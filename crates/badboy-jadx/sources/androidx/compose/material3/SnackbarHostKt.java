package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a:\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\u0008\u000cH\u0003¢\u0006\u0002\u0010\r\u001a:\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0019\u0008\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\u0008\u000cH\u0007¢\u0006\u0002\u0010\u0012\u001a9\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0008\u0002\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u001bH\u0003¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001e\u001a\u001e\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020\u00192\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000*b\u0008\u0002\u0010%\"-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\u0008\u000c¢\u0006\u000c\u0008&\u0012\u0008\u0008'\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\u0008\u000c2-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\u0008\u000c¢\u0006\u000c\u0008&\u0012\u0008\u0008'\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\u0008\u000c¨\u0006(", d2 = {"SnackbarFadeInMillis", "", "SnackbarFadeOutMillis", "SnackbarInBetweenDelayMillis", "FadeInFadeOutWithScale", "", "current", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SnackbarHost", "hostState", "Landroidx/compose/material3/SnackbarHostState;", "snackbar", "(Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animatedOpacity", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", "visible", "", "onAnimationFinish", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "toMillis", "", "Landroidx/compose/material3/SnackbarDuration;", "hasAction", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "FadeInFadeOutTransition", "Lkotlin/ParameterName;", "name", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SnackbarHostKt {

    private static final int SnackbarFadeInMillis = 150;
    private static final int SnackbarFadeOutMillis = 75;
    private static final int SnackbarInBetweenDelayMillis;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal3;
            int ordinal2;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[SnackbarDuration.Indefinite.ordinal()] = 1;
            iArr[SnackbarDuration.Long.ordinal()] = 2;
            iArr[SnackbarDuration.Short.ordinal()] = 3;
            SnackbarHostKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    private static final void FadeInFadeOutWithScale(androidx.compose.material3.SnackbarData current, Modifier modifier, Function3<? super androidx.compose.material3.SnackbarData, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int size;
        Object items;
        int $dirty3;
        Object obj4;
        int $dirty2;
        Object modifier2;
        int $i$f$fastForEach;
        Object obj2;
        int $i$a$LayoutBoxKt$Box$1$iv;
        Integer valueOf;
        int i4;
        int i14;
        boolean traceInProgress;
        List mutableList;
        Composer composer2;
        Object topStart;
        Object str;
        int fastFilterNotNull;
        int i17;
        int i19;
        int maybeCachedBoxMeasurePolicy;
        int i11;
        Object rememberedValue;
        int i3;
        int i15;
        int i13;
        Object empty;
        int currentCompositeKeyHash;
        Object fadeInFadeOutState;
        androidx.compose.runtime.CompositionLocalMap index$iv$iv;
        Modifier materializeModifier;
        int index$iv$iv2;
        Function0 constructor;
        int i5;
        int i8;
        int i;
        int i12;
        int $dirty;
        int i7;
        Object keys;
        int i16;
        Object obj3;
        int i18;
        BoxScopeInstance boxScopeInstance;
        int $i$f$Box;
        Alignment alignment;
        Composer composer;
        int i9;
        int i20;
        int i2;
        int i21;
        List $this$fastForEach$iv;
        int i10;
        Object obj;
        int obj37;
        items = current;
        $i$a$LayoutBoxKt$Box$1$iv = $changed;
        traceInProgress2 = -1316639904;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(FadeInFadeOutWithScale)P(1,2)328@12730L48,393@15387L162:SnackbarHost.kt#uh7d8r");
        $dirty3 = $changed;
        if (i6 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if ($i$a$LayoutBoxKt$Box$1$iv & 6 == 0) {
                i4 = restartGroup.changed(items) ? 4 : 2;
                $dirty3 |= i4;
            }
        }
        i14 = i6 & 2;
        if (i14 != 0) {
            $dirty3 |= 48;
            str = modifier;
        } else {
            if ($i$a$LayoutBoxKt$Box$1$iv & 48 == 0) {
                i17 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i17;
            } else {
                str = modifier;
            }
        }
        if (i6 & 4 != 0) {
            $dirty3 |= 384;
        } else {
            if ($i$a$LayoutBoxKt$Box$1$iv & 384 == 0) {
                i19 = restartGroup.changedInstance(content) ? 256 : 128;
                $dirty3 |= i19;
            }
        }
        maybeCachedBoxMeasurePolicy = $dirty3;
        if (maybeCachedBoxMeasurePolicy & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, maybeCachedBoxMeasurePolicy, -1, "androidx.compose.material3.FadeInFadeOutWithScale (SnackbarHost.kt:327)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1256815738, "CC(remember):SnackbarHost.kt#9igjgp");
                int i23 = 0;
                Composer composer4 = restartGroup;
                fastFilterNotNull = 0;
                rememberedValue = composer4.rememberedValue();
                i15 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    fadeInFadeOutState = new FadeInFadeOutState();
                    composer4.updateRememberedValue(fadeInFadeOutState);
                } else {
                    fadeInFadeOutState = rememberedValue;
                }
                Object invalid$iv = fadeInFadeOutState;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                restartGroup.startReplaceGroup(-1256811491);
                ComposerKt.sourceInformation(restartGroup, "*337@13129L2237");
                if (!Intrinsics.areEqual(items, (FadeInFadeOutState)invalid$iv.getCurrent())) {
                    invalid$iv.setCurrent(items);
                    List items2 = invalid$iv.getItems();
                    int i43 = 0;
                    ArrayList arrayList = new ArrayList(items2.size());
                    List list = items2;
                    int i48 = 0;
                    index$iv$iv2 = 0;
                    while (index$iv$iv2 < list.size()) {
                        i = 0;
                        i7 = 0;
                        (Collection)arrayList.add((SnackbarData)(FadeInFadeOutAnimationItem)list.get(index$iv$iv2).getKey());
                        index$iv$iv2++;
                    }
                    mutableList = CollectionsKt.toMutableList((Collection)(List)arrayList);
                    if (!mutableList.contains(items)) {
                        mutableList.add(items);
                    }
                    invalid$iv.getItems().clear();
                    rememberedValue = invalid$iv.getItems();
                    i15 = 0;
                    empty = fastFilterNotNull;
                    fadeInFadeOutState = 0;
                    index$iv$iv = 0;
                    while (index$iv$iv < empty.size()) {
                        i8 = 0;
                        int i34 = i5;
                        i = 0;
                        SnackbarHostKt.FadeInFadeOutWithScale.1.1 $dirty4 = new SnackbarHostKt.FadeInFadeOutWithScale.1.1((SnackbarData)i34, items, mutableList, invalid$iv);
                        FadeInFadeOutAnimationItem $this$fastMapTo$iv = new FadeInFadeOutAnimationItem(i34, (Function3)ComposableLambdaKt.rememberComposableLambda(-1654683077, true, $dirty4, restartGroup, 54));
                        (Collection)rememberedValue.add($this$fastMapTo$iv);
                        index$iv$iv++;
                        items = current;
                        $i$a$LayoutBoxKt$Box$1$iv = $changed;
                        fastFilterNotNull = i12;
                        maybeCachedBoxMeasurePolicy = i7;
                        mutableList = keys;
                        i15 = i16;
                    }
                    keys = mutableList;
                    i12 = fastFilterNotNull;
                    $dirty = maybeCachedBoxMeasurePolicy;
                    i16 = i15;
                    items = rememberedValue;
                } else {
                    $dirty = maybeCachedBoxMeasurePolicy;
                }
                restartGroup.endReplaceGroup();
                i25 &= 14;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                topStart = Alignment.Companion.getTopStart();
                i3 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                i = 0;
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
                int i50 = i31;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(topStart, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i49 = 0;
                Composer composer6 = constructor-impl;
                int i51 = 0;
                if (!composer6.getInserting()) {
                    $i$f$Box = valueOf;
                    alignment = topStart;
                    if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer6;
                    }
                } else {
                    $i$f$Box = valueOf;
                    alignment = topStart;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, modifier2), ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                i16 = i28;
                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i40 |= 6;
                i18 = 0;
                boxScopeInstance = iNSTANCE;
                i9 = i35;
                $i$a$LayoutBoxKt$Box$1$iv = composer5;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, -1643979990, "C394@15425L21:SnackbarHost.kt#uh7d8r");
                invalid$iv.setScope(ComposablesKt.getCurrentRecomposeScope($i$a$LayoutBoxKt$Box$1$iv, 0));
                $i$a$LayoutBoxKt$Box$1$iv.startReplaceGroup(1748085441);
                ComposerKt.sourceInformation($i$a$LayoutBoxKt$Box$1$iv, "");
                obj3 = invalid$iv;
                size = invalid$iv.getItems().size();
                i20 = i32;
                $i$f$fastForEach = i5;
                while ($i$f$fastForEach < size) {
                    int i52 = i5;
                    i21 = 0;
                    Object obj5 = component1;
                    $i$a$LayoutBoxKt$Box$1$iv.startMovableGroup(1201076541, (SnackbarData)obj5);
                    ComposerKt.sourceInformation($i$a$LayoutBoxKt$Box$1$iv, "395@15520L19,395@15512L27");
                    SnackbarHostKt.FadeInFadeOutWithScale.2.1.1 anon = new SnackbarHostKt.FadeInFadeOutWithScale.2.1.1(obj2, obj5);
                    obj = obj5;
                    i52.component2().invoke(ComposableLambdaKt.rememberComposableLambda(-1135367807, true, anon, $i$a$LayoutBoxKt$Box$1$iv, 54), $i$a$LayoutBoxKt$Box$1$iv, 6);
                    $i$a$LayoutBoxKt$Box$1$iv.endMovableGroup();
                    $i$f$fastForEach = i2 + 1;
                    i14 = obj37;
                    obj2 = content;
                    items = $this$fastForEach$iv;
                    size = i10;
                }
                $this$fastForEach$iv = items;
                i2 = $i$f$fastForEach;
                obj37 = i14;
                $i$a$LayoutBoxKt$Box$1$iv.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = keys;
            } else {
                restartGroup.skipToGroupEnd();
                obj4 = str;
                $dirty = maybeCachedBoxMeasurePolicy;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SnackbarHostKt.FadeInFadeOutWithScale.3(current, obj4, content, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void SnackbarHost(androidx.compose.material3.SnackbarHostState hostState, Modifier modifier, Function3<? super androidx.compose.material3.SnackbarData, ? super Composer, ? super Integer, Unit> snackbar, Composer $composer, int $changed, int i6) {
        int currentSnackbarData;
        int $dirty2;
        int $dirty;
        Object modifier3;
        Object obj3;
        Object modifier4;
        int i7;
        int lambda-1$material3_release;
        boolean traceInProgress;
        Object obj2;
        Object modifier2;
        int i5;
        int i;
        Object obj;
        int i8;
        int i9;
        int i3;
        int i4;
        Object empty;
        Object anon;
        int i2;
        final int i12 = $changed;
        currentSnackbarData = 464178177;
        final Composer restartGroup = $composer.startRestartGroup(currentSnackbarData);
        ComposerKt.sourceInformation(restartGroup, "C(SnackbarHost)223@9468L7,224@9516L348,224@9480L384,235@9869L134:SnackbarHost.kt#uh7d8r");
        $dirty2 = $changed;
        if (i6 & 1 != 0) {
            $dirty2 |= 6;
            obj3 = hostState;
        } else {
            if (i12 & 6 == 0) {
                i7 = restartGroup.changed(hostState) ? 4 : 2;
                $dirty2 |= i7;
            } else {
                obj3 = hostState;
            }
        }
        lambda-1$material3_release = i6 & 2;
        if (lambda-1$material3_release != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else {
            if (i12 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                modifier2 = modifier;
            }
        }
        i = i6 & 4;
        if (i != 0) {
            $dirty2 |= 384;
            obj = snackbar;
        } else {
            if (i12 & 384 == 0) {
                i8 = restartGroup.changedInstance(snackbar) ? 256 : 128;
                $dirty2 |= i8;
            } else {
                obj = snackbar;
            }
        }
        final int i24 = $dirty2;
        if (i24 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (lambda-1$material3_release != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i != 0) {
                    obj = lambda-1$material3_release;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(currentSnackbarData, i24, -1, "androidx.compose.material3.SnackbarHost (SnackbarHost.kt:221)");
                }
                currentSnackbarData = obj3.getCurrentSnackbarData();
                int i14 = 0;
                int i18 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -487334772, "CC(remember):SnackbarHost.kt#9igjgp");
                Composer composer = restartGroup;
                int i22 = 0;
                Object rememberedValue = composer.rememberedValue();
                i4 = 0;
                if (changed2 |= changedInstance == null) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new SnackbarHostKt.SnackbarHost.1.1(currentSnackbarData, this_$iv, 0);
                        composer.updateRememberedValue((Function2)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.LaunchedEffect(currentSnackbarData, (Function2)anon, restartGroup, 0);
                i = modifier3;
                SnackbarHostKt.FadeInFadeOutWithScale(obj3.getCurrentSnackbarData(), i, obj, restartGroup, i23 |= i19, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = i;
                obj2 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            currentSnackbarData = new SnackbarHostKt.SnackbarHost.2(obj3, modifier2, obj2, i12, i6);
            endRestartGroup.updateScope((Function2)currentSnackbarData);
        } else {
            modifier4 = modifier2;
        }
    }

    public static final void access$FadeInFadeOutWithScale(androidx.compose.material3.SnackbarData current, Modifier modifier, Function3 content, Composer $composer, int $changed, int $default) {
        SnackbarHostKt.FadeInFadeOutWithScale(current, modifier, content, $composer, $changed, $default);
    }

    public static final State access$animatedOpacity(AnimationSpec animation, boolean visible, Function0 onAnimationFinish, Composer $composer, int $changed, int $default) {
        return SnackbarHostKt.animatedOpacity(animation, visible, onAnimationFinish, $composer, $changed, $default);
    }

    public static final State access$animatedScale(AnimationSpec animation, boolean visible, Composer $composer, int $changed) {
        return SnackbarHostKt.animatedScale(animation, visible, $composer, $changed);
    }

    private static final State<Float> animatedOpacity(AnimationSpec<Float> animation, boolean visible, Function0<Unit> onAnimationFinish, Composer $composer, int $changed, int i6) {
        Object alpha;
        androidx.compose.material3.SnackbarHostKt.animatedOpacity.1 iNSTANCE;
        boolean traceInProgress;
        Animatable animatable;
        int empty;
        String str;
        boolean changed2;
        int i2;
        int changed;
        androidx.compose.material3.SnackbarHostKt.animatedOpacity.1 anon;
        int i7;
        Object $i$a$CacheSnackbarHostKt$animatedOpacity$alpha$1;
        int i4;
        int i3;
        int i;
        int i5;
        boolean z = visible;
        final Composer composer2 = $composer;
        final int i19 = $changed;
        int i8 = 1431889134;
        ComposerKt.sourceInformationMarkerStart(composer2, i8, "C(animatedOpacity)P(!1,2)419@16197L49,420@16275L111,420@16251L135:SnackbarHost.kt#uh7d8r");
        if (i6 & 4 != 0) {
            anon = iNSTANCE;
        } else {
            anon = onAnimationFinish;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, i19, -1, "androidx.compose.material3.animatedOpacity (SnackbarHost.kt:418)");
        }
        String str3 = "CC(remember):SnackbarHost.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer2, 2104079446, str3);
        int i10 = 0;
        Composer composer = $composer;
        int i18 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i20 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            int i25 = 0;
            i4 = 0;
            i3 = !z ? 1065353216 : i4;
            composer.updateRememberedValue(AnimatableKt.Animatable$default(i3, i4, 2, 0));
        } else {
            $i$a$CacheSnackbarHostKt$animatedOpacity$alpha$1 = rememberedValue;
        }
        Animatable invalid$iv = $i$a$CacheSnackbarHostKt$animatedOpacity$alpha$1;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerStart(composer2, 2104082004, str3);
        int i21 = 1;
        int i22 = 32;
        if (i16 ^= 48 > i22) {
            if (!composer2.changed(z)) {
                i2 = i19 & 48 == i22 ? i21 : i7;
            } else {
            }
        } else {
        }
        int i23 = 256;
        if (i17 ^= 384 > i23) {
            if (!composer2.changed(anon)) {
                if (i19 & 384 == i23) {
                    i7 = i21;
                }
            } else {
            }
        } else {
        }
        Composer composer3 = $composer;
        int i26 = 0;
        Object rememberedValue2 = composer3.rememberedValue();
        int i27 = 0;
        if (i12 |= i7 == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                i5 = 0;
                alpha = new SnackbarHostKt.animatedOpacity.2.1(invalid$iv, z, animation, anon, 0);
                composer3.updateRememberedValue((Function2)alpha);
            } else {
                animatable = invalid$iv;
                alpha = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        EffectsKt.LaunchedEffect(Boolean.valueOf(z), (Function2)alpha, composer2, i13 &= 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return animatable.asState();
    }

    private static final State<Float> animatedScale(AnimationSpec<Float> animation, boolean visible, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        boolean changed;
        int i3;
        Object $i$a$CacheSnackbarHostKt$animatedScale$scale$1;
        int empty;
        int i2;
        Object anon;
        int i;
        int i4 = 1966809761;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(animatedScale)429@16538L51,430@16618L85,430@16594L109:SnackbarHost.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.material3.animatedScale (SnackbarHost.kt:428)");
        }
        String str3 = "CC(remember):SnackbarHost.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, 1433330423, str3);
        int i6 = 0;
        Composer composer = $composer;
        int i11 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i16 = 0;
        final int i19 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            int i17 = 0;
            empty = !visible ? 1065353216 : 1061997773;
            composer.updateRememberedValue(AnimatableKt.Animatable$default(empty, 0, 2, i19));
        } else {
            $i$a$CacheSnackbarHostKt$animatedScale$scale$1 = rememberedValue;
        }
        Animatable invalid$iv = $i$a$CacheSnackbarHostKt$animatedScale$scale$1;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 1433333017, str3);
        int i14 = 32;
        if (i13 ^= 48 > i14) {
            if (!$composer.changed(visible)) {
                i3 = $changed & 48 == i14 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer2 = $composer;
        int i15 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        int i18 = 0;
        if (i7 |= changedInstance2 == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new SnackbarHostKt.animatedScale.1.1(invalid$iv, visible, animation, i19);
                composer2.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(Boolean.valueOf(visible), (Function2)anon, $composer, i9 &= 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return invalid$iv.asState();
    }

    public static final long toMillis(androidx.compose.material3.SnackbarDuration $this$toMillis, boolean hasAction, AccessibilityManager accessibilityManager) {
        int i;
        switch (i2) {
            case 1:
                i = Long.MAX_VALUE;
                break;
            case 2:
                i = 10000;
                break;
            case 3:
                i = 4000;
                break;
            default:
                Object obj3 = hasAction;
                NoWhenBranchMatchedException obj9 = new NoWhenBranchMatchedException();
                throw obj9;
        }
        final int i3 = i;
        if (accessibilityManager == null) {
            return i3;
        }
        return accessibilityManager.calculateRecommendedTimeoutMillis(i3, obj4, true, true);
    }
}
