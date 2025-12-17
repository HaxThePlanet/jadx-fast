package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: classes5.dex */
class PathInterpolatorApi14 implements Interpolator {

    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;
    PathInterpolatorApi14(float controlX, float controlY) {
        super(PathInterpolatorApi14.createQuad(controlX, controlY));
    }

    PathInterpolatorApi14(float controlX1, float controlY1, float controlX2, float controlY2) {
        super(PathInterpolatorApi14.createCubic(controlX1, controlY1, controlX2, controlY2));
    }

    PathInterpolatorApi14(Path path) {
        int i;
        int i2;
        float[] fArr;
        float f;
        super();
        final int i3 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, i3);
        final float length = pathMeasure.getLength();
        final int i8 = 1;
        i6 += i8;
        this.mX = new float[i7];
        this.mY = new float[i7];
        float[] fArr4 = new float[2];
        i = 0;
        while (i < i7) {
            pathMeasure.getPosTan(i10 /= f3, fArr4, 0);
            this.mX[i] = fArr4[i3];
            this.mY[i] = fArr4[i8];
            i++;
        }
    }

    private static Path createCubic(float controlX1, float controlY1, float controlX2, float controlY2) {
        Path path = new Path();
        final Path path2 = path;
        int i = 0;
        path2.moveTo(i, i);
        path2.cubicTo(controlX1, controlY1, controlX2, controlY2, 1065353216, 1065353216);
        return path2;
    }

    private static Path createQuad(float controlX, float controlY) {
        Path path = new Path();
        int i = 0;
        path.moveTo(i, i);
        int i2 = 1065353216;
        path.quadTo(controlX, controlY, i2, i2);
        return path;
    }

    @Override // android.view.animation.Interpolator
    public float getInterpolation(float t) {
        int startIndex;
        int endIndex;
        int i;
        int cmp;
        int i2 = 0;
        if (Float.compare(t, i2) <= 0) {
            return i2;
        }
        int i4 = 1065353216;
        if (Float.compare(t, i4) >= 0) {
            return i4;
        }
        startIndex = 0;
        int i5 = 1;
        length -= i5;
        while (endIndex - startIndex > i5) {
            i9 /= 2;
            if (Float.compare(t, f6) < 0) {
            } else {
            }
            startIndex = i;
            endIndex = i;
        }
        f3 -= f4;
        if (Float.compare(i6, i2) == 0) {
            return this.mY[startIndex];
        }
        float f5 = this.mY[startIndex];
        return i11 += f5;
    }
}
