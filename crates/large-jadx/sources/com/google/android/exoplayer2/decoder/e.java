package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.util.g;

/* loaded from: classes2.dex */
public final class e {

    public final String a;
    public final i1 b;
    public final i1 c;
    public final int d;
    public final int e;
    public e(String string, i1 i12, i1 i13, int i4, int i5) {
        int i;
        super();
        if (i4 != 0) {
            if (i5 == 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        g.a(i);
        g.d(string);
        this.a = string;
        g.e(i12);
        this.b = (i1)i12;
        g.e(i13);
        this.c = (i1)i13;
        this.d = i4;
        this.e = i5;
    }

    public boolean equals(Object object) {
        int i2;
        int equals;
        Class<com.google.android.exoplayer2.decoder.e> obj;
        int i;
        Class class;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i3 = 0;
        if (object != null) {
            if (e.class != object.getClass()) {
            } else {
                if (this.d == object.d && this.e == object.e && this.a.equals(object.a) && this.b.equals(object.b) && this.c.equals(object.c)) {
                    if (this.e == object.e) {
                        if (this.a.equals(object.a)) {
                            if (this.b.equals(object.b)) {
                                if (this.c.equals(object.c)) {
                                } else {
                                    i2 = i3;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
            return i2;
        }
        return i3;
    }

    public int hashCode() {
        return i14 += i5;
    }
}
