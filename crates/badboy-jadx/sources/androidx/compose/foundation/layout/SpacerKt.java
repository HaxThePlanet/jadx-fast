package androidx.compose.foundation.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"Spacer", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpacerKt {
    public static final void Spacer(Modifier modifier, Composer $composer, int $changed) {
        Integer valueOf2;
        int valueOf;
        boolean traceInProgress;
        String str;
        valueOf2 = $composer;
        valueOf = $changed;
        int i = -72882467;
        ComposerKt.sourceInformationMarkerStart(valueOf2, i, "C(Spacer)39@1433L64:Spacer.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, valueOf, -1, "androidx.compose.foundation.layout.Spacer (Spacer.kt:38)");
        }
        i2 |= 48;
        int i4 = 0;
        ComposerKt.sourceInformationMarkerStart(valueOf2, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(valueOf2, 0);
        final int i7 = 6;
        final int i8 = 0;
        ComposerKt.sourceInformationMarkerStart(valueOf2, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        if (!applier instanceof Applier) {
            ComposablesKt.invalidApplier();
        }
        valueOf2.startReusableNode();
        if (valueOf2.getInserting()) {
            valueOf2.createNode(ComposeUiNode.Companion.getConstructor());
        } else {
            valueOf2.useNode();
        }
        Composer constructor-impl = Updater.constructor-impl(valueOf2);
        int i10 = 0;
        Updater.set-impl(constructor-impl, (MeasurePolicy)SpacerMeasurePolicy.INSTANCE, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(constructor-impl, valueOf2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(valueOf2, modifier), ComposeUiNode.Companion.getSetModifier());
        int i11 = 0;
        final Composer composer = constructor-impl;
        final int i12 = 0;
        if (!composer.getInserting()) {
            if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
            }
        } else {
        }
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }
}
