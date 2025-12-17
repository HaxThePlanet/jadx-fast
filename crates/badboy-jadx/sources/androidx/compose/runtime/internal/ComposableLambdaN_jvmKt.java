package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007\u001a(\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007\u001a-\u0010\u000c\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e", d2 = {"composableLambdaN", "Landroidx/compose/runtime/internal/ComposableLambdaN;", "composer", "Landroidx/compose/runtime/Composer;", "key", "", "tracked", "", "arity", "block", "", "composableLambdaNInstance", "rememberComposableLambdaN", "(IZILjava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/internal/ComposableLambdaN;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ComposableLambdaN_jvmKt {
    @ComposeCompilerApi
    public static final androidx.compose.runtime.internal.ComposableLambdaN composableLambdaN(Composer composer, int key, boolean tracked, int arity, Object block) {
        Object composableLambdaNImpl;
        composer.startReplaceableGroup(key);
        final Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            composableLambdaNImpl = new ComposableLambdaNImpl(key, tracked, arity);
            composer.updateRememberedValue(composableLambdaNImpl);
        } else {
            Intrinsics.checkNotNull(rememberedValue, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaNImpl");
            composableLambdaNImpl = rememberedValue;
        }
        composableLambdaNImpl.update(block);
        composer.endReplaceableGroup();
        return (ComposableLambdaN)composableLambdaNImpl;
    }

    @ComposeCompilerApi
    public static final androidx.compose.runtime.internal.ComposableLambdaN composableLambdaNInstance(int key, boolean tracked, int arity, Object block) {
        ComposableLambdaNImpl composableLambdaNImpl = new ComposableLambdaNImpl(key, tracked, arity);
        final int i = 0;
        composableLambdaNImpl.update(block);
        return (ComposableLambdaN)composableLambdaNImpl;
    }

    @ComposeCompilerApi
    public static final androidx.compose.runtime.internal.ComposableLambdaN rememberComposableLambdaN(int key, boolean tracked, int arity, Object block, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int empty;
        Object composableLambdaNImpl;
        int i = -293456346;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberComposableLambdaN)P(2,3)*176@5693L55:ComposableLambdaN.jvm.kt#9drcc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.internal.rememberComposableLambdaN (ComposableLambdaN.jvm.kt:176)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -593837686, "CC(remember):ComposableLambdaN.jvm.kt#9igjgp");
        int i3 = 0;
        Composer composer = $composer;
        int i5 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i6 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty = 0;
            composableLambdaNImpl = new ComposableLambdaNImpl(key, tracked, arity);
            composer.updateRememberedValue(composableLambdaNImpl);
        } else {
            composableLambdaNImpl = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        int i4 = 0;
        (ComposableLambdaNImpl)composableLambdaNImpl.update(block);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (ComposableLambdaN)composableLambdaNImpl;
    }
}
