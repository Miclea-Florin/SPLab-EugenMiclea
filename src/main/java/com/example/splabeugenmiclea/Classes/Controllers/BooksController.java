package com.example.splabeugenmiclea.Classes.Controllers;

import com.example.splabeugenmiclea.Classes.Repository.authorRepository;
import com.example.splabeugenmiclea.Classes.models.Author;
import com.example.splabeugenmiclea.Classes.models.Book;
import com.example.splabeugenmiclea.Classes.models.Section;
import com.example.splabeugenmiclea.Classes.models.allBooksSubject;
import com.example.splabeugenmiclea.Classes.service.Element;
import com.example.splabeugenmiclea.Classes.service.implementation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
public class BooksController {


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
    public BooksController(com.example.splabeugenmiclea.Classes.Repository.sectionRepository sectionRepository, com.example.splabeugenmiclea.Classes.Repository.authorRepository authorRepository, CommandAddBook addBook, CommandDeleteBook deleteBook, CommandUpdateBook updateBook, CommandGetBooks getAllBooks, CommandGetBookByID getBookByID, com.example.splabeugenmiclea.Classes.models.allBooksSubject allBooksSubject) {
        this.sectionRepository = sectionRepository;
        this.authorRepository = authorRepository;
        this.addBook = addBook;
        this.deleteBook = deleteBook;
        this.updateBook = updateBook;
        this.getAllBooks = getAllBooks;
        this.getBookByID = getBookByID;
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return getAllBooks.execute();
    }

    @PostMapping("/books")
    public CompletableFuture<Book> createBook(@RequestBody Book book) throws IOException {
       // book.setTitle("gica");
        List<Author> authors = book.getAuthors(); // Assuming you have a method to get the Author from the Book entity
        for (Author e : authors)
            authorRepository.save(e);
        for(Element e: book.getSections())
            sectionRepository.save((Section) e);

        addBook.setBook(book);
        allBooksSubject.add(book);

        return addBook.execute();
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
