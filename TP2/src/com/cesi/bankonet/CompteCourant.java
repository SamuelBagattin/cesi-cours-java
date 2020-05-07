package com.cesi.bankonet;

import com.cesi.bankonet.contracts.CompteBase;
import com.cesi.bankonet.exceptions.InvalidAmountException;

public class CompteCourant extends CompteBase {
    private final double montantDecouvertAutorise;

    public CompteCourant() {
        super();
        this.montantDecouvertAutorise = 0;
    }

    public CompteCourant(String numero, String intitule, double balance, double montantDecouvertAutorise) {
        super(numero, intitule, balance);
        this.montantDecouvertAutorise = montantDecouvertAutorise;
    }

    @Override
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

    @Override
    public String toString() {
        return "CompteCourant{" +
                "numero='" + numero + '\'' +
                ", intitule='" + intitule + '\'' +
                ", balance=" + balance +
                ", montantDecouvertAutorise=" + montantDecouvertAutorise +
                '}';
    }

}
