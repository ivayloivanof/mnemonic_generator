package com.hash;

public class ConvertByteToBinary {

    public static String convert(byte b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; --i) {
            sb.append(b >>> i & 1);
        }

        return sb.toString();
    }
}
