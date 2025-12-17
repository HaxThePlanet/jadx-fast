package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ClipOp.Companion;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aB\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000b\u001ab\u0010\u000c\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013\u001aP\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001e\u001a\\\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"\u001a!\u0010#\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0008H\u0086\u0008\u001a.\u0010$\u001a\u00020\u0001*\u00020\u00022\u0006\u0010$\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0086\u0008\u001a:\u0010$\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010%\u001a\u00020\u000e2\u0008\u0008\u0002\u0010&\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0086\u0008\u001aF\u0010$\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0086\u0008\u001aB\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010(\u001a\u00020\u000e2\u0008\u0008\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,\u001aB\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010.\u001a\u00020\u000e2\u0008\u0008\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008/\u0010,\u001aB\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u00100\u001a\u00020\u000e2\u0008\u0008\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u00081\u0010,\u001aJ\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e2\u0008\u0008\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u00084\u00105\u001a:\u00106\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0086\u0008\u001a?\u00107\u001a\u00020\u0001*\u00020\u00022\u0017\u00108\u001a\u0013\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\t2\u0017\u0010:\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0008¢\u0006\u0002\u0008\tH\u0086\u0008\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006;", d2 = {"clipPath", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipPath-KD09W0M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;ILkotlin/jvm/functions/Function1;)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-rOu3jXo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFILkotlin/jvm/functions/Function1;)V", "draw", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "draw-GRGpd60", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw-ymL40Pk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/jvm/functions/Function1;)V", "drawIntoCanvas", "inset", "horizontal", "vertical", "rotate", "degrees", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotate-Rg1IO4c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJLkotlin/jvm/functions/Function1;)V", "rotateRad", "radians", "rotateRad-Rg1IO4c", "scale", "scale-Rg1IO4c", "scaleX", "scaleY", "scale-Fgt4K4Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLkotlin/jvm/functions/Function1;)V", "translate", "withTransform", "transformBlock", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "drawBlock", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DrawScopeKt {
    public static final void clipPath-KD09W0M(androidx.compose.ui.graphics.drawscope.DrawScope $this$clipPath_u2dKD09W0M, Path path, int clipOp, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        final int i = 0;
        final Object obj = $this$clipPath_u2dKD09W0M;
        final int i2 = 0;
        final androidx.compose.ui.graphics.drawscope.DrawContext drawContext = obj.getDrawContext();
        final int i3 = 0;
        drawContext.getCanvas().save();
        final int i4 = 0;
        drawContext.getTransform().clipPath-mtrdD-E(path, clipOp);
        block.invoke(obj);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public static void clipPath-KD09W0M$default(androidx.compose.ui.graphics.drawscope.DrawScope $this$clipPath_u2dKD09W0M_u24default, Path path, int clipOp, Function1 block, int i5, Object object6) {
        int obj9;
        int obj11;
        if (i5 &= 2 != 0) {
            obj9 = ClipOp.Companion.getIntersect-rtfAjoo();
        }
        obj11 = 0;
        final Object obj12 = $this$clipPath_u2dKD09W0M_u24default;
        final int i = 0;
        final androidx.compose.ui.graphics.drawscope.DrawContext drawContext = obj12.getDrawContext();
        final int i2 = 0;
        drawContext.getCanvas().save();
        final int i3 = 0;
        drawContext.getTransform().clipPath-mtrdD-E(path, obj9);
        block.invoke(obj12);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public static final void clipRect-rOu3jXo(androidx.compose.ui.graphics.drawscope.DrawScope $this$clipRect_u2drOu3jXo, float left, float top, float right, float bottom, int clipOp, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        Object obj2;
        final int i2 = 0;
        final Object obj = $this$clipRect_u2drOu3jXo;
        final int i3 = 0;
        final androidx.compose.ui.graphics.drawscope.DrawContext drawContext = obj.getDrawContext();
        final int i4 = 0;
        drawContext.getCanvas().save();
        int i = 0;
        drawContext.getTransform().clipRect-N_I0leg(left, top, right, bottom, clipOp);
        block.invoke(obj);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public static void clipRect-rOu3jXo$default(androidx.compose.ui.graphics.drawscope.DrawScope $this$clipRect_u2drOu3jXo_u24default, float left, float top, float right, float bottom, int clipOp, Function1 block, int i8, Object object9) {
        int i2;
        int i3;
        float f2;
        float f;
        int i;
        int obj8;
        int obj9;
        float obj10;
        float obj11;
        int obj12;
        final int obj15 = i8 & 1;
        i2 = obj15 != null ? obj8 : left;
        i3 = i8 & 2 != 0 ? obj9 : top;
        if (i8 & 4 != 0) {
            f2 = obj10;
        } else {
            f2 = right;
        }
        if (i8 & 8 != 0) {
            f = obj11;
        } else {
            f = bottom;
        }
        if (i8 & 16 != 0) {
            i = obj12;
        } else {
            i = clipOp;
        }
        obj8 = 0;
        obj9 = $this$clipRect_u2drOu3jXo_u24default;
        obj10 = 0;
        obj11 = obj9.getDrawContext();
        obj12 = 0;
        obj11.getCanvas().save();
        final int i4 = 0;
        obj11.getTransform().clipRect-N_I0leg(i2, i3, f2, f, i);
        block.invoke(obj9);
        obj11.getCanvas().restore();
        obj11.setSize-uvyYCjk(obj11.getSize-NH-jbRc());
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use a new overload accepting nullable GraphicsLayer")
    public static final void draw-GRGpd60(androidx.compose.ui.graphics.drawscope.DrawScope $this$draw_u2dGRGpd60, Density density, LayoutDirection layoutDirection, Canvas canvas, long size, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        final int i2 = 0;
        final Object obj = $this$draw_u2dGRGpd60;
        final int i4 = 0;
        androidx.compose.ui.graphics.drawscope.DrawContext drawContext7 = obj.getDrawContext();
        final Density density3 = density;
        drawContext7.setDensity(density3);
        drawContext7.setLayoutDirection(layoutDirection);
        final Canvas canvas3 = canvas;
        drawContext7.setCanvas(canvas3);
        int i6 = i5;
        drawContext7.setSize-uvyYCjk(size);
        drawContext7.setGraphicsLayer(0);
        canvas3.save();
        obj24.invoke(obj);
        canvas3.restore();
        androidx.compose.ui.graphics.drawscope.DrawContext drawContext8 = obj.getDrawContext();
        final int i7 = 0;
        drawContext8.setDensity(obj.getDrawContext().getDensity());
        drawContext8.setLayoutDirection(obj.getDrawContext().getLayoutDirection());
        drawContext8.setCanvas(obj.getDrawContext().getCanvas());
        drawContext8.setSize-uvyYCjk(obj.getDrawContext().getSize-NH-jbRc());
        drawContext8.setGraphicsLayer(obj.getDrawContext().getGraphicsLayer());
    }

    public static final void draw-ymL40Pk(androidx.compose.ui.graphics.drawscope.DrawScope $this$draw_u2dymL40Pk, Density density, LayoutDirection layoutDirection, Canvas canvas, long size, GraphicsLayer graphicsLayer, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        final int i = 0;
        androidx.compose.ui.graphics.drawscope.DrawContext drawContext7 = $this$draw_u2dymL40Pk.getDrawContext();
        int i2 = 0;
        drawContext7.setDensity(density);
        drawContext7.setLayoutDirection(layoutDirection);
        final Canvas canvas3 = canvas;
        drawContext7.setCanvas(canvas3);
        drawContext7.setSize-uvyYCjk(size);
        drawContext7.setGraphicsLayer(block);
        canvas3.save();
        Object obj = $this$draw_u2dymL40Pk;
        obj25.invoke(obj);
        canvas3.restore();
        androidx.compose.ui.graphics.drawscope.DrawContext drawContext8 = obj.getDrawContext();
        final int i3 = 0;
        drawContext8.setDensity($this$draw_u2dymL40Pk.getDrawContext().getDensity());
        drawContext8.setLayoutDirection($this$draw_u2dymL40Pk.getDrawContext().getLayoutDirection());
        drawContext8.setCanvas($this$draw_u2dymL40Pk.getDrawContext().getCanvas());
        drawContext8.setSize-uvyYCjk($this$draw_u2dymL40Pk.getDrawContext().getSize-NH-jbRc());
        drawContext8.setGraphicsLayer($this$draw_u2dymL40Pk.getDrawContext().getGraphicsLayer());
    }

    public static void draw-ymL40Pk$default(androidx.compose.ui.graphics.drawscope.DrawScope $this$draw_u2dymL40Pk_u24default, Density density, LayoutDirection layoutDirection, Canvas canvas, long size, GraphicsLayer graphicsLayer, Function1 block, int i8, Object object9) {
        int i;
        int i2;
        i2 = object9 & 16 != 0 ? i : block;
        final int i3 = 0;
        androidx.compose.ui.graphics.drawscope.DrawContext drawContext7 = $this$draw_u2dymL40Pk_u24default.getDrawContext();
        int i4 = 0;
        drawContext7.setDensity(density);
        drawContext7.setLayoutDirection(layoutDirection);
        final Canvas canvas3 = canvas;
        drawContext7.setCanvas(canvas3);
        drawContext7.setSize-uvyYCjk(size);
        drawContext7.setGraphicsLayer(i2);
        canvas3.save();
        Object obj = $this$draw_u2dymL40Pk_u24default;
        i8.invoke(obj);
        canvas3.restore();
        androidx.compose.ui.graphics.drawscope.DrawContext drawContext8 = obj.getDrawContext();
        final int i6 = 0;
        drawContext8.setDensity($this$draw_u2dymL40Pk_u24default.getDrawContext().getDensity());
        drawContext8.setLayoutDirection($this$draw_u2dymL40Pk_u24default.getDrawContext().getLayoutDirection());
        drawContext8.setCanvas($this$draw_u2dymL40Pk_u24default.getDrawContext().getCanvas());
        drawContext8.setSize-uvyYCjk($this$draw_u2dymL40Pk_u24default.getDrawContext().getSize-NH-jbRc());
        drawContext8.setGraphicsLayer($this$draw_u2dymL40Pk_u24default.getDrawContext().getGraphicsLayer());
    }

    public static final void drawIntoCanvas(androidx.compose.ui.graphics.drawscope.DrawScope $this$drawIntoCanvas, Function1<? super Canvas, Unit> block) {
        final int i = 0;
        block.invoke($this$drawIntoCanvas.getDrawContext().getCanvas());
    }

    public static final void inset(androidx.compose.ui.graphics.drawscope.DrawScope $this$inset, float left, float top, float right, float bottom, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        final int i = 0;
        $this$inset.getDrawContext().getTransform().inset(left, top, right, bottom);
        block.invoke($this$inset);
        $this$inset.getDrawContext().getTransform().inset(-left, -top, -right, -bottom);
    }

    public static final void inset(androidx.compose.ui.graphics.drawscope.DrawScope $this$inset, float horizontal, float vertical, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        final int i = 0;
        final Object obj = $this$inset;
        final int i2 = 0;
        obj.getDrawContext().getTransform().inset(horizontal, vertical, horizontal, vertical);
        block.invoke(obj);
        obj.getDrawContext().getTransform().inset(-horizontal, -vertical, -horizontal, -vertical);
    }

    public static final void inset(androidx.compose.ui.graphics.drawscope.DrawScope $this$inset, float inset, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        final int i = 0;
        $this$inset.getDrawContext().getTransform().inset(inset, inset, inset, inset);
        block.invoke($this$inset);
        $this$inset.getDrawContext().getTransform().inset(-inset, -inset, -inset, -inset);
    }

    public static void inset$default(androidx.compose.ui.graphics.drawscope.DrawScope $this$inset_u24default, float horizontal, float vertical, Function1 block, int i5, Object object6) {
        int obj8;
        int obj9;
        if (i5 & 1 != 0) {
            obj8 = 0;
        }
        if (i5 &= 2 != 0) {
            obj9 = 0;
        }
        int obj11 = 0;
        Object obj12 = $this$inset_u24default;
        final int i = 0;
        obj12.getDrawContext().getTransform().inset(obj8, obj9, obj8, obj9);
        block.invoke(obj12);
        obj12.getDrawContext().getTransform().inset(-obj8, -obj9, -obj8, -obj9);
    }

    public static final void rotate-Rg1IO4c(androidx.compose.ui.graphics.drawscope.DrawScope $this$rotate_u2dRg1IO4c, float degrees, long pivot, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        final int i = 0;
        final Object obj = $this$rotate_u2dRg1IO4c;
        final int i2 = 0;
        final androidx.compose.ui.graphics.drawscope.DrawContext drawContext = obj.getDrawContext();
        final int i3 = 0;
        drawContext.getCanvas().save();
        final int i4 = 0;
        drawContext.getTransform().rotate-Uv8p0NA(degrees, pivot);
        obj13.invoke(obj);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public static void rotate-Rg1IO4c$default(androidx.compose.ui.graphics.drawscope.DrawScope $this$rotate_u2dRg1IO4c_u24default, float degrees, long pivot, Function1 block, int i5, Object object6) {
        long obj9;
        if (object6 &= 2 != 0) {
            obj9 = $this$rotate_u2dRg1IO4c_u24default.getCenter-F1C5BW0();
        }
        int obj12 = 0;
        final Object obj13 = $this$rotate_u2dRg1IO4c_u24default;
        final int i = 0;
        final androidx.compose.ui.graphics.drawscope.DrawContext drawContext = obj13.getDrawContext();
        final int i2 = 0;
        drawContext.getCanvas().save();
        final int i3 = 0;
        drawContext.getTransform().rotate-Uv8p0NA(degrees, obj9);
        i5.invoke(obj13);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public static final void rotateRad-Rg1IO4c(androidx.compose.ui.graphics.drawscope.DrawScope $this$rotateRad_u2dRg1IO4c, float radians, long pivot, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        final int i = 0;
        final Object obj = $this$rotateRad_u2dRg1IO4c;
        final int i2 = 0;
        final androidx.compose.ui.graphics.drawscope.DrawContext drawContext = obj.getDrawContext();
        final int i3 = 0;
        drawContext.getCanvas().save();
        final int i4 = 0;
        drawContext.getTransform().rotate-Uv8p0NA(DegreesKt.degrees(radians), pivot);
        obj14.invoke(obj);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public static void rotateRad-Rg1IO4c$default(androidx.compose.ui.graphics.drawscope.DrawScope $this$rotateRad_u2dRg1IO4c_u24default, float radians, long pivot, Function1 block, int i5, Object object6) {
        long obj10;
        if (object6 &= 2 != 0) {
            obj10 = $this$rotateRad_u2dRg1IO4c_u24default.getCenter-F1C5BW0();
        }
        int obj13 = 0;
        final Object obj14 = $this$rotateRad_u2dRg1IO4c_u24default;
        final int i = 0;
        final androidx.compose.ui.graphics.drawscope.DrawContext drawContext = obj14.getDrawContext();
        final int i2 = 0;
        drawContext.getCanvas().save();
        final int i3 = 0;
        drawContext.getTransform().rotate-Uv8p0NA(DegreesKt.degrees(radians), obj10);
        i5.invoke(obj14);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public static final void scale-Fgt4K4Q(androidx.compose.ui.graphics.drawscope.DrawScope $this$scale_u2dFgt4K4Q, float scaleX, float scaleY, long pivot, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        final int i = 0;
        final Object obj = $this$scale_u2dFgt4K4Q;
        final int i2 = 0;
        final androidx.compose.ui.graphics.drawscope.DrawContext drawContext = obj.getDrawContext();
        final int i3 = 0;
        drawContext.getCanvas().save();
        final int i4 = 0;
        drawContext.getTransform().scale-0AR0LA0(scaleX, scaleY, pivot);
        obj14.invoke(obj);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public static void scale-Fgt4K4Q$default(androidx.compose.ui.graphics.drawscope.DrawScope $this$scale_u2dFgt4K4Q_u24default, float scaleX, float scaleY, long pivot, Function1 block, int i6, Object object7) {
        long obj10;
        if (object7 &= 4 != 0) {
            obj10 = $this$scale_u2dFgt4K4Q_u24default.getCenter-F1C5BW0();
        }
        int obj13 = 0;
        final Object obj14 = $this$scale_u2dFgt4K4Q_u24default;
        final int i = 0;
        final androidx.compose.ui.graphics.drawscope.DrawContext drawContext = obj14.getDrawContext();
        final int i2 = 0;
        drawContext.getCanvas().save();
        final int i3 = 0;
        drawContext.getTransform().scale-0AR0LA0(scaleX, scaleY, obj10);
        i6.invoke(obj14);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public static final void scale-Rg1IO4c(androidx.compose.ui.graphics.drawscope.DrawScope $this$scale_u2dRg1IO4c, float scale, long pivot, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        final int i = 0;
        final Object obj = $this$scale_u2dRg1IO4c;
        final int i2 = 0;
        final androidx.compose.ui.graphics.drawscope.DrawContext drawContext = obj.getDrawContext();
        final int i3 = 0;
        drawContext.getCanvas().save();
        final int i4 = 0;
        drawContext.getTransform().scale-0AR0LA0(scale, scale, pivot);
        obj13.invoke(obj);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public static void scale-Rg1IO4c$default(androidx.compose.ui.graphics.drawscope.DrawScope $this$scale_u2dRg1IO4c_u24default, float scale, long pivot, Function1 block, int i5, Object object6) {
        long obj9;
        if (object6 &= 2 != 0) {
            obj9 = $this$scale_u2dRg1IO4c_u24default.getCenter-F1C5BW0();
        }
        int obj12 = 0;
        final Object obj13 = $this$scale_u2dRg1IO4c_u24default;
        final int i = 0;
        final androidx.compose.ui.graphics.drawscope.DrawContext drawContext = obj13.getDrawContext();
        final int i2 = 0;
        drawContext.getCanvas().save();
        final int i3 = 0;
        drawContext.getTransform().scale-0AR0LA0(scale, scale, obj9);
        i5.invoke(obj13);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public static final void translate(androidx.compose.ui.graphics.drawscope.DrawScope $this$translate, float left, float top, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> block) {
        final int i = 0;
        $this$translate.getDrawContext().getTransform().translate(left, top);
        block.invoke($this$translate);
        $this$translate.getDrawContext().getTransform().translate(-left, -top);
    }

    public static void translate$default(androidx.compose.ui.graphics.drawscope.DrawScope $this$translate_u24default, float left, float top, Function1 block, int i5, Object object6) {
        int obj4;
        int obj5;
        if (i5 & 1 != 0) {
            obj4 = 0;
        }
        if (i5 &= 2 != 0) {
            obj5 = 0;
        }
        int obj7 = 0;
        $this$translate_u24default.getDrawContext().getTransform().translate(obj4, obj5);
        block.invoke($this$translate_u24default);
        $this$translate_u24default.getDrawContext().getTransform().translate(-obj4, -obj5);
    }

    public static final void withTransform(androidx.compose.ui.graphics.drawscope.DrawScope $this$withTransform, Function1<? super androidx.compose.ui.graphics.drawscope.DrawTransform, Unit> transformBlock, Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, Unit> drawBlock) {
        final int i = 0;
        final androidx.compose.ui.graphics.drawscope.DrawContext drawContext = $this$withTransform.getDrawContext();
        final int i2 = 0;
        drawContext.getCanvas().save();
        transformBlock.invoke(drawContext.getTransform());
        drawBlock.invoke($this$withTransform);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }
}
