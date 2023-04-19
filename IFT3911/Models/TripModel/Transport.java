package Models.TripModel;
import java.util.*;

public abstract class Transport<S extends Section<R, O, T>, R extends Reservable<O>, O extends ReservationOption, T extends Enum<T>> {

	private List<S> sections;

	public Transport() {
		sections = new ArrayList<S>();
	}

	public S GetSection(T sectionType) {
		for (S s : this.sections) {
			if (s.getSectionType() == sectionType) {
				return s;
			}
		}
		return null;
	}

}