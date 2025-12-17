package androidx.compose.ui.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNode.Companion;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006", d2 = {"TestModifierUpdaterLayout", "", "onAttached", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/TestModifierUpdater;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TestModifierUpdaterKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "It is a test API, do not use it in the real applications")
    public static final void TestModifierUpdaterLayout(Function1<? super androidx.compose.ui.layout.TestModifierUpdater, Unit> onAttached, Composer $composer, int $changed) {
        boolean currentCompositeKeyHash;
        int traceInProgress;
        int $dirty;
        int i4;
        int iNSTANCE;
        boolean traceInProgress2;
        int constructor$ui_release;
        int i;
        int i3;
        Composer constructor-impl;
        int i5;
        kotlin.jvm.functions.Function2 setCompositeKeyHash;
        int i2;
        Composer composer;
        int i6;
        Object rememberedValue;
        int obj17;
        final Object obj = onAttached;
        final int i7 = $changed;
        traceInProgress = -1673066036;
        Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(TestModifierUpdaterLayout)50@1816L23,54@1971L330:TestModifierUpdater.kt#80mrfh");
        constructor$ui_release = 2;
        if (i7 & 6 == 0) {
            i4 = restartGroup.changedInstance(obj) ? 4 : constructor$ui_release;
            $dirty |= i4;
        }
        if ($dirty & 3 == constructor$ui_release) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.ui.layout.TestModifierUpdaterLayout (TestModifierUpdater.kt:49)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                i = 6;
                i3 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1886828752, "CC(ComposeNode):Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(LayoutNode.Companion.getConstructor$ui_release());
                } else {
                    restartGroup.useNode();
                }
                constructor-impl = Updater.constructor-impl(restartGroup);
                i5 = 0;
                Updater.set-impl(constructor-impl, (MeasurePolicy)TestModifierUpdaterKt.TestModifierUpdaterLayout.measurePolicy.1.INSTANCE, ComposeUiNode.Companion.getSetMeasurePolicy());
                i2 = 0;
                composer = constructor-impl;
                i6 = 0;
                if (!composer.getInserting()) {
                    if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer.updateRememberedValue(Integer.valueOf(obj17));
                        constructor-impl.apply(Integer.valueOf(obj17), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    }
                } else {
                    obj17 = currentCompositeKeyHash;
                }
                TestModifierUpdaterKt.TestModifierUpdaterLayout.1.1 anon = new TestModifierUpdaterKt.TestModifierUpdaterLayout.1.1(obj);
                Updater.init-impl(constructor-impl, (Function1)anon);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
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
            iNSTANCE = new TestModifierUpdaterKt.TestModifierUpdaterLayout.2(obj, i7);
            endRestartGroup.updateScope((Function2)iNSTANCE);
        }
    }
}
