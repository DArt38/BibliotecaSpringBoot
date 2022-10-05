package com.misiontic.usergioarboleda.Biblioteca.repositories;

import com.misiontic.usergioarboleda.Biblioteca.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {

    @Autowired
    private AuthorCRUDRepository authorCRUDRepository;

    public List<Author> getAll(){
        return (List<Author>) authorCRUDRepository.findAll();
    }

    public Optional<Author> getAuthor(int code){
        return authorCRUDRepository.findById(code);
    }

    public Author save(Author author){
        return authorCRUDRepository.save(author);
    }

    public void delete(Author author){
        authorCRUDRepository.delete(author);
    }
}
