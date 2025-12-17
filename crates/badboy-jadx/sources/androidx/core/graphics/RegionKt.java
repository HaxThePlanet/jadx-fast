package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010(\n\u0002\u0008\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\u000c\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u000c\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n\u001a0\u0010\u0008\u001a\u00020\t*\u00020\u00012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\u0086\u0008\u001a\u0013\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010*\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\u000c\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u000c\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\u000c\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u000c¨\u0006\u0017", d2 = {"and", "Landroid/graphics/Region;", "r", "Landroid/graphics/Rect;", "contains", "", "p", "Landroid/graphics/Point;", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "iterator", "", "minus", "not", "or", "plus", "unaryMinus", "xor", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RegionKt {
    public static final Region and(Region $this$and, Rect r) {
        final int i = 0;
        Region region = new Region($this$and);
        final int i2 = 0;
        region.op(r, Region.Op.INTERSECT);
        return region;
    }

    public static final Region and(Region $this$and, Region r) {
        final int i = 0;
        Region region = new Region($this$and);
        final int i2 = 0;
        region.op(r, Region.Op.INTERSECT);
        return region;
    }

    public static final boolean contains(Region $this$contains, Point p) {
        final int i = 0;
        return $this$contains.contains(p.x, p.y);
    }

    public static final void forEach(Region $this$forEach, Function1<? super Rect, Unit> action) {
        Rect rect;
        boolean next;
        final int i = 0;
        RegionIterator regionIterator = new RegionIterator($this$forEach);
        rect = new Rect();
        while (!regionIterator.next(rect)) {
            action.invoke(rect);
            rect = new Rect();
        }
    }

    public static final Iterator<Rect> iterator(Region $this$iterator) {
        RegionKt.iterator.1 anon = new RegionKt.iterator.1($this$iterator);
        return (Iterator)anon;
    }

    public static final Region minus(Region $this$minus, Rect r) {
        final int i = 0;
        Region region = new Region($this$minus);
        final int i2 = 0;
        region.op(r, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Region minus(Region $this$minus, Region r) {
        final int i = 0;
        Region region = new Region($this$minus);
        final int i2 = 0;
        region.op(r, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Region not(Region $this$not) {
        final int i = 0;
        final Region region = $this$not;
        final int i2 = 0;
        Region region2 = new Region(region.getBounds());
        final int i3 = 0;
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region or(Region $this$or, Rect r) {
        final int i = 0;
        final int i2 = 0;
        Region region2 = new Region($this$or);
        final int i3 = 0;
        region2.union(r);
        return region2;
    }

    public static final Region or(Region $this$or, Region r) {
        final int i = 0;
        final int i2 = 0;
        Region region2 = new Region($this$or);
        final int i3 = 0;
        region2.op(r, Region.Op.UNION);
        return region2;
    }

    public static final Region plus(Region $this$plus, Rect r) {
        final int i = 0;
        Region region = new Region($this$plus);
        final int i2 = 0;
        region.union(r);
        return region;
    }

    public static final Region plus(Region $this$plus, Region r) {
        final int i = 0;
        Region region = new Region($this$plus);
        final int i2 = 0;
        region.op(r, Region.Op.UNION);
        return region;
    }

    public static final Region unaryMinus(Region $this$unaryMinus) {
        final int i = 0;
        Region region = new Region($this$unaryMinus.getBounds());
        final int i2 = 0;
        region.op($this$unaryMinus, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Region xor(Region $this$xor, Rect r) {
        final int i = 0;
        Region region = new Region($this$xor);
        final int i2 = 0;
        region.op(r, Region.Op.XOR);
        return region;
    }

    public static final Region xor(Region $this$xor, Region r) {
        final int i = 0;
        Region region = new Region($this$xor);
        final int i2 = 0;
        region.op(r, Region.Op.XOR);
        return region;
    }
}
