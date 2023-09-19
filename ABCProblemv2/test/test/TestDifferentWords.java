package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.WordMaker;

class TestDifferentWords {

	WordMaker wordMaker;
	
	@BeforeEach
	public void initialize() {
		wordMaker = new WordMaker();
	}
	
	@Test
	void testFinalBARK() {
		assertEquals(true, wordMaker.canMake("bArk"));
	}
	@Test
	void testRemoveBlocksBARK() {
		assertEquals(4, wordMaker.removeBlocks("bArk"));
	}
	@Test
	void testFinalBOOK() {
		assertEquals(false, wordMaker.canMake("BOOk"));
	}
	@Test
	void testRemoveBlocksBOOK() {
		assertEquals(3, wordMaker.removeBlocks("BOOk"));
	}
	@Test
	void testFinalTREAT() {
		assertEquals(true, wordMaker.canMake("TReAt"));
	}
	@Test
	void testRemoveBlocksTREAT() {
		assertEquals(5, wordMaker.removeBlocks("TReAt"));
	}
	@Test
	void testFinalCOMMON() {
		assertEquals(false, wordMaker.canMake("coMmon"));
	}
	@Test
	void testRemoveBlocksCOMMON() {
		assertEquals(5, wordMaker.removeBlocks("coMmon"));
	}
	@Test
	void testFinalSQUAD() {
		assertEquals(true, wordMaker.canMake("sQuad"));
	}
	@Test
	void testRemoveBlocksSQUAD() {
		assertEquals(5, wordMaker.removeBlocks("sQuad"));
	}
	@Test
	void testFinalCONFUSE() {
		assertEquals(true, wordMaker.canMake("cOnFuse"));
	}
	@Test
	void testRemoveBlocksCONFUSE() {
		assertEquals(7, wordMaker.removeBlocks("cOnFuse"));
	}
	@Test
	void testFinalCustom() {
		assertEquals(false, wordMaker.canMake("bbom"));
	}
	@Test
	void testRemoveBlocksCustom() {
		assertEquals(3, wordMaker.removeBlocks("bbom"));
	}
}
