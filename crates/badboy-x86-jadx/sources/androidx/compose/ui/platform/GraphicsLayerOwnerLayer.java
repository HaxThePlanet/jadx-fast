package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.CompositingStrategy.Companion;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Outline.Generic;
import androidx.compose.ui.graphics.Outline.Rectangle;
import androidx.compose.ui.graphics.Outline.Rounded;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOrigin.Companion;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.CompositingStrategy;
import androidx.compose.ui.graphics.layer.CompositingStrategy.Companion;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u00128\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u00100\n\u0012\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010<\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0008\u0010=\u001a\u00020\u0010H\u0016J\u001a\u0010>\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0017\u0010?\u001a\u0004\u0018\u00010\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008@\u0010AJ\u0015\u0010B\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008C\u0010AJ\u0008\u0010D\u001a\u00020\u0010H\u0016J\u001a\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\u0008G\u0010HJ\u001a\u0010I\u001a\u00020\u00172\u0006\u0010J\u001a\u00020KH\u0016ø\u0001\u0000¢\u0006\u0004\u0008L\u0010MJ\u0018\u0010N\u001a\u00020\u00102\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0017H\u0016J\"\u0010R\u001a\u00020K2\u0006\u0010S\u001a\u00020K2\u0006\u0010Q\u001a\u00020\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\u0008T\u0010UJ\u001a\u0010V\u001a\u00020\u00102\u0006\u0010J\u001a\u00020WH\u0016ø\u0001\u0000¢\u0006\u0004\u0008X\u0010YJ\u001a\u0010Z\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016ø\u0001\u0000¢\u0006\u0004\u0008[\u0010YJP\u0010\\\u001a\u00020\u001028\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u00100\n2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u001a\u0010]\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\u0008^\u0010HJ\u0008\u0010_\u001a\u00020\u0010H\u0002J\u0008\u0010`\u001a\u00020\u0010H\u0016J\u0010\u0010a\u001a\u00020\u00102\u0006\u00101\u001a\u00020bH\u0016J\u0008\u0010c\u001a\u00020\u0010H\u0002J\u0008\u0010d\u001a\u00020\u0010H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017@BX\u0082\u000e¢\u0006\u0008\n\u0000\"\u0004\u0008\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u00020\u0019X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008,\u0010#R\u001f\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00100.¢\u0006\u0002\u00080X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\u000204X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00105R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\u00020;X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00105\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006e", d2 = {"Landroidx/compose/ui/platform/GraphicsLayerOwnerLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "context", "Landroidx/compose/ui/graphics/GraphicsContext;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "density", "Landroidx/compose/ui/unit/Density;", "drawnWithEnabledZ", "", "inverseMatrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "isDestroyed", "value", "isDirty", "setDirty", "(Z)V", "layerId", "", "getLayerId", "()J", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "matrixCache", "mutatedFields", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "ownerViewId", "getOwnerViewId", "recordLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "scope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "tmpPath", "Landroidx/compose/ui/graphics/Path;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "clipManually", "destroy", "drawLayer", "getInverseMatrix", "getInverseMatrix-3i98HWw", "()[F", "getMatrix", "getMatrix-sQKQjiQ", "invalidate", "inverseTransform", "matrix", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "triggerRepaint", "updateDisplayList", "updateLayerProperties", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "updateMatrix", "updateOutline", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GraphicsLayerOwnerLayer implements OwnedLayer, GraphicLayerInfo {

    public static final int $stable = 8;
    private final GraphicsContext context;
    private Density density;
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithEnabledZ;
    private GraphicsLayer graphicsLayer;
    private Function0<Unit> invalidateParentLayer;
    private float[] inverseMatrixCache;
    private boolean isDestroyed;
    private boolean isDirty;
    private LayoutDirection layoutDirection;
    private final float[] matrixCache;
    private int mutatedFields;
    private Outline outline;
    private final androidx.compose.ui.platform.AndroidComposeView ownerView;
    private final Function1<DrawScope, Unit> recordLambda;
    private final CanvasDrawScope scope;
    private long size;
    private Paint softwareLayerPaint;
    private Path tmpPath;
    private long transformOrigin;
    static {
        final int i = 8;
    }

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer, GraphicsContext context, androidx.compose.ui.platform.AndroidComposeView ownerView, Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        super();
        this.graphicsLayer = graphicsLayer;
        this.context = context;
        this.ownerView = ownerView;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
        int i = Integer.MAX_VALUE;
        this.size = IntSizeKt.IntSize(i, i);
        final int i4 = 0;
        this.matrixCache = Matrix.constructor-impl$default(i4, 1, i4);
        this.density = DensityKt.Density$default(1065353216, 0, 2, i4);
        this.layoutDirection = LayoutDirection.Ltr;
        CanvasDrawScope canvasDrawScope = new CanvasDrawScope();
        this.scope = canvasDrawScope;
        this.transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
        GraphicsLayerOwnerLayer.recordLambda.1 anon = new GraphicsLayerOwnerLayer.recordLambda.1(this);
        this.recordLambda = (Function1)anon;
    }

    public static final Function2 access$getDrawBlock$p(androidx.compose.ui.platform.GraphicsLayerOwnerLayer $this) {
        return $this.drawBlock;
    }

    private final void clipManually(Canvas canvas) {
        boolean outline;
        boolean tmpPath;
        int i2;
        int i3;
        int i4;
        androidx.compose.ui.geometry.RoundRect roundRect;
        int i;
        if (this.graphicsLayer.getClip()) {
            outline = this.graphicsLayer.getOutline();
            i2 = 0;
            i3 = 2;
            i4 = 0;
            if (outline instanceof Outline.Rectangle) {
                Canvas.clipRect-mtrdD-E$default(canvas, (Outline.Rectangle)outline.getRect(), i2, i3, i4);
            } else {
                if (outline instanceof Outline.Rounded) {
                    if (this.tmpPath == null) {
                        i = 0;
                        this.tmpPath = AndroidPath_androidKt.Path();
                    }
                    tmpPath.reset();
                    Path.addRoundRect$default(tmpPath, (Outline.Rounded)outline.getRoundRect(), i4, i3, i4);
                    Canvas.clipPath-mtrdD-E$default(canvas, tmpPath, i2, i3, i4);
                } else {
                    if (outline instanceof Outline.Generic) {
                        Canvas.clipPath-mtrdD-E$default(canvas, (Outline.Generic)outline.getPath(), i2, i3, i4);
                    }
                }
            }
        }
    }

    private final float[] getInverseMatrix-3i98HWw() {
        float[] inverseMatrixCache;
        float[] i;
        float[] fArr;
        int i2;
        i = 0;
        if (this.inverseMatrixCache == null) {
            i2 = 0;
            this.inverseMatrixCache = Matrix.constructor-impl$default(i, 1, i);
        }
        if (InvertMatrixKt.invertTo-JiSxe2E(getMatrix-sQKQjiQ(), inverseMatrixCache)) {
            i = inverseMatrixCache;
        } else {
        }
        return i;
    }

    private final float[] getMatrix-sQKQjiQ() {
        updateMatrix();
        return this.matrixCache;
    }

    private final void setDirty(boolean value) {
        boolean ownerView;
        Object obj;
        if (value != this.isDirty) {
            this.isDirty = value;
            this.ownerView.notifyLayerIsDirty$ui_release((OwnedLayer)this, value);
        }
    }

    private final void triggerRepaint() {
        WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
    }

    private final void updateMatrix() {
        long center-uvyYCjk;
        final GraphicsLayer graphicsLayer = this.graphicsLayer;
        final int i = 0;
        if (OffsetKt.isUnspecified-k-4lQ0M(graphicsLayer.getPivotOffset-F1C5BW0())) {
            center-uvyYCjk = SizeKt.getCenter-uvyYCjk(IntSizeKt.toSize-ozmzZPI(this.size));
        } else {
            center-uvyYCjk = graphicsLayer.getPivotOffset-F1C5BW0();
        }
        Matrix.reset-impl(this.matrixCache);
        int i2 = 0;
        int i3 = 1;
        float[] constructor-impl$default2 = Matrix.constructor-impl$default(i2, i3, i2);
        int i13 = 0;
        int i10 = 4;
        final int i12 = 0;
        int i8 = 0;
        Matrix.translate-impl$default(constructor-impl$default2, -x-impl2, -y-impl2, i8, i10, i12);
        Matrix.timesAssign-58bKbWc(this.matrixCache, constructor-impl$default2);
        float[] constructor-impl$default3 = Matrix.constructor-impl$default(i2, i3, i2);
        float[] fArr3 = constructor-impl$default3;
        int i14 = 0;
        Matrix.translate-impl$default(fArr3, graphicsLayer.getTranslationX(), graphicsLayer.getTranslationY(), i8, i10, i12);
        Matrix.rotateX-impl(fArr3, graphicsLayer.getRotationX());
        Matrix.rotateY-impl(fArr3, graphicsLayer.getRotationY());
        Matrix.rotateZ-impl(fArr3, graphicsLayer.getRotationZ());
        Matrix.scale-impl$default(fArr3, graphicsLayer.getScaleX(), graphicsLayer.getScaleY(), i8, i10, i12);
        Matrix.timesAssign-58bKbWc(this.matrixCache, constructor-impl$default3);
        float[] constructor-impl$default = Matrix.constructor-impl$default(i2, i3, i2);
        int i11 = 0;
        Matrix.translate-impl$default(constructor-impl$default, Offset.getX-impl(center-uvyYCjk), Offset.getY-impl(center-uvyYCjk), 0, 4, 0);
        Matrix.timesAssign-58bKbWc(this.matrixCache, constructor-impl$default);
    }

    private final void updateOutline() {
        boolean invalidateParentLayer;
        int i;
        final Outline outline = this.outline;
        if (outline == null) {
        }
        GraphicsLayerKt.setOutline(this.graphicsLayer, outline);
        invalidateParentLayer = this.invalidateParentLayer;
        if (outline instanceof Outline.Generic && Build.VERSION.SDK_INT < 33 && invalidateParentLayer != null) {
            if (Build.VERSION.SDK_INT < 33) {
                invalidateParentLayer = this.invalidateParentLayer;
                if (invalidateParentLayer != null) {
                    invalidateParentLayer.invoke();
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        Object ownerView;
        Object obj;
        int i = 0;
        this.drawBlock = i;
        this.invalidateParentLayer = i;
        this.isDestroyed = true;
        setDirty(false);
        if (this.context != null) {
            this.context.releaseGraphicsLayer(this.graphicsLayer);
            this.ownerView.recycle$ui_release((OwnedLayer)this);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        int i;
        CanvasDrawScope scope;
        GraphicsLayer graphicsLayer;
        long l2;
        long l;
        long drawBlock;
        Paint softwareLayerPaint;
        android.graphics.Paint frameworkPaint;
        Paint it;
        int i2;
        float alpha;
        final Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            i = Float.compare(shadowElevation, i3) > 0 ? 1 : 0;
            this.drawnWithEnabledZ = i;
            DrawContext drawContext = this.scope.getDrawContext();
            int i4 = 0;
            drawContext.setCanvas(canvas);
            drawContext.setGraphicsLayer(parentLayer);
            GraphicsLayerKt.drawLayer((DrawScope)this.scope, this.graphicsLayer);
        } else {
            scope = (float)x-impl;
            graphicsLayer = (float)y-impl;
            if (Float.compare(alpha2, it) < 0) {
                if (this.softwareLayerPaint == null) {
                    i2 = 0;
                    this.softwareLayerPaint = AndroidPaint_androidKt.Paint();
                }
                it = softwareLayerPaint;
                i2 = 0;
                it.setAlpha(this.graphicsLayer.getAlpha());
                nativeCanvas.saveLayer(scope, graphicsLayer, f += scope, f2 += graphicsLayer, it.asFrameworkPaint());
            } else {
                canvas.save();
            }
            canvas.translate(scope, graphicsLayer);
            canvas.concat-58bKbWc(getMatrix-sQKQjiQ());
            if (this.graphicsLayer.getClip()) {
                clipManually(canvas);
            }
            drawBlock = this.drawBlock;
            if (drawBlock != null) {
                drawBlock.invoke(canvas, 0);
            }
            canvas.restore();
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public long getLayerId() {
        return this.graphicsLayer.getLayerId();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public long getOwnerViewId() {
        return this.graphicsLayer.getOwnerViewId();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        boolean isDestroyed;
        if (!this.isDirty && !this.isDestroyed) {
            if (!this.isDestroyed) {
                this.ownerView.invalidate();
                setDirty(true);
            }
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void inverseTransform-58bKbWc(float[] matrix) {
        final float[] inverseMatrix-3i98HWw = getInverseMatrix-3i98HWw();
        if (inverseMatrix-3i98HWw != null) {
            Matrix.timesAssign-58bKbWc(matrix, inverseMatrix-3i98HWw);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public boolean isInLayer-k-4lQ0M(long position) {
        if (this.graphicsLayer.getClip()) {
            return ShapeContainingUtilKt.isInOutline$default(this.graphicsLayer.getOutline(), Offset.getX-impl(position), Offset.getY-impl(position), 0, 0, 24, 0);
        }
        return 1;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        float[] inverseMatrix-3i98HWw;
        int i;
        if (inverse) {
            inverseMatrix-3i98HWw = getInverseMatrix-3i98HWw();
            if (inverseMatrix-3i98HWw == null) {
                i = 0;
                rect.set(i, i, i, i);
            } else {
                Matrix.map-impl(inverseMatrix-3i98HWw, rect);
            }
        } else {
            Matrix.map-impl(getMatrix-sQKQjiQ(), rect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public long mapOffset-8S9VItk(long point, boolean inverse) {
        long map-MK-Hz9U;
        if (obj5 != null) {
            float[] inverseMatrix-3i98HWw = getInverseMatrix-3i98HWw();
            if (inverseMatrix-3i98HWw != null) {
                map-MK-Hz9U = Matrix.map-MK-Hz9U(inverseMatrix-3i98HWw, point);
            } else {
                map-MK-Hz9U = Offset.Companion.getInfinite-F1C5BW0();
            }
        } else {
            map-MK-Hz9U = Matrix.map-MK-Hz9U(getMatrix-sQKQjiQ(), point);
        }
        return map-MK-Hz9U;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void move--gyyYBs(long position) {
        this.graphicsLayer.setTopLeft--gyyYBs(position);
        triggerRepaint();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void resize-ozmzZPI(long size) {
        if (!IntSize.equals-impl0(size, obj4)) {
            this.size = size;
            invalidate();
        }
    }

    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        GraphicsContext context = this.context;
        if (context == null) {
        } else {
            if (!this.graphicsLayer.isReleased()) {
            } else {
                this.graphicsLayer = context.createGraphicsLayer();
                int i2 = 0;
                this.isDestroyed = i2;
                this.drawBlock = drawBlock;
                this.invalidateParentLayer = invalidateParentLayer;
                this.transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
                this.drawnWithEnabledZ = i2;
                int i3 = Integer.MAX_VALUE;
                this.size = IntSizeKt.IntSize(i3, i3);
                this.outline = 0;
                this.mutatedFields = i2;
            }
            int i = 0;
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("layer should have been released before reuse".toString());
            throw illegalArgumentException2;
        }
        int context2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("currently reuse is only supported when we manage the layer lifecycle".toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void transform-58bKbWc(float[] matrix) {
        Matrix.timesAssign-58bKbWc(matrix, getMatrix-sQKQjiQ());
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        boolean graphicsLayer;
        boolean isDirty;
        long l;
        long center-SzJe1aQ;
        long graphicsLayer2;
        long density;
        LayoutDirection layoutDirection;
        long size;
        Function1 recordLambda;
        center-SzJe1aQ = this.size;
        if (this.isDirty && !TransformOrigin.equals-impl0(this.transformOrigin, obj1) && !IntSize.equals-impl0(this.graphicsLayer.getSize-YbymL2g(), obj1)) {
            if (!TransformOrigin.equals-impl0(this.transformOrigin, obj1)) {
                center-SzJe1aQ = this.size;
                if (!IntSize.equals-impl0(this.graphicsLayer.getSize-YbymL2g(), obj1)) {
                    pivotFractionY-impl *= graphicsLayer2;
                    this.graphicsLayer.setPivotOffset-k-4lQ0M(OffsetKt.Offset(pivotFractionX-impl *= f, center-SzJe1aQ));
                }
            }
            this.graphicsLayer.record-mL-hObY(this.density, this.layoutDirection, this.size, obj7);
            setDirty(false);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope scope) {
        int transformOrigin-SzJe1aQ;
        int graphicsLayer5;
        int graphicsLayer6;
        int graphicsLayer9;
        int graphicsLayer12;
        int graphicsLayer10;
        int invalidateParentLayer;
        int graphicsLayer7;
        int graphicsLayer2;
        int graphicsLayer;
        int graphicsLayer8;
        int graphicsLayer13;
        int graphicsLayer15;
        int graphicsLayer14;
        int graphicsLayer4;
        int graphicsLayer3;
        int graphicsLayer11;
        int outlineChanged;
        float ambientShadowColor-0d7_KjU;
        boolean outline$ui_release;
        long modulateAlpha--NrFUSI;
        long l;
        mutatedFields$ui_release |= mutatedFields;
        this.layoutDirection = scope.getLayoutDirection$ui_release();
        this.density = scope.getGraphicsDensity$ui_release();
        if (i & 4096 != 0) {
            this.transformOrigin = scope.getTransformOrigin-SzJe1aQ();
        }
        if (i & 1 != 0) {
            this.graphicsLayer.setScaleX(scope.getScaleX());
        }
        if (i & 2 != 0) {
            this.graphicsLayer.setScaleY(scope.getScaleY());
        }
        if (i & 4 != 0) {
            this.graphicsLayer.setAlpha(scope.getAlpha());
        }
        if (i & 8 != 0) {
            this.graphicsLayer.setTranslationX(scope.getTranslationX());
        }
        if (i & 16 != 0) {
            this.graphicsLayer.setTranslationY(scope.getTranslationY());
        }
        this.graphicsLayer.setShadowElevation(scope.getShadowElevation());
        invalidateParentLayer = this.invalidateParentLayer;
        if (i & 32 != 0 && Float.compare(shadowElevation, ambientShadowColor-0d7_KjU) > 0 && !this.drawnWithEnabledZ && invalidateParentLayer != null) {
            this.graphicsLayer.setShadowElevation(scope.getShadowElevation());
            if (Float.compare(shadowElevation, ambientShadowColor-0d7_KjU) > 0) {
                if (!this.drawnWithEnabledZ) {
                    invalidateParentLayer = this.invalidateParentLayer;
                    if (invalidateParentLayer != null) {
                        invalidateParentLayer.invoke();
                    }
                }
            }
        }
        if (i & 64 != 0) {
            this.graphicsLayer.setAmbientShadowColor-8_81llA(scope.getAmbientShadowColor-0d7_KjU());
        }
        if (i & 128 != 0) {
            this.graphicsLayer.setSpotShadowColor-8_81llA(scope.getSpotShadowColor-0d7_KjU());
        }
        if (i & 1024 != 0) {
            this.graphicsLayer.setRotationZ(scope.getRotationZ());
        }
        if (i & 256 != 0) {
            this.graphicsLayer.setRotationX(scope.getRotationX());
        }
        if (i & 512 != 0) {
            this.graphicsLayer.setRotationY(scope.getRotationY());
        }
        if (i & 2048 != 0) {
            this.graphicsLayer.setCameraDistance(scope.getCameraDistance());
        }
        if (i & 4096 != 0) {
            modulateAlpha--NrFUSI = TransformOrigin.Companion.getCenter-SzJe1aQ();
            if (TransformOrigin.equals-impl0(this.transformOrigin, ambientShadowColor-0d7_KjU)) {
                this.graphicsLayer.setPivotOffset-k-4lQ0M(Offset.Companion.getUnspecified-F1C5BW0());
            } else {
                pivotFractionY-impl *= l;
                this.graphicsLayer.setPivotOffset-k-4lQ0M(OffsetKt.Offset(pivotFractionX-impl *= f, modulateAlpha--NrFUSI));
            }
        }
        if (i & 16384 != 0) {
            this.graphicsLayer.setClip(scope.getClip());
        }
        if (i2 &= i != 0) {
            this.graphicsLayer.setRenderEffect(scope.getRenderEffect());
        }
        if (i3 &= i != 0) {
            int compositingStrategy--NrFUSI = scope.getCompositingStrategy--NrFUSI();
            if (CompositingStrategy.equals-impl0(compositingStrategy--NrFUSI, CompositingStrategy.Companion.getAuto--NrFUSI())) {
                ambientShadowColor-0d7_KjU = CompositingStrategy.Companion.getAuto-ke2Ky5w();
                this.graphicsLayer.setCompositingStrategy-Wpw9cng(ambientShadowColor-0d7_KjU);
            } else {
                if (CompositingStrategy.equals-impl0(compositingStrategy--NrFUSI, CompositingStrategy.Companion.getOffscreen--NrFUSI())) {
                    ambientShadowColor-0d7_KjU = CompositingStrategy.Companion.getOffscreen-ke2Ky5w();
                } else {
                    if (!CompositingStrategy.equals-impl0(compositingStrategy--NrFUSI, CompositingStrategy.Companion.getModulateAlpha--NrFUSI())) {
                    } else {
                        ambientShadowColor-0d7_KjU = CompositingStrategy.Companion.getModulateAlpha-ke2Ky5w();
                    }
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("Not supported composition strategy");
            throw illegalStateException;
        }
        outlineChanged = 0;
        if (!Intrinsics.areEqual(this.outline, scope.getOutline$ui_release())) {
            outlineChanged = 1;
            this.outline = scope.getOutline$ui_release();
            updateOutline();
        }
        this.mutatedFields = scope.getMutatedFields$ui_release();
        if (i == 0) {
            if (outlineChanged != 0) {
                triggerRepaint();
            }
        } else {
        }
    }
}
