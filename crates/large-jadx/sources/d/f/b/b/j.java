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
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.k;
import d.f.a.k.a.c;
import d.f.b.a.a;
import d.h.l.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

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
    private c H0;
    private boolean I0;
    private d.f.b.b.j.e J0;
    private Runnable K0;
    private int[] L0;
    d.f.b.b.l M;
    int M0;
    Interpolator N;
    private boolean N0;
    Interpolator O;
    d.f.b.b.j.g O0;
    float P;
    d.f.b.b.j.d P0;
    private int Q;
    private boolean Q0;
    int R;
    ArrayList<Integer> R0;
    private int S;
    private int T;
    private int U;
    private boolean V;
    HashMap<View, d.f.b.b.g> W;
    private long a0;
    private float b0;
    float c0;
    float d0;
    private long e0;
    float f0;
    private boolean g0;
    boolean h0;
    private d.f.b.b.j.f i0;
    int j0;
    d.f.b.b.j.c k0;
    private boolean l0;
    private a m0;
    private d.f.b.b.b n0;
    int o0;
    int p0;
    boolean q0;
    float r0;
    float s0;
    long t0;
    float u0;
    private boolean v0;
    private ArrayList<d.f.b.b.h> w0;
    private ArrayList<d.f.b.b.h> x0;
    private ArrayList<d.f.b.b.h> y0;
    private CopyOnWriteArrayList<d.f.b.b.j.f> z0;

    class a implements Runnable {

        final d.f.b.b.j a;
        a(d.f.b.b.j j) {
            this.a = j;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            j.v(this.a).a();
        }
    }

    static class b {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            j.b.a = iArr;
            iArr[j.g.UNDEFINED.ordinal()] = 1;
            j.b.a[j.g.SETUP.ordinal()] = 2;
            j.b.a[j.g.MOVING.ordinal()] = 3;
            j.b.a[j.g.FINISHED.ordinal()] = 4;
        }
    }

    private class c {

        int[] a;
        float[] b;
        Paint c;
        Paint d;
        Paint e;
        Paint f;
        Paint g;
        private float[] h;
        DashPathEffect i;
        Rect j;
        boolean k = false;
        int l;
        final d.f.b.b.j m;
        public c(d.f.b.b.j j) {
            Paint paint;
            boolean obj5;
            this.m = j;
            super();
            Rect rect = new Rect();
            this.j = rect;
            int i2 = 0;
            int i3 = 1;
            this.l = i3;
            Paint paint2 = new Paint();
            this.c = paint2;
            paint2.setAntiAlias(i3);
            this.c.setColor(-21965);
            int i7 = 1073741824;
            this.c.setStrokeWidth(i7);
            this.c.setStyle(Paint.Style.STROKE);
            Paint paint6 = new Paint();
            this.d = paint6;
            paint6.setAntiAlias(i3);
            this.d.setColor(-2067046);
            this.d.setStrokeWidth(i7);
            this.d.setStyle(Paint.Style.STROKE);
            Paint paint10 = new Paint();
            this.e = paint10;
            paint10.setAntiAlias(i3);
            int i10 = -13391360;
            this.e.setColor(i10);
            this.e.setStrokeWidth(i7);
            this.e.setStyle(Paint.Style.STROKE);
            Paint paint14 = new Paint();
            this.f = paint14;
            paint14.setAntiAlias(i3);
            this.f.setColor(i10);
            this.f.setTextSize(obj5 *= i8);
            this.h = new float[8];
            obj5 = new Paint();
            this.g = obj5;
            obj5.setAntiAlias(i3);
            float[] fArr = new float[2];
            fArr = new int[]{1082130432, 1090519040};
            obj5 = new DashPathEffect(fArr, 0);
            this.i = obj5;
            this.e.setPathEffect(obj5);
            this.b = new float[100];
            this.a = new int[50];
            if (this.k) {
                paint = 1090519040;
                this.c.setStrokeWidth(paint);
                this.g.setStrokeWidth(paint);
                this.d.setStrokeWidth(paint);
                this.l = 4;
            }
        }
    }

    class d {
        public void a() {
            throw 0;
        }
    }

    class e {

        float a = NaNf;
        float b = NaNf;
        int c = -1;
        int d = -1;
        final d.f.b.b.j e;
        e(d.f.b.b.j j) {
            this.e = j;
            super();
            int obj1 = 2143289344;
            obj1 = -1;
        }

        void a() {
            d.f.b.b.j i;
            int sETUP;
            int i2;
            d.f.b.b.j jVar;
            i = this.c;
            int i4 = -1;
            if (i == i4) {
                if (this.d != i4) {
                    if (i == i4) {
                        this.e.K(this.d);
                    } else {
                        i2 = this.d;
                        if (i2 == i4) {
                            this.e.H(i, i4, i4);
                        } else {
                            this.e.I(i, i2);
                        }
                    }
                    this.e.setState(j.g.SETUP);
                }
            } else {
            }
            if (Float.isNaN(this.b) && Float.isNaN(this.a)) {
                if (Float.isNaN(this.a)) {
                }
                this.e.setProgress(this.a);
            }
            this.e.G(this.a, this.b);
            int i3 = 2143289344;
            this.a = i3;
            this.b = i3;
            this.c = i4;
            this.d = i4;
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.a);
            bundle.putFloat("motion.velocity", this.b);
            bundle.putInt("motion.StartState", this.c);
            bundle.putInt("motion.EndState", this.d);
            return bundle;
        }

        public void c() {
            this.d = j.w(this.e);
            this.c = j.x(this.e);
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
        public abstract void a(d.f.b.b.j j, int i2, int i3, float f4);

        public abstract void b(d.f.b.b.j j, int i2, int i3);

        public abstract void c(d.f.b.b.j j, int i2);
    }

    static enum g {

        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED;
    }
    private void A() {
        d.f.b.b.j.f iterator2;
        int iterator;
        d.f.b.b.j.f next2;
        int next;
        int i2;
        int i;
        if (this.i0 == null) {
            iterator2 = this.z0;
            int i3 = -1;
            d.f.b.b.j.f fVar = this.i0;
            if (iterator2 != null && !iterator2.isEmpty() && Float.compare(e0, next2) != 0 && this.D0 != i3 && fVar != null) {
                if (!iterator2.isEmpty()) {
                    if (Float.compare(e0, next2) != 0) {
                        i3 = -1;
                        if (this.D0 != i3) {
                            fVar = this.i0;
                            if (fVar != null) {
                                fVar.b(this, this.Q, this.S);
                            }
                            iterator = this.z0;
                            if (iterator != null) {
                                iterator = iterator.iterator();
                                for (j.f next : iterator) {
                                    next.b(this, this.Q, this.S);
                                }
                            }
                        }
                        this.D0 = i3;
                        float f = this.c0;
                        this.E0 = f;
                        next2 = this.i0;
                        if (next2 != null) {
                            next2.a(this, this.Q, this.S, f);
                        }
                        iterator2 = this.z0;
                        if (iterator2 != null) {
                            iterator2 = iterator2.iterator();
                            for (j.f next2 : iterator2) {
                                next2.a(this, this.Q, this.S, this.c0);
                            }
                        }
                    }
                }
            }
        } else {
        }
    }

    private void E() {
        CopyOnWriteArrayList empty;
        Object next;
        Object iterator;
        int intValue;
        int intValue2;
        empty = this.z0;
        if (this.i0 == null && empty != null && empty.isEmpty()) {
            empty = this.z0;
            if (empty != null) {
                if (empty.isEmpty()) {
                }
            }
        }
        Iterator iterator2 = this.R0.iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            d.f.b.b.j.f fVar = this.i0;
            if (fVar != null) {
            }
            iterator = this.z0;
            if (iterator != null) {
            }
            iterator = iterator.iterator();
            for (j.f intValue : iterator) {
                intValue.c(this, (Integer)next.intValue());
            }
            (j.f)iterator.next().c(this, next.intValue());
            fVar.c(this, next.intValue());
        }
        this.R0.clear();
    }

    static d.f.b.b.j.e v(d.f.b.b.j j) {
        return j.J0;
    }

    static int w(d.f.b.b.j j) {
        return j.S;
    }

    static int x(d.f.b.b.j j) {
        return j.Q;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void B() {
        d.f.b.b.j.f intValue;
        int[] iArr;
        int valueOf;
        int i;
        final int i4 = 1;
        if (this.i0 == null) {
            intValue = this.z0;
            valueOf = -1;
            if (intValue != null && !intValue.isEmpty() && this.D0 == valueOf) {
                if (!intValue.isEmpty()) {
                    valueOf = -1;
                    if (this.D0 == valueOf) {
                        this.D0 = this.R;
                        if (!this.R0.isEmpty()) {
                            ArrayList r02 = this.R0;
                            intValue = (Integer)r02.get(size -= i4).intValue();
                        } else {
                            intValue = valueOf;
                        }
                        i = this.R;
                        if (intValue != i && i != valueOf) {
                            if (i != valueOf) {
                                this.R0.add(Integer.valueOf(i));
                            }
                        }
                    }
                }
            }
        } else {
        }
        E();
        Runnable k0 = this.K0;
        if (k0 != null) {
            k0.run();
        }
        iArr = this.L0;
        if (iArr != null && this.M0 > 0) {
            if (this.M0 > 0) {
                valueOf = 0;
                K(iArr[valueOf]);
                int[] l0 = this.L0;
                System.arraycopy(l0, i4, l0, valueOf, length -= i4);
                this.M0 = m0 -= i4;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public d.f.b.b.l.a C(int i) {
        this.M.h(i);
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    void D() {
        d.f.b.b.l lVar = this.M;
        if (lVar != null) {
        } else {
        }
        lVar.a(this, this.R);
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void F() {
        this.P0.a();
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void G(float f, float f2) {
        d.f.b.b.j.e eVar;
        if (!isAttachedToWindow() && this.J0 == null) {
            if (this.J0 == null) {
                eVar = new j.e(this);
                this.J0 = eVar;
            }
            this.J0.e(f);
            this.J0.h(f2);
        }
        setProgress(f);
        setState(j.g.MOVING);
        this.P = f2;
        y(1065353216);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void H(int i, int i2, int i3) {
        float obj3;
        float obj4;
        setState(j.g.SETUP);
        this.R = i;
        int i4 = -1;
        this.Q = i4;
        this.S = i4;
        c cVar = this.C;
        if (cVar != null) {
            cVar.d(i, (float)i2, (float)i3);
        } else {
            obj3 = this.M;
            if (obj3 != null) {
            } else {
            }
        }
        obj3.b(i);
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void I(int i, int i2) {
        d.f.b.b.j.e eVar;
        if (!isAttachedToWindow() && this.J0 == null) {
            if (this.J0 == null) {
                eVar = new j.e(this);
                this.J0 = eVar;
            }
            this.J0.f(i);
            this.J0.d(i2);
        }
        d.f.b.b.l lVar = this.M;
        if (lVar != null) {
        } else {
        }
        this.Q = i;
        this.S = i2;
        lVar.l(i, i2);
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void J() {
        y(1065353216);
        this.K0 = 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void K(int i) {
        d.f.b.b.j.e eVar;
        if (!isAttachedToWindow() && this.J0 == null) {
            if (this.J0 == null) {
                eVar = new j.e(this);
                this.J0 = eVar;
            }
            this.J0.d(i);
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
        Object lVar;
        int obj5;
        lVar = this.M;
        final int i6 = 0;
        if (lVar != null) {
            lVar = lVar.a;
            if (lVar != null) {
            } else {
            }
            lVar.a(this.R, i, (float)i2, (float)i3);
            throw i6;
        }
        int obj6 = this.R;
        if (obj6 == i) {
        }
        int i5 = 1148846080;
        int i7 = 0;
        y(i7);
        if (this.Q == i && i4 > 0) {
            y(i7);
            if (i4 > 0) {
                this.b0 = obj5 /= i5;
            }
        }
        final int i8 = 1065353216;
        y(i8);
        if (this.S == i && i4 > 0) {
            y(i8);
            if (i4 > 0) {
                this.b0 = obj5 /= i5;
            }
        }
        this.S = i;
        int obj7 = -1;
        I(obj6, i);
        y(i8);
        this.d0 = i7;
        J();
        if (obj6 != obj7 && i4 > 0) {
            I(obj6, i);
            y(i8);
            this.d0 = i7;
            J();
            if (i4 > 0) {
                this.b0 = obj5 /= i5;
            }
        }
        obj5 = 0;
        this.l0 = obj5;
        this.f0 = i8;
        this.c0 = i7;
        this.d0 = i7;
        this.e0 = getNanoTime();
        this.a0 = getNanoTime();
        this.g0 = obj5;
        this.N = i6;
        if (i4 == obj7) {
            this.M.e();
            throw i6;
        }
        this.Q = obj7;
        this.M.l(obj7, this.S);
        throw i6;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void dispatchDraw(Canvas canvas) {
        Object iterator;
        int paint;
        Object iterator2;
        Object next;
        Object lVar;
        int cmp;
        String str;
        int inEditMode;
        int i;
        float f;
        long i2;
        float f2;
        int i3;
        int i4;
        d.f.b.b.j.c obj11;
        iterator = this.y0;
        if (iterator != null) {
            iterator = iterator.iterator();
            for (h next : iterator) {
                next.x(canvas);
            }
        }
        paint = 0;
        z(paint);
        lVar = this.M;
        final int i16 = 0;
        if (lVar != null) {
            lVar = lVar.c;
            if (lVar != null) {
            } else {
            }
            lVar.a();
            throw i16;
        }
        super.dispatchDraw(canvas);
        if (this.M == null) {
        }
        final int i17 = 1;
        if (i6 &= i17 == i17 && !isInEditMode()) {
            if (!isInEditMode()) {
                this.A0 = a0 += i17;
                long nanoTime = getNanoTime();
                i2 = this.B0;
                if (Long.compare(i2, i4) != 0) {
                    i2 = nanoTime - i2;
                    if (Long.compare(i2, i4) > 0) {
                        i2 = 1120403456;
                        this.C0 = f4 /= i2;
                        this.A0 = paint;
                        this.B0 = nanoTime;
                    }
                } else {
                    this.B0 = nanoTime;
                }
                paint = new Paint();
                paint.setTextSize(1109917696);
                i = 1092616192;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.C0);
                stringBuilder.append(" fps ");
                stringBuilder.append(a.c(this, this.Q));
                stringBuilder.append(" -> ");
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(stringBuilder.toString());
                stringBuilder2.append(a.c(this, this.S));
                stringBuilder2.append(" (progress: ");
                stringBuilder2.append(f5 /= i);
                stringBuilder2.append(" ) state=");
                int i15 = this.R;
                if (i15 == -1) {
                    str = "undefined";
                } else {
                    str = a.c(this, i15);
                }
                stringBuilder2.append(str);
                inEditMode = stringBuilder2.toString();
                paint.setColor(-16777216);
                canvas.drawText(inEditMode, 1093664768, (float)i27, paint);
                paint.setColor(-7864184);
                canvas.drawText(inEditMode, i, (float)i24, paint);
            }
        }
        if (this.j0 > i17) {
            if (this.k0 != null) {
            } else {
                obj11 = new j.c(this);
                this.k0 = obj11;
            }
            this.M.e();
            throw i16;
        }
        iterator2 = this.y0;
        if (iterator2 != null) {
            iterator2 = iterator2.iterator();
            for (h inEditMode : iterator2) {
                inEditMode.w(canvas);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public int[] getConstraintSetIds() {
        final d.f.b.b.l lVar = this.M;
        final int i = 0;
        if (lVar != null) {
        } else {
            return i;
        }
        lVar.c();
        throw i;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public int getCurrentState() {
        return this.R;
    }

    public ArrayList<d.f.b.b.l.a> getDefinedTransitions() {
        final d.f.b.b.l lVar = this.M;
        final int i = 0;
        if (lVar != null) {
        } else {
            return i;
        }
        lVar.d();
        throw i;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public d.f.b.b.b getDesignTool() {
        d.f.b.b.b bVar;
        if (this.n0 == null) {
            bVar = new b(this);
            this.n0 = bVar;
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
        d.f.b.b.j.e eVar;
        if (this.J0 == null) {
            eVar = new j.e(this);
            this.J0 = eVar;
        }
        this.J0.c();
        return this.J0.b();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public long getTransitionTimeMs() {
        d.f.b.b.l lVar = this.M;
        if (lVar != null) {
        } else {
            return (long)i;
        }
        lVar.e();
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public float getVelocity() {
        return this.P;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public boolean isAttachedToWindow() {
        int i;
        if (Build.VERSION.SDK_INT >= 19) {
            return super.isAttachedToWindow();
        }
        i = getWindowToken() != null ? 1 : 0;
        return i;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void n(int i) {
        this.C = 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void onAttachedToWindow() {
        int sDK_INT;
        Object aVar;
        int i;
        int i2;
        int i3;
        super.onAttachedToWindow();
        sDK_INT = getDisplay();
        if (Build.VERSION.SDK_INT >= 17 && sDK_INT != null) {
            sDK_INT = getDisplay();
            if (sDK_INT != null) {
                sDK_INT.getRotation();
            }
        }
        d.f.b.b.l lVar = this.M;
        i = 0;
        if (lVar != null) {
            i2 = this.R;
            if (i2 != -1) {
            } else {
            }
            lVar.b(i2);
            throw i;
        }
        D();
        aVar = this.J0;
        if (aVar != null) {
            if (this.N0) {
                aVar = new j.a(this);
                post(aVar);
            } else {
                aVar.a();
            }
        } else {
            aVar = this.M;
            if (aVar != null) {
                aVar = aVar.b;
                if (aVar != null) {
                } else {
                }
                aVar.a();
                throw i;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        final d.f.b.b.l lVar = this.M;
        final int i = 0;
        if (lVar != null) {
            if (!this.V) {
            } else {
                d.f.b.b.n nVar = lVar.c;
                final int i2 = 0;
                if (nVar != null) {
                } else {
                    final d.f.b.b.l.a obj5 = lVar.b;
                    if (obj5 != null) {
                    } else {
                        return i;
                    }
                    obj5.d();
                    throw i2;
                }
            }
            nVar.b(motionEvent);
            throw i2;
        }
        return i;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int obj4;
        final int i = 1;
        this.I0 = i;
        final int i6 = 0;
        if (this.M == null) {
            super.onLayout(z, i2, i3, i4, i5);
            this.I0 = i6;
        }
        i4 -= i2;
        i5 -= i3;
        if (this.o0 == obj7) {
            if (this.p0 != obj8) {
                try {
                    F();
                    z(i);
                    this.o0 = obj7;
                    this.p0 = obj8;
                    this.I0 = i6;
                    this.I0 = obj1;
                    throw z;
                }
            }
        } else {
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void onMeasure(int i, int i2) {
        int i4;
        boolean i3;
        if (this.M == null) {
            super.onMeasure(i, i2);
        }
        if (this.T == i) {
            i4 = this.U;
        }
        if (!this.Q0) {
        } else {
            this.Q0 = false;
            D();
            E();
        }
        boolean z = this.z;
        this.T = i;
        this.U = i2;
        this.M.g();
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public boolean onNestedFling(View view, float f2, float f3, boolean z4) {
        return 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onNestedPreScroll(View view, int i2, int i3, int[] i4Arr4, int i5) {
        d.f.b.b.l obj1 = this.M;
        if (obj1 == null) {
        }
        obj1 = obj1.b;
        if (obj1 != null) {
        } else {
        }
        obj1.d();
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] i7Arr7) {
        int obj1;
        int obj2;
        final int obj6 = 0;
        if (!this.q0 && i2 == 0) {
            if (i2 == 0) {
                if (i3 != 0) {
                    i7Arr7[obj6] = obj1 += i4;
                    obj1 = 1;
                    i7Arr7[obj1] = obj2 += i5;
                }
            } else {
            }
        } else {
        }
        this.q0 = obj6;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onNestedScrollAccepted(View view, View view2, int i3, int i4) {
        this.t0 = getNanoTime();
        int obj1 = 0;
        this.u0 = obj1;
        this.r0 = obj1;
        this.s0 = obj1;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onRtlPropertiesChanged(int i) {
        d.f.b.b.l obj2 = this.M;
        if (obj2 != null) {
        } else {
        }
        obj2.k(l());
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public boolean onStartNestedScroll(View view, View view2, int i3, int i4) {
        Object obj1;
        obj1 = this.M;
        if (obj1 != null) {
            obj1 = obj1.b;
            if (obj1 != null) {
            } else {
            }
            obj1.c();
            throw 0;
        }
        return 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onStopNestedScroll(View view, int i2) {
        int cmp;
        float obj4;
        d.f.b.b.l obj3 = this.M;
        if (obj3 != null) {
            obj4 = this.u0;
            if (Float.compare(obj4, i) != 0) {
            } else {
            }
            obj3.i(f /= obj4, f2 /= obj4);
            throw 0;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        final d.f.b.b.l lVar = this.M;
        if (lVar != null) {
            if (this.V) {
            } else {
            }
            lVar.n();
            throw 0;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onViewAdded(View view) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        ArrayList arrayList2;
        boolean z3;
        boolean z2;
        ArrayList arrayList3;
        ArrayList arrayList;
        boolean z;
        super.onViewAdded(view);
        if (view instanceof h && this.z0 == null) {
            if (this.z0 == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
                this.z0 = copyOnWriteArrayList;
            }
            this.z0.add((h)(h)view);
            if (view.v() && this.w0 == null) {
                if (this.w0 == null) {
                    arrayList2 = new ArrayList();
                    this.w0 = arrayList2;
                }
                this.w0.add(view);
            }
            if (view.u() && this.x0 == null) {
                if (this.x0 == null) {
                    arrayList = new ArrayList();
                    this.x0 = arrayList;
                }
                this.x0.add(view);
            }
            if (view.t() && this.y0 == null) {
                if (this.y0 == null) {
                    arrayList3 = new ArrayList();
                    this.y0 = arrayList3;
                }
                this.y0.add(view);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList list = this.w0;
        if (list != null) {
            list.remove(view);
        }
        ArrayList list2 = this.x0;
        if (list2 != null) {
            list2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void requestLayout() {
        boolean i;
        int i2;
        i = this.M;
        if (!this.F0 && this.R == -1 && i != null) {
            if (this.R == -1) {
                i = this.M;
                if (i != null) {
                    i = i.b;
                    if (i != null) {
                    } else {
                    }
                    i.b();
                    throw 0;
                }
            }
        }
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
        } else {
            setProgress(f);
        }
        setState(j.g.MOVING);
        this.M.f();
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setOnHide(float f) {
        ArrayList size;
        int i;
        Object obj;
        size = this.x0;
        if (size != null) {
            i = 0;
            while (i < size.size()) {
                (h)this.x0.get(i).setProgress(f);
                i++;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setOnShow(float f) {
        ArrayList size;
        int i;
        Object obj;
        size = this.w0;
        if (size != null) {
            i = 0;
            while (i < size.size()) {
                (h)this.w0.get(i).setProgress(f);
                i++;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setProgress(float f) {
        d.f.b.b.j.e eVar;
        int fINISHED;
        int mOVING;
        float cmp;
        int mOVING2;
        int i;
        int cmp2;
        String str;
        int i2 = 0;
        int cmp3 = Float.compare(f, i2);
        i = 1065353216;
        if (cmp3 >= 0) {
            if (Float.compare(f, i) > 0) {
                Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
            }
        } else {
        }
        if (!isAttachedToWindow() && this.J0 == null) {
            if (this.J0 == null) {
                eVar = new j.e(this);
                this.J0 = eVar;
            }
            this.J0.e(f);
        }
        if (cmp3 <= 0) {
            if (Float.compare(f3, i) == 0 && this.R == this.S) {
                if (this.R == this.S) {
                    setState(j.g.MOVING);
                }
            }
            this.R = this.Q;
            if (Float.compare(cmp, i2) == 0) {
                setState(j.g.FINISHED);
            }
        } else {
            if (Float.compare(f, i) >= 0) {
                if (Float.compare(cmp, i2) == 0 && this.R == this.Q) {
                    if (this.R == this.Q) {
                        setState(j.g.MOVING);
                    }
                }
                this.R = this.S;
                if (Float.compare(f2, i) == 0) {
                    setState(j.g.FINISHED);
                }
            } else {
                this.R = -1;
                setState(j.g.MOVING);
            }
        }
        if (this.M == null) {
        }
        int i3 = 1;
        this.g0 = i3;
        this.f0 = f;
        this.c0 = f;
        int i6 = -1;
        this.e0 = i6;
        this.a0 = i6;
        this.N = 0;
        this.h0 = i3;
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setScene(d.f.b.b.l l) {
        l.k(l());
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    void setStartState(int i) {
        d.f.b.b.j.e eVar;
        if (!isAttachedToWindow() && this.J0 == null) {
            if (this.J0 == null) {
                eVar = new j.e(this);
                this.J0 = eVar;
            }
            this.J0.f(i);
            this.J0.d(i);
        }
        this.R = i;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    void setState(d.f.b.b.j.g j$g) {
        int i3;
        int i2;
        d.f.b.b.j.g mOVING;
        int i;
        final d.f.b.b.j.g fINISHED = j.g.FINISHED;
        if (g == fINISHED && this.R == -1) {
            if (this.R == -1) {
            }
        }
        d.f.b.b.j.g o0 = this.O0;
        this.O0 = g;
        mOVING = j.g.MOVING;
        if (o0 == mOVING && g == mOVING) {
            if (g == mOVING) {
                A();
            }
        }
        int i4 = j.b.a[o0.ordinal()];
        if (i4 != 1 && i4 != 2) {
            if (i4 != 2) {
                if (i4 != 3) {
                } else {
                    if (g == fINISHED) {
                        B();
                    }
                }
            } else {
                if (g == mOVING) {
                    A();
                }
                if (g == fINISHED) {
                    B();
                }
            }
        } else {
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setTransition(int i) {
        if (this.M != null) {
        } else {
        }
        C(i);
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void setTransition(d.f.b.b.l.a l$a) {
        this.M.m(a);
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setTransitionDuration(int i) {
        d.f.b.b.l lVar = this.M;
        if (lVar != null) {
        } else {
            Log.e("MotionLayout", "MotionScene not defined");
        }
        lVar.j(i);
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setTransitionListener(d.f.b.b.j.f j$f) {
        this.i0 = f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setTransitionState(Bundle bundle) {
        d.f.b.b.j.e eVar;
        boolean obj2;
        if (this.J0 == null) {
            eVar = new j.e(this);
            this.J0 = eVar;
        }
        this.J0.g(bundle);
        if (isAttachedToWindow()) {
            this.J0.a();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public String toString() {
        Context context = getContext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.a(context, this.Q));
        stringBuilder.append("->");
        stringBuilder.append(a.a(context, this.S));
        stringBuilder.append(" (pos:");
        stringBuilder.append(this.d0);
        stringBuilder.append(" Dpos/Dt:");
        stringBuilder.append(this.P);
        return stringBuilder.toString();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    void y(float f) {
        int cmp;
        final d.f.b.b.l lVar = this.M;
        if (lVar == null) {
        }
        final float f4 = this.c0;
        if (Float.compare(f2, f4) != 0 && this.g0) {
            if (this.g0) {
                this.d0 = f4;
            }
        }
        if (Float.compare(f3, f) != 0) {
        } else {
        }
        this.l0 = false;
        this.f0 = f;
        lVar.e();
        throw 0;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    void z(boolean z) {
        int nanoTime;
        int signum;
        int cmp3;
        int i7;
        int i9;
        int cmp9;
        boolean cmp;
        float interpolation2;
        int mOVING;
        int fINISHED2;
        int childCount;
        boolean fINISHED3;
        boolean fINISHED;
        int cmp8;
        Interpolator cmp2;
        float interpolation;
        int i2;
        int i10;
        int cmp7;
        int i3;
        int i4;
        int cmp5;
        int i5;
        long nanoTime3;
        long nanoTime2;
        long l2;
        int i12;
        Interpolator interpolator;
        int i6;
        int interpolation3;
        float f;
        int cmp4;
        int cmp6;
        int i11;
        int i;
        Object obj;
        int i8;
        float f2;
        long l;
        c cVar;
        final Object obj2 = this;
        if (Long.compare(l3, i13) == 0) {
            obj2.e0 = getNanoTime();
        }
        signum = obj2.d0;
        i9 = 0;
        cmp8 = -1;
        final int i15 = 1065353216;
        if (Float.compare(signum, i9) > 0 && Float.compare(signum, i15) < 0) {
            if (Float.compare(signum, i15) < 0) {
                obj2.R = cmp8;
            }
        }
        i10 = 0;
        if (!obj2.v0) {
            if (obj2.h0) {
                if (!z) {
                    if (Float.compare(f12, signum) != 0) {
                        signum = Math.signum(f5 -= signum);
                        nanoTime3 = getNanoTime();
                        interpolation2 = obj2.N;
                        interpolation3 = 814313567;
                        if (!interpolation2 instanceof i) {
                            i23 /= f;
                        } else {
                            i12 = i9;
                        }
                        f18 += i12;
                        if (obj2.g0) {
                            f = obj2.f0;
                        }
                        cmp4 = Float.compare(signum, i9);
                        if (cmp4 > 0) {
                            if (Float.compare(f, f20) < 0) {
                                if (Float.compare(signum, i9) <= 0 && Float.compare(f, f19) <= 0) {
                                    if (Float.compare(f, f19) <= 0) {
                                        f = obj2.f0;
                                        obj2.h0 = i10;
                                        cmp6 = 1;
                                    } else {
                                        cmp6 = i10;
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                        obj2.d0 = f;
                        obj2.c0 = f;
                        obj2.e0 = nanoTime3;
                        i11 = 925353388;
                        i = 0;
                        if (interpolation2 != null && cmp6 == 0) {
                            if (cmp6 == 0) {
                                if (obj2.l0) {
                                    interpolation2 = interpolation2.getInterpolation(f13 *= interpolation3);
                                    cmp2 = obj2.N;
                                    a aVar = obj2.m0;
                                    if (cmp2 == aVar) {
                                    } else {
                                        obj2.d0 = interpolation2;
                                        obj2.e0 = nanoTime3;
                                        if (cmp2 instanceof i) {
                                            float f14 = (i)cmp2.a();
                                            obj2.P = f14;
                                            int cmp11 = Float.compare(i20, i11);
                                            if (Float.compare(f14, i9) > 0 && Float.compare(interpolation2, i15) >= 0) {
                                                if (Float.compare(interpolation2, i15) >= 0) {
                                                    obj2.d0 = i15;
                                                    obj2.h0 = false;
                                                    interpolation2 = i15;
                                                } else {
                                                    i10 = 0;
                                                }
                                            } else {
                                            }
                                            if (Float.compare(f14, i9) < 0 && Float.compare(interpolation2, i9) <= 0) {
                                                if (Float.compare(interpolation2, i9) <= 0) {
                                                    obj2.d0 = i9;
                                                    obj2.h0 = i10;
                                                    f = i9;
                                                } else {
                                                    f = interpolation2;
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    }
                                    aVar.b();
                                    throw i;
                                }
                                Interpolator interpolator2 = obj2.N;
                                if (interpolator2 instanceof i) {
                                    obj2.P = (i)interpolator2.a();
                                } else {
                                    obj2.P = i19 /= i12;
                                }
                            } else {
                                obj2.P = i12;
                            }
                        } else {
                        }
                        if (Float.compare(f7, i11) > 0) {
                            obj2.setState(j.g.MOVING);
                        }
                        if (cmp4 > 0) {
                            if (Float.compare(f, f11) < 0) {
                                if (Float.compare(signum, i9) <= 0 && Float.compare(f, f10) <= 0) {
                                    if (Float.compare(f, f10) <= 0) {
                                        f = obj2.f0;
                                        obj2.h0 = false;
                                    }
                                }
                            } else {
                            }
                        } else {
                        }
                        if (Float.compare(f, i15) < 0) {
                            if (Float.compare(f, i9) <= 0) {
                                obj2.h0 = false;
                                obj2.setState(j.g.FINISHED);
                            } else {
                                i3 = 0;
                            }
                        } else {
                        }
                        obj2.v0 = i3;
                        obj2.G0 = f;
                        Interpolator interpolator3 = obj2.O;
                        if (interpolator3 == null) {
                            interpolation = f;
                        } else {
                            interpolation = interpolator3.getInterpolation(f);
                        }
                        interpolator = obj2.O;
                        if (interpolator != null) {
                            float interpolation5 = interpolator.getInterpolation(i24 += f);
                            obj2.P = interpolation5;
                            obj2.P = interpolation5 -= interpolation3;
                        }
                        i6 = i3;
                        while (i6 < getChildCount()) {
                            interpolation3 = obj2.getChildAt(i6);
                            obj = i11;
                            if ((g)obj != null) {
                            }
                            i6++;
                            i3 = 0;
                            obj2.v0 = z3 |= i11;
                        }
                        if (cmp4 > 0) {
                            if (Float.compare(f, f9) < 0) {
                                if (Float.compare(signum, i9) <= 0 && Float.compare(f, f8) <= 0) {
                                    i4 = Float.compare(f, f8) <= 0 ? 1 : 0;
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                        if (!obj2.v0 && !obj2.h0 && i4 != 0) {
                            if (!obj2.h0) {
                                if (i4 != 0) {
                                    obj2.setState(j.g.FINISHED);
                                }
                            }
                        }
                        if (obj2.F0) {
                            requestLayout();
                        }
                        z2 |= i21;
                        obj2.v0 = fINISHED;
                        cmp5 = obj2.Q;
                        if (Float.compare(f, i9) <= 0 && cmp5 != cmp8) {
                            cmp5 = obj2.Q;
                            if (cmp5 != cmp8) {
                                if (obj2.R != cmp5) {
                                } else {
                                }
                                obj2.R = cmp5;
                                obj2.M.b(cmp5);
                                throw i;
                            }
                        }
                        if (Double.compare(i10, l2) >= 0) {
                            i10 = obj2.S;
                            if (obj2.R != i10) {
                            } else {
                            }
                            obj2.R = i10;
                            obj2.M.b(i10);
                            throw i;
                        }
                        if (fINISHED == 0) {
                            if (obj2.h0) {
                                invalidate();
                            } else {
                                if (cmp4 > 0) {
                                    if (Float.compare(f, i15) != 0) {
                                        if (Float.compare(signum, i9) < 0 && Float.compare(f, i9) == 0) {
                                            if (Float.compare(f, i9) == 0) {
                                                obj2.setState(j.g.FINISHED);
                                            }
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                        if (!obj2.v0 && !obj2.h0) {
                            if (!obj2.h0) {
                                if (cmp4 > 0) {
                                    if (Float.compare(f, i15) != 0) {
                                        if (Float.compare(signum, i9) < 0 && Float.compare(f, i9) == 0) {
                                            if (Float.compare(f, i9) == 0) {
                                                D();
                                            }
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            }
                        }
                    } else {
                        i2 = 1;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        float f3 = obj2.d0;
        if (Float.compare(f3, i15) >= 0) {
            i9 = obj2.S;
            if (obj2.R != i9) {
            } else {
                i2 = 0;
            }
            obj2.R = i9;
            i5 = i2;
        } else {
        }
        obj2.Q0 = q0 |= i5;
        if (i5 != 0 && !obj2.I0) {
            if (!obj2.I0) {
                requestLayout();
            }
        }
        obj2.c0 = obj2.d0;
    }
}
