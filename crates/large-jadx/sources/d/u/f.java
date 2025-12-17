package d.u;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

/* loaded from: classes.dex */
class f {
    static <T> ObjectAnimator a(T t, Property<T, PointF> property2, Path path3) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ObjectAnimator.ofObject(t, property2, 0, path3);
        }
        h hVar = new h(property2, path3);
        float[] obj3 = new float[2];
        obj3 = new int[]{0, 1065353216};
        return ObjectAnimator.ofFloat(t, hVar, obj3);
    }
}
