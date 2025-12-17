package androidx.compose.ui.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNode.Companion;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000A\n\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0001\u001a6\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u001d\u0010\u0007\u001a\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0008¢\u0006\u0002\u0008\u000cH\u0007¢\u0006\u0002\u0010\r\u001a>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u001d\u0010\u0007\u001a\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0008¢\u0006\u0002\u0008\u000cH\u0007¢\u0006\u0002\u0010\u0010\u001a\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0015", d2 = {"ReusedSlotId", "androidx/compose/ui/layout/SubcomposeLayoutKt$ReusedSlotId$1", "Landroidx/compose/ui/layout/SubcomposeLayoutKt$ReusedSlotId$1;", "SubcomposeLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "state", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "(Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SubcomposeSlotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "maxSlotsToRetainForReuse", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SubcomposeLayoutKt {

    private static final androidx.compose.ui.layout.SubcomposeLayoutKt.ReusedSlotId.1 ReusedSlotId;
    static {
        SubcomposeLayoutKt.ReusedSlotId.1 anon = new SubcomposeLayoutKt.ReusedSlotId.1();
        SubcomposeLayoutKt.ReusedSlotId = anon;
    }

    public static final void SubcomposeLayout(Modifier modifier, Function2<? super androidx.compose.ui.layout.SubcomposeMeasureScope, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> measurePolicy, Composer $composer, int $changed, int i5) {
        int anon;
        int $i$f$cache;
        int i3;
        int i4;
        int skipping;
        Object obj;
        int i2;
        Object empty;
        int i;
        Object subcomposeLayoutState;
        Object obj8;
        int obj10;
        anon = -1298353104;
        final Composer restartGroup = $composer.startRestartGroup(anon);
        ComposerKt.sourceInformation(restartGroup, "C(SubcomposeLayout)P(1)80@3810L36,79@3776L144:SubcomposeLayout.kt#80mrfh");
        obj10 = $changed;
        $i$f$cache = i5 & 1;
        if ($i$f$cache != 0) {
            obj10 |= 6;
        } else {
            if ($changed & 6 == 0) {
                i3 = restartGroup.changed(modifier) ? 4 : 2;
                obj10 |= i3;
            }
        }
        if (i5 & 2 != 0) {
            obj10 |= 48;
        } else {
            if ($changed & 48 == 0) {
                i4 = restartGroup.changedInstance(measurePolicy) ? 32 : 16;
                obj10 |= i4;
            }
        }
        if (obj10 & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if ($i$f$cache != 0) {
                    skipping = obj8;
                } else {
                    skipping = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, obj10, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:78)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1663495477, "CC(remember):SubcomposeLayout.kt#9igjgp");
                obj8 = 0;
                Composer composer = restartGroup;
                int i7 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i9 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    subcomposeLayoutState = new SubcomposeLayoutState();
                    composer.updateRememberedValue(subcomposeLayoutState);
                } else {
                    subcomposeLayoutState = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                SubcomposeLayoutKt.SubcomposeLayout((SubcomposeLayoutState)subcomposeLayoutState, skipping, measurePolicy, restartGroup, obj8 | anon, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj8 = skipping;
            } else {
                restartGroup.skipToGroupEnd();
                obj = measurePolicy;
            }
        } else {
        }
        final ScopeUpdateScope obj9 = restartGroup.endRestartGroup();
        if (obj9 != null) {
            anon = new SubcomposeLayoutKt.SubcomposeLayout.2(obj8, obj, $changed, i5);
            obj9.updateScope((Function2)anon);
        }
    }

    public static final void SubcomposeLayout(androidx.compose.ui.layout.SubcomposeLayoutState state, Modifier modifier, Function2<? super androidx.compose.ui.layout.SubcomposeMeasureScope, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> measurePolicy, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int i9;
        int $dirty2;
        Object obj;
        int $dirty;
        Object modifier3;
        Object valueOf;
        int i4;
        int currentCompositeKeyHash;
        boolean traceInProgress;
        Object rememberCompositionContext;
        int i3;
        int i8;
        int materializeModifier;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Object constructor$ui_release;
        int i5;
        Object empty;
        Object constructor-impl;
        int i;
        int i7;
        int i2;
        Object modifier2;
        Composer obj22;
        final Object obj2 = state;
        valueOf = measurePolicy;
        final int i13 = $changed;
        traceInProgress2 = -511989831;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(SubcomposeLayout)P(2,1)113@5266L23,114@5319L28,117@5475L487:SubcomposeLayout.kt#80mrfh");
        $dirty2 = $changed;
        if (i6 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i13 & 6 == 0) {
                i4 = restartGroup.changedInstance(obj2) ? 4 : 2;
                $dirty2 |= i4;
            }
        }
        currentCompositeKeyHash = i6 & 2;
        if (currentCompositeKeyHash != 0) {
            $dirty2 |= 48;
            rememberCompositionContext = modifier;
        } else {
            if (i13 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                rememberCompositionContext = modifier;
            }
        }
        if (i6 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (i13 & 384 == 0) {
                i8 = restartGroup.changedInstance(valueOf) ? 256 : 128;
                $dirty2 |= i8;
            }
        }
        int i15 = $dirty2;
        if (i15 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (currentCompositeKeyHash != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = rememberCompositionContext;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i15, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:112)");
                }
                int i10 = 0;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i10);
                i5 = 6;
                empty = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(LayoutNode.Companion.getConstructor$ui_release());
                } else {
                    restartGroup.useNode();
                }
                constructor-impl = Updater.constructor-impl(restartGroup);
                i = 0;
                Updater.set-impl(constructor-impl, obj2, obj2.getSetRoot$ui_release());
                Updater.set-impl(constructor-impl, ComposablesKt.rememberCompositionContext(restartGroup, i10), obj2.getSetCompositionContext$ui_release());
                Updater.set-impl(constructor-impl, valueOf, obj2.getSetMeasurePolicy$ui_release());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, modifier3), ComposeUiNode.Companion.getSetModifier());
                i7 = 0;
                obj22 = constructor-impl;
                i2 = 0;
                if (!obj22.getInserting()) {
                    modifier2 = modifier3;
                    if (!Intrinsics.areEqual(obj22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        valueOf = obj22;
                    }
                } else {
                    modifier2 = modifier3;
                }
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (!restartGroup.getSkipping()) {
                    restartGroup.startReplaceGroup(-26580342);
                    ComposerKt.sourceInformation(restartGroup, "130@6019L54,130@6008L65");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1663424771, "CC(remember):SubcomposeLayout.kt#9igjgp");
                    modifier3 = restartGroup;
                    valueOf = 0;
                    constructor$ui_release = modifier3.rememberedValue();
                    i5 = 0;
                    if (!restartGroup.changedInstance(obj2)) {
                        if (constructor$ui_release == Composer.Companion.getEmpty()) {
                            empty = 0;
                            constructor-impl = new SubcomposeLayoutKt.SubcomposeLayout.4.1(obj2);
                            modifier3.updateRememberedValue((Function0)constructor-impl);
                        } else {
                            constructor-impl = constructor$ui_release;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    EffectsKt.SideEffect((Function0)constructor-impl, restartGroup, 0);
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(-26502501);
                    restartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = modifier2;
            } else {
                restartGroup.skipToGroupEnd();
                obj = rememberCompositionContext;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SubcomposeLayoutKt.SubcomposeLayout.5(obj2, obj, measurePolicy, i13, i6);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final androidx.compose.ui.layout.SubcomposeSlotReusePolicy SubcomposeSlotReusePolicy(int maxSlotsToRetainForReuse) {
        FixedCountSubcomposeSlotReusePolicy fixedCountSubcomposeSlotReusePolicy = new FixedCountSubcomposeSlotReusePolicy(maxSlotsToRetainForReuse);
        return (SubcomposeSlotReusePolicy)fixedCountSubcomposeSlotReusePolicy;
    }

    public static final androidx.compose.ui.layout.SubcomposeLayoutKt.ReusedSlotId.1 access$getReusedSlotId$p() {
        return SubcomposeLayoutKt.ReusedSlotId;
    }
}
