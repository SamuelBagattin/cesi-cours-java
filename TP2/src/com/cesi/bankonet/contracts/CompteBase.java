package com.cesi.bankonet.contracts;

import com.cesi.bankonet.exceptions.InvalidAmountException;

public abstract class CompteBase {
    protected final String numero;
    protected final String intitule;
    protected double balance;

    public CompteBase() {
        this("Undefined", "Undefined", 0);
    }

    public CompteBase(String numero, String intitule, double balance) {
        this.numero = numero;
        this.intitule = intitule;
        this.balance = balance;
    }


    public void decreaseBalance(int amount) throws Exception {
        if (amount == 0) {
            throw new InvalidAmountException("Amount of money should not be null");
        }
        if (amount < 0) {
            throw new InvalidAmountException("Negative amount of money given : " + amount);
        }
        if(balance-amount < 0){
            throw new Exception("Your account can't have a balance under 0");
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

    public String getNumero() {
        return numero;
    }

    public String getIntitule() {
        return intitule;
    }

    public double getBalance() {
        return balance;
    }
}
