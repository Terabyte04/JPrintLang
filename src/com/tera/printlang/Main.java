package com.tera.printlang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.tera.printlang.lexer.Lexer;
import com.tera.printlang.parser.Parser;

public class Main {
	
	private static Lexer lexer;
	private static ArrayList<String> tokens;
	
	private static Parser parser;

	private static String readFile(String fileName) {
		String data = null;
		BufferedReader reader = null;
		try {
			File file = new File(fileName);
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			StringBuilder builder = new StringBuilder();
			while ((line = reader.readLine()) != null)
				builder.append(line).append("\n");
			data = builder.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public static void main(String[] args) {
		String data = readFile("res/program.prl");
		lexer = new Lexer(data);
		tokens = lexer.lex();
		parser = new Parser(tokens);
		parser.parse();
	}
	
}
