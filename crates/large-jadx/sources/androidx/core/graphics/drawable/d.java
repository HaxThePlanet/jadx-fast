package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

/* loaded from: classes.dex */
class d extends Drawable implements Drawable.Callback, androidx.core.graphics.drawable.c, androidx.core.graphics.drawable.b {

    static final PorterDuff.Mode y;
    private int a;
    private PorterDuff.Mode b;
    private boolean c;
    androidx.core.graphics.drawable.f v;
    private boolean w;
    Drawable x;
    static {
        d.y = PorterDuff.Mode.SRC_IN;
    }

    d(Drawable drawable) {
        super();
        this.v = d();
        a(drawable);
    }

    d(androidx.core.graphics.drawable.f f, Resources resources2) {
        super();
        this.v = f;
        e(resources2);
    }

    private androidx.core.graphics.drawable.f d() {
        f fVar = new f(this.v);
        return fVar;
    }

    private void e(Resources resources) {
        Drawable.ConstantState fVar;
        Object obj2;
        fVar = this.v;
        fVar = fVar.b;
        if (fVar != null && fVar != null) {
            fVar = fVar.b;
            if (fVar != null) {
                a(fVar.newDrawable(resources));
            }
        }
    }

    private boolean f(int[] iArr) {
        boolean list;
        int defaultColor;
        int obj5;
        final int i = 0;
        if (!c()) {
            return i;
        }
        androidx.core.graphics.drawable.f fVar = this.v;
        list = fVar.c;
        PorterDuff.Mode mode = fVar.d;
        obj5 = list.getColorForState(iArr, list.getDefaultColor());
        if (list != null && mode != null && this.c && obj5 == this.a && mode != this.b) {
            if (mode != null) {
                obj5 = list.getColorForState(iArr, list.getDefaultColor());
                if (this.c) {
                    if (obj5 == this.a) {
                        if (mode != this.b) {
                        }
                        return i;
                    }
                }
                setColorFilter(obj5, mode);
                this.a = obj5;
                this.b = mode;
                obj5 = 1;
                this.c = obj5;
                return obj5;
            }
        }
        this.c = i;
        clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final void a(Drawable drawable) {
        Object drawable2;
        int i;
        Object obj3;
        drawable2 = this.x;
        if (drawable2 != null) {
            drawable2.setCallback(0);
        }
        this.x = drawable;
        drawable.setCallback(this);
        setVisible(drawable.isVisible(), true);
        setState(drawable.getState());
        setLevel(drawable.getLevel());
        setBounds(drawable.getBounds());
        drawable2 = this.v;
        if (drawable != null && drawable2 != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            drawable2 = this.v;
            if (drawable2 != null) {
                drawable2.b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable b() {
        return this.x;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean c() {
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.x.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations;
        androidx.core.graphics.drawable.f fVar = this.v;
        if (fVar != null) {
            changingConfigurations = fVar.getChangingConfigurations();
        } else {
            changingConfigurations = 0;
        }
        return i |= changingConfigurations3;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        androidx.core.graphics.drawable.f fVar;
        fVar = this.v;
        if (fVar != null && fVar.a()) {
            if (fVar.a()) {
                fVar2.a = getChangingConfigurations();
                return this.v;
            }
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.x.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.x.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.x.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return a.f(this.x);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.x.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.x.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.x.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.x.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.x.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.x.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return a.h(this.x);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        boolean z;
        int stateful;
        int i;
        z = this.v;
        if (c() && z != null) {
            z = this.v;
            stateful = z != null ? z.c : 0;
        } else {
        }
        if (stateful != 0) {
            if (!stateful.isStateful()) {
                i = this.x.isStateful() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.x.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        boolean mutate;
        int constantState;
        this.v = d();
        Drawable drawable = this.x;
        if (!this.w && super.mutate() == this && drawable != null) {
            if (super.mutate() == this) {
                this.v = d();
                drawable = this.x;
                if (drawable != null) {
                    drawable.mutate();
                }
                androidx.core.graphics.drawable.f fVar2 = this.v;
                if (fVar2 != null) {
                    Drawable drawable2 = this.x;
                    if (drawable2 != null) {
                        constantState = drawable2.getConstantState();
                    } else {
                        constantState = 0;
                    }
                    fVar2.b = constantState;
                }
                this.w = true;
            }
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        final Drawable drawable = this.x;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return a.m(this.x, i);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.x.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleDrawable(Drawable drawable, Runnable runnable2, long l3) {
        scheduleSelf(runnable2, l3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.x.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        a.j(this.x, z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.x.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.x.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.x.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.x.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        int obj2;
        if (!f(iArr)) {
            if (this.x.setState(iArr)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        fVar.c = colorStateList;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode porterDuff$Mode) {
        fVar.d = mode;
        f(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable visible;
        int obj2;
        if (!super.setVisible(z, z2)) {
            if (this.x.setVisible(z, z2)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleDrawable(Drawable drawable, Runnable runnable2) {
        unscheduleSelf(runnable2);
    }
}
