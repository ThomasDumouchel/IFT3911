package Views.TripVisitors;

import java.util.List;

import Models.CruiseTripModel.CruiseSection;
import Models.CruiseTripModel.CruiseTrip;
import Models.PlaneTripModel.PlaneSection;
import Models.PlaneTripModel.PlaneTrip;
import Models.TrainTripModel.TrainSection;
import Models.TrainTripModel.TrainTrip;

public class AdminTripVisitor implements ITripVisitor {

    @Override
    public String visitPlaneTrip(PlaneTrip trip) {
        String result = "";
        result += trip.getOrigin().getCode() + " - " + trip.getDestination().getCode() + ":";
        result += "[" + trip.getCompany().getName() + "]";
        result += trip.getId();
        result += "(" + trip.getFirstTravel().getDepartureTime().toString() + "-" + trip.getLastTravel().getArrivalTime().toString() + ")";
        List<PlaneSection> sections = trip.getTransport().getSections();
        for (PlaneSection s : sections) {
            result += "|" + s.getSectionType().getCode() + s.getSectionLayout().getCode();
            result += Long.toString(s.getReservables().stream().filter(r -> r.isAvailable()).count())
                + "/" + Integer.toString(s.getReservables().size());
            result += String.format("%.2f", trip.getFullPrice() * s.getFullPriceMultiplier());
        }
        return result;
    }

    @Override
    public String visitTrainTrip(TrainTrip trip) {
        String result = "";
        result += trip.getOrigin().getCode() + " - " + trip.getDestination().getCode() + ":";
        result += "[" + trip.getCompany().getName() + "]";
        result += trip.getId();
        result += "(" + trip.getFirstTravel().getDepartureTime().toString() + "-" + trip.getLastTravel().getArrivalTime().toString() + ")";
        List<TrainSection> sections = trip.getTransport().getSections();
        for (TrainSection s : sections) {
            result += "|" + s.getSectionType().getCode();
            result += Long.toString(s.getReservables().stream().filter(r -> r.isAvailable()).count())
                + "/" + Integer.toString(s.getReservables().size());
            result += String.format("%.2f", trip.getFullPrice() * s.getFullPriceMultiplier());
        }
        return result;
    }

    @Override
    public String visitCruiseTrip(CruiseTrip trip) {
        String result = "";
        result += trip.getOrigin().getCode() + " - " + trip.getDestination().getCode() + ":";
        result += "[" + trip.getCompany().getName() + "]";
        result += trip.getId();
        result += "(" + trip.getFirstTravel().getDepartureTime().toString() + "-" + trip.getLastTravel().getArrivalTime().toString() + ")";
        List<CruiseSection> sections = trip.getTransport().getSections();
        for (CruiseSection s : sections) {
            result += "|" + s.getSectionType().getCode();
            result += Long.toString(s.getReservables().stream().filter(r -> r.isAvailable()).count())
                + "/" + Integer.toString(s.getReservables().size());
            result += String.format("%.2f", trip.getFullPrice() * s.getFullPriceMultiplier());
        }
        return result;
    }



}