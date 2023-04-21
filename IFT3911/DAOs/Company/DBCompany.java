package DAOs.Company;

import DAOs.Trip.TripType;
import Models.TripModel.Company;

public class DBCompany {
    
    private TripType type;
    private Company company;

    public DBCompany(TripType type, Company company) {
        this.type = type;
        this.company = company;
    }

    public TripType getType() {
        return type;
    }

    public void setCompany(Company updated_company) {
        this.company = updated_company;
    }

    public Company getCompany() {
        return company;
    }

}
