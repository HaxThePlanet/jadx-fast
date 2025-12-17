package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\r", d2 = {"Landroidx/compose/material3/EqualWeightContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class EqualWeightContentMeasurePolicy implements MeasurePolicy {
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        int i3;
        ArrayList $this$fastForEach$iv;
        ArrayList list2;
        int width;
        int itemHeight;
        int i8;
        int arrayList2;
        int index$iv;
        ArrayList arrayList;
        Object obj2;
        int i6;
        Object obj;
        int index$iv$iv;
        ArrayList list3;
        int index$iv$iv2;
        int i4;
        int maxIntrinsicHeight;
        Object maxHeight-impl;
        Object obj3;
        int i;
        int i5;
        int itemsPlaceables;
        int i11;
        int i10;
        int $this$fastMap$iv;
        int i2;
        int i9;
        int i7;
        ArrayList list;
        final Object obj4 = constraints;
        width = Constraints.getMaxWidth-impl(obj4);
        int i12 = 0;
        itemHeight = Constraints.getMinHeight-impl(obj4);
        final int size4 = measurables.size();
        if (size4 < 1) {
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, width, itemHeight, 0, (Function1)EqualWeightContentMeasurePolicy.measure.1.INSTANCE, 4, 0);
        }
        if (!Constraints.getHasBoundedWidth-impl(obj4)) {
            i8 = measurables;
            arrayList2 = 0;
            arrayList = new ArrayList(i8.size());
            i6 = i8;
            int i22 = 0;
            index$iv$iv2 = 0;
            while (index$iv$iv2 < i6.size()) {
                i = 0;
                $this$fastMap$iv = 0;
                (Collection)arrayList.add((Measurable)i6.get(index$iv$iv2).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(obj4, obj1)));
                index$iv$iv2++;
                i3 = i5;
                width = i11;
                i8 = i2;
                arrayList2 = i9;
            }
            itemsPlaceables = i3;
            i10 = width;
            i2 = i8;
            i7 = arrayList2;
            list3 = list2;
        } else {
            itemsPlaceables = i3;
            width = i10 / size4;
            ArrayList list4 = measurables;
            int i16 = 0;
            index$iv = 0;
            while (index$iv < list4.size()) {
                i4 = 0;
                maxIntrinsicHeight = (Measurable)list4.get(index$iv).maxIntrinsicHeight(width);
                if (itemHeight < maxIntrinsicHeight) {
                }
                index$iv++;
                itemHeight = RangesKt.coerceAtMost(maxIntrinsicHeight, Constraints.getMaxHeight-impl(obj4));
            }
            $this$fastForEach$iv = measurables;
            i8 = 0;
            arrayList2 = new ArrayList($this$fastForEach$iv.size());
            arrayList = $this$fastForEach$iv;
            i6 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < arrayList.size()) {
                obj3 = 0;
                i2 = 0;
                (Collection)arrayList2.add((Measurable)arrayList.get(index$iv$iv).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(obj4, obj1)));
                index$iv$iv++;
                $this$fastForEach$iv = $this$fastMap$iv;
                i8 = i9;
                arrayList2 = list;
            }
            $this$fastMap$iv = $this$fastForEach$iv;
            i7 = i8;
            list3 = list2;
        }
        EqualWeightContentMeasurePolicy.measure.5 anon = new EqualWeightContentMeasurePolicy.measure.5(list3);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, i10, itemHeight, 0, (Function1)anon, 4, 0);
    }
}
