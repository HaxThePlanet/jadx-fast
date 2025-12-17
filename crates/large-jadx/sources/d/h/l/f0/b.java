package d.h.l.f0;

import android.graphics.Path;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public final class b {
    public static Interpolator a(float f, float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            PathInterpolator pathInterpolator = new PathInterpolator(f, f2, f3, f4);
            return pathInterpolator;
        }
        a aVar = new a(f, f2, f3, f4);
        return aVar;
    }

    public static Interpolator b(Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            PathInterpolator pathInterpolator = new PathInterpolator(path);
            return pathInterpolator;
        }
        a aVar = new a(path);
        return aVar;
    }
}
