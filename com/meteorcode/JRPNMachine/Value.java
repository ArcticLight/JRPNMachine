/**
 * 
 */
package com.meteorcode.JRPNMachine;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author Hawk Weisman
 * @author Max Clive
 *
 */
public class Value {
	
	private static boolean NewPrecise;		// are new values precise?
	private static boolean reportScientific;	// are all values scientific?
	
	private boolean myPrecision;		// am I precise?
	
	//contained data
	private double doubleData;
	private BigDecimal bigData;
	
	DecimalFormat scientific = new DecimalFormat("0.0E0");
	
	public Value(String instantiation) throws NumberFormatException {
		myPrecision = NewPrecise;
		if(NewPrecise) {
			bigData = new BigDecimal(instantiation);
		}
		else {
			doubleData = Double.parseDouble(instantiation);
		}
	}
	
	public Value (BigDecimal data) {
		myPrecision = true;
		bigData = data;
	}
	
	public Value(double data) {
		myPrecision = false;
		doubleData = data;
	}
	
	public static boolean getDefaultPrecision() {
	    return NewPrecise;
	}
	
	public static boolean getScientific() {
		return (reportScientific);
	}
	
	public static void setDefaultPrecision(boolean precise) {
	    NewPrecise = precise;
	}
	
	public static void setScientific(boolean newVal) {
	    reportScientific = newVal;
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
	
	public static Value subtract(Value a, Value b) {
		if(a.precise() || b.precise()) {
			return new Value(a.getPrecise().subtract(b.getPrecise()));
		} else {
			return new Value(a.getUnprecise() - b.getUnprecise());
		}
	}
	
	public static Value multiply(Value a, Value b) {
		if(a.precise() || b.precise()) {
			return new Value(a.getPrecise().multiply(b.getPrecise()));
		} else {
			return new Value(a.getUnprecise() * b.getUnprecise());
		}
	}
	
	public static Value divide(Value a, Value b) {
		if(a.precise() || b.precise()) {
			return new Value(a.getPrecise().divide(b.getPrecise()));
		} else {
			return new Value(a.getUnprecise() / b.getUnprecise());
		}
	}
	
	public static Value power(Value a, Value b) {
		if(a.precise() || b.precise()) {
			throw new ArithmeticException("Error! This operation not implemented for Precise numbers");
		} else {
			return new Value(Math.pow(a.getUnprecise(), b.getUnprecise()));
		}
	}
	
	@Override
	public String toString () {
		if (reportScientific) {
			if (this.precise()){
				return scientific.format(this.getPrecise());
			} else {
				return scientific.format(this.getUnprecise());
			}
		} else {
			if (this.precise()) {
				return getPrecise().toString();
			} else {
				//if there is no fractional part
				if(Math.floor(this.getUnprecise()) == this.getUnprecise()) {
					return String.format("%.0f", getUnprecise());
				}
				return String.format("%f",getUnprecise());
			}
		}
	}
	
	static {
		NewPrecise = false;
	}

}
