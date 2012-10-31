package reader;

import hash.HashTable;
import tree.trie.TrieTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Reader {
	String file;
	Vector<String> text;
	String[] keys;
	HashTable hash;
	TrieTree trie;

	public Reader(String file) throws IOException {
		this.file = file;
		this.text = new Vector<String>();
		this.hash = new HashTable();
		this.trie = new TrieTree();
		readFile();
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
	
	public HashTable getHash() {
		return hash;
	}

	public void setHash(HashTable hash) {
		this.hash = hash;
	}

	public TrieTree getTrie() {
		return trie;
	}

	public void setTrie(TrieTree trie) {
		this.trie = trie;
	}

	public Vector<String> getText() {
		return text;
	}

	public void setText(Vector<String> text) {
		this.text = text;
	}

	public void searchKeyWords()
	{
		for(String key: keys)
		{
			Vector<Integer> lines = new Vector<Integer>();
			
			trie.insert(key);
			for(int i = 0; i < text.size(); i++)
			{
				if(text.get(i).contains(key))
				{
					lines.add(i);
				}
			}
			
			int[] l = new int[lines.size()];
			for(int i = 0; i < lines.size(); i++)
			{
				l[i] = lines.get(i);
			}
			hash.add(key.toLowerCase(), l);
		}
	}
	
}
