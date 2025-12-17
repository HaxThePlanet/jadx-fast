package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface w {

    public static final class a {

        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public a(int i, int i2, int i3, int i4) {
            super();
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public boolean a(int i) {
            int i3;
            int i2;
            int obj4;
            i3 = 0;
            final int i4 = 1;
            if (i == i4) {
                if (obj4 -= i2 > i4) {
                    i3 = i4;
                }
            } else {
                if (obj4 -= i2 > i4) {
                }
            }
            return i3;
        }
    }

    public static final class b {

        public final int a;
        public final long b;
        public b(int i, long l2) {
            int i2;
            super();
            i2 = Long.compare(l2, i3) >= 0 ? 1 : 0;
            g.a(i2);
            this.a = i;
            this.b = l2;
        }
    }

    public static final class c {

        public final IOException a;
        public final int b;
        public c(s s, v v2, IOException iOException3, int i4) {
            super();
            this.a = iOException3;
            this.b = i4;
        }
    }
    public abstract long a(com.google.android.exoplayer2.upstream.w.c w$c);

    public abstract com.google.android.exoplayer2.upstream.w.b b(com.google.android.exoplayer2.upstream.w.a w$a, com.google.android.exoplayer2.upstream.w.c w$c2);

    public void c(long l) {
    }

    public abstract int d(int i);
}
