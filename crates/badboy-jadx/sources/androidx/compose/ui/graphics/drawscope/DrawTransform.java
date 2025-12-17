package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ClipOp.Companion;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;

/* loaded from: classes.dex */
@DrawScopeMarker
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008g\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010JD\u0010\u0011\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00132\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eH&ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J(\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H&J$\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eJ,\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#J\u001a\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&H&ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(J\u001c\u0010)\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0013H&R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006*À\u0006\u0003", d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "inset", "rotate", "degrees", "pivot", "rotate-Uv8p0NA", "(FJ)V", "scale", "scaleX", "scaleY", "scale-0AR0LA0", "(FFJ)V", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "translate", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DrawTransform {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void clipPath-mtrdD-E$default(androidx.compose.ui.graphics.drawscope.DrawTransform drawTransform, Path path2, int i3, int i4, Object object5) {
            DrawTransform.clipPath-mtrdD-E$default(drawTransform, path2, i3, i4, object5);
        }

        public static void clipRect-N_I0leg$default(androidx.compose.ui.graphics.drawscope.DrawTransform drawTransform, float f2, float f3, float f4, float f5, int i6, int i7, Object object8) {
            DrawTransform.clipRect-N_I0leg$default(drawTransform, f2, f3, f4, f5, i6, i7, object8);
        }

        @Deprecated
        public static long getCenter-F1C5BW0(androidx.compose.ui.graphics.drawscope.DrawTransform $this) {
            return DrawTransform.access$getCenter-F1C5BW0$jd($this);
        }

        public static void rotate-Uv8p0NA$default(androidx.compose.ui.graphics.drawscope.DrawTransform drawTransform, float f2, long l3, int i4, Object object5) {
            DrawTransform.rotate-Uv8p0NA$default(drawTransform, f2, l3, i4, object5);
        }

        public static void scale-0AR0LA0$default(androidx.compose.ui.graphics.drawscope.DrawTransform drawTransform, float f2, float f3, long l4, int i5, Object object6) {
            DrawTransform.scale-0AR0LA0$default(drawTransform, f2, f3, l4, i5, object6);
        }

        public static void translate$default(androidx.compose.ui.graphics.drawscope.DrawTransform drawTransform, float f2, float f3, int i4, Object object5) {
            DrawTransform.translate$default(drawTransform, f2, f3, i4, object5);
        }
    }
    public static long access$getCenter-F1C5BW0$jd(androidx.compose.ui.graphics.drawscope.DrawTransform $this) {
        return super.getCenter-F1C5BW0();
    }

    public static void clipPath-mtrdD-E$default(androidx.compose.ui.graphics.drawscope.DrawTransform drawTransform, Path path2, int i3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = ClipOp.Companion.getIntersect-rtfAjoo();
            }
            drawTransform.clipPath-mtrdD-E(path2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        throw obj0;
    }

    public static void clipRect-N_I0leg$default(androidx.compose.ui.graphics.drawscope.DrawTransform drawTransform, float f2, float f3, float f4, float f5, int i6, int i7, Object object8) {
        int size-NH-jbRc;
        int obj3;
        int obj4;
        float obj5;
        float obj6;
        int obj7;
        if (object8 != null) {
        } else {
            size-NH-jbRc = 0;
            if (i7 & 1 != 0) {
                obj3 = size-NH-jbRc;
            }
            if (i7 & 2 != 0) {
                obj4 = size-NH-jbRc;
            }
            if (i7 & 4 != 0) {
                obj5 = Size.getWidth-impl(drawTransform.getSize-NH-jbRc());
            }
            if (i7 & 8 != 0) {
                obj6 = Size.getHeight-impl(drawTransform.getSize-NH-jbRc());
            }
            if (i7 &= 16 != 0) {
                obj7 = ClipOp.Companion.getIntersect-rtfAjoo();
            }
            drawTransform.clipRect-N_I0leg(obj3, obj4, obj5, obj6, obj7);
        }
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        throw obj2;
    }

    public static void rotate-Uv8p0NA$default(androidx.compose.ui.graphics.drawscope.DrawTransform drawTransform, float f2, long l3, int i4, Object object5) {
        long obj2;
        if (obj5 != null) {
        } else {
            if (object5 &= 2 != 0) {
                obj2 = drawTransform.getCenter-F1C5BW0();
            }
            drawTransform.rotate-Uv8p0NA(f2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rotate-Uv8p0NA");
        throw obj0;
    }

    public static void scale-0AR0LA0$default(androidx.compose.ui.graphics.drawscope.DrawTransform drawTransform, float f2, float f3, long l4, int i5, Object object6) {
        long obj3;
        if (obj6 != null) {
        } else {
            if (object6 &= 4 != 0) {
                obj3 = drawTransform.getCenter-F1C5BW0();
            }
            drawTransform.scale-0AR0LA0(f2, f3, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale-0AR0LA0");
        throw obj0;
    }

    public static void translate$default(androidx.compose.ui.graphics.drawscope.DrawTransform drawTransform, float f2, float f3, int i4, Object object5) {
        int obj2;
        int obj3;
        if (object5 != null) {
        } else {
            final int i = 0;
            if (i4 & 1 != 0) {
                obj2 = i;
            }
            if (i4 &= 2 != 0) {
                obj3 = i;
            }
            drawTransform.translate(obj2, obj3);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translate");
        throw obj1;
    }

    public abstract void clipPath-mtrdD-E(Path path, int i2);

    public abstract void clipRect-N_I0leg(float f, float f2, float f3, float f4, int i5);

    public long getCenter-F1C5BW0() {
        float f = (float)i2;
        return OffsetKt.Offset(width-impl /= f, height-impl /= f);
    }

    public abstract long getSize-NH-jbRc();

    public abstract void inset(float f, float f2, float f3, float f4);

    public abstract void rotate-Uv8p0NA(float f, long l2);

    public abstract void scale-0AR0LA0(float f, float f2, long l3);

    public abstract void transform-58bKbWc(float[] fArr);

    public abstract void translate(float f, float f2);
}
