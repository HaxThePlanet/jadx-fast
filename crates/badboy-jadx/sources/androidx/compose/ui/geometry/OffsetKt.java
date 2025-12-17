package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u001d\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0011\u001a*\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017\u001a%\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001aH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001c\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\u0004\u001a\u0004\u0008\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u000b\u0010\u0004\u001a\u0004\u0008\u000c\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d", d2 = {"isFinite", "", "Landroidx/compose/ui/geometry/Offset;", "isFinite-k-4lQ0M$annotations", "(J)V", "isFinite-k-4lQ0M", "(J)Z", "isSpecified", "isSpecified-k-4lQ0M$annotations", "isSpecified-k-4lQ0M", "isUnspecified", "isUnspecified-k-4lQ0M$annotations", "isUnspecified-k-4lQ0M", "Offset", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-Wko1d7g", "(JJF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-3MmeM6k", "(JLkotlin/jvm/functions/Function0;)J", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OffsetKt {
    public static final long Offset(float x, float y) {
        int i = 0;
        long l = (long)floatToRawIntBits;
        return Offset.constructor-impl(i3 | i4);
    }

    public static final boolean isFinite-k-4lQ0M(long $this$isFinite) {
        int i;
        long l = 9187343241974906880L;
        l ^= i3;
        i = Long.compare(i6, i8) == 0 ? 1 : 0;
        return i;
    }

    public static void isFinite-k-4lQ0M$annotations(long l) {
    }

    public static final boolean isSpecified-k-4lQ0M(long $this$isSpecified) {
        int i;
        i = Long.compare(i2, l2) != 0 ? 1 : 0;
        return i;
    }

    public static void isSpecified-k-4lQ0M$annotations(long l) {
    }

    public static final boolean isUnspecified-k-4lQ0M(long $this$isUnspecified) {
        int i;
        i = Long.compare(i2, l2) == 0 ? 1 : 0;
        return i;
    }

    public static void isUnspecified-k-4lQ0M$annotations(long l) {
    }

    public static final long lerp-Wko1d7g(long start, long stop, float fraction) {
        int i3 = 0;
        int i6 = 32;
        int i12 = 0;
        int i4 = 0;
        final int i16 = 0;
        int i10 = 0;
        long l = 4294967295L;
        int i19 = 0;
        int i11 = 0;
        int i22 = 0;
        float lerp2 = MathHelpersKt.lerp(Float.intBitsToFloat((int)i17), Float.intBitsToFloat((int)i20), obj15);
        int i5 = 0;
        return Offset.constructor-impl(i7 | i15);
    }

    public static final long takeOrElse-3MmeM6k(long $this$takeOrElse_u2d3MmeM6k, Function0<androidx.compose.ui.geometry.Offset> block) {
        long unbox-impl;
        final int i = 0;
        if (OffsetKt.isSpecified-k-4lQ0M($this$takeOrElse_u2d3MmeM6k)) {
            unbox-impl = $this$takeOrElse_u2d3MmeM6k;
        } else {
            unbox-impl = (Offset)obj5.invoke().unbox-impl();
        }
        return unbox-impl;
    }
}
