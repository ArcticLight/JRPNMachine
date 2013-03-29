/**
  * A member (either an operator or operand) of the RPN machine's execution stack.
  * @author Hawk Weisman
  * @author Max Clive
  * 
  */

package com.meteorcode.JRPNMachine;

public static class StackMember {
    double datavalue;							// the numerical value of this stack member
    Operation op;							// the operation type of this stack member
    enum Operation { DATA, ADD, SUBTRACT, MULTIPLY, DIVIDE, MODULO }	// possible operation identities for stack members
	
	
	public double getValue () {
		return this.datavalue;
	}

	/**
	 * Throws an ArithmeticException if the calling StackMember is not an operand
	 * @throws ArithmeticException
	 */
	public void notData () {
		if(this.op != DATA) throw new ArithmeticException("Stack item " + this + " is not an integer.");	
	}
}
