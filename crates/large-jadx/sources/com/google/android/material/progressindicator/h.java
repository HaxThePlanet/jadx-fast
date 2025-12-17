package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Property;
import d.v.a.a.b;
import f.c.a.e.m.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
abstract class h extends Drawable implements Animatable {

    private static final Property<com.google.android.material.progressindicator.h, Float> G;
    private List<b> A;
    private b B;
    private boolean C;
    private float D;
    final Paint E;
    private int F;
    final Context a;
    final com.google.android.material.progressindicator.c b;
    com.google.android.material.progressindicator.a c;
    private ValueAnimator v;
    private ValueAnimator w;
    private boolean x;
    private boolean y;
    private float z;

    class a extends AnimatorListenerAdapter {

        final com.google.android.material.progressindicator.h a;
        a(com.google.android.material.progressindicator.h h) {
            this.a = h;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            h.a(this.a);
        }
    }

    class b extends AnimatorListenerAdapter {

        final com.google.android.material.progressindicator.h a;
        b(com.google.android.material.progressindicator.h h) {
            this.a = h;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            final int i = 0;
            h.b(this.a, i, i);
            h.c(this.a);
        }
    }

    static class c extends Property<com.google.android.material.progressindicator.h, Float> {
        c(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public Float a(com.google.android.material.progressindicator.h h) {
            return Float.valueOf(h.g());
        }

        @Override // android.util.Property
        public void b(com.google.android.material.progressindicator.h h, Float float2) {
            h.m(float2.floatValue());
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((h)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((h)object, (Float)object2);
        }
    }
    static {
        h.c cVar = new h.c(Float.class, "growFraction");
        h.G = cVar;
    }

    h(Context context, com.google.android.material.progressindicator.c c2) {
        super();
        Paint paint = new Paint();
        this.E = paint;
        this.a = context;
        this.b = c2;
        a obj2 = new a();
        this.c = obj2;
        setAlpha(255);
    }

    static void a(com.google.android.material.progressindicator.h h) {
        h.e();
    }

    static boolean b(com.google.android.material.progressindicator.h h, boolean z2, boolean z3) {
        return super.setVisible(z2, z3);
    }

    static void c(com.google.android.material.progressindicator.h h) {
        h.d();
    }

    private void d() {
        Object iterator;
        boolean next;
        b bVar = this.B;
        if (bVar != null) {
            bVar.onAnimationEnd(this);
        }
        iterator = this.A;
        if (iterator != null && !this.C) {
            if (!this.C) {
                iterator = iterator.iterator();
                for (b next : iterator) {
                    next.onAnimationEnd(this);
                }
            }
        }
    }

    private void e() {
        Object iterator;
        boolean next;
        b bVar = this.B;
        if (bVar != null) {
            bVar.onAnimationStart(this);
        }
        iterator = this.A;
        if (iterator != null && !this.C) {
            if (!this.C) {
                iterator = iterator.iterator();
                for (b next : iterator) {
                    next.onAnimationStart(this);
                }
            }
        }
    }

    private void f(ValueAnimator... valueAnimatorArr) {
        int i;
        Object obj;
        this.C = true;
        i = 0;
        while (i < valueAnimatorArr.length) {
            valueAnimatorArr[i].end();
            i++;
        }
        this.C = this.C;
    }

    private void k() {
        ValueAnimator valueAnimator2;
        ValueAnimator valueAnimator;
        int i;
        int fArr;
        android.animation.TimeInterpolator time;
        i = 500;
        fArr = 2;
        if (this.v == null) {
            float[] fArr2 = new float[fArr];
            fArr2 = new int[]{0, 1065353216};
            ObjectAnimator float = ObjectAnimator.ofFloat(this, h.G, fArr2);
            this.v = float;
            float.setDuration(i);
            this.v.setInterpolator(a.b);
            o(this.v);
        }
        if (this.w == null) {
            fArr = new float[fArr];
            fArr = new int[]{1065353216, 0};
            ObjectAnimator float2 = ObjectAnimator.ofFloat(this, h.G, fArr);
            this.w = float2;
            float2.setDuration(i);
            this.w.setInterpolator(a.b);
            n(this.w);
        }
    }

    private void n(ValueAnimator valueAnimator) {
        ValueAnimator running;
        running = this.w;
        if (running != null) {
            if (running.isRunning()) {
            } else {
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            throw obj2;
        }
        this.w = valueAnimator;
        h.b bVar = new h.b(this);
        valueAnimator.addListener(bVar);
    }

    private void o(ValueAnimator valueAnimator) {
        ValueAnimator running;
        running = this.v;
        if (running != null) {
            if (running.isRunning()) {
            } else {
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            throw obj2;
        }
        this.v = valueAnimator;
        h.a aVar = new h.a(this);
        valueAnimator.addListener(aVar);
    }

    @Override // android.graphics.drawable.Drawable
    float g() {
        boolean z;
        boolean z2;
        if (!this.b.b() && !this.b.a()) {
            if (!this.b.a()) {
                return 1065353216;
            }
        }
        if (!this.y && this.x) {
            if (this.x) {
            }
            return this.D;
        }
        return this.z;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.F;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean h() {
        int i = 0;
        return p(i, i, i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean i() {
        boolean running;
        int i;
        running = this.w;
        if (running != null) {
            if (!running.isRunning()) {
                i = this.y ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isRunning() {
        int i;
        boolean z;
        if (!j()) {
            if (i()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean j() {
        boolean running;
        int i;
        running = this.v;
        if (running != null) {
            if (!running.isRunning()) {
                i = this.x ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void l(b b) {
        Object arrayList;
        boolean contains;
        if (this.A == null) {
            arrayList = new ArrayList();
            this.A = arrayList;
        }
        if (!this.A.contains(b)) {
            this.A.add(b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    void m(float f) {
        if (Float.compare(f2, f) != 0) {
            this.D = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean p(boolean z, boolean z2, boolean z3) {
        int obj5;
        if (z3 != 0 && Float.compare(f, obj5) > 0) {
            obj5 = Float.compare(f, obj5) > 0 ? 1 : 0;
        } else {
        }
        return q(z, z2, obj5);
    }

    @Override // android.graphics.drawable.Drawable
    boolean q(boolean z, boolean z2, boolean z3) {
        ValueAnimator valueAnimator;
        boolean obj4;
        int obj5;
        boolean obj6;
        k();
        final int i = 0;
        if (!isVisible() && !z) {
            if (!z) {
                return i;
            }
        }
        valueAnimator = z ? this.v : this.w;
        final int i2 = 1;
        if (!z3) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                obj5 = new ValueAnimator[i2];
                obj5[i] = valueAnimator;
                f(obj5);
            }
            return super.setVisible(z, i);
        }
        if (z3 && valueAnimator.isRunning()) {
            if (valueAnimator.isRunning()) {
                return i;
            }
        }
        if (z) {
            if (super.setVisible(z, i)) {
                obj6 = i2;
            } else {
                obj6 = i;
            }
        } else {
        }
        if (z) {
            obj4 = this.b.b();
        } else {
            obj4 = this.b.a();
        }
        if (obj4 == null) {
            obj4 = new ValueAnimator[i2];
            obj4[i] = valueAnimator;
            f(obj4);
            return obj6;
        }
        if (z2 == 0 && Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= 19) {
                if (!valueAnimator.isPaused()) {
                    valueAnimator.start();
                } else {
                    valueAnimator.resume();
                }
            } else {
            }
        } else {
        }
        return obj6;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean r(b b) {
        List contains;
        boolean obj2;
        contains = this.A;
        this.A.remove(b);
        if (contains != null && contains.contains(b) && this.A.isEmpty()) {
            if (contains.contains(b)) {
                this.A.remove(b);
                if (this.A.isEmpty()) {
                    this.A = 0;
                }
                return 1;
            }
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.F = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.E.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return p(z, z2, true);
    }

    @Override // android.graphics.drawable.Drawable
    public void start() {
        final int i = 1;
        q(i, i, false);
    }

    @Override // android.graphics.drawable.Drawable
    public void stop() {
        final int i = 0;
        q(i, true, i);
    }
}
