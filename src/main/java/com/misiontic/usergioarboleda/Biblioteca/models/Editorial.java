package com.misiontic.usergioarboleda.Biblioteca.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import org.springframework.data.annotation.Id;
import org.springframework.relational.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name = "editorial")
public class Editorial implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String country;

    @OneToMany(cascade={CascadeType.PERSIST},mappedBy = "editorial_fk")
    @JsonIgnoreProperties("editorial_fk")
    private List<Book> books;


    /**
     *
     * @param id
     * @param name
     * @param country
     */
    public Editorial(Integer id,String name,String country){
        this.id = id;
        this.name = name;
        this.country = country;

    }


    /// Getters and Setters
    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
