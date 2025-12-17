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
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\r", d2 = {"Landroidx/compose/material3/CenteredContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CenteredContentMeasurePolicy implements MeasurePolicy {
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        int i13;
        int itemsPlaceables;
        ArrayList list2;
        int maxWidth-impl;
        int itemHeight;
        int i9;
        int i3;
        ArrayList arrayList;
        int target$iv;
        int index$iv;
        int i4;
        int size;
        ArrayList itemsCount;
        int i;
        int index$iv$iv;
        Object obj;
        Object obj3;
        int size2;
        Object obj2;
        Object maxIntrinsicHeight;
        int width;
        int width2;
        int i2;
        int itemsPlaceables2;
        int i14;
        int i5;
        int i11;
        int i10;
        ArrayList list3;
        int itemMaxWidth;
        int coerceAtMost;
        int i8;
        ArrayList list;
        int i12;
        int i6;
        int i7;
        final Object obj4 = constraints;
        maxWidth-impl = Constraints.getMaxWidth-impl(obj4);
        int i15 = 0;
        itemHeight = Constraints.getMinHeight-impl(obj4);
        size = measurables.size();
        if (size < 1) {
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, maxWidth-impl, itemHeight, 0, (Function1)CenteredContentMeasurePolicy.measure.1.INSTANCE, 4, 0);
        }
        Ref.IntRef intRef = new Ref.IntRef();
        final Ref.IntRef intRef2 = intRef;
        if (!Constraints.getHasBoundedWidth-impl(obj4)) {
            i9 = measurables;
            i3 = 0;
            arrayList = new ArrayList(i9.size());
            i4 = i9;
            i = 0;
            index$iv$iv = 0;
            while (index$iv$iv < i4.size()) {
                width = 0;
                i5 = 0;
                (Collection)arrayList.add((Measurable)i4.get(index$iv$iv).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(obj4, obj1)));
                index$iv$iv++;
                i13 = i2;
                i9 = i14;
                i3 = i11;
                arrayList = list3;
            }
            itemsPlaceables2 = i13;
            i14 = i9;
            i10 = i3;
            width2 = maxWidth-impl;
            i6 = size;
            itemsCount = list2;
        } else {
            itemsPlaceables2 = i13;
            itemsPlaceables = maxWidth-impl / size;
            intRef2.element = ExpressiveNavigationBarKt.access$calculateCenteredContentHorizontalPadding(size, maxWidth-impl);
            int i23 = measurables;
            int i25 = 0;
            index$iv = 0;
            while (index$iv < i23.size()) {
                obj2 = 0;
                maxIntrinsicHeight = (Measurable)i23.get(index$iv).maxIntrinsicHeight(i21 /= size);
                if (itemHeight < maxIntrinsicHeight) {
                } else {
                }
                width = maxWidth-impl;
                index$iv++;
                maxWidth-impl = width;
                width = maxWidth-impl;
                itemHeight = maxWidth-impl;
            }
            width2 = maxWidth-impl;
            maxWidth-impl = measurables;
            i3 = 0;
            arrayList = new ArrayList(maxWidth-impl.size());
            i = 0;
            index$iv$iv = 0;
            while (index$iv$iv < maxWidth-impl.size()) {
                i14 = 0;
                i11 = i9;
                Object itemMinWidth = maxIntrinsicHeight;
                list3 = 0;
                int maxIntrinsicWidth = (Measurable)itemMinWidth.maxIntrinsicWidth(Constraints.getMinHeight-impl(obj4));
                if (i11 < maxIntrinsicWidth) {
                }
                (Collection)arrayList.add(itemMinWidth.measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(obj4, obj1)));
                index$iv$iv++;
                maxWidth-impl = i5;
                i9 = i11;
                itemsPlaceables = itemMaxWidth;
                i3 = i8;
                arrayList = list;
                size = i12;
                i4 = i7;
                coerceAtMost = RangesKt.coerceAtMost(maxIntrinsicWidth, itemsPlaceables);
                intRef2.element = currentItemWidth -= i12;
                target$iv = coerceAtMost;
            }
            itemMaxWidth = itemsPlaceables;
            i5 = maxWidth-impl;
            i10 = i9;
            i8 = i3;
            i7 = i4;
            i6 = size;
            itemsCount = list2;
        }
        CenteredContentMeasurePolicy.measure.5 anon = new CenteredContentMeasurePolicy.measure.5(intRef2, itemsCount);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, width2, itemHeight, 0, (Function1)anon, 4, 0);
    }
}
