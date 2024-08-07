package flightreservationsystem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class TicketReservation {

	private static final int CONFIRMEDLIST_LIMIT = 10;
	private static final int WAITINGLIST_LIMIT = 3;

	private List<Passenger> confirmedList = new ArrayList<>();
	private Deque<Passenger> waitingList = new ArrayDeque<>();

	// This getter is used only by the junit test case.
	public List<Passenger> getConfirmedList() {
		return confirmedList;
	}

	/**
	 * Returns true if passenger could be added into either confirmedList or
	 * waitingList. Passenger will be added to waitingList only if confirmedList is
	 * full.
	 * 
	 * Return false if both passengerList & waitingList are full
	 */
	public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass,
			String confirmationNumber) {
		Passenger newPassenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);
		if (this.confirmedList.size() < this.CONFIRMEDLIST_LIMIT) {
			this.confirmedList.add(newPassenger);
			return true;
		} else if (this.waitingList.size() < this.WAITINGLIST_LIMIT) {
			this.waitingList.add(newPassenger);
			return true;
		}
		return false;

	}

	/**
	 * Removes passenger with the given confirmationNumber. Passenger could be in
	 * either confirmedList or waitingList. The implementation to remove the
	 * passenger should go in removePassenger() method and removePassenger method
	 * will be tested separately by the uploaded test scripts.
	 * 
	 * If passenger is in confirmedList, then after removing that passenger, the
	 * passenger at the front of waitingList (if not empty) must be moved into
	 * passengerList. Use poll() method (not remove()) to extract the passenger from
	 * waitingList.
	 */
	public boolean cancel(String confirmationNumber) {
		boolean removedFromConfirmedList = removePassenger(this.confirmedList.iterator(), confirmationNumber);
		if (!removedFromConfirmedList) {
			for (Passenger passenger : this.waitingList) {
				if (passenger.getConfirmationNumber()==confirmationNumber) {
					this.waitingList.remove(passenger);
					return true;
				}
			}
		} else if(removedFromConfirmedList) {
			Passenger waitingPassenger = this.waitingList.poll();
			this.confirmedList.add(waitingPassenger);
			return true;
		}
		return false;
	}

	/**
	 * Removes passenger with the given confirmation number. Returns true only if
	 * passenger was present and removed. Otherwise, return false.
	 */
	public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
		while(iterator.hasNext()) {
			Passenger confirmedPassenger = iterator.next();
			if (confirmedPassenger.getConfirmationNumber()==confirmationNumber) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

}
