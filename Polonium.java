public class Polonium {
	
	public static final String P_VERSION = "0.01a";
	
	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		
		System.out.printf("Polonium v%s starting...   ", P_VERSION);
		com.meteorcode.JRPNMachine.RPNMachine machine = new com.meteorcode.JRPNMachine.RPNMachine();
		
		String input = null;
		
		System.out.printf("[ ok ]\n\n");
		do {
			try {
				System.out.printf("%s\n > ", machine.showState());
				input = in.nextLine();
				if(!input.equals("x"))
				{
					String[] temp = input.split(" ");
					System.out.printf(">> %s : \"%s\"\n", machine.showState(), temp[0]);
					for(int i = 0; i < temp.length; i++) {
						machine.eval(temp[i]);
						if(i != temp.length - 1)
							System.out.printf(">> %s : \"%s\"\n", machine.showState(), temp[i+1]);
					}
				}
			} catch (Exception e) {
				System.out.printf("Error! Type: %s\n Message: %s\n\n", e.getClass().getName(), e.getMessage());
			}
		} while(input != null && !input.equals("x"));
		
		System.out.println("Goodbye.");
		in.close();
	}
}
