package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
class WrappedDrawableApi21 extends androidx.core.graphics.drawable.WrappedDrawableApi14 {

    private static final String TAG = "WrappedDrawableApi21";
    private static Method sIsProjectedDrawableMethod;
    WrappedDrawableApi21(Drawable drawable) {
        super(drawable);
        findAndCacheIsProjectedDrawableMethod();
    }

    WrappedDrawableApi21(androidx.core.graphics.drawable.WrappedDrawableState state, Resources resources) {
        super(state, resources);
        findAndCacheIsProjectedDrawableMethod();
    }

    private void findAndCacheIsProjectedDrawableMethod() {
        Method sIsProjectedDrawableMethod;
        String str2;
        String str;
        if (WrappedDrawableApi21.sIsProjectedDrawableMethod == null) {
            WrappedDrawableApi21.sIsProjectedDrawableMethod = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
        }
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    public void getOutline(Outline outline) {
        this.mDrawable.getOutline(outline);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    protected boolean isCompatTintEnabled() {
        return 0;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    public boolean isProjected() {
        Object sIsProjectedDrawableMethod;
        String str2;
        String str;
        final int i = 0;
        if (this.mDrawable != null && WrappedDrawableApi21.sIsProjectedDrawableMethod != null) {
            if (WrappedDrawableApi21.sIsProjectedDrawableMethod != null) {
                return (Boolean)WrappedDrawableApi21.sIsProjectedDrawableMethod.invoke(this.mDrawable, new Object[i]).booleanValue();
            }
        }
        return i;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    public void setHotspot(float x, float y) {
        this.mDrawable.setHotspot(x, y);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    public void setHotspotBounds(int left, int top, int right, int bottom) {
        this.mDrawable.setHotspotBounds(left, top, right, bottom);
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    public boolean setState(int[] stateSet) {
        if (super.setState(stateSet)) {
            invalidateSelf();
            return 1;
        }
        return 0;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    public void setTint(int tintColor) {
        boolean compatTintEnabled;
        if (isCompatTintEnabled()) {
            super.setTint(tintColor);
        } else {
            this.mDrawable.setTint(tintColor);
        }
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    public void setTintList(ColorStateList tint) {
        boolean compatTintEnabled;
        if (isCompatTintEnabled()) {
            super.setTintList(tint);
        } else {
            this.mDrawable.setTintList(tint);
        }
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawableApi14
    public void setTintMode(PorterDuff.Mode tintMode) {
        boolean compatTintEnabled;
        if (isCompatTintEnabled()) {
            super.setTintMode(tintMode);
        } else {
            this.mDrawable.setTintMode(tintMode);
        }
    }
}
