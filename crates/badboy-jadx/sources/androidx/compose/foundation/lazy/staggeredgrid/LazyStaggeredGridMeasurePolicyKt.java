package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u007f\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\u0008\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\u001a)\u0010\u001c\u001a\u00020\u0012*\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001f\u001a)\u0010 \u001a\u00020\u0012*\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001f\u001a!\u0010!\u001a\u00020\u0012*\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\"\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006#", d2 = {"rememberStaggeredGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "rememberStaggeredGridMeasurePolicy-qKj4JfE", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;FFLkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "afterPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "startPadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridMeasurePolicyKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[Orientation.Vertical.ordinal()] = 1;
            iArr[Orientation.Horizontal.ordinal()] = 2;
            LazyStaggeredGridMeasurePolicyKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final float access$afterPadding(PaddingValues $receiver, Orientation orientation, boolean reverseLayout, LayoutDirection layoutDirection) {
        return LazyStaggeredGridMeasurePolicyKt.afterPadding($receiver, orientation, reverseLayout, layoutDirection);
    }

    public static final float access$beforePadding(PaddingValues $receiver, Orientation orientation, boolean reverseLayout, LayoutDirection layoutDirection) {
        return LazyStaggeredGridMeasurePolicyKt.beforePadding($receiver, orientation, reverseLayout, layoutDirection);
    }

    public static final float access$startPadding(PaddingValues $receiver, Orientation orientation, LayoutDirection layoutDirection) {
        return LazyStaggeredGridMeasurePolicyKt.startPadding($receiver, orientation, layoutDirection);
    }

    private static final float afterPadding(PaddingValues $this$afterPadding, Orientation orientation, boolean reverseLayout, LayoutDirection layoutDirection) {
        float bottomPadding-D9Ej5fM;
        switch (i2) {
            case 1:
                bottomPadding-D9Ej5fM = $this$afterPadding.calculateTopPadding-D9Ej5fM();
                bottomPadding-D9Ej5fM = $this$afterPadding.calculateBottomPadding-D9Ej5fM();
                break;
            case 2:
                bottomPadding-D9Ej5fM = PaddingKt.calculateStartPadding($this$afterPadding, layoutDirection);
                bottomPadding-D9Ej5fM = PaddingKt.calculateEndPadding($this$afterPadding, layoutDirection);
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return bottomPadding-D9Ej5fM;
    }

    private static final float beforePadding(PaddingValues $this$beforePadding, Orientation orientation, boolean reverseLayout, LayoutDirection layoutDirection) {
        float bottomPadding-D9Ej5fM;
        switch (i2) {
            case 1:
                bottomPadding-D9Ej5fM = $this$beforePadding.calculateBottomPadding-D9Ej5fM();
                bottomPadding-D9Ej5fM = $this$beforePadding.calculateTopPadding-D9Ej5fM();
                break;
            case 2:
                bottomPadding-D9Ej5fM = PaddingKt.calculateEndPadding($this$beforePadding, layoutDirection);
                bottomPadding-D9Ej5fM = PaddingKt.calculateStartPadding($this$beforePadding, layoutDirection);
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return bottomPadding-D9Ej5fM;
    }

    public static final Function2<LazyLayoutMeasureScope, Constraints, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult> rememberStaggeredGridMeasurePolicy-qKj4JfE(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state, Function0<? extends androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider> itemProviderLambda, PaddingValues contentPadding, boolean reverseLayout, Orientation orientation, float mainAxisSpacing, float crossAxisSpacing, CoroutineScope coroutineScope, androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider slots, GraphicsContext graphicsContext, Composer $composer, int $changed) {
        boolean traceInProgress;
        int changed3;
        int i6;
        int i9;
        int i7;
        Object obj;
        Object obj5;
        boolean changed7;
        boolean changed;
        String str;
        int i10;
        float anon;
        int i;
        Object rememberedValue;
        Object empty;
        Object obj2;
        Object obj4;
        boolean z;
        boolean changed2;
        int i4;
        int i2;
        Object obj3;
        int changed4;
        int i3;
        int i8;
        boolean changed5;
        float f;
        boolean changed6;
        int i5;
        final Composer composer = $composer;
        final int i11 = $changed;
        int i12 = 1630140849;
        ComposerKt.sourceInformationMarkerStart(composer, i12, "C(rememberStaggeredGridMeasurePolicy)P(9,4!1,7,6,5:c#ui.unit.Dp,2:c#ui.unit.Dp!1,8)50@2173L2923:LazyStaggeredGridMeasurePolicy.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:50)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1650675918, "CC(remember):LazyStaggeredGridMeasurePolicy.kt#9igjgp");
        final Object obj6 = state;
        int i28 = 32;
        i = 0;
        empty = 1;
        if (i22 ^= 48 > i28) {
            if (!composer.changed(itemProviderLambda)) {
                i6 = i11 & 48 == i28 ? empty : i;
            } else {
            }
        } else {
            obj2 = itemProviderLambda;
        }
        int i29 = 256;
        if (i23 ^= 384 > i29) {
            if (!composer.changed(contentPadding)) {
                i9 = i11 & 384 == i29 ? empty : i;
            } else {
            }
        } else {
            obj4 = contentPadding;
        }
        int i30 = 2048;
        if (i24 ^= 3072 > i30) {
            if (!composer.changed(reverseLayout)) {
                i7 = i11 & 3072 == i30 ? empty : i;
            } else {
            }
        } else {
            z = reverseLayout;
        }
        int i31 = 16384;
        if (i26 ^= 24576 > i31) {
            if (!composer.changed(orientation)) {
                i10 = i11 & 24576 == i31 ? empty : i;
            } else {
            }
        } else {
            obj = orientation;
        }
        i3 = 196608;
        int i40 = 131072;
        if (i33 ^= i3 > i40) {
            if (!composer.changed(mainAxisSpacing)) {
                i4 = i3 &= i11 == i40 ? empty : i;
            } else {
            }
        } else {
            anon = mainAxisSpacing;
        }
        int i41 = 1572864;
        int i42 = 1048576;
        if (i36 ^= i41 > i42) {
            if (!composer.changed(crossAxisSpacing)) {
                i2 = i11 & i41 == i42 ? empty : i;
            } else {
            }
        } else {
            f = crossAxisSpacing;
        }
        i8 = 100663296;
        int i43 = 67108864;
        if (i38 ^= i8 > i43) {
            if (!composer.changed(slots)) {
                if (i8 &= i11 == i43) {
                    i = empty;
                }
            } else {
            }
        } else {
            obj3 = slots;
        }
        Object obj8 = graphicsContext;
        Composer composer2 = $composer;
        final int i44 = 0;
        rememberedValue = composer2.rememberedValue();
        final int i45 = 0;
        if (i20 |= changed9 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i5 = 0;
                obj5 = obj7;
                anon = new LazyStaggeredGridMeasurePolicyKt.rememberStaggeredGridMeasurePolicy.1.1(obj6, obj, obj3, obj2, obj4, z, mainAxisSpacing, coroutineScope, obj8);
                composer2.updateRememberedValue((Function2)anon);
            } else {
                obj5 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (Function2)rememberedValue;
    }

    private static final float startPadding(PaddingValues $this$startPadding, Orientation orientation, LayoutDirection layoutDirection) {
        float topPadding-D9Ej5fM;
        switch (i) {
            case 1:
                topPadding-D9Ej5fM = PaddingKt.calculateStartPadding($this$startPadding, layoutDirection);
                break;
            case 2:
                topPadding-D9Ej5fM = $this$startPadding.calculateTopPadding-D9Ej5fM();
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return topPadding-D9Ej5fM;
    }
}
