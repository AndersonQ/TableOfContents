package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Reader {
	String file;
	Vector<String> text;
	String[] keys;

	public Reader(String file) {
		this.file = file;
		this.text = new Vector<String>();
	}
	
	/**
	 * Read a text file, separate the  text, stored in 'text'
	 * and the key words in 'keys'
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
				line = in.readLine();
				keys = line.split(",");
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
