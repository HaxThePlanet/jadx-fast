package com.google.android.material.progressindicator;

import android.accounts.Account;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import d.n.a.a.b;
import d.v.a.a.b;
import f.c.a.e.m.c;
import f.c.a.e.r.a;

/* loaded from: classes2.dex */
final class e extends com.google.android.material.progressindicator.j<ObjectAnimator> {

    private static final int[] l;
    private static final int[] m;
    private static final int[] n;
    private static final Property<com.google.android.material.progressindicator.e, Float> o;
    private static final Property<com.google.android.material.progressindicator.e, Float> p;
    private ObjectAnimator d;
    private ObjectAnimator e;
    private final b f;
    private final com.google.android.material.progressindicator.c g;
    private int h = 0;
    private float i;
    private float j;
    b k = null;

    class a extends AnimatorListenerAdapter {

        final com.google.android.material.progressindicator.e a;
        a(com.google.android.material.progressindicator.e e) {
            this.a = e;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            final com.google.android.material.progressindicator.e obj3 = this.a;
            e.j(obj3, i2 %= length);
        }
    }

    class b extends AnimatorListenerAdapter {

        final com.google.android.material.progressindicator.e a;
        b(com.google.android.material.progressindicator.e e) {
            this.a = e;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            Object obj2;
            super.onAnimationEnd(animator);
            this.a.a();
            obj2 = this.a;
            final b bVar = obj2.k;
            if (bVar != null) {
                bVar.onAnimationEnd(obj2.a);
            }
        }
    }

    static class c extends Property<com.google.android.material.progressindicator.e, Float> {
        c(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public Float a(com.google.android.material.progressindicator.e e) {
            return Float.valueOf(e.l(e));
        }

        @Override // android.util.Property
        public void b(com.google.android.material.progressindicator.e e, Float float2) {
            e.t(float2.floatValue());
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((e)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((e)object, (Float)object2);
        }
    }

    static class d extends Property<com.google.android.material.progressindicator.e, Float> {
        d(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public Float a(com.google.android.material.progressindicator.e e) {
            return Float.valueOf(e.m(e));
        }

        @Override // android.util.Property
        public void b(com.google.android.material.progressindicator.e e, Float float2) {
            e.n(e, float2.floatValue());
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((e)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((e)object, (Float)object2);
        }
    }
    static {
        final Class<Float> obj = Float.class;
        int i2 = 4;
        int[] iArr2 = new int[i2];
        iArr2 = new int[]{0, 1350, 2700, 4050};
        e.l = iArr2;
        int[] iArr3 = new int[i2];
        iArr3 = new int[]{667, 2017, 3367, 4717};
        e.m = iArr3;
        int[] iArr = new int[i2];
        iArr = new int[]{1000, 2350, 3700, 5050};
        e.n = iArr;
        e.c cVar = new e.c(obj, "animationFraction");
        e.o = cVar;
        e.d dVar = new e.d(obj, "completeEndFraction");
        e.p = dVar;
    }

    public e(com.google.android.material.progressindicator.f f) {
        super(1);
        int i2 = 0;
        int i3 = 0;
        this.g = f;
        b obj2 = new b();
        this.f = obj2;
    }

    static int i(com.google.android.material.progressindicator.e e) {
        return e.h;
    }

    static int j(com.google.android.material.progressindicator.e e, int i2) {
        e.h = i2;
        return i2;
    }

    static com.google.android.material.progressindicator.c k(com.google.android.material.progressindicator.e e) {
        return e.g;
    }

    static float l(com.google.android.material.progressindicator.e e) {
        return e.o();
    }

    static float m(com.google.android.material.progressindicator.e e) {
        return e.p();
    }

    static void n(com.google.android.material.progressindicator.e e, float f2) {
        e.u(f2);
    }

    private float o() {
        return this.i;
    }

    private float p() {
        return this.j;
    }

    private void q() {
        ObjectAnimator objectAnimator2;
        ObjectAnimator objectAnimator;
        int bVar;
        com.google.android.material.progressindicator.e.a aVar;
        bVar = 2;
        if (this.d == null) {
            float[] fArr2 = new float[bVar];
            fArr2 = new int[]{0, 1065353216};
            ObjectAnimator float = ObjectAnimator.ofFloat(this, e.o, fArr2);
            this.d = float;
            float.setDuration(5400);
            this.d.setInterpolator(0);
            this.d.setRepeatCount(-1);
            aVar = new e.a(this);
            this.d.addListener(aVar);
        }
        if (this.e == null) {
            float[] fArr = new float[bVar];
            fArr = new int[]{0, 1065353216};
            ObjectAnimator float2 = ObjectAnimator.ofFloat(this, e.p, fArr);
            this.e = float2;
            float2.setDuration(333);
            this.e.setInterpolator(this.f);
            bVar = new e.b(this);
            this.e.addListener(bVar);
        }
    }

    private void r(int i) {
        int valueOf;
        float f;
        int interpolation;
        int cmp;
        c cVar;
        int obj6;
        final int i2 = 0;
        valueOf = i2;
        while (valueOf < 4) {
            f = b(i, e.n[valueOf], 333);
            if (Float.compare(f, i9) >= 0) {
                break;
            } else {
            }
            valueOf++;
            if (Float.compare(f, i10) <= 0) {
                break;
            } else {
            }
        }
    }

    private void u(float f) {
        this.j = f;
    }

    private void v(int i) {
        int i5;
        int i3;
        int i6;
        int i4;
        b bVar;
        int i2;
        float[] fArr = this.b;
        float f4 = this.i;
        int i17 = 1153302528;
        int i22 = 0;
        fArr[i22] = i19 += i21;
        int i18 = 1;
        fArr[i18] = f4 *= i17;
        i5 = i22;
        while (i5 < 4) {
            int i20 = 667;
            float[] fArr2 = this.b;
            i2 = 1132068864;
            fArr2[i18] = f10 += i15;
            i6 = this.b;
            i6[i22] = i23 += i3;
            i5++;
        }
        final float[] obj9 = this.b;
        obj9[i22] = f += i12;
        int i13 = 1135869952;
        obj9[i22] = f2 /= i13;
        obj9[i18] = f3 /= i13;
    }

    @Override // com.google.android.material.progressindicator.j
    void a() {
        final ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.j
    public void c() {
        s();
    }

    @Override // com.google.android.material.progressindicator.j
    public void d(b b) {
        this.k = b;
    }

    @Override // com.google.android.material.progressindicator.j
    void f() {
        ObjectAnimator running;
        running = this.e;
        if (running != null) {
            if (running.isRunning()) {
            } else {
                if (this.a.isVisible()) {
                    this.e.start();
                } else {
                    a();
                }
            }
        }
    }

    @Override // com.google.android.material.progressindicator.j
    void g() {
        q();
        s();
        this.d.start();
    }

    @Override // com.google.android.material.progressindicator.j
    public void h() {
        this.k = 0;
    }

    @Override // com.google.android.material.progressindicator.j
    void s() {
        int i = 0;
        this.h = i;
        this.c[i] = a.a(cVar.c[i], this.a.getAlpha());
        this.j = 0;
    }

    @Override // com.google.android.material.progressindicator.j
    void t(float f) {
        this.i = f;
        int obj2 = (int)obj2;
        v(obj2);
        r(obj2);
        this.a.invalidateSelf();
    }
}
