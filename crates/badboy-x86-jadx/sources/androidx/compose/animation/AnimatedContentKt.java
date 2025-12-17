package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.IntSize;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a´\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u001f\u0008\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2%\u0008\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u0017\u001aP\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2>\u0008\u0002\u0010\u001c\u001a8\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u001e\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u001f\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001d0 0\u0014\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020!2\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u001f\u0008\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2%\u0008\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000721\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0003\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0086\u0004\u001a\u0015\u0010'\u001a\u00020\t*\u00020$2\u0006\u0010%\u001a\u00020&H\u0087\u0004¨\u0006(", d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "label", "", "contentKey", "Lkotlin/ParameterName;", "name", "", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "togetherWith", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "with", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimatedContentKt {
    public static final <S> void AnimatedContent(Transition<S> $this$AnimatedContent, Modifier modifier, Function1<? super androidx.compose.animation.AnimatedContentTransitionScope<S>, androidx.compose.animation.ContentTransform> transitionSpec, Alignment contentAlignment, Function1<? super S, ? extends Object> contentKey, Function4<? super androidx.compose.animation.AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress2;
        int i4;
        int empty;
        Object $i$a$CacheAnimatedContentKt$AnimatedContent$currentlyVisible$1;
        int i10;
        boolean currentState;
        boolean equal2;
        Object equal;
        boolean contains;
        int i19;
        Object $i$a$CacheAnimatedContentKt$AnimatedContent$7;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        boolean key;
        Object currentState2;
        Object empty2;
        Object $i$a$CacheAnimatedContentKt$AnimatedContent$contentMap$1;
        int targetState;
        int i13;
        int $dirty;
        Object obj4;
        int skipping;
        Object modifier5;
        int i5;
        Object obj;
        Object transitionSpec2;
        Integer valueOf;
        int $i$a$LayoutAnimatedContentKt$AnimatedContent$8;
        Object obj11;
        Object obj9;
        int iNSTANCE;
        boolean traceInProgress;
        Object animatedContentTransitionScopeImpl;
        Composer composer;
        Object obj7;
        Integer $this$fastForEach$iv2;
        Object obj10;
        Object obj6;
        int i16;
        int i7;
        Object targetState2;
        int modifier4;
        Object obj5;
        Object consume;
        int i2;
        int currentCompositionLocalMap;
        Object obj3;
        int i6;
        int $i$f$cache;
        Object obj2;
        int i12;
        Object currentCompositeKeyHash;
        Object $i$a$CacheAnimatedContentKt$AnimatedContent$contentTransform$1;
        int i15;
        int i11;
        int index$iv;
        int i3;
        Composer.Companion companion;
        Object modifier3;
        int i17;
        Object $this$fastForEach$iv;
        int i;
        Modifier modifier2;
        int $i$f$setImpl;
        androidx.compose.animation.AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl2;
        int i8;
        int it;
        int i18;
        int i14;
        Object obj8;
        Object obj30;
        Object obj31;
        Object obj32;
        Object obj33;
        int obj35;
        empty2 = $this$AnimatedContent;
        modifier4 = $changed;
        traceInProgress2 = -114689412;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(AnimatedContent)P(3,4,1,2)714@34537L7,715@34565L106,719@34759L51,720@34832L69,808@39387L58,809@39479L45,819@39798L52,810@39529L327:AnimatedContent.kt#xbi5r1");
        $dirty = $changed;
        if (i9 & i43 != 0) {
            $dirty |= 6;
        } else {
            if (modifier4 & 6 == 0) {
                i5 = restartGroup.changed(empty2) ? 4 : 2;
                $dirty |= i5;
            }
        }
        int i44 = i9 & 1;
        if (i44 != 0) {
            $dirty |= 48;
            obj10 = modifier;
        } else {
            if (modifier4 & 48 == 0) {
                i16 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i16;
            } else {
                obj10 = modifier;
            }
        }
        i7 = i9 & 2;
        if (i7 != 0) {
            $dirty |= 384;
            obj5 = transitionSpec;
        } else {
            if (modifier4 & 384 == 0) {
                i2 = restartGroup.changedInstance(transitionSpec) ? 256 : 128;
                $dirty |= i2;
            } else {
                obj5 = transitionSpec;
            }
        }
        currentCompositionLocalMap = i9 & 4;
        if (currentCompositionLocalMap != null) {
            $dirty |= 3072;
            obj3 = contentAlignment;
        } else {
            if (modifier4 & 3072 == 0) {
                i6 = restartGroup.changed(contentAlignment) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                obj3 = contentAlignment;
            }
        }
        $i$f$cache = i9 & 8;
        if ($i$f$cache != 0) {
            $dirty |= 24576;
            obj2 = contentKey;
        } else {
            if (modifier4 & 24576 == 0) {
                i12 = restartGroup.changedInstance(contentKey) ? 16384 : 8192;
                $dirty |= i12;
            } else {
                obj2 = contentKey;
            }
        }
        i15 = 196608;
        if (i9 & 16 != 0) {
            $dirty |= i15;
            currentCompositeKeyHash = content;
        } else {
            if (modifier4 & i15 == 0) {
                i15 = restartGroup.changedInstance(content) ? 131072 : 65536;
                $dirty |= i15;
            } else {
                currentCompositeKeyHash = content;
            }
        }
        int i72 = $dirty;
        if ($dirty2 &= i72 == 74898) {
            if (!restartGroup.getSkipping()) {
                if (i44 != 0) {
                    modifier5 = Modifier.Companion;
                } else {
                    modifier5 = obj10;
                }
                if (i7 != 0) {
                    transitionSpec2 = AnimatedContentKt.AnimatedContent.4.INSTANCE;
                } else {
                    transitionSpec2 = obj5;
                }
                if (currentCompositionLocalMap != null) {
                    obj3 = iNSTANCE;
                }
                if ($i$f$cache != 0) {
                    obj2 = iNSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i72, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:713)");
                }
                int i46 = 0;
                int i51 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                String str6 = "CC(remember):AnimatedContent.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -801903883, str6);
                i4 = i72 & 14 == 4 ? 1 : 0;
                Composer composer5 = restartGroup;
                int i73 = 0;
                Object rememberedValue3 = composer5.rememberedValue();
                companion = 0;
                if (i4 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        $i$f$cache = 0;
                        animatedContentTransitionScopeImpl = new AnimatedContentTransitionScopeImpl(empty2, obj3, (LayoutDirection)consume);
                        composer5.updateRememberedValue(animatedContentTransitionScopeImpl);
                    } else {
                        animatedContentTransitionScopeImpl = rememberedValue3;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -801897730, str6);
                empty = i72 & 14 == 4 ? 1 : 0;
                Composer composer4 = restartGroup;
                int i54 = 0;
                Object rememberedValue5 = composer4.rememberedValue();
                int i74 = 0;
                if (empty == 0) {
                    obj33 = empty;
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        int invalid$iv2 = 0;
                        composer4.updateRememberedValue(SnapshotStateKt.mutableStateListOf(/* result */));
                    } else {
                        $i$a$CacheAnimatedContentKt$AnimatedContent$currentlyVisible$1 = rememberedValue5;
                    }
                } else {
                    obj33 = empty;
                }
                Object $this$cache$iv = $i$a$CacheAnimatedContentKt$AnimatedContent$currentlyVisible$1;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -801895376, str6);
                i10 = i72 & 14 == 4 ? 1 : 0;
                Composer composer6 = restartGroup;
                int i66 = 0;
                Object rememberedValue = composer6.rememberedValue();
                index$iv = 0;
                if (i10 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i41 = 0;
                        composer6.updateRememberedValue(ScatterMapKt.mutableScatterMapOf());
                    } else {
                        $i$a$CacheAnimatedContentKt$AnimatedContent$contentMap$1 = rememberedValue;
                    }
                } else {
                }
                $i$f$cache = $i$a$CacheAnimatedContentKt$AnimatedContent$contentMap$1;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (!(SnapshotStateList)$this$cache$iv.contains($this$AnimatedContent.getCurrentState())) {
                    $this$cache$iv.clear();
                    $this$cache$iv.add($this$AnimatedContent.getCurrentState());
                }
                if (Intrinsics.areEqual($this$AnimatedContent.getCurrentState(), $this$AnimatedContent.getTargetState())) {
                    if ($this$cache$iv.size() == 1) {
                        if (!Intrinsics.areEqual($this$cache$iv.get(0), $this$AnimatedContent.getCurrentState())) {
                            $this$cache$iv.clear();
                            $this$cache$iv.add($this$AnimatedContent.getCurrentState());
                        }
                    } else {
                    }
                    if ((MutableScatterMap)$i$f$cache.getSize() == 1) {
                        if ($i$f$cache.containsKey($this$AnimatedContent.getCurrentState())) {
                            $i$f$cache.clear();
                        }
                    } else {
                    }
                    (AnimatedContentTransitionScopeImpl)animatedContentTransitionScopeImpl.setContentAlignment(obj3);
                    animatedContentTransitionScopeImpl.setLayoutDirection$animation_release(consume);
                } else {
                    targetState = 1;
                }
                if (!Intrinsics.areEqual($this$AnimatedContent.getCurrentState(), $this$AnimatedContent.getTargetState()) && !$this$cache$iv.contains($this$AnimatedContent.getTargetState())) {
                    if (!$this$cache$iv.contains($this$AnimatedContent.getTargetState())) {
                        targetState2 = 0;
                        index$iv = 0;
                        companion = (List)$this$cache$iv.iterator();
                        for (Object modifier3 : companion) {
                            i17 = 0;
                            Composer.Companion companion4 = obj32;
                            obj35 = companion4;
                            index$iv++;
                            equal = obj32;
                            targetState = 1;
                        }
                        obj32 = equal;
                        index$iv = -1;
                        contains = index$iv;
                        if (contains == -1) {
                            $this$cache$iv.add($this$AnimatedContent.getTargetState());
                        } else {
                            $this$cache$iv.set(contains, $this$AnimatedContent.getTargetState());
                        }
                    }
                }
                if ($i$f$cache.containsKey($this$AnimatedContent.getTargetState())) {
                    if (!$i$f$cache.containsKey($this$AnimatedContent.getCurrentState())) {
                        restartGroup.startReplaceGroup(912931457);
                        ComposerKt.sourceInformation(restartGroup, "*756@36778L2565");
                        $i$f$cache.clear();
                        index$iv = 0;
                        targetState = 0;
                        targetState2 = (List)$this$cache$iv.size();
                        while (targetState < targetState2) {
                            Composer.Companion modifier6 = companion;
                            i17 = 0;
                            AnimatedContentKt.AnimatedContent.6.1 $this$fastForEach$iv3 = new AnimatedContentKt.AnimatedContent.6.1($this$AnimatedContent, modifier6, transitionSpec2, animatedContentTransitionScopeImpl, $this$cache$iv, currentCompositeKeyHash);
                            $i$f$cache.set(modifier6, ComposableLambdaKt.rememberComposableLambda(885640742, true, $this$fastForEach$iv3, restartGroup, 54));
                            targetState = modifier3 + 1;
                            consume = obj30;
                            modifier5 = obj13;
                            targetState2 = i70;
                            i19 = $this$fastForEach$iv;
                            currentCompositeKeyHash = content;
                            modifier4 = $changed;
                        }
                        $this$fastForEach$iv = i19;
                        modifier3 = targetState;
                        modifier4 = modifier5;
                        obj30 = consume;
                        restartGroup.endReplaceGroup();
                    } else {
                        restartGroup.startReplaceGroup(915535767);
                        restartGroup.endReplaceGroup();
                        modifier4 = modifier5;
                        obj30 = consume;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -801749627, str6);
                Composer composer2 = restartGroup;
                int i42 = 0;
                Object rememberedValue4 = composer2.rememberedValue();
                int i60 = 0;
                if (changed |= changed2 == 0) {
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        int i69 = 0;
                        composer2.updateRememberedValue((ContentTransform)transitionSpec2.invoke(animatedContentTransitionScopeImpl));
                    } else {
                        $i$a$CacheAnimatedContentKt$AnimatedContent$contentTransform$1 = rememberedValue4;
                    }
                } else {
                }
                Object invalid$iv = $i$a$CacheAnimatedContentKt$AnimatedContent$contentTransform$1;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Modifier sizeAnimationModifier$animation_release = animatedContentTransitionScopeImpl.createSizeAnimationModifier$animation_release((ContentTransform)invalid$iv, restartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -801736481, str6);
                int i57 = 0;
                Composer composer7 = restartGroup;
                int i62 = 0;
                Object rememberedValue6 = composer7.rememberedValue();
                int i75 = 0;
                obj32 = invalid$iv;
                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                    obj33 = i27;
                    $i$a$CacheAnimatedContentKt$AnimatedContent$7 = new AnimatedContentMeasurePolicy(animatedContentTransitionScopeImpl);
                    composer7.updateRememberedValue($i$a$CacheAnimatedContentKt$AnimatedContent$7);
                } else {
                    $i$a$CacheAnimatedContentKt$AnimatedContent$7 = rememberedValue6;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj5 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, modifier4.then(sizeAnimationModifier$animation_release));
                obj35 = constructor;
                i11 = 0;
                modifier3 = sizeAnimationModifier$animation_release;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(obj35);
                } else {
                    factory$iv$iv = obj35;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i76 = 0;
                $this$fastForEach$iv = factory$iv$iv;
                Updater.set-impl(constructor-impl, (MeasurePolicy)(AnimatedContentMeasurePolicy)$i$a$CacheAnimatedContentKt$AnimatedContent$7, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                valueOf = 0;
                obj35 = constructor-impl;
                int i77 = 0;
                if (!obj35.getInserting()) {
                    $i$f$setImpl = valueOf;
                    animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl;
                    if (!Intrinsics.areEqual(obj35.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj35.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = obj35;
                    }
                } else {
                    $i$f$setImpl = valueOf;
                    animatedContentTransitionScopeImpl2 = animatedContentTransitionScopeImpl;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                obj35 = i32;
                ComposerKt.sourceInformationMarkerStart(composer3, 1023567688, "C:AnimatedContent.kt#xbi5r1");
                composer3.startReplaceGroup(-1491001814);
                String str = "";
                ComposerKt.sourceInformation(composer3, str);
                i17 = 0;
                modifier2 = materializeModifier;
                empty2 = (List)$this$cache$iv.size();
                i8 = i45;
                $i$a$LayoutAnimatedContentKt$AnimatedContent$8 = i;
                while ($i$a$LayoutAnimatedContentKt$AnimatedContent$8 < empty2) {
                    i18 = 0;
                    int i39 = i78;
                    composer3.startMovableGroup(1908315325, obj2.invoke(i39));
                    ComposerKt.sourceInformation(composer3, str);
                    obj11 = $i$f$cache.get(i39);
                    if ((Function2)obj11 == null) {
                    } else {
                    }
                    composer3.startReplaceGroup(1908317105);
                    ComposerKt.sourceInformation(composer3, "815@39722L8");
                    (Function2)obj11.invoke(composer3, 0);
                    composer3.endReplaceGroup();
                    composer3.endMovableGroup();
                    $i$a$LayoutAnimatedContentKt$AnimatedContent$8 = it + 1;
                    empty2 = i14;
                    obj7 = obj8;
                    composer3.startReplaceGroup(-971711888);
                    composer3.endReplaceGroup();
                    obj31 = 0;
                }
                it = $i$a$LayoutAnimatedContentKt$AnimatedContent$8;
                obj8 = obj7;
                composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj33;
                obj4 = modifier4;
                obj9 = obj3;
                obj6 = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                obj4 = obj10;
                obj = obj5;
                obj9 = obj3;
                obj6 = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AnimatedContentKt.AnimatedContent.9($this$AnimatedContent, obj4, obj, obj9, obj6, content, $changed, i9);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final <S> void AnimatedContent(S targetState, Modifier modifier, Function1<? super androidx.compose.animation.AnimatedContentTransitionScope<S>, androidx.compose.animation.ContentTransform> transitionSpec, Alignment contentAlignment, String label, Function1<? super S, ? extends Object> contentKey, Function4<? super androidx.compose.animation.AnimatedContentScope, ? super S, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress2;
        Object modifier2;
        int $dirty;
        Object $dirty2;
        int i3;
        int topStart;
        Object label2;
        Object label3;
        boolean changedInstance;
        Object iNSTANCE;
        boolean traceInProgress;
        Object obj2;
        int i5;
        int str;
        Object obj9;
        Object obj;
        Object obj3;
        int i9;
        int i;
        Object contentAlignment2;
        int i6;
        Object obj5;
        int modifier3;
        Object obj7;
        int i12;
        Object i4;
        Object obj4;
        int i7;
        Object obj8;
        int i8;
        int i11;
        int i2;
        Object obj6;
        final Object obj10 = targetState;
        final int i34 = $changed;
        final Composer restartGroup = $composer.startRestartGroup(2132720749);
        ComposerKt.sourceInformation(restartGroup, "C(AnimatedContent)P(5,4,6,1,3,2)141@7507L58,142@7581L136:AnimatedContent.kt#xbi5r1");
        $dirty = $changed;
        if (i10 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i34 & 6 == 0) {
                if (i34 & 8 == 0) {
                    changedInstance = restartGroup.changed(obj10);
                } else {
                    changedInstance = restartGroup.changedInstance(obj10);
                }
                i3 = changedInstance != null ? 4 : 2;
                $dirty |= i3;
            }
        }
        int i14 = i10 & 2;
        if (i14 != 0) {
            $dirty |= 48;
            iNSTANCE = modifier;
        } else {
            if (i34 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i5;
            } else {
                iNSTANCE = modifier;
            }
        }
        str = i10 & 4;
        if (str != null) {
            $dirty |= 384;
            obj = transitionSpec;
        } else {
            if (i34 & 384 == 0) {
                i9 = restartGroup.changedInstance(transitionSpec) ? 256 : 128;
                $dirty |= i9;
            } else {
                obj = transitionSpec;
            }
        }
        i = i10 & 8;
        if (i != 0) {
            $dirty |= 3072;
            contentAlignment2 = contentAlignment;
        } else {
            if (i34 & 3072 == 0) {
                i6 = restartGroup.changed(contentAlignment) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                contentAlignment2 = contentAlignment;
            }
        }
        int i36 = i10 & 16;
        if (i36 != 0) {
            $dirty |= 24576;
            obj7 = label;
        } else {
            if (i34 & 24576 == 0) {
                i12 = restartGroup.changed(label) ? 16384 : 8192;
                $dirty |= i12;
            } else {
                obj7 = label;
            }
        }
        i4 = i10 & 32;
        int i40 = 196608;
        if (i4 != 0) {
            $dirty |= i40;
            obj4 = contentKey;
        } else {
            if (i40 &= i34 == 0) {
                i7 = restartGroup.changedInstance(contentKey) ? 131072 : 65536;
                $dirty |= i7;
            } else {
                obj4 = contentKey;
            }
        }
        i8 = 1572864;
        if (i10 & 64 != 0) {
            $dirty |= i8;
            obj8 = content;
        } else {
            if (i34 & i8 == 0) {
                i8 = restartGroup.changedInstance(content) ? 1048576 : 524288;
                $dirty |= i8;
            } else {
                obj8 = content;
            }
        }
        if ($dirty & i11 == 599186) {
            if (!restartGroup.getSkipping()) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = iNSTANCE;
                }
                if (str != null) {
                    obj = topStart;
                }
                if (i != 0) {
                    contentAlignment2 = topStart;
                }
                label2 = i36 != 0 ? "AnimatedContent" : obj7;
                if (i4 != 0) {
                    obj4 = iNSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2132720749, $dirty, -1, "androidx.compose.animation.AnimatedContent (AnimatedContent.kt:140)");
                }
                obj7 = obj;
                i4 = contentAlignment2;
                AnimatedContentKt.AnimatedContent(TransitionKt.updateTransition(obj10, label2, restartGroup, i18 |= i22, 0), modifier2, obj7, i4, obj4, obj8, restartGroup, i27 | i, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj9 = label2;
                label3 = obj7;
                obj2 = i4;
                obj3 = obj4;
            } else {
                restartGroup.skipToGroupEnd();
                obj5 = iNSTANCE;
                label3 = obj;
                obj2 = contentAlignment2;
                obj9 = obj7;
                obj3 = obj4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            modifier3 = $dirty;
            traceInProgress2 = new AnimatedContentKt.AnimatedContent.3(obj10, obj5, label3, obj2, obj9, obj3, content, i34, i10);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            modifier3 = $dirty;
            $dirty2 = obj6;
        }
    }

    public static final androidx.compose.animation.SizeTransform SizeTransform(boolean clip, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> sizeAnimationSpec) {
        SizeTransformImpl sizeTransformImpl = new SizeTransformImpl(clip, sizeAnimationSpec);
        return (SizeTransform)sizeTransformImpl;
    }

    public static androidx.compose.animation.SizeTransform SizeTransform$default(boolean z, Function2 function22, int i3, Object object4) {
        int obj0;
        androidx.compose.animation.AnimatedContentKt.SizeTransform.1 obj1;
        if (i3 & 1 != 0) {
            obj0 = 1;
        }
        if (i3 &= 2 != 0) {
            obj1 = AnimatedContentKt.SizeTransform.1.INSTANCE;
        }
        return AnimatedContentKt.SizeTransform(obj0, obj1);
    }

    public static final androidx.compose.animation.ContentTransform togetherWith(androidx.compose.animation.EnterTransition $this$togetherWith, androidx.compose.animation.ExitTransition exit) {
        ContentTransform contentTransform = new ContentTransform($this$togetherWith, exit, 0, 0, 12, 0);
        return contentTransform;
    }

    @Deprecated(message = "Infix fun EnterTransition.with(ExitTransition) has been renamed to togetherWith", replaceWith = @ReplaceWith(...))
    public static final androidx.compose.animation.ContentTransform with(androidx.compose.animation.EnterTransition $this$with, androidx.compose.animation.ExitTransition exit) {
        ContentTransform contentTransform = new ContentTransform($this$with, exit, 0, 0, 12, 0);
        return contentTransform;
    }
}
