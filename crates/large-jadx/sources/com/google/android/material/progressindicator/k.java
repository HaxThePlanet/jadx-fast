package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

/* loaded from: classes2.dex */
public final class k<S extends com.google.android.material.progressindicator.c>  extends com.google.android.material.progressindicator.h {

    private com.google.android.material.progressindicator.i<S> H;
    private com.google.android.material.progressindicator.j<ObjectAnimator> I;
    k(Context context, com.google.android.material.progressindicator.c c2, com.google.android.material.progressindicator.i<S> i3, com.google.android.material.progressindicator.j<ObjectAnimator> j4) {
        super(context, c2);
        w(i3);
        v(j4);
    }

    public static com.google.android.material.progressindicator.k<com.google.android.material.progressindicator.f> s(Context context, com.google.android.material.progressindicator.f f2) {
        d dVar = new d(f2);
        e eVar = new e(f2);
        k kVar = new k(context, f2, dVar, eVar);
        return kVar;
    }

    @Override // com.google.android.material.progressindicator.h
    public void draw(Canvas canvas) {
        int clipBounds;
        android.graphics.Paint paint;
        boolean visible;
        int[] iArr;
        int length;
        com.google.android.material.progressindicator.i iVar;
        Canvas canvas2;
        android.graphics.Paint paint2;
        int i3;
        int i;
        int i2;
        clipBounds = new Rect();
        if (!getBounds().isEmpty() && isVisible()) {
            if (isVisible()) {
                if (!canvas.getClipBounds(clipBounds)) {
                } else {
                    canvas.save();
                    this.H.g(canvas, g());
                    this.H.c(canvas, this.E);
                    clipBounds = 0;
                    visible = this.I;
                    iArr = visible.c;
                    for (int i2 : obj2) {
                        paint = visible.b;
                        int i4 = clipBounds * 2;
                        this.H.b(canvas, this.E, paint[i4], paint[i4++], i2);
                        visible = this.I;
                        iArr = visible.c;
                    }
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
    boolean q(boolean z, boolean z2, boolean z3) {
        boolean running;
        boolean obj3;
        boolean obj5;
        if (!isRunning()) {
            this.I.a();
        }
        if (z) {
            if (!z3) {
                if (Build.VERSION.SDK_INT <= 21 && Float.compare(f, obj3) > 0) {
                    if (Float.compare(f, obj3) > 0) {
                        this.I.g();
                    }
                }
            } else {
            }
        }
        return super.q(z, z2, z3);
    }

    com.google.android.material.progressindicator.j<ObjectAnimator> t() {
        return this.I;
    }

    com.google.android.material.progressindicator.i<S> u() {
        return this.H;
    }

    void v(com.google.android.material.progressindicator.j<ObjectAnimator> j) {
        this.I = j;
        j.e(this);
    }

    void w(com.google.android.material.progressindicator.i<S> i) {
        this.H = i;
        i.f(this);
    }
}
