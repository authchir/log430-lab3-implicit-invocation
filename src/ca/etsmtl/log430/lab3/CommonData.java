package ca.etsmtl.log430.lab3;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains data that is used (directly or indirectly) by all
 * classes.
 * 
 * @author A.J. Lattanze, CMU
 * @version 1.3, 2012-Jun-19
 */

/*
 * Modification Log **********************************************************
 * 
 * v1.3, R. Champagne, 2012-Jun-19 - Various refactorings for new lab.
 * 
 * v1.2, R. Champagne, 2011-Feb-24 - Various refactorings, conversion of
 * comments to javadoc format.
 * 
 * v1.1, R. Champagne, 2002-Jun-19 - Adapted for use at ETS.
 * 
 * v1.0, A.J. Lattanze, 12/29/99 - Original version.
 * 
 * ***************************************************************************
 */

public class CommonData {
	/** The file that contains the information for deliveries. */
	private String defaultDeliveryFile = "deliveries.txt";

	/** The file that contains the information for drivers. */
	private String defaultDriverFile = "drivers.txt";
	
	/** Variable used to determine if initialization has been realized. */
	private static boolean initialized = false;

	/** Object that reads the deliveries from a file. */
	static DeliveryReader theListOfDeliveries;

	/** Object that reads the drivers from a file. */
	static DriverReader theListOfDrivers;

	/** A list of components */
	private static List<Communication> systemComponents;

	/**
	 * Initializes the driver and delivery list using the default lists
	 */
	public CommonData() {
		if (!initialized) {
			theListOfDeliveries = new DeliveryReader(defaultDeliveryFile);
			theListOfDrivers = new DriverReader(defaultDriverFile);
			systemComponents = new ArrayList<Communication>();
			initialized = true;
		} // if

		// If either list is null, you are in trouble.
		if (theListOfDeliveries.getListOfDeliveries() == null) {
			System.out.println("\n\n *** The delivery list is empty ***");
		}
		
		if (theListOfDrivers.getListOfDrivers() == null) {
			System.out.println("\n\n *** The driver list is empty ***");
		}
	}

	/**
	 * Updates an internal list of system components. This lets system
	 * components know the identity of other components in the system
	 * 
	 * @param component
	 */
	public void registerComponent(Communication component) {
		systemComponents.add(component);
	}

	/**
	 * @param componentName
	 * @return object that corresponds to the object's instance name
	 */
	public Communication getComponent(final String componentName) {
		return Utils.find(systemComponents, new Predicate<Communication>() {
			@Override
			public boolean run(Communication c) {
				return c.componentName.equalsIgnoreCase(componentName);
			}
		});
	}

	/**
	 * @param componentName
	 * @return registration ID that corresponds to the object's instance name
	 */
	public Integer getComponentID(final String componentName) {
		Communication c = Utils.find(systemComponents, new Predicate<Communication>() {
			@Override
			public boolean run(Communication c) {
				return c.componentName.equalsIgnoreCase(componentName);
			}
		});
		
		return c != null ? c.registrationNumber : null;
	}
}