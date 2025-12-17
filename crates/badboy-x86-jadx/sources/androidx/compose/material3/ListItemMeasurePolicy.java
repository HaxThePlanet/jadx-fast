package androidx.compose.material3;

import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u00070\u00072\u0006\u0010\t\u001a\u00020\u00042,\u0010\n\u001a(\u0012\u0004\u0012\u00020\u0008\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\t\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\u0008\u000eH\u0002JV\u0010\u000f\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u00070\u00072\u0006\u0010\u0010\u001a\u00020\u00042,\u0010\n\u001a(\u0012\u0004\u0012\u00020\u0008\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\u0008\u000eH\u0002J(\u0010\u0011\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u00070\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016J(\u0010\u0012\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u00070\u00072\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J2\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u00070\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aJ(\u0010\u001b\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u00070\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016J(\u0010\u001c\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u00070\u00072\u0006\u0010\u0010\u001a\u00020\u0004H\u0016\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d", d2 = {"Landroidx/compose/material3/ListItemMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "()V", "calculateIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "intrinsicMeasure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "calculateIntrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ListItemMeasurePolicy implements MultiContentMeasurePolicy {
    private final int calculateIntrinsicHeight(IntrinsicMeasureScope $this$calculateIntrinsicHeight, List<? extends List<? extends IntrinsicMeasurable>> measurables, int width, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasure) {
        int i5;
        int i4;
        int firstOrNull;
        int firstOrNull2;
        int intValue2;
        int remainingWidth;
        int i7;
        int valueOf;
        int i3;
        Object valueOf2;
        int intValue;
        int i6;
        int intValue3;
        int i;
        int i2;
        final androidx.compose.ui.unit.Density density = $this$calculateIntrinsicHeight;
        final Object obj6 = measurables;
        final Object obj7 = intrinsicMeasure;
        i5 = 0;
        i4 = 1;
        int i14 = 0;
        int i18 = 0;
        int i16 = width;
        remainingWidth = ListItemKt.access$subtractConstraintSafely(i16, density.roundToPx-0680j_4(Dp.constructor-impl(listItemStartPadding + listItemEndPadding)));
        Object firstOrNull3 = CollectionsKt.firstOrNull((List)obj6.get(3));
        valueOf = Integer.MAX_VALUE;
        if ((IntrinsicMeasurable)firstOrNull3 != null) {
            i3 = 0;
            intValue = (Number)obj7.invoke((IntrinsicMeasurable)firstOrNull3, Integer.valueOf(remainingWidth)).intValue();
            remainingWidth = i6;
        } else {
            intValue = i5;
        }
        Object firstOrNull4 = CollectionsKt.firstOrNull((List)obj6.get(4));
        if ((IntrinsicMeasurable)firstOrNull4 != null) {
            i3 = 0;
            intValue3 = (Number)obj7.invoke((IntrinsicMeasurable)firstOrNull4, Integer.valueOf(remainingWidth)).intValue();
            i = remainingWidth;
        } else {
            intValue3 = i5;
            i = remainingWidth;
        }
        firstOrNull2 = CollectionsKt.firstOrNull((List)obj6.get(i4));
        if ((IntrinsicMeasurable)firstOrNull2 != null) {
            i7 = firstOrNull2;
        } else {
            i7 = i5;
        }
        Object firstOrNull5 = CollectionsKt.firstOrNull((List)obj6.get(2));
        if ((IntrinsicMeasurable)firstOrNull5 != null) {
            intValue2 = (Number)obj7.invoke((IntrinsicMeasurable)firstOrNull5, Integer.valueOf(i)).intValue();
        } else {
            intValue2 = i5;
        }
        boolean z = ListItemKt.access$isSupportingMultilineHeuristic((Density)density, intValue2);
        if (i7 > 0) {
            i5 = i4;
        }
        if (intValue2 > 0) {
        } else {
            i4 = 0;
        }
        int invoke-Z-LSjz4$material3_release = ListItemType.Companion.invoke-Z-LSjz4$material3_release(i5, i4, z);
        firstOrNull = CollectionsKt.firstOrNull((List)obj6.get(i5));
        if ((IntrinsicMeasurable)firstOrNull != null) {
            i2 = firstOrNull;
        } else {
            i2 = 0;
        }
        final int i20 = 0;
        boolean z2 = z;
        return ListItemKt.access$calculateHeight-N4Jib3Y(density, intValue, intValue3, i2, i7, intValue2, invoke-Z-LSjz4$material3_release, density.roundToPx-0680j_4(Dp.constructor-impl(listItemType *= f)), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, 0));
    }

    private final int calculateIntrinsicWidth(IntrinsicMeasureScope $this$calculateIntrinsicWidth, List<? extends List<? extends IntrinsicMeasurable>> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasure) {
        int intValue;
        int firstOrNull;
        int firstOrNull3;
        int firstOrNull4;
        Object firstOrNull2;
        Integer valueOf;
        int i3;
        int i;
        int i4;
        int i2;
        final Object obj = measurables;
        final Object obj2 = intrinsicMeasure;
        intValue = 0;
        firstOrNull = CollectionsKt.firstOrNull((List)obj.get(3));
        if ((IntrinsicMeasurable)firstOrNull != null) {
            i3 = firstOrNull;
        } else {
            i3 = intValue;
        }
        firstOrNull3 = CollectionsKt.firstOrNull((List)obj.get(4));
        if ((IntrinsicMeasurable)firstOrNull3 != null) {
            i = firstOrNull3;
        } else {
            i = intValue;
        }
        firstOrNull4 = CollectionsKt.firstOrNull((List)obj.get(intValue));
        if ((IntrinsicMeasurable)firstOrNull4 != null) {
            i4 = firstOrNull4;
        } else {
            i4 = intValue;
        }
        firstOrNull2 = CollectionsKt.firstOrNull((List)obj.get(1));
        if ((IntrinsicMeasurable)firstOrNull2 != null) {
            i2 = firstOrNull2;
        } else {
            i2 = intValue;
        }
        Object firstOrNull5 = CollectionsKt.firstOrNull((List)obj.get(2));
        if ((IntrinsicMeasurable)firstOrNull5 != null) {
            intValue = (Number)obj2.invoke((IntrinsicMeasurable)firstOrNull5, Integer.valueOf(height)).intValue();
        }
        int i10 = 0;
        Integer obj8 = $this$calculateIntrinsicWidth;
        final int i14 = 0;
        return ListItemKt.access$calculateWidth-yeHjK3Y(obj8, i3, i, i4, i2, intValue, obj8.roundToPx-0680j_4(Dp.constructor-impl(listItemStartPadding + listItemEndPadding)), ConstraintsKt.Constraints$default(0, i14, 0, 0, 15, 0));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends List<? extends IntrinsicMeasurable>> measurables, int width) {
        return calculateIntrinsicHeight($this$maxIntrinsicHeight, measurables, width, (Function2)ListItemMeasurePolicy.maxIntrinsicHeight.1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends List<? extends IntrinsicMeasurable>> measurables, int height) {
        return calculateIntrinsicWidth($this$maxIntrinsicWidth, measurables, height, (Function2)ListItemMeasurePolicy.maxIntrinsicWidth.1.INSTANCE);
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends List<? extends Measurable>> measurables, long constraints) {
        int measure-BRTryo0;
        int currentTotalWidth2;
        int i;
        int measure-BRTryo02;
        Placeable trailingPlaceable2;
        int i12;
        int currentTotalWidth;
        int i10;
        int i7;
        int i11;
        long copy-Zbe2FdA$default;
        int firstOrNull;
        int trailingPlaceable;
        Placeable supportingPlaceable;
        int i2;
        int minIntrinsicWidth2;
        int minIntrinsicWidth;
        int maxHeight-impl;
        int minIntrinsicHeight;
        long l;
        int i3;
        int i14;
        int i8;
        int i6;
        int i9;
        int i15;
        int i5;
        int measure-BRTryo03;
        long looseConstraints;
        Object obj;
        Placeable headlinePlaceable;
        int i13;
        Placeable placeable;
        int currentTotalWidth3;
        int i4;
        final MeasureScope measureScope = $this$measure_u2d3p2s80s;
        Object obj7 = measurables;
        int i16 = 0;
        Object obj8 = obj2;
        final Object obj9 = obj3;
        final Object obj10 = obj4;
        final Object obj11 = obj5;
        final Object obj12 = obj6;
        int i26 = 0;
        int i32 = 0;
        copy-Zbe2FdA$default = Constraints.copy-Zbe2FdA$default(constraints, obj5, 0, i32, 0, 0, 10);
        float listItemStartPadding = ListItemKt.getListItemStartPadding();
        float listItemEndPadding = ListItemKt.getListItemEndPadding();
        int i37 = 0;
        int roundToPx-0680j_42 = measureScope.roundToPx-0680j_4(Dp.constructor-impl(listItemStartPadding + listItemEndPadding));
        Object firstOrNull4 = CollectionsKt.firstOrNull(obj11);
        if ((Measurable)firstOrNull4 != null) {
            minIntrinsicWidth2 = (Measurable)firstOrNull4.minIntrinsicWidth(Constraints.getMaxHeight-impl(constraints));
        } else {
            minIntrinsicWidth2 = i16;
        }
        Object firstOrNull5 = CollectionsKt.firstOrNull(obj12);
        if ((Measurable)firstOrNull5 != null) {
            minIntrinsicWidth = (Measurable)firstOrNull5.minIntrinsicWidth(Constraints.getMaxHeight-impl(constraints));
        } else {
            minIntrinsicWidth = i16;
        }
        int i41 = ListItemKt.access$subtractConstraintSafely(Constraints.getMaxWidth-impl(copy-Zbe2FdA$default), i42 += roundToPx-0680j_42);
        Object firstOrNull6 = CollectionsKt.firstOrNull(obj10);
        if ((Measurable)firstOrNull6 != null) {
            minIntrinsicHeight = (Measurable)firstOrNull6.minIntrinsicHeight(i41);
        } else {
            minIntrinsicHeight = i16;
        }
        boolean z = ListItemKt.access$isSupportingMultilineHeuristic((Density)measureScope, minIntrinsicHeight);
        if (CollectionsKt.firstOrNull(obj9) != null) {
        } else {
            i = 0;
        }
        currentTotalWidth = CollectionsKt.firstOrNull(obj10) != null ? 1 : 0;
        int i27 = 0;
        int roundToPx-0680j_4 = measureScope.roundToPx-0680j_4(Dp.constructor-impl(arg0$iv *= f4));
        i10 = -roundToPx-0680j_4;
        long offset-NN6Ew-U = ConstraintsKt.offset-NN6Ew-U(copy-Zbe2FdA$default, i32, -roundToPx-0680j_42);
        final int i57 = roundToPx-0680j_4;
        Object intrinsicVerticalPadding = firstOrNull10;
        measure-BRTryo03 = 0;
        if ((Measurable)intrinsicVerticalPadding != null) {
            measure-BRTryo0 = (Measurable)intrinsicVerticalPadding.measure-BRTryo0(offset-NN6Ew-U);
        } else {
            measure-BRTryo0 = measure-BRTryo03;
        }
        final int i58 = measure-BRTryo0;
        int leadingPlaceable = i3 + widthOrZero4;
        long l2 = offset-NN6Ew-U;
        Object paddedLooseConstraints = firstOrNull9;
        if ((Measurable)paddedLooseConstraints != null) {
            looseConstraints = copy-Zbe2FdA$default;
            measure-BRTryo02 = (Measurable)paddedLooseConstraints.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(l2, obj22, -leadingPlaceable, 0, 2));
        } else {
            looseConstraints = copy-Zbe2FdA$default;
            measure-BRTryo02 = measure-BRTryo03;
        }
        leadingPlaceable += widthOrZero;
        int i28 = 0;
        Object firstOrNull2 = CollectionsKt.firstOrNull(obj8);
        if ((Measurable)firstOrNull2 != null) {
            i14 = i28;
            trailingPlaceable = measure-BRTryo02;
            obj = obj8;
            l = l2;
            trailingPlaceable2 = (Measurable)firstOrNull2.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(l2, obj22, -currentTotalWidth2, 0, 2));
        } else {
            trailingPlaceable = measure-BRTryo02;
            i14 = i28;
            obj = obj8;
            l = l2;
            trailingPlaceable2 = measure-BRTryo03;
        }
        heightOrZero2 += i14;
        firstOrNull = CollectionsKt.firstOrNull(obj10);
        if ((Measurable)firstOrNull != null) {
            headlinePlaceable = trailingPlaceable2;
            i13 = trailingPlaceable;
            i8 = i11;
            supportingPlaceable = trailingPlaceable2;
        } else {
            headlinePlaceable = trailingPlaceable2;
            i8 = i11;
            i13 = trailingPlaceable;
            supportingPlaceable = measure-BRTryo03;
        }
        heightOrZero += i8;
        if (supportingPlaceable != null && supportingPlaceable.get((AlignmentLine)AlignmentLineKt.getFirstBaseline()) != supportingPlaceable.get((AlignmentLine)AlignmentLineKt.getLastBaseline())) {
            i7 = supportingPlaceable.get((AlignmentLine)AlignmentLineKt.getFirstBaseline()) != supportingPlaceable.get((AlignmentLine)AlignmentLineKt.getLastBaseline()) ? 1 : 0;
        } else {
        }
        Object firstOrNull3 = CollectionsKt.firstOrNull(obj9);
        if ((Measurable)firstOrNull3 != null) {
            placeable = supportingPlaceable;
            currentTotalWidth3 = currentTotalWidth2;
            i4 = i22;
            measure-BRTryo03 = (Measurable)firstOrNull3.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(l, obj8, -currentTotalWidth2));
        } else {
            currentTotalWidth3 = currentTotalWidth2;
            i4 = i22;
            placeable = supportingPlaceable;
        }
        int i31 = measure-BRTryo03;
        i12 = i31 != 0 ? 1 : 0;
        i2 = placeable != null ? 1 : 0;
        int i18 = invoke-Z-LSjz4$material3_release2;
        float f2 = ListItemKt.access$verticalPadding-yh95HIg(i18);
        int i45 = 0;
        int i53 = i18;
        float constructor-impl2 = Dp.constructor-impl(listItemType *= f2);
        int i48 = roundToPx-0680j_42;
        final int i59 = i48;
        int i49 = i53;
        long l3 = l;
        float f6 = constructor-impl2;
        float f5 = f2;
        int i50 = i7;
        boolean z3 = z2;
        float f3 = listItemStartPadding;
        int intrinsicIsSupportingMultiline = i47;
        int intrinsicSupportingHeight = i46;
        float intrinsicSupportingWidthConstraint = listItemEndPadding;
        return ListItemKt.access$place(measureScope, ListItemKt.access$calculateWidth-yeHjK3Y((IntrinsicMeasureScope)measureScope, TextFieldImplKt.widthOrZero(i58), TextFieldImplKt.widthOrZero(i13), TextFieldImplKt.widthOrZero(headlinePlaceable), TextFieldImplKt.widthOrZero(i31), TextFieldImplKt.widthOrZero(placeable), i48, constraints), ListItemKt.access$calculateHeight-N4Jib3Y((IntrinsicMeasureScope)measureScope, TextFieldImplKt.heightOrZero(i58), TextFieldImplKt.heightOrZero(i13), TextFieldImplKt.heightOrZero(headlinePlaceable), TextFieldImplKt.heightOrZero(i31), TextFieldImplKt.heightOrZero(placeable), i49, measureScope.roundToPx-0680j_4(constructor-impl2), constraints), i58, i13, headlinePlaceable, i31, placeable, ListItemType.equals-impl0(i49, ListItemType.Companion.getThreeLine-AlXitO8()), measureScope.roundToPx-0680j_4(listItemStartPadding), measureScope.roundToPx-0680j_4(listItemEndPadding), measureScope.roundToPx-0680j_4(f2));
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends List<? extends IntrinsicMeasurable>> measurables, int width) {
        return calculateIntrinsicHeight($this$minIntrinsicHeight, measurables, width, (Function2)ListItemMeasurePolicy.minIntrinsicHeight.1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends List<? extends IntrinsicMeasurable>> measurables, int height) {
        return calculateIntrinsicWidth($this$minIntrinsicWidth, measurables, height, (Function2)ListItemMeasurePolicy.minIntrinsicWidth.1.INSTANCE);
    }
}
