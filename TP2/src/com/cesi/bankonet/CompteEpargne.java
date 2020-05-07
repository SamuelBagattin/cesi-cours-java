package com.cesi.bankonet;

import com.cesi.bankonet.contracts.CompteBase;

public class CompteEpargne extends CompteBase {
    private double tauxInteret;

    public CompteEpargne(double tauxInteret) {
        super();
        this.tauxInteret = tauxInteret;
    }

    public CompteEpargne(String numero, String intitule, double balance, double tauxInteret) {
        super(numero, intitule, balance);
        this.tauxInteret = tauxInteret;
    }
}
