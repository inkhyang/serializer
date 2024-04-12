package com.inkhyang.serializer;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        boolean[] boolArray = new boolean[]{true, true, true, true, true, true, true};
        Boolean[] booleans = new Boolean[]{true, true, true, true, true, true, true};
        System.out.println(Serializer.boolConverter(boolArray));
        System.out.println(Arrays.toString(Serializer.byteConverter((byte) 127)));
        System.out.println();
        System.out.println(Serializer.boolConverter(booleans));
        System.out.println(Serializer.byteConverter(2186));
    }
}