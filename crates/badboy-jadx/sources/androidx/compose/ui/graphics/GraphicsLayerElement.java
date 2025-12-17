package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u00085\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u0008\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000c\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\t\u00105\u001a\u00020\u0004HÆ\u0003J\t\u00106\u001a\u00020\u0004HÆ\u0003J\u0016\u00107\u001a\u00020\u000fHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00088\u0010\u001fJ\t\u00109\u001a\u00020\u0011HÆ\u0003J\t\u0010:\u001a\u00020\u0013HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0016\u0010<\u001a\u00020\u0017HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008=\u0010\u001fJ\u0016\u0010>\u001a\u00020\u0017HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008?\u0010\u001fJ\u0016\u0010@\u001a\u00020\u001aHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008A\u0010%J\t\u0010B\u001a\u00020\u0004HÆ\u0003J\t\u0010C\u001a\u00020\u0004HÆ\u0003J\t\u0010D\u001a\u00020\u0004HÆ\u0003J\t\u0010E\u001a\u00020\u0004HÆ\u0003J\t\u0010F\u001a\u00020\u0004HÆ\u0003J\t\u0010G\u001a\u00020\u0004HÆ\u0003J\t\u0010H\u001a\u00020\u0004HÆ\u0003J\t\u0010I\u001a\u00020\u0004HÆ\u0003J¿\u0001\u0010J\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\t\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00042\u0008\u0008\u0002\u0010\r\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001aHÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008K\u0010LJ\u0008\u0010M\u001a\u00020\u0002H\u0016J\u0013\u0010N\u001a\u00020\u00132\u0008\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020RHÖ\u0001J\t\u0010S\u001a\u00020THÖ\u0001J\u0010\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0002H\u0016J\u000c\u0010X\u001a\u00020V*\u00020YH\u0016R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0019\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0019\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010&\u001a\u0004\u0008$\u0010%R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u001dR\u0011\u0010\u000c\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100R\u0019\u0010\u0018\u001a\u00020\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u00081\u0010\u001fR\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\u00082\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010\u001dR\u0011\u0010\u0008\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010\u001d\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Z", d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha", "()F", "getAmbientShadowColor-0d7_KjU", "()J", "J", "getCameraDistance", "getClip", "()Z", "getCompositingStrategy--NrFUSI", "()I", "I", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "getRotationX", "getRotationY", "getRotationZ", "getScaleX", "getScaleY", "getShadowElevation", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getSpotShadowColor-0d7_KjU", "getTransformOrigin-SzJe1aQ", "getTranslationX", "getTranslationY", "component1", "component10", "component11", "component11-SzJe1aQ", "component12", "component13", "component14", "component15", "component15-0d7_KjU", "component16", "component16-0d7_KjU", "component17", "component17--NrFUSI", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copy-JVvOYNQ", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJI)Landroidx/compose/ui/graphics/GraphicsLayerElement;", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class GraphicsLayerElement extends ModifierNodeElement<androidx.compose.ui.graphics.SimpleGraphicsLayerModifier> {

    private final float alpha;
    private final long ambientShadowColor;
    private final float cameraDistance;
    private final boolean clip;
    private final int compositingStrategy;
    private final androidx.compose.ui.graphics.RenderEffect renderEffect;
    private final float rotationX;
    private final float rotationY;
    private final float rotationZ;
    private final float scaleX;
    private final float scaleY;
    private final float shadowElevation;
    private final androidx.compose.ui.graphics.Shape shape;
    private final long spotShadowColor;
    private final long transformOrigin;
    private final float translationX;
    private final float translationY;
    private GraphicsLayerElement(float scaleX, float scaleY, float alpha, float translationX, float translationY, float shadowElevation, float rotationX, float rotationY, float rotationZ, float cameraDistance, long transformOrigin, androidx.compose.ui.graphics.Shape shape, boolean clip, androidx.compose.ui.graphics.RenderEffect renderEffect, long ambientShadowColor, long spotShadowColor, int compositingStrategy) {
        final Object obj = this;
        super();
        obj.scaleX = scaleX;
        obj.scaleY = scaleY;
        obj.alpha = alpha;
        obj.translationX = translationX;
        obj.translationY = translationY;
        obj.shadowElevation = shadowElevation;
        obj.rotationX = rotationX;
        obj.rotationY = rotationY;
        obj.rotationZ = rotationZ;
        obj.cameraDistance = cameraDistance;
        obj.transformOrigin = transformOrigin;
        obj.shape = clip;
        obj.clip = renderEffect;
        obj.renderEffect = ambientShadowColor;
        obj.ambientShadowColor = spotShadowColor;
        obj.spotShadowColor = obj34;
        obj.compositingStrategy = obj36;
    }

    public GraphicsLayerElement(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long l11, androidx.compose.ui.graphics.Shape shape12, boolean z13, androidx.compose.ui.graphics.RenderEffect renderEffect14, long l15, long l16, int i17, DefaultConstructorMarker defaultConstructorMarker18) {
        super(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, l11, shape12, z13, renderEffect14, l15, l16, i17, defaultConstructorMarker18, obj19, obj20);
    }

    public static androidx.compose.ui.graphics.GraphicsLayerElement copy-JVvOYNQ$default(androidx.compose.ui.graphics.GraphicsLayerElement graphicsLayerElement, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, long l12, androidx.compose.ui.graphics.Shape shape13, boolean z14, androidx.compose.ui.graphics.RenderEffect renderEffect15, long l16, long l17, int i18, int i19, Object object20) {
        long ambientShadowColor;
        long compositingStrategy;
        float scaleX;
        androidx.compose.ui.graphics.RenderEffect renderEffect;
        float scaleY;
        float alpha;
        float translationX;
        float translationY;
        float shadowElevation;
        float rotationX;
        float rotationY;
        float rotationZ;
        float cameraDistance;
        long transformOrigin;
        androidx.compose.ui.graphics.Shape shape;
        boolean clip;
        long obj22;
        long obj36;
        int obj38;
        Object obj = graphicsLayerElement;
        int i = obj38;
        scaleX = i & 1 != 0 ? obj.scaleX : f2;
        scaleY = i & 2 != 0 ? obj.scaleY : f3;
        alpha = i & 4 != 0 ? obj.alpha : f4;
        translationX = i & 8 != 0 ? obj.translationX : f5;
        translationY = i & 16 != 0 ? obj.translationY : f6;
        shadowElevation = i & 32 != 0 ? obj.shadowElevation : f7;
        rotationX = i & 64 != 0 ? obj.rotationX : f8;
        rotationY = i & 128 != 0 ? obj.rotationY : f9;
        rotationZ = i & 256 != 0 ? obj.rotationZ : f10;
        cameraDistance = i & 512 != 0 ? obj.cameraDistance : f11;
        transformOrigin = i & 1024 != 0 ? obj.transformOrigin : l12;
        shape = i & 2048 != 0 ? obj.shape : z14;
        clip = i & 4096 != 0 ? obj.clip : renderEffect15;
        renderEffect = i & 8192 != 0 ? obj.renderEffect : l16;
        ambientShadowColor = i & 16384 != 0 ? obj.ambientShadowColor : l17;
        compositingStrategy = obj38 & i17 != 0 ? obj.spotShadowColor : i19;
        if (obj38 & i21 != 0) {
            obj36 = obj22;
            obj38 = compositingStrategy;
        } else {
            obj38 = obj37;
            obj36 = compositingStrategy;
        }
        return obj.copy-JVvOYNQ(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, z14, shape, clip, renderEffect, ambientShadowColor, i19);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component1() {
        return this.scaleX;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component10() {
        return this.cameraDistance;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final long component11-SzJe1aQ() {
        return this.transformOrigin;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.graphics.Shape component12() {
        return this.shape;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean component13() {
        return this.clip;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.graphics.RenderEffect component14() {
        return this.renderEffect;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final long component15-0d7_KjU() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final long component16-0d7_KjU() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int component17--NrFUSI() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component2() {
        return this.scaleY;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component3() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component4() {
        return this.translationX;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component5() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component6() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component7() {
        return this.rotationX;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component8() {
        return this.rotationY;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component9() {
        return this.rotationZ;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.graphics.GraphicsLayerElement copy-JVvOYNQ(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long l11, androidx.compose.ui.graphics.Shape shape12, boolean z13, androidx.compose.ui.graphics.RenderEffect renderEffect14, long l15, long l16, int i17) {
        GraphicsLayerElement graphicsLayerElement = new GraphicsLayerElement(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, l11, obj12, z13, renderEffect14, l15, l16, obj17, obj40, obj19, obj42, 0);
        return graphicsLayerElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.graphics.SimpleGraphicsLayerModifier create() {
        final Object obj = this;
        final androidx.compose.ui.graphics.RenderEffect renderEffect3 = renderEffect;
        androidx.compose.ui.graphics.SimpleGraphicsLayerModifier simpleGraphicsLayerModifier2 = simpleGraphicsLayerModifier3;
        simpleGraphicsLayerModifier2 = new SimpleGraphicsLayerModifier(obj.scaleX, obj.scaleY, obj.alpha, obj.translationX, obj.translationY, obj.shadowElevation, obj.rotationX, obj.rotationY, obj.rotationZ, obj.cameraDistance, obj.transformOrigin, obj13, obj.shape, obj.clip, renderEffect3, obj.ambientShadowColor, renderEffect3, obj.spotShadowColor, obj20, obj.compositingStrategy, 0);
        return simpleGraphicsLayerModifier2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof GraphicsLayerElement) {
            return i2;
        }
        Object obj = object;
        if (Float.compare(this.scaleX, obj.scaleX) != 0) {
            return i2;
        }
        if (Float.compare(this.scaleY, obj.scaleY) != 0) {
            return i2;
        }
        if (Float.compare(this.alpha, obj.alpha) != 0) {
            return i2;
        }
        if (Float.compare(this.translationX, obj.translationX) != 0) {
            return i2;
        }
        if (Float.compare(this.translationY, obj.translationY) != 0) {
            return i2;
        }
        if (Float.compare(this.shadowElevation, obj.shadowElevation) != 0) {
            return i2;
        }
        if (Float.compare(this.rotationX, obj.rotationX) != 0) {
            return i2;
        }
        if (Float.compare(this.rotationY, obj.rotationY) != 0) {
            return i2;
        }
        if (Float.compare(this.rotationZ, obj.rotationZ) != 0) {
            return i2;
        }
        float cameraDistance2 = obj.cameraDistance;
        if (Float.compare(this.cameraDistance, cameraDistance2) != 0) {
            return i2;
        }
        if (!TransformOrigin.equals-impl0(this.transformOrigin, cameraDistance2)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.shape, obj.shape)) {
            return i2;
        }
        if (this.clip != obj.clip) {
            return i2;
        }
        androidx.compose.ui.graphics.RenderEffect renderEffect2 = obj.renderEffect;
        if (!Intrinsics.areEqual(this.renderEffect, renderEffect2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.ambientShadowColor, renderEffect2)) {
            return i2;
        }
        if (!Color.equals-impl0(this.spotShadowColor, renderEffect2)) {
            return i2;
        }
        if (!CompositingStrategy.equals-impl0(this.compositingStrategy, obj.compositingStrategy)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final long getAmbientShadowColor-0d7_KjU() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int getCompositingStrategy--NrFUSI() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.graphics.RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getRotationX() {
        return this.rotationX;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getRotationY() {
        return this.rotationY;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getRotationZ() {
        return this.rotationZ;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.ui.graphics.Shape getShape() {
        return this.shape;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final long getSpotShadowColor-0d7_KjU() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final long getTransformOrigin-SzJe1aQ() {
        return this.transformOrigin;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        if (this.renderEffect == null) {
            i = 0;
        } else {
            i = this.renderEffect.hashCode();
        }
        return i17 += i49;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("graphicsLayer");
        $this$inspectableProperties.getProperties().set("scaleX", Float.valueOf(this.scaleX));
        $this$inspectableProperties.getProperties().set("scaleY", Float.valueOf(this.scaleY));
        $this$inspectableProperties.getProperties().set("alpha", Float.valueOf(this.alpha));
        $this$inspectableProperties.getProperties().set("translationX", Float.valueOf(this.translationX));
        $this$inspectableProperties.getProperties().set("translationY", Float.valueOf(this.translationY));
        $this$inspectableProperties.getProperties().set("shadowElevation", Float.valueOf(this.shadowElevation));
        $this$inspectableProperties.getProperties().set("rotationX", Float.valueOf(this.rotationX));
        $this$inspectableProperties.getProperties().set("rotationY", Float.valueOf(this.rotationY));
        $this$inspectableProperties.getProperties().set("rotationZ", Float.valueOf(this.rotationZ));
        String str13 = "cameraDistance";
        $this$inspectableProperties.getProperties().set(str13, Float.valueOf(this.cameraDistance));
        $this$inspectableProperties.getProperties().set("transformOrigin", TransformOrigin.box-impl(this.transformOrigin));
        $this$inspectableProperties.getProperties().set("shape", this.shape);
        $this$inspectableProperties.getProperties().set("clip", Boolean.valueOf(this.clip));
        androidx.compose.ui.graphics.RenderEffect renderEffect = this.renderEffect;
        $this$inspectableProperties.getProperties().set("renderEffect", renderEffect);
        String str16 = "ambientShadowColor";
        $this$inspectableProperties.getProperties().set(str16, Color.box-impl(this.ambientShadowColor));
        $this$inspectableProperties.getProperties().set("spotShadowColor", Color.box-impl(this.spotShadowColor));
        $this$inspectableProperties.getProperties().set("compositingStrategy", CompositingStrategy.box-impl(this.compositingStrategy));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GraphicsLayerElement(scaleX=").append(this.scaleX).append(", scaleY=").append(this.scaleY).append(", alpha=").append(this.alpha).append(", translationX=").append(this.translationX).append(", translationY=").append(this.translationY).append(", shadowElevation=").append(this.shadowElevation).append(", rotationX=").append(this.rotationX).append(", rotationY=").append(this.rotationY).append(", rotationZ=").append(this.rotationZ).append(", cameraDistance=").append(this.cameraDistance).append(", transformOrigin=").append(TransformOrigin.toString-impl(this.transformOrigin)).append(", shape=");
        stringBuilder.append(this.shape).append(", clip=").append(this.clip).append(", renderEffect=").append(this.renderEffect).append(", ambientShadowColor=").append(Color.toString-impl(this.ambientShadowColor)).append(", spotShadowColor=").append(Color.toString-impl(this.spotShadowColor)).append(", compositingStrategy=").append(CompositingStrategy.toString-impl(this.compositingStrategy)).append(')');
        return stringBuilder.toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((SimpleGraphicsLayerModifier)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.graphics.SimpleGraphicsLayerModifier node) {
        node.setScaleX(this.scaleX);
        node.setScaleY(this.scaleY);
        node.setAlpha(this.alpha);
        node.setTranslationX(this.translationX);
        node.setTranslationY(this.translationY);
        node.setShadowElevation(this.shadowElevation);
        node.setRotationX(this.rotationX);
        node.setRotationY(this.rotationY);
        node.setRotationZ(this.rotationZ);
        node.setCameraDistance(this.cameraDistance);
        node.setTransformOrigin-__ExYCQ(this.transformOrigin);
        node.setShape(this.shape);
        node.setClip(this.clip);
        node.setRenderEffect(this.renderEffect);
        node.setAmbientShadowColor-8_81llA(this.ambientShadowColor);
        node.setSpotShadowColor-8_81llA(this.spotShadowColor);
        node.setCompositingStrategy-aDBOjCE(this.compositingStrategy);
        node.invalidateLayerBlock();
    }
}
