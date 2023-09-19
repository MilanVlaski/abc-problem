package main;

public class Block {

	private char first;
	private char second;
	
	public Block(char first, char second) {
		super();
		this.first = first;
		this.second = second;
	}

	public boolean has(char c) {
		return (c == first || c == second);
	}
}
