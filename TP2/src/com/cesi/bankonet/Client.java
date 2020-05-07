package com.cesi.bankonet;

public class Client {
    public String identifiant;
    public String nom;
    public String prenom;

    public CompteCourant compteCourant;

    public CompteEpargne compteEpargne;

    public Client(String identifiant, String nom, String prenom, CompteCourant compteCourant) {
        if(compteCourant == null){
            throw new NullPointerException("CompteCourant should not be null");
        }
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.compteCourant = compteCourant;
    }

    public Client(String identifiant, String nom, String prenom, CompteCourant compteCourant, CompteEpargne compteEpargne){
        this(identifiant, nom, prenom, compteCourant);
        this.compteEpargne = compteEpargne;
    }

    public double calculerAvoirGlobal(){
        if(compteEpargne == null){
            return compteCourant.getBalance();
        }
        return compteCourant.getBalance() + compteEpargne.getBalance();
    }

    @Override
    public String toString() {
        return "Client{" +
                "identifiant='" + identifiant + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
