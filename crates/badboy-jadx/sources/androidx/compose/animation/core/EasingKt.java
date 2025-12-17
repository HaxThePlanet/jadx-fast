package androidx.compose.animation.core;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0003\"\u0011\u0010\u0008\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0003¨\u0006\n", d2 = {"FastOutLinearInEasing", "Landroidx/compose/animation/core/Easing;", "getFastOutLinearInEasing", "()Landroidx/compose/animation/core/Easing;", "FastOutSlowInEasing", "getFastOutSlowInEasing", "LinearEasing", "getLinearEasing", "LinearOutSlowInEasing", "getLinearOutSlowInEasing", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EasingKt {

    private static final androidx.compose.animation.core.Easing FastOutLinearInEasing;
    private static final androidx.compose.animation.core.Easing FastOutSlowInEasing;
    private static final androidx.compose.animation.core.Easing LinearEasing;
    private static final androidx.compose.animation.core.Easing LinearOutSlowInEasing;
    public static float $r8$lambda$mMxEzlbH87hNiWQOEalATwCIuTQ(float f) {
        return EasingKt.LinearEasing$lambda$0(f);
    }

    static {
        final int i = 1053609165;
        final int i2 = 0;
        final int i3 = 1045220557;
        final int i4 = 1065353216;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(i, i2, i3, i4);
        EasingKt.FastOutSlowInEasing = (Easing)cubicBezierEasing;
        CubicBezierEasing cubicBezierEasing2 = new CubicBezierEasing(i2, i2, i3, i4);
        EasingKt.LinearOutSlowInEasing = (Easing)cubicBezierEasing2;
        CubicBezierEasing cubicBezierEasing3 = new CubicBezierEasing(i, i2, i4, i4);
        EasingKt.FastOutLinearInEasing = (Easing)cubicBezierEasing3;
        EasingKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new EasingKt$$ExternalSyntheticLambda0();
        EasingKt.LinearEasing = externalSyntheticLambda0;
    }

    private static final float LinearEasing$lambda$0(float fraction) {
        return fraction;
    }

    public static final androidx.compose.animation.core.Easing getFastOutLinearInEasing() {
        return EasingKt.FastOutLinearInEasing;
    }

    public static final androidx.compose.animation.core.Easing getFastOutSlowInEasing() {
        return EasingKt.FastOutSlowInEasing;
    }

    public static final androidx.compose.animation.core.Easing getLinearEasing() {
        return EasingKt.LinearEasing;
    }

    public static final androidx.compose.animation.core.Easing getLinearOutSlowInEasing() {
        return EasingKt.LinearOutSlowInEasing;
    }
}
