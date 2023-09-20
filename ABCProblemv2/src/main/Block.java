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
		if (c == first)
			match = first;
		else if (c == second)
			match = second;
	}

	public char matchesChar() {
		return match;
	}
	
	@Override
	public boolean equals(Object obj) {
		Block block = (Block) obj;
		return block.has(first) && block.has(second);
	}
}
