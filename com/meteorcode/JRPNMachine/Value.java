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
	private static boolean NewPrecise;
	
	//am I a precise object?
	private boolean myPrecision;
	
	//contained data
	private double doubleData;
	private BigDecimal bigData;
	
	
	public Value(String instantiation) throws NumberFormatException {
		myPrecision = NewPrecise;
		if(NewPrecise) {
			bigData = new BigDecimal(instantiation);
		}
		else {
			doubleData = Double.parseDouble(instantiation);
		}
	}
	
	private Value (BigDecimal data) {
		myPrecision = true;
		bigData = data;
	}
	
	public Value(double data) {
		myPrecision = false;
		doubleData = data;
	}

	public boolean precise() {
		return myPrecision;
	}
	
	public double getUnprecise() {
		if(myPrecision) {
			return bigData.doubleValue();
		}
		else {
			return doubleData;
		}
	}
	
	public BigDecimal getPrecise() {
		if(myPrecision) {
			return bigData;
		} else {
			return new BigDecimal(doubleData);
		}
	}
	
	public static Value add (Value a, Value b) {
		if(a.precise() || b.precise()) {
			return new Value(a.getPrecise().add(b.getPrecise()));
		} else {
			return new Value(a.getUnprecise() + b.getUnprecise());
			
		}
	}
	
	static {
		NewPrecise = false;
	}

}
