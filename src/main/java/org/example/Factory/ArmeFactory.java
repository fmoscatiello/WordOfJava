package org.example.Factory;

import org.example.Abstract.Arme;
import org.example.Model.Epee;
import org.example.Model.Gourdin;

import java.util.Random;

public class ArmeFactory {

    static String [] nomEpee = {"Excalibur","Zanpakuto","Berserker","Claymore","Katana","Durandall","Needle"};
    static String [] nomGourdin = {"Batte mobile","Big Bang impact","Truandeur","KasseTete"};
    static Integer [] degatInfliges =  {5,8,10,3,6,2,4,9};
    static Integer [] longueur = {70,210,105,120,81,96};
    static Integer[] poids = {210,550,750,2000,325};

    /**
     * Method epour générer une arme aleatoirement
     * Cela peut être une épée ou un gourdin
     * les degats, la taille et le poids sont aussi aléatoire
     * @return {Arme} , l'arme générée
     */
    public static Arme buildArme(){
       Arme arme;
       boolean epOuGourdin = new Random().nextBoolean();
        if(epOuGourdin){
            arme = new Epee();
            arme.setNomArme(nomEpee[(int)Math.floor(Math.random()*nomEpee.length)]);
        }
       else{
            arme = new Gourdin();
            arme.setNomArme(nomGourdin[(int)Math.floor(Math.random()*nomGourdin.length)]);
        }
       arme.setDegatsParAttaque(degatInfliges[(int)Math.floor(Math.random()*degatInfliges.length)]);
       arme.setLongueur(longueur[(int)Math.floor(Math.random()*longueur.length)]);
       arme.setPoids(poids[(int)Math.floor(Math.random()*poids.length)]);
        return arme;
    };





}
