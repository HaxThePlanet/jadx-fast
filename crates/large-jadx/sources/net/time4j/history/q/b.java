package net.time4j.history.q;

/* compiled from: HistoricVariant.java */
/* loaded from: classes3.dex */
public enum b {

    INTRODUCTION_ON_1582_10_15,
    PROLEPTIC_BYZANTINE,
    PROLEPTIC_GREGORIAN,
    PROLEPTIC_JULIAN,
    SINGLE_CUTOVER_DATE,
    SWEDEN;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[b.values().length];
            b.a.a = iArr;
            try {
                iArr[b.PROLEPTIC_JULIAN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                b.a.a[b.PROLEPTIC_GREGORIAN.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                b.a.a[b.SWEDEN.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                b.a.a[b.INTRODUCTION_ON_1582_10_15.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                b.a.a[b.PROLEPTIC_BYZANTINE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    @Override // java.lang.Enum
    public int getSerialValue() {
        int i = b.a.a[ordinal()];
        int i4 = 2;
        int i7 = 1;
        if (b.a.a != i7 && b.a.a != i4) {
            int i5 = 4;
            int i8 = 3;
            if (b.a.a != i8 && b.a.a != i5) {
                if (b.a.a != 5) {
                    return 0;
                }
                return i8;
            }
            return i5;
        }
        return i4;
    }
}
