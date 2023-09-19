package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordMaker {
	
	List<Block> blocks = new ArrayList<>();

	public WordMaker() {	
		blocks = new ArrayList<>(Arrays.asList(		
				new Block('B', 'O'),
				new Block('X', 'K'),
				new Block('D', 'Q'),
				new Block('C', 'P'),
				new Block('N', 'A'),
				new Block('G', 'T'),
				new Block('R', 'E'),
				new Block('T', 'G'),
				new Block('Q', 'D'),
				new Block('F', 'S'),
				new Block('J', 'W'),
				new Block('H', 'U'),
				new Block('V', 'I'),
				new Block('A', 'N'),
				new Block('O', 'B'),
				new Block('E', 'R'),
				new Block('F', 'S'),
				new Block('L', 'Y'),
				new Block('P', 'C'),
				new Block('Z', 'M')));
	}
	
	public WordMaker(List<Block> blocks) {	
		this.blocks = new ArrayList<>(blocks);
	}
	
	//Returns the index of a matching block (if no matching blocks are present,
	// returns an index that is 1 greater than the length of the array of blocks)
	public int indexOfMatchingBlock(char character) {
		int i = 0;
		 
		for (Block block : blocks) {
			if(block.has(character))
				break;
			i++;
		}
		
		if(i == blocks.size())
			return -1;
		
		return i;
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
			int indexToRemove = indexOfMatchingBlock(c);
			if(indexToRemove != -1) {
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
