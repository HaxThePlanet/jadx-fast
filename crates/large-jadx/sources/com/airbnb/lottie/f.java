package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.u.a;
import com.airbnb.lottie.u.b;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.v.f;
import com.airbnb.lottie.v.l.a;
import com.airbnb.lottie.v.l.b;
import com.airbnb.lottie.x.s;
import com.airbnb.lottie.y.a;
import com.airbnb.lottie.y.d;
import com.airbnb.lottie.y.e;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.c;
import d.e.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class f extends Drawable implements Drawable.Callback, Animatable {

    private b A;
    private String B;
    private com.airbnb.lottie.b C;
    private a D;
    com.airbnb.lottie.a E;
    com.airbnb.lottie.s F;
    private boolean G;
    private b H;
    private int I = 255;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M = true;
    private boolean N = false;
    private final Matrix a;
    private com.airbnb.lottie.d b;
    private final e c;
    private float v = 1f;
    private boolean w = true;
    private boolean x = false;
    private final ArrayList<com.airbnb.lottie.f.o> y;
    private final ValueAnimator.AnimatorUpdateListener z;

    class f implements ValueAnimator.AnimatorUpdateListener {

        final com.airbnb.lottie.f a;
        f(com.airbnb.lottie.f f) {
            this.a = f;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f;
            b obj2;
            if (f.a(this.a) != null) {
                f.a(this.a).H(f.b(this.a).h());
            }
        }
    }

    private interface o {
        public abstract void a(com.airbnb.lottie.d d);
    }

    class a implements com.airbnb.lottie.f.o {

        final String a;
        final com.airbnb.lottie.f b;
        a(com.airbnb.lottie.f f, String string2) {
            this.b = f;
            this.a = string2;
            super();
        }

        @Override // com.airbnb.lottie.f$o
        public void a(com.airbnb.lottie.d d) {
            this.b.W(this.a);
        }
    }

    class b implements com.airbnb.lottie.f.o {

        final int a;
        final int b;
        final com.airbnb.lottie.f c;
        b(com.airbnb.lottie.f f, int i2, int i3) {
            this.c = f;
            this.a = i2;
            this.b = i3;
            super();
        }

        @Override // com.airbnb.lottie.f$o
        public void a(com.airbnb.lottie.d d) {
            this.c.V(this.a, this.b);
        }
    }

    class c implements com.airbnb.lottie.f.o {

        final int a;
        final com.airbnb.lottie.f b;
        c(com.airbnb.lottie.f f, int i2) {
            this.b = f;
            this.a = i2;
            super();
        }

        @Override // com.airbnb.lottie.f$o
        public void a(com.airbnb.lottie.d d) {
            this.b.P(this.a);
        }
    }

    class d implements com.airbnb.lottie.f.o {

        final float a;
        final com.airbnb.lottie.f b;
        d(com.airbnb.lottie.f f, float f2) {
            this.b = f;
            this.a = f2;
            super();
        }

        @Override // com.airbnb.lottie.f$o
        public void a(com.airbnb.lottie.d d) {
            this.b.c0(this.a);
        }
    }

    class e implements com.airbnb.lottie.f.o {

        final e a;
        final Object b;
        final c c;
        final com.airbnb.lottie.f d;
        e(com.airbnb.lottie.f f, e e2, Object object3, c c4) {
            this.d = f;
            this.a = e2;
            this.b = object3;
            this.c = c4;
            super();
        }

        @Override // com.airbnb.lottie.f$o
        public void a(com.airbnb.lottie.d d) {
            this.d.c(this.a, this.b, this.c);
        }
    }

    class g implements com.airbnb.lottie.f.o {

        final com.airbnb.lottie.f a;
        g(com.airbnb.lottie.f f) {
            this.a = f;
            super();
        }

        @Override // com.airbnb.lottie.f$o
        public void a(com.airbnb.lottie.d d) {
            this.a.J();
        }
    }

    class h implements com.airbnb.lottie.f.o {

        final com.airbnb.lottie.f a;
        h(com.airbnb.lottie.f f) {
            this.a = f;
            super();
        }

        @Override // com.airbnb.lottie.f$o
        public void a(com.airbnb.lottie.d d) {
            this.a.L();
        }
    }

    class i implements com.airbnb.lottie.f.o {

        final int a;
        final com.airbnb.lottie.f b;
        i(com.airbnb.lottie.f f, int i2) {
            this.b = f;
            this.a = i2;
            super();
        }

        @Override // com.airbnb.lottie.f$o
        public void a(com.airbnb.lottie.d d) {
            this.b.X(this.a);
        }
    }

    class j implements com.airbnb.lottie.f.o {

        final float a;
        final com.airbnb.lottie.f b;
        j(com.airbnb.lottie.f f, float f2) {
            this.b = f;
            this.a = f2;
            super();
        }

        @Override // com.airbnb.lottie.f$o
        public void a(com.airbnb.lottie.d d) {
            this.b.Z(this.a);
        }
    }

    class k implements com.airbnb.lottie.f.o {

        final int a;
        final com.airbnb.lottie.f b;
        k(com.airbnb.lottie.f f, int i2) {
            this.b = f;
            this.a = i2;
            super();
        }

        @Override // com.airbnb.lottie.f$o
        public void a(com.airbnb.lottie.d d) {
            this.b.S(this.a);
        }
    }

    class l implements com.airbnb.lottie.f.o {

        final float a;
        final com.airbnb.lottie.f b;
        l(com.airbnb.lottie.f f, float f2) {
            this.b = f;
            this.a = f2;
            super();
        }

        @Override // com.airbnb.lottie.f$o
        public void a(com.airbnb.lottie.d d) {
            this.b.U(this.a);
        }
    }

    class m implements com.airbnb.lottie.f.o {

        final String a;
        final com.airbnb.lottie.f b;
        m(com.airbnb.lottie.f f, String string2) {
            this.b = f;
            this.a = string2;
            super();
        }

        @Override // com.airbnb.lottie.f$o
        public void a(com.airbnb.lottie.d d) {
            this.b.Y(this.a);
        }
    }

    class n implements com.airbnb.lottie.f.o {

        final String a;
        final com.airbnb.lottie.f b;
        n(com.airbnb.lottie.f f, String string2) {
            this.b = f;
            this.a = string2;
            super();
        }

        @Override // com.airbnb.lottie.f$o
        public void a(com.airbnb.lottie.d d) {
            this.b.T(this.a);
        }
    }
    public f() {
        super();
        Matrix matrix = new Matrix();
        this.a = matrix;
        e eVar = new e();
        this.c = eVar;
        int i = 1065353216;
        int i2 = 1;
        final int i3 = 0;
        ArrayList arrayList = new ArrayList();
        this.y = arrayList;
        f.f fVar = new f.f(this);
        this.z = fVar;
        final int i4 = 255;
        eVar.addUpdateListener(fVar);
    }

    static b a(com.airbnb.lottie.f f) {
        return f.H;
    }

    static e b(com.airbnb.lottie.f f) {
        return f.c;
    }

    private float d(Rect rect) {
        return f /= obj2;
    }

    private boolean e() {
        com.airbnb.lottie.d cmp;
        int i;
        float empty;
        cmp = this.b;
        i = 1;
        if (cmp != null) {
            if (getBounds().isEmpty()) {
            } else {
                if (Float.compare(empty, f) == 0) {
                } else {
                    i = 0;
                }
            }
        }
        return i;
    }

    private void f() {
        boolean z;
        b bVar = new b(this, s.a(this.b), this.b.j(), this.b);
        this.H = bVar;
        if (this.K) {
            bVar.F(true);
        }
    }

    private void i(Canvas canvas) {
        if (!e()) {
            j(canvas);
        } else {
            k(canvas);
        }
    }

    private void j(Canvas canvas) {
        int save;
        Rect bounds;
        int i4;
        int i;
        boolean z;
        int cmp;
        int i3;
        int i2;
        if (this.H == null) {
        }
        save = -1;
        bounds = getBounds();
        f2 /= f3;
        f4 /= f5;
        if (this.M) {
            z = Math.min(i4, i);
            int i7 = 1065353216;
            if (Float.compare(z, i7) < 0) {
                i3 = i7 / z;
                i4 /= i3;
                i /= i3;
            } else {
                i3 = i7;
            }
            if (Float.compare(i3, i7) > 0) {
                save = canvas.save();
                int i9 = 1073741824;
                f6 /= i9;
                f /= i9;
                i2 = i8 * z;
                z *= i5;
                canvas.translate(i8 -= i2, i5 -= z);
                canvas.scale(i3, i3, i2, z);
            }
        }
        this.a.reset();
        this.a.preScale(i4, i);
        this.H.f(canvas, this.a, this.I);
        if (save > 0) {
            canvas.restoreToCount(save);
        }
    }

    private void k(Canvas canvas) {
        int i4;
        float f;
        int save;
        int cmp;
        int i;
        int i5;
        int i3;
        int i2;
        if (this.H == null) {
        }
        float f2 = this.v;
        f = w(canvas);
        int i6 = 1065353216;
        i4 = Float.compare(f2, f) > 0 ? f3 / f : i6;
        save = -1;
        if (Float.compare(i4, i6) > 0) {
            save = canvas.save();
            int i10 = 1073741824;
            f4 /= i10;
            f6 /= i10;
            i = i8 * f;
            i3 = i5 * f;
            canvas.translate(i11 -= i, i9 -= i3);
            canvas.scale(i4, i4, i, i3);
        }
        this.a.reset();
        this.a.preScale(f, f);
        this.H.f(canvas, this.a, this.I);
        if (save > 0) {
            canvas.restoreToCount(save);
        }
    }

    private Context p() {
        Drawable.Callback callback = getCallback();
        final int i = 0;
        if (callback == null) {
            return i;
        }
        if (callback instanceof View != null) {
            return (View)callback.getContext();
        }
        return i;
    }

    private a q() {
        a aVar2;
        Drawable.Callback callback;
        com.airbnb.lottie.a aVar;
        if (getCallback() == null) {
            return null;
        }
        if (this.D == null) {
            aVar2 = new a(getCallback(), this.E);
            this.D = aVar2;
        }
        return this.D;
    }

    private b t() {
        b bVar;
        b bVar2;
        int callback;
        Context context;
        com.airbnb.lottie.b bVar3;
        java.util.Map map;
        callback = 0;
        if (getCallback() == null) {
            return callback;
        }
        bVar = this.A;
        if (bVar != null && !bVar.b(p())) {
            if (!bVar.b(p())) {
                this.A = callback;
            }
        }
        if (this.A == null) {
            bVar2 = new b(getCallback(), this.B, this.C, this.b.i());
            this.A = bVar2;
        }
        return this.A;
    }

    private float w(Canvas canvas) {
        return Math.min(f /= f2, obj3 /= f3);
    }

    @Override // android.graphics.drawable.Drawable
    public int A() {
        return this.c.getRepeatCount();
    }

    @Override // android.graphics.drawable.Drawable
    public int B() {
        return this.c.getRepeatMode();
    }

    @Override // android.graphics.drawable.Drawable
    public float C() {
        return this.v;
    }

    @Override // android.graphics.drawable.Drawable
    public float D() {
        return this.c.n();
    }

    @Override // android.graphics.drawable.Drawable
    public com.airbnb.lottie.s E() {
        return this.F;
    }

    @Override // android.graphics.drawable.Drawable
    public Typeface F(String string, String string2) {
        final a aVar = q();
        if (aVar != null) {
            return aVar.b(string, string2);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean G() {
        e eVar = this.c;
        if (eVar == null) {
            return 0;
        }
        return eVar.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean H() {
        return this.L;
    }

    @Override // android.graphics.drawable.Drawable
    public void I() {
        this.y.clear();
        this.c.p();
    }

    @Override // android.graphics.drawable.Drawable
    public void J() {
        int z;
        boolean z2;
        float f;
        int i;
        if (this.H == null) {
            f.g gVar = new f.g(this);
            this.y.add(gVar);
        }
        if (!this.w) {
            if (A() == 0) {
                this.c.r();
            }
        } else {
        }
        if (!this.w) {
            if (Float.compare(f2, i) < 0) {
                f = x();
            } else {
                f = v();
            }
            P((int)f);
            this.c.g();
        }
    }

    public List<e> K(e e) {
        if (this.H == null) {
            d.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        final int i = 0;
        e eVar = new e(new String[i]);
        this.H.c(e, i, arrayList, eVar);
        return arrayList;
    }

    @Override // android.graphics.drawable.Drawable
    public void L() {
        int z2;
        boolean z;
        float f;
        int i;
        if (this.H == null) {
            f.h hVar = new f.h(this);
            this.y.add(hVar);
        }
        if (!this.w) {
            if (A() == 0) {
                this.c.v();
            }
        } else {
        }
        if (!this.w) {
            if (Float.compare(f2, i) < 0) {
                f = x();
            } else {
                f = v();
            }
            P((int)f);
            this.c.g();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void M(boolean z) {
        this.L = z;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean N(com.airbnb.lottie.d d) {
        boolean z;
        ArrayList next;
        int i = 0;
        if (this.b == d) {
            return i;
        }
        this.N = i;
        h();
        this.b = d;
        f();
        this.c.x(d);
        c0(this.c.getAnimatedFraction());
        g0(this.v);
        ArrayList arrayList = new ArrayList(this.y);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((f.o)next != null) {
            }
            iterator.remove();
            (f.o)next.a(d);
        }
        this.y.clear();
        d.u(this.J);
        Drawable.Callback obj3 = getCallback();
        if (obj3 instanceof ImageView != null) {
            (ImageView)obj3.setImageDrawable(0);
            obj3.setImageDrawable(this);
        }
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void O(com.airbnb.lottie.a a) {
        final a aVar = this.D;
        if (aVar != null) {
            aVar.c(a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void P(int i) {
        if (this.b == null) {
            f.c cVar = new f.c(this, i);
            this.y.add(cVar);
        }
        this.c.y((float)i);
    }

    @Override // android.graphics.drawable.Drawable
    public void Q(com.airbnb.lottie.b b) {
        this.C = b;
        final b bVar = this.A;
        if (bVar != null) {
            bVar.d(b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void R(String string) {
        this.B = string;
    }

    @Override // android.graphics.drawable.Drawable
    public void S(int i) {
        if (this.b == null) {
            f.k kVar = new f.k(this, i);
            this.y.add(kVar);
        }
        this.c.z(obj3 += i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void T(String string) {
        com.airbnb.lottie.d dVar = this.b;
        if (dVar == null) {
            f.n nVar = new f.n(this, string);
            this.y.add(nVar);
        }
        com.airbnb.lottie.v.h hVar = dVar.k(string);
        if (hVar == null) {
        } else {
            S((int)obj4);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find marker with name ");
        stringBuilder.append(string);
        stringBuilder.append(".");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // android.graphics.drawable.Drawable
    public void U(float f) {
        com.airbnb.lottie.d dVar = this.b;
        if (dVar == null) {
            f.l lVar = new f.l(this, f);
            this.y.add(lVar);
        }
        S((int)obj3);
    }

    @Override // android.graphics.drawable.Drawable
    public void V(int i, int i2) {
        if (this.b == null) {
            f.b bVar = new f.b(this, i, i2);
            this.y.add(bVar);
        }
        this.c.A((float)i, obj4 += i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void W(String string) {
        com.airbnb.lottie.d dVar = this.b;
        if (dVar == null) {
            f.a aVar = new f.a(this, string);
            this.y.add(aVar);
        }
        com.airbnb.lottie.v.h hVar = dVar.k(string);
        if (hVar == null) {
        } else {
            int obj4 = (int)obj4;
            V(obj4, i += obj4);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find marker with name ");
        stringBuilder.append(string);
        stringBuilder.append(".");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // android.graphics.drawable.Drawable
    public void X(int i) {
        if (this.b == null) {
            f.i iVar = new f.i(this, i);
            this.y.add(iVar);
        }
        this.c.B(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void Y(String string) {
        com.airbnb.lottie.d dVar = this.b;
        if (dVar == null) {
            f.m mVar = new f.m(this, string);
            this.y.add(mVar);
        }
        com.airbnb.lottie.v.h hVar = dVar.k(string);
        if (hVar == null) {
        } else {
            X((int)obj4);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find marker with name ");
        stringBuilder.append(string);
        stringBuilder.append(".");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // android.graphics.drawable.Drawable
    public void Z(float f) {
        com.airbnb.lottie.d dVar = this.b;
        if (dVar == null) {
            f.j jVar = new f.j(this, f);
            this.y.add(jVar);
        }
        X((int)obj3);
    }

    @Override // android.graphics.drawable.Drawable
    public void a0(boolean z) {
        if (this.K == z) {
        }
        this.K = z;
        b bVar = this.H;
        if (bVar != null) {
            bVar.F(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void b0(boolean z) {
        this.J = z;
        final com.airbnb.lottie.d dVar = this.b;
        if (dVar != null) {
            dVar.u(z);
        }
    }

    public <T> void c(e e, T t2, c<T> c3) {
        b bVar;
        e size;
        int i;
        e obj4;
        bVar = this.H;
        if (bVar == null) {
            f.e eVar = new f.e(this, e, t2, c3);
            this.y.add(eVar);
        }
        if (e == e.c) {
            bVar.g(t2, c3);
        } else {
            if (e.d() != null) {
                e.d().g(t2, c3);
            } else {
                obj4 = K(e);
                bVar = 0;
                while (bVar < obj4.size()) {
                    (e)obj4.get(bVar).d().g(t2, c3);
                    bVar++;
                }
                i ^= obj4;
            }
        }
        invalidateSelf();
        if (i != 0 && t2 == k.C) {
            invalidateSelf();
            if (t2 == k.C) {
                c0(z());
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void c0(float f) {
        if (this.b == null) {
            f.d dVar2 = new f.d(this, f);
            this.y.add(dVar2);
        }
        String str = "Drawable#setProgress";
        c.a(str);
        this.c.y(g.k(this.b.o(), this.b.f(), f));
        c.b(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void d0(int i) {
        this.c.setRepeatCount(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Canvas obj3;
        this.N = false;
        String str = "Drawable#draw";
        c.a(str);
        if (this.x) {
            i(canvas);
        } else {
            i(canvas);
        }
        c.b(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void e0(int i) {
        this.c.setRepeatMode(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void f0(boolean z) {
        this.x = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void g() {
        this.y.clear();
        this.c.cancel();
    }

    @Override // android.graphics.drawable.Drawable
    public void g0(float f) {
        this.v = f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.I;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i;
        float f;
        com.airbnb.lottie.d dVar = this.b;
        if (dVar == null) {
            i = -1;
        } else {
            i = (int)i2;
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i;
        float f;
        com.airbnb.lottie.d dVar = this.b;
        if (dVar == null) {
            i = -1;
        } else {
            i = (int)i2;
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void h() {
        boolean running;
        if (this.c.isRunning()) {
            this.c.cancel();
        }
        int i = 0;
        this.b = i;
        this.H = i;
        this.A = i;
        this.c.f();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void h0(float f) {
        this.c.C(f);
    }

    @Override // android.graphics.drawable.Drawable
    void i0(Boolean boolean) {
        this.w = boolean.booleanValue();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateDrawable(Drawable drawable) {
        final Drawable.Callback obj1 = getCallback();
        if (obj1 == null) {
        }
        obj1.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.N) {
        }
        this.N = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isRunning() {
        return G();
    }

    @Override // android.graphics.drawable.Drawable
    public void j0(com.airbnb.lottie.s s) {
    }

    @Override // android.graphics.drawable.Drawable
    public boolean k0() {
        com.airbnb.lottie.s sVar;
        int i;
        if (this.F == null && this.b.c().k() > 0) {
            i = this.b.c().k() > 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void l(boolean z) {
        if (this.G == z) {
        }
        if (Build.VERSION.SDK_INT < 19) {
            d.c("Merge paths are not supported pre-Kit Kat.");
        }
        this.G = z;
        if (this.b != null) {
            f();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean m() {
        return this.G;
    }

    @Override // android.graphics.drawable.Drawable
    public void n() {
        this.y.clear();
        this.c.g();
    }

    @Override // android.graphics.drawable.Drawable
    public com.airbnb.lottie.d o() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int r() {
        return (int)f;
    }

    @Override // android.graphics.drawable.Drawable
    public Bitmap s(String string) {
        final b bVar = t();
        if (bVar != null) {
            return bVar.a(string);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleDrawable(Drawable drawable, Runnable runnable2, long l3) {
        final Drawable.Callback obj1 = getCallback();
        if (obj1 == null) {
        }
        obj1.scheduleDrawable(this, runnable2, l3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.I = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void start() {
        Drawable.Callback inEditMode;
        inEditMode = getCallback();
        if (inEditMode instanceof View != null && !(View)inEditMode.isInEditMode()) {
            if (!(View)inEditMode.isInEditMode()) {
                J();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void stop() {
        n();
    }

    @Override // android.graphics.drawable.Drawable
    public String u() {
        return this.B;
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleDrawable(Drawable drawable, Runnable runnable2) {
        final Drawable.Callback obj1 = getCallback();
        if (obj1 == null) {
        }
        obj1.unscheduleDrawable(this, runnable2);
    }

    @Override // android.graphics.drawable.Drawable
    public float v() {
        return this.c.l();
    }

    @Override // android.graphics.drawable.Drawable
    public float x() {
        return this.c.m();
    }

    @Override // android.graphics.drawable.Drawable
    public com.airbnb.lottie.n y() {
        com.airbnb.lottie.d dVar = this.b;
        if (dVar != null) {
            return dVar.m();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public float z() {
        return this.c.h();
    }
}
