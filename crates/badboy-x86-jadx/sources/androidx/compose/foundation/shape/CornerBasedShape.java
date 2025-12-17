package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u0008'\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003J0\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003H&J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018JB\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H&ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001c", d2 = {"Landroidx/compose/foundation/shape/CornerBasedShape;", "Landroidx/compose/ui/graphics/Shape;", "topStart", "Landroidx/compose/foundation/shape/CornerSize;", "topEnd", "bottomEnd", "bottomStart", "(Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;Landroidx/compose/foundation/shape/CornerSize;)V", "getBottomEnd", "()Landroidx/compose/foundation/shape/CornerSize;", "getBottomStart", "getTopEnd", "getTopStart", "copy", "all", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "", "createOutline-LjSzlW0", "(JFFFFLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/graphics/Outline;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class CornerBasedShape implements Shape {

    public static final int $stable;
    private final androidx.compose.foundation.shape.CornerSize bottomEnd;
    private final androidx.compose.foundation.shape.CornerSize bottomStart;
    private final androidx.compose.foundation.shape.CornerSize topEnd;
    private final androidx.compose.foundation.shape.CornerSize topStart;
    static {
    }

    public CornerBasedShape(androidx.compose.foundation.shape.CornerSize topStart, androidx.compose.foundation.shape.CornerSize topEnd, androidx.compose.foundation.shape.CornerSize bottomEnd, androidx.compose.foundation.shape.CornerSize bottomStart) {
        super();
        this.topStart = topStart;
        this.topEnd = topEnd;
        this.bottomEnd = bottomEnd;
        this.bottomStart = bottomStart;
    }

    public static androidx.compose.foundation.shape.CornerBasedShape copy$default(androidx.compose.foundation.shape.CornerBasedShape cornerBasedShape, androidx.compose.foundation.shape.CornerSize cornerSize2, androidx.compose.foundation.shape.CornerSize cornerSize3, androidx.compose.foundation.shape.CornerSize cornerSize4, androidx.compose.foundation.shape.CornerSize cornerSize5, int i6, Object object7) {
        androidx.compose.foundation.shape.CornerSize obj1;
        androidx.compose.foundation.shape.CornerSize obj2;
        androidx.compose.foundation.shape.CornerSize obj3;
        androidx.compose.foundation.shape.CornerSize obj4;
        if (object7 != null) {
        } else {
            if (i6 & 1 != 0) {
                obj1 = cornerBasedShape.topStart;
            }
            if (i6 & 2 != 0) {
                obj2 = cornerBasedShape.topEnd;
            }
            if (i6 & 4 != 0) {
                obj3 = cornerBasedShape.bottomEnd;
            }
            if (i6 &= 8 != 0) {
                obj4 = cornerBasedShape.bottomStart;
            }
            return cornerBasedShape.copy(obj1, obj2, obj3, obj4);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        throw obj0;
    }

    @Override // androidx.compose.ui.graphics.Shape
    public final androidx.compose.foundation.shape.CornerBasedShape copy(androidx.compose.foundation.shape.CornerSize all) {
        return copy(all, all, all, all);
    }

    @Override // androidx.compose.ui.graphics.Shape
    public abstract androidx.compose.foundation.shape.CornerBasedShape copy(androidx.compose.foundation.shape.CornerSize cornerSize, androidx.compose.foundation.shape.CornerSize cornerSize2, androidx.compose.foundation.shape.CornerSize cornerSize3, androidx.compose.foundation.shape.CornerSize cornerSize4);

    @Override // androidx.compose.ui.graphics.Shape
    public abstract Outline createOutline-LjSzlW0(long l, float f2, float f3, float f4, float f5, LayoutDirection layoutDirection6);

    @Override // androidx.compose.ui.graphics.Shape
    public final Outline createOutline-Pq9zytI(long size, LayoutDirection layoutDirection, Density density) {
        float topStart;
        float topEnd;
        float bottomEnd;
        float bottomStart;
        int cmp2;
        int cmp3;
        int i;
        int scale;
        int cmp;
        int i3 = 0;
        topStart = this.topStart.toPx-TmRCtEA(size, layoutDirection);
        int i4 = 0;
        topEnd = this.topEnd.toPx-TmRCtEA(size, layoutDirection);
        int i5 = 0;
        bottomEnd = this.bottomEnd.toPx-TmRCtEA(size, layoutDirection);
        int i6 = 0;
        bottomStart = this.bottomStart.toPx-TmRCtEA(size, layoutDirection);
        final float minDimension-impl = Size.getMinDimension-impl(size);
        if (Float.compare(i7, minDimension-impl) > 0) {
            cmp2 = minDimension-impl / i9;
            topStart *= cmp2;
            bottomStart *= cmp2;
        }
        if (Float.compare(scale2, minDimension-impl) > 0) {
            cmp3 = minDimension-impl / i8;
            topEnd *= cmp3;
            bottomEnd *= cmp3;
        }
        scale = 0;
        if (Float.compare(topStart, scale) >= 0 && Float.compare(topEnd, scale) >= 0 && Float.compare(bottomEnd, scale) >= 0 && Float.compare(bottomStart, scale) >= 0) {
            if (Float.compare(topEnd, scale) >= 0) {
                if (Float.compare(bottomEnd, scale) >= 0) {
                    i = Float.compare(bottomStart, scale) >= 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        if (i == 0) {
        } else {
            return this.createOutline-LjSzlW0(size, obj2, topStart, topEnd, bottomEnd, bottomStart);
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Corner size in Px can't be negative(topStart = ").append(topStart).append(", topEnd = ").append(topEnd).append(", bottomEnd = ").append(bottomEnd).append(", bottomStart = ").append(bottomStart).append(")!").toString().toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.ui.graphics.Shape
    public final androidx.compose.foundation.shape.CornerSize getBottomEnd() {
        return this.bottomEnd;
    }

    @Override // androidx.compose.ui.graphics.Shape
    public final androidx.compose.foundation.shape.CornerSize getBottomStart() {
        return this.bottomStart;
    }

    @Override // androidx.compose.ui.graphics.Shape
    public final androidx.compose.foundation.shape.CornerSize getTopEnd() {
        return this.topEnd;
    }

    @Override // androidx.compose.ui.graphics.Shape
    public final androidx.compose.foundation.shape.CornerSize getTopStart() {
        return this.topStart;
    }
}
