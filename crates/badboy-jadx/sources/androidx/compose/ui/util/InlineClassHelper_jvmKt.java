package androidx.compose.ui.util;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\u0008\u001a\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0006H\u0086\u0008\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0001H\u0086\u0008\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0086\u0008¨\u0006\u0008", d2 = {"doubleFromBits", "", "bits", "", "floatFromBits", "", "", "fastRoundToInt", "ui-util_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InlineClassHelper_jvmKt {
    public static final double doubleFromBits(long bits) {
        final int i = 0;
        return Double.longBitsToDouble(bits);
    }

    public static final int fastRoundToInt(double $this$fastRoundToInt) {
        final int i = 0;
        return (int)round;
    }

    public static final int fastRoundToInt(float $this$fastRoundToInt) {
        final int i = 0;
        return Math.round($this$fastRoundToInt);
    }

    public static final float floatFromBits(int bits) {
        final int i = 0;
        return Float.intBitsToFloat(bits);
    }
}
