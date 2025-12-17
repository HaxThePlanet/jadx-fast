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
        int i;
        int itemsPlaceables;
        ArrayList list2;
        int maxWidth-impl;
        int itemHeight;
        int i5;
        int i13;
        ArrayList arrayList;
        int target$iv;
        int index$iv;
        int i11;
        int size;
        ArrayList itemsCount;
        int i7;
        int index$iv$iv;
        Object obj;
        Object obj2;
        int size2;
        Object obj3;
        Object maxIntrinsicHeight;
        int width2;
        int width;
        int i2;
        int itemsPlaceables2;
        int i3;
        int i4;
        int i6;
        int i14;
        ArrayList list;
        int itemMaxWidth;
        int coerceAtMost;
        int i9;
        ArrayList list3;
        int i12;
        int i10;
        int i8;
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
            i5 = measurables;
            i13 = 0;
            arrayList = new ArrayList(i5.size());
            i11 = i5;
            i7 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < i11.size()) {
                width2 = 0;
                i4 = 0;
                (Collection)arrayList.add((Measurable)i11.get(index$iv$iv).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(obj4, obj1)));
                index$iv$iv++;
                i = i2;
                i5 = i3;
                i13 = i6;
                arrayList = list;
            }
            itemsPlaceables2 = i;
            i3 = i5;
            i14 = i13;
            width = maxWidth-impl;
            i10 = size;
            itemsCount = list2;
        } else {
            itemsPlaceables2 = i;
            itemsPlaceables = maxWidth-impl / size;
            intRef2.element = ExpressiveNavigationBarKt.access$calculateCenteredContentHorizontalPadding(size, maxWidth-impl);
            int i23 = measurables;
            int i25 = 0;
            index$iv = 0;
            while (index$iv < i23.size()) {
                obj3 = 0;
                maxIntrinsicHeight = (Measurable)i23.get(index$iv).maxIntrinsicHeight(i21 /= size);
                if (itemHeight < maxIntrinsicHeight) {
                } else {
                }
                width2 = maxWidth-impl;
                index$iv++;
                maxWidth-impl = width2;
                width2 = maxWidth-impl;
                itemHeight = maxWidth-impl;
            }
            width = maxWidth-impl;
            maxWidth-impl = measurables;
            i13 = 0;
            arrayList = new ArrayList(maxWidth-impl.size());
            i7 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < maxWidth-impl.size()) {
                i3 = 0;
                i6 = i5;
                Object itemMinWidth = maxIntrinsicHeight;
                list = 0;
                int maxIntrinsicWidth = (Measurable)itemMinWidth.maxIntrinsicWidth(Constraints.getMinHeight-impl(obj4));
                if (i6 < maxIntrinsicWidth) {
                }
                (Collection)arrayList.add(itemMinWidth.measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(obj4, obj1)));
                index$iv$iv++;
                maxWidth-impl = i4;
                i5 = i6;
                itemsPlaceables = itemMaxWidth;
                i13 = i9;
                arrayList = list3;
                size = i12;
                i11 = i8;
                coerceAtMost = RangesKt.coerceAtMost(maxIntrinsicWidth, itemsPlaceables);
                intRef2.element = currentItemWidth -= i12;
                target$iv = coerceAtMost;
            }
            itemMaxWidth = itemsPlaceables;
            i4 = maxWidth-impl;
            i14 = i5;
            i9 = i13;
            i8 = i11;
            i10 = size;
            itemsCount = list2;
        }
        CenteredContentMeasurePolicy.measure.5 anon = new CenteredContentMeasurePolicy.measure.5(intRef2, itemsCount);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, width, itemHeight, 0, (Function1)anon, 4, 0);
    }
}
