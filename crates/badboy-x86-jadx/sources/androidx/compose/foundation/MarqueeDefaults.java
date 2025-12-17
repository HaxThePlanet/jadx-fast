package androidx.compose.foundation;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001a\u0010\u0008\u001a\u00020\u0004X\u0086D¢\u0006\u000e\n\u0000\u0012\u0004\u0008\t\u0010\u0002\u001a\u0004\u0008\n\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/MarqueeDefaults;", "", "()V", "Iterations", "", "getIterations$annotations", "getIterations", "()I", "RepeatDelayMillis", "getRepeatDelayMillis$annotations", "getRepeatDelayMillis", "Spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "getSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "Velocity", "Landroidx/compose/ui/unit/Dp;", "getVelocity-D9Ej5fM", "()F", "F", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MarqueeDefaults {

    public static final int $stable;
    public static final androidx.compose.foundation.MarqueeDefaults INSTANCE;
    private static final int Iterations = 3;
    private static final int RepeatDelayMillis = 1200;
    private static final androidx.compose.foundation.MarqueeSpacing Spacing;
    private static final float Velocity;
    static {
        MarqueeDefaults marqueeDefaults = new MarqueeDefaults();
        MarqueeDefaults.INSTANCE = marqueeDefaults;
        int i = 3;
        int i2 = 1200;
        MarqueeDefaults.Spacing = MarqueeSpacing.Companion.fractionOfContainer(1051372203);
        int i5 = 0;
        MarqueeDefaults.Velocity = Dp.constructor-impl((float)i3);
    }

    public static void getIterations$annotations() {
    }

    public static void getRepeatDelayMillis$annotations() {
    }

    public final int getIterations() {
        return MarqueeDefaults.Iterations;
    }

    public final int getRepeatDelayMillis() {
        return MarqueeDefaults.RepeatDelayMillis;
    }

    public final androidx.compose.foundation.MarqueeSpacing getSpacing() {
        return MarqueeDefaults.Spacing;
    }

    public final float getVelocity-D9Ej5fM() {
        return MarqueeDefaults.Velocity;
    }
}
