package com.google.android.exoplayer2.l2;

/* loaded from: classes2.dex */
public final class r {

    public static final com.google.android.exoplayer2.l2.r c;
    public final long a;
    public final long b;
    static {
        final int i = 0;
        r rVar = new r(i, obj2, i, obj2);
        r.c = rVar;
    }

    public r(long l, long l2) {
        super();
        this.a = l;
        this.b = obj3;
    }

    public boolean equals(Object object) {
        int i;
        long cmp;
        Class<com.google.android.exoplayer2.l2.r> obj;
        Class class;
        long l;
        int obj7;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (r.class != object.getClass()) {
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(60);
        stringBuilder.append("[timeUs=");
        stringBuilder.append(this.a);
        stringBuilder.append(", position=");
        stringBuilder.append(this.b);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
