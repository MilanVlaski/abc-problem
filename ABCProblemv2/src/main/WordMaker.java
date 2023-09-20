package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class WordMaker {

	private final List<Block> blocks;
	private final List<Block> matchingBlocks = new ArrayList<>();

	public WordMaker(List<Block> blocks) {
		this.blocks = new ArrayList<>(blocks);
	}

	/**
	 * If no block is found that has the character, returns -1
	 * @param mutableList 
	 * 
	 * @param character
	 * @return
	 */
	public int indexOfBlockThatMatches(List<Block> mutableList, char character) {

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

	private void removeBlocks(List<Block> mutableList, String word) {
		char[] chars = prepare(word);

		for (char character : chars) {
			int blockToRemove = indexOfBlockThatMatches(mutableList, character);
			if (blockToRemove != -1)
				removeBlock(mutableList, blockToRemove);
		}

		// if couldnt match, check removedBlocks
		if (matchingBlocks.size() < word.length()) {
			// Check which char is missing.
			// Chec	k that missing char is among removedBlocks (this means that
			// a removed block matches two different chars in word)
			// Get other value on block
			// If we have once matched this value (C),
			// that means we can create the thing!
			// (actually we add block that matches C to removedBlocks,
			// looping until resolved)
		}

	}

	private Optional<Block> removedAndMatchingBlock(char character) {
		for (Block block : matchingBlocks) {
			if (block.has(character))
				return Optional.of(block);
		}
		return Optional.empty();
	}

	private void removeBlock(List<Block> mutableList, int blockToRemove) {
		matchingBlocks.add(blocks.get(blockToRemove));
		blocks.remove(blockToRemove);
	}

	public boolean canMake(String word) {
		List<Block> mutableList = new ArrayList<>(blocks);
		removeBlocks(mutableList, word);
		return (matchingBlocks.size() == word.length());
	}

}
