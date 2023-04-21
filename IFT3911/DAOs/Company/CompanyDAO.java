package DAOs.Company;

import java.util.ArrayList;
import java.util.List;

import DAOs.Trip.TripType;
import DAOs.TripObserver.TripEventManager;
import Models.TripModel.Company;

public class CompanyDAO {

    private List<DBCompany> companies;
    private TripEventManager tripEventManager;

    public CompanyDAO(TripEventManager tripEventManager) {
        this.tripEventManager = tripEventManager;
        this.companies = new ArrayList<DBCompany>();
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
            result.add(ToAppModel(dbCompany));
        }
        return result;
    }

    public Company getCompany(TripType type, String companyId) {
        for (DBCompany dbCompany : GetAllDBCompanies(type)) {
            if (dbCompany.getCompany().getId().equals(companyId)) {
                return ToAppModel(dbCompany);
            }
        }
        throw new RuntimeException("Company not found");
    }

    public static Company ToAppModel(DBCompany dbWrapper) {
        return dbWrapper.getCompany();
    }




    
}