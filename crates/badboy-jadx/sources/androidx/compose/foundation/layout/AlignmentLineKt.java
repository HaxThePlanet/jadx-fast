package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnit.Companion;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u001a>\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0008\u001a\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0008\u001a\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018\u001a*\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\u0008\u0008\u0002\u0010\u001a\u001a\u00020\n2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a*\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001f\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006 ", d2 = {"horizontal", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "alignmentLineOffsetMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "alignmentLine", "before", "Landroidx/compose/ui/unit/Dp;", "after", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "paddingFrom", "Landroidx/compose/ui/Modifier;", "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/TextUnit;", "paddingFrom-Y_r0B1c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;JJ)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline-wCyjxdI", "(Landroidx/compose/ui/Modifier;JJ)Landroidx/compose/ui/Modifier;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AlignmentLineKt {
    public static final MeasureResult access$alignmentLineOffsetMeasure-tjqqzMA(MeasureScope $receiver, AlignmentLine alignmentLine, float before, float after, Measurable measurable, long constraints) {
        return AlignmentLineKt.alignmentLineOffsetMeasure-tjqqzMA($receiver, alignmentLine, before, after, measurable, constraints);
    }

    public static final boolean access$getHorizontal(AlignmentLine $receiver) {
        return AlignmentLineKt.getHorizontal($receiver);
    }

    private static final MeasureResult alignmentLineOffsetMeasure-tjqqzMA(MeasureScope $this$alignmentLineOffsetMeasure_u2dtjqqzMA, AlignmentLine alignmentLine, float before, float after, Measurable measurable, long constraints) {
        long copy-Zbe2FdA$default;
        int it;
        int height;
        int maxHeight-impl;
        int roundToPx-0680j_42;
        int roundToPx-0680j_4;
        int width;
        int minWidth-impl;
        int height2;
        int i5;
        Object obj;
        int i7;
        int i3;
        int i2;
        int i4;
        int i6;
        int i;
        final MeasureScope measureScope = $this$alignmentLineOffsetMeasure_u2dtjqqzMA;
        float f = before;
        final float f2 = after;
        if (AlignmentLineKt.getHorizontal(alignmentLine)) {
            copy-Zbe2FdA$default = Constraints.copy-Zbe2FdA$default(constraints, obj11, 0, 0, 0, 0, 11);
        } else {
            copy-Zbe2FdA$default = Constraints.copy-Zbe2FdA$default(constraints, obj11, 0, 0, 0, 0, 14);
        }
        final Placeable measure-BRTryo0 = measurable.measure-BRTryo0(copy-Zbe2FdA$default);
        AlignmentLine alignmentLine2 = alignmentLine;
        int i16 = 0;
        int i24 = 0;
        if (measure-BRTryo0.get(alignmentLine2) != Integer.MIN_VALUE) {
        } else {
            it = i24;
        }
        final int i26 = it;
        if (AlignmentLineKt.getHorizontal(alignmentLine2)) {
            height = measure-BRTryo0.getHeight();
        } else {
            height = measure-BRTryo0.getWidth();
        }
        int i27 = height;
        if (AlignmentLineKt.getHorizontal(alignmentLine2)) {
            maxHeight-impl = Constraints.getMaxHeight-impl(constraints);
        } else {
            maxHeight-impl = Constraints.getMaxWidth-impl(constraints);
        }
        int i28 = maxHeight-impl;
        if (!Dp.equals-impl0(f, Dp.Companion.getUnspecified-D9Ej5fM())) {
            roundToPx-0680j_42 = measureScope.roundToPx-0680j_4(f);
        } else {
            roundToPx-0680j_42 = i24;
        }
        int coerceIn = RangesKt.coerceIn(roundToPx-0680j_42 -= i26, i24, i28 - i27);
        if (!Dp.equals-impl0(f2, Dp.Companion.getUnspecified-D9Ej5fM())) {
            roundToPx-0680j_4 = measureScope.roundToPx-0680j_4(f2);
        } else {
            roundToPx-0680j_4 = i24;
        }
        int coerceIn2 = RangesKt.coerceIn(i9 += i26, i24, i19 -= coerceIn);
        if (AlignmentLineKt.getHorizontal(alignmentLine2)) {
            width = measure-BRTryo0.getWidth();
        } else {
            width = Math.max(i11 += coerceIn2, Constraints.getMinWidth-impl(constraints));
        }
        if (AlignmentLineKt.getHorizontal(alignmentLine2)) {
            i5 = height2;
        } else {
            i5 = height2;
        }
        int i22 = width;
        AlignmentLineKt.alignmentLineOffsetMeasure.1 width3 = new AlignmentLineKt.alignmentLineOffsetMeasure.1(alignmentLine2, f, coerceIn, i22, coerceIn2, measure-BRTryo0, i5);
        int i29 = coerceIn2;
        int height4 = coerceIn;
        int i13 = i22;
        int i23 = i13;
        return MeasureScope.layout$default(measureScope, i13, i5, 0, (Function1)width3, 4, 0);
    }

    private static final boolean getHorizontal(AlignmentLine $this$horizontal) {
        return $this$horizontal instanceof HorizontalAlignmentLine;
    }

    public static final Modifier paddingFrom-4j6BHR0(Modifier $this$paddingFrom_u2d4j6BHR0, AlignmentLine alignmentLine, float before, float after) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new AlignmentLineKt.paddingFrom-4j6BHR0$$inlined.debugInspectorInfo.1(alignmentLine, before, after);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        AlignmentLineOffsetDpElement alignmentLineOffsetDpElement = new AlignmentLineOffsetDpElement(alignmentLine, before, after, noInspectorInfo, 0);
        return $this$paddingFrom_u2d4j6BHR0.then((Modifier)alignmentLineOffsetDpElement);
    }

    public static Modifier paddingFrom-4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine2, float f3, float f4, int i5, Object object6) {
        float obj2;
        float obj3;
        if (i5 & 2 != 0) {
            obj2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i5 &= 4 != 0) {
            obj3 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return AlignmentLineKt.paddingFrom-4j6BHR0(modifier, alignmentLine2, obj2, obj3);
    }

    public static final Modifier paddingFrom-Y_r0B1c(Modifier $this$paddingFrom_u2dY_r0B1c, AlignmentLine alignmentLine, long before, long after) {
        long l;
        androidx.compose.foundation.layout.AlignmentLineKt.paddingFrom-Y_r0B1c$$inlined.debugInspectorInfo.1 anon;
        AlignmentLine alignmentLine2;
        long l2;
        kotlin.jvm.functions.Function1 function1;
        kotlin.jvm.functions.Function1 obj10;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            l2 = before;
            anon = new AlignmentLineKt.paddingFrom-Y_r0B1c$$inlined.debugInspectorInfo.1(alignmentLine, l2, obj6, obj13, obj8);
            obj10 = anon;
            l = l2;
        } else {
            alignmentLine2 = alignmentLine;
            l = before;
            function1 = obj13;
            obj10 = InspectableValueKt.getNoInspectorInfo();
        }
        AlignmentLineOffsetTextUnitElement alignmentLineOffsetTextUnitElement = new AlignmentLineOffsetTextUnitElement(alignmentLine2, l, anon, function1, l2, obj10, 0);
        return $this$paddingFrom_u2dY_r0B1c.then((Modifier)alignmentLineOffsetTextUnitElement);
    }

    public static Modifier paddingFrom-Y_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine2, long l3, long l4, int i5, Object object6) {
        long l2;
        long l;
        long obj8;
        long obj10;
        if (obj12 & 2 != 0) {
            l2 = obj8;
        } else {
            l2 = l3;
        }
        if (obj12 & 4 != 0) {
            l = obj10;
        } else {
            l = i5;
        }
        return AlignmentLineKt.paddingFrom-Y_r0B1c(modifier, alignmentLine2, l2, obj3);
    }

    public static final Modifier paddingFromBaseline-VpY3zN4(Modifier $this$paddingFromBaseline_u2dVpY3zN4, float top, float bottom) {
        androidx.compose.ui.layout.HorizontalAlignmentLine firstBaseline;
        boolean lastBaseline;
        androidx.compose.ui.Modifier.Companion companion;
        androidx.compose.ui.layout.HorizontalAlignmentLine horizontalAlignmentLine;
        float top2;
        int i4;
        int i5;
        int i;
        float bottom2;
        int i3;
        int i2;
        Modifier obj11;
        Modifier obj12;
        if (!Dp.equals-impl0(top, Dp.Companion.getUnspecified-D9Ej5fM())) {
            obj11 = AlignmentLineKt.paddingFrom-4j6BHR0$default((Modifier)Modifier.Companion, (AlignmentLine)AlignmentLineKt.getFirstBaseline(), top, 0, 4, 0);
        } else {
            top2 = top;
            obj11 = Modifier.Companion;
        }
        if (!Dp.equals-impl0(bottom, Dp.Companion.getUnspecified-D9Ej5fM())) {
            obj12 = AlignmentLineKt.paddingFrom-4j6BHR0$default((Modifier)Modifier.Companion, (AlignmentLine)AlignmentLineKt.getLastBaseline(), 0, bottom, 2, 0);
        } else {
            bottom2 = bottom;
            obj12 = Modifier.Companion;
        }
        return $this$paddingFromBaseline_u2dVpY3zN4.then(obj11).then(obj12);
    }

    public static Modifier paddingFromBaseline-VpY3zN4$default(Modifier modifier, float f2, float f3, int i4, Object object5) {
        float obj1;
        float obj2;
        if (i4 & 1 != 0) {
            obj1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i4 &= 2 != 0) {
            obj2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        return AlignmentLineKt.paddingFromBaseline-VpY3zN4(modifier, obj1, obj2);
    }

    public static final Modifier paddingFromBaseline-wCyjxdI(Modifier $this$paddingFromBaseline_u2dwCyjxdI, long top, long bottom) {
        Modifier paddingFrom-Y_r0B1c$default;
        androidx.compose.ui.Modifier.Companion companion;
        Modifier paddingFrom-Y_r0B1c$default2;
        androidx.compose.ui.layout.HorizontalAlignmentLine horizontalAlignmentLine;
        AlignmentLine alignmentLine;
        long l;
        int i;
        int i2;
        int i4;
        int i3;
        int i5;
        if (!TextUnitKt.isUnspecified--R2X_6o(top)) {
            paddingFrom-Y_r0B1c$default = AlignmentLineKt.paddingFrom-Y_r0B1c$default((Modifier)Modifier.Companion, (AlignmentLine)AlignmentLineKt.getFirstBaseline(), top, obj4, 0, obj6);
        } else {
            paddingFrom-Y_r0B1c$default = Modifier.Companion;
        }
        if (!TextUnitKt.isUnspecified--R2X_6o(obj13)) {
            paddingFrom-Y_r0B1c$default2 = AlignmentLineKt.paddingFrom-Y_r0B1c$default((Modifier)Modifier.Companion, (AlignmentLine)AlignmentLineKt.getLastBaseline(), 0, i, obj13, i4);
        } else {
            paddingFrom-Y_r0B1c$default2 = Modifier.Companion;
        }
        return $this$paddingFromBaseline_u2dwCyjxdI.then(paddingFrom-Y_r0B1c$default).then(paddingFrom-Y_r0B1c$default2);
    }

    public static Modifier paddingFromBaseline-wCyjxdI$default(Modifier modifier, long l2, long l3, int i4, Object object5) {
        long obj1;
        long obj3;
        if (obj5 & 1 != 0) {
            obj1 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }
        if (obj5 &= 2 != 0) {
            obj3 = TextUnit.Companion.getUnspecified-XSAIIZE();
        }
        return AlignmentLineKt.paddingFromBaseline-wCyjxdI(modifier, obj1, l3);
    }
}
