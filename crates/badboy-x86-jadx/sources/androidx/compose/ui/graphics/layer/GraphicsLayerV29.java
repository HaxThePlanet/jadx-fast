package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RenderNode;
import android.os.Build.VERSION;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendMode.Companion;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010h\u001a\u00020iH\u0002J\u0008\u0010j\u001a\u00020<H\u0016J\u0008\u0010k\u001a\u00020iH\u0016J\u0010\u0010l\u001a\u00020i2\u0006\u0010m\u001a\u00020nH\u0016J\u0008\u0010o\u001a\u00020:H\u0002J9\u0010p\u001a\u00020i2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0017\u0010w\u001a\u0013\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020i0x¢\u0006\u0002\u0008zH\u0016J\u0008\u0010{\u001a\u00020!H\u0002J\u0008\u0010|\u001a\u00020!H\u0002J\u0012\u0010}\u001a\u00020i2\u0008\u0010~\u001a\u0004\u0018\u00010\u007fH\u0016J2\u0010\u0080\u0001\u001a\u00020i2\u0008\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0008\u0010\u0083\u0001\u001a\u00030\u0082\u00012\u0007\u0010]\u001a\u00030\u0084\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u0085\u0001\u0010\u0086\u0001J\t\u0010\u0087\u0001\u001a\u00020iH\u0002J!\u0010\u0088\u0001\u001a\u00020i*\u00020J2\u0006\u00100\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0006\u0008\u0089\u0001\u0010\u008a\u0001R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR,\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R,\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u0017@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010\r\"\u0004\u0008 \u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\"\u001a\u00020!2\u0006\u0010\t\u001a\u00020!@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010$\"\u0004\u0008%\u0010&R\u000e\u0010'\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010*\u001a\u0004\u0018\u00010)2\u0008\u0010\t\u001a\u0004\u0018\u00010)@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008+\u0010,\"\u0004\u0008-\u0010.R,\u00100\u001a\u00020/2\u0006\u0010\t\u001a\u00020/@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\u00081\u0010\u001a\"\u0004\u00082\u0010\u001cR\u0014\u00103\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00084\u0010$R\u001a\u00105\u001a\u00020!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00085\u0010$\"\u0004\u00086\u0010&R\u0014\u00107\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00088\u0010\u0013R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010\u0013R,\u0010@\u001a\u00020?2\u0006\u0010\t\u001a\u00020?@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\u0008A\u0010\u0013\"\u0004\u0008B\u0010\u0015R(\u0010D\u001a\u0004\u0018\u00010C2\u0008\u0010\t\u001a\u0004\u0018\u00010C@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008E\u0010F\"\u0004\u0008G\u0010HR\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010K\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008L\u0010\r\"\u0004\u0008M\u0010\u000fR$\u0010N\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008O\u0010\r\"\u0004\u0008P\u0010\u000fR$\u0010Q\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008R\u0010\r\"\u0004\u0008S\u0010\u000fR$\u0010T\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008U\u0010\r\"\u0004\u0008V\u0010\u000fR$\u0010W\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008X\u0010\r\"\u0004\u0008Y\u0010\u000fR$\u0010Z\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008[\u0010\r\"\u0004\u0008\\\u0010\u000fR\u0016\u0010]\u001a\u00020^X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0016R,\u0010_\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\u0008`\u0010\u0013\"\u0004\u0008a\u0010\u0015R$\u0010b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008c\u0010\r\"\u0004\u0008d\u0010\u000fR$\u0010e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008f\u0010\r\"\u0004\u0008g\u0010\u000f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u008b\u0001", d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV29;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "ownerId", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "I", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clip", "getClip", "()Z", "setClip", "(Z)V", "clipToBounds", "clipToOutline", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "hasDisplayList", "getHasDisplayList", "isInvalidated", "setInvalidated", "layerId", "getLayerId", "layerPaint", "Landroid/graphics/Paint;", "matrix", "Landroid/graphics/Matrix;", "outlineIsProvided", "getOwnerId", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderNode", "Landroid/graphics/RenderNode;", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "size", "Landroidx/compose/ui/geometry/Size;", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "applyClip", "", "calculateMatrix", "discardDisplayList", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "obtainLayerPaint", "record", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "requiresCompositingLayer", "requiresLayerPaint", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "x", "", "y", "Landroidx/compose/ui/unit/IntSize;", "setPosition-H0pRuoY", "(IIJ)V", "updateLayerProperties", "applyCompositingStrategy", "applyCompositingStrategy-Z1X6vPc", "(Landroid/graphics/RenderNode;I)V", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GraphicsLayerV29 implements androidx.compose.ui.graphics.layer.GraphicsLayerImpl {

    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private float cameraDistance;
    private final CanvasDrawScope canvasDrawScope;
    private final CanvasHolder canvasHolder;
    private boolean clip;
    private boolean clipToBounds;
    private boolean clipToOutline;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private Paint layerPaint;
    private Matrix matrix;
    private boolean outlineIsProvided;
    private final long ownerId;
    private long pivotOffset;
    private RenderEffect renderEffect;
    private final RenderNode renderNode;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private long size;
    private long spotShadowColor;
    private float translationX;
    private float translationY;
    public GraphicsLayerV29(long ownerId, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        super();
        this.ownerId = ownerId;
        this.canvasHolder = canvasDrawScope;
        this.canvasDrawScope = obj7;
        RenderNode renderNode = new RenderNode("graphicsLayer");
        this.renderNode = renderNode;
        this.size = Size.Companion.getZero-NH-jbRc();
        this.renderNode.setClipToBounds(false);
        applyCompositingStrategy-Z1X6vPc(this.renderNode, CompositingStrategy.Companion.getAuto-ke2Ky5w());
        int i = 1065353216;
        this.alpha = i;
        this.blendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
        this.pivotOffset = Offset.Companion.getUnspecified-F1C5BW0();
        this.scaleX = i;
        this.scaleY = i;
        this.ambientShadowColor = Color.Companion.getBlack-0d7_KjU();
        this.spotShadowColor = Color.Companion.getBlack-0d7_KjU();
        this.cameraDistance = 1090519040;
        this.compositingStrategy = CompositingStrategy.Companion.getAuto-ke2Ky5w();
        this.isInvalidated = true;
    }

    public GraphicsLayerV29(long l, CanvasHolder canvasHolder2, CanvasDrawScope canvasDrawScope3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        CanvasHolder obj3;
        CanvasDrawScope obj4;
        if (defaultConstructorMarker5 & 2 != 0) {
            obj3 = new CanvasHolder();
        }
        if (defaultConstructorMarker5 &= 4 != 0) {
            obj4 = new CanvasDrawScope();
        }
        super(l, canvasHolder2, obj3, obj4);
    }

    private final void applyClip() {
        boolean outlineIsProvided;
        int i2;
        int i;
        boolean clipToBounds;
        boolean clipToOutline;
        boolean outlineIsProvided2;
        int i3 = 0;
        if (getClip() && !this.outlineIsProvided) {
            i2 = !this.outlineIsProvided ? i : i3;
        } else {
        }
        if (getClip() && this.outlineIsProvided) {
            if (this.outlineIsProvided) {
            } else {
                i = i3;
            }
        } else {
        }
        if (i2 != this.clipToBounds) {
            this.clipToBounds = i2;
            this.renderNode.setClipToBounds(this.clipToBounds);
        }
        if (i != this.clipToOutline) {
            this.clipToOutline = i;
            this.renderNode.setClipToOutline(i);
        }
    }

    private final void applyCompositingStrategy-Z1X6vPc(RenderNode $this$applyCompositingStrategy_u2dZ1X6vPc, int compositingStrategy) {
        Paint layerPaint;
        int i;
        final int i2 = 1;
        if (CompositingStrategy.equals-impl0(compositingStrategy, CompositingStrategy.Companion.getOffscreen-ke2Ky5w())) {
            $this$applyCompositingStrategy_u2dZ1X6vPc.setUseCompositingLayer(i2, this.layerPaint);
            $this$applyCompositingStrategy_u2dZ1X6vPc.setHasOverlappingRendering(i2);
        } else {
            i = 0;
            if (CompositingStrategy.equals-impl0(compositingStrategy, CompositingStrategy.Companion.getModulateAlpha-ke2Ky5w())) {
                $this$applyCompositingStrategy_u2dZ1X6vPc.setUseCompositingLayer(i, this.layerPaint);
                $this$applyCompositingStrategy_u2dZ1X6vPc.setHasOverlappingRendering(i);
            } else {
                $this$applyCompositingStrategy_u2dZ1X6vPc.setUseCompositingLayer(i, this.layerPaint);
                $this$applyCompositingStrategy_u2dZ1X6vPc.setHasOverlappingRendering(i2);
            }
        }
    }

    private final Paint obtainLayerPaint() {
        Paint layerPaint;
        Paint paint;
        int i;
        if (this.layerPaint == null) {
            layerPaint = new Paint();
            i = 0;
            this.layerPaint = layerPaint;
        }
        return layerPaint;
    }

    private final boolean requiresCompositingLayer() {
        boolean requiresLayerPaint;
        int i;
        if (!CompositingStrategy.equals-impl0(getCompositingStrategy-ke2Ky5w(), CompositingStrategy.Companion.getOffscreen-ke2Ky5w()) && !requiresLayerPaint()) {
            if (!requiresLayerPaint()) {
                if (getRenderEffect() != null) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private final boolean requiresLayerPaint() {
        int i;
        boolean colorFilter;
        if (BlendMode.equals-impl0(getBlendMode-0nO6VwU(), BlendMode.Companion.getSrcOver-0nO6VwU())) {
            if (getColorFilter() != null) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final void updateLayerProperties() {
        RenderNode renderNode;
        int compositingStrategy-ke2Ky5w;
        if (requiresCompositingLayer()) {
            applyCompositingStrategy-Z1X6vPc(this.renderNode, CompositingStrategy.Companion.getOffscreen-ke2Ky5w());
        } else {
            applyCompositingStrategy-Z1X6vPc(this.renderNode, getCompositingStrategy-ke2Ky5w());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix calculateMatrix() {
        Matrix matrix;
        Matrix matrix2;
        int i;
        if (this.matrix == null) {
            matrix = new Matrix();
            i = 0;
            this.matrix = matrix;
        }
        this.renderNode.getMatrix(matrix);
        return matrix;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void draw(Canvas canvas) {
        AndroidCanvas_androidKt.getNativeCanvas(canvas).drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long getAmbientShadowColor-0d7_KjU() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int getBlendMode-0nO6VwU() {
        return this.blendMode;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getCameraDistance() {
        return this.cameraDistance;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public int getCompositingStrategy-ke2Ky5w() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean getHasDisplayList() {
        return this.renderNode.hasDisplayList();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long getLayerId() {
        return this.renderNode.getUniqueId();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long getOwnerId() {
        return this.ownerId;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long getPivotOffset-F1C5BW0() {
        return this.pivotOffset;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationX() {
        return this.rotationX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationY() {
        return this.rotationY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationZ() {
        return this.rotationZ;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getShadowElevation() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long getSpotShadowColor-0d7_KjU() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean isInvalidated() {
        return this.isInvalidated;
    }

    public void record(Density density, LayoutDirection layoutDirection, androidx.compose.ui.graphics.layer.GraphicsLayer layer, Function1<? super DrawScope, Unit> block) {
        CanvasHolder canvasHolder = this.canvasHolder;
        final int i2 = 0;
        canvasHolder.getAndroidCanvas().setInternalCanvas((Canvas)this.renderNode.beginRecording());
        int i3 = 0;
        DrawContext drawContext = this.canvasDrawScope.getDrawContext();
        final int i4 = 0;
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setGraphicsLayer(layer);
        drawContext.setSize-uvyYCjk(this.size);
        drawContext.setCanvas((Canvas)canvasHolder.getAndroidCanvas());
        block.invoke(this.canvasDrawScope);
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvasHolder.getAndroidCanvas().getInternalCanvas());
        this.renderNode.endRecording();
        setInvalidated(false);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float value) {
        this.alpha = value;
        this.renderNode.setAlpha(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAmbientShadowColor-8_81llA(long value) {
        this.ambientShadowColor = value;
        this.renderNode.setAmbientShadowColor(ColorKt.toArgb-8_81llA(value));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setBlendMode-s9anfk8(int value) {
        this.blendMode = value;
        final int i = 0;
        obtainLayerPaint().setBlendMode(AndroidBlendMode_androidKt.toAndroidBlendMode-s9anfk8(value));
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setCameraDistance(float value) {
        this.cameraDistance = value;
        this.renderNode.setCameraDistance(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setClip(boolean value) {
        this.clip = value;
        applyClip();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setColorFilter(ColorFilter value) {
        android.graphics.ColorFilter androidColorFilter;
        this.colorFilter = value;
        final int i = 0;
        if (value != null) {
            androidColorFilter = AndroidColorFilter_androidKt.asAndroidColorFilter(value);
        } else {
            androidColorFilter = 0;
        }
        obtainLayerPaint().setColorFilter(androidColorFilter);
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setCompositingStrategy-Wpw9cng(int value) {
        this.compositingStrategy = value;
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setInvalidated(boolean <set-?>) {
        this.isInvalidated = <set-?>;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setOutline(Outline outline) {
        int i;
        this.renderNode.setOutline(outline);
        i = outline != null ? 1 : 0;
        this.outlineIsProvided = i;
        applyClip();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setPivotOffset-k-4lQ0M(long value) {
        RenderNode renderNode;
        float y-impl;
        this.pivotOffset = value;
        if (OffsetKt.isUnspecified-k-4lQ0M(value)) {
            this.renderNode.resetPivot();
        } else {
            this.renderNode.setPivotX(Offset.getX-impl(value));
            this.renderNode.setPivotY(Offset.getY-impl(value));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setPosition-H0pRuoY(int x, int y, long size) {
        this.renderNode.setPosition(x, y, width-impl += x, height-impl += y);
        this.size = IntSizeKt.toSize-ozmzZPI(size);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRenderEffect(RenderEffect value) {
        int iNSTANCE;
        int renderNode;
        this.renderEffect = value;
        if (Build.VERSION.SDK_INT >= 31) {
            RenderNodeVerificationHelper.INSTANCE.setRenderEffect(this.renderNode, value);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationX(float value) {
        this.rotationX = value;
        this.renderNode.setRotationX(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationY(float value) {
        this.rotationY = value;
        this.renderNode.setRotationY(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationZ(float value) {
        this.rotationZ = value;
        this.renderNode.setRotationZ(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleX(float value) {
        this.scaleX = value;
        this.renderNode.setScaleX(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleY(float value) {
        this.scaleY = value;
        this.renderNode.setScaleY(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setShadowElevation(float value) {
        this.shadowElevation = value;
        this.renderNode.setElevation(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setSpotShadowColor-8_81llA(long value) {
        this.spotShadowColor = value;
        this.renderNode.setSpotShadowColor(ColorKt.toArgb-8_81llA(value));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationX(float value) {
        this.translationX = value;
        this.renderNode.setTranslationX(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationY(float value) {
        this.translationY = value;
        this.renderNode.setTranslationY(value);
    }
}
