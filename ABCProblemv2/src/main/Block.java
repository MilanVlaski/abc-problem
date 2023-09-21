package main;

public class Block {

	private final char first;
	private final char second;
	private char match;

	public Block(char first, char second) {
		this.first = first;
		this.second = second;
	}

	public Block(char first, char second, char match) {
		this.first = first;
		this.second = second;
		this.match = match;
	}

	public boolean has(char c) {
		return (c == first || c == second);
	}

	public void matchTo(char c) {
		if (has(c))
			match = c;
	}

	public char match() {
		return match;
	}

	public char other() {
		if (match == first)
			return second;
		else if (match == second)
			return first;
		else
			return '\0';
	}

	@Override
	public boolean equals(Object obj) {
		Block block = (Block) obj;
		return block.has(first) && block.has(second);
	}

}
