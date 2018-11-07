package com.tera.printlang.parser;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

	private ArrayList<String> tokens;
	
	public Parser(ArrayList<String> tokens) {
		this.tokens = tokens;
	}
	
	public void parse() {
		int index = 0;
		while (index < tokens.size()) {
			if (tokens.get(index).toUpperCase().equals("PRINT") && tokens.get(index + 1).substring(0, 6).toUpperCase().equals("STRING")) {
				String string = tokens.get(index + 1).substring(9, tokens.get(index + 1).length() - 1);
				System.out.println(string);
				index += 2;
			} else if (tokens.get(index).toUpperCase().equals("CLEAR")) {
				for (int i = 0; i < 300; i++)
					System.out.println();
				index += 1;
			} else if (tokens.get(index).toUpperCase().equals("INPUT") && tokens.get(index + 1).substring(0, 6).toUpperCase().equals("STRING")) {
				String inputMessage = tokens.get(index + 1).substring(9, tokens.get(index + 1).length() - 1);
				Scanner scanner = new Scanner(System.in);
				System.out.print(inputMessage + " ");
				String input = scanner.nextLine();
				System.out.println(input);
				index += 2;
			}
		}
	}
	
}
