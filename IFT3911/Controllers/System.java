package Controllers;

public class System implements ClientController, AdminPlaneTripController {

	private PaymentManager paymentManager;
	private TrainTripManager trainTripManager;
	private CruiseTripManager cruiseTripManager;
	private PlaneTripManager planeTripManager;

}