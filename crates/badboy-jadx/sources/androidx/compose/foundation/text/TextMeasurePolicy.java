package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B+\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003¢\u0006\u0002\u0010\u0008J,\u0010\t\u001a\u00020\n*\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/text/TextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "placements", "", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TextMeasurePolicy implements MeasurePolicy {

    private final Function0<List<Rect>> placements;
    private final Function0<Boolean> shouldMeasureLinks;
    public TextMeasurePolicy(Function0<Boolean> shouldMeasureLinks, Function0<? extends List<Rect>> placements) {
        super();
        this.shouldMeasureLinks = shouldMeasureLinks;
        this.placements = placements;
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        ArrayList $this$fastFilter$iv;
        Object box-impl;
        ArrayList arrayList2;
        ArrayList list;
        int i9;
        ArrayList arrayList;
        int index$iv$iv;
        int size2;
        int index$iv$iv2;
        int index$iv$iv3;
        int size;
        int i4;
        Object obj2;
        int it;
        boolean z;
        Object parentData;
        int i6;
        int i7;
        Object obj3;
        int i5;
        Object obj;
        ArrayList inlineContentMeasurables;
        ArrayList inlineContentMeasurables2;
        int i;
        ArrayList list2;
        int i3;
        int i8;
        int i10;
        int i12;
        int i11;
        int i2;
        final Object obj4 = this;
        int i13 = measurables;
        int i15 = 0;
        arrayList2 = new ArrayList(i13.size());
        i9 = i13;
        arrayList = 0;
        index$iv$iv = 0;
        while (index$iv$iv < i9.size()) {
            size = index$iv$iv3;
            i4 = 0;
            it = 0;
            if (!parentData2 instanceof TextRangeLayoutModifier) {
            }
            index$iv$iv++;
            (Collection)arrayList2.add(size);
        }
        box-impl = obj4.placements.invoke();
        if ((List)box-impl != null) {
            i9 = 0;
            arrayList = new ArrayList((List)box-impl.size());
            index$iv$iv = box-impl;
            size2 = 0;
            index$iv$iv3 = 0;
            while (index$iv$iv3 < index$iv$iv.size()) {
                z = 0;
                parentData = it;
                i7 = 0;
                if ((Rect)parentData != null) {
                } else {
                }
                inlineContentMeasurables = $this$fastFilter$iv;
                obj = box-impl;
                i = i9;
                list2 = arrayList;
                arrayList2 = 0;
                if (arrayList2 != null) {
                }
                index$iv$iv3++;
                box-impl = obj;
                $this$fastFilter$iv = inlineContentMeasurables;
                i9 = i;
                arrayList = list2;
                $this$fastFilter$iv = 0;
                (Collection)list2.add(arrayList2);
                obj3 = parentData;
                i5 = 0;
                inlineContentMeasurables = $this$fastFilter$iv;
                obj = box-impl;
                i = i9;
                list2 = arrayList;
                int i19 = 0;
                arrayList2 = new Pair((Measurable)$this$fastFilter$iv.get(index$iv$iv3).measure-BRTryo0(ConstraintsKt.Constraints$default(0, (int)f, 0, (int)f2, 5, 0)), IntOffset.box-impl(IntOffsetKt.IntOffset(Math.round(obj3.getLeft()), Math.round(obj3.getTop()))));
            }
            inlineContentMeasurables2 = $this$fastFilter$iv;
            obj = box-impl;
            i = i9;
            list = list2;
        } else {
            inlineContentMeasurables2 = $this$fastFilter$iv;
            list = 0;
        }
        int i14 = measurables;
        int i17 = 0;
        ArrayList arrayList3 = new ArrayList(i14.size());
        int i20 = i14;
        int i21 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < i20.size()) {
            i4 = size;
            obj2 = 0;
            z = 0;
            if (parentData instanceof TextRangeLayoutModifier) {
            }
            index$iv$iv2++;
            (Collection)arrayList3.add(i4);
        }
        TextMeasurePolicy.measure.1 anon = new TextMeasurePolicy.measure.1(list, BasicTextKt.access$measureWithTextRangeMeasureConstraints((List)arrayList3, obj4.shouldMeasureLinks));
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, Constraints.getMaxWidth-impl(constraints), Constraints.getMaxHeight-impl(constraints), 0, (Function1)anon, 4, 0);
    }
}
