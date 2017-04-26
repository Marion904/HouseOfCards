package com.example.wilder.houseofcards;

/**
 * Created by wilder on 05/04/17.
 */

public class Ministre extends Politicien{

    public Ministre(String name, int revenus, double patrimoine, Parti parti) {
        super(name, revenus, patrimoine, parti);
    }

    @Override
    public int getFunction() {
        return MINISTRE;
    }

    public Loi proposeLoi(){
        switch (getParti()){
            case EELV:
                return new Loi("Les petits oiseaux alinea 3",Loi.GAUCHE);
            case PS:
                return new Loi("Mariage pour tous",Loi.GAUCHE);
            case NPA:
                return new Loi("Smic = 3000 boules",Loi.GAUCHE);
            case LR:
                return new Loi("Bouclier fiscale",Loi.DROITE);
            case FN:
                return new Loi("Sorti de l'Europe",Loi.DROITE);
            case FI:
                return new Loi("Emprisonner Marine",Loi.GAUCHE);
            case EnMarche:
                return new Loi("Loi travail",Loi.CENTRE);
            default:
                return new Loi("Bayrou", Loi.CENTRE);
        }
    }
}
