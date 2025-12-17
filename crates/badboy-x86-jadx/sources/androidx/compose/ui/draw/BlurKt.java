package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.graphics.TileMode.Companion;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000c", d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radius", "Landroidx/compose/ui/unit/Dp;", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radiusX", "radiusY", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BlurKt {
    public static final Modifier blur-1fqS-gw(Modifier $this$blur_u2d1fqS_u2dgw, float radiusX, float radiusY, Shape edgeTreatment) {
        int clip;
        int compareTo-0680j_4;
        int tileMode;
        int i3;
        TileMode.Companion companion;
        float anon;
        float radiusX2;
        float f;
        int i;
        Shape shape;
        int i2;
        Modifier obj9;
        int i4 = 0;
        int i6 = 0;
        if (edgeTreatment != null) {
            i2 = clip;
            i = tileMode;
        } else {
            i2 = clip;
            i = tileMode;
        }
        i3 = 0;
        if (Dp.compareTo-0680j_4(radiusX, Dp.constructor-impl((float)clip2)) > 0) {
            i3 = 0;
            if (Dp.compareTo-0680j_4(radiusY, Dp.constructor-impl((float)i5)) <= 0) {
                if (i2 != 0) {
                    anon = new BlurKt.blur.1(radiusX, radiusY, i, edgeTreatment, i2);
                    obj9 = GraphicsLayerModifierKt.graphicsLayer($this$blur_u2d1fqS_u2dgw, (Function1)anon);
                } else {
                    radiusX2 = radiusX;
                    f = radiusY;
                    shape = edgeTreatment;
                    obj9 = $this$blur_u2d1fqS_u2dgw;
                }
            } else {
            }
        } else {
        }
        return obj9;
    }

    public static Modifier blur-1fqS-gw$default(Modifier modifier, float f2, float f3, androidx.compose.ui.draw.BlurredEdgeTreatment blurredEdgeTreatment4, int i5, Object object6) {
        androidx.compose.ui.draw.BlurredEdgeTreatment obj3;
        if (i5 &= 4 != 0) {
            obj3 = BlurredEdgeTreatment.box-impl(BlurredEdgeTreatment.Companion.getRectangle---Goahg());
        }
        return BlurKt.blur-1fqS-gw(modifier, f2, f3, obj3.unbox-impl());
    }

    public static final Modifier blur-F8QBwvs(Modifier $this$blur_u2dF8QBwvs, float radius, Shape edgeTreatment) {
        return BlurKt.blur-1fqS-gw($this$blur_u2dF8QBwvs, radius, radius, edgeTreatment);
    }

    public static Modifier blur-F8QBwvs$default(Modifier modifier, float f2, androidx.compose.ui.draw.BlurredEdgeTreatment blurredEdgeTreatment3, int i4, Object object5) {
        androidx.compose.ui.draw.BlurredEdgeTreatment obj2;
        if (i4 &= 2 != 0) {
            obj2 = BlurredEdgeTreatment.box-impl(BlurredEdgeTreatment.Companion.getRectangle---Goahg());
        }
        return BlurKt.blur-F8QBwvs(modifier, f2, obj2.unbox-impl());
    }
}
