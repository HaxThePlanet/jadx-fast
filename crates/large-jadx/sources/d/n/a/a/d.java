package d.n.a.a;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
abstract class d implements Interpolator {

    private final float[] a;
    private final float b = 1f;
    protected d(float[] fArr) {
        super();
        this.a = fArr;
        i /= obj2;
    }

    @Override // android.view.animation.Interpolator
    public float getInterpolation(float f) {
        int i = 1065353216;
        if (Float.compare(f, i) >= 0) {
            return i;
        }
        int i2 = 0;
        if (Float.compare(f, i2) <= 0) {
            return i2;
        }
        float[] fArr = this.a;
        int i4 = Math.min((int)i6, length += -2);
        float f5 = this.b;
        float[] fArr2 = this.a;
        return f6 += obj5;
    }
}
