package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a?\u0010\u0008\u001a\u00020\t*\u00020\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0013¨\u0006\u0014", d2 = {"estimatedLazyMaxScrollOffset", "", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "canScrollForward", "", "estimatedLazyScrollOffset", "lazyLayoutSemantics", "Landroidx/compose/ui/Modifier;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "reverseScrolling", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutSemanticsKt {
    public static final float estimatedLazyMaxScrollOffset(int firstVisibleItemIndex, int firstVisibleItemScrollOffset, boolean canScrollForward) {
        int estimatedLazyScrollOffset;
        float f;
        if (canScrollForward) {
            estimatedLazyScrollOffset2 += f;
        } else {
            estimatedLazyScrollOffset = LazyLayoutSemanticsKt.estimatedLazyScrollOffset(firstVisibleItemIndex, firstVisibleItemScrollOffset);
        }
        return estimatedLazyScrollOffset;
    }

    public static final float estimatedLazyScrollOffset(int firstVisibleItemIndex, int firstVisibleItemScrollOffset) {
        return (float)i2;
    }

    public static final Modifier lazyLayoutSemantics(Modifier $this$lazyLayoutSemantics, Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider> itemProviderLambda, androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState state, Orientation orientation, boolean userScrollEnabled, boolean reverseScrolling, Composer $composer, int $changed) {
        int traceInProgress;
        String str;
        int i;
        int i2 = 1070136913;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(lazyLayoutSemantics)P(!1,3!1,4):LazyLayoutSemantics.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.foundation.lazy.layout.lazyLayoutSemantics (LazyLayoutSemantics.kt:46)");
        } else {
            i = $changed;
        }
        LazyLayoutSemanticsModifier lazyLayoutSemanticsModifier = new LazyLayoutSemanticsModifier(itemProviderLambda, state, orientation, userScrollEnabled, reverseScrolling);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return $this$lazyLayoutSemantics.then((Modifier)lazyLayoutSemanticsModifier);
    }
}
