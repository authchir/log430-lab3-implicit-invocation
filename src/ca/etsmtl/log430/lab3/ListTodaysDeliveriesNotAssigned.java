/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.etsmtl.log430.lab3;

import java.util.Observable;

/**
 *
 * @author Charles
 */
public class ListTodaysDeliveriesNotAssigned extends Communication {

	public ListTodaysDeliveriesNotAssigned(Integer registrationNumber, String componentName) {
		super(registrationNumber, componentName);
	}
	
	public void update(Observable sender, Object notificationNumber){
		Displays display = new Displays();
		if (registrationNumber.compareTo((Integer) notificationNumber) == 0) {			
			for(Delivery d : CommonData.theListOfDeliveries.getListOfDeliveries()){
				if(d.getDriversAssigned().isEmpty()){
					display.displayDelivery(d);
				}
			}
		}
	}

	
	
	
	
}
