package com.esprit.tn.livraisonmicro;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Livraison implements Serializable {
    private static final long serialVersionUID = 6;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  int id;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private LocalDate dateLivraison;
    private String statut;

    private String telephone;

    private Double fraisLivraison;
    private Double longitude;
    private Double latitude;

    public Livraison() {
    }

    public Livraison(int id, LocalDate dateLivraison, String statut, String telephone, Double fraisLivraison, Double longitude, Double latitude) {
        this.id = id;
        this.dateLivraison = dateLivraison;
        this.statut = statut;
        this.telephone = telephone;
        this.fraisLivraison = fraisLivraison;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }



    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public String getStatut() {
        return statut;
    }

    public String getTelephone() {
        return telephone;
    }

    public Double getFraisLivraison() {
        return fraisLivraison;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setFraisLivraison(Double fraisLivraison) {
        this.fraisLivraison = fraisLivraison;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }


}
