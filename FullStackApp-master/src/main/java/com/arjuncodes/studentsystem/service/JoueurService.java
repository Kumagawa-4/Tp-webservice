package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Joueur;

import java.util.List;

public interface JoueurService {
    public Joueur saveStudent(Joueur student);
    public List<Joueur> getAllStudents();
    
}
