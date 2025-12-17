package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes.dex */
public final class u1 {

    public static final com.google.android.exoplayer2.u1 d;
    public final float a;
    public final float b;
    private final int c;
    static {
        u1 u1Var = new u1(1065353216);
        u1.d = u1Var;
        com.google.android.exoplayer2.i0 i0Var = i0.a;
    }

    public u1(float f) {
        super(f, 1065353216);
    }

    public u1(float f, float f2) {
        int i;
        int i2;
        super();
        int i3 = 0;
        final int i4 = 0;
        i = Float.compare(f, i3) > 0 ? i2 : i4;
        g.a(i);
        if (Float.compare(f2, i3) > 0) {
        } else {
            i2 = i4;
        }
        g.a(i2);
        this.a = f;
        this.b = f2;
        this.c = Math.round(f *= obj6);
    }

    public long a(long l) {
        return l *= l2;
    }

    public com.google.android.exoplayer2.u1 b(float f) {
        u1 u1Var = new u1(f, this.b);
        return u1Var;
    }

    public boolean equals(Object object) {
        int i;
        float cmp;
        Class<com.google.android.exoplayer2.u1> obj;
        Class class;
        int obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (u1.class != object.getClass()) {
            } else {
                if (Float.compare(f, f2) == 0 && Float.compare(cmp, obj5) == 0) {
                    if (Float.compare(cmp, obj5) == 0) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        return i3 += floatToRawIntBits2;
    }

    public String toString() {
        Object[] arr = new Object[2];
        return p0.z("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.a), Float.valueOf(this.b));
    }
}
