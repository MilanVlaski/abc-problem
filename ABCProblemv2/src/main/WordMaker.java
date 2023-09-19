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
	
	/**
	 * If no block is found that has the character, returns -1
	 * @param character
	 * @return
	 */
	public int indexOfBlockThatMatches(char character) {
		int match = 0;
		 
		for (Block block : blocks) {
			if(block.has(character))
				return match;
			match++;
		}
		
		return -1;
	}
	
	public char[] prepare(String word) {
		return word.toUpperCase().toCharArray();
	}
	// NAME: howManyMatchingBlocks
	public int removeBlocks(String word) {
		
		char[] chars = prepare(word);
		int numOfRemovedBlocks = 0;
		
		for (char character : chars) {
			int indexToRemove = indexOfBlockThatMatches(character);
			if(indexToRemove != -1) {
				blocks.remove(indexToRemove);
				numOfRemovedBlocks++;
			}
		}
		return numOfRemovedBlocks;
	}
	
	public boolean canMake(String word) {
		int numOfRemovedBlocks = removeBlocks(word);
		
		return (numOfRemovedBlocks == word.length());
	}
}
