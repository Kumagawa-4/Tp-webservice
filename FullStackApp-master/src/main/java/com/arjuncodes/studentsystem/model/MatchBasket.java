package com.arjuncodes.studentsystem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MatchBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String adversaire;
    private int scoreEquipe;
    private int scoreAdversaire;

    @ManyToOne
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;

    public MatchBasket() {
        // Constructeur par défaut requis par JPA
    }

    public MatchBasket(Date date, String adversaire, int scoreEquipe, int scoreAdversaire) {
        this.date = date;
        this.adversaire = adversaire;
        this.scoreEquipe = scoreEquipe;
        this.scoreAdversaire = scoreAdversaire;
    }

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAdversaire() {
        return adversaire;
    }

    public void setAdversaire(String adversaire) {
        this.adversaire = adversaire;
    }

    public int getScoreEquipe() {
        return scoreEquipe;
    }

    public void setScoreEquipe(int scoreEquipe) {
        this.scoreEquipe = scoreEquipe;
    }

    public int getScoreAdversaire() {
        return scoreAdversaire;
    }

    public void setScoreAdversaire(int scoreAdversaire) {
        this.scoreAdversaire = scoreAdversaire;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
}