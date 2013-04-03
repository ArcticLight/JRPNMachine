/**
 * 
 */
package com.meteorcode.JRPNMachine;

/**
 * @author hawk
 *
 */
public class MathTest {

	public static void arithmeticTestCase (double expected, RPNMachine target, String... ops) {
		for (String s : ops) {
			target.eval(s);
		}
		
		if (target.showNextValue().getUnprecise() == expected) {
			System.out.println ("GOOD: " + target.showState());
		} else {
			System.err.println("BAD: expected " + expected + ", got " + target.showNextValue());
			System.out.println("BAD: " + target.showState());
		}
		target.eval ("clearall");
	}
	public static void main(String[] args) {
		
		RPNMachine testMachine = new RPNMachine ();
		

	}

}
