package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\\\u0010\u0012\u001a\u00020\u0013\"\u0008\u0008\u0000\u0010\u0014*\u00020\u0015\"\u000e\u0008\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\u0008\u00030\u00172\u000e\u0008\u0008\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\u0008\u001d¢\u0006\u0002\u0008\u001eH\u0087\u0008¢\u0006\u0002\u0010\u001f\u001ak\u0010\u0012\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0014\"\u000e\u0008\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\u0008\u00030\u00172\u000e\u0008\u0008\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\u0008\u001d¢\u0006\u0002\u0008\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\u0008!H\u0087\u0008¢\u0006\u0002\u0010\"\u001a\u0091\u0001\u0010\u0012\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0014\"\u000e\u0008\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\u0008\u00030\u00172\u000e\u0008\u0008\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\u0008\u001d¢\u0006\u0002\u0008\u001e2$\u0008\u0008\u0010#\u001a\u001e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00140$\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\u0008!¢\u0006\u0002\u0008\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\u0008!H\u0087\u0008¢\u0006\u0002\u0010%\u001a\\\u0010&\u001a\u00020\u0013\"\u0008\u0008\u0000\u0010\u0014*\u00020\u0015\"\u000e\u0008\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\u0008\u00030\u00172\u000e\u0008\u0008\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\u0008\u001d¢\u0006\u0002\u0008\u001eH\u0087\u0008¢\u0006\u0002\u0010\u001f\u001ak\u0010&\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0014\"\u000e\u0008\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\u0008\u00030\u00172\u000e\u0008\u0008\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\u0008\u001d¢\u0006\u0002\u0008\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\u0008!H\u0087\u0008¢\u0006\u0002\u0010\"\u001a\u0091\u0001\u0010&\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0014\"\u000e\u0008\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\u0008\u00030\u00172\u000e\u0008\u0008\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\u0008\u001d¢\u0006\u0002\u0008\u001e2$\u0008\u0008\u0010#\u001a\u001e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00140$\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\u0008!¢\u0006\u0002\u0008\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\u0008!H\u0087\u0008¢\u0006\u0002\u0010%\u001a+\u0010'\u001a\u00020\u00132\u0008\u0010(\u001a\u0004\u0018\u00010\u00152\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\u0008!H\u0087\u0008¢\u0006\u0002\u0010)\u001a+\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\u0013\u0008\u0004\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\u0008!H\u0087\u0008¢\u0006\u0002\u0010-\u001a\u0008\u0010.\u001a\u00020\u0013H\u0001\u001a?\u0010(\u001a\u0002H\u0014\"\u0004\u0008\u0000\u0010\u00142\u0016\u0010/\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u001500\"\u0004\u0018\u00010\u00152\u0011\u00101\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\u0008!H\u0087\u0008¢\u0006\u0002\u00102\u001a)\u00103\u001a\u0002H\u0014\"\u0004\u0008\u0000\u0010\u00142\u0013\u0008\u0004\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\u0008\u001dH\u0087\u0008¢\u0006\u0002\u00105\u001a3\u00103\u001a\u0002H\u0014\"\u0004\u0008\u0000\u0010\u00142\u0008\u00106\u001a\u0004\u0018\u00010\u00152\u0013\u0008\u0004\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\u0008\u001dH\u0087\u0008¢\u0006\u0002\u00107\u001a=\u00103\u001a\u0002H\u0014\"\u0004\u0008\u0000\u0010\u00142\u0008\u00106\u001a\u0004\u0018\u00010\u00152\u0008\u00108\u001a\u0004\u0018\u00010\u00152\u0013\u0008\u0004\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\u0008\u001dH\u0087\u0008¢\u0006\u0002\u00109\u001aG\u00103\u001a\u0002H\u0014\"\u0004\u0008\u0000\u0010\u00142\u0008\u00106\u001a\u0004\u0018\u00010\u00152\u0008\u00108\u001a\u0004\u0018\u00010\u00152\u0008\u0010:\u001a\u0004\u0018\u00010\u00152\u0013\u0008\u0004\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\u0008\u001dH\u0087\u0008¢\u0006\u0002\u0010;\u001aA\u00103\u001a\u0002H\u0014\"\u0004\u0008\u0000\u0010\u00142\u0016\u0010/\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u001500\"\u0004\u0018\u00010\u00152\u0013\u0008\u0004\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\u0008\u001dH\u0087\u0008¢\u0006\u0002\u0010<\u001a\r\u0010=\u001a\u00020>H\u0007¢\u0006\u0002\u0010?\"\u0011\u0010\u0000\u001a\u00020\u00018G¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007\"\u0017\u0010\u0008\u001a\u00020\t8G¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u000c\u0010\r\"\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006@", d2 = {"currentComposer", "Landroidx/compose/runtime/Composer;", "getCurrentComposer", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/Composer;", "currentCompositeKeyHash", "", "getCurrentCompositeKeyHash", "(Landroidx/compose/runtime/Composer;I)I", "currentCompositionLocalContext", "Landroidx/compose/runtime/CompositionLocalContext;", "getCurrentCompositionLocalContext$annotations", "()V", "getCurrentCompositionLocalContext", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/CompositionLocalContext;", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getCurrentRecomposeScope", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/RecomposeScope;", "ComposeNode", "", "T", "", "E", "Landroidx/compose/runtime/Applier;", "factory", "Lkotlin/Function0;", "update", "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "Landroidx/compose/runtime/DisallowComposableCalls;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "skippableUpdate", "Landroidx/compose/runtime/SkippableUpdater;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ReusableComposeNode", "ReusableContent", "key", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ReusableContentHost", "active", "", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "invalidApplier", "keys", "", "block", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "remember", "calculation", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key1", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "rememberCompositionContext", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/CompositionContext;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ComposablesKt {
    public static final <T, E extends androidx.compose.runtime.Applier<?>> void ComposeNode(Function0<? extends T> factory, Function1<? super androidx.compose.runtime.Updater<T>, Unit> update, androidx.compose.runtime.Composer $composer, int $changed) {
        final int i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 1886828752, "CC(ComposeNode):Composables.kt#9igjgp");
        Intrinsics.reifiedOperationMarker(3, "E");
        if (!applier instanceof Applier) {
            ComposablesKt.invalidApplier();
        }
        $composer.startNode();
        if ($composer.getInserting()) {
            $composer.createNode(factory);
        } else {
            $composer.useNode();
        }
        update.invoke(Updater.box-impl(Updater.constructor-impl($composer)));
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final <T, E extends androidx.compose.runtime.Applier<?>> void ComposeNode(Function0<? extends T> factory, Function1<? super androidx.compose.runtime.Updater<T>, Unit> update, Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content, androidx.compose.runtime.Composer $composer, int $changed) {
        final int i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -548224868, "CC(ComposeNode)P(1,2)336@12596L9:Composables.kt#9igjgp");
        Intrinsics.reifiedOperationMarker(3, "E");
        if (!applier instanceof Applier) {
            ComposablesKt.invalidApplier();
        }
        $composer.startNode();
        if ($composer.getInserting()) {
            $composer.createNode(factory);
        } else {
            $composer.useNode();
        }
        update.invoke(Updater.box-impl(Updater.constructor-impl($composer)));
        content.invoke($composer, Integer.valueOf(i3 &= 14));
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final <T, E extends androidx.compose.runtime.Applier<?>> void ComposeNode(Function0<? extends T> factory, Function1<? super androidx.compose.runtime.Updater<T>, Unit> update, Function3<? super androidx.compose.runtime.SkippableUpdater<T>, ? super androidx.compose.runtime.Composer, ? super Integer, Unit> skippableUpdate, Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content, androidx.compose.runtime.Composer $composer, int $changed) {
        final int i = 0;
        Intrinsics.reifiedOperationMarker(3, "E");
        if (!applier instanceof Applier) {
            ComposablesKt.invalidApplier();
        }
        $composer.startNode();
        if ($composer.getInserting()) {
            $composer.createNode(factory);
        } else {
            $composer.useNode();
        }
        update.invoke(Updater.box-impl(Updater.constructor-impl($composer)));
        skippableUpdate.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl($composer)), $composer, Integer.valueOf(i6 &= 112));
        $composer.startReplaceableGroup(2058660585);
        content.invoke($composer, Integer.valueOf(i3 &= 14));
        $composer.endReplaceableGroup();
        $composer.endNode();
    }

    public static final <T, E extends androidx.compose.runtime.Applier<?>> void ReusableComposeNode(Function0<? extends T> factory, Function1<? super androidx.compose.runtime.Updater<T>, Unit> update, androidx.compose.runtime.Composer $composer, int $changed) {
        final int i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        Intrinsics.reifiedOperationMarker(3, "E");
        if (!applier instanceof Applier) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            $composer.createNode(factory);
        } else {
            $composer.useNode();
        }
        update.invoke(Updater.box-impl(Updater.constructor-impl($composer)));
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final <T, E extends androidx.compose.runtime.Applier<?>> void ReusableComposeNode(Function0<? extends T> factory, Function1<? super androidx.compose.runtime.Updater<T>, Unit> update, Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content, androidx.compose.runtime.Composer $composer, int $changed) {
        final int i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        Intrinsics.reifiedOperationMarker(3, "E");
        if (!applier instanceof Applier) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            $composer.createNode(factory);
        } else {
            $composer.useNode();
        }
        update.invoke(Updater.box-impl(Updater.constructor-impl($composer)));
        content.invoke($composer, Integer.valueOf(i3 &= 14));
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final <T, E extends androidx.compose.runtime.Applier<?>> void ReusableComposeNode(Function0<? extends T> factory, Function1<? super androidx.compose.runtime.Updater<T>, Unit> update, Function3<? super androidx.compose.runtime.SkippableUpdater<T>, ? super androidx.compose.runtime.Composer, ? super Integer, Unit> skippableUpdate, Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content, androidx.compose.runtime.Composer $composer, int $changed) {
        final int i = 0;
        Intrinsics.reifiedOperationMarker(3, "E");
        if (!applier instanceof Applier) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            $composer.createNode(factory);
        } else {
            $composer.useNode();
        }
        update.invoke(Updater.box-impl(Updater.constructor-impl($composer)));
        skippableUpdate.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl($composer)), $composer, Integer.valueOf(i6 &= 112));
        $composer.startReplaceableGroup(2058660585);
        content.invoke($composer, Integer.valueOf(i3 &= 14));
        $composer.endReplaceableGroup();
        $composer.endNode();
    }

    public static final void ReusableContent(Object key, Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content, androidx.compose.runtime.Composer $composer, int $changed) {
        final int i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 444418301, "CC(ReusableContent)P(1)149@5444L9:Composables.kt#9igjgp");
        $composer.startReusableGroup(207, key);
        content.invoke($composer, Integer.valueOf(i4 &= 14));
        $composer.endReusableGroup();
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void ReusableContentHost(boolean active, Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content, androidx.compose.runtime.Composer $composer, int $changed) {
        Object valueOf;
        final int i = 0;
        $composer.startReusableGroup(207, Boolean.valueOf(active));
        $composer.startReplaceGroup(-869707859);
        ComposerKt.sourceInformation($composer, "175@6712L9");
        if (active) {
            content.invoke($composer, Integer.valueOf(i4 &= 14));
        } else {
            $composer.deactivateToEndGroup($composer.changed(active));
        }
        $composer.endReplaceGroup();
        $composer.endReusableGroup();
    }

    public static final androidx.compose.runtime.Composer getCurrentComposer(androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -554250212;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C:Composables.kt#9igjgp");
        if (!ComposerKt.isTraceInProgress()) {
        } else {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.<get-currentComposer> (Composables.kt:187)");
        }
        NotImplementedError notImplementedError = new NotImplementedError("Implemented as an intrinsic");
        throw notImplementedError;
    }

    public static final int getCurrentCompositeKeyHash(androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        int i;
        String str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(524444915, $changed, -1, "androidx.compose.runtime.<get-currentCompositeKeyHash> (Composables.kt:228)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return $composer.getCompoundKeyHash();
    }

    public static final androidx.compose.runtime.CompositionLocalContext getCurrentCompositionLocalContext(androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -43352356;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C:Composables.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.<get-currentCompositionLocalContext> (Composables.kt:211)");
        }
        CompositionLocalContext compositionLocalContext = new CompositionLocalContext($composer.buildContext().getCompositionLocalScope$runtime_release());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return compositionLocalContext;
    }

    public static void getCurrentCompositionLocalContext$annotations() {
    }

    public static final androidx.compose.runtime.RecomposeScope getCurrentRecomposeScope(androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 394957799;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C:Composables.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.<get-currentRecomposeScope> (Composables.kt:196)");
        }
        androidx.compose.runtime.RecomposeScope recomposeScope = $composer.getRecomposeScope();
        if (recomposeScope == null) {
        } else {
            $composer.recordUsed(recomposeScope);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            return recomposeScope;
        }
        IllegalStateException scope = new IllegalStateException("no recompose scope found".toString());
        throw scope;
    }

    public static final void invalidApplier() {
        IllegalStateException illegalStateException = new IllegalStateException("Invalid applier".toString());
        throw illegalStateException;
    }

    public static final <T> T key(Object[] keys, Function2<? super androidx.compose.runtime.Composer, ? super Integer, ? extends T> block, androidx.compose.runtime.Composer $composer, int $changed) {
        final int i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -11941951, "CC(key)P(1)132@4789L7:Composables.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        return block.invoke($composer, Integer.valueOf(i3 &= 14));
    }

    public static final <T> T remember(Object key1, Object key2, Object key3, Function0<? extends T> calculation, androidx.compose.runtime.Composer $composer, int $changed) {
        Object invoke;
        Object empty;
        final int i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 1618982084, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        androidx.compose.runtime.Composer composer = $composer;
        final int i5 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i6 = 0;
        if (i3 |= changed3 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                composer.updateRememberedValue(calculation.invoke());
            } else {
                invoke = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return invoke;
    }

    public static final <T> T remember(Object key1, Object key2, Function0<? extends T> calculation, androidx.compose.runtime.Composer $composer, int $changed) {
        Object invoke;
        Object empty;
        final int i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 511388516, "CC(remember)P(1,2):Composables.kt#9igjgp");
        androidx.compose.runtime.Composer composer = $composer;
        final int i4 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i5 = 0;
        if (changed |= changed2 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                composer.updateRememberedValue(calculation.invoke());
            } else {
                invoke = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return invoke;
    }

    public static final <T> T remember(Object key1, Function0<? extends T> calculation, androidx.compose.runtime.Composer $composer, int $changed) {
        Object invoke;
        Object empty;
        final int i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 1157296644, "CC(remember)P(1):Composables.kt#9igjgp");
        androidx.compose.runtime.Composer composer = $composer;
        final int i3 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i4 = 0;
        if (!$composer.changed(key1)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                composer.updateRememberedValue(calculation.invoke());
            } else {
                invoke = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return invoke;
    }

    public static final <T> T remember(Function0<? extends T> calculation, androidx.compose.runtime.Composer $composer, int $changed) {
        Object invoke;
        final int i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -492369756, "CC(remember):Composables.kt#9igjgp");
        int i3 = 0;
        androidx.compose.runtime.Composer composer = $composer;
        final int i4 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i5 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(calculation.invoke());
        } else {
            invoke = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return invoke;
    }

    public static final <T> T remember(Object[] keys, Function0<? extends T> calculation, androidx.compose.runtime.Composer $composer, int $changed) {
        int invalid;
        int i;
        Object obj;
        boolean changed;
        Object empty;
        Object invoke;
        final int i2 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -568225417, "CC(remember)P(1):Composables.kt#9igjgp");
        invalid = 0;
        i = 0;
        while (i < keys.length) {
            invalid |= changed;
            i++;
        }
        androidx.compose.runtime.Composer composer = $composer;
        int i4 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i5 = 0;
        if (invalid == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                composer.updateRememberedValue(calculation.invoke());
            } else {
                invoke = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return invoke;
    }

    public static final androidx.compose.runtime.CompositionContext rememberCompositionContext(androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1165786124;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberCompositionContext):Composables.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.rememberCompositionContext (Composables.kt:484)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return $composer.buildContext();
    }
}
