package Views.TripVisitors;

import java.util.List;

import Models.CruiseTripModel.CruiseSection;
import Models.CruiseTripModel.CruiseSectionType;
import Models.CruiseTripModel.CruiseTrip;
import Models.PlaneTripModel.PlaneSection;
import Models.PlaneTripModel.PlaneSectionType;
import Models.PlaneTripModel.PlaneTrip;
import Models.TrainTripModel.TrainSection;
import Models.TrainTripModel.TrainSectionType;
import Models.TrainTripModel.TrainTrip;

public class ClientTripVisitor<T extends Enum<?>> implements ITripVisitor {

	private T sectionType;

	public ClientTripVisitor(T sectionType) {
		this.sectionType = sectionType;
	}


	//YUL-YYZ:[AIRCAN]AC481(2014.11.28:06.00-2014.11.28:07:24)|237.00|E50

    @Override
    public String visitPlaneTrip(PlaneTrip trip) {
        String result = "";
        result += trip.getOrigin().getCode() + " - " + trip.getDestination().getCode() + ":";
        result += "[" + trip.getCompany().getName() + "]";
        result += trip.getId();
        result += "(" + trip.getFirstTravel().getDepartureTime().toString() + "-" + trip.getLastTravel().getArrivalTime().toString() + ")";
		PlaneSection s = trip.getTransport().getSection((PlaneSectionType)sectionType);
		result += "|" + String.format("%.2f", trip.getFullPrice() * s.getFullPriceMultiplier());
		result += "|" + s.getSectionType().getCode() + 
			Long.toString(s.getReservables().stream().filter(r -> r.isAvailable()).count());
        return result;
    }

    @Override
    public String visitTrainTrip(TrainTrip trip) {
        String result = "";
        result += trip.getOrigin().getCode() + " - " + trip.getDestination().getCode() + ":";
        result += "[" + trip.getCompany().getName() + "]";
        result += trip.getId();
        result += "(" + trip.getFirstTravel().getDepartureTime().toString() + "-" + trip.getLastTravel().getArrivalTime().toString() + ")";
		TrainSection s = trip.getTransport().getSection((TrainSectionType)sectionType);
		result += "|" + String.format("%.2f", trip.getFullPrice() * s.getFullPriceMultiplier());
		result += "|" + s.getSectionType().getCode() + 
			Long.toString(s.getReservables().stream().filter(r -> r.isAvailable()).count());
        return result;
    }

    @Override
    public String visitCruiseTrip(CruiseTrip trip) {
        String result = "";
        result += trip.getOrigin().getCode() + " - " + trip.getDestination().getCode() + ":";
        result += "[" + trip.getCompany().getName() + "]";
        result += trip.getId();
        result += "(" + trip.getFirstTravel().getDepartureTime().toString() + "-" + trip.getLastTravel().getArrivalTime().toString() + ")";
		CruiseSection s = trip.getTransport().getSection((CruiseSectionType)sectionType);
		result += "|" + String.format("%.2f", trip.getFullPrice() * s.getFullPriceMultiplier());
		result += "|" + s.getSectionType().getCode() + 
			Long.toString(s.getReservables().stream().filter(r -> r.isAvailable()).count());
        return result;
    }


}