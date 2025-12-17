package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000e\u0008&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J\u0012\u0010\u0017\u001a\u00020\u00152\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\n2\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u0008\u0010\u001d\u001a\u00020\u0011H\u0002J2\u0010\u001e\u001a\u00020\n*\u00020\t2\u0006\u0010\u001f\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!J\u000c\u0010\"\u001a\u00020\n*\u00020\tH$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008¢\u0006\u0002\u0008\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000c\u001a\u00020\rX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006#", d2 = {"Landroidx/compose/ui/graphics/painter/Painter;", "", "()V", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "drawLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "layerPaint", "Landroidx/compose/ui/graphics/Paint;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "useLayer", "", "applyAlpha", "applyColorFilter", "applyLayoutDirection", "configureAlpha", "configureColorFilter", "configureLayoutDirection", "rtl", "obtainPaint", "draw", "size", "draw-x_KDEd0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/ui/graphics/ColorFilter;)V", "onDraw", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Painter {

    private float alpha = 1f;
    private ColorFilter colorFilter;
    private final Function1<DrawScope, Unit> drawLambda;
    private Paint layerPaint;
    private LayoutDirection layoutDirection = 1065353216;
    private boolean useLayer;
    public Painter() {
        super();
        int i = 1065353216;
        LayoutDirection ltr = LayoutDirection.Ltr;
        Painter.drawLambda.1 anon = new Painter.drawLambda.1(this);
        this.drawLambda = (Function1)anon;
    }

    private final void configureAlpha(float alpha) {
        int alpha2;
        int layerPaint;
        int paint;
        int i;
        layerPaint = 1;
        paint = 0;
        alpha2 = Float.compare(alpha3, alpha) == 0 ? layerPaint : paint;
        if (alpha2 == 0 && !applyAlpha(alpha)) {
            if (!applyAlpha(alpha)) {
                i = Float.compare(alpha, i2) == 0 ? layerPaint : paint;
                if (i != 0) {
                    layerPaint = this.layerPaint;
                    if (layerPaint == null) {
                    } else {
                        layerPaint.setAlpha(alpha);
                    }
                    this.useLayer = paint;
                } else {
                    obtainPaint().setAlpha(alpha);
                    this.useLayer = layerPaint;
                }
            }
            this.alpha = alpha;
        }
    }

    private final void configureColorFilter(ColorFilter colorFilter) {
        boolean colorFilter2;
        int i2;
        int i;
        if (!Intrinsics.areEqual(this.colorFilter, colorFilter) && !applyColorFilter(colorFilter)) {
            if (!applyColorFilter(colorFilter)) {
                if (colorFilter == null) {
                    Paint layerPaint = this.layerPaint;
                    if (layerPaint == null) {
                    } else {
                        layerPaint.setColorFilter(0);
                    }
                    this.useLayer = false;
                } else {
                    obtainPaint().setColorFilter(colorFilter);
                    this.useLayer = true;
                }
            }
            this.colorFilter = colorFilter;
        }
    }

    private final void configureLayoutDirection(LayoutDirection rtl) {
        if (this.layoutDirection != rtl) {
            applyLayoutDirection(rtl);
            this.layoutDirection = rtl;
        }
    }

    public static void draw-x_KDEd0$default(androidx.compose.ui.graphics.painter.Painter painter, DrawScope drawScope2, long l3, float f4, ColorFilter colorFilter5, int i6, Object object7) {
        int i2;
        int i;
        int obj10;
        int obj11;
        if (obj13 != null) {
        } else {
            i2 = object7 & 2 != 0 ? obj10 : colorFilter5;
            i = object7 & 4 != 0 ? obj11 : i6;
            painter.draw-x_KDEd0(drawScope2, l3, obj3, i2);
        }
        UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw-x_KDEd0");
        throw obj6;
    }

    private final Paint obtainPaint() {
        Paint target;
        if (this.layerPaint == null) {
            this.layerPaint = AndroidPaint_androidKt.Paint();
        }
        return target;
    }

    protected boolean applyAlpha(float alpha) {
        return 0;
    }

    protected boolean applyColorFilter(ColorFilter colorFilter) {
        return 0;
    }

    protected boolean applyLayoutDirection(LayoutDirection layoutDirection) {
        return 0;
    }

    public final void draw-x_KDEd0(DrawScope $this$draw_u2dx_KDEd0, long size, float alpha, ColorFilter colorFilter) {
        int useLayer;
        float f;
        Object $this$drawIntoCanvas$iv;
        int i;
        Canvas canvas;
        long l;
        Canvas canvas2;
        Paint paint;
        int i2;
        DrawScope drawScope;
        final Object obj = this;
        f = colorFilter;
        obj.configureAlpha(f);
        $this$drawIntoCanvas$iv = obj24;
        obj.configureColorFilter($this$drawIntoCanvas$iv);
        obj.configureLayoutDirection($this$draw_u2dx_KDEd0.getLayoutDirection());
        height-impl2 -= height-impl3;
        DrawScope drawScope3 = $this$draw_u2dx_KDEd0;
        i = 0;
        final int i10 = i;
        final int i11 = i3;
        final int i12 = i;
        final int i13 = 0;
        drawScope3.getDrawContext().getTransform().inset(i12, i10, i11, i7);
        DrawScope drawScope4 = drawScope3;
        final int i17 = 0;
        if (Float.compare(f, i) > 0 && Float.compare(width-impl2, i) > 0 && Float.compare(height-impl, i) > 0) {
            if (Float.compare(width-impl2, i) > 0) {
                if (Float.compare(height-impl, i) > 0) {
                    if (obj.useLayer) {
                        DrawScope drawScope2 = drawScope4;
                        i = 0;
                        l = 0;
                        canvas2 = canvas;
                        i2 = 0;
                        drawScope = drawScope2;
                        canvas2.saveLayer(RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), obj14), obj.obtainPaint());
                        useLayer = 0;
                        obj.onDraw(drawScope4);
                        canvas2.restore();
                    } else {
                        obj.onDraw(drawScope4);
                    }
                }
            }
        }
        drawScope3.getDrawContext().getTransform().inset(-i12, -i10, -i11, -i7);
    }

    public abstract long getIntrinsicSize-NH-jbRc();

    protected abstract void onDraw(DrawScope drawScope);
}
