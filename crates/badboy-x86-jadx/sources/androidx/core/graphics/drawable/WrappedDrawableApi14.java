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

/* loaded from: classes5.dex */
class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, androidx.core.graphics.drawable.WrappedDrawable, androidx.core.graphics.drawable.TintAwareDrawable {

    static final PorterDuff.Mode DEFAULT_TINT_MODE;
    private boolean mColorFilterSet;
    private int mCurrentColor;
    private PorterDuff.Mode mCurrentMode;
    Drawable mDrawable;
    private boolean mMutated;
    androidx.core.graphics.drawable.WrappedDrawableState mState;
    static {
        WrappedDrawableApi14.DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    WrappedDrawableApi14(Drawable dr) {
        super();
        this.mState = mutateConstantState();
        setWrappedDrawable(dr);
    }

    WrappedDrawableApi14(androidx.core.graphics.drawable.WrappedDrawableState state, Resources res) {
        super();
        this.mState = state;
        updateLocalState(res);
    }

    private androidx.core.graphics.drawable.WrappedDrawableState mutateConstantState() {
        WrappedDrawableState wrappedDrawableState = new WrappedDrawableState(this.mState);
        return wrappedDrawableState;
    }

    private void updateLocalState(Resources res) {
        Object mDrawableState;
        if (this.mState != null && mState.mDrawableState != null) {
            if (mState.mDrawableState != null) {
                setWrappedDrawable(mState2.mDrawableState.newDrawable(res));
            }
        }
    }

    private boolean updateTint(int[] state) {
        int colorForState;
        PorterDuff.Mode mColorFilterSet;
        int i = 0;
        if (!isCompatTintEnabled()) {
            return i;
        }
        ColorStateList mTint = mState.mTint;
        PorterDuff.Mode mTintMode = mState2.mTintMode;
        colorForState = mTint.getColorForState(state, mTint.getDefaultColor());
        if (mTint != null && mTintMode != null && this.mColorFilterSet != null && colorForState == this.mCurrentColor && mTintMode != this.mCurrentMode) {
            if (mTintMode != null) {
                colorForState = mTint.getColorForState(state, mTint.getDefaultColor());
                if (this.mColorFilterSet != null) {
                    if (colorForState == this.mCurrentColor) {
                        if (mTintMode != this.mCurrentMode) {
                        }
                        return i;
                    }
                }
                setColorFilter(colorForState, mTintMode);
                this.mCurrentColor = colorForState;
                this.mCurrentMode = mTintMode;
                int i2 = 1;
                this.mColorFilterSet = i2;
                return i2;
            }
        }
        this.mColorFilterSet = i;
        clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations;
        if (this.mState != null) {
            changingConfigurations = this.mState.getChangingConfigurations();
        } else {
            changingConfigurations = 0;
        }
        return i |= changingConfigurations3;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        androidx.core.graphics.drawable.WrappedDrawableState constantState;
        if (this.mState != null && this.mState.canConstantState()) {
            if (this.mState.canConstantState()) {
                mState2.mChangingConfigurations = getChangingConfigurations();
                return this.mState;
            }
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return DrawableCompat.getLayoutDirection(this.mDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        return this.mDrawable.getPadding(padding);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.mDrawable.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateDrawable(Drawable who) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean isCompatTintEnabled() {
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        boolean compatTintEnabled;
        int mTint;
        boolean stateful;
        int i;
        if (isCompatTintEnabled() && this.mState != null) {
            mTint = this.mState != null ? mState.mTint : 0;
        } else {
        }
        if (mTint != 0) {
            if (!mTint.isStateful()) {
                i = this.mDrawable.isStateful() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        boolean mMutated;
        Drawable mDrawable;
        androidx.core.graphics.drawable.WrappedDrawableState mState;
        int constantState;
        this.mState = mutateConstantState();
        if (!this.mMutated && super.mutate() == this && this.mDrawable != null) {
            if (super.mutate() == this) {
                this.mState = mutateConstantState();
                if (this.mDrawable != null) {
                    this.mDrawable.mutate();
                }
                if (this.mState != null) {
                    if (this.mDrawable != null) {
                        constantState = this.mDrawable.getConstantState();
                    } else {
                        constantState = 0;
                    }
                    mState.mDrawableState = constantState;
                }
                this.mMutated = true;
            }
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Drawable mDrawable;
        if (this.mDrawable != null) {
            this.mDrawable.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int layoutDirection) {
        return DrawableCompat.setLayoutDirection(this.mDrawable, layoutDirection);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int level) {
        return this.mDrawable.setLevel(level);
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        scheduleSelf(what, when);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.mDrawable.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean mirrored) {
        DrawableCompat.setAutoMirrored(this.mDrawable, mirrored);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int configs) {
        this.mDrawable.setChangingConfigurations(configs);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
        this.mDrawable.setColorFilter(cf);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean dither) {
        this.mDrawable.setDither(dither);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean filter) {
        this.mDrawable.setFilterBitmap(filter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] stateSet) {
        int i;
        if (!updateTint(stateSet)) {
            if (this.mDrawable.setState(stateSet)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int tint) {
        setTintList(ColorStateList.valueOf(tint));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList tint) {
        mState.mTint = tint;
        updateTint(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode tintMode) {
        mState.mTintMode = tintMode;
        updateTint(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        int i;
        boolean visible2;
        if (!super.setVisible(visible, restart)) {
            if (this.mDrawable.setVisible(visible, restart)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setWrappedDrawable(Drawable dr) {
        Drawable mDrawable;
        int constantState;
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(0);
        }
        this.mDrawable = dr;
        dr.setCallback(this);
        setVisible(dr.isVisible(), true);
        setState(dr.getState());
        setLevel(dr.getLevel());
        setBounds(dr.getBounds());
        if (dr != null && this.mState != null) {
            dr.setCallback(this);
            setVisible(dr.isVisible(), true);
            setState(dr.getState());
            setLevel(dr.getLevel());
            setBounds(dr.getBounds());
            if (this.mState != null) {
                mDrawable.mDrawableState = dr.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleDrawable(Drawable who, Runnable what) {
        unscheduleSelf(what);
    }
}
