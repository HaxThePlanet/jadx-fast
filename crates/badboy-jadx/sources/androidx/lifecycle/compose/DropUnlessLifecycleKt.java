package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a3\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0008\u001a+\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0002\u0010\n\u001a+\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000c", d2 = {"dropUnlessStateIsAtLeast", "Lkotlin/Function0;", "", "state", "Landroidx/lifecycle/Lifecycle$State;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "block", "(Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function0;", "dropUnlessStarted", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function0;", "dropUnlessResumed", "lifecycle-runtime-compose_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DropUnlessLifecycleKt {
    public static Unit $r8$lambda$TzX7zqFauTi6ZxXC0x9Y_67-fCs(LifecycleOwner lifecycleOwner, Lifecycle.State lifecycle$State2, Function0 function03) {
        return DropUnlessLifecycleKt.dropUnlessStateIsAtLeast$lambda$2$lambda$1(lifecycleOwner, state2, function03);
    }

    public static final Function0<Unit> dropUnlessResumed(LifecycleOwner lifecycleOwner, Function0<Unit> block, Composer $composer, int $changed, int i5) {
        String str2;
        Object obj;
        Object consume;
        String str;
        Object obj7;
        int obj11;
        final int i = 1331131589;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(dropUnlessResumed)P(1)97@4047L7,99@4095L62:DropUnlessLifecycle.kt#2vxrgp");
        if (i5 &= 1 != 0) {
            str2 = 6;
            int i2 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd($composer);
            obj = obj7;
        } else {
            obj = lifecycleOwner;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.lifecycle.compose.dropUnlessResumed (DropUnlessLifecycle.kt:99)");
        }
        Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return DropUnlessLifecycleKt.dropUnlessStateIsAtLeast(Lifecycle.State.RESUMED, obj, block, composer, obj7 | obj11, 0);
    }

    public static final Function0<Unit> dropUnlessStarted(LifecycleOwner lifecycleOwner, Function0<Unit> block, Composer $composer, int $changed, int i5) {
        String str2;
        Object obj;
        Object consume;
        String str;
        Object obj7;
        int obj11;
        final int i = 1207869935;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(dropUnlessStarted)P(1)75@3053L7,77@3101L62:DropUnlessLifecycle.kt#2vxrgp");
        if (i5 &= 1 != 0) {
            str2 = 6;
            int i2 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd($composer);
            obj = obj7;
        } else {
            obj = lifecycleOwner;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.lifecycle.compose.dropUnlessStarted (DropUnlessLifecycle.kt:77)");
        }
        Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return DropUnlessLifecycleKt.dropUnlessStateIsAtLeast(Lifecycle.State.STARTED, obj, block, composer, obj7 | obj11, 0);
    }

    private static final Function0<Unit> dropUnlessStateIsAtLeast(Lifecycle.State state, LifecycleOwner lifecycleOwner, Function0<Unit> block, Composer $composer, int $changed, int i6) {
        int i3;
        String str;
        int i2;
        boolean changed2;
        int i;
        int changed;
        Object consume;
        String empty;
        Object externalSyntheticLambda0;
        Object obj7;
        int obj11;
        int i4 = -2057956404;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(dropUnlessStateIsAtLeast)P(2,1)45@1919L7,53@2217L107:DropUnlessLifecycle.kt#2vxrgp");
        if (i6 &= 2 != 0) {
            str = 6;
            i2 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd($composer);
            obj7 = consume;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.lifecycle.compose.dropUnlessStateIsAtLeast (DropUnlessLifecycle.kt:47)");
        }
        i3 = 1;
        int i5 = 0;
        obj11 = state != Lifecycle.State.DESTROYED ? i3 : i5;
        if (obj11 == null) {
        } else {
            ComposerKt.sourceInformationMarkerStart($composer, -2011134025, "CC(remember):DropUnlessLifecycle.kt#9igjgp");
            int i11 = 4;
            if (i8 ^= 6 > i11) {
                if (!$composer.changed((Enum)state.ordinal())) {
                    i = $changed & 6 == i11 ? i3 : i5;
                } else {
                }
            } else {
            }
            int i12 = 256;
            if (i9 ^= 384 > i12) {
                if (!$composer.changed(block)) {
                    if ($changed & 384 == i12) {
                    } else {
                        i3 = i5;
                    }
                } else {
                }
            } else {
            }
            Composer composer = $composer;
            int i7 = 0;
            Object rememberedValue = composer.rememberedValue();
            int i13 = 0;
            if (obj11 |= i3 == 0) {
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    externalSyntheticLambda0 = new DropUnlessLifecycleKt$$ExternalSyntheticLambda0(obj7, state, block);
                    composer.updateRememberedValue(externalSyntheticLambda0);
                } else {
                    externalSyntheticLambda0 = rememberedValue;
                }
            } else {
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            return (Function0)externalSyntheticLambda0;
        }
        obj11 = 0;
        obj11 = new IllegalArgumentException("Target state is not allowed to be `Lifecycle.State.DESTROYED` because Compose disposes of the composition before `Lifecycle.Event.ON_DESTROY` observers are invoked.".toString());
        throw obj11;
    }

    private static final Unit dropUnlessStateIsAtLeast$lambda$2$lambda$1(LifecycleOwner $lifecycleOwner, Lifecycle.State $state, Function0 $block) {
        if ($lifecycleOwner.getLifecycle().getCurrentState().isAtLeast($state)) {
            $block.invoke();
        }
        return Unit.INSTANCE;
    }
}
