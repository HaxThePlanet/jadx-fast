package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
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
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0008\u0001\u0018\u0000 \u008e\u00012\u00020\u0001:\u0002\u008e\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0008\u0010k\u001a\u00020lH\u0002J\u001a\u0010m\u001a\u00020l2\u0006\u00102\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\u0008n\u0010\u001eJ\u0008\u0010o\u001a\u00020>H\u0016J\u0008\u0010p\u001a\u00020lH\u0016J\r\u0010q\u001a\u00020lH\u0000¢\u0006\u0002\u0008rJ\u0010\u0010s\u001a\u00020l2\u0006\u0010t\u001a\u00020uH\u0016J\u0008\u0010v\u001a\u00020<H\u0002J;\u0010w\u001a\u00020l2\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020}2\u0019\u0010~\u001a\u0015\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0004\u0012\u00020l0\u007f¢\u0006\u0003\u0008\u0081\u0001H\u0016J\t\u0010\u0082\u0001\u001a\u00020#H\u0002J\u0015\u0010\u0083\u0001\u001a\u00020l2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016J1\u0010\u0086\u0001\u001a\u00020l2\u0008\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0008\u0010\u0089\u0001\u001a\u00030\u0088\u00012\u0006\u0010`\u001a\u00020aH\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u008a\u0001\u0010\u008b\u0001J\t\u0010\u008c\u0001\u001a\u00020lH\u0002J\u0011\u0010\u008d\u0001\u001a\u00020l2\u0006\u0010K\u001a\u00020LH\u0002R$\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R,\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R,\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0019@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR$\u0010 \u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\u000f\"\u0004\u0008\"\u0010\u0011R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010&\"\u0004\u0008'\u0010(R\u000e\u0010)\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010,\u001a\u0004\u0018\u00010+2\u0008\u0010\u000b\u001a\u0004\u0018\u00010+@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010.\"\u0004\u0008/\u00100R,\u00102\u001a\u0002012\u0006\u0010\u000b\u001a\u000201@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\u00083\u0010\u001c\"\u0004\u00084\u0010\u001eR\u0014\u00105\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00086\u0010&R\u001a\u00107\u001a\u00020#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00087\u0010&\"\u0004\u00088\u0010(R\u0014\u00109\u001a\u00020\u0005X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010\u0015R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008@\u0010\u0015R,\u0010B\u001a\u00020A2\u0006\u0010\u000b\u001a\u00020A@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\u0008C\u0010\u0015\"\u0004\u0008D\u0010\u0017R\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008G\u0010H\"\u0004\u0008I\u0010JR\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010M\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008N\u0010\u000f\"\u0004\u0008O\u0010\u0011R$\u0010P\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Q\u0010\u000f\"\u0004\u0008R\u0010\u0011R$\u0010S\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008T\u0010\u000f\"\u0004\u0008U\u0010\u0011R$\u0010V\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008W\u0010\u000f\"\u0004\u0008X\u0010\u0011R$\u0010Y\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Z\u0010\u000f\"\u0004\u0008[\u0010\u0011R$\u0010\\\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008]\u0010\u000f\"\u0004\u0008^\u0010\u0011R\u000e\u0010_\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010`\u001a\u00020aX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R,\u0010b\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\u0008c\u0010\u0015\"\u0004\u0008d\u0010\u0017R$\u0010e\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008f\u0010\u000f\"\u0004\u0008g\u0010\u0011R$\u0010h\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008i\u0010\u000f\"\u0004\u0008j\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u008f\u0001", d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "ownerView", "Landroid/view/View;", "ownerId", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroid/view/View;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "I", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clip", "getClip", "()Z", "setClip", "(Z)V", "clipToBounds", "clipToOutline", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "hasDisplayList", "getHasDisplayList", "isInvalidated", "setInvalidated", "layerId", "getLayerId", "layerPaint", "Landroid/graphics/Paint;", "matrix", "Landroid/graphics/Matrix;", "outlineIsProvided", "getOwnerId", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderNode", "Landroid/view/RenderNode;", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "shouldManuallySetCenterPivot", "size", "Landroidx/compose/ui/unit/IntSize;", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "applyClip", "", "applyCompositingStrategy", "applyCompositingStrategy-Wpw9cng", "calculateMatrix", "discardDisplayList", "discardDisplayListInternal", "discardDisplayListInternal$ui_graphics_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "obtainLayerPaint", "record", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "requiresCompositingLayer", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "x", "", "y", "setPosition-H0pRuoY", "(IIJ)V", "updateLayerProperties", "verifyShadowColorProperties", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GraphicsLayerV23 implements androidx.compose.ui.graphics.layer.GraphicsLayerImpl {

    public static final androidx.compose.ui.graphics.layer.GraphicsLayerV23.Companion Companion;
    private static final AtomicBoolean needToValidateAccess;
    private static boolean testFailCreateRenderNode;
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
    private final long layerId;
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
    private boolean shouldManuallySetCenterPivot;
    private long size;
    private long spotShadowColor;
    private float translationX;
    private float translationY;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23$Companion;", "", "()V", "needToValidateAccess", "Ljava/util/concurrent/atomic/AtomicBoolean;", "testFailCreateRenderNode", "", "getTestFailCreateRenderNode$ui_graphics_release", "()Z", "setTestFailCreateRenderNode$ui_graphics_release", "(Z)V", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final boolean getTestFailCreateRenderNode$ui_graphics_release() {
            return GraphicsLayerV23.access$getTestFailCreateRenderNode$cp();
        }

        public final void setTestFailCreateRenderNode$ui_graphics_release(boolean <set-?>) {
            GraphicsLayerV23.access$setTestFailCreateRenderNode$cp(<set-?>);
        }
    }
    static {
        GraphicsLayerV23.Companion companion = new GraphicsLayerV23.Companion(0);
        GraphicsLayerV23.Companion = companion;
        AtomicBoolean atomicBoolean = new AtomicBoolean(1);
        GraphicsLayerV23.needToValidateAccess = atomicBoolean;
    }

    public GraphicsLayerV23(View ownerView, long ownerId, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        boolean andSet;
        RenderNode renderNode;
        boolean overlappingRendering;
        super();
        this.ownerId = ownerId;
        this.canvasHolder = canvasDrawScope;
        this.canvasDrawScope = obj9;
        this.renderNode = RenderNode.create("Compose", ownerView);
        this.size = IntSize.Companion.getZero-YbymL2g();
        int i4 = 0;
        if (GraphicsLayerV23.needToValidateAccess.getAndSet(i4)) {
            andSet = 0;
            this.renderNode.setScaleX(this.renderNode.getScaleX());
            this.renderNode.setScaleY(this.renderNode.getScaleY());
            this.renderNode.setTranslationX(this.renderNode.getTranslationX());
            this.renderNode.setTranslationY(this.renderNode.getTranslationY());
            this.renderNode.setElevation(this.renderNode.getElevation());
            this.renderNode.setRotation(this.renderNode.getRotation());
            this.renderNode.setRotationX(this.renderNode.getRotationX());
            this.renderNode.setRotationY(this.renderNode.getRotationY());
            this.renderNode.setCameraDistance(this.renderNode.getCameraDistance());
            this.renderNode.setPivotX(this.renderNode.getPivotX());
            this.renderNode.setPivotY(this.renderNode.getPivotY());
            this.renderNode.setClipToOutline(this.renderNode.getClipToOutline());
            this.renderNode.setClipToBounds(i4);
            this.renderNode.setAlpha(this.renderNode.getAlpha());
            this.renderNode.isValid();
            this.renderNode.setLeftTopRightBottom(i4, i4, i4, i4);
            this.renderNode.offsetLeftAndRight(i4);
            this.renderNode.offsetTopAndBottom(i4);
            verifyShadowColorProperties(this.renderNode);
            discardDisplayListInternal$ui_graphics_release();
            this.renderNode.setLayerType(i4);
            this.renderNode.setHasOverlappingRendering(this.renderNode.hasOverlappingRendering());
        }
        if (GraphicsLayerV23.testFailCreateRenderNode) {
        } else {
            this.renderNode.setClipToBounds(i4);
            applyCompositingStrategy-Wpw9cng(CompositingStrategy.Companion.getAuto-ke2Ky5w());
            this.compositingStrategy = CompositingStrategy.Companion.getAuto-ke2Ky5w();
            this.blendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
            int i = 1065353216;
            this.alpha = i;
            this.pivotOffset = Offset.Companion.getUnspecified-F1C5BW0();
            this.scaleX = i;
            this.scaleY = i;
            this.ambientShadowColor = Color.Companion.getBlack-0d7_KjU();
            this.spotShadowColor = Color.Companion.getBlack-0d7_KjU();
            this.cameraDistance = 1090519040;
            this.isInvalidated = true;
        }
        NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError();
        throw noClassDefFoundError;
    }

    public GraphicsLayerV23(View view, long l2, CanvasHolder canvasHolder3, CanvasDrawScope canvasDrawScope4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
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
        super(view, l2, obj3, canvasHolder, canvasDrawScope);
    }

    public static final boolean access$getTestFailCreateRenderNode$cp() {
        return GraphicsLayerV23.testFailCreateRenderNode;
    }

    public static final void access$setTestFailCreateRenderNode$cp(boolean <set-?>) {
        GraphicsLayerV23.testFailCreateRenderNode = <set-?>;
    }

    private final void applyClip() {
        boolean outlineIsProvided;
        int i;
        int i2;
        boolean clipToBounds;
        boolean clipToOutline;
        boolean outlineIsProvided2;
        int i3 = 0;
        if (getClip() && !this.outlineIsProvided) {
            i = !this.outlineIsProvided ? i2 : i3;
        } else {
        }
        if (getClip() && this.outlineIsProvided) {
            if (this.outlineIsProvided) {
            } else {
                i2 = i3;
            }
        } else {
        }
        if (i != this.clipToBounds) {
            this.clipToBounds = i;
            this.renderNode.setClipToBounds(this.clipToBounds);
        }
        if (i2 != this.clipToOutline) {
            this.clipToOutline = i2;
            this.renderNode.setClipToOutline(i2);
        }
    }

    private final void applyCompositingStrategy-Wpw9cng(int compositingStrategy) {
        Paint layerPaint;
        int i;
        final RenderNode renderNode = this.renderNode;
        final int i2 = 0;
        final int i4 = 1;
        if (CompositingStrategy.equals-impl0(compositingStrategy, CompositingStrategy.Companion.getOffscreen-ke2Ky5w())) {
            renderNode.setLayerType(2);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(i4);
        } else {
            i = 0;
            if (CompositingStrategy.equals-impl0(compositingStrategy, CompositingStrategy.Companion.getModulateAlpha-ke2Ky5w())) {
                renderNode.setLayerType(i);
                renderNode.setLayerPaint(this.layerPaint);
                renderNode.setHasOverlappingRendering(i);
            } else {
                renderNode.setLayerType(i);
                renderNode.setLayerPaint(this.layerPaint);
                renderNode.setHasOverlappingRendering(i4);
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
        boolean colorFilter;
        int i;
        int offscreen-ke2Ky5w;
        if (!CompositingStrategy.equals-impl0(getCompositingStrategy-ke2Ky5w(), CompositingStrategy.Companion.getOffscreen-ke2Ky5w()) && BlendMode.equals-impl0(getBlendMode-0nO6VwU(), BlendMode.Companion.getSrcOver-0nO6VwU())) {
            if (BlendMode.equals-impl0(getBlendMode-0nO6VwU(), BlendMode.Companion.getSrcOver-0nO6VwU())) {
                if (getColorFilter() != null) {
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

    private final void updateLayerProperties() {
        int compositingStrategy-ke2Ky5w;
        if (requiresCompositingLayer()) {
            applyCompositingStrategy-Wpw9cng(CompositingStrategy.Companion.getOffscreen-ke2Ky5w());
        } else {
            applyCompositingStrategy-Wpw9cng(getCompositingStrategy-ke2Ky5w());
        }
    }

    private final void verifyShadowColorProperties(RenderNode renderNode) {
        RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(renderNode, RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(renderNode));
        RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(renderNode, RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(renderNode));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix calculateMatrix() {
        Matrix matrix2;
        Matrix matrix;
        int i;
        if (this.matrix == null) {
            matrix2 = new Matrix();
            i = 0;
            this.matrix = matrix2;
        }
        this.renderNode.getMatrix(matrix2);
        return matrix2;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void discardDisplayList() {
        discardDisplayListInternal$ui_graphics_release();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public final void discardDisplayListInternal$ui_graphics_release() {
        RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void draw(Canvas canvas) {
        final android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        Intrinsics.checkNotNull(nativeCanvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        (DisplayListCanvas)nativeCanvas.drawRenderNode(this.renderNode);
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
        return this.renderNode.isValid();
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
        final Object obj = this;
        DisplayListCanvas start = obj.renderNode.start(IntSize.getWidth-impl(obj.size), IntSize.getHeight-impl(obj.size));
        CanvasHolder canvasHolder2 = canvasHolder;
        final int i2 = 0;
        canvasHolder2.getAndroidCanvas().setInternalCanvas((Canvas)start);
        AndroidCanvas androidCanvas5 = androidCanvas3;
        final int i3 = 0;
        final CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        final int i4 = 0;
        DrawContext drawContext6 = canvasDrawScope2.getDrawContext();
        int i5 = 0;
        drawContext6.setDensity(density);
        drawContext6.setLayoutDirection(layoutDirection);
        drawContext6.setCanvas(androidCanvas5);
        drawContext6.setSize-uvyYCjk(IntSizeKt.toSize-ozmzZPI(obj.size));
        drawContext6.setGraphicsLayer(layer);
        androidCanvas5.save();
        block.invoke(canvasDrawScope2);
        androidCanvas5.restore();
        DrawContext drawContext7 = canvasDrawScope2.getDrawContext();
        int i6 = 0;
        drawContext7.setDensity(canvasDrawScope2.getDrawContext().getDensity());
        drawContext7.setLayoutDirection(canvasDrawScope2.getDrawContext().getLayoutDirection());
        drawContext7.setCanvas(canvasDrawScope2.getDrawContext().getCanvas());
        final int i7 = i2;
        drawContext7.setSize-uvyYCjk(canvasDrawScope2.getDrawContext().getSize-NH-jbRc());
        drawContext7.setGraphicsLayer(canvasDrawScope2.getDrawContext().getGraphicsLayer());
        canvasHolder2.getAndroidCanvas().setInternalCanvas(canvasHolder2.getAndroidCanvas().getInternalCanvas());
        obj.renderNode.end(start);
        obj.setInvalidated(false);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float value) {
        this.alpha = value;
        this.renderNode.setAlpha(value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAmbientShadowColor-8_81llA(long value) {
        this.ambientShadowColor = value;
        RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, ColorKt.toArgb-8_81llA(value));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setBlendMode-s9anfk8(int value) {
        boolean layerPaint;
        int i;
        PorterDuffXfermode porterDuffXfermode;
        android.graphics.PorterDuff.Mode porterDuffMode-s9anfk8;
        if (!BlendMode.equals-impl0(this.blendMode, value)) {
            this.blendMode = value;
            i = 0;
            porterDuffXfermode = new PorterDuffXfermode(AndroidBlendMode_androidKt.toPorterDuffMode-s9anfk8(value));
            obtainLayerPaint().setXfermode((Xfermode)porterDuffXfermode);
            updateLayerProperties();
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setCameraDistance(float value) {
        this.cameraDistance = value;
        this.renderNode.setCameraDistance(-value);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setClip(boolean value) {
        this.clip = value;
        applyClip();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setColorFilter(ColorFilter value) {
        RenderNode renderNode;
        Paint layerPaint;
        Paint paint;
        int i;
        android.graphics.ColorFilter androidColorFilter;
        this.colorFilter = value;
        if (value != null) {
            applyCompositingStrategy-Wpw9cng(CompositingStrategy.Companion.getOffscreen-ke2Ky5w());
            layerPaint = obtainLayerPaint();
            i = 0;
            layerPaint.setColorFilter(AndroidColorFilter_androidKt.asAndroidColorFilter(value));
            this.renderNode.setLayerPaint(layerPaint);
        } else {
            updateLayerProperties();
        }
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
        int y-impl;
        int i;
        long size;
        this.pivotOffset = value;
        if (OffsetKt.isUnspecified-k-4lQ0M(value)) {
            this.shouldManuallySetCenterPivot = true;
            i = 1073741824;
            this.renderNode.setPivotX(f /= i);
            this.renderNode.setPivotY(f2 /= i);
        } else {
            this.shouldManuallySetCenterPivot = false;
            this.renderNode.setPivotX(Offset.getX-impl(value));
            this.renderNode.setPivotY(Offset.getY-impl(value));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setPosition-H0pRuoY(int x, int y, long size) {
        boolean shouldManuallySetCenterPivot;
        int i2;
        int i;
        width-impl += x;
        this.renderNode.setLeftTopRightBottom(x, y, i2, height-impl2 += y);
        if (!IntSize.equals-impl0(this.size, i2) && this.shouldManuallySetCenterPivot) {
            if (this.shouldManuallySetCenterPivot) {
                i = 1073741824;
                this.renderNode.setPivotX(f /= i);
                this.renderNode.setPivotY(f2 /= i);
            }
            this.size = size;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRenderEffect(RenderEffect <set-?>) {
        this.renderEffect = <set-?>;
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
        this.renderNode.setRotation(value);
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
        RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, ColorKt.toArgb-8_81llA(value));
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
