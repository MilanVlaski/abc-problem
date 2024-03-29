package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Block;
import main.WordMaker;

class TestClass {

	WordMaker wordMaker;
	public static List<Block> BLOCKS = List.of(
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
			new Block('Z', 'M'));

	@BeforeEach
	void setup() {
		wordMaker = new WordMaker(BLOCKS);
	}

	@Test
	void blockShouldHaveB() {
		Block block = new Block('B', 'O');
		assertTrue(block.has('B'));
	}

	@Test
	void shouldMatchBlockToB() {
		Block block = new Block('B', 'O');
		block.matchTo('B');
		assertEquals('B', block.matches());
	}

	@Test
	void shouldMatchBlockToO() {
		Block block = new Block('B', 'O');
		block.matchTo('O');
		assertEquals('O', block.matches());
		assertEquals('B', block.other());
	}

	@Test
	void shouldReturnMatchingBlock() {
		Block aBlock = new Block('A', 'B');
		List<Block> blocks = List.of(aBlock);
		assertEquals(aBlock, wordMaker.blockWith('A', blocks).get());
	}

	@Test
	void shouldReturnEmptyIfNotFound() {
		List<Block> blocks = List.of(new Block('A', 'B'));
		assertEquals(Optional.empty(), wordMaker.blockWith('C', blocks));
	}

	@Test
	void testPrepareWord() {
		char[] expected = { 'C', 'O', 'N', 'F', 'U', 'S', 'E' };
		assertArrayEquals(expected, wordMaker.prepare("cOnfuSE"));
	}

	@Test
	void testFinalA() {
		assertTrue(wordMaker.canMake("A"));
	}

//	 This obviously can make the word "ace". But because we go sequentially,
//	 we can never know that we missed an opportunity to make it.
	@Test
	void shouldWorkRegardlessOfOrderOfBlocks() {
		WordMaker wordMaker = new WordMaker(List.of(
				new Block('A', 'Z'),
				new Block('C', 'E'),
				new Block('C', 'B')));
		assertTrue(wordMaker.canMake("ace"));
	}

	@Test
	void shouldMakeCharArrayOutOfBlocks() {
		List<Block> matchedBlocks = List.of(
				new Block('A', 'Z', 'A'),
				new Block('C', 'E', 'C'));
		char[] charArray = { 'A', 'C' };
		assertArrayEquals(charArray, wordMaker.matchedChars(matchedBlocks));
	}

	@Test
	void shouldGetCharsThatAreMissingFromWord() {
		assertArrayEquals(new char[] { 'E' },
				wordMaker.missingChars("ACE", new char[] { 'A', 'C' }));
	}

	@Test
	void shouldGetBlockThatHasMissingChar() {
		List<Block> matchedBlocks = List.of(
				new Block('A', 'Z'),
				new Block('C', 'E'));
		assertEquals(new Block('C', 'E'),
				wordMaker.blockWith('E', matchedBlocks).get());
	}
}
