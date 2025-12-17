package com.google.android.material.floatingactionbutton;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import d.h.f.a;
import f.c.a.e.d0.c;
import f.c.a.e.d0.k;
import f.c.a.e.d0.l;

/* loaded from: classes2.dex */
class a extends Drawable {

    private final l a;
    private final Paint b;
    private final Path c;
    private final Rect d;
    private final RectF e;
    private final RectF f;
    private final com.google.android.material.floatingactionbutton.a.b g;
    float h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n = true;
    private k o;
    private ColorStateList p;

    static class a {
    }

    private class b extends Drawable.ConstantState {

        final com.google.android.material.floatingactionbutton.a a;
        private b(com.google.android.material.floatingactionbutton.a a) {
            this.a = a;
            super();
        }

        b(com.google.android.material.floatingactionbutton.a a, com.google.android.material.floatingactionbutton.a.a a$a2) {
            super(a);
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            return this.a;
        }
    }
    a(k k) {
        super();
        this.a = l.k();
        Path path = new Path();
        this.c = path;
        Rect rect = new Rect();
        this.d = rect;
        RectF rectF = new RectF();
        this.e = rectF;
        RectF rectF2 = new RectF();
        this.f = rectF2;
        a.b bVar = new a.b(this, 0);
        this.g = bVar;
        this.o = k;
        Paint obj3 = new Paint(1);
        this.b = obj3;
        obj3.setStyle(Paint.Style.STROKE);
    }

    private Shader a() {
        Rect rect = this.d;
        copyBounds(rect);
        f /= f2;
        int i3 = 6;
        final int[] iArr = new int[i3];
        int i22 = 0;
        iArr[i22] = a.f(this.i, this.m);
        int i25 = 1;
        iArr[i25] = a.f(this.j, this.m);
        int i27 = 2;
        iArr[i27] = a.f(a.i(this.j, i22), this.m);
        int i30 = 3;
        iArr[i30] = a.f(a.i(this.l, i22), this.m);
        int i32 = 4;
        iArr[i32] = a.f(this.l, this.m);
        int i34 = 5;
        iArr[i34] = a.f(this.k, this.m);
        float[] fArr = new float[i3];
        fArr[i22] = 0;
        fArr[i25] = i;
        int i19 = 1056964608;
        fArr[i27] = i19;
        fArr[i30] = i19;
        int i20 = 1065353216;
        fArr[i32] = i20 - i;
        fArr[i34] = i20;
        super(0, (float)top, 0, (float)bottom, iArr, fArr, Shader.TileMode.CLAMP);
        return linearGradient;
    }

    @Override // android.graphics.drawable.Drawable
    protected RectF b() {
        this.f.set(getBounds());
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    void c(ColorStateList colorStateList) {
        int colorForState;
        int i;
        if (colorStateList != null) {
            this.m = colorStateList.getColorForState(getState(), this.m);
        }
        this.p = colorStateList;
        this.n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void d(float f) {
        int cmp;
        int i;
        float obj3;
        if (Float.compare(f2, f) != 0) {
            this.h = f;
            this.b.setStrokeWidth(f *= i);
            this.n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z2;
        int i;
        Shader shader;
        boolean z;
        if (this.n) {
            this.b.setShader(a());
            this.n = false;
        }
        int i2 = 1073741824;
        strokeWidth /= i2;
        copyBounds(this.d);
        this.e.set(this.d);
        float f = Math.min(this.o.r().a(b()), width /= i2);
        if (this.o.u(b())) {
            this.e.inset(i, i);
            canvas.drawRoundRect(this.e, f, f, this.b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    void e(int i, int i2, int i3, int i4) {
        this.i = i;
        this.j = i2;
        this.k = i3;
        this.l = i4;
    }

    @Override // android.graphics.drawable.Drawable
    public void f(k k) {
        this.o = k;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int i;
        i = Float.compare(f, i2) > 0 ? -3 : -2;
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        boolean convex;
        if (this.o.u(b())) {
            outline.setRoundRect(getBounds(), this.o.r().a(b()));
        }
        copyBounds(this.d);
        this.e.set(this.d);
        this.a.d(this.o, 1065353216, this.e, this.c);
        if (this.c.isConvex()) {
            outline.setConvexPath(this.c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean round;
        if (this.o.u(b())) {
            round = Math.round(this.h);
            rect.set(round, round, round, round);
        }
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        boolean stateful;
        int i;
        stateful = this.p;
        if (stateful != null) {
            if (!stateful.isStateful()) {
                i = super.isStateful() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList list;
        int i;
        int[] obj3;
        list = this.p;
        obj3 = list.getColorForState(iArr, this.m);
        if (list != null && obj3 != this.m) {
            obj3 = list.getColorForState(iArr, this.m);
            if (obj3 != this.m) {
                this.n = true;
                this.m = obj3;
            }
        }
        if (this.n) {
            invalidateSelf();
        }
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.b.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
