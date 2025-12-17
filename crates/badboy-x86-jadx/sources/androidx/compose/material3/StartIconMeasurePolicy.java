package androidx.compose.material3;

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
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B+\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0008\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\"\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\"\u0010\u0018\u001a\u00020\u0012*\u00020\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J,\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000c\u0010\rR\u0019\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000f\u0010\rR\u0019\u0010\u0008\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u0010\u0010\r\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\"", d2 = {"Landroidx/compose/material3/StartIconMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "animationProgress", "Lkotlin/Function0;", "", "indicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "indicatorVerticalPadding", "startIconToLabelHorizontalPadding", "(Lkotlin/jvm/functions/Function0;FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnimationProgress", "()Lkotlin/jvm/functions/Function0;", "getIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getIndicatorVerticalPadding-D9Ej5fM", "getStartIconToLabelHorizontalPadding-D9Ej5fM", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StartIconMeasurePolicy implements MeasurePolicy {

    private final Function0<Float> animationProgress;
    private final float indicatorHorizontalPadding;
    private final float indicatorVerticalPadding;
    private final float startIconToLabelHorizontalPadding;
    private StartIconMeasurePolicy(Function0<Float> animationProgress, float indicatorHorizontalPadding, float indicatorVerticalPadding, float startIconToLabelHorizontalPadding) {
        super();
        this.animationProgress = animationProgress;
        this.indicatorHorizontalPadding = indicatorHorizontalPadding;
        this.indicatorVerticalPadding = indicatorVerticalPadding;
        this.startIconToLabelHorizontalPadding = startIconToLabelHorizontalPadding;
    }

    public StartIconMeasurePolicy(Function0 function0, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(function0, f2, f3, f4);
    }

    public final Function0<Float> getAnimationProgress() {
        return this.animationProgress;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final float getIndicatorHorizontalPadding-D9Ej5fM() {
        return this.indicatorHorizontalPadding;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final float getIndicatorVerticalPadding-D9Ej5fM() {
        return this.indicatorVerticalPadding;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final float getStartIconToLabelHorizontalPadding-D9Ej5fM() {
        return this.startIconToLabelHorizontalPadding;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        int index$iv$iv;
        int index$iv$iv2;
        String str2;
        Object obj;
        Object obj2;
        int i2;
        boolean it;
        int i3;
        int i;
        Object obj3;
        Object layoutId;
        String layoutId2;
        String str;
        final int i4 = width;
        int i5 = 0;
        Object obj6 = obj4;
        int i7 = 0;
        index$iv$iv = 0;
        str2 = "Collection contains no element matching the predicate.";
        while (index$iv$iv < obj6.size()) {
            obj2 = obj;
            i2 = 0;
            i = 0;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)obj2), "icon")) {
                break;
            } else {
            }
            i3 = this;
            obj3 = $this$maxIntrinsicHeight;
            index$iv$iv++;
            str2 = "Collection contains no element matching the predicate.";
        }
        int i14 = this;
        Object obj10 = $this$maxIntrinsicHeight;
        NoSuchElementException $this$fastForEach$iv$iv = new NoSuchElementException(str2);
        throw $this$fastForEach$iv$iv;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        int maxIntrinsicWidth;
        int index$iv$iv;
        int index$iv$iv2;
        String str;
        Object obj;
        Object obj2;
        int i3;
        boolean it;
        int i2;
        int i4;
        Object layoutId;
        String layoutId2;
        int i;
        final Object obj3 = this;
        final int i5 = height;
        int i7 = 0;
        Object obj6 = obj4;
        int i12 = 0;
        index$iv$iv = 0;
        str = "Collection contains no element matching the predicate.";
        while (index$iv$iv < obj6.size()) {
            obj2 = obj;
            i3 = 0;
            i4 = 0;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)obj2), "icon")) {
                break;
            } else {
            }
            i2 = $this$maxIntrinsicWidth;
            index$iv$iv++;
            str = "Collection contains no element matching the predicate.";
        }
        int i18 = $this$maxIntrinsicWidth;
        NoSuchElementException $this$fastForEach$iv$iv = new NoSuchElementException(str);
        throw $this$fastForEach$iv$iv;
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        Object obj2;
        int size2;
        int size;
        int i6;
        int i15;
        int labelPlaceable;
        int labelPlaceable2;
        int i;
        Placeable animatedIndicatorWidth;
        int iconPlaceable;
        int index$iv$iv2;
        int index$iv$iv;
        int index$iv$iv3;
        String str;
        Object placeable;
        long l;
        int i3;
        int i5;
        int i11;
        Placeable animatedIndicatorWidth2;
        int i9;
        int i7;
        int i4;
        int i13;
        int i10;
        Placeable placeable2;
        int i12;
        int i14;
        int i8;
        int i2;
        final Object obj = this;
        obj2 = $this$measure_u2d3p2s80s;
        final int i58 = 0;
        final int i60 = 0;
        long copy-Zbe2FdA$default = Constraints.copy-Zbe2FdA$default(constraints, obj11, 0, i58, 0, i60, 10);
        int i31 = 0;
        int i37 = 0;
        long l3 = offset-NN6Ew-U;
        i = 0;
        int i33 = i6;
        int i38 = 0;
        index$iv$iv2 = 0;
        str = "Collection contains no element matching the predicate.";
        while (index$iv$iv2 < i33.size()) {
            l = placeable;
            i3 = 0;
            i9 = 0;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable)l), "icon")) {
                break;
            } else {
            }
            index$iv$iv2++;
            obj2 = $this$measure_u2d3p2s80s;
            i6 = i4;
            i = i10;
            str = "Collection contains no element matching the predicate.";
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException(str);
        throw noSuchElementException;
    }
}
