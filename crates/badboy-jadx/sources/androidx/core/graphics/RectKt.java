package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u000c\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u000c\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0004\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\u0008\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0008\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u000c\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u000c\u001a\u0015\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\u000c\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0003H\u0086\u0008\u001a\r\u0010\u0017\u001a\u00020\u0003*\u00020\u0001H\u0086\u0008\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0001H\u0086\u0008\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0003H\u0086\u0008\u001a\u0015\u0010\u0019\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\u0008\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u000c\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\u000c¨\u0006\u001d", d2 = {"and", "Landroid/graphics/Rect;", "r", "Landroid/graphics/RectF;", "component1", "", "", "component2", "component3", "component4", "contains", "", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "minus", "xy", "Landroid/graphics/Region;", "or", "plus", "times", "factor", "toRect", "toRectF", "toRegion", "transform", "m", "Landroid/graphics/Matrix;", "xor", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RectKt {
    public static final Rect and(Rect $this$and, Rect r) {
        final int i = 0;
        Rect rect = new Rect($this$and);
        final int i2 = 0;
        rect.intersect(r);
        return rect;
    }

    public static final RectF and(RectF $this$and, RectF r) {
        final int i = 0;
        RectF rectF = new RectF($this$and);
        final int i2 = 0;
        rectF.intersect(r);
        return rectF;
    }

    public static final float component1(RectF $this$component1) {
        final int i = 0;
        return $this$component1.left;
    }

    public static final int component1(Rect $this$component1) {
        final int i = 0;
        return $this$component1.left;
    }

    public static final float component2(RectF $this$component2) {
        final int i = 0;
        return $this$component2.top;
    }

    public static final int component2(Rect $this$component2) {
        final int i = 0;
        return $this$component2.top;
    }

    public static final float component3(RectF $this$component3) {
        final int i = 0;
        return $this$component3.right;
    }

    public static final int component3(Rect $this$component3) {
        final int i = 0;
        return $this$component3.right;
    }

    public static final float component4(RectF $this$component4) {
        final int i = 0;
        return $this$component4.bottom;
    }

    public static final int component4(Rect $this$component4) {
        final int i = 0;
        return $this$component4.bottom;
    }

    public static final boolean contains(Rect $this$contains, Point p) {
        final int i = 0;
        return $this$contains.contains(p.x, p.y);
    }

    public static final boolean contains(RectF $this$contains, PointF p) {
        final int i = 0;
        return $this$contains.contains(p.x, p.y);
    }

    public static final Rect minus(Rect $this$minus, int xy) {
        final int i = 0;
        Rect rect = new Rect($this$minus);
        final int i2 = 0;
        rect.offset(-xy, -xy);
        return rect;
    }

    public static final Rect minus(Rect $this$minus, Point xy) {
        final int i = 0;
        Rect rect = new Rect($this$minus);
        final int i2 = 0;
        rect.offset(-i3, -i5);
        return rect;
    }

    public static final RectF minus(RectF $this$minus, float xy) {
        final int i = 0;
        RectF rectF = new RectF($this$minus);
        final int i2 = 0;
        rectF.offset(-xy, -xy);
        return rectF;
    }

    public static final RectF minus(RectF $this$minus, PointF xy) {
        final int i = 0;
        RectF rectF = new RectF($this$minus);
        final int i2 = 0;
        rectF.offset(-f, -f2);
        return rectF;
    }

    public static final Region minus(Rect $this$minus, Rect r) {
        final int i = 0;
        Region region = new Region($this$minus);
        final int i2 = 0;
        region.op(r, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Region minus(RectF $this$minus, RectF r) {
        final int i = 0;
        int i2 = 0;
        Rect rect = new Rect();
        $this$minus.roundOut(rect);
        Region region = new Region(rect);
        int i3 = 0;
        final int i4 = 0;
        Rect rect2 = new Rect();
        r.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Rect or(Rect $this$or, Rect r) {
        final int i = 0;
        final int i2 = 0;
        Rect rect2 = new Rect($this$or);
        final int i3 = 0;
        rect2.union(r);
        return rect2;
    }

    public static final RectF or(RectF $this$or, RectF r) {
        final int i = 0;
        final int i2 = 0;
        RectF rectF2 = new RectF($this$or);
        final int i3 = 0;
        rectF2.union(r);
        return rectF2;
    }

    public static final Rect plus(Rect $this$plus, int xy) {
        final int i = 0;
        Rect rect = new Rect($this$plus);
        final int i2 = 0;
        rect.offset(xy, xy);
        return rect;
    }

    public static final Rect plus(Rect $this$plus, Point xy) {
        final int i = 0;
        Rect rect = new Rect($this$plus);
        final int i2 = 0;
        rect.offset(xy.x, xy.y);
        return rect;
    }

    public static final Rect plus(Rect $this$plus, Rect r) {
        final int i = 0;
        Rect rect = new Rect($this$plus);
        final int i2 = 0;
        rect.union(r);
        return rect;
    }

    public static final RectF plus(RectF $this$plus, float xy) {
        final int i = 0;
        RectF rectF = new RectF($this$plus);
        final int i2 = 0;
        rectF.offset(xy, xy);
        return rectF;
    }

    public static final RectF plus(RectF $this$plus, PointF xy) {
        final int i = 0;
        RectF rectF = new RectF($this$plus);
        final int i2 = 0;
        rectF.offset(xy.x, xy.y);
        return rectF;
    }

    public static final RectF plus(RectF $this$plus, RectF r) {
        final int i = 0;
        RectF rectF = new RectF($this$plus);
        final int i2 = 0;
        rectF.union(r);
        return rectF;
    }

    public static final Rect times(Rect $this$times, int factor) {
        final int i = 0;
        Rect rect = new Rect($this$times);
        final Rect rect2 = rect;
        final int i2 = 0;
        rect2.top = top *= factor;
        rect2.left = left *= factor;
        rect2.right = right *= factor;
        rect2.bottom = bottom *= factor;
        return rect;
    }

    public static final RectF times(RectF $this$times, float factor) {
        final int i = 0;
        RectF rectF = new RectF($this$times);
        final RectF rectF2 = rectF;
        final int i2 = 0;
        rectF2.top = top *= factor;
        rectF2.left = left *= factor;
        rectF2.right = right *= factor;
        rectF2.bottom = bottom *= factor;
        return rectF;
    }

    public static final RectF times(RectF $this$times, int factor) {
        final int i = 0;
        final float f = (float)factor;
        final int i2 = 0;
        RectF rectF2 = new RectF($this$times);
        final RectF rectF3 = rectF2;
        final int i3 = 0;
        rectF3.top = top *= f;
        rectF3.left = left *= f;
        rectF3.right = right *= f;
        rectF3.bottom = bottom *= f;
        return rectF2;
    }

    public static final Rect toRect(RectF $this$toRect) {
        final int i = 0;
        Rect rect = new Rect();
        $this$toRect.roundOut(rect);
        return rect;
    }

    public static final RectF toRectF(Rect $this$toRectF) {
        final int i = 0;
        RectF rectF = new RectF($this$toRectF);
        return rectF;
    }

    public static final Region toRegion(Rect $this$toRegion) {
        final int i = 0;
        Region region = new Region($this$toRegion);
        return region;
    }

    public static final Region toRegion(RectF $this$toRegion) {
        final int i = 0;
        final int i2 = 0;
        Rect rect = new Rect();
        $this$toRegion.roundOut(rect);
        Region region = new Region(rect);
        return region;
    }

    public static final RectF transform(RectF $this$transform, Matrix m) {
        final int i = 0;
        final RectF rectF = $this$transform;
        final int i2 = 0;
        m.mapRect($this$transform);
        return $this$transform;
    }

    public static final Region xor(Rect $this$xor, Rect r) {
        final int i = 0;
        Region region = new Region($this$xor);
        final int i2 = 0;
        region.op(r, Region.Op.XOR);
        return region;
    }

    public static final Region xor(RectF $this$xor, RectF r) {
        final int i = 0;
        int i2 = 0;
        Rect rect = new Rect();
        $this$xor.roundOut(rect);
        Region region = new Region(rect);
        int i3 = 0;
        final int i4 = 0;
        Rect rect2 = new Rect();
        r.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }
}
