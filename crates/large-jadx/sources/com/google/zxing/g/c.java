package com.google.zxing.g;

import com.google.zxing.FormatException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum c {

    Cp437(/* unknown */, field_4),
    ISO8859_1(field_4, "Cp437"),
    ISO8859_2(4, "Cp437"),
    ISO8859_3(5, "ISO8859_1"),
    ISO8859_4(6, "ISO8859_3"),
    ISO8859_5(7, 3),
    ISO8859_6(5, "ISO8859_5"),
    ISO8859_7(4, "ISO8859_6"),
    ISO8859_8(true, "ISO8859_6"),
    ISO8859_9(false, "ISO8859_6"),
    ISO8859_10(2, "ISO8859_6"),
    ISO8859_11(2, "ISO8859_6"),
    ISO8859_13(2, "ISO8859_6"),
    ISO8859_14(2, 4),
    ISO8859_15(false, 4),
    ISO8859_16(false, 4),
    SJIS(false, 4),
    Cp1250(false, 4),
    Cp1251(false, 4),
    Cp1252(true, 4),
    Cp1256(true, 4),
    UnicodeBigUnmarked(true, 4),
    UTF8("ISO8859_6", true),
    ASCII(4, true),
    Big5(4),
    GB18030(2, false),
    EUC_KR(true, false);

    private final String[] otherEncodingNames;
    private final int[] values;
    public static com.google.zxing.g.c getCharacterSetECIByName(String string) {
        return (c)c.NAME_TO_ECI.get(string);
    }

    public static com.google.zxing.g.c getCharacterSetECIByValue(int i) {
        int i2;
        if (i < 0) {
        } else {
            if (i >= 900) {
            } else {
                return (c)c.VALUE_TO_ECI.get(Integer.valueOf(i));
            }
        }
        throw FormatException.a();
    }

    @Override // java.lang.Enum
    public int getValue() {
        return this.values[0];
    }
}
