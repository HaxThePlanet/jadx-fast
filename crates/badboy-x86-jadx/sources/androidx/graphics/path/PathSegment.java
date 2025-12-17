package androidx.graphics.path;

import android.graphics.PointF;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B%\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016R\u0019\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0019", d2 = {"Landroidx/graphics/path/PathSegment;", "", "type", "Landroidx/graphics/path/PathSegment$Type;", "points", "", "Landroid/graphics/PointF;", "weight", "", "(Landroidx/graphics/path/PathSegment$Type;[Landroid/graphics/PointF;F)V", "getPoints", "()[Landroid/graphics/PointF;", "[Landroid/graphics/PointF;", "getType", "()Landroidx/graphics/path/PathSegment$Type;", "getWeight", "()F", "equals", "", "other", "hashCode", "", "toString", "", "Type", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathSegment {

    private final PointF[] points;
    private final androidx.graphics.path.PathSegment.Type type;
    private final float weight;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\t\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\t¨\u0006\n", d2 = {"Landroidx/graphics/path/PathSegment$Type;", "", "(Ljava/lang/String;I)V", "Move", "Line", "Quadratic", "Conic", "Cubic", "Close", "Done", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static enum Type {

        Move,
        Move,
        Move,
        Move,
        Move,
        Move,
        Move,
        Move;
        private static final androidx.graphics.path.PathSegment.Type[] $values() {
            return /* result */;
        }
    }
    public PathSegment(androidx.graphics.path.PathSegment.Type type, PointF[] points, float weight) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(points, "points");
        super();
        this.type = type;
        this.points = points;
        this.weight = weight;
    }

    public boolean equals(Object other) {
        int i;
        Class class;
        final int i2 = 1;
        if (this == other) {
            return i2;
        }
        if (other != null) {
            class = other.getClass();
        } else {
            class = 0;
        }
        int i3 = 0;
        if (!Intrinsics.areEqual(getClass(), class)) {
            return i3;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.graphics.path.PathSegment");
        Object obj = other;
        if (this.type != obj2.type) {
            return i3;
        }
        if (!Arrays.equals(this.points, obj3.points)) {
            return i3;
        }
        i = Float.compare(weight, weight2) == 0 ? i2 : i3;
        if (i == 0) {
            return i3;
        }
        return i2;
    }

    public final PointF[] getPoints() {
        return this.points;
    }

    public final androidx.graphics.path.PathSegment.Type getType() {
        return this.type;
    }

    public final float getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return result += i6;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = Arrays.toString(this.points);
        Intrinsics.checkNotNullExpressionValue(string2, "toString(this)");
        return stringBuilder.append("PathSegment(type=").append(this.type).append(", points=").append(string2).append(", weight=").append(this.weight).append(')').toString();
    }
}
