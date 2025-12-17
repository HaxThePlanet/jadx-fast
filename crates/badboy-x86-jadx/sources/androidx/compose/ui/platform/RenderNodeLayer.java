package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOrigin.Companion;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0002UVBU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00128\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\r0\u0006\u0012\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010/\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0008\u00100\u001a\u00020\rH\u0016J\u001a\u00101\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00072\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u000bH\u0016J\u0008\u00102\u001a\u00020\rH\u0016J\u001a\u00103\u001a\u00020\r2\u0006\u00104\u001a\u000205H\u0016ø\u0001\u0000¢\u0006\u0004\u00086\u00107J\u001a\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020:H\u0016ø\u0001\u0000¢\u0006\u0004\u0008;\u0010<J\u0018\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0014H\u0016J\"\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020:2\u0006\u0010@\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\u0008C\u0010DJ\u001a\u0010E\u001a\u00020\r2\u0006\u00109\u001a\u00020FH\u0016ø\u0001\u0000¢\u0006\u0004\u0008G\u0010HJ\u001a\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020KH\u0016ø\u0001\u0000¢\u0006\u0004\u0008L\u0010HJP\u0010M\u001a\u00020\r28\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\r0\u00062\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000fH\u0016J\u001a\u0010N\u001a\u00020\r2\u0006\u00104\u001a\u000205H\u0016ø\u0001\u0000¢\u0006\u0004\u0008O\u00107J\u0008\u0010P\u001a\u00020\rH\u0002J\u0008\u0010Q\u001a\u00020\rH\u0016J\u0010\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020TH\u0016R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0005\u001a6\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014@BX\u0082\u000e¢\u0006\u0008\n\u0000\"\u0004\u0008\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0014\u0010'\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008(\u0010\u001dR\u000e\u0010)\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\u00020-X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010.\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006W", d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "drawnWithZ", "", "isDestroyed", "value", "isDirty", "setDirty", "(Z)V", "layerId", "", "getLayerId", "()J", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "mutatedFields", "", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "renderNode", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "clipRenderNode", "destroy", "drawLayer", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "triggerRepaint", "updateDisplayList", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RenderNodeLayer implements OwnedLayer, GraphicLayerInfo {

    public static final int $stable = 8;
    public static final androidx.compose.ui.platform.RenderNodeLayer.Companion Companion;
    private static final Function2<androidx.compose.ui.platform.DeviceRenderNode, Matrix, Unit> getMatrix = 8;
    private final CanvasHolder canvasHolder;
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithZ;
    private Function0<Unit> invalidateParentLayer;
    private boolean isDestroyed;
    private boolean isDirty;
    private final androidx.compose.ui.platform.LayerMatrixCache<androidx.compose.ui.platform.DeviceRenderNode> matrixCache;
    private int mutatedFields;
    private final androidx.compose.ui.platform.OutlineResolver outlineResolver;
    private final androidx.compose.ui.platform.AndroidComposeView ownerView;
    private final androidx.compose.ui.platform.DeviceRenderNode renderNode;
    private Paint softwareLayerPaint;
    private long transformOrigin;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer$Companion;", "", "()V", "getMatrix", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "Landroid/graphics/Matrix;", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007", d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class UniqueDrawingIdApi29 {

        public static final androidx.compose.ui.platform.RenderNodeLayer.UniqueDrawingIdApi29 INSTANCE;
        static {
            RenderNodeLayer.UniqueDrawingIdApi29 uniqueDrawingIdApi29 = new RenderNodeLayer.UniqueDrawingIdApi29();
            RenderNodeLayer.UniqueDrawingIdApi29.INSTANCE = uniqueDrawingIdApi29;
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            return view.getUniqueDrawingId();
        }
    }
    static {
        RenderNodeLayer.Companion companion = new RenderNodeLayer.Companion(0);
        RenderNodeLayer.Companion = companion;
        int i = 8;
        androidx.compose.ui.platform.RenderNodeLayer.Companion.getMatrix.1 iNSTANCE = RenderNodeLayer.Companion.getMatrix.1.INSTANCE;
    }

    public RenderNodeLayer(androidx.compose.ui.platform.AndroidComposeView ownerView, Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        super();
        this.ownerView = ownerView;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
        OutlineResolver outlineResolver = new OutlineResolver();
        this.outlineResolver = outlineResolver;
        LayerMatrixCache layerMatrixCache = new LayerMatrixCache(RenderNodeLayer.getMatrix);
        this.matrixCache = layerMatrixCache;
        CanvasHolder canvasHolder = new CanvasHolder();
        this.canvasHolder = canvasHolder;
        this.transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
        RenderNodeApi29 renderNodeApi29 = new RenderNodeApi29(this.ownerView);
        androidx.compose.ui.platform.RenderNodeApi29 renderNodeApi292 = renderNodeApi29;
        final int i = 0;
        renderNodeApi292.setHasOverlappingRendering(true);
        renderNodeApi292.setClipToBounds(false);
        this.renderNode = (DeviceRenderNode)renderNodeApi29;
    }

    private final void clipRenderNode(Canvas canvas) {
        boolean outlineResolver;
        if (!this.renderNode.getClipToOutline()) {
            if (this.renderNode.getClipToBounds()) {
                this.outlineResolver.clipToOutline(canvas);
            }
        } else {
        }
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

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        boolean hasDisplayList;
        if (this.renderNode.getHasDisplayList()) {
            this.renderNode.discardDisplayList();
        }
        int i = 0;
        this.drawBlock = i;
        this.invalidateParentLayer = i;
        this.isDestroyed = true;
        setDirty(false);
        this.ownerView.requestClearInvalidObservations();
        this.ownerView.recycle$ui_release((OwnedLayer)this);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer parentLayer) {
        boolean drawnWithZ;
        int i3;
        float f;
        float f2;
        Function2 drawBlock;
        int frameworkPaint;
        Paint softwareLayerPaint;
        int i2;
        androidx.compose.ui.platform.DeviceRenderNode renderNode;
        int it;
        int i;
        float alpha;
        final Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            if (Float.compare(elevation, i3) > 0) {
                i2 = 1;
            }
            this.drawnWithZ = i2;
            if (this.drawnWithZ) {
                canvas.enableZ();
            }
            this.renderNode.drawInto(nativeCanvas);
            if (this.drawnWithZ) {
                canvas.disableZ();
            }
        } else {
            drawnWithZ = (float)left;
            i3 = (float)top;
            if (Float.compare(alpha2, it) < 0) {
                if (this.softwareLayerPaint == null) {
                    i = 0;
                    this.softwareLayerPaint = AndroidPaint_androidKt.Paint();
                }
                it = softwareLayerPaint;
                i = 0;
                it.setAlpha(this.renderNode.getAlpha());
                nativeCanvas.saveLayer(drawnWithZ, i3, (float)right, (float)bottom, it.asFrameworkPaint());
            } else {
                canvas.save();
            }
            canvas.translate(drawnWithZ, i3);
            canvas.concat-58bKbWc(this.matrixCache.calculateMatrix-GrdbGEg(this.renderNode));
            clipRenderNode(canvas);
            drawBlock = this.drawBlock;
            if (drawBlock != null) {
                drawBlock.invoke(canvas, 0);
            }
            canvas.restore();
            setDirty(false);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public long getLayerId() {
        return this.renderNode.getUniqueId();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public final androidx.compose.ui.platform.AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public long getOwnerViewId() {
        return RenderNodeLayer.UniqueDrawingIdApi29.getUniqueDrawingId((View)this.ownerView);
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
        float[] inverseMatrix-bWbORWo = this.matrixCache.calculateInverseMatrix-bWbORWo(this.renderNode);
        if (inverseMatrix-bWbORWo != null) {
            Matrix.timesAssign-58bKbWc(matrix, inverseMatrix-bWbORWo);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public boolean isInLayer-k-4lQ0M(long position) {
        int cmp;
        int i;
        int cmp2;
        final float x-impl = Offset.getX-impl(position);
        final float y-impl = Offset.getY-impl(position);
        if (this.renderNode.getClipToBounds()) {
            cmp = 0;
            if (Float.compare(cmp, x-impl) <= 0 && Float.compare(x-impl, f2) < 0 && Float.compare(cmp, y-impl) <= 0 && Float.compare(y-impl, f) < 0) {
                if (Float.compare(x-impl, f2) < 0) {
                    if (Float.compare(cmp, y-impl) <= 0) {
                        if (Float.compare(y-impl, f) < 0) {
                        } else {
                            i = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        if (this.renderNode.getClipToOutline()) {
            return this.outlineResolver.isInOutline-k-4lQ0M(position);
        }
        return 1;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect rect, boolean inverse) {
        float[] inverseMatrix-bWbORWo;
        androidx.compose.ui.platform.DeviceRenderNode renderNode;
        if (inverse) {
            inverseMatrix-bWbORWo = this.matrixCache.calculateInverseMatrix-bWbORWo(this.renderNode);
            if (inverseMatrix-bWbORWo == null) {
                renderNode = 0;
                rect.set(renderNode, renderNode, renderNode, renderNode);
            } else {
                Matrix.map-impl(inverseMatrix-bWbORWo, rect);
            }
        } else {
            Matrix.map-impl(this.matrixCache.calculateMatrix-GrdbGEg(this.renderNode), rect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public long mapOffset-8S9VItk(long point, boolean inverse) {
        long map-MK-Hz9U;
        androidx.compose.ui.platform.DeviceRenderNode renderNode;
        if (obj5 != null) {
            float[] inverseMatrix-bWbORWo = this.matrixCache.calculateInverseMatrix-bWbORWo(this.renderNode);
            if (inverseMatrix-bWbORWo != null) {
                map-MK-Hz9U = Matrix.map-MK-Hz9U(inverseMatrix-bWbORWo, point);
            } else {
                map-MK-Hz9U = Offset.Companion.getInfinite-F1C5BW0();
            }
        } else {
            map-MK-Hz9U = Matrix.map-MK-Hz9U(this.matrixCache.calculateMatrix-GrdbGEg(this.renderNode), point);
        }
        return map-MK-Hz9U;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void move--gyyYBs(long position) {
        androidx.compose.ui.platform.LayerMatrixCache matrixCache;
        int i;
        int left = this.renderNode.getLeft();
        int top = this.renderNode.getTop();
        final int x-impl = IntOffset.getX-impl(position);
        final int y-impl = IntOffset.getY-impl(position);
        if (left == x-impl) {
            if (top != y-impl && left != x-impl) {
                if (left != x-impl) {
                    this.renderNode.offsetLeftAndRight(x-impl - left);
                }
                if (top != y-impl) {
                    this.renderNode.offsetTopAndBottom(y-impl - top);
                }
                triggerRepaint();
                this.matrixCache.invalidate();
            }
        } else {
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void resize-ozmzZPI(long size) {
        boolean matrixCache;
        int androidOutline;
        final int width-impl = IntSize.getWidth-impl(size);
        final int height-impl = IntSize.getHeight-impl(size);
        float f = (float)width-impl;
        this.renderNode.setPivotX(pivotFractionX-impl *= f);
        this.renderNode.setPivotY(pivotFractionY-impl *= f2);
        if (this.renderNode.setPosition(this.renderNode.getLeft(), this.renderNode.getTop(), left += width-impl, top2 += height-impl)) {
            this.renderNode.setOutline(this.outlineResolver.getAndroidOutline());
            invalidate();
            this.matrixCache.invalidate();
        }
    }

    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer) {
        int i = 0;
        setDirty(i);
        this.isDestroyed = i;
        this.drawnWithZ = i;
        this.transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void transform-58bKbWc(float[] matrix) {
        Matrix.timesAssign-58bKbWc(matrix, this.matrixCache.calculateMatrix-GrdbGEg(this.renderNode));
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        boolean hasDisplayList;
        boolean outlineClipSupported;
        int i;
        int i2;
        androidx.compose.ui.platform.DeviceRenderNode renderNode;
        CanvasHolder canvasHolder;
        androidx.compose.ui.platform.RenderNodeLayer.updateDisplayList.1.1 anon;
        if (!this.isDirty) {
            if (!this.renderNode.getHasDisplayList()) {
                if (this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported()) {
                    if (!this.outlineResolver.getOutlineClipSupported()) {
                        hasDisplayList = this.outlineResolver.getClipPath();
                    } else {
                        hasDisplayList = 0;
                    }
                } else {
                }
                Function2 drawBlock = this.drawBlock;
                if (drawBlock != null) {
                    i2 = 0;
                    anon = new RenderNodeLayer.updateDisplayList.1.1(drawBlock);
                    this.renderNode.record(this.canvasHolder, hasDisplayList, (Function1)anon);
                }
                setDirty(false);
            }
        } else {
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope scope) {
        int transformOrigin-SzJe1aQ;
        int i2;
        boolean outlineClipSupported;
        int i3;
        boolean invalidateParentLayer;
        int matrixCache;
        int renderNode2;
        int renderNode11;
        int renderNode4;
        int renderNode10;
        int renderNode7;
        int renderNode8;
        int renderNode5;
        int renderNode13;
        int renderNode3;
        int renderNode14;
        int renderNode6;
        int renderNode16;
        int renderNode15;
        int i;
        int renderNode;
        int renderNode12;
        int renderNode9;
        boolean shape;
        float compositingStrategy--NrFUSI;
        boolean shape2;
        boolean cacheIsDirty$ui_release;
        long rectangleShape;
        Object androidOutline;
        mutatedFields$ui_release |= mutatedFields;
        if (i4 & 4096 != 0) {
            this.transformOrigin = scope.getTransformOrigin-SzJe1aQ();
        }
        i3 = 0;
        int i5 = 1;
        if (this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported()) {
            i2 = !this.outlineResolver.getOutlineClipSupported() ? i5 : i3;
        } else {
        }
        if (i4 & 1 != 0) {
            this.renderNode.setScaleX(scope.getScaleX());
        }
        if (i4 & 2 != 0) {
            this.renderNode.setScaleY(scope.getScaleY());
        }
        if (i4 & 4 != 0) {
            this.renderNode.setAlpha(scope.getAlpha());
        }
        if (i4 & 8 != 0) {
            this.renderNode.setTranslationX(scope.getTranslationX());
        }
        if (i4 & 16 != 0) {
            this.renderNode.setTranslationY(scope.getTranslationY());
        }
        if (i4 & 32 != 0) {
            this.renderNode.setElevation(scope.getShadowElevation());
        }
        if (i4 & 64 != 0) {
            this.renderNode.setAmbientShadowColor(ColorKt.toArgb-8_81llA(scope.getAmbientShadowColor-0d7_KjU()));
        }
        if (i4 & 128 != 0) {
            this.renderNode.setSpotShadowColor(ColorKt.toArgb-8_81llA(scope.getSpotShadowColor-0d7_KjU()));
        }
        if (i4 & 1024 != 0) {
            this.renderNode.setRotationZ(scope.getRotationZ());
        }
        if (i4 & 256 != 0) {
            this.renderNode.setRotationX(scope.getRotationX());
        }
        if (i4 & 512 != 0) {
            this.renderNode.setRotationY(scope.getRotationY());
        }
        if (i4 & 2048 != 0) {
            this.renderNode.setCameraDistance(scope.getCameraDistance());
        }
        if (i4 & 4096 != 0) {
            float f = (float)width;
            this.renderNode.setPivotX(pivotFractionX-impl *= f);
            this.renderNode.setPivotY(pivotFractionY-impl *= rectangleShape);
        }
        if (scope.getClip() && scope.getShape() != RectangleShapeKt.getRectangleShape()) {
            i = scope.getShape() != RectangleShapeKt.getRectangleShape() ? i5 : i3;
        } else {
        }
        final int i9 = i;
        if (i4 & 24576 != 0) {
            this.renderNode.setClipToOutline(i9);
            if (scope.getClip() && scope.getShape() == RectangleShapeKt.getRectangleShape()) {
                compositingStrategy--NrFUSI = scope.getShape() == RectangleShapeKt.getRectangleShape() ? i5 : i3;
            } else {
            }
            this.renderNode.setClipToBounds(compositingStrategy--NrFUSI);
        }
        if (i6 &= i4 != 0) {
            this.renderNode.setRenderEffect(scope.getRenderEffect());
        }
        if (i7 &= i4 != 0) {
            this.renderNode.setCompositingStrategy-aDBOjCE(scope.getCompositingStrategy--NrFUSI());
        }
        if (this.outlineResolver.getCacheIsDirty$ui_release()) {
            this.renderNode.setOutline(this.outlineResolver.getAndroidOutline());
        }
        if (i9 != 0 && !this.outlineResolver.getOutlineClipSupported()) {
            if (!this.outlineResolver.getOutlineClipSupported()) {
                i3 = i5;
            }
        }
        if (i2 == i3) {
            if (i3 != 0 && this.outlineResolver.update-S_szKao(scope.getOutline$ui_release(), scope.getAlpha(), i9, scope.getShadowElevation(), scope.getSize-NH-jbRc())) {
                if (this.outlineResolver.update-S_szKao(scope.getOutline$ui_release(), scope.getAlpha(), i9, scope.getShadowElevation(), scope.getSize-NH-jbRc())) {
                    invalidate();
                } else {
                    triggerRepaint();
                }
            } else {
            }
        } else {
        }
        invalidateParentLayer = this.invalidateParentLayer;
        if (!this.drawnWithZ && Float.compare(elevation, cacheIsDirty$ui_release) > 0 && invalidateParentLayer != null) {
            if (Float.compare(elevation, cacheIsDirty$ui_release) > 0) {
                invalidateParentLayer = this.invalidateParentLayer;
                if (invalidateParentLayer != null) {
                    invalidateParentLayer.invoke();
                }
            }
        }
        if (i4 & 7963 != 0) {
            this.matrixCache.invalidate();
        }
        this.mutatedFields = scope.getMutatedFields$ui_release();
    }
}
