package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.CompositingStrategy.Companion;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u001f\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0001\u0018\u0000 \u0086\u00012\u00020\u0001:\u0002\u0086\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010e\u001a\u00020fH\u0016J\u0008\u0010g\u001a\u00020fH\u0002J\u0010\u0010h\u001a\u00020f2\u0006\u0010i\u001a\u00020jH\u0016J\u0008\u0010k\u001a\u00020lH\u0016J\u0010\u0010m\u001a\u00020f2\u0006\u0010n\u001a\u00020oH\u0016J\r\u0010p\u001a\u00020\u000cH\u0000¢\u0006\u0002\u0008qJ\u0010\u0010r\u001a\u00020f2\u0006\u0010n\u001a\u00020oH\u0016J\r\u0010s\u001a\u00020\u0018H\u0000¢\u0006\u0002\u0008tJ\u0010\u0010u\u001a\u00020f2\u0006\u0010v\u001a\u00020\u000cH\u0016J\u0010\u0010w\u001a\u00020f2\u0006\u0010v\u001a\u00020\u000cH\u0016J.\u0010x\u001a\u00020f2\u0006\u0010y\u001a\u00020z2\u0008\u0010{\u001a\u0004\u0018\u00010|2\u0012\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\u007f\u0012\u0004\u0012\u00020f0~H\u0016J\u0011\u0010\u0080\u0001\u001a\u00020\u00182\u0006\u0010s\u001a\u00020\u0018H\u0016J\u0015\u0010\u0081\u0001\u001a\u00020f2\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J)\u0010\u0084\u0001\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u000c2\u0006\u0010V\u001a\u00020\u000c2\u0006\u0010A\u001a\u00020\u000c2\u0006\u0010\u0012\u001a\u00020\u000cH\u0016J\u0011\u0010\u0085\u0001\u001a\u00020f2\u0006\u0010?\u001a\u00020@H\u0002R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR$\u0010\r\u001a\u00020\u000c2\u0006\u0010\u0005\u001a\u00020\u000c8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u000f\"\u0004\u0008\u0014\u0010\u0011R$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0016\u0010\t\"\u0004\u0008\u0017\u0010\u000bR$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u001f\u0010\u001b\"\u0004\u0008 \u0010\u001dR*\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008#\u0010\u000f\"\u0004\u0008$\u0010\u0011R$\u0010%\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008&\u0010\t\"\u0004\u0008'\u0010\u000bR\u0014\u0010(\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008)\u0010\u001bR\u0014\u0010*\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008+\u0010\u000fR\u0016\u0010,\u001a\u00020!X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010-R\u001a\u0010.\u001a\u00020\u000cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008/\u0010\u000f\"\u0004\u00080\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R$\u00103\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u00084\u0010\t\"\u0004\u00085\u0010\u000bR$\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u00087\u0010\t\"\u0004\u00088\u0010\u000bR\u001c\u00109\u001a\u0004\u0018\u00010:X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008;\u0010<\"\u0004\u0008=\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020\u000cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008B\u0010\u000f\"\u0004\u0008C\u0010\u0011R$\u0010D\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008E\u0010\t\"\u0004\u0008F\u0010\u000bR$\u0010G\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008H\u0010\t\"\u0004\u0008I\u0010\u000bR$\u0010J\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008K\u0010\t\"\u0004\u0008L\u0010\u000bR$\u0010M\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008N\u0010\t\"\u0004\u0008O\u0010\u000bR$\u0010P\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008Q\u0010\t\"\u0004\u0008R\u0010\u000bR$\u0010S\u001a\u00020\u000c2\u0006\u0010\u0005\u001a\u00020\u000c8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008T\u0010\u000f\"\u0004\u0008U\u0010\u0011R\u001a\u0010V\u001a\u00020\u000cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008W\u0010\u000f\"\u0004\u0008X\u0010\u0011R$\u0010Y\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008Z\u0010\t\"\u0004\u0008[\u0010\u000bR$\u0010\\\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008]\u0010\t\"\u0004\u0008^\u0010\u000bR\u0014\u0010_\u001a\u00020`8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008a\u0010bR\u0014\u0010c\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008d\u0010\u000f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0087\u0001", d2 = {"Landroidx/compose/ui/platform/RenderNodeApi23;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "", "ambientShadowColor", "getAmbientShadowColor", "()I", "setAmbientShadowColor", "(I)V", "bottom", "getBottom", "setBottom", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clipToBounds", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "clipToOutline", "getClipToOutline", "setClipToOutline", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "elevation", "getElevation", "setElevation", "hasDisplayList", "getHasDisplayList", "height", "getHeight", "internalCompositingStrategy", "I", "left", "getLeft", "setLeft", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderNode", "Landroid/view/RenderNode;", "right", "getRight", "setRight", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "spotShadowColor", "getSpotShadowColor", "setSpotShadowColor", "top", "getTop", "setTop", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "uniqueId", "", "getUniqueId", "()J", "width", "getWidth", "discardDisplayList", "", "discardDisplayListInternal", "drawInto", "canvas", "Landroid/graphics/Canvas;", "dumpRenderNodeData", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "getInverseMatrix", "matrix", "Landroid/graphics/Matrix;", "getLayerType", "getLayerType$ui_release", "getMatrix", "hasOverlappingRendering", "hasOverlappingRendering$ui_release", "offsetLeftAndRight", "offset", "offsetTopAndBottom", "record", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "setHasOverlappingRendering", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "verifyShadowColorProperties", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RenderNodeApi23 implements androidx.compose.ui.platform.DeviceRenderNode {

    public static final int $stable = 8;
    public static final androidx.compose.ui.platform.RenderNodeApi23.Companion Companion;
    private static boolean needToValidateAccess;
    private static boolean testFailCreateRenderNode;
    private int bottom;
    private boolean clipToBounds;
    private int internalCompositingStrategy;
    private int left;
    private final androidx.compose.ui.platform.AndroidComposeView ownerView;
    private RenderEffect renderEffect;
    private final RenderNode renderNode;
    private int right;
    private int top;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Landroidx/compose/ui/platform/RenderNodeApi23$Companion;", "", "()V", "needToValidateAccess", "", "testFailCreateRenderNode", "getTestFailCreateRenderNode$ui_release", "()Z", "setTestFailCreateRenderNode$ui_release", "(Z)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final boolean getTestFailCreateRenderNode$ui_release() {
            return RenderNodeApi23.access$getTestFailCreateRenderNode$cp();
        }

        public final void setTestFailCreateRenderNode$ui_release(boolean <set-?>) {
            RenderNodeApi23.access$setTestFailCreateRenderNode$cp(<set-?>);
        }
    }
    static {
        RenderNodeApi23.Companion companion = new RenderNodeApi23.Companion(0);
        RenderNodeApi23.Companion = companion;
        int i = 8;
        RenderNodeApi23.needToValidateAccess = true;
    }

    public RenderNodeApi23(androidx.compose.ui.platform.AndroidComposeView ownerView) {
        boolean needToValidateAccess;
        Object renderNode;
        int i;
        boolean overlappingRendering;
        super();
        this.ownerView = ownerView;
        this.renderNode = RenderNode.create("Compose", (View)this.ownerView);
        this.internalCompositingStrategy = CompositingStrategy.Companion.getAuto--NrFUSI();
        if (RenderNodeApi23.needToValidateAccess) {
            needToValidateAccess = 0;
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
            i = 0;
            this.renderNode.setClipToBounds(i);
            this.renderNode.setAlpha(this.renderNode.getAlpha());
            this.renderNode.isValid();
            this.renderNode.setLeftTopRightBottom(i, i, i, i);
            this.renderNode.offsetLeftAndRight(i);
            this.renderNode.offsetTopAndBottom(i);
            verifyShadowColorProperties(this.renderNode);
            discardDisplayListInternal();
            this.renderNode.setLayerType(i);
            this.renderNode.setHasOverlappingRendering(this.renderNode.hasOverlappingRendering());
            RenderNodeApi23.needToValidateAccess = i;
        }
        if (RenderNodeApi23.testFailCreateRenderNode) {
        } else {
        }
        NoClassDefFoundError noClassDefFoundError = new NoClassDefFoundError();
        throw noClassDefFoundError;
    }

    public static final boolean access$getTestFailCreateRenderNode$cp() {
        return RenderNodeApi23.testFailCreateRenderNode;
    }

    public static final void access$setTestFailCreateRenderNode$cp(boolean <set-?>) {
        RenderNodeApi23.testFailCreateRenderNode = <set-?>;
    }

    private final void discardDisplayListInternal() {
        RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
    }

    private final void verifyShadowColorProperties(RenderNode renderNode) {
        RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(renderNode, RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(renderNode));
        RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(renderNode, RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(renderNode));
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void discardDisplayList() {
        discardDisplayListInternal();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void drawInto(Canvas canvas) {
        Intrinsics.checkNotNull(canvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        (DisplayListCanvas)canvas.drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public androidx.compose.ui.platform.DeviceRenderNodeData dumpRenderNodeData() {
        final Object obj = this;
        DeviceRenderNodeData deviceRenderNodeData = new DeviceRenderNodeData(0, obj3, 0, 0, 0, 0, 0, 0, obj.renderNode.getScaleX(), obj.renderNode.getScaleY(), obj.renderNode.getTranslationX(), obj.renderNode.getTranslationY(), obj.renderNode.getElevation(), obj.getAmbientShadowColor(), obj.getSpotShadowColor(), obj.renderNode.getRotation(), obj.renderNode.getRotationX(), obj.renderNode.getRotationY(), obj.renderNode.getCameraDistance(), obj.renderNode.getPivotX(), obj.renderNode.getPivotY(), obj.renderNode.getClipToOutline(), obj.getClipToBounds(), obj.renderNode.getAlpha(), obj.getRenderEffect(), obj.internalCompositingStrategy, 0);
        return deviceRenderNodeData;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getAmbientShadowColor() {
        return RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getBottom() {
        return this.bottom;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getCameraDistance() {
        return -cameraDistance;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToBounds() {
        return this.clipToBounds;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToOutline() {
        return this.renderNode.getClipToOutline();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getCompositingStrategy--NrFUSI() {
        return this.internalCompositingStrategy;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getElevation() {
        return this.renderNode.getElevation();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getHasDisplayList() {
        return this.renderNode.isValid();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getHeight() {
        return bottom -= top;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void getInverseMatrix(Matrix matrix) {
        this.renderNode.getInverseMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final int getLayerType$ui_release() {
        int i;
        i = CompositingStrategy.equals-impl0(this.internalCompositingStrategy, CompositingStrategy.Companion.getOffscreen--NrFUSI()) ? 2 : 0;
        return i;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getLeft() {
        return this.left;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void getMatrix(Matrix matrix) {
        this.renderNode.getMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final androidx.compose.ui.platform.AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getPivotX() {
        return this.renderNode.getPivotX();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getPivotY() {
        return this.renderNode.getPivotY();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getRight() {
        return this.right;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getRotationX() {
        return this.renderNode.getRotationX();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getRotationY() {
        return this.renderNode.getRotationY();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getRotationZ() {
        return this.renderNode.getRotation();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getScaleX() {
        return this.renderNode.getScaleX();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getScaleY() {
        return this.renderNode.getScaleY();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getSpotShadowColor() {
        return RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getTop() {
        return this.top;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getTranslationX() {
        return this.renderNode.getTranslationX();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getTranslationY() {
        return this.renderNode.getTranslationY();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public long getUniqueId() {
        return 0;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getWidth() {
        return right -= left;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final boolean hasOverlappingRendering$ui_release() {
        return this.renderNode.hasOverlappingRendering();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetLeftAndRight(int offset) {
        setLeft(left += offset);
        setRight(right += offset);
        this.renderNode.offsetLeftAndRight(offset);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetTopAndBottom(int offset) {
        setTop(top += offset);
        setBottom(bottom += offset);
        this.renderNode.offsetTopAndBottom(offset);
    }

    public void record(CanvasHolder canvasHolder, Path clipPath, Function1<? super Canvas, Unit> drawBlock) {
        int i3;
        int i2;
        int i;
        DisplayListCanvas start = this.renderNode.start(getWidth(), getHeight());
        Object obj = canvasHolder;
        int i4 = 0;
        obj.getAndroidCanvas().setInternalCanvas((Canvas)start);
        AndroidCanvas androidCanvas3 = obj.getAndroidCanvas();
        int i5 = 0;
        if (clipPath != null) {
            (Canvas)androidCanvas3.save();
            Canvas.clipPath-mtrdD-E$default(androidCanvas3, clipPath, 0, 2, 0);
        }
        drawBlock.invoke(androidCanvas3);
        if (clipPath != null) {
            androidCanvas3.restore();
        }
        obj.getAndroidCanvas().setInternalCanvas(obj.getAndroidCanvas().getInternalCanvas());
        this.renderNode.end(start);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAlpha(float value) {
        this.renderNode.setAlpha(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAmbientShadowColor(int value) {
        RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setBottom(int <set-?>) {
        this.bottom = <set-?>;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setCameraDistance(float value) {
        this.renderNode.setCameraDistance(-value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToBounds(boolean value) {
        this.clipToBounds = value;
        this.renderNode.setClipToBounds(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToOutline(boolean value) {
        this.renderNode.setClipToOutline(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setCompositingStrategy-aDBOjCE(int value) {
        RenderNode renderNode;
        int i;
        final int i2 = 1;
        if (CompositingStrategy.equals-impl0(value, CompositingStrategy.Companion.getOffscreen--NrFUSI())) {
            this.renderNode.setLayerType(2);
            this.renderNode.setHasOverlappingRendering(i2);
        } else {
            i = 0;
            if (CompositingStrategy.equals-impl0(value, CompositingStrategy.Companion.getModulateAlpha--NrFUSI())) {
                this.renderNode.setLayerType(i);
                this.renderNode.setHasOverlappingRendering(i);
            } else {
                this.renderNode.setLayerType(i);
                this.renderNode.setHasOverlappingRendering(i2);
            }
        }
        this.internalCompositingStrategy = value;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setElevation(float value) {
        this.renderNode.setElevation(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean setHasOverlappingRendering(boolean hasOverlappingRendering) {
        return this.renderNode.setHasOverlappingRendering(hasOverlappingRendering);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setLeft(int <set-?>) {
        this.left = <set-?>;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setOutline(Outline outline) {
        this.renderNode.setOutline(outline);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setPivotX(float value) {
        this.renderNode.setPivotX(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setPivotY(float value) {
        this.renderNode.setPivotY(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean setPosition(int left, int top, int right, int bottom) {
        setLeft(left);
        setTop(top);
        setRight(right);
        setBottom(bottom);
        return this.renderNode.setLeftTopRightBottom(left, top, right, bottom);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRenderEffect(RenderEffect <set-?>) {
        this.renderEffect = <set-?>;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRight(int <set-?>) {
        this.right = <set-?>;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationX(float value) {
        this.renderNode.setRotationX(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationY(float value) {
        this.renderNode.setRotationY(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRotationZ(float value) {
        this.renderNode.setRotation(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setScaleX(float value) {
        this.renderNode.setScaleX(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setScaleY(float value) {
        this.renderNode.setScaleY(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setSpotShadowColor(int value) {
        RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setTop(int <set-?>) {
        this.top = <set-?>;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setTranslationX(float value) {
        this.renderNode.setTranslationX(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setTranslationY(float value) {
        this.renderNode.setTranslationY(value);
    }
}
