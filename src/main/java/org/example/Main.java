package org.example;
import org.example.Abstract.Personnage;
import org.example.Actions.Combattre;
import org.example.Battlefield.Battlefield;
import org.example.Factory.PersonnageFactory;
import org.example.Model.Equipe;

public class Main {
    public static void main(String[] args) {
       try {
            Battlefield.commencerLeCombat();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       /*Personnage monstre = PersonnageFactory.genererMonstre();
        Personnage heros = PersonnageFactory.genererHeros();
        try {
            Combattre.combattez1vs1(heros,monstre);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }
}