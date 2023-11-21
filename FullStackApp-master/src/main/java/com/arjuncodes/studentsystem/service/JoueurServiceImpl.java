package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.Joueur;
import com.arjuncodes.studentsystem.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurServiceImpl implements JoueurService {

    @Autowired
    private  JoueurRepository studentRepository;


    @Override
    public Joueur saveStudent(Joueur student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Joueur> getAllStudents() {
        return studentRepository.findAll();
    }



 

 
}
