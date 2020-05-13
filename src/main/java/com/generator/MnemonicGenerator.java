package com.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class MnemonicGenerator {
	public static final Logger LOG = Logger.getLogger(MnemonicGenerator.class.getName());
		
	private EntropyGenerator entropy;
	private List<String> mnemonicWords;
	
	public EntropyGenerator getEntropy() {
		return this.entropy;
	}
	
	private void setEntropy(EntropyGenerator entropy) {
		this.entropy = entropy;
	}
	
	public List<String> getWords() {
		return this.mnemonicWords;
	}
	
	private void setWords(List<String> words) {
		this.mnemonicWords = words;
	}

	public MnemonicGenerator(int entropyWords, String wordsFile) {
		this.setEntropy(new EntropyGenerator(entropyWords));
		this.setWords(this.getWordsFromFile(wordsFile));
	}

	private List<String> getWordsFromFile(String pathWordsFile) {
		Scanner scanner;
		String[] file = new String[2048];
		try {
			scanner = new Scanner(new File(pathWordsFile));
			int loop = 0;
			while (scanner.hasNextLine()) {
				file[loop] = scanner.nextLine();
				loop++;
			}
			LOG.info("Get all words from file!");
		} catch (FileNotFoundException e) {
			LOG.info(e.getMessage());
		}
		
		List<String> result = new ArrayList();
		
		for (String string : entropy.getEntropy()) {
			result.add(file[Integer.parseInt(string, 2)]);
		}			
		
		LOG.info("Mnemonic phrase is generated!");
		
		return result;
	}
	
	
}
