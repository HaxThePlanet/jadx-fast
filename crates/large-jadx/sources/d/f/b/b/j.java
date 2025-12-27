package d.f.b.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.k;
import d.f.b.a.a;
import d.h.l.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MotionLayout.java */
/* loaded from: classes.dex */
public class j extends ConstraintLayout implements n {

    public static boolean S0;
    private int A0;
    private long B0;
    private float C0;
    private int D0;
    private float E0;
    protected boolean F0;
    float G0;
    private d.f.a.k.a.c H0;
    private boolean I0;
    private j.e J0;
    private Runnable K0;
    private int[] L0;
    l M;
    int M0;
    Interpolator N;
    private boolean N0;
    Interpolator O;
    j.g O0;
    float P;
    j.d P0;
    private int Q;
    private boolean Q0;
    int R;
    ArrayList<Integer> R0;
    private int S;
    private int T;
    private int U;
    private boolean V;
    HashMap<View, g> W;
    private long a0;
    private float b0;
    float c0;
    float d0;
    private long e0;
    float f0;
    private boolean g0;
    boolean h0;
    private j.f i0;
    int j0;
    j.c k0;
    private boolean l0;
    private a m0;
    private b n0;
    int o0;
    int p0;
    boolean q0;
    float r0;
    float s0;
    long t0;
    float u0;
    private boolean v0;
    private ArrayList<h> w0;
    private ArrayList<h> x0;
    private ArrayList<h> y0;
    private CopyOnWriteArrayList<j.f> z0;

    class a implements Runnable {

        final /* synthetic */ j a;
        a() {
            this.a = jVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.J0.a();
        }
    }

    static class b {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[j.g.values().length];
            j.b.a = iArr;
            try {
                iArr[j.g.UNDEFINED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                j.b.a[j.g.SETUP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                j.b.a[j.g.MOVING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                j.b.a[j.g.FINISHED.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    private class c {

        int[] a;
        float[] b;
        Paint c = new Paint();
        Paint d = new Paint();
        Paint e = new Paint();
        Paint f = new Paint();
        Paint g = new Paint();
        private float[] h;
        DashPathEffect i = new DashPathEffect();
        Rect j = new Rect();
        boolean k = false;
        int l;
        final /* synthetic */ j m;
        public c() {
            this.m = jVar;
            super();
            Rect rect = new Rect();
            int i3 = 1;
            this.l = i3;
            new Paint().setAntiAlias(true);
            this.c.setColor(-21965);
            float f2 = 2f;
            this.c.setStrokeWidth(f2);
            this.c.setStyle(Paint.Style.STROKE);
            new Paint().setAntiAlias(true);
            this.d.setColor(-2067046);
            this.d.setStrokeWidth(f2);
            this.d.setStyle(Paint.Style.STROKE);
            new Paint().setAntiAlias(true);
            int i9 = -13391360;
            this.e.setColor(i9);
            this.e.setStrokeWidth(f2);
            this.e.setStyle(Paint.Style.STROKE);
            new Paint().setAntiAlias(true);
            this.f.setColor(i9);
            this.f.setTextSize(jVar.getContext().getResources().getDisplayMetrics().density * 12f);
            this.h = new float[8];
            new Paint().setAntiAlias(true);
            this.e.setPathEffect(new DashPathEffect(new float[] { 1082130432, 1090519040 }, 0.0f));
            this.b = new float[100];
            this.a = new int[50];
            if (this.k) {
                float f = 8f;
                this.c.setStrokeWidth(f);
                this.g.setStrokeWidth(f);
                this.d.setStrokeWidth(f);
                this.l = 4;
            }
        }
    }

    class d {
        public void a() {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
    }

    class e {

        float a = NaNf;
        float b = NaNf;
        int c = -1;
        int d = -1;
        final /* synthetic */ j e;
        e() {
            this.e = jVar;
            super();
        }

        void a() {
            d.f.b.b.j jVar3;
            int i4 = -1;
            if (this.c != i4 || this.d != i4) {
                if (this.c == i4) {
                    this.e.K(this.d);
                } else {
                    if (this.d == i4) {
                        this.e.H(this.c, i4, i4);
                    } else {
                        this.e.I(this.c, this.d);
                    }
                }
                this.e.setState(j.g.SETUP);
            }
            if (Float.isNaN(this.b)) {
                if (Float.isNaN(this.a)) {
                    return;
                }
                this.e.setProgress(this.a);
                return;
            }
            this.e.G(this.a, this.b);
            float f3 = Float.NaN;
            this.a = f3;
            this.b = f3;
            this.c = i4;
            this.d = i4;
        }

        public Bundle b() {
            final Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.a);
            bundle.putFloat("motion.velocity", this.b);
            bundle.putInt("motion.StartState", this.c);
            bundle.putInt("motion.EndState", this.d);
            return bundle;
        }

        public void c() {
            this.d = this.e.S;
            this.c = this.e.Q;
            this.b = this.e.getVelocity();
            this.a = this.e.getProgress();
        }

        public void d(int i) {
            this.d = i;
        }

        public void e(float f) {
            this.a = f;
        }

        public void f(int i) {
            this.c = i;
        }

        public void g(Bundle bundle) {
            this.a = bundle.getFloat("motion.progress");
            this.b = bundle.getFloat("motion.velocity");
            this.c = bundle.getInt("motion.StartState");
            this.d = bundle.getInt("motion.EndState");
        }

        public void h(float f) {
            this.b = f;
        }
    }

    public interface f {
        void a(j jVar, int i, int i2, float f);

        void b(j jVar, int i, int i2);

        void c(j jVar, int i);
    }

    enum g {

        FINISHED,
        MOVING,
        SETUP,
        UNDEFINED;
    }
    private void A() {
        int i2;
        int i3;
        int i4;
        if (this.i0 != null || this.z0 != null || !this.z0.isEmpty()) {
            if (this.E0 != this.c0) {
                int i5 = -1;
                if (this.D0 != i5 && this.i0 != null) {
                    this.i0.b(this, this.Q, this.S);
                    if (this.z0 != null) {
                        Iterator it2 = this.z0.iterator();
                        while (it2.hasNext()) {
                            (j.f)it2.next().b(this, this.Q, this.S);
                        }
                    }
                }
                this.D0 = i5;
                this.E0 = this.c0;
                if (this.i0 != null) {
                    this.i0.a(this, this.Q, this.S, this.c0);
                }
                if (this.z0 != null) {
                    Iterator it = this.z0.iterator();
                    while (it.hasNext()) {
                        (j.f)it.next().a(this, this.Q, this.S, this.c0);
                    }
                }
            }
        }
    }

    private void E() {
        boolean hasNext;
        int value;
        if (this.i0 == null) {
            return;
        }
        Iterator it = this.R0.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        this.R0.clear();
    }

    static /* synthetic */ j.e v(j jVar) {
        return jVar.J0;
    }

    static /* synthetic */ int w(j jVar) {
        return jVar.S;
    }

    static /* synthetic */ int x(j jVar) {
        return jVar.Q;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void B() {
        int value;
        int i2;
        final int i6 = 1;
        if ((this.i0 != null || this.z0 != null || !this.z0.isEmpty()) && this.D0 == value) {
            this.D0 = this.R;
            if (!this.R0.isEmpty()) {
                i = this.R0.size() - i6;
                value = (Integer)this.R0.get(i).intValue();
            } else {
            }
            if (this.R0 != this.R && this.R != value) {
                this.R0.add(Integer.valueOf(this.R));
            }
        }
        E();
        if (this.K0 != null) {
            this.K0.run();
        }
        if (this.L0 != null && this.M0 > 0) {
            value = 0;
            K(iArr[value]);
            i2 = l02.length - i6;
            System.arraycopy(this.L0, i6, this.L0, value, i2);
            this.M0 -= i6;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public l.a C(int i) {
        this.M.h(i);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    void D() {
        if (this.M != null) {
            this.M.a(this, this.R);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void F() {
        this.P0.a();
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void G(float f, float f2) {
        if (!isAttachedToWindow() && this.J0 == null) {
            this.J0 = new j.e(this);
            this.J0.e(f);
            this.J0.h(f2);
            return;
        }
        setProgress(f);
        setState(j.g.MOVING);
        this.P = f2;
        y(1f);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void H(int i, int i2, int i3) {
        setState(j.g.SETUP);
        this.R = i;
        int i4 = -1;
        this.Q = i4;
        this.S = i4;
        if (this.C != null) {
            f = (float)i2;
            f2 = (float)i3;
            this.C.d(i, f, f2);
            return;
        }
        lVar.b(i);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void I(int i, int i2) {
        if (!isAttachedToWindow() && this.J0 == null) {
            this.J0 = new j.e(this);
            this.J0.f(i);
            this.J0.d(i2);
            return;
        }
        if (this.M != null) {
            this.Q = i;
            this.S = i2;
            this.M.l(i, i2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void J() {
        y(1f);
        this.K0 = null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void K(int i) {
        if (!isAttachedToWindow() && this.J0 == null) {
            this.J0 = new j.e(this);
            this.J0.d(i);
            return;
        }
        int i2 = -1;
        L(i, i2, i2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void L(int i, int i2, int i3) {
        M(i, i2, i3, -1);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void M(int i, int i2, int i3, int i4) {
        final Interpolator interpolator = null;
        if (this.M != null) {
            if (lVar.a != null) {
                lVar.a.a(this.R, i, (float)i2, (float)i3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) interpolator;
            }
        }
        if (this.R == i) {
            return;
        }
        float f4 = 1000f;
        float f5 = 0.0f;
        if (this.Q == i && this.R > 0) {
            f = (float)i4 / f4;
            this.b0 = f;
            return;
        }
        final float f6 = 1f;
        if (this.S == i && this.R > 0) {
            f2 = (float)i4 / f4;
            this.b0 = f2;
            return;
        }
        this.S = i;
        int i9 = -1;
        if (this.R != i9) {
            I(this.R, i);
            y(f6);
            this.d0 = 0.0f;
            J();
            if (this.R > 0) {
                f3 = (float)i4 / f4;
                this.b0 = f3;
            }
            return;
        }
        boolean z = false;
        this.l0 = z;
        this.f0 = f6;
        this.c0 = 0.0f;
        this.d0 = 0.0f;
        this.e0 = getNanoTime();
        this.a0 = getNanoTime();
        this.g0 = z;
        this.N = interpolator;
        if (this.R == i9) {
            this.M.e();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) interpolator;
        }
        this.Q = i9;
        this.M.l(i9, this.S);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) interpolator;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void dispatchDraw(Canvas canvas) {
        String str;
        int i;
        float f6 = 814313567;
        long l2 = -1;
        if (this.y0 != null) {
            Iterator it = this.y0.iterator();
            while (it.hasNext()) {
                (h)it.next().x(canvas);
            }
        }
        boolean z = false;
        z(z);
        final int i9 = 0;
        if (this.M != null) {
            if (lVar.c != null) {
                lVar.c.a();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i9;
            }
        }
        super.dispatchDraw(canvas);
        if (this.M == null) {
            return;
        }
        final int i10 = 1;
        i = this.j0 & i10;
        if ((this.j0 & i10) == i10 && !this.isInEditMode()) {
            this.A0 += i10;
            long nanoTime = getNanoTime();
            l2 = -1L;
            if (this.B0 == l2) {
                this.B0 = nanoTime;
            } else {
                l = nanoTime - l;
                l2 = 200000000L;
                if (this.B0 > l2) {
                    f6 = 0.000000001f;
                    float f13 = 100f;
                    float f = (float)this.A0 / (float)l * f6 * f13;
                    this.C0 = f / f13;
                    this.A0 = z;
                    this.B0 = nanoTime;
                }
            }
            Paint paint = new Paint();
            paint.setTextSize(42f);
            float f2 = getProgress() * 1000f;
            float f3 = 10f;
            StringBuilder stringBuilder = new StringBuilder();
            String str7 = " fps ";
            String str8 = a.c(this, this.Q);
            String str9 = " -> ";
            str4 = this.C0 + str7 + str8 + str9;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str4);
            stringBuilder2.append(a.c(this, this.S));
            stringBuilder2.append(" (progress: ");
            stringBuilder2.append(f2 / f3);
            stringBuilder2.append(" ) state=");
            if (this.R == -1) {
                str = "undefined";
            } else {
                str = a.c(this, this.R);
            }
            stringBuilder2.append(str);
            String str3 = stringBuilder2.toString();
            paint.setColor(-16777216);
            f5 = (float)(getHeight() - 29);
            canvas.drawText(str3, 11f, f5, paint);
            paint.setColor(-7864184);
            f4 = (float)(getHeight() - 30);
            canvas.drawText(str3, f3, f4, paint);
        }
        if (this.j0 > i10) {
            if (this.k0 != null) {
                this.M.e();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i9;
            } else {
                this.k0 = new j.c(this);
            }
        }
        if (this.y0 != null) {
            Iterator it2 = this.y0.iterator();
            while (it2.hasNext()) {
                (h)it2.next().w(canvas);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public int[] getConstraintSetIds() {
        final int i = 0;
        if (this.M != null) {
            this.M.c();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            return null;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public int getCurrentState() {
        return this.R;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public ArrayList<l.a> getDefinedTransitions() {
        final int i = 0;
        if (this.M != null) {
            this.M.d();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            return null;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public b getDesignTool() {
        if (this.n0 == null) {
            this.n0 = new b(this);
        }
        return this.n0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public int getEndState() {
        return this.S;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected long getNanoTime() {
        return System.nanoTime();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public float getProgress() {
        return this.d0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public int getStartState() {
        return this.Q;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public float getTargetPosition() {
        return this.f0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public Bundle getTransitionState() {
        if (this.J0 == null) {
            this.J0 = new j.e(this);
        }
        this.J0.c();
        return this.J0.b();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public long getTransitionTimeMs() {
        if (this.M != null) {
            this.M.e();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return (long)(this.b0 * 1000f);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public float getVelocity() {
        return this.P;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public boolean isAttachedToWindow() {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 19) {
            return super.isAttachedToWindow();
        }
        int r0 = getWindowToken() != null ? 1 : 0;
        return (getWindowToken() != null ? 1 : 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void n(int i) {
        this.C = null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= 17 && display != null) {
            display.getRotation();
        }
        int i = 0;
        if (this.M != null) {
            int i3 = -1;
            if (this.R != -1) {
                this.M.b(this.R);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            }
        }
        D();
        if (this.J0 != null) {
            if (this.N0) {
                post(new j.a(this));
            } else {
                this.J0.a();
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        final boolean z2 = false;
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        final boolean z2 = true;
        this.I0 = z2;
        final boolean z4 = false;
        try {
            super.onLayout(z, i, i2, i3, i4);
        } finally {
            this.I0 = z3;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) z;
        }
        i3 -= i;
        i4 -= i2;
        try {
            if (this.o0 != i6 || this.p0 != i7) {
                F();
                z(z2);
            }
            this.o0 = i6;
            this.p0 = i7;
        } finally {
            this.I0 = z3;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) z;
        }
        this.I0 = z4;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void onMeasure(int i, int i2) {
        if (this.M == null) {
            super.onMeasure(i, i2);
            return;
        }
        if (this.T == i) {
        }
        if (!this.Q0) {
            this.T = i;
            this.U = i2;
            this.M.g();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            boolean z = false;
            this.Q0 = z;
            D();
            E();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (this.M == null) {
            return;
        }
        if (lVar.b != null) {
            lVar.b.d();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        final int i11 = 0;
        if (this.q0 || i == 0 || i2 != 0) {
            iArr[i11] = iArr[i11] + i3;
            i = 1;
            i7 = iArr[i] + i4;
            iArr[i] = i7;
        }
        this.q0 = false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.t0 = getNanoTime();
        float f = 0.0f;
        this.u0 = f;
        this.r0 = f;
        this.s0 = f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onRtlPropertiesChanged(int i) {
        if (this.M != null) {
            this.M.k(l());
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onStopNestedScroll(View view, int i) {
        if (this.M != null) {
            if (this.u0 != 0) {
                this.M.i(this.r0 / f, this.s0 / f);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        z = view instanceof h;
        if (view instanceof h) {
            if (this.z0 == null) {
                this.z0 = new CopyOnWriteArrayList();
            }
            this.z0.add(view);
            if (view.v() && this.w0 == null) {
                this.w0 = new ArrayList();
                this.w0.add(view);
            }
            if (view.u() && this.x0 == null) {
                this.x0 = new ArrayList();
                this.x0.add(view);
            }
            if (view.t() && this.y0 == null) {
                this.y0 = new ArrayList();
                this.y0.add(view);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (this.w0 != null) {
            this.w0.remove(view);
        }
        if (this.x0 != null) {
            this.x0.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void requestLayout() {
        super.requestLayout();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setDebugMode(int i) {
        this.j0 = i;
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setDelayedApplicationOfInitialState(boolean z) {
        this.N0 = z;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setInteractionEnabled(boolean z) {
        this.V = z;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setInterpolatedProgress(float f) {
        if (this.M != null) {
            setState(j.g.MOVING);
            this.M.f();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            setProgress(f);
            return;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setOnHide(float f) {
        int i = 0;
        Object item;
        if (this.x0 != null) {
            i = 0;
            while (i < this.x0.size()) {
                (h)this.x0.get(i).setProgress(f);
                i = i + 1;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setOnShow(float f) {
        int i = 0;
        Object item;
        if (this.w0 != null) {
            i = 0;
            while (i < this.w0.size()) {
                (h)this.w0.get(i).setProgress(f);
                i = i + 1;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setProgress(float f) {
        float f2;
        float f3 = 1065353216;
        float f4 = 0.0f;
        f3 = 1f;
        if (f >= 0.0f) {
            if (f > f3) {
                str = "Warning! Progress is defined for values between 0.0 and 1.0 inclusive";
                Log.w("MotionLayout", str);
            }
        }
        if (!isAttachedToWindow() && this.J0 == null) {
            this.J0 = new j.e(this);
            this.J0.e(f);
            return;
        }
        if (f <= 0.0f) {
            if (this.d0 == f3 && this.R == this.S) {
                setState(j.g.MOVING);
            }
            this.R = this.Q;
            if (this.d0 == 0.0f) {
                setState(j.g.FINISHED);
            }
        } else {
            if (f >= f3) {
                if (this.d0 == 0.0f && this.R == this.Q) {
                    setState(j.g.MOVING);
                }
                this.R = this.S;
                if (this.d0 == f3) {
                    setState(j.g.FINISHED);
                }
            } else {
                this.R = -1;
                setState(j.g.MOVING);
            }
        }
        if (this.M == null) {
            return;
        }
        boolean z = true;
        this.g0 = z;
        this.f0 = f;
        this.c0 = f;
        long l = -1L;
        this.e0 = l;
        this.a0 = l;
        this.N = null;
        this.h0 = z;
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setScene(l lVar) {
        lVar.k(l());
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    void setStartState(int i) {
        if (!isAttachedToWindow() && this.J0 == null) {
            this.J0 = new j.e(this);
            this.J0.f(i);
            this.J0.d(i);
            return;
        }
        this.R = i;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    void setState(j.g gVar) {
        int i3 = 1;
        final d.f.b.b.j.g fINISHED2 = j.g.FINISHED;
        if (gVar == j.g.FINISHED && this.R == -1) {
            return;
        }
        this.O0 = gVar;
        mOVING2 = j.g.MOVING;
        if (this.O0 == j.g.MOVING && gVar == j.g.MOVING) {
            A();
        }
        int i4 = j.b.a[this.O0.ordinal()];
        i3 = 1;
        if (this.R == 1 || this.R == 2) {
            if (gVar == j.g.MOVING) {
                A();
            }
            if (gVar == j.g.FINISHED) {
                B();
            }
        } else {
            if (this.R == 3) {
                if (gVar == j.g.FINISHED) {
                    B();
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setTransition(int i) {
        if (this.M != null) {
            C(i);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setTransitionDuration(int i) {
        if (this.M != null) {
            this.M.j(i);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            Log.e("MotionLayout", "MotionScene not defined");
            return;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setTransitionListener(j.f fVar) {
        this.i0 = fVar;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setTransitionState(Bundle bundle) {
        if (this.J0 == null) {
            this.J0 = new j.e(this);
        }
        this.J0.g(bundle);
        if (isAttachedToWindow()) {
            this.J0.a();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public String toString() {
        Context context = getContext();
        final StringBuilder stringBuilder = new StringBuilder();
        String str5 = a.a(context, this.Q);
        String str6 = "->";
        String str = a.a(context, this.S);
        String str2 = " (pos:";
        String str3 = " Dpos/Dt:";
        str4 = str5 + str6 + str + str2 + this.d0 + str3 + this.P;
        return str4;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    void y(float f) {
        if (this.M == null) {
            return;
        }
        if (this.d0 != this.c0 && this.g0) {
            this.d0 = this.c0;
        }
        if (this.d0 != f) {
            this.l0 = false;
            this.f0 = f;
            this.M.e();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    void z(boolean z) {
        int cmp2;
        int cmp3;
        int i2;
        float interpolation;
        int cmp5;
        boolean z2;
        int cmp7;
        int childCount;
        int cmp8;
        Interpolator interpolator;
        int i3 = 1;
        int i4 = 0;
        boolean z7;
        int i5 = 0;
        int i6 = 1;
        double d;
        long nanoTime;
        float interpolation2 = 814313567;
        int i7 = 1;
        boolean z8;
        float f3 = 925353388;
        Object value;
        View childAt;
        long nanoTime2;
        d.f.a.k.a.c cVar;
        final Object z9 = this;
        if (z9.e0 == -1) {
            z9.e0 = getNanoTime();
        }
        interpolation = 0.0f;
        cmp8 = -1;
        interpolation = 1f;
        if (z9.d0 > 0.0f) {
            if (z9.d0 < interpolation) {
                z9.R = cmp8;
            }
        }
        boolean z6 = false;
        if (z9.v0 || z9.h0) {
            float signum = Math.signum(z9.f0 - signum);
            nanoTime = getNanoTime();
            interpolation2 = 0.000000001f;
            if (!(interpolator3 instanceof i)) {
                interpolation = (float)(nanoTime - z9.e0) * signum * interpolation2 / z9.b0;
            } else {
            }
            interpolation = z9.d0 + interpolation;
            if (z9.g0) {
            }
            if (signum > 0.0f) {
                if (z9.d0 < z9.f0) {
                    if (signum <= 0.0f) {
                        if (z9.d0 <= z9.f0) {
                            z9.h0 = z6;
                            i7 = 1;
                        } else {
                        }
                    }
                }
            }
            z9.d0 = interpolation;
            z9.c0 = interpolation;
            z9.e0 = nanoTime;
            f3 = 0.00001f;
            int i8 = 0;
            if (z9.N == null || z9.f0 != 0) {
                z9.P = interpolation;
            } else {
                if (z9.l0) {
                    interpolation = z9.N.getInterpolation((float)(nanoTime - z9.a0) * interpolation2);
                    if (z9.N == z9.m0) {
                        z9.m0.b();
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i8;
                    } else {
                        z9.d0 = interpolation;
                        z9.e0 = nanoTime;
                        z7 = interpolator instanceof i;
                        if (interpolator instanceof i) {
                            float f16 = interpolator.a();
                            z9.P = f16;
                            if (f16 > 0.0f) {
                                if (interpolation >= interpolation) {
                                    z9.d0 = interpolation;
                                    z9.h0 = false;
                                } else {
                                    i4 = 0;
                                }
                            }
                            if (f16 < 0.0f) {
                                if (z9.f0 - signum <= 0.0f) {
                                    z9.d0 = 0.0f;
                                    z9.h0 = i4;
                                } else {
                                }
                            }
                        }
                    }
                }
                z7 = interpolator4 instanceof i;
                if (interpolator4 instanceof i) {
                    z9.P = interpolator4.a();
                } else {
                    interpolation = interpolation + interpolation;
                    z9.P = (interpolator4.getInterpolation(interpolation) - z9.N.getInterpolation(interpolation)) * signum / interpolation;
                }
            }
            float abs = Math.abs(z9.P);
            if (abs > 0.00001f) {
                z9.setState(j.g.MOVING);
            }
            if (signum > 0.0f) {
                if (z9.d0 < z9.f0) {
                    if (signum <= 0.0f && z9.d0 <= z9.f0) {
                        boolean z3 = false;
                        z9.h0 = z3;
                    }
                }
            }
            if (z9.d0 < interpolation) {
                if (z9.d0 <= 0.0f) {
                    z9.h0 = false;
                    z9.setState(j.g.FINISHED);
                } else {
                    i5 = 0;
                }
            }
            z9.v0 = i5;
            z9.G0 = interpolation;
            if (z9.O == null) {
            } else {
                interpolation = z9.O.getInterpolation(interpolation);
            }
            if (z9.O != null) {
                float interpolation4 = z9.O.getInterpolation((signum / z9.b0) + interpolation);
                z9.P = interpolation4;
                z9.P = interpolation4 - z9.O.getInterpolation(interpolation);
            }
            while (z9.O < getChildCount()) {
                childAt = z9.getChildAt(i5);
            }
            if (signum > 0.0f) {
                if (z9.d0 < z9.f0) {
                    if (signum <= 0.0f) {
                        int r7 = z9.d0 <= z9.f0 ? 1 : 0;
                    }
                }
            }
            if (!z9.v0 && !z9.h0 && z9.m0 != 0) {
                z9.setState(j.g.FINISHED);
            }
            if (z9.F0) {
                requestLayout();
            }
            i3 = 1;
            z9.v0 |= i10;
            d = (double)interpolation;
            double d2 = 1d;
            if (z9.m0 >= d2) {
                if (z9.R != z9.S) {
                    z9.R = z9.S;
                    z9.M.b(z9.S);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i8;
                }
            }
            if (z9.F0 != 0 || z9.h0) {
                invalidate();
            }
            if (!z9.v0 && !z9.h0) {
                if (signum > 0.0f) {
                    if (z9.d0 != interpolation) {
                        if (signum < 0.0f && z9.d0 == 0.0f) {
                            D();
                        }
                    }
                }
            }
        } else {
            if (!z) {
                if (z9.f0 == z9.d0) {
                    i3 = 1;
                }
            }
        }
        if (z9.d0 >= interpolation) {
            if (z9.R == z9.S) {
                i3 = 0;
            }
            z9.R = z9.S;
        }
        z9.Q0 |= i3;
        if (z9.S != 0 && !z9.I0) {
            requestLayout();
        }
        z9.c0 = z9.d0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void setTransition(l.a aVar) {
        this.M.m(aVar);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
    }
}
