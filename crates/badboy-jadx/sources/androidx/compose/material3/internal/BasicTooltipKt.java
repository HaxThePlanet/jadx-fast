package androidx.compose.material3.internal;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a&\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006H\u0001\u001a+\u0010\u0007\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0008¨\u0006\t", d2 = {"BasicTooltipState", "Landroidx/compose/material3/TooltipState;", "initialIsVisible", "", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "rememberBasicTooltipState", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BasicTooltipKt {
    public static final TooltipState BasicTooltipState(boolean initialIsVisible, boolean isPersistent, MutatorMutex mutatorMutex) {
        BasicTooltipStateImpl basicTooltipStateImpl = new BasicTooltipStateImpl(initialIsVisible, isPersistent, mutatorMutex);
        return (TooltipState)basicTooltipStateImpl;
    }

    public static TooltipState BasicTooltipState$default(boolean z, boolean z2, MutatorMutex mutatorMutex3, int i4, Object object5) {
        int obj0;
        int obj1;
        MutatorMutex obj2;
        if (i4 & 1 != 0) {
            obj0 = 0;
        }
        if (i4 & 2 != 0) {
            obj1 = 1;
        }
        if (i4 &= 4 != 0) {
            obj2 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return BasicTooltipKt.BasicTooltipState(obj0, obj1, obj2);
    }

    public static final TooltipState rememberBasicTooltipState(boolean initialIsVisible, boolean isPersistent, MutatorMutex mutatorMutex, Composer $composer, int $changed, int i6) {
        int i;
        int str;
        int changed;
        Object empty;
        Object basicTooltipStateImpl;
        int obj6;
        int obj7;
        MutatorMutex obj8;
        int obj11;
        int i2 = -1483057531;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberBasicTooltipState)88@4062L215:BasicTooltip.kt#mqatfk");
        if (i6 & 1 != 0) {
            obj6 = 0;
        }
        if (i6 & 2 != 0) {
            obj7 = 1;
        }
        if (i6 &= 4 != 0) {
            obj8 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material3.internal.rememberBasicTooltipState (BasicTooltip.kt:88)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1300278280, "CC(remember):BasicTooltip.kt#9igjgp");
        int i4 = 32;
        int i8 = 1;
        if (obj11 ^= 48 > i4) {
            if (!$composer.changed(obj7)) {
                obj11 = $changed & 48 == i4 ? i8 : i;
            } else {
            }
        } else {
        }
        int i9 = 256;
        if (i5 ^= 384 > i9) {
            if (!$composer.changed(obj8)) {
                if ($changed & 384 == i9) {
                    i = i8;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i7 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i10 = 0;
        if (obj11 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                basicTooltipStateImpl = new BasicTooltipStateImpl(obj6, obj7, obj8);
                composer.updateRememberedValue(basicTooltipStateImpl);
            } else {
                basicTooltipStateImpl = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (TooltipState)(BasicTooltipStateImpl)basicTooltipStateImpl;
    }
}
