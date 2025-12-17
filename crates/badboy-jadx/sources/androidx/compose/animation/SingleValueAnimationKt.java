package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u001a$\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0007\u0010\u0008\u001aH\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u000e\u0008\u0002\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00020\r2\u0016\u0008\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u001aR\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u000e\u0008\u0002\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00020\r2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0016\u0008\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0017", d2 = {"colorDefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/graphics/Color;", "Animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector4D;", "initialValue", "Animatable-8_81llA", "(J)Landroidx/compose/animation/core/Animatable;", "animateColorAsState", "Landroidx/compose/runtime/State;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "finishedListener", "Lkotlin/Function1;", "", "animateColorAsState-KTwxG1Y", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "label", "", "animateColorAsState-euL9pac", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SingleValueAnimationKt {

    private static final SpringSpec<Color> colorDefaultSpring;
    static {
        int i = 0;
        final int i3 = 0;
        SingleValueAnimationKt.colorDefaultSpring = AnimationSpecKt.spring$default(i3, i3, i, 7, i);
    }

    public static final Animatable<Color, AnimationVector4D> Animatable-8_81llA(long initialValue) {
        Animatable animatable = new Animatable(Color.box-impl(initialValue), (TwoWayConverter)ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.getColorSpace-impl(initialValue)), 0, 0, 12, 0);
        return animatable;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final State animateColorAsState-KTwxG1Y(long targetValue, AnimationSpec animationSpec, Function1 finishedListener, Composer $composer, int $changed, int i6) {
        int colorDefaultSpring;
        SpringSpec springSpec;
        int i;
        SpringSpec obj11;
        int obj12;
        final int i2 = -1942442407;
        ComposerKt.sourceInformationMarkerStart($changed, i2, "C(animateColorAsState)P(2:c#ui.graphics.Color)80@3400L98:SingleValueAnimation.kt#xbi5r1");
        if (obj15 & 2 != 0) {
            springSpec = obj11;
        } else {
            springSpec = finishedListener;
        }
        i = obj15 & 4 != 0 ? obj12 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i6, -1, "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:79)");
        }
        final Composer composer = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return SingleValueAnimationKt.animateColorAsState-euL9pac(targetValue, obj2, springSpec, 0, i, composer, obj11 | obj12);
    }

    public static final State<Color> animateColorAsState-euL9pac(long targetValue, AnimationSpec<Color> animationSpec, String label, Function1<? super Color, Unit> finishedListener, Composer $composer, int $changed, int i7) {
        SpringSpec colorDefaultSpring;
        SpringSpec springSpec;
        String str;
        int i;
        Object empty;
        Object invoke;
        androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace-impl;
        SpringSpec obj14;
        final Composer composer2 = $changed;
        final int i18 = i7;
        int i2 = -451899108;
        ComposerKt.sourceInformationMarkerStart(composer2, i2, "C(animateColorAsState)P(3:c#ui.graphics.Color!1,2)62@2847L96,65@2955L124:SingleValueAnimation.kt#xbi5r1");
        if (obj19 & 2 != 0) {
            springSpec = obj14;
        } else {
            springSpec = label;
        }
        str = obj19 & 4 != 0 ? obj14 : finishedListener;
        i = obj19 & 8 != 0 ? obj14 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i18, -1, "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:61)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -1018619694, "CC(remember):SingleValueAnimation.kt#9igjgp");
        Composer composer = $changed;
        int i4 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i13 = 0;
        if (!composer2.changed(Color.getColorSpace-impl(targetValue))) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                composer.updateRememberedValue((TwoWayConverter)ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.getColorSpace-impl(targetValue)));
            } else {
                invoke = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return AnimateAsStateKt.animateValueAsState(Color.box-impl(targetValue), (TwoWayConverter)invoke, springSpec, 0, str, i, composer2, obj14 | i11, 8);
    }
}
