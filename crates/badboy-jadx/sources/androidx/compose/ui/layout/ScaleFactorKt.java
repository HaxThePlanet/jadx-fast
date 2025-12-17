package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u001d\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH\u0007¢\u0006\u0002\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000cH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014\u001a\u001f\u0010\u0015\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a\u000c\u0010\u001a\u001a\u00020\u000c*\u00020\u000cH\u0002\u001a%\u0010\u001b\u001a\u00020\u0002*\u00020\u00022\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001dH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a\u001f\u0010 \u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\u0019\u001a\u001f\u0010 \u001a\u00020\u0016*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0016H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\u0008#\u0010\u0019\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\u0004\u001a\u0004\u0008\t\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006$", d2 = {"isSpecified", "", "Landroidx/compose/ui/layout/ScaleFactor;", "isSpecified-FK8aYYs$annotations", "(J)V", "isSpecified-FK8aYYs", "(J)Z", "isUnspecified", "isUnspecified-FK8aYYs$annotations", "isUnspecified-FK8aYYs", "ScaleFactor", "scaleX", "", "scaleY", "(FF)J", "lerp", "start", "stop", "fraction", "lerp--bDIf60", "(JJF)J", "div", "Landroidx/compose/ui/geometry/Size;", "scaleFactor", "div-UQTWf7w", "(JJ)J", "roundToTenths", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-oyDd2qo", "(JLkotlin/jvm/functions/Function0;)J", "times", "times-UQTWf7w", "size", "times-m-w2e94", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScaleFactorKt {
    public static final long ScaleFactor(float scaleX, float scaleY) {
        int i = 0;
        long l = (long)floatToRawIntBits;
        return ScaleFactor.constructor-impl(i3 | i4);
    }

    public static final float access$roundToTenths(float $receiver) {
        return ScaleFactorKt.roundToTenths($receiver);
    }

    public static final long div-UQTWf7w(long $this$div_u2dUQTWf7w, long scaleFactor) {
        return SizeKt.Size(width-impl /= scaleX-impl, height-impl /= scaleY-impl);
    }

    public static final boolean isSpecified-FK8aYYs(long $this$isSpecified) {
        int i;
        final int i2 = 0;
        i = Long.compare($this$isSpecified, unspecified-_hLwfpc) != 0 ? 1 : 0;
        return i;
    }

    public static void isSpecified-FK8aYYs$annotations(long l) {
    }

    public static final boolean isUnspecified-FK8aYYs(long $this$isUnspecified) {
        int i;
        final int i2 = 0;
        i = Long.compare($this$isUnspecified, unspecified-_hLwfpc) == 0 ? 1 : 0;
        return i;
    }

    public static void isUnspecified-FK8aYYs$annotations(long l) {
    }

    public static final long lerp--bDIf60(long start, long stop, float fraction) {
        return ScaleFactorKt.ScaleFactor(MathHelpersKt.lerp(ScaleFactor.getScaleX-impl(start), ScaleFactor.getScaleX-impl(fraction), obj7), MathHelpersKt.lerp(ScaleFactor.getScaleY-impl(start), ScaleFactor.getScaleY-impl(fraction), obj7));
    }

    private static final float roundToTenths(float $this$roundToTenths) {
        int i;
        float f = (float)i2;
        final int i3 = $this$roundToTenths * f;
        i = Float.compare(i5, i6) >= 0 ? i7 + 1 : (int)i3;
        return f3 /= f;
    }

    public static final long takeOrElse-oyDd2qo(long $this$takeOrElse_u2doyDd2qo, Function0<androidx.compose.ui.layout.ScaleFactor> block) {
        long unbox-impl;
        int i;
        final int i2 = 0;
        final int i3 = 0;
        i = Long.compare(l, unspecified-_hLwfpc) != 0 ? 1 : 0;
        if (i != 0) {
            unbox-impl = $this$takeOrElse_u2doyDd2qo;
        } else {
            unbox-impl = (ScaleFactor)obj8.invoke().unbox-impl();
        }
        return unbox-impl;
    }

    public static final long times-UQTWf7w(long $this$times_u2dUQTWf7w, long scaleFactor) {
        return SizeKt.Size(width-impl *= scaleX-impl, height-impl *= scaleY-impl);
    }

    public static final long times-m-w2e94(long $this$times_u2dm_u2dw2e94, long size) {
        return ScaleFactorKt.times-UQTWf7w(obj4, obj5);
    }
}
