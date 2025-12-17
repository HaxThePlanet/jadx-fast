package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes5.dex */
public final class PathUtils {

    static class Api26Impl {
        static float[] approximate(Path path, float acceptableError) {
            return path.approximate(acceptableError);
        }
    }
    public static Collection<androidx.core.graphics.PathSegment> flatten(Path path) {
        return PathUtils.flatten(path, 1056964608);
    }

    public static Collection<androidx.core.graphics.PathSegment> flatten(Path path, float error) {
        int i;
        int i2;
        int i3;
        float f;
        float f3;
        float f6;
        float f2;
        float f4;
        float f5;
        int pathSegment;
        PointF pointF2;
        PointF pointF;
        final float[] approximate = PathUtils.Api26Impl.approximate(path, error);
        length /= 3;
        ArrayList arrayList = new ArrayList(i4);
        i = 1;
        while (i < i4) {
            i2 = i * 3;
            i5 *= 3;
            f = approximate[i2];
            f3 = approximate[i2 + 1];
            f6 = approximate[i2 + 2];
            f2 = approximate[i3];
            f4 = approximate[i3 + 1];
            f5 = approximate[i3 + 2];
            if (Float.compare(f, f2) != 0) {
            }
            i++;
            if (Float.compare(f3, f4) == 0) {
            } else {
            }
            pointF2 = new PointF(f4, f5);
            pointF = new PointF(f3, f6);
            pathSegment = new PathSegment(pointF2, f2, pointF, f);
            arrayList.add(pathSegment);
            if (Float.compare(f6, f5) != 0) {
            }
        }
        return arrayList;
    }
}
