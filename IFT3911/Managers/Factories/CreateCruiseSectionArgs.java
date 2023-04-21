package Managers.Factories;

import Controllers.CreateSectionArgs;

public class CreateCruiseSectionArgs extends CreateSectionArgs {

    private int nbCabins;

    public CreateCruiseSectionArgs(int nbCabins) {
        this.nbCabins = nbCabins;
    }

    public int getNbCabins() {
        return nbCabins;
    }

}
