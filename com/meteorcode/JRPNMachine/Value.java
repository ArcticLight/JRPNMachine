/**
 * 
 */
package com.meteorcode.JRPNMachine;
import java.math.BigDecimal;

/**
 * @author Hawk Weisman
 * @author Max Clive
 *
 */
public class Value {
	
	//are new things precise?
	private static boolean New_Prescise;
	
	//am I a precise object?
	private boolean my_precision;
	
	//contained data
	private double doublData;
	private BigDecimal bigData;
	
	
	public Value(String instantiation) throws NumberFormatException {
		my_precision = New_Precise;
		if(New_Precise) {
			bigData = new BigDecimal(instantiation);
		}
		else {
			doublData = Double.parseDouble(instantiation);
		}
	}
	
	private Value(BigDecimal data) {
		my_precision = true;
		bigData = data;
	}
	
	public boolean precise() {
		return my_precision;
	}
	
	public double getUnprecise() {
		if(my_precision) {
			return bigData.doubleValue();
		}
		else {
			return doublData;
		}
	}
	
	public BigDecimal getPrecise() {
		if(my_precision) {
			return bigData;
		} else {
			return new BigDecimal(doublData);
		}
	}
	
	public static Value add(Value a, Value b) {
		if(a.precise() || b.precise()) {
			//BigDecimal temp = 
		}
	}
	
	static {
		New_Precise = false;
	}
	
	

}
