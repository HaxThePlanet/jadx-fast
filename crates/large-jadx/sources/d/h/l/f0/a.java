package d.h.l.f0;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* compiled from: PathInterpolatorApi14.java */
/* loaded from: classes.dex */
class a implements Interpolator {

    private final float[] a;
    private final float[] b;
    a(Path path) {
        boolean z;
        super();
        z = false;
        final PathMeasure pathMeasure = new PathMeasure(path, z);
        final float length = pathMeasure.getLength();
        final int i4 = 1;
        int i3 = (int)(length / 0.002f) + i4;
        this.a = new float[i3];
        this.b = new float[i3];
        float[] fArr4 = new float[2];
        while (z < i3) {
            pathMeasure.getPosTan((z != 0 ? 1f : 0f) * length / (float)(i3 - 1), fArr4, null);
            this.a[z] = fArr4[z];
            this.b[z] = fArr4[i4];
            z = z + 1;
        }
    }

    private static Path a(float f, float f2, float f3, float f4) {
        final Path path = new Path();
        float f6 = 0.0f;
        path.moveTo(f6, f6);
        path.cubicTo(f, f2, f3, f4, 1f, 1f);
        return path;
    }

    public float getInterpolation(float f) {
        int i = 0;
        float f2 = 0.0f;
        if (f <= 0.0f) {
            return 0.0f;
        }
        float f6 = 1f;
        if (f >= f6) {
            return f6;
        }
        i = 0;
        int i2 = 1;
        i = this.a.length - i2;
        while (i - i > i2) {
            i = (i + i) / 2;
            float f11 = this.a[i];
        }
        float f10 = fArr3[i] - fArr3[i];
        if (f10 == 0.0f) {
            return this.b[i];
        }
        float f7 = fArr[i];
        return f7 + (f - fArr3[i]) / f10 * (fArr[i] - f7);
    }

    a(float f, float f2, float f3, float f4) {
        this(a.a(f, f2, f3, f4));
    }
}
