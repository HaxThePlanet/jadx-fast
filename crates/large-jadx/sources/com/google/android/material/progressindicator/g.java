package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import d.k.a.b;
import d.k.a.c;
import d.k.a.d;
import d.k.a.e;
import f.c.a.e.r.a;

/* loaded from: classes2.dex */
public final class g<S extends com.google.android.material.progressindicator.c>  extends com.google.android.material.progressindicator.h {

    private static final c<com.google.android.material.progressindicator.g> M;
    private com.google.android.material.progressindicator.i<S> H;
    private final e I;
    private final d J;
    private float K;
    private boolean L = false;

    static class a extends c<com.google.android.material.progressindicator.g> {
        a(String string) {
            super(string);
        }

        @Override // d.k.a.c
        public float a(Object object) {
            return c((g)object);
        }

        @Override // d.k.a.c
        public void b(Object object, float f2) {
            d((g)object, f2);
        }

        @Override // d.k.a.c
        public float c(com.google.android.material.progressindicator.g g) {
            return obj2 *= i;
        }

        @Override // d.k.a.c
        public void d(com.google.android.material.progressindicator.g g, float f2) {
            g.t(g, f2 /= i);
        }
    }
    static {
        g.a aVar = new g.a("indicatorLevel");
        g.M = aVar;
    }

    g(Context context, com.google.android.material.progressindicator.c c2, com.google.android.material.progressindicator.i<S> i3) {
        super(context, c2);
        int obj2 = 0;
        x(i3);
        obj2 = new e();
        this.I = obj2;
        final int obj3 = 1065353216;
        obj2.d(obj3);
        obj2.f(1112014848);
        d obj4 = new d(this, g.M);
        this.J = obj4;
        obj4.p(obj2);
        m(obj3);
    }

    static float s(com.google.android.material.progressindicator.g g) {
        return g.w();
    }

    static void t(com.google.android.material.progressindicator.g g, float f2) {
        g.y(f2);
    }

    public static com.google.android.material.progressindicator.g<com.google.android.material.progressindicator.f> u(Context context, com.google.android.material.progressindicator.f f2) {
        d dVar = new d(f2);
        g gVar = new g(context, f2, dVar);
        return gVar;
    }

    private float w() {
        return this.K;
    }

    private void y(float f) {
        this.K = f;
        invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.h
    public void draw(Canvas canvas) {
        Rect clipBounds;
        boolean visible;
        com.google.android.material.progressindicator.i iVar;
        Canvas canvas2;
        android.graphics.Paint paint;
        int i2;
        float f;
        int i;
        clipBounds = new Rect();
        if (!getBounds().isEmpty() && isVisible()) {
            if (isVisible()) {
                if (!canvas.getClipBounds(clipBounds)) {
                } else {
                    canvas.save();
                    this.H.g(canvas, g());
                    this.H.c(canvas, this.E);
                    this.H.b(canvas, this.E, 0, w(), a.a(cVar.c[0], getAlpha()));
                    canvas.restore();
                }
            }
        }
    }

    @Override // com.google.android.material.progressindicator.h
    public int getIntrinsicHeight() {
        return this.H.d();
    }

    @Override // com.google.android.material.progressindicator.h
    public int getIntrinsicWidth() {
        return this.H.e();
    }

    @Override // com.google.android.material.progressindicator.h
    public void jumpToCurrentState() {
        this.J.q();
        y(f /= i2);
    }

    @Override // com.google.android.material.progressindicator.h
    protected boolean onLevelChange(int i) {
        d dVar;
        int i2;
        int obj4;
        final int i3 = 1176256512;
        if (this.L) {
            this.J.q();
            y(obj4 /= i3);
        } else {
            this.J.h(f *= i3);
            this.J.l((float)i);
        }
        return 1;
    }

    @Override // com.google.android.material.progressindicator.h
    boolean q(boolean z, boolean z2, boolean z3) {
        int i;
        int obj3;
        int obj4;
        obj3 = this.c.a(this.a.getContentResolver());
        if (Float.compare(obj3, obj4) == 0) {
            this.L = true;
        } else {
            this.L = false;
            this.I.f(i2 /= obj3);
        }
        return super.q(z, z2, z3);
    }

    com.google.android.material.progressindicator.i<S> v() {
        return this.H;
    }

    void x(com.google.android.material.progressindicator.i<S> i) {
        this.H = i;
        i.f(this);
    }

    @Override // com.google.android.material.progressindicator.h
    void z(float f) {
        setLevel((int)obj2);
    }
}
