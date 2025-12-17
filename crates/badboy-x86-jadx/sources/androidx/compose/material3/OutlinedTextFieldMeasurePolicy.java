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
        boolean equal2;
        int $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$placeholderHeight$2;
        int equal;
        int $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2;
        boolean equal4;
        Object equal5;
        Object obj5;
        int invoke2;
        Object $this$fastFirstOrNull$iv2;
        int layoutId2;
        Object invoke3;
        int prefixHeight;
        int intValue;
        int $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$leadingHeight$2;
        int maxIntrinsicWidth;
        int i7;
        int invoke;
        int obj6;
        int i6;
        int index$iv$iv5;
        int maxIntrinsicWidth2;
        int index$iv$iv6;
        int index$iv$iv9;
        int index$iv$iv7;
        boolean equal3;
        int index$iv$iv3;
        int index$iv$iv2;
        int index$iv$iv8;
        int index$iv$iv4;
        int index$iv$iv;
        Object obj2;
        int size2;
        int size;
        Object obj4;
        int i4;
        Object obj;
        int i8;
        Object layoutId;
        Object placeholderHeight;
        int trailingHeight;
        boolean $this$fastFirstOrNull$iv;
        int i5;
        int i2;
        Object obj3;
        int i;
        int i3;
        final Object obj7 = this;
        final Object obj8 = intrinsicMeasurer;
        int i9 = 0;
        layoutId2 = 0;
        Object obj10 = obj9;
        invoke = 0;
        index$iv$iv5 = 0;
        while (index$iv$iv5 < obj10.size()) {
            i4 = 0;
            i8 = 0;
            index$iv$iv5++;
        }
        obj4 = 0;
        if ((IntrinsicMeasurable)obj4 != 0) {
            int i21 = 0;
            remainingWidth = i27;
            $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$leadingHeight$2 = (Number)obj8.invoke(obj4, Integer.valueOf(width)).intValue();
        } else {
            $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$leadingHeight$2 = 0;
        }
        int i22 = 0;
        int i28 = maxIntrinsicWidth;
        int i31 = 0;
        index$iv$iv3 = 0;
        while (index$iv$iv3 < i28.size()) {
            obj = null;
            layoutId = null;
            index$iv$iv3++;
            equal = Integer.MAX_VALUE;
        }
        i4 = 0;
        if ((IntrinsicMeasurable)i4 != 0) {
            int i14 = 0;
            remainingWidth = i19;
            $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2 = (Number)obj8.invoke(i4, Integer.valueOf(width)).intValue();
        } else {
            $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2 = 0;
        }
        int i20 = 0;
        Object obj11 = invoke3;
        int i29 = 0;
        index$iv$iv6 = 0;
        while (index$iv$iv6 < obj11.size()) {
            i4 = 0;
            i8 = 0;
            index$iv$iv6++;
            $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2 = trailingHeight;
        }
        trailingHeight = $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2;
        obj4 = 0;
        if ((IntrinsicMeasurable)obj4 != 0) {
            int i13 = 0;
            i5 = $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2;
        } else {
            i7 = width;
            i5 = 0;
        }
        int i15 = 0;
        obj6 = equal4;
        maxIntrinsicWidth2 = 0;
        index$iv$iv9 = 0;
        while (index$iv$iv9 < obj6.size()) {
            i4 = 0;
            i8 = 0;
            index$iv$iv9++;
            equal4 = $this$fastFirstOrNull$iv;
        }
        $this$fastFirstOrNull$iv = equal4;
        obj4 = 0;
        if ((IntrinsicMeasurable)obj4 != 0) {
            equal4 = 0;
            prefixHeight = (Number)obj8.invoke((IntrinsicMeasurable)obj4, Integer.valueOf(remainingWidth)).intValue();
            remainingWidth = obj6;
        } else {
            prefixHeight = 0;
        }
        i6 = 0;
        Object obj13 = equal5;
        int i32 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < obj13.size()) {
            obj = null;
            layoutId = null;
            index$iv$iv2++;
            equal5 = $this$fastFirstOrNull$iv;
            prefixHeight = i2;
        }
        $this$fastFirstOrNull$iv = equal5;
        i2 = prefixHeight;
        i4 = 0;
        if ((IntrinsicMeasurable)i4 != 0) {
            equal5 = 0;
            intValue = (Number)obj8.invoke((IntrinsicMeasurable)i4, Integer.valueOf(remainingWidth)).intValue();
            remainingWidth = i6;
        } else {
            intValue = 0;
        }
        int i24 = 0;
        Object obj14 = obj5;
        int i33 = 0;
        index$iv$iv8 = 0;
        while (index$iv$iv8 < obj14.size()) {
            i4 = obj4;
            obj = null;
            layoutId = null;
            i3 = remainingWidth;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)i4), "TextField")) {
                break;
            } else {
            }
            index$iv$iv8++;
            obj5 = placeholderHeight;
            remainingWidth = i3;
        }
        int remainingWidth2 = remainingWidth;
        Object obj16 = obj5;
        NoSuchElementException noSuchElementException = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private final int intrinsicWidth(IntrinsicMeasureScope $this$intrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        boolean $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicWidth$trailingWidth$2;
        boolean $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicWidth$leadingWidth$2;
        int $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicWidth$prefixWidth$2;
        int $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicWidth$suffixWidth$2;
        int $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicWidth$placeholderWidth$2;
        int $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicWidth$labelWidth$2;
        String $this$fastFirstOrNull$iv4;
        int $i$f$fastFirstOrNull;
        int leadingWidth;
        int $i$f$fastFirstOrNull3;
        int $i$f$fastFirstOrNull2;
        Object invoke;
        int i8;
        int i;
        int index$iv$iv4;
        int index$iv$iv5;
        int i3;
        Object obj;
        int i6;
        Object equal;
        int index$iv$iv7;
        int index$iv$iv2;
        String $this$fastForEach$iv$iv;
        int it;
        int i7;
        int index$iv$iv3;
        int index$iv$iv6;
        boolean it2;
        int index$iv$iv;
        int i2;
        Object layoutId2;
        String str;
        Object layoutId;
        String $this$fastFirstOrNull$iv2;
        int $this$fastFirstOrNull$iv;
        int i5;
        int $this$fastFirstOrNull$iv3;
        int i4;
        final Object obj2 = this;
        final Object obj3 = intrinsicMeasurer;
        int i15 = 0;
        boolean z2 = z;
        int i19 = 0;
        index$iv$iv4 = 0;
        while (index$iv$iv4 < z2.size()) {
            equal = obj;
            i7 = 0;
            i2 = 0;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)equal), "TextField")) {
                break;
            } else {
            }
            index$iv$iv4++;
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
        int equal4;
        int size;
        int equal6;
        int measure-BRTryo02;
        int totalHeight;
        int equal;
        int measure-BRTryo03;
        int equal3;
        int equal7;
        int measure-BRTryo05;
        int equal5;
        int measure-BRTryo0;
        int equal2;
        int supportingMeasurable2;
        int i21;
        int leadingPlaceable;
        int $i$f$fastFirstOrNull2;
        int $i$f$fastFirstOrNull;
        int labelHorizontalPaddingOffset;
        Size.Companion companion;
        int $this$fastFirstOrNull$iv;
        int i29;
        int $this$fastFirstOrNull$iv3;
        int measure-BRTryo04;
        int relaxedConstraints2;
        int i19;
        Placeable placeable;
        long relaxedConstraints;
        long copy-Zbe2FdA$default;
        int index$iv$iv3;
        int i24;
        int index$iv$iv;
        int index$iv$iv4;
        long prefixPlaceable;
        int index$iv$iv2;
        int i23;
        Object layoutId;
        int size2;
        long $i$a$LetOutlinedTextFieldMeasurePolicy$measure$labelSize$1;
        int minIntrinsicHeight;
        long textFieldPlaceable;
        Object obj2;
        int i8;
        int i16;
        Object supportingPlaceable;
        MeasureScope measureScope;
        Object obj4;
        long relaxedConstraints3;
        float f2;
        int i25;
        int i18;
        Object obj3;
        Object obj;
        int i3;
        int i10;
        int i5;
        int i12;
        PaddingValues i20;
        int $this$fastFirstOrNull$iv4;
        int i6;
        int $this$fastFirstOrNull$iv2;
        int i11;
        int i9;
        int i27;
        int i26;
        int i22;
        int i2;
        int i17;
        int supportingMeasurable;
        int i4;
        int i14;
        float f;
        int i28;
        float f3;
        int i30;
        float density2;
        float density;
        int i;
        PaddingValues paddingValues;
        int labelConstraints;
        int i15;
        long l;
        Placeable supportingConstraints;
        int i7;
        long l3;
        int i13;
        long l2;
        supportingPlaceable = this;
        measureScope = $this$measure_u2d3p2s80s;
        equal4 = 0;
        final int roundToPx-0680j_44 = measureScope.roundToPx-0680j_4(supportingPlaceable.paddingValues.calculateBottomPadding-D9Ej5fM());
        int i62 = 0;
        long copy-Zbe2FdA$default2 = Constraints.copy-Zbe2FdA$default(constraints, obj3, 0, i62, 0, 0, 10);
        int i48 = 0;
        int i66 = i40;
        int i72 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < i66.size()) {
            i25 = 0;
            i5 = 0;
            index$iv$iv++;
            equal4 = $this$fastFirstOrNull$iv4;
        }
        $this$fastFirstOrNull$iv4 = equal4;
        obj4 = 0;
        if ((Measurable)obj4 != 0) {
            leadingPlaceable = equal4;
        } else {
            leadingPlaceable = 0;
        }
        widthOrZero += $this$fastFirstOrNull$iv4;
        int i67 = 0;
        int i73 = equal;
        int i75 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < i73.size()) {
            i25 = 0;
            i5 = 0;
            index$iv$iv2++;
            equal = $this$fastFirstOrNull$iv4;
            leadingPlaceable = labelConstraints;
        }
        $this$fastFirstOrNull$iv4 = equal;
        labelConstraints = leadingPlaceable;
        obj4 = 0;
        measure-BRTryo03 = obj4;
        if ((Measurable)measure-BRTryo03 != 0) {
            relaxedConstraints2 = measure-BRTryo03;
        } else {
            relaxedConstraints3 = copy-Zbe2FdA$default2;
            relaxedConstraints2 = 0;
        }
        i31 += widthOrZero2;
        $i$f$fastFirstOrNull2 = 0;
        int i63 = equal3;
        int i68 = 0;
        index$iv$iv3 = 0;
        while (index$iv$iv3 < i63.size()) {
            obj2 = null;
            i5 = 0;
            index$iv$iv3++;
            equal3 = $this$fastFirstOrNull$iv4;
            $i$f$fastFirstOrNull2 = $this$fastFirstOrNull$iv2;
        }
        $this$fastFirstOrNull$iv4 = equal3;
        $this$fastFirstOrNull$iv2 = $i$f$fastFirstOrNull2;
        size2 = 0;
        if ((Measurable)size2 != 0) {
            placeable = equal3;
        } else {
            placeable = 0;
        }
        occupiedSpaceHorizontally += widthOrZero3;
        $i$f$fastFirstOrNull = 0;
        int i69 = equal7;
        index$iv$iv4 = 0;
        while (index$iv$iv4 < i69.size()) {
            obj = 0;
            $this$fastFirstOrNull$iv4 = 0;
            index$iv$iv4++;
            equal7 = $this$fastFirstOrNull$iv2;
            $i$f$fastFirstOrNull = i26;
        }
        $this$fastFirstOrNull$iv2 = equal7;
        i26 = $i$f$fastFirstOrNull;
        obj2 = 0;
        if ((Measurable)obj2 != null) {
            relaxedConstraints = relaxedConstraints3;
            measure-BRTryo05 = (Measurable)obj2.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(relaxedConstraints3, i25, -occupiedSpaceHorizontally2, 0, 2));
        } else {
            relaxedConstraints = relaxedConstraints3;
            measure-BRTryo05 = 0;
        }
        occupiedSpaceHorizontally2 += widthOrZero4;
        roundToPx-0680j_4 += roundToPx-0680j_42;
        i23 = -roundToPx-0680j_44;
        i8 = 0;
        f2 = i81;
        int i96 = 0;
        i15 = measure-BRTryo05;
        equal5 = f2.size();
        final int i125 = i49;
        labelHorizontalPaddingOffset = i3;
        while (labelHorizontalPaddingOffset < equal5) {
            $this$fastFirstOrNull$iv4 = 0;
            i26 = 0;
            labelHorizontalPaddingOffset = i14 + 1;
            equal5 = i17;
        }
        i14 = labelHorizontalPaddingOffset;
        i5 = 0;
        int i42 = i5;
        if ((Measurable)i42 != 0) {
            measure-BRTryo0 = (Measurable)i42.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(relaxedConstraints, 0, MathHelpersKt.lerp(i76 -= i49, -i49, supportingPlaceable.animationProgress)));
        } else {
            measure-BRTryo0 = 0;
        }
        if (measure-BRTryo0 != 0) {
            companion = measure-BRTryo0;
            int i86 = 0;
            $i$a$LetOutlinedTextFieldMeasurePolicy$measure$labelSize$1 = SizeKt.Size((float)width3, (float)height);
        } else {
            $i$a$LetOutlinedTextFieldMeasurePolicy$measure$labelSize$1 = Size.Companion.getZero-NH-jbRc();
        }
        supportingPlaceable.onLabelMeasured.invoke(Size.box-impl($i$a$LetOutlinedTextFieldMeasurePolicy$measure$labelSize$1));
        int i50 = measurables;
        int i82 = 0;
        int i87 = i50;
        int i92 = 0;
        final int i126 = measure-BRTryo0;
        equal2 = i87.size();
        int i99 = i50;
        $this$fastFirstOrNull$iv = i18;
        while ($this$fastFirstOrNull$iv < equal2) {
            $this$fastFirstOrNull$iv4 = 0;
            i26 = 0;
            $this$fastFirstOrNull$iv = i14 + 1;
            equal2 = i17;
        }
        i14 = $this$fastFirstOrNull$iv;
        i5 = 0;
        int i43 = i5;
        if ((Measurable)i43 != 0) {
            minIntrinsicHeight = (Measurable)i43.minIntrinsicHeight(Constraints.getMinWidth-impl(constraints));
        } else {
            minIntrinsicHeight = 0;
        }
        final int i128 = i84;
        i89 -= i127;
        final int i129 = relaxedConstraints2;
        long copy-Zbe2FdA$default3 = Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U(constraints, relaxedConstraints2, -occupiedSpaceHorizontally3), i18, 0, 0, 0, 0, 11);
        int i106 = 0;
        final int i130 = occupiedSpaceHorizontally3;
        size = measurables.size();
        i29 = i6;
        relaxedConstraints2 = "Collection contains no element matching the predicate.";
        while (i29 < size) {
            int i32 = i10;
            i11 = obj6;
            i22 = 0;
            i14 = 0;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable)i11), "TextField")) {
                break;
            } else {
            }
            supportingMeasurable = i43;
            l = copy-Zbe2FdA$default3;
            l2 = prefixPlaceable;
            Placeable labelConstraints4 = placeable;
            long leadingPlaceable4 = l2;
            i29 = i30 + 1;
            supportingPlaceable = this;
            measureScope = $this$measure_u2d3p2s80s;
            size = i6;
            i10 = i28;
            labelConstraints = i24;
            i15 = i23;
            prefixPlaceable = l2;
            relaxedConstraints = l3;
            relaxedConstraints2 = "Collection contains no element matching the predicate.";
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException(relaxedConstraints2);
        throw noSuchElementException;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        return intrinsicHeight($this$minIntrinsicHeight, measurables, width, (Function2)OutlinedTextFieldMeasurePolicy.minIntrinsicHeight.1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        return intrinsicWidth($this$minIntrinsicWidth, measurables, height, (Function2)OutlinedTextFieldMeasurePolicy.minIntrinsicWidth.1.INSTANCE);
    }
}
