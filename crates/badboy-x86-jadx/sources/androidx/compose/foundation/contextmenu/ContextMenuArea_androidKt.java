package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aF\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0017\u0010\u0008\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\u0008\u000bH\u0001¢\u0006\u0002\u0010\u000c\u001ac\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00052\u0017\u0010\u0008\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\u0008\u000b2\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u0011H\u0001¢\u0006\u0002\u0010\u0012¨\u0006\u0013", d2 = {"ContextMenu", "", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "contextMenuBuilderBlock", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/contextmenu/ContextMenuState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ContextMenuArea", "enabled", "", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/contextmenu/ContextMenuState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContextMenuArea_androidKt {
    public static final void ContextMenu(androidx.compose.foundation.contextmenu.ContextMenuState state, Function0<Unit> onDismiss, Modifier modifier, Function1<? super androidx.compose.foundation.contextmenu.ContextMenuScope, Unit> contextMenuBuilderBlock, Composer $composer, int $changed, int i7) {
        boolean traceInProgress;
        int invalid$iv;
        int $dirty;
        int $dirty2;
        boolean traceInProgress2;
        int i6;
        int i;
        int str;
        Object obj;
        int i4;
        Object obj2;
        int i2;
        int i5;
        Object empty;
        Composer restartGroup;
        androidx.compose.foundation.contextmenu.ContextMenuState.Status status;
        Object contextMenuPopupPositionProvider;
        long round-k-4lQ0M;
        int i3;
        i2 = $changed;
        invalid$iv = 645832757;
        restartGroup = $composer.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(restartGroup, "C(ContextMenu)P(3,2,1)67@2412L88,71@2506L197:ContextMenuArea.android.kt#3xeu6s");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i2 & 6 == 0) {
                i6 = restartGroup.changed(state) ? 4 : 2;
                $dirty |= i6;
            }
        }
        if (i7 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i2 & 48 == 0) {
                i = restartGroup.changedInstance(onDismiss) ? 32 : 16;
                $dirty |= i;
            }
        }
        str = i7 & 4;
        if (str != null) {
            $dirty |= 384;
            obj = modifier;
        } else {
            if (i2 & 384 == 0) {
                i4 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i4;
            } else {
                obj = modifier;
            }
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
            obj2 = contextMenuBuilderBlock;
        } else {
            if (i2 & 3072 == 0) {
                i5 = restartGroup.changedInstance(contextMenuBuilderBlock) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                obj2 = contextMenuBuilderBlock;
            }
        }
        final int i18 = $dirty;
        if (i18 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (str != null) {
                    obj = $dirty2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(invalid$iv, i18, -1, "androidx.compose.foundation.contextmenu.ContextMenu (ContextMenuArea.android.kt:63)");
                }
                status = state.getStatus();
                if (!status instanceof ContextMenuState.Status.Open && ComposerKt.isTraceInProgress()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup2 = restartGroup.endRestartGroup();
                    if (endRestartGroup2 != null) {
                        traceInProgress = new ContextMenuArea_androidKt.ContextMenu.1(state, onDismiss, obj, obj2, i2, i7);
                        endRestartGroup2.updateScope((Function2)traceInProgress);
                    }
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1573318964, "CC(remember):ContextMenuArea.android.kt#9igjgp");
                Composer composer = restartGroup;
                int i9 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i17 = 0;
                if (!restartGroup.changed(status)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        contextMenuPopupPositionProvider = new ContextMenuPopupPositionProvider(IntOffsetKt.round-k-4lQ0M((ContextMenuState.Status.Open)status.getOffset-F1C5BW0()), obj12, 0);
                        composer.updateRememberedValue(contextMenuPopupPositionProvider);
                    } else {
                        contextMenuPopupPositionProvider = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i2 = restartGroup;
                ContextMenuUi_androidKt.ContextMenuPopup((PopupPositionProvider)(ContextMenuPopupPositionProvider)contextMenuPopupPositionProvider, onDismiss, obj, contextMenuBuilderBlock, i2, i11 | i16, 0);
                restartGroup = i2;
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
            invalid$iv = new ContextMenuArea_androidKt.ContextMenu.2(state, onDismiss, obj, contextMenuBuilderBlock, $changed, i7);
            endRestartGroup.updateScope((Function2)invalid$iv);
        }
    }

    public static final void ContextMenuArea(androidx.compose.foundation.contextmenu.ContextMenuState state, Function0<Unit> onDismiss, Function1<? super androidx.compose.foundation.contextmenu.ContextMenuScope, Unit> contextMenuBuilderBlock, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        boolean traceInProgress;
        Object contextMenuGestures;
        Function0 i4;
        int $dirty;
        int companion;
        boolean traceInProgress2;
        boolean maybeCachedBoxMeasurePolicy;
        int i18;
        Object materialized$iv$iv2;
        Composer composer2;
        int valueOf;
        int i2;
        Object obj3;
        Object obj2;
        int i10;
        int str;
        boolean z;
        Object materialized$iv$iv;
        Object obj;
        int i20;
        int i21;
        Object i13;
        boolean z2;
        int i16;
        int i11;
        Object i17;
        int i15;
        int i7;
        int i8;
        int i22;
        int i14;
        int currentCompositeKeyHash;
        int i12;
        int i6;
        int i5;
        int i23;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        Alignment measurePolicy$iv2;
        int i;
        int i3;
        BoxScopeInstance boxScopeInstance;
        int i19;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        androidx.compose.runtime.CompositionLocalMap map;
        Modifier modifier2;
        Function0 function0;
        Composer composer;
        Alignment obj36;
        Function0 obj37;
        Composer obj39;
        traceInProgress = state;
        obj = content;
        i20 = $changed;
        i4 = -84584070;
        final Composer restartGroup = $composer.startRestartGroup(i4);
        ComposerKt.sourceInformation(restartGroup, "C(ContextMenuArea)P(5,4,1,3,2)46@1865L231:ContextMenuArea.android.kt#3xeu6s");
        $dirty = $changed;
        if (i9 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i20 & 6 == 0) {
                i18 = restartGroup.changed(traceInProgress) ? 4 : 2;
                $dirty |= i18;
            }
        }
        if (i9 & 2 != 0) {
            $dirty |= 48;
            materialized$iv$iv2 = onDismiss;
        } else {
            if (i20 & 48 == 0) {
                i2 = restartGroup.changedInstance(onDismiss) ? 32 : 16;
                $dirty |= i2;
            } else {
                materialized$iv$iv2 = onDismiss;
            }
        }
        if (i9 & 4 != 0) {
            $dirty |= 384;
            obj3 = contextMenuBuilderBlock;
        } else {
            if (i20 & 384 == 0) {
                i10 = restartGroup.changedInstance(contextMenuBuilderBlock) ? 256 : 128;
                $dirty |= i10;
            } else {
                obj3 = contextMenuBuilderBlock;
            }
        }
        str = i9 & 8;
        if (str != null) {
            $dirty |= 3072;
            materialized$iv$iv = modifier;
        } else {
            if (i20 & 3072 == 0) {
                i21 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty |= i21;
            } else {
                materialized$iv$iv = modifier;
            }
        }
        i13 = i9 & 16;
        if (i13 != 0) {
            $dirty |= 24576;
            z2 = enabled;
        } else {
            if (i20 & 24576 == 0) {
                i16 = restartGroup.changed(enabled) ? 16384 : 8192;
                $dirty |= i16;
            } else {
                z2 = enabled;
            }
        }
        int i53 = 196608;
        if (i9 & 32 != 0) {
            $dirty |= i53;
        } else {
            if (i20 & i53 == 0) {
                i11 = restartGroup.changedInstance(obj) ? 131072 : 65536;
                $dirty |= i11;
            }
        }
        int i52 = $dirty;
        if ($dirty2 &= i52 == 74898) {
            if (!restartGroup.getSkipping()) {
                if (str != null) {
                    i17 = companion;
                } else {
                    i17 = materialized$iv$iv;
                }
                if (i13 != 0) {
                    z2 = companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i4, i52, -1, "androidx.compose.foundation.contextmenu.ContextMenuArea (ContextMenuArea.android.kt:44)");
                }
                if (z2) {
                    contextMenuGestures = ContextMenuGestures_androidKt.contextMenuGestures(i17, traceInProgress);
                } else {
                    contextMenuGestures = i17;
                }
                i7 = i28;
                i8 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart = Alignment.Companion.getTopStart();
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, true);
                i14 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, contextMenuGestures);
                Function0 function02 = constructor;
                i12 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                valueOf = 0;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i54 = 0;
                obj39 = constructor-impl;
                int i55 = 0;
                if (!obj39.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    i = valueOf;
                    if (!Intrinsics.areEqual(obj39.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj39.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = obj39;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    i = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                i5 = i27 & 14;
                Composer composer3 = restartGroup;
                i23 = 0;
                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i3 = i38 | 6;
                boxScopeInstance = iNSTANCE;
                Composer composer5 = composer3;
                i19 = 0;
                ComposerKt.sourceInformationMarkerStart(composer5, -1754330561, "C47@1926L9,48@1944L146:ContextMenuArea.android.kt#3xeu6s");
                obj.invoke(composer5, Integer.valueOf(i32 &= 14));
                function0 = obj37;
                modifier2 = modifier3;
                map = currentCompositionLocalMap;
                measurePolicy = measurePolicy$iv;
                measurePolicy$iv2 = obj36;
                ContextMenuArea_androidKt.ContextMenu(state, onDismiss, 0, contextMenuBuilderBlock, composer5, i35 |= i41, 4);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = i17;
                z = z2;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = materialized$iv$iv;
                z = z2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ContextMenuArea_androidKt.ContextMenuArea.2(state, onDismiss, contextMenuBuilderBlock, obj2, z, obj, i20, i9);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }
}
