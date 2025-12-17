package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\t\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000e\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000f", d2 = {"shadow", "Landroidx/compose/ui/Modifier;", "elevation", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "shadow-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "ambientColor", "Landroidx/compose/ui/graphics/Color;", "spotColor", "shadow-s4CzXII", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;ZJJ)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ShadowKt {
    public static final Modifier shadow-s4CzXII(Modifier $this$shadow_u2ds4CzXII, float elevation, Shape shape, boolean clip, long ambientColor, long spotColor) {
        Modifier then;
        int shadowGraphicsLayerElement;
        float f;
        Shape shape2;
        boolean z;
        long l;
        kotlin.jvm.internal.DefaultConstructorMarker constructor;
        int i;
        shadowGraphicsLayerElement = 0;
        if (Dp.compareTo-0680j_4(elevation, Dp.constructor-impl((float)i2)) <= 0) {
            if (clip) {
                shadowGraphicsLayerElement = new ShadowGraphicsLayerElement(elevation, shape, clip, ambientColor, obj6, obj16, obj8, 0);
                then = $this$shadow_u2ds4CzXII.then((Modifier)shadowGraphicsLayerElement);
            } else {
                then = $this$shadow_u2ds4CzXII;
            }
        } else {
        }
        return then;
    }

    public static Modifier shadow-s4CzXII$default(Modifier modifier, float f2, Shape shape3, boolean z4, long l5, long l6, int i7, Object object8) {
        Shape rectangleShape;
        int i;
        int i2;
        float f;
        long defaultShadowColor;
        long defaultShadowColor2;
        if (obj15 & 2 != 0) {
            rectangleShape = RectangleShapeKt.getRectangleShape();
        } else {
            rectangleShape = shape3;
        }
        if (obj15 & 4 != 0) {
            i2 = 0;
            i = Dp.compareTo-0680j_4(f2, Dp.constructor-impl((float)i5)) > 0 ? 1 : 0;
        } else {
            i = z4;
        }
        if (obj15 & 8 != 0) {
            defaultShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
        } else {
            defaultShadowColor = l5;
        }
        if (obj15 & 16 != 0) {
            defaultShadowColor2 = GraphicsLayerScopeKt.getDefaultShadowColor();
        } else {
            defaultShadowColor2 = i7;
        }
        return ShadowKt.shadow-s4CzXII(modifier, f2, rectangleShape, i, defaultShadowColor, object8);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with shadow which accepts ambientColor and spotColor parameters", replaceWith = @ReplaceWith(...))
    public static final Modifier shadow-ziNgDLE(Modifier $this$shadow_u2dziNgDLE, float elevation, Shape shape, boolean clip) {
        return ShadowKt.shadow-s4CzXII($this$shadow_u2dziNgDLE, elevation, shape, clip, GraphicsLayerScopeKt.getDefaultShadowColor(), obj5);
    }

    public static Modifier shadow-ziNgDLE$default(Modifier modifier, float f2, Shape shape3, boolean z4, int i5, Object object6) {
        Shape obj2;
        int obj3;
        int obj4;
        int obj5;
        if (i5 & 2 != 0) {
            obj2 = RectangleShapeKt.getRectangleShape();
        }
        if (i5 &= 4 != 0) {
            obj4 = 0;
            obj3 = Dp.compareTo-0680j_4(f2, Dp.constructor-impl((float)obj3)) > 0 ? 1 : 0;
        }
        return ShadowKt.shadow-ziNgDLE(modifier, f2, obj2, obj3);
    }
}
