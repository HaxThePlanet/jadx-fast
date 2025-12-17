package com.google.android.exoplayer2.l2.u;

import com.google.android.exoplayer2.util.d0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
abstract class c {

    public final int a;

    static final class a extends com.google.android.exoplayer2.l2.u.c {

        public final long b;
        public final List<com.google.android.exoplayer2.l2.u.c.b> c;
        public final List<com.google.android.exoplayer2.l2.u.c.a> d;
        public a(int i, long l2) {
            super(i);
            this.b = l2;
            ArrayList obj1 = new ArrayList();
            this.c = obj1;
            obj1 = new ArrayList();
            this.d = obj1;
        }

        @Override // com.google.android.exoplayer2.l2.u.c
        public void d(com.google.android.exoplayer2.l2.u.c.a c$a) {
            this.d.add(a);
        }

        @Override // com.google.android.exoplayer2.l2.u.c
        public void e(com.google.android.exoplayer2.l2.u.c.b c$b) {
            this.c.add(b);
        }

        @Override // com.google.android.exoplayer2.l2.u.c
        public com.google.android.exoplayer2.l2.u.c.a f(int i) {
            int i2;
            Object obj;
            int i3;
            i2 = 0;
            while (i2 < this.d.size()) {
                obj = this.d.get(i2);
                i2++;
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.l2.u.c
        public com.google.android.exoplayer2.l2.u.c.b g(int i) {
            int i2;
            Object obj;
            int i3;
            i2 = 0;
            while (i2 < this.c.size()) {
                obj = this.c.get(i2);
                i2++;
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.l2.u.c
        public String toString() {
            String str = c.a(this.a);
            String string2 = Arrays.toString(this.c.toArray());
            String string3 = Arrays.toString(this.d.toArray());
            StringBuilder stringBuilder = new StringBuilder(i3 += length3);
            stringBuilder.append(str);
            stringBuilder.append(" leaves: ");
            stringBuilder.append(string2);
            stringBuilder.append(" containers: ");
            stringBuilder.append(string3);
            return stringBuilder.toString();
        }
    }

    static final class b extends com.google.android.exoplayer2.l2.u.c {

        public final d0 b;
        public b(int i, d0 d02) {
            super(i);
            this.b = d02;
        }
    }
    public c(int i) {
        super();
        this.a = i;
    }

    public static String a(int i) {
        StringBuilder stringBuilder = new StringBuilder(4);
        stringBuilder.append((char)i3);
        stringBuilder.append((char)i5);
        stringBuilder.append((char)i7);
        stringBuilder.append((char)obj5);
        return stringBuilder.toString();
    }

    public static int b(int i) {
        return i &= i2;
    }

    public static int c(int i) {
        return obj0 &= 255;
    }

    public String toString() {
        return c.a(this.a);
    }
}
