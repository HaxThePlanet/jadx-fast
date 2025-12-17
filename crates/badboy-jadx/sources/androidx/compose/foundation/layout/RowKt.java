package androidx.compose.foundation.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Alignment.Vertical;
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
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u001aJ\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\u0008\u0011¢\u0006\u0002\u0008\u0012H\u0087\u0008¢\u0006\u0002\u0010\u0013\u001a5\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0000¢\u0006\u0002\u0010\u001d\u001a\u001d\u0010\u001e\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u001f\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006 ", d2 = {"DefaultRowMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultRowMeasurePolicy$annotations", "()V", "getDefaultRowMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "Row", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "createRowConstraints", "Landroidx/compose/ui/unit/Constraints;", "isPrioritizing", "", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "(ZIIII)J", "rowMeasurePolicy", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RowKt {

    private static final MeasurePolicy DefaultRowMeasurePolicy;
    static {
        RowMeasurePolicy rowMeasurePolicy = new RowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop());
        RowKt.DefaultRowMeasurePolicy = (MeasurePolicy)rowMeasurePolicy;
    }

    public static final void Row(Modifier modifier, androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, Function3<? super androidx.compose.foundation.layout.RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        boolean valueOf;
        androidx.compose.ui.Modifier.Companion modifier2;
        Composer composer;
        androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement2;
        Alignment.Vertical verticalAlignment2;
        int $i$f$Row;
        androidx.compose.ui.Modifier.Companion companion;
        Composer composer2 = $composer;
        valueOf = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
        if (i7 & 1 != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if (i7 & 2 != 0) {
            horizontalArrangement2 = Arrangement.INSTANCE.getStart();
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        if (i7 & 4 != 0) {
            verticalAlignment2 = Alignment.Companion.getTop();
        } else {
            verticalAlignment2 = verticalAlignment;
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
        Updater.set-impl(constructor-impl, RowKt.rowMeasurePolicy(horizontalArrangement2, verticalAlignment2, composer2, i10 |= i13), ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(constructor-impl, composer2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        int i29 = 0;
        Composer obj20 = constructor-impl;
        final int i30 = 0;
        if (!obj20.getInserting()) {
            $i$f$Row = valueOf;
            companion = modifier2;
            if (!Intrinsics.areEqual(obj20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                obj20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
            } else {
                composer = obj20;
            }
        } else {
            $i$f$Row = valueOf;
            companion = modifier2;
        }
        Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(composer2, modifier2), ComposeUiNode.Companion.getSetModifier());
        Composer composer3 = $composer;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
        obj20 = i2;
        content.invoke(RowScopeInstance.INSTANCE, composer3, Integer.valueOf(i27 |= 6));
        ComposerKt.sourceInformationMarkerEnd(composer3);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final long createRowConstraints(boolean isPrioritizing, int mainAxisMin, int crossAxisMin, int mainAxisMax, int crossAxisMax) {
        long fitPrioritizingWidth-Zbe2FdA;
        if (!isPrioritizing) {
            fitPrioritizingWidth-Zbe2FdA = ConstraintsKt.Constraints(mainAxisMin, mainAxisMax, crossAxisMin, crossAxisMax);
        } else {
            fitPrioritizingWidth-Zbe2FdA = Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(mainAxisMin, mainAxisMax, crossAxisMin, crossAxisMax);
        }
        return fitPrioritizingWidth-Zbe2FdA;
    }

    public static final MeasurePolicy getDefaultRowMeasurePolicy() {
        return RowKt.DefaultRowMeasurePolicy;
    }

    public static void getDefaultRowMeasurePolicy$annotations() {
    }

    public static final MeasurePolicy rowMeasurePolicy(androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, Composer $composer, int $changed) {
        Object defaultRowMeasurePolicy;
        boolean equal;
        int changed;
        int i2;
        boolean traceInProgress;
        int i;
        String str;
        Object rememberedValue;
        int changed2;
        int i3;
        Object empty;
        Object rowMeasurePolicy;
        int i4 = -837807694;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(rowMeasurePolicy):Row.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.foundation.layout.rowMeasurePolicy (Row.kt:121)");
        }
        if (Intrinsics.areEqual(horizontalArrangement, Arrangement.INSTANCE.getStart()) && Intrinsics.areEqual(verticalAlignment, Alignment.Companion.getTop())) {
            if (Intrinsics.areEqual(verticalAlignment, Alignment.Companion.getTop())) {
                $composer.startReplaceGroup(-849160037);
                $composer.endReplaceGroup();
                defaultRowMeasurePolicy = RowKt.DefaultRowMeasurePolicy;
            } else {
                $composer.startReplaceGroup(-849109166);
                ComposerKt.sourceInformation($composer, "124@5724L224");
                ComposerKt.sourceInformationMarkerStart($composer, -1828505632, "CC(remember):Row.kt#9igjgp");
                int i10 = 1;
                int i11 = 4;
                if (i8 ^= 6 > i11) {
                    if (!$composer.changed(horizontalArrangement)) {
                        i2 = $changed & 6 == i11 ? i10 : i;
                    } else {
                    }
                } else {
                }
                int i13 = 32;
                if (i12 ^= 48 > i13) {
                    if (!$composer.changed(verticalAlignment)) {
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
                i3 = 0;
                if (i2 |= i == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        rowMeasurePolicy = new RowMeasurePolicy(horizontalArrangement, verticalAlignment);
                        traceInProgress.updateRememberedValue(rowMeasurePolicy);
                    } else {
                        rowMeasurePolicy = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                defaultRowMeasurePolicy = rowMeasurePolicy;
            }
        } else {
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultRowMeasurePolicy;
    }
}
