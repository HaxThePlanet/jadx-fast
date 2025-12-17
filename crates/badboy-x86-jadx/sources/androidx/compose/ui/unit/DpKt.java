package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008:\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u001a\"\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00082\u0006\u00107\u001a\u00020\u0008H\u0007ø\u0001\u0000¢\u0006\u0004\u00088\u00109\u001a\"\u0010:\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00082\u0006\u0010\u0014\u001a\u00020\u0008H\u0007ø\u0001\u0000¢\u0006\u0004\u0008;\u00109\u001a*\u0010<\u001a\u00020\u00082\u0006\u0010=\u001a\u00020\u00082\u0006\u0010>\u001a\u00020\u00082\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008@\u0010A\u001a*\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008B\u0010C\u001a*\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008D\u0010C\u001a#\u0010E\u001a\u00020\u00082\u0006\u0010F\u001a\u00020\u00082\u0006\u0010G\u001a\u00020\u0008H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008H\u0010I\u001a#\u0010J\u001a\u00020\u00082\u0006\u0010F\u001a\u00020\u00082\u0006\u0010G\u001a\u00020\u0008H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008K\u0010I\u001a\u001f\u0010L\u001a\u00020\u0008*\u00020\u00082\u0006\u0010M\u001a\u00020\u0008H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008N\u0010I\u001a\u001f\u0010O\u001a\u00020\u0008*\u00020\u00082\u0006\u0010P\u001a\u00020\u0008H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008Q\u0010I\u001a'\u0010R\u001a\u00020\u0008*\u00020\u00082\u0006\u0010M\u001a\u00020\u00082\u0006\u0010P\u001a\u00020\u0008H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008S\u0010A\u001a%\u0010T\u001a\u00020\u0008*\u00020\u00082\u000c\u0010U\u001a\u0008\u0012\u0004\u0012\u00020\u00080VH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008W\u0010X\u001a%\u0010T\u001a\u00020\u0001*\u00020\u00012\u000c\u0010U\u001a\u0008\u0012\u0004\u0012\u00020\u00010VH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008Y\u0010Z\u001a%\u0010T\u001a\u00020\u0002*\u00020\u00022\u000c\u0010U\u001a\u0008\u0012\u0004\u0012\u00020\u00020VH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008[\u0010Z\u001a\u001f\u0010\\\u001a\u00020\u0008*\u00020\t2\u0006\u0010]\u001a\u00020\u0008H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008^\u0010_\u001a\u001f\u0010\\\u001a\u00020\u0008*\u00020\u000e2\u0006\u0010]\u001a\u00020\u0008H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008^\u0010I\u001a\u001f\u0010\\\u001a\u00020\u0002*\u00020\u000e2\u0006\u0010.\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008`\u0010a\u001a\u001f\u0010\\\u001a\u00020\u0008*\u00020\u00112\u0006\u0010]\u001a\u00020\u0008H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008^\u0010b\u001a\u001f\u0010\\\u001a\u00020\u0002*\u00020\u00112\u0006\u0010.\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\u0008`\u0010c\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0008*\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u000c\u0010\r\"\u001f\u0010\u0007\u001a\u00020\u0008*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u000f\u001a\u0004\u0008\u000c\u0010\u0010\"\u001f\u0010\u0007\u001a\u00020\u0008*\u00020\u00118Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u0012\u001a\u0004\u0008\u000c\u0010\u0013\"\u001f\u0010\u0014\u001a\u00020\u0008*\u00020\u00158Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0018\u0010\u0019\"\u001f\u0010\u001a\u001a\u00020\u001b*\u00020\u00088Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001c\u0010\u000f\u001a\u0004\u0008\u001d\u0010\u001e\"\u001f\u0010\u001f\u001a\u00020\u001b*\u00020\u00088Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008 \u0010\u000f\u001a\u0004\u0008!\u0010\u001e\"\u001f\u0010\u001f\u001a\u00020\u001b*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\"\u0010\u0004\u001a\u0004\u0008#\u0010$\"\u001f\u0010\u001f\u001a\u00020\u001b*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008%\u0010\u0004\u001a\u0004\u0008&\u0010$\"\u001f\u0010'\u001a\u00020\u001b*\u00020\u00088Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008(\u0010\u000f\u001a\u0004\u0008)\u0010\u001e\"\u001f\u0010'\u001a\u00020\u001b*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008*\u0010\u0004\u001a\u0004\u0008+\u0010$\"\u001f\u0010'\u001a\u00020\u001b*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008,\u0010\u0004\u001a\u0004\u0008-\u0010$\"\u001f\u0010.\u001a\u00020\u0002*\u00020\u00158Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008/\u0010\u0017\u001a\u0004\u00080\u00101\"\u001f\u00102\u001a\u00020\u0008*\u00020\u00158Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u00083\u0010\u0017\u001a\u0004\u00084\u0010\u0019\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006d", d2 = {"center", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/ui/unit/DpSize;", "getCenter-EaSLcWc$annotations", "(J)V", "getCenter-EaSLcWc", "(J)J", "dp", "Landroidx/compose/ui/unit/Dp;", "", "getDp$annotations", "(D)V", "getDp", "(D)F", "", "(F)V", "(F)F", "", "(I)V", "(I)F", "height", "Landroidx/compose/ui/unit/DpRect;", "getHeight$annotations", "(Landroidx/compose/ui/unit/DpRect;)V", "getHeight", "(Landroidx/compose/ui/unit/DpRect;)F", "isFinite", "", "isFinite-0680j_4$annotations", "isFinite-0680j_4", "(F)Z", "isSpecified", "isSpecified-0680j_4$annotations", "isSpecified-0680j_4", "isSpecified-jo-Fl9I$annotations", "isSpecified-jo-Fl9I", "(J)Z", "isSpecified-EaSLcWc$annotations", "isSpecified-EaSLcWc", "isUnspecified", "isUnspecified-0680j_4$annotations", "isUnspecified-0680j_4", "isUnspecified-jo-Fl9I$annotations", "isUnspecified-jo-Fl9I", "isUnspecified-EaSLcWc$annotations", "isUnspecified-EaSLcWc", "size", "getSize$annotations", "getSize", "(Landroidx/compose/ui/unit/DpRect;)J", "width", "getWidth$annotations", "getWidth", "DpOffset", "x", "y", "DpOffset-YgX7TsA", "(FF)J", "DpSize", "DpSize-YgX7TsA", "lerp", "start", "stop", "fraction", "lerp-Md-fbLM", "(FFF)F", "lerp-xhh869w", "(JJF)J", "lerp-IDex15A", "max", "a", "b", "max-YgX7TsA", "(FF)F", "min", "min-YgX7TsA", "coerceAtLeast", "minimumValue", "coerceAtLeast-YgX7TsA", "coerceAtMost", "maximumValue", "coerceAtMost-YgX7TsA", "coerceIn", "coerceIn-2z7ARbQ", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-D5KLDUw", "(FLkotlin/jvm/functions/Function0;)F", "takeOrElse-gVKV90s", "(JLkotlin/jvm/functions/Function0;)J", "takeOrElse-itqla9I", "times", "other", "times-3ABfNKs", "(DF)F", "times-6HolHcs", "(FJ)J", "(IF)F", "(IJ)J", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DpKt {
    public static final long DpOffset-YgX7TsA(float x, float y) {
        final float f2 = x;
        final int i = 0;
        return DpOffset.constructor-impl(i3 | i4);
    }

    public static final long DpSize-YgX7TsA(float width, float height) {
        final float f2 = width;
        final int i = 0;
        return DpSize.constructor-impl(i3 | i4);
    }

    public static final float coerceAtLeast-YgX7TsA(float $this$coerceAtLeast_u2dYgX7TsA, float minimumValue) {
        final int i = 0;
        return Dp.constructor-impl(RangesKt.coerceAtLeast($this$coerceAtLeast_u2dYgX7TsA, minimumValue));
    }

    public static final float coerceAtMost-YgX7TsA(float $this$coerceAtMost_u2dYgX7TsA, float maximumValue) {
        final int i = 0;
        return Dp.constructor-impl(RangesKt.coerceAtMost($this$coerceAtMost_u2dYgX7TsA, maximumValue));
    }

    public static final float coerceIn-2z7ARbQ(float $this$coerceIn_u2d2z7ARbQ, float minimumValue, float maximumValue) {
        final int i = 0;
        return Dp.constructor-impl(RangesKt.coerceIn($this$coerceIn_u2d2z7ARbQ, minimumValue, maximumValue));
    }

    public static final long getCenter-EaSLcWc(long $this$center) {
        int i2 = 0;
        int i6 = 0;
        float arg0$iv2 = Dp.constructor-impl(height-D9Ej5fM / i3);
        int i4 = 0;
        return DpOffset.constructor-impl(i9 | i10);
    }

    public static void getCenter-EaSLcWc$annotations(long l) {
    }

    public static final float getDp(double $this$dp) {
        final int i = 0;
        return Dp.constructor-impl((float)$this$dp);
    }

    public static final float getDp(float $this$dp) {
        final int i = 0;
        return Dp.constructor-impl($this$dp);
    }

    public static final float getDp(int $this$dp) {
        final int i = 0;
        return Dp.constructor-impl((float)$this$dp);
    }

    public static void getDp$annotations(double d) {
    }

    public static void getDp$annotations(float f) {
    }

    public static void getDp$annotations(int i) {
    }

    public static final float getHeight(androidx.compose.ui.unit.DpRect $this$height) {
        final int i = 0;
        final int i2 = 0;
        return Dp.constructor-impl(bottom-D9Ej5fM - top-D9Ej5fM);
    }

    public static void getHeight$annotations(androidx.compose.ui.unit.DpRect dpRect) {
    }

    public static final long getSize(androidx.compose.ui.unit.DpRect $this$size) {
        final int i = 0;
        Object obj = $this$size;
        int i2 = 0;
        int i4 = 0;
        int i3 = 0;
        int i6 = 0;
        return DpKt.DpSize-YgX7TsA(Dp.constructor-impl(right-D9Ej5fM - left-D9Ej5fM), Dp.constructor-impl(bottom-D9Ej5fM - top-D9Ej5fM));
    }

    public static void getSize$annotations(androidx.compose.ui.unit.DpRect dpRect) {
    }

    public static final float getWidth(androidx.compose.ui.unit.DpRect $this$width) {
        final int i = 0;
        final int i2 = 0;
        return Dp.constructor-impl(right-D9Ej5fM - left-D9Ej5fM);
    }

    public static void getWidth$annotations(androidx.compose.ui.unit.DpRect dpRect) {
    }

    public static final boolean isFinite-0680j_4(float $this$isFinite) {
        int i;
        final int i2 = 0;
        final int i5 = 1;
        i = Float.compare($this$isFinite, i3) == 0 ? i5 : 0;
        return i ^= i5;
    }

    public static void isFinite-0680j_4$annotations(float f) {
    }

    public static final boolean isSpecified-0680j_4(float $this$isSpecified) {
        final int i = 0;
        return naN ^= 1;
    }

    public static void isSpecified-0680j_4$annotations(float f) {
    }

    public static final boolean isSpecified-EaSLcWc(long $this$isSpecified) {
        int i;
        final int i2 = 0;
        i = Long.compare($this$isSpecified, l) != 0 ? 1 : 0;
        return i;
    }

    public static void isSpecified-EaSLcWc$annotations(long l) {
    }

    public static final boolean isSpecified-jo-Fl9I(long $this$isSpecified) {
        int i;
        final int i2 = 0;
        i = Long.compare($this$isSpecified, l) != 0 ? 1 : 0;
        return i;
    }

    public static void isSpecified-jo-Fl9I$annotations(long l) {
    }

    public static final boolean isUnspecified-0680j_4(float $this$isUnspecified) {
        final int i = 0;
        return Float.isNaN($this$isUnspecified);
    }

    public static void isUnspecified-0680j_4$annotations(float f) {
    }

    public static final boolean isUnspecified-EaSLcWc(long $this$isUnspecified) {
        int i;
        final int i2 = 0;
        i = Long.compare($this$isUnspecified, l) == 0 ? 1 : 0;
        return i;
    }

    public static void isUnspecified-EaSLcWc$annotations(long l) {
    }

    public static final boolean isUnspecified-jo-Fl9I(long $this$isUnspecified) {
        int i;
        final int i2 = 0;
        i = Long.compare($this$isUnspecified, l) == 0 ? 1 : 0;
        return i;
    }

    public static void isUnspecified-jo-Fl9I$annotations(long l) {
    }

    public static final long lerp-IDex15A(long start, long stop, float fraction) {
        float lerp-Md-fbLM2 = DpKt.lerp-Md-fbLM(DpSize.getHeight-D9Ej5fM(start), DpSize.getHeight-D9Ej5fM(fraction), obj15);
        int i = 0;
        return DpSize.constructor-impl(i3 | i4);
    }

    public static final float lerp-Md-fbLM(float start, float stop, float fraction) {
        return Dp.constructor-impl(MathHelpersKt.lerp(start, stop, fraction));
    }

    public static final long lerp-xhh869w(long start, long stop, float fraction) {
        float lerp2 = MathHelpersKt.lerp(DpOffset.getY-D9Ej5fM(start), DpOffset.getY-D9Ej5fM(fraction), obj15);
        int i = 0;
        return DpOffset.constructor-impl(i3 | i4);
    }

    public static final float max-YgX7TsA(float a, float b) {
        final int i = 0;
        return Dp.constructor-impl(Math.max(a, b));
    }

    public static final float min-YgX7TsA(float a, float b) {
        final int i = 0;
        return Dp.constructor-impl(Math.min(a, b));
    }

    public static final float takeOrElse-D5KLDUw(float $this$takeOrElse_u2dD5KLDUw, Function0<androidx.compose.ui.unit.Dp> block) {
        float unbox-impl;
        final int i = 0;
        final int i2 = 0;
        if (!Float.isNaN($this$takeOrElse_u2dD5KLDUw)) {
            unbox-impl = $this$takeOrElse_u2dD5KLDUw;
        } else {
            unbox-impl = (Dp)block.invoke().unbox-impl();
        }
        return unbox-impl;
    }

    public static final long takeOrElse-gVKV90s(long $this$takeOrElse_u2dgVKV90s, Function0<androidx.compose.ui.unit.DpOffset> block) {
        long unbox-impl;
        int i;
        final int i2 = 0;
        final int i3 = 0;
        i = Long.compare(l, l2) != 0 ? 1 : 0;
        if (i != 0) {
            unbox-impl = $this$takeOrElse_u2dgVKV90s;
        } else {
            unbox-impl = (DpOffset)obj8.invoke().unbox-impl();
        }
        return unbox-impl;
    }

    public static final long takeOrElse-itqla9I(long $this$takeOrElse_u2ditqla9I, Function0<androidx.compose.ui.unit.DpSize> block) {
        long unbox-impl;
        int i;
        final int i2 = 0;
        final int i3 = 0;
        i = Long.compare(l, l2) != 0 ? 1 : 0;
        if (i != 0) {
            unbox-impl = $this$takeOrElse_u2ditqla9I;
        } else {
            unbox-impl = (DpSize)obj8.invoke().unbox-impl();
        }
        return unbox-impl;
    }

    public static final float times-3ABfNKs(double $this$times_u2d3ABfNKs, float other) {
        final int i = 0;
        return Dp.constructor-impl(f *= obj4);
    }

    public static final float times-3ABfNKs(float $this$times_u2d3ABfNKs, float other) {
        final int i = 0;
        return Dp.constructor-impl($this$times_u2d3ABfNKs * other);
    }

    public static final float times-3ABfNKs(int $this$times_u2d3ABfNKs, float other) {
        final int i = 0;
        return Dp.constructor-impl(f *= other);
    }

    public static final long times-6HolHcs(float $this$times_u2d6HolHcs, long size) {
        final int i = 0;
        return DpSize.times-Gh9hcWk(size, obj5);
    }

    public static final long times-6HolHcs(int $this$times_u2d6HolHcs, long size) {
        final int i = 0;
        return DpSize.times-Gh9hcWk(size, obj5);
    }
}
