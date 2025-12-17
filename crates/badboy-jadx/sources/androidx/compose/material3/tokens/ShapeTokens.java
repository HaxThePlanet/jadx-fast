package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0006¨\u0006\u001d", d2 = {"Landroidx/compose/material3/tokens/ShapeTokens;", "", "()V", "CornerExtraLarge", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getCornerExtraLarge", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "CornerExtraLargeTop", "getCornerExtraLargeTop", "CornerExtraSmall", "getCornerExtraSmall", "CornerExtraSmallTop", "getCornerExtraSmallTop", "CornerFull", "getCornerFull", "CornerLarge", "getCornerLarge", "CornerLargeEnd", "getCornerLargeEnd", "CornerLargeTop", "getCornerLargeTop", "CornerMedium", "getCornerMedium", "CornerNone", "Landroidx/compose/ui/graphics/Shape;", "getCornerNone", "()Landroidx/compose/ui/graphics/Shape;", "CornerSmall", "getCornerSmall", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ShapeTokens {

    public static final int $stable;
    private static final RoundedCornerShape CornerExtraLarge;
    private static final RoundedCornerShape CornerExtraLargeTop;
    private static final RoundedCornerShape CornerExtraSmall;
    private static final RoundedCornerShape CornerExtraSmallTop;
    private static final RoundedCornerShape CornerFull;
    private static final RoundedCornerShape CornerLarge;
    private static final RoundedCornerShape CornerLargeEnd;
    private static final RoundedCornerShape CornerLargeTop;
    private static final RoundedCornerShape CornerMedium;
    private static final Shape CornerNone;
    private static final RoundedCornerShape CornerSmall;
    public static final androidx.compose.material3.tokens.ShapeTokens INSTANCE;
    static {
        ShapeTokens shapeTokens = new ShapeTokens();
        ShapeTokens.INSTANCE = shapeTokens;
        int i2 = 0;
        ShapeTokens.CornerExtraLarge = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)l));
        int i3 = 0;
        int i14 = 0;
        int i22 = 0;
        int i26 = 0;
        ShapeTokens.CornerExtraLargeTop = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl((float)l2), Dp.constructor-impl((float)l9), Dp.constructor-impl((float)i4), Dp.constructor-impl((float)i15));
        int i5 = 0;
        ShapeTokens.CornerExtraSmall = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)l3));
        int i6 = 0;
        int i16 = 0;
        int i23 = 0;
        int i27 = 0;
        ShapeTokens.CornerExtraSmallTop = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl((float)l4), Dp.constructor-impl((float)l10), Dp.constructor-impl((float)i7), Dp.constructor-impl((float)i17));
        ShapeTokens.CornerFull = RoundedCornerShapeKt.getCircleShape();
        int i8 = 0;
        ShapeTokens.CornerLarge = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)l5));
        int i9 = 0;
        int i18 = 0;
        int i24 = 0;
        int i28 = 0;
        ShapeTokens.CornerLargeEnd = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl((float)i), Dp.constructor-impl((float)l11), Dp.constructor-impl((float)l13), Dp.constructor-impl((float)i19));
        int i10 = 0;
        int i20 = 0;
        int i25 = 0;
        int i29 = 0;
        ShapeTokens.CornerLargeTop = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl((float)l6), Dp.constructor-impl((float)l12), Dp.constructor-impl((float)i11), Dp.constructor-impl((float)i21));
        int i12 = 0;
        ShapeTokens.CornerMedium = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)l7));
        ShapeTokens.CornerNone = RectangleShapeKt.getRectangleShape();
        int i13 = 0;
        ShapeTokens.CornerSmall = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)l8));
    }

    public final RoundedCornerShape getCornerExtraLarge() {
        return ShapeTokens.CornerExtraLarge;
    }

    public final RoundedCornerShape getCornerExtraLargeTop() {
        return ShapeTokens.CornerExtraLargeTop;
    }

    public final RoundedCornerShape getCornerExtraSmall() {
        return ShapeTokens.CornerExtraSmall;
    }

    public final RoundedCornerShape getCornerExtraSmallTop() {
        return ShapeTokens.CornerExtraSmallTop;
    }

    public final RoundedCornerShape getCornerFull() {
        return ShapeTokens.CornerFull;
    }

    public final RoundedCornerShape getCornerLarge() {
        return ShapeTokens.CornerLarge;
    }

    public final RoundedCornerShape getCornerLargeEnd() {
        return ShapeTokens.CornerLargeEnd;
    }

    public final RoundedCornerShape getCornerLargeTop() {
        return ShapeTokens.CornerLargeTop;
    }

    public final RoundedCornerShape getCornerMedium() {
        return ShapeTokens.CornerMedium;
    }

    public final Shape getCornerNone() {
        return ShapeTokens.CornerNone;
    }

    public final RoundedCornerShape getCornerSmall() {
        return ShapeTokens.CornerSmall;
    }
}
