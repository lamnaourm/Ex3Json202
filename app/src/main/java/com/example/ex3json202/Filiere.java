package com.example.ex3json202;

import java.io.Serializable;

public class Filiere implements Serializable {

    private String code;
    private String description;
    private String niveau;
    private int nbModule;

    public Filiere() {
    }

    public Filiere(String code, String description, String niveau, int nbModule) {
        this.code = code;
        this.description = description;
        this.niveau = niveau;
        this.nbModule = nbModule;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getNbModule() {
        return nbModule;
    }

    public void setNbModule(int nbModule) {
        this.nbModule = nbModule;
    }
}
