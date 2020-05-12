package com.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;


public class Hash256 {
	public static final Logger LOG = Logger.getLogger(Hash256.class.getName());

    public static byte[] covert(String str) {
        byte[] hash = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            hash = md.digest(str.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            LOG.info(e.getMessage());
        }

        return hash;
    }
}
