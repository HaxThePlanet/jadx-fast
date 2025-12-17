package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u001a!\u0010\u0005\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"ScrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "consumeScrollDelta", "Lkotlin/Function1;", "", "rememberScrollableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/ScrollableState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScrollableStateKt {
    public static final androidx.compose.foundation.gestures.ScrollableState ScrollableState(Function1<? super Float, Float> consumeScrollDelta) {
        DefaultScrollableState defaultScrollableState = new DefaultScrollableState(consumeScrollDelta);
        return (ScrollableState)defaultScrollableState;
    }

    public static final androidx.compose.foundation.gestures.ScrollableState rememberScrollableState(Function1<? super Float, Float> consumeScrollDelta, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object $i$a$CacheScrollableStateKt$rememberScrollableState$1;
        androidx.compose.foundation.gestures.ScrollableStateKt.rememberScrollableState.1.1 anon;
        int i = -180460798;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberScrollableState)162@7610L40,163@7662L61:ScrollableState.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.foundation.gestures.rememberScrollableState (ScrollableState.kt:161)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2119060080, "CC(remember):ScrollableState.kt#9igjgp");
        int i4 = 0;
        Composer composer = $composer;
        final int i5 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i6 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            int i7 = 0;
            anon = new ScrollableStateKt.rememberScrollableState.1.1(SnapshotStateKt.rememberUpdatedState(consumeScrollDelta, $composer, $changed & 14));
            composer.updateRememberedValue(ScrollableStateKt.ScrollableState((Function1)anon));
        } else {
            $i$a$CacheScrollableStateKt$rememberScrollableState$1 = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (ScrollableState)$i$a$CacheScrollableStateKt$rememberScrollableState$1;
    }
}
