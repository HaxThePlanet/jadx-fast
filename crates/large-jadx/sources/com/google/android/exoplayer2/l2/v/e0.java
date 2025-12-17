package com.google.android.exoplayer2.l2.v;

import android.util.SparseArray;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public interface e0 {

    public static final class a {

        public final String a;
        public final byte[] b;
        public a(String string, int i2, byte[] b3Arr3) {
            super();
            this.a = string;
            this.b = b3Arr3;
        }
    }

    public static final class b {

        public final int a;
        public final String b;
        public final List<com.google.android.exoplayer2.l2.v.e0.a> c;
        public final byte[] d;
        public b(int i, String string2, List<com.google.android.exoplayer2.l2.v.e0.a> list3, byte[] b4Arr4) {
            List obj1;
            super();
            this.a = i;
            this.b = string2;
            if (list3 == null) {
                obj1 = Collections.emptyList();
            } else {
                obj1 = Collections.unmodifiableList(list3);
            }
            this.c = obj1;
            this.d = b4Arr4;
        }
    }

    public interface c {
        public abstract com.google.android.exoplayer2.l2.v.e0 a(int i, com.google.android.exoplayer2.l2.v.e0.b e0$b2);

        public abstract SparseArray<com.google.android.exoplayer2.l2.v.e0> b();
    }

    public static final class d {

        private final String a;
        private final int b;
        private final int c;
        private int d;
        private String e;
        public d(int i, int i2) {
            super(Integer.MIN_VALUE, i, i2);
        }

        public d(int i, int i2, int i3) {
            int i4;
            StringBuilder stringBuilder;
            String obj5;
            super();
            final String str = "";
            final int i5 = Integer.MIN_VALUE;
            if (i != i5) {
                stringBuilder = new StringBuilder(12);
                stringBuilder.append(i);
                stringBuilder.append("/");
                obj5 = stringBuilder.toString();
            } else {
                obj5 = str;
            }
            this.a = obj5;
            this.b = i2;
            this.c = i3;
            this.d = i5;
            this.e = str;
        }

        private void d() {
            if (this.d == Integer.MIN_VALUE) {
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException("generateNewId() must be called before retrieving ids.");
            throw illegalStateException;
        }

        public void a() {
            int i2;
            int i;
            int i3 = this.d;
            i2 = i3 == Integer.MIN_VALUE ? this.b : i3 + i;
            this.d = i2;
            String str = this.a;
            StringBuilder stringBuilder = new StringBuilder(length += 11);
            stringBuilder.append(str);
            stringBuilder.append(i2);
            this.e = stringBuilder.toString();
        }

        public String b() {
            d();
            return this.e;
        }

        public int c() {
            d();
            return this.d;
        }
    }
    public abstract void a(m0 m0, k k2, com.google.android.exoplayer2.l2.v.e0.d e0$d3);

    public abstract void b(d0 d0, int i2);

    public abstract void c();
}
