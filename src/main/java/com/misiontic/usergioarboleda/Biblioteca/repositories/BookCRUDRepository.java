package com.misiontic.usergioarboleda.Biblioteca.repositories;

import com.misiontic.usergioarboleda.Biblioteca.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookCRUDRepository extends CrudRepository<Book,Integer>{


    @Query(values="SELECT * FROM book WHERE year>=? AND year<=?", nativeQuery = true)
    public List<Book> findBooksByDates(String startYear,String endYear);
}
