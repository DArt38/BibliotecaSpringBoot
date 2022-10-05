package com.misiontic.usergioarboleda.Biblioteca.repositories;

import com.misiontic.usergioarboleda.Biblioteca.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    @Autowired
    private BookCRUDRepository bookCRUDRepository;

    public List<Book> getAll(){
        return(List<Book>) bookCRUDRepository.findAll();
    }

    public List<Book> getBooksByDates(String start,String end){
        return bookCRUDRepository.findBooksByDates(start,end);
    }

    public Optional<Book> getBook(int isbn){
        return bookCRUDRepository.findById(isbn);
    }

    public Book save(Book book){
        return bookCRUDRepository.save(book);
    }

    public void delete(Book book){
        bookCRUDRepository.delete(book);

    }
}
