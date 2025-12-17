package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007\u001a8\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\u00052\u0008\u0008\u0002\u0010\n\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u000e\u001a.\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\t\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000e\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\u001a.\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0003\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0003\u0010\u0012\u001a\u00020\u00102\u0008\u0008\u0003\u0010\u0013\u001a\u00020\u00102\u0008\u0008\u0003\u0010\u0014\u001a\u00020\u0010\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0015", d2 = {"AbsoluteCutCornerShape", "Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "corner", "Landroidx/compose/foundation/shape/CornerSize;", "size", "Landroidx/compose/ui/unit/Dp;", "AbsoluteCutCornerShape-0680j_4", "(F)Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "topLeft", "topRight", "bottomRight", "bottomLeft", "AbsoluteCutCornerShape-a9UjIt4", "(FFFF)Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "", "percent", "", "topLeftPercent", "topRightPercent", "bottomRightPercent", "bottomLeftPercent", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AbsoluteCutCornerShapeKt {
    public static final androidx.compose.foundation.shape.AbsoluteCutCornerShape AbsoluteCutCornerShape(float size) {
        return AbsoluteCutCornerShapeKt.AbsoluteCutCornerShape(CornerSizeKt.CornerSize(size));
    }

    public static final androidx.compose.foundation.shape.AbsoluteCutCornerShape AbsoluteCutCornerShape(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        AbsoluteCutCornerShape absoluteCutCornerShape = new AbsoluteCutCornerShape(CornerSizeKt.CornerSize(topLeft), CornerSizeKt.CornerSize(topRight), CornerSizeKt.CornerSize(bottomRight), CornerSizeKt.CornerSize(bottomLeft));
        return absoluteCutCornerShape;
    }

    public static final androidx.compose.foundation.shape.AbsoluteCutCornerShape AbsoluteCutCornerShape(int percent) {
        return AbsoluteCutCornerShapeKt.AbsoluteCutCornerShape(CornerSizeKt.CornerSize(percent));
    }

    public static final androidx.compose.foundation.shape.AbsoluteCutCornerShape AbsoluteCutCornerShape(int topLeftPercent, int topRightPercent, int bottomRightPercent, int bottomLeftPercent) {
        AbsoluteCutCornerShape absoluteCutCornerShape = new AbsoluteCutCornerShape(CornerSizeKt.CornerSize(topLeftPercent), CornerSizeKt.CornerSize(topRightPercent), CornerSizeKt.CornerSize(bottomRightPercent), CornerSizeKt.CornerSize(bottomLeftPercent));
        return absoluteCutCornerShape;
    }

    public static final androidx.compose.foundation.shape.AbsoluteCutCornerShape AbsoluteCutCornerShape(androidx.compose.foundation.shape.CornerSize corner) {
        AbsoluteCutCornerShape absoluteCutCornerShape = new AbsoluteCutCornerShape(corner, corner, corner, corner);
        return absoluteCutCornerShape;
    }

    public static androidx.compose.foundation.shape.AbsoluteCutCornerShape AbsoluteCutCornerShape$default(float f, float f2, float f3, float f4, int i5, Object object6) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 1 != 0) {
            obj1 = i;
        }
        if (i5 & 2 != 0) {
            obj2 = i;
        }
        if (i5 & 4 != 0) {
            obj3 = i;
        }
        if (i5 &= 8 != 0) {
            obj4 = i;
        }
        return AbsoluteCutCornerShapeKt.AbsoluteCutCornerShape(obj1, obj2, obj3, obj4);
    }

    public static androidx.compose.foundation.shape.AbsoluteCutCornerShape AbsoluteCutCornerShape$default(int i, int i2, int i3, int i4, int i5, Object object6) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        final int i6 = 0;
        if (i5 & 1 != 0) {
            obj1 = i6;
        }
        if (i5 & 2 != 0) {
            obj2 = i6;
        }
        if (i5 & 4 != 0) {
            obj3 = i6;
        }
        if (i5 &= 8 != 0) {
            obj4 = i6;
        }
        return AbsoluteCutCornerShapeKt.AbsoluteCutCornerShape(obj1, obj2, obj3, obj4);
    }

    public static final androidx.compose.foundation.shape.AbsoluteCutCornerShape AbsoluteCutCornerShape-0680j_4(float size) {
        return AbsoluteCutCornerShapeKt.AbsoluteCutCornerShape(CornerSizeKt.CornerSize-0680j_4(size));
    }

    public static final androidx.compose.foundation.shape.AbsoluteCutCornerShape AbsoluteCutCornerShape-a9UjIt4(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        AbsoluteCutCornerShape absoluteCutCornerShape = new AbsoluteCutCornerShape(CornerSizeKt.CornerSize-0680j_4(topLeft), CornerSizeKt.CornerSize-0680j_4(topRight), CornerSizeKt.CornerSize-0680j_4(bottomRight), CornerSizeKt.CornerSize-0680j_4(bottomLeft));
        return absoluteCutCornerShape;
    }

    public static androidx.compose.foundation.shape.AbsoluteCutCornerShape AbsoluteCutCornerShape-a9UjIt4$default(float f, float f2, float f3, float f4, int i5, Object object6) {
        float f5;
        float obj1;
        float obj2;
        float obj3;
        float obj4;
        int obj5;
        int obj6;
        if (i5 & 1 != 0) {
            obj6 = 0;
            obj1 = Dp.constructor-impl((float)obj1);
        }
        if (i5 & 2 != 0) {
            obj6 = 0;
            obj2 = Dp.constructor-impl((float)obj2);
        }
        if (i5 & 4 != 0) {
            obj6 = 0;
            obj3 = Dp.constructor-impl((float)obj3);
        }
        if (i5 &= 8 != 0) {
            obj5 = 0;
            obj4 = Dp.constructor-impl((float)obj4);
        }
        return AbsoluteCutCornerShapeKt.AbsoluteCutCornerShape-a9UjIt4(obj1, obj2, obj3, obj4);
    }
}
