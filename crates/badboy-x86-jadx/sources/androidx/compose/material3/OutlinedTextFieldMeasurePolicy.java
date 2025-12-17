package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.geometry.SizeKt;
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
import androidx.compose.ui.util.MathHelpersKt;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u0001B1\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ<\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J<\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J\"\u0010\u0018\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u0019\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J,\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!J\"\u0010\"\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010#\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006$", d2 = {"Landroidx/compose/material3/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function1;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {

    private final float animationProgress;
    private final Function1<Size, Unit> onLabelMeasured;
    private final PaddingValues paddingValues;
    private final boolean singleLine;
    public OutlinedTextFieldMeasurePolicy(Function1<? super Size, Unit> onLabelMeasured, boolean singleLine, float animationProgress, PaddingValues paddingValues) {
        super();
        this.onLabelMeasured = onLabelMeasured;
        this.singleLine = singleLine;
        this.animationProgress = animationProgress;
        this.paddingValues = paddingValues;
    }

    public static final float access$getAnimationProgress$p(androidx.compose.material3.OutlinedTextFieldMeasurePolicy $this) {
        return $this.animationProgress;
    }

    public static final PaddingValues access$getPaddingValues$p(androidx.compose.material3.OutlinedTextFieldMeasurePolicy $this) {
        return $this.paddingValues;
    }

    public static final boolean access$getSingleLine$p(androidx.compose.material3.OutlinedTextFieldMeasurePolicy $this) {
        return $this.singleLine;
    }

    private final int intrinsicHeight(IntrinsicMeasureScope $this$intrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        int remainingWidth;
        boolean equal5;
        int intValue;
        int equal;
        int intValue2;
        boolean equal2;
        Object equal4;
        Object obj6;
        int invoke2;
        Object $this$fastFirstOrNull$iv;
        int layoutId2;
        Object invoke;
        int prefixHeight;
        int intValue3;
        int intValue4;
        int maxIntrinsicWidth;
        int i7;
        int invoke3;
        int obj;
        int i2;
        int index$iv$iv3;
        int maxIntrinsicWidth2;
        int index$iv$iv6;
        int index$iv$iv2;
        int index$iv$iv4;
        boolean equal3;
        int index$iv$iv5;
        int index$iv$iv;
        int index$iv$iv7;
        int index$iv$iv8;
        int index$iv$iv9;
        Object obj4;
        int size2;
        int size;
        Object obj2;
        int i3;
        Object obj3;
        int i8;
        Object layoutId;
        Object placeholderHeight;
        int trailingHeight;
        boolean $this$fastFirstOrNull$iv2;
        int i;
        int i6;
        Object obj5;
        int i4;
        int i5;
        final Object obj7 = this;
        final Object obj8 = intrinsicMeasurer;
        int i9 = 0;
        layoutId2 = 0;
        Object obj10 = obj9;
        invoke3 = 0;
        index$iv$iv3 = 0;
        while (index$iv$iv3 < obj10.size()) {
            i3 = 0;
            i8 = 0;
            index$iv$iv3++;
        }
        obj2 = 0;
        if ((IntrinsicMeasurable)obj2 != 0) {
            int i21 = 0;
            remainingWidth = i27;
            intValue4 = (Number)obj8.invoke(obj2, Integer.valueOf(width)).intValue();
        } else {
            intValue4 = 0;
        }
        int i22 = 0;
        int i28 = maxIntrinsicWidth;
        int i31 = 0;
        index$iv$iv5 = 0;
        while (index$iv$iv5 < i28.size()) {
            obj3 = null;
            layoutId = null;
            index$iv$iv5++;
            equal = Integer.MAX_VALUE;
        }
        i3 = 0;
        if ((IntrinsicMeasurable)i3 != 0) {
            int i14 = 0;
            remainingWidth = i19;
            intValue2 = (Number)obj8.invoke(i3, Integer.valueOf(width)).intValue();
        } else {
            intValue2 = 0;
        }
        int i20 = 0;
        Object obj11 = invoke;
        int i29 = 0;
        index$iv$iv6 = 0;
        while (index$iv$iv6 < obj11.size()) {
            i3 = 0;
            i8 = 0;
            index$iv$iv6++;
            intValue2 = trailingHeight;
        }
        trailingHeight = intValue2;
        obj2 = 0;
        if ((IntrinsicMeasurable)obj2 != 0) {
            int i13 = 0;
            i = intValue2;
        } else {
            i7 = width;
            i = 0;
        }
        int i15 = 0;
        obj = equal2;
        maxIntrinsicWidth2 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < obj.size()) {
            i3 = 0;
            i8 = 0;
            index$iv$iv2++;
            equal2 = $this$fastFirstOrNull$iv2;
        }
        $this$fastFirstOrNull$iv2 = equal2;
        obj2 = 0;
        if ((IntrinsicMeasurable)obj2 != 0) {
            equal2 = 0;
            prefixHeight = (Number)obj8.invoke((IntrinsicMeasurable)obj2, Integer.valueOf(remainingWidth)).intValue();
            remainingWidth = obj;
        } else {
            prefixHeight = 0;
        }
        i2 = 0;
        Object obj13 = equal4;
        int i32 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < obj13.size()) {
            obj3 = null;
            layoutId = null;
            index$iv$iv++;
            equal4 = $this$fastFirstOrNull$iv2;
            prefixHeight = i6;
        }
        $this$fastFirstOrNull$iv2 = equal4;
        i6 = prefixHeight;
        i3 = 0;
        if ((IntrinsicMeasurable)i3 != 0) {
            equal4 = 0;
            intValue3 = (Number)obj8.invoke((IntrinsicMeasurable)i3, Integer.valueOf(remainingWidth)).intValue();
            remainingWidth = i2;
        } else {
            intValue3 = 0;
        }
        int i24 = 0;
        Object obj14 = obj6;
        int i33 = 0;
        index$iv$iv7 = 0;
        while (index$iv$iv7 < obj14.size()) {
            i3 = obj2;
            obj3 = null;
            layoutId = null;
            i5 = remainingWidth;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)i3), "TextField")) {
                break;
            } else {
            }
            index$iv$iv7++;
            obj6 = placeholderHeight;
            remainingWidth = i5;
        }
        int remainingWidth2 = remainingWidth;
        Object obj16 = obj6;
        NoSuchElementException noSuchElementException = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private final int intrinsicWidth(IntrinsicMeasureScope $this$intrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        boolean intValue6;
        boolean intValue;
        int intValue5;
        int intValue3;
        int intValue2;
        int intValue4;
        String $this$fastFirstOrNull$iv;
        int $i$f$fastFirstOrNull;
        int leadingWidth;
        int $i$f$fastFirstOrNull2;
        int $i$f$fastFirstOrNull3;
        Object invoke;
        int i4;
        int i2;
        int index$iv$iv5;
        int index$iv$iv6;
        int i3;
        Object obj;
        int i7;
        Object equal;
        int index$iv$iv2;
        int index$iv$iv3;
        String $this$fastForEach$iv$iv;
        int it2;
        int i8;
        int index$iv$iv4;
        int index$iv$iv7;
        boolean it;
        int index$iv$iv;
        int i5;
        Object layoutId;
        String str;
        Object layoutId2;
        String $this$fastFirstOrNull$iv4;
        int $this$fastFirstOrNull$iv2;
        int i;
        int $this$fastFirstOrNull$iv3;
        int i6;
        final Object obj2 = this;
        final Object obj3 = intrinsicMeasurer;
        int i15 = 0;
        boolean z2 = z;
        int i19 = 0;
        index$iv$iv5 = 0;
        while (index$iv$iv5 < z2.size()) {
            equal = obj;
            i8 = 0;
            i5 = 0;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)equal), "TextField")) {
                break;
            } else {
            }
            index$iv$iv5++;
        }
        NoSuchElementException $this$fastForEach$iv$iv2 = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw $this$fastForEach$iv$iv2;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        return intrinsicHeight($this$maxIntrinsicHeight, measurables, width, (Function2)OutlinedTextFieldMeasurePolicy.maxIntrinsicHeight.1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        return intrinsicWidth($this$maxIntrinsicWidth, measurables, height, (Function2)OutlinedTextFieldMeasurePolicy.maxIntrinsicWidth.1.INSTANCE);
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        int equal3;
        int size;
        int equal6;
        int measure-BRTryo04;
        int totalHeight;
        int equal2;
        int measure-BRTryo03;
        int equal4;
        int equal7;
        int measure-BRTryo0;
        int equal;
        int measure-BRTryo02;
        int equal5;
        int supportingMeasurable2;
        int i14;
        int leadingPlaceable;
        int $i$f$fastFirstOrNull;
        int $i$f$fastFirstOrNull2;
        int labelHorizontalPaddingOffset;
        Size.Companion companion;
        int $this$fastFirstOrNull$iv2;
        int i7;
        int $this$fastFirstOrNull$iv3;
        int measure-BRTryo05;
        int relaxedConstraints3;
        int i4;
        Placeable placeable;
        long relaxedConstraints;
        long copy-Zbe2FdA$default;
        int index$iv$iv2;
        int i23;
        int index$iv$iv4;
        int index$iv$iv3;
        long prefixPlaceable;
        int index$iv$iv;
        int i9;
        Object layoutId;
        int size2;
        long zero-NH-jbRc;
        int minIntrinsicHeight;
        long textFieldPlaceable;
        Object obj3;
        int i16;
        int i10;
        Object supportingPlaceable;
        MeasureScope measureScope;
        Object obj;
        long relaxedConstraints2;
        float f3;
        int i2;
        int i27;
        Object obj2;
        Object obj4;
        int i24;
        int i28;
        int i15;
        int i29;
        PaddingValues i5;
        int $this$fastFirstOrNull$iv;
        int i25;
        int $this$fastFirstOrNull$iv4;
        int i;
        int i12;
        int i19;
        int i20;
        int i26;
        int i8;
        int i17;
        int supportingMeasurable;
        int i18;
        int i11;
        float f2;
        int i30;
        float f;
        int i13;
        float density;
        float density2;
        int i22;
        PaddingValues paddingValues;
        int labelConstraints;
        int i3;
        long l;
        Placeable supportingConstraints;
        int i21;
        long l2;
        int i6;
        long l3;
        supportingPlaceable = this;
        measureScope = $this$measure_u2d3p2s80s;
        equal3 = 0;
        final int roundToPx-0680j_44 = measureScope.roundToPx-0680j_4(supportingPlaceable.paddingValues.calculateBottomPadding-D9Ej5fM());
        int i62 = 0;
        long copy-Zbe2FdA$default2 = Constraints.copy-Zbe2FdA$default(constraints, obj3, 0, i62, 0, 0, 10);
        int i48 = 0;
        int i66 = i40;
        int i72 = 0;
        index$iv$iv4 = 0;
        while (index$iv$iv4 < i66.size()) {
            i2 = 0;
            i15 = 0;
            index$iv$iv4++;
            equal3 = $this$fastFirstOrNull$iv;
        }
        $this$fastFirstOrNull$iv = equal3;
        obj = 0;
        if ((Measurable)obj != 0) {
            leadingPlaceable = equal3;
        } else {
            leadingPlaceable = 0;
        }
        widthOrZero += $this$fastFirstOrNull$iv;
        int i67 = 0;
        int i73 = equal2;
        int i75 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < i73.size()) {
            i2 = 0;
            i15 = 0;
            index$iv$iv++;
            equal2 = $this$fastFirstOrNull$iv;
            leadingPlaceable = labelConstraints;
        }
        $this$fastFirstOrNull$iv = equal2;
        labelConstraints = leadingPlaceable;
        obj = 0;
        measure-BRTryo03 = obj;
        if ((Measurable)measure-BRTryo03 != 0) {
            relaxedConstraints3 = measure-BRTryo03;
        } else {
            relaxedConstraints2 = copy-Zbe2FdA$default2;
            relaxedConstraints3 = 0;
        }
        i31 += widthOrZero2;
        $i$f$fastFirstOrNull = 0;
        int i63 = equal4;
        int i68 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < i63.size()) {
            obj3 = null;
            i15 = 0;
            index$iv$iv2++;
            equal4 = $this$fastFirstOrNull$iv;
            $i$f$fastFirstOrNull = $this$fastFirstOrNull$iv4;
        }
        $this$fastFirstOrNull$iv = equal4;
        $this$fastFirstOrNull$iv4 = $i$f$fastFirstOrNull;
        size2 = 0;
        if ((Measurable)size2 != 0) {
            placeable = equal4;
        } else {
            placeable = 0;
        }
        occupiedSpaceHorizontally += widthOrZero3;
        $i$f$fastFirstOrNull2 = 0;
        int i69 = equal7;
        index$iv$iv3 = 0;
        while (index$iv$iv3 < i69.size()) {
            obj4 = 0;
            $this$fastFirstOrNull$iv = 0;
            index$iv$iv3++;
            equal7 = $this$fastFirstOrNull$iv4;
            $i$f$fastFirstOrNull2 = i20;
        }
        $this$fastFirstOrNull$iv4 = equal7;
        i20 = $i$f$fastFirstOrNull2;
        obj3 = 0;
        if ((Measurable)obj3 != null) {
            relaxedConstraints = relaxedConstraints2;
            measure-BRTryo0 = (Measurable)obj3.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(relaxedConstraints2, i2, -occupiedSpaceHorizontally2, 0, 2));
        } else {
            relaxedConstraints = relaxedConstraints2;
            measure-BRTryo0 = 0;
        }
        occupiedSpaceHorizontally2 += widthOrZero4;
        roundToPx-0680j_4 += roundToPx-0680j_42;
        i9 = -roundToPx-0680j_44;
        i16 = 0;
        f3 = i81;
        int i96 = 0;
        i3 = measure-BRTryo0;
        equal = f3.size();
        final int i125 = i49;
        labelHorizontalPaddingOffset = i24;
        while (labelHorizontalPaddingOffset < equal) {
            $this$fastFirstOrNull$iv = 0;
            i20 = 0;
            labelHorizontalPaddingOffset = i11 + 1;
            equal = i17;
        }
        i11 = labelHorizontalPaddingOffset;
        i15 = 0;
        int i42 = i15;
        if ((Measurable)i42 != 0) {
            measure-BRTryo02 = (Measurable)i42.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(relaxedConstraints, 0, MathHelpersKt.lerp(i76 -= i49, -i49, supportingPlaceable.animationProgress)));
        } else {
            measure-BRTryo02 = 0;
        }
        if (measure-BRTryo02 != 0) {
            companion = measure-BRTryo02;
            int i86 = 0;
            zero-NH-jbRc = SizeKt.Size((float)width3, (float)height);
        } else {
            zero-NH-jbRc = Size.Companion.getZero-NH-jbRc();
        }
        supportingPlaceable.onLabelMeasured.invoke(Size.box-impl(zero-NH-jbRc));
        int i50 = measurables;
        int i82 = 0;
        int i87 = i50;
        int i92 = 0;
        final int i126 = measure-BRTryo02;
        equal5 = i87.size();
        int i99 = i50;
        $this$fastFirstOrNull$iv2 = i27;
        while ($this$fastFirstOrNull$iv2 < equal5) {
            $this$fastFirstOrNull$iv = 0;
            i20 = 0;
            $this$fastFirstOrNull$iv2 = i11 + 1;
            equal5 = i17;
        }
        i11 = $this$fastFirstOrNull$iv2;
        i15 = 0;
        int i43 = i15;
        if ((Measurable)i43 != 0) {
            minIntrinsicHeight = (Measurable)i43.minIntrinsicHeight(Constraints.getMinWidth-impl(constraints));
        } else {
            minIntrinsicHeight = 0;
        }
        final int i128 = i84;
        i89 -= i127;
        final int i129 = relaxedConstraints3;
        long copy-Zbe2FdA$default3 = Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U(constraints, relaxedConstraints3, -occupiedSpaceHorizontally3), i27, 0, 0, 0, 0, 11);
        int i106 = 0;
        final int i130 = occupiedSpaceHorizontally3;
        size = measurables.size();
        i7 = i25;
        relaxedConstraints3 = "Collection contains no element matching the predicate.";
        while (i7 < size) {
            int i32 = i28;
            i = obj6;
            i26 = 0;
            i11 = 0;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable)i), "TextField")) {
                break;
            } else {
            }
            supportingMeasurable = i43;
            l = copy-Zbe2FdA$default3;
            l3 = prefixPlaceable;
            Placeable labelConstraints4 = placeable;
            long leadingPlaceable4 = l3;
            i7 = i13 + 1;
            supportingPlaceable = this;
            measureScope = $this$measure_u2d3p2s80s;
            size = i25;
            i28 = i30;
            labelConstraints = i23;
            i3 = i9;
            prefixPlaceable = l3;
            relaxedConstraints = l2;
            relaxedConstraints3 = "Collection contains no element matching the predicate.";
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException(relaxedConstraints3);
        throw noSuchElementException;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        return intrinsicHeight($this$minIntrinsicHeight, measurables, width, (Function2)OutlinedTextFieldMeasurePolicy.minIntrinsicHeight.1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        return intrinsicWidth($this$minIntrinsicWidth, measurables, height, (Function2)OutlinedTextFieldMeasurePolicy.minIntrinsicWidth.1.INSTANCE);
    }
}
