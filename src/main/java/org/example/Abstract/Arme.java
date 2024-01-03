package org.example.Abstract;

import java.util.StringJoiner;

/**
 * Classe Abstraite Arme contenant le nom, les degats qu'infligent l'arme
 * la longueur de l'arme en cm, et le poids de cette dernière
 */
public abstract class Arme {
    String nomArme;
    int degatsParAttaque;
    int longueur;
    int poids;

    public Arme(){

    }

    public Arme(String nomArme, int degatsParAttaque, int longueur, int poids) {
        this.nomArme = nomArme;
        this.degatsParAttaque = degatsParAttaque;
        this.longueur = longueur;
        this.poids = poids;
    }

    public String getNomArme() {
        return nomArme;
    }

    public void setNomArme(String nomArme) {
        this.nomArme = nomArme;
    }

    public int getDegatsParAttaque() {
        return degatsParAttaque;
    }

    public void setDegatsParAttaque(int degatsParAttaque) {
        this.degatsParAttaque = degatsParAttaque;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Arme.class.getSimpleName() + "[", "]")
                .add("nomArme='" + nomArme + "'")
                .add("degatsParAttaque=" + degatsParAttaque)
                .add("longueur=" + longueur)
                .add("poids=" + poids)
                .toString();
    }
}
