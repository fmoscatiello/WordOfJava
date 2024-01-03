package org.example.Model;

import org.example.Abstract.Personnage;

import java.util.List;

public class Equipe {

    private List<Personnage> team ;

    public Equipe(){

    }

    public Equipe(List<Personnage> team){
        this.team=team;
    }

    public List<Personnage> getTeam() {
        return this.team;
    }

    public void setTeam(List<Personnage> team) {
        this.team = team;
    }

}
