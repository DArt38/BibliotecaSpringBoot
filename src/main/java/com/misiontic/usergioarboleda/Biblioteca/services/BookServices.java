package com.misiontic.usergioarboleda.Biblioteca.services;

import com.misiontic.usergioarboleda.Biblioteca.models.Book;
import com.misiontic.usergioarboleda.Biblioteca.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBook(){
        return bookRepository.getAll();
    }

    public List<Book> getBookByDates(int start,int end){
        return bookRepository.getBooksByDates(start, end);
    }

    public Optional<Book> getBook(int isbn){
        return bookRepository.getBook(isbn);
    }

    public  Book insertBook(Book book){
        if(book.getIsbn() != null){
            Optional<Book> temp = bookRepository.getBook( book.getIsbn() );
            if( temp.isEmpty() )
                if(book.getTitle() != null && book.getRegister_date() != null && book.getEditorial_fk() != null)
                    return bookRepository.save(book);
                else
                    return book;
            else
                return book;
        }
        else
            return book;
    }

    public Book updateBook(Book book){
        if(book.getIsbn() != null){
            Optional<Book> temp = bookRepository.getBook( book.getIsbn() );
            if( !temp.isEmpty() ){
                if(book.getYear() != null)
                    temp.get().setYear( book.getYear() );
                if(book.getAuthors() != null)
                    temp.get().setAuthors( book.getAuthors() );
                return bookRepository.save( temp.get() );
            }
            else
                return book;
        }
        else
            return book;
    }

    public Boolean deleteBook(int isbn){
        Boolean success = bookRepository.getBook(isbn).map(book -> {
            bookRepository.delete(book);
            return true;
        }).orElse(false);
        return success;

    }

}
