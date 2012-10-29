package main;

import java.io.IOException;

import reader.Reader;

public class Main {

	public static void main(String[] args) throws IOException
	{
		Reader reader;
		//Checking parameters
		if(args.length != 1)
		{
			System.err.println("Usage: java main.Main text_file");
			System.exit(1);
		}
		
		reader = new Reader(args[0]);
		reader.readFile();
	}
}
