package d.u;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

/* loaded from: classes.dex */
class i {
    static PropertyValuesHolder a(Property<?, PointF> property, Path path2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return PropertyValuesHolder.ofObject(property, 0, path2);
        }
        h hVar = new h(property, path2);
        float[] obj2 = new float[2];
        obj2 = new int[]{0, 1065353216};
        return PropertyValuesHolder.ofFloat(hVar, obj2);
    }
}
