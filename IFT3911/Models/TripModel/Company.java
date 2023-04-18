package Models.TripModel;
public abstract class Company {

	private String name; // name of the company should be unique
	private String prefix; // prefix of the company should be unique

	protected Company(String name, String prefix) {
		this.name = name;
		this.prefix = prefix;
	}

	public String getName() {
		return this.name;
	}

	public String getPrefix() {
		return this.prefix;
	}
}