package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"SimpleLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SimpleLayoutKt {
    public static final void SimpleLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i5) {
        int traceInProgress;
        int $dirty;
        int valueOf;
        Object modifier2;
        Object obj;
        boolean traceInProgress2;
        Integer valueOf2;
        Composer composer;
        int i;
        int i9;
        boolean skipping;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Modifier materializeModifier;
        kotlin.jvm.functions.Function0 constructor;
        int i2;
        int i3;
        int i4;
        Composer composer2;
        int i6;
        int i7;
        int i8;
        Object obj20;
        int obj22;
        final Object obj2 = content;
        final int i10 = $changed;
        final int i11 = i5;
        traceInProgress = -2105228848;
        Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(SimpleLayout)P(1)32@1169L592:SimpleLayout.kt#eksfi3");
        $dirty = $changed;
        valueOf = i11 & 1;
        if (valueOf != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i10 & 6 == 0) {
                i = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i;
            } else {
                obj = modifier;
            }
        }
        if (i11 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i10 & 48 == 0) {
                i9 = restartGroup.changedInstance(obj2) ? 32 : 16;
                $dirty |= i9;
            }
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (valueOf != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.foundation.text.selection.SimpleLayout (SimpleLayout.kt:31)");
                }
                i17 |= i19;
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                i3 = 0;
                obj22 = $dirty;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    restartGroup.useNode();
                }
                $dirty = Updater.constructor-impl(restartGroup);
                i4 = 0;
                Updater.set-impl($dirty, (MeasurePolicy)SimpleLayoutKt.SimpleLayout.1.INSTANCE, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($dirty, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                valueOf = 0;
                composer2 = $dirty;
                i6 = 0;
                if (!composer2.getInserting()) {
                    i7 = valueOf;
                    i8 = valueOf2;
                    if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        $dirty.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer2;
                    }
                } else {
                    i7 = valueOf;
                    i8 = valueOf2;
                }
                Updater.set-impl($dirty, ComposedModifierKt.materializeModifier(restartGroup, modifier2), ComposeUiNode.Companion.getSetModifier());
                obj2.invoke(restartGroup, Integer.valueOf(i12 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj20;
            } else {
                restartGroup.skipToGroupEnd();
                obj22 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new SimpleLayoutKt.SimpleLayout.2(obj, obj2, i10, i11);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }
}
