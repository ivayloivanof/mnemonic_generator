package com.generator;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.logging.Logger;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.hash.ConvertByteToBinary;
import com.hash.Hash;

public class EntropyGenerator {
	public static final Logger LOG = Logger.getLogger(EntropyGenerator.class.getName());

	private String[] entropy;

	public String[] getEntropy() {
		return this.entropy;
	}

	private void setEntropy(String[] entropy) {
		this.entropy = entropy;
	}

	public EntropyGenerator(int entropyWords) {
		this.setEntropy(choseEntropy(entropyWords));		
	}

	private String[] choseEntropy(int entropyWords) {
		
		long random = new SecureRandom().nextLong();
		byte[] b = Hash.covertSHA_256(random + "");
		
		StringBuilder stringBuilder = new StringBuilder();
		
		if (entropyWords == 5) {			
			b = Arrays.copyOf(b, 20);		//160 bits
		} else if (entropyWords == 6) {		
			b = Arrays.copyOf(b, 24);		//192 bits
		} else if (entropyWords == 7) {		
			b = Arrays.copyOf(b, 28);		//224 bits
		} else if (entropyWords == 8) {		
			b = b;							//256 bits
		} else {
			b = Arrays.copyOf(b, 16);		//128 bits
		}
		
		for (byte c : b) {
			stringBuilder.append(ConvertByteToBinary.convert(c));
		}
		
		String str = ConvertByteToBinary.convert(b[0]);
		String[] spl = str.split("");
		
		for(int l = 0; l< entropyWords; l++) {
			stringBuilder.append(spl[l]);
		}				

		Iterable<String> result = Splitter.fixedLength(11).split(stringBuilder.toString());
		return Iterables.toArray(result, String.class);		
	}	
	
}
