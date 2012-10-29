package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Reader {
	String file;
	Vector<String> text;

	public Reader(String file) {
		this.file = file;
		this.text = new Vector<String>();
	}
	
	/**
	 * Read a text file, building a table of contents that uses
	 * a HashTable and a TrieTree
	 * @throws IOException
	 */
	public void readFile() throws IOException
	{
		String line;
		BufferedReader in = new BufferedReader(new FileReader(this.file));
		
		while(in.ready())
		{
			line = in.readLine();
			
			//If line is '#', next line is key words
			if(line.equals("#"))
			{
				System.out.println("TODO: save key words in hash table!");
				//TODO: save key words in hash table!
			}
			else
			{
				//Do not save a empty line
				if(!line.equals(""))
				{
					text.add(line);
				}
			}
			
		}
	}
	
}
