package Views.AdminCommands;
import Models.PlaneTripModel.PlaneSection;
import Models.PlaneTripModel.PlaneSectionLayoutType;
import Models.PlaneTripModel.PlaneSectionType;

public class CreatePlaneSectionCommand<P extends PlaneSection> {

	private Integer amountOfRows;
	private PlaneSectionType sectionType;
	private PlaneSectionLayoutType layout;

}