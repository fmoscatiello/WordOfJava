package org.example.Factory;
import org.example.Model.Heros;
import org.example.Model.Monstre;


public class PersonnageFactory {

     static String[] nomPersonnageMonstre = {"Gobelin","Orochimaru","Troll des Montagnes",
    "Sauron","Saruman","Voldemort","Smaug"};
     static String[] nomPersonnageHeros = {"Harry Potter","Legolas","Boba Fett","King Arthur",
    "Lancelot du Lac","KillerBee","Pikachu"};

     static int[] pointDeVie = {60,75,55,64,57,68};

    public static Heros genererHeros(){
       Heros heros = new Heros();
        heros.setNom(nomPersonnageHeros[(int)Math.floor(Math.random()*nomPersonnageHeros.length)]);
        heros.setPointDeVie(pointDeVie[(int) Math.floor(Math.random()*pointDeVie.length)]);
        heros.setArme(ArmeFactory.buildArme());
        return heros;
    }
    public static Monstre genererMonstre(){
        Monstre monstre = new Monstre();
        monstre.setNom(nomPersonnageMonstre[(int)Math.floor(Math.random()*nomPersonnageMonstre.length)]);
        monstre.setPointDeVie(pointDeVie[(int) Math.floor(Math.random()*pointDeVie.length)]);
        monstre.setArme(ArmeFactory.buildArme());
        return monstre;
    }

}
