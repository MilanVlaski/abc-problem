package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class WordMaker {

	// if you try working with this list, it breaks
	private final List<Block> blocks;

	public WordMaker(List<Block> blocks) {
		this.blocks = blocks;
	}

	public boolean canMake(String word) {
		List<Block> mutableBlocks = new ArrayList<>(blocks);
		int matchingBlocks = howManyMatchingBlocks(mutableBlocks, word);
		return (matchingBlocks == word.length());
	}

	private int howManyMatchingBlocks(List<Block> blocks, String word) {
		List<Block> matchingBlocks = new ArrayList<>();
		char[] chars = prepare(word);

		for (char character : chars) {
			Optional<Block> match = blockThatMatches(blocks, character);
			if (match.isPresent()) {
				matchingBlocks.add(match.get());
				blocks.remove(match.get());
			}
		}
		// if couldnt match, check removedBlocks
		if (matchingBlocks.size() < word.length()) {
			char[] matchedChars = matchedChars(matchingBlocks);
			char[] missingChars = missingChars(word, matchedChars);
			Optional<Block> matchingBlockWithMissingChar = matchingBlockWithMissingChar(matchingBlocks, missingChars);
			// Check that missing char is among removedBlocks (this means that
			// a removed block matches two different chars in word)
			// Get other value on block
			// If we have once matched this other value (C),
			// that means we can create the thing!
			// (actually we add block that matches C to matchingBlocks,
		}

		return matchingBlocks.size();
	}

	private Optional<Block> matchingBlockWithMissingChar(List<Block> matchingBlocks,
	                                                     char[] missingChars) {
		return matchingBlocks.stream()
				.filter((block) -> block.match() == missingChars[0])
				.findFirst();
	}

	public char[] missingChars(String word, char[] matchedChars) {
		String result = word;
		for (char c : matchedChars)
			result = result.replaceFirst(String.valueOf(c), "");

		return result.toCharArray();
	}

	public char[] matchedChars(List<Block> matchingBlocks) {
		char[] matchedChars = new char[matchingBlocks.size()];

		int i = 0;
		for (Block block : matchingBlocks)
			matchedChars[i++] = block.match();

		return matchedChars;
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
}
