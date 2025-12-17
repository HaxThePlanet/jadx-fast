package androidx.compose.foundation;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008ç\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0008À\u0006\u0001", d2 = {"Landroidx/compose/foundation/MarqueeSpacing;", "", "calculateSpacing", "", "Landroidx/compose/ui/unit/Density;", "contentWidth", "containerWidth", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MarqueeSpacing {

    public static final androidx.compose.foundation.MarqueeSpacing.Companion Companion;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/MarqueeSpacing$Companion;", "", "()V", "fractionOfContainer", "Landroidx/compose/foundation/MarqueeSpacing;", "fraction", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.foundation.MarqueeSpacing.Companion $$INSTANCE;
        public static int $r8$lambda$SBZMTxTgcJVX_wTtT7ap1LCg9xI(float f, Density density2, int i3, int i4) {
            return MarqueeSpacing.Companion.fractionOfContainer$lambda$0(f, density2, i3, i4);
        }

        static {
            MarqueeSpacing.Companion companion = new MarqueeSpacing.Companion();
            MarqueeSpacing.Companion.$$INSTANCE = companion;
        }

        private static final int fractionOfContainer$lambda$0(float $fraction, Density $this$MarqueeSpacing, int i3, int width) {
            return MathKt.roundToInt(obj2 *= $fraction);
        }

        public final androidx.compose.foundation.MarqueeSpacing fractionOfContainer(float fraction) {
            MarqueeSpacing.Companion$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new MarqueeSpacing.Companion$$ExternalSyntheticLambda0(fraction);
            return externalSyntheticLambda0;
        }
    }
    static {
        MarqueeSpacing.Companion = MarqueeSpacing.Companion.$$INSTANCE;
    }

    public abstract int calculateSpacing(Density density, int i2, int i3);
}
