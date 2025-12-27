package i.b.m0.j;

/* compiled from: Pow2.java */
/* loaded from: classes3.dex */
public final class q {
    public static int a(int i) {
        final int i2 = 1;
        return i2 << (Integer.numberOfLeadingZeros(i - i2)) - 32;
    }
}
