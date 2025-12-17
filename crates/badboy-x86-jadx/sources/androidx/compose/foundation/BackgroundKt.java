package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0003\u0010\u0006\u001a\u00020\u0007H\u0007\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000c", d2 = {"background", "Landroidx/compose/ui/Modifier;", "brush", "Landroidx/compose/ui/graphics/Brush;", "shape", "Landroidx/compose/ui/graphics/Shape;", "alpha", "", "color", "Landroidx/compose/ui/graphics/Color;", "background-bw27NRU", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BackgroundKt {
    public static final Modifier background(Modifier $this$background, Brush brush, Shape shape, float alpha) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new BackgroundKt.background$$inlined.debugInspectorInfo.1(alpha, brush, shape);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        BackgroundElement backgroundElement = new BackgroundElement(0, noInspectorInfo, brush, alpha, shape, noInspectorInfo, 1, 0);
        return $this$background.then((Modifier)backgroundElement);
    }

    public static Modifier background$default(Modifier modifier, Brush brush2, Shape shape3, float f4, int i5, Object object6) {
        Shape obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = RectangleShapeKt.getRectangleShape();
        }
        if (i5 &= 4 != 0) {
            obj3 = 1065353216;
        }
        return BackgroundKt.background(modifier, brush2, obj2, obj3);
    }

    public static final Modifier background-bw27NRU(Modifier $this$background_u2dbw27NRU, long color, Shape shape) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new BackgroundKt.background-bw27NRU$$inlined.debugInspectorInfo.1(color, shape, obj12);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        BackgroundElement backgroundElement = new BackgroundElement(color, obj2, 0, 1065353216, obj12, noInspectorInfo, 2, 0);
        return $this$background_u2dbw27NRU.then((Modifier)backgroundElement);
    }

    public static Modifier background-bw27NRU$default(Modifier modifier, long l2, Shape shape3, int i4, Object object5) {
        Shape obj3;
        if (object5 &= 2 != 0) {
            obj3 = RectangleShapeKt.getRectangleShape();
        }
        return BackgroundKt.background-bw27NRU(modifier, l2, shape3);
    }
}
