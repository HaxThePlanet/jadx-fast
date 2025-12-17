package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0017\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"collectIsDraggedAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DragInteractionKt {
    public static final State<Boolean> collectIsDraggedAsState(androidx.compose.foundation.interaction.InteractionSource $this$collectIsDraggedAsState, Composer $composer, int $changed) {
        boolean traceInProgress;
        int changed;
        String str;
        Object empty;
        Object mutableStateOf$default;
        Object anon;
        int i2;
        Boolean valueOf;
        int i;
        int i3 = 101276833;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(collectIsDraggedAsState)80@2766L34,81@2826L492,81@2805L513:DragInteraction.kt#ywyzhk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.foundation.interaction.collectIsDraggedAsState (DragInteraction.kt:79)");
        }
        String str3 = "CC(remember):DragInteraction.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, -1150053971, str3);
        int i5 = 0;
        Composer composer2 = $composer;
        int i11 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        empty = 0;
        final int i14 = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            int i13 = 0;
            composer2.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(false, i14, 2, i14));
        } else {
            mutableStateOf$default = rememberedValue2;
        }
        androidx.compose.runtime.MutableState invalid$iv = mutableStateOf$default;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -1150051593, str3);
        int i9 = 4;
        if (i6 ^= 6 > i9) {
            if (!$composer.changed($this$collectIsDraggedAsState)) {
                if ($changed & 6 == i9) {
                    i2 = 1;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i10 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (i2 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new DragInteractionKt.collectIsDraggedAsState.1.1($this$collectIsDraggedAsState, (MutableState)invalid$iv, i14);
                composer.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect($this$collectIsDraggedAsState, (Function2)anon, $composer, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (State)invalid$iv;
    }
}
