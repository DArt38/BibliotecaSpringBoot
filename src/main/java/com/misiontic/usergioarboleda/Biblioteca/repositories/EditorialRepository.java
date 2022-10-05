package com.misiontic.usergioarboleda.Biblioteca.repositories;


import com.misiontic.usergioarboleda.Biblioteca.models.Editorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EditorialRepository {

    @Autowired
    private EditorialCRUDRepository editorialCRUDRepository;


    public List<Editorial> getAll(){
        return (List<Editorial>) editorialCRUDRepository.findAll();
    }

    public Optional<Editorial> getEditorial(int id){
        return editorialCRUDRepository.findById(id);
    }

    public Editorial save(Editorial editorial){
        return editorialCRUDRepository.save(editorial);
    }

    public void delete (Editorial editorial){
        editorialCRUDRepository.delete(editorial);
    }
}
