package net.time4j.g1;

import net.time4j.engine.x;

/* loaded from: classes3.dex */
public enum e implements x {

    FULL(false),
    LONG(true),
    MEDIUM(2),
    SHORT(3);

    private final transient int style;
    public static net.time4j.g1.e ofStyle(int i) {
        int i2;
        net.time4j.g1.e eVar;
        int styleValue;
        net.time4j.g1.e[] eNUMS = e.ENUMS;
        i2 = 0;
        while (i2 < eNUMS.length) {
            eVar = eNUMS[i2];
            i2++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown format style: ");
        stringBuilder.append(i);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.toString());
        throw unsupportedOperationException;
    }

    @Override // java.lang.Enum
    public int getStyleValue() {
        return this.style;
    }
}
