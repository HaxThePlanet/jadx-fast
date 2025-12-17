package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.g;

/* loaded from: classes.dex */
public final class d2 {

    public static final com.google.android.exoplayer2.d2 c;
    public static final com.google.android.exoplayer2.d2 d;
    public final long a;
    public final long b;
    static {
        final int i = 0;
        d2 d2Var = new d2(i, obj2, i, obj2);
        d2.c = d2Var;
        final long l = Long.MAX_VALUE;
        d2 d2Var2 = new d2(l, obj5, l, obj5);
        d2 d2Var3 = new d2(l, obj5, i, obj2);
        d2 d2Var4 = new d2(i, obj2, l, obj5);
        d2.d = d2Var;
    }

    public d2(long l, long l2) {
        int i2;
        int i;
        super();
        int i3 = 0;
        final int i4 = 0;
        i2 = Long.compare(l, i3) >= 0 ? i : i4;
        g.a(i2);
        if (Long.compare(obj8, i3) >= 0) {
        } else {
            i = i4;
        }
        g.a(i);
        this.a = l;
        this.b = obj8;
    }

    public boolean equals(Object object) {
        int i;
        long cmp;
        Class<com.google.android.exoplayer2.d2> obj;
        Class class;
        long l;
        int obj7;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (d2.class != object.getClass()) {
            } else {
                if (Long.compare(l2, l) == 0 && Long.compare(cmp, l) == 0) {
                    if (Long.compare(cmp, l) == 0) {
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
        return i2 += i4;
    }
}
