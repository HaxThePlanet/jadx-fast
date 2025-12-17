package androidx.compose.foundation.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u001a\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001aJ\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00102\u001c\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0002\u0008\u001d¢\u0006\u0002\u0008\u001eH\u0087\u0008¢\u0006\u0002\u0010\u001f\u001a,\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001`\u00082\u0006\u0010\u0019\u001a\u00020\u0010H\u0002\u001a\u0018\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0010H\u0001\u001a\u001d\u0010#\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010$\u001a<\u0010%\u001a\u00020\u0014*\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000c2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010\"\u001a\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\"*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001`\u0008X\u0082\u0004¢\u0006\u0002\n\u0000\"*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001`\u0008X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u000c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e\"\u0018\u0010\u000f\u001a\u00020\u0010*\u00020\u000c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006/", d2 = {"DefaultBoxMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "EmptyBoxMeasurePolicy", "getEmptyBoxMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "cache1", "Ljava/util/HashMap;", "Landroidx/compose/ui/Alignment;", "Lkotlin/collections/HashMap;", "cache2", "boxChildDataNode", "Landroidx/compose/foundation/layout/BoxChildDataNode;", "Landroidx/compose/ui/layout/Measurable;", "getBoxChildDataNode", "(Landroidx/compose/ui/layout/Measurable;)Landroidx/compose/foundation/layout/BoxChildDataNode;", "matchesParentSize", "", "getMatchesParentSize", "(Landroidx/compose/ui/layout/Measurable;)Z", "Box", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "contentAlignment", "propagateMinConstraints", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "cacheFor", "maybeCachedBoxMeasurePolicy", "alignment", "rememberBoxMeasurePolicy", "(Landroidx/compose/ui/Alignment;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "placeInBox", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "measurable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "boxWidth", "", "boxHeight", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BoxKt {

    private static final MeasurePolicy DefaultBoxMeasurePolicy;
    private static final MeasurePolicy EmptyBoxMeasurePolicy = null;
    private static final HashMap<Alignment, MeasurePolicy> cache1;
    private static final HashMap<Alignment, MeasurePolicy> cache2;
    static {
        BoxKt.cache1 = BoxKt.cacheFor(true);
        int i2 = 0;
        BoxKt.cache2 = BoxKt.cacheFor(i2);
        BoxMeasurePolicy boxMeasurePolicy = new BoxMeasurePolicy(Alignment.Companion.getTopStart(), i2);
        BoxKt.DefaultBoxMeasurePolicy = (MeasurePolicy)boxMeasurePolicy;
        androidx.compose.foundation.layout.BoxKt.EmptyBoxMeasurePolicy.1 iNSTANCE = BoxKt.EmptyBoxMeasurePolicy.1.INSTANCE;
    }

    public static final void Box(Modifier modifier, Composer $composer, int $changed) {
        int traceInProgress;
        boolean restartGroup;
        int $dirty;
        int i2;
        int skipping;
        boolean traceInProgress2;
        int str;
        int currentCompositeKeyHash;
        Modifier materializeModifier;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        kotlin.jvm.functions.Function0 constructor;
        int i6;
        int i3;
        Composer constructor-impl;
        int i7;
        int i4;
        int i;
        Composer $composer2;
        int i5;
        Composer obj20;
        final Object obj = modifier;
        final int i8 = $changed;
        traceInProgress = -211209833;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Box)237@9098L66:Box.kt#2w3rfo");
        str = 2;
        if (i8 & 6 == 0) {
            i2 = restartGroup.changed(obj) ? 4 : str;
            $dirty |= i2;
        }
        if ($dirty & 3 == str) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.foundation.layout.Box (Box.kt:236)");
                }
                i9 |= 48;
                str = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                i6 = 6;
                i3 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    restartGroup.useNode();
                }
                constructor-impl = Updater.constructor-impl(restartGroup);
                i7 = 0;
                Updater.set-impl(constructor-impl, BoxKt.EmptyBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, obj), ComposeUiNode.Companion.getSetModifier());
                i4 = 0;
                obj20 = constructor-impl;
                i = 0;
                if (!obj20.getInserting()) {
                    $composer2 = restartGroup;
                    i5 = $dirty;
                    if (!Intrinsics.areEqual(obj20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        $dirty = obj20;
                    }
                } else {
                    $composer2 = restartGroup;
                    i5 = $dirty;
                }
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                $composer2 = restartGroup;
                i5 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            restartGroup = new BoxKt.Box.2(obj, i8);
            endRestartGroup.updateScope((Function2)restartGroup);
        }
    }

    public static final void Box(Modifier modifier, Alignment contentAlignment, boolean propagateMinConstraints, Function3<? super androidx.compose.foundation.layout.BoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        boolean valueOf;
        androidx.compose.ui.Modifier.Companion modifier2;
        Composer composer;
        Alignment contentAlignment2;
        int propagateMinConstraints2;
        int $i$f$Box;
        androidx.compose.ui.Modifier.Companion companion;
        Composer composer2 = $composer;
        valueOf = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
        if (i7 & 1 != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if (i7 & 2 != 0) {
            contentAlignment2 = Alignment.Companion.getTopStart();
        } else {
            contentAlignment2 = contentAlignment;
        }
        propagateMinConstraints2 = i7 & 4 != 0 ? 0 : propagateMinConstraints;
        final int i11 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        final int i17 = 0;
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
        int i20 = 0;
        Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment2, propagateMinConstraints2), ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(constructor-impl, composer2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        int i24 = 0;
        Composer obj20 = constructor-impl;
        final int i25 = 0;
        if (!obj20.getInserting()) {
            $i$f$Box = valueOf;
            companion = modifier2;
            if (!Intrinsics.areEqual(obj20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                obj20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
            } else {
                composer = obj20;
            }
        } else {
            $i$f$Box = valueOf;
            companion = modifier2;
        }
        Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(composer2, modifier2), ComposeUiNode.Companion.getSetModifier());
        Composer composer3 = $composer;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
        obj20 = i2;
        content.invoke(BoxScopeInstance.INSTANCE, composer3, Integer.valueOf(i22 |= 6));
        ComposerKt.sourceInformationMarkerEnd(composer3);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final boolean access$getMatchesParentSize(Measurable $receiver) {
        return BoxKt.getMatchesParentSize($receiver);
    }

    public static final void access$placeInBox(Placeable.PlacementScope $receiver, Placeable placeable, Measurable measurable, LayoutDirection layoutDirection, int boxWidth, int boxHeight, Alignment alignment) {
        BoxKt.placeInBox($receiver, placeable, measurable, layoutDirection, boxWidth, boxHeight, alignment);
    }

    private static final HashMap<Alignment, MeasurePolicy> cacheFor(boolean propagateMinConstraints) {
        HashMap hashMap = new HashMap(9);
        HashMap map = hashMap;
        final int i2 = 0;
        BoxKt.cacheFor$lambda$1$putAlignment(map, propagateMinConstraints, Alignment.Companion.getTopStart());
        BoxKt.cacheFor$lambda$1$putAlignment(map, propagateMinConstraints, Alignment.Companion.getTopCenter());
        BoxKt.cacheFor$lambda$1$putAlignment(map, propagateMinConstraints, Alignment.Companion.getTopEnd());
        BoxKt.cacheFor$lambda$1$putAlignment(map, propagateMinConstraints, Alignment.Companion.getCenterStart());
        BoxKt.cacheFor$lambda$1$putAlignment(map, propagateMinConstraints, Alignment.Companion.getCenter());
        BoxKt.cacheFor$lambda$1$putAlignment(map, propagateMinConstraints, Alignment.Companion.getCenterEnd());
        BoxKt.cacheFor$lambda$1$putAlignment(map, propagateMinConstraints, Alignment.Companion.getBottomStart());
        BoxKt.cacheFor$lambda$1$putAlignment(map, propagateMinConstraints, Alignment.Companion.getBottomCenter());
        BoxKt.cacheFor$lambda$1$putAlignment(map, propagateMinConstraints, Alignment.Companion.getBottomEnd());
        return hashMap;
    }

    private static final void cacheFor$lambda$1$putAlignment(HashMap<Alignment, MeasurePolicy> $this_apply, boolean $propagateMinConstraints, Alignment it) {
        BoxMeasurePolicy boxMeasurePolicy = new BoxMeasurePolicy(it, $propagateMinConstraints);
        $this_apply.put(it, boxMeasurePolicy);
    }

    private static final androidx.compose.foundation.layout.BoxChildDataNode getBoxChildDataNode(Measurable $this$boxChildDataNode) {
        Object parentData;
        if (parentData instanceof BoxChildDataNode) {
        } else {
            parentData = 0;
        }
        return parentData;
    }

    public static final MeasurePolicy getEmptyBoxMeasurePolicy() {
        return BoxKt.EmptyBoxMeasurePolicy;
    }

    private static final boolean getMatchesParentSize(Measurable $this$matchesParentSize) {
        boolean matchParentSize;
        androidx.compose.foundation.layout.BoxChildDataNode boxChildDataNode = BoxKt.getBoxChildDataNode($this$matchesParentSize);
        if (boxChildDataNode != null) {
            matchParentSize = boxChildDataNode.getMatchParentSize();
        } else {
            matchParentSize = 0;
        }
        return matchParentSize;
    }

    public static final MeasurePolicy maybeCachedBoxMeasurePolicy(Alignment alignment, boolean propagateMinConstraints) {
        HashMap cache1;
        Object boxMeasurePolicy;
        cache1 = propagateMinConstraints ? BoxKt.cache1 : BoxKt.cache2;
        if ((MeasurePolicy)cache1.get(alignment) == null) {
            boxMeasurePolicy = new BoxMeasurePolicy(alignment, propagateMinConstraints);
        }
        return boxMeasurePolicy;
    }

    private static final void placeInBox(Placeable.PlacementScope $this$placeInBox, Placeable placeable, Measurable measurable, LayoutDirection layoutDirection, int boxWidth, int boxHeight, Alignment alignment) {
        Alignment boxChildDataNode;
        boxChildDataNode = BoxKt.getBoxChildDataNode(measurable);
        if (boxChildDataNode != null) {
            if (boxChildDataNode.getAlignment() == null) {
                boxChildDataNode = alignment;
            }
        } else {
        }
        Placeable.PlacementScope.place-70tqf50$default($this$placeInBox, placeable, boxChildDataNode.align-KFBX0sM(IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight()), obj3, IntSizeKt.IntSize(boxWidth, boxHeight)), obj9, 0, 2);
    }

    public static final MeasurePolicy rememberBoxMeasurePolicy(Alignment alignment, boolean propagateMinConstraints, Composer $composer, int $changed) {
        Object defaultBoxMeasurePolicy;
        int changed;
        int i2;
        boolean traceInProgress;
        int i3;
        String str;
        Object rememberedValue;
        int changed2;
        int i;
        Object empty;
        Object boxMeasurePolicy;
        int i4 = 56522820;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(rememberBoxMeasurePolicy):Box.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:113)");
        }
        if (Intrinsics.areEqual(alignment, Alignment.Companion.getTopStart()) && !propagateMinConstraints) {
            if (!propagateMinConstraints) {
                $composer.startReplaceGroup(-1710139705);
                $composer.endReplaceGroup();
                defaultBoxMeasurePolicy = BoxKt.DefaultBoxMeasurePolicy;
            } else {
                $composer.startReplaceGroup(-1710100211);
                ComposerKt.sourceInformation($composer, "116@4696L113");
                ComposerKt.sourceInformationMarkerStart($composer, -55164339, "CC(remember):Box.kt#9igjgp");
                int i10 = 1;
                int i11 = 4;
                if (i8 ^= 6 > i11) {
                    if (!$composer.changed(alignment)) {
                        i2 = $changed & 6 == i11 ? i10 : i3;
                    } else {
                    }
                } else {
                }
                int i13 = 32;
                if (i12 ^= 48 > i13) {
                    if (!$composer.changed(propagateMinConstraints)) {
                        if ($changed & 48 == i13) {
                            i3 = i10;
                        }
                    } else {
                    }
                } else {
                }
                traceInProgress = $composer;
                str = 0;
                rememberedValue = traceInProgress.rememberedValue();
                i = 0;
                if (i2 |= i3 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        boxMeasurePolicy = new BoxMeasurePolicy(alignment, propagateMinConstraints);
                        traceInProgress.updateRememberedValue(boxMeasurePolicy);
                    } else {
                        boxMeasurePolicy = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                defaultBoxMeasurePolicy = boxMeasurePolicy;
            }
        } else {
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultBoxMeasurePolicy;
    }
}
