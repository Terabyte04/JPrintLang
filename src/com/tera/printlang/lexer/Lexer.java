package com.tera.printlang.lexer;

import java.util.ArrayList;

public class Lexer {

	private String data;
	private ArrayList<String> tokens;
	
	public Lexer(String data) {
		this.data = data;
		this.tokens = new ArrayList<String>();
	}
	
	public ArrayList<String> lex() {
		char[] chars = data.toCharArray();
		ArrayList<Character> asList = new ArrayList<Character>();
		for (char character : chars)
			asList.add(character);
		String acc = "";
		int state = 0;
		String string = "";
		for (char character : asList) {
			acc += character;
			if (acc.equals("\n"))
				acc = "";
			else if (acc.equals(" ")) {
				if (state == 0)
					acc = "";
				else
					acc = " ";
			} else if (acc.toUpperCase().equals("PRINT")) {
				tokens.add("PRINT");
				acc = "";
			} else if (acc.toUpperCase().equals("CLEAR")) {
				tokens.add("CLEAR");
				acc = "";
			} else if (acc.toUpperCase().equals("INPUT")) {
				tokens.add("INPUT");
				acc = "";
			} else if (acc.matches(".*\\d+.*")) {
				tokens.add("NUMBER:  " + acc);
				acc = "";
			} else if (acc.toUpperCase().equals("IF")) {
				tokens.add("IF");
				acc = "";
			} else if (acc.toUpperCase().equals("THEN")) {
				tokens.add("THEN");
				acc = "";
			} else if (acc.toUpperCase().equals("END")) {
				tokens.add("END");
				acc = "";
			} else if (acc.equals("==")) {
				tokens.add("==");
				acc = "";
			} else if (acc.equals("\"")) {
				if (state == 0)
					state = 1;
				else if (state == 1) {
					tokens.add("STRING: " + string + "\"");
					state = 0;
					acc = "";
					string = "";
				}
			} else if (state == 1) {
				string += acc;
				acc = "";
			}
		}
		return tokens;
	}
	
}
