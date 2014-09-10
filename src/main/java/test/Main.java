package test;

public class Main {

	public static void main(String[] args) {
		
		validateArgs(args);

		new Test().start(args);
		
	}

	private static void validateArgs(String[] args) {
		if (args.length!=1 && args.length!=3)	{
			printUsage();
			throw new IllegalArgumentException("Invalid number of arguments: "+args.length);			
		}
		
		if (args.length==3){
			try {
				Integer.parseInt(args[2]);
			}catch (NumberFormatException e){
				printUsage();
				throw new IllegalArgumentException("Invalid port: "+args[2]);
			}
			
		}
	}

	private static void printUsage() {
		System.out.println("Usage: ");
		System.out.println("Main <queryString> ");
		System.out.println("or ");
		System.out.println("Main <queryString> <httpProxyHost> <httpProxyPort>");
	}
}
