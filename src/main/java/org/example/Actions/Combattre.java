package org.example.Actions;
import org.example.Abstract.Personnage;
import org.example.Model.Equipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;


public class Combattre {

    /**
     * Methode pour faire combattre un héros contre un monstre
     * le combat s'affiche en console jusqu'à ce que l'un des deux
     * aient des points inférieur ou égal à 0
     *
     * @throws InterruptedException
     */
    public static void combattez1vs1(Personnage heros, Personnage monstre) throws InterruptedException {
        boolean rand; // ce booléan genererera plus tard soit true, soit false
        //afin de savoir qui du héros ou du monstre attaquera le premier à chaque tour
        while (heros.getPointDeVie()>0 && monstre.getPointDeVie()>0) {
            System.out.println("------------------------");
            rand = new Random().nextBoolean();
            if (rand) {
                attaqueDuPremierPerso(heros,monstre);
                sleep(100);
            }else{
                attaqueDuPremierPerso(monstre,heros);
                sleep(100);
            }
        }
        //on determine le nom du perdant pour l'afficher en console
        String vaincu = heros.getPointDeVie()<=0? heros.getNom(): monstre.getNom();
        System.out.println(vaincu + " est mort!");
    }

    /**
     * Methode permettant de faire attaquer le personnage 1 en premier et de
     * Faire repliquer le second personnage si ses PV > 0
     * @param perso1 premier personnage à attaquer
     * @param perso2 second personnage à attaquer
     */
    private static void attaqueDuPremierPerso(Personnage perso1, Personnage perso2){
        if (perso1.getPointDeVie() > 0) {
            perso2.recevoirDesDegats(perso1);
        }
        if (perso2.getPointDeVie() > 0) {
            perso1.recevoirDesDegats(perso2);
        }
    }

    /**
     * Methode pour mettre à jour les équipes
     * passer le gagnant en fin de equipeGagnante et supprimer le perdant de equipePerdante
     * Attention!! l'ordre est important!
     * L'Equipe dans laquelle se situe le vainqueur doit TOUJOURS etre en premiers!
     * @param equipeGagnante l'équipe Gagnante
     * @param equipePerdante l'équipe Perdante
     * @return looser{Personnage} . Ceci afin de pouvoir l'ajouter au cimetière.
     */
    public static Personnage miseAjourEquipes(Equipe equipeGagnante, Equipe equipePerdante){
        //on va chercher le Perdant en debut de Liste
        Personnage looser = equipePerdante.getTeam().get(0);
        //On le retire de l'Equipe
        equipePerdante.getTeam().remove(looser);
        //On va chercher le gagnant
        Personnage winner = equipeGagnante.getTeam().get(0);
        //On met le gagnant en fin de liste pour qu'il recombatte après
        equipeGagnante.getTeam().remove(equipeGagnante.getTeam().get(0));
        equipeGagnante.getTeam().add(winner);
        return looser;
    }

    /**
     * Methode qui fait combattre les deux équipes entre-elles et qui retourne le cimetière
     * @param equipe1
     * @param equipe2
     * @return cimetiere{Equipe}, la liste des morts après le combat
     * @throws InterruptedException
     */
    private static Equipe combatDEquipe(Equipe equipe1, Equipe equipe2) throws InterruptedException {
        //Personnage perdant qui sera stocké temporairement avant d'ajouter dans le cimetière
        Personnage looser;
        //Personnage gagnant qui sera mis à la fin de l'équipe après sa victoire afin qu'il ne
        //combatte pas de suite le prochain adversaire
        Personnage winner;
        //Création du cimetière qui est une liste de Personnage, et donc une équipe
        Equipe cimetiere = new Equipe();
        while (!equipe1.getTeam().isEmpty() && !equipe2.getTeam().isEmpty()){
            //on fait combattre le premier heros de la liste et le premier monstre de la liste
            combattez1vs1(equipe1.getTeam().get(0), equipe2.getTeam().get(0));

            if (equipe1.getTeam().get(0).getPointDeVie()>0){
                looser = miseAjourEquipes(equipe1,equipe2);
            }else{
                looser = miseAjourEquipes(equipe2,equipe1);
            }
            cimetiere.getTeam().add(looser);
        }

        return cimetiere;
    }

    /**
     * Methode qui affiche l'equipe gagnante
     * @param equipeHeros l'équipe de Heros
     * @param equipeMonstre l'équipe de Monstres
     */
    private static void afficherListeVainqueurs(Equipe equipeHeros, Equipe equipeMonstre){
        System.out.println("/////////////////////////// FIN DU COMBAT //////////////////////////////");
        if(equipeMonstre.getTeam().isEmpty()){
            System.out.println("Les Heros ont gagnés! bravo!");
            System.out.println("Liste des vainqueurs : ");
            for (int i = 0; i < equipeHeros.getTeam().size(); i++) {
                System.out.println(equipeHeros.getTeam().get(i).getNom());
            }
        }else{
            System.out.println("Les Monstres ont gagnés! bravo!");
            System.out.println("Liste des vainqueurs : ");
            for (int i = 0; i < equipeMonstre.getTeam().size(); i++) {
                System.out.println(equipeMonstre.getTeam().get(i).getNom());
            }
        }
    }


    /**
     * Methode pour faire combattre un groupe de Heros contre un groupe de Monstre
     * La méthode affiche en console les combats au tour par tour
     * Elle affiche enfin la liste des vainqueurs et le cimetière.
     *
     * @param equipeHeros
     * @param equipeMonstre
     * @throws InterruptedException
     */
    public static void combatDeGroupe(Equipe equipeHeros, Equipe equipeMonstre) throws InterruptedException {
        //affichage dans la console des Heros et des Monstres dans la console
        System.out.println("------------------------------ Bienvenue sur World of Java -------------------------------");
        System.out.println("Team de Heros :" + equipeHeros.getTeam());
        System.out.println("Team de Monstres :" + equipeMonstre.getTeam());
        //ajouter le cimetière après kes combats
        Equipe cimetiere = combatDEquipe(equipeHeros,equipeMonstre);
        //affichage liste des vainqueurs
        afficherListeVainqueurs(equipeHeros,equipeMonstre);
        System.out.println("+++++++++++++++++++++++++++++++Dans le Cimetière++++++++++++++++++++++++++++++++");
        System.out.println(cimetiere.getTeam());
    }

}
