package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RenderNode;
import android.os.Build.VERSION;
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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u001d\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010b\u001a\u00020cH\u0016J\u0010\u0010d\u001a\u00020c2\u0006\u0010e\u001a\u00020fH\u0016J\u0008\u0010g\u001a\u00020hH\u0016J\u0010\u0010i\u001a\u00020c2\u0006\u0010j\u001a\u00020kH\u0016J\u0010\u0010l\u001a\u00020c2\u0006\u0010j\u001a\u00020kH\u0016J\r\u0010m\u001a\u00020\u0017H\u0000¢\u0006\u0002\u0008nJ\r\u0010o\u001a\u00020\u0017H\u0000¢\u0006\u0002\u0008pJ\u0010\u0010q\u001a\u00020c2\u0006\u0010r\u001a\u00020\u000cH\u0016J\u0010\u0010s\u001a\u00020c2\u0006\u0010r\u001a\u00020\u000cH\u0016J.\u0010t\u001a\u00020c2\u0006\u0010u\u001a\u00020v2\u0008\u0010w\u001a\u0004\u0018\u00010x2\u0012\u0010y\u001a\u000e\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020c0zH\u0016J\u0010\u0010|\u001a\u00020\u00172\u0006\u0010m\u001a\u00020\u0017H\u0016J\u0012\u0010}\u001a\u00020c2\u0008\u0010~\u001a\u0004\u0018\u00010\u007fH\u0016J)\u0010\u0080\u0001\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u000c2\u0006\u0010T\u001a\u00020\u000c2\u0006\u0010@\u001a\u00020\u000c2\u0006\u0010\u0012\u001a\u00020\u000cH\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR$\u0010\r\u001a\u00020\u000c2\u0006\u0010\u0005\u001a\u00020\u000c8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u000fR$\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0015\u0010\t\"\u0004\u0008\u0016\u0010\u000bR$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u001e\u0010\u001a\"\u0004\u0008\u001f\u0010\u001cR*\u0010!\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020 8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\"\u0010\u000f\"\u0004\u0008#\u0010\u0011R$\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008%\u0010\t\"\u0004\u0008&\u0010\u000bR\u0014\u0010'\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008(\u0010\u001aR\u0014\u0010)\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008*\u0010\u000fR\u0016\u0010+\u001a\u00020 X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00080\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R$\u00103\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u00084\u0010\t\"\u0004\u00085\u0010\u000bR$\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u00087\u0010\t\"\u0004\u00088\u0010\u000bR(\u00109\u001a\u0004\u0018\u00010.2\u0008\u0010\u0005\u001a\u0004\u0018\u00010.8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008:\u0010;\"\u0004\u0008<\u0010=R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008A\u0010\u000fR$\u0010B\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008C\u0010\t\"\u0004\u0008D\u0010\u000bR$\u0010E\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008F\u0010\t\"\u0004\u0008G\u0010\u000bR$\u0010H\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008I\u0010\t\"\u0004\u0008J\u0010\u000bR$\u0010K\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008L\u0010\t\"\u0004\u0008M\u0010\u000bR$\u0010N\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008O\u0010\t\"\u0004\u0008P\u0010\u000bR$\u0010Q\u001a\u00020\u000c2\u0006\u0010\u0005\u001a\u00020\u000c8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008R\u0010\u000f\"\u0004\u0008S\u0010\u0011R\u0014\u0010T\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008U\u0010\u000fR$\u0010V\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008W\u0010\t\"\u0004\u0008X\u0010\u000bR$\u0010Y\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008Z\u0010\t\"\u0004\u0008[\u0010\u000bR\u0014\u0010\\\u001a\u00020]8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008^\u0010_R\u0014\u0010`\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008a\u0010\u000f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0081\u0001", d2 = {"Landroidx/compose/ui/platform/RenderNodeApi29;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "", "ambientShadowColor", "getAmbientShadowColor", "()I", "setAmbientShadowColor", "(I)V", "bottom", "getBottom", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clipToBounds", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "clipToOutline", "getClipToOutline", "setClipToOutline", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "elevation", "getElevation", "setElevation", "hasDisplayList", "getHasDisplayList", "height", "getHeight", "internalCompositingStrategy", "I", "internalRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "left", "getLeft", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderNode", "Landroid/graphics/RenderNode;", "right", "getRight", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "spotShadowColor", "getSpotShadowColor", "setSpotShadowColor", "top", "getTop", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "uniqueId", "", "getUniqueId", "()J", "width", "getWidth", "discardDisplayList", "", "drawInto", "canvas", "Landroid/graphics/Canvas;", "dumpRenderNodeData", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "getInverseMatrix", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "hasOverlappingRendering", "hasOverlappingRendering$ui_release", "isUsingCompositingLayer", "isUsingCompositingLayer$ui_release", "offsetLeftAndRight", "offset", "offsetTopAndBottom", "record", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "setHasOverlappingRendering", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RenderNodeApi29 implements androidx.compose.ui.platform.DeviceRenderNode {

    public static final int $stable = 8;
    private int internalCompositingStrategy;
    private RenderEffect internalRenderEffect;
    private final androidx.compose.ui.platform.AndroidComposeView ownerView;
    private final RenderNode renderNode;
    static {
        final int i = 8;
    }

    public RenderNodeApi29(androidx.compose.ui.platform.AndroidComposeView ownerView) {
        super();
        this.ownerView = ownerView;
        RenderNode renderNode = new RenderNode("Compose");
        this.renderNode = renderNode;
        this.internalCompositingStrategy = CompositingStrategy.Companion.getAuto--NrFUSI();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void drawInto(Canvas canvas) {
        canvas.drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public androidx.compose.ui.platform.DeviceRenderNodeData dumpRenderNodeData() {
        final Object obj = this;
        androidx.compose.ui.platform.DeviceRenderNodeData deviceRenderNodeData2 = deviceRenderNodeData3;
        deviceRenderNodeData2 = new DeviceRenderNodeData(obj.renderNode.getUniqueId(), obj3, obj.renderNode.getLeft(), obj.renderNode.getTop(), obj.renderNode.getRight(), obj.renderNode.getBottom(), obj.renderNode.getWidth(), obj.renderNode.getHeight(), obj.renderNode.getScaleX(), obj.renderNode.getScaleY(), obj.renderNode.getTranslationX(), obj.renderNode.getTranslationY(), obj.renderNode.getElevation(), obj.renderNode.getAmbientShadowColor(), obj.renderNode.getSpotShadowColor(), obj.renderNode.getRotationZ(), obj.renderNode.getRotationX(), obj.renderNode.getRotationY(), obj.renderNode.getCameraDistance(), obj.renderNode.getPivotX(), obj.renderNode.getPivotY(), obj.renderNode.getClipToOutline(), obj.renderNode.getClipToBounds(), obj.renderNode.getAlpha(), obj.internalRenderEffect, obj.internalCompositingStrategy, 0);
        return deviceRenderNodeData2;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getAmbientShadowColor() {
        return this.renderNode.getAmbientShadowColor();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getBottom() {
        return this.renderNode.getBottom();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public float getCameraDistance() {
        return this.renderNode.getCameraDistance();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public boolean getClipToBounds() {
        return this.renderNode.getClipToBounds();
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
        return this.renderNode.hasDisplayList();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getHeight() {
        return this.renderNode.getHeight();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void getInverseMatrix(Matrix matrix) {
        this.renderNode.getInverseMatrix(matrix);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getLeft() {
        return this.renderNode.getLeft();
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
        return this.internalRenderEffect;
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getRight() {
        return this.renderNode.getRight();
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
        return this.renderNode.getRotationZ();
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
        return this.renderNode.getSpotShadowColor();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getTop() {
        return this.renderNode.getTop();
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
        return this.renderNode.getUniqueId();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public int getWidth() {
        return this.renderNode.getWidth();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final boolean hasOverlappingRendering$ui_release() {
        return this.renderNode.hasOverlappingRendering();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public final boolean isUsingCompositingLayer$ui_release() {
        return this.renderNode.getUseCompositingLayer();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetLeftAndRight(int offset) {
        this.renderNode.offsetLeftAndRight(offset);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void offsetTopAndBottom(int offset) {
        this.renderNode.offsetTopAndBottom(offset);
    }

    public void record(CanvasHolder canvasHolder, Path clipPath, Function1<? super Canvas, Unit> drawBlock) {
        int i3;
        int i;
        int i2;
        final Object obj = canvasHolder;
        final int i4 = 0;
        obj.getAndroidCanvas().setInternalCanvas((Canvas)this.renderNode.beginRecording());
        AndroidCanvas androidCanvas3 = obj.getAndroidCanvas();
        final int i5 = 0;
        if (clipPath != null) {
            (Canvas)androidCanvas3.save();
            Canvas.clipPath-mtrdD-E$default(androidCanvas3, clipPath, 0, 2, 0);
        }
        drawBlock.invoke(androidCanvas3);
        if (clipPath != null) {
            androidCanvas3.restore();
        }
        obj.getAndroidCanvas().setInternalCanvas(obj.getAndroidCanvas().getInternalCanvas());
        this.renderNode.endRecording();
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAlpha(float value) {
        this.renderNode.setAlpha(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setAmbientShadowColor(int value) {
        this.renderNode.setAmbientShadowColor(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setCameraDistance(float value) {
        this.renderNode.setCameraDistance(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToBounds(boolean value) {
        this.renderNode.setClipToBounds(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setClipToOutline(boolean value) {
        this.renderNode.setClipToOutline(value);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setCompositingStrategy-aDBOjCE(int value) {
        boolean equals-impl0;
        int i;
        final RenderNode renderNode = this.renderNode;
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 1;
        if (CompositingStrategy.equals-impl0(value, CompositingStrategy.Companion.getOffscreen--NrFUSI())) {
            renderNode.setUseCompositingLayer(i4, i3);
            renderNode.setHasOverlappingRendering(i4);
        } else {
            i = 0;
            if (CompositingStrategy.equals-impl0(value, CompositingStrategy.Companion.getModulateAlpha--NrFUSI())) {
                renderNode.setUseCompositingLayer(i, i3);
                renderNode.setHasOverlappingRendering(i);
            } else {
                renderNode.setUseCompositingLayer(i, i3);
                renderNode.setHasOverlappingRendering(i4);
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
        return this.renderNode.setPosition(left, top, right, bottom);
    }

    @Override // androidx.compose.ui.platform.DeviceRenderNode
    public void setRenderEffect(RenderEffect value) {
        int iNSTANCE;
        int renderNode;
        this.internalRenderEffect = value;
        if (Build.VERSION.SDK_INT >= 31) {
            RenderNodeApi29VerificationHelper.INSTANCE.setRenderEffect(this.renderNode, value);
        }
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
        this.renderNode.setRotationZ(value);
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
        this.renderNode.setSpotShadowColor(value);
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
