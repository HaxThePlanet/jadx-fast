package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u001a8\u0010\u0004\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00082\u0008\u0008\u0002\u0010\r\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0011\u001a.\u0010\u0004\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00112\u0008\u0008\u0002\u0010\r\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0011\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013\u001a.\u0010\u0004\u001a\u00020\u00012\u0008\u0008\u0003\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0003\u0010\u0015\u001a\u00020\u00132\u0008\u0008\u0003\u0010\u0016\u001a\u00020\u00132\u0008\u0008\u0003\u0010\u0017\u001a\u00020\u0013\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0018", d2 = {"CircleShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getCircleShape", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "RoundedCornerShape", "corner", "Landroidx/compose/foundation/shape/CornerSize;", "size", "Landroidx/compose/ui/unit/Dp;", "RoundedCornerShape-0680j_4", "(F)Landroidx/compose/foundation/shape/RoundedCornerShape;", "topStart", "topEnd", "bottomEnd", "bottomStart", "RoundedCornerShape-a9UjIt4", "(FFFF)Landroidx/compose/foundation/shape/RoundedCornerShape;", "", "percent", "", "topStartPercent", "topEndPercent", "bottomEndPercent", "bottomStartPercent", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RoundedCornerShapeKt {

    private static final androidx.compose.foundation.shape.RoundedCornerShape CircleShape;
    static {
        RoundedCornerShapeKt.CircleShape = RoundedCornerShapeKt.RoundedCornerShape(50);
    }

    public static final androidx.compose.foundation.shape.RoundedCornerShape RoundedCornerShape(float size) {
        return RoundedCornerShapeKt.RoundedCornerShape(CornerSizeKt.CornerSize(size));
    }

    public static final androidx.compose.foundation.shape.RoundedCornerShape RoundedCornerShape(float topStart, float topEnd, float bottomEnd, float bottomStart) {
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(CornerSizeKt.CornerSize(topStart), CornerSizeKt.CornerSize(topEnd), CornerSizeKt.CornerSize(bottomEnd), CornerSizeKt.CornerSize(bottomStart));
        return roundedCornerShape;
    }

    public static final androidx.compose.foundation.shape.RoundedCornerShape RoundedCornerShape(int percent) {
        return RoundedCornerShapeKt.RoundedCornerShape(CornerSizeKt.CornerSize(percent));
    }

    public static final androidx.compose.foundation.shape.RoundedCornerShape RoundedCornerShape(int topStartPercent, int topEndPercent, int bottomEndPercent, int bottomStartPercent) {
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(CornerSizeKt.CornerSize(topStartPercent), CornerSizeKt.CornerSize(topEndPercent), CornerSizeKt.CornerSize(bottomEndPercent), CornerSizeKt.CornerSize(bottomStartPercent));
        return roundedCornerShape;
    }

    public static final androidx.compose.foundation.shape.RoundedCornerShape RoundedCornerShape(androidx.compose.foundation.shape.CornerSize corner) {
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(corner, corner, corner, corner);
        return roundedCornerShape;
    }

    public static androidx.compose.foundation.shape.RoundedCornerShape RoundedCornerShape$default(float f, float f2, float f3, float f4, int i5, Object object6) {
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
        return RoundedCornerShapeKt.RoundedCornerShape(obj1, obj2, obj3, obj4);
    }

    public static androidx.compose.foundation.shape.RoundedCornerShape RoundedCornerShape$default(int i, int i2, int i3, int i4, int i5, Object object6) {
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
        return RoundedCornerShapeKt.RoundedCornerShape(obj1, obj2, obj3, obj4);
    }

    public static final androidx.compose.foundation.shape.RoundedCornerShape RoundedCornerShape-0680j_4(float size) {
        return RoundedCornerShapeKt.RoundedCornerShape(CornerSizeKt.CornerSize-0680j_4(size));
    }

    public static final androidx.compose.foundation.shape.RoundedCornerShape RoundedCornerShape-a9UjIt4(float topStart, float topEnd, float bottomEnd, float bottomStart) {
        RoundedCornerShape roundedCornerShape = new RoundedCornerShape(CornerSizeKt.CornerSize-0680j_4(topStart), CornerSizeKt.CornerSize-0680j_4(topEnd), CornerSizeKt.CornerSize-0680j_4(bottomEnd), CornerSizeKt.CornerSize-0680j_4(bottomStart));
        return roundedCornerShape;
    }

    public static androidx.compose.foundation.shape.RoundedCornerShape RoundedCornerShape-a9UjIt4$default(float f, float f2, float f3, float f4, int i5, Object object6) {
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
        return RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(obj1, obj2, obj3, obj4);
    }

    public static final androidx.compose.foundation.shape.RoundedCornerShape getCircleShape() {
        return RoundedCornerShapeKt.CircleShape;
    }
}
