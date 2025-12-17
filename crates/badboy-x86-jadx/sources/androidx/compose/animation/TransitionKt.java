package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition.Segment;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a:\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\t\u001aD\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00072\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\u001a\u0082\u0001\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\u000f2*\u0008\n\u0010\u0010\u001a$\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000e0\u0012\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00020\u00130\u0011¢\u0006\u0002\u0008\u0014¢\u0006\u0002\u0008\u00152\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000e¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u00020\u0011¢\u0006\u0002\u0008\u0014H\u0087\u0008¢\u0006\u0002\u0010\u001a\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"animateColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/InfiniteTransition;", "initialValue", "targetValue", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "animateColor-RIQooxk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "label", "", "animateColor-DTcfvLk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "S", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransitionKt {
    public static final <S> State<Color> animateColor(Transition<S> $this$animateColor, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Color>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Color> targetValueByState, Composer $composer, int $changed, int i7) {
        int iNSTANCE;
        int str;
        String str2;
        Object empty;
        androidx.compose.animation.TransitionKt.animateColor.1 anon;
        Object invoke;
        final Object obj = targetValueByState;
        final Composer composer2 = $composer;
        final int i26 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
        if (i7 & 1 != 0) {
            anon = iNSTANCE;
        } else {
            anon = transitionSpec;
        }
        str2 = i7 & 2 != 0 ? str : label;
        Integer valueOf = Integer.valueOf(i6 &= 112);
        final androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace-impl = Color.getColorSpace-impl((Color)obj.invoke($this$animateColor.getTargetState(), composer2, valueOf).unbox-impl());
        ComposerKt.sourceInformationMarkerStart(composer2, 1918408083, "CC(remember):Transition.kt#9igjgp");
        Composer composer = $composer;
        int i16 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i23 = 0;
        if (!composer2.changed(colorSpace-impl)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                composer.updateRememberedValue((TwoWayConverter)ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpace-impl));
            } else {
                invoke = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        int i17 = 57344;
        int i27 = i5 | i14;
        Transition transition = $this$animateColor;
        final int i28 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return TransitionKt.createTransitionAnimation(transition, obj.invoke(transition.getCurrentState(), composer2, Integer.valueOf(i21 &= 112)), obj.invoke(transition.getTargetState(), composer2, Integer.valueOf(i24 &= 112)), (FiniteAnimationSpec)anon.invoke(transition.getSegment(), composer2, Integer.valueOf(i29 &= 112)), (TwoWayConverter)invoke, str2, composer2, i19 |= i33);
    }

    public static final State<Color> animateColor-DTcfvLk(InfiniteTransition $this$animateColor_u2dDTcfvLk, long initialValue, long targetValue, InfiniteRepeatableSpec<Color> animationSpec, String label, Composer $composer, int $changed, int i8) {
        int str2;
        boolean traceInProgress;
        String str;
        String str3;
        Object empty;
        Object invoke;
        androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace-impl;
        final Composer composer2 = i8;
        final int i24 = obj19;
        int i = 1901963533;
        ComposerKt.sourceInformationMarkerStart(composer2, i, "C(animateColor)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color)102@4596L72,105@4680L72:Transition.kt#xbi5r1");
        str3 = obj20 & 8 != 0 ? str2 : $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, i24, -1, "androidx.compose.animation.animateColor (Transition.kt:101)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 1918449973, "CC(remember):Transition.kt#9igjgp");
        int i3 = 0;
        Composer composer = i8;
        int i10 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i11 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty = 0;
            composer.updateRememberedValue((TwoWayConverter)ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.getColorSpace-impl(animationSpec)));
        } else {
            invoke = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(i8);
        return InfiniteTransitionKt.animateValue($this$animateColor_u2dDTcfvLk, Color.box-impl(initialValue), Color.box-impl(animationSpec), (TwoWayConverter)invoke, $composer, str3, composer2, i9 | i19, 0);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateColor APIs now have a new label parameter added.")
    public static final State animateColor-RIQooxk(InfiniteTransition $this$animateColor_u2dRIQooxk, long initialValue, long targetValue, InfiniteRepeatableSpec animationSpec, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        final int i = obj20;
        int i2 = 1400583834;
        final Composer composer = obj19;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(animateColor)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color)117@5040L143:Transition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i, -1, "androidx.compose.animation.animateColor (Transition.kt:117)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(obj19);
        return TransitionKt.animateColor-DTcfvLk($this$animateColor_u2dRIQooxk, initialValue, obj5, animationSpec, obj7, $changed, "ColorAnimation", composer);
    }
}
