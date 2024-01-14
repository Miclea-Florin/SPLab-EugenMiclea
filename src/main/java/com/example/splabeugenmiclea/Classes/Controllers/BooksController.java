package com.example.splabeugenmiclea.Classes.Controllers;

import com.example.splabeugenmiclea.Classes.Repository.authorRepository;
import com.example.splabeugenmiclea.Classes.models.Author;
import com.example.splabeugenmiclea.Classes.models.Book;
import com.example.splabeugenmiclea.Classes.models.Section;
import com.example.splabeugenmiclea.Classes.models.allBooksSubject;
import com.example.splabeugenmiclea.Classes.service.CommandExecutor;
import com.example.splabeugenmiclea.Classes.service.Element;
import com.example.splabeugenmiclea.Classes.service.implementation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

@RestController
public class BooksController {
    private Book b1;
    private final BookService bookService;
    List<Request<?>> requests;
    CommandExecutor asyncCommandExecutor;
    ExecutorService executorService;
    private List<Book> books = new ArrayList<>();
    private final com.example.splabeugenmiclea.Classes.Repository.sectionRepository sectionRepository;
    private final authorRepository authorRepository;
    private final CommandAddBook addBook;
    private final CommandDeleteBook deleteBook;
    private final CommandUpdateBook updateBook;
    private final CommandGetBooks getAllBooks;
    private final CommandGetBookByID getBookByID;

    private final allBooksSubject allBooksSubject;
    @Autowired
    public BooksController(BookService bookService, com.example.splabeugenmiclea.Classes.Repository.sectionRepository sectionRepository, com.example.splabeugenmiclea.Classes.Repository.authorRepository authorRepository, CommandAddBook addBook, CommandDeleteBook deleteBook, CommandUpdateBook updateBook, CommandGetBooks getAllBooks, CommandGetBookByID getBookByID, com.example.splabeugenmiclea.Classes.models.allBooksSubject allBooksSubject) {
        this.bookService = bookService;
        this.sectionRepository = sectionRepository;
        this.authorRepository = authorRepository;
        this.addBook = addBook;
        this.deleteBook = deleteBook;
        this.updateBook = updateBook;
        this.getAllBooks = getAllBooks;
        this.getBookByID = getBookByID;
        this.requests = new ArrayList<>();
        this.allBooksSubject = allBooksSubject;
        this.asyncCommandExecutor = new AsynchronousExecutor();
        this.executorService = Executors.newFixedThreadPool(10);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

        scheduler.scheduleAtFixedRate(this::processRequests,3,10, TimeUnit.SECONDS);

    }

    public void processRequests() {
       // System.out.println("Processing requests");

        for (Request request : requests) {
            if (!request.isCompleted()) {
                executorService.submit(() -> {
                    System.out.println("Executing request " + request.getId());

                    request.setCompleted(true);

                    System.out.println("Request " + request.getId() + " completed");
                });
            }
        }
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return getAllBooks.execute();
    }


    @PostMapping("/books")
    public ResponseEntity<?> createBook(@RequestBody Book book) throws IOException {
      // book.setTitle("gica");
        b1= book;


        List<Author> authors = book.getAuthors();
        for (Author e : authors)
            authorRepository.save(e);
        for(Element e: book.getSections())
            sectionRepository.save((Section) e);
        allBooksSubject.add(book);

        addBook.setBook(book);


 addBook.setBook(book);
        Request request = asyncCommandExecutor.executeCommand(addBook,bookService);
        request.setId(requests.size());
        requests.add(request);



        addBook.execute();

        return new ResponseEntity<>(requests.size()-1, HttpStatus.ACCEPTED);
        //return addBook.execute();
    }


    @GetMapping("books/{id}")
    public Optional<Book> getBookById(@PathVariable Integer id) {
        getBookByID.setID(id);
        return getBookByID.execute();
    }


        @PutMapping("/books/{id}")
        public Book updateBook(@PathVariable Integer id, @RequestBody Book updatedBook) {
            updateBook.setBook(id,updatedBook);
            return updateBook.execute();
        }

        @DeleteMapping("/books/{id}")
        public void deleteBook(@PathVariable Integer id) {
            deleteBook.setId(id);
            deleteBook.execute();
        }

        /* lab 12 */
    /*
        @PostMapping
        public String newBook(@RequestBody NewBookRequest newBookRequest) throws IOException {
            Book book = createBook(newBookRequest);
            book = booksRepository.save(book);
            allBooksSubject.add(book);
            return "Book saved [" + book.getId() + "] " + book.getTitle();
        }
    */

}
