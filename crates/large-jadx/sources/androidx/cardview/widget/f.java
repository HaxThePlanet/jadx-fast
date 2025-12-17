package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class f extends Drawable {

    private float a;
    private final Paint b;
    private final RectF c;
    private final Rect d;
    private float e;
    private boolean f = false;
    private boolean g = true;
    private ColorStateList h;
    private PorterDuffColorFilter i;
    private ColorStateList j;
    private PorterDuff.Mode k = 1;
    f(ColorStateList colorStateList, float f2) {
        super();
        int i = 0;
        int i2 = 1;
        PorterDuff.Mode sRC_IN = PorterDuff.Mode.SRC_IN;
        this.a = f2;
        Paint obj3 = new Paint(5);
        this.b = obj3;
        e(colorStateList);
        RectF obj2 = new RectF();
        this.c = obj2;
        obj2 = new Rect();
        this.d = obj2;
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode porterDuff$Mode2) {
        if (colorStateList != null && mode2 == null) {
            if (mode2 == null) {
            }
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode2);
            return porterDuffColorFilter;
        }
        return null;
    }

    private void e(ColorStateList colorStateList) {
        ColorStateList obj4;
        if (colorStateList == null) {
            obj4 = ColorStateList.valueOf(0);
        }
        this.h = obj4;
        this.b.setColor(obj4.getColorForState(getState(), this.h.getDefaultColor()));
    }

    private void i(Rect rect) {
        Rect rect3;
        float rect2;
        float ceil;
        Rect obj6;
        if (rect == null) {
            obj6 = getBounds();
        }
        float f5 = (float)right;
        this.c.set((float)left, (float)top, f5, (float)bottom);
        this.d.set(obj6);
        if (this.f) {
            this.d.inset((int)ceil2, (int)ceil);
            this.c.set(this.d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorStateList b() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    float c() {
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public float d() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Object colorFilter;
        int i;
        int obj5;
        final Paint paint = this.b;
        if (this.i != null && paint.getColorFilter() == null) {
            if (paint.getColorFilter() == null) {
                paint.setColorFilter(this.i);
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        final float f = this.a;
        canvas.drawRoundRect(this.c, f, f, paint);
        if (i != 0) {
            paint.setColorFilter(0);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    void g(float f, boolean z2, boolean z3) {
        int cmp;
        if (Float.compare(f, f2) == 0 && this.f == z2 && this.g == z3) {
            if (this.f == z2) {
                if (this.g == z3) {
                }
            }
        }
        this.e = f;
        this.f = z2;
        this.g = z3;
        i(0);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.d, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    void h(float f) {
        if (Float.compare(f, f2) == 0) {
        }
        this.a = f;
        i(0);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        int i;
        ColorStateList stateful;
        stateful = this.j;
        if (stateful != null) {
            if (!stateful.isStateful()) {
                stateful = this.h;
                if (stateful != null) {
                    if (!stateful.isStateful()) {
                        i = super.isStateful() ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int i;
        Paint paint;
        ColorStateList list = this.h;
        int obj4 = list.getColorForState(iArr, list.getDefaultColor());
        int i2 = 1;
        i = obj4 != this.b.getColor() ? i2 : 0;
        if (i != 0) {
            this.b.setColor(obj4);
        }
        obj4 = this.j;
        paint = this.k;
        if (obj4 != null && paint != null) {
            paint = this.k;
            if (paint != null) {
                this.i = a(obj4, paint);
                return i2;
            }
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.i = a(colorStateList, this.k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode porterDuff$Mode) {
        this.k = mode;
        this.i = a(this.j, mode);
        invalidateSelf();
    }
}
