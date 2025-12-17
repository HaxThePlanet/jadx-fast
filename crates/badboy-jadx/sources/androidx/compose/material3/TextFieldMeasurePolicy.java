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
        int $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$placeholderHeight$2;
        int $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$supportingHeight$2;
        int $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$trailingHeight$2;
        int $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2;
        boolean equal;
        Object invoke;
        int invoke4;
        int layoutId;
        Object invoke3;
        int intValue;
        int $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$leadingHeight$2;
        int maxIntrinsicWidth2;
        int i2;
        int intValue2;
        int invoke2;
        int maxIntrinsicWidth;
        int i5;
        int index$iv$iv2;
        int index$iv$iv;
        int index$iv$iv3;
        int index$iv$iv8;
        int index$iv$iv4;
        int index$iv$iv5;
        int index$iv$iv7;
        boolean equal2;
        int index$iv$iv6;
        int size;
        int item$iv$iv;
        Object obj;
        int size2;
        Object obj2;
        int it;
        Object obj3;
        int layoutId3;
        Object layoutId2;
        int labelHeight;
        int i;
        int prefixHeight;
        boolean $this$fastFirstOrNull$iv;
        int i6;
        int i3;
        int i4;
        int i7;
        final Object obj4 = this;
        final Object obj5 = intrinsicMeasurer;
        int i8 = 0;
        layoutId = 0;
        int i20 = i12;
        invoke2 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < i20.size()) {
            it = 0;
            layoutId3 = 0;
            index$iv$iv2++;
        }
        obj2 = 0;
        if ((IntrinsicMeasurable)obj2 != 0) {
            int i26 = 0;
            remainingWidth = i32;
            $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$leadingHeight$2 = (Number)obj5.invoke(obj2, Integer.valueOf(width)).intValue();
        } else {
            $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$leadingHeight$2 = 0;
        }
        int i27 = 0;
        int i33 = maxIntrinsicWidth2;
        int i38 = 0;
        index$iv$iv6 = 0;
        while (index$iv$iv6 < i33.size()) {
            obj3 = null;
            layoutId2 = null;
            index$iv$iv6++;
            $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$trailingHeight$2 = Integer.MAX_VALUE;
        }
        it = 0;
        if ((IntrinsicMeasurable)it != 0) {
            int i16 = 0;
            remainingWidth = i19;
            i = $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$trailingHeight$2;
        } else {
            i = 0;
        }
        invoke3 = 0;
        int i21 = i13;
        int i28 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < i21.size()) {
            obj2 = 0;
            obj3 = null;
            index$iv$iv++;
        }
        size2 = 0;
        if ((IntrinsicMeasurable)size2 != 0) {
            int i14 = 0;
            $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2 = (Number)obj5.invoke((IntrinsicMeasurable)size2, Integer.valueOf(remainingWidth)).intValue();
        } else {
            $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2 = 0;
        }
        i2 = 0;
        maxIntrinsicWidth = i17;
        int i34 = 0;
        index$iv$iv8 = 0;
        while (index$iv$iv8 < maxIntrinsicWidth.size()) {
            it = 0;
            layoutId3 = 0;
            index$iv$iv8++;
            $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2 = prefixHeight;
        }
        prefixHeight = $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2;
        obj2 = 0;
        if ((IntrinsicMeasurable)obj2 != 0) {
            $i$a$LetTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2 = 0;
            intValue = (Number)obj5.invoke((IntrinsicMeasurable)obj2, Integer.valueOf(remainingWidth)).intValue();
            remainingWidth = i2;
        } else {
            intValue = 0;
        }
        intValue2 = 0;
        i5 = equal;
        int i35 = 0;
        index$iv$iv4 = 0;
        while (index$iv$iv4 < i5.size()) {
            it = 0;
            layoutId3 = 0;
            index$iv$iv4++;
            equal = $this$fastFirstOrNull$iv;
        }
        $this$fastFirstOrNull$iv = equal;
        obj2 = 0;
        if ((IntrinsicMeasurable)obj2 != 0) {
            equal = 0;
            remainingWidth = i5;
            i6 = intValue2;
        } else {
            i6 = 0;
        }
        int i22 = 0;
        int i30 = i15;
        int i36 = 0;
        index$iv$iv5 = 0;
        while (index$iv$iv5 < i30.size()) {
            obj2 = size2;
            it = 0;
            layoutId3 = 0;
            i7 = remainingWidth;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)obj2), "TextField")) {
                break;
            } else {
            }
            int labelHeight4 = intValue;
            index$iv$iv5++;
            remainingWidth = i7;
            prefixHeight = labelHeight;
        }
        int remainingWidth3 = remainingWidth;
        int i42 = prefixHeight;
        int labelHeight3 = intValue;
        NoSuchElementException noSuchElementException = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        boolean $i$a$LetTextFieldMeasurePolicy$intrinsicWidth$trailingWidth$2;
        boolean $i$a$LetTextFieldMeasurePolicy$intrinsicWidth$prefixWidth$2;
        boolean $i$a$LetTextFieldMeasurePolicy$intrinsicWidth$suffixWidth$2;
        int $i$a$LetTextFieldMeasurePolicy$intrinsicWidth$leadingWidth$2;
        int $i$a$LetTextFieldMeasurePolicy$intrinsicWidth$placeholderWidth$2;
        int $i$a$LetTextFieldMeasurePolicy$intrinsicWidth$labelWidth$2;
        Object invoke2;
        int invoke;
        int $i$f$fastFirstOrNull3;
        int $i$f$fastFirstOrNull2;
        int leadingWidth;
        Object invoke3;
        int i4;
        int i5;
        int index$iv$iv6;
        int index$iv$iv7;
        int i2;
        Object obj;
        int i7;
        Object str;
        int index$iv$iv4;
        Object $i$f$fastFirstOrNull;
        int it3;
        int i6;
        int index$iv$iv;
        int index$iv$iv3;
        boolean it2;
        int size;
        int index$iv$iv5;
        int i;
        int index$iv$iv2;
        Object it;
        String str2;
        Object layoutId;
        String layoutId2;
        boolean $this$fastFirstOrNull$iv;
        int $this$fastFirstOrNull$iv2;
        int $this$fastFirstOrNull$iv3;
        int i3;
        final Object obj2 = intrinsicMeasurer;
        int i14 = 0;
        Object obj4 = obj3;
        int i18 = 0;
        index$iv$iv6 = 0;
        while (index$iv$iv6 < obj4.size()) {
            str = obj;
            i6 = 0;
            i = 0;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)str), "TextField")) {
                break;
            } else {
            }
            index$iv$iv6++;
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
        int equal6;
        int measure-BRTryo0;
        int size3;
        int equal4;
        int measure-BRTryo02;
        int size;
        int equal7;
        int measure-BRTryo04;
        int equal5;
        int equal;
        int measure-BRTryo06;
        int equal2;
        int measure-BRTryo03;
        int equal3;
        int supportingMeasurable2;
        int i22;
        int $i$f$fastFirstOrNull;
        int $i$f$fastFirstOrNull3;
        int $i$f$fastFirstOrNull2;
        int labelConstraints;
        int i4;
        int minIntrinsicHeight;
        int $this$fastFirstOrNull$iv;
        int $this$fastFirst$iv;
        int $this$fastFirstOrNull$iv2;
        int i27;
        int i12;
        int i3;
        int i11;
        int i21;
        int index$iv$iv2;
        int index$iv$iv;
        Placeable placeable;
        int index$iv$iv3;
        int index$iv$iv5;
        long looseConstraints2;
        int placeholderPlaceable;
        Object layoutId;
        int size2;
        int measure-BRTryo05;
        Object obj3;
        Object obj2;
        MeasureScope measureScope;
        Object obj4;
        long looseConstraints;
        Object i6;
        int i15;
        int i28;
        int i25;
        int i8;
        Object obj;
        int i;
        int i18;
        int index$iv$iv4;
        float i16;
        int i9;
        int i2;
        int i5;
        int $this$fastFirstOrNull$iv5;
        int i20;
        int i19;
        int $this$fastFirstOrNull$iv3;
        int i13;
        int i17;
        int height;
        int $this$fastFirstOrNull$iv4;
        int i23;
        int i24;
        int heightOrZero;
        int i14;
        int supportingMeasurable;
        int i7;
        Object obj5;
        float f;
        float f2;
        int i26;
        int i10;
        float density;
        PaddingValues paddingValues;
        long l2;
        long l;
        long supportingConstraints;
        obj2 = this;
        measureScope = $this$measure_u2d3p2s80s;
        final int roundToPx-0680j_4 = measureScope.roundToPx-0680j_4(obj2.paddingValues.calculateTopPadding-D9Ej5fM());
        final int roundToPx-0680j_42 = measureScope.roundToPx-0680j_4(obj2.paddingValues.calculateBottomPadding-D9Ej5fM());
        equal6 = 0;
        int i65 = 0;
        long copy-Zbe2FdA$default3 = Constraints.copy-Zbe2FdA$default(constraints, obj3, 0, i65, 0, 0, 10);
        int i51 = 0;
        int i74 = i43;
        int i78 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < i74.size()) {
            i25 = 0;
            i9 = 0;
            index$iv$iv2++;
            equal6 = $this$fastFirstOrNull$iv5;
        }
        $this$fastFirstOrNull$iv5 = equal6;
        obj4 = 0;
        measure-BRTryo0 = obj4;
        if ((Measurable)measure-BRTryo0 != 0) {
            i12 = measure-BRTryo0;
        } else {
            i12 = 0;
        }
        widthOrZero += $this$fastFirstOrNull$iv5;
        $i$f$fastFirstOrNull = 0;
        int i79 = equal7;
        int i81 = 0;
        index$iv$iv3 = 0;
        while (index$iv$iv3 < i79.size()) {
            i25 = 0;
            i9 = 0;
            index$iv$iv3++;
            equal7 = $this$fastFirstOrNull$iv5;
            $i$f$fastFirstOrNull = $this$fastFirstOrNull$iv3;
        }
        $this$fastFirstOrNull$iv5 = equal7;
        $this$fastFirstOrNull$iv3 = $i$f$fastFirstOrNull;
        obj4 = 0;
        measure-BRTryo04 = obj4;
        if ((Measurable)measure-BRTryo04 != 0) {
            i21 = measure-BRTryo04;
        } else {
            looseConstraints = copy-Zbe2FdA$default3;
            i21 = 0;
        }
        i29 += widthOrZero2;
        $i$f$fastFirstOrNull3 = 0;
        int i62 = equal5;
        int i66 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < i62.size()) {
            obj = null;
            $this$fastFirstOrNull$iv5 = 0;
            index$iv$iv++;
            equal5 = $this$fastFirstOrNull$iv3;
            $i$f$fastFirstOrNull3 = $this$fastFirstOrNull$iv4;
        }
        $this$fastFirstOrNull$iv3 = equal5;
        $this$fastFirstOrNull$iv4 = $i$f$fastFirstOrNull3;
        obj3 = 0;
        if ((Measurable)obj3 != 0) {
            placeable = equal5;
        } else {
            placeable = 0;
        }
        occupiedSpaceHorizontally += widthOrZero3;
        $i$f$fastFirstOrNull2 = 0;
        int i63 = equal;
        int i67 = 0;
        index$iv$iv5 = 0;
        int size6 = i63.size();
        while (index$iv$iv5 < size6) {
            i9 = 0;
            $this$fastFirstOrNull$iv3 = 0;
            index$iv$iv5++;
            equal = $this$fastFirstOrNull$iv4;
            $i$f$fastFirstOrNull2 = i14;
        }
        $this$fastFirstOrNull$iv4 = equal;
        i14 = $i$f$fastFirstOrNull2;
        obj = 0;
        int i45 = obj;
        if ((Measurable)i45 != 0) {
            looseConstraints2 = looseConstraints;
            measure-BRTryo06 = (Measurable)i45.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(looseConstraints, i25, -occupiedSpaceHorizontally2, 0, 2));
        } else {
            looseConstraints2 = looseConstraints;
            measure-BRTryo06 = 0;
        }
        occupiedSpaceHorizontally2 += widthOrZero4;
        i4 = -occupiedSpaceHorizontally3;
        long offset-NN6Ew-U = ConstraintsKt.offset-NN6Ew-U(looseConstraints2, size6, i4);
        int i68 = measurables;
        int i83 = 0;
        int i89 = 0;
        final int i114 = measure-BRTryo06;
        equal2 = i68.size();
        i2 = i68;
        $this$fastFirstOrNull$iv = i;
        while ($this$fastFirstOrNull$iv < equal2) {
            Object obj6 = i6;
            $this$fastFirstOrNull$iv3 = 0;
            i14 = 0;
            $this$fastFirstOrNull$iv = i26 + 1;
            equal2 = i;
            i6 = obj5;
        }
        i26 = $this$fastFirstOrNull$iv;
        obj5 = i6;
        $this$fastFirstOrNull$iv5 = 0;
        int i46 = $this$fastFirstOrNull$iv5;
        if ((Measurable)i46 != 0) {
            measure-BRTryo03 = (Measurable)i46.measure-BRTryo0(offset-NN6Ew-U);
        } else {
            measure-BRTryo03 = 0;
        }
        int i84 = 0;
        final int i115 = measure-BRTryo03;
        equal3 = measurables.size();
        final long l7 = offset-NN6Ew-U;
        labelConstraints = i18;
        while (labelConstraints < equal3) {
            i4 = i15;
            i2 = 0;
            $this$fastFirstOrNull$iv3 = 0;
            labelConstraints = i14 + 1;
            i15 = i4;
            equal3 = $this$fastFirstOrNull$iv4;
        }
        i14 = labelConstraints;
        i4 = i15;
        i18 = 0;
        int i47 = i18;
        if ((Measurable)i47 != 0) {
            minIntrinsicHeight = (Measurable)i47.minIntrinsicHeight(Constraints.getMinWidth-impl(constraints));
        } else {
            minIntrinsicHeight = 0;
        }
        heightOrZero8 += roundToPx-0680j_4;
        int i85 = i12;
        int effectiveTopOffset = -occupiedSpaceHorizontally3;
        long offset-NN6Ew-U2 = ConstraintsKt.offset-NN6Ew-U(Constraints.copy-Zbe2FdA$default(constraints, 0, 0, 0, 0, 0, 11), i12, effectiveTopOffset);
        int i70 = measurables;
        i3 = 0;
        final int i118 = occupiedSpaceHorizontally3;
        size3 = i70.size();
        int i98 = i70;
        $this$fastFirst$iv = index$iv$iv4;
        String $i$f$fastFirst = "Collection contains no element matching the predicate.";
        while ($this$fastFirst$iv < size3) {
            int i30 = i28;
            i13 = obj7;
            i23 = 0;
            obj5 = 0;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable)i13), "TextField")) {
                break;
            } else {
            }
            supportingMeasurable = i47;
            l2 = offset-NN6Ew-U2;
            l = looseConstraints2;
            $this$fastFirst$iv = i10 + 1;
            obj2 = this;
            measureScope = $this$measure_u2d3p2s80s;
            i3 = index$iv$iv4;
            size3 = i20;
            i28 = i26;
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
