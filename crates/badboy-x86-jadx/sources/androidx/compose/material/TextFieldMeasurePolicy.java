package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J8\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u000e\u001a\u00020\nH\u0016J,\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u000c2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006 ", d2 = {"Landroidx/compose/material/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TextFieldMeasurePolicy implements MeasurePolicy {

    private final float animationProgress;
    private final PaddingValues paddingValues;
    private final boolean singleLine;
    public TextFieldMeasurePolicy(boolean singleLine, float animationProgress, PaddingValues paddingValues) {
        super();
        this.singleLine = singleLine;
        this.animationProgress = animationProgress;
        this.paddingValues = paddingValues;
    }

    public static final float access$getAnimationProgress$p(androidx.compose.material.TextFieldMeasurePolicy $this) {
        return $this.animationProgress;
    }

    public static final PaddingValues access$getPaddingValues$p(androidx.compose.material.TextFieldMeasurePolicy $this) {
        return $this.paddingValues;
    }

    public static final boolean access$getSingleLine$p(androidx.compose.material.TextFieldMeasurePolicy $this) {
        return $this.singleLine;
    }

    private final int intrinsicHeight(IntrinsicMeasureScope $this$intrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        int remainingWidth2;
        int obj3;
        int intValue2;
        int intValue3;
        Object invoke2;
        int $i$f$fastFirstOrNull;
        int equal;
        int i7;
        int intValue;
        int invoke;
        int index$iv$iv2;
        int index$iv$iv;
        int index$iv$iv3;
        int index$iv$iv5;
        int size;
        String str;
        Object obj2;
        int index$iv$iv4;
        Object obj;
        int size2;
        int i3;
        int i2;
        int i4;
        boolean it2;
        int i5;
        int it;
        Object layoutId2;
        int i6;
        String layoutId;
        int $this$fastFirstOrNull$iv;
        int remainingWidth;
        int i;
        final Object obj4 = intrinsicMeasurer;
        int i8 = 0;
        equal = 0;
        Object obj9 = obj7;
        invoke = 0;
        index$iv$iv3 = 0;
        while (index$iv$iv3 < obj9.size()) {
            i2 = 0;
            i5 = 0;
            index$iv$iv3++;
        }
        obj = 0;
        intValue3 = Integer.MAX_VALUE;
        if ((IntrinsicMeasurable)obj != null) {
            int i16 = 0;
            remainingWidth2 = TextFieldKt.access$substractConstraintSafely(width, (IntrinsicMeasurable)obj.maxIntrinsicWidth(intValue3));
            intValue = (Number)obj4.invoke(obj, Integer.valueOf(width)).intValue();
        } else {
            intValue = 0;
        }
        int i17 = 0;
        Object obj12 = obj10;
        int i19 = 0;
        index$iv$iv4 = 0;
        while (index$iv$iv4 < obj12.size()) {
            layoutId2 = null;
            $this$fastFirstOrNull$iv = 0;
            index$iv$iv4++;
        }
        i5 = 0;
        if ((IntrinsicMeasurable)i5 != 0) {
            equal = 0;
            remainingWidth2 = TextFieldKt.access$substractConstraintSafely(remainingWidth2, (IntrinsicMeasurable)i5.maxIntrinsicWidth(intValue3));
            it = intValue3;
        } else {
            it = 0;
        }
        int i13 = 0;
        Object obj11 = invoke2;
        int i18 = 0;
        index$iv$iv5 = 0;
        while (index$iv$iv5 < obj11.size()) {
            size2 = 0;
            layoutId2 = null;
            index$iv$iv5++;
            remainingWidth2 = remainingWidth;
        }
        remainingWidth = remainingWidth2;
        index$iv$iv4 = 0;
        if ((IntrinsicMeasurable)index$iv$iv4 != 0) {
            int i9 = 0;
            i4 = remainingWidth2;
        } else {
            i4 = 0;
        }
        int i11 = 0;
        Object obj8 = obj3;
        int i14 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < obj8.size()) {
            str = size;
            index$iv$iv4 = 0;
            layoutId2 = null;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)str), "TextField")) {
                break;
            } else {
            }
            Object obj5 = this;
            index$iv$iv2++;
            obj3 = $this$fastFirstOrNull$iv;
        }
        NoSuchElementException $this$fastForEach$iv$iv = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw $this$fastForEach$iv$iv;
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        boolean intValue4;
        boolean intValue2;
        boolean intValue3;
        int intValue;
        Object invoke;
        int leadingWidth;
        Object invoke2;
        int i2;
        int index$iv$iv4;
        int i3;
        int index$iv$iv3;
        int i6;
        Object obj;
        Object str2;
        int index$iv$iv5;
        Object $i$f$fastForEach;
        int i5;
        int index$iv$iv;
        int index$iv$iv2;
        boolean it;
        int size;
        int i4;
        Object it2;
        String str;
        Object layoutId2;
        String layoutId;
        boolean $this$fastFirstOrNull$iv;
        int i;
        final Object obj2 = intrinsicMeasurer;
        int i11 = 0;
        boolean z2 = z;
        int i16 = 0;
        index$iv$iv4 = 0;
        while (index$iv$iv4 < z2.size()) {
            str2 = obj;
            i5 = 0;
            i4 = 0;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)str2), "TextField")) {
                break;
            } else {
            }
            index$iv$iv4++;
        }
        NoSuchElementException $this$fastForEach$iv$iv = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw $this$fastForEach$iv$iv;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        return intrinsicHeight($this$maxIntrinsicHeight, measurables, width, (Function2)TextFieldMeasurePolicy.maxIntrinsicHeight.1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        return intrinsicWidth(measurables, height, (Function2)TextFieldMeasurePolicy.maxIntrinsicWidth.1.INSTANCE);
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        int equal;
        long measure-BRTryo02;
        int equal3;
        long measure-BRTryo0;
        int occupiedSpaceHorizontally2;
        int equal4;
        int measure-BRTryo04;
        int equal2;
        Placeable measure-BRTryo03;
        int $this$fastFirstOrNull$iv;
        long looseConstraints;
        int looseConstraints2;
        int it;
        long offset-NN6Ew-U$default;
        int i6;
        int i5;
        int i7;
        int topPaddingValue;
        int index$iv$iv;
        int i22;
        int i17;
        int height;
        int i23;
        int index$iv$iv3;
        int leadingPlaceable;
        Object trailingPlaceable;
        Object layoutId;
        MeasureScope measureScope;
        Object obj;
        int index$iv$iv2;
        long l;
        int i3;
        int i18;
        long l3;
        int i19;
        int i10;
        int i20;
        int i12;
        int i11;
        int occupiedSpaceHorizontally;
        int i13;
        int i;
        int i21;
        int i9;
        int i16;
        int i8;
        int i2;
        int i14;
        int verticalConstraintOffset;
        int looseConstraints3;
        Placeable placeable;
        int i15;
        long l2;
        long textFieldConstraints;
        int i4;
        trailingPlaceable = this;
        measureScope = $this$measure_u2d3p2s80s;
        int roundToPx-0680j_4 = measureScope.roundToPx-0680j_4(trailingPlaceable.paddingValues.calculateTopPadding-D9Ej5fM());
        final int roundToPx-0680j_43 = measureScope.roundToPx-0680j_4(trailingPlaceable.paddingValues.calculateBottomPadding-D9Ej5fM());
        final int roundToPx-0680j_42 = measureScope.roundToPx-0680j_4(TextFieldKt.getTextFieldTopPadding());
        equal = 0;
        int i33 = 0;
        long l6 = l4;
        int i38 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < l6.size()) {
            i18 = 0;
            i20 = 0;
            index$iv$iv++;
            equal = occupiedSpaceHorizontally;
        }
        occupiedSpaceHorizontally = equal;
        l = 0;
        measure-BRTryo02 = l;
        if ((Measurable)measure-BRTryo02 != 0) {
            i22 = measure-BRTryo02;
        } else {
            i22 = 0;
        }
        widthOrZero2 += occupiedSpaceHorizontally;
        i6 = 0;
        i5 = offset-NN6Ew-U$default;
        i17 = 0;
        index$iv$iv3 = 0;
        while (index$iv$iv3 < i5.size()) {
            i18 = 0;
            i20 = 0;
            index$iv$iv3++;
            looseConstraints = occupiedSpaceHorizontally;
            equal3 = verticalConstraintOffset;
        }
        verticalConstraintOffset = equal3;
        occupiedSpaceHorizontally = looseConstraints;
        l = 0;
        measure-BRTryo0 = l;
        if ((Measurable)measure-BRTryo0 != 0) {
            i6 = 0;
            leadingPlaceable = measure-BRTryo0;
        } else {
            looseConstraints2 = occupiedSpaceHorizontally;
            leadingPlaceable = 0;
        }
        widthOrZero += i27;
        long offset-NN6Ew-U2 = ConstraintsKt.offset-NN6Ew-U(looseConstraints2, obj4, -i24);
        int i28 = measurables;
        i7 = 0;
        height = i28;
        int i45 = 0;
        index$iv$iv2 = 0;
        equal2 = height.size();
        while (index$iv$iv2 < equal2) {
            i20 = 0;
            i21 = 0;
            index$iv$iv2++;
            equal2 = i8;
            looseConstraints2 = looseConstraints3;
        }
        looseConstraints3 = looseConstraints2;
        i10 = 0;
        int i29 = i10;
        if ((Measurable)i29 != 0) {
            measure-BRTryo03 = (Measurable)i29.measure-BRTryo0(offset-NN6Ew-U2);
        } else {
            measure-BRTryo03 = 0;
        }
        if (measure-BRTryo03 != null) {
            i7 = 0;
            if (measure-BRTryo03.get((AlignmentLine)AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE) {
            } else {
                it = height;
            }
        } else {
            it = 0;
        }
        int i46 = Math.max(it, roundToPx-0680j_4);
        if (measure-BRTryo03 != null) {
            i40 -= i46;
        } else {
            i41 -= roundToPx-0680j_43;
        }
        long offset-NN6Ew-U = ConstraintsKt.offset-NN6Ew-U(Constraints.copy-Zbe2FdA$default(constraints, i28, 0, 0, 0, 0, 11), it, -i24);
        int i56 = 0;
        final int i63 = i24;
        occupiedSpaceHorizontally2 = i12;
        while (occupiedSpaceHorizontally2 < measurables.size()) {
            placeable = measure-BRTryo03;
            long labelPlaceable = l3;
            i12 = obj2;
            i13 = 0;
            i2 = 0;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable)i12), "TextField")) {
                break;
            } else {
            }
            textFieldConstraints = offset-NN6Ew-U;
            i9 = offset-NN6Ew-U2;
            int verticalConstraintOffset2 = roundToPx-0680j_4;
            occupiedSpaceHorizontally2 = i15 + 1;
            measureScope = $this$measure_u2d3p2s80s;
            topPaddingValue = leadingPlaceable3;
            measure-BRTryo03 = placeable;
            l3 = l2;
            verticalConstraintOffset = trailingPlaceable2;
            leadingPlaceable = i43;
            trailingPlaceable = this;
        }
        int i64 = occupiedSpaceHorizontally2;
        Placeable placeable3 = measure-BRTryo03;
        NoSuchElementException noSuchElementException = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw noSuchElementException;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        return intrinsicHeight($this$minIntrinsicHeight, measurables, width, (Function2)TextFieldMeasurePolicy.minIntrinsicHeight.1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        return intrinsicWidth(measurables, height, (Function2)TextFieldMeasurePolicy.minIntrinsicWidth.1.INSTANCE);
    }
}
