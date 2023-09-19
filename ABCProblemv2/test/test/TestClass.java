package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Block;
import main.WordMaker;

class TestClass {

	WordMaker wordMaker;
	public static List<Block> BLOCKS = Arrays.asList(
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
		assertEquals(true, block.has('B'));
	}

	@Test
	void fourthBlockShouldHaveA() {
		assertEquals(4, wordMaker.indexOfBlockThatMatches('A'));
	}

	@Test
	void shouldReturnMinusOneIfNotFound() {
		wordMaker = new WordMaker(Arrays.asList(new Block('A', 'B')));
		assertEquals(-1, wordMaker.indexOfBlockThatMatches('C'));
	}

	@Test
	void testPrepareWord() {
		char[] expected = { 'C', 'O', 'N', 'F', 'U', 'S', 'E' };
		assertArrayEquals(expected, wordMaker.prepare("cOnfuSE"));
	}

	@Test
	void testRemoveBlocksA() {
		assertEquals(1, wordMaker.removeBlocks("A"));
	}

	@Test
	void testFinalA() {
		assertEquals(true, wordMaker.canMake("A"));
	}
}
