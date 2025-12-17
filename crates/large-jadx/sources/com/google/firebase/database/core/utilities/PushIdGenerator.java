package com.google.firebase.database.core.utilities;

import java.util.Random;

/* loaded from: classes2.dex */
public class PushIdGenerator {

    private static final int MAX_KEY_LEN = 786;
    private static final char MAX_PUSH_CHAR = 'z';
    private static final char MIN_PUSH_CHAR = '-';
    private static final String PUSH_CHARS = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz";
    private static long lastPushTime;
    private static final int[] lastRandChars;
    private static final Random randGen;
    static {
        Random random = new Random();
        PushIdGenerator.randGen = random;
        PushIdGenerator.lastPushTime = 0;
        PushIdGenerator.lastRandChars = new int[12];
    }

    public static String generatePushChildName(long l) {
        int lastRandChars;
        int i;
        char[] nextInt;
        int i3;
        int i4;
        char charAt;
        int i5;
        int i2;
        long obj13;
        int obj14;
        final Class<com.google.firebase.database.core.utilities.PushIdGenerator> obj = PushIdGenerator.class;
        i = 1;
        final int i6 = 0;
        synchronized (obj) {
            lastRandChars = i;
            try {
                PushIdGenerator.lastPushTime = l;
                nextInt = new char[8];
                final int i8 = 20;
                StringBuilder stringBuilder = new StringBuilder(i8);
                i3 = 7;
                while (i3 >= 0) {
                    i5 = 64;
                    nextInt[i3] = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt((int)i9);
                    obj13 /= i5;
                    i3--;
                }
                i5 = 64;
                nextInt[i3] = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt((int)i9);
                obj13 /= i5;
                i3--;
                if (Long.compare(obj13, i4) == 0) {
                } else {
                }
                obj13 = i;
                obj13 = i6;
                Utilities.hardAssert(obj13);
                stringBuilder.append(nextInt);
                obj13 = 12;
                if (lastRandChars == 0) {
                } else {
                }
                obj14 = i6;
                while (obj14 < obj13) {
                    PushIdGenerator.lastRandChars[obj14] = PushIdGenerator.randGen.nextInt(64);
                    obj14++;
                }
                PushIdGenerator.lastRandChars[obj14] = PushIdGenerator.randGen.nextInt(64);
                obj14++;
                PushIdGenerator.incrementArray();
                obj14 = i6;
                while (obj14 < obj13) {
                    stringBuilder.append("-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt(PushIdGenerator.lastRandChars[obj14]));
                    obj14++;
                }
                stringBuilder.append("-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt(PushIdGenerator.lastRandChars[obj14]));
                obj14++;
                if (stringBuilder.length() == i8) {
                } else {
                }
                i = i6;
                Utilities.hardAssert(i);
                return stringBuilder.toString();
                throw l;
            }
        }
    }

    private static void incrementArray() {
        int i;
        int[] lastRandChars;
        int i3;
        int i2;
        i = 11;
        while (i >= 0) {
            lastRandChars = PushIdGenerator.lastRandChars;
            lastRandChars[i] = 0;
            i--;
        }
    }

    public static final String predecessor(String string) {
        Validation.validateNullableKey(string);
        Integer tryParseInt = Utilities.tryParseInt(string);
        int i = 1;
        if (tryParseInt != null && tryParseInt.intValue() == Integer.MIN_VALUE) {
            if (tryParseInt.intValue() == Integer.MIN_VALUE) {
                return "[MIN_NAME]";
            }
            return String.valueOf(obj4 -= i);
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        if (stringBuilder.charAt(obj4 -= i) == 45 && stringBuilder.length() == i) {
            if (stringBuilder.length() == i) {
                return String.valueOf(Integer.MAX_VALUE);
            }
            return stringBuilder.substring(0, length2 -= i);
        }
        final String str3 = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz";
        stringBuilder.setCharAt(obj4 -= i, str3.charAt(indexOf -= i));
        String obj4 = new String(new char[length - 786]);
        stringBuilder.append(obj4.replace("\u0000", "z"));
        return stringBuilder.toString();
    }

    public static final String successor(String string) {
        int charAt;
        int i;
        int obj3;
        Validation.validateNullableKey(string);
        Integer tryParseInt = Utilities.tryParseInt(string);
        charAt = 45;
        if (tryParseInt != null && tryParseInt.intValue() == Integer.MAX_VALUE) {
            if (tryParseInt.intValue() == Integer.MAX_VALUE) {
                return String.valueOf(charAt);
            }
            return String.valueOf(obj3++);
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        if (stringBuilder.length() < 786) {
            stringBuilder.append(charAt);
            return stringBuilder.toString();
        }
        obj3--;
        while (obj3 >= 0) {
            if (stringBuilder.charAt(obj3) == 122) {
            }
            obj3--;
        }
        if (obj3 == -1) {
            return "[MAX_KEY]";
        }
        String str = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz";
        int i5 = obj3 + 1;
        stringBuilder.replace(obj3, i5, String.valueOf(str.charAt(indexOf++)));
        return stringBuilder.substring(0, i5);
    }
}
