package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0017\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"collectIsFocusedAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusInteractionKt {
    public static final State<Boolean> collectIsFocusedAsState(androidx.compose.foundation.interaction.InteractionSource $this$collectIsFocusedAsState, Composer $composer, int $changed) {
        boolean traceInProgress;
        int changed;
        String str;
        Object empty;
        Object $i$a$CacheFocusInteractionKt$collectIsFocusedAsState$isFocused$1;
        Object anon;
        int i;
        Boolean valueOf;
        int i2;
        int i3 = -1805515472;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(collectIsFocusedAsState)65@2219L34,66@2279L414,66@2258L435:FocusInteraction.kt#ywyzhk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.foundation.interaction.collectIsFocusedAsState (FocusInteraction.kt:64)");
        }
        String str3 = "CC(remember):FocusInteraction.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, -1673627384, str3);
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
            $i$a$CacheFocusInteractionKt$collectIsFocusedAsState$isFocused$1 = rememberedValue2;
        }
        androidx.compose.runtime.MutableState invalid$iv = $i$a$CacheFocusInteractionKt$collectIsFocusedAsState$isFocused$1;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -1673625084, str3);
        int i9 = 4;
        if (i6 ^= 6 > i9) {
            if (!$composer.changed($this$collectIsFocusedAsState)) {
                if ($changed & 6 == i9) {
                    i = 1;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i10 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new FocusInteractionKt.collectIsFocusedAsState.1.1($this$collectIsFocusedAsState, (MutableState)invalid$iv, i14);
                composer.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect($this$collectIsFocusedAsState, (Function2)anon, $composer, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (State)invalid$iv;
    }
}
