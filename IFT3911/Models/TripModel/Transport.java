package Models.TripModel;
import java.util.*;

public abstract class Transport<T extends Enum, O extends ReserveOption, R extends Reservable<O>, S extends Section<O, R, T>> {

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

	/**
	 * @param sectionType
	 * @param option
	 */
	public R reserve(T sectionType, O option){
        var section = this.GetSection(sectionType);
		if (section == null){
			return null;
		}
		else{
			return section.Reserve(option);
		} 
	}

}