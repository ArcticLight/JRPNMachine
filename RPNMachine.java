public class RPNMachine {
	public static class StackMember {
		double datavalue;
		Operation op;
		enum Operation { DATA, ADD, SUBTRACT }
		
		public void notData () {
			if(this.op != DATA) throw new ArithmeticException("Stack item " + this + " is not an integer.");	
		}

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
					if(next.op != DATA) throw new ArithmeticException("Stack item " + next + " is not an integer.");
			}
		}
	}
}
