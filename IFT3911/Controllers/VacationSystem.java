package Controllers;

import java.util.List;

import Models.PlaneTripModel.Airline;
import Models.PlaneTripModel.Airport;
import Models.PlaneTripModel.Plane;
import Models.PlaneTripModel.PlaneSection;
import Models.PlaneTripModel.PlaneSectionLayoutType;
import Models.PlaneTripModel.PlaneSectionType;
import Models.PlaneTripModel.PlaneTrip;

public class VacationSystem implements AdminPlaneTripController {

	public VacationSystem() {
		
	}

	@Override
	public Airport CreateAirport(String name, String city) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'CreateAirport'");
	}

	@Override
	public Airport UpdateAirport(String name, Airport updated_airport) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'UpdateAirport'");
	}

	@Override
	public Airport DeleteAirport(String name) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'DeleteAirport'");
	}

	@Override
	public Airline CreateAirline(String name, String prefix) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'CreateAirline'");
	}

	@Override
	public Airline UpdateAirline(String id, Airline updated_airline) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'UpdateAirline'");
	}

	@Override
	public Airline DeleteAirline(String id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'DeleteAirline'");
	}

	@Override
	public PlaneTrip CreatePlaneTrip(Airline company) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'CreatePlaneTrip'");
	}

	@Override
	public PlaneTrip UpdatePlaneTrip(String id, PlaneTrip updatedPlaneTrip) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'UpdatePlaneTrip'");
	}

	@Override
	public PlaneTrip DeletePlaneTrip(String id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'DeletePlaneTrip'");
	}

	@Override
	public PlaneSection CreatePlaneSection(Integer rowCount, PlaneSectionType sectionType,
			PlaneSectionLayoutType layout) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'CreatePlaneSection'");
	}

	@Override
	public PlaneSection UpdatePlaneSection(String id, PlaneSection updatedPlaneSection) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'UpdatePlaneSection'");
	}

	@Override
	public PlaneSection DeletePlaneSection(String id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'DeletePlaneSection'");
	}

	@Override
	public Plane createPlane() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createPlane'");
	}

	@Override
	public List<PlaneTrip> GetPlaneTrips(String origin_id, String destination_id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'GetPlaneTrips'");
	}

	@Override
	public List<PlaneTrip> GetPlaneTrips(String company_id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'GetPlaneTrips'");
	} //implements ClientController

	// private PaymentManager paymentManager;
	// private TrainTripManager trainTripManager;
	// private CruiseTripManager cruiseTripManager;
	// private PlaneTripManager planeTripManager;

}