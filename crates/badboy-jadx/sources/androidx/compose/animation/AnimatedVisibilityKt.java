package androidx.compose.animation;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u001a\u0091\u0001\u0010\u0006\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00132\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001aa\u0010\u001b\u001a\u00020\u00072\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u001d2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008\u0019H\u0007¢\u0006\u0002\u0010 \u001a[\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008\u0019H\u0007¢\u0006\u0002\u0010!\u001ak\u0010\"\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008\u0019H\u0001¢\u0006\u0002\u0010#\u001am\u0010\u001b\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u00020\u00010\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008\u0019H\u0007¢\u0006\u0002\u0010$\u001ae\u0010\u001b\u001a\u00020\u0007*\u00020%2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u001d2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008\u0019H\u0007¢\u0006\u0002\u0010&\u001a_\u0010\u001b\u001a\u00020\u0007*\u00020%2\u0006\u0010\n\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008\u0019H\u0007¢\u0006\u0002\u0010'\u001ae\u0010\u001b\u001a\u00020\u0007*\u00020(2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u001d2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008\u0019H\u0007¢\u0006\u0002\u0010)\u001a_\u0010\u001b\u001a\u00020\u0007*\u00020(2\u0006\u0010\n\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008\u0019H\u0007¢\u0006\u0002\u0010*\u001a9\u0010+\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010,\u001a\u0002H\u0008H\u0003¢\u0006\u0002\u0010-\"\u001e\u0010\u0000\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006.²\u0006\"\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0013\"\u0004\u0008\u0000\u0010\u0008X\u008a\u0084\u0002²\u0006\u0010\u00100\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0008X\u008a\u0084\u0002", d2 = {"exitFinished", "", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "getExitFinished", "(Landroidx/compose/animation/core/Transition;)Z", "AnimatedEnterExitImpl", "", "T", "transition", "visible", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "shouldDisposeBlock", "Lkotlin/Function2;", "onLookaheadMeasured", "Landroidx/compose/animation/OnLookaheadMeasured;", "content", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/animation/OnLookaheadMeasured;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibility", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "label", "", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibilityImpl", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation_release", "shouldDisposeBlockUpdated", "shouldDisposeAfterExit"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimatedVisibilityKt {
    public static final <T> void AnimatedEnterExitImpl(Transition<T> transition, Function1<? super T, Boolean> visible, Modifier modifier, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, Function2<? super androidx.compose.animation.EnterExitState, ? super androidx.compose.animation.EnterExitState, Boolean> shouldDisposeBlock, androidx.compose.animation.OnLookaheadMeasured onLookaheadMeasured, Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object traceInProgress3;
        Object produceState;
        Object anon;
        Modifier companion3;
        Object $i$a$CacheAnimatedVisibilityKt$AnimatedEnterExitImpl$2;
        Object $this$cache$iv;
        boolean exitFinished;
        Object valueOf;
        int i2;
        boolean hasInitialValueAnimations;
        int empty;
        Object $i$a$CacheTransitionKt$createChildTransition$initialParentState$1$iv;
        boolean traceInProgress;
        androidx.compose.animation.EnterExitState initialState$iv2;
        Object empty3;
        Composer composer2;
        int valueOf2;
        boolean changed;
        int $dirty;
        Composer $dirty2;
        Object currentState;
        int i15;
        int i7;
        int i6;
        Object rememberUpdatedState;
        Object obj;
        int currentCompositeKeyHash;
        int companion4;
        int currentCompositionLocalMap;
        int $i$a$CreateChildTransitionAnimatedVisibilityKt$AnimatedEnterExitImpl$childTransition$1;
        int changedInstance;
        boolean $this$createChildTransition$iv;
        int i3;
        Object materializeModifier;
        androidx.compose.animation.EnterTransition enterTransition;
        int i16;
        int i4;
        int constructor;
        int i10;
        boolean traceInProgress2;
        int i13;
        androidx.compose.animation.ExitTransition exitTransition;
        Object empty2;
        boolean changedInstance2;
        int i14;
        int i17;
        int animatedEnterExitMeasurePolicy;
        Object animatedVisibilityScopeImpl;
        int rememberedValue;
        Composer restartGroup;
        int i8;
        Composer composer;
        int companion5;
        int companion;
        Modifier modifier2;
        int i5;
        int i;
        Object initialState$iv;
        int i12;
        int $changed$iv;
        int i9;
        Composer.Companion companion2;
        int invalid$iv$iv;
        State obj32;
        Object obj34;
        produceState = transition;
        $this$cache$iv = visible;
        valueOf = modifier;
        final Object obj3 = shouldDisposeBlock;
        traceInProgress3 = onLookaheadMeasured;
        final Object obj4 = content;
        currentCompositeKeyHash = $changed;
        currentCompositionLocalMap = i11;
        i2 = -891967166;
        restartGroup = $composer.startRestartGroup(i2);
        ComposerKt.sourceInformation(restartGroup, "C(AnimatedEnterExitImpl)P(6,7,3,1,2,5,4):AnimatedVisibility.kt#xbi5r1");
        $dirty = $changed;
        if (currentCompositionLocalMap & 1 != 0) {
            $dirty |= 6;
        } else {
            if (currentCompositeKeyHash & 6 == 0) {
                i15 = restartGroup.changed(produceState) ? 4 : 2;
                $dirty |= i15;
            }
        }
        if (currentCompositionLocalMap & 2 != 0) {
            $dirty |= 48;
        } else {
            if (currentCompositeKeyHash & 48 == 0) {
                i7 = restartGroup.changedInstance($this$cache$iv) ? 32 : 16;
                $dirty |= i7;
            }
        }
        if (currentCompositionLocalMap & 4 != 0) {
            $dirty |= 384;
        } else {
            if (currentCompositeKeyHash & 384 == 0) {
                i6 = restartGroup.changed(valueOf) ? 256 : 128;
                $dirty |= i6;
            }
        }
        if (currentCompositionLocalMap & 8 != 0) {
            $dirty |= 3072;
            rememberUpdatedState = enter;
        } else {
            if (currentCompositeKeyHash & 3072 == 0) {
                i3 = restartGroup.changed(enter) ? 2048 : 1024;
                $dirty |= i3;
            } else {
                rememberUpdatedState = enter;
            }
        }
        if (currentCompositionLocalMap & 16 != 0) {
            $dirty |= 24576;
            materializeModifier = exit;
        } else {
            if (currentCompositeKeyHash & 24576 == 0) {
                i16 = restartGroup.changed(exit) ? 16384 : 8192;
                $dirty |= i16;
            } else {
                materializeModifier = exit;
            }
        }
        int i80 = 196608;
        if (currentCompositionLocalMap & 32 != 0) {
            $dirty |= i80;
        } else {
            if (currentCompositeKeyHash & i80 == 0) {
                i4 = restartGroup.changedInstance(obj3) ? 131072 : 65536;
                $dirty |= i4;
            }
        }
        constructor = currentCompositionLocalMap & 64;
        i5 = 2097152;
        if (constructor != null) {
            $dirty |= i14;
        } else {
        }
        if (currentCompositionLocalMap & 128 != 0) {
            i17 = 12582912;
            $dirty |= i17;
        } else {
        }
        if (i83 &= $dirty == 4793490) {
            if (!restartGroup.getSkipping()) {
                if (constructor != null) {
                    traceInProgress3 = 0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i2, $dirty, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:737)");
                }
                if (!(Boolean)$this$cache$iv.invoke(produceState.getTargetState()).booleanValue() && !(Boolean)$this$cache$iv.invoke(produceState.getCurrentState()).booleanValue() && !produceState.isSeeking()) {
                    if (!(Boolean)$this$cache$iv.invoke(produceState.getCurrentState()).booleanValue()) {
                        if (!produceState.isSeeking()) {
                            if (produceState.getHasInitialValueAnimations()) {
                                restartGroup.startReplaceGroup(1787977937);
                                ComposerKt.sourceInformation(restartGroup, "741@39659L116,745@39818L40,752@40073L399,747@39898L574");
                                Object obj5 = transition;
                                companion5 = 0;
                                modifier2 = i30;
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 1215497572, "CC(createChildTransition)1811@74006L36,1812@74066L74,1813@74163L39,1814@74214L63:Transition.kt#pdpnli");
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 272023029, "CC(remember):Transition.kt#9igjgp");
                                i = 1;
                                if (i32 ^= 6 > 4) {
                                    if (!restartGroup.changed(obj5)) {
                                        empty = modifier2 & 6 == 4 ? i : 0;
                                    } else {
                                        i10 = 4;
                                    }
                                } else {
                                }
                                obj34 = restartGroup;
                                int i88 = 0;
                                Object rememberedValue5 = obj34.rememberedValue();
                                int i90 = 0;
                                if (empty == 0) {
                                    invalid$iv$iv = empty;
                                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                                        int invalid$iv$iv2 = 0;
                                        i9 = $dirty;
                                        obj34.updateRememberedValue(obj5.getCurrentState());
                                    } else {
                                        i9 = $dirty;
                                        $i$a$CacheTransitionKt$createChildTransition$initialParentState$1$iv = rememberedValue5;
                                        $dirty2 = obj34;
                                    }
                                } else {
                                    invalid$iv$iv = empty;
                                }
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                if (obj5.isSeeking()) {
                                    currentState = obj5.getCurrentState();
                                } else {
                                    currentState = $i$a$CacheTransitionKt$createChildTransition$initialParentState$1$iv;
                                }
                                i76 &= 112;
                                int i89 = 0;
                                $changed$iv = $i$a$CacheTransitionKt$createChildTransition$initialParentState$1$iv;
                                Composer composer6 = obj34;
                                composer6.startReplaceGroup(-466616829);
                                ComposerKt.sourceInformation(composer6, "C742@39737L28:AnimatedVisibility.kt#xbi5r1");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-466616829, i77, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:742)");
                                }
                                initialState$iv2 = AnimatedVisibilityKt.targetEnterExit(produceState, $this$cache$iv, currentState, composer6, i34 |= i59);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer6.endReplaceGroup();
                                i53 &= 112;
                                Composer composer7 = restartGroup;
                                $i$a$CreateChildTransitionAnimatedVisibilityKt$AnimatedEnterExitImpl$childTransition$1 = 0;
                                composer7.startReplaceGroup(-466616829);
                                ComposerKt.sourceInformation(composer7, "C742@39737L28:AnimatedVisibility.kt#xbi5r1");
                                if (ComposerKt.isTraceInProgress()) {
                                    initialState$iv = initialState$iv2;
                                    obj32 = $i$a$CreateChildTransitionAnimatedVisibilityKt$AnimatedEnterExitImpl$childTransition$1;
                                    ComposerKt.traceEventStart(-466616829, i54, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:742)");
                                } else {
                                    initialState$iv = initialState$iv2;
                                    obj32 = $i$a$CreateChildTransitionAnimatedVisibilityKt$AnimatedEnterExitImpl$childTransition$1;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer7.endReplaceGroup();
                                empty3 = 0;
                                int i47 = 4;
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                $this$createChildTransition$iv = childTransitionInternal;
                                rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(obj3, restartGroup, i55 &= 14);
                                materializeModifier = "CC(remember):AnimatedVisibility.kt#9igjgp";
                                ComposerKt.sourceInformationMarkerStart(restartGroup, 1581710007, materializeModifier);
                                constructor = restartGroup;
                                animatedEnterExitMeasurePolicy = 0;
                                $dirty = constructor.rememberedValue();
                                i8 = 0;
                                if (changed4 |= changed6 == 0) {
                                    if ($dirty == Composer.Companion.getEmpty()) {
                                        empty3 = 0;
                                        anon = new AnimatedVisibilityKt.AnimatedEnterExitImpl.shouldDisposeAfterExit.2.1($this$createChildTransition$iv, rememberUpdatedState, 0);
                                        constructor.updateRememberedValue((Function2)anon);
                                    } else {
                                        anon = $dirty;
                                    }
                                } else {
                                }
                                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                produceState = SnapshotStateKt.produceState(obj3.invoke($this$createChildTransition$iv.getCurrentState(), $this$createChildTransition$iv.getTargetState()), (Function2)anon, restartGroup, 0);
                                if (AnimatedVisibilityKt.getExitFinished($this$createChildTransition$iv)) {
                                    if (!AnimatedVisibilityKt.AnimatedEnterExitImpl$lambda$4(produceState)) {
                                        restartGroup.startReplaceGroup(1788869559);
                                        ComposerKt.sourceInformation(restartGroup, "768@40570L69,773@40810L47,794@41913L50,769@40652L1325");
                                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1581725581, materializeModifier);
                                        i13 = i9 & 14 == 4 ? i : 0;
                                        Composer composer3 = restartGroup;
                                        int i40 = 0;
                                        Object rememberedValue3 = composer3.rememberedValue();
                                        companion4 = 0;
                                        if (i13 == 0) {
                                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                                currentCompositionLocalMap = 0;
                                                animatedVisibilityScopeImpl = new AnimatedVisibilityScopeImpl($this$createChildTransition$iv);
                                                composer3.updateRememberedValue(animatedVisibilityScopeImpl);
                                            } else {
                                                animatedVisibilityScopeImpl = rememberedValue3;
                                            }
                                        } else {
                                        }
                                        $this$cache$iv = animatedVisibilityScopeImpl;
                                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                        composer = composer4;
                                        String str4 = materializeModifier;
                                        restartGroup = composer;
                                        if (traceInProgress3 != null) {
                                            restartGroup.startReplaceGroup(1789227361);
                                            ComposerKt.sourceInformation(restartGroup, "775@40967L849");
                                            ComposerKt.sourceInformationMarkerStart(restartGroup, 1581739065, str4);
                                            if (i9 & i69 != 1048576) {
                                                if (i9 & i5 != 0 && restartGroup.changedInstance(traceInProgress3)) {
                                                    if (restartGroup.changedInstance(traceInProgress3)) {
                                                        exitTransition = i;
                                                    } else {
                                                        exitTransition = 0;
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                            currentCompositionLocalMap = restartGroup;
                                            enterTransition = 0;
                                            rememberedValue = currentCompositionLocalMap.rememberedValue();
                                            composer = 0;
                                            if (exitTransition == 0) {
                                                obj32 = produceState;
                                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                                    obj34 = shouldDisposeAfterExit$delegate2;
                                                    $i$a$CacheAnimatedVisibilityKt$AnimatedEnterExitImpl$2 = new AnimatedVisibilityKt.AnimatedEnterExitImpl.2.1(traceInProgress3);
                                                    currentCompositionLocalMap.updateRememberedValue((Function3)$i$a$CacheAnimatedVisibilityKt$AnimatedEnterExitImpl$2);
                                                } else {
                                                    $i$a$CacheAnimatedVisibilityKt$AnimatedEnterExitImpl$2 = rememberedValue;
                                                }
                                            } else {
                                                obj32 = produceState;
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                            companion3 = LayoutModifierKt.layout((Modifier)Modifier.Companion, (Function3)$i$a$CacheAnimatedVisibilityKt$AnimatedEnterExitImpl$2);
                                            restartGroup.endReplaceGroup();
                                        } else {
                                            obj32 = produceState;
                                            restartGroup.startReplaceGroup(1581766416);
                                            restartGroup.endReplaceGroup();
                                            companion3 = Modifier.Companion;
                                        }
                                        Modifier then2 = valueOf.then(EnterExitTransitionKt.createModifier($this$createChildTransition$iv, enter, exit, 0, "Built-in", composer, i43 | i49, 4).then(companion3));
                                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1581768538, str4);
                                        int i44 = 0;
                                        Composer composer5 = restartGroup;
                                        int i60 = 0;
                                        Object rememberedValue4 = composer5.rememberedValue();
                                        int i71 = 0;
                                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                            empty2 = 0;
                                            animatedEnterExitMeasurePolicy = new AnimatedEnterExitMeasurePolicy((AnimatedVisibilityScopeImpl)$this$cache$iv);
                                            composer5.updateRememberedValue(animatedEnterExitMeasurePolicy);
                                        } else {
                                            animatedEnterExitMeasurePolicy = rememberedValue4;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                        valueOf2 = 384;
                                        $dirty = 0;
                                        ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                                        obj34 = traceInProgress3;
                                        i8 = 0;
                                        modifier2 = then2;
                                        ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!applier instanceof Applier) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        restartGroup.startReusableNode();
                                        if (restartGroup.getInserting()) {
                                            restartGroup.createNode(ComposeUiNode.Companion.getConstructor());
                                        } else {
                                            restartGroup.useNode();
                                        }
                                        Composer constructor-impl = Updater.constructor-impl(restartGroup);
                                        i = i24;
                                        Updater.set-impl(constructor-impl, (MeasurePolicy)(AnimatedEnterExitMeasurePolicy)animatedEnterExitMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        int i87 = 0;
                                        initialState$iv = constructor-impl;
                                        i12 = 0;
                                        if (!initialState$iv.getInserting()) {
                                            $changed$iv = valueOf2;
                                            if (!Intrinsics.areEqual(initialState$iv.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                initialState$iv.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                            } else {
                                                composer2 = initialState$iv;
                                            }
                                        } else {
                                            $changed$iv = valueOf2;
                                        }
                                        Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, then2), ComposeUiNode.Companion.getSetModifier());
                                        produceState = restartGroup;
                                        valueOf = 0;
                                        i5 = i21;
                                        ComposerKt.sourceInformationMarkerStart(produceState, 254461613, "C770@40694L9:AnimatedVisibility.kt#xbi5r1");
                                        obj4.invoke($this$cache$iv, produceState, Integer.valueOf(i22 &= 112));
                                        ComposerKt.sourceInformationMarkerEnd(produceState);
                                        restartGroup.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                                        restartGroup.endReplaceGroup();
                                    } else {
                                        restartGroup.startReplaceGroup(1790256282);
                                        restartGroup.endReplaceGroup();
                                        obj34 = traceInProgress3;
                                    }
                                } else {
                                }
                                restartGroup.endReplaceGroup();
                            } else {
                                restartGroup.startReplaceGroup(1790262234);
                                restartGroup.endReplaceGroup();
                                obj34 = traceInProgress3;
                                i9 = $dirty;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj34;
            } else {
                restartGroup.skipToGroupEnd();
                obj = traceInProgress3;
                i9 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress3 = new AnimatedVisibilityKt.AnimatedEnterExitImpl.4(transition, visible, modifier, enter, exit, obj3, obj, obj4, $changed, i11);
            endRestartGroup.updateScope((Function2)traceInProgress3);
        }
    }

    private static final Function2<androidx.compose.animation.EnterExitState, androidx.compose.animation.EnterExitState, Boolean> AnimatedEnterExitImpl$lambda$2(State<? extends Function2<? super androidx.compose.animation.EnterExitState, ? super androidx.compose.animation.EnterExitState, Boolean>> $shouldDisposeBlockUpdated$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Function2)$shouldDisposeBlockUpdated$delegate.getValue();
    }

    private static final boolean AnimatedEnterExitImpl$lambda$4(State<Boolean> $shouldDisposeAfterExit$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$shouldDisposeAfterExit$delegate.getValue().booleanValue();
    }

    public static final void AnimatedVisibility(MutableTransitionState<Boolean> visibleState, Modifier modifier, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, String label, Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        Object enter2;
        boolean traceInProgress2;
        int $dirty2;
        Object $dirty;
        int i8;
        Object modifier3;
        Object obj;
        boolean changedInstance;
        Object obj3;
        int plus;
        Object label2;
        Object label3;
        int i14;
        int shrinkOut$default;
        boolean traceInProgress;
        Object obj2;
        Object str;
        int i7;
        int rememberTransition;
        Object obj4;
        int i5;
        Object obj7;
        int modifier2;
        Object obj8;
        int i4;
        int i3;
        int skipping;
        Object obj6;
        int i12;
        int i10;
        int i2;
        int i;
        int i11;
        int i13;
        int i15;
        int i6;
        Object obj5;
        final Object obj9 = visibleState;
        final int i32 = $changed;
        final Composer restartGroup = $composer.startRestartGroup(-222898426);
        ComposerKt.sourceInformation(restartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)385@20955L39,386@20999L84:AnimatedVisibility.kt#xbi5r1");
        $dirty2 = $changed;
        if (i9 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i32 & 6 == 0) {
                if (i32 & 8 == 0) {
                    changedInstance = restartGroup.changed(obj9);
                } else {
                    changedInstance = restartGroup.changedInstance(obj9);
                }
                i8 = changedInstance != null ? 4 : 2;
                $dirty2 |= i8;
            }
        }
        int i16 = i9 & 2;
        if (i16 != 0) {
            $dirty2 |= 48;
            obj3 = modifier;
        } else {
            if (i32 & 48 == 0) {
                i14 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i14;
            } else {
                obj3 = modifier;
            }
        }
        shrinkOut$default = i9 & 4;
        if (shrinkOut$default != 0) {
            $dirty2 |= 384;
            str = enter;
        } else {
            if (i32 & 384 == 0) {
                i7 = restartGroup.changed(enter) ? 256 : 128;
                $dirty2 |= i7;
            } else {
                str = enter;
            }
        }
        rememberTransition = i9 & 8;
        if (rememberTransition != 0) {
            $dirty2 |= 3072;
            obj4 = exit;
        } else {
            if (i32 & 3072 == 0) {
                i5 = restartGroup.changed(exit) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                obj4 = exit;
            }
        }
        int i38 = i9 & 16;
        if (i38 != 0) {
            $dirty2 |= 24576;
            obj8 = label;
        } else {
            if (i32 & 24576 == 0) {
                i4 = restartGroup.changed(label) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                obj8 = label;
            }
        }
        int i43 = 196608;
        if (i9 & 32 != 0) {
            $dirty2 |= i43;
            obj6 = content;
        } else {
            if (i32 & i43 == 0) {
                i3 = restartGroup.changedInstance(content) ? 131072 : 65536;
                $dirty2 |= i3;
            } else {
                obj6 = content;
            }
        }
        if (i41 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                if (i16 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = obj3;
                }
                plus = 0;
                int i42 = 0;
                i12 = 3;
                if (shrinkOut$default != 0) {
                    enter2 = EnterExitTransitionKt.fadeIn$default(i42, plus, i12, i42).plus(EnterExitTransitionKt.expandIn$default(0, 0, false, 0, 15, 0));
                } else {
                    enter2 = str;
                }
                if (rememberTransition != 0) {
                    skipping = plus;
                } else {
                    skipping = obj4;
                }
                label2 = i38 != 0 ? "AnimatedVisibility" : obj8;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-222898426, $dirty2, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:384)");
                }
                obj8 = enter2;
                AnimatedVisibilityKt.AnimatedVisibilityImpl(TransitionKt.rememberTransition((TransitionState)obj9, label2, restartGroup, i25 |= i35, 0), (Function1)AnimatedVisibilityKt.AnimatedVisibility.7.INSTANCE, modifier3, obj8, skipping, obj6, restartGroup, i23 | str);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = label2;
                obj = obj8;
                label3 = skipping;
            } else {
                restartGroup.skipToGroupEnd();
                obj7 = obj3;
                obj = str;
                label3 = obj4;
                obj2 = obj8;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            modifier2 = $dirty2;
            traceInProgress2 = new AnimatedVisibilityKt.AnimatedVisibility.8(obj9, obj7, obj, label3, obj2, content, i32, i9);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            modifier2 = $dirty2;
            $dirty = obj5;
        }
    }

    public static final <T> void AnimatedVisibility(Transition<T> $this$AnimatedVisibility, Function1<? super T, Boolean> visible, Modifier modifier, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress2;
        int $dirty2;
        int i;
        int i6;
        int modifier2;
        Object obj;
        int plus;
        boolean traceInProgress;
        int i12;
        Object obj4;
        Object enter2;
        Object shrinkOut$default;
        Object obj3;
        int i11;
        int i7;
        Object obj7;
        Object obj5;
        Object obj6;
        int $dirty;
        int i2;
        int i13;
        boolean skipping;
        int i5;
        Object obj2;
        androidx.compose.animation.EnterTransition expandIn$default;
        int i14;
        int i8;
        int i3;
        int i10;
        int i4;
        final int i31 = $changed;
        traceInProgress2 = 1031950689;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(AnimatedVisibility)P(4,3,1,2)609@34120L79:AnimatedVisibility.kt#xbi5r1");
        $dirty2 = $changed;
        if (i9 & i20 != 0) {
            $dirty2 |= 6;
            obj7 = $this$AnimatedVisibility;
        } else {
            if (i31 & 6 == 0) {
                i = restartGroup.changed($this$AnimatedVisibility) ? 4 : 2;
                $dirty2 |= i;
            } else {
                obj7 = $this$AnimatedVisibility;
            }
        }
        if (i9 & 1 != 0) {
            $dirty2 |= 48;
            obj5 = visible;
        } else {
            if (i31 & 48 == 0) {
                i6 = restartGroup.changedInstance(visible) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                obj5 = visible;
            }
        }
        modifier2 = i9 & 2;
        if (modifier2 != 0) {
            $dirty2 |= 384;
            obj = modifier;
        } else {
            if (i31 & 384 == 0) {
                i12 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i12;
            } else {
                obj = modifier;
            }
        }
        int i29 = i9 & 4;
        if (i29 != 0) {
            $dirty2 |= 3072;
            shrinkOut$default = enter;
        } else {
            if (i31 & 3072 == 0) {
                i11 = restartGroup.changed(enter) ? 2048 : 1024;
                $dirty2 |= i11;
            } else {
                shrinkOut$default = enter;
            }
        }
        i7 = i9 & 8;
        if (i7 != 0) {
            $dirty2 |= 24576;
            obj6 = exit;
        } else {
            if (i31 & 24576 == 0) {
                i2 = restartGroup.changed(exit) ? 16384 : 8192;
                $dirty2 |= i2;
            } else {
                obj6 = exit;
            }
        }
        int i35 = 196608;
        if (i9 & 16 != 0) {
            $dirty2 |= i35;
            obj2 = content;
        } else {
            if (i31 & i35 == 0) {
                i13 = restartGroup.changedInstance(content) ? 131072 : 65536;
                $dirty2 |= i13;
            } else {
                obj2 = content;
            }
        }
        if (i33 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                if (modifier2 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj;
                }
                plus = 3;
                int i34 = 0;
                int i36 = 0;
                if (i29 != 0) {
                    enter2 = EnterExitTransitionKt.fadeIn$default(i36, i34, plus, i36).plus(EnterExitTransitionKt.expandIn$default(0, 0, false, 0, 15, 0));
                } else {
                    enter2 = shrinkOut$default;
                }
                if (i7 != 0) {
                    i5 = plus;
                } else {
                    i5 = obj6;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:609)");
                }
                obj6 = modifier2;
                skipping = enter2;
                AnimatedVisibilityKt.AnimatedVisibilityImpl(obj7, obj5, obj6, skipping, i5, obj2, restartGroup, i19 | i28);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj6;
                obj4 = skipping;
                obj3 = i5;
            } else {
                restartGroup.skipToGroupEnd();
                obj4 = shrinkOut$default;
                obj3 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = $dirty2;
            traceInProgress2 = new AnimatedVisibilityKt.AnimatedVisibility.13($this$AnimatedVisibility, visible, obj, obj4, obj3, content, i31, i9);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $dirty = $dirty2;
        }
    }

    public static final void AnimatedVisibility(ColumnScope $this$AnimatedVisibility, MutableTransitionState<Boolean> visibleState, Modifier modifier, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, String label, Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int label2;
        int $dirty2;
        int i7;
        Object modifier2;
        Object obj5;
        boolean changedInstance;
        Object obj2;
        int fadeOut$default;
        boolean traceInProgress;
        Object obj8;
        int i14;
        int expandVertically$default;
        Object obj4;
        Object obj6;
        Object obj3;
        int i11;
        int i17;
        Object rememberTransition;
        int i5;
        androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.11 i6;
        Object obj;
        int $dirty;
        int i12;
        int i16;
        int skipping;
        Object i8;
        Object obj7;
        int i4;
        int i2;
        int i;
        int i9;
        int i15;
        int i13;
        int i3;
        final Object obj10 = visibleState;
        final int i38 = $changed;
        final Composer restartGroup = $composer.startRestartGroup(-850656618);
        ComposerKt.sourceInformation(restartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)536@29773L39,537@29817L84:AnimatedVisibility.kt#xbi5r1");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 48;
        } else {
            if (i38 & 48 == 0) {
                if (i38 & 64 == 0) {
                    changedInstance = restartGroup.changed(obj10);
                } else {
                    changedInstance = restartGroup.changedInstance(obj10);
                }
                i7 = changedInstance != null ? 32 : 16;
                $dirty2 |= i7;
            }
        }
        int i18 = i10 & 2;
        if (i18 != 0) {
            $dirty2 |= 384;
            obj2 = modifier;
        } else {
            if (i38 & 384 == 0) {
                i14 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i14;
            } else {
                obj2 = modifier;
            }
        }
        expandVertically$default = i10 & 4;
        if (expandVertically$default != 0) {
            $dirty2 |= 3072;
            obj6 = enter;
        } else {
            if (i38 & 3072 == 0) {
                i11 = restartGroup.changed(enter) ? 2048 : 1024;
                $dirty2 |= i11;
            } else {
                obj6 = enter;
            }
        }
        i17 = i10 & 8;
        if (i17 != 0) {
            $dirty2 |= 24576;
            rememberTransition = exit;
        } else {
            if (i38 & 24576 == 0) {
                i5 = restartGroup.changed(exit) ? 16384 : 8192;
                $dirty2 |= i5;
            } else {
                rememberTransition = exit;
            }
        }
        i6 = i10 & 16;
        int i40 = 196608;
        if (i6 != 0) {
            $dirty2 |= i40;
            obj = label;
        } else {
            if (i40 &= i38 == 0) {
                i12 = restartGroup.changed(label) ? 131072 : 65536;
                $dirty2 |= i12;
            } else {
                obj = label;
            }
        }
        int i44 = 1572864;
        if (i10 & 32 != 0) {
            $dirty2 |= i44;
            obj7 = content;
        } else {
            if (i38 & i44 == 0) {
                i16 = restartGroup.changedInstance(content) ? 1048576 : 524288;
                $dirty2 |= i16;
            } else {
                obj7 = content;
            }
        }
        if (i42 &= $dirty2 == 599184) {
            if (!restartGroup.getSkipping()) {
                if (i18 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj2;
                }
                fadeOut$default = 0;
                int i43 = 3;
                int i45 = 0;
                if (expandVertically$default != 0) {
                    obj6 = label2;
                }
                if (i17 != 0) {
                    i8 = label2;
                } else {
                    i8 = rememberTransition;
                }
                label2 = i6 != 0 ? "AnimatedVisibility" : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-850656618, $dirty2, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:535)");
                }
                obj = modifier2;
                skipping = obj6;
                AnimatedVisibilityKt.AnimatedVisibilityImpl(TransitionKt.rememberTransition((TransitionState)obj10, label2, restartGroup, i25 |= i36, 0), (Function1)AnimatedVisibilityKt.AnimatedVisibility.11.INSTANCE, obj, skipping, i8, obj7, restartGroup, i24 | i31);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = label2;
                obj5 = obj;
                obj8 = skipping;
                obj4 = i8;
            } else {
                restartGroup.skipToGroupEnd();
                obj5 = obj2;
                obj8 = obj6;
                obj4 = rememberTransition;
                obj3 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = $dirty2;
            label2 = new AnimatedVisibilityKt.AnimatedVisibility.12($this$AnimatedVisibility, obj10, obj5, obj8, obj4, obj3, content, i38, i10);
            endRestartGroup.updateScope((Function2)label2);
        } else {
            $dirty = $dirty2;
        }
    }

    public static final void AnimatedVisibility(ColumnScope $this$AnimatedVisibility, boolean visible, Modifier modifier, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, String label, Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int label2;
        int $dirty;
        boolean z;
        int i12;
        Object obj5;
        Object modifier2;
        Object obj;
        Object obj8;
        int shrinkVertically$default;
        boolean traceInProgress;
        int i15;
        Object obj6;
        int fadeIn$default;
        Object obj2;
        Object obj3;
        int i;
        int i4;
        Object transition;
        int i3;
        int i11;
        Object obj4;
        int $dirty2;
        int i8;
        int i9;
        boolean skipping;
        int i14;
        Object obj7;
        int i7;
        int i16;
        int i6;
        int i13;
        int i2;
        int i5;
        final int i37 = $changed;
        final Composer restartGroup = $composer.startRestartGroup(1766503102);
        ComposerKt.sourceInformation(restartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)280@15555L32,281@15592L84:AnimatedVisibility.kt#xbi5r1");
        $dirty = $changed;
        if (i10 & 1 != 0) {
            $dirty |= 48;
            z = visible;
        } else {
            if (i37 & 48 == 0) {
                i12 = restartGroup.changed(visible) ? 32 : 16;
                $dirty |= i12;
            } else {
                z = visible;
            }
        }
        int i19 = i10 & 2;
        if (i19 != 0) {
            $dirty |= 384;
            obj = modifier;
        } else {
            if (i37 & 384 == 0) {
                i15 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i15;
            } else {
                obj = modifier;
            }
        }
        fadeIn$default = i10 & 4;
        if (fadeIn$default != 0) {
            $dirty |= 3072;
            obj2 = enter;
        } else {
            if (i37 & 3072 == 0) {
                i = restartGroup.changed(enter) ? 2048 : 1024;
                $dirty |= i;
            } else {
                obj2 = enter;
            }
        }
        i4 = i10 & 8;
        if (i4 != 0) {
            $dirty |= 24576;
            transition = exit;
        } else {
            if (i37 & 24576 == 0) {
                i3 = restartGroup.changed(exit) ? 16384 : 8192;
                $dirty |= i3;
            } else {
                transition = exit;
            }
        }
        i11 = i10 & 16;
        int i39 = 196608;
        if (i11 != 0) {
            $dirty |= i39;
            obj4 = label;
        } else {
            if (i39 &= i37 == 0) {
                i8 = restartGroup.changed(label) ? 131072 : 65536;
                $dirty |= i8;
            } else {
                obj4 = label;
            }
        }
        int i43 = 1572864;
        if (i10 & 32 != 0) {
            $dirty |= i43;
            obj7 = content;
        } else {
            if (i37 & i43 == 0) {
                i9 = restartGroup.changedInstance(content) ? 1048576 : 524288;
                $dirty |= i9;
            } else {
                obj7 = content;
            }
        }
        if (i41 &= $dirty == 599184) {
            if (!restartGroup.getSkipping()) {
                if (i19 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj;
                }
                shrinkVertically$default = 0;
                int i42 = 3;
                int i44 = 0;
                if (fadeIn$default != 0) {
                    obj2 = label2;
                }
                if (i4 != 0) {
                    i14 = label2;
                } else {
                    i14 = transition;
                }
                label2 = i11 != 0 ? "AnimatedVisibility" : obj4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1766503102, $dirty, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:279)");
                }
                obj4 = modifier2;
                skipping = obj2;
                AnimatedVisibilityKt.AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z), label2, restartGroup, i26 |= i35, 0), (Function1)AnimatedVisibilityKt.AnimatedVisibility.5.INSTANCE, obj4, skipping, i14, obj7, restartGroup, i24 | i32);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = label2;
                obj5 = obj4;
                obj8 = skipping;
                obj6 = i14;
            } else {
                restartGroup.skipToGroupEnd();
                obj5 = obj;
                obj8 = obj2;
                obj6 = transition;
                obj3 = obj4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = $dirty;
            label2 = new AnimatedVisibilityKt.AnimatedVisibility.6($this$AnimatedVisibility, z, obj5, obj8, obj6, obj3, content, i37, i10);
            endRestartGroup.updateScope((Function2)label2);
        } else {
            $dirty2 = $dirty;
        }
    }

    public static final void AnimatedVisibility(RowScope $this$AnimatedVisibility, MutableTransitionState<Boolean> visibleState, Modifier modifier, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, String label, Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int label2;
        int $dirty;
        int i9;
        Object modifier2;
        Object obj8;
        boolean changedInstance;
        Object obj5;
        int fadeOut$default;
        boolean traceInProgress;
        Object obj3;
        int i11;
        int expandHorizontally$default;
        Object obj6;
        Object obj7;
        Object obj;
        int i14;
        int i;
        Object rememberTransition;
        int i15;
        androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.9 i13;
        Object obj4;
        int $dirty2;
        int i4;
        int i8;
        int skipping;
        Object i16;
        Object obj2;
        int i12;
        int i2;
        int i3;
        int i7;
        int i17;
        int i5;
        int i6;
        final Object obj10 = visibleState;
        final int i38 = $changed;
        final Composer restartGroup = $composer.startRestartGroup(836509870);
        ComposerKt.sourceInformation(restartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)460@25318L39,461@25362L84:AnimatedVisibility.kt#xbi5r1");
        $dirty = $changed;
        if (i10 & 1 != 0) {
            $dirty |= 48;
        } else {
            if (i38 & 48 == 0) {
                if (i38 & 64 == 0) {
                    changedInstance = restartGroup.changed(obj10);
                } else {
                    changedInstance = restartGroup.changedInstance(obj10);
                }
                i9 = changedInstance != null ? 32 : 16;
                $dirty |= i9;
            }
        }
        int i18 = i10 & 2;
        if (i18 != 0) {
            $dirty |= 384;
            obj5 = modifier;
        } else {
            if (i38 & 384 == 0) {
                i11 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i11;
            } else {
                obj5 = modifier;
            }
        }
        expandHorizontally$default = i10 & 4;
        if (expandHorizontally$default != 0) {
            $dirty |= 3072;
            obj7 = enter;
        } else {
            if (i38 & 3072 == 0) {
                i14 = restartGroup.changed(enter) ? 2048 : 1024;
                $dirty |= i14;
            } else {
                obj7 = enter;
            }
        }
        i = i10 & 8;
        if (i != 0) {
            $dirty |= 24576;
            rememberTransition = exit;
        } else {
            if (i38 & 24576 == 0) {
                i15 = restartGroup.changed(exit) ? 16384 : 8192;
                $dirty |= i15;
            } else {
                rememberTransition = exit;
            }
        }
        i13 = i10 & 16;
        int i40 = 196608;
        if (i13 != 0) {
            $dirty |= i40;
            obj4 = label;
        } else {
            if (i40 &= i38 == 0) {
                i4 = restartGroup.changed(label) ? 131072 : 65536;
                $dirty |= i4;
            } else {
                obj4 = label;
            }
        }
        int i44 = 1572864;
        if (i10 & 32 != 0) {
            $dirty |= i44;
            obj2 = content;
        } else {
            if (i38 & i44 == 0) {
                i8 = restartGroup.changedInstance(content) ? 1048576 : 524288;
                $dirty |= i8;
            } else {
                obj2 = content;
            }
        }
        if (i42 &= $dirty == 599184) {
            if (!restartGroup.getSkipping()) {
                if (i18 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj5;
                }
                fadeOut$default = 0;
                int i43 = 3;
                int i45 = 0;
                if (expandHorizontally$default != 0) {
                    obj7 = label2;
                }
                if (i != 0) {
                    i16 = label2;
                } else {
                    i16 = rememberTransition;
                }
                label2 = i13 != 0 ? "AnimatedVisibility" : obj4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(836509870, $dirty, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:459)");
                }
                obj4 = modifier2;
                skipping = obj7;
                AnimatedVisibilityKt.AnimatedVisibilityImpl(TransitionKt.rememberTransition((TransitionState)obj10, label2, restartGroup, i25 |= i36, 0), (Function1)AnimatedVisibilityKt.AnimatedVisibility.9.INSTANCE, obj4, skipping, i16, obj2, restartGroup, i24 | i31);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = label2;
                obj8 = obj4;
                obj3 = skipping;
                obj6 = i16;
            } else {
                restartGroup.skipToGroupEnd();
                obj8 = obj5;
                obj3 = obj7;
                obj6 = rememberTransition;
                obj = obj4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = $dirty;
            label2 = new AnimatedVisibilityKt.AnimatedVisibility.10($this$AnimatedVisibility, obj10, obj8, obj3, obj6, obj, content, i38, i10);
            endRestartGroup.updateScope((Function2)label2);
        } else {
            $dirty2 = $dirty;
        }
    }

    public static final void AnimatedVisibility(RowScope $this$AnimatedVisibility, boolean visible, Modifier modifier, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, String label, Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int label2;
        int $dirty2;
        boolean z;
        int i11;
        Object obj4;
        Object modifier2;
        Object obj8;
        Object obj;
        int shrinkHorizontally$default;
        boolean traceInProgress;
        int i13;
        Object obj3;
        int fadeIn$default;
        Object obj7;
        Object obj5;
        int i14;
        int i16;
        Object transition;
        int i4;
        int i15;
        Object obj6;
        int $dirty;
        int i12;
        int i2;
        boolean skipping;
        int i9;
        Object obj2;
        int i5;
        int i;
        int i3;
        int i6;
        int i7;
        int i8;
        final int i37 = $changed;
        final Composer restartGroup = $composer.startRestartGroup(-1741346906);
        ComposerKt.sourceInformation(restartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)207@11272L32,208@11309L84:AnimatedVisibility.kt#xbi5r1");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 48;
            z = visible;
        } else {
            if (i37 & 48 == 0) {
                i11 = restartGroup.changed(visible) ? 32 : 16;
                $dirty2 |= i11;
            } else {
                z = visible;
            }
        }
        int i19 = i10 & 2;
        if (i19 != 0) {
            $dirty2 |= 384;
            obj8 = modifier;
        } else {
            if (i37 & 384 == 0) {
                i13 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i13;
            } else {
                obj8 = modifier;
            }
        }
        fadeIn$default = i10 & 4;
        if (fadeIn$default != 0) {
            $dirty2 |= 3072;
            obj7 = enter;
        } else {
            if (i37 & 3072 == 0) {
                i14 = restartGroup.changed(enter) ? 2048 : 1024;
                $dirty2 |= i14;
            } else {
                obj7 = enter;
            }
        }
        i16 = i10 & 8;
        if (i16 != 0) {
            $dirty2 |= 24576;
            transition = exit;
        } else {
            if (i37 & 24576 == 0) {
                i4 = restartGroup.changed(exit) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                transition = exit;
            }
        }
        i15 = i10 & 16;
        int i39 = 196608;
        if (i15 != 0) {
            $dirty2 |= i39;
            obj6 = label;
        } else {
            if (i39 &= i37 == 0) {
                i12 = restartGroup.changed(label) ? 131072 : 65536;
                $dirty2 |= i12;
            } else {
                obj6 = label;
            }
        }
        int i43 = 1572864;
        if (i10 & 32 != 0) {
            $dirty2 |= i43;
            obj2 = content;
        } else {
            if (i37 & i43 == 0) {
                i2 = restartGroup.changedInstance(content) ? 1048576 : 524288;
                $dirty2 |= i2;
            } else {
                obj2 = content;
            }
        }
        if (i41 &= $dirty2 == 599184) {
            if (!restartGroup.getSkipping()) {
                if (i19 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj8;
                }
                shrinkHorizontally$default = 0;
                int i42 = 3;
                int i44 = 0;
                if (fadeIn$default != 0) {
                    obj7 = label2;
                }
                if (i16 != 0) {
                    i9 = label2;
                } else {
                    i9 = transition;
                }
                label2 = i15 != 0 ? "AnimatedVisibility" : obj6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1741346906, $dirty2, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:206)");
                }
                obj6 = modifier2;
                skipping = obj7;
                AnimatedVisibilityKt.AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z), label2, restartGroup, i26 |= i35, 0), (Function1)AnimatedVisibilityKt.AnimatedVisibility.3.INSTANCE, obj6, skipping, i9, obj2, restartGroup, i24 | i32);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = label2;
                obj4 = obj6;
                obj = skipping;
                obj3 = i9;
            } else {
                restartGroup.skipToGroupEnd();
                obj4 = obj8;
                obj = obj7;
                obj3 = transition;
                obj5 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = $dirty2;
            label2 = new AnimatedVisibilityKt.AnimatedVisibility.4($this$AnimatedVisibility, z, obj4, obj, obj3, obj5, content, i37, i10);
            endRestartGroup.updateScope((Function2)label2);
        } else {
            $dirty = $dirty2;
        }
    }

    public static final void AnimatedVisibility(boolean visible, Modifier modifier, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, String label, Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        Object enter2;
        int $dirty;
        boolean z;
        Object modifier4;
        int i13;
        Object obj7;
        Object modifier3;
        Object obj6;
        Object label3;
        int plus;
        Object label2;
        int i14;
        Object obj;
        androidx.compose.animation.EnterTransition shrinkOut$default;
        boolean traceInProgress2;
        Object str;
        int i5;
        int transition;
        Object obj3;
        int i10;
        Object obj4;
        int modifier2;
        Object obj5;
        int i;
        int i2;
        boolean skipping;
        Object obj2;
        int i11;
        int i3;
        int i6;
        int i4;
        int i12;
        int i8;
        int i7;
        final int i32 = $changed;
        final Composer restartGroup = $composer.startRestartGroup(2088733774);
        ComposerKt.sourceInformation(restartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)132@6967L32,133@7004L84:AnimatedVisibility.kt#xbi5r1");
        $dirty = $changed;
        if (i9 & 1 != 0) {
            $dirty |= 6;
            z = visible;
        } else {
            if (i32 & 6 == 0) {
                i13 = restartGroup.changed(visible) ? 4 : 2;
                $dirty |= i13;
            } else {
                z = visible;
            }
        }
        int i17 = i9 & 2;
        if (i17 != 0) {
            $dirty |= 48;
            obj6 = modifier;
        } else {
            if (i32 & 48 == 0) {
                i14 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i14;
            } else {
                obj6 = modifier;
            }
        }
        shrinkOut$default = i9 & 4;
        if (shrinkOut$default != 0) {
            $dirty |= 384;
            str = enter;
        } else {
            if (i32 & 384 == 0) {
                i5 = restartGroup.changed(enter) ? 256 : 128;
                $dirty |= i5;
            } else {
                str = enter;
            }
        }
        transition = i9 & 8;
        if (transition != 0) {
            $dirty |= 3072;
            obj3 = exit;
        } else {
            if (i32 & 3072 == 0) {
                i10 = restartGroup.changed(exit) ? 2048 : 1024;
                $dirty |= i10;
            } else {
                obj3 = exit;
            }
        }
        int i37 = i9 & 16;
        if (i37 != 0) {
            $dirty |= 24576;
            obj5 = label;
        } else {
            if (i32 & 24576 == 0) {
                i = restartGroup.changed(label) ? 16384 : 8192;
                $dirty |= i;
            } else {
                obj5 = label;
            }
        }
        int i42 = 196608;
        if (i9 & 32 != 0) {
            $dirty |= i42;
            obj2 = content;
        } else {
            if (i32 & i42 == 0) {
                i2 = restartGroup.changedInstance(content) ? 131072 : 65536;
                $dirty |= i2;
            } else {
                obj2 = content;
            }
        }
        if (i40 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                if (i17 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = obj6;
                }
                plus = 0;
                int i41 = 0;
                int i43 = 3;
                if (shrinkOut$default != 0) {
                    enter2 = EnterExitTransitionKt.fadeIn$default(i41, plus, i43, i41).plus(EnterExitTransitionKt.expandIn$default(0, 0, false, 0, 15, 0));
                } else {
                    enter2 = str;
                }
                if (transition != 0) {
                    skipping = plus;
                } else {
                    skipping = obj3;
                }
                label2 = i37 != 0 ? "AnimatedVisibility" : obj5;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2088733774, $dirty, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:131)");
                }
                obj5 = enter2;
                AnimatedVisibilityKt.AnimatedVisibilityImpl(TransitionKt.updateTransition(Boolean.valueOf(z), label2, restartGroup, i25 |= i34, 0), (Function1)AnimatedVisibilityKt.AnimatedVisibility.1.INSTANCE, modifier3, obj5, skipping, obj2, restartGroup, i23 | str);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = label2;
                obj7 = obj5;
                label3 = skipping;
            } else {
                restartGroup.skipToGroupEnd();
                obj4 = obj6;
                obj7 = str;
                label3 = obj3;
                obj = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            modifier2 = $dirty;
            traceInProgress = new AnimatedVisibilityKt.AnimatedVisibility.2(z, obj4, obj7, label3, obj, content, i32, i9);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            modifier4 = obj4;
            modifier2 = $dirty;
        }
    }

    public static final <T> void AnimatedVisibilityImpl(Transition<T> transition, Function1<? super T, Boolean> visible, Modifier modifier, androidx.compose.animation.EnterTransition enter, androidx.compose.animation.ExitTransition exit, Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Object traceInProgress2;
        Object obj4;
        int i8;
        int layout;
        int $dirty;
        int skipping;
        boolean traceInProgress;
        int i7;
        int i5;
        int i4;
        int i3;
        Object obj;
        int i11;
        int i6;
        int i10;
        Object obj2;
        int i9;
        Object anon;
        int i2;
        Object obj3;
        int i;
        int str;
        Object empty;
        int obj22;
        traceInProgress2 = transition;
        obj4 = visible;
        final Object obj5 = modifier;
        final int i33 = $changed;
        layout = 429978603;
        final Composer restartGroup = $composer.startRestartGroup(layout);
        ComposerKt.sourceInformation(restartGroup, "C(AnimatedVisibilityImpl)P(4,5,3,1,2)697@38299L415,694@38181L703:AnimatedVisibility.kt#xbi5r1");
        i11 = 4;
        if (i33 & 6 == 0) {
            i5 = restartGroup.changed(traceInProgress2) ? i11 : 2;
            $dirty |= i5;
        }
        i6 = 32;
        if (i33 & 48 == 0) {
            i4 = restartGroup.changedInstance(obj4) ? i6 : 16;
            $dirty |= i4;
        }
        if (i33 & 384 == 0) {
            i3 = restartGroup.changed(obj5) ? 256 : 128;
            $dirty |= i3;
        }
        if (i33 & 3072 == 0) {
            i10 = restartGroup.changed(enter) ? 2048 : 1024;
            $dirty |= i10;
        } else {
            obj = enter;
        }
        if (i33 & 24576 == 0) {
            i9 = restartGroup.changed(exit) ? 16384 : 8192;
            $dirty |= i9;
        } else {
            obj2 = exit;
        }
        i2 = 196608;
        if (i33 & i2 == 0) {
            i = restartGroup.changedInstance(content) ? 131072 : 65536;
            $dirty |= i;
        } else {
            obj3 = content;
        }
        int i34 = $dirty;
        if ($dirty2 &= i34 == 74898) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(layout, i34, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:693)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 689212639, "CC(remember):AnimatedVisibility.kt#9igjgp");
                int i35 = 0;
                i8 = i34 & 112 == i6 ? i7 : i35;
                if (i34 & 14 == i11) {
                } else {
                    i7 = i35;
                }
                Composer composer = restartGroup;
                int i22 = 0;
                Object rememberedValue = composer.rememberedValue();
                str = 0;
                if (i8 |= i7 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        obj22 = i2;
                        anon = new AnimatedVisibilityKt.AnimatedVisibilityImpl.1.1(obj4, traceInProgress2);
                        composer.updateRememberedValue((Function3)anon);
                    } else {
                        obj22 = i2;
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                AnimatedVisibilityKt.AnimatedEnterExitImpl(traceInProgress2, obj4, LayoutModifierKt.layout(obj5, (Function3)anon), obj, obj2, (Function2)AnimatedVisibilityKt.AnimatedVisibilityImpl.2.INSTANCE, 0, content, restartGroup, i20 | i29, 64);
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
            traceInProgress2 = new AnimatedVisibilityKt.AnimatedVisibilityImpl.3(transition, visible, obj5, enter, exit, content, i33);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final Function2 access$AnimatedEnterExitImpl$lambda$2(State $shouldDisposeBlockUpdated$delegate) {
        return AnimatedVisibilityKt.AnimatedEnterExitImpl$lambda$2($shouldDisposeBlockUpdated$delegate);
    }

    public static final boolean access$getExitFinished(Transition $receiver) {
        return AnimatedVisibilityKt.getExitFinished($receiver);
    }

    private static final boolean getExitFinished(Transition<androidx.compose.animation.EnterExitState> $this$exitFinished) {
        Object currentState;
        int i;
        androidx.compose.animation.EnterExitState postExit;
        if ($this$exitFinished.getCurrentState() == EnterExitState.PostExit && $this$exitFinished.getTargetState() == EnterExitState.PostExit) {
            i = $this$exitFinished.getTargetState() == EnterExitState.PostExit ? 1 : 0;
        } else {
        }
        return i;
    }

    private static final <T> androidx.compose.animation.EnterExitState targetEnterExit(Transition<T> $this$targetEnterExit, Function1<? super T, Boolean> visible, T targetState, Composer $composer, int $changed) {
        androidx.compose.animation.EnterExitState hasBeenVisible;
        boolean traceInProgress;
        boolean booleanValue;
        String str;
        Object rememberedValue;
        int i;
        Object $i$a$CacheAnimatedVisibilityKt$targetEnterExit$hasBeenVisible$1;
        Boolean valueOf;
        int i2;
        int i3;
        int i4 = 361571134;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(targetEnterExit)P(1):AnimatedVisibility.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:855)");
        }
        $composer.startMovableGroup(-902048200, $this$targetEnterExit);
        ComposerKt.sourceInformation($composer, "");
        if ($this$targetEnterExit.isSeeking()) {
            $composer.startReplaceGroup(2101296683);
            $composer.endReplaceGroup();
            hasBeenVisible = (Boolean)visible.invoke(targetState).booleanValue() ? EnterExitState.Visible : booleanValue3 ? EnterExitState.PostExit : EnterExitState.PreEnter;
        } else {
            $composer.startReplaceGroup(2101530516);
            ComposerKt.sourceInformation($composer, "868@44365L34");
            ComposerKt.sourceInformationMarkerStart($composer, -902039492, "CC(remember):AnimatedVisibility.kt#9igjgp");
            int i9 = 0;
            Composer composer = $composer;
            str = 0;
            rememberedValue = composer.rememberedValue();
            i = 0;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i11 = 0;
                i3 = 0;
                composer.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(false, i3, 2, i3));
            } else {
                $i$a$CacheAnimatedVisibilityKt$targetEnterExit$hasBeenVisible$1 = rememberedValue;
            }
            MutableState invalid$iv = $i$a$CacheAnimatedVisibilityKt$targetEnterExit$hasBeenVisible$1;
            ComposerKt.sourceInformationMarkerEnd($composer);
            if ((Boolean)visible.invoke($this$targetEnterExit.getCurrentState()).booleanValue()) {
                (MutableState)invalid$iv.setValue(true);
            }
            hasBeenVisible = (Boolean)visible.invoke(targetState).booleanValue() ? traceInProgress : booleanValue5 ? traceInProgress : traceInProgress;
            $composer.endReplaceGroup();
        }
        $composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return hasBeenVisible;
    }
}
