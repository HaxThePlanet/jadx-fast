package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageButton;
import androidx.core.graphics.drawable.a;
import com.google.android.exoplayer2.audio.AudioSink.WriteException;
import com.google.android.material.internal.g;
import com.google.android.material.internal.o;
import d.h.k.i;
import d.h.l.u;
import f.c.a.e.b;
import f.c.a.e.b0.a;
import f.c.a.e.b0.b;
import f.c.a.e.c0.b;
import f.c.a.e.d0.g;
import f.c.a.e.d0.h;
import f.c.a.e.d0.k;
import f.c.a.e.d0.n;
import f.c.a.e.g;
import f.c.a.e.m.a;
import f.c.a.e.m.b;
import f.c.a.e.m.f;
import f.c.a.e.m.g;
import f.c.a.e.m.h;
import f.c.a.e.m.i;
import f.c.a.e.x.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class b {

    static final TimeInterpolator D;
    static final int[] E;
    static final int[] F;
    static final int[] G;
    static final int[] H;
    static final int[] I;
    static final int[] J;
    private final RectF A;
    private final Matrix B;
    private ViewTreeObserver.OnPreDrawListener C;
    k a;
    g b;
    Drawable c;
    com.google.android.material.floatingactionbutton.a d;
    Drawable e;
    boolean f;
    boolean g = true;
    float h;
    float i;
    float j;
    int k;
    private final g l;
    private Animator m;
    private h n;
    private h o;
    private float p;
    private float q = 1f;
    private int r;
    private int s = 0;
    private ArrayList<Animator.AnimatorListener> t;
    private ArrayList<Animator.AnimatorListener> u;
    private ArrayList<com.google.android.material.floatingactionbutton.b.j> v;
    final com.google.android.material.floatingactionbutton.FloatingActionButton w;
    final b x;
    private final Rect y;
    private final RectF z;

    class a extends AnimatorListenerAdapter {

        private boolean a;
        final boolean b;
        final com.google.android.material.floatingactionbutton.b.k c;
        final com.google.android.material.floatingactionbutton.b d;
        a(com.google.android.material.floatingactionbutton.b b, boolean z2, com.google.android.material.floatingactionbutton.b.k b$k3) {
            this.d = b;
            this.b = z2;
            this.c = k3;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            int i;
            int i2;
            boolean obj3;
            b.a(this.d, 0);
            b.b(this.d, 0);
            if (!this.a) {
                i = this.b;
                i2 = i ? 8 : 4;
                obj3.w.b(i2, i);
                obj3 = this.c;
                if (obj3 != null) {
                    obj3.b();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            final int i2 = 0;
            bVar.w.b(i2, this.b);
            b.a(this.d, 1);
            b.b(this.d, animator);
            this.a = i2;
        }
    }

    class b extends AnimatorListenerAdapter {

        final boolean a;
        final com.google.android.material.floatingactionbutton.b.k b;
        final com.google.android.material.floatingactionbutton.b c;
        b(com.google.android.material.floatingactionbutton.b b, boolean z2, com.google.android.material.floatingactionbutton.b.k b$k3) {
            this.c = b;
            this.a = z2;
            this.b = k3;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            b.a(this.c, 0);
            b.b(this.c, 0);
            com.google.android.material.floatingactionbutton.b.k obj2 = this.b;
            if (obj2 != null) {
                obj2.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            bVar.w.b(0, this.a);
            b.a(this.c, 2);
            b.b(this.c, animator);
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {

        final float a;
        final float b;
        final float c;
        final float d;
        final float e;
        final float f;
        final float g;
        final Matrix h;
        final com.google.android.material.floatingactionbutton.b i;
        d(com.google.android.material.floatingactionbutton.b b, float f2, float f3, float f4, float f5, float f6, float f7, float f8, Matrix matrix9) {
            this.i = b;
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.d = f5;
            this.e = f6;
            this.f = f7;
            this.g = f8;
            this.h = matrix9;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float obj6 = (Float)valueAnimator.getAnimatedValue().floatValue();
            bVar.w.setAlpha(a.b(this.a, this.b, 0, 1045220557, obj6));
            bVar2.w.setScaleX(a.a(this.c, this.d, obj6));
            bVar3.w.setScaleY(a.a(this.e, this.d, obj6));
            b.c(this.i, a.a(this.f, this.g, obj6));
            b.d(this.i, a.a(this.f, this.g, obj6), this.h);
            obj6.w.setImageMatrix(this.h);
        }
    }

    class e implements TypeEvaluator<Float> {

        FloatEvaluator a;
        e(com.google.android.material.floatingactionbutton.b b) {
            super();
            FloatEvaluator obj1 = new FloatEvaluator();
            this.a = obj1;
        }

        @Override // android.animation.TypeEvaluator
        public Float a(float f, Float float2, Float float3) {
            float obj2;
            if (Float.compare(obj2, obj3) < 0) {
                obj2 = 0;
            }
            return Float.valueOf(obj2);
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object object2, Object object3) {
            return a(f, (Float)object2, (Float)object3);
        }
    }

    class f implements ViewTreeObserver.OnPreDrawListener {

        final com.google.android.material.floatingactionbutton.b a;
        f(com.google.android.material.floatingactionbutton.b b) {
            this.a = b;
            super();
        }

        @Override // android.view.ViewTreeObserver$OnPreDrawListener
        public boolean onPreDraw() {
            this.a.H();
            return 1;
        }
    }

    interface j {
        public abstract void a();

        public abstract void b();
    }

    interface k {
        public abstract void a();

        public abstract void b();
    }

    private abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        private boolean a;
        private float b;
        private float c;
        final com.google.android.material.floatingactionbutton.b d;
        private m(com.google.android.material.floatingactionbutton.b b) {
            this.d = b;
            super();
        }

        m(com.google.android.material.floatingactionbutton.b b, com.google.android.material.floatingactionbutton.b.a b$a2) {
            super(b);
        }

        @Override // android.animation.AnimatorListenerAdapter
        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.d.g0((float)i);
            this.a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f;
            boolean z;
            if (!this.a) {
                g gVar = bVar.b;
                if (gVar == null) {
                    f = 0;
                } else {
                    f = gVar.w();
                }
                this.b = f;
                this.c = a();
                this.a = true;
            }
            float f3 = this.b;
            this.d.g0((float)obj4);
        }
    }

    class c extends g {

        final com.google.android.material.floatingactionbutton.b d;
        c(com.google.android.material.floatingactionbutton.b b) {
            this.d = b;
            super();
        }

        @Override // f.c.a.e.m.g
        public Matrix a(float f, Matrix matrix2, Matrix matrix3) {
            b.c(this.d, f);
            return super.a(f, matrix2, matrix3);
        }
    }

    private class g extends com.google.android.material.floatingactionbutton.b.m {
        g(com.google.android.material.floatingactionbutton.b b) {
            super(b, 0);
        }

        @Override // com.google.android.material.floatingactionbutton.b$m
        protected float a() {
            return 0;
        }
    }

    private class h extends com.google.android.material.floatingactionbutton.b.m {

        final com.google.android.material.floatingactionbutton.b e;
        h(com.google.android.material.floatingactionbutton.b b) {
            this.e = b;
            super(b, 0);
        }

        @Override // com.google.android.material.floatingactionbutton.b$m
        protected float a() {
            com.google.android.material.floatingactionbutton.b bVar = this.e;
            return f2 += f;
        }
    }

    private class i extends com.google.android.material.floatingactionbutton.b.m {

        final com.google.android.material.floatingactionbutton.b e;
        i(com.google.android.material.floatingactionbutton.b b) {
            this.e = b;
            super(b, 0);
        }

        @Override // com.google.android.material.floatingactionbutton.b$m
        protected float a() {
            com.google.android.material.floatingactionbutton.b bVar = this.e;
            return f2 += f;
        }
    }

    private class l extends com.google.android.material.floatingactionbutton.b.m {

        final com.google.android.material.floatingactionbutton.b e;
        l(com.google.android.material.floatingactionbutton.b b) {
            this.e = b;
            super(b, 0);
        }

        @Override // com.google.android.material.floatingactionbutton.b$m
        protected float a() {
            return bVar.h;
        }
    }
    static {
        b.D = a.c;
        int i2 = 2;
        int[] iArr4 = new int[i2];
        iArr4 = new int[]{16842919, 16842910};
        b.E = iArr4;
        int[] iArr5 = new int[3];
        iArr5 = new int[]{16843623, 16842908, 16842910};
        b.F = iArr5;
        int[] iArr6 = new int[i2];
        iArr6 = new int[]{16842908, 16842910};
        b.G = iArr6;
        int[] iArr = new int[i2];
        iArr = new int[]{16843623, 16842910};
        b.H = iArr;
        int[] iArr2 = new int[1];
        final int i7 = 0;
        iArr2[i7] = 16842910;
        b.I = iArr2;
        b.J = new int[i7];
    }

    b(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, b b2) {
        super();
        int i = 1;
        int i2 = 1065353216;
        int i3 = 0;
        Rect rect = new Rect();
        this.y = rect;
        RectF rectF = new RectF();
        this.z = rectF;
        RectF rectF2 = new RectF();
        this.A = rectF2;
        Matrix matrix = new Matrix();
        this.B = matrix;
        this.w = floatingActionButton;
        this.x = b2;
        g obj4 = new g();
        this.l = obj4;
        b.i iVar = new b.i(this);
        obj4.a(b.E, k(iVar));
        b.h hVar = new b.h(this);
        obj4.a(b.F, k(hVar));
        b.h hVar2 = new b.h(this);
        obj4.a(b.G, k(hVar2));
        b.h hVar3 = new b.h(this);
        obj4.a(b.H, k(hVar3));
        b.l lVar = new b.l(this);
        obj4.a(b.I, k(lVar));
        b.g gVar = new b.g(this);
        obj4.a(b.J, k(gVar));
        this.p = floatingActionButton.getRotation();
    }

    static int a(com.google.android.material.floatingactionbutton.b b, int i2) {
        b.s = i2;
        return i2;
    }

    private boolean a0() {
        boolean inEditMode;
        int i;
        if (u.R(this.w) && !this.w.isInEditMode()) {
            i = !this.w.isInEditMode() ? 1 : 0;
        } else {
        }
        return i;
    }

    static Animator b(com.google.android.material.floatingactionbutton.b b, Animator animator2) {
        b.m = animator2;
        return animator2;
    }

    static float c(com.google.android.material.floatingactionbutton.b b, float f2) {
        b.q = f2;
        return f2;
    }

    static void d(com.google.android.material.floatingactionbutton.b b, float f2, Matrix matrix3) {
        b.h(f2, matrix3);
    }

    private void h(float f, Matrix matrix2) {
        Drawable drawable;
        int i3;
        int i2;
        float f2;
        int i;
        matrix2.reset();
        drawable = this.w.getDrawable();
        if (drawable != null && this.r != 0) {
            if (this.r != 0) {
                RectF rectF = this.z;
                RectF rectF2 = this.A;
                i = 0;
                rectF.set(i, i, (float)intrinsicWidth, (float)intrinsicHeight);
                int i4 = this.r;
                rectF2.set(i, i, (float)i4, (float)i4);
                matrix2.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                int i5 = this.r;
                i2 = 1073741824;
                matrix2.postScale(f, f, f6 /= i2, f5 /= i2);
            }
        }
    }

    private void h0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
        }
        b.e eVar = new b.e(this);
        objectAnimator.setEvaluator(eVar);
    }

    private AnimatorSet i(h h, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        float[] fArr2 = new float[i];
        final int i2 = 0;
        fArr2[i2] = f2;
        ObjectAnimator obj8 = ObjectAnimator.ofFloat(this.w, View.ALPHA, fArr2);
        h.e("opacity").a(obj8);
        arrayList.add(obj8);
        float[] fArr = new float[i];
        fArr[i2] = f3;
        obj8 = ObjectAnimator.ofFloat(this.w, View.SCALE_X, fArr);
        String str2 = "scale";
        h.e(str2).a(obj8);
        h0(obj8);
        arrayList.add(obj8);
        float[] fArr3 = new float[i];
        fArr3[i2] = f3;
        obj8 = ObjectAnimator.ofFloat(this.w, View.SCALE_Y, fArr3);
        h.e(str2).a(obj8);
        h0(obj8);
        arrayList.add(obj8);
        h(f4, this.B);
        f obj9 = new f();
        b.c obj10 = new b.c(this);
        Matrix[] arr = new Matrix[i];
        Matrix matrix = new Matrix(this.B);
        arr[i2] = matrix;
        obj8 = ObjectAnimator.ofObject(this.w, obj9, obj10, arr);
        h.e("iconScale").a(obj8);
        arrayList.add(obj8);
        AnimatorSet obj7 = new AnimatorSet();
        b.a(obj7, arrayList);
        return obj7;
    }

    private AnimatorSet j(float f, float f2, float f3) {
        final Object obj2 = this;
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        float[] fArr = new float[2];
        fArr = new int[]{0, 1065353216};
        final ValueAnimator float = ValueAnimator.ofFloat(fArr);
        Matrix matrix2 = new Matrix(obj2.B);
        super(this, obj2.w.getAlpha(), f, obj2.w.getScaleX(), f2, obj2.w.getScaleY(), obj2.q, f3, matrix2);
        float.addUpdateListener(dVar2);
        arrayList.add(float);
        b.a(animatorSet, arrayList);
        int i3 = b.I;
        animatorSet.setDuration((long)i2);
        animatorSet.setInterpolator(a.e(obj2.w.getContext(), b.J, a.b));
        return animatorSet;
    }

    private ValueAnimator k(com.google.android.material.floatingactionbutton.b.m b$m) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(b.D);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(m);
        valueAnimator.addUpdateListener(m);
        float[] obj4 = new float[2];
        obj4 = new int[]{0, 1065353216};
        valueAnimator.setFloatValues(obj4);
        return valueAnimator;
    }

    private ViewTreeObserver.OnPreDrawListener r() {
        ViewTreeObserver.OnPreDrawListener fVar;
        if (this.C == null) {
            fVar = new b.f(this);
            this.C = fVar;
        }
        return this.C;
    }

    void A() {
        this.l.c();
    }

    void B() {
        boolean viewTreeObserver;
        com.google.android.material.floatingactionbutton.FloatingActionButton num;
        g gVar = this.b;
        if (gVar != null) {
            h.f(this.w, gVar);
        }
        if (K()) {
            this.w.getViewTreeObserver().addOnPreDrawListener(r());
        }
    }

    void C() {
    }

    void D() {
        ViewTreeObserver viewTreeObserver;
        final ViewTreeObserver.OnPreDrawListener list = this.C;
        if (list != null) {
            this.w.getViewTreeObserver().removeOnPreDrawListener(list);
            this.C = 0;
        }
    }

    void E(int[] iArr) {
        this.l.d(iArr);
    }

    void F(float f, float f2, float f3) {
        f0();
        g0(f);
    }

    void G(Rect rect) {
        Object insetDrawable;
        Object str;
        Drawable drawable;
        int left;
        int top;
        int right;
        int bottom;
        b obj8;
        i.d(this.e, "Didn't initialize content background");
        if (Z()) {
            super(this.e, rect.left, rect.top, rect.right, rect.bottom);
            this.x.c(insetDrawable);
        } else {
            this.x.c(this.e);
        }
    }

    void H() {
        float rotation = this.w.getRotation();
        if (Float.compare(f, rotation) != 0) {
            this.p = rotation;
            d0();
        }
    }

    void I() {
        Object iterator;
        Object next;
        iterator = this.v;
        if (iterator != null) {
            iterator = iterator.iterator();
            for (b.j next : iterator) {
                next.b();
            }
        }
    }

    void J() {
        Object iterator;
        Object next;
        iterator = this.v;
        if (iterator != null) {
            iterator = iterator.iterator();
            for (b.j next : iterator) {
                next.a();
            }
        }
    }

    boolean K() {
        return 1;
    }

    void L(ColorStateList colorStateList) {
        g gVar = this.b;
        if (gVar != null) {
            gVar.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.a aVar = this.d;
        if (aVar != null) {
            aVar.c(colorStateList);
        }
    }

    void M(PorterDuff.Mode porterDuff$Mode) {
        final g gVar = this.b;
        if (gVar != null) {
            gVar.setTintMode(mode);
        }
    }

    final void N(float f) {
        int cmp;
        float f2;
        if (Float.compare(f3, f) != 0) {
            this.h = f;
            F(f, this.i, this.j);
        }
    }

    void O(boolean z) {
        this.f = z;
    }

    final void P(h h) {
        this.o = h;
    }

    final void Q(float f) {
        int cmp;
        float f2;
        if (Float.compare(f3, f) != 0) {
            this.i = f;
            F(this.h, f, this.j);
        }
    }

    final void R(float f) {
        this.q = f;
        final Matrix matrix = this.B;
        h(f, matrix);
        this.w.setImageMatrix(matrix);
    }

    final void S(int i) {
        if (this.r != i) {
            this.r = i;
            e0();
        }
    }

    void T(int i) {
        this.k = i;
    }

    final void U(float f) {
        int cmp;
        float f2;
        if (Float.compare(f3, f) != 0) {
            this.j = f;
            F(this.h, this.i, f);
        }
    }

    void V(ColorStateList colorStateList) {
        ColorStateList obj2;
        final Drawable drawable = this.c;
        if (drawable != null) {
            a.o(drawable, b.d(colorStateList));
        }
    }

    void W(boolean z) {
        this.g = z;
        f0();
    }

    final void X(k k) {
        this.a = k;
        g gVar = this.b;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(k);
        }
        Drawable drawable = this.c;
        if (drawable instanceof n) {
            (n)drawable.setShapeAppearanceModel(k);
        }
        com.google.android.material.floatingactionbutton.a aVar = this.d;
        if (aVar != null) {
            aVar.f(k);
        }
    }

    final void Y(h h) {
        this.n = h;
    }

    boolean Z() {
        return 1;
    }

    final boolean b0() {
        int i;
        boolean sizeDimension;
        int i2;
        if (this.f) {
            if (this.w.getSizeDimension() >= this.k) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    void c0(com.google.android.material.floatingactionbutton.b.k b$k, boolean z2) {
        int i4;
        Object obj;
        com.google.android.material.floatingactionbutton.b.b bVar;
        int visibility;
        boolean z;
        int i;
        int i2;
        int i3;
        Object obj7;
        boolean obj8;
        if (z()) {
        }
        Animator animator = this.m;
        if (animator != null) {
            animator.cancel();
        }
        bVar = 0;
        i4 = this.n == null ? 1 : bVar;
        final int i5 = 1065353216;
        if (a0()) {
            if (this.w.getVisibility() != 0) {
                z = 0;
                this.w.setAlpha(z);
                i = 1053609165;
                i3 = i4 != 0 ? i : z;
                this.w.setScaleY(i3);
                i2 = i4 != 0 ? i : z;
                this.w.setScaleX(i2);
                if (i4 != 0) {
                    z = i;
                }
                R(z);
            }
            h hVar2 = this.n;
            if (hVar2 != null) {
                obj = i(hVar2, i5, i5, i5);
            } else {
                obj = j(i5, i5, i5);
            }
            bVar = new b.b(this, z2, k);
            obj.addListener(bVar);
            obj7 = this.t;
            if (obj7 != null) {
                obj7 = obj7.iterator();
                for (Animator.AnimatorListener obj8 : obj7) {
                    obj.addListener(obj8);
                }
            }
            obj.start();
        } else {
            this.w.b(bVar, z2);
            this.w.setAlpha(i5);
            this.w.setScaleY(i5);
            this.w.setScaleX(i5);
            R(i5);
            if (k != null) {
                k.a();
            }
        }
    }

    void d0() {
        int layerType;
        int i2;
        int i;
        if (Build.VERSION.SDK_INT == 19) {
            i2 = 0;
            if (Float.compare(i3, i5) != 0) {
                i = 1;
                if (this.w.getLayerType() != i) {
                    this.w.setLayerType(i, i2);
                }
            } else {
                if (this.w.getLayerType() != 0) {
                    this.w.setLayerType(0, i2);
                }
            }
        }
        g gVar = this.b;
        if (gVar != null) {
            gVar.f0((int)f2);
        }
    }

    public void e(Animator.AnimatorListener animator$AnimatorListener) {
        ArrayList arrayList;
        if (this.u == null) {
            arrayList = new ArrayList();
            this.u = arrayList;
        }
        this.u.add(animatorListener);
    }

    final void e0() {
        R(this.q);
    }

    void f(Animator.AnimatorListener animator$AnimatorListener) {
        ArrayList arrayList;
        if (this.t == null) {
            arrayList = new ArrayList();
            this.t = arrayList;
        }
        this.t.add(animatorListener);
    }

    final void f0() {
        Rect rect = this.y;
        s(rect);
        G(rect);
        this.x.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void g(com.google.android.material.floatingactionbutton.b.j b$j) {
        ArrayList arrayList;
        if (this.v == null) {
            arrayList = new ArrayList();
            this.v = arrayList;
        }
        this.v.add(j);
    }

    void g0(float f) {
        final g gVar = this.b;
        if (gVar != null) {
            gVar.Y(f);
        }
    }

    g l() {
        final k kVar = this.a;
        i.c(kVar);
        g gVar = new g((k)kVar);
        return gVar;
    }

    final Drawable m() {
        return this.e;
    }

    float n() {
        return this.h;
    }

    boolean o() {
        return this.f;
    }

    final h p() {
        return this.o;
    }

    float q() {
        return this.i;
    }

    void s(Rect rect) {
        int i2;
        int sizeDimension;
        int i;
        float f;
        if (this.f) {
            i5 /= 2;
        } else {
            i2 = 0;
        }
        if (this.g) {
            f2 += f;
        } else {
            i = 0;
        }
        int i9 = Math.max(i2, (int)ceil);
        int i3 = Math.max(i2, (int)ceil2);
        rect.set(i9, i3, i9, i3);
    }

    float t() {
        return this.j;
    }

    final k u() {
        return this.a;
    }

    final h v() {
        return this.n;
    }

    void w(com.google.android.material.floatingactionbutton.b.k b$k, boolean z2) {
        Object obj;
        int aVar;
        Object obj3;
        boolean obj4;
        if (y()) {
        }
        Animator animator = this.m;
        if (animator != null) {
            animator.cancel();
        }
        if (a0()) {
            h hVar = this.o;
            int i2 = 0;
            if (hVar != null) {
                obj = i(hVar, i2, i2, i2);
            } else {
                int i = 1053609165;
                obj = j(i2, i, i);
            }
            aVar = new b.a(this, z2, k);
            obj.addListener(aVar);
            obj3 = this.u;
            if (obj3 != null) {
                obj3 = obj3.iterator();
                for (Animator.AnimatorListener obj4 : obj3) {
                    obj.addListener(obj4);
                }
            }
            obj.start();
        } else {
            aVar = z2 ? 8 : 4;
            this.w.b(aVar, z2);
            if (k != null) {
                k.b();
            }
        }
    }

    void x(ColorStateList colorStateList, PorterDuff.Mode porterDuff$Mode2, ColorStateList colorStateList3, int i4) {
        Object obj1;
        g obj4 = l();
        this.b = obj4;
        obj4.setTintList(colorStateList);
        if (mode2 != null) {
            this.b.setTintMode(mode2);
        }
        this.b.e0(-12303292);
        this.b.O(this.w.getContext());
        obj1 = new a(this.b.E());
        obj1.setTintList(b.d(colorStateList3));
        this.c = obj1;
        Drawable[] obj2 = new Drawable[2];
        obj4 = this.b;
        i.c(obj4);
        obj1 = new LayerDrawable(obj2);
        this.e = obj1;
    }

    boolean y() {
        int i;
        i = 0;
        final int i4 = 1;
        if (this.w.getVisibility() == 0 && this.s == i4) {
            if (this.s == i4) {
                i = i4;
            }
            return i;
        }
        if (this.s != 2) {
            i = i4;
        }
        return i;
    }

    boolean z() {
        int i;
        i = 0;
        final int i4 = 1;
        if (this.w.getVisibility() != 0 && this.s == 2) {
            if (this.s == 2) {
                i = i4;
            }
            return i;
        }
        if (this.s != i4) {
            i = i4;
        }
        return i;
    }
}
