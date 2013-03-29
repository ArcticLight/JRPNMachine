public class RPNMachine {
	public static class StackMember {
		double datavalue;
		Operation op;
		enum Operation { DATA, ADD, SUBTRACT }
		
		/**
		 * Throws an ArithmeticException if the calling StackMember is not an operand
		 */
		public void notData () {
			if(this.op != DATA) throw new ArithmeticException("Stack item " + this + " is not an integer.");	
		}
		
		/**
		 * Evaluates the calling stack member in the context of the given stack.
		 * @param the stack in which to eval the calling StackMember
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
			}
		}
	}
}
