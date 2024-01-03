package org.example;
import org.example.Battlefield.Battlefield;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------------Bienvenu sur World of Java-------------------------------");
        try {
            Battlefield.commencerLeCombat();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}