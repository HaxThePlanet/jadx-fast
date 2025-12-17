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

/* loaded from: classes.dex */
public class c extends Drawable implements com.bumptech.glide.load.n.g.g.b, Animatable {

    private Paint A;
    private Rect B;
    private List<b> C;
    private final com.bumptech.glide.load.n.g.c.a a;
    private boolean b;
    private boolean c;
    private boolean v;
    private boolean w;
    private int x;
    private int y;
    private boolean z;

    static final class a extends Drawable.ConstantState {

        final com.bumptech.glide.load.n.g.g a;
        a(com.bumptech.glide.load.n.g.g g) {
            super();
            this.a = g;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            c cVar = new c(this);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }
    public c(Context context, a a2, l<Bitmap> l3, int i4, int i5, Bitmap bitmap6) {
        super(c.c(context), a2, i4, i5, l3, bitmap6);
        c.a aVar = new c.a(gVar2);
        super(aVar);
    }

    c(com.bumptech.glide.load.n.g.c.a c$a) {
        super();
        this.w = true;
        this.y = -1;
        k.d(a);
        this.a = (c.a)a;
    }

    private Drawable.Callback b() {
        Drawable.Callback callback;
        boolean z;
        callback = getCallback();
        while (callback instanceof Drawable) {
            callback = (Drawable)callback.getCallback();
        }
        return callback;
    }

    private Rect d() {
        Rect rect;
        if (this.B == null) {
            rect = new Rect();
            this.B = rect;
        }
        return this.B;
    }

    private Paint h() {
        Paint paint;
        int i;
        if (this.A == null) {
            paint = new Paint(2);
            this.A = paint;
        }
        return this.A;
    }

    private void j() {
        List size;
        int i;
        Object obj;
        size = this.C;
        if (size != null) {
            i = 0;
            while (i < size.size()) {
                (b)this.C.get(i).onAnimationEnd(this);
                i++;
            }
        }
    }

    private void l() {
        this.x = 0;
    }

    private void n() {
        int i;
        final int i3 = 1;
        k.a(z ^= i3, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (aVar.a.f() == i3) {
            invalidateSelf();
        } else {
            if (!this.b) {
                this.b = i3;
                aVar2.a.r(this);
                invalidateSelf();
            }
        }
    }

    private void o() {
        this.b = false;
        aVar.a.s(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void a() {
        int i2;
        int i;
        if (b() == null) {
            stop();
            invalidateSelf();
        }
        invalidateSelf();
        if (g() == i5--) {
            this.x = i3++;
        }
        int i4 = this.y;
        if (i4 != -1 && this.x >= i4) {
            if (this.x >= i4) {
                j();
                stop();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ByteBuffer c() {
        return aVar.a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        int intrinsicWidth;
        int intrinsicHeight;
        Rect bounds;
        Rect rect;
        if (this.v) {
        }
        if (this.z) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.z = false;
        }
        canvas.drawBitmap(aVar.a.c(), 0, d(), h());
    }

    @Override // android.graphics.drawable.Drawable
    public Bitmap e() {
        return aVar.a.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int f() {
        return aVar.a.f();
    }

    @Override // android.graphics.drawable.Drawable
    public int g() {
        return aVar.a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return aVar.a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return aVar.a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public int i() {
        return aVar.a.j();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isRunning() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public void k() {
        this.v = true;
        aVar.a.a();
    }

    public void m(l<Bitmap> l, Bitmap bitmap2) {
        aVar.a.o(l, bitmap2);
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
        int i;
        k.a(z3 ^= 1, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
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
}
