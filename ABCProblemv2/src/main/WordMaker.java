package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class WordMaker {

	private final List<Block> blocks;
	private final List<Block> removedBlocks = new ArrayList<>();

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
	 * 
	 * @param character
	 * @return
	 */
	public int indexOfBlockThatMatches(char character) {

		int match = 0;
		for (Block block : blocks) {
			if (block.has(character)) {
				block.matchTo(character);
				return match;
			}
			match++;
		}

		return -1;
	}

	public char[] prepare(String word) {
		return word.toUpperCase().toCharArray();
	}

	private void removeBlocks(String word) {
		char[] chars = prepare(word);

		for (char character : chars) {
			int blockToRemove = indexOfBlockThatMatches(character);
			if (blockToRemove != -1)
				removeBlock(blockToRemove);
		}

		// if couldn match, check removedBlocks
		if (removedBlocks.size() < word.length()) {
			// Check which char is missing.
			// Check that missing char is among removedBlocks (this means that
			// a removed block matches two different chars in word)
			// Get other value on block
			// If we have once matched this value (C),
			// that means we can create the thing!
			// (actually we add block that matches C to removedBlocks,
			// looping until resolved)
		}

	}

	private Optional<Block> removedAndMatchingBlock(char character) {
		for (Block block : removedBlocks) {
			if (block.has(character))
				return Optional.of(block);
		}
		return Optional.empty();
	}

	private void removeBlock(int blockToRemove) {
		removedBlocks.add(blocks.get(blockToRemove));
		blocks.remove(blockToRemove);
	}

	public boolean canMake(String word) {
		removeBlocks(word);
		return (removedBlocks.size() == word.length());
	}

}
