package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001ay\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\n¢\u0006\u0002\u0008\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\n¢\u0006\u0002\u0008\u000bH\u0007¢\u0006\u0002\u0010\u0013\u001aR\u0010\u0014\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0014\u0008\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u00082#\u0008\u0002\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\u000c\u0008\u001a\u0012\u0008\u0008\u001b\u0012\u0004\u0008\u0008(\u001c\u0012\u0004\u0012\u00020\u00190\u0008H\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u001e", d2 = {"DismissVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "SwipeToDismissBox", "", "state", "Landroidx/compose/material3/SwipeToDismissBoxState;", "backgroundContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "enableDismissFromStartToEnd", "", "enableDismissFromEndToStart", "gesturesEnabled", "content", "(Landroidx/compose/material3/SwipeToDismissBoxState;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberSwipeToDismissBoxState", "initialValue", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "confirmValueChange", "positionalThreshold", "", "Lkotlin/ParameterName;", "name", "totalDistance", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeToDismissBoxState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SwipeToDismissBoxKt {

    private static final float DismissVelocityThreshold;
    static {
        final int i2 = 0;
        SwipeToDismissBoxKt.DismissVelocityThreshold = Dp.constructor-impl((float)i);
    }

    public static final void SwipeToDismissBox(androidx.compose.material3.SwipeToDismissBoxState state, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> backgroundContent, Modifier modifier, boolean enableDismissFromStartToEnd, boolean enableDismissFromEndToStart, boolean gesturesEnabled, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress2;
        boolean gesturesEnabled2;
        Integer currentCompositionLocalMap;
        Integer currentCompositionLocalMap2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        int obj4;
        int i16;
        Object it$iv;
        Integer valueOf;
        Object obj5;
        int $dirty3;
        Composer composer;
        int valueOf3;
        Object $dirty2;
        int i6;
        int i11;
        boolean traceInProgress;
        int i14;
        boolean z4;
        boolean str;
        boolean z3;
        Object obj3;
        Composer composer5;
        Object maybeCachedBoxMeasurePolicy;
        boolean z;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        androidx.compose.ui.Alignment.Vertical top;
        int i13;
        Object currentValue;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        Composer $i$a$LayoutBoxKt$Box$1$iv;
        Object settled;
        Integer valueOf2;
        boolean z5;
        int $dirty;
        int i25;
        Composer composer4;
        int i12;
        int i26;
        Object rowMeasurePolicy2;
        androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy;
        boolean z2;
        int i29;
        int i30;
        int i3;
        int i27;
        int i2;
        int i31;
        Object obj;
        int i36;
        int i18;
        int i24;
        int currentCompositeKeyHash;
        int i;
        Modifier modifier3;
        kotlin.jvm.functions.Function0 function0;
        int i32;
        int i4;
        int i9;
        int i34;
        Object obj2;
        int companion;
        int i17;
        int i19;
        int i28;
        Composer composer3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Modifier modifier2;
        int i23;
        BoxScopeInstance boxScopeInstance;
        int i37;
        kotlin.jvm.functions.Function0 function02;
        int i22;
        int i35;
        int $changed$iv;
        int i21;
        int i7;
        androidx.compose.ui.Alignment.Vertical vertical;
        kotlin.jvm.functions.Function0 function03;
        int i15;
        int i33;
        int i5;
        int i20;
        Composer composer2;
        int i8;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        int obj57;
        Modifier obj58;
        boolean obj59;
        Alignment obj60;
        int obj62;
        obj4 = state;
        obj5 = backgroundContent;
        final Object obj7 = content;
        top = $changed;
        final Composer restartGroup = $composer.startRestartGroup(-402577235);
        ComposerKt.sourceInformation(restartGroup, "C(SwipeToDismissBox)P(6!1,5,3,2,4)225@9211L7,227@9247L1205:SwipeToDismissBox.kt#uh7d8r");
        $dirty3 = $changed;
        if (i10 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (top & 6 == 0) {
                i6 = restartGroup.changed(obj4) ? 4 : 2;
                $dirty3 |= i6;
            }
        }
        if (i10 & 2 != 0) {
            $dirty3 |= 48;
        } else {
            if (top & 48 == 0) {
                i11 = restartGroup.changedInstance(obj5) ? 32 : 16;
                $dirty3 |= i11;
            }
        }
        int i55 = i10 & 4;
        if (i55 != 0) {
            $dirty3 |= 384;
            obj3 = modifier;
        } else {
            if (top & 384 == 0) {
                i13 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty3 |= i13;
            } else {
                obj3 = modifier;
            }
        }
        $i$a$LayoutBoxKt$Box$1$iv = i10 & 8;
        if ($i$a$LayoutBoxKt$Box$1$iv != 0) {
            $dirty3 |= 3072;
            z5 = enableDismissFromStartToEnd;
        } else {
            if (top & 3072 == 0) {
                i25 = restartGroup.changed(enableDismissFromStartToEnd) ? 2048 : 1024;
                $dirty3 |= i25;
            } else {
                z5 = enableDismissFromStartToEnd;
            }
        }
        rowMeasurePolicy = i10 & 16;
        if (rowMeasurePolicy != 0) {
            $dirty3 |= 24576;
            z2 = enableDismissFromEndToStart;
        } else {
            if (top & 24576 == 0) {
                i29 = restartGroup.changed(enableDismissFromEndToStart) ? 16384 : 8192;
                $dirty3 |= i29;
            } else {
                z2 = enableDismissFromEndToStart;
            }
        }
        i30 = i10 & 32;
        i3 = 196608;
        if (i30 != 0) {
            $dirty3 |= i3;
            str = gesturesEnabled;
        } else {
            if (top & i3 == 0) {
                i3 = restartGroup.changed(gesturesEnabled) ? 131072 : 65536;
                $dirty3 |= i3;
            } else {
                str = gesturesEnabled;
            }
        }
        if (i10 & 64 != 0) {
            i27 = 1572864;
            $dirty3 |= i27;
        } else {
        }
        if ($dirty3 & i2 == 599186) {
            if (!restartGroup.getSkipping()) {
                if (i55 != 0) {
                    obj = traceInProgress2;
                } else {
                    obj = obj3;
                }
                if ($i$a$LayoutBoxKt$Box$1$iv != 0) {
                    z5 = traceInProgress2;
                }
                if (rowMeasurePolicy != 0) {
                    z2 = traceInProgress2;
                }
                gesturesEnabled2 = i30 != 0 ? 1 : str;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-402577235, $dirty3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:224)");
                }
                int i56 = 0;
                int i57 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i58 = 1;
                i14 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? i58 : 0;
                if (gesturesEnabled2 && obj4.getCurrentValue() == SwipeToDismissBoxValue.Settled) {
                    i24 = obj4.getCurrentValue() == SwipeToDismissBoxValue.Settled ? i58 : 0;
                } else {
                }
                Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(obj, obj4.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, i24, false, 0, 24, 0);
                int i70 = 384;
                int i76 = i58;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart = Alignment.Companion.getTopStart();
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i76);
                i36 = 0;
                obj60 = topStart;
                String contentAlignment$iv = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, contentAlignment$iv);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(restartGroup, anchoredDraggable$default);
                modifier3 = anchoredDraggable$default;
                kotlin.jvm.functions.Function0 function04 = constructor2;
                i = 0;
                String $changed$iv5 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $changed$iv5);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function04);
                } else {
                    factory$iv$iv$iv2 = function04;
                    restartGroup.useNode();
                }
                function0 = factory$iv$iv$iv2;
                Composer constructor-impl2 = Updater.constructor-impl(restartGroup);
                int i111 = 0;
                i19 = i76;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i112 = 0;
                Composer composer10 = constructor-impl2;
                int i113 = 0;
                if (!composer10.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer10;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl2, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer6 = restartGroup;
                i34 = i41;
                ComposerKt.sourceInformationMarkerStart(composer6, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance iNSTANCE = BoxScopeInstance.INSTANCE;
                i28 = 0;
                modifier2 = materializeModifier3;
                i23 = i69;
                $i$a$LayoutBoxKt$Box$1$iv = composer9;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, -586717200, "C235@9549L71,239@9784L652,236@9629L817:SwipeToDismissBox.kt#uh7d8r");
                companion = 0;
                boxScopeInstance = iNSTANCE;
                int i114 = i63;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                androidx.compose.foundation.layout.Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                androidx.compose.ui.Alignment.Vertical top2 = Alignment.Companion.getTop();
                i35 = i80;
                rowMeasurePolicy2 = RowKt.rowMeasurePolicy(start, top2, $i$a$LayoutBoxKt$Box$1$iv, i116 | i120);
                int i121 = 0;
                androidx.compose.foundation.layout.Arrangement.Horizontal horizontal3 = start;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, -1323940314, contentAlignment$iv);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($i$a$LayoutBoxKt$Box$1$iv, 0);
                currentCompositionLocalMap2 = $i$a$LayoutBoxKt$Box$1$iv.getCurrentCompositionLocalMap();
                vertical = top2;
                kotlin.jvm.functions.Function0 function05 = constructor3;
                i7 = 0;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, -692256719, $changed$iv5);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $i$a$LayoutBoxKt$Box$1$iv.startReusableNode();
                if ($i$a$LayoutBoxKt$Box$1$iv.getInserting()) {
                    $i$a$LayoutBoxKt$Box$1$iv.createNode(function05);
                } else {
                    factory$iv$iv$iv = function05;
                    $i$a$LayoutBoxKt$Box$1$iv.useNode();
                }
                function03 = factory$iv$iv$iv;
                Composer constructor-impl = Updater.constructor-impl($i$a$LayoutBoxKt$Box$1$iv);
                int i122 = 0;
                i20 = i90;
                Updater.set-impl(constructor-impl, rowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i5 = 0;
                composer2 = constructor-impl;
                i8 = 0;
                if (!composer2.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy2 = rowMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = composer2;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy2 = rowMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier($i$a$LayoutBoxKt$Box$1$iv, (BoxScope)iNSTANCE.matchParentSize((Modifier)Modifier.Companion)), ComposeUiNode.Companion.getSetModifier());
                Composer composer7 = $i$a$LayoutBoxKt$Box$1$iv;
                int i81 = 0;
                i33 = i44;
                ComposerKt.sourceInformationMarkerStart(composer7, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                obj5.invoke(RowScopeInstance.INSTANCE, composer7, Integer.valueOf(i93 |= 6));
                ComposerKt.sourceInformationMarkerEnd(composer7);
                $i$a$LayoutBoxKt$Box$1$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, 396722910, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                i12 = $dirty3 & 7168 == 2048 ? 1 : 0;
                i16 = i96 &= $dirty3 == 16384 ? 1 : 0;
                i26 = $dirty3 & 14 == 4 ? 1 : 0;
                Composer composer8 = $i$a$LayoutBoxKt$Box$1$iv;
                int i99 = 0;
                it$iv = composer8.rememberedValue();
                int i106 = 0;
                if (i51 |= i26 == 0) {
                    obj62 = $dirty3;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        $dirty3 = 0;
                        obj2 = it$iv;
                        it$iv = new SwipeToDismissBoxKt.SwipeToDismissBox.1.1.1(obj4, z5, i14, z2);
                        composer8.updateRememberedValue((Function2)it$iv);
                    } else {
                        obj2 = it$iv;
                    }
                } else {
                    obj62 = $dirty3;
                }
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                i53 &= 7168;
                valueOf3 = 0;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                i31 = 0;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, -1323940314, contentAlignment$iv);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier($i$a$LayoutBoxKt$Box$1$iv, AnchoredDraggableKt.draggableAnchors((Modifier)Modifier.Companion, obj4.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, (Function2)it$iv));
                obj57 = currentCompositeKeyHash2;
                obj58 = constructor;
                i18 = 0;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, -692256719, $changed$iv5);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $i$a$LayoutBoxKt$Box$1$iv.startReusableNode();
                if ($i$a$LayoutBoxKt$Box$1$iv.getInserting()) {
                    $i$a$LayoutBoxKt$Box$1$iv.createNode(obj58);
                } else {
                    factory$iv$iv$iv3 = obj58;
                    $i$a$LayoutBoxKt$Box$1$iv.useNode();
                }
                Composer constructor-impl3 = Updater.constructor-impl($i$a$LayoutBoxKt$Box$1$iv);
                i9 = 0;
                function02 = factory$iv$iv$iv3;
                Updater.set-impl(constructor-impl3, RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), $i$a$LayoutBoxKt$Box$1$iv, i87 |= i101), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, $i$a$LayoutBoxKt$Box$1$iv.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i37 = 0;
                obj58 = constructor-impl3;
                i22 = 0;
                if (!obj58.getInserting()) {
                    $changed$iv = valueOf;
                    i21 = valueOf3;
                    if (!Intrinsics.areEqual(obj58.rememberedValue(), Integer.valueOf(obj57))) {
                        obj58.updateRememberedValue(Integer.valueOf(obj57));
                        constructor-impl3.apply(Integer.valueOf(obj57), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = obj58;
                    }
                } else {
                    $changed$iv = valueOf;
                    i21 = valueOf3;
                }
                Updater.set-impl(constructor-impl3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                i49 &= 14;
                obj5 = $i$a$LayoutBoxKt$Box$1$iv;
                int i54 = 0;
                obj58 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(obj5, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                obj7.invoke(RowScopeInstance.INSTANCE, obj5, Integer.valueOf(i73 |= 6));
                ComposerKt.sourceInformationMarkerEnd(obj5);
                $i$a$LayoutBoxKt$Box$1$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z = obj59;
                $dirty2 = obj;
                z4 = z5;
                z3 = z2;
            } else {
                restartGroup.skipToGroupEnd();
                obj62 = $dirty3;
                $dirty2 = obj3;
                z = str;
                z4 = z5;
                z3 = z2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = obj62;
            traceInProgress2 = new SwipeToDismissBoxKt.SwipeToDismissBox.2(state, backgroundContent, $dirty2, z4, z3, z, obj7, $changed, i10);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $dirty = obj62;
        }
    }

    public static final float access$getDismissVelocityThreshold$p() {
        return SwipeToDismissBoxKt.DismissVelocityThreshold;
    }

    public static final androidx.compose.material3.SwipeToDismissBoxState rememberSwipeToDismissBoxState(androidx.compose.material3.SwipeToDismissBoxValue initialValue, Function1<? super androidx.compose.material3.SwipeToDismissBoxValue, Boolean> confirmValueChange, Function1<? super Float, Float> positionalThreshold, Composer $composer, int $changed, int i6) {
        int i;
        int iNSTANCE;
        int i2;
        boolean changed3;
        int changed2;
        int i3;
        int changed;
        String str;
        Object empty;
        Object anon;
        androidx.compose.material3.SwipeToDismissBoxValue obj10;
        androidx.compose.material3.SwipeToDismissBoxKt.rememberSwipeToDismissBoxState.1 obj11;
        Function1 obj12;
        int obj15;
        int i4 = -246335487;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(rememberSwipeToDismissBoxState)P(1)185@7607L19,187@7687L7,195@7929L102,188@7706L325:SwipeToDismissBox.kt#uh7d8r");
        if (i6 & 1 != 0) {
            obj10 = SwipeToDismissBoxValue.Settled;
        }
        if (i6 & 2 != 0) {
            obj11 = iNSTANCE;
        }
        int i9 = 4;
        int i12 = 6;
        if (i6 &= i9 != 0) {
            obj12 = SwipeToDismissBoxDefaults.INSTANCE.getPositionalThreshold($composer, i12);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:186)");
        }
        int i5 = 0;
        int i16 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        obj15 = consume;
        i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -1333458863, "CC(remember):SwipeToDismissBox.kt#9igjgp");
        int i20 = 1;
        if (i12 ^= i19 > i9) {
            if (!$composer.changed(obj10)) {
                i2 = $changed & 6 == i9 ? i20 : i;
            } else {
            }
        } else {
        }
        int i22 = 32;
        if (i13 ^= 48 > i22) {
            if (!$composer.changed(obj11)) {
                i3 = $changed & 48 == i22 ? i20 : i;
            } else {
            }
        } else {
        }
        int i23 = 256;
        if (i14 ^= 384 > i23) {
            if (!$composer.changed(obj12)) {
                if ($changed & 384 == i23) {
                    i = i20;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i15 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i24 = 0;
        if (i |= i11 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new SwipeToDismissBoxKt.rememberSwipeToDismissBoxState.2.1(obj10, obj15, obj11, obj12);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Composer composer2 = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return (SwipeToDismissBoxState)RememberSaveableKt.rememberSaveable(new Object[i], SwipeToDismissBoxState.Companion.Saver(obj11, obj12, (Density)obj15), 0, (Function0)anon, composer2, 0, 4);
    }
}
