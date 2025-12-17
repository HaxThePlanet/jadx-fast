package com.google.android.exoplayer2.l2;

import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.d0;
import java.util.Arrays;

/* loaded from: classes2.dex */
public interface s {

    public static final class a {

        public final int a;
        public final byte[] b;
        public final int c;
        public final int d;
        public a(int i, byte[] b2Arr2, int i3, int i4) {
            super();
            this.a = i;
            this.b = b2Arr2;
            this.c = i3;
            this.d = i4;
        }

        public boolean equals(Object object) {
            int i2;
            int i;
            Class<com.google.android.exoplayer2.l2.s.a> obj;
            int i3;
            Class class;
            Object obj5;
            if (this == object) {
                return 1;
            }
            final int i4 = 0;
            if (object != null) {
                if (s.a.class != object.getClass()) {
                } else {
                    if (this.a == object.a && this.c == object.c && this.d == object.d && Arrays.equals(this.b, object.b)) {
                        if (this.c == object.c) {
                            if (this.d == object.d) {
                                if (Arrays.equals(this.b, object.b)) {
                                } else {
                                    i2 = i4;
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
            return i4;
        }

        public int hashCode() {
            return i6 += i10;
        }
    }
    public abstract int a(i i, int i2, boolean z3, int i4);

    public int b(i i, int i2, boolean z3) {
        return a(i, i2, z3, 0);
    }

    public void c(d0 d0, int i2) {
        f(d0, i2, 0);
    }

    public abstract void d(long l, int i2, int i3, int i4, com.google.android.exoplayer2.l2.s.a s$a5);

    public abstract void e(i1 i1);

    public abstract void f(d0 d0, int i2, int i3);
}
