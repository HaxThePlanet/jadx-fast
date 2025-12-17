package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\u0008\u000bH\u0007¢\u0006\u0002\u0010\u000c\u001aX\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\u0008\u000bH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00102\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072%\u0008\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\n2&\u0010\t\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\u0008\u000bH\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\u0010\u0010\u0017\u001a\u00020\u0008\"\u0004\u0008\u0000\u0010\u0002X\u008a\u0084\u0002", d2 = {"Crossfade", "", "T", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "label", "", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", "name", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CrossfadeKt {
    public static final <T> void Crossfade(Transition<T> $this$Crossfade, Modifier modifier, FiniteAnimationSpec<Float> animationSpec, Function1<? super T, ? extends Object> contentKey, Function3<? super T, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        Object invalid$iv;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Object obj4;
        boolean traceInProgress2;
        Object size;
        Object obj6;
        int $dirty;
        int $dirty2;
        Object modifier2;
        Object equal;
        Object targetState;
        Object contains;
        Integer topStart;
        Object obj;
        int i9;
        Object $this$Crossfade_u24lambda_u241_u24lambda_u240;
        Object obj5;
        Object currentState;
        boolean equal2;
        int invoke;
        Composer composer2;
        int i18;
        Integer index$iv2;
        int valueOf;
        int equal3;
        Object obj2;
        Object rememberBoxMeasurePolicy;
        Object iNSTANCE;
        boolean traceInProgress;
        String index$iv;
        int i14;
        int str;
        Object empty;
        Object obj3;
        int i13;
        int index$iv3;
        int i10;
        Object i4;
        int i16;
        int i12;
        int next;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Object mutableScatterMapOf;
        int currentCompositeKeyHash;
        int i17;
        int i22;
        Object mutableStateListOf;
        kotlin.jvm.functions.Function0 function0;
        int i20;
        int i19;
        Function3 function3;
        int i;
        int i5;
        int i3;
        BoxScopeInstance boxScopeInstance;
        Alignment contentAlignment$iv;
        int i2;
        Composer composer;
        int i15;
        int i11;
        int i21;
        int it;
        int i7;
        Object $this$fastForEach$iv;
        int i6;
        int obj36;
        SnapshotStateList obj37;
        int obj38;
        Object obj40;
        size = $this$Crossfade;
        final int i58 = $changed;
        traceInProgress2 = 679005231;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Crossfade)P(3!1,2)104@4422L64,105@4508L61,137@5785L159:Crossfade.kt#xbi5r1");
        $dirty = $changed;
        if (i8 & i44 != 0) {
            $dirty |= 6;
        } else {
            if (i58 & 6 == 0) {
                i9 = restartGroup.changed(size) ? 4 : 2;
                $dirty |= i9;
            }
        }
        int i45 = i8 & 1;
        if (i45 != 0) {
            $dirty |= 48;
            iNSTANCE = modifier;
        } else {
            if (i58 & 48 == 0) {
                i14 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i14;
            } else {
                iNSTANCE = modifier;
            }
        }
        str = i8 & 2;
        if (str != null) {
            $dirty |= 384;
            obj3 = animationSpec;
        } else {
            if (i58 & 384 == 0) {
                i13 = restartGroup.changedInstance(animationSpec) ? 256 : 128;
                $dirty |= i13;
            } else {
                obj3 = animationSpec;
            }
        }
        i10 = i8 & 4;
        if (i10 != 0) {
            $dirty |= 3072;
            i4 = contentKey;
        } else {
            if (i58 & 3072 == 0) {
                i16 = restartGroup.changedInstance(contentKey) ? 2048 : 1024;
                $dirty |= i16;
            } else {
                i4 = contentKey;
            }
        }
        if (i8 & 8 != 0) {
            $dirty |= 24576;
        } else {
            if (i58 & 24576 == 0) {
                i12 = restartGroup.changedInstance(content) ? 16384 : 8192;
                $dirty |= i12;
            }
        }
        int i69 = $dirty;
        if (i69 & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (i45 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = iNSTANCE;
                }
                int i46 = 0;
                if (str != null) {
                    str = 0;
                    obj3 = iNSTANCE;
                }
                if (i10 != 0) {
                    i4 = iNSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i69, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:103)");
                }
                index$iv = "CC(remember):Crossfade.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1274683025, index$iv);
                int i24 = 0;
                Composer composer5 = restartGroup;
                int i70 = 0;
                Object rememberedValue3 = composer5.rememberedValue();
                i17 = 0;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    mutableStateListOf = SnapshotStateKt.mutableStateListOf();
                    i20 = 0;
                    mutableStateListOf.add(size.getCurrentState());
                    composer5.updateRememberedValue(mutableStateListOf);
                } else {
                    $this$Crossfade_u24lambda_u241_u24lambda_u240 = rememberedValue3;
                }
                invalid$iv = $this$Crossfade_u24lambda_u241_u24lambda_u240;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1274685774, index$iv);
                int i48 = 0;
                Composer composer4 = restartGroup;
                int i66 = 0;
                Object rememberedValue2 = composer4.rememberedValue();
                next = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    int i75 = 0;
                    composer4.updateRememberedValue(ScatterMapKt.mutableScatterMapOf());
                } else {
                    mutableScatterMapOf = rememberedValue2;
                }
                Object invalid$iv2 = mutableScatterMapOf;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                str = "";
                index$iv3 = 1;
                if (Intrinsics.areEqual(size.getCurrentState(), size.getTargetState())) {
                    restartGroup.startReplaceGroup(860660313);
                    ComposerKt.sourceInformation(restartGroup, str);
                    if ((SnapshotStateList)invalid$iv.size() == index$iv3) {
                        if (!Intrinsics.areEqual(invalid$iv.get(0), size.getTargetState())) {
                            restartGroup.startReplaceGroup(860794667);
                            ComposerKt.sourceInformation(restartGroup, "110@4883L21");
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 1274697734, index$iv);
                            index$iv = i69 & 14 == 4 ? index$iv3 : 0;
                            next = restartGroup;
                            mutableScatterMapOf = 0;
                            index$iv3 = next.rememberedValue();
                            i17 = 0;
                            if (index$iv == 0) {
                                obj40 = modifier2;
                                if (index$iv3 == Composer.Companion.getEmpty()) {
                                    obj38 = modifier3;
                                    modifier2 = new CrossfadeKt.Crossfade.4.1(size);
                                    next.updateRememberedValue((Function1)modifier2);
                                } else {
                                    modifier2 = index$iv3;
                                }
                            } else {
                                obj40 = modifier2;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            CollectionsKt.removeAll((List)invalid$iv, (Function1)modifier2);
                            (MutableScatterMap)invalid$iv2.clear();
                            restartGroup.endReplaceGroup();
                        } else {
                            restartGroup.startReplaceGroup(860984945);
                            restartGroup.endReplaceGroup();
                            obj40 = modifier2;
                        }
                    } else {
                    }
                    restartGroup.endReplaceGroup();
                } else {
                    obj40 = modifier2;
                    restartGroup.startReplaceGroup(860990897);
                    restartGroup.endReplaceGroup();
                }
                if (!invalid$iv2.contains(size.getTargetState())) {
                    restartGroup.startReplaceGroup(861052122);
                    ComposerKt.sourceInformation(restartGroup, "*126@5458L305");
                    invoke = 0;
                    index$iv = 0;
                    Iterator iterator = (List)invalid$iv.iterator();
                    for (Object next : iterator) {
                        i17 = 0;
                        index$iv++;
                        equal = obj38;
                        invoke = mutableStateListOf;
                    }
                    obj38 = equal;
                    mutableStateListOf = invoke;
                    index$iv = -1;
                    if (index$iv == -1) {
                        invalid$iv.add(size.getTargetState());
                    } else {
                        invalid$iv.set(index$iv, size.getTargetState());
                    }
                    invalid$iv2.clear();
                    equal2 = 0;
                    index$iv3 = 0;
                    while (index$iv3 < (List)invalid$iv.size()) {
                        i17 = 0;
                        Object $this$fastForEach$iv3 = obj36;
                        CrossfadeKt.Crossfade.5.1 currentlyVisible = new CrossfadeKt.Crossfade.5.1(size, obj3, $this$fastForEach$iv3, rememberBoxMeasurePolicy);
                        invalid$iv2.set($this$fastForEach$iv3, ComposableLambdaKt.rememberComposableLambda(-1426421288, true, currentlyVisible, restartGroup, 54));
                        index$iv3++;
                        size = $this$Crossfade;
                        equal2 = obj36;
                        invalid$iv = obj38;
                        rememberBoxMeasurePolicy = content;
                        contains = mutableStateListOf;
                    }
                    obj38 = invalid$iv;
                    mutableStateListOf = contains;
                    obj36 = equal2;
                    restartGroup.endReplaceGroup();
                } else {
                    obj38 = invalid$iv;
                    restartGroup.startReplaceGroup(861812273);
                    restartGroup.endReplaceGroup();
                }
                i25 &= 14;
                restartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(restartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                topStart = Alignment.Companion.getTopStart();
                valueOf = 0;
                i10 = 0;
                restartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(restartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                kotlin.jvm.functions.Function0 function02 = constructor;
                i22 = 0;
                i20 = i28;
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
                function0 = factory$iv$iv$iv;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i76 = 0;
                i5 = i34;
                Updater.set-impl(constructor-impl, BoxKt.rememberBoxMeasurePolicy(topStart, valueOf, restartGroup, i56 |= i61), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i77 = 0;
                Composer composer7 = constructor-impl;
                int i78 = 0;
                if (!composer7.getInserting()) {
                    contentAlignment$iv = topStart;
                    i2 = valueOf;
                    if (!Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer7;
                    }
                } else {
                    contentAlignment$iv = topStart;
                    i2 = valueOf;
                }
                Function3 function32 = obj37;
                function32.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(restartGroup)), restartGroup, Integer.valueOf(i35 &= 112));
                restartGroup.startReplaceableGroup(2058660585);
                Composer composer3 = restartGroup;
                obj37 = i31;
                function3 = function32;
                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                i3 = 0;
                boxScopeInstance = iNSTANCE2;
                i15 = i43;
                Composer $changed2 = composer6;
                ComposerKt.sourceInformationMarkerStart($changed2, -1517004430, "C:Crossfade.kt#xbi5r1");
                $changed2.startReplaceGroup(-187482432);
                ComposerKt.sourceInformation($changed2, str);
                i11 = i37;
                size = (List)obj38.size();
                i21 = i49;
                i18 = i;
                while (i18 < size) {
                    i7 = 0;
                    int $this$fastForEach$iv2 = i79;
                    $changed2.startMovableGroup(-1081873445, i4.invoke($this$fastForEach$iv2));
                    ComposerKt.sourceInformation($changed2, str);
                    obj6 = invalid$iv2.get($this$fastForEach$iv2);
                    if ((Function2)obj6 == null) {
                    } else {
                    }
                    $changed2.startReplaceGroup(-1081871785);
                    ComposerKt.sourceInformation($changed2, "140@5906L8");
                    (Function2)obj6.invoke($changed2, 0);
                    $changed2.endReplaceGroup();
                    $changed2.endMovableGroup();
                    i18 = i6 + 1;
                    size = it;
                    obj4 = $this$fastForEach$iv;
                    $changed2.startReplaceGroup(821713034);
                    $changed2.endReplaceGroup();
                    i19 = 0;
                }
                $this$fastForEach$iv = obj4;
                i6 = i18;
                $changed2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($changed2);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endReplaceableGroup();
                restartGroup.endNode();
                restartGroup.endReplaceableGroup();
                restartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj40;
                obj5 = obj3;
                obj2 = i4;
            } else {
                restartGroup.skipToGroupEnd();
                obj = iNSTANCE;
                obj5 = obj3;
                obj2 = i4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new CrossfadeKt.Crossfade.7($this$Crossfade, obj, obj5, obj2, content, i58, i8);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final <T> void Crossfade(T targetState, Modifier modifier, FiniteAnimationSpec<Float> animationSpec, String label, Function3<? super T, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        int traceInProgress;
        int $dirty2;
        Object obj4;
        int $dirty;
        Object modifier2;
        int i9;
        Object obj5;
        boolean changedInstance;
        Object obj2;
        Object obj3;
        Object animationSpec2;
        int i3;
        int label2;
        Object transition;
        boolean traceInProgress2;
        int i4;
        int str;
        Object obj6;
        int i2;
        int i;
        int i5;
        Object obj;
        int i7;
        int i6;
        final Object obj7 = targetState;
        final int i23 = $changed;
        traceInProgress = -310686752;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Crossfade)P(4,3!1,2)56@2327L36,57@2379L53:Crossfade.kt#xbi5r1");
        $dirty2 = $changed;
        if (i8 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i23 & 6 == 0) {
                if (i23 & 8 == 0) {
                    changedInstance = restartGroup.changed(obj7);
                } else {
                    changedInstance = restartGroup.changedInstance(obj7);
                }
                i9 = changedInstance != null ? 4 : 2;
                $dirty2 |= i9;
            }
        }
        int i15 = i8 & 2;
        if (i15 != 0) {
            $dirty2 |= 48;
            obj2 = modifier;
        } else {
            if (i23 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                obj2 = modifier;
            }
        }
        label2 = i8 & 4;
        if (label2 != 0) {
            $dirty2 |= 384;
            transition = animationSpec;
        } else {
            if (i23 & 384 == 0) {
                i4 = restartGroup.changedInstance(animationSpec) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                transition = animationSpec;
            }
        }
        str = i8 & 8;
        if (str != null) {
            $dirty2 |= 3072;
            obj6 = label;
        } else {
            if (i23 & 3072 == 0) {
                i2 = restartGroup.changed(label) ? 2048 : 1024;
                $dirty2 |= i2;
            } else {
                obj6 = label;
            }
        }
        if (i8 & 16 != 0) {
            $dirty2 |= 24576;
            obj = content;
        } else {
            if (i23 & 24576 == 0) {
                i = restartGroup.changedInstance(content) ? 16384 : 8192;
                $dirty2 |= i;
            } else {
                obj = content;
            }
        }
        final int i29 = $dirty2;
        if (i29 & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (i15 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj2;
                }
                int i16 = 0;
                if (label2 != 0) {
                    label2 = 0;
                    animationSpec2 = AnimationSpecKt.tween$default(i16, i16, label2, 7, label2);
                } else {
                    animationSpec2 = transition;
                }
                label2 = str != null ? "Crossfade" : obj6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i29, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
                }
                str = modifier2;
                obj6 = animationSpec2;
                CrossfadeKt.Crossfade(TransitionKt.updateTransition(obj7, label2, restartGroup, i11 |= i27, i16), str, obj6, 0, obj, restartGroup, i14 | i19, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = label2;
                obj4 = str;
                obj5 = obj6;
            } else {
                restartGroup.skipToGroupEnd();
                obj4 = obj2;
                obj5 = transition;
                obj3 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new CrossfadeKt.Crossfade.1(obj7, obj4, obj5, obj3, content, i23, i8);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Crossfade API now has a new label parameter added.")
    public static final void Crossfade(Object targetState, Modifier modifier, FiniteAnimationSpec animationSpec, Function3 content, Composer $composer, int $changed, int i7) {
        int traceInProgress;
        int $dirty2;
        boolean $dirty;
        boolean changedInstance;
        int i4;
        Object obj3;
        Object obj2;
        Object tween$default;
        boolean traceInProgress2;
        int i6;
        int transition;
        Object obj4;
        int i9;
        int i5;
        int i2;
        int i8;
        Object obj;
        int i;
        int i3;
        final int i24 = $changed;
        traceInProgress = 523603005;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Crossfade)P(3,2)72@2790L29,73@2835L53:Crossfade.kt#xbi5r1");
        $dirty2 = $changed;
        int i20 = 2;
        if (i7 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i24 & 6 == 0) {
                if (i24 & 8 == 0) {
                    changedInstance = restartGroup.changed(targetState);
                } else {
                    changedInstance = restartGroup.changedInstance(targetState);
                }
                i4 = changedInstance != null ? 4 : i20;
                $dirty2 |= i4;
            }
        }
        int i15 = i7 & 2;
        if (i15 != 0) {
            $dirty2 |= 48;
            tween$default = modifier;
        } else {
            if (i24 & 48 == 0) {
                i6 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                tween$default = modifier;
            }
        }
        transition = i7 & 4;
        if (transition != 0) {
            $dirty2 |= 384;
            obj4 = animationSpec;
        } else {
            if (i24 & 384 == 0) {
                i9 = restartGroup.changedInstance(animationSpec) ? 256 : 128;
                $dirty2 |= i9;
            } else {
                obj4 = animationSpec;
            }
        }
        if (i7 & 8 != 0) {
            $dirty2 |= 3072;
            obj = content;
        } else {
            if (i24 & 3072 == 0) {
                i5 = restartGroup.changedInstance(content) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                obj = content;
            }
        }
        final int i26 = $dirty2;
        if (i26 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (i15 != 0) {
                    $dirty = Modifier.Companion;
                } else {
                    $dirty = tween$default;
                }
                int i16 = 0;
                if (transition != 0) {
                    transition = 0;
                    i2 = tween$default;
                } else {
                    i2 = obj4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i26, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:71)");
                }
                obj4 = $dirty;
                CrossfadeKt.Crossfade(TransitionKt.updateTransition(targetState, i16, restartGroup, i10 |= tween$default, i20), obj4, i2, 0, obj, restartGroup, i13 | i19, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj4;
                obj2 = i2;
            } else {
                restartGroup.skipToGroupEnd();
                obj3 = tween$default;
                obj2 = obj4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new CrossfadeKt.Crossfade.2(targetState, obj3, obj2, content, i24, i7);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }
}
