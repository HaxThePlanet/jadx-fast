package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a0\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0008¨\u0006\t", d2 = {"WindowFocusObserver", "", "onWindowFocusChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isWindowFocused", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WindowInfoKt {
    public static final void WindowFocusObserver(Function1<? super Boolean, Unit> onWindowFocusChanged, Composer $composer, int $changed) {
        int this_$iv;
        int $dirty;
        int i;
        int rememberUpdatedState;
        boolean traceInProgress2;
        int traceInProgress;
        Composer composer;
        int i3;
        Object rememberedValue;
        int i4;
        Object empty;
        Object anon;
        int i2;
        this_$iv = 127829799;
        final Composer obj12 = $composer.startRestartGroup(this_$iv);
        ComposerKt.sourceInformation(obj12, "C(WindowFocusObserver)53@2007L7,54@2034L42,55@2108L90,55@2081L117:WindowInfo.kt#itgzvw");
        traceInProgress = 2;
        if ($changed & 6 == 0) {
            i = obj12.changedInstance(onWindowFocusChanged) ? 4 : traceInProgress;
            $dirty |= i;
        }
        if ($dirty & 3 == traceInProgress) {
            if (!obj12.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(this_$iv, $dirty, -1, "androidx.compose.ui.platform.WindowFocusObserver (WindowInfo.kt:52)");
                }
                int i5 = 6;
                int i7 = 0;
                ComposerKt.sourceInformationMarkerStart(obj12, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(obj12);
                this_$iv = consume;
                rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onWindowFocusChanged, obj12, $dirty & 14);
                ComposerKt.sourceInformationMarkerStart(obj12, -1536578506, "CC(remember):WindowInfo.kt#9igjgp");
                composer = obj12;
                i3 = 0;
                rememberedValue = composer.rememberedValue();
                i4 = 0;
                if (changed |= changed2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new WindowInfoKt.WindowFocusObserver.1.1(this_$iv, rememberUpdatedState, 0);
                        composer.updateRememberedValue((Function2)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj12);
                EffectsKt.LaunchedEffect(this_$iv, (Function2)anon, obj12, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj12.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj12.endRestartGroup();
        if (endRestartGroup != null) {
            rememberUpdatedState = new WindowInfoKt.WindowFocusObserver.2(onWindowFocusChanged, $changed);
            endRestartGroup.updateScope((Function2)rememberUpdatedState);
        }
    }
}
