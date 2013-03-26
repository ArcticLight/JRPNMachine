public class RPNMachine {
	public static class StackMember {
		double datavalue;
		Operation op;
		enum Operation { DATA, ADD, SUBTRACT }

		public void eval(java.util.Stack<StackMember> stack) {
			StackMember current = stack.pop();
			switch(current.op) {
				case DATA:
					stack.push(current);
					break;
				case ADD:
					StackMember next = stack.pop();
					if(next.op != DATA) throw new ArithmeticException("Stack item " + next + " is not an integer.");
					double a = next.datavalue;
			}
		}
	}
}
