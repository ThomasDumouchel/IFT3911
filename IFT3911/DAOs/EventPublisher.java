package DAOs;

import Views.*;

public class EventPublisher {

	EventListener listeners;

	/**
	 * 
	 * @param eventType
	 * @param listener
	 */
	public void subscribe(EventTypes eventType, EventListener listener) {
		// TODO - implement EventPublisher.subscribe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param eventType
	 * @param listener
	 */
	public void unsubscribe(EventTypes eventType, EventListener listener) {
		// TODO - implement EventPublisher.unsubscribe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param eventType
	 * @param trip
	 */
	public void notify(EventTypes eventType, Trip trip) {
		// TODO - implement EventPublisher.notify
		throw new UnsupportedOperationException();
	}

}