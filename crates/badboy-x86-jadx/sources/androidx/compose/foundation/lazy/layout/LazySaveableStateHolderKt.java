package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a&\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007", d2 = {"LazySaveableStateHolderProvider", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazySaveableStateHolderKt {
    public static final void LazySaveableStateHolderProvider(Function3<? super SaveableStateHolder, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int this_$iv;
        int i;
        int rememberSaveable;
        boolean traceInProgress2;
        int traceInProgress;
        androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda;
        int i2;
        int i5;
        int i4;
        int i3;
        Object empty;
        Object anon;
        int obj12;
        this_$iv = 674185128;
        final Composer restartGroup = $composer.startRestartGroup(this_$iv);
        ComposerKt.sourceInformation(restartGroup, "C(LazySaveableStateHolderProvider)42@2089L7,45@2218L68,43@2114L172,48@2360L92,48@2291L161:LazySaveableStateHolder.kt#wow0x6");
        traceInProgress = 2;
        if ($changed & 6 == 0) {
            i = restartGroup.changedInstance(content) ? 4 : traceInProgress;
            obj12 |= i;
        }
        if (obj12 & 3 == traceInProgress) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(this_$iv, obj12, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider (LazySaveableStateHolder.kt:41)");
                }
                int i6 = 0;
                int i7 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                this_$iv = consume;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -16183005, "CC(remember):LazySaveableStateHolder.kt#9igjgp");
                Composer composer = restartGroup;
                int i12 = 0;
                Object rememberedValue = composer.rememberedValue();
                i3 = 0;
                if (!restartGroup.changedInstance(this_$iv)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new LazySaveableStateHolderKt.LazySaveableStateHolderProvider.holder.1.1(this_$iv);
                        composer.updateRememberedValue((Function0)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                rememberSaveable = RememberSaveableKt.rememberSaveable(/* result */, LazySaveableStateHolder.Companion.saver((SaveableStateRegistry)this_$iv), 0, (Function0)anon, restartGroup, 0, 4);
                LazySaveableStateHolderKt.LazySaveableStateHolderProvider.1 anon2 = new LazySaveableStateHolderKt.LazySaveableStateHolderProvider.1(rememberSaveable, content);
                CompositionLocalKt.CompositionLocalProvider(SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides((LazySaveableStateHolder)rememberSaveable), (Function2)ComposableLambdaKt.rememberComposableLambda(1863926504, true, anon2, restartGroup, 54), restartGroup, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            rememberSaveable = new LazySaveableStateHolderKt.LazySaveableStateHolderProvider.2(content, $changed);
            endRestartGroup.updateScope((Function2)rememberSaveable);
        }
    }
}
