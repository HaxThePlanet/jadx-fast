package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005H&ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0003", d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "", "transformBy", "", "zoomChange", "", "panChange", "Landroidx/compose/ui/geometry/Offset;", "rotationChange", "transformBy-d-4ec7I", "(FJF)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TransformScope {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void transformBy-d-4ec7I$default(androidx.compose.foundation.gestures.TransformScope transformScope, float f2, long l3, float f4, int i5, Object object6) {
            TransformScope.transformBy-d-4ec7I$default(transformScope, f2, l3, f4, i5, object6);
        }
    }
    public static void transformBy-d-4ec7I$default(androidx.compose.foundation.gestures.TransformScope transformScope, float f2, long l3, float f4, int i5, Object object6) {
        int obj1;
        long obj2;
        int obj4;
        if (obj6 != null) {
        } else {
            if (object6 & 1 != 0) {
                obj1 = 1065353216;
            }
            if (object6 & 2 != 0) {
                obj2 = Offset.Companion.getZero-F1C5BW0();
            }
            if (object6 &= 4 != 0) {
                obj4 = 0;
            }
            transformScope.transformBy-d-4ec7I(obj1, obj2, f4);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transformBy-d-4ec7I");
        throw obj0;
    }

    public abstract void transformBy-d-4ec7I(float f, long l2, float f3);
}
