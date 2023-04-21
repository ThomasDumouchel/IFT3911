package Managers.Factories;

import Controllers.CreateSectionArgs;

public class CreateTrainSectionArgs extends CreateSectionArgs {

    private int rows;

    public CreateTrainSectionArgs(int rows) {
        this.rows = rows;
    }

    public int getRows() {
        return rows;
    }

}
