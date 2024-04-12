package com.inkhyang.serializer;

import java.util.Deque;
import java.util.LinkedList;

//UtilClass
public final class Serializer {
    private Serializer() {
    }

    private static boolean isValid(boolean[] boolArray) {
        return boolArray.length <= 7;
    }

    /*
     * byte = [8bit][true(1), false(0)] (-128 = 0 = 127)(256)
     * \\uses only positive values// = 2^7
     * byte = max 127 = 1111111 = 7*true
     * byte = min 0 = 0000000 = 7*false -->
     * --> 128 values
     */
    public static byte boolConverter(boolean[] boolArray) {
        byte b = 0;
        if (!isValid(boolArray)) return 0b11111111111111111111111111111111;
        byte i = (byte) (boolArray.length - 0b1);
        while (i >= 0) {
            if (!(boolArray[i])) {
                i--;
                continue;
            }
            b += (byte) Math.pow(2, boolArray.length - 1 - i);
            i--;
        }
        return b;
    }

    public static boolean[] byteConverter(byte value) {
        boolean[] boolArray = new boolean[7];
        byte i = (byte) (boolArray.length - 1);
        while (value > 0) {
            boolArray[i] = (value % 2 == 1);
            value /= 2;
            i--;
        }
        return boolArray;
    }

    /*
     * int = 4 byte = 32 bit -16 0 +15 bits
     * \\uses only positive values// =2^31
     * false(0) null(1) true(2)
     * 01 = 1
     * 02 = 2
     * 10 = 3
     */
    public static int boolConverter(Boolean[] boolArray) {
        int a = 0;
        for (int i = boolArray.length - 1; i >= 0; i--) {
            if (boolArray[i] == null) {
                a += (int) Math.pow(3, boolArray.length - 1 - i);
                continue;
            }
            if (!boolArray[i]) {
                continue;
            }
            a += 2 * (int) Math.pow(3, (boolArray.length - 1 - i));
        }
        return a;
    }

    public static Deque<Boolean> byteConverter(int value) {
        Deque<Boolean> boolArray = new LinkedList<>();
        while (value > 0) {
            if (value % 3 == 1) {
                boolArray.addFirst(null);
                value /= 3;
            } else if (value % 3 == 0) {
                boolArray.addFirst(false);
                value /= 3;
            } else {
                boolArray.addFirst(true);
                value /= 3;
            }
        }
        return boolArray;
    }
}
