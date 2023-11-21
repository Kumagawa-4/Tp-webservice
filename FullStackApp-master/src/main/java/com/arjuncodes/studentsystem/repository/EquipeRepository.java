package com.arjuncodes.studentsystem.repository;

import com.arjuncodes.studentsystem.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

    // Méthodes supplémentaires pour les opérations spécifiques aux équipes

}