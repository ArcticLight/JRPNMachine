/**
  * A member (either an operator or operand) of the RPN machine's execution stack.
  * @author Hawk Weisman
  * @author Max Clive
  * 
  */

package com.meteorcode.JRPNMachine;

public class StackMember {
    Value myValue;							// the numerical value of this stack member
    Operation op;							// the operation type of this stack member
    enum Operation { DATA, ADD, SUBTRACT, MULTIPLY, DIVIDE, CLEAR, CLEAR_ALL }	// possible operation identities for stack members
	
	/**
	 * constructor: creates a new StackMember with a value (operand)
	 * @param value
	 */
	public StackMember (Value value) {
		myValue = value;
		op = Operation.DATA;
	}    
    
	/**
	 * constructor: creates a new StackMember with a value (operand)
	 * @param value
	 */
	public StackMember (String value) {
		myValue = new Value(value);
		op = Operation.DATA;
	}
	
	/**
	 * constructor: creates a new StackMember with an operation (operator)
	 * @param op 
	 */
	public StackMember (Operation op) {
		this.op = op;
		myValue = null;
	}
	
	/**
	 * accessor for datavalue
	 * @return the value of this StackMember (null if it is an operator)
	 */
	public Value getValue () {
		return this.myValue;
	}
	
	/**
	 * accessor for op
	 * @return the operation identity of this StackMember
	 */
	public Operation getOp () {
		return this.op;
	}

	/**
	 * test to see if the calling StackMember is not an operand
	 * @throws ArithmeticException
	 */
	public void notData () {
		if(this.op != Operation.DATA) throw new ArithmeticException("Stack item " + this + " is not an integer.");	
	}
	
	/**
	 * toString
	 * @return a representation of this StackMember as a string
	 */
	 public String toString () {
		switch (this.op) {
			case DATA:
				return myValue.toString();
			case ADD:
				return "+";
			case SUBTRACT:
				return "-";
			case MULTIPLY:
				return "*";
			case DIVIDE:
				return "/";
			case CLEAR:
				return "clear";
			case CLEAR_ALL:
				return "clear all";
		}
		return null;
	 }
}
