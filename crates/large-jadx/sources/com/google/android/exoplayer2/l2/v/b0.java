package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.l2.b;
import com.google.android.exoplayer2.l2.b.b;
import com.google.android.exoplayer2.l2.b.e;
import com.google.android.exoplayer2.l2.b.f;
import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes2.dex */
final class b0 extends b {

    private static final class a implements b.f {

        private final m0 a;
        private final d0 b;
        private final int c;
        private final int d;
        public a(int i, m0 m02, int i3) {
            super();
            this.c = i;
            this.a = m02;
            this.d = i3;
            d0 obj1 = new d0();
            this.b = obj1;
        }

        private b.e c(d0 d0, long l2, long l3) {
            int i;
            long l4;
            int i2;
            long l;
            int i3;
            int i4;
            int cmp;
            final Object obj = this;
            d0 d0Var = d0;
            final long l5 = obj20;
            int i8 = d0.f();
            final long l7 = -9223372036854775807L;
            i2 = i;
            l = l7;
            while (d0.a() >= 188) {
                i3 = f0.a(d0.d(), d0.e(), i8);
                i4 = i3 + 188;
                l4 = f0.c(d0Var, i3, obj.c);
                d0Var.I(i4);
                i = (long)i4;
                l4 = obj.a.b(l4);
                i2 = (long)i3;
                l = l4;
            }
            if (Long.compare(l, l7) != 0) {
                return b.e.f(l, obj12);
            }
            return b.e.d;
        }

        @Override // com.google.android.exoplayer2.l2.b$f
        public void a() {
            this.b.F(p0.f);
        }

        @Override // com.google.android.exoplayer2.l2.b$f
        public b.e b(j j, long l2) {
            final long position = j.getPosition();
            int i2 = (int)l3;
            this.b.E(i2);
            j.m(this.b.d(), 0, i2);
            return this.c(this.b, l2, obj3);
        }
    }
    public b0(m0 m0, long l2, long l3, int i4, int i5) {
        b.b bVar = new b.b();
        final int i6 = obj23;
        b0.a aVar = new b0.a(obj22, m0, i6);
        super(bVar, aVar, l2, i6, 0, obj6, l2 + i2, obj8, 0, obj10, i4, obj12, 188, obj14, 940);
    }
}
