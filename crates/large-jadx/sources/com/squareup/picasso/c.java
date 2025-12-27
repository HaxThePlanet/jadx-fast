package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import l.d0;
import l.h;
import l.q;

/* compiled from: BitmapHunter.java */
/* loaded from: classes2.dex */
class c implements Runnable {

    private static final Object L = new Object();
    private static final java.lang.ThreadLocal<StringBuilder> M = new c$a<>();
    private static final AtomicInteger N = new AtomicInteger();
    private static final y O = new c$b();
    int A;
    final y B;
    a C;
    List<a> D;
    Bitmap E;
    Future<?> F;
    t.e G;
    Exception H;
    int I;
    int J;
    t.f K;
    final int a;
    final t b;
    final i c;
    final d v;
    final a0 w;
    final String x;
    final w y;
    final int z;

    static class a extends java.lang.ThreadLocal<StringBuilder> {
        a() {
            super();
        }

        @Override // java.lang.ThreadLocal
        protected StringBuilder a() {
            return new StringBuilder("Picasso-");
        }
    }

    static class c implements Runnable {

        final /* synthetic */ e0 a;
        final /* synthetic */ RuntimeException b;
        c(e0 e0Var, RuntimeException exc) {
            this.a = e0Var;
            this.b = exc;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Transformation ";
            String key = this.a.key();
            String str2 = " crashed with exception.";
            r1 = str + key + str2;
            throw new RuntimeException(r1, this.b);
        }
    }

    static class d implements Runnable {

        final /* synthetic */ StringBuilder a;
        d(StringBuilder sb) {
            this.a = sb;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new NullPointerException(this.a.toString());
        }
    }

    static class e implements Runnable {

        final /* synthetic */ e0 a;
        e(e0 e0Var) {
            this.a = e0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Transformation ";
            String key = this.a.key();
            String str2 = " returned input Bitmap but recycled it.";
            r1 = str + key + str2;
            throw new IllegalStateException(r1);
        }
    }

    static class f implements Runnable {

        final /* synthetic */ e0 a;
        f(e0 e0Var) {
            this.a = e0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Transformation ";
            String key = this.a.key();
            String str2 = " mutated input Bitmap but failed to recycle the original.";
            r1 = str + key + str2;
            throw new IllegalStateException(r1);
        }
    }

    static class b extends y {
        b() {
            super();
        }

        @Override // com.squareup.picasso.y
        public y.a f(w wVar, int i) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Unrecognized type of request: ";
            wVar = str + wVar;
            throw new IllegalStateException(wVar);
        }

        @Override // com.squareup.picasso.y
        public boolean c(w wVar) {
            return true;
        }
    }

    c(t tVar, i iVar, d dVar, a0 a0Var, a aVar, y yVar) {
        super();
        this.a = c.N.incrementAndGet();
        this.b = tVar;
        this.c = iVar;
        this.v = dVar;
        this.w = a0Var;
        this.C = aVar;
        this.x = aVar.d();
        this.y = aVar.i();
        this.K = aVar.h();
        this.z = aVar.e();
        this.A = aVar.f();
        this.B = yVar;
        this.J = yVar.e();
    }

    static Bitmap a(List<e0> list, Bitmap bitmap) {
        int i = 0;
        boolean recycled;
        Bitmap transform;
        i = 0;
        while (i < list.size()) {
            Object item = list.get(i);
            int i2 = 0;
            try {
                transform = item.transform(transform);
            } catch (RuntimeException e) {
                bitmap = t.p;
                bitmap.post(new c.c(r2, e));
                return obj;
            }
            if (transform != transform && !transform.isRecycled()) {
            }
        }
        return transform;
    }

    private t.f d() {
        com.squareup.picasso.t.f lOW2;
        int size;
        com.squareup.picasso.a aVar;
        int ordinal;
        size = 1;
        size = 0;
        int r1 = this.D != null && !this.D.isEmpty() ? 1 : size;
        if (this.C == null) {
            if (this.D == 0) {
            }
        }
        if (size == 0) {
            return t.f.LOW;
        }
        if (this.C != null) {
            lOW2 = this.C.h();
        }
        if (this.D != 0) {
            while (size < this.D.size()) {
                lOW2 = (a)this.D.get(size).h();
                size = size + 1;
            }
        }
        return lOW2;
    }

    static Bitmap e(d0 d0Var, w wVar) throws IOException {
        int i;
        int i2 = 21;
        java.io.InputStream inputStream;
        h hVar = q.d(d0Var);
        final boolean z5 = true;
        boolean z3 = false;
        if (wVar.r) {
            i2 = 21;
            boolean r1 = Build.VERSION.SDK_INT < 21 ? z5 : z3;
        }
        android.graphics.BitmapFactory.Options options = y.d(wVar);
        boolean z4 = y.g(options);
        if (!f0.r(hVar)) {
            if (Build.VERSION.SDK_INT == 0) {
                android.graphics.Rect rect = null;
                if (z4) {
                    com.squareup.picasso.n nVar = new n(hVar.g2());
                    nVar.a(z3);
                    BitmapFactory.decodeStream(nVar, rect, options);
                    y.b(wVar.h, wVar.i, options, wVar);
                    nVar.c(nVar.e(1024));
                    nVar.a(z5);
                }
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, rect, options);
                if (decodeStream != null) {
                    return decodeStream;
                }
            }
            throw new IOException("Failed to decode stream.");
        }
        byte[] bArr = hVar.X();
        if (z4) {
            BitmapFactory.decodeByteArray(bArr, z3, bArr.length, options);
            y.b(wVar.h, wVar.i, options, wVar);
        }
        return BitmapFactory.decodeByteArray(bArr, z3, bArr.length, options);
    }

    static c g(t tVar, i iVar, d dVar, a0 a0Var, a aVar) {
        int i = 0;
        final List list = tVar.i();
        i = 0;
        while (i < list.size()) {
            yVar = list.get(i);
            if (yVar.c(aVar.i())) {
                c cVar2 = new c(tVar, iVar, dVar, a0Var, aVar, yVar);
                return cVar2;
            }
        }
        c cVar = new c(tVar, iVar, dVar, a0Var, aVar, c.O);
        return cVar;
    }

    static Bitmap y(w wVar, Bitmap bitmap, int i) {
        Matrix matrix;
        Bitmap bitmap22;
        int width;
        int i2 = 0;
        float f;
        float f2;
        float f3;
        double floored;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        boolean z;
        boolean z2;
        int i4 = 90;
        int height;
        double d2;
        float f9;
        float f10;
        float f11;
        double d3;
        float f12;
        double d4;
        double d5 = 0;
        double cos;
        double d6;
        double min;
        Object wVar2 = wVar;
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        matrix = new Matrix();
        if (wVar.e() || i != 0) {
            int cmp2 = (f24 > 0 ? 1 : (f24 == 0 ? 0 : -1));
            if (wVar2.n == 0) {
            } else {
                double d46 = (double)f24;
                cos = Math.cos(Math.toRadians(d46));
                double sin = Math.sin(Math.toRadians(d46));
                if (wVar2.q) {
                    matrix.setRotate(wVar2.n, wVar2.o, wVar2.p);
                    double d49 = 1d - cos;
                    double d = (double)f21 * d49 + (double)f27 * sin;
                    double d21 = (double)f27 * d49 - (double)f21 * sin;
                    d6 = (double)i17 * cos + d;
                    min = (double)i17 * sin + d21;
                    d3 = (double)i17 * cos;
                    d2 = (d + d3) - (double)i19 * sin;
                    double d12 = (double)i17 * sin + d21 + (double)i19 * cos;
                    double d29 = d - (double)i19 * sin;
                    d4 = (Math.max(d29, Math.max(d2, Math.max(d, d6)))) - (Math.min(d29, Math.min(d2, Math.min(d, d6))));
                    width = (int)Math.floor(d4);
                    d5 = (Math.max(d2, Math.max(d12, Math.max(d21, min)))) - (Math.min(d2, Math.min(d12, Math.min(d21, min))));
                    width = (int)Math.floor(d5);
                } else {
                    matrix.setRotate(wVar2.n);
                    wVar2 = wVar;
                    double d23 = (double)i15 * cos;
                    double d33 = (double)i15 * sin;
                    double d39 = (double)i15 * cos - (double)i20 * sin;
                    d6 = (double)i15 * sin + (double)i20 * cos;
                    int i7 = -(double)i20 * sin;
                    int i24 = 0;
                    d4 = (Math.max(i7, Math.max(d39, Math.max(i24, d23)))) - (Math.min(i7, Math.min(d39, Math.min(i24, d23))));
                    width = (int)Math.floor(d4);
                    width = (int)(Math.floor((Math.max(d2, Math.max(d6, Math.max(i24, d33)))) - (Math.min(d2, Math.min(d6, Math.min(i24, d33))))));
                }
            }
            if (i != 0) {
                int i8 = c.l(i);
                int i16 = c.m(i);
                if (i8 != 0) {
                    matrix.preRotate((float)i8);
                    i4 = 90;
                    if (i8 == 90 || i8 == 270) {
                    }
                }
                width = 1;
                if (i16 != 1) {
                    matrix.postScale((float)i16, 1f);
                }
            }
            wVar2 = wVar;
            if (wVar2.j) {
                if (wVar2.o != 0) {
                    f4 = (float)width / (float)width;
                } else {
                    f4 = (float)width / (float)height;
                }
                f12 = wVar2.i != 0 ? (float)height : (float)width;
                f9 /= f12;
                if (wVar2.h > wVar2.n) {
                    float f29 = (float)height * (f4 / f4);
                    double ceiled = Math.ceil((double)f29);
                    height = (int)ceiled;
                    i5 = i9 & 48;
                    i = (i9 & 48) == 48 ? 0 : wVar2.k == wVar2.p ? height - height : i11 / 2;
                    f4 = (float)width / (float)ceiled;
                    i2 = 0;
                } else {
                    if (wVar2.h < wVar2.n) {
                        double ceiled2 = Math.ceil((double)(float)width * (f4 / f4));
                        width = (int)ceiled2;
                        i6 = i12 & 3;
                        i2 = (i12 & 3) == 3 ? 0 : wVar2.k == wVar2.p ? width - width : i14 / 2;
                        i = 0;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                }
                if (c.v(z2, width, height, width, width)) {
                    matrix.preScale(f4, f4);
                }
            } else {
                if (wVar2.l) {
                    f5 = wVar2.o != 0 ? (float)width : (float)height;
                    f2 = f / f5;
                    f10 = wVar2.i != 0 ? (float)height : (float)width;
                    f6 /= f10;
                    if (wVar2.k >= wVar2.h) {
                    }
                    if (c.v(z2, width, height, width, width)) {
                        matrix.preScale(f2, f2);
                    }
                } else {
                    if (wVar2.o != 0 || wVar2.i != 0) {
                        if (wVar2.o != wVar2.m || wVar2.i != height) {
                            f7 = wVar2.o != 0 ? (float)width : (float)height;
                            f2 = f3 / f7;
                            f11 = wVar2.i != 0 ? (float)height : (float)width;
                            if (c.v(z2, width, height, width, width)) {
                                matrix.preScale(f3 / f7, f8 / f11);
                            }
                        }
                    }
                }
                i2 = 0;
                i = 0;
            }
        }
        bitmap22 = bitmap;
        if (Bitmap.createBitmap(bitmap, i2, i, width, height, matrix, true) != wVar2.k) {
            bitmap.recycle();
        } else {
        }
        return bitmap22;
    }

    static void z(w wVar) {
        String str2 = wVar.a();
        Object obj = c.M.get();
        final int i2 = 8;
        obj.ensureCapacity(str2.length() + i2);
        obj.replace(i2, obj.length(), str2);
        Thread.currentThread().setName(obj.toString());
    }

    void b(a aVar) {
        final String str6 = "to ";
        final String str7 = "joined";
        final String str8 = "Hunter";
        if (this.C == null) {
            this.C = aVar;
            if (this.b.n && this.D != null && this.D.isEmpty()) {
                f0.t(str8, str7, aVar.b.d(), "to empty hunter");
            }
            return;
        }
        if (this.D == null) {
            int i = 3;
            this.D = new ArrayList(i);
        }
        this.D.add(aVar);
        if (this.b.n) {
            f0.t(str8, str7, aVar.b.d(), f0.k(this, str6));
        }
        com.squareup.picasso.t.f fVar2 = aVar.h();
        if (fVar2.ordinal() > this.K.ordinal()) {
            this.K = fVar2;
        }
    }

    boolean c() {
        boolean z = false;
        z = false;
        if (this.C == null && this.D != null && this.D.isEmpty() && this.F != null && this.F.cancel(false)) {
            int i = 1;
        }
        return z;
    }

    void f(a aVar) {
        boolean remove = false;
        com.squareup.picasso.t.f fVar;
        if (this.C == aVar) {
            this.C = null;
            int i3 = 1;
        } else {
            if (this.D != null) {
                remove = this.D.remove(aVar);
            } else {
                int i = 0;
            }
        }
        if (this.C && aVar.h() == this.K) {
            this.K = d();
        }
        if (this.b.n) {
            str = "removed";
            f0.t("Hunter", str, aVar.b.d(), f0.k(this, "from "));
        }
    }

    a h() {
        return this.C;
    }

    List<a> i() {
        return this.D;
    }

    w j() {
        return this.y;
    }

    Exception k() {
        return this.H;
    }

    String n() {
        return this.x;
    }

    t.e o() {
        return this.G;
    }

    int p() {
        return this.z;
    }

    t q() {
        return this.b;
    }

    t.f r() {
        return this.K;
    }

    @Override // java.lang.Runnable
    public void run() {
        StringWriter currentThread2;
        String str;
        com.squareup.picasso.a0 a0Var;
        String str2;
        try {
            c.z(this.y);
            if (this.b.n) {
                str = "executing";
                f0.s("Hunter", str, f0.j(this));
            }
            Bitmap bitmap = t();
            this.E = bitmap;
            this.c.e(this);
            this.c.d(this);
        } catch (Throwable th) {
        }
        Thread.currentThread().setName("Picasso-Idle");
    }

    Bitmap s() {
        return this.E;
    }

    Bitmap t() {
        int i = 0;
        Bitmap bitmap;
        int index2;
        com.squareup.picasso.y.a aVar;
        com.squareup.picasso.y yVar;
        boolean z5;
        com.squareup.picasso.w wVar;
        String str4;
        String str6;
        if (p.shouldReadFromMemoryCache(this.z)) {
            Bitmap bitmap2 = this.v.get(this.x);
            if (bitmap2 != null) {
                this.w.d();
                this.G = t.e.MEMORY;
                if (this.b.n) {
                    str2 = "decoded";
                    str5 = "from cache";
                    f0.t("Hunter", str2, this.y.d(), str5);
                }
                return bitmap2;
            }
        } else {
            i = 0;
        }
        index2 = this.J == 0 ? oFFLINE2.index : this.A;
        this.A = index2;
        aVar = this.B.f(this.y, index2);
        if (aVar != null && aVar.a() == null) {
            d0 d0Var = aVar.d();
            try {
            } catch (java.io.IOException unused) {
            }
            try {
                d0Var.close();
            } catch (Throwable th) {
            }
        }
        if (this.z != null) {
            if (this.b.n) {
                f0.s("Hunter", "decoded", this.y.d());
            }
            this.w.b(bitmap);
            if (this.y.f() || this.I != 0) {
                Object obj = c.L;
                synchronized (obj) {
                    try {
                        if (this.y.e() || this.I != 0) {
                            bitmap = c.y(this.y, bitmap, this.I);
                            if (this.b.n) {
                                f0.s("Hunter", "transformed", this.y.d());
                            }
                        }
                        if (this.y.b() && this.b.n) {
                            str6 = "from custom transformations";
                            f0.t("Hunter", "transformed", this.y.d(), str6);
                        }
                    } catch (Throwable th) {
                    }
                }
                if (this.z != null) {
                    this.w.c(bitmap);
                }
            }
        }
        return bitmap;
    }

    boolean u() {
        boolean z = false;
        int r0 = this.F != null && this.F.isCancelled() ? 1 : 0;
        return (this.F != null && this.F.isCancelled() ? 1 : 0);
    }

    boolean w(boolean z, NetworkInfo networkInfo) {
        int i;
        i = 1;
        i = 0;
        int r3 = i;
        if (i == 0) {
            return false;
        }
        this.J -= i;
        return this.B.h(z, networkInfo);
    }

    boolean x() {
        return this.B.i();
    }

    static int l(int i) {
        int i2 = 90;
        switch (i) {
            case 3:
                i2 = 180;
                break;
            case 4:
                i2 = 90;
                break;
            case 5:
                i2 = 270;
                break;
            default:
                i2 = 0;
        }
        return i2;
    }

    static int m(int i) {
        int i2 = 2;
        int i3 = 1;
        i2 = 2;
        i = i != 2 && i != 7 && i != 4 && i != 5 ? 1 : -1;
        return (i != 2 && i != 7 && i != 4 && i != 5 ? 1 : -1);
    }

    private static boolean v(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = true;
        if (!z || i3 != 0) {
            i = 1;
        } else {
            if (!(i > i3 || i4 != 0)) {
                if (i2 <= i4) {
                    int i6 = 0;
                }
            }
        }
        return z2;
    }
}
