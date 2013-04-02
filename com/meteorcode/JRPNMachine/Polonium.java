package com.meteorcode.JRPNMachine;

import java.io.Console;

public class Polonium {
	
	public static final String P_VERSION = "0.01a";
	
	public static void main(String[] args) {
		Console con = System.console();
		con.printf("Polonium version %s start!\n", P_VERSION);
	}
}
