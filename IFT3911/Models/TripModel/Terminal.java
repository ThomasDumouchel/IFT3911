package Models.TripModel;
public abstract class Terminal {

	private String name;
	private String city;

	protected Terminal(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return this.city;
	}


}