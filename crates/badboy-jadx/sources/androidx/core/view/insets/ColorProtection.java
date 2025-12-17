package androidx.core.view.insets;

import android.graphics.drawable.ColorDrawable;

/* loaded from: classes5.dex */
public class ColorProtection extends androidx.core.view.insets.Protection {

    private int mColor;
    private final ColorDrawable mDrawable;
    private boolean mHasColor;
    public ColorProtection(int side) {
        super(side);
        ColorDrawable colorDrawable = new ColorDrawable();
        this.mDrawable = colorDrawable;
        this.mColor = 0;
    }

    public ColorProtection(int side, int color) {
        super(side);
        setColor(color);
    }

    private void setColorInner(int color) {
        int mDrawable;
        if (this.mColor != color) {
            this.mColor = color;
            this.mDrawable.setColor(color);
            setDrawable(this.mDrawable);
        }
    }

    @Override // androidx.core.view.insets.Protection
    void dispatchColorHint(int color) {
        if (!this.mHasColor) {
            setColorInner(color);
        }
    }

    @Override // androidx.core.view.insets.Protection
    public int getColor() {
        return this.mColor;
    }

    @Override // androidx.core.view.insets.Protection
    boolean occupiesCorners() {
        return 1;
    }

    @Override // androidx.core.view.insets.Protection
    public void setColor(int color) {
        this.mHasColor = true;
        setColorInner(color);
    }
}
