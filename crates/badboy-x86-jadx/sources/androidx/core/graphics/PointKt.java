package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0008\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u0008\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0008\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0008\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000c\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\r\u001a\u00020\u0002*\u00020\u0004H\u0086\u0008\u001a\r\u0010\u000e\u001a\u00020\u0004*\u00020\u0002H\u0086\u0008\u001a\r\u0010\u000f\u001a\u00020\u0002*\u00020\u0002H\u0086\n\u001a\r\u0010\u000f\u001a\u00020\u0004*\u00020\u0004H\u0086\n¨\u0006\u0010", d2 = {"component1", "", "Landroid/graphics/Point;", "", "Landroid/graphics/PointF;", "component2", "div", "scalar", "minus", "p", "xy", "plus", "times", "toPoint", "toPointF", "unaryMinus", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PointKt {
    public static final float component1(PointF $this$component1) {
        final int i = 0;
        return $this$component1.x;
    }

    public static final int component1(Point $this$component1) {
        final int i = 0;
        return $this$component1.x;
    }

    public static final float component2(PointF $this$component2) {
        final int i = 0;
        return $this$component2.y;
    }

    public static final int component2(Point $this$component2) {
        final int i = 0;
        return $this$component2.y;
    }

    public static final Point div(Point $this$div, float scalar) {
        final int i = 0;
        Point point = new Point(Math.round(f /= scalar), Math.round(f2 /= scalar));
        return point;
    }

    public static final PointF div(PointF $this$div, float scalar) {
        final int i = 0;
        PointF pointF = new PointF(f /= scalar, f2 /= scalar);
        return pointF;
    }

    public static final Point minus(Point $this$minus, int xy) {
        final int i = 0;
        Point point = new Point($this$minus.x, $this$minus.y);
        int i4 = 0;
        point.offset(-xy, -xy);
        return point;
    }

    public static final Point minus(Point $this$minus, Point p) {
        final int i = 0;
        Point point = new Point($this$minus.x, $this$minus.y);
        int i4 = 0;
        point.offset(-i5, -i7);
        return point;
    }

    public static final PointF minus(PointF $this$minus, float xy) {
        final int i = 0;
        PointF pointF = new PointF($this$minus.x, $this$minus.y);
        int i2 = 0;
        pointF.offset(-xy, -xy);
        return pointF;
    }

    public static final PointF minus(PointF $this$minus, PointF p) {
        final int i = 0;
        PointF pointF = new PointF($this$minus.x, $this$minus.y);
        int i2 = 0;
        pointF.offset(-f3, -f4);
        return pointF;
    }

    public static final Point plus(Point $this$plus, int xy) {
        final int i = 0;
        Point point = new Point($this$plus.x, $this$plus.y);
        int i4 = 0;
        point.offset(xy, xy);
        return point;
    }

    public static final Point plus(Point $this$plus, Point p) {
        final int i = 0;
        Point point = new Point($this$plus.x, $this$plus.y);
        int i4 = 0;
        point.offset(p.x, p.y);
        return point;
    }

    public static final PointF plus(PointF $this$plus, float xy) {
        final int i = 0;
        PointF pointF = new PointF($this$plus.x, $this$plus.y);
        int i2 = 0;
        pointF.offset(xy, xy);
        return pointF;
    }

    public static final PointF plus(PointF $this$plus, PointF p) {
        final int i = 0;
        PointF pointF = new PointF($this$plus.x, $this$plus.y);
        int i2 = 0;
        pointF.offset(p.x, p.y);
        return pointF;
    }

    public static final Point times(Point $this$times, float scalar) {
        final int i = 0;
        Point point = new Point(Math.round(f *= scalar), Math.round(f2 *= scalar));
        return point;
    }

    public static final PointF times(PointF $this$times, float scalar) {
        final int i = 0;
        PointF pointF = new PointF(f *= scalar, f2 *= scalar);
        return pointF;
    }

    public static final Point toPoint(PointF $this$toPoint) {
        final int i = 0;
        Point point = new Point((int)f, (int)f2);
        return point;
    }

    public static final PointF toPointF(Point $this$toPointF) {
        final int i = 0;
        PointF pointF = new PointF($this$toPointF);
        return pointF;
    }

    public static final Point unaryMinus(Point $this$unaryMinus) {
        final int i = 0;
        Point point = new Point(-i2, -i4);
        return point;
    }

    public static final PointF unaryMinus(PointF $this$unaryMinus) {
        final int i = 0;
        PointF pointF = new PointF(-f, -f2);
        return pointF;
    }
}
