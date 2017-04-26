package com.example.wilder.houseofcards;

/**
 * Created by wilder on 05/04/17.
 */

public class Depute extends Politicien{

    private boolean assiduite;

    public Depute(String name, int revenus, double patrimoine, Parti parti, boolean assiduite) {
        super(name, revenus, patrimoine, parti);
        this.assiduite=assiduite;
    }

    @Override
    public boolean hasCasierJudiciaire() {
        return super.hasCasierJudiciaire();
    }

    @Override
    public int getFunction() {
        return DEPUTE;
    }

    public boolean vote (Loi loi){
        return loi.getOrientation() == this.getEntente();

    }

    public boolean estAssidu(){
        return this.assiduite;
    }
}
