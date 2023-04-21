package Managers.Factories;

import Controllers.CreateSectionArgs;
import Models.PlaneTripModel.PlaneSectionLayoutType;

public class CreatePlaneSectionArgs extends CreateSectionArgs {

    private int rows;
    private PlaneSectionLayoutType layoutType;

    public CreatePlaneSectionArgs(int rows, PlaneSectionLayoutType layoutType) {
        this.rows = rows;
        this.layoutType = layoutType;
    }

    public int getRows() {
        return rows;
    }

    public PlaneSectionLayoutType getLayoutType() {
        return layoutType;
    }

}
