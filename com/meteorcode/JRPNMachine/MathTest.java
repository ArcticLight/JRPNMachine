/**
 * 
 */
package com.meteorcode.JRPNMachine;

import com.meteorcode.JRPNMachine.StackMember.Operation;

/**
 * @author hawk
 *
 */
public class MathTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.Stack<StackMember> stack = new java.util.Stack<StackMember>();
		
		stack.push(new StackMember(1));
		stack.push(new StackMember(1));
		stack.push(new StackMember(Operation.ADD));
		
		RPNMachine.eval(stack);
		
		if (stack.peek().getValue() != 2.0) {
			System.err.println ("Unexpected value, " + stack.peek().getValue());
		}	else {
			System.out.println ("Expected value, " + stack.peek().getValue());
		}
		
		stack.push(new StackMember(1));
		stack.push(new StackMember(4));
		stack.push(new StackMember(Operation.SUBTRACT));
		
		RPNMachine.eval(stack);
		
		if (stack.peek().getValue() != 3.0) {
			System.err.println ("Unexpected value, " + stack.peek().getValue());
		}	else {
			System.out.println ("Expected value, " + stack.peek().getValue());
		}
		
		stack.push(new StackMember(5));
		stack.push(new StackMember(10));
		stack.push(new StackMember(Operation.MULTIPLY));
		
		RPNMachine.eval(stack);
		
		if (stack.peek().getValue() != 50.0) {
			System.err.println ("Unexpected value, " + stack.peek().getValue());
		}	else {
			System.out.println ("Expected value, " + stack.peek().getValue());
		}
	
		stack.push(new StackMember(50));
		stack.push(new StackMember(5));
		stack.push(new StackMember(Operation.DIVIDE));
		
		RPNMachine.eval(stack);
		
		if (stack.peek().getValue() != 10.0) {
			System.err.println ("Unexpected value, " + stack.peek().getValue());
		}	else {
			System.out.println ("Expected value, " + stack.peek().getValue());
		}
		
		
		// test input parser 
		
		RPNMachine.parseInput("1", stack);
		RPNMachine.parseInput("1", stack);
		RPNMachine.parseInput("+", stack);
		
		RPNMachine.eval(stack);
		
		if (stack.peek().getValue() != 2.0) {
			System.err.println ("Unexpected value, " + stack.peek().getValue());
		}	else {
			System.out.println ("Expected value, " + stack.peek().getValue());
		}
		
		RPNMachine.parseInput("1", stack);
		RPNMachine.parseInput("4", stack);
		RPNMachine.parseInput("-", stack);
		
		RPNMachine.eval(stack);
		
		if (stack.peek().getValue() != 3.0) {
			System.err.println ("Unexpected value, " + stack.peek().getValue());
		}	else {
			System.out.println ("Expected value, " + stack.peek().getValue());
		}
		
		RPNMachine.parseInput("5", stack);
		RPNMachine.parseInput("10", stack);
		RPNMachine.parseInput("*", stack);
		
		RPNMachine.eval(stack);
		
		if (stack.peek().getValue() != 50.0) {
			System.err.println ("Unexpected value, " + stack.peek().getValue());
		}	else {
			System.out.println ("Expected value, " + stack.peek().getValue());
		}
	
		RPNMachine.parseInput("50", stack);
		RPNMachine.parseInput("5", stack);
		RPNMachine.parseInput("/", stack);
		
		RPNMachine.eval(stack);
		
		if (stack.peek().getValue() != 10.0) {
			System.err.println ("Unexpected value, " + stack.peek().getValue());
		}	else {
			System.out.println ("Expected value, " + stack.peek().getValue());
		}
	}

}
