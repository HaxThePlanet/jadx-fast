package androidx.compose.animation;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ClipOp.Companion;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00013B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000c¢\u0006\u0002\u0010\u0010J\u0008\u0010.\u001a\u00020/H\u0016J\u0008\u00100\u001a\u00020/H\u0016J\u000c\u00101\u001a\u00020/*\u000202H\u0016R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u0008\u0018\u00010\u001aR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR \u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010$\"\u0004\u0008%\u0010&R+\u0010\t\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008,\u0010-\u001a\u0004\u0008(\u0010)\"\u0004\u0008*\u0010+¨\u00064", d2 = {"Landroidx/compose/animation/RenderInTransitionOverlayNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "sharedScope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "renderInOverlay", "Lkotlin/Function0;", "", "zIndexInOverlay", "", "clipInOverlay", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/animation/SharedTransitionScopeImpl;Lkotlin/jvm/functions/Function0;FLkotlin/jvm/functions/Function2;)V", "getClipInOverlay", "()Lkotlin/jvm/functions/Function2;", "setClipInOverlay", "(Lkotlin/jvm/functions/Function2;)V", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layerWithRenderer", "Landroidx/compose/animation/RenderInTransitionOverlayNode$LayerWithRenderer;", "parentState", "Landroidx/compose/animation/SharedElementInternalState;", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "getRenderInOverlay", "()Lkotlin/jvm/functions/Function0;", "setRenderInOverlay", "(Lkotlin/jvm/functions/Function0;)V", "getSharedScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "setSharedScope", "(Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "<set-?>", "getZIndexInOverlay", "()F", "setZIndexInOverlay", "(F)V", "zIndexInOverlay$delegate", "Landroidx/compose/runtime/MutableFloatState;", "onAttach", "", "onDetach", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "LayerWithRenderer", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RenderInTransitionOverlayNode extends Modifier.Node implements DrawModifierNode, ModifierLocalModifierNode {

    public static final int $stable = 8;
    private Function2<? super LayoutDirection, ? super Density, ? extends Path> clipInOverlay;
    private androidx.compose.animation.RenderInTransitionOverlayNode.LayerWithRenderer layerWithRenderer;
    private Function0<Boolean> renderInOverlay;
    private androidx.compose.animation.SharedTransitionScopeImpl sharedScope;
    private final MutableFloatState zIndexInOverlay$delegate;

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0013", d2 = {"Landroidx/compose/animation/RenderInTransitionOverlayNode$LayerWithRenderer;", "Landroidx/compose/animation/LayerRenderer;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/animation/RenderInTransitionOverlayNode;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentState", "Landroidx/compose/animation/SharedElementInternalState;", "getParentState", "()Landroidx/compose/animation/SharedElementInternalState;", "zIndex", "", "getZIndex", "()F", "drawInOverlay", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class LayerWithRenderer implements androidx.compose.animation.LayerRenderer {

        private final GraphicsLayer layer;
        final androidx.compose.animation.RenderInTransitionOverlayNode this$0;
        public LayerWithRenderer(androidx.compose.animation.RenderInTransitionOverlayNode this$0, GraphicsLayer layer) {
            this.this$0 = this$0;
            super();
            this.layer = layer;
        }

        @Override // androidx.compose.animation.LayerRenderer
        public void drawInOverlay(DrawScope drawScope) {
            boolean booleanValue;
            DrawContext canvas;
            int i3;
            int x-impl;
            Object obj;
            Throwable y-impl;
            DrawContext transform;
            int intersect-rtfAjoo;
            int i9;
            int i8;
            int i7;
            DrawContext drawContext;
            int i2;
            long size-NH-jbRc;
            int i;
            int i4;
            int i10;
            int i5;
            int i6;
            DrawContext $this$drawInOverlay_u24lambda_u243;
            final Object obj2 = this;
            if ((Boolean)obj2.this$0.getRenderInOverlay().invoke().booleanValue()) {
                androidx.compose.animation.RenderInTransitionOverlayNode this$02 = obj2.this$0;
                canvas = drawScope;
                int i11 = 0;
                androidx.compose.animation.RenderInTransitionOverlayNode renderInTransitionOverlayNode = this$02;
                long zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
                long localPositionOf-R5De75A = this$02.getSharedScope().getRoot$animation_release().localPositionOf-R5De75A(DelegatableNodeKt.requireLayoutCoordinates((DelegatableNode)renderInTransitionOverlayNode), zero-F1C5BW0);
                int i12 = 0;
                x-impl = Offset.getX-impl(localPositionOf-R5De75A);
                int i14 = 0;
                y-impl = Offset.getY-impl(localPositionOf-R5De75A);
                obj = invoke2;
                if ((Path)obj != null) {
                    i9 = 0;
                    i8 = transform;
                    i7 = 0;
                    drawContext = i8.getDrawContext();
                    i2 = 0;
                    drawContext.getCanvas().save();
                    int i15 = 0;
                    drawContext.getTransform().clipPath-mtrdD-E((Path)obj, ClipOp.Companion.getIntersect-rtfAjoo());
                    i4 = 0;
                    i10 = i;
                    i5 = 0;
                    i10.getDrawContext().getTransform().translate(x-impl, y-impl);
                    int i16 = 0;
                    $this$drawInOverlay_u24lambda_u243 = canvas;
                    GraphicsLayerKt.drawLayer(i10, obj2.layer);
                    i6 = i11;
                    i10.getDrawContext().getTransform().translate(-x-impl, -y-impl);
                    drawContext.getCanvas().restore();
                    drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
                } else {
                    $this$drawInOverlay_u24lambda_u243 = canvas;
                    i6 = i11;
                    i3 = 0;
                    canvas.getDrawContext().getTransform().translate(x-impl, y-impl);
                    int i13 = 0;
                    GraphicsLayerKt.drawLayer(canvas, obj2.layer);
                    canvas.getDrawContext().getTransform().translate(-x-impl, -y-impl);
                }
            }
        }

        @Override // androidx.compose.animation.LayerRenderer
        public final GraphicsLayer getLayer() {
            return this.layer;
        }

        @Override // androidx.compose.animation.LayerRenderer
        public androidx.compose.animation.SharedElementInternalState getParentState() {
            return this.this$0.getParentState();
        }

        @Override // androidx.compose.animation.LayerRenderer
        public float getZIndex() {
            return this.this$0.getZIndexInOverlay();
        }
    }
    static {
        final int i = 8;
    }

    public RenderInTransitionOverlayNode(androidx.compose.animation.SharedTransitionScopeImpl sharedScope, Function0<Boolean> renderInOverlay, float zIndexInOverlay, Function2<? super LayoutDirection, ? super Density, ? extends Path> clipInOverlay) {
        super();
        this.sharedScope = sharedScope;
        this.renderInOverlay = renderInOverlay;
        this.clipInOverlay = clipInOverlay;
        this.zIndexInOverlay$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(zIndexInOverlay);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void draw(ContentDrawScope $this$draw) {
        boolean booleanValue;
        GraphicsLayer layer = getLayer();
        if (layer == null) {
        } else {
            final GraphicsLayer graphicsLayer = layer;
            RenderInTransitionOverlayNode.draw.1 anon = new RenderInTransitionOverlayNode.draw.1($this$draw);
            DrawScope.record-JVtK1S4$default((DrawScope)$this$draw, graphicsLayer, 0, obj4, (Function1)anon, 1);
            if (!(Boolean)this.renderInOverlay.invoke().booleanValue()) {
                GraphicsLayerKt.drawLayer((DrawScope)$this$draw, graphicsLayer);
            }
        }
        int i = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Error: layer never initialized".toString());
        throw illegalArgumentException;
    }

    public final Function2<LayoutDirection, Density, Path> getClipInOverlay() {
        return this.clipInOverlay;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final GraphicsLayer getLayer() {
        GraphicsLayer layer;
        androidx.compose.animation.RenderInTransitionOverlayNode.LayerWithRenderer layerWithRenderer = this.layerWithRenderer;
        if (layerWithRenderer != null) {
            layer = layerWithRenderer.getLayer();
        } else {
            layer = 0;
        }
        return layer;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.animation.SharedElementInternalState getParentState() {
        return (SharedElementInternalState)getCurrent((ModifierLocal)SharedContentNodeKt.getModifierLocalSharedElementInternalState());
    }

    public final Function0<Boolean> getRenderInOverlay() {
        return this.renderInOverlay;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.animation.SharedTransitionScopeImpl getSharedScope() {
        return this.sharedScope;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getZIndexInOverlay() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.zIndexInOverlay$delegate.getFloatValue();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onAttach() {
        RenderInTransitionOverlayNode.LayerWithRenderer layerWithRenderer = new RenderInTransitionOverlayNode.LayerWithRenderer(this, DelegatableNodeKt.requireGraphicsContext((DelegatableNode)this).createGraphicsLayer());
        int i = 0;
        this.sharedScope.onLayerRendererCreated$animation_release((LayerRenderer)layerWithRenderer);
        this.layerWithRenderer = layerWithRenderer;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        int i;
        GraphicsContext requireGraphicsContext;
        GraphicsLayer layer;
        final androidx.compose.animation.RenderInTransitionOverlayNode.LayerWithRenderer layerWithRenderer = this.layerWithRenderer;
        if (layerWithRenderer != null) {
            i = 0;
            this.sharedScope.onLayerRendererRemoved$animation_release((LayerRenderer)layerWithRenderer);
            DelegatableNodeKt.requireGraphicsContext((DelegatableNode)this).releaseGraphicsLayer(layerWithRenderer.getLayer());
        }
    }

    public final void setClipInOverlay(Function2<? super LayoutDirection, ? super Density, ? extends Path> <set-?>) {
        this.clipInOverlay = <set-?>;
    }

    public final void setRenderInOverlay(Function0<Boolean> <set-?>) {
        this.renderInOverlay = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setSharedScope(androidx.compose.animation.SharedTransitionScopeImpl <set-?>) {
        this.sharedScope = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setZIndexInOverlay(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.zIndexInOverlay$delegate.setFloatValue(<set-?>);
    }
}
