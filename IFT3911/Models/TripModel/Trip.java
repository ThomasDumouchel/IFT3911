package Models.TripModel;

import java.util.ArrayList;
import java.util.List;

import Views.TripVisitors.ITripVisitor;

public abstract class Trip<T extends Transport, X extends Terminal> {

	private String id;
	private Company company;
	private List<Travel<X>> travels;
	private T transport;
	private Double fullPrice;

	protected Trip(Company company, Double fullPrice){
		// make the id the company prefix + a 3 digit random number
		this.id = company.getPrefix() + String.format("%03d", (int)(Math.random() * 1000));
		this.company = company;
		this.travels = new ArrayList<Travel<X>>();
		this.transport = null;
		this.fullPrice = fullPrice;
	}

	public String getId(){
		return this.id;
	}

	public T getTransport(){
		return this.transport;
	}

	public Company getCompany(){
		return this.company;
	}

	public Double getFullPrice(){
		return this.fullPrice;
	}

	public List<Travel<X>> getTravels(){
		return this.travels;
	}

	public abstract X getOrigin();

	public abstract X getDestination();

	/**
	 * 
	 * @param visitor
	 */
	public abstract String accept(ITripVisitor visitor);

}