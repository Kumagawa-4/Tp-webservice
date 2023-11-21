package com.arjuncodes.studentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.arjuncodes.studentsystem.model.Joueur;
import com.arjuncodes.studentsystem.repository.JoueurRepository;

import javassist.NotFoundException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/joueurs")
public class JoueurController {
    @Autowired
    private JoueurRepository joueurRepository;

    @GetMapping
    public ResponseEntity<List<Joueur>> getAllJoueurs() {
        List<Joueur> joueurs = joueurRepository.findAll();
        return new ResponseEntity<>(joueurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable("id") long id) throws NotFoundException {
        Joueur joueur = joueurRepository.findById( id)
                .orElseThrow(() -> new NotFoundException("Joueur non trouvé avec l'ID : " + id));
        return new ResponseEntity<>(joueur, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Joueur> createJoueur(@RequestBody Joueur joueur) {
        Joueur nouveauJoueur = joueurRepository.save(joueur);
        return new ResponseEntity<>(nouveauJoueur, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Joueur> updateJoueur(@PathVariable("id") long id, @RequestBody Joueur joueurDetails) throws NotFoundException{
        Joueur joueur = joueurRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Joueur non trouvé avec l'ID : " + id));

        joueur.setName(joueurDetails.getName());
        joueur.setEquipe(joueurDetails.getEquipe());
        joueur.setTaille(joueurDetails.getTaille());
        joueur.setPoids(joueurDetails.getPoids());
        joueur.setPoste(joueurDetails.getPoste());

        Joueur joueurMiseAJour = joueurRepository.save(joueur);
        return new ResponseEntity<>(joueurMiseAJour, HttpStatus.OK);
    }
  


}
