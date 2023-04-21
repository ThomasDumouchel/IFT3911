package DAOs.Company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DAOs.Trip.TripType;
import DAOs.TripObserver.TripEventManager;
import Models.CruiseTripModel.CruiseLine;
import Models.PlaneTripModel.Airline;
import Models.TrainTripModel.TrainLine;
import Models.TripModel.Company;

public class CompanyDAO {

    private List<DBCompany> companies;
    private TripEventManager tripEventManager;

    public CompanyDAO(TripEventManager tripEventManager) {
        this.tripEventManager = tripEventManager;
        this.companies = new ArrayList<DBCompany>(Arrays.asList(
            new DBCompany(TripType.PLANE, new Airline("Delta", "DL")),
            new DBCompany(TripType.PLANE, new Airline("American Airlines", "AA")),
            new DBCompany(TripType.PLANE, new Airline("United Airlines", "UA")),
            new DBCompany(TripType.TRAIN, new TrainLine("Amtrak", "AM")),
            new DBCompany(TripType.TRAIN, new TrainLine("Greyhound", "GR")),
            new DBCompany(TripType.TRAIN, new TrainLine("Megabus", "MB")),
            new DBCompany(TripType.CRUISE, new CruiseLine("Norwegian Cruise Line", "NC")),
            new DBCompany(TripType.CRUISE, new CruiseLine("Carnival", "CA")),
            new DBCompany(TripType.CRUISE, new CruiseLine("Royal Caribbean", "RC"))
        ));
    }

    private List<DBCompany> GetAllDBCompanies(TripType tripType) {
        List<DBCompany> result = new ArrayList<DBCompany>();
        for (DBCompany dbCompany : this.companies) {
            if (dbCompany.getType() == tripType){
                result.add(dbCompany);
            }
        }
        return result;
    }


    public static Company ToAppModel(DBCompany dbWrapper) {
        return dbWrapper.getCompany();
    }

    public Company addCompany(TripType tripType, Company company) {
        DBCompany dbCompany = new DBCompany(tripType, company);
        this.companies.add(dbCompany);
        return company;
    }

    public Company deleteCompany(TripType tripType, String companyId) {
        for (DBCompany dbCompany : GetAllDBCompanies(tripType)) {
            if (dbCompany.getCompany().getId().equals(companyId)) {
                this.companies.remove(dbCompany);
                return dbCompany.getCompany();
            }
        }
        throw new RuntimeException("Company not found");
    }

    public Company updateCompany(TripType tripType, Company company) {
        for (DBCompany dbCompany : GetAllDBCompanies(tripType)) {
            if (dbCompany.getCompany().getId().equals(company.getId())) {
                dbCompany.setCompany(company);
                return company;
            }
        }
        throw new RuntimeException("Company not found");
    }


    public List<Company> getCompanies(TripType tripType) {
        List<Company> result = new ArrayList<Company>();
        for (DBCompany dbCompany : GetAllDBCompanies(tripType)) {
            result.add((Airline)ToAppModel(dbCompany));
        }
        return result;
    }




    
}