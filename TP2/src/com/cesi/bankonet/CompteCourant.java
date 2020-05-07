package com.cesi.bankonet;

import com.cesi.bankonet.exceptions.InvalidAmountException;

public class CompteCourant {
    private final String numero;
    private final String intitule;
    private double balance;
    private final double montantDecouvertAutorise;
    private static int nbComptesCourants = 0;

    public CompteCourant() {
        this("Undefined", "Undefined", 0, 0);
    }

    public CompteCourant(String numero, String intitule, double balance, double montantDecouvertAutorise) {
        this.numero = numero;
        this.intitule = intitule;
        this.balance = balance;
        this.montantDecouvertAutorise = montantDecouvertAutorise;
        nbComptesCourants++;
    }


    public void decreaseBalance(int amount) throws Exception {
        if (amount == 0) {
            throw new InvalidAmountException("Amount of money should not be null");
        }
        if (amount < 0) {
            throw new InvalidAmountException("Negative amount of money given : " + amount);
        }
        if (this.balance - amount < -montantDecouvertAutorise) {
            throw new Exception("Your balance can't be under : " + -montantDecouvertAutorise);
        }
        this.balance -= amount;
    }

    public void increaseBalance(int amount) throws InvalidAmountException {
        if (amount == 0) {
            throw new InvalidAmountException("Amount of money should not be null");
        }
        if (amount < 0) {
            throw new InvalidAmountException("Negative amount of money given : " + amount);
        }
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "CompteCourant{" +
                "numero='" + numero + '\'' +
                ", intitule='" + intitule + '\'' +
                ", balance=" + balance +
                ", montantDecouvertAutorise=" + montantDecouvertAutorise +
                '}';
    }

    public static void resetAccountsNumbers(){
        CompteCourant.nbComptesCourants = 0;
    }

    //<editor-fold desc="Getters and setters">
    public String getNumero() {
        return numero;
    }

    public String getIntitule() {
        return intitule;
    }

    public double getBalance() {
        return balance;
    }

    public double getMontantDecouvertAutorise() {
        return montantDecouvertAutorise;
    }

    public static int getNbComptesCourants() {
        return nbComptesCourants;
    }
    //</editor-fold>

}
