package d.h.l.f0;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
class a implements Interpolator {

    private final float[] a;
    private final float[] b;
    a(float f, float f2, float f3, float f4) {
        super(a.a(f, f2, f3, f4));
    }

    a(Path path) {
        int i;
        float[] fArr;
        float f;
        super();
        final int i2 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, i2);
        final float obj9 = pathMeasure.getLength();
        final int i7 = 1;
        i5 += i7;
        this.a = new float[i6];
        this.b = new float[i6];
        float[] fArr4 = new float[2];
        i = i2;
        while (i < i6) {
            pathMeasure.getPosTan(i9 /= f3, fArr4, 0);
            this.a[i] = fArr4[i2];
            this.b[i] = fArr4[i7];
            i++;
        }
    }

    private static Path a(float f, float f2, float f3, float f4) {
        Path path2 = new Path();
        int i = 0;
        path2.moveTo(i, i);
        path2.cubicTo(f, f2, f3, f4, 1065353216, 1065353216);
        return path2;
    }

    @Override // android.view.animation.Interpolator
    public float getInterpolation(float f) {
        int i2;
        int i;
        int i3;
        int cmp;
        int i4 = 0;
        if (Float.compare(f, i4) <= 0) {
            return i4;
        }
        int i6 = 1065353216;
        if (Float.compare(f, i6) >= 0) {
            return i6;
        }
        i2 = 0;
        int i8 = 1;
        length -= i8;
        while (i - i2 > i8) {
            i10 /= 2;
            if (Float.compare(f, f6) < 0) {
            } else {
            }
            i2 = i3;
            i = i3;
        }
        float[] fArr3 = this.a;
        f5 -= f7;
        if (Float.compare(i11, i4) == 0) {
            return this.b[i2];
        }
        float[] fArr = this.b;
        float f4 = fArr[i2];
        return f4 += obj7;
    }
}
