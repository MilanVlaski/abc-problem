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
		wordMaker = new WordMaker(TestClass.BLOCKS);
	}

	@Test
	void testFinalBARK() {
		assertEquals(true, wordMaker.canMake("bArk"));
	}


	@Test
	void testFinalBOOK() {
		assertEquals(false, wordMaker.canMake("BOOk"));
	}

	@Test
	void testFinalTREAT() {
		assertEquals(true, wordMaker.canMake("TReAt"));
	}

	@Test
	void testFinalCOMMON() {
		assertEquals(false, wordMaker.canMake("coMmon"));
	}


	@Test
	void testFinalSQUAD() {
		assertEquals(true, wordMaker.canMake("sQuad"));
	}


	@Test
	void testFinalCONFUSE() {
		assertEquals(true, wordMaker.canMake("cOnFuse"));
	}


	@Test
	void testFinalCustom() {
		assertEquals(false, wordMaker.canMake("bbom"));
	}

}
