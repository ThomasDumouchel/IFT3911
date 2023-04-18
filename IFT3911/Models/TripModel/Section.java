package Models.TripModel;

import java.util.ArrayList;
import java.util.List;

public abstract class Section<O extends ReserveOption, R extends Reservable<O>, T extends Enum> {

	private T sectionType;
	private Double fullPriceMultiplier;
	private List<R> reservables;

	public Section(T sectionType, Double fullPriceMutliplier) {
		this.sectionType = sectionType;
		this.fullPriceMultiplier = fullPriceMutliplier;
		this.reservables = new ArrayList<R>();
	}

	public T getSectionType(){
		return this.sectionType;
	}

	public Double getFullPriceMultiplier(){
		return this.fullPriceMultiplier;
	}

	/**
	 * 
	 * @param option
	 */
	public R Reserve(O option) {
		// TODO: handle the case where a reservable is available,
		// but does not respect the option (should we reserve it anyway?)
		for (R r : reservables) {
			if (r.isAvailable() && r.doesRespectOption(option)) {
				// Reserve the reservable
				r.book();
				return r;
			}
		}
		// No reservable was found
		return null;
	}

}