package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.TextFieldImplKt;
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
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J8\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u000e\u001a\u00020\nH\u0016J,\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u000c2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006 ", d2 = {"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    public static final float access$getAnimationProgress$p(androidx.compose.material3.TextFieldMeasurePolicy $this) {
        return $this.animationProgress;
    }

    public static final PaddingValues access$getPaddingValues$p(androidx.compose.material3.TextFieldMeasurePolicy $this) {
        return $this.paddingValues;
    }

    public static final boolean access$getSingleLine$p(androidx.compose.material3.TextFieldMeasurePolicy $this) {
        return $this.singleLine;
    }

    private final int intrinsicHeight(IntrinsicMeasureScope $this$intrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        int remainingWidth;
        int intValue4;
        int intValue7;
        int intValue2;
        int intValue6;
        boolean equal2;
        Object invoke;
        int invoke2;
        int layoutId2;
        Object invoke3;
        int intValue3;
        int intValue;
        int maxIntrinsicWidth2;
        int i4;
        int intValue5;
        int invoke4;
        int maxIntrinsicWidth;
        int i5;
        int index$iv$iv;
        int index$iv$iv8;
        int index$iv$iv3;
        int index$iv$iv6;
        int index$iv$iv7;
        int index$iv$iv4;
        int index$iv$iv2;
        boolean equal;
        int index$iv$iv5;
        int size;
        int item$iv$iv;
        Object obj2;
        int size2;
        Object obj;
        int it;
        Object obj3;
        int layoutId3;
        Object layoutId;
        int labelHeight;
        int i7;
        int prefixHeight;
        boolean $this$fastFirstOrNull$iv;
        int i3;
        int i6;
        int i2;
        int i;
        final Object obj4 = this;
        final Object obj5 = intrinsicMeasurer;
        int i8 = 0;
        layoutId2 = 0;
        int i20 = i12;
        invoke4 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < i20.size()) {
            it = 0;
            layoutId3 = 0;
            index$iv$iv++;
        }
        obj = 0;
        if ((IntrinsicMeasurable)obj != 0) {
            int i26 = 0;
            remainingWidth = i32;
            intValue = (Number)obj5.invoke(obj, Integer.valueOf(width)).intValue();
        } else {
            intValue = 0;
        }
        int i27 = 0;
        int i33 = maxIntrinsicWidth2;
        int i38 = 0;
        index$iv$iv5 = 0;
        while (index$iv$iv5 < i33.size()) {
            obj3 = null;
            layoutId = null;
            index$iv$iv5++;
            intValue2 = Integer.MAX_VALUE;
        }
        it = 0;
        if ((IntrinsicMeasurable)it != 0) {
            int i16 = 0;
            remainingWidth = i19;
            i7 = intValue2;
        } else {
            i7 = 0;
        }
        invoke3 = 0;
        int i21 = i13;
        int i28 = 0;
        index$iv$iv8 = 0;
        while (index$iv$iv8 < i21.size()) {
            obj = 0;
            obj3 = null;
            index$iv$iv8++;
        }
        size2 = 0;
        if ((IntrinsicMeasurable)size2 != 0) {
            int i14 = 0;
            intValue6 = (Number)obj5.invoke((IntrinsicMeasurable)size2, Integer.valueOf(remainingWidth)).intValue();
        } else {
            intValue6 = 0;
        }
        i4 = 0;
        maxIntrinsicWidth = i17;
        int i34 = 0;
        index$iv$iv6 = 0;
        while (index$iv$iv6 < maxIntrinsicWidth.size()) {
            it = 0;
            layoutId3 = 0;
            index$iv$iv6++;
            intValue6 = prefixHeight;
        }
        prefixHeight = intValue6;
        obj = 0;
        if ((IntrinsicMeasurable)obj != 0) {
            intValue6 = 0;
            intValue3 = (Number)obj5.invoke((IntrinsicMeasurable)obj, Integer.valueOf(remainingWidth)).intValue();
            remainingWidth = i4;
        } else {
            intValue3 = 0;
        }
        intValue5 = 0;
        i5 = equal2;
        int i35 = 0;
        index$iv$iv7 = 0;
        while (index$iv$iv7 < i5.size()) {
            it = 0;
            layoutId3 = 0;
            index$iv$iv7++;
            equal2 = $this$fastFirstOrNull$iv;
        }
        $this$fastFirstOrNull$iv = equal2;
        obj = 0;
        if ((IntrinsicMeasurable)obj != 0) {
            equal2 = 0;
            remainingWidth = i5;
            i3 = intValue5;
        } else {
            i3 = 0;
        }
        int i22 = 0;
        int i30 = i15;
        int i36 = 0;
        index$iv$iv4 = 0;
        while (index$iv$iv4 < i30.size()) {
            obj = size2;
            it = 0;
            layoutId3 = 0;
            i = remainingWidth;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)obj), "TextField")) {
                break;
            } else {
            }
            int labelHeight4 = intValue3;
            index$iv$iv4++;
            remainingWidth = i;
            prefixHeight = labelHeight;
        }
        int remainingWidth3 = remainingWidth;
        int i42 = prefixHeight;
        int labelHeight3 = intValue3;
        NoSuchElementException noSuchElementException = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        boolean intValue6;
        boolean intValue2;
        boolean intValue;
        int intValue3;
        int intValue5;
        int intValue4;
        Object invoke3;
        int invoke2;
        int $i$f$fastFirstOrNull;
        int $i$f$fastFirstOrNull3;
        int leadingWidth;
        Object invoke;
        int i;
        int i7;
        int index$iv$iv2;
        int index$iv$iv5;
        int i6;
        Object obj;
        int i5;
        Object str2;
        int index$iv$iv3;
        Object $i$f$fastFirstOrNull2;
        int it2;
        int i2;
        int index$iv$iv4;
        int index$iv$iv6;
        boolean it3;
        int size;
        int index$iv$iv7;
        int i4;
        int index$iv$iv;
        Object it;
        String str;
        Object layoutId;
        String layoutId2;
        boolean $this$fastFirstOrNull$iv3;
        int $this$fastFirstOrNull$iv;
        int $this$fastFirstOrNull$iv2;
        int i3;
        final Object obj2 = intrinsicMeasurer;
        int i14 = 0;
        Object obj4 = obj3;
        int i18 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < obj4.size()) {
            str2 = obj;
            i2 = 0;
            i4 = 0;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)str2), "TextField")) {
                break;
            } else {
            }
            index$iv$iv2++;
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
        int measure-BRTryo03;
        int size;
        int equal7;
        int measure-BRTryo0;
        int size2;
        int equal3;
        int measure-BRTryo06;
        int equal6;
        int equal4;
        int measure-BRTryo05;
        int equal2;
        int measure-BRTryo04;
        int equal5;
        int supportingMeasurable;
        int i23;
        int $i$f$fastFirstOrNull2;
        int $i$f$fastFirstOrNull;
        int $i$f$fastFirstOrNull3;
        int labelConstraints;
        int i3;
        int minIntrinsicHeight;
        int $this$fastFirstOrNull$iv5;
        int $this$fastFirst$iv;
        int $this$fastFirstOrNull$iv4;
        int i5;
        int i7;
        int i10;
        int i6;
        int i24;
        int index$iv$iv;
        int index$iv$iv3;
        Placeable placeable;
        int index$iv$iv5;
        int index$iv$iv4;
        long looseConstraints;
        int placeholderPlaceable;
        Object layoutId;
        int size3;
        int measure-BRTryo02;
        Object obj3;
        Object obj2;
        MeasureScope measureScope;
        Object obj4;
        long looseConstraints2;
        Object i26;
        int i13;
        int i17;
        int i27;
        int i15;
        Object obj;
        int i28;
        int i21;
        int index$iv$iv2;
        float i8;
        int i;
        int i4;
        int i16;
        int $this$fastFirstOrNull$iv3;
        int i25;
        int i2;
        int $this$fastFirstOrNull$iv2;
        int i19;
        int i9;
        int height;
        int $this$fastFirstOrNull$iv;
        int i12;
        int i20;
        int heightOrZero;
        int i22;
        int supportingMeasurable2;
        int i18;
        Object obj5;
        float f2;
        float f;
        int i11;
        int i14;
        float density;
        PaddingValues paddingValues;
        long l2;
        long l;
        long supportingConstraints;
        obj2 = this;
        measureScope = $this$measure_u2d3p2s80s;
        final int roundToPx-0680j_4 = measureScope.roundToPx-0680j_4(obj2.paddingValues.calculateTopPadding-D9Ej5fM());
        final int roundToPx-0680j_42 = measureScope.roundToPx-0680j_4(obj2.paddingValues.calculateBottomPadding-D9Ej5fM());
        equal = 0;
        int i65 = 0;
        long copy-Zbe2FdA$default3 = Constraints.copy-Zbe2FdA$default(constraints, obj3, 0, i65, 0, 0, 10);
        int i51 = 0;
        int i74 = i43;
        int i78 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < i74.size()) {
            i27 = 0;
            i = 0;
            index$iv$iv++;
            equal = $this$fastFirstOrNull$iv3;
        }
        $this$fastFirstOrNull$iv3 = equal;
        obj4 = 0;
        measure-BRTryo03 = obj4;
        if ((Measurable)measure-BRTryo03 != 0) {
            i7 = measure-BRTryo03;
        } else {
            i7 = 0;
        }
        widthOrZero += $this$fastFirstOrNull$iv3;
        $i$f$fastFirstOrNull2 = 0;
        int i79 = equal3;
        int i81 = 0;
        index$iv$iv5 = 0;
        while (index$iv$iv5 < i79.size()) {
            i27 = 0;
            i = 0;
            index$iv$iv5++;
            equal3 = $this$fastFirstOrNull$iv3;
            $i$f$fastFirstOrNull2 = $this$fastFirstOrNull$iv2;
        }
        $this$fastFirstOrNull$iv3 = equal3;
        $this$fastFirstOrNull$iv2 = $i$f$fastFirstOrNull2;
        obj4 = 0;
        measure-BRTryo06 = obj4;
        if ((Measurable)measure-BRTryo06 != 0) {
            i24 = measure-BRTryo06;
        } else {
            looseConstraints2 = copy-Zbe2FdA$default3;
            i24 = 0;
        }
        i29 += widthOrZero2;
        $i$f$fastFirstOrNull = 0;
        int i62 = equal6;
        int i66 = 0;
        index$iv$iv3 = 0;
        while (index$iv$iv3 < i62.size()) {
            obj = null;
            $this$fastFirstOrNull$iv3 = 0;
            index$iv$iv3++;
            equal6 = $this$fastFirstOrNull$iv2;
            $i$f$fastFirstOrNull = $this$fastFirstOrNull$iv;
        }
        $this$fastFirstOrNull$iv2 = equal6;
        $this$fastFirstOrNull$iv = $i$f$fastFirstOrNull;
        obj3 = 0;
        if ((Measurable)obj3 != 0) {
            placeable = equal6;
        } else {
            placeable = 0;
        }
        occupiedSpaceHorizontally += widthOrZero3;
        $i$f$fastFirstOrNull3 = 0;
        int i63 = equal4;
        int i67 = 0;
        index$iv$iv4 = 0;
        int size6 = i63.size();
        while (index$iv$iv4 < size6) {
            i = 0;
            $this$fastFirstOrNull$iv2 = 0;
            index$iv$iv4++;
            equal4 = $this$fastFirstOrNull$iv;
            $i$f$fastFirstOrNull3 = i22;
        }
        $this$fastFirstOrNull$iv = equal4;
        i22 = $i$f$fastFirstOrNull3;
        obj = 0;
        int i45 = obj;
        if ((Measurable)i45 != 0) {
            looseConstraints = looseConstraints2;
            measure-BRTryo05 = (Measurable)i45.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(looseConstraints2, i27, -occupiedSpaceHorizontally2, 0, 2));
        } else {
            looseConstraints = looseConstraints2;
            measure-BRTryo05 = 0;
        }
        occupiedSpaceHorizontally2 += widthOrZero4;
        i3 = -occupiedSpaceHorizontally3;
        long offset-NN6Ew-U = ConstraintsKt.offset-NN6Ew-U(looseConstraints, size6, i3);
        int i68 = measurables;
        int i83 = 0;
        int i89 = 0;
        final int i114 = measure-BRTryo05;
        equal2 = i68.size();
        i4 = i68;
        $this$fastFirstOrNull$iv5 = i28;
        while ($this$fastFirstOrNull$iv5 < equal2) {
            Object obj6 = i26;
            $this$fastFirstOrNull$iv2 = 0;
            i22 = 0;
            $this$fastFirstOrNull$iv5 = i11 + 1;
            equal2 = i28;
            i26 = obj5;
        }
        i11 = $this$fastFirstOrNull$iv5;
        obj5 = i26;
        $this$fastFirstOrNull$iv3 = 0;
        int i46 = $this$fastFirstOrNull$iv3;
        if ((Measurable)i46 != 0) {
            measure-BRTryo04 = (Measurable)i46.measure-BRTryo0(offset-NN6Ew-U);
        } else {
            measure-BRTryo04 = 0;
        }
        int i84 = 0;
        final int i115 = measure-BRTryo04;
        equal5 = measurables.size();
        final long l7 = offset-NN6Ew-U;
        labelConstraints = i21;
        while (labelConstraints < equal5) {
            i3 = i13;
            i4 = 0;
            $this$fastFirstOrNull$iv2 = 0;
            labelConstraints = i22 + 1;
            i13 = i3;
            equal5 = $this$fastFirstOrNull$iv;
        }
        i22 = labelConstraints;
        i3 = i13;
        i21 = 0;
        int i47 = i21;
        if ((Measurable)i47 != 0) {
            minIntrinsicHeight = (Measurable)i47.minIntrinsicHeight(Constraints.getMinWidth-impl(constraints));
        } else {
            minIntrinsicHeight = 0;
        }
        heightOrZero8 += roundToPx-0680j_4;
        int i85 = i7;
        int effectiveTopOffset = -occupiedSpaceHorizontally3;
        long offset-NN6Ew-U2 = ConstraintsKt.offset-NN6Ew-U(Constraints.copy-Zbe2FdA$default(constraints, 0, 0, 0, 0, 0, 11), i7, effectiveTopOffset);
        int i70 = measurables;
        i10 = 0;
        final int i118 = occupiedSpaceHorizontally3;
        size = i70.size();
        int i98 = i70;
        $this$fastFirst$iv = index$iv$iv2;
        String $i$f$fastFirst = "Collection contains no element matching the predicate.";
        while ($this$fastFirst$iv < size) {
            int i30 = i17;
            i19 = obj7;
            i12 = 0;
            obj5 = 0;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable)i19), "TextField")) {
                break;
            } else {
            }
            supportingMeasurable2 = i47;
            l2 = offset-NN6Ew-U2;
            l = looseConstraints;
            $this$fastFirst$iv = i14 + 1;
            obj2 = this;
            measureScope = $this$measure_u2d3p2s80s;
            i10 = index$iv$iv2;
            size = i25;
            i17 = i11;
            $i$f$fastFirst = "Collection contains no element matching the predicate.";
        }
        NoSuchElementException noSuchElementException2 = new NoSuchElementException($i$f$fastFirst);
        throw noSuchElementException2;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        return intrinsicHeight($this$minIntrinsicHeight, measurables, width, (Function2)TextFieldMeasurePolicy.minIntrinsicHeight.1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        return intrinsicWidth(measurables, height, (Function2)TextFieldMeasurePolicy.minIntrinsicWidth.1.INSTANCE);
    }
}
