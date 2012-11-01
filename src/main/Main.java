package main;

import hash.HashTable;

import java.io.IOException;
import java.util.Vector;

import reader.Reader;
import tree.trie.TrieTree;

public class Main {

	public static void main(String[] args) throws IOException
	{
		TrieTree trie;
		HashTable hash;
		Reader reader;
		Vector<String> keys, text;
		//Checking parameters
		if(args.length != 1)
		{
			System.err.println("Usage: java main.Main text_file");
			System.exit(1);
		}
		
		reader = new Reader(args[0]);
		reader.readFile();
		reader.searchKeyWords();
		
		//Get the text
		text = reader.getText();
		//Get trie
		trie = reader.getTrie();
		//Get hashtable
		hash = reader.getHash();
		//Get all stored keys
		keys = trie.getAll();
		
		//Print text
		System.out.println("Text:");
		for(String l: text)
		{
			System.out.println(l);
		}
		
		//Print keys
		System.out.print("\nKey words: ");
		System.out.println(keys);
		//uncomment to Print the trie tree
		//trie.print();
		
		//Print all keys and your element stored into hashtable
		System.out.println("\nTable of Contents\n");
		for(int i = 0; i < keys.size(); i++)
		{
			int[] lines;
			
			System.out.print(keys.get(i) + " ");
			//Get element to key i
			lines = hash.get(keys.get(i));
			
			if(lines != null)
			{
				for(int l: lines)
				{
					System.out.print(l + ", ");
				}
			}
			System.out.println();
		}
	}
}
