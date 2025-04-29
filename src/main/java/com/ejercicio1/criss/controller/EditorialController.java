package com.ejercicio1.criss.controller;

import com.ejercicio1.criss.model.Editorial;
import com.ejercicio1.criss.service.EditorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {

    private final EditorialService editorialService;

    public EditorialController(EditorialService editorialService) {
        this.editorialService = editorialService;
    }

    @GetMapping
    public ResponseEntity<List<Editorial>> getAllEditoriales() {
        return ResponseEntity.ok(editorialService.getAllEditoriales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editorial> getEditorialById(@PathVariable Integer id) {
        return ResponseEntity.ok(editorialService.getEditorialById(id));
    }

    @PostMapping
    public ResponseEntity<Editorial> createEditorial(@RequestBody Editorial editorial) {
        return ResponseEntity.ok(editorialService.createEditorial(editorial));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editorial> updateEditorial(@PathVariable Integer id, @RequestBody Editorial editorial) {
        return ResponseEntity.ok(editorialService.updateEditorial(id, editorial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEditorial(@PathVariable Integer id) {
        editorialService.deleteEditorial(id);
        return ResponseEntity.noContent().build();
    }
}

