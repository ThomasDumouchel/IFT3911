package DAOs.TripObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TripEventManager {

	private HashMap<TripEventType, List<TripEventListener>> listeners;

	public TripEventManager() {
		this.listeners = new HashMap<>();
	}

	/**
	 * 
	 * @param eventType
	 * @param listener
	 */
	public void subscribe(TripEventType eventType, TripEventListener listener) {
		// add the listener to the list of listeners for the event type
		if (this.listeners.containsKey(eventType)) {
			this.listeners.get(eventType).add(listener);
		} else {
			List<TripEventListener> newListeners = new ArrayList<>();
			newListeners.add(listener);
			this.listeners.put(eventType, newListeners);
		}
	}

	/**
	 * 
	 * @param eventType
	 * @param listener
	 */
	public void unsubscribe(TripEventType eventType, TripEventListener listener) {
		// remove the listener from the list of listeners for the event type
		if (this.listeners.containsKey(eventType)) {
			this.listeners.get(eventType).remove(listener);
		}
	}

	/**
	 * 
	 * @param eventType
	 * @param trip
	 */
	public void notify(TripEventType eventType, Object object) {
		if (this.listeners.containsKey(eventType)) {
			for (TripEventListener listener : this.listeners.get(eventType)) {
				listener.update(object);
			}
		}
	}

}