package com.ejercicio1.criss.service;

import com.ejercicio1.criss.model.Editorial;
import com.ejercicio1.criss.repository.EditorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialService {

    private final EditorialRepository editorialRepository;

    public EditorialService(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    public List<Editorial> getAllEditoriales() {
        return editorialRepository.findAll();
    }

    public Editorial getEditorialById(Integer id) {
        return editorialRepository.findById(id).orElse(null);
    }

    public Editorial createEditorial(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    public Editorial updateEditorial(Integer id, Editorial editorial) {
        Optional<Editorial> editorialExistente = editorialRepository.findById(id);
        if (editorialExistente.isPresent()) {
            editorial.setId(id);
            return editorialRepository.save(editorial);
        } else {
            return null;
        }
    }

    public void deleteEditorial(Integer id) {
        editorialRepository.deleteById(id);
    }
}

