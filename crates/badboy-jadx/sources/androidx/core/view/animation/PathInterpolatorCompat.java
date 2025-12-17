package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes5.dex */
public final class PathInterpolatorCompat {

    static class Api21Impl {
        static Interpolator createPathInterpolator(float controlX, float controlY) {
            PathInterpolator pathInterpolator = new PathInterpolator(controlX, controlY);
            return pathInterpolator;
        }

        static Interpolator createPathInterpolator(float controlX1, float controlY1, float controlX2, float controlY2) {
            PathInterpolator pathInterpolator = new PathInterpolator(controlX1, controlY1, controlX2, controlY2);
            return pathInterpolator;
        }

        static Interpolator createPathInterpolator(Path path) {
            PathInterpolator pathInterpolator = new PathInterpolator(path);
            return pathInterpolator;
        }
    }
    public static Interpolator create(float controlX, float controlY) {
        return PathInterpolatorCompat.Api21Impl.createPathInterpolator(controlX, controlY);
    }

    public static Interpolator create(float controlX1, float controlY1, float controlX2, float controlY2) {
        return PathInterpolatorCompat.Api21Impl.createPathInterpolator(controlX1, controlY1, controlX2, controlY2);
    }

    public static Interpolator create(Path path) {
        return PathInterpolatorCompat.Api21Impl.createPathInterpolator(path);
    }
}
