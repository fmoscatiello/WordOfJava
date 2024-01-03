package org.example.Abstract;

import java.util.StringJoiner;

public abstract class Personnage {
    /**
     * Classe abstraite personnage comprenant des points de vies, un nom, une arme
     * et les méthodes d'attaque et de dégats reçus.
     */

    int pointDeVie;
    String nom;

    Arme arme;

    public Personnage() {

    }

    public Personnage(int pointDeVie, String nom, Arme arme) {
        this.pointDeVie = pointDeVie;
        this.nom = nom;
        this.arme = arme;
    }

    public int getPointDeVie() {
        return this.pointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Arme getArme() {
        return this.arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    /**
     * methode pour attaquer l'adversaire
     * @return le nombre de point que l'arme inflige
     */
   /* public int attaquer(){
        System.out.println(this.getNom() + " attaque ");
        return this.getArme().getDegatsParAttaque();
    };*/

    /**
     * methode pour soustraire des points de vies suite à une attaque subie
     * @return les dégats subits
     */
public void recevoirDesDegats(Personnage attaquant){
    System.out.println(attaquant.getNom() + "("+attaquant.getPointDeVie()+ ") attaque ");
    this.setPointDeVie(this.getPointDeVie()-attaquant.getArme().getDegatsParAttaque());
    System.out.println("il reste " + this.getPointDeVie() + " points de vie pour " + this.getNom());
}

    @Override
    public String toString() {
        return new StringJoiner(", ", Personnage.class.getSimpleName() + "[", "]")
                .add("pointDeVie=" + pointDeVie)
                .add("nom='" + nom + "'")
                .add("arme=" + arme)
                .toString();
    }
}
