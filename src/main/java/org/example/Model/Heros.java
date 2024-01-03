package org.example.Model;

import org.example.Abstract.Arme;
import org.example.Abstract.Personnage;

public class Heros extends Personnage {

    public Heros(){};

    public Heros(int pointDeVie, String nom, Arme arme){
        super(pointDeVie,nom,arme);
    }


    /**
     * methode pour attaquer l'adversaire
     *
     * @return le niveau de l'attaque envoyé par le personnage en integer
     */
    @Override
    public int attaquer() {
        return 0;
    }

    /**
     * methode pour soustraire des points de vies suite à une attaque subie
     *
     * @return les dégats subits
     */

}
