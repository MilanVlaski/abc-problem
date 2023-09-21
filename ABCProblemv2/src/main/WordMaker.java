package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class WordMaker {

	// immutable list
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
				// this should be a function
				Block matchingBlock = match.get();
				matchingBlock.matchTo(character);
				matchingBlocks.add(matchingBlock);
				blocks.remove(matchingBlock);
			}
		}
		// if couldnt match, check removedBlocks
		if (matchingBlocks.size() < word.length()) {
			char[] matchedChars = matchedChars(matchingBlocks);
			char[] missingChars = missingChars(word, matchedChars);
			// for each missing char this should be done
			Optional<Block> matchingBlockWithMissingChar = blockThatHasChar(matchingBlocks, missingChars[0]);
			if(matchingBlockWithMissingChar.isPresent()) {
				char charToReplace = matchingBlockWithMissingChar.get().match();
				Optional<Block> replacementBlock = blockThatHasChar(blocks, charToReplace);
				replacementBlock.ifPresent(block -> matchingBlocks.add(block));
			}
		}

		return matchingBlocks.size();
	}

	public Optional<Block> blockThatHasChar(List<Block> matchingBlocks, char c) {
		return matchingBlocks.stream()
				.filter(block -> block.has(c))
				.findFirst();
	}

	public char[] missingChars(String word, char[] matchedChars) {
		String result = word.toUpperCase();
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
