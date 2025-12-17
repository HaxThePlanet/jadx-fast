package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class e extends androidx.core.graphics.drawable.d {

    private static Method z;
    e(Drawable drawable) {
        super(drawable);
        g();
    }

    e(androidx.core.graphics.drawable.f f, Resources resources2) {
        super(f, resources2);
        g();
    }

    private void g() {
        Method declaredMethod;
        String str;
        String str2;
        if (e.z == null) {
            e.z = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
        }
    }

    @Override // androidx.core.graphics.drawable.d
    protected boolean c() {
        Drawable sDK_INT;
        int i2;
        boolean i;
        i2 = 0;
        if (Build.VERSION.SDK_INT == 21) {
            sDK_INT = this.x;
            if (!sDK_INT instanceof GradientDrawable && !sDK_INT instanceof DrawableContainer && !sDK_INT instanceof InsetDrawable) {
                if (!sDK_INT instanceof DrawableContainer) {
                    if (!sDK_INT instanceof InsetDrawable) {
                        if (sDK_INT instanceof RippleDrawable) {
                            i2 = 1;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
        return i2;
    }

    @Override // androidx.core.graphics.drawable.d
    public Rect getDirtyBounds() {
        return this.x.getDirtyBounds();
    }

    @Override // androidx.core.graphics.drawable.d
    public void getOutline(Outline outline) {
        this.x.getOutline(outline);
    }

    @Override // androidx.core.graphics.drawable.d
    public boolean isProjected() {
        Drawable drawable;
        Object str2;
        String str;
        drawable = this.x;
        final int i = 0;
        str2 = e.z;
        if (drawable != null && str2 != null) {
            str2 = e.z;
            if (str2 != null) {
                return (Boolean)str2.invoke(drawable, new Object[i]).booleanValue();
            }
        }
        return i;
    }

    @Override // androidx.core.graphics.drawable.d
    public void setHotspot(float f, float f2) {
        this.x.setHotspot(f, f2);
    }

    @Override // androidx.core.graphics.drawable.d
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.x.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.core.graphics.drawable.d
    public boolean setState(int[] iArr) {
        if (super.setState(iArr)) {
            invalidateSelf();
            return 1;
        }
        return 0;
    }

    @Override // androidx.core.graphics.drawable.d
    public void setTint(int i) {
        boolean z;
        if (c()) {
            super.setTint(i);
        } else {
            this.x.setTint(i);
        }
    }

    @Override // androidx.core.graphics.drawable.d
    public void setTintList(ColorStateList colorStateList) {
        boolean z;
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.x.setTintList(colorStateList);
        }
    }

    @Override // androidx.core.graphics.drawable.d
    public void setTintMode(PorterDuff.Mode porterDuff$Mode) {
        boolean z;
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.x.setTintMode(mode);
        }
    }
}
