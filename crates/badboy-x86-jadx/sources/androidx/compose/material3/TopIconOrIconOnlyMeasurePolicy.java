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
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0006\u0010\n\u001a\u00020\u0008\u0012\u0006\u0010\u000b\u001a\u00020\u0008¢\u0006\u0002\u0010\u000cJ\"\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J,\u0010\u001e\u001a\u00020\u001f*\u00020 2\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020!0\u001b2\u0006\u0010\"\u001a\u00020#H\u0016ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\u0008\u0011\u0010\u0012R\u0019\u0010\n\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\u0008\u0014\u0010\u0012R\u0019\u0010\t\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\u0008\u0015\u0010\u0012R\u0019\u0010\u000b\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\u0008\u0016\u0010\u0012\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006&", d2 = {"Landroidx/compose/material3/TopIconOrIconOnlyMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "hasLabel", "", "animationProgress", "Lkotlin/Function0;", "", "indicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "indicatorVerticalPadding", "indicatorToLabelVerticalPadding", "topIconItemVerticalPadding", "(ZLkotlin/jvm/functions/Function0;FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnimationProgress", "()Lkotlin/jvm/functions/Function0;", "getHasLabel", "()Z", "getIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getIndicatorToLabelVerticalPadding-D9Ej5fM", "getIndicatorVerticalPadding-D9Ej5fM", "getTopIconItemVerticalPadding-D9Ej5fM", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TopIconOrIconOnlyMeasurePolicy implements MeasurePolicy {

    private final Function0<Float> animationProgress;
    private final boolean hasLabel;
    private final float indicatorHorizontalPadding;
    private final float indicatorToLabelVerticalPadding;
    private final float indicatorVerticalPadding;
    private final float topIconItemVerticalPadding;
    private TopIconOrIconOnlyMeasurePolicy(boolean hasLabel, Function0<Float> animationProgress, float indicatorHorizontalPadding, float indicatorVerticalPadding, float indicatorToLabelVerticalPadding, float topIconItemVerticalPadding) {
        super();
        this.hasLabel = hasLabel;
        this.animationProgress = animationProgress;
        this.indicatorHorizontalPadding = indicatorHorizontalPadding;
        this.indicatorVerticalPadding = indicatorVerticalPadding;
        this.indicatorToLabelVerticalPadding = indicatorToLabelVerticalPadding;
        this.topIconItemVerticalPadding = topIconItemVerticalPadding;
    }

    public TopIconOrIconOnlyMeasurePolicy(boolean z, Function0 function02, float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(z, function02, f3, f4, f5, f6);
    }

    public final Function0<Float> getAnimationProgress() {
        return this.animationProgress;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final boolean getHasLabel() {
        return this.hasLabel;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final float getIndicatorHorizontalPadding-D9Ej5fM() {
        return this.indicatorHorizontalPadding;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final float getIndicatorToLabelVerticalPadding-D9Ej5fM() {
        return this.indicatorToLabelVerticalPadding;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final float getIndicatorVerticalPadding-D9Ej5fM() {
        return this.indicatorVerticalPadding;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final float getTopIconItemVerticalPadding-D9Ej5fM() {
        return this.topIconItemVerticalPadding;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        int maxIntrinsicHeight;
        int index$iv$iv;
        int index$iv$iv2;
        Object obj2;
        Object obj;
        int i;
        Object obj8;
        boolean it;
        int it2;
        Object layoutId;
        String layoutId2;
        String str;
        final Object obj3 = this;
        final int i2 = width;
        int i3 = 0;
        Object obj6 = obj4;
        int i5 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < obj6.size()) {
            obj = obj2;
            i = 0;
            it2 = 0;
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable)obj), "icon")) {
                break;
            } else {
            }
            obj8 = $this$maxIntrinsicHeight;
            index$iv$iv++;
        }
        Object obj9 = $this$maxIntrinsicHeight;
        NoSuchElementException $this$fastForEach$iv$iv = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw $this$fastForEach$iv$iv;
    }

    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        Object obj2;
        float f2;
        Placeable measure-BRTryo02;
        Placeable measure-BRTryo03;
        MeasureResult labelPlaceable;
        Placeable measure-BRTryo0;
        int i11;
        int iconPlaceable2;
        Placeable indicatorRipplePlaceable;
        long iconPlaceable;
        int indicatorRipplePlaceable2;
        Placeable indicatorHeight;
        Placeable animatedIndicatorWidth;
        int indicatorPlaceable;
        int index$iv$iv;
        float f;
        Placeable constrain-N9IONVI;
        long l;
        int indicatorToLabelVerticalPadding;
        int i3;
        float indicatorVerticalPadding;
        int i;
        float topIconItemVerticalPadding;
        int index$iv$iv4;
        int i14;
        int index$iv$iv3;
        int index$iv$iv2;
        int i7;
        int size;
        int i12;
        int i2;
        int i6;
        int i13;
        int indicatorHeight2;
        int i10;
        int i8;
        int i5;
        int i4;
        int indicatorPlaceable2;
        int indicatorPlaceable3;
        Placeable placeable2;
        Placeable placeable;
        int i9;
        long l2;
        final Object obj = this;
        obj2 = $this$measure_u2d3p2s80s;
        final long copy-Zbe2FdA$default = Constraints.copy-Zbe2FdA$default(constraints, obj3, 0, 0, 0, 0, 10);
        i11 = 0;
        float f3 = f2;
        int i25 = 0;
        index$iv$iv = 0;
        indicatorToLabelVerticalPadding = "Collection contains no element matching the predicate.";
        while (index$iv$iv < f3.size()) {
            i = i3;
            i14 = 0;
            i12 = 0;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable)i), "icon")) {
                break;
            } else {
            }
            index$iv$iv++;
            obj2 = $this$measure_u2d3p2s80s;
            f2 = i2;
            i11 = i6;
            indicatorToLabelVerticalPadding = "Collection contains no element matching the predicate.";
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException(indicatorToLabelVerticalPadding);
        throw noSuchElementException;
    }
}
