package net.time4j.history.q;

/* loaded from: classes3.dex */
public enum b {

    PROLEPTIC_JULIAN,
    PROLEPTIC_GREGORIAN,
    SWEDEN,
    INTRODUCTION_ON_1582_10_15,
    SINGLE_CUTOVER_DATE,
    PROLEPTIC_BYZANTINE;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            b.a.a = iArr;
            iArr[b.PROLEPTIC_JULIAN.ordinal()] = 1;
            b.a.a[b.PROLEPTIC_GREGORIAN.ordinal()] = 2;
            b.a.a[b.SWEDEN.ordinal()] = 3;
            b.a.a[b.INTRODUCTION_ON_1582_10_15.ordinal()] = 4;
            b.a.a[b.PROLEPTIC_BYZANTINE.ordinal()] = 5;
        }
    }
    @Override // java.lang.Enum
    public int getSerialValue() {
        int i = b.a.a[ordinal()];
        int i4 = 2;
        int i7 = 1;
        int i5 = 4;
        int i8 = 3;
        if (i != i7 && i != i4 && i != i8 && i != i5 && i != 5) {
            if (i != i4) {
                i5 = 4;
                i8 = 3;
                if (i != i8) {
                    if (i != i5) {
                        if (i != 5) {
                            return 0;
                        }
                        return i8;
                    }
                    return 7;
                }
                return i5;
            }
            return i7;
        }
        return i4;
    }
}
