package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a¡\u0001\u0010\u0000\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\u0008\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\"", d2 = {"rememberPagerMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "pageCount", "rememberPagerMeasurePolicy-8u0NR3k", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagerMeasurePolicyKt {
    public static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberPagerMeasurePolicy-8u0NR3k(Function0<androidx.compose.foundation.pager.PagerLazyLayoutItemProvider> itemProviderLambda, androidx.compose.foundation.pager.PagerState state, PaddingValues contentPadding, boolean reverseLayout, Orientation orientation, int beyondViewportPageCount, float pageSpacing, androidx.compose.foundation.pager.PageSize pageSize, Alignment.Horizontal horizontalAlignment, Alignment.Vertical verticalAlignment, SnapPosition snapPosition, CoroutineScope coroutineScope, Function0<Integer> pageCount, Composer $composer, int $changed, int $changed1) {
        int i15;
        Object invalid$iv2;
        int changed9;
        int i10;
        Composer composer;
        boolean traceInProgress;
        int i8;
        int i3;
        Object obj2;
        boolean changed5;
        boolean changed10;
        int i;
        Object obj10;
        int i14;
        int changed8;
        int i7;
        int i11;
        int i16;
        boolean changed4;
        Object $this$cache$iv2;
        Object obj5;
        int i9;
        Object obj3;
        Object obj8;
        boolean z;
        boolean changed3;
        int i5;
        Object obj7;
        int i2;
        int i18;
        float f;
        int i6;
        boolean changed;
        int i17;
        int i12;
        Object obj;
        boolean changed7;
        int i4;
        Object obj6;
        boolean changed2;
        int $this$cache$iv;
        boolean changed6;
        int i13;
        Object obj4;
        Object obj9;
        int invalid$iv;
        Composer composer2 = $composer;
        i15 = $changed;
        final int i20 = $changed1;
        int i21 = 1391419623;
        ComposerKt.sourceInformationMarkerStart(composer2, i21, "C(rememberPagerMeasurePolicy)P(4,11,1,9,5!1,8:c#ui.unit.Dp,7,3,12,10)56@2301L6278:PagerMeasurePolicy.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i21, i15, i20, "androidx.compose.foundation.pager.rememberPagerMeasurePolicy (PagerMeasurePolicy.kt:56)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 35232261, "CC(remember):PagerMeasurePolicy.kt#9igjgp");
        int i33 = 32;
        if (i23 ^= 48 > i33) {
            if (!composer2.changed(state)) {
                i10 = i15 & 48 == i33 ? 1 : 0;
            } else {
            }
        } else {
            obj5 = state;
        }
        int i46 = 256;
        if (i34 ^= 384 > i46) {
            if (!composer2.changed(contentPadding)) {
                i8 = i15 & 384 == i46 ? 1 : 0;
            } else {
            }
        } else {
            obj8 = contentPadding;
        }
        int i49 = 2048;
        if (i35 ^= 3072 > i49) {
            if (!composer2.changed(reverseLayout)) {
                i3 = i15 & 3072 == i49 ? 1 : 0;
            } else {
            }
        } else {
            z = reverseLayout;
        }
        int i50 = 16384;
        if (i37 ^= 24576 > i50) {
            if (!composer2.changed(orientation)) {
                i9 = i15 & 24576 == i50 ? 1 : 0;
            } else {
            }
        } else {
            obj2 = orientation;
        }
        i2 = 100663296;
        int i57 = 67108864;
        if (i52 ^= i2 > i57) {
            if (!composer2.changed(horizontalAlignment)) {
                i5 = i2 &= i15 == i57 ? 1 : 0;
            } else {
            }
        } else {
            obj3 = horizontalAlignment;
        }
        i6 = 805306368;
        int i61 = 536870912;
        if (i55 ^= i6 > i61) {
            if (!composer2.changed(verticalAlignment)) {
                i18 = i6 &= i15 == i61 ? 1 : 0;
            } else {
            }
        } else {
            obj7 = verticalAlignment;
        }
        i17 = 1572864;
        int i65 = 1048576;
        if (i59 ^= i17 > i65) {
            if (!composer2.changed(pageSpacing)) {
                i12 = i17 &= i15 == i65 ? 1 : 0;
            } else {
            }
        } else {
            f = pageSpacing;
        }
        i4 = 12582912;
        int i39 = 8388608;
        if (i63 ^= i4 > i39) {
            if (!composer2.changed(pageSize)) {
                i = i4 &= i15 == i39 ? 1 : 0;
            } else {
            }
        } else {
            obj = pageSize;
        }
        int i66 = 4;
        if (i40 ^= 6 > i66) {
            if (!composer2.changed(snapPosition)) {
                i14 = i20 & 6 == i66 ? 1 : 0;
            } else {
            }
        } else {
            obj10 = snapPosition;
        }
        if (i42 ^= 384 > i46) {
            if (!composer2.changed(pageCount)) {
                i7 = i20 & 384 == i46 ? 1 : 0;
            } else {
            }
        } else {
            obj6 = pageCount;
        }
        if (i44 ^= i47 > 131072) {
            if (!composer2.changed(beyondViewportPageCount)) {
                $this$cache$iv = i48 &= i15 == 131072 ? 1 : 0;
            } else {
            }
        } else {
            i11 = beyondViewportPageCount;
        }
        Object obj11 = coroutineScope;
        i19 |= changed11;
        Composer composer3 = $composer;
        final int i67 = 0;
        Object rememberedValue = composer3.rememberedValue();
        final int i68 = 0;
        if (invalid$iv2 == 0) {
            invalid$iv = invalid$iv2;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                invalid$iv2 = 0;
                $this$cache$iv2 = new PagerMeasurePolicyKt.rememberPagerMeasurePolicy.1.1(obj5, obj2, obj8, z, f, obj, itemProviderLambda, obj6, obj7, obj3, i11, obj10, obj11);
                composer3.updateRememberedValue((Function2)$this$cache$iv2);
            } else {
                composer = composer3;
                $this$cache$iv2 = rememberedValue;
            }
        } else {
            invalid$iv = invalid$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Function2)$this$cache$iv2;
    }
}
