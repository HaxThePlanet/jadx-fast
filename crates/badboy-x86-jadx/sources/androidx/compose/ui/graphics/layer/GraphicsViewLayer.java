package androidx.compose.ui.graphics.layer;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
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
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0000\u0018\u0000 \u0095\u00012\u00020\u0001:\u0002\u0095\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010u\u001a\u00020v2\u0006\u00106\u001a\u000205H\u0002ø\u0001\u0000¢\u0006\u0004\u0008w\u0010\u001eJ\u0008\u0010x\u001a\u00020yH\u0016J\u0008\u0010z\u001a\u00020vH\u0016J\u0010\u0010{\u001a\u00020v2\u0006\u0010|\u001a\u00020}H\u0016J\u0008\u0010~\u001a\u00020>H\u0002JC\u0010\u007f\u001a\u00020v2\u0008\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0008\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0008\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u001b\u0010\u0086\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0004\u0012\u00020v0\u0087\u0001¢\u0006\u0003\u0008\u0089\u0001H\u0016J\t\u0010\u008a\u0001\u001a\u00020vH\u0002J\t\u0010\u008b\u0001\u001a\u00020%H\u0002J\t\u0010\u008c\u0001\u001a\u00020%H\u0002J\u0015\u0010\u008d\u0001\u001a\u00020v2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J-\u0010\u0090\u0001\u001a\u00020v2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020s2\u0006\u0010e\u001a\u00020fH\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u0091\u0001\u0010\u0092\u0001J\t\u0010\u0093\u0001\u001a\u00020vH\u0002J\t\u0010\u0094\u0001\u001a\u00020vH\u0002R$\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R,\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R,\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0019@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR$\u0010 \u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008!\u0010\u000f\"\u0004\u0008\"\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R$\u0010&\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020%8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008'\u0010(\"\u0004\u0008)\u0010*R\u000e\u0010+\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R(\u00100\u001a\u0004\u0018\u00010/2\u0008\u0010\u000b\u001a\u0004\u0018\u00010/@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104R,\u00106\u001a\u0002052\u0006\u0010\u000b\u001a\u000205@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\u00087\u0010\u001c\"\u0004\u00088\u0010\u001eR\u001a\u00109\u001a\u00020%X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00089\u0010(\"\u0004\u0008:\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008<\u0010\u0015R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008@\u0010\u0015R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010F\u001a\u00020E2\u0006\u0010\u000b\u001a\u00020E@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\u0008G\u0010\u0015\"\u0004\u0008H\u0010\u0017R(\u0010J\u001a\u0004\u0018\u00010I2\u0008\u0010\u000b\u001a\u0004\u0018\u00010I@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008K\u0010L\"\u0004\u0008M\u0010NR\u0016\u0010O\u001a\n Q*\u0004\u0018\u00010P0PX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010R\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008S\u0010\u000f\"\u0004\u0008T\u0010\u0011R$\u0010U\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008V\u0010\u000f\"\u0004\u0008W\u0010\u0011R$\u0010X\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Y\u0010\u000f\"\u0004\u0008Z\u0010\u0011R$\u0010[\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\\\u0010\u000f\"\u0004\u0008]\u0010\u0011R$\u0010^\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008_\u0010\u000f\"\u0004\u0008`\u0010\u0011R$\u0010a\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008b\u0010\u000f\"\u0004\u0008c\u0010\u0011R\u000e\u0010d\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010e\u001a\u00020fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R,\u0010g\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\u0008h\u0010\u0015\"\u0004\u0008i\u0010\u0017R$\u0010j\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008k\u0010\u000f\"\u0004\u0008l\u0010\u0011R$\u0010m\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008n\u0010\u000f\"\u0004\u0008o\u0010\u0011R\u000e\u0010p\u001a\u00020qX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020sX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020sX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0096\u0001", d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsViewLayer;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "layerContainer", "Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;", "ownerId", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroidx/compose/ui/graphics/layer/view/DrawChildContainer;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "I", "cameraDistance", "getCameraDistance", "setCameraDistance", "getCanvasHolder", "()Landroidx/compose/ui/graphics/CanvasHolder;", "", "clip", "getClip", "()Z", "setClip", "(Z)V", "clipBoundsInvalidated", "clipRect", "Landroid/graphics/Rect;", "clipToBounds", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "isInvalidated", "setInvalidated", "layerId", "getLayerId", "layerPaint", "Landroid/graphics/Paint;", "outlineIsProvided", "getOwnerId", "picture", "Landroid/graphics/Picture;", "pictureCanvasHolder", "pictureDrawScope", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "resources", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "shouldManuallySetCenterPivot", "size", "Landroidx/compose/ui/unit/IntSize;", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "viewLayer", "Landroidx/compose/ui/graphics/layer/ViewLayer;", "x", "", "y", "applyCompositingLayer", "", "applyCompositingLayer-Wpw9cng", "calculateMatrix", "Landroid/graphics/Matrix;", "discardDisplayList", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "obtainLayerPaint", "record", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "recordDrawingOperations", "requiresCompositingLayer", "requiresLayerPaint", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "setPosition-H0pRuoY", "(IIJ)V", "updateClipBounds", "updateLayerProperties", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GraphicsViewLayer implements androidx.compose.ui.graphics.layer.GraphicsLayerImpl {

    public static final androidx.compose.ui.graphics.layer.GraphicsViewLayer.Companion Companion;
    private static final Canvas PlaceholderCanvas;
    private static final boolean mayRenderInSoftware;
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private final CanvasHolder canvasHolder;
    private boolean clipBoundsInvalidated;
    private final Rect clipRect;
    private boolean clipToBounds;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private final DrawChildContainer layerContainer;
    private final long layerId;
    private Paint layerPaint;
    private boolean outlineIsProvided;
    private final long ownerId;
    private final Picture picture;
    private final CanvasHolder pictureCanvasHolder;
    private final CanvasDrawScope pictureDrawScope;
    private long pivotOffset;
    private RenderEffect renderEffect;
    private final Resources resources;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private boolean shouldManuallySetCenterPivot;
    private long size;
    private long spotShadowColor;
    private float translationX;
    private float translationY;
    private final androidx.compose.ui.graphics.layer.ViewLayer viewLayer;
    private int x;
    private int y;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsViewLayer$Companion;", "", "()V", "PlaceholderCanvas", "Landroid/graphics/Canvas;", "getPlaceholderCanvas", "()Landroid/graphics/Canvas;", "mayRenderInSoftware", "", "getMayRenderInSoftware", "()Z", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final boolean getMayRenderInSoftware() {
            return GraphicsViewLayer.access$getMayRenderInSoftware$cp();
        }

        public final Canvas getPlaceholderCanvas() {
            return GraphicsViewLayer.access$getPlaceholderCanvas$cp();
        }
    }
    static {
        GraphicsViewLayer.Companion companion = new GraphicsViewLayer.Companion(0);
        GraphicsViewLayer.Companion = companion;
        GraphicsViewLayer.mayRenderInSoftware = lockHardwareCanvasAvailable ^= 1;
        GraphicsViewLayer.Companion.PlaceholderCanvas.1 anon = new GraphicsViewLayer.Companion.PlaceholderCanvas.1();
        GraphicsViewLayer.PlaceholderCanvas = (Canvas)anon;
    }

    public GraphicsViewLayer(DrawChildContainer layerContainer, long ownerId, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        int picture;
        int canvasDrawScope2;
        CanvasHolder canvasHolder2;
        super();
        this.layerContainer = layerContainer;
        this.ownerId = ownerId;
        this.canvasHolder = canvasDrawScope;
        ViewLayer viewLayer = new ViewLayer((View)this.layerContainer, this.canvasHolder, obj8);
        this.viewLayer = viewLayer;
        this.resources = this.layerContainer.getResources();
        Rect rect = new Rect();
        this.clipRect = rect;
        int i3 = 0;
        if (GraphicsViewLayer.mayRenderInSoftware) {
            picture = new Picture();
        } else {
            picture = i3;
        }
        this.picture = picture;
        if (GraphicsViewLayer.mayRenderInSoftware) {
            canvasDrawScope2 = new CanvasDrawScope();
        } else {
            canvasDrawScope2 = i3;
        }
        this.pictureDrawScope = canvasDrawScope2;
        if (GraphicsViewLayer.mayRenderInSoftware) {
            canvasHolder2 = new CanvasHolder();
        } else {
            canvasHolder2 = i3;
        }
        this.pictureCanvasHolder = canvasHolder2;
        this.layerContainer.addView((View)this.viewLayer);
        this.viewLayer.setClipBounds(i3);
        this.size = IntSize.Companion.getZero-YbymL2g();
        this.isInvalidated = true;
        this.layerId = (long)viewId;
        this.blendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
        this.compositingStrategy = CompositingStrategy.Companion.getAuto-ke2Ky5w();
        int i2 = 1065353216;
        this.alpha = i2;
        this.pivotOffset = Offset.Companion.getZero-F1C5BW0();
        this.scaleX = i2;
        this.scaleY = i2;
        this.ambientShadowColor = Color.Companion.getBlack-0d7_KjU();
        this.spotShadowColor = Color.Companion.getBlack-0d7_KjU();
    }

    public GraphicsViewLayer(DrawChildContainer drawChildContainer, long l2, CanvasHolder canvasHolder3, CanvasDrawScope canvasDrawScope4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        CanvasHolder canvasHolder;
        CanvasDrawScope canvasDrawScope;
        CanvasHolder obj10;
        CanvasDrawScope obj11;
        if (defaultConstructorMarker6 & 4 != 0) {
            obj10 = new CanvasHolder();
            canvasHolder = obj10;
        } else {
            canvasHolder = canvasDrawScope4;
        }
        if (defaultConstructorMarker6 & 8 != 0) {
            obj11 = new CanvasDrawScope();
            canvasDrawScope = obj11;
        } else {
            canvasDrawScope = i5;
        }
        super(drawChildContainer, l2, obj3, canvasHolder, canvasDrawScope);
    }

    public static final boolean access$getMayRenderInSoftware$cp() {
        return GraphicsViewLayer.mayRenderInSoftware;
    }

    public static final Canvas access$getPlaceholderCanvas$cp() {
        return GraphicsViewLayer.PlaceholderCanvas;
    }

    private final void applyCompositingLayer-Wpw9cng(int compositingStrategy) {
        androidx.compose.ui.graphics.layer.ViewLayer viewLayer;
        int i;
        int i2;
        Paint layerPaint;
        i = 1;
        if (CompositingStrategy.equals-impl0(compositingStrategy, CompositingStrategy.Companion.getOffscreen-ke2Ky5w())) {
            this.viewLayer.setLayerType(2, this.layerPaint);
        } else {
            i2 = 0;
            if (CompositingStrategy.equals-impl0(compositingStrategy, CompositingStrategy.Companion.getModulateAlpha-ke2Ky5w())) {
                this.viewLayer.setLayerType(i2, this.layerPaint);
                i = i2;
            } else {
                this.viewLayer.setLayerType(i2, this.layerPaint);
            }
        }
        this.viewLayer.setCanUseCompositingLayer$ui_graphics_release(i);
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

    private final void recordDrawingOperations() {
        CanvasHolder canvasHolder;
        canvasHolder = this.canvasHolder;
        final int i = 0;
        canvasHolder.getAndroidCanvas().setInternalCanvas(GraphicsViewLayer.PlaceholderCanvas);
        final int i2 = 0;
        this.layerContainer.drawChild$ui_graphics_release((Canvas)canvasHolder.getAndroidCanvas(), (View)this.viewLayer, this.viewLayer.getDrawingTime());
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvasHolder.getAndroidCanvas().getInternalCanvas());
    }

    private final boolean requiresCompositingLayer() {
        int i;
        boolean requiresLayerPaint;
        if (!CompositingStrategy.equals-impl0(getCompositingStrategy-ke2Ky5w(), CompositingStrategy.Companion.getOffscreen-ke2Ky5w())) {
            if (requiresLayerPaint()) {
                i = 1;
            } else {
                i = 0;
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

    private final void updateClipBounds() {
        boolean clipBoundsInvalidated;
        int clipRect;
        boolean outlineIsProvided;
        Rect rect;
        int i;
        int height;
        if (this.clipBoundsInvalidated) {
            if (getClip() && !this.outlineIsProvided) {
                if (!this.outlineIsProvided) {
                    rect = clipRect;
                    i = 0;
                    int i2 = 0;
                    rect.left = i2;
                    rect.top = i2;
                    rect.right = this.viewLayer.getWidth();
                    rect.bottom = this.viewLayer.getHeight();
                } else {
                    clipRect = 0;
                }
            } else {
            }
            this.viewLayer.setClipBounds(clipRect);
        }
    }

    private final void updateLayerProperties() {
        int compositingStrategy-ke2Ky5w;
        if (requiresCompositingLayer()) {
            applyCompositingLayer-Wpw9cng(CompositingStrategy.Companion.getOffscreen-ke2Ky5w());
        } else {
            applyCompositingLayer-Wpw9cng(getCompositingStrategy-ke2Ky5w());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix calculateMatrix() {
        return this.viewLayer.getMatrix();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void discardDisplayList() {
        this.layerContainer.removeViewInLayout((View)this.viewLayer);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void draw(Canvas canvas) {
        Object layerContainer;
        androidx.compose.ui.graphics.layer.ViewLayer viewLayer;
        long drawingTime;
        updateClipBounds();
        final Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            this.layerContainer.drawChild$ui_graphics_release(canvas, (View)this.viewLayer, this.viewLayer.getDrawingTime());
        } else {
            layerContainer = this.picture;
            if (layerContainer != null) {
                viewLayer = 0;
                nativeCanvas.drawPicture(layerContainer);
            }
        }
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
        return cameraDistance /= f;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final CanvasHolder getCanvasHolder() {
        return this.canvasHolder;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean getClip() {
        int i;
        boolean clipToOutline;
        if (!this.clipToBounds) {
            if (this.viewLayer.getClipToOutline()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
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
    public long getLayerId() {
        return this.layerId;
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
        Object layerContainer;
        Object pictureCanvasHolder;
        Object prevCanvas$iv;
        androidx.compose.ui.graphics.layer.ViewLayer viewLayer;
        int i5;
        int i4;
        Canvas beginRecording;
        long l;
        Canvas internalCanvas;
        AndroidCanvas androidCanvas;
        int i3;
        CanvasDrawScope pictureDrawScope;
        long size-ozmzZPI;
        int i;
        int i2;
        Density density2;
        LayoutDirection layoutDirection2;
        Canvas canvas;
        Canvas canvas2;
        long l2;
        CanvasHolder this_$iv;
        prevCanvas$iv = this;
        final Density density4 = density;
        final LayoutDirection layoutDirection3 = layoutDirection;
        final Function1 function1 = block;
        if (prevCanvas$iv.viewLayer.getParent() == null) {
            prevCanvas$iv.layerContainer.addView((View)prevCanvas$iv.viewLayer);
        }
        prevCanvas$iv.viewLayer.setDrawParams(density4, layoutDirection3, layer, function1);
        prevCanvas$iv.viewLayer.setVisibility(4);
        prevCanvas$iv.viewLayer.setVisibility(0);
        prevCanvas$iv.recordDrawingOperations();
        pictureCanvasHolder = prevCanvas$iv.picture;
        i5 = pictureCanvasHolder;
        i4 = 0;
        pictureCanvasHolder = prevCanvas$iv.pictureCanvasHolder;
        if (prevCanvas$iv.viewLayer.isAttachedToWindow() && pictureCanvasHolder != null && pictureCanvasHolder != null) {
            prevCanvas$iv.viewLayer.setVisibility(4);
            prevCanvas$iv.viewLayer.setVisibility(0);
            prevCanvas$iv.recordDrawingOperations();
            pictureCanvasHolder = prevCanvas$iv.picture;
            if (pictureCanvasHolder != null) {
                i5 = pictureCanvasHolder;
                i4 = 0;
                pictureCanvasHolder = prevCanvas$iv.pictureCanvasHolder;
                if (pictureCanvasHolder != null) {
                    l = 0;
                    pictureCanvasHolder.getAndroidCanvas().setInternalCanvas(i5.beginRecording(IntSize.getWidth-impl(prevCanvas$iv.size), IntSize.getHeight-impl(prevCanvas$iv.size)));
                    androidCanvas = pictureCanvasHolder.getAndroidCanvas();
                    i3 = 0;
                    pictureDrawScope = prevCanvas$iv.pictureDrawScope;
                    if (pictureDrawScope != null) {
                        i = 0;
                        CanvasDrawScope.DrawParams drawParams = pictureDrawScope.getDrawParams();
                        int i7 = 0;
                        this_$iv = pictureCanvasHolder;
                        CanvasDrawScope.DrawParams this_$iv2 = drawParams3;
                        this_$iv2.setDensity(density4);
                        this_$iv2.setLayoutDirection(layoutDirection3);
                        this_$iv2.setCanvas((Canvas)androidCanvas);
                        this_$iv2.setSize-uvyYCjk(IntSizeKt.toSize-ozmzZPI(prevCanvas$iv.size));
                        androidCanvas.save();
                        function1.invoke(pictureDrawScope);
                        androidCanvas.restore();
                        pictureCanvasHolder = pictureDrawScope.getDrawParams();
                        i2 = 0;
                        Density density3 = density5;
                        pictureCanvasHolder.setDensity(density3);
                        density2 = density3;
                        LayoutDirection prevDensity$iv = layoutDirection4;
                        pictureCanvasHolder.setLayoutDirection(prevDensity$iv);
                        layoutDirection2 = prevDensity$iv;
                        Canvas prevLayoutDirection$iv = canvas2;
                        pictureCanvasHolder.setCanvas(prevLayoutDirection$iv);
                        canvas = prevLayoutDirection$iv;
                        pictureCanvasHolder.setSize-uvyYCjk(drawParams.component4-NH-jbRc());
                    } else {
                        this_$iv = pictureCanvasHolder;
                    }
                    this_$iv.getAndroidCanvas().setInternalCanvas(pictureCanvasHolder.getAndroidCanvas().getInternalCanvas());
                    pictureCanvasHolder = Unit.INSTANCE;
                }
                i5.endRecording();
            }
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float value) {
        this.alpha = value;
        this.viewLayer.setAlpha(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAmbientShadowColor-8_81llA(long value) {
        this.ambientShadowColor = value;
        ViewLayerVerificationHelper28.INSTANCE.setOutlineAmbientShadowColor((View)this.viewLayer, ColorKt.toArgb-8_81llA(value));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setBlendMode-s9anfk8(int value) {
        this.blendMode = value;
        final int i = 0;
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(AndroidBlendMode_androidKt.toPorterDuffMode-s9anfk8(value));
        obtainLayerPaint().setXfermode((Xfermode)porterDuffXfermode);
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setCameraDistance(float value) {
        this.viewLayer.setCameraDistance(f *= value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setClip(boolean value) {
        int i;
        boolean outlineIsProvided2;
        int i2;
        boolean outlineIsProvided;
        final int i3 = 1;
        if (value != null && !this.outlineIsProvided) {
            i2 = !this.outlineIsProvided ? i3 : i;
        } else {
        }
        this.clipToBounds = i2;
        this.clipBoundsInvalidated = i3;
        if (value != null && this.outlineIsProvided) {
            if (this.outlineIsProvided) {
                i = i3;
            }
        }
        this.viewLayer.setClipToOutline(i);
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
        int viewLayer;
        boolean clipToBounds;
        viewLayer = 1;
        final int i2 = 0;
        this.viewLayer.setClipToOutline(viewLayer);
        if (getClip() && outline != null && this.clipToBounds) {
            if (outline != null) {
                this.viewLayer.setClipToOutline(viewLayer);
                if (this.clipToBounds) {
                    this.clipToBounds = i2;
                    this.clipBoundsInvalidated = viewLayer;
                }
            }
        }
        if (outline != null) {
        } else {
            viewLayer = i2;
        }
        this.outlineIsProvided = viewLayer;
        if (layerOutline ^= viewLayer != 0) {
            this.viewLayer.invalidate();
            recordDrawingOperations();
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setPivotOffset-k-4lQ0M(long value) {
        Object viewLayer2;
        androidx.compose.ui.graphics.layer.ViewLayer viewLayer;
        this.pivotOffset = value;
        if (OffsetKt.isUnspecified-k-4lQ0M(value)) {
            ViewLayerVerificationHelper28.INSTANCE.resetPivot((View)this.viewLayer);
        } else {
            this.shouldManuallySetCenterPivot = false;
            this.viewLayer.setPivotX(Offset.getX-impl(value));
            this.viewLayer.setPivotY(Offset.getY-impl(value));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setPosition-H0pRuoY(int x, int y, long size) {
        int shouldManuallySetCenterPivot;
        int viewLayer;
        boolean clip;
        long l;
        int i;
        if (!IntSize.equals-impl0(this.size, obj1)) {
            if (getClip()) {
                this.clipBoundsInvalidated = true;
            }
            this.viewLayer.layout(x, y, width-impl += x, height-impl2 += y);
            this.size = size;
            if (this.shouldManuallySetCenterPivot) {
                i = 1073741824;
                this.viewLayer.setPivotX(f /= i);
                this.viewLayer.setPivotY(f2 /= i);
            }
        } else {
            if (this.x != x) {
                this.viewLayer.offsetLeftAndRight(x - i3);
            }
            if (this.y != y) {
                this.viewLayer.offsetTopAndBottom(y - i2);
            }
        }
        this.x = x;
        this.y = y;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRenderEffect(RenderEffect value) {
        int iNSTANCE;
        int viewLayer;
        this.renderEffect = value;
        if (Build.VERSION.SDK_INT >= 31) {
            ViewLayerVerificationHelper31.INSTANCE.setRenderEffect((View)this.viewLayer, value);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationX(float value) {
        this.rotationX = value;
        this.viewLayer.setRotationX(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationY(float value) {
        this.rotationY = value;
        this.viewLayer.setRotationY(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationZ(float value) {
        this.rotationZ = value;
        this.viewLayer.setRotation(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleX(float value) {
        this.scaleX = value;
        this.viewLayer.setScaleX(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleY(float value) {
        this.scaleY = value;
        this.viewLayer.setScaleY(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setShadowElevation(float value) {
        this.shadowElevation = value;
        this.viewLayer.setElevation(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setSpotShadowColor-8_81llA(long value) {
        this.spotShadowColor = value;
        ViewLayerVerificationHelper28.INSTANCE.setOutlineSpotShadowColor((View)this.viewLayer, ColorKt.toArgb-8_81llA(value));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationX(float value) {
        this.translationX = value;
        this.viewLayer.setTranslationX(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationY(float value) {
        this.translationY = value;
        this.viewLayer.setTranslationY(value);
    }
}
