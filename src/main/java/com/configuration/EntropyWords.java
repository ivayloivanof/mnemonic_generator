package com.configuration;

public enum EntropyWords {
	TWELVE(4), FIFTHEEN(5), EIGHTTEEN(6), TWENTYONE(7), TWENTYFOUR(8);
	
	private final int value;

	EntropyWords(final int v) {
        value = v;
    }

    public int getValue() { return this.value; }
}
