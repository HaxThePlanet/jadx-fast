package com.bumptech.glide.load.n.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import com.bumptech.glide.c;
import com.bumptech.glide.load.l;
import com.bumptech.glide.n.a;
import com.bumptech.glide.t.k;
import d.v.a.a.b;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: GifDrawable.java */
/* loaded from: classes.dex */
public class c extends Drawable implements g.b, Animatable {

    private Paint A;
    private Rect B;
    private List<b> C;
    private final c.a a;
    private boolean b;
    private boolean c;
    private boolean v;
    private boolean w;
    private int x;
    private int y;
    private boolean z;

    static final class a extends Drawable.ConstantState {

        final g a;
        a(g gVar) {
            super();
            this.a = gVar;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            return new c(this);
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }
    public c(Context context, a aVar, l<Bitmap> lVar, int i, int i2, Bitmap bitmap) {
        super(c.c(context), aVar, i, i2, lVar, bitmap);
        this(new c.a(gVar));
    }

    private Drawable.Callback b() {
        Drawable.Callback callback;
        callback = getCallback();
        z = callback instanceof Drawable;
        while (callback instanceof Drawable) {
            callback = callback.getCallback();
            z = callback instanceof Drawable;
        }
        return callback;
    }

    private Rect d() {
        if (this.B == null) {
            this.B = new Rect();
        }
        return this.B;
    }

    private Paint h() {
        if (this.A == null) {
            int i = 2;
            this.A = new Paint(i);
        }
        return this.A;
    }

    private void j() {
        int i = 0;
        Object item;
        if (this.C != null) {
            i = 0;
            while (i < this.C.size()) {
                (b)this.C.get(i).onAnimationEnd(this);
                i = i + 1;
            }
        }
    }

    private void l() {
        this.x = 0;
    }

    private void n() {
        final int i3 = 1;
        k.a(this.v ^ i3, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.a.a.f() == i3) {
            invalidateSelf();
        } else {
            if (!this.b) {
                this.b = true;
                this.a.a.r(this);
                invalidateSelf();
            }
        }
    }

    private void o() {
        this.b = false;
        this.a.a.s(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.x++;
        }
        int i2 = -1;
        if (this.y != -1 && this.x >= this.y) {
            j();
            stop();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ByteBuffer c() {
        return this.a.a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.v) {
            return;
        }
        if (this.z) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            boolean z = false;
            this.z = z;
        }
        canvas.drawBitmap(this.a.a.c(), null, d(), h());
    }

    @Override // android.graphics.drawable.Drawable
    public Bitmap e() {
        return this.a.a.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int f() {
        return this.a.a.f();
    }

    @Override // android.graphics.drawable.Drawable
    public int g() {
        return this.a.a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.a.a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.a.a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int i() {
        return this.a.a.j();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isRunning() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public void k() {
        this.v = true;
        this.a.a.a();
    }

    @Override // android.graphics.drawable.Drawable
    public void m(l<Bitmap> lVar, Bitmap bitmap) {
        this.a.a.o(lVar, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.z = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        h().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        i = !this.v;
        k.a(i, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.w = z;
        if (!z) {
            o();
        } else {
            if (this.c) {
                n();
            }
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void start() {
        this.c = true;
        l();
        if (this.w) {
            n();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void stop() {
        this.c = false;
        o();
    }

    c(c.a aVar) {
        super();
        this.w = true;
        this.y = -1;
        k.d(aVar);
        this.a = aVar;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }
}
