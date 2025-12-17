package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* loaded from: classes5.dex */
final class WrappedDrawableState extends Drawable.ConstantState {

    int mChangingConfigurations = 0;
    Drawable.ConstantState mDrawableState = null;
    ColorStateList mTint;
    PorterDuff.Mode mTintMode;
    WrappedDrawableState(androidx.core.graphics.drawable.WrappedDrawableState orig) {
        PorterDuff.Mode dEFAULT_TINT_MODE;
        super();
        this.mTint = 0;
        this.mTintMode = WrappedDrawableApi14.DEFAULT_TINT_MODE;
        if (orig != null) {
            int mChangingConfigurations = orig.mChangingConfigurations;
            Drawable.ConstantState mDrawableState = orig.mDrawableState;
            this.mTint = orig.mTint;
            this.mTintMode = orig.mTintMode;
        }
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    boolean canConstantState() {
        int i;
        i = this.mDrawableState != null ? 1 : 0;
        return i;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public int getChangingConfigurations() {
        int changingConfigurations;
        if (this.mDrawableState != null) {
            changingConfigurations = this.mDrawableState.getChangingConfigurations();
        } else {
            changingConfigurations = 0;
        }
        return mChangingConfigurations |= changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public Drawable newDrawable() {
        return newDrawable(0);
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public Drawable newDrawable(Resources res) {
        WrappedDrawableApi21 wrappedDrawableApi21 = new WrappedDrawableApi21(this, res);
        return wrappedDrawableApi21;
    }
}
