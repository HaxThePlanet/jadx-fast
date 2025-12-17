package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\r\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a\u001f\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011\u001a\u001f\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0011\u001a\u001f\u0010\u0013\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0011\u001a\u001f\u0010\u0013\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0011\u001a\u0016\u0010\u0016\u001a\u00020\u0001*\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018\u001a\u0017\u0010\u0019\u001a\u00020\u000e*\u00020\u0001H\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u0018\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"IntOffset", "Landroidx/compose/ui/unit/IntOffset;", "x", "", "y", "(II)J", "lerp", "start", "stop", "fraction", "", "lerp-81ZRxRo", "(JJF)J", "minus", "Landroidx/compose/ui/geometry/Offset;", "offset", "minus-Nv-tHpc", "(JJ)J", "minus-oCl6YwE", "plus", "plus-Nv-tHpc", "plus-oCl6YwE", "round", "round-k-4lQ0M", "(J)J", "toOffset", "toOffset--gyyYBs", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntOffsetKt {
    public static final long IntOffset(int x, int y) {
        int i = 0;
        l <<= i3;
        return IntOffset.constructor-impl(i2 | i4);
    }

    public static final long lerp-81ZRxRo(long start, long stop, float fraction) {
        int lerp2 = MathHelpersKt.lerp(IntOffset.getY-impl(start), IntOffset.getY-impl(fraction), obj13);
        int i = 0;
        return IntOffset.constructor-impl(i2 | i4);
    }

    public static final long minus-Nv-tHpc(long $this$minus_u2dNv_u2dtHpc, long offset) {
        return OffsetKt.Offset(x-impl -= f, y-impl -= f2);
    }

    public static final long minus-oCl6YwE(long $this$minus_u2doCl6YwE, long offset) {
        return OffsetKt.Offset(f -= x-impl2, f2 -= y-impl2);
    }

    public static final long plus-Nv-tHpc(long $this$plus_u2dNv_u2dtHpc, long offset) {
        return OffsetKt.Offset(x-impl += f, y-impl += f2);
    }

    public static final long plus-oCl6YwE(long $this$plus_u2doCl6YwE, long offset) {
        return OffsetKt.Offset(f += x-impl2, f2 += y-impl2);
    }

    public static final long round-k-4lQ0M(long $this$round_u2dk_u2d4lQ0M) {
        int i = 0;
        int i2 = 0;
        int $this$fastRoundToInt$iv2 = Math.round(Offset.getY-impl($this$round_u2dk_u2d4lQ0M));
        int i3 = 0;
        return IntOffset.constructor-impl(i4 | i6);
    }

    public static final long toOffset--gyyYBs(long $this$toOffset_u2d_u2dgyyYBs) {
        final int i = 0;
        return OffsetKt.Offset((float)x-impl, (float)y-impl);
    }
}
