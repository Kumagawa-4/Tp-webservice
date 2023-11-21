package com.arjuncodes.studentsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.arjuncodes.studentsystem.model.Equipe;
import com.arjuncodes.studentsystem.repository.EquipeRepository;



import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/equipes")
public class EquipeController {

    private final EquipeRepository equipeRepository;

    public EquipeController(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    @GetMapping
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable("id") Long id) {
        java.util.Optional<Equipe> equipeOptional = equipeRepository.findById(id);
        return equipeOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Equipe createEquipe(@RequestBody Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipe> updateEquipe(@PathVariable("id") Long id, @RequestBody Equipe equipe) {
        java.util.Optional<Equipe> equipeOptional = equipeRepository.findById(id);
        if (equipeOptional.isPresent()) {
            equipe.setId(id);
            Equipe updatedEquipe = equipeRepository.save(equipe);
            return ResponseEntity.ok(updatedEquipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable("id") Long id) {
        java.util.Optional<Equipe> equipeOptional = equipeRepository.findById(id);
        if (equipeOptional.isPresent()) {
            equipeRepository.delete(equipeOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}