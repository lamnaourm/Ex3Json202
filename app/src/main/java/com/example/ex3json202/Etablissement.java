package com.example.ex3json202;

import java.io.Serializable;
import java.util.ArrayList;

public class Etablissement implements Serializable {

    private String nom;
    private String adresse;
    private String specialite;
    private ArrayList<Filiere> filieres=new ArrayList<>();

    public Etablissement() {
    }

    public Etablissement(String nom, String adresse, String specialite) {
        this.nom = nom;
        this.adresse = adresse;
        this.specialite = specialite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public ArrayList<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(ArrayList<Filiere> filieres) {
        this.filieres = filieres;
    }
}
