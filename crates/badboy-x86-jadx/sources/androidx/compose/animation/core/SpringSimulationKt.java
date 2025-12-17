package androidx.compose.animation.core;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\n\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"UNSET", "", "getUNSET", "()F", "VelocityThresholdMultiplier", "", "Motion", "Landroidx/compose/animation/core/Motion;", "value", "velocity", "(FF)J", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpringSimulationKt {

    private static final float UNSET = 0f;
    private static final double VelocityThresholdMultiplier = 62.5d;
    static {
        SpringSimulationKt.UNSET = 2139095039;
    }

    public static final long Motion(float value, float velocity) {
        int i = 0;
        long l = (long)floatToRawIntBits;
        return Motion.constructor-impl(i3 | i4);
    }

    public static final float getUNSET() {
        return SpringSimulationKt.UNSET;
    }
}
