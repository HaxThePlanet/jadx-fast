package androidx.compose.ui.draganddrop;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View.DragShadowBuilder;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B.\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0014", d2 = {"Landroidx/compose/ui/draganddrop/ComposeDragShadowBuilder;", "Landroid/view/View$DragShadowBuilder;", "density", "Landroidx/compose/ui/unit/Density;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "onDrawShadow", "canvas", "Landroid/graphics/Canvas;", "onProvideShadowMetrics", "outShadowSize", "Landroid/graphics/Point;", "outShadowTouchPoint", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComposeDragShadowBuilder extends View.DragShadowBuilder {

    public static final int $stable;
    private final long decorationSize;
    private final Density density;
    private final Function1<DrawScope, Unit> drawDragDecoration;
    static {
    }

    private ComposeDragShadowBuilder(Density density, long decorationSize, Function1<? super DrawScope, Unit> drawDragDecoration) {
        super();
        this.density = density;
        this.decorationSize = decorationSize;
        this.drawDragDecoration = obj4;
    }

    public ComposeDragShadowBuilder(Density density, long l2, Function1 function13, DefaultConstructorMarker defaultConstructorMarker4) {
        super(density, l2, function13, defaultConstructorMarker4);
    }

    @Override // android.view.View$DragShadowBuilder
    public void onDrawShadow(Canvas canvas) {
        final Object obj = this;
        CanvasDrawScope canvasDrawScope = new CanvasDrawScope();
        final Canvas canvas2 = AndroidCanvas_androidKt.Canvas(canvas);
        final int i2 = 0;
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        final int i3 = 0;
        drawParams3.setDensity(obj.density);
        drawParams3.setLayoutDirection(LayoutDirection.Ltr);
        drawParams3.setCanvas(canvas2);
        drawParams3.setSize-uvyYCjk(obj.decorationSize);
        canvas2.save();
        obj.drawDragDecoration.invoke(canvasDrawScope);
        canvas2.restore();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        int i = 0;
        drawParams.setDensity(drawParams2.component1());
        drawParams.setLayoutDirection(drawParams2.component2());
        drawParams.setCanvas(drawParams2.component3());
        drawParams.setSize-uvyYCjk(drawParams2.component4-NH-jbRc());
    }

    @Override // android.view.View$DragShadowBuilder
    public void onProvideShadowMetrics(Point outShadowSize, Point outShadowTouchPoint) {
        final Density density = this.density;
        final int i = 0;
        outShadowSize.set(density.roundToPx-0680j_4(density.toDp-u2uoSUM(Size.getWidth-impl(this.decorationSize))), density.roundToPx-0680j_4(density.toDp-u2uoSUM(Size.getHeight-impl(this.decorationSize))));
        outShadowTouchPoint.set(i2 /= 2, i4 /= 2);
    }
}
