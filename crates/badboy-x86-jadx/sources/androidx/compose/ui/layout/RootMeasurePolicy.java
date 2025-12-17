package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode.NoIntrinsicsMeasurePolicy;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\r", d2 = {"Landroidx/compose/ui/layout/RootMeasurePolicy;", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {

    public static final int $stable;
    public static final androidx.compose.ui.layout.RootMeasurePolicy INSTANCE;
    static {
        RootMeasurePolicy rootMeasurePolicy = new RootMeasurePolicy();
        RootMeasurePolicy.INSTANCE = rootMeasurePolicy;
    }

    private RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    public androidx.compose.ui.layout.MeasureResult measure-3p2s80s(androidx.compose.ui.layout.MeasureScope $this$measure_u2d3p2s80s, List<? extends androidx.compose.ui.layout.Measurable> measurables, long constraints) {
        androidx.compose.ui.layout.MeasureResult placeable;
        androidx.compose.ui.layout.MeasureScope measureScope;
        int i4;
        int constrainWidth-K40F9xA;
        int i3;
        int constrainHeight-K40F9xA;
        int i5;
        kotlin.jvm.internal.Lambda lambda;
        int index$iv$iv;
        int index$iv;
        int i6;
        int i;
        Object obj;
        Object obj5;
        int maxWidth;
        int maxHeight;
        ArrayList height;
        androidx.compose.ui.layout.Placeable it;
        int i2;
        final long l = constraints;
        if (measurables.isEmpty()) {
            placeable = MeasureScope.layout$default($this$measure_u2d3p2s80s, Constraints.getMinWidth-impl(l), Constraints.getMinHeight-impl(l), 0, (Function1)RootMeasurePolicy.measure.1.INSTANCE, 4, 0);
            obj5 = measurables;
        } else {
            if (measurables.size() == 1) {
                androidx.compose.ui.layout.Placeable measure-BRTryo0 = (Measurable)measurables.get(0).measure-BRTryo0(l);
                RootMeasurePolicy.measure.2 anon = new RootMeasurePolicy.measure.2(measure-BRTryo0);
                placeable = MeasureScope.layout$default($this$measure_u2d3p2s80s, ConstraintsKt.constrainWidth-K40F9xA(l, obj1), ConstraintsKt.constrainHeight-K40F9xA(l, obj1), 0, (Function1)anon, 4, 0);
            } else {
                obj5 = measurables;
                Object obj3 = measurables;
                int i9 = 0;
                ArrayList arrayList = new ArrayList(obj3.size());
                Object obj4 = obj3;
                int i10 = 0;
                index$iv$iv = 0;
                while (index$iv$iv < obj4.size()) {
                    maxHeight = 0;
                    i2 = 0;
                    (Collection)arrayList.add((Measurable)obj4.get(index$iv$iv).measure-BRTryo0(l));
                    index$iv$iv++;
                }
                ArrayList $this$fastMap$iv = arrayList;
                ArrayList list = $this$fastMap$iv;
                int i11 = 0;
                index$iv = 0;
                maxWidth = i4;
                maxHeight = i3;
                while (index$iv < list.size()) {
                    i3 = i4;
                    obj = 0;
                    maxWidth = Math.max((Placeable)i3.getWidth(), maxWidth);
                    maxHeight = Math.max(i3.getHeight(), maxHeight);
                    index$iv++;
                }
                RootMeasurePolicy.measure.4 anon2 = new RootMeasurePolicy.measure.4((List)$this$fastMap$iv);
                placeable = constrainWidth-K40F9xA;
            }
        }
        return placeable;
    }
}
