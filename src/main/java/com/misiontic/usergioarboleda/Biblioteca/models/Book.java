package com.misiontic.usergioarboleda.Biblioteca.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

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
    @JoinColumn(name="id")
    @JsonIgnoreProperties("books")
    private Editorial editorial_fk;

    @ManyToMany
    @JoinTable(
            name ="book_author",
            joinColumns = @JoinColumn(name = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "code")
    )
    private Set<Author> authors;


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
