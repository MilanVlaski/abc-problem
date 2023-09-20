package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class WordMaker {

	private final List<Block> blocks;

	public WordMaker(List<Block> blocks) {
		this.blocks = new ArrayList<>(blocks);
	}

	public boolean canMake(String word) {
		List<Block> mutableBlocks = new ArrayList<>(blocks);
		List<Block> matchingBlocks = matchBlocks(mutableBlocks, word);
		return (matchingBlocks.size() == word.length());
	}

	private List<Block> matchBlocks(List<Block> blocks, String word) {
		List<Block> matchingBlocks = new ArrayList<>();
		char[] chars = prepare(word);

		for (char character : chars) {
			Optional<Block> match = blockThatMatches(blocks, character);
			if (match.isPresent()) {
				matchingBlocks.add(match.get());
				blocks.remove(match.get());
			}
		}

		return matchingBlocks;

		// if couldnt match, check removedBlocks
//		if (matchingBlocks.size() < word.length()) {
//			// Check which char is missing.
//			// Chec k that missing char is among removedBlocks (this means that
//			// a removed block matches two different chars in word)
//			// Get other value on block
//			// If we have once matched this value (C),
//			// that means we can create the thing!
//			// (actually we add block that matches C to removedBlocks,
//			// looping until resolved)
//		}

	}

	/**
	 * If no block is found that has the character, returns -1
	 * 
	 * @param mutableList
	 * 
	 * @param character
	 * @return
	 */
	public Optional<Block> blockThatMatches(List<Block> mutableList, char character) {

		for (Block block : mutableList) {
			if (block.has(character))
				return Optional.of(block);
		}

		return Optional.empty();
	}

	public char[] prepare(String word) {
		return word.toUpperCase().toCharArray();
	}

//	private Optional<Block> removedAndMatchingBlock(char character) {
//		for (Block block : matchingBlocks) {
//			if (block.has(character))
//				return Optional.of(block);
//		}
//		return Optional.empty();
//	}
}
