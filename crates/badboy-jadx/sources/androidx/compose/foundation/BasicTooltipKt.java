package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a&\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a+\u0010\u0007\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0008¨\u0006\t", d2 = {"BasicTooltipState", "Landroidx/compose/foundation/BasicTooltipState;", "initialIsVisible", "", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "rememberBasicTooltipState", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BasicTooltipState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BasicTooltipKt {
    public static final androidx.compose.foundation.BasicTooltipState BasicTooltipState(boolean initialIsVisible, boolean isPersistent, androidx.compose.foundation.MutatorMutex mutatorMutex) {
        BasicTooltipStateImpl basicTooltipStateImpl = new BasicTooltipStateImpl(initialIsVisible, isPersistent, mutatorMutex);
        return (BasicTooltipState)basicTooltipStateImpl;
    }

    public static androidx.compose.foundation.BasicTooltipState BasicTooltipState$default(boolean z, boolean z2, androidx.compose.foundation.MutatorMutex mutatorMutex3, int i4, Object object5) {
        int obj0;
        int obj1;
        androidx.compose.foundation.MutatorMutex obj2;
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

    public static final androidx.compose.foundation.BasicTooltipState rememberBasicTooltipState(boolean initialIsVisible, boolean isPersistent, androidx.compose.foundation.MutatorMutex mutatorMutex, Composer $composer, int $changed, int i6) {
        int i;
        int str;
        int changed;
        Object empty;
        Object basicTooltipStateImpl;
        int obj6;
        int obj7;
        androidx.compose.foundation.MutatorMutex obj8;
        int obj11;
        int i2 = 1123859613;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberBasicTooltipState)82@3676L237:BasicTooltip.kt#71ulvw");
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
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.foundation.rememberBasicTooltipState (BasicTooltip.kt:82)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1506345218, "CC(remember):BasicTooltip.kt#9igjgp");
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
        return (BasicTooltipState)(BasicTooltipStateImpl)basicTooltipStateImpl;
    }
}
