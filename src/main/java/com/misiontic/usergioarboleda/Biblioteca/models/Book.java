package com.misiontic.usergioarboleda.Biblioteca.models;

import java.io.Serializable;
import javax.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.relational.core.mapping.Table;

@Entity
@Table(name="book")
public class Book implements Serializable {
    //Atributos
    @Id
    private Integer isbn;
    private String title;
    private String register_date;
    private Integer year;
    private Editorial editorial_fk;


    /**
     *
     * @param isbn
     * @param title
     * @param register_date
     * @param year
     * @param editorial_fk
     */
    public Book(Integer isbn,String title,String register_date,Integer year,Editorial editorial_fk){
        this.isbn = isbn;
        this.title = title;
        this.register_date = register_date;
        this.year = year;
        this.editorial_fk = editorial_fk;

    }
}
