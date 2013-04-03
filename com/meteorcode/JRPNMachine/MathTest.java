/**
 * 
 */
package com.meteorcode.JRPNMachine;

import java.util.EmptyStackException;

/**
 * @author hawk
 *
 */
public class MathTest {
	
	public static void emptyTestCase(RPNMachine target, String ops) {
		for(String s : ops.split(" ")) {
			target.eval(s);
		}
		
		try {
			System.err.println("BAD: " + target.showNextValue());
			System.out.println("BAD: Target should have been empty!");
		} catch (EmptyStackException e) {
			System.out.println("GOOD: Stack is empty.");
		}
	}
	
	public static void arithmeticTestCase (double expected, RPNMachine target, String ops) {
		for (String s : ops.split(" ")) {
			target.eval(s);
		}
		
		if (Math.abs(target.showNextValue().getUnprecise() - expected) < 0.0000001) {
			System.out.println ("GOOD: " + target.showState());
		} else {
			System.err.println("BAD: expected " + expected + ", got " + target.showNextValue());
			System.out.printf("BAD TEST: \"%s\"; %s, top =/= %f", ops, target.showState(), expected);
		}
		//target.eval ("clearall");
	}
	
	public static void errorTestCase(Class<? extends Exception> exception, RPNMachine target, String ops) {
		try {
			for(String s : ops.split(" "))
				target.eval(s);
			System.err.println("BAD: Should have errored, did not.");
			System.out.println("BAD: Didn't encounter expected error.");
		} catch(Exception e) {
			if(exception.isInstance(e)) {
				System.out.printf("GOOD: Caught exception %s\n", exception.getName());
			}
			else {
				System.err.printf("BAD: Expected exception %s, caught %s instead!", exception.getName(), e.getClass().getName());
				System.out.println("BAD: Wrong error!");
			}
		}
	}
	
	public static void main(String[] args) {
		
		RPNMachine testMachine = new RPNMachine ();
		//verify a known example given by wikipedia
		arithmeticTestCase(3.000122, testMachine, "3 4 2 * 1 5 - 2 3 ^ ^ / +");
		//verify simple math
		arithmeticTestCase(8, testMachine, "1 5 3 +");
		//verify state saved across tests
		arithmeticTestCase(9, testMachine, "+");
		//verify clearall
		emptyTestCase(testMachine, "clearall");
		//verify alias of clearall
		emptyTestCase(testMachine, "1 3 5 6 ca");
		//verify things get pushed to this point
		arithmeticTestCase(7, testMachine, "1 3 8 7");
		//verify single clear
		arithmeticTestCase(8, testMachine, "c");
		//verify ailias of single clear
		arithmeticTestCase(3, testMachine, "clear");
		//verify that the stack still has 3 1 on it
		arithmeticTestCase(4, testMachine, "+");
		//verify that adding while there aren't enough things on the stack causes breakage.
		errorTestCase(EmptyStackException.class, testMachine, "+");
		testMachine = new RPNMachine();
		arithmeticTestCase(21, testMachine, "3 4 2 * 1 5 - 2 3 ^ ^ / + 1 5 3 + + clearall 1 ca 9 1 3 8 7 c + + +");
	}

}
