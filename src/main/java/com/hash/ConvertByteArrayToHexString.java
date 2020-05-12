package com.hash;

import org.bouncycastle.util.encoders.Hex;

public class ConvertByteArrayToHexString {
    
    public static String convert(byte[] b) {            
        return Hex.toHexString(b);                    
    }
    
}
