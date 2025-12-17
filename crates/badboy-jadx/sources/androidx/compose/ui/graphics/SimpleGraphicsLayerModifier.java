package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0091\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u0008\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000c\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a¢\u0006\u0002\u0010\u001bJ\u0006\u0010S\u001a\u000203J\u0008\u0010T\u001a\u00020UH\u0016J&\u0010V\u001a\u00020W*\u00020X2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0016ø\u0001\u0000¢\u0006\u0004\u0008]\u0010^R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\"\u0010\u0016\u001a\u00020\u0017X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\u0008 \u0010!\"\u0004\u0008\"\u0010#R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010\u001d\"\u0004\u0008&\u0010\u001fR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008'\u0010(\"\u0004\u0008)\u0010*R\"\u0010\u0019\u001a\u00020\u001aX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\u0008+\u0010,\"\u0004\u0008-\u0010.R\u001f\u00100\u001a\u0013\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020301¢\u0006\u0002\u00084X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00085\u00106\"\u0004\u00087\u00108R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00089\u0010\u001d\"\u0004\u0008:\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008;\u0010\u001d\"\u0004\u0008<\u0010\u001fR\u001a\u0010\u000c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008=\u0010\u001d\"\u0004\u0008>\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008?\u0010\u001d\"\u0004\u0008@\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008A\u0010\u001d\"\u0004\u0008B\u0010\u001fR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008C\u0010\u001d\"\u0004\u0008D\u0010\u001fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008E\u0010F\"\u0004\u0008G\u0010HR\u0014\u0010I\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008J\u0010(R\"\u0010\u0018\u001a\u00020\u0017X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\u0008K\u0010!\"\u0004\u0008L\u0010#R\"\u0010\u000e\u001a\u00020\u000fX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\u0008M\u0010!\"\u0004\u0008N\u0010#R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008O\u0010\u001d\"\u0004\u0008P\u0010\u001fR\u001a\u0010\u0008\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Q\u0010\u001d\"\u0004\u0008R\u0010\u001f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006_", d2 = {"Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "getCameraDistance", "setCameraDistance", "getClip", "()Z", "setClip", "(Z)V", "getCompositingStrategy--NrFUSI", "()I", "setCompositingStrategy-aDBOjCE", "(I)V", "I", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "getRotationX", "setRotationX", "getRotationY", "setRotationY", "getRotationZ", "setRotationZ", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getShadowElevation", "setShadowElevation", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "invalidateLayerBlock", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SimpleGraphicsLayerModifier extends Modifier.Node implements LayoutModifierNode {

    private float alpha;
    private long ambientShadowColor;
    private float cameraDistance;
    private boolean clip;
    private int compositingStrategy;
    private Function1<? super androidx.compose.ui.graphics.GraphicsLayerScope, Unit> layerBlock;
    private androidx.compose.ui.graphics.RenderEffect renderEffect;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private androidx.compose.ui.graphics.Shape shape;
    private long spotShadowColor;
    private long transformOrigin;
    private float translationX;
    private float translationY;
    private SimpleGraphicsLayerModifier(float scaleX, float scaleY, float alpha, float translationX, float translationY, float shadowElevation, float rotationX, float rotationY, float rotationZ, float cameraDistance, long transformOrigin, androidx.compose.ui.graphics.Shape shape, boolean clip, androidx.compose.ui.graphics.RenderEffect renderEffect, long ambientShadowColor, long spotShadowColor, int compositingStrategy) {
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
        SimpleGraphicsLayerModifier.layerBlock.1 anon = new SimpleGraphicsLayerModifier.layerBlock.1(obj);
        obj.layerBlock = (Function1)anon;
    }

    public SimpleGraphicsLayerModifier(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long l11, androidx.compose.ui.graphics.Shape shape12, boolean z13, androidx.compose.ui.graphics.RenderEffect renderEffect14, long l15, long l16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker19) {
        int auto--NrFUSI;
        int i;
        if (obj44 & i2 != 0) {
            i = auto--NrFUSI;
        } else {
            i = obj43;
        }
        super(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, l11, obj13, z13, renderEffect14, l15, l16, obj18, i18, obj20, i, 0);
    }

    public SimpleGraphicsLayerModifier(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long l11, androidx.compose.ui.graphics.Shape shape12, boolean z13, androidx.compose.ui.graphics.RenderEffect renderEffect14, long l15, long l16, int i17, DefaultConstructorMarker defaultConstructorMarker18) {
        super(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, l11, shape12, z13, renderEffect14, l15, l16, i17, defaultConstructorMarker18, obj19, obj20);
    }

    public static final Function1 access$getLayerBlock$p(androidx.compose.ui.graphics.SimpleGraphicsLayerModifier $this) {
        return $this.layerBlock;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final long getAmbientShadowColor-0d7_KjU() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final int getCompositingStrategy--NrFUSI() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.ui.graphics.RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getRotationX() {
        return this.rotationX;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getRotationY() {
        return this.rotationY;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getRotationZ() {
        return this.rotationZ;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.ui.graphics.Shape getShape() {
        return this.shape;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final long getSpotShadowColor-0d7_KjU() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final long getTransformOrigin-SzJe1aQ() {
        return this.transformOrigin;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void invalidateLayerBlock() {
        int $i$f$getLayoutOLwlOKw;
        int i;
        int i2 = 0;
        NodeCoordinator wrapped$ui_release = DelegatableNodeKt.requireCoordinator-64DMado((DelegatableNode)this, NodeKind.constructor-impl(2)).getWrapped$ui_release();
        if (wrapped$ui_release != null) {
            wrapped$ui_release.updateLayerBlock(this.layerBlock, true);
        }
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        final Placeable measure-BRTryo0 = measurable.measure-BRTryo0(constraints);
        SimpleGraphicsLayerModifier.measure.1 anon = new SimpleGraphicsLayerModifier.measure.1(measure-BRTryo0, this);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, measure-BRTryo0.getWidth(), measure-BRTryo0.getHeight(), 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setAlpha(float <set-?>) {
        this.alpha = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setAmbientShadowColor-8_81llA(long <set-?>) {
        this.ambientShadowColor = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setCameraDistance(float <set-?>) {
        this.cameraDistance = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setClip(boolean <set-?>) {
        this.clip = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setCompositingStrategy-aDBOjCE(int <set-?>) {
        this.compositingStrategy = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setRenderEffect(androidx.compose.ui.graphics.RenderEffect <set-?>) {
        this.renderEffect = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setRotationX(float <set-?>) {
        this.rotationX = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setRotationY(float <set-?>) {
        this.rotationY = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setRotationZ(float <set-?>) {
        this.rotationZ = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setScaleX(float <set-?>) {
        this.scaleX = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setScaleY(float <set-?>) {
        this.scaleY = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setShadowElevation(float <set-?>) {
        this.shadowElevation = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setShape(androidx.compose.ui.graphics.Shape <set-?>) {
        this.shape = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setSpotShadowColor-8_81llA(long <set-?>) {
        this.spotShadowColor = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setTransformOrigin-__ExYCQ(long <set-?>) {
        this.transformOrigin = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setTranslationX(float <set-?>) {
        this.translationX = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setTranslationY(float <set-?>) {
        this.translationY = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SimpleGraphicsLayerModifier(scaleX=").append(this.scaleX).append(", scaleY=").append(this.scaleY).append(", alpha = ").append(this.alpha).append(", translationX=").append(this.translationX).append(", translationY=").append(this.translationY).append(", shadowElevation=").append(this.shadowElevation).append(", rotationX=").append(this.rotationX).append(", rotationY=").append(this.rotationY).append(", rotationZ=").append(this.rotationZ).append(", cameraDistance=").append(this.cameraDistance).append(", transformOrigin=").append(TransformOrigin.toString-impl(this.transformOrigin)).append(", shape=");
        stringBuilder.append(this.shape).append(", clip=").append(this.clip).append(", renderEffect=").append(this.renderEffect).append(", ambientShadowColor=").append(Color.toString-impl(this.ambientShadowColor)).append(", spotShadowColor=").append(Color.toString-impl(this.spotShadowColor)).append(", compositingStrategy=").append(CompositingStrategy.toString-impl(this.compositingStrategy)).append(')');
        return stringBuilder.toString();
    }
}
