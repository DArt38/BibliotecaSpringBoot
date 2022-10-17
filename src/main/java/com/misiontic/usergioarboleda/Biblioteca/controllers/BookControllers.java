package com.misiontic.usergioarboleda.Biblioteca.controllers;

import com.misiontic.usergioarboleda.Biblioteca.models.Book;
import com.misiontic.usergioarboleda.Biblioteca.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookControllers {
    @Autowired
    private BookServices bookServices;

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookServices.getAllBook();
    }

    @GetMapping("/years/{start}/{end}")
    public List<Book> getAllBooksByDates(@PathVariable("start") int start, @PathVariable("end") int end){
        return bookServices.getBookByDates(start, end);
    }

    @GetMapping("/{isbn}")
    public Optional<Book> getBook(@PathVariable("isbn") int isbn){
        return bookServices.getBook(isbn);
    }

    @PostMapping("/insert")
    public Book insertBook(@RequestBody Book book){
        return bookServices.insertBook(book);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book){
        return bookServices.updateBook(book);
    }

    @DeleteMapping("/delete/{isbn}")
    public Boolean deleteBook(@PathVariable("isbn") int isbn){
        return bookServices.deleteBook(isbn);
    }
}
