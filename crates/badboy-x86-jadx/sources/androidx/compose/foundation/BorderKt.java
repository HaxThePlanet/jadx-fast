package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.PathOperation.Companion;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u001e\u0010\u000b\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u001a.\u0010\u000b\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001a0\u0010\u000b\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a\u000c\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0002\u001a>\u0010\u001d\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$\u001a\u001e\u0010%\u001a\u00020&*\u00020&2\u0006\u0010'\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006*", d2 = {"createInsetRoundedRect", "Landroidx/compose/ui/geometry/RoundRect;", "widthPx", "", "roundedRect", "createRoundRectPath", "Landroidx/compose/ui/graphics/Path;", "targetPath", "strokeWidth", "fillArea", "", "border", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/BorderStroke;", "shape", "Landroidx/compose/ui/graphics/Shape;", "width", "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "border-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "border-xT4_qwU", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "drawContentWithoutBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "drawRectBorder", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "strokeWidthPx", "drawRectBorder-NsqcLGU", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;JJZF)Landroidx/compose/ui/draw/DrawResult;", "shrink", "Landroidx/compose/ui/geometry/CornerRadius;", "value", "shrink-Kibmq7A", "(JF)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BorderKt {
    public static final Path access$createRoundRectPath(Path targetPath, RoundRect roundedRect, float strokeWidth, boolean fillArea) {
        return BorderKt.createRoundRectPath(targetPath, roundedRect, strokeWidth, fillArea);
    }

    public static final DrawResult access$drawContentWithoutBorder(CacheDrawScope $receiver) {
        return BorderKt.drawContentWithoutBorder($receiver);
    }

    public static final DrawResult access$drawRectBorder-NsqcLGU(CacheDrawScope $receiver, Brush brush, long topLeft, long borderSize, boolean fillArea, float strokeWidthPx) {
        return BorderKt.drawRectBorder-NsqcLGU($receiver, brush, topLeft, borderSize, fillArea, strokeWidthPx);
    }

    public static final long access$shrink-Kibmq7A(long $receiver, float value) {
        return BorderKt.shrink-Kibmq7A($receiver, value);
    }

    public static final Modifier border(Modifier $this$border, androidx.compose.foundation.BorderStroke border, Shape shape) {
        return BorderKt.border-ziNgDLE($this$border, border.getWidth-D9Ej5fM(), border.getBrush(), shape);
    }

    public static Modifier border$default(Modifier modifier, androidx.compose.foundation.BorderStroke borderStroke2, Shape shape3, int i4, Object object5) {
        Shape obj2;
        if (i4 &= 2 != 0) {
            obj2 = RectangleShapeKt.getRectangleShape();
        }
        return BorderKt.border(modifier, borderStroke2, obj2);
    }

    public static final Modifier border-xT4_qwU(Modifier $this$border_u2dxT4_qwU, float width, long color, Shape shape) {
        SolidColor solidColor = new SolidColor(color, shape, 0);
        return BorderKt.border-ziNgDLE($this$border_u2dxT4_qwU, width, (Brush)solidColor, obj6);
    }

    public static Modifier border-xT4_qwU$default(Modifier modifier, float f2, long l3, Shape shape4, int i5, Object object6) {
        Shape obj4;
        if (object6 &= 4 != 0) {
            obj4 = RectangleShapeKt.getRectangleShape();
        }
        return BorderKt.border-xT4_qwU(modifier, f2, l3, shape4);
    }

    public static final Modifier border-ziNgDLE(Modifier $this$border_u2dziNgDLE, float width, Brush brush, Shape shape) {
        BorderModifierNodeElement borderModifierNodeElement = new BorderModifierNodeElement(width, brush, shape, 0);
        return $this$border_u2dziNgDLE.then((Modifier)borderModifierNodeElement);
    }

    private static final RoundRect createInsetRoundedRect(float widthPx, RoundRect roundedRect) {
        RoundRect roundRect = new RoundRect(widthPx, widthPx, width - widthPx, height - widthPx, BorderKt.shrink-Kibmq7A(roundedRect.getTopLeftCornerRadius-kKHJgLs(), obj6), obj6, BorderKt.shrink-Kibmq7A(roundedRect.getTopRightCornerRadius-kKHJgLs(), obj8), obj8, BorderKt.shrink-Kibmq7A(roundedRect.getBottomRightCornerRadius-kKHJgLs(), obj10), obj10, BorderKt.shrink-Kibmq7A(roundedRect.getBottomLeftCornerRadius-kKHJgLs(), obj10), obj12, 0);
        return roundRect;
    }

    private static final Path createRoundRectPath(Path targetPath, RoundRect roundedRect, float strokeWidth, boolean fillArea) {
        int difference-b3I0S0c;
        Path path;
        Path path2;
        int i;
        RoundRect insetRoundedRect;
        final Path path3 = targetPath;
        final int i2 = 0;
        path3.reset();
        difference-b3I0S0c = 0;
        final int i3 = 2;
        Path.addRoundRect$default(path3, roundedRect, difference-b3I0S0c, i3, difference-b3I0S0c);
        if (!fillArea) {
            path = AndroidPath_androidKt.Path();
            i = 0;
            Path.addRoundRect$default(path, BorderKt.createInsetRoundedRect(strokeWidth, roundedRect), difference-b3I0S0c, i3, difference-b3I0S0c);
            path3.op-N5in7k0(path3, path, PathOperation.Companion.getDifference-b3I0S0c());
        }
        return targetPath;
    }

    private static final DrawResult drawContentWithoutBorder(CacheDrawScope $this$drawContentWithoutBorder) {
        return $this$drawContentWithoutBorder.onDrawWithContent((Function1)BorderKt.drawContentWithoutBorder.1.INSTANCE);
    }

    private static final DrawResult drawRectBorder-NsqcLGU(CacheDrawScope $this$drawRectBorder_u2dNsqcLGU, Brush brush, long topLeft, long borderSize, boolean fillArea, float strokeWidthPx) {
        long size-NH-jbRc;
        androidx.compose.ui.graphics.drawscope.DrawStyle iNSTANCE;
        long l;
        Stroke stroke;
        float f;
        int i3;
        int i4;
        int i6;
        int i;
        int i5;
        int i2;
        if (obj22 != null) {
            size-NH-jbRc = Offset.Companion.getZero-F1C5BW0();
        } else {
            size-NH-jbRc = topLeft;
        }
        if (obj22 != null) {
            l = size-NH-jbRc;
        } else {
            l = fillArea;
        }
        if (obj22 != null) {
            iNSTANCE = Fill.INSTANCE;
        } else {
            stroke = new Stroke(obj23, 0, 0, 0, 0, 30, 0);
            iNSTANCE = stroke;
        }
        BorderKt.drawRectBorder.1 anon = new BorderKt.drawRectBorder.1(brush, size-NH-jbRc, obj5, l, obj7, iNSTANCE);
        return $this$drawRectBorder_u2dNsqcLGU.onDrawWithContent((Function1)anon);
    }

    private static final long shrink-Kibmq7A(long $this$shrink_u2dKibmq7A, float value) {
        int i2 = 0;
        return CornerRadiusKt.CornerRadius(Math.max(i2, x-impl -= obj5), Math.max(i2, y-impl -= obj5));
    }
}
