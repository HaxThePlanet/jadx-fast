package androidx.compose.animation;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"DecelerationRate", "", "GravityEarth", "InchesPerMeter", "computeDeceleration", "friction", "density", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FlingCalculatorKt {

    private static final float DecelerationRate = 0f;
    private static final float GravityEarth = 9.80665f;
    private static final float InchesPerMeter = 39.37f;
    static {
        FlingCalculatorKt.DecelerationRate = (float)i;
    }

    public static final float access$computeDeceleration(float friction, float density) {
        return FlingCalculatorKt.computeDeceleration(friction, density);
    }

    public static final float access$getDecelerationRate$p() {
        return FlingCalculatorKt.DecelerationRate;
    }

    private static final float computeDeceleration(float friction, float density) {
        return i3 *= friction;
    }
}
