package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0008\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00052\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J,\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"Landroidx/compose/foundation/layout/BoxMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "alignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "(Landroidx/compose/ui/Alignment;Z)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BoxMeasurePolicy implements MeasurePolicy {

    private final Alignment alignment;
    private final boolean propagateMinConstraints;
    public BoxMeasurePolicy(Alignment alignment, boolean propagateMinConstraints) {
        super();
        this.alignment = alignment;
        this.propagateMinConstraints = propagateMinConstraints;
    }

    public static final Alignment access$getAlignment$p(androidx.compose.foundation.layout.BoxMeasurePolicy $this) {
        return $this.alignment;
    }

    private final Alignment component1() {
        return this.alignment;
    }

    private final boolean component2() {
        return this.propagateMinConstraints;
    }

    public static androidx.compose.foundation.layout.BoxMeasurePolicy copy$default(androidx.compose.foundation.layout.BoxMeasurePolicy boxMeasurePolicy, Alignment alignment2, boolean z3, int i4, Object object5) {
        Alignment obj1;
        boolean obj2;
        if (i4 & 1 != 0) {
            obj1 = boxMeasurePolicy.alignment;
        }
        if (i4 &= 2 != 0) {
            obj2 = boxMeasurePolicy.propagateMinConstraints;
        }
        return boxMeasurePolicy.copy(obj1, obj2);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final androidx.compose.foundation.layout.BoxMeasurePolicy copy(Alignment alignment, boolean z2) {
        BoxMeasurePolicy boxMeasurePolicy = new BoxMeasurePolicy(alignment, z2);
        return boxMeasurePolicy;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof BoxMeasurePolicy) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.alignment, obj.alignment)) {
            return i2;
        }
        if (this.propagateMinConstraints != obj.propagateMinConstraints) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int hashCode() {
        return i2 += i4;
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        long copy-Zbe2FdA$default;
        long i2;
        int i7;
        int element2;
        int boxWidth;
        int element;
        int boxHeight;
        int hasMatchParentSizeChildren;
        Placeable placeable;
        int i5;
        long minHeight-impl2;
        int i6;
        int index$iv2;
        long l;
        int minHeight-impl;
        int index$iv;
        int i8;
        int size;
        int i9;
        int i4;
        int i;
        int i3;
        boolean measure-BRTryo0;
        if (measurables.isEmpty()) {
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, Constraints.getMinWidth-impl(constraints), Constraints.getMinHeight-impl(constraints), 0, (Function1)BoxMeasurePolicy.measure.1.INSTANCE, 4, 0);
        }
        Object obj3 = this;
        if (obj3.propagateMinConstraints) {
            copy-Zbe2FdA$default = constraints;
        } else {
            copy-Zbe2FdA$default = Constraints.copy-Zbe2FdA$default(constraints, obj9, 0, 0, 0, 0, 10);
        }
        long l2 = copy-Zbe2FdA$default;
        if (measurables.size() == 1) {
            Object obj2 = obj;
            int i12 = 0;
            int i15 = 0;
            int i19 = 0;
            if (!BoxKt.access$getMatchesParentSize((Measurable)obj2)) {
                placeable = obj2.measure-BRTryo0(l2);
                i6 = boxHeight3;
                boxHeight = boxWidth;
            } else {
                int minWidth-impl4 = Constraints.getMinWidth-impl(constraints);
                placeable = obj2.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(minWidth-impl4, Constraints.getMinHeight-impl(constraints)));
                i6 = boxHeight2;
                boxHeight = boxWidth;
            }
            int i23 = boxHeight;
            Placeable boxWidth3 = placeable;
            BoxMeasurePolicy.measure.2 boxWidth2 = new BoxMeasurePolicy.measure.2(boxWidth3, obj2, $this$measure_u2d3p2s80s, i23, i6, obj3);
            Placeable placeable4 = boxWidth3;
            Object obj4 = obj2;
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, i23, i6, 0, (Function1)boxWidth2, 4, 0);
        }
        Placeable[] arr = new Placeable[measurables.size()];
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = Constraints.getMinWidth-impl(constraints);
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = Constraints.getMinHeight-impl(constraints);
        i5 = measurables;
        index$iv2 = 0;
        index$iv = i17;
        hasMatchParentSizeChildren = i31;
        while (hasMatchParentSizeChildren < i5.size()) {
            i4 = i9;
            i3 = 0;
            if (!BoxKt.access$getMatchesParentSize((Measurable)i4)) {
            } else {
            }
            index$iv = i7;
            hasMatchParentSizeChildren++;
            i2 = measurables;
            element = 0;
            measure-BRTryo0 = i4.measure-BRTryo0(l2);
            arr[hasMatchParentSizeChildren] = measure-BRTryo0;
            intRef.element = Math.max(intRef.element, measure-BRTryo0.getWidth());
            intRef2.element = Math.max(intRef2.element, measure-BRTryo0.getHeight());
        }
        if (index$iv != 0) {
            int i13 = Integer.MAX_VALUE;
            element2 = intRef.element != i13 ? intRef.element : 0;
            element = intRef2.element != i13 ? intRef2.element : 0;
            hasMatchParentSizeChildren = measurables;
            i5 = 0;
            index$iv2 = 0;
            while (index$iv2 < hasMatchParentSizeChildren.size()) {
                i4 = i9;
                i3 = 0;
                if (BoxKt.access$getMatchesParentSize((Measurable)i4)) {
                }
                index$iv2++;
                arr[index$iv2] = i4.measure-BRTryo0(ConstraintsKt.Constraints(element2, intRef.element, element, intRef2.element));
            }
        }
        BoxMeasurePolicy.measure.5 anon = new BoxMeasurePolicy.measure.5(arr, measurables, $this$measure_u2d3p2s80s, intRef, intRef2, this);
        Placeable[] objArr = arr;
        Ref.IntRef intRef3 = intRef;
        Ref.IntRef intRef4 = intRef2;
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, intRef.element, intRef2.element, 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BoxMeasurePolicy(alignment=").append(this.alignment).append(", propagateMinConstraints=").append(this.propagateMinConstraints).append(')').toString();
    }
}
