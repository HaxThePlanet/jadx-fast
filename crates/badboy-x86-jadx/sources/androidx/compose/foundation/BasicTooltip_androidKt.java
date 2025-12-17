package androidx.compose.foundation;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u0006H\u0007¢\u0006\u0002\u0010\u000f\u001a@\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u000c2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u0006H\u0003¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u0006H\u0003¢\u0006\u0002\u0010\u0015\u001a,\u0010\u0016\u001a\u00020\n*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u001c\u0010\u001a\u001a\u00020\n*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u0008H\u0002¨\u0006\u001b", d2 = {"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/foundation/BasicTooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/foundation/BasicTooltipState;Lkotlinx/coroutines/CoroutineScope;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "WrappedAnchor", "(ZLandroidx/compose/foundation/BasicTooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "anchorSemantics", "label", "", "enabled", "handleGestures", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BasicTooltip_androidKt {
    public static final void BasicTooltipBox(PopupPositionProvider positionProvider, Function2<? super Composer, ? super Integer, Unit> tooltip, androidx.compose.foundation.BasicTooltipState state, Modifier modifier, boolean focusable, boolean enableUserInput, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        Object compositionCoroutineScope;
        int $composer$iv;
        int anon;
        Object compositionScopedCoroutineScopeCanceller;
        int propagateMinConstraints$iv;
        Object obj5;
        int $dirty;
        int companion2;
        boolean traceInProgress2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        boolean visible;
        Object traceInProgress;
        int valueOf;
        Composer composer3;
        String str2;
        int i;
        Object obj6;
        Composer composer;
        Object obj3;
        int i20;
        int i16;
        int str;
        boolean z3;
        Object obj;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        boolean z2;
        Object obj4;
        int materializeModifier;
        int i9;
        int i13;
        boolean anon2;
        Alignment focusable2;
        int i17;
        int i5;
        boolean z;
        int i8;
        Object obj2;
        int i14;
        int i11;
        int i12;
        Object iNSTANCE;
        int currentCompositeKeyHash;
        int i7;
        int i15;
        int i3;
        androidx.compose.ui.Modifier.Companion companion;
        int i2;
        androidx.compose.ui.layout.MeasurePolicy factory$iv$iv$iv;
        int i6;
        int i21;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        int i4;
        BoxScopeInstance boxScopeInstance;
        int i18;
        kotlin.jvm.functions.Function0 function0;
        Composer composer2;
        int i19;
        CoroutineScope scope;
        boolean z4;
        Object obj38;
        Alignment obj39;
        int obj40;
        final int i74 = $changed;
        anon = -868234445;
        final Composer restartGroup = $composer.startRestartGroup(anon);
        ComposerKt.sourceInformation(restartGroup, "C(BasicTooltipBox)P(4,6,5,3,2,1)75@3416L24,76@3445L451,95@3926L47,95@3902L71:BasicTooltip.android.kt#71ulvw");
        $dirty = $changed;
        if (i10 & 1 != 0) {
            $dirty |= 6;
            traceInProgress = positionProvider;
        } else {
            if (i74 & 6 == 0) {
                i = restartGroup.changed(positionProvider) ? 4 : 2;
                $dirty |= i;
            } else {
                traceInProgress = positionProvider;
            }
        }
        if (i10 & 2 != 0) {
            $dirty |= 48;
            obj6 = tooltip;
        } else {
            if (i74 & 48 == 0) {
                i20 = restartGroup.changedInstance(tooltip) ? 32 : 16;
                $dirty |= i20;
            } else {
                obj6 = tooltip;
            }
        }
        if (i10 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i74 & 384 == 0) {
                i16 = restartGroup.changed(state) ? 256 : 128;
                $dirty |= i16;
            }
        }
        str = i10 & 8;
        if (str != null) {
            $dirty |= 3072;
            obj = modifier;
        } else {
            if (i74 & 3072 == 0) {
                i9 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty |= i9;
            } else {
                obj = modifier;
            }
        }
        i13 = i10 & 16;
        if (i13 != 0) {
            $dirty |= 24576;
            anon2 = focusable;
        } else {
            if (i74 & 24576 == 0) {
                i17 = restartGroup.changed(focusable) ? 16384 : 8192;
                $dirty |= i17;
            } else {
                anon2 = focusable;
            }
        }
        i5 = i10 & 32;
        int i78 = 196608;
        if (i5 != 0) {
            $dirty |= i78;
            z = enableUserInput;
        } else {
            if (i78 &= i74 == 0) {
                i8 = restartGroup.changed(enableUserInput) ? 131072 : 65536;
                $dirty |= i8;
            } else {
                z = enableUserInput;
            }
        }
        i14 = 1572864;
        if (i10 & 64 != 0) {
            $dirty |= i14;
            obj2 = content;
        } else {
            if (i74 & i14 == 0) {
                i14 = restartGroup.changedInstance(content) ? 1048576 : 524288;
                $dirty |= i14;
            } else {
                obj2 = content;
            }
        }
        int i82 = $dirty;
        if ($dirty2 &= i82 == 599186) {
            if (!restartGroup.getSkipping()) {
                if (str != null) {
                    obj4 = companion2;
                } else {
                    obj4 = obj;
                }
                if (i13 != 0) {
                    anon2 = companion2;
                }
                if (i5 != 0) {
                    z = companion2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, i82, -1, "androidx.compose.foundation.BasicTooltipBox (BasicTooltip.android.kt:74)");
                }
                int i75 = 0;
                int i41 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                int i71 = 0;
                Composer composer7 = restartGroup;
                int i83 = 0;
                obj38 = i75;
                Object rememberedValue3 = composer7.rememberedValue();
                int i85 = 0;
                obj39 = i22;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    int i86 = 0;
                    obj40 = i23;
                    compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, restartGroup));
                    composer7.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                } else {
                    compositionScopedCoroutineScopeCanceller = rememberedValue3;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i76 = obj38;
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                androidx.compose.ui.Modifier.Companion companion3 = Modifier.Companion;
                Alignment topStart = Alignment.Companion.getTopStart();
                int i67 = 0;
                measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i67);
                i12 = 0;
                obj39 = topStart;
                obj40 = $i$f$rememberCoroutineScope;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, obj38);
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                kotlin.jvm.functions.Function0 function02 = constructor;
                i7 = 0;
                companion = companion3;
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
                kotlin.jvm.functions.Function0 function03 = function02;
                Updater.set-impl(constructor-impl, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i87 = 0;
                Composer composer8 = constructor-impl;
                int i88 = 0;
                if (!composer8.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    i4 = valueOf;
                    if (!Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer8;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    i4 = valueOf;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, (Modifier)companion3), ComposeUiNode.Companion.getSetModifier());
                i2 = i25 & 14;
                Composer composer4 = restartGroup;
                i6 = 0;
                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i21 = i43 | 6;
                boxScopeInstance = iNSTANCE2;
                propagateMinConstraints$iv = i67;
                Composer propagateMinConstraints$iv2 = composer4;
                i18 = 0;
                ComposerKt.sourceInformationMarkerStart(propagateMinConstraints$iv2, 136799737, "C87@3729L161:BasicTooltip.android.kt#71ulvw");
                if (state.isVisible()) {
                    propagateMinConstraints$iv2.startReplaceGroup(136814616);
                    ComposerKt.sourceInformation(propagateMinConstraints$iv2, "78@3494L215");
                    composer2 = composer4;
                    i15 = propagateMinConstraints$iv;
                    str2 = anon2;
                    function0 = function03;
                    i19 = 0;
                    focusable2 = obj39;
                    factory$iv$iv$iv = measurePolicy$iv;
                    visible = obj40;
                    BasicTooltip_androidKt.TooltipPopup(positionProvider, state, visible, str2, obj6, propagateMinConstraints$iv2, i48 |= i61);
                    scope = visible;
                    z4 = str2;
                    propagateMinConstraints$iv2.endReplaceGroup();
                } else {
                    scope = obj40;
                    composer2 = composer4;
                    i15 = propagateMinConstraints$iv;
                    composer = propagateMinConstraints$iv2;
                    z4 = anon2;
                    function0 = function03;
                    i19 = 0;
                    focusable2 = obj39;
                    factory$iv$iv$iv = measurePolicy$iv;
                    composer.startReplaceGroup(137044295);
                    composer.endReplaceGroup();
                }
                obj5 = state;
                companion2 = obj38;
                anon = z;
                BasicTooltip_androidKt.WrappedAnchor(anon, obj5, companion2, obj2, composer, i29 | i40, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 740291627, "CC(remember):BasicTooltip.android.kt#9igjgp");
                i13 = i82 & 896 == 256 ? 1 : i19;
                Composer composer5 = restartGroup;
                int i65 = 0;
                Object rememberedValue2 = composer5.rememberedValue();
                int i73 = 0;
                if (i13 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        materializeModifier = 0;
                        anon2 = new BasicTooltip_androidKt.BasicTooltipBox.2.1(obj5);
                        composer5.updateRememberedValue((Function1)anon2);
                    } else {
                        anon2 = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.DisposableEffect(obj5, (Function1)anon2, restartGroup, i54 &= 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z2 = anon;
                obj3 = companion2;
                z3 = z4;
            } else {
                restartGroup.skipToGroupEnd();
                obj3 = obj;
                z3 = anon2;
                z2 = z;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new BasicTooltip_androidKt.BasicTooltipBox.3(positionProvider, tooltip, obj5, obj3, z3, z2, content, i74, i10);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    private static final void TooltipPopup(PopupPositionProvider positionProvider, androidx.compose.foundation.BasicTooltipState state, CoroutineScope scope, boolean focusable, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int stringResource;
        int $dirty2;
        int i7;
        int i3;
        int i10;
        int i2;
        int i4;
        int traceInProgress;
        boolean traceInProgress2;
        int i8;
        Object obj;
        int $this$cache$iv;
        int $dirty;
        int popupProperties;
        Object anon;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i5;
        boolean z;
        int i11;
        Object empty;
        int i6;
        int i;
        int i9;
        final Object obj3 = state;
        final Object obj4 = scope;
        final Object obj5 = content;
        final int i14 = $changed;
        stringResource = -73658727;
        final Composer restartGroup = $composer.startRestartGroup(stringResource);
        ComposerKt.sourceInformation(restartGroup, "C(TooltipPopup)P(2,4,3,1)125@4750L44,128@4883L109,134@5060L203,126@4799L464:BasicTooltip.android.kt#71ulvw");
        if (i14 & 6 == 0) {
            i7 = restartGroup.changed(positionProvider) ? 4 : 2;
            $dirty2 |= i7;
        } else {
            obj = positionProvider;
        }
        $this$cache$iv = 32;
        if (i14 & 48 == 0) {
            i3 = restartGroup.changed(obj3) ? $this$cache$iv : 16;
            $dirty2 |= i3;
        }
        if (i14 & 384 == 0) {
            i10 = restartGroup.changedInstance(obj4) ? 256 : 128;
            $dirty2 |= i10;
        }
        if (i14 & 3072 == 0) {
            i2 = restartGroup.changed(focusable) ? 2048 : 1024;
            $dirty2 |= i2;
        } else {
            z = focusable;
        }
        if (i14 & 24576 == 0) {
            i4 = restartGroup.changedInstance(obj5) ? 16384 : 8192;
            $dirty2 |= i4;
        }
        if ($dirty2 & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(stringResource, $dirty2, -1, "androidx.compose.foundation.TooltipPopup (BasicTooltip.android.kt:124)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1255640176, "CC(remember):BasicTooltip.android.kt#9igjgp");
                if ($dirty2 & 112 == $this$cache$iv) {
                    i8 = 1;
                }
                Composer composer = restartGroup;
                int i17 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i21 = 0;
                if (i8 |= changedInstance3 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new BasicTooltip_androidKt.TooltipPopup.1.1(obj3, obj4);
                        composer.updateRememberedValue((Function0)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                super(z, 0, 0, 0, 14, 0);
                BasicTooltip_androidKt.TooltipPopup.2 anon2 = new BasicTooltip_androidKt.TooltipPopup.2(StringResources_androidKt.stringResource(R.string.tooltip_description, restartGroup, 0), obj5);
                AndroidPopup_androidKt.Popup(obj, (Function0)anon, popupProperties, (Function2)ComposableLambdaKt.rememberComposableLambda(-1147839433, true, anon2, restartGroup, 54), restartGroup, i13 | 3072, 0);
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
            $dirty = $dirty2;
            stringResource = new BasicTooltip_androidKt.TooltipPopup.3(positionProvider, obj3, obj4, focusable, obj5, i14);
            endRestartGroup.updateScope((Function2)stringResource);
        } else {
            $dirty = $dirty2;
        }
    }

    private static final void WrappedAnchor(boolean enableUserInput, androidx.compose.foundation.BasicTooltipState state, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        int traceInProgress;
        Object compositionCoroutineScope;
        boolean $changed$iv;
        boolean currentCompositionLocalMap;
        Object obj2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int $dirty;
        Object obj3;
        int $dirty2;
        Object modifier3;
        int i;
        Object compositionScopedCoroutineScopeCanceller;
        Composer composer3;
        Object coroutineScope2;
        int i11;
        int i10;
        int i13;
        boolean traceInProgress2;
        Object anchorSemantics;
        int i2;
        int i4;
        int i3;
        Alignment topStart;
        int i5;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy;
        int i6;
        int i8;
        int i15;
        Object iNSTANCE;
        Modifier modifier2;
        int i12;
        Object obj;
        Composer composer2;
        kotlin.jvm.functions.Function0 function0;
        int i9;
        BoxScopeInstance boxScopeInstance;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        CoroutineScope coroutineScope;
        int i14;
        Composer composer;
        int obj30;
        String obj32;
        $changed$iv = enableUserInput;
        obj2 = state;
        final Object obj5 = content;
        i = $changed;
        traceInProgress = 1712976033;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(WrappedAnchor)P(1,3,2)108@4208L24,109@4258L38,110@4301L171:BasicTooltip.android.kt#71ulvw");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i & 6 == 0) {
                i11 = restartGroup.changed($changed$iv) ? 4 : 2;
                $dirty |= i11;
            }
        }
        if (i7 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i & 48 == 0) {
                i10 = restartGroup.changed(obj2) ? 32 : 16;
                $dirty |= i10;
            }
        }
        i13 = i7 & 4;
        if (i13 != 0) {
            $dirty |= 384;
            anchorSemantics = modifier;
        } else {
            if (i & 384 == 0) {
                i2 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i2;
            } else {
                anchorSemantics = modifier;
            }
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i & 3072 == 0) {
                i4 = restartGroup.changedInstance(obj5) ? 2048 : 1024;
                $dirty |= i4;
            }
        }
        int i35 = $dirty;
        if (i35 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (i13 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = anchorSemantics;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i35, -1, "androidx.compose.foundation.WrappedAnchor (BasicTooltip.android.kt:107)");
                }
                int i31 = i16;
                int i34 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                int i38 = 0;
                Composer composer5 = restartGroup;
                int i40 = 0;
                Object rememberedValue2 = composer5.rememberedValue();
                int i42 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    int i43 = 0;
                    obj32 = i20;
                    compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, restartGroup));
                    composer5.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                } else {
                    compositionScopedCoroutineScopeCanceller = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                coroutineScope2 = (CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i32 = 0;
                String stringResource = StringResources_androidKt.stringResource(R.string.tooltip_label, restartGroup, i32);
                i3 = i32;
                i13 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                i8 = 0;
                obj32 = stringResource;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                obj30 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, BasicTooltip_androidKt.anchorSemantics(BasicTooltip_androidKt.handleGestures(modifier3, $changed$iv, obj2), stringResource, $changed$iv, obj2, coroutineScope2));
                kotlin.jvm.functions.Function0 function02 = constructor;
                i15 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i44 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i45 = 0;
                Composer composer6 = constructor-impl;
                int i46 = 0;
                if (!composer6.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    coroutineScope = coroutineScope2;
                    if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(obj30))) {
                        composer6.updateRememberedValue(Integer.valueOf(obj30));
                        constructor-impl.apply(Integer.valueOf(obj30), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer6;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    coroutineScope = coroutineScope2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                obj2 = restartGroup;
                int i27 = 0;
                modifier2 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(obj2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i30 |= 6;
                composer2 = obj2;
                i9 = 0;
                boxScopeInstance = iNSTANCE2;
                i14 = i22;
                ComposerKt.sourceInformationMarkerStart(obj2, 1506105755, "C113@4461L9:BasicTooltip.android.kt#71ulvw");
                obj5.invoke(obj2, Integer.valueOf(i18 &= 14));
                ComposerKt.sourceInformationMarkerEnd(obj2);
                ComposerKt.sourceInformationMarkerEnd(obj2);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                obj3 = anchorSemantics;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new BasicTooltip_androidKt.WrappedAnchor.2(enableUserInput, state, obj3, obj5, $changed, i7);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void access$TooltipPopup(PopupPositionProvider positionProvider, androidx.compose.foundation.BasicTooltipState state, CoroutineScope scope, boolean focusable, Function2 content, Composer $composer, int $changed) {
        BasicTooltip_androidKt.TooltipPopup(positionProvider, state, scope, focusable, content, $composer, $changed);
    }

    public static final void access$WrappedAnchor(boolean enableUserInput, androidx.compose.foundation.BasicTooltipState state, Modifier modifier, Function2 content, Composer $composer, int $changed, int $default) {
        BasicTooltip_androidKt.WrappedAnchor(enableUserInput, state, modifier, content, $composer, $changed, $default);
    }

    private static final Modifier anchorSemantics(Modifier $this$anchorSemantics, String label, boolean enabled, androidx.compose.foundation.BasicTooltipState state, CoroutineScope scope) {
        Modifier semantics;
        int i;
        if (enabled) {
            BasicTooltip_androidKt.anchorSemantics.1 anon = new BasicTooltip_androidKt.anchorSemantics.1(label, scope, state);
            semantics = SemanticsModifierKt.semantics($this$anchorSemantics, true, (Function1)anon);
        } else {
            semantics = $this$anchorSemantics;
        }
        return semantics;
    }

    private static final Modifier handleGestures(Modifier $this$handleGestures, boolean enabled, androidx.compose.foundation.BasicTooltipState state) {
        Modifier pointerInput;
        int i;
        androidx.compose.foundation.BasicTooltip_androidKt.handleGestures.2 anon;
        if (enabled) {
            i = 0;
            BasicTooltip_androidKt.handleGestures.1 anon2 = new BasicTooltip_androidKt.handleGestures.1(state, i);
            anon = new BasicTooltip_androidKt.handleGestures.2(state, i);
            pointerInput = SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput($this$handleGestures, state, (Function2)anon2), state, (Function2)anon);
        } else {
            pointerInput = $this$handleGestures;
        }
        return pointerInput;
    }
}
