package androidx.core.view.insets;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.animation.PathInterpolator;

/* loaded from: classes5.dex */
public class GradientProtection extends androidx.core.view.insets.Protection {

    private static final float[] ALPHAS;
    private int mColor;
    private final int[] mColors;
    private final GradientDrawable mDrawable;
    private boolean mHasColor;
    private float mScale;
    static {
        int i;
        int aLPHAS;
        int interpolation;
        float f;
        GradientProtection.ALPHAS = new float[100];
        PathInterpolator pathInterpolator = new PathInterpolator(1054280253, 0, 1058306785, 1065353216);
        length--;
        i = i4;
        while (i >= 0) {
            GradientProtection.ALPHAS[i] = pathInterpolator.getInterpolation(f2 /= f);
            i--;
        }
    }

    public GradientProtection(int side) {
        GradientDrawable mDrawable;
        GradientDrawable.Orientation rIGHT_LEFT;
        super(side);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.mDrawable = gradientDrawable;
        this.mColors = new int[aLPHAS.length];
        this.mColor = 0;
        this.mScale = 1067030938;
        switch (side) {
            case 1:
                this.mDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                break;
            case 2:
                this.mDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                break;
            case 4:
                this.mDrawable.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
                break;
            case 8:
                this.mDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                break;
            default:
        }
    }

    public GradientProtection(int side, int color) {
        super(side);
        setColor(color);
    }

    private void setColorInner(int color) {
        int mDrawable;
        int[] mColors;
        if (this.mColor != color) {
            this.mColor = color;
            GradientProtection.toColors(this.mColor, this.mColors);
            this.mDrawable.setColors(this.mColors);
            setDrawable(this.mDrawable);
        }
    }

    private static void toColors(int color, int[] colors) {
        int i;
        int argb;
        int i2;
        int green;
        int blue;
        length--;
        while (i >= 0) {
            colors[i] = Color.argb((int)i3, Color.red(color), Color.green(color), Color.blue(color));
            i--;
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
    public float getScale() {
        return this.mScale;
    }

    @Override // androidx.core.view.insets.Protection
    int getThickness(int inset) {
        return (int)i;
    }

    @Override // androidx.core.view.insets.Protection
    public void setColor(int color) {
        this.mHasColor = true;
        setColorInner(color);
    }

    @Override // androidx.core.view.insets.Protection
    public void setScale(float scale) {
        if (Float.compare(scale, i) < 0) {
        } else {
            this.mScale = scale;
            updateLayout();
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Scale must not be negative.");
        throw illegalArgumentException;
    }
}
