package com.example.splabeugenmiclea.Classes.Controllers;

import com.example.splabeugenmiclea.Classes.models.Book;
import com.example.splabeugenmiclea.Classes.service.implementation.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {

    private List<Book> books = new ArrayList<>();
    private final CommandAddBook addBook;
    private final CommandDeleteBook deleteBook;
    private final CommandUpdateBook updateBook;
    private final CommandGetBooks getAllBooks;
    private final CommandGetBookByID getBookByID;

    public BooksController(CommandAddBook addBook, CommandDeleteBook deleteBook, CommandUpdateBook updateBook, CommandGetBooks getAllBooks, CommandGetBookByID getBookByID) {
        this.addBook = addBook;
        this.deleteBook = deleteBook;
        this.updateBook = updateBook;
        this.getAllBooks = getAllBooks;
        this.getBookByID = getBookByID;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return getAllBooks.execute();
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
       // book.setTitle("gica");
        addBook.setBook(book);
        return addBook.execute();
    }


    @GetMapping("books/{id}")
    public Book getBookById(@PathVariable Long id) {
        getBookByID.setID(id);
        return getBookByID.execute();
    }


        @PutMapping("/books/{id}")
        public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
            updateBook.setBook(id,updatedBook);
            return updateBook.execute();
        }

        @DeleteMapping("/book/{id}")
        public void deleteBook(@PathVariable Long id) {
            deleteBook.setId(id);
            deleteBook.execute();
        }

}
