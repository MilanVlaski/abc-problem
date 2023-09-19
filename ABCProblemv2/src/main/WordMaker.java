package main;

import java.util.Vector;

public class WordMaker {
	
	Vector<Block> blocks = new Vector<>();

	public WordMaker() {
		blocks.add(new Block('B', 'O'));
		blocks.add(new Block('X', 'K'));
		blocks.add(new Block('D', 'Q'));
		blocks.add(new Block('C', 'P'));
		blocks.add(new Block('N', 'A'));
		blocks.add(new Block('G', 'T'));
		blocks.add(new Block('R', 'E'));
		blocks.add(new Block('T', 'G'));
		blocks.add(new Block('Q', 'D'));
		blocks.add(new Block('F', 'S'));
		blocks.add(new Block('J', 'W'));
		blocks.add(new Block('H', 'U'));
		blocks.add(new Block('V', 'I'));
		blocks.add(new Block('A', 'N'));
		blocks.add(new Block('O', 'B'));
		blocks.add(new Block('E', 'R'));
		blocks.add(new Block('F', 'S'));
		blocks.add(new Block('L', 'Y'));
		blocks.add(new Block('P', 'C'));
		blocks.add(new Block('Z', 'M'));
	}
	
	//Returns the index of a matching block (if no matching blocks are present,
	// returns an index that is 1 greater than the length of the array of blocks)
	public int compareLetterWithBlocks(char c) {
		int index = 0;
		
		for (Block b : blocks) {
			if(b.isMatching(c))
				break;
			index++;
		}
		return index;
	}
	
	//returns an all upper case representation of a String, as a char[]
	public char[] prepareWord(String word) {
		return word.toUpperCase().toCharArray();
	}
	
	//removes the blocks if they are matching, and returns the number of removed blocks
	public int removeBlocks(String word) {
		
		char[] chars = prepareWord(word);
		int numOfRemovedBlocks = 0;
		
		for (char c : chars) {
			int indexToRemove = compareLetterWithBlocks(c);
			if(indexToRemove < blocks.size()) {
				blocks.remove(indexToRemove);
				numOfRemovedBlocks++;
			}
		}
		return numOfRemovedBlocks;
	}
	
	//returns true if the word can be assembled with the blocks
	public boolean makeWord(String word) {
		int numOfRemovedBlocks = removeBlocks(word);
		
		return (numOfRemovedBlocks == word.length());
	}
}
