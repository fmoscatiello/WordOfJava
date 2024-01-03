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
        boolean rand; // ce booléan genererera plus tard soit treu, soit false
        //afin de savoir qui du héros ou du monstre attaquera le premier à chaque tour

        System.out.println("*******Combattez!!*******");
        System.out.println("Le premier personnage "+ heros.getNom() + " a "
                + heros.getPointDeVie() + " points de vies");
        System.out.println("Son arme est : " + heros.getArme().getNomArme()+
                " et inflige "+ heros.getArme().getDegatsParAttaque() + " points de dégats par coup.");
        System.out.println("Le second personnage "+ monstre.getNom() + " a "
                + monstre.getPointDeVie() + " points de vies");
        System.out.println("Son arme est : " + monstre.getArme().getNomArme()+
                " et inflige "+ monstre.getArme().getDegatsParAttaque() + " points de dégats par coup.");
        while (heros.getPointDeVie()>0 && monstre.getPointDeVie()>0) {
            System.out.println("------------------------");
            rand = new Random().nextBoolean();
            if (rand) {
                if (heros.getPointDeVie() > 0) {
                    System.out.println(heros.getNom() + " attaque ");
                    monstre.setPointDeVie(monstre.getPointDeVie() - heros.getArme().getDegatsParAttaque());
                    System.out.println("il reste " + monstre.getPointDeVie() + " points de vie pour " + monstre.getNom());
                }
                if (monstre.getPointDeVie() > 0) {
                    System.out.println(monstre.getNom() + " attaque ");
                    heros.setPointDeVie(heros.getPointDeVie() - monstre.getArme().getDegatsParAttaque());
                    System.out.println("il reste " + heros.getPointDeVie() + " points de vie pour " + heros.getNom());
                }
                sleep(1000);
            }else{
                if (monstre.getPointDeVie() > 0) {
                    System.out.println(monstre.getNom() + " attaque ");
                    heros.setPointDeVie(heros.getPointDeVie() - monstre.getArme().getDegatsParAttaque());
                    System.out.println("il reste " + heros.getPointDeVie() + " points de vie pour " + heros.getNom());
                }
                if (heros.getPointDeVie() > 0) {
                    System.out.println(heros.getNom() + " attaque ");
                    monstre.setPointDeVie(monstre.getPointDeVie() - heros.getArme().getDegatsParAttaque());
                    System.out.println("il reste " + monstre.getPointDeVie() + " points de vie pour " + monstre.getNom());
                }
                sleep(100);
            }
        }
        String vaincu = heros.getPointDeVie()<=0? heros.getNom(): monstre.getNom();
        System.out.println(vaincu + " est mort!");
    }

    /**
     * Methode pour faire combattre un groupe de Heros contre un groupe de Monstre
     * La méthode affiche en console les combats au tour par tour
     * Elle affiche enfin la liste des vainqueurs.
     *
     * @param equipeHeros
     * @param equipeMonstre
     * @throws InterruptedException
     */
    public static void combatDeGroupe(Equipe equipeHeros, Equipe equipeMonstre) throws InterruptedException {
        System.out.println("Team de Heros :" + equipeHeros.getTeam());
        System.out.println("Team de Monstres :" + equipeMonstre.getTeam());
        Personnage looser;
        Personnage winner;
        //Création du cimetière qui est une liste de Personnage
        Equipe cimetiere = new Equipe();
        List<Personnage> cim = new ArrayList<>();
        while (!equipeHeros.getTeam().isEmpty()&&!equipeMonstre.getTeam().isEmpty()){
            combattez1vs1(equipeHeros.getTeam().get(0), equipeMonstre.getTeam().get(0));
            if (equipeHeros.getTeam().get(0).getPointDeVie()>0){
                looser = equipeMonstre.getTeam().get(0);
                equipeMonstre.getTeam().remove(looser);
                winner = equipeHeros.getTeam().get(0);
                equipeHeros.getTeam().remove(equipeHeros.getTeam().get(0));
                equipeHeros.getTeam().add(winner);
            }else{
                looser = equipeHeros.getTeam().get(0);
                equipeHeros.getTeam().remove(looser);
                winner = equipeMonstre.getTeam().get(0);
                equipeMonstre.getTeam().remove(equipeMonstre.getTeam().get(0));
                equipeMonstre.getTeam().add(winner);
            }
            cim.add(looser);
        }
        if(!equipeHeros.getTeam().isEmpty()){
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
        cimetiere.setTeam(cim);
        System.out.println("+++++++++++++++++++++++++++++++Dans le Cimetière++++++++++++++++++++++++++++++++");
        System.out.println(cimetiere.getTeam());
    }

}
