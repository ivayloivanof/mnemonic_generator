package com.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.logging.Logger;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class Hash {
	public static final Logger LOG = Logger.getLogger(Hash.class.getName());

    public static byte[] covertSHA_256(String str) {
        byte[] hash = null;

        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            LOG.info(e.getMessage());
        }

        return hash;
    }
    
    public static byte[] covertSHA3_256(String str) {
        byte[] hash = null;

        try {
        	final MessageDigest digest = MessageDigest.getInstance("SHA3_256");
        	hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            LOG.info(e.getMessage());
        }

        return hash;
    }
    
    public static byte[] covertKeccak_256(String str) {
        byte[] hash = null;

        try {
        	Security.addProvider(new BouncyCastleProvider());
        	final MessageDigest digest = MessageDigest.getInstance("KECCAK_256");
        	hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            LOG.info(e.getMessage());
        }

        return hash;
    }
}
