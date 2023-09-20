package main;

public class Block {

	private final char first;
	private final char second;
	private char match;
	
	public Block(char first, char second) {
		this.first = first;
		this.second = second;
	}

	public boolean has(char c) {
		return (c == first || c == second);
	}

	public void matchTo(char c) {
		if(this.has(c)) {
			if(c == first)
				match = first;
			else
				match = second;
		}
	}

	public char matched() {
		return match;
	}
}
