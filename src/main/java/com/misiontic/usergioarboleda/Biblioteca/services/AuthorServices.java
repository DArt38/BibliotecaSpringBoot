package com.misiontic.usergioarboleda.Biblioteca.services;

import com.misiontic.usergioarboleda.Biblioteca.models.Author;
import com.misiontic.usergioarboleda.Biblioteca.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServices {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAll(){
        return authorRepository.getAll();
    }

    public Optional<Author> getAuthor(int code){
        return authorRepository.getAuthor(code);
    }

    public Author insertAuthor(Author author){
        if(author.getCode() != null){
                Optional<Author> temp = authorRepository.getAuthor(author.getCode());
                if(temp.isEmpty()) {
                    if (author.getName() != null && author.getLastname() != null)
                        return authorRepository.save(author);
                    else
                        return author;
                }
                else
                    return author;
        }
        else
            return author;
    }

    public Author updateAuthor(Author author){
        if(author.getCode() != null){
            Optional<Author> temp = authorRepository.getAuthor(author.getCode());
            if(!temp.isEmpty()){
                if(author.getName() != null)
                    temp.get().setName(author.getName());

                if(author.getLastname() != null)
                    temp.get().setLastname(author.getLastname());

                return authorRepository.save(temp.get());
            }
            else
                return author;
        }
        else
            return author;
    }

    public Boolean delete(int code){
        Boolean success = authorRepository.getAuthor(code).map(author -> {
                    authorRepository.delete(author);
                    return true;
             }).orElse(false);
        return  success;
    }
}
