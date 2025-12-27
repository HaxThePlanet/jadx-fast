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
import com.airbnb.lottie.v.f;
import com.airbnb.lottie.x.s;
import com.airbnb.lottie.y.d;
import com.airbnb.lottie.y.g;
import com.airbnb.lottie.z.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: LottieDrawable.java */
/* loaded from: classes.dex */
public class f extends Drawable implements Drawable.Callback, Animatable {

    private com.airbnb.lottie.u.b A;
    private String B;
    private b C;
    private com.airbnb.lottie.u.a D;
    a E;
    s F;
    private boolean G;
    private com.airbnb.lottie.v.l.b H;
    private int I = 255;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M = true;
    private boolean N = false;
    private final Matrix a = new Matrix();
    private d b;
    private final com.airbnb.lottie.y.e c = new e();
    private float v = 1f;
    private boolean w = true;
    private boolean x = false;
    private final ArrayList<f.o> y = new ArrayList<>();
    private final ValueAnimator.AnimatorUpdateListener z = new f$f();

    class f implements ValueAnimator.AnimatorUpdateListener {

        final /* synthetic */ f a;
        f() {
            this.a = fVar;
            super();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.a.H != null) {
                this.a.H.H(this.a.c.h());
            }
        }
    }

    private interface o {
        void a(d dVar);
    }

    class a implements f.o {

        final /* synthetic */ String a;
        final /* synthetic */ f b;
        a(String str) {
            this.b = fVar;
            this.a = str;
            super();
        }

        public void a(d dVar) {
            this.b.W(this.a);
        }
    }

    class b implements f.o {

        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ f c;
        b(int i, int i2) {
            this.c = fVar;
            this.a = i;
            this.b = i2;
            super();
        }

        public void a(d dVar) {
            this.c.V(this.a, this.b);
        }
    }

    class c implements f.o {

        final /* synthetic */ int a;
        final /* synthetic */ f b;
        c(int i) {
            this.b = fVar;
            this.a = i;
            super();
        }

        public void a(d dVar) {
            this.b.P(this.a);
        }
    }

    class d implements f.o {

        final /* synthetic */ float a;
        final /* synthetic */ f b;
        d(float f) {
            this.b = fVar;
            this.a = f;
            super();
        }

        public void a(d dVar) {
            this.b.c0(this.a);
        }
    }

    class e implements f.o {

        final /* synthetic */ com.airbnb.lottie.v.e a;
        final /* synthetic */ Object b;
        final /* synthetic */ c c;
        final /* synthetic */ f d;
        e(com.airbnb.lottie.v.e eVar, Object object, c cVar) {
            this.d = fVar;
            this.a = eVar;
            this.b = object;
            this.c = cVar;
            super();
        }

        public void a(d dVar) {
            this.d.c(this.a, this.b, this.c);
        }
    }

    class g implements f.o {

        final /* synthetic */ f a;
        g() {
            this.a = fVar;
            super();
        }

        public void a(d dVar) {
            this.a.J();
        }
    }

    class h implements f.o {

        final /* synthetic */ f a;
        h() {
            this.a = fVar;
            super();
        }

        public void a(d dVar) {
            this.a.L();
        }
    }

    class i implements f.o {

        final /* synthetic */ int a;
        final /* synthetic */ f b;
        i(int i) {
            this.b = fVar;
            this.a = i;
            super();
        }

        public void a(d dVar) {
            this.b.X(this.a);
        }
    }

    class j implements f.o {

        final /* synthetic */ float a;
        final /* synthetic */ f b;
        j(float f) {
            this.b = fVar;
            this.a = f;
            super();
        }

        public void a(d dVar) {
            this.b.Z(this.a);
        }
    }

    class k implements f.o {

        final /* synthetic */ int a;
        final /* synthetic */ f b;
        k(int i) {
            this.b = fVar;
            this.a = i;
            super();
        }

        public void a(d dVar) {
            this.b.S(this.a);
        }
    }

    class l implements f.o {

        final /* synthetic */ float a;
        final /* synthetic */ f b;
        l(float f) {
            this.b = fVar;
            this.a = f;
            super();
        }

        public void a(d dVar) {
            this.b.U(this.a);
        }
    }

    class m implements f.o {

        final /* synthetic */ String a;
        final /* synthetic */ f b;
        m(String str) {
            this.b = fVar;
            this.a = str;
            super();
        }

        public void a(d dVar) {
            this.b.Y(this.a);
        }
    }

    class n implements f.o {

        final /* synthetic */ String a;
        final /* synthetic */ f b;
        n(String str) {
            this.b = fVar;
            this.a = str;
            super();
        }

        public void a(d dVar) {
            this.b.T(this.a);
        }
    }
    public f() {
        super();
        Matrix matrix = new Matrix();
        ArrayList arrayList = new ArrayList();
        new e().addUpdateListener(new f.f(this));
    }

    static /* synthetic */ com.airbnb.lottie.v.l.b a(f fVar) {
        return fVar.H;
    }

    static /* synthetic */ com.airbnb.lottie.y.e b(f fVar) {
        return fVar.c;
    }

    private float d(Rect rect) {
        return (float)rect.width() / (float)rect.height();
    }

    private boolean e() {
        boolean z = true;
        int i = 1;
        if (this.b != null) {
            if (!(getBounds().isEmpty())) {
                float f = d(getBounds());
                float f2 = d(this.b.b());
                if (f != f2) {
                    int i2 = 0;
                }
            }
        }
        return z;
    }

    private void f() {
        final com.airbnb.lottie.v.l.b bVar = new b(this, s.a(this.b), this.b.j(), this.b);
        this.H = bVar;
        if (this.K) {
            boolean z = true;
            bVar.F(z);
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
        int save = -1;
        float f;
        float f2;
        float f3;
        if (this.H == null) {
            return;
        }
        save = -1;
        Rect bounds = getBounds();
        f = (float)bounds.width() / (float)this.b.b().width();
        f2 = (float)bounds.height() / (float)this.b.b().height();
        if (this.M) {
            float min = Math.min(f, f2);
            f3 = 1f;
            if (min < f3) {
                f3 = f3 / min;
                f = f / f3;
                f2 = f2 / f3;
            } else {
            }
            if (f3 > f3) {
                save = canvas.save();
                float f16 = 2f;
                float f14 = (float)bounds.width() / f16;
                float f6 = (float)bounds.height() / f16;
                f4 = f14 * min;
                min *= f6;
                canvas.translate(f14 - f4, f6 - f12);
                canvas.scale(f3, f3, f4, f12);
            }
        }
        this.a.reset();
        this.a.preScale(f, f2);
        this.H.f(canvas, this.a, this.I);
        if (this.H > 0) {
            canvas.restoreToCount(save);
        }
    }

    private void k(Canvas canvas) {
        float f2;
        float f;
        int save = -1;
        if (this.H == null) {
            return;
        }
        f = w(canvas);
        float f8 = 1f;
        f2 = this.v > f ? f7 / f : f8;
        save = -1;
        if (this.H > f8) {
            save = canvas.save();
            float f14 = 2f;
            float f10 = (float)this.b.b().width() / f14;
            f4 = (float)this.b.b().height() / f14;
            f3 = f10 * f;
            f5 = f4 * f;
            f6 = (C() * f10) - f3;
            canvas.translate(f6, (C() * f4) - f5);
            canvas.scale(f2, f2, f3, f5);
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
            return null;
        }
        if (callback instanceof View) {
            return callback.getContext();
        }
        return i;
    }

    private com.airbnb.lottie.u.a q() {
        if (getCallback() == null) {
            return null;
        }
        if (this.D == null) {
            this.D = new a(getCallback(), this.E);
        }
        return this.D;
    }

    private com.airbnb.lottie.u.b t() {
        Context context;
        com.airbnb.lottie.u.b bVar3 = null;
        if (getCallback() == null) {
            return bVar3;
        }
        if (this.A != null && !this.A.b(this.p())) {
            this.A = bVar3;
        }
        if (this.A == null) {
            this.A = new b(getCallback(), this.B, this.C, this.b.i());
        }
        return this.A;
    }

    private float w(Canvas canvas) {
        return Math.min((float)canvas.getWidth() / (float)this.b.b().width(), (float)canvas.getHeight() / (float)this.b.b().height());
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
    public s E() {
        return this.F;
    }

    @Override // android.graphics.drawable.Drawable
    public Typeface F(String str, String str2) {
        final com.airbnb.lottie.u.a aVar = q();
        if (aVar != null) {
            return aVar.b(str, str2);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean G() {
        if (this.c == null) {
            return false;
        }
        return this.c.isRunning();
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
        float f;
        if (this.H == null) {
            this.y.add(new f.g(this));
            return;
        }
        if (this.w || this.A() == 0) {
            this.c.r();
        }
        if (!this.w) {
            float f3 = D();
            float f2 = 0.0f;
            if (f3 < 0.0f) {
                f = x();
            } else {
                f = v();
            }
            P((int)f);
            this.c.g();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public List<com.airbnb.lottie.v.e> K(com.airbnb.lottie.v.e eVar) {
        if (this.H == null) {
            d.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        final int i = 0;
        this.H.c(eVar, i, arrayList, new e(new String[i]));
        return arrayList;
    }

    @Override // android.graphics.drawable.Drawable
    public void L() {
        float f;
        if (this.H == null) {
            this.y.add(new f.h(this));
            return;
        }
        if (this.w || this.A() == 0) {
            this.c.v();
        }
        if (!this.w) {
            float f3 = D();
            float f2 = 0.0f;
            if (f3 < 0.0f) {
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
    public boolean N(d dVar) {
        boolean z3 = false;
        if (this.b == dVar) {
            return false;
        }
        this.N = z3;
        h();
        this.b = dVar;
        f();
        this.c.x(dVar);
        c0(this.c.getAnimatedFraction());
        g0(this.v);
        Iterator it = new ArrayList(this.y).iterator();
        while (it.hasNext()) {
            ArrayList item = it.next();
            it.remove();
        }
        this.y.clear();
        dVar.u(this.J);
        Drawable.Callback callback = getCallback();
        z = callback instanceof ImageView;
        if (callback instanceof ImageView) {
            callback.setImageDrawable(null);
            callback.setImageDrawable(this);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void O(a aVar) {
        if (this.D != null) {
            this.D.c(aVar);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void P(int i) {
        if (this.b == null) {
            this.y.add(new f.c(this, i));
            return;
        }
        this.c.y((float)i);
    }

    @Override // android.graphics.drawable.Drawable
    public void Q(b bVar) {
        this.C = bVar;
        if (this.A != null) {
            this.A.d(bVar);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void R(String str) {
        this.B = str;
    }

    @Override // android.graphics.drawable.Drawable
    public void S(int i) {
        if (this.b == null) {
            this.y.add(new f.k(this, i));
            return;
        }
        this.c.z((float)i + 0.99f);
    }

    @Override // android.graphics.drawable.Drawable
    public void T(String str) {
        if (this.b == null) {
            this.y.add(new f.n(this, str));
            return;
        }
        com.airbnb.lottie.v.h hVar = this.b.k(str);
        if (hVar == null) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "Cannot find marker with name ";
            String str3 = ".";
            str = str2 + str + str3;
            throw new IllegalArgumentException(str);
        } else {
            S((int)(hVar.b + hVar.c));
            return;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void U(float f) {
        if (this.b == null) {
            this.y.add(new f.l(this, f));
            return;
        }
        S((int)(g.k(this.b.o(), this.b.f(), f)));
    }

    @Override // android.graphics.drawable.Drawable
    public void V(int i, int i2) {
        if (this.b == null) {
            this.y.add(new f.b(this, i, i2));
            return;
        }
        this.c.A((float)i, (float)i2 + 0.99f);
    }

    @Override // android.graphics.drawable.Drawable
    public void W(String str) {
        if (this.b == null) {
            this.y.add(new f.a(this, str));
            return;
        }
        com.airbnb.lottie.v.h hVar = this.b.k(str);
        if (hVar == null) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "Cannot find marker with name ";
            String str3 = ".";
            str = str2 + str + str3;
            throw new IllegalArgumentException(str);
        } else {
            int i3 = (int)hVar.b;
            V(i3, (int)hVar.c + i3);
            return;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void X(int i) {
        if (this.b == null) {
            this.y.add(new f.i(this, i));
            return;
        }
        this.c.B(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void Y(String str) {
        if (this.b == null) {
            this.y.add(new f.m(this, str));
            return;
        }
        com.airbnb.lottie.v.h hVar = this.b.k(str);
        if (hVar == null) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "Cannot find marker with name ";
            String str3 = ".";
            str = str2 + str + str3;
            throw new IllegalArgumentException(str);
        } else {
            X((int)hVar.b);
            return;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void Z(float f) {
        if (this.b == null) {
            this.y.add(new f.j(this, f));
            return;
        }
        X((int)(g.k(this.b.o(), this.b.f(), f)));
    }

    @Override // android.graphics.drawable.Drawable
    public void a0(boolean z) {
        if (this.K == z) {
            return;
        }
        this.K = z;
        if (this.H != null) {
            this.H.F(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void b0(boolean z) {
        this.J = z;
        if (this.b != null) {
            this.b.u(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public <T> void c(com.airbnb.lottie.v.e eVar, T t, c<T> cVar) {
        int i = 0;
        int i2 = 1;
        boolean empty;
        if (this.H == null) {
            this.y.add(new f.e(this, eVar, t, cVar));
            return;
        }
        i2 = 1;
        if (eVar == e.c) {
            this.H.g(t, cVar);
        } else {
            if (eVar.d() != null) {
                eVar.d().g(t, cVar);
            } else {
                List list2 = K(eVar);
                i = 0;
                while (this.y < list2.size()) {
                    (e)list2.get(i).d().g(t, cVar);
                    i = i + 1;
                }
                i2 = 1 ^ list2.isEmpty();
            }
        }
        if (i2 != 0) {
            invalidateSelf();
            if (t == k.C) {
                c0(z());
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void c0(float f) {
        if (this.b == null) {
            this.y.add(new f.d(this, f));
            return;
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
        this.N = false;
        String str = "Drawable#draw";
        c.a(str);
        if (this.x) {
            try {
                i(canvas);
            } catch (Throwable th) {
                d.b("Lottie crashed in draw!", th);
            }
        } else {
            i(th);
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
        int i = -1;
        if (this.b == null) {
            i = -1;
        } else {
            i = (int)(float)this.b.b().height() * C();
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = -1;
        if (this.b == null) {
            i = -1;
        } else {
            i = (int)(float)this.b.b().width() * C();
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void h() {
        if (this.c.isRunning()) {
            this.c.cancel();
        }
        com.airbnb.lottie.d dVar = null;
        this.b = dVar;
        this.H = dVar;
        this.A = dVar;
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
        final Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.N) {
            return;
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
    public boolean k0() {
        boolean z = false;
        if (this.F == null) {
            int r0 = this.b.c().k() > 0 ? 1 : 0;
        }
        return (this.b.c().k() > 0 ? 1 : 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void l(boolean z) {
        if (this.G == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            d.c("Merge paths are not supported pre-Kit Kat.");
            return;
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
    public d o() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int r() {
        return (int)this.c.j();
    }

    @Override // android.graphics.drawable.Drawable
    public Bitmap s(String str) {
        final com.airbnb.lottie.u.b bVar = t();
        if (bVar != null) {
            return bVar.a(str);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        final Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
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
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            if (!callback.isInEditMode()) {
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
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        final Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
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
    public n y() {
        if (this.b != null) {
            return this.b.m();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public float z() {
        return this.c.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void j0(s sVar) {
    }
}
