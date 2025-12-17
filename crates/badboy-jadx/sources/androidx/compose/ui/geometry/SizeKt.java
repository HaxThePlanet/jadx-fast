package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0006\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u001d\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0013\u001a*\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a%\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001cH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00020\u0002*\u00020 2\u0006\u0010!\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#\u001a\u001f\u0010\u001f\u001a\u00020\u0002*\u00020\u00112\u0006\u0010!\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008\"\u0010$\u001a\u001f\u0010\u001f\u001a\u00020\u0002*\u00020%2\u0006\u0010!\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008\"\u0010&\u001a\u0016\u0010'\u001a\u00020(*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0008*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\u0004\u001a\u0004\u0008\n\u0010\u000b\"\u001f\u0010\u000c\u001a\u00020\u0008*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\r\u0010\u0004\u001a\u0004\u0008\u000e\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006+", d2 = {"center", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Size;", "getCenter-uvyYCjk$annotations", "(J)V", "getCenter-uvyYCjk", "(J)J", "isSpecified", "", "isSpecified-uvyYCjk$annotations", "isSpecified-uvyYCjk", "(J)Z", "isUnspecified", "isUnspecified-uvyYCjk$annotations", "isUnspecified-uvyYCjk", "Size", "width", "", "height", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-VgWVRYQ", "(JJF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-TmRCtEA", "(JLkotlin/jvm/functions/Function0;)J", "times", "", "size", "times-d16Qtg0", "(DJ)J", "(FJ)J", "", "(IJ)J", "toRect", "Landroidx/compose/ui/geometry/Rect;", "toRect-uvyYCjk", "(J)Landroidx/compose/ui/geometry/Rect;", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SizeKt {
    public static final long Size(float width, float height) {
        int i = 0;
        long l = (long)floatToRawIntBits;
        return Size.constructor-impl(i3 | i4);
    }

    public static final long getCenter-uvyYCjk(long $this$center) {
        int cmp;
        if (Long.compare($this$center, l) == 0) {
            InlineClassHelperKt.throwIllegalStateException("Size is unspecified");
        }
        final int i = 0;
        int i6 = 0;
        int value$iv = 1073741824;
        int i7 = 0;
        final int i11 = 0;
        return OffsetKt.Offset(bits$iv$iv /= value$iv, bits$iv$iv2 /= value$iv);
    }

    public static void getCenter-uvyYCjk$annotations(long l) {
    }

    public static final boolean isSpecified-uvyYCjk(long $this$isSpecified) {
        int i;
        final int i2 = 0;
        i = Long.compare($this$isSpecified, l) != 0 ? 1 : 0;
        return i;
    }

    public static void isSpecified-uvyYCjk$annotations(long l) {
    }

    public static final boolean isUnspecified-uvyYCjk(long $this$isUnspecified) {
        int i;
        final int i2 = 0;
        i = Long.compare($this$isUnspecified, l) == 0 ? 1 : 0;
        return i;
    }

    public static void isUnspecified-uvyYCjk$annotations(long l) {
    }

    public static final long lerp-VgWVRYQ(long start, long stop, float fraction) {
        int cmp;
        cmp = 9205357640488583168L;
        if (Long.compare(start, cmp) != 0) {
            if (Long.compare(fraction, cmp) == 0) {
                InlineClassHelperKt.throwIllegalStateException("Offset is unspecified");
            }
        } else {
        }
        int i = 0;
        int i4 = 32;
        int i10 = 0;
        int i2 = 0;
        final int i14 = 0;
        int i8 = 0;
        long l3 = 4294967295L;
        int i17 = 0;
        int i9 = 0;
        int i20 = 0;
        float lerp2 = MathHelpersKt.lerp(Float.intBitsToFloat((int)i15), Float.intBitsToFloat((int)i18), obj15);
        int i3 = 0;
        return Size.constructor-impl(i5 | i13);
    }

    public static final long takeOrElse-TmRCtEA(long $this$takeOrElse_u2dTmRCtEA, Function0<androidx.compose.ui.geometry.Size> block) {
        long unbox-impl;
        int i;
        final int i2 = 0;
        final int i3 = 0;
        i = Long.compare(l, l2) != 0 ? 1 : 0;
        if (i != 0) {
            unbox-impl = $this$takeOrElse_u2dTmRCtEA;
        } else {
            unbox-impl = (Size)obj8.invoke().unbox-impl();
        }
        return unbox-impl;
    }

    public static final long times-d16Qtg0(double $this$times_u2dd16Qtg0, long size) {
        final int i = 0;
        return Size.times-7Ah8Wj8(obj5, obj6);
    }

    public static final long times-d16Qtg0(float $this$times_u2dd16Qtg0, long size) {
        final int i = 0;
        return Size.times-7Ah8Wj8(size, obj5);
    }

    public static final long times-d16Qtg0(int $this$times_u2dd16Qtg0, long size) {
        final int i = 0;
        return Size.times-7Ah8Wj8(size, obj5);
    }

    public static final androidx.compose.ui.geometry.Rect toRect-uvyYCjk(long $this$toRect_u2duvyYCjk) {
        return RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), obj1);
    }
}
