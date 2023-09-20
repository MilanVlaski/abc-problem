package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	void testFinal() {
		assertEquals(true, wordMaker.canMake("bark"));
		assertEquals(false, wordMaker.canMake("book"));
		assertEquals(true, wordMaker.canMake("treat"));
		assertEquals(false, wordMaker.canMake("common"));
		assertEquals(true, wordMaker.canMake("squad"));
		assertEquals(true, wordMaker.canMake("confuse"));
		assertEquals(false, wordMaker.canMake("bbom"));
	}

}
