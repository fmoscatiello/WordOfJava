package org.example.Model;

import org.example.Abstract.Arme;
import org.example.Abstract.Personnage;

public class Heros extends Personnage {

    public Heros(){};

    public Heros(int pointDeVie, String nom, Arme arme){
        super(pointDeVie,nom,arme);
    }

}
