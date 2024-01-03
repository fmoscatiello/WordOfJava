package org.example.Battlefield;

import org.example.Abstract.Personnage;
import org.example.Actions.Combattre;
import org.example.Factory.PersonnageFactory;
import org.example.Model.Equipe;

import java.util.ArrayList;
import java.util.List;

public class Battlefield {

    /**
     * Methode pour génerer aléatoirement des Héros.
     * @param nbrHeros , le nombre de Héros qu'il y aura dans l'équipe
     * @return teamHeros, la team de Heros créée
     */
    public static Equipe genererTeamHeros(int nbrHeros){
        Equipe teamHeros = new Equipe();
        List<Personnage> perso = new ArrayList<>();
        for (int i = 0; i < nbrHeros; i++) {
            perso.add(PersonnageFactory.genererHeros());
        }
        teamHeros.setTeam(perso);
        return teamHeros;
    }

    /**
     * Methode pour génerer aléatoirement des Monstres.
     * @param nbrMonstre , le nombre de Monstres qu'il y aura dans l'équipe
     * @return teamMonstre, la team de monstres créée
     */
    public static Equipe genererTeamMonstre(int nbrMonstre){
        Equipe teamMonstre = new Equipe();
        List<Personnage> perso = new ArrayList<>();
        for (int i = 0; i < nbrMonstre; i++) {
            perso.add(PersonnageFactory.genererMonstre());
        }
        teamMonstre.setTeam(perso);
        return teamMonstre;
    }

    public static void commencerLeCombat() throws InterruptedException {
        Equipe teamHeros = genererTeamHeros(4);
        Equipe teamMonstre = genererTeamMonstre(2);
        Combattre.combatDeGroupe(teamHeros,teamMonstre);
    }



}
