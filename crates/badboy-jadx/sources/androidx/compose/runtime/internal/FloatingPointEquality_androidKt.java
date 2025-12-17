package androidx.compose.runtime.internal;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0080\u0008\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0080\u0008\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0000\u0010\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0000\u0010\u0005¨\u0006\u0008", d2 = {"isNan", "", "", "(D)Z", "", "(F)Z", "equalsWithNanFix", "other", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatingPointEquality_androidKt {
    public static final boolean equalsWithNanFix(double $this$equalsWithNanFix, double other) {
        int i;
        final int i2 = 0;
        i = Double.compare($this$equalsWithNanFix, obj4) == 0 ? 1 : 0;
        return i;
    }

    public static final boolean equalsWithNanFix(float $this$equalsWithNanFix, float other) {
        int i;
        final int i2 = 0;
        i = Float.compare($this$equalsWithNanFix, other) == 0 ? 1 : 0;
        return i;
    }

    public static final boolean isNan(double $this$isNan) {
        int i;
        i = Long.compare(i2, l2) > 0 ? 1 : 0;
        return i;
    }

    public static final boolean isNan(float $this$isNan) {
        int i;
        i = floatToRawIntBits &= i3 > 2139095040 ? 1 : 0;
        return i;
    }
}
