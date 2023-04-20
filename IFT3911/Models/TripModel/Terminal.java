package Models.TripModel;
public abstract class Terminal {

	private String terminalCode;
	private String name;
	private String city;

	protected Terminal(String terminalCode, String name, String city) {
		this.terminalCode = terminalCode;
		this.name = name;
		this.city = city;
	}

	public String getId() {
		return this.terminalCode;
	}

	public String getName() {
		return this.name;
	}

	public String getCode() {
		return this.terminalCode;
	}

	public String getCity() {
		return this.city;
	}

	@Override
	public String toString(){
		return this.terminalCode + " (" + this.city + ")";
	}


}