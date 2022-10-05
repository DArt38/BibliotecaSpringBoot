package com.misiontic.usergioarboleda.Biblioteca.models;

import java.io.Serializable;
import javax.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "author")
public class Author implements Serializable {

    //Atributos
    @Id
    private Integer code;
    private String name;
    private String lastname;


    /**
     *
     * @param code
     * @param name
     * @param lastname
     */
    public Author(Integer code,String name,String lastname){
        this.code = code;
        this.name = name;
        this.lastname = lastname;

    }
}
