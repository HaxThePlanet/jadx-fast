package com.google.zxing.k.b;

/* loaded from: classes2.dex */
public enum b {

    TERMINATOR(/* unknown */, false),
    NUMERIC("TERMINATOR", true),
    ALPHANUMERIC("NUMERIC", 2),
    STRUCTURED_APPEND("ALPHANUMERIC", 3),
    BYTE("STRUCTURED_APPEND", 4),
    ECI("BYTE", 7),
    KANJI("ECI", 2),
    FNC1_FIRST_POSITION("KANJI", 5),
    FNC1_SECOND_POSITION("KANJI", 5),
    HANZI("KANJI", 3);

    private final int bits;
    private final int[] characterCountBitsForVersions;
    public static com.google.zxing.k.b.b forBits(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 7 && i != 8 && i != 9) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 7) {
                                    if (i != 8) {
                                        if (i != 9) {
                                            if (i != 13) {
                                            } else {
                                                return b.HANZI;
                                            }
                                            IllegalArgumentException obj1 = new IllegalArgumentException();
                                            throw obj1;
                                        }
                                        return b.FNC1_SECOND_POSITION;
                                    }
                                    return b.KANJI;
                                }
                                return b.ECI;
                            }
                            return b.FNC1_FIRST_POSITION;
                        }
                        return b.BYTE;
                    }
                    return b.STRUCTURED_APPEND;
                }
                return b.ALPHANUMERIC;
            }
            return b.NUMERIC;
        }
        return b.TERMINATOR;
    }

    @Override // java.lang.Enum
    public int getBits() {
        return this.bits;
    }

    @Override // java.lang.Enum
    public int getCharacterCountBits(com.google.zxing.k.b.c c) {
        int i;
        int obj2;
        obj2 = c.f();
        obj2 = obj2 <= 9 ? 0 : obj2 <= i ? 1 : 2;
        return this.characterCountBitsForVersions[obj2];
    }
}
