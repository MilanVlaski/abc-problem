package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WordMaker {

	// immutable list
	private final List<Block> blocks;

	public WordMaker(List<Block> blocks) {
		this.blocks = blocks;
	}

	public boolean canMake(String word) {
		List<Block> availableBlocks = new ArrayList<>(blocks);
		int matchingBlocks = matchBlocks(availableBlocks, word);
		return (matchingBlocks == word.length());
	}

	private int matchBlocks(List<Block> blocks, String word) {
		List<Block> matchingBlocks = new ArrayList<>();
		char[] chars = prepare(word);

		for (char character : chars) {
			Optional<Block> matchingBlock = blockWith(character, blocks);
			matchingBlock.ifPresent(match -> {
				matchingBlocks.add(match);
				blocks.remove(match);
				match.matchTo(character);
			});
		}

		if (matchingBlocks.size() < word.length())
			tryMatchingWithRemainingBlocks(word, blocks, matchingBlocks);

		return matchingBlocks.size();
	}

	private void tryMatchingWithRemainingBlocks(String word, List<Block> blocks, List<Block> matchingBlocks) {
		char[] matchedChars = matchedChars(matchingBlocks);
		char[] missingChars = missingChars(word, matchedChars);

		for (char missingChar : missingChars) {
			Optional<Block> missingBlock = blockWith(missingChar, matchingBlocks);
			missingBlock.ifPresent(block -> {
				char replacementChar = block.matches();
				Optional<Block> replacementBlock = blockWith(replacementChar, blocks);
				replacementBlock.ifPresent(matchingBlocks::add);
			});
		}
	}

	public Optional<Block> blockWith(char character, List<Block> blocks) {
		return blocks.stream()
				.filter(block -> block.has(character))
				.findFirst();
	}

	public char[] missingChars(String word, char[] chars) {
		String result = word.toUpperCase();
		for (char c : chars)
			result = result.replaceFirst(String.valueOf(c), "");

		return result.toCharArray();
	}

	public char[] matchedChars(List<Block> matchingBlocks) {
		char[] matchedChars = new char[matchingBlocks.size()];

		int i = 0;
		for (Block block : matchingBlocks)
			matchedChars[i++] = block.matches();

		return matchedChars;
	}

	public char[] prepare(String word) {
		return word.toUpperCase().toCharArray();
	}
}
