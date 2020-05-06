package com.cesi.bankonet;

public class CompteCourant {
    public String numero;
    public String intitule;
    public double balance;
    public double montantDecouvertAutorise;
    public static int nbComptesCourants = 0;

    public CompteCourant(String numero, String intitule, double balance, double montantDecouvertAutorise) {
        this.numero = numero;
        this.intitule = intitule;
        this.balance = balance;
        this.montantDecouvertAutorise = montantDecouvertAutorise;
        nbComptesCourants++;
    }

    public void decreaseBalance(int amount) throws Exception {
        if(this.balance - amount < -montantDecouvertAutorise){
            throw new Exception("Your balance can't be under" + -montantDecouvertAutorise);
        }
        this.balance -= amount;
    }

    public void increaseBalance(int amount){
        this.balance += amount;
    }
}
