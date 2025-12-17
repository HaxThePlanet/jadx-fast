package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

/* loaded from: classes5.dex */
abstract class LookupTableInterpolator implements Interpolator {

    private final float mStepSize = 1f;
    private final float[] mValues;
    protected LookupTableInterpolator(float[] values) {
        super();
        this.mValues = values;
        i2 /= f;
    }

    @Override // android.view.animation.Interpolator
    public float getInterpolation(float input) {
        int i = 1065353216;
        if (Float.compare(input, i) >= 0) {
            return i;
        }
        int i2 = 0;
        if (Float.compare(input, i2) <= 0) {
            return i2;
        }
        int i6 = Math.min((int)i4, length2 += -2);
        return f3 += i13;
    }
}
