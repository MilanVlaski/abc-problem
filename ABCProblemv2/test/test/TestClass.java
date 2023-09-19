package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Block;
import main.WordMaker;

class TestClass {

	WordMaker wordMaker;

	@Test
	void testIsMatching() {
		Block block = new Block('B', 'O');
		assertEquals(true, block.isMatching('B'));
	}

	@BeforeEach
	void setup() {
		wordMaker = new WordMaker();
	}

	@Test
	void testCompareLetterWithBlocks() {
		assertEquals(4, wordMaker.compareLetterWithBlocks('A'));
	}

	@Test
	void testPrepareWord() {
		char[] expected = { 'C', 'O', 'N', 'F', 'U', 'S', 'E' };
		assertArrayEquals(expected, wordMaker.prepareWord("cOnfuSE"));
	}

	@Test
	void testRemoveBlocksA() {
		assertEquals(1, wordMaker.removeBlocks("A"));
	}

	@Test
	void testFinalA() {
		assertEquals(true, wordMaker.makeWord("A"));
	}
}
