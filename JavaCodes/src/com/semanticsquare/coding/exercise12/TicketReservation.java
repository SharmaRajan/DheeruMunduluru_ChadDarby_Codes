/**
 * @Author: Rajan Kumar Sharma
 * Date: 24/04/2023
 */

package com.semanticsquare.coding.exercise12;

import java.util.*;

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
     * waitingList. Passenger will be added to waitingList only if confirmedList
     * is full.
     *
     * Return false if both passengerList & waitingList are full
     */
    public boolean bookFlight(String firstName, String lastName, int age, String gender,
                              String travelClass, String confirmationNumber) {

        boolean flightBooked = false;

        Passenger passenger = new Passenger(firstName,lastName,age,gender,travelClass,confirmationNumber);

        if(confirmedList.size() <= CONFIRMEDLIST_LIMIT) {
            confirmedList.add(passenger);
            flightBooked = true;
        }else if(confirmedList.size() == CONFIRMEDLIST_LIMIT){
            if(waitingList.size() <= WAITINGLIST_LIMIT) {
                waitingList.add(passenger);
                flightBooked = true;
            }
        }else{
            flightBooked = false;
        }
        return flightBooked;
    }

    /**
     * Removes passenger with the given confirmationNumber. Passenger could be
     * in either confirmedList or waitingList. The implementation to remove the
     * passenger should go in removePassenger() method and removePassenger method
     * will be tested separately by the uploaded test scripts.
     * If passenger is in confirmedList, then after removing that passenger, the
     * passenger at the front of waitingList (if not empty) must be moved into
     * passengerList. Use poll() method (not remove()) to extract the passenger
     * from waitingList.
     */
    // When we get whole object then we get this supress warning
//	@SuppressWarnings("unlikely-arg-type")
    public boolean cancel(String confirmationNumber) {

        boolean cancelTicket = false;

        Iterator<Passenger> confirmedListIterator = confirmedList.iterator();

        Iterator<Passenger> waitingListIterator = waitingList.descendingIterator();

        for(int i = 0; i < confirmedList.size(); i++) {
            if(confirmedList.get(i).getConfirmationNumber().equals(confirmationNumber)) {
//				passenger = confirmedList.get(i);
                confirmedList.remove(i);
                confirmedList.add(waitingList.poll());
                cancelTicket = true;
            }else if(waitingList.getFirst().getConfirmationNumber().equals(confirmationNumber)) {
//				passenger = waitingList.getFirst();
                waitingList.poll();
                cancelTicket = true;
            }
        }
        return cancelTicket;
    }

    /**
     * Removes passenger with the given confirmation number.
     * Returns true only if passenger was present and removed. Otherwise, return false.
     */
    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {

        boolean passengerRemoved = false;

        while(iterator.hasNext()) {
            if(confirmationNumber.equals(iterator.next().getConfirmationNumber())) {
                iterator.remove();
                passengerRemoved = true;
            }
        }
        return passengerRemoved;
    }

}
