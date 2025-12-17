package androidx.compose.material3.internal;

import androidx.compose.foundation.R.string;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.TooltipState;
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
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u0006H\u0001¢\u0006\u0002\u0010\u000f\u001a@\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u000c2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u0006H\u0003¢\u0006\u0002\u0010\u0013\u001a:\u0010\u0014\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u0006H\u0003¢\u0006\u0002\u0010\u0015\u001a,\u0010\u0016\u001a\u00020\n*\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u001c\u0010\u001a\u001a\u00020\n*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u0008H\u0002¨\u0006\u001b", d2 = {"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/material3/TooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/material3/TooltipState;Lkotlinx/coroutines/CoroutineScope;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "WrappedAnchor", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "anchorSemantics", "label", "", "enabled", "handleGestures", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BasicTooltip_androidKt {
    public static final void BasicTooltipBox(PopupPositionProvider positionProvider, Function2<? super Composer, ? super Integer, Unit> tooltip, TooltipState state, Modifier modifier, boolean focusable, boolean enableUserInput, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        Object compositionCoroutineScope;
        Object $composer$iv;
        boolean anon2;
        Object compositionScopedCoroutineScopeCanceller;
        int propagateMinConstraints$iv;
        Object obj5;
        int $dirty;
        int companion;
        boolean traceInProgress2;
        boolean currentCompositionLocalMap;
        boolean visible;
        Object traceInProgress;
        Composer composer2;
        String str;
        int changedInstance;
        Integer valueOf;
        int i18;
        Object obj;
        Composer composer;
        Object obj2;
        int i14;
        boolean changedInstance2;
        int i11;
        int str2;
        boolean z;
        Object obj3;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        boolean z3;
        Object obj4;
        int materializeModifier;
        int i19;
        int i16;
        boolean anon;
        Alignment focusable2;
        int i8;
        int i6;
        boolean coroutineScope;
        int i9;
        Object obj6;
        int i2;
        int i13;
        int i12;
        Object $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        int currentCompositeKeyHash;
        int i17;
        int i4;
        int i15;
        androidx.compose.ui.Modifier.Companion companion2;
        int i;
        androidx.compose.ui.layout.MeasurePolicy factory$iv$iv$iv;
        int i5;
        int i7;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        int i21;
        BoxScopeInstance boxScopeInstance;
        int i3;
        kotlin.jvm.functions.Function0 function0;
        Composer composer3;
        int i20;
        CoroutineScope scope;
        boolean z2;
        Object obj38;
        Alignment obj39;
        int obj40;
        obj5 = state;
        final int i74 = $changed;
        anon2 = -550509567;
        final Composer restartGroup = $composer.startRestartGroup(anon2);
        ComposerKt.sourceInformation(restartGroup, "C(BasicTooltipBox)P(4,6,5,3,2,1)86@3910L24,87@3939L451,106@4420L35,106@4396L59:BasicTooltip.android.kt#mqatfk");
        $dirty = $changed;
        if (i10 & 1 != 0) {
            $dirty |= 6;
            traceInProgress = positionProvider;
        } else {
            if (i74 & 6 == 0) {
                i18 = restartGroup.changed(positionProvider) ? 4 : 2;
                $dirty |= i18;
            } else {
                traceInProgress = positionProvider;
            }
        }
        if (i10 & 2 != 0) {
            $dirty |= 48;
            obj = tooltip;
        } else {
            if (i74 & 48 == 0) {
                i14 = restartGroup.changedInstance(tooltip) ? 32 : 16;
                $dirty |= i14;
            } else {
                obj = tooltip;
            }
        }
        if (i10 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i74 & 384 == 0) {
                if (i74 & 512 == 0) {
                    changedInstance2 = restartGroup.changed(obj5);
                } else {
                    changedInstance2 = restartGroup.changedInstance(obj5);
                }
                i11 = changedInstance2 ? 256 : 128;
                $dirty |= i11;
            }
        }
        str2 = i10 & 8;
        if (str2 != null) {
            $dirty |= 3072;
            obj3 = modifier;
        } else {
            if (i74 & 3072 == 0) {
                i19 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty |= i19;
            } else {
                obj3 = modifier;
            }
        }
        i16 = i10 & 16;
        if (i16 != 0) {
            $dirty |= 24576;
            anon = focusable;
        } else {
            if (i74 & 24576 == 0) {
                i8 = restartGroup.changed(focusable) ? 16384 : 8192;
                $dirty |= i8;
            } else {
                anon = focusable;
            }
        }
        i6 = i10 & 32;
        int i78 = 196608;
        if (i6 != 0) {
            $dirty |= i78;
            coroutineScope = enableUserInput;
        } else {
            if (i78 &= i74 == 0) {
                i9 = restartGroup.changed(enableUserInput) ? 131072 : 65536;
                $dirty |= i9;
            } else {
                coroutineScope = enableUserInput;
            }
        }
        i2 = 1572864;
        if (i10 & 64 != 0) {
            $dirty |= i2;
            obj6 = content;
        } else {
            if (i74 & i2 == 0) {
                i2 = restartGroup.changedInstance(content) ? 1048576 : 524288;
                $dirty |= i2;
            } else {
                obj6 = content;
            }
        }
        int i82 = $dirty;
        if ($dirty2 &= i82 == 599186) {
            if (!restartGroup.getSkipping()) {
                if (str2 != null) {
                    obj4 = companion;
                } else {
                    obj4 = obj3;
                }
                if (i16 != 0) {
                    anon = companion;
                }
                if (i6 != 0) {
                    coroutineScope = companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon2, i82, -1, "androidx.compose.material3.internal.BasicTooltipBox (BasicTooltip.android.kt:85)");
                }
                int i75 = 0;
                int i41 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                int i71 = 0;
                Composer composer6 = restartGroup;
                int i83 = 0;
                obj38 = i75;
                Object rememberedValue3 = composer6.rememberedValue();
                int i85 = 0;
                obj39 = i22;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    int i86 = 0;
                    obj40 = i29;
                    compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, restartGroup));
                    composer6.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                } else {
                    compositionScopedCoroutineScopeCanceller = rememberedValue3;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i76 = obj38;
                i6 = 0;
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
                i17 = 0;
                companion2 = companion3;
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
                Composer composer7 = constructor-impl;
                int i88 = 0;
                if (!composer7.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    i21 = valueOf;
                    if (!Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer7;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    i21 = valueOf;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, (Modifier)companion3), ComposeUiNode.Companion.getSetModifier());
                i = i24 & 14;
                $composer$iv = restartGroup;
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i7 = i43 | 6;
                boxScopeInstance = iNSTANCE;
                propagateMinConstraints$iv = i67;
                Composer propagateMinConstraints$iv2 = $composer$iv;
                i3 = 0;
                ComposerKt.sourceInformationMarkerStart(propagateMinConstraints$iv2, 2072656365, "C98@4223L161:BasicTooltip.android.kt#mqatfk");
                propagateMinConstraints$iv2.startReplaceGroup(-625876949);
                ComposerKt.sourceInformation(propagateMinConstraints$iv2, "89@3988L215");
                if (state.isVisible()) {
                    composer3 = $composer$iv;
                    i4 = propagateMinConstraints$iv;
                    str = anon;
                    function0 = function03;
                    i20 = 0;
                    focusable2 = obj39;
                    factory$iv$iv$iv = measurePolicy$iv;
                    visible = obj40;
                    BasicTooltip_androidKt.TooltipPopup(positionProvider, state, visible, str, obj, propagateMinConstraints$iv2, i48 |= i60);
                    scope = visible;
                    z2 = str;
                    composer = propagateMinConstraints$iv2;
                } else {
                    scope = obj40;
                    composer3 = $composer$iv;
                    i4 = propagateMinConstraints$iv;
                    composer = propagateMinConstraints$iv2;
                    z2 = anon;
                    function0 = function03;
                    i20 = 0;
                    focusable2 = obj39;
                    factory$iv$iv$iv = measurePolicy$iv;
                }
                composer.endReplaceGroup();
                obj5 = state;
                companion = obj38;
                anon2 = coroutineScope;
                BasicTooltip_androidKt.WrappedAnchor(anon2, obj5, companion, obj6, composer, i28 | i40, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1907285077, "CC(remember):BasicTooltip.android.kt#9igjgp");
                if (i82 & 896 != 256) {
                    if (i82 & 512 != 0 && restartGroup.changedInstance(obj5)) {
                        if (restartGroup.changedInstance(obj5)) {
                            i16 = 1;
                        } else {
                            i16 = i20;
                        }
                    } else {
                    }
                } else {
                }
                Composer composer4 = restartGroup;
                int i64 = 0;
                Object rememberedValue2 = composer4.rememberedValue();
                int i73 = 0;
                if (i16 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        materializeModifier = 0;
                        anon = new BasicTooltip_androidKt.BasicTooltipBox.2.1(obj5);
                        composer4.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.DisposableEffect(obj5, (Function1)anon, restartGroup, i53 &= 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z3 = anon2;
                obj2 = companion;
                z = z2;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = obj3;
                z = anon;
                z3 = coroutineScope;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            anon2 = new BasicTooltip_androidKt.BasicTooltipBox.3(positionProvider, tooltip, obj5, obj2, z, z3, content, i74, i10);
            endRestartGroup.updateScope((Function2)anon2);
        }
    }

    private static final void TooltipPopup(PopupPositionProvider positionProvider, TooltipState state, CoroutineScope scope, boolean focusable, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int stringResource;
        int $dirty;
        int i7;
        int i10;
        int i6;
        int i4;
        int i11;
        boolean traceInProgress;
        boolean traceInProgress2;
        int i8;
        boolean changedInstance;
        Object obj;
        int $this$cache$iv;
        int $dirty2;
        int popupProperties;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Object anon;
        int i5;
        boolean z;
        int i2;
        int empty;
        int i9;
        int i;
        int i3;
        final Object obj3 = state;
        final Object obj4 = scope;
        final Object obj5 = content;
        final int i15 = $changed;
        stringResource = -273292979;
        final Composer restartGroup = $composer.startRestartGroup(stringResource);
        ComposerKt.sourceInformation(restartGroup, "C(TooltipPopup)P(2,4,3,1)136@5181L44,139@5314L109,145@5491L251,137@5230L512:BasicTooltip.android.kt#mqatfk");
        if (i15 & 6 == 0) {
            i7 = restartGroup.changed(positionProvider) ? 4 : 2;
            $dirty |= i7;
        } else {
            obj = positionProvider;
        }
        $this$cache$iv = 32;
        if (i15 & 48 == 0) {
            if (i15 & 64 == 0) {
                changedInstance = restartGroup.changed(obj3);
            } else {
                changedInstance = restartGroup.changedInstance(obj3);
            }
            i10 = changedInstance != null ? $this$cache$iv : 16;
            $dirty |= i10;
        }
        if (i15 & 384 == 0) {
            i6 = restartGroup.changedInstance(obj4) ? 256 : 128;
            $dirty |= i6;
        }
        if (i15 & 3072 == 0) {
            i4 = restartGroup.changed(focusable) ? 2048 : 1024;
            $dirty |= i4;
        } else {
            z = focusable;
        }
        if (i15 & 24576 == 0) {
            i11 = restartGroup.changedInstance(obj5) ? 16384 : 8192;
            $dirty |= i11;
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(stringResource, $dirty, -1, "androidx.compose.material3.internal.TooltipPopup (BasicTooltip.android.kt:135)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 162917156, "CC(remember):BasicTooltip.android.kt#9igjgp");
                if ($dirty & 112 != $this$cache$iv) {
                    if ($dirty & 64 != 0 && restartGroup.changedInstance(obj3)) {
                        if (restartGroup.changedInstance(obj3)) {
                            i8 = 1;
                        }
                    }
                } else {
                }
                Composer composer = restartGroup;
                int i18 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i22 = 0;
                if (i8 |= changedInstance4 == 0) {
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
                AndroidPopup_androidKt.Popup(obj, (Function0)anon, popupProperties, (Function2)ComposableLambdaKt.rememberComposableLambda(610617071, true, anon2, restartGroup, 54), restartGroup, i13 | 3072, 0);
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
            $dirty2 = $dirty;
            stringResource = new BasicTooltip_androidKt.TooltipPopup.3(positionProvider, obj3, obj4, focusable, obj5, i15);
            endRestartGroup.updateScope((Function2)stringResource);
        } else {
            $dirty2 = $dirty;
        }
    }

    private static final void WrappedAnchor(boolean enableUserInput, TooltipState state, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        Object compositionCoroutineScope;
        boolean traceInProgress;
        boolean currentCompositionLocalMap;
        String $changed$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Object obj;
        int $dirty;
        int $dirty2;
        Object modifier2;
        Object companion;
        Object compositionScopedCoroutineScopeCanceller;
        Composer composer2;
        Object coroutineScope;
        int i15;
        int i11;
        int i5;
        boolean traceInProgress2;
        int i6;
        boolean changedInstance;
        Object anchorSemantics;
        int i10;
        int i2;
        int i8;
        Alignment topStart;
        int i9;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy;
        int i12;
        int i3;
        Object $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        int i14;
        Modifier modifier3;
        int i4;
        androidx.compose.ui.Modifier.Companion companion2;
        Composer composer3;
        kotlin.jvm.functions.Function0 function0;
        int i13;
        BoxScopeInstance boxScopeInstance;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        CoroutineScope coroutineScope2;
        int i;
        Composer composer;
        int obj30;
        int obj32;
        $changed$iv = enableUserInput;
        obj = state;
        final Object obj3 = content;
        i15 = $changed;
        traceInProgress = 1848240995;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(WrappedAnchor)P(1,3,2)116@4644L24,117@4694L38,118@4737L212:BasicTooltip.android.kt#mqatfk");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i15 & 6 == 0) {
                i11 = restartGroup.changed($changed$iv) ? 4 : 2;
                $dirty |= i11;
            }
        }
        if (i7 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i15 & 48 == 0) {
                if (i15 & 64 == 0) {
                    changedInstance = restartGroup.changed(obj);
                } else {
                    changedInstance = restartGroup.changedInstance(obj);
                }
                i5 = changedInstance != null ? 32 : 16;
                $dirty |= i5;
            }
        }
        i6 = i7 & 4;
        if (i6 != 0) {
            $dirty |= 384;
            anchorSemantics = modifier;
        } else {
            if (i15 & 384 == 0) {
                i10 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i10;
            } else {
                anchorSemantics = modifier;
            }
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i15 & 3072 == 0) {
                i2 = restartGroup.changedInstance(obj3) ? 2048 : 1024;
                $dirty |= i2;
            }
        }
        int i35 = $dirty;
        if (i35 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (i6 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = anchorSemantics;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i35, -1, "androidx.compose.material3.internal.WrappedAnchor (BasicTooltip.android.kt:115)");
                }
                int i30 = i16;
                int i33 = 0;
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
                coroutineScope = (CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i31 = 0;
                String stringResource = StringResources_androidKt.stringResource(R.string.tooltip_label, restartGroup, i31);
                i8 = i31;
                i6 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                i3 = 0;
                obj32 = stringResource;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                obj30 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, BasicTooltip_androidKt.anchorSemantics(BasicTooltip_androidKt.handleGestures(modifier2, $changed$iv, obj), stringResource, $changed$iv, obj, coroutineScope));
                kotlin.jvm.functions.Function0 function02 = constructor;
                i14 = 0;
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
                    coroutineScope2 = coroutineScope;
                    if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(obj30))) {
                        composer6.updateRememberedValue(Integer.valueOf(obj30));
                        constructor-impl.apply(Integer.valueOf(obj30), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer6;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    coroutineScope2 = coroutineScope;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                obj = restartGroup;
                int i26 = 0;
                modifier3 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(obj, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i29 |= 6;
                composer3 = obj;
                i13 = 0;
                boxScopeInstance = iNSTANCE;
                i = i22;
                ComposerKt.sourceInformationMarkerStart(obj, 400210223, "C124@4934L9:BasicTooltip.android.kt#mqatfk");
                obj3.invoke(obj, Integer.valueOf(i18 &= 14));
                ComposerKt.sourceInformationMarkerEnd(obj);
                ComposerKt.sourceInformationMarkerEnd(obj);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                companion = companion2;
            } else {
                restartGroup.skipToGroupEnd();
                companion = anchorSemantics;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new BasicTooltip_androidKt.WrappedAnchor.2(enableUserInput, state, companion, obj3, $changed, i7);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void access$TooltipPopup(PopupPositionProvider positionProvider, TooltipState state, CoroutineScope scope, boolean focusable, Function2 content, Composer $composer, int $changed) {
        BasicTooltip_androidKt.TooltipPopup(positionProvider, state, scope, focusable, content, $composer, $changed);
    }

    public static final void access$WrappedAnchor(boolean enableUserInput, TooltipState state, Modifier modifier, Function2 content, Composer $composer, int $changed, int $default) {
        BasicTooltip_androidKt.WrappedAnchor(enableUserInput, state, modifier, content, $composer, $changed, $default);
    }

    private static final Modifier anchorSemantics(Modifier $this$anchorSemantics, String label, boolean enabled, TooltipState state, CoroutineScope scope) {
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

    private static final Modifier handleGestures(Modifier $this$handleGestures, boolean enabled, TooltipState state) {
        Modifier pointerInput;
        int i;
        androidx.compose.material3.internal.BasicTooltip_androidKt.handleGestures.2 anon;
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
