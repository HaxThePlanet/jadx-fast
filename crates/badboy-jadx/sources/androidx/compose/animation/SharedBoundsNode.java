package androidx.compose.animation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'J\u0008\u0010(\u001a\u00020)H\u0016J\u0008\u0010*\u001a\u00020)H\u0016J\u0008\u0010+\u001a\u00020)H\u0016J\u0008\u0010,\u001a\u00020\u0016H\u0002J&\u0010-\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\u00084\u00105J\u000c\u00106\u001a\u00020)*\u000207H\u0016J&\u00108\u001a\u00020.*\u0002092\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\u0008:\u0010;J\u0014\u0010<\u001a\u00020.*\u0002092\u0006\u0010=\u001a\u00020>H\u0002J\u000c\u0010?\u001a\u00020)*\u00020\u0016H\u0002R\u0014\u0010\u0008\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r@BX\u0082\u000e¢\u0006\u0008\n\u0000\"\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0006@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006@", d2 = {"Landroidx/compose/animation/SharedBoundsNode;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "state", "Landroidx/compose/animation/SharedElementInternalState;", "(Landroidx/compose/animation/SharedElementInternalState;)V", "boundsAnimation", "Landroidx/compose/animation/BoundsAnimation;", "getBoundsAnimation", "()Landroidx/compose/animation/BoundsAnimation;", "value", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "setLayer", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "rootCoords", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getRootCoords", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "rootLookaheadCoords", "getRootLookaheadCoords", "sharedElement", "Landroidx/compose/animation/SharedElement;", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "getState", "()Landroidx/compose/animation/SharedElementInternalState;", "setState$animation_release", "isMeasurementApproachInProgress", "", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "onAttach", "", "onDetach", "onReset", "requireLookaheadLayoutCoordinates", "approachMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "measure", "Landroidx/compose/ui/layout/MeasureScope;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "place", "placeable", "Landroidx/compose/ui/layout/Placeable;", "updateCurrentBounds", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SharedBoundsNode extends Modifier.Node implements ApproachLayoutModifierNode, DrawModifierNode, ModifierLocalModifierNode {

    public static final int $stable = 8;
    private GraphicsLayer layer;
    private final ModifierLocalMap providedValues;
    private androidx.compose.animation.SharedElementInternalState state;
    static {
        final int i = 8;
    }

    public SharedBoundsNode(androidx.compose.animation.SharedElementInternalState state) {
        super();
        this.state = state;
        this.layer = state.getLayer();
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(SharedContentNodeKt.getModifierLocalSharedElementInternalState(), state));
    }

    public static final androidx.compose.animation.BoundsAnimation access$getBoundsAnimation(androidx.compose.animation.SharedBoundsNode $this) {
        return $this.getBoundsAnimation();
    }

    public static final LayoutCoordinates access$getRootCoords(androidx.compose.animation.SharedBoundsNode $this) {
        return $this.getRootCoords();
    }

    public static final LayoutCoordinates access$getRootLookaheadCoords(androidx.compose.animation.SharedBoundsNode $this) {
        return $this.getRootLookaheadCoords();
    }

    public static final androidx.compose.animation.SharedElement access$getSharedElement(androidx.compose.animation.SharedBoundsNode $this) {
        return $this.getSharedElement();
    }

    public static final LayoutCoordinates access$requireLookaheadLayoutCoordinates(androidx.compose.animation.SharedBoundsNode $this) {
        return $this.requireLookaheadLayoutCoordinates();
    }

    public static final void access$updateCurrentBounds(androidx.compose.animation.SharedBoundsNode $this, LayoutCoordinates $receiver) {
        $this.updateCurrentBounds($receiver);
    }

    private final androidx.compose.animation.BoundsAnimation getBoundsAnimation() {
        return this.state.getBoundsAnimation();
    }

    private final LayoutCoordinates getRootCoords() {
        return getSharedElement().getScope().getRoot$animation_release();
    }

    private final LayoutCoordinates getRootLookaheadCoords() {
        return getSharedElement().getScope().getLookaheadRoot$animation_release();
    }

    private final androidx.compose.animation.SharedElement getSharedElement() {
        return this.state.getSharedElement();
    }

    private final MeasureResult place(MeasureScope $this$place, Placeable placeable) {
        long size-YbymL2g = requireLookaheadLayoutCoordinates().getSize-YbymL2g();
        int height = placeable.getHeight();
        long size-JyjRU_E = this.state.getPlaceHolderSize().calculateSize-JyjRU_E(size-YbymL2g, obj2);
        int i = 0;
        int i2 = 0;
        SharedBoundsNode.place.1 anon = new SharedBoundsNode.place.1(this, placeable);
        return MeasureScope.layout$default($this$place, IntSize.getWidth-impl(size-JyjRU_E), IntSize.getHeight-impl(size-JyjRU_E), 0, (Function1)anon, 4, 0);
    }

    private final LayoutCoordinates requireLookaheadLayoutCoordinates() {
        final int i = 0;
        return this.state.getSharedElement().getScope().toLookaheadCoordinates(DelegatableNodeKt.requireLayoutCoordinates((DelegatableNode)this));
    }

    private final void setLayer(GraphicsLayer value) {
        Object state;
        int i;
        GraphicsContext requireGraphicsContext;
        if (value == null) {
            state = this.layer;
            if (state != null) {
                i = 0;
                DelegatableNodeKt.requireGraphicsContext((DelegatableNode)this).releaseGraphicsLayer(state);
            }
        } else {
            this.state.setLayer(value);
        }
        this.layer = value;
    }

    private final void updateCurrentBounds(LayoutCoordinates $this$updateCurrentBounds) {
        long zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
        float f2 = (float)height-impl;
        getSharedElement().setCurrentBounds(RectKt.Rect-tz77jQw(getRootCoords().localPositionOf-R5De75A($this$updateCurrentBounds, zero-F1C5BW0), zero-F1C5BW0));
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult approachMeasure-3p2s80s(ApproachMeasureScope $this$approachMeasure_u2d3p2s80s, Measurable measurable, long constraints) {
        long it;
        Rect currentBounds;
        int i;
        int height-impl;
        Constraints.Companion companion;
        int i2;
        int $i$f$component1Impl;
        int coerceAtLeast2;
        int coerceAtLeast;
        if (!getSharedElement().getFoundMatch()) {
        } else {
            if (getBoundsAnimation().getValue() == null) {
                currentBounds = getSharedElement().getCurrentBounds();
            }
            if (currentBounds != null) {
                i = 0;
                long roundToIntSize-uvyYCjk = IntSizeKt.roundToIntSize-uvyYCjk(currentBounds.getSize-NH-jbRc());
                int i5 = 0;
                $i$f$component1Impl = IntSize.getWidth-impl(roundToIntSize-uvyYCjk);
                int i6 = 0;
                height-impl = IntSize.getHeight-impl(roundToIntSize-uvyYCjk);
                int i3 = Integer.MAX_VALUE;
                int i7 = 0;
                if ($i$f$component1Impl != i3 && height-impl != i3) {
                    i2 = height-impl != i3 ? 1 : i7;
                } else {
                }
                if (i2 == 0) {
                } else {
                    it = Constraints.Companion.fixed-JhjzzOo(RangesKt.coerceAtLeast($i$f$component1Impl, i7), RangesKt.coerceAtLeast(height-impl, i7));
                    return place((MeasureScope)$this$approachMeasure_u2d3p2s80s, measurable.measure-BRTryo0(it));
                }
                int i4 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Error: Infinite width/height is invalid. animated bounds: ").append(getBoundsAnimation().getValue()).append(", current bounds: ").append(getSharedElement().getCurrentBounds()).toString().toString());
                throw illegalArgumentException;
            }
        }
        it = constraints;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void draw(ContentDrawScope $this$draw) {
        boolean shouldRenderInPlace;
        Rect currentBounds = getSharedElement().getCurrentBounds();
        Intrinsics.checkNotNull(currentBounds);
        final androidx.compose.ui.unit.LayoutDirection layoutDirection = $this$draw.getLayoutDirection();
        this.state.setClipPathInOverlay$animation_release(this.state.getOverlayClip().getClipPath(this.state.getUserState(), currentBounds, layoutDirection, DelegatableNodeKt.requireDensity((DelegatableNode)this)));
        GraphicsLayer layer = this.state.getLayer();
        if (layer == null) {
        } else {
            GraphicsLayer graphicsLayer = layer;
            SharedBoundsNode.draw.1 anon = new SharedBoundsNode.draw.1($this$draw, this);
            DrawScope.record-JVtK1S4$default((DrawScope)$this$draw, graphicsLayer, 0, layoutDirection, (Function1)anon, 1);
            if (this.state.getShouldRenderInPlace()) {
                GraphicsLayerKt.drawLayer((DrawScope)$this$draw, graphicsLayer);
            }
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Error: Layer is null when accessed for shared bounds/element : ").append(getSharedElement().getKey()).append(",target: ").append(this.state.getBoundsAnimation().getTarget()).append(", is attached: ").append(isAttached()).toString().toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.animation.SharedElementInternalState getState() {
        return this.state;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean isMeasurementApproachInProgress-ozmzZPI(long lookaheadSize) {
        boolean transitionActive;
        int i;
        if (getSharedElement().getFoundMatch() && this.state.getSharedElement().getScope().isTransitionActive()) {
            i = this.state.getSharedElement().getScope().isTransitionActive() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        final Placeable measure-BRTryo0 = measurable.measure-BRTryo0(constraints);
        float f2 = (float)height;
        SharedBoundsNode.measure.1 anon = new SharedBoundsNode.measure.1(measure-BRTryo0, this, SizeKt.Size((float)width, f2), f2);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, measure-BRTryo0.getWidth(), measure-BRTryo0.getHeight(), 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onAttach() {
        super.onAttach();
        provide((ModifierLocal)SharedContentNodeKt.getModifierLocalSharedElementInternalState(), this.state);
        this.state.setParentState((SharedElementInternalState)getCurrent((ModifierLocal)SharedContentNodeKt.getModifierLocalSharedElementInternalState()));
        setLayer(DelegatableNodeKt.requireGraphicsContext((DelegatableNode)this).createGraphicsLayer());
        SharedBoundsNode.onAttach.1 anon = new SharedBoundsNode.onAttach.1(this);
        this.state.setLookaheadCoords((Function0)anon);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        super.onDetach();
        int i = 0;
        setLayer(i);
        this.state.setParentState(i);
        this.state.setLookaheadCoords((Function0)SharedBoundsNode.onDetach.1.INSTANCE);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onReset() {
        int i;
        GraphicsContext requireGraphicsContext;
        super.onReset();
        GraphicsLayer layer = this.layer;
        if (layer != null) {
            i = 0;
            DelegatableNodeKt.requireGraphicsContext((DelegatableNode)this).releaseGraphicsLayer(layer);
        }
        setLayer(DelegatableNodeKt.requireGraphicsContext((DelegatableNode)this).createGraphicsLayer());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setState$animation_release(androidx.compose.animation.SharedElementInternalState value) {
        boolean attached;
        androidx.compose.animation.SharedBoundsNode.state.1 anon;
        this.state = value;
        if (!Intrinsics.areEqual(value, this.state) && isAttached()) {
            this.state = value;
            if (isAttached()) {
                provide((ModifierLocal)SharedContentNodeKt.getModifierLocalSharedElementInternalState(), value);
                this.state.setParentState((SharedElementInternalState)getCurrent((ModifierLocal)SharedContentNodeKt.getModifierLocalSharedElementInternalState()));
                this.state.setLayer(this.layer);
                anon = new SharedBoundsNode.state.1(this);
                this.state.setLookaheadCoords((Function0)anon);
            }
        }
    }
}
