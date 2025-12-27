package d.n.a.a;

import android.view.animation.Interpolator;

/* compiled from: LookupTableInterpolator.java */
/* loaded from: classes.dex */
abstract class d implements Interpolator {

    private final float[] a;
    private final float b;
    protected d(float[] fArr) {
        super();
        this.a = fArr;
        this.b = 1f / (float)(fArr.length - 1);
    }

    public float getInterpolation(float f) {
        float f2 = 1f;
        if (f >= f2) {
            return f2;
        }
        float f3 = 0.0f;
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int)(float)(fArr.length - 1) * f, fArr.length - 2);
        return fArr2[min] + (f - (float)min * f9) / f9 * (fArr2[min + 1]) - fArr2[min];
    }
}
