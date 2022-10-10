package com.misiontic.usergioarboleda.Biblioteca.services;

import com.misiontic.usergioarboleda.Biblioteca.models.Editorial;
import com.misiontic.usergioarboleda.Biblioteca.repositories.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EditorialServices {
    @Autowired
    private EditorialRepository editorialRepository;

    public List<Editorial> getAllEditorial(){
        return editorialRepository.getAll();
    }

    public Optional<Editorial> getEditorial(int id){
        return  editorialRepository.getEditorial(id);
    }

    public Editorial insertEditorial(Editorial editorial){
        if(editorial.getId() == null)
            if(editorial.getName() != null)
                return editorialRepository.save(editorial);
            else
                return editorial;
        else
            return editorial;
    }

    public Editorial updateEditorial(Editorial editorial){
        if(editorial.getId() != null){
            Optional<Editorial> temp = editorialRepository.getEditorial(editorial.getId());
            if(!temp.isEmpty() ){
                if(editorial.getName() != null)
                    temp.get().setName(editorial.getName());
                if(editorial.getCountry() != null)
                    temp.get().setCountry(editorial.getCountry());
                return editorialRepository.save(temp.get());
            }
            else
                return editorial;
        }
        else
            return editorial;
    }

    public Boolean deleteEditorial(int id){
        Boolean success = editorialRepository.getEditorial(id).map(editorial -> {
            editorialRepository.delete(editorial);
            return true;
                }).orElse(false);
        return success;
    }




}
