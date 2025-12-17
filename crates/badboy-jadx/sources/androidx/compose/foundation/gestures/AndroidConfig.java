package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/gestures/AndroidConfig;", "Landroidx/compose/foundation/gestures/ScrollConfig;", "()V", "calculateMouseWheelScroll", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/unit/Density;", "event", "Landroidx/compose/ui/input/pointer/PointerEvent;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "calculateMouseWheelScroll-8xgXZGE", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/input/pointer/PointerEvent;J)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AndroidConfig implements androidx.compose.foundation.gestures.ScrollConfig {

    public static final androidx.compose.foundation.gestures.AndroidConfig INSTANCE;
    static {
        AndroidConfig androidConfig = new AndroidConfig();
        AndroidConfig.INSTANCE = androidConfig;
    }

    @Override // androidx.compose.foundation.gestures.ScrollConfig
    public long calculateMouseWheelScroll-8xgXZGE(Density $this$calculateMouseWheelScroll_u2d8xgXZGE, PointerEvent event, long bounds) {
        List changes;
        Offset box-impl;
        Offset accumulator$iv;
        int index$iv$iv;
        Object obj3;
        Object obj;
        int i;
        Object obj2;
        long unbox-impl;
        int i2;
        List list;
        Offset offset;
        int i3 = 0;
        int i6 = 0;
        accumulator$iv = box-impl;
        List list2 = changes;
        final int i8 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list2.size()) {
            i = 0;
            i2 = 0;
            accumulator$iv = box-impl2;
            index$iv$iv++;
            changes = list;
            box-impl = offset;
        }
        List $this$fastFold$iv = changes;
        int i7 = 0;
        return Offset.times-tuRUvjQ(accumulator$iv.unbox-impl(), box-impl);
    }
}
