package net.time4j.g1;

import net.time4j.engine.x;

/* compiled from: DisplayMode.java */
/* loaded from: classes3.dex */
public enum e implements x {

    FULL,
    LONG,
    MEDIUM,
    SHORT;

    private final transient int style;
    public static e ofStyle(int i) {
        int i2 = 0;
        net.time4j.g1.e[] eNUMS2 = e.ENUMS;
        i2 = 0;
        for (net.time4j.g1.e eVar : eNUMS2) {
            if (eVar.getStyleValue() == i) {
                return eVar;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = "Unknown format style: ";
        i = str + i;
        throw new UnsupportedOperationException(i);
    }

    @Override // java.lang.Enum
    public int getStyleValue() {
        return this.style;
    }
}
