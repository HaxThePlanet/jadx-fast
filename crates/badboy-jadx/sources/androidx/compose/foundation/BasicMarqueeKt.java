package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005\u001aH\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u001a&\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00142\u0006\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\nH\u0002\u001aR\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001c", d2 = {"MarqueeSpacing", "Landroidx/compose/foundation/MarqueeSpacing;", "spacing", "Landroidx/compose/ui/unit/Dp;", "MarqueeSpacing-0680j_4", "(F)Landroidx/compose/foundation/MarqueeSpacing;", "createMarqueeAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "iterations", "", "targetValue", "initialDelayMillis", "delayMillis", "velocity", "density", "Landroidx/compose/ui/unit/Density;", "createMarqueeAnimationSpec-Z4HSEVQ", "(IFIIFLandroidx/compose/ui/unit/Density;)Landroidx/compose/animation/core/AnimationSpec;", "velocityBasedTween", "Landroidx/compose/animation/core/TweenSpec;", "basicMarquee", "Landroidx/compose/ui/Modifier;", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "repeatDelayMillis", "basicMarquee-1Mj1MLw", "(Landroidx/compose/ui/Modifier;IIIILandroidx/compose/foundation/MarqueeSpacing;F)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BasicMarqueeKt {
    public static int $r8$lambda$KcvXG22a4rRt6CKr32crVmFegXs(float f, Density density2, int i3, int i4) {
        return BasicMarqueeKt.MarqueeSpacing_0680j_4$lambda$1(f, density2, i3, i4);
    }

    public static final androidx.compose.foundation.MarqueeSpacing MarqueeSpacing-0680j_4(float spacing) {
        BasicMarqueeKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new BasicMarqueeKt$$ExternalSyntheticLambda0(spacing);
        return externalSyntheticLambda0;
    }

    private static final int MarqueeSpacing_0680j_4$lambda$1(float $spacing, Density $this$MarqueeSpacing, int i3, int i4) {
        return $this$MarqueeSpacing.roundToPx-0680j_4($spacing);
    }

    public static final AnimationSpec access$createMarqueeAnimationSpec-Z4HSEVQ(int iterations, float targetValue, int initialDelayMillis, int delayMillis, float velocity, Density density) {
        return BasicMarqueeKt.createMarqueeAnimationSpec-Z4HSEVQ(iterations, targetValue, initialDelayMillis, delayMillis, velocity, density);
    }

    public static final Modifier basicMarquee-1Mj1MLw(Modifier $this$basicMarquee_u2d1Mj1MLw, int iterations, int animationMode, int repeatDelayMillis, int initialDelayMillis, androidx.compose.foundation.MarqueeSpacing spacing, float velocity) {
        MarqueeModifierElement marqueeModifierElement = new MarqueeModifierElement(iterations, animationMode, repeatDelayMillis, initialDelayMillis, spacing, velocity, 0);
        return $this$basicMarquee_u2d1Mj1MLw.then((Modifier)marqueeModifierElement);
    }

    public static Modifier basicMarquee-1Mj1MLw$default(Modifier modifier, int i2, int i3, int i4, int i5, androidx.compose.foundation.MarqueeSpacing marqueeSpacing6, float f7, int i8, Object object9) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        androidx.compose.foundation.MarqueeSpacing obj5;
        float obj6;
        float obj8;
        if (i8 & 1 != 0) {
            obj1 = MarqueeDefaults.INSTANCE.getIterations();
        }
        if (i8 & 2 != 0) {
            obj2 = MarqueeAnimationMode.Companion.getImmediately-ZbEOnfQ();
        }
        if (i8 & 4 != 0) {
            obj3 = MarqueeDefaults.INSTANCE.getRepeatDelayMillis();
        }
        if (i8 & 8 != 0) {
            obj4 = MarqueeAnimationMode.equals-impl0(obj2, MarqueeAnimationMode.Companion.getImmediately-ZbEOnfQ()) ? obj3 : 0;
        }
        if (i8 & 16 != 0) {
            obj5 = MarqueeDefaults.INSTANCE.getSpacing();
        }
        if (i8 &= 32 != 0) {
            obj8 = obj6;
        } else {
            obj8 = f7;
        }
        return BasicMarqueeKt.basicMarquee-1Mj1MLw(modifier, obj1, obj2, obj3, obj4, obj5, obj8);
    }

    private static final AnimationSpec<Float> createMarqueeAnimationSpec-Z4HSEVQ(int iterations, float targetValue, int initialDelayMillis, int delayMillis, float velocity, Density density) {
        Object infiniteRepeatable-9IiC70o$default;
        TweenSpec tweenSpec;
        int i3;
        long constructor-impl$default;
        long l;
        int i2;
        int i;
        int i4;
        final int i5 = delayMillis;
        int i6 = 0;
        TweenSpec velocityBasedTween = BasicMarqueeKt.velocityBasedTween(Math.abs(density.toPx-0680j_4(velocity)), targetValue, i5);
        constructor-impl$default = StartOffset.constructor-impl$default(i7 += initialDelayMillis, 0, 2, 0);
        int i11 = iterations;
        if (i11 == Integer.MAX_VALUE) {
            infiniteRepeatable-9IiC70o$default = AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)velocityBasedTween, 0, constructor-impl$default, obj12, 2);
        } else {
            l = constructor-impl$default;
            infiniteRepeatable-9IiC70o$default = AnimationSpecKt.repeatable-91I0pcU$default(i11, (DurationBasedAnimationSpec)velocityBasedTween, 0, l, obj13, 4);
            constructor-impl$default = l;
        }
        return infiniteRepeatable-9IiC70o$default;
    }

    private static final TweenSpec<Float> velocityBasedTween(float velocity, float targetValue, int delayMillis) {
        return AnimationSpecKt.tween((int)f, delayMillis, EasingKt.getLinearEasing());
    }
}
