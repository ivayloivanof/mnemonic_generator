package com;

import com.configuration.EntropyWords;
import com.generator.MnemonicBruteForce;
import com.generator.MnemonicGenerator;

public class Main {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		MnemonicGenerator mnemonicGenerator = new MnemonicGenerator(EntropyWords.TWELVE.getValue(), "/home/ivanov/DevSrc/Java/bitcoin-bruteforce/src/main/java/mnemonic/words/english.txt");
		MnemonicBruteForce mnemonicBruteForce = new MnemonicBruteForce(false);
		mnemonicBruteForce.bruteForceMnemonicPhrase(mnemonicGenerator.getWords());;
		
		System.out.println();

	}

}
