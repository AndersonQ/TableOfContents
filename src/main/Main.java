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
		Vector<String> keys;
		//Checking parameters
		if(args.length != 1)
		{
			System.err.println("Usage: java main.Main text_file");
			System.exit(1);
		}
		
		reader = new Reader(args[0]);
		reader.readFile();
		reader.searchKeyWords();
		
		trie = reader.getTrie();
		hash = reader.getHash();
		keys = trie.getAll();
		System.out.println(keys);
		trie.print();
		System.out.println("\n-----------------" + keys.size());
		for(int i = 0; i < keys.size(); i++)
		{
			int[] lines;
			System.out.println("Searching: " + keys.get(i));
			lines = hash.get(keys.get(i));
			System.out.println("lines: " + lines);
			System.out.print(keys.get(i) + ": ");
			for(int l: lines)
			{
				System.out.print(l + ", ");
			}
		}
	}
}
