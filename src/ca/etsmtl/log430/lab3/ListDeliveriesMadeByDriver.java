package ca.etsmtl.log430.lab3;

import java.util.Observable;

public class ListDeliveriesMadeByDriver extends Communication {

	public ListDeliveriesMadeByDriver(Integer registrationNumber, String componentName) {
		super(registrationNumber, componentName);
	}

	public void update(Observable thing, Object notificationNumber) {
		Menus menu = new Menus();
		Displays display = new Displays();
		Driver myDriver = new Driver();

		if (registrationNumber.compareTo((Integer) notificationNumber) == 0) {
			/*
			 * First we use a Displays object to list all of the drivers. Then
			 * we ask the user to pick a driver using a Menus object.
			 */
			addToReceiverList("ListDriversComponent");
			signalReceivers("ListDriversComponent");
			myDriver = menu.pickDriver(CommonData.theListOfDrivers.getListOfDrivers());

			/*
			 * If the user selected an invalid driver, then a message is
			 * printed to the terminal.
			 */
			if (myDriver != null) {
				display.displayDeliveriesMadeByDriver(myDriver);
			} else {
				System.out.println("\n\n *** Driver not found ***");
			}
		}
		removeFromReceiverList("ListDriversComponent");
	}
}
