/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.etsmtl.log430.lab3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
		
		if (registrationNumber.compareTo((Integer) notificationNumber) == 0) {			
			List<Delivery> deliveries = new ArrayList<Delivery>();
			for(Delivery d : CommonData.theListOfDeliveries.getListOfDeliveries()){
				if(d.getDriversAssigned().size() == 0){
					deliveries.add(d);
				}
			}
			Displays display = new Displays();
			display.displayDeliveryList(deliveries);
		}
	}

	
	
	
	
}
