/********************************************************************\
 * Polonium.java													*
 * A command-line interface for a JRPNMachine calculator.			*
 * 																	*
 * @author Max Clive												*
 * @author Hawk Weisman												*
 * @version 0.3RC1												*
\********************************************************************/
 
import com.meteorcode.JRPNMachine.Value;

public class Polonium {
	
	// current version string
	public static final String P_VERSION = "0.3RC1";
	
	//declare Polonium specific instructions here please.
	public static final String[] P_INSTRUCTIONS = {"x", "exit", "pd", "p", "pt",  "sd", "s", "st", "h", "help"};
	
	/**
	 * prints the Polonium help file
	 */
	public static void printHelp () {
		System.out.printf (">> Welcome to the polonium v%s help file\n", P_VERSION);
		System.out.println(">> Polonium commands: \n"
		                 + ">> x, exit: quit Polonium\n" 
				         + ">> pd, p: display the current precision mode\n" 
				         + ">> pt: Toggles the current precision mode \n"
				         + ">> sd, s: display the current notation mode (scientific, standard)"
				         + ">> st: toggles the notation mode"
				         + ">> h, help: display this help file");
		System.out.println(">> RPNMachine commands: \n"
		                 + ">> +, -, /, *: add, subtract, divide, multiply \n"
				         + ">> ^: raise the next number to the power of the number after it\n"
				         + ">> c, clear: remove a number or instruction from the stack\n"
				         + ">> ca, clearall: remove all numbers or instructions from the stack\n");
	}
	
	/**
	 * toggles current precision state and tells the user
	 */
	public static void togglePrecision () {
	    Value.setDefaultPrecision(!Value.getDefaultPrecision());
	    System.out.printf("Precision mode toggled to %s\n", ((Value.getDefaultPrecision())? "precise" : "imprecise"));
	     if (Value.getDefaultPrecision()){
	    	System.out.println("Some operations may be unavailable in this precision mode.");
	   	}
	}
	
	/**
	 * toggles the scientific notation mode
	 */
	public static void toggleScientific () {
		Value.setScientific(!Value.getScientific());
		System.out.printf("Notation mode toggled to %s.\n", ((Value.getScientific())? "scientific notation" : "standard notation"));
	}
	
	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		
		System.out.printf("Polonium v%s starting...   ", P_VERSION);
		
		if (args.length == 1 && args[0].equals("-help")) {
			printHelp();
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
						    System.out.printf("The current default precision mode is %s\n", ((Value.getDefaultPrecision())? "precise" : "imprecise"));
							break;
						case "pt":
							togglePrecision();
							break;
						case "sd":
						case "s":
							System.out.printf("Polonium is currently in %s notation mode.\n", ((Value.getScientific())? "scientific" : "standard"));
							break;
						case "st":
							toggleScientific();
							break;
						//h and help: display help
						case "h":
						case "help":
							printHelp();
							break;
					}
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
