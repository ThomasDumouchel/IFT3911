package Models.TripModel;
import java.util.*;

public abstract class Transport<S extends Section<R, O, T>, R extends Reservable<O>, O extends ReservationOption, T extends ISectionType> {

	private List<S> sections;

	public Transport() {
		sections = new ArrayList<S>();
	}

	public List<S> getSections() {
		return this.sections;
	}

	public S getSection(T sectionType) {
		for (S s : this.sections) {
			if (s.getSectionType() == sectionType) {
				return s;
			}
		}
		return null;
	}

	public void addSection(S section) {
		this.sections.add(section);
	}

}