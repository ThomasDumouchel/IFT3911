package Views.TripVisitors;

import java.util.List;

import Models.CruiseTripModel.CruiseTrip;
import Models.PlaneTripModel.Airport;
import Models.PlaneTripModel.PlaneSection;
import Models.PlaneTripModel.PlaneTrip;
import Models.TrainTripModel.TrainTrip;
import Models.TripModel.Section;
import Models.TripModel.Travel;

public class AdminTripVisitor implements ITripVisitor {

    @Override
    public String visitPlaneTrip(PlaneTrip p) {
        String result = "";
        Travel<Airport> travel = p.getTravels().get(0);
        result += travel.getFrom().getCode() + " - " + travel.getTo().getCode() + ":";
        result += "[" + p.getCompany().getName() + "]";
        result += p.getId();
        result += "(" + travel.getDepartureTime().toString() + "-" + travel.getArrivalTime().toString() + ")";
        List<PlaneSection> sections = p.getTransport().getSections();
        for (PlaneSection s : sections) {
            result += "|" + s.getSectionType().toString() + ":";
            result += s.getCapacity() + "/" + s.getAvailableSeats();
        }
        return result;
    }

    @Override
    public String visitCruiseTrip(CruiseTrip c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitCruiseTrip'");
    }

    @Override
    public String visitTrainTrip(TrainTrip t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitTrainTrip'");
    }
}