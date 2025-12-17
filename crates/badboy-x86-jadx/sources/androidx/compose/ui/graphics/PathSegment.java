package androidx.compose.ui.graphics;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u001f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0017", d2 = {"Landroidx/compose/ui/graphics/PathSegment;", "", "type", "Landroidx/compose/ui/graphics/PathSegment$Type;", "points", "", "weight", "", "(Landroidx/compose/ui/graphics/PathSegment$Type;[FF)V", "getPoints", "()[F", "getType", "()Landroidx/compose/ui/graphics/PathSegment$Type;", "getWeight", "()F", "equals", "", "other", "hashCode", "", "toString", "", "Type", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathSegment {

    private final float[] points;
    private final androidx.compose.ui.graphics.PathSegment.Type type;
    private final float weight;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\t\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\t¨\u0006\n", d2 = {"Landroidx/compose/ui/graphics/PathSegment$Type;", "", "(Ljava/lang/String;I)V", "Move", "Line", "Quadratic", "Conic", "Cubic", "Close", "Done", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static enum Type {

        Move,
        Line,
        Quadratic,
        Conic,
        Cubic,
        Close,
        Done;
        private static final androidx.compose.ui.graphics.PathSegment.Type[] $values() {
            return /* result */;
        }
    }
    public PathSegment(androidx.compose.ui.graphics.PathSegment.Type type, float[] points, float weight) {
        super();
        this.type = type;
        this.points = points;
        this.weight = weight;
    }

    public boolean equals(Object other) {
        int i;
        Class class2;
        Class class;
        final int i2 = 1;
        if (this == other) {
            return i2;
        }
        final int i3 = 0;
        if (other != null) {
            if (getClass() != other.getClass()) {
            } else {
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
            }
            return i2;
        }
        return i3;
    }

    public final float[] getPoints() {
        return this.points;
    }

    public final androidx.compose.ui.graphics.PathSegment.Type getType() {
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
