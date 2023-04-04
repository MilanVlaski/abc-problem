package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import main.Block;
import main.WordMaker;

class TestClass {

	@Test
	void testIsMatching() {
		Block block = new Block('B', 'O');
		assertEquals(true, block.isMatching('B'));
	}
	
	@Test
	void testCompareLetterWithBlocks() {
		WordMaker wordMaker = new WordMaker();
		assertEquals(4, wordMaker.compareLetterWithBlocks('A'));
	}
	
	@Test
	void testPrepareWord() {
		WordMaker wordMaker = new WordMaker();
		char[] expected = {'C', 'O', 'N', 'F', 'U', 'S', 'E'}; 
		assertArrayEquals(expected, wordMaker.prepareWord("cOnfuSE"));
	}
	
	@Test
	void testRemoveBlocksA() {
		WordMaker wordMaker = new WordMaker();
		
		assertEquals(1, wordMaker.removeBlocks("A"));
	}
	
	@Test
	void testFinalA() {
		WordMaker wordMaker = new WordMaker();
		assertEquals(true, wordMaker.makeWord("A"));
	}
}
