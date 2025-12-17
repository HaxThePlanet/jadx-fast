package com.google.android.exoplayer2;

/* loaded from: classes.dex */
public final class b2 {

    public static final com.google.android.exoplayer2.b2 b;
    public final boolean a;
    static {
        b2 b2Var = new b2(0);
        b2.b = b2Var;
    }

    public b2(boolean z) {
        super();
        this.a = z;
    }

    public boolean equals(Object object) {
        int i;
        Class<com.google.android.exoplayer2.b2> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (b2.class != object.getClass()) {
            } else {
                if (this.a == object.a) {
                } else {
                    i = i2;
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        return z ^= 1;
    }
}
