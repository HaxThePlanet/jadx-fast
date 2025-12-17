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

/* loaded from: classes2.dex */
class c implements Runnable {

    private static final Object L;
    private static final java.lang.ThreadLocal<StringBuilder> M;
    private static final AtomicInteger N;
    private static final com.squareup.picasso.y O;
    int A;
    final com.squareup.picasso.y B;
    com.squareup.picasso.a C;
    List<com.squareup.picasso.a> D;
    Bitmap E;
    Future<?> F;
    com.squareup.picasso.t.e G;
    Exception H;
    int I;
    int J;
    com.squareup.picasso.t.f K;
    final int a;
    final com.squareup.picasso.t b;
    final com.squareup.picasso.i c;
    final com.squareup.picasso.d v;
    final com.squareup.picasso.a0 w;
    final String x;
    final com.squareup.picasso.w y;
    final int z;

    static class a extends java.lang.ThreadLocal<StringBuilder> {
        @Override // java.lang.ThreadLocal
        protected StringBuilder a() {
            StringBuilder stringBuilder = new StringBuilder("Picasso-");
            return stringBuilder;
        }

        @Override // java.lang.ThreadLocal
        protected Object initialValue() {
            return a();
        }
    }

    static class c implements Runnable {

        final com.squareup.picasso.e0 a;
        final RuntimeException b;
        c(com.squareup.picasso.e0 e0, RuntimeException runtimeException2) {
            this.a = e0;
            this.b = runtimeException2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Transformation ");
            stringBuilder.append(this.a.key());
            stringBuilder.append(" crashed with exception.");
            RuntimeException runtimeException = new RuntimeException(stringBuilder.toString(), this.b);
            throw runtimeException;
        }
    }

    static class d implements Runnable {

        final StringBuilder a;
        d(StringBuilder stringBuilder) {
            this.a = stringBuilder;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            NullPointerException nullPointerException = new NullPointerException(this.a.toString());
            throw nullPointerException;
        }
    }

    static class e implements Runnable {

        final com.squareup.picasso.e0 a;
        e(com.squareup.picasso.e0 e0) {
            this.a = e0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Transformation ");
            stringBuilder.append(this.a.key());
            stringBuilder.append(" returned input Bitmap but recycled it.");
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
    }

    static class f implements Runnable {

        final com.squareup.picasso.e0 a;
        f(com.squareup.picasso.e0 e0) {
            this.a = e0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Transformation ");
            stringBuilder.append(this.a.key());
            stringBuilder.append(" mutated input Bitmap but failed to recycle the original.");
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
    }

    static class b extends com.squareup.picasso.y {
        @Override // com.squareup.picasso.y
        public boolean c(com.squareup.picasso.w w) {
            return 1;
        }

        @Override // com.squareup.picasso.y
        public com.squareup.picasso.y.a f(com.squareup.picasso.w w, int i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unrecognized type of request: ");
            stringBuilder.append(w);
            IllegalStateException obj4 = new IllegalStateException(stringBuilder.toString());
            throw obj4;
        }
    }
    static {
        Object object = new Object();
        c.L = object;
        c.a aVar = new c.a();
        c.M = aVar;
        AtomicInteger atomicInteger = new AtomicInteger();
        c.N = atomicInteger;
        c.b bVar = new c.b();
        c.O = bVar;
    }

    c(com.squareup.picasso.t t, com.squareup.picasso.i i2, com.squareup.picasso.d d3, com.squareup.picasso.a0 a04, com.squareup.picasso.a a5, com.squareup.picasso.y y6) {
        super();
        this.a = c.N.incrementAndGet();
        this.b = t;
        this.c = i2;
        this.v = d3;
        this.w = a04;
        this.C = a5;
        this.x = a5.d();
        this.y = a5.i();
        this.K = a5.h();
        this.z = a5.e();
        this.A = a5.f();
        this.B = y6;
        this.J = y6.e();
    }

    static Bitmap a(List<com.squareup.picasso.e0> list, Bitmap bitmap2) {
        String str;
        int i;
        Object obj;
        int i2;
        Bitmap transform;
        boolean recycled;
        Object obj7;
        i = 0;
        while (i < list.size()) {
            obj = list.get(i);
            i2 = 0;
            transform = (e0)obj.transform(obj7);
            i++;
            obj7 = transform;
        }
        return obj7;
    }

    private com.squareup.picasso.t.f d() {
        com.squareup.picasso.t.f lOW;
        List empty;
        int size;
        int i;
        int i2;
        com.squareup.picasso.a ordinal;
        int ordinal2;
        empty = this.D;
        i2 = 0;
        if (empty != null && !empty.isEmpty()) {
            size = !empty.isEmpty() ? i : i2;
        } else {
        }
        ordinal = this.C;
        if (ordinal == null) {
            if (size != 0) {
            } else {
                i = i2;
            }
        }
        if (i == 0) {
            return t.f.LOW;
        }
        if (ordinal != null) {
            lOW = ordinal.h();
        }
        if (size != 0) {
            while (i2 < this.D.size()) {
                i = (a)this.D.get(i2).h();
                if (i.ordinal() > lOW.ordinal()) {
                }
                i2++;
                lOW = i;
            }
        }
        return lOW;
    }

    static Bitmap e(d0 d0, com.squareup.picasso.w w2) {
        boolean z;
        boolean sDK_INT;
        int nVar;
        int i;
        int i2;
        boolean z2;
        java.io.InputStream obj7;
        obj7 = q.d(d0);
        final int i4 = 1;
        i = 0;
        if (w2.r && Build.VERSION.SDK_INT < 21) {
            nVar = Build.VERSION.SDK_INT < 21 ? i4 : i;
        } else {
        }
        android.graphics.BitmapFactory.Options factory = y.d(w2);
        z2 = y.g(factory);
        if (!f0.r(obj7)) {
            if (nVar != 0) {
            } else {
                int i3 = 0;
                if (z2) {
                    nVar = new n(obj7.g2());
                    nVar.a(i);
                    BitmapFactory.decodeStream(nVar, i3, factory);
                    y.b(w2.h, w2.i, factory, w2);
                    nVar.c(nVar.e(1024));
                    nVar.a(i4);
                    obj7 = nVar;
                }
                obj7 = BitmapFactory.decodeStream(obj7, i3, factory);
                if (obj7 == null) {
                } else {
                    return obj7;
                }
            }
            obj7 = new IOException("Failed to decode stream.");
            throw obj7;
        }
        obj7 = obj7.X();
        if (z2) {
            BitmapFactory.decodeByteArray(obj7, i, obj7.length, factory);
            y.b(w2.h, w2.i, factory, w2);
        }
        return BitmapFactory.decodeByteArray(obj7, i, obj7.length, factory);
    }

    static com.squareup.picasso.c g(com.squareup.picasso.t t, com.squareup.picasso.i i2, com.squareup.picasso.d d3, com.squareup.picasso.a0 a04, com.squareup.picasso.a a5) {
        int i;
        boolean z;
        Object obj;
        final List list = t.i();
        i = 0;
        while (i < list.size()) {
            obj = obj2;
            i++;
        }
        super(t, i2, d3, a04, a5, c.O);
        return cVar;
    }

    static int l(int i) {
        int obj0;
        switch (i) {
            case 3:
                obj0 = 180;
                break;
            case 4:
                obj0 = 90;
                break;
            case 5:
                obj0 = 270;
                break;
            default:
                obj0 = 0;
        }
        return obj0;
    }

    static int m(int i) {
        int i2;
        int obj1;
        if (i != 2 && i != 7 && i != 4 && i != 5) {
            if (i != 7) {
                if (i != 4) {
                    obj1 = i != 5 ? 1 : -1;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static boolean v(boolean z, int i2, int i3, int i4, int i5) {
        int obj0;
        if (z) {
            if (i4 != 0) {
                if (i2 <= i4) {
                    if (i5 != 0 && i3 > i5) {
                        if (i3 > i5) {
                            obj0 = 1;
                        } else {
                            obj0 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj0;
    }

    static Bitmap y(com.squareup.picasso.w w, Bitmap bitmap2, int i3) {
        Matrix matrix;
        Bitmap bitmap;
        int width;
        int i14;
        int i6;
        float f7;
        float f;
        double height;
        float f2;
        float f3;
        float f8;
        float f5;
        boolean z4;
        int i7;
        boolean z3;
        int z2;
        int i9;
        int i22;
        int i12;
        int i20;
        int i10;
        int i11;
        int cmp2;
        float f9;
        int i5;
        float f4;
        int i8;
        int cmp;
        float f6;
        int i25;
        int i13;
        int i17;
        int i18;
        int matrix2;
        double d2;
        int i15;
        double d;
        int i4;
        int i23;
        int i16;
        boolean z;
        int i2;
        Matrix matrix3;
        int i;
        int i19;
        int i21;
        int i24;
        Object obj = w;
        width = bitmap2.getWidth();
        height = bitmap2.getHeight();
        z4 = obj.m;
        matrix2 = new Matrix();
        if (!w.e()) {
            if (i3 != 0) {
                z2 = obj.h;
                i10 = obj.i;
                cmp2 = obj.n;
                cmp = Float.compare(cmp2, i63);
                if (cmp != 0) {
                    double d40 = (double)cmp2;
                    d = Math.cos(Math.toRadians(d40));
                    d2 = Math.sin(Math.toRadians(d40));
                    boolean z5 = obj.q;
                    if (z5) {
                        matrix2.setRotate(cmp2, obj.o, obj.p);
                        float f14 = obj.o;
                        l -= d;
                        float f17 = obj.p;
                        i16 = height;
                        z = z4;
                        i54 += i40;
                        i41 -= i77;
                        int i48 = obj.h;
                        i78 += i55;
                        int i81 = i55;
                        i52 += i42;
                        d30 *= d;
                        int i67 = obj.i;
                        i19 = width;
                        i57 -= i26;
                        i28 += i49;
                        int i51 = i81 - i50;
                        int i75 = i81;
                        int i56 = i21;
                        i4 = i2;
                        z2 = (int)height;
                        i10 = (int)floor;
                        matrix = matrix3;
                    } else {
                        i19 = width;
                        i16 = height;
                        z = z4;
                        matrix2.setRotate(cmp2);
                        Object obj2 = w;
                        int i43 = obj2.h;
                        d13 *= d;
                        d23 *= d2;
                        int i70 = obj2.i;
                        i58 -= i79;
                        i80 += i30;
                        int i32 = -i31;
                        i15 = 0;
                        cmp2 = i2;
                        i10 = (int)height;
                        z2 = width;
                    }
                } else {
                    i19 = width;
                    i16 = height;
                    z = z4;
                    matrix = matrix2;
                }
                int i33 = c.l(i3);
                height = c.m(i3);
                if (i3 != 0 && i33 != 0) {
                    i33 = c.l(i3);
                    height = c.m(i3);
                    if (i33 != 0) {
                        matrix.preRotate((float)i33);
                        if (i33 != 90) {
                            if (i33 == 270) {
                                i10 = z2;
                                z2 = i24;
                            }
                        } else {
                        }
                    }
                    if (height != 1) {
                        matrix.postScale((float)height, 1065353216);
                    }
                }
                Object obj3 = w;
                if (obj3.j) {
                    if (z2 != 0) {
                        f10 /= f15;
                        i22 = i16;
                    } else {
                        i7 = i19;
                        f11 /= cmp2;
                    }
                    f6 = i10 != 0 ? (float)i22 : (float)i7;
                    f9 /= f6;
                    if (Float.compare(height, i60) > 0) {
                        f18 *= i61;
                        int i62 = (int)ceil;
                        int i34 = obj3.k;
                        i14 = i34 & 48 == 48 ? 0 : i35 == i25 ? i22 - i62 : i36 / 2;
                        f19 /= f22;
                        matrix2 = i62;
                        d2 = z;
                        i = 0;
                        i5 = i14;
                        width = i7;
                    } else {
                        if (Float.compare(height, i60) < 0) {
                            int i45 = (int)ceil2;
                            int i37 = obj3.k;
                            i6 = i37 & 3 == 3 ? 0 : i38 == i13 ? i7 - i45 : i39 / 2;
                            i = i6;
                            width = i45;
                            matrix2 = i22;
                            height = i66;
                            d2 = z;
                            i17 = i60;
                            i5 = 0;
                        } else {
                            width = i7;
                            matrix2 = i22;
                            i17 = height;
                            d2 = z;
                            i5 = 0;
                            i = 0;
                        }
                    }
                    if (c.v(d2, i7, i22, z2, i10)) {
                        matrix.preScale(height, i17);
                    }
                    i11 = i5;
                    i18 = matrix2;
                    i12 = i;
                    i8 = width;
                } else {
                    i20 = i16;
                    d2 = z;
                    z3 = i19;
                    if (obj3.l) {
                        f2 = z2 != 0 ? (float)z3 : (float)i20;
                        f4 = i10 != 0 ? (float)i20 : (float)z3;
                        f3 /= f4;
                        if (Float.compare(width, i46) < 0) {
                        } else {
                            width = i46;
                        }
                        if (c.v(d2, z3, i20, z2, i10)) {
                            matrix.preScale(width, width);
                        }
                    } else {
                        if (z2 == 0) {
                            if (i10 != 0) {
                                if (z2 == z3) {
                                    if (i10 != i20) {
                                        f8 = z2 != 0 ? (float)z3 : (float)i20;
                                        cmp2 = i10 != 0 ? (float)i20 : (float)z3;
                                        if (c.v(d2, z3, i20, z2, i10)) {
                                            matrix.preScale(f /= f8, f5 /= cmp2);
                                        }
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                    i8 = z3;
                    i18 = i20;
                    i12 = 0;
                    i11 = 0;
                }
            } else {
                z3 = width;
                i20 = height;
                matrix = matrix2;
            }
        } else {
        }
        Bitmap bitmap3 = bitmap2;
        if (Bitmap.createBitmap(bitmap2, i12, i11, i8, i18, matrix, true) != bitmap3) {
            bitmap2.recycle();
        } else {
            bitmap = bitmap3;
        }
        return bitmap;
    }

    static void z(com.squareup.picasso.w w) {
        String obj3 = w.a();
        Object obj = c.M.get();
        final int i2 = 8;
        (StringBuilder)obj.ensureCapacity(length += i2);
        obj.replace(i2, obj.length(), obj3);
        Thread.currentThread().setName(obj.toString());
    }

    @Override // java.lang.Runnable
    void b(com.squareup.picasso.a a) {
        boolean str;
        Object wVar;
        Object arrayList;
        int i;
        Object obj8;
        str = tVar.n;
        wVar = a.b;
        final String str2 = "to ";
        final String str3 = "joined";
        final String str4 = "Hunter";
        this.C = a;
        if (this.C == null && str != null) {
            this.C = a;
            if (str != null) {
                obj8 = this.D;
                if (obj8 != null) {
                    if (obj8.isEmpty()) {
                        f0.t(str4, str3, wVar.d(), "to empty hunter");
                    } else {
                        f0.t(str4, str3, wVar.d(), f0.k(this, str2));
                    }
                } else {
                }
            }
        }
        if (this.D == null) {
            arrayList = new ArrayList(3);
            this.D = arrayList;
        }
        this.D.add(a);
        if (str != null) {
            f0.t(str4, str3, wVar.d(), f0.k(this, str2));
        }
        obj8 = a.h();
        if (obj8.ordinal() > this.K.ordinal()) {
            this.K = obj8;
        }
    }

    @Override // java.lang.Runnable
    boolean c() {
        List cancel;
        int i;
        if (this.C == null) {
            cancel = this.D;
            if (cancel != null) {
                cancel = this.F;
                if (cancel.isEmpty() && cancel != null && cancel.cancel(false)) {
                    cancel = this.F;
                    if (cancel != null) {
                        if (cancel.cancel(i)) {
                            i = 1;
                        }
                    }
                }
            } else {
            }
        }
        return i;
    }

    @Override // java.lang.Runnable
    void f(com.squareup.picasso.a a) {
        boolean remove;
        boolean z;
        com.squareup.picasso.t.f str2;
        String str;
        Object obj4;
        if (this.C == a) {
            this.C = 0;
            remove = 1;
        } else {
            List list = this.D;
            if (list != null) {
                remove = list.remove(a);
            } else {
                remove = 0;
            }
        }
        if (remove && a.h() == this.K) {
            if (a.h() == this.K) {
                this.K = d();
            }
        }
        if (tVar.n) {
            f0.t("Hunter", "removed", a.b.d(), f0.k(this, "from "));
        }
    }

    @Override // java.lang.Runnable
    com.squareup.picasso.a h() {
        return this.C;
    }

    List<com.squareup.picasso.a> i() {
        return this.D;
    }

    @Override // java.lang.Runnable
    com.squareup.picasso.w j() {
        return this.y;
    }

    @Override // java.lang.Runnable
    Exception k() {
        return this.H;
    }

    @Override // java.lang.Runnable
    String n() {
        return this.x;
    }

    @Override // java.lang.Runnable
    com.squareup.picasso.t.e o() {
        return this.G;
    }

    @Override // java.lang.Runnable
    int p() {
        return this.z;
    }

    @Override // java.lang.Runnable
    com.squareup.picasso.t q() {
        return this.b;
    }

    @Override // java.lang.Runnable
    com.squareup.picasso.t.f r() {
        return this.K;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th;
        boolean str;
        com.squareup.picasso.i iVar;
        StringWriter currentThread;
        com.squareup.picasso.a0 a0Var;
        PrintWriter printWriter;
        c.z(this.y);
        if (tVar.n) {
            f0.s("Hunter", "executing", f0.j(this));
        }
        try {
            Bitmap bitmap = t();
            this.E = bitmap;
            if (bitmap == null) {
            } else {
            }
            this.c.e(this);
            this.c.d(this);
            this.H = th;
            th = this.c;
            th.e(this);
            currentThread = new StringWriter();
            a0Var = this.w;
            a0Var = a0Var.a();
            printWriter = new PrintWriter(currentThread);
            a0Var.a(printWriter);
            currentThread = currentThread.toString();
            a0Var = new RuntimeException(currentThread, th);
            this.H = a0Var;
            th = this.c;
            th.e(this);
            this.H = th;
            th = this.c;
            th.g(this);
            Thread.currentThread().setName("Picasso-Idle");
            currentThread = th.networkPolicy;
            currentThread = q.isOfflineOnly(currentThread);
            if (currentThread != null) {
            } else {
            }
            currentThread = th.code;
            a0Var = 504;
            if (currentThread != a0Var) {
            }
            this.H = th;
            th = this.c;
            th.e(this);
            currentThread = Thread.currentThread();
            currentThread.setName(obj0);
            throw th;
        } catch (Throwable th) {
        }
    }

    @Override // java.lang.Runnable
    Bitmap s() {
        return this.E;
    }

    @Override // java.lang.Runnable
    Bitmap t() {
        Bitmap bitmap;
        String str4;
        int index;
        Object aVar;
        boolean str9;
        boolean str10;
        Object str6;
        boolean str7;
        String str8;
        Object str;
        String str2;
        String str5;
        String str3;
        if (p.shouldReadFromMemoryCache(this.z)) {
            bitmap = this.v.get(this.x);
            this.w.d();
            this.G = t.e.MEMORY;
            if (bitmap != null && tVar2.n) {
                this.w.d();
                this.G = t.e.MEMORY;
                if (tVar2.n) {
                    f0.t("Hunter", "decoded", this.y.d(), "from cache");
                }
                return bitmap;
            }
        } else {
            bitmap = 0;
        }
        index = this.J == 0 ? oFFLINE.index : this.A;
        this.A = index;
        aVar = this.B.f(this.y, index);
        this.G = aVar.c();
        this.I = aVar.b();
        if (aVar != null && aVar.a() == null) {
            this.G = aVar.c();
            this.I = aVar.b();
            if (aVar.a() == null) {
                d0 d0Var = aVar.d();
                d0Var.close();
                bitmap = aVar;
            }
        }
        if (bitmap != null && tVar.n) {
            if (tVar.n) {
                f0.s("Hunter", "decoded", this.y.d());
            }
            this.w.b(bitmap);
            if (!this.y.f()) {
                if (this.I != 0) {
                    aVar = c.L;
                    synchronized (aVar) {
                        bitmap = c.y(this.y, bitmap, this.I);
                        if (this.I != 0 && tVar4.n) {
                            bitmap = c.y(this.y, bitmap, this.I);
                            if (tVar4.n) {
                                f0.s("Hunter", "transformed", this.y.d());
                            }
                        }
                        bitmap = c.a(wVar5.g, bitmap);
                        if (this.y.b() && tVar3.n) {
                            bitmap = c.a(wVar5.g, bitmap);
                            if (tVar3.n) {
                                f0.t("Hunter", "transformed", this.y.d(), "from custom transformations");
                            }
                        }
                        if (bitmap != null) {
                        }
                    }
                    this.w.c(bitmap);
                }
            } else {
            }
        }
        return bitmap;
    }

    @Override // java.lang.Runnable
    boolean u() {
        Future cancelled;
        int i;
        cancelled = this.F;
        if (cancelled != null && cancelled.isCancelled()) {
            i = cancelled.isCancelled() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.lang.Runnable
    boolean w(boolean z, NetworkInfo networkInfo2) {
        int i;
        int i2 = this.J;
        final int i4 = 1;
        final int i5 = 0;
        i = i2 > 0 ? i4 : i5;
        if (i == 0) {
            return i5;
        }
        this.J = i2 -= i4;
        return this.B.h(z, networkInfo2);
    }

    @Override // java.lang.Runnable
    boolean x() {
        return this.B.i();
    }
}
