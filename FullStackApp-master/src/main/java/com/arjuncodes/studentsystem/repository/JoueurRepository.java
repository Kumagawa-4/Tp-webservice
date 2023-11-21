package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur,Long> {
}
