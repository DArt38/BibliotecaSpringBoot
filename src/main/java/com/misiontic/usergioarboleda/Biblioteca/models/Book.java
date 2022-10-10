package com.misiontic.usergioarboleda.Biblioteca.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="book")
public class Book implements Serializable {
    //Atributos
    @Id
    private Integer isbn;
    private String title;
    private String register_date;
    private Integer year;

    @ManyToOne
    @JoinColumn(name= "id") //vincule las columnas
    @JsonIgnoreProperties("books")
    private Editorial editorial_fk;


    @ManytoMany
    @JoinTable(
            name ="book_author",
            joinColumns = @JoinColumn(name = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "code")
    )
    private Set<Author> authors;


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

    /**
     *
     * @param isbn
     * @param title
     * @param register_date
     * @param year
     * @param editorial_fk
     * @param authors
     */
    public Book(Integer isbn,String title,String register_date,Integer year,Editorial editorial_fk,Set<Author> authors){
        this.isbn = isbn;
        this.title = title;
        this.register_date = register_date;
        this.year = year;
        this.editorial_fk = editorial_fk;
        this.authors = authors;

    }


    // Getters and Setters

    public Integer getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Editorial getEditorial_fk() {
        return editorial_fk;
    }

    public void setEditorial_fk(Editorial editorial_fk) {
        this.editorial_fk = editorial_fk;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
