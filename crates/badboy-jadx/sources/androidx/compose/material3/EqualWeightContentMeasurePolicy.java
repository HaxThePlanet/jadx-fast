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
        int i8;
        ArrayList $this$fastForEach$iv;
        ArrayList list3;
        int width;
        int itemHeight;
        int i5;
        int arrayList2;
        int index$iv;
        ArrayList arrayList;
        Object obj;
        int i2;
        Object obj3;
        int index$iv$iv2;
        ArrayList list;
        int index$iv$iv;
        int i3;
        int maxIntrinsicHeight;
        Object maxHeight-impl;
        Object obj2;
        int i9;
        int i6;
        int itemsPlaceables;
        int i10;
        int i11;
        int $this$fastMap$iv;
        int i4;
        int i;
        int i7;
        ArrayList list2;
        final Object obj4 = constraints;
        width = Constraints.getMaxWidth-impl(obj4);
        int i12 = 0;
        itemHeight = Constraints.getMinHeight-impl(obj4);
        final int size4 = measurables.size();
        if (size4 < 1) {
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, width, itemHeight, 0, (Function1)EqualWeightContentMeasurePolicy.measure.1.INSTANCE, 4, 0);
        }
        if (!Constraints.getHasBoundedWidth-impl(obj4)) {
            i5 = measurables;
            arrayList2 = 0;
            arrayList = new ArrayList(i5.size());
            i2 = i5;
            int i22 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < i2.size()) {
                i9 = 0;
                $this$fastMap$iv = 0;
                (Collection)arrayList.add((Measurable)i2.get(index$iv$iv).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(obj4, obj1)));
                index$iv$iv++;
                i8 = i6;
                width = i10;
                i5 = i4;
                arrayList2 = i;
            }
            itemsPlaceables = i8;
            i11 = width;
            i4 = i5;
            i7 = arrayList2;
            list = list3;
        } else {
            itemsPlaceables = i8;
            width = i11 / size4;
            ArrayList list4 = measurables;
            int i16 = 0;
            index$iv = 0;
            while (index$iv < list4.size()) {
                i3 = 0;
                maxIntrinsicHeight = (Measurable)list4.get(index$iv).maxIntrinsicHeight(width);
                if (itemHeight < maxIntrinsicHeight) {
                }
                index$iv++;
                itemHeight = RangesKt.coerceAtMost(maxIntrinsicHeight, Constraints.getMaxHeight-impl(obj4));
            }
            $this$fastForEach$iv = measurables;
            i5 = 0;
            arrayList2 = new ArrayList($this$fastForEach$iv.size());
            arrayList = $this$fastForEach$iv;
            i2 = 0;
            index$iv$iv2 = 0;
            while (index$iv$iv2 < arrayList.size()) {
                obj2 = 0;
                i4 = 0;
                (Collection)arrayList2.add((Measurable)arrayList.get(index$iv$iv2).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(obj4, obj1)));
                index$iv$iv2++;
                $this$fastForEach$iv = $this$fastMap$iv;
                i5 = i;
                arrayList2 = list2;
            }
            $this$fastMap$iv = $this$fastForEach$iv;
            i7 = i5;
            list = list3;
        }
        EqualWeightContentMeasurePolicy.measure.5 anon = new EqualWeightContentMeasurePolicy.measure.5(list);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, i11, itemHeight, 0, (Function1)anon, 4, 0);
    }
}
