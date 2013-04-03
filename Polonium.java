/**
 * @author Max Clive
 *
 */

public class Polonium {
	
	public static final String P_VERSION = "0.3_2b";
	
	//declare Polonium specific instructions here please.
	public static final String[] P_INSTRUCTIONS = {"x", "exit", "pd", "p", "pt", "h", "help"};
	
	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		
		System.out.printf("Polonium v%s starting...   ", P_VERSION);
		
		if (args.length == 1 && args[0].equals("-help")) {
			System.out.println(""); // FIXME: write help
		}
		
		com.meteorcode.JRPNMachine.RPNMachine machine = new com.meteorcode.JRPNMachine.RPNMachine();
		
		String input = null;
		
		System.out.printf("[ ok ]\n\n");
		java.util.List<String> instructions = java.util.Arrays.asList(P_INSTRUCTIONS);
		do {
			try {
				System.out.printf("%s\n > ", machine.showState());
				input = in.nextLine();
				//if this is not a polonium instruction, eval it using the machine
				if(!instructions.contains(input))
				{
					String[] temp = input.split(" ");
					System.out.printf(">> %s : \"%s\"\n", machine.showState(), temp[0]);
					for(int i = 0; i < temp.length; i++) {
						machine.eval(temp[i]);
						if(i != temp.length - 1)
							System.out.printf(">> %s : \"%s\"\n", machine.showState(), temp[i+1]);
					}
				//otherwise, Polonium handles this input.
				} else {
					switch(input) {
						//Do nothing on x; x is exit.
						case "x":
						case "exit":
							break;
						//pd, also p:  display precision mode
						case "pd":
						case "p":
							//TODO: Implement this
							break;
						case "pt":
							//TODO: Implement this
							break;
						//h and help: display help
						case "h":
						case "help":
							System.out.printf(">> Welcome to the polonium v%s help file\n", P_VERSION);
							System.out.println(">> Polonium commands: \n>> x, exit: quit Polonium\n" +
									">> pd, p: display the current precision mode\n" +
									">> pt: I don't know whhelat this does \n>> h, help: display this help file"); //FIXME: max, what does pt do?
							System.out.println(">> RPNMachine commands: \n>> +, -, /, *: add, subtract, divide, multiply \n"
									+ ">> ^: raise the next number to the power of the number after it\n"
									+ ">> c, clear: remove a number or instruction from the stack\n"
									+ ">> ca, clearall: remove all numbers or instructions from the stack\n");
							break;
				}
			} 
			catch (NumberFormatException e) {
				System.out.printf("\nERR: NumberFormatException\nPlease enter acceptable operators and operands!\n");
			}
			catch (Exception e) {
				System.out.printf("\nERR: Type: %s\n Message: %s\n\n", e.getClass().getName(), e.getMessage());
			}
		} while(input != null && !input.equals("x") && !input.equals("exit"));
		
		System.out.println("Goodbye.");
		in.close();
	}
}
