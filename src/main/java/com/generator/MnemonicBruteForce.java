package com.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

public class MnemonicBruteForce {
	

	private int loop = 0;
	private int fileName = 0;
	private List<String> mnemonicPhfase = new ArrayList<String>();
	private boolean convertInPrivateKey;
	
	public MnemonicBruteForce(boolean convertToPrivateKey) {
		setConvertInPrivateKey(convertToPrivateKey);
	}	

	public boolean isConvertInPrivateKey() {
		return this.convertInPrivateKey;
	}

	private void setConvertInPrivateKey(boolean convertInPrivateKey) {
		this.convertInPrivateKey = convertInPrivateKey;
	}

	public void bruteForceMnemonicPhrase(List<String> mnemonicPhrase) {
		Collections.sort(mnemonicPhrase);		
		changeListToArrayAndRun(mnemonicPhrase);
	}

	private void changeListToArrayAndRun(List<String> words) {
		String[] w = new String[words.size()];
		for (int i = 0; i < words.size(); i++) {
			w[i] = words.get(i);
		}
		
		permutationsMnemonicWords(w, 0);
	}

	private void permutationsMnemonicWords(String[] arr, int index){
	    if(index >= arr.length - 1){ 
	    	StringBuilder stringBuilder = new StringBuilder();
	        for(int i = 0; i < arr.length - 1; i++){
	            stringBuilder.append(arr[i] + " ");
	        }
	        if(arr.length > 0) {
	            stringBuilder.append(arr[arr.length - 1]);
	        }	        

	        this.mnemonicPhfase.add(stringBuilder.toString());
	        
			if (convertInPrivateKey) {
				Credentials credentials = WalletUtils.loadBip39Credentials(null, stringBuilder.toString());
				System.out.println(credentials.getEcKeyPair().getPrivateKey());
			} else {
				//byte[] seed = MnemonicCode.toSeed(Arrays.asList(stringBuilder.toString().split(" ")), "");	        
		        //System.out.println(ConvertByteArrayToHexString.convert(seed));
				System.out.println(stringBuilder.toString());
			}
			
	        
	        if (this.loop == 1_048_575) {
		        //AddressFileWriter.writeFile(mnemonicPhfase, "/home/ivanov/Desktop/mnemonic/" + fileName + ".txt");

	        	this.mnemonicPhfase = null;
	        	this.mnemonicPhfase = new ArrayList<String>();
	        	this.fileName++;
	        	this.loop = 0;
	        }
	        
	        this.loop++;
	        
	        return;
	    }

	    for(int i = index; i < arr.length; i++){ 
	        //Swap the elements at indices index and i
	        String t = arr[index];
	        arr[index] = arr[i];
	        arr[i] = t;

	        //Recurse on the sub array arr[index+1...end]
	        permutationsMnemonicWords(arr, index+1);

	        //Swap the elements back
	        t = arr[index];
	        arr[index] = arr[i];
	        arr[i] = t;
	    }
	}
	
}
