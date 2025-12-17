package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.decoder.b;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes2.dex */
class d0 {

    private final f a;
    private final int b;
    private final d0 c;
    private com.google.android.exoplayer2.source.d0.a d;
    private com.google.android.exoplayer2.source.d0.a e;
    private com.google.android.exoplayer2.source.d0.a f;
    private long g;

    private static final class a {

        public final long a;
        public final long b;
        public boolean c;
        public e d;
        public com.google.android.exoplayer2.source.d0.a e;
        public a(long l, int i2) {
            super();
            this.a = l;
            this.b = l += l2;
        }

        public com.google.android.exoplayer2.source.d0.a a() {
            final int i = 0;
            this.d = i;
            this.e = i;
            return this.e;
        }

        public void b(e e, com.google.android.exoplayer2.source.d0.a d0$a2) {
            this.d = e;
            this.e = a2;
            this.c = true;
        }

        public int c(long l) {
            return obj3 += obj4;
        }
    }
    public d0(f f) {
        super();
        this.a = f;
        final int obj4 = f.e();
        this.b = obj4;
        d0 d0Var = new d0(32);
        this.c = d0Var;
        d0.a aVar = new d0.a(0, obj2, obj4);
        this.d = aVar;
        this.e = aVar;
        this.f = aVar;
    }

    private void a(com.google.android.exoplayer2.source.d0.a d0$a) {
        int i;
        e eVar;
        Object obj7;
        if (!a.c) {
        }
        com.google.android.exoplayer2.source.d0.a aVar = this.f;
        z2 += i3;
        e[] arr = new e[i4];
        i = 0;
        while (i < i4) {
            arr[i] = obj7.d;
            obj7 = obj7.a();
            i++;
        }
        this.a.d(arr);
    }

    private static com.google.android.exoplayer2.source.d0.a d(com.google.android.exoplayer2.source.d0.a d0$a, long l2) {
        while (Long.compare(l2, l) >= 0) {
            final com.google.android.exoplayer2.source.d0.a obj2 = a.e;
        }
        return a;
    }

    private void g(int i) {
        com.google.android.exoplayer2.source.d0.a obj5;
        l += l2;
        this.g = i2;
        obj5 = this.f;
        if (Long.compare(i2, l3) == 0) {
            this.f = obj5.e;
        }
    }

    private int h(int i) {
        boolean z;
        com.google.android.exoplayer2.source.d0.a aVar;
        long l;
        int i2;
        com.google.android.exoplayer2.source.d0.a aVar2 = this.f;
        if (!aVar2.c) {
            aVar = new d0.a(aVar4.b, obj4, this.b);
            aVar2.b(this.a.b(), aVar);
        }
        return Math.min(i, (int)i3);
    }

    private static com.google.android.exoplayer2.source.d0.a i(com.google.android.exoplayer2.source.d0.a d0$a, long l2, ByteBuffer byteBuffer3, int i4) {
        int cmp;
        byte[] bArr;
        int i;
        com.google.android.exoplayer2.source.d0.a obj3;
        com.google.android.exoplayer2.source.d0.a obj4;
        int obj7;
        obj3 = d0.d(a, l2);
        while (obj7 > 0) {
            int i5 = Math.min(obj7, (int)i2);
            i4.put(eVar.a, obj3.c(obj4), i5);
            obj7 -= i5;
            if (Long.compare(obj4, l4) == 0) {
            }
            obj3 = obj3.e;
        }
        return obj3;
    }

    private static com.google.android.exoplayer2.source.d0.a j(com.google.android.exoplayer2.source.d0.a d0$a, long l2, byte[] b3Arr3, int i4) {
        int i2;
        int cmp;
        byte[] bArr;
        int i;
        int i3;
        com.google.android.exoplayer2.source.d0.a obj5;
        com.google.android.exoplayer2.source.d0.a obj6;
        obj5 = d0.d(a, l2);
        i2 = obj9;
        while (i2 > 0) {
            int i7 = Math.min(i2, (int)i5);
            System.arraycopy(eVar.a, obj5.c(obj6), i4, obj9 - i2, i7);
            i2 -= i7;
            if (Long.compare(obj6, l4) == 0) {
            }
            obj5 = obj5.e;
        }
        return obj5;
    }

    private static com.google.android.exoplayer2.source.d0.a k(com.google.android.exoplayer2.source.d0.a d0$a, DecoderInputBuffer decoderInputBuffer2, com.google.android.exoplayer2.source.e0.b e0$b3, d0 d04) {
        int i7;
        int i8;
        int i3;
        int[] iArr;
        int[] iArr2;
        int i6;
        com.google.android.exoplayer2.source.d0.a aVar;
        int length;
        int i4;
        int i5;
        byte[] bArr;
        long i;
        long i2;
        final Object obj = b3;
        i7 = d04;
        long l = obj.b;
        i3 = 1;
        i7.E(i3);
        l += i19;
        i4 = 0;
        byte b = d04.d()[i4];
        i5 = b & 128 != 0 ? i3 : i4;
        b &= 127;
        b bVar = obj3.b;
        bArr = bVar.a;
        if (bArr == null) {
            bVar.a = new byte[16];
        } else {
            Arrays.fill(bArr, i4);
        }
        i12 += i;
        if (i5 != 0) {
            int i16 = 2;
            i7.E(i16);
            aVar = d0.j(d0.j(d0.j(a, l, obj3, d04.d()), i12, obj3, bVar.a), i8, obj3, d04.d());
            i8 += i;
            i3 = d04.D();
        }
        int i22 = i3;
        iArr = bVar.d;
        if (iArr != null) {
            if (iArr.length < i22) {
                iArr = new int[i22];
            }
        } else {
        }
        final int[] iArr3 = iArr;
        iArr2 = bVar.e;
        if (iArr2 != null) {
            if (iArr2.length < i22) {
                iArr2 = new int[i22];
            }
        } else {
        }
        final int[] iArr4 = iArr2;
        if (i5 != 0) {
            i6 = i22 * 6;
            i7.E(i6);
            aVar = d0.j(aVar, i8, obj3, d04.d());
            i8 += i2;
            i7.I(i4);
            while (i4 < i22) {
                iArr3[i4] = d04.D();
                iArr4[i4] = d04.B();
                i4++;
            }
        } else {
            iArr3[i4] = i4;
            iArr4[i4] = i9 -= i6;
        }
        com.google.android.exoplayer2.l2.s.a aVar2 = obj.c;
        p0.i(aVar2);
        bVar.c(i22, iArr3, iArr4, aVar2.b, bVar.a, aVar2.a, aVar2.c, aVar2.d);
        long l3 = obj.b;
        int i11 = (int)i13;
        obj.b = l3 += l2;
        obj.a = i14 -= i11;
        return aVar;
    }

    private static com.google.android.exoplayer2.source.d0.a l(com.google.android.exoplayer2.source.d0.a d0$a, DecoderInputBuffer decoderInputBuffer2, com.google.android.exoplayer2.source.e0.b e0$b3, d0 d04) {
        long l;
        int i;
        long l2;
        int i2;
        com.google.android.exoplayer2.source.d0.a obj5;
        ByteBuffer obj6;
        int obj7;
        int obj8;
        if (decoderInputBuffer2.v()) {
            obj5 = d0.k(a, decoderInputBuffer2, b3, d04);
        }
        if (decoderInputBuffer2.n()) {
            int i3 = 4;
            d04.E(i3);
            obj8 = d04.B();
            b3.b = l6 += i2;
            i8 -= i3;
            b3.a = i;
            decoderInputBuffer2.t(obj8);
            b3.b = l4 += l2;
            i5 -= obj8;
            b3.a = i6;
            decoderInputBuffer2.x(i6);
            obj5 = d0.i(d0.i(d0.j(obj5, b3.b, obj2, d04.d()), b3.b, i, decoderInputBuffer2.c), b3.b, i, decoderInputBuffer2.x);
        } else {
            decoderInputBuffer2.t(b3.a);
            obj5 = d0.i(obj5, b3.b, obj1, decoderInputBuffer2.c);
        }
        return obj5;
    }

    public void b(long l) {
        int cmp;
        f fVar;
        if (Long.compare(l, i) == 0) {
        }
        com.google.android.exoplayer2.source.d0.a aVar = this.d;
        while (Long.compare(l, l2) >= 0) {
            this.a.a(aVar.d);
            this.d = this.d.a();
            aVar = this.d;
        }
        if (Long.compare(obj4, l3) < 0) {
            this.e = aVar;
        }
    }

    public void c(long l) {
        long l2;
        int cmp;
        long cmp2;
        long l3;
        com.google.android.exoplayer2.source.d0.a obj6;
        int obj7;
        this.g = l;
        if (Long.compare(l, i) != 0) {
            if (Long.compare(l, cmp2) == 0) {
                a(this.d);
                obj6 = new d0.a(this.g, cmp2, this.b);
                this.d = obj6;
                this.e = obj6;
                this.f = obj6;
            }
        } else {
        }
    }

    public long e() {
        return this.g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, com.google.android.exoplayer2.source.e0.b e0$b2) {
        d0.l(this.e, decoderInputBuffer, b2, this.c);
    }

    public void m(DecoderInputBuffer decoderInputBuffer, com.google.android.exoplayer2.source.e0.b e0$b2) {
        this.e = d0.l(this.e, decoderInputBuffer, b2, this.c);
    }

    public void n() {
        a(this.d);
        final int i2 = 0;
        d0.a aVar2 = new d0.a(i2, obj3, this.b);
        this.d = aVar2;
        this.e = aVar2;
        this.f = aVar2;
        this.g = i2;
        this.a.c();
    }

    public void o() {
        this.e = this.d;
    }

    public int p(i i, int i2, boolean z3) {
        com.google.android.exoplayer2.source.d0.a aVar = this.f;
        int obj5 = i.read(eVar.a, aVar.c(this.g), h(i2));
        int obj6 = -1;
        if (obj5 == obj6) {
            if (!z3) {
            } else {
                return obj6;
            }
            obj5 = new EOFException();
            throw obj5;
        }
        g(obj5);
        return obj5;
    }

    public void q(d0 d0, int i2) {
        while (i2 > 0) {
            final int i = h(i2);
            com.google.android.exoplayer2.source.d0.a aVar = this.f;
            d0.j(eVar.a, aVar.c(this.g), i);
            i2 -= i;
            g(i);
        }
    }
}
