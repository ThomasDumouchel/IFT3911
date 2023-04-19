package DAOs.Company;

import Models.TripModel.Company;

public class DBCompany {
    
    private CompanyType type;
    private Company company;

    public DBCompany(CompanyType type, Company company) {
        this.type = type;
        this.company = company;
    }

    public CompanyType getType() {
        return type;
    }

    public Company getCompany() {
        return company;
    }

}
