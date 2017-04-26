package com.example.wilder.houseofcards;

/**
 * Created by wilder on 05/04/17.
 */

public abstract class Politicien implements Malhonnete{
    private int income;
    private boolean casierJudiciaire = false;
    private double patrimoine;
    private int bullshitLevel = 0;
    private Parti parti;
    private String name;
    public static final int MINISTRE = 0;
    public static final int DEPUTE = 1;


    public Politicien(String name, int revenus, double patrimoine, Parti parti) {
        this.income = revenus;
        this.patrimoine = patrimoine;
        this.parti = parti;
        this.name = name;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int revenus) {
        this.income = revenus;
    }

    public boolean hasCasierJudiciaire() {
        return casierJudiciaire;
    }

    public void setCasierJudiciaire(boolean casierJudiciaire) {
        this.casierJudiciaire = casierJudiciaire;
    }

    public double getPatrimoine() {
        return patrimoine;
    }

    public void setPatrimoine(double patrimoine) {
        this.patrimoine = patrimoine;
    }

    public int getBullshitLevel() {
        return bullshitLevel;
    }

    public void setBullshitLevel() {
        this.bullshitLevel++;
    }
    public Parti getParti() {
        return parti;
    }
    public void setParti(Parti parti) {
        this.parti = parti;
    }
    public int getEntente(){
        switch (getParti()) {
            case PS :
            case EELV:
            case NPA:
            case FI:
                return Loi.GAUCHE;
            case FN:
            case LR:
                return Loi.DROITE;
            case EnMarche:
                return Loi.CENTRE;
            default:
                return Loi.CENTRE;
        }
    }
    public void cauchtByMediaPart(){
        this.casierJudiciaire=true;
    }

    public boolean isCasierJudiciaire() {
        return casierJudiciaire;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void Malhonnete() {

    }

    public abstract int getFunction();

}
