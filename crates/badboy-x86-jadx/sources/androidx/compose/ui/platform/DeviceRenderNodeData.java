package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008W\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001BÏ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000c\u0012\u0006\u0010\u000e\u001a\u00020\u000c\u0012\u0006\u0010\u000f\u001a\u00020\u000c\u0012\u0006\u0010\u0010\u001a\u00020\u000c\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u000c\u0012\u0006\u0010\u0014\u001a\u00020\u000c\u0012\u0006\u0010\u0015\u001a\u00020\u000c\u0012\u0006\u0010\u0016\u001a\u00020\u000c\u0012\u0006\u0010\u0017\u001a\u00020\u000c\u0012\u0006\u0010\u0018\u001a\u00020\u000c\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u000c\u0012\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u000cHÆ\u0003J\t\u0010Y\u001a\u00020\u000cHÆ\u0003J\t\u0010Z\u001a\u00020\u000cHÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u000cHÆ\u0003J\t\u0010^\u001a\u00020\u000cHÆ\u0003J\t\u0010_\u001a\u00020\u000cHÆ\u0003J\t\u0010`\u001a\u00020\u000cHÆ\u0003J\t\u0010a\u001a\u00020\u000cHÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003J\t\u0010c\u001a\u00020\u000cHÆ\u0003J\t\u0010d\u001a\u00020\u001aHÆ\u0003J\t\u0010e\u001a\u00020\u001aHÆ\u0003J\t\u0010f\u001a\u00020\u000cHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u0016\u0010h\u001a\u00020 HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008i\u0010'J\t\u0010j\u001a\u00020\u0005HÆ\u0003J\t\u0010k\u001a\u00020\u0005HÆ\u0003J\t\u0010l\u001a\u00020\u0005HÆ\u0003J\t\u0010m\u001a\u00020\u0005HÆ\u0003J\t\u0010n\u001a\u00020\u0005HÆ\u0003J\t\u0010o\u001a\u00020\u000cHÆ\u0003J\t\u0010p\u001a\u00020\u000cHÆ\u0003J\u008f\u0002\u0010q\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\u00052\u0008\u0008\u0002\u0010\n\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u000c2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008r\u0010sJ\u0013\u0010t\u001a\u00020\u001a2\u0008\u0010u\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010v\u001a\u00020\u0005HÖ\u0001J\t\u0010w\u001a\u00020xHÖ\u0001R\u001a\u0010\u001c\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010#\"\u0004\u0008$\u0010%R\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010'\"\u0004\u0008(\u0010)R\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010'R\u001a\u0010\u0016\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008+\u0010#\"\u0004\u0008,\u0010%R\u001a\u0010\u001b\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010.\"\u0004\u0008/\u00100R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00081\u0010.\"\u0004\u00082\u00100R\"\u0010\u001f\u001a\u00020 X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u00105\u001a\u0004\u00083\u0010'\"\u0004\u00084\u0010)R\u001a\u0010\u0010\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00086\u0010#\"\u0004\u00087\u0010%R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u0010'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010'R\u001a\u0010\u0017\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008:\u0010#\"\u0004\u0008;\u0010%R\u001a\u0010\u0018\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008<\u0010#\"\u0004\u0008=\u0010%R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008>\u0010?\"\u0004\u0008@\u0010AR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008B\u0010'R\u001a\u0010\u0014\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008C\u0010#\"\u0004\u0008D\u0010%R\u001a\u0010\u0015\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008E\u0010#\"\u0004\u0008F\u0010%R\u001a\u0010\u0013\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008G\u0010#\"\u0004\u0008H\u0010%R\u001a\u0010\u000b\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008I\u0010#\"\u0004\u0008J\u0010%R\u001a\u0010\r\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008K\u0010#\"\u0004\u0008L\u0010%R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008M\u0010'\"\u0004\u0008N\u0010)R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008O\u0010'R\u001a\u0010\u000e\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008P\u0010#\"\u0004\u0008Q\u0010%R\u001a\u0010\u000f\u001a\u00020\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008R\u0010#\"\u0004\u0008S\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008T\u0010UR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008V\u0010'\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006y", d2 = {"Landroidx/compose/ui/platform/DeviceRenderNodeData;", "", "uniqueId", "", "left", "", "top", "right", "bottom", "width", "height", "scaleX", "", "scaleY", "translationX", "translationY", "elevation", "ambientShadowColor", "spotShadowColor", "rotationZ", "rotationX", "rotationY", "cameraDistance", "pivotX", "pivotY", "clipToOutline", "", "clipToBounds", "alpha", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "(JIIIIIIFFFFFIIFFFFFFZZFLandroidx/compose/ui/graphics/RenderEffect;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getAmbientShadowColor", "()I", "setAmbientShadowColor", "(I)V", "getBottom", "getCameraDistance", "setCameraDistance", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "getClipToOutline", "setClipToOutline", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "I", "getElevation", "setElevation", "getHeight", "getLeft", "getPivotX", "setPivotX", "getPivotY", "setPivotY", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "getRight", "getRotationX", "setRotationX", "getRotationY", "setRotationY", "getRotationZ", "setRotationZ", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getSpotShadowColor", "setSpotShadowColor", "getTop", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "getUniqueId", "()J", "getWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component25--NrFUSI", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copy-fuCbV5c", "(JIIIIIIFFFFFIIFFFFFFZZFLandroidx/compose/ui/graphics/RenderEffect;I)Landroidx/compose/ui/platform/DeviceRenderNodeData;", "equals", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeviceRenderNodeData {

    public static final int $stable = 8;
    private float alpha;
    private int ambientShadowColor;
    private final int bottom;
    private float cameraDistance;
    private boolean clipToBounds;
    private boolean clipToOutline;
    private int compositingStrategy;
    private float elevation;
    private final int height;
    private final int left;
    private float pivotX;
    private float pivotY;
    private RenderEffect renderEffect;
    private final int right;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private int spotShadowColor;
    private final int top;
    private float translationX;
    private float translationY;
    private final long uniqueId;
    private final int width;
    static {
        final int i = 8;
    }

    private DeviceRenderNodeData(long uniqueId, int left, int top, int right, int bottom, int width, int height, float scaleX, float scaleY, float translationX, float translationY, float elevation, int ambientShadowColor, int spotShadowColor, float rotationZ, float rotationX, float rotationY, float cameraDistance, float pivotX, float pivotY, boolean clipToOutline, boolean clipToBounds, float alpha, RenderEffect renderEffect, int compositingStrategy) {
        final Object obj = this;
        super();
        obj.uniqueId = uniqueId;
        obj.left = top;
        obj.top = right;
        obj.right = bottom;
        obj.bottom = width;
        obj.width = height;
        obj.height = scaleX;
        obj.scaleX = scaleY;
        obj.scaleY = translationX;
        obj.translationX = translationY;
        obj.translationY = elevation;
        obj.elevation = ambientShadowColor;
        obj.ambientShadowColor = spotShadowColor;
        obj.spotShadowColor = rotationZ;
        obj.rotationZ = rotationX;
        obj.rotationX = rotationY;
        obj.rotationY = cameraDistance;
        obj.cameraDistance = pivotX;
        obj.pivotX = pivotY;
        obj.pivotY = clipToOutline;
        obj.clipToOutline = clipToBounds;
        obj.clipToBounds = alpha;
        obj.alpha = renderEffect;
        obj.renderEffect = compositingStrategy;
        obj.compositingStrategy = obj42;
    }

    public DeviceRenderNodeData(long l, int i2, int i3, int i4, int i5, int i6, int i7, float f8, float f9, float f10, float f11, float f12, int i13, int i14, float f15, float f16, float f17, float f18, float f19, float f20, boolean z21, boolean z22, float f23, RenderEffect renderEffect24, int i25, DefaultConstructorMarker defaultConstructorMarker26) {
        super(l, i2, i3, i4, i5, i6, i7, f8, f9, f10, f11, f12, i13, i14, f15, f16, f17, f18, f19, f20, z21, z22, f23, renderEffect24, i25, defaultConstructorMarker26);
    }

    public static androidx.compose.ui.platform.DeviceRenderNodeData copy-fuCbV5c$default(androidx.compose.ui.platform.DeviceRenderNodeData deviceRenderNodeData, long l2, int i3, int i4, int i5, int i6, int i7, int i8, float f9, float f10, float f11, float f12, float f13, int i14, int i15, float f16, float f17, float f18, float f19, float f20, float f21, boolean z22, boolean z23, float f24, RenderEffect renderEffect25, int i26, int i27, Object object28) {
        float rotationX;
        float rotationY;
        float cameraDistance;
        float pivotX;
        float pivotY;
        boolean clipToOutline;
        boolean clipToBounds;
        float alpha;
        RenderEffect compositingStrategy;
        long uniqueId;
        int spotShadowColor;
        float rotationZ;
        int left;
        int top;
        int right;
        int bottom;
        int width;
        int height;
        float scaleX;
        float scaleY;
        float translationX;
        float translationY;
        float elevation;
        int ambientShadowColor;
        RenderEffect obj28;
        RenderEffect obj45;
        int obj46;
        Object obj = deviceRenderNodeData;
        int i = object28;
        uniqueId = i & 1 != 0 ? obj.uniqueId : l2;
        left = i & 2 != 0 ? obj.left : i4;
        top = i & 4 != 0 ? obj.top : i5;
        right = i & 8 != 0 ? obj.right : i6;
        bottom = i & 16 != 0 ? obj.bottom : i7;
        width = i & 32 != 0 ? obj.width : i8;
        height = i & 64 != 0 ? obj.height : f9;
        scaleX = i & 128 != 0 ? obj.scaleX : f10;
        scaleY = i & 256 != 0 ? obj.scaleY : f11;
        translationX = i & 512 != 0 ? obj.translationX : f12;
        translationY = i & 1024 != 0 ? obj.translationY : f13;
        elevation = i & 2048 != 0 ? obj.elevation : i14;
        ambientShadowColor = i & 4096 != 0 ? obj.ambientShadowColor : i15;
        spotShadowColor = i & 8192 != 0 ? obj.spotShadowColor : f16;
        rotationZ = i & 16384 != 0 ? obj.rotationZ : f17;
        rotationX = i & i25 != 0 ? obj.rotationX : f18;
        rotationY = object28 & i29 != 0 ? obj.rotationY : f19;
        cameraDistance = object28 & i31 != 0 ? obj.cameraDistance : f20;
        final float obj22 = cameraDistance;
        pivotX = object28 & i33 != 0 ? obj.pivotX : f21;
        pivotY = object28 & i35 != 0 ? obj.pivotY : z22;
        clipToOutline = object28 & i37 != 0 ? obj.clipToOutline : z23;
        clipToBounds = object28 & i39 != 0 ? obj.clipToBounds : f24;
        alpha = object28 & i41 != 0 ? obj.alpha : renderEffect25;
        compositingStrategy = object28 & i43 != 0 ? obj.renderEffect : i26;
        if (object28 & i45 != 0) {
            obj45 = obj28;
            obj46 = compositingStrategy;
        } else {
            obj46 = i27;
            obj45 = compositingStrategy;
        }
        return obj.copy-fuCbV5c(uniqueId, obj22, left, top, right, bottom, width, height, scaleX, scaleY, translationX, translationY, elevation, ambientShadowColor, spotShadowColor, rotationZ, rotationX, rotationY, obj22, pivotX, pivotY, clipToOutline, clipToBounds, alpha, obj45);
    }

    public final long component1() {
        return this.uniqueId;
    }

    public final float component10() {
        return this.translationX;
    }

    public final float component11() {
        return this.translationY;
    }

    public final float component12() {
        return this.elevation;
    }

    public final int component13() {
        return this.ambientShadowColor;
    }

    public final int component14() {
        return this.spotShadowColor;
    }

    public final float component15() {
        return this.rotationZ;
    }

    public final float component16() {
        return this.rotationX;
    }

    public final float component17() {
        return this.rotationY;
    }

    public final float component18() {
        return this.cameraDistance;
    }

    public final float component19() {
        return this.pivotX;
    }

    public final int component2() {
        return this.left;
    }

    public final float component20() {
        return this.pivotY;
    }

    public final boolean component21() {
        return this.clipToOutline;
    }

    public final boolean component22() {
        return this.clipToBounds;
    }

    public final float component23() {
        return this.alpha;
    }

    public final RenderEffect component24() {
        return this.renderEffect;
    }

    public final int component25--NrFUSI() {
        return this.compositingStrategy;
    }

    public final int component3() {
        return this.top;
    }

    public final int component4() {
        return this.right;
    }

    public final int component5() {
        return this.bottom;
    }

    public final int component6() {
        return this.width;
    }

    public final int component7() {
        return this.height;
    }

    public final float component8() {
        return this.scaleX;
    }

    public final float component9() {
        return this.scaleY;
    }

    public final androidx.compose.ui.platform.DeviceRenderNodeData copy-fuCbV5c(long l, int i2, int i3, int i4, int i5, int i6, int i7, float f8, float f9, float f10, float f11, float f12, int i13, int i14, float f15, float f16, float f17, float f18, float f19, float f20, boolean z21, boolean z22, float f23, RenderEffect renderEffect24, int i25) {
        DeviceRenderNodeData deviceRenderNodeData = new DeviceRenderNodeData(l, obj2, i3, i4, i5, i6, i7, f8, f9, f10, f11, f12, i13, i14, f15, f16, f17, f18, f19, f20, z21, z22, f23, renderEffect24, i25, obj54, 0);
        return deviceRenderNodeData;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof DeviceRenderNodeData == null) {
            return i2;
        }
        Object obj = object;
        if (Long.compare(uniqueId, uniqueId2) != 0) {
            return i2;
        }
        if (this.left != obj.left) {
            return i2;
        }
        if (this.top != obj.top) {
            return i2;
        }
        if (this.right != obj.right) {
            return i2;
        }
        if (this.bottom != obj.bottom) {
            return i2;
        }
        if (this.width != obj.width) {
            return i2;
        }
        if (this.height != obj.height) {
            return i2;
        }
        if (Float.compare(this.scaleX, obj.scaleX) != 0) {
            return i2;
        }
        if (Float.compare(this.scaleY, obj.scaleY) != 0) {
            return i2;
        }
        if (Float.compare(this.translationX, obj.translationX) != 0) {
            return i2;
        }
        if (Float.compare(this.translationY, obj.translationY) != 0) {
            return i2;
        }
        if (Float.compare(this.elevation, obj.elevation) != 0) {
            return i2;
        }
        if (this.ambientShadowColor != obj.ambientShadowColor) {
            return i2;
        }
        if (this.spotShadowColor != obj.spotShadowColor) {
            return i2;
        }
        if (Float.compare(this.rotationZ, obj.rotationZ) != 0) {
            return i2;
        }
        if (Float.compare(this.rotationX, obj.rotationX) != 0) {
            return i2;
        }
        if (Float.compare(this.rotationY, obj.rotationY) != 0) {
            return i2;
        }
        if (Float.compare(this.cameraDistance, obj.cameraDistance) != 0) {
            return i2;
        }
        if (Float.compare(this.pivotX, obj.pivotX) != 0) {
            return i2;
        }
        if (Float.compare(this.pivotY, obj.pivotY) != 0) {
            return i2;
        }
        if (this.clipToOutline != obj.clipToOutline) {
            return i2;
        }
        if (this.clipToBounds != obj.clipToBounds) {
            return i2;
        }
        if (Float.compare(this.alpha, obj.alpha) != 0) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.renderEffect, obj.renderEffect)) {
            return i2;
        }
        if (!CompositingStrategy.equals-impl0(this.compositingStrategy, obj.compositingStrategy)) {
            return i2;
        }
        return i;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final int getAmbientShadowColor() {
        return this.ambientShadowColor;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    public final boolean getClipToBounds() {
        return this.clipToBounds;
    }

    public final boolean getClipToOutline() {
        return this.clipToOutline;
    }

    public final int getCompositingStrategy--NrFUSI() {
        return this.compositingStrategy;
    }

    public final float getElevation() {
        return this.elevation;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLeft() {
        return this.left;
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public final int getRight() {
        return this.right;
    }

    public final float getRotationX() {
        return this.rotationX;
    }

    public final float getRotationY() {
        return this.rotationY;
    }

    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final int getSpotShadowColor() {
        return this.spotShadowColor;
    }

    public final int getTop() {
        return this.top;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final long getUniqueId() {
        return this.uniqueId;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i;
        if (this.renderEffect == null) {
            i = 0;
        } else {
            i = this.renderEffect.hashCode();
        }
        return i25 += i73;
    }

    public final void setAlpha(float <set-?>) {
        this.alpha = <set-?>;
    }

    public final void setAmbientShadowColor(int <set-?>) {
        this.ambientShadowColor = <set-?>;
    }

    public final void setCameraDistance(float <set-?>) {
        this.cameraDistance = <set-?>;
    }

    public final void setClipToBounds(boolean <set-?>) {
        this.clipToBounds = <set-?>;
    }

    public final void setClipToOutline(boolean <set-?>) {
        this.clipToOutline = <set-?>;
    }

    public final void setCompositingStrategy-aDBOjCE(int <set-?>) {
        this.compositingStrategy = <set-?>;
    }

    public final void setElevation(float <set-?>) {
        this.elevation = <set-?>;
    }

    public final void setPivotX(float <set-?>) {
        this.pivotX = <set-?>;
    }

    public final void setPivotY(float <set-?>) {
        this.pivotY = <set-?>;
    }

    public final void setRenderEffect(RenderEffect <set-?>) {
        this.renderEffect = <set-?>;
    }

    public final void setRotationX(float <set-?>) {
        this.rotationX = <set-?>;
    }

    public final void setRotationY(float <set-?>) {
        this.rotationY = <set-?>;
    }

    public final void setRotationZ(float <set-?>) {
        this.rotationZ = <set-?>;
    }

    public final void setScaleX(float <set-?>) {
        this.scaleX = <set-?>;
    }

    public final void setScaleY(float <set-?>) {
        this.scaleY = <set-?>;
    }

    public final void setSpotShadowColor(int <set-?>) {
        this.spotShadowColor = <set-?>;
    }

    public final void setTranslationX(float <set-?>) {
        this.translationX = <set-?>;
    }

    public final void setTranslationY(float <set-?>) {
        this.translationY = <set-?>;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DeviceRenderNodeData(uniqueId=").append(this.uniqueId).append(", left=").append(this.left).append(", top=").append(this.top).append(", right=").append(this.right).append(", bottom=").append(this.bottom).append(", width=").append(this.width).append(", height=").append(this.height).append(", scaleX=").append(this.scaleX).append(", scaleY=").append(this.scaleY).append(", translationX=").append(this.translationX).append(", translationY=").append(this.translationY).append(", elevation=");
        stringBuilder.append(this.elevation).append(", ambientShadowColor=").append(this.ambientShadowColor).append(", spotShadowColor=").append(this.spotShadowColor).append(", rotationZ=").append(this.rotationZ).append(", rotationX=").append(this.rotationX).append(", rotationY=").append(this.rotationY).append(", cameraDistance=").append(this.cameraDistance).append(", pivotX=").append(this.pivotX).append(", pivotY=").append(this.pivotY).append(", clipToOutline=").append(this.clipToOutline).append(", clipToBounds=").append(this.clipToBounds).append(", alpha=").append(this.alpha);
        stringBuilder.append(", renderEffect=").append(this.renderEffect).append(", compositingStrategy=").append(CompositingStrategy.toString-impl(this.compositingStrategy)).append(')');
        return stringBuilder.toString();
    }
}
