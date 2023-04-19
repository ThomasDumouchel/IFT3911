package DAOs.Company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Models.CruiseTripModel.CruiseLine;
import Models.PlaneTripModel.Airline;
import Models.TrainTripModel.TrainLine;
import Models.TripModel.Company;

public class CompanyDAO {

    private List<DBCompany> companies;

    public CompanyDAO() {
        this.companies = new ArrayList<DBCompany>(Arrays.asList(
            new DBCompany(CompanyType.AIRLINE, new Airline("Delta", "DL")),
            new DBCompany(CompanyType.AIRLINE, new Airline("American Airlines", "AA")),
            new DBCompany(CompanyType.AIRLINE, new Airline("United Airlines", "UA")),
            new DBCompany(CompanyType.TRAINLINE, new TrainLine("Amtrak", "AM")),
            new DBCompany(CompanyType.TRAINLINE, new TrainLine("Greyhound", "GR")),
            new DBCompany(CompanyType.TRAINLINE, new TrainLine("Megabus", "MB")),
            new DBCompany(CompanyType.CRUISELINE, new CruiseLine("Norwegian Cruise Line", "NC")),
            new DBCompany(CompanyType.CRUISELINE, new CruiseLine("Carnival", "CA")),
            new DBCompany(CompanyType.CRUISELINE, new CruiseLine("Royal Caribbean", "RC"))
        ));
    }

    public List<Company> GetCompanies(CompanyType compapyType) {
        List<Company> result = new ArrayList<Company>();
        for (DBCompany dbCompany : this.companies) {
            result.add(CompanyDAO.ToAppModel(dbCompany));
        }
        return result;
    }

    public static Company ToAppModel(DBCompany dbWrapper) {
        return dbWrapper.getCompany();
    }

    public static DBCompany ToDBModel(Company company) {
        CompanyType type = null;
        if (company instanceof Airline) {
            type = CompanyType.AIRLINE;
        } else if (company instanceof TrainLine) {
            type = CompanyType.TRAINLINE;
        } else if (company instanceof CruiseLine) {
            type = CompanyType.CRUISELINE;
        }
        return new DBCompany(type, company);
    }

    
}