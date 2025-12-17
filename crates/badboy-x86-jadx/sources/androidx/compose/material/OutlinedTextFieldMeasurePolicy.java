package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
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
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u0001B1\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ<\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J<\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000e2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015H\u0002J\"\u0010\u0018\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010\u0019\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J,\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!J\"\u0010\"\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\"\u0010#\u001a\u00020\u000e*\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006$", d2 = {"Landroidx/compose/material/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Lkotlin/jvm/functions/Function1;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    public static final float access$getAnimationProgress$p(androidx.compose.material.OutlinedTextFieldMeasurePolicy $this) {
        return $this.animationProgress;
    }

    public static final PaddingValues access$getPaddingValues$p(androidx.compose.material.OutlinedTextFieldMeasurePolicy $this) {
        return $this.paddingValues;
    }

    public static final boolean access$getSingleLine$p(androidx.compose.material.OutlinedTextFieldMeasurePolicy $this) {
        return $this.singleLine;
    }

    private final int intrinsicHeight(IntrinsicMeasureScope $this$intrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        int remainingWidth;
        boolean equal;
        int intValue2;
        int intValue;
        int i5;
        int $i$f$fastFirstOrNull;
        int layoutId2;
        int $i$f$fastFirstOrNull2;
        int intValue3;
        int intValue4;
        int i10;
        int invoke;
        int index$iv$iv4;
        int i;
        boolean equal2;
        int index$iv$iv2;
        int i8;
        Object obj2;
        int index$iv$iv5;
        int i6;
        Object obj3;
        int size;
        int index$iv$iv3;
        int index$iv$iv;
        int i7;
        Object obj;
        int i9;
        Object layoutId;
        int $this$fastFirstOrNull$iv2;
        int i2;
        int i4;
        int $this$fastFirstOrNull$iv;
        int i3;
        final Object obj4 = this;
        final Object obj5 = intrinsicMeasurer;
        int i11 = 0;
        layoutId2 = 0;
        int i18 = i13;
        invoke = 0;
        index$iv$iv4 = 0;
        while (index$iv$iv4 < i18.size()) {
            i7 = 0;
            i9 = 0;
            index$iv$iv4++;
        }
        obj3 = 0;
        if ((IntrinsicMeasurable)obj3 != null) {
            int i21 = 0;
            remainingWidth = OutlinedTextFieldKt.access$substractConstraintSafely(width, (IntrinsicMeasurable)obj3.maxIntrinsicWidth(Integer.MAX_VALUE));
            intValue4 = (Number)obj5.invoke(obj3, Integer.valueOf(width)).intValue();
        } else {
            intValue4 = 0;
        }
        int i23 = 0;
        int i24 = i19;
        int i27 = 0;
        index$iv$iv5 = 0;
        while (index$iv$iv5 < i24.size()) {
            i9 = 0;
            $this$fastFirstOrNull$iv2 = 0;
            index$iv$iv5++;
            intValue2 = Integer.MAX_VALUE;
        }
        obj = 0;
        if ((IntrinsicMeasurable)obj != null) {
            int i15 = 0;
            remainingWidth = OutlinedTextFieldKt.access$substractConstraintSafely(remainingWidth, (IntrinsicMeasurable)obj.maxIntrinsicWidth(Integer.MAX_VALUE));
            i = intValue2;
        } else {
            i = 0;
        }
        $i$f$fastFirstOrNull2 = 0;
        int i20 = intValue;
        int i25 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < i20.size()) {
            obj = null;
            layoutId = null;
            index$iv$iv2++;
            intValue = $this$fastFirstOrNull$iv2;
            $i$f$fastFirstOrNull2 = i2;
        }
        $this$fastFirstOrNull$iv2 = intValue;
        i2 = $i$f$fastFirstOrNull2;
        i7 = 0;
        if ((IntrinsicMeasurable)i7 != 0) {
            int i14 = 0;
            i8 = intValue;
        } else {
            i10 = width;
            i8 = 0;
        }
        int i16 = 0;
        int i26 = i5;
        int i28 = 0;
        index$iv$iv3 = 0;
        while (index$iv$iv3 < i26.size()) {
            i9 = obj;
            layoutId = null;
            i2 = 0;
            i4 = remainingWidth;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)i9), "TextField")) {
                break;
            } else {
            }
            index$iv$iv3++;
            remainingWidth = i4;
            i5 = $this$fastFirstOrNull$iv;
        }
        int remainingWidth2 = remainingWidth;
        int i30 = i5;
        NoSuchElementException noSuchElementException = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private final int intrinsicWidth(IntrinsicMeasureScope $this$intrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        boolean intValue4;
        boolean intValue2;
        int intValue3;
        int intValue;
        String $this$fastFirstOrNull$iv;
        int $i$f$fastFirstOrNull;
        int leadingWidth;
        Object invoke;
        int i3;
        int index$iv$iv2;
        int i2;
        int index$iv$iv5;
        int i5;
        Object obj;
        Object equal;
        int index$iv$iv3;
        int index$iv$iv;
        Object $i$f$fastForEach;
        int i;
        int index$iv$iv4;
        boolean it;
        int i6;
        Object layoutId2;
        String str;
        Object layoutId;
        String $this$fastFirstOrNull$iv3;
        int $this$fastFirstOrNull$iv2;
        int i4;
        final Object obj2 = this;
        final Object obj3 = intrinsicMeasurer;
        int i11 = 0;
        boolean z2 = z;
        int i15 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < z2.size()) {
            equal = obj;
            i = 0;
            i6 = 0;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)equal), "TextField")) {
                break;
            } else {
            }
            index$iv$iv2++;
        }
        NoSuchElementException $this$fastForEach$iv$iv = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw $this$fastForEach$iv$iv;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        return intrinsicHeight($this$maxIntrinsicHeight, measurables, width, (Function2)OutlinedTextFieldMeasurePolicy.maxIntrinsicHeight.1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        return intrinsicWidth($this$maxIntrinsicWidth, measurables, height, (Function2)OutlinedTextFieldMeasurePolicy.maxIntrinsicWidth.1.INSTANCE);
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        int size;
        int equal;
        Placeable measure-BRTryo0;
        int height;
        int equal3;
        int equal2;
        int relaxedConstraints3;
        Placeable measure-BRTryo03;
        int labelPlaceable;
        int $this$fastFirstOrNull$iv;
        long relaxedConstraints;
        Object companion;
        int i18;
        int i14;
        long measure-BRTryo02;
        int i19;
        int i8;
        int i;
        int i12;
        long offset-NN6Ew-U2;
        int i23;
        int i2;
        int index$iv$iv4;
        int i3;
        Object trailingPlaceable;
        int index$iv$iv5;
        float i10;
        int i4;
        Object layoutId;
        long zero-NH-jbRc;
        float f;
        long l;
        int i11;
        int index$iv$iv2;
        int i7;
        int index$iv$iv3;
        int i22;
        int i9;
        int index$iv$iv;
        int i5;
        float f3;
        float f2;
        int occupiedSpaceHorizontally;
        long l3;
        int i15;
        float density;
        int i13;
        PaddingValues paddingValues;
        int labelHorizontalPaddingOffset;
        int relaxedConstraints2;
        long offset-NN6Ew-U;
        long l2;
        int i20;
        int i26;
        int i25;
        int i17;
        int i21;
        int occupiedSpaceHorizontally2;
        int i6;
        int i16;
        int i24;
        Placeable placeable;
        Placeable placeable2;
        trailingPlaceable = this;
        MeasureScope measureScope = $this$measure_u2d3p2s80s;
        equal3 = 0;
        final int roundToPx-0680j_44 = measureScope.roundToPx-0680j_4(trailingPlaceable.paddingValues.calculateBottomPadding-D9Ej5fM());
        int i45 = 0;
        int i48 = i42;
        int i52 = 0;
        index$iv$iv4 = 0;
        while (index$iv$iv4 < i48.size()) {
            i7 = 0;
            i9 = 0;
            index$iv$iv4++;
            equal3 = occupiedSpaceHorizontally;
        }
        occupiedSpaceHorizontally = equal3;
        i11 = 0;
        if ((Measurable)i11 != 0) {
            equal2 = (Measurable)i11.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(constraints, obj13, 0, 0, 0, 0, 10));
        } else {
            equal2 = 0;
        }
        int i54 = occupiedSpaceHorizontally + widthOrZero2;
        i = 0;
        i12 = i43;
        i23 = 0;
        index$iv$iv5 = 0;
        while (index$iv$iv5 < i12.size()) {
            i7 = 0;
            i9 = 0;
            index$iv$iv5++;
            relaxedConstraints = occupiedSpaceHorizontally;
            equal2 = labelHorizontalPaddingOffset;
        }
        labelHorizontalPaddingOffset = equal2;
        occupiedSpaceHorizontally = relaxedConstraints;
        i11 = 0;
        if ((Measurable)i11 != 0) {
            i = 0;
            relaxedConstraints = occupiedSpaceHorizontally;
            relaxedConstraints3 = relaxedConstraints;
            i8 = measure-BRTryo02;
        } else {
            relaxedConstraints3 = occupiedSpaceHorizontally;
            i8 = 0;
        }
        widthOrZero += i54;
        roundToPx-0680j_4 += roundToPx-0680j_42;
        i2 = -roundToPx-0680j_44;
        i10 = 0;
        int i66 = i3;
        index$iv$iv2 = 0;
        int size4 = i66.size();
        while (index$iv$iv2 < size4) {
            occupiedSpaceHorizontally = 0;
            i13 = 0;
            index$iv$iv2++;
            relaxedConstraints3 = relaxedConstraints2;
        }
        relaxedConstraints2 = relaxedConstraints3;
        i9 = 0;
        int i31 = i9;
        if ((Measurable)i31 != 0) {
            measure-BRTryo03 = (Measurable)i31.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(relaxedConstraints3, relaxedConstraints, MathHelpersKt.lerp(i49 -= i46, -i46, trailingPlaceable.animationProgress)));
        } else {
            measure-BRTryo03 = 0;
        }
        if (measure-BRTryo03 != null) {
            companion = measure-BRTryo03;
            i3 = 0;
            zero-NH-jbRc = SizeKt.Size((float)width3, (float)height5);
        } else {
            zero-NH-jbRc = Size.Companion.getZero-NH-jbRc();
        }
        trailingPlaceable.onLabelMeasured.invoke(Size.box-impl(zero-NH-jbRc));
        long copy-Zbe2FdA$default = Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U(constraints, 0, -i19), obj29, 0, 0, 0, 0, 11);
        int i57 = 0;
        int i63 = i18;
        int i71 = 0;
        size = i63.size();
        placeable = measure-BRTryo03;
        labelPlaceable = index$iv$iv;
        String $this$fastFirst$iv = "Collection contains no element matching the predicate.";
        while (labelPlaceable < size) {
            i15 = occupiedSpaceHorizontally;
            i13 = 0;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable)i15), "TextField")) {
                break;
            } else {
            }
            occupiedSpaceHorizontally2 = i19;
            int i60 = i8;
            offset-NN6Ew-U = copy-Zbe2FdA$default;
            int leadingPlaceable = i46;
            labelPlaceable = i26 + 1;
            f = constraints;
            i18 = index$iv$iv;
            size = i20;
            trailingPlaceable = this;
            labelHorizontalPaddingOffset = i2;
            offset-NN6Ew-U2 = i16;
            placeable = placeable2;
            $this$fastFirst$iv = "Collection contains no element matching the predicate.";
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException($this$fastFirst$iv);
        throw noSuchElementException;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        return intrinsicHeight($this$minIntrinsicHeight, measurables, width, (Function2)OutlinedTextFieldMeasurePolicy.minIntrinsicHeight.1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        return intrinsicWidth($this$minIntrinsicWidth, measurables, height, (Function2)OutlinedTextFieldMeasurePolicy.minIntrinsicWidth.1.INSTANCE);
    }
}
