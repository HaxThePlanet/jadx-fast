package androidx.compose.ui.util;

import kotlin.Metadata;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a)\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\u0008\u001a)\u0010\u0008\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\u0008\u001a\u001e\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u000c\u001a\u00020\u0001\u001a\u001e\u0010\t\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\u0001\u001a\u001e\u0010\t\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000c\u001a\u00020\u0001\u001a\u0015\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0086\u0008\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0086\u0008\u001a\u0015\u0010\u0012\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0086\u0008\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0086\u0008\u001a\u001d\u0010\u0014\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0086\u0008\u001a\u001d\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0086\u0008¨\u0006\u0015", d2 = {"fastCbrt", "", "x", "fastMaxOf", "a", "b", "c", "d", "fastMinOf", "lerp", "start", "stop", "fraction", "", "", "fastCoerceAtLeast", "", "minimumValue", "fastCoerceAtMost", "maximumValue", "fastCoerceIn", "ui-util_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MathHelpersKt {
    public static final float fastCbrt(float x) {
        int i7 = 0;
        float bits$iv = Float.intBitsToFloat(i4 += i6);
        final int i16 = 1051372203;
        bits$iv -= i11;
        return estimate -= i15;
    }

    public static final double fastCoerceAtLeast(double $this$fastCoerceAtLeast, double minimumValue) {
        double d;
        final int i = 0;
        d = Double.compare($this$fastCoerceAtLeast, obj5) < 0 ? obj5 : $this$fastCoerceAtLeast;
        return d;
    }

    public static final float fastCoerceAtLeast(float $this$fastCoerceAtLeast, float minimumValue) {
        float f;
        final int i = 0;
        f = Float.compare($this$fastCoerceAtLeast, minimumValue) < 0 ? minimumValue : $this$fastCoerceAtLeast;
        return f;
    }

    public static final double fastCoerceAtMost(double $this$fastCoerceAtMost, double maximumValue) {
        double d;
        final int i = 0;
        d = Double.compare($this$fastCoerceAtMost, obj5) > 0 ? obj5 : $this$fastCoerceAtMost;
        return d;
    }

    public static final float fastCoerceAtMost(float $this$fastCoerceAtMost, float maximumValue) {
        float f;
        final int i = 0;
        f = Float.compare($this$fastCoerceAtMost, maximumValue) > 0 ? maximumValue : $this$fastCoerceAtMost;
        return f;
    }

    public static final double fastCoerceIn(double $this$fastCoerceIn, double minimumValue, double maximumValue) {
        double $this$fastCoerceAtLeast$iv;
        final int i = 0;
        int i2 = 0;
        if (Double.compare($this$fastCoerceAtLeast$iv, maximumValue) < 0) {
            $this$fastCoerceAtLeast$iv = maximumValue;
        }
        int i3 = 0;
        if (Double.compare($this$fastCoerceAtLeast$iv, obj9) > 0) {
            $this$fastCoerceAtLeast$iv = obj9;
        }
        return $this$fastCoerceAtLeast$iv;
    }

    public static final float fastCoerceIn(float $this$fastCoerceIn, float minimumValue, float maximumValue) {
        float $this$fastCoerceAtLeast$iv;
        final int i = 0;
        int i2 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv, minimumValue) < 0) {
            $this$fastCoerceAtLeast$iv = minimumValue;
        }
        int i3 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv, maximumValue) > 0) {
            $this$fastCoerceAtLeast$iv = maximumValue;
        }
        return $this$fastCoerceAtLeast$iv;
    }

    public static final float fastMaxOf(float a, float b, float c, float d) {
        final int i = 0;
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }

    public static final float fastMinOf(float a, float b, float c, float d) {
        final int i = 0;
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }

    public static final float lerp(float start, float stop, float fraction) {
        return i3 += i5;
    }

    public static final int lerp(int start, int stop, float fraction) {
        int i3 = 0;
        return $this$fastRoundToInt$iv += start;
    }

    public static final long lerp(long start, long stop, float fraction) {
        return roundToLong += start;
    }
}
