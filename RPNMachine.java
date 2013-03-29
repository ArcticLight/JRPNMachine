public class RPNMachine {
	
	/**
	 * A member (either an operator or operand) of the RPN machine's execution stack.
	 * @author Hawk Weisman
	 * @author Max Clive
	 * 
	 */
	public static class StackMember {
		double datavalue;							// the numerical value of this stack member
		Operation op;								// the operation type of this stack member
		enum Operation { DATA, ADD, SUBTRACT, MULTIPLY, DIVIDE, MODULO }	// possible operation identities for stack members
		
		
		/**
		 * Throws an ArithmeticException if the calling StackMember is not an operand
		 * @throws ArithmeticException
		 */
		public void notData () {
			if(this.op != DATA) throw new ArithmeticException("Stack item " + this + " is not an integer.");	
		}
	}
		
	/**
	 * Evaluates the top member of the stack given as a parameter
	 * @param the stack to be evaluated
	 */
	public void eval(java.util.Stack<StackMember> stack) {
		StackMember current = stack.pop();
		switch(current.op) {
			case DATA:
			stack.push(current);
			break;
			case ADD:
				StackMember next = stack.pop();
				next.notData();
				double a = next.datavalue;
				next = stack.pop();
				next.notData();
				double b = next.datavalue;
				stack.pop (a + b);
				break;
			case SUBTRACT:
				StackMember next = stack.pop();
				next.notData();
				double a = next.datavalue;
				next = stack.pop();
				next.notData();
				double b = next.datavalue();
				stack.pop (a - b);
				break;
			case MULTIPLY:
				StackMember next = stack.pop();
				next.notData();
				double a = next.datavalue;
				next = stack.pop();
				next.notData();
				double b = next.datavalue();
				stack.pop (a * b);
				break;
			case DIVIDE:
				StackMember next = stack.pop();
				next.notData();
				double a = next.datavalue;
				next = stack.pop();
				next.notData();
				double b = next.datavalue();
				stack.pop (a / b);
				break;
			case MODULO:
				StackMember next = stack.pop();
				next.notData();
				double a = next.datavalue;
				next = stack.pop();
				next.notData();
				double b = next.datavalue();
				stack.pop (a % b);
				break;
		}
	}
}
