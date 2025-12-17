package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a5\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u00082\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000cH\u0007¢\u0006\u0002\u0010\r\u001a?\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u00082\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000c2\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u000e\u001aY\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u0007\"\u0004\u0008\u0000\u0010\u0010\"\u0008\u0008\u0001\u0010\u0011*\u00020\u0012*\u00020\u00012\u0006\u0010\t\u001a\u0002H\u00102\u0006\u0010\n\u001a\u0002H\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u00142\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u000cH\u0007¢\u0006\u0002\u0010\u0015\u001ac\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u0007\"\u0004\u0008\u0000\u0010\u0010\"\u0008\u0008\u0001\u0010\u0011*\u00020\u0012*\u00020\u00012\u0006\u0010\t\u001a\u0002H\u00102\u0006\u0010\n\u001a\u0002H\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u00142\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u000c2\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017", d2 = {"rememberInfiniteTransition", "Landroidx/compose/animation/core/InfiniteTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/InfiniteTransition;", "label", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/InfiniteTransition;", "animateFloat", "Landroidx/compose/runtime/State;", "", "initialValue", "targetValue", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateValue", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InfiniteTransitionKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateFloat APIs now have a new label parameter added.")
    public static final State animateFloat(androidx.compose.animation.core.InfiniteTransition $this$animateFloat, float initialValue, float targetValue, androidx.compose.animation.core.InfiniteRepeatableSpec animationSpec, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 469472752;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(animateFloat)P(1,2)357@13770L155:InfiniteTransition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:356)");
        }
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return InfiniteTransitionKt.animateFloat($this$animateFloat, initialValue, targetValue, animationSpec, "FloatAnimation", composer, i5 | i8, 0);
    }

    public static final State<Float> animateFloat(androidx.compose.animation.core.InfiniteTransition $this$animateFloat, float initialValue, float targetValue, androidx.compose.animation.core.InfiniteRepeatableSpec<Float> animationSpec, String label, Composer $composer, int $changed, int i8) {
        int str3;
        boolean traceInProgress;
        String str2;
        String str;
        final int i = $changed;
        int i2 = -644770905;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(animateFloat)P(1,3)316@12588L84:InfiniteTransition.kt#pdpnli");
        str = i8 & 8 != 0 ? str3 : label;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:316)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return InfiniteTransitionKt.animateValue($this$animateFloat, Float.valueOf(initialValue), Float.valueOf(targetValue), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), animationSpec, str, composer, i6 | i13, 0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateValue APIs now have a new label parameter added.")
    public static final State animateValue(androidx.compose.animation.core.InfiniteTransition $this$animateValue, Object initialValue, Object targetValue, androidx.compose.animation.core.TwoWayConverter typeConverter, androidx.compose.animation.core.InfiniteRepeatableSpec animationSpec, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        final int i = $changed;
        int i2 = -1695411770;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(animateValue)P(1,2,3)338@13274L202:InfiniteTransition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:337)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return InfiniteTransitionKt.animateValue($this$animateValue, initialValue, targetValue, typeConverter, animationSpec, "ValueAnimation", composer, i9 | i21, 0);
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> State<T> animateValue(androidx.compose.animation.core.InfiniteTransition $this$animateValue, T initialValue, T targetValue, androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter, androidx.compose.animation.core.InfiniteRepeatableSpec<T> animationSpec, String label, Composer $composer, int $changed, int i9) {
        Object transitionAnimationState;
        int str;
        boolean traceInProgress;
        androidx.compose.animation.core.InfiniteTransition infiniteTransition;
        String str2;
        Object obj2;
        Object obj;
        androidx.compose.animation.core.TwoWayConverter twoWayConverter;
        boolean changedInstance2;
        int i3;
        androidx.compose.animation.core.AnimationSpec animationSpec2;
        int changedInstance3;
        int i4;
        int changedInstance;
        String str3;
        int i;
        Object anon;
        Object rememberedValue;
        Object anon2;
        Object empty;
        int i2;
        final Object obj3 = animationSpec;
        final Composer composer3 = $composer;
        final int i19 = $changed;
        int i5 = -1062847727;
        ComposerKt.sourceInformationMarkerStart(composer3, i5, "C(animateValue)P(1,3,4)262@10743L151,268@10911L346,268@10900L357,280@11301L128,280@11263L166:InfiniteTransition.kt#pdpnli");
        str3 = i9 & 16 != 0 ? str : label;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, i19, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:260)");
        }
        String str5 = "CC(remember):InfiniteTransition.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer3, 1444224427, str5);
        int i21 = 0;
        Composer composer4 = $composer;
        int i24 = 0;
        Object rememberedValue3 = composer4.rememberedValue();
        empty = 0;
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            i2 = 0;
            transitionAnimationState = new InfiniteTransition.TransitionAnimationState($this$animateValue, initialValue, targetValue, typeConverter, (AnimationSpec)obj3, str3);
            composer4.updateRememberedValue(transitionAnimationState);
        } else {
            infiniteTransition = $this$animateValue;
            obj2 = initialValue;
            obj = targetValue;
            transitionAnimationState = rememberedValue3;
        }
        ComposerKt.sourceInformationMarkerEnd(composer3);
        ComposerKt.sourceInformationMarkerStart(composer3, 1444229998, str5);
        int i15 = 32;
        i = 1;
        if (i8 ^= 48 > i15) {
            if (!composer3.changedInstance(obj2)) {
                i3 = i19 & 48 == i15 ? i : 0;
            } else {
            }
        } else {
        }
        int i25 = 256;
        if (i16 ^= 384 > i25) {
            if (!composer3.changedInstance(obj)) {
                i4 = i19 & 384 == i25 ? i : 0;
            } else {
            }
        } else {
        }
        int i26 = 16384;
        if (i18 ^= 24576 > i26) {
            if (!composer3.changedInstance(obj3)) {
                if (i19 & 24576 == i26) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i22 = 0;
        rememberedValue = composer.rememberedValue();
        int i27 = 0;
        if (i10 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new InfiniteTransitionKt.animateValue.1.1(obj2, (InfiniteTransition.TransitionAnimationState)transitionAnimationState, obj, obj3);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer3);
        EffectsKt.SideEffect((Function0)anon, composer3, 0);
        ComposerKt.sourceInformationMarkerStart(composer3, 1444242260, str5);
        Composer composer2 = $composer;
        int i20 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        int i23 = 0;
        if (!composer3.changedInstance(infiniteTransition)) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue = 0;
                anon2 = new InfiniteTransitionKt.animateValue.2.1(infiniteTransition, transitionAnimationState);
                composer2.updateRememberedValue((Function1)anon2);
            } else {
                anon2 = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer3);
        EffectsKt.DisposableEffect(transitionAnimationState, (Function1)anon2, composer3, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer3);
        return (State)transitionAnimationState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "rememberInfiniteTransition APIs now have a new label parameter added.")
    public static final androidx.compose.animation.core.InfiniteTransition rememberInfiniteTransition(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -840193660;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberInfiniteTransition)324@12880L48:InfiniteTransition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:323)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return InfiniteTransitionKt.rememberInfiniteTransition("InfiniteTransition", $composer, 6, 0);
    }

    public static final androidx.compose.animation.core.InfiniteTransition rememberInfiniteTransition(String label, Composer $composer, int $changed, int i4) {
        String str;
        Object empty;
        Object infiniteTransition;
        String obj6;
        boolean obj9;
        int i = 1013651573;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberInfiniteTransition)45@1981L38,46@2043L5:InfiniteTransition.kt#pdpnli");
        if (i4 &= 1 != 0) {
            obj6 = "InfiniteTransition";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:44)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1916602784, "CC(remember):InfiniteTransition.kt#9igjgp");
        obj9 = 0;
        Composer composer = $composer;
        int i3 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i5 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty = 0;
            infiniteTransition = new InfiniteTransition(obj6);
            composer.updateRememberedValue(infiniteTransition);
        } else {
            infiniteTransition = rememberedValue;
        }
        obj9 = infiniteTransition;
        ComposerKt.sourceInformationMarkerEnd($composer);
        (InfiniteTransition)obj9.run$animation_core_release($composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return obj9;
    }
}
