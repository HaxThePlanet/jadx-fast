package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.BasicTooltipDefaults;
import androidx.compose.material3.internal.BasicTooltip_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0000\u001al\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020!0%¢\u0006\u0002\u0008'¢\u0006\u0002\u0008(2\u0006\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u0008\u0008\u0002\u0010-\u001a\u00020.2\u0008\u0008\u0002\u0010/\u001a\u00020.2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020!01¢\u0006\u0002\u0008'H\u0007¢\u0006\u0002\u00102\u001a&\u00103\u001a\u00020*2\u0008\u0008\u0002\u00104\u001a\u00020.2\u0008\u0008\u0002\u00105\u001a\u00020.2\u0008\u0008\u0002\u00106\u001a\u000207H\u0007\u001a+\u00108\u001a\u00020*2\u0008\u0008\u0002\u00104\u001a\u00020.2\u0008\u0008\u0002\u00105\u001a\u00020.2\u0008\u0008\u0002\u00106\u001a\u000207H\u0007¢\u0006\u0002\u00109\u001a\u001a\u0010:\u001a\u00020,*\u00020,2\u000c\u0010;\u001a\u0008\u0012\u0004\u0012\u00020.0<H\u0000\u001a\u001c\u0010=\u001a\u00020,*\u00020,2\u0006\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020.H\u0001\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0006\u0010\u0003\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u0008\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\t\u0010\u0003\"\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u000f\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0010\u0010\u0003\"\u0010\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u0012\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0013\u0010\u0003\"\u0016\u0010\u0014\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0015\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0017\u0010\u0003\"\u0010\u0010\u0018\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u001aX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u001c\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u001d\u0010\u0003\"\u0016\u0010\u001e\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u001f\u0010\u0003¨\u0006@²\u0006\n\u0010A\u001a\u00020BX\u008a\u0084\u0002²\u0006\n\u0010C\u001a\u00020BX\u008a\u0084\u0002", d2 = {"ActionLabelBottomPadding", "Landroidx/compose/ui/unit/Dp;", "getActionLabelBottomPadding", "()F", "F", "ActionLabelMinHeight", "getActionLabelMinHeight", "HeightFromSubheadToTextFirstLine", "HeightToSubheadFirstLine", "getHeightToSubheadFirstLine", "PlainTooltipContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getPlainTooltipContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "PlainTooltipHorizontalPadding", "PlainTooltipMaxWidth", "getPlainTooltipMaxWidth", "PlainTooltipVerticalPadding", "RichTooltipHorizontalPadding", "getRichTooltipHorizontalPadding", "RichTooltipMaxWidth", "getRichTooltipMaxWidth", "SpacingBetweenTooltipAndAnchor", "getSpacingBetweenTooltipAndAnchor", "TextBottomPadding", "TooltipFadeInDuration", "", "TooltipFadeOutDuration", "TooltipMinHeight", "getTooltipMinHeight", "TooltipMinWidth", "getTooltipMinWidth", "TooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "state", "Landroidx/compose/material3/TooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "focusable", "", "enableUserInput", "content", "Lkotlin/Function0;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "rememberTooltipState", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "animateTooltip", "transition", "Landroidx/compose/animation/core/Transition;", "textVerticalPadding", "subheadExists", "actionExists", "material3_release", "scale", "", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TooltipKt {

    private static final float ActionLabelBottomPadding = 0f;
    private static final float ActionLabelMinHeight = 0f;
    private static final float HeightFromSubheadToTextFirstLine = 0f;
    private static final float HeightToSubheadFirstLine = 0f;
    private static final PaddingValues PlainTooltipContentPadding = null;
    private static final float PlainTooltipHorizontalPadding = 0f;
    private static final float PlainTooltipMaxWidth = 0f;
    private static final float PlainTooltipVerticalPadding = 0f;
    private static final float RichTooltipHorizontalPadding = 0f;
    private static final float RichTooltipMaxWidth = 0f;
    private static final float SpacingBetweenTooltipAndAnchor = 0f;
    private static final float TextBottomPadding = 0f;
    public static final int TooltipFadeInDuration = 150;
    public static final int TooltipFadeOutDuration = 75;
    private static final float TooltipMinHeight;
    private static final float TooltipMinWidth;
    static {
        int i14 = 0;
        TooltipKt.SpacingBetweenTooltipAndAnchor = Dp.constructor-impl((float)i);
        int i15 = 0;
        TooltipKt.TooltipMinHeight = Dp.constructor-impl((float)i2);
        int i16 = 0;
        TooltipKt.TooltipMinWidth = Dp.constructor-impl((float)i3);
        int i17 = 0;
        TooltipKt.PlainTooltipMaxWidth = Dp.constructor-impl((float)i4);
        int i18 = 0;
        TooltipKt.PlainTooltipVerticalPadding = Dp.constructor-impl((float)i5);
        int i19 = 0;
        TooltipKt.PlainTooltipHorizontalPadding = Dp.constructor-impl((float)i6);
        TooltipKt.PlainTooltipContentPadding = PaddingKt.PaddingValues-YgX7TsA(TooltipKt.PlainTooltipHorizontalPadding, TooltipKt.PlainTooltipVerticalPadding);
        int i20 = 0;
        TooltipKt.RichTooltipMaxWidth = Dp.constructor-impl((float)i7);
        int i21 = 0;
        TooltipKt.RichTooltipHorizontalPadding = Dp.constructor-impl((float)i8);
        int i22 = 0;
        TooltipKt.HeightToSubheadFirstLine = Dp.constructor-impl((float)i9);
        int i23 = 0;
        TooltipKt.HeightFromSubheadToTextFirstLine = Dp.constructor-impl((float)i10);
        int i24 = 0;
        TooltipKt.TextBottomPadding = Dp.constructor-impl((float)i11);
        int i25 = 0;
        TooltipKt.ActionLabelMinHeight = Dp.constructor-impl((float)i12);
        int i26 = 0;
        TooltipKt.ActionLabelBottomPadding = Dp.constructor-impl((float)i13);
    }

    public static final void TooltipBox(PopupPositionProvider positionProvider, Function3<? super androidx.compose.material3.TooltipScope, ? super Composer, ? super Integer, Unit> tooltip, androidx.compose.material3.TooltipState state, Modifier modifier, boolean focusable, boolean enableUserInput, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        Object anon;
        Object mutableStateOf$default;
        boolean traceInProgress;
        Object invalid$iv;
        Object obj2;
        int $dirty;
        boolean z2;
        int companion2;
        boolean traceInProgress2;
        int $i$f$cache;
        Object obj;
        boolean modifier3;
        boolean i5;
        int i11;
        int i7;
        int i;
        boolean i8;
        boolean changedInstance;
        Object modifier2;
        int i9;
        int str;
        boolean z;
        int i3;
        Transition transition;
        boolean z3;
        Object empty;
        int i2;
        int i4;
        int i6;
        Composer.Companion companion;
        int obj21;
        int obj22;
        final Object obj3 = tooltip;
        traceInProgress = state;
        anon = content;
        mutableStateOf$default = $changed;
        int i15 = 1836749106;
        final Composer restartGroup = $composer.startRestartGroup(i15);
        ComposerKt.sourceInformation(restartGroup, "C(TooltipBox)P(4,6,5,3,2,1)133@5704L64,134@5826L33,135@5876L52,137@5979L103,143@6168L64,141@6088L310:Tooltip.kt#uh7d8r");
        $dirty = $changed;
        if (i10 & 1 != 0) {
            $dirty |= 6;
            obj = positionProvider;
        } else {
            if (mutableStateOf$default & 6 == 0) {
                i11 = restartGroup.changed(positionProvider) ? 4 : 2;
                $dirty |= i11;
            } else {
                obj = positionProvider;
            }
        }
        if (i10 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (mutableStateOf$default & 48 == 0) {
                i7 = restartGroup.changedInstance(obj3) ? 32 : 16;
                $dirty |= i7;
            }
        }
        if (i10 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (mutableStateOf$default & 384 == 0) {
                if (mutableStateOf$default & 512 == 0) {
                    changedInstance = restartGroup.changed(traceInProgress);
                } else {
                    changedInstance = restartGroup.changedInstance(traceInProgress);
                }
                i = changedInstance != null ? 256 : 128;
                $dirty |= i;
            }
        }
        i8 = i10 & 8;
        if (i8 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else {
            if (mutableStateOf$default & 3072 == 0) {
                i9 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty |= i9;
            } else {
                modifier2 = modifier;
            }
        }
        str = i10 & 16;
        if (str != null) {
            $dirty |= 24576;
            z = focusable;
        } else {
            if (mutableStateOf$default & 24576 == 0) {
                i3 = restartGroup.changed(focusable) ? 16384 : 8192;
                $dirty |= i3;
            } else {
                z = focusable;
            }
        }
        transition = i10 & 32;
        int i43 = 196608;
        if (transition != 0) {
            $dirty |= i43;
            z3 = enableUserInput;
        } else {
            if (i43 &= mutableStateOf$default == 0) {
                i2 = restartGroup.changed(enableUserInput) ? 131072 : 65536;
                $dirty |= i2;
            } else {
                z3 = enableUserInput;
            }
        }
        i6 = 1572864;
        if (i10 & 64 != 0) {
            $dirty |= i6;
        } else {
            if (mutableStateOf$default & i6 == 0) {
                i4 = restartGroup.changedInstance(anon) ? 1048576 : 524288;
                $dirty |= i4;
            }
        }
        int i45 = $dirty;
        if ($dirty2 &= i45 == 599186) {
            if (!restartGroup.getSkipping()) {
                if (i8 != 0) {
                    modifier2 = companion2;
                }
                i5 = str != null ? companion2 : z;
                i8 = transition != 0 ? companion2 : z3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i15, i45, -1, "androidx.compose.material3.TooltipBox (Tooltip.kt:131)");
                }
                String str3 = "CC(remember):Tooltip.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1495108980, str3);
                int i17 = 0;
                Composer composer2 = restartGroup;
                int i40 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                i6 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    obj21 = i12;
                    int $i$a$CacheTooltipKt$TooltipBox$anchorBounds$1 = 0;
                    composer2.updateRememberedValue(SnapshotStateKt.mutableStateOf$default($i$a$CacheTooltipKt$TooltipBox$anchorBounds$1, $i$a$CacheTooltipKt$TooltipBox$anchorBounds$1, 2, $i$a$CacheTooltipKt$TooltipBox$anchorBounds$1));
                } else {
                    mutableStateOf$default = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1495107361, str3);
                int i14 = 0;
                Composer composer = restartGroup;
                $i$f$cache = 0;
                Object rememberedValue = composer.rememberedValue();
                int i41 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    obj21 = i14;
                    obj22 = $i$f$cache;
                    $i$f$cache = new TooltipKt.TooltipBox.scope.1.1((MutableState)mutableStateOf$default);
                    invalid$iv = new TooltipScopeImpl((Function0)$i$f$cache);
                    composer.updateRememberedValue(invalid$iv);
                } else {
                    obj21 = i14;
                    obj22 = $i$f$cache;
                    invalid$iv = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                TooltipKt.TooltipBox.wrappedContent.1 anon2 = new TooltipKt.TooltipBox.wrappedContent.1(mutableStateOf$default, anon);
                int i20 = 1;
                int i31 = 54;
                TooltipKt.TooltipBox.1 anon3 = new TooltipKt.TooltipBox.1(TransitionKt.updateTransition(traceInProgress.getTransition(), "tooltip transition", restartGroup, $stable |= 48, 0), obj3, (TooltipScopeImpl)invalid$iv);
                Object obj6 = obj5;
                BasicTooltip_androidKt.BasicTooltipBox(obj, (Function2)ComposableLambdaKt.rememberComposableLambda(-149611544, i20, anon3, restartGroup, i31), state, obj6, i5, i8, (Function2)ComposableLambdaKt.rememberComposableLambda(-1130808188, i20, anon2, restartGroup, i31), restartGroup, i38 |= i25, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj6;
                z2 = i5;
                modifier3 = i8;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = modifier2;
                z2 = z;
                modifier3 = z3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new TooltipKt.TooltipBox.2(positionProvider, obj3, state, obj2, z2, modifier3, content, $changed, i10);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    public static final androidx.compose.material3.TooltipState TooltipState(boolean initialIsVisible, boolean isPersistent, MutatorMutex mutatorMutex) {
        TooltipStateImpl tooltipStateImpl = new TooltipStateImpl(initialIsVisible, isPersistent, mutatorMutex);
        return (TooltipState)tooltipStateImpl;
    }

    public static androidx.compose.material3.TooltipState TooltipState$default(boolean z, boolean z2, MutatorMutex mutatorMutex3, int i4, Object object5) {
        int obj0;
        int obj1;
        MutatorMutex obj2;
        if (i4 & 1 != 0) {
            obj0 = 0;
        }
        if (i4 & 2 != 0) {
            obj1 = 1;
        }
        if (i4 &= 4 != 0) {
            obj2 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return TooltipKt.TooltipState(obj0, obj1, obj2);
    }

    public static final Modifier animateTooltip(Modifier $this$animateTooltip, Transition<Boolean> transition) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new TooltipKt.animateTooltip$$inlined.debugInspectorInfo.1(transition);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        TooltipKt.animateTooltip.2 $i$f$debugInspectorInfo = new TooltipKt.animateTooltip.2(transition);
        return ComposedModifierKt.composed($this$animateTooltip, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }

    public static final float getActionLabelBottomPadding() {
        return TooltipKt.ActionLabelBottomPadding;
    }

    public static final float getActionLabelMinHeight() {
        return TooltipKt.ActionLabelMinHeight;
    }

    public static final float getHeightToSubheadFirstLine() {
        return TooltipKt.HeightToSubheadFirstLine;
    }

    public static final PaddingValues getPlainTooltipContentPadding() {
        return TooltipKt.PlainTooltipContentPadding;
    }

    public static final float getPlainTooltipMaxWidth() {
        return TooltipKt.PlainTooltipMaxWidth;
    }

    public static final float getRichTooltipHorizontalPadding() {
        return TooltipKt.RichTooltipHorizontalPadding;
    }

    public static final float getRichTooltipMaxWidth() {
        return TooltipKt.RichTooltipMaxWidth;
    }

    public static final float getSpacingBetweenTooltipAndAnchor() {
        return TooltipKt.SpacingBetweenTooltipAndAnchor;
    }

    public static final float getTooltipMinHeight() {
        return TooltipKt.TooltipMinHeight;
    }

    public static final float getTooltipMinWidth() {
        return TooltipKt.TooltipMinWidth;
    }

    public static final androidx.compose.material3.TooltipState rememberTooltipState(boolean initialIsVisible, boolean isPersistent, MutatorMutex mutatorMutex, Composer $composer, int $changed, int i6) {
        int i;
        int str;
        int changed;
        Object empty;
        Object tooltipStateImpl;
        int obj6;
        int obj7;
        MutatorMutex obj8;
        int obj11;
        int i2 = -1413230530;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberTooltipState)436@18949L210:Tooltip.kt#uh7d8r");
        if (i6 & 1 != 0) {
            obj6 = 0;
        }
        if (i6 & 2 != 0) {
            obj7 = 0;
        }
        if (i6 &= 4 != 0) {
            obj8 = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material3.rememberTooltipState (Tooltip.kt:436)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1281295952, "CC(remember):Tooltip.kt#9igjgp");
        int i4 = 32;
        int i8 = 1;
        if (obj11 ^= 48 > i4) {
            if (!$composer.changed(obj7)) {
                obj11 = $changed & 48 == i4 ? i8 : i;
            } else {
            }
        } else {
        }
        int i9 = 256;
        if (i5 ^= 384 > i9) {
            if (!$composer.changed(obj8)) {
                if ($changed & 384 == i9) {
                    i = i8;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i7 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i10 = 0;
        if (obj11 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                tooltipStateImpl = new TooltipStateImpl(obj6, obj7, obj8);
                composer.updateRememberedValue(tooltipStateImpl);
            } else {
                tooltipStateImpl = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (TooltipState)(TooltipStateImpl)tooltipStateImpl;
    }

    public static final Modifier textVerticalPadding(Modifier $this$textVerticalPadding, boolean subheadExists, boolean actionExists) {
        Modifier padding-qDBjuR0$default;
        float heightFromSubheadToTextFirstLine;
        int i4;
        Modifier paddingFromBaseline-VpY3zN4$default;
        int i5;
        int i6;
        int i3;
        float textBottomPadding;
        int i;
        int i2;
        int i7 = 0;
        final int i8 = 0;
        if (!subheadExists && !actionExists) {
            if (!actionExists) {
                padding-qDBjuR0$default = PaddingKt.padding-VpY3zN4$default($this$textVerticalPadding, i8, TooltipKt.PlainTooltipVerticalPadding, 1, i7);
            } else {
                padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(AlignmentLineKt.paddingFromBaseline-VpY3zN4$default($this$textVerticalPadding, TooltipKt.HeightFromSubheadToTextFirstLine, i8, 2, i7), 0, 0, 0, TooltipKt.TextBottomPadding, 7, 0);
            }
        } else {
        }
        return padding-qDBjuR0$default;
    }
}
