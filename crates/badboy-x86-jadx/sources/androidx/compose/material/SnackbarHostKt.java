package androidx.compose.material;

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
@Metadata(d1 = "\u0000h\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a:\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\u0008\u000cH\u0003¢\u0006\u0002\u0010\r\u001a:\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0019\u0008\u0002\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\u0008\u000cH\u0007¢\u0006\u0002\u0010\u0012\u001a9\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0008\u0002\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u001bH\u0003¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0003¢\u0006\u0002\u0010\u001e\u001a\u001e\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020\u00192\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000*b\u0008\u0002\u0010%\"-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\u0008\u000c¢\u0006\u000c\u0008&\u0012\u0008\u0008'\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\u0008\u000c2-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00050\u001b¢\u0006\u0002\u0008\u000c¢\u0006\u000c\u0008&\u0012\u0008\u0008'\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\u0008\u000c¨\u0006(", d2 = {"SnackbarFadeInMillis", "", "SnackbarFadeOutMillis", "SnackbarInBetweenDelayMillis", "FadeInFadeOutWithScale", "", "current", "Landroidx/compose/material/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SnackbarHost", "hostState", "Landroidx/compose/material/SnackbarHostState;", "snackbar", "(Landroidx/compose/material/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animatedOpacity", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", "visible", "", "onAnimationFinish", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "toMillis", "", "Landroidx/compose/material/SnackbarDuration;", "hasAction", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "FadeInFadeOutTransition", "Lkotlin/ParameterName;", "name", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SnackbarHostKt {

    private static final int SnackbarFadeInMillis = 150;
    private static final int SnackbarFadeOutMillis = 75;
    private static final int SnackbarInBetweenDelayMillis;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal2;
            int ordinal3;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[SnackbarDuration.Indefinite.ordinal()] = 1;
            iArr[SnackbarDuration.Long.ordinal()] = 2;
            iArr[SnackbarDuration.Short.ordinal()] = 3;
            SnackbarHostKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    private static final void FadeInFadeOutWithScale(androidx.compose.material.SnackbarData current, Modifier modifier, Function3<? super androidx.compose.material.SnackbarData, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int size;
        boolean traceInProgress2;
        int i20;
        List items;
        int $dirty;
        int $dirty3;
        Object modifier2;
        int $i$f$fastForEach;
        Object obj3;
        Object obj;
        int i21;
        boolean valueOf;
        int i9;
        boolean traceInProgress;
        boolean mutableList;
        Composer composer;
        int i4;
        Object topStart;
        boolean changedInstance;
        Object str;
        int fastFilterNotNull;
        int i8;
        int i13;
        int maybeCachedBoxMeasurePolicy;
        Object rememberedValue;
        int i18;
        int i11;
        int i;
        Object empty;
        int i14;
        Object fadeInFadeOutState;
        int currentCompositeKeyHash;
        int index$iv$iv2;
        int materializeModifier;
        int index$iv$iv;
        int constructor;
        int i5;
        int i10;
        int i15;
        List list;
        int $dirty2;
        int i2;
        Object keys;
        int i17;
        Object obj4;
        int i16;
        BoxScopeInstance boxScopeInstance;
        int $i$f$Box;
        Alignment alignment;
        Composer composer2;
        int i22;
        int i19;
        int i12;
        int i7;
        List $this$fastForEach$iv;
        int i3;
        Object obj2;
        int obj37;
        items = current;
        i21 = $changed;
        traceInProgress2 = 2036134589;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(FadeInFadeOutWithScale)P(1,2)264@9342L48,322@11685L246:SnackbarHost.kt#jmzs0o");
        $dirty = $changed;
        if (i6 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i21 & 6 == 0) {
                if (i21 & 8 == 0) {
                    changedInstance = restartGroup.changed(items);
                } else {
                    changedInstance = restartGroup.changedInstance(items);
                }
                i9 = changedInstance != null ? 4 : 2;
                $dirty |= i9;
            }
        }
        i4 = i6 & 2;
        if (i4 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i21 & 48 == 0) {
                i8 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i8;
            } else {
                str = modifier;
            }
        }
        if (i6 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i21 & 384 == 0) {
                i13 = restartGroup.changedInstance(content) ? 256 : 128;
                $dirty |= i13;
            }
        }
        maybeCachedBoxMeasurePolicy = $dirty;
        if (maybeCachedBoxMeasurePolicy & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (i4 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, maybeCachedBoxMeasurePolicy, -1, "androidx.compose.material.FadeInFadeOutWithScale (SnackbarHost.kt:263)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 187635977, "CC(remember):SnackbarHost.kt#9igjgp");
                int i24 = 0;
                Composer composer4 = restartGroup;
                fastFilterNotNull = 0;
                rememberedValue = composer4.rememberedValue();
                i11 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    fadeInFadeOutState = new FadeInFadeOutState();
                    composer4.updateRememberedValue(fadeInFadeOutState);
                } else {
                    fadeInFadeOutState = rememberedValue;
                }
                Object invalid$iv = fadeInFadeOutState;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (!Intrinsics.areEqual(items, (FadeInFadeOutState)invalid$iv.getCurrent())) {
                    restartGroup.startReplaceGroup(1521898746);
                    ComposerKt.sourceInformation(restartGroup, "*273@9741L1923");
                    invalid$iv.setCurrent(items);
                    List items2 = invalid$iv.getItems();
                    int i45 = 0;
                    ArrayList arrayList = new ArrayList(items2.size());
                    List list2 = items2;
                    int i50 = 0;
                    index$iv$iv = 0;
                    while (index$iv$iv < list2.size()) {
                        i15 = 0;
                        i2 = 0;
                        (Collection)arrayList.add((SnackbarData)(FadeInFadeOutAnimationItem)list2.get(index$iv$iv).getKey());
                        index$iv$iv++;
                    }
                    mutableList = CollectionsKt.toMutableList((Collection)(List)arrayList);
                    if (!mutableList.contains(items)) {
                        mutableList.add(items);
                    }
                    invalid$iv.getItems().clear();
                    rememberedValue = invalid$iv.getItems();
                    i11 = 0;
                    empty = fastFilterNotNull;
                    fadeInFadeOutState = 0;
                    index$iv$iv2 = 0;
                    while (index$iv$iv2 < empty.size()) {
                        i10 = 0;
                        int i36 = i5;
                        i15 = 0;
                        SnackbarHostKt.FadeInFadeOutWithScale.1.1 $dirty4 = new SnackbarHostKt.FadeInFadeOutWithScale.1.1((SnackbarData)i36, items, mutableList, invalid$iv);
                        FadeInFadeOutAnimationItem $this$fastMapTo$iv = new FadeInFadeOutAnimationItem(i36, (Function3)ComposableLambdaKt.rememberComposableLambda(1471040642, true, $dirty4, restartGroup, 54));
                        (Collection)rememberedValue.add($this$fastMapTo$iv);
                        index$iv$iv2++;
                        items = current;
                        i21 = $changed;
                        fastFilterNotNull = list;
                        maybeCachedBoxMeasurePolicy = i2;
                        mutableList = keys;
                        i11 = i17;
                    }
                    keys = mutableList;
                    list = fastFilterNotNull;
                    $dirty2 = maybeCachedBoxMeasurePolicy;
                    i17 = i11;
                    i20 = rememberedValue;
                    restartGroup.endReplaceGroup();
                } else {
                    $dirty2 = maybeCachedBoxMeasurePolicy;
                    restartGroup.startReplaceGroup(1524065801);
                    restartGroup.endReplaceGroup();
                }
                i25 &= 14;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                topStart = Alignment.Companion.getTopStart();
                i = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                i15 = 0;
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
                int i52 = i32;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(topStart, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i51 = 0;
                Composer composer6 = constructor-impl;
                int i53 = 0;
                if (!composer6.getInserting()) {
                    $i$f$Box = valueOf;
                    alignment = topStart;
                    if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer6;
                    }
                } else {
                    $i$f$Box = valueOf;
                    alignment = topStart;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, modifier2), ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                i17 = i28;
                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i40 |= 6;
                i16 = 0;
                boxScopeInstance = iNSTANCE;
                i22 = i35;
                i21 = composer5;
                ComposerKt.sourceInformationMarkerStart(i21, 9772019, "C323@11723L21:SnackbarHost.kt#jmzs0o");
                invalid$iv.setScope(ComposablesKt.getCurrentRecomposeScope(i21, 0));
                i21.startReplaceGroup(1801432280);
                ComposerKt.sourceInformation(i21, "");
                obj4 = invalid$iv;
                size = invalid$iv.getItems().size();
                i19 = i33;
                $i$f$fastForEach = i5;
                while ($i$f$fastForEach < size) {
                    int i54 = i5;
                    i7 = 0;
                    Object obj5 = component1;
                    i21.startMovableGroup(2123976768, (SnackbarData)obj5);
                    ComposerKt.sourceInformation(i21, "326@11846L55,326@11838L63");
                    SnackbarHostKt.FadeInFadeOutWithScale.2.1.1 anon = new SnackbarHostKt.FadeInFadeOutWithScale.2.1.1(obj, obj5);
                    obj2 = obj5;
                    i54.component2().invoke(ComposableLambdaKt.rememberComposableLambda(2041982076, true, anon, i21, 54), i21, 6);
                    i21.endMovableGroup();
                    $i$f$fastForEach = i12 + 1;
                    i4 = obj37;
                    obj = content;
                    items = $this$fastForEach$iv;
                    size = i3;
                }
                $this$fastForEach$iv = items;
                i12 = $i$f$fastForEach;
                obj37 = i4;
                i21.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(i21);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = keys;
            } else {
                restartGroup.skipToGroupEnd();
                obj3 = str;
                $dirty2 = maybeCachedBoxMeasurePolicy;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SnackbarHostKt.FadeInFadeOutWithScale.3(current, obj3, content, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void SnackbarHost(androidx.compose.material.SnackbarHostState hostState, Modifier modifier, Function3<? super androidx.compose.material.SnackbarData, ? super Composer, ? super Integer, Unit> snackbar, Composer $composer, int $changed, int i6) {
        int currentSnackbarData;
        int $dirty2;
        int $dirty;
        Object modifier3;
        Object obj;
        Object modifier4;
        int i4;
        int lambda-1$material_release;
        boolean traceInProgress;
        Object obj2;
        Object modifier2;
        int i3;
        int i7;
        Object obj3;
        int i8;
        int i;
        int i2;
        int i5;
        Object empty;
        Object anon;
        int i9;
        final int i12 = $changed;
        currentSnackbarData = 431012348;
        final Composer restartGroup = $composer.startRestartGroup(currentSnackbarData);
        ComposerKt.sourceInformation(restartGroup, "C(SnackbarHost)159@6593L7,160@6641L304,160@6605L340,170@6950L134:SnackbarHost.kt#jmzs0o");
        $dirty2 = $changed;
        if (i6 & 1 != 0) {
            $dirty2 |= 6;
            obj = hostState;
        } else {
            if (i12 & 6 == 0) {
                i4 = restartGroup.changed(hostState) ? 4 : 2;
                $dirty2 |= i4;
            } else {
                obj = hostState;
            }
        }
        lambda-1$material_release = i6 & 2;
        if (lambda-1$material_release != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else {
            if (i12 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                modifier2 = modifier;
            }
        }
        i7 = i6 & 4;
        if (i7 != 0) {
            $dirty2 |= 384;
            obj3 = snackbar;
        } else {
            if (i12 & 384 == 0) {
                i8 = restartGroup.changedInstance(snackbar) ? 256 : 128;
                $dirty2 |= i8;
            } else {
                obj3 = snackbar;
            }
        }
        final int i24 = $dirty2;
        if (i24 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (lambda-1$material_release != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i7 != 0) {
                    obj3 = lambda-1$material_release;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(currentSnackbarData, i24, -1, "androidx.compose.material.SnackbarHost (SnackbarHost.kt:157)");
                }
                currentSnackbarData = obj.getCurrentSnackbarData();
                int i14 = 0;
                int i18 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1079932477, "CC(remember):SnackbarHost.kt#9igjgp");
                Composer composer = restartGroup;
                int i22 = 0;
                Object rememberedValue = composer.rememberedValue();
                i5 = 0;
                if (changedInstance |= changedInstance2 == 0) {
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
                i7 = modifier3;
                SnackbarHostKt.FadeInFadeOutWithScale(obj.getCurrentSnackbarData(), i7, obj3, restartGroup, i23 |= i19, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = i7;
                obj2 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = obj3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            currentSnackbarData = new SnackbarHostKt.SnackbarHost.2(obj, modifier2, obj2, i12, i6);
            endRestartGroup.updateScope((Function2)currentSnackbarData);
        } else {
            modifier4 = modifier2;
        }
    }

    public static final void access$FadeInFadeOutWithScale(androidx.compose.material.SnackbarData current, Modifier modifier, Function3 content, Composer $composer, int $changed, int $default) {
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
        androidx.compose.material.SnackbarHostKt.animatedOpacity.1 iNSTANCE;
        boolean traceInProgress;
        Animatable animatable;
        int empty;
        String str;
        boolean changed2;
        int i7;
        int changed;
        androidx.compose.material.SnackbarHostKt.animatedOpacity.1 anon;
        int i3;
        Object obj;
        int i4;
        int i5;
        int i2;
        int i;
        boolean z = visible;
        final Composer composer2 = $composer;
        final int i19 = $changed;
        int i8 = 1016418159;
        ComposerKt.sourceInformationMarkerStart(composer2, i8, "C(animatedOpacity)P(!1,2)354@12579L49,355@12657L145,355@12633L169:SnackbarHost.kt#jmzs0o");
        if (i6 & 4 != 0) {
            anon = iNSTANCE;
        } else {
            anon = onAnimationFinish;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, i19, -1, "androidx.compose.material.animatedOpacity (SnackbarHost.kt:353)");
        }
        String str3 = "CC(remember):SnackbarHost.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer2, -1211563917, str3);
        int i10 = 0;
        Composer composer = $composer;
        int i18 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i20 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            int i25 = 0;
            i4 = 0;
            i5 = !z ? 1065353216 : i4;
            composer.updateRememberedValue(AnimatableKt.Animatable$default(i5, i4, 2, 0));
        } else {
            obj = rememberedValue;
        }
        Animatable invalid$iv = obj;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerStart(composer2, -1211561325, str3);
        int i21 = 1;
        int i22 = 32;
        if (i16 ^= 48 > i22) {
            if (!composer2.changed(z)) {
                i7 = i19 & 48 == i22 ? i21 : i3;
            } else {
            }
        } else {
        }
        int i23 = 256;
        if (i17 ^= 384 > i23) {
            if (!composer2.changed(anon)) {
                if (i19 & 384 == i23) {
                    i3 = i21;
                }
            } else {
            }
        } else {
        }
        Composer composer3 = $composer;
        int i26 = 0;
        Object rememberedValue2 = composer3.rememberedValue();
        int i27 = 0;
        if (i12 |= i3 == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                i = 0;
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
        int i2;
        Object animatable;
        int empty;
        int i;
        Object anon;
        int i3;
        int i4 = 2003504988;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(animatedScale)367@12954L51,368@13034L119,368@13010L143:SnackbarHost.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.material.animatedScale (SnackbarHost.kt:366)");
        }
        String str3 = "CC(remember):SnackbarHost.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, 245409428, str3);
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
            animatable = rememberedValue;
        }
        Animatable invalid$iv = animatable;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 245412056, str3);
        int i14 = 32;
        if (i13 ^= 48 > i14) {
            if (!$composer.changed(visible)) {
                i2 = $changed & 48 == i14 ? 1 : 0;
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

    public static final long toMillis(androidx.compose.material.SnackbarDuration $this$toMillis, boolean hasAction, AccessibilityManager accessibilityManager) {
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
