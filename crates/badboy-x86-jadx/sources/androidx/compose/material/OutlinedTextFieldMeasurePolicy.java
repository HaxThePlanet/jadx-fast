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
        int $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$trailingHeight$2;
        int $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2;
        int i4;
        int $i$f$fastFirstOrNull;
        int layoutId2;
        int $i$f$fastFirstOrNull2;
        int intValue;
        int $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$leadingHeight$2;
        int i3;
        int invoke;
        int index$iv$iv4;
        int i8;
        boolean equal2;
        int index$iv$iv2;
        int i6;
        Object obj2;
        int index$iv$iv5;
        int i10;
        Object obj;
        int size;
        int index$iv$iv3;
        int index$iv$iv;
        int i7;
        Object obj3;
        int i5;
        Object layoutId;
        int $this$fastFirstOrNull$iv;
        int i2;
        int i;
        int $this$fastFirstOrNull$iv2;
        int i9;
        final Object obj4 = this;
        final Object obj5 = intrinsicMeasurer;
        int i11 = 0;
        layoutId2 = 0;
        int i18 = i13;
        invoke = 0;
        index$iv$iv4 = 0;
        while (index$iv$iv4 < i18.size()) {
            i7 = 0;
            i5 = 0;
            index$iv$iv4++;
        }
        obj = 0;
        if ((IntrinsicMeasurable)obj != null) {
            int i21 = 0;
            remainingWidth = OutlinedTextFieldKt.access$substractConstraintSafely(width, (IntrinsicMeasurable)obj.maxIntrinsicWidth(Integer.MAX_VALUE));
            $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$leadingHeight$2 = (Number)obj5.invoke(obj, Integer.valueOf(width)).intValue();
        } else {
            $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$leadingHeight$2 = 0;
        }
        int i23 = 0;
        int i24 = i19;
        int i27 = 0;
        index$iv$iv5 = 0;
        while (index$iv$iv5 < i24.size()) {
            i5 = 0;
            $this$fastFirstOrNull$iv = 0;
            index$iv$iv5++;
            $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$trailingHeight$2 = Integer.MAX_VALUE;
        }
        obj3 = 0;
        if ((IntrinsicMeasurable)obj3 != null) {
            int i15 = 0;
            remainingWidth = OutlinedTextFieldKt.access$substractConstraintSafely(remainingWidth, (IntrinsicMeasurable)obj3.maxIntrinsicWidth(Integer.MAX_VALUE));
            i8 = $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$trailingHeight$2;
        } else {
            i8 = 0;
        }
        $i$f$fastFirstOrNull2 = 0;
        int i20 = $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2;
        int i25 = 0;
        index$iv$iv2 = 0;
        while (index$iv$iv2 < i20.size()) {
            obj3 = null;
            layoutId = null;
            index$iv$iv2++;
            $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2 = $this$fastFirstOrNull$iv;
            $i$f$fastFirstOrNull2 = i2;
        }
        $this$fastFirstOrNull$iv = $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2;
        i2 = $i$f$fastFirstOrNull2;
        i7 = 0;
        if ((IntrinsicMeasurable)i7 != 0) {
            int i14 = 0;
            i6 = $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicHeight$labelHeight$2;
        } else {
            i3 = width;
            i6 = 0;
        }
        int i16 = 0;
        int i26 = i4;
        int i28 = 0;
        index$iv$iv3 = 0;
        while (index$iv$iv3 < i26.size()) {
            i5 = obj3;
            layoutId = null;
            i2 = 0;
            i = remainingWidth;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)i5), "TextField")) {
                break;
            } else {
            }
            index$iv$iv3++;
            remainingWidth = i;
            i4 = $this$fastFirstOrNull$iv2;
        }
        int remainingWidth2 = remainingWidth;
        int i30 = i4;
        NoSuchElementException noSuchElementException = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private final int intrinsicWidth(IntrinsicMeasureScope $this$intrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        boolean $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicWidth$trailingWidth$2;
        boolean $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicWidth$leadingWidth$2;
        int $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicWidth$placeholderWidth$2;
        int $i$a$LetOutlinedTextFieldMeasurePolicy$intrinsicWidth$labelWidth$2;
        String $this$fastFirstOrNull$iv2;
        int $i$f$fastFirstOrNull;
        int leadingWidth;
        Object invoke;
        int i3;
        int index$iv$iv2;
        int i5;
        int index$iv$iv4;
        int i4;
        Object obj;
        Object equal;
        int index$iv$iv3;
        int index$iv$iv;
        Object $i$f$fastForEach;
        int i;
        int index$iv$iv5;
        boolean it;
        int i6;
        Object layoutId;
        String str;
        Object layoutId2;
        String $this$fastFirstOrNull$iv;
        int $this$fastFirstOrNull$iv3;
        int i2;
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
        int equal3;
        Placeable measure-BRTryo02;
        int height;
        int equal;
        int equal2;
        int relaxedConstraints2;
        Placeable measure-BRTryo03;
        int labelPlaceable;
        int $this$fastFirstOrNull$iv;
        long relaxedConstraints;
        Object companion;
        int i5;
        int i18;
        long measure-BRTryo0;
        int i26;
        int i9;
        int i8;
        int i3;
        long offset-NN6Ew-U;
        int i21;
        int i13;
        int index$iv$iv;
        int i19;
        Object trailingPlaceable;
        int index$iv$iv4;
        float i7;
        int i23;
        Object layoutId;
        long zero-NH-jbRc;
        float f3;
        long l;
        int i2;
        int index$iv$iv3;
        int i;
        int index$iv$iv2;
        int i10;
        int i24;
        int index$iv$iv5;
        int i6;
        float f;
        float f2;
        int occupiedSpaceHorizontally2;
        long l2;
        int i12;
        float density;
        int i22;
        PaddingValues paddingValues;
        int labelHorizontalPaddingOffset;
        int relaxedConstraints3;
        long offset-NN6Ew-U2;
        long l3;
        int i25;
        int i4;
        int i15;
        int i20;
        int i17;
        int occupiedSpaceHorizontally;
        int i14;
        int i11;
        int i16;
        Placeable placeable2;
        Placeable placeable;
        trailingPlaceable = this;
        MeasureScope measureScope = $this$measure_u2d3p2s80s;
        equal = 0;
        final int roundToPx-0680j_44 = measureScope.roundToPx-0680j_4(trailingPlaceable.paddingValues.calculateBottomPadding-D9Ej5fM());
        int i45 = 0;
        int i48 = i42;
        int i52 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < i48.size()) {
            i = 0;
            i24 = 0;
            index$iv$iv++;
            equal = occupiedSpaceHorizontally2;
        }
        occupiedSpaceHorizontally2 = equal;
        i2 = 0;
        if ((Measurable)i2 != 0) {
            equal2 = (Measurable)i2.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(constraints, obj13, 0, 0, 0, 0, 10));
        } else {
            equal2 = 0;
        }
        int i54 = occupiedSpaceHorizontally2 + widthOrZero2;
        i8 = 0;
        i3 = i43;
        i21 = 0;
        index$iv$iv4 = 0;
        while (index$iv$iv4 < i3.size()) {
            i = 0;
            i24 = 0;
            index$iv$iv4++;
            relaxedConstraints = occupiedSpaceHorizontally2;
            equal2 = labelHorizontalPaddingOffset;
        }
        labelHorizontalPaddingOffset = equal2;
        occupiedSpaceHorizontally2 = relaxedConstraints;
        i2 = 0;
        if ((Measurable)i2 != 0) {
            i8 = 0;
            relaxedConstraints = occupiedSpaceHorizontally2;
            relaxedConstraints2 = relaxedConstraints;
            i9 = measure-BRTryo0;
        } else {
            relaxedConstraints2 = occupiedSpaceHorizontally2;
            i9 = 0;
        }
        widthOrZero += i54;
        roundToPx-0680j_4 += roundToPx-0680j_42;
        i13 = -roundToPx-0680j_44;
        i7 = 0;
        int i66 = i19;
        index$iv$iv3 = 0;
        int size4 = i66.size();
        while (index$iv$iv3 < size4) {
            occupiedSpaceHorizontally2 = 0;
            i22 = 0;
            index$iv$iv3++;
            relaxedConstraints2 = relaxedConstraints3;
        }
        relaxedConstraints3 = relaxedConstraints2;
        i24 = 0;
        int i31 = i24;
        if ((Measurable)i31 != 0) {
            measure-BRTryo03 = (Measurable)i31.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(relaxedConstraints2, relaxedConstraints, MathHelpersKt.lerp(i49 -= i46, -i46, trailingPlaceable.animationProgress)));
        } else {
            measure-BRTryo03 = 0;
        }
        if (measure-BRTryo03 != null) {
            companion = measure-BRTryo03;
            i19 = 0;
            zero-NH-jbRc = SizeKt.Size((float)width3, (float)height5);
        } else {
            zero-NH-jbRc = Size.Companion.getZero-NH-jbRc();
        }
        trailingPlaceable.onLabelMeasured.invoke(Size.box-impl(zero-NH-jbRc));
        long copy-Zbe2FdA$default = Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U(constraints, 0, -i26), obj29, 0, 0, 0, 0, 11);
        int i57 = 0;
        int i63 = i5;
        int i71 = 0;
        size = i63.size();
        placeable2 = measure-BRTryo03;
        labelPlaceable = index$iv$iv5;
        String $this$fastFirst$iv = "Collection contains no element matching the predicate.";
        while (labelPlaceable < size) {
            i12 = occupiedSpaceHorizontally2;
            i22 = 0;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable)i12), "TextField")) {
                break;
            } else {
            }
            occupiedSpaceHorizontally = i26;
            int i60 = i9;
            offset-NN6Ew-U2 = copy-Zbe2FdA$default;
            int leadingPlaceable = i46;
            labelPlaceable = i4 + 1;
            f3 = constraints;
            i5 = index$iv$iv5;
            size = i25;
            trailingPlaceable = this;
            labelHorizontalPaddingOffset = i13;
            offset-NN6Ew-U = i11;
            placeable2 = placeable;
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
