package com.google.zxing.f.b;

import com.google.zxing.g.a;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
final class f {

    static final com.google.zxing.f.b.f e;
    private final int a;
    private final com.google.zxing.f.b.g b;
    private final int c;
    private final int d;
    static {
        final int i = 0;
        f fVar = new f(g.b, i, i, i);
        f.e = fVar;
    }

    private f(com.google.zxing.f.b.g g, int i2, int i3, int i4) {
        super();
        this.b = g;
        this.a = i2;
        this.c = i3;
        this.d = i4;
    }

    com.google.zxing.f.b.f a(int i) {
        com.google.zxing.f.b.g gVar;
        int i4;
        int i2;
        int i5;
        int i3;
        com.google.zxing.f.b.f fVar;
        int obj7;
        i4 = this.a;
        int i11 = 0;
        if (i4 != 4) {
            if (i4 == 2) {
                int i8 = d.c[i4][i11];
                i8 >>= 16;
                gVar = this.b.a(i15 &= i8, i9);
                i2 += i9;
                i4 = i11;
            }
        } else {
        }
        int i12 = this.c;
        if (i12 != 0) {
            if (i12 == 31) {
                i3 = 18;
            } else {
                i3 = i12 == 62 ? 9 : 8;
            }
        } else {
        }
        fVar = new f(gVar, i4, i12++, i2 += i3);
        if (fVar.c == 2078) {
            fVar = fVar.b(i++);
        }
        return fVar;
    }

    com.google.zxing.f.b.f b(int i) {
        int i2 = this.c;
        if (i2 == 0) {
            return this;
        }
        f fVar = new f(this.b.b(i -= i2, i2), this.a, 0, this.d);
        return fVar;
    }

    int c() {
        return this.c;
    }

    int d() {
        return this.d;
    }

    int e() {
        return this.a;
    }

    boolean f(com.google.zxing.f.b.f f) {
        int i2;
        int i;
        int i6 = f.c;
        if (i6 > 0) {
            i = this.c;
            if (i != 0) {
                if (i > i6) {
                    i2 += 10;
                }
            } else {
            }
        }
        if (i2 <= f.d) {
            return 1;
        }
        return 0;
    }

    com.google.zxing.f.b.f g(int i, int i2) {
        int i6;
        com.google.zxing.f.b.g gVar;
        int i4;
        int i5;
        int i3;
        i4 = this.a;
        if (i != i4) {
            int i8 = d.c[i4][i];
            i8 >>= 16;
            gVar = this.b.a(i10 &= i8, i4);
            i6 += i4;
        }
        i5 = i == 2 ? 4 : 5;
        f fVar = new f(gVar.a(i2, i5), i, 0, i6 += i5);
        return fVar;
    }

    com.google.zxing.f.b.f h(int i, int i2) {
        int i3;
        int i5 = this.a;
        final int i7 = 5;
        i3 = i5 == 2 ? 4 : i7;
        f obj7 = new f(this.b.a(d.e[i5][i], i3).a(i2, i7), this.a, 0, i10 += i7);
        return obj7;
    }

    a i(byte[] bArr) {
        com.google.zxing.f.b.g gVar;
        Object next;
        LinkedList linkedList = new LinkedList();
        gVar = fVar.b;
        while (gVar != null) {
            linkedList.addFirst(gVar);
            gVar = gVar.d();
        }
        a aVar = new a();
        Iterator iterator = linkedList.iterator();
        for (g next : iterator) {
            next.c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        Object[] arr = new Object[3];
        return String.format("%s bits=%d bytes=%d", d.b[this.a], Integer.valueOf(this.d), Integer.valueOf(this.c));
    }
}
