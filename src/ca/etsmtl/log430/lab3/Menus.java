package ca.etsmtl.log430.lab3;

import java.util.Arrays;
import java.util.Collections;

/**
 * This class presents the user with menus, accepts their choice, ensures their
 * choice is valid, and returns their choice to the caller. The menu is
 * presented as follows:
 * 
 * <pre>
 *    1) List drivers
 *    2) List deliveries
 *    3) List deliveries currently assigned to a driver today
 *    4) List drivers currently assigned to a delivery today
 *    5) Assign a driver to a delivery
 *    X) Exit.
 * </pre>
 * 
 * @author A.J. Lattanze, CMU
 * @version 1.4, 2012-May-31.
 */

/*
 * Modification Log
 * ***************************************************************************
 * v1.4, R. Champagne, 2012-May-31 - Various refactorings for new lab.
 * 
 * v1.3, R. Champagne, 2012-Feb-02 - Various refactorings for new lab.
 * 
 * v1.2, 2011-Feb-02, R. Champagne - Various refactorings, javadoc comments.
 * 
 * v1.1, 2002-May-21, R. Champagne - Adapted for use at ETS.
 * 
 * v1.0, 12/29/99, A.J. Lattanze - Original version.
 * ***************************************************************************
 */

public class Menus {
	public char mainMenu() {
		Termio terminal = new Termio();
		char userChoice = ' ';
		boolean error = true;

		while (error) {
			System.out.println("\n\n1) List drivers");
			System.out.println("2) List deliveries");
			System.out.println("3) List deliveries currently assigned to a driver today");
			System.out.println("4) List drivers currently assigned to a delivery today");
			System.out.println("5) Assign a driver to a delivery");
			System.out.println("6) List deliveries made by driver");
			System.out.println("X) Exit");
			System.out.print("\n\nEnter your choice and press return >> ");

			userChoice = terminal.keyboardReadChar();

			if (!Utils.contains(Arrays.asList('1', '2', '3', '4', '5', '6', 'X', 'x'), userChoice)) {
				System.out.print("\n\n*** Invalid Choice:: " + userChoice + " ***");
			} else {
				error = false;
			}
		}
		return userChoice;
	}

	public Driver pickDriver(Iterable<Driver> list) {
		System.out.print("\n\nEnter driver ID and press return >> ");
		final String userChoice = new Termio().keyboardReadString();

		Driver driver = Utils.find(list, new Predicate<Driver>() {
			@Override
			public boolean run(Driver d) {
				return d.getDriverID().equalsIgnoreCase(userChoice);
			}
		});

		if (driver == null) {
			System.out.println("\n\n*** Driver ID " + userChoice + " not found ***");
		}

		return driver;

	}

	public Delivery pickDelivery(Iterable<Delivery> list) {
		System.out.print("\nEnter delivery ID and press return >> ");
		final String userChoiceDeliveryID = new Termio().keyboardReadString();

		 Delivery delivery = Utils.find(list, new Predicate<Delivery>() {
			@Override
			public boolean run(Delivery d) {
				return d.getDeliveryID().equalsIgnoreCase(userChoiceDeliveryID);
			} 
		 });

		if (delivery == null) {
			System.out.print("\n\n*** Delivery ID:" + userChoiceDeliveryID + " not found ***");
		}

		return delivery;
	}
}