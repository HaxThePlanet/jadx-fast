package androidx.compose.foundation.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u001aJ\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\u0008\u0011¢\u0006\u0002\u0008\u0012H\u0087\u0008¢\u0006\u0002\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u0015\u001a5\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0000¢\u0006\u0002\u0010\u001f\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006 ", d2 = {"DefaultColumnMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultColumnMeasurePolicy$annotations", "()V", "getDefaultColumnMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "Column", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columnMeasurePolicy", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "createColumnConstraints", "Landroidx/compose/ui/unit/Constraints;", "isPrioritizing", "", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "(ZIIII)J", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColumnKt {

    private static final MeasurePolicy DefaultColumnMeasurePolicy;
    static {
        ColumnMeasurePolicy columnMeasurePolicy = new ColumnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart());
        ColumnKt.DefaultColumnMeasurePolicy = (MeasurePolicy)columnMeasurePolicy;
    }

    public static final void Column(Modifier modifier, androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        boolean valueOf;
        androidx.compose.ui.Modifier.Companion modifier2;
        Composer composer;
        androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement2;
        Alignment.Horizontal horizontalAlignment2;
        int $i$f$Column;
        androidx.compose.ui.Modifier.Companion companion;
        Composer composer2 = $composer;
        valueOf = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
        if (i7 & 1 != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if (i7 & 2 != 0) {
            verticalArrangement2 = Arrangement.INSTANCE.getTop();
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        if (i7 & 4 != 0) {
            horizontalAlignment2 = Alignment.Companion.getStart();
        } else {
            horizontalAlignment2 = horizontalAlignment;
        }
        final int i16 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        final int i22 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!applier instanceof Applier) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            composer2.createNode(ComposeUiNode.Companion.getConstructor());
        } else {
            composer2.useNode();
        }
        Composer constructor-impl = Updater.constructor-impl(composer2);
        int i25 = 0;
        Updater.set-impl(constructor-impl, ColumnKt.columnMeasurePolicy(verticalArrangement2, horizontalAlignment2, composer2, i10 |= i13), ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(constructor-impl, composer2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        int i29 = 0;
        Composer obj20 = constructor-impl;
        final int i30 = 0;
        if (!obj20.getInserting()) {
            $i$f$Column = valueOf;
            companion = modifier2;
            if (!Intrinsics.areEqual(obj20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                obj20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
            } else {
                composer = obj20;
            }
        } else {
            $i$f$Column = valueOf;
            companion = modifier2;
        }
        Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(composer2, modifier2), ComposeUiNode.Companion.getSetModifier());
        Composer composer3 = $composer;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
        obj20 = i2;
        content.invoke(ColumnScopeInstance.INSTANCE, composer3, Integer.valueOf(i27 |= 6));
        ComposerKt.sourceInformationMarkerEnd(composer3);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final MeasurePolicy columnMeasurePolicy(androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, Composer $composer, int $changed) {
        Object defaultColumnMeasurePolicy;
        boolean equal;
        int changed;
        int i3;
        boolean traceInProgress;
        int i;
        String str;
        Object rememberedValue;
        int changed2;
        int i2;
        Object empty;
        Object columnMeasurePolicy;
        int i4 = 1089876336;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(columnMeasurePolicy)P(1):Column.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.foundation.layout.columnMeasurePolicy (Column.kt:105)");
        }
        if (Intrinsics.areEqual(verticalArrangement, Arrangement.INSTANCE.getTop()) && Intrinsics.areEqual(horizontalAlignment, Alignment.Companion.getStart())) {
            if (Intrinsics.areEqual(horizontalAlignment, Alignment.Companion.getStart())) {
                $composer.startReplaceGroup(345884104);
                $composer.endReplaceGroup();
                defaultColumnMeasurePolicy = ColumnKt.DefaultColumnMeasurePolicy;
            } else {
                $composer.startReplaceGroup(345937951);
                ComposerKt.sourceInformation($composer, "108@4955L227");
                ComposerKt.sourceInformationMarkerStart($composer, -1789955725, "CC(remember):Column.kt#9igjgp");
                int i10 = 1;
                int i11 = 4;
                if (i8 ^= 6 > i11) {
                    if (!$composer.changed(verticalArrangement)) {
                        i3 = $changed & 6 == i11 ? i10 : i;
                    } else {
                    }
                } else {
                }
                int i13 = 32;
                if (i12 ^= 48 > i13) {
                    if (!$composer.changed(horizontalAlignment)) {
                        if ($changed & 48 == i13) {
                            i = i10;
                        }
                    } else {
                    }
                } else {
                }
                traceInProgress = $composer;
                str = 0;
                rememberedValue = traceInProgress.rememberedValue();
                i2 = 0;
                if (i3 |= i == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        columnMeasurePolicy = new ColumnMeasurePolicy(verticalArrangement, horizontalAlignment);
                        traceInProgress.updateRememberedValue(columnMeasurePolicy);
                    } else {
                        columnMeasurePolicy = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                defaultColumnMeasurePolicy = columnMeasurePolicy;
            }
        } else {
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultColumnMeasurePolicy;
    }

    public static final long createColumnConstraints(boolean isPrioritizing, int mainAxisMin, int crossAxisMin, int mainAxisMax, int crossAxisMax) {
        long fitPrioritizingHeight-Zbe2FdA;
        if (!isPrioritizing) {
            fitPrioritizingHeight-Zbe2FdA = ConstraintsKt.Constraints(crossAxisMin, crossAxisMax, mainAxisMin, mainAxisMax);
        } else {
            fitPrioritizingHeight-Zbe2FdA = Constraints.Companion.fitPrioritizingHeight-Zbe2FdA(crossAxisMin, crossAxisMax, mainAxisMin, mainAxisMax);
        }
        return fitPrioritizingHeight-Zbe2FdA;
    }

    public static final MeasurePolicy getDefaultColumnMeasurePolicy() {
        return ColumnKt.DefaultColumnMeasurePolicy;
    }

    public static void getDefaultColumnMeasurePolicy$annotations() {
    }
}
