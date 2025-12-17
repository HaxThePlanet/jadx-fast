package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.PaintingStyle.Companion;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0000\u0018\u0000 C2\u00020\u0001:\u0002CDB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J:\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0010\u0010/\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0008\u00100\u001a\u00020\u0017H\u0002J\u001a\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u0002032\u0008\u00104\u001a\u0004\u0018\u000105H\u0016J=\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0019\u0010;\u001a\u0015\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u0017\u0018\u00010<¢\u0006\u0002\u0008>H\u0014ø\u0001\u0000¢\u0006\u0004\u0008?\u0010@J*\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010A\u001a\u000205H\u0014ø\u0001\u0000¢\u0006\u0004\u0008?\u0010BR(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u001a\u0010\u000c\u001a\u00020\rX\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006E", d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "<set-?>", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "tail", "Landroidx/compose/ui/node/TailModifierNode;", "getTail$annotations", "()V", "getTail", "()Landroidx/compose/ui/node/TailModifierNode;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ensureLookaheadDelegateCreated", "", "hitTestChild", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "hitTestChild-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "onAfterPlaceAt", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "layer", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Companion", "LookaheadDelegateImpl", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InnerNodeCoordinator extends androidx.compose.ui.node.NodeCoordinator {

    public static final int $stable;
    public static final androidx.compose.ui.node.InnerNodeCoordinator.Companion Companion;
    private static final Paint innerBoundsPaint;
    private androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = null;
    private final androidx.compose.ui.node.TailModifierNode tail;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$Companion;", "", "()V", "innerBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getInnerBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Paint getInnerBoundsPaint() {
            return InnerNodeCoordinator.access$getInnerBoundsPaint$cp();
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0008\u0010\u0013\u001a\u00020\u0014H\u0014\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0015", d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$LookaheadDelegateImpl;", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/InnerNodeCoordinator;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "placeChildren", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class LookaheadDelegateImpl extends androidx.compose.ui.node.LookaheadDelegate {

        final androidx.compose.ui.node.InnerNodeCoordinator this$0;
        public LookaheadDelegateImpl(androidx.compose.ui.node.InnerNodeCoordinator this$0) {
            this.this$0 = this$0;
            super((NodeCoordinator)this$0);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            int intValue;
            Object obj = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
            if ((Integer)obj != null) {
                intValue = (Integer)obj.intValue();
            } else {
                intValue = Integer.MIN_VALUE;
            }
            final int i2 = 0;
            getCachedAlignmentLinesMap().put(alignmentLine, Integer.valueOf(intValue));
            return intValue;
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int maxIntrinsicHeight(int width) {
            return getLayoutNode().maxLookaheadIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int maxIntrinsicWidth(int height) {
            return getLayoutNode().maxLookaheadIntrinsicWidth(height);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public Placeable measure-BRTryo0(long constraints) {
            int i$iv$iv;
            Object[] content;
            Object obj;
            int i;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release;
            androidx.compose.ui.node.LayoutNode.UsageByParent notUsed;
            final androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = constraints;
            final androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate2 = this;
            final int i2 = 0;
            LookaheadDelegate.access$setMeasurementConstraints-BRTryo0((LookaheadDelegate)lookaheadDelegate2, lookaheadDelegate);
            final int i3 = 0;
            int i4 = 0;
            MutableVector mutableVector = getLayoutNode().get_children$ui_release();
            int i6 = 0;
            final int size = mutableVector.getSize();
            if (size > 0) {
                i$iv$iv = 0;
                i = 0;
                lookaheadPassDelegate$ui_release = (LayoutNode)mutableVector.getContent()[i$iv$iv].getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                while (i$iv$iv++ >= size) {
                    i = 0;
                    lookaheadPassDelegate$ui_release = (LayoutNode)content[i$iv$iv].getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                }
            }
            int i5 = 0;
            LookaheadDelegate.access$set_measureResult(lookaheadDelegate2, getLayoutNode().getMeasurePolicy().measure-3p2s80s((MeasureScope)this, getLayoutNode().getChildLookaheadMeasurables$ui_release(), lookaheadDelegate));
            return (Placeable)lookaheadDelegate2;
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int minIntrinsicHeight(int width) {
            return getLayoutNode().minLookaheadIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public int minIntrinsicWidth(int height) {
            return getLayoutNode().minLookaheadIntrinsicWidth(height);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        protected void placeChildren() {
            androidx.compose.ui.node.LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLookaheadPassDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
            lookaheadPassDelegate$ui_release.onNodePlaced$ui_release();
        }
    }
    static {
        InnerNodeCoordinator.Companion companion = new InnerNodeCoordinator.Companion(0);
        InnerNodeCoordinator.Companion = companion;
        Paint paint = AndroidPaint_androidKt.Paint();
        Paint paint2 = paint;
        final int i2 = 0;
        paint2.setColor-8_81llA(Color.Companion.getRed-0d7_KjU());
        paint2.setStrokeWidth(1065353216);
        paint2.setStyle-k9PVt8s(PaintingStyle.Companion.getStroke-TiuSbCo());
        InnerNodeCoordinator.innerBoundsPaint = paint;
    }

    public InnerNodeCoordinator(androidx.compose.ui.node.LayoutNode layoutNode) {
        super(layoutNode);
        TailModifierNode tailModifierNode = new TailModifierNode();
        this.tail = tailModifierNode;
        getTail().updateCoordinator$ui_release((NodeCoordinator)this);
        if (layoutNode.getLookaheadRoot$ui_release() != null) {
            InnerNodeCoordinator.LookaheadDelegateImpl lookaheadDelegateImpl = new InnerNodeCoordinator.LookaheadDelegateImpl(this);
        }
        int i = 0;
    }

    public static final Paint access$getInnerBoundsPaint$cp() {
        return InnerNodeCoordinator.innerBoundsPaint;
    }

    public static void getTail$annotations() {
    }

    private final void onAfterPlaceAt() {
        if (isShallowPlacing$ui_release()) {
        }
        onPlaced();
        getLayoutNode().getMeasurePassDelegate$ui_release().onNodePlaced$ui_release();
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        int alignmentLine2;
        androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
        if (lookaheadDelegate != null) {
            alignmentLine2 = lookaheadDelegate.calculateAlignmentLine(alignmentLine);
        } else {
            Object obj = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
            if ((Integer)obj != null) {
                alignmentLine2 = (Integer)obj.intValue();
            } else {
                alignmentLine2 = Integer.MIN_VALUE;
            }
        }
        return alignmentLine2;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void ensureLookaheadDelegateCreated() {
        androidx.compose.ui.node.LookaheadDelegate lookaheadDelegateImpl;
        if (getLookaheadDelegate() == null) {
            lookaheadDelegateImpl = new InnerNodeCoordinator.LookaheadDelegateImpl(this);
            setLookaheadDelegate((LookaheadDelegate)lookaheadDelegateImpl);
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public androidx.compose.ui.node.LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public Modifier.Node getTail() {
        return (Modifier.Node)getTail();
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public androidx.compose.ui.node.TailModifierNode getTail() {
        return this.tail;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void hitTestChild-YqVAtuI(androidx.compose.ui.node.NodeCoordinator.HitTestSource hitTestSource, long pointerPosition, androidx.compose.ui.node.HitTestResult hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        int inLayer;
        int hitTestChildren;
        long continueHitTest;
        long shouldSharePointerInputWithSibling;
        int withinLayerBounds-k-4lQ0M;
        float distanceInMinimumTouchTarget-tz77jQw;
        boolean z;
        int i;
        boolean infinite;
        int i3;
        long minimumTouchTargetSize-NH-jbRc;
        androidx.compose.ui.node.HitTestResult hitTestResult2;
        int i4;
        int i2;
        int i7;
        MutableVector zSortedChildren;
        int i5;
        int size;
        Object[] content;
        int i$iv;
        int i6;
        final Object obj = this;
        continueHitTest = pointerPosition;
        int i8 = 0;
        inLayer = obj27;
        final int i10 = 0;
        final int i11 = 1;
        if (hitTestSource.shouldHitTestChildren(obj.getLayoutNode())) {
            if (obj.withinLayerBounds-k-4lQ0M(continueHitTest)) {
                i = inLayer;
                i3 = hitTestChildren;
            } else {
                if (isInLayer) {
                    distanceInMinimumTouchTarget-tz77jQw = obj.distanceInMinimumTouchTarget-tz77jQw(continueHitTest, obj4);
                    if (!Float.isInfinite(distanceInMinimumTouchTarget-tz77jQw) && !Float.isNaN(distanceInMinimumTouchTarget-tz77jQw)) {
                        withinLayerBounds-k-4lQ0M = !Float.isNaN(distanceInMinimumTouchTarget-tz77jQw) ? i11 : i10;
                    } else {
                    }
                    if (withinLayerBounds-k-4lQ0M != 0) {
                        i = inLayer;
                        i3 = hitTestChildren;
                    } else {
                        i = inLayer;
                        i3 = hitTestChildren;
                    }
                } else {
                }
            }
        } else {
        }
        if (i3 != 0) {
            hitTestResult2 = isTouchEvent;
            i4 = 0;
            i7 = 0;
            zSortedChildren = obj.getLayoutNode().getZSortedChildren();
            i5 = 0;
            size = zSortedChildren.getSize();
            if (size > 0) {
                i$iv = inLayer;
                hitTestChildren = i$iv2;
                i6 = 0;
                while ((LayoutNode)hitTestChildren.isPlaced()) {
                    z.childHitTest-YqVAtuI(hitTestChildren, continueHitTest, shouldSharePointerInputWithSibling, isTouchEvent, isInLayer);
                    int i9 = 0;
                    if (!isTouchEvent.hasHit()) {
                    } else {
                    }
                    if (isTouchEvent.getShouldSharePointerInputWithSibling()) {
                    } else {
                    }
                    continueHitTest = 0;
                    if (continueHitTest == 0) {
                    } else {
                    }
                    inLayer = i10;
                    if (inLayer == 0) {
                        break;
                    }
                    if (i$iv-- < 0) {
                        break;
                    } else {
                    }
                    z = hitTestSource;
                    continueHitTest = pointerPosition;
                    hitTestChildren = i$iv2;
                    i6 = 0;
                    inLayer = i10;
                    inLayer = i11;
                    isTouchEvent.acceptHits();
                    continueHitTest = 1;
                    continueHitTest = 1;
                }
            } else {
            }
            HitTestResult.access$setHitDepth$p(hitTestResult2, HitTestResult.access$getHitDepth$p(hitTestResult2));
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public int maxIntrinsicHeight(int width) {
        return getLayoutNode().maxIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public int maxIntrinsicWidth(int height) {
        return getLayoutNode().maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public Placeable measure-BRTryo0(long constraints) {
        long constraints-msEJaDk$ui_release;
        androidx.compose.ui.node.LayoutNode.UsageByParent this_$iv2;
        int i$iv$iv;
        Object[] content;
        Object obj;
        int i;
        androidx.compose.ui.node.LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate$ui_release;
        androidx.compose.ui.node.LayoutNode.UsageByParent this_$iv;
        final androidx.compose.ui.layout.MeasureScope measureScope = this;
        if (measureScope.getForceMeasureWithLookaheadConstraints$ui_release()) {
            androidx.compose.ui.node.LookaheadDelegate lookaheadDelegate = measureScope.getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            constraints-msEJaDk$ui_release = lookaheadDelegate.getConstraints-msEJaDk$ui_release();
        } else {
            constraints-msEJaDk$ui_release = constraints;
        }
        this_$iv2 = measureScope;
        final int i2 = 0;
        NodeCoordinator.access$setMeasurementConstraints-BRTryo0((NodeCoordinator)this_$iv2, constraints-msEJaDk$ui_release);
        final int i3 = 0;
        int i5 = 0;
        MutableVector mutableVector = measureScope.getLayoutNode().get_children$ui_release();
        final int i6 = 0;
        final int size = mutableVector.getSize();
        if (size > 0) {
            i$iv$iv = 0;
            i = 0;
            (LayoutNode)mutableVector.getContent()[i$iv$iv].getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
            while (i$iv$iv++ >= size) {
                this_$iv2 = this_$iv;
                i = 0;
                (LayoutNode)content[i$iv$iv].getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
            }
        } else {
            this_$iv = this_$iv2;
        }
        int i4 = 0;
        measureScope.setMeasureResult$ui_release(measureScope.getLayoutNode().getMeasurePolicy().measure-3p2s80s((MeasureScope)measureScope, measureScope.getLayoutNode().getChildMeasurables$ui_release(), constraints-msEJaDk$ui_release));
        measureScope.onMeasured();
        return (Placeable)measureScope;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public int minIntrinsicHeight(int width) {
        return getLayoutNode().minIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public int minIntrinsicWidth(int height) {
        return getLayoutNode().minIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        boolean showLayoutBounds;
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        boolean placed;
        MutableVector zSortedChildren = getLayoutNode().getZSortedChildren();
        final int i2 = 0;
        final int size = zSortedChildren.getSize();
        if (size > 0) {
            i$iv = 0;
            obj = zSortedChildren.getContent()[i$iv];
            i = 0;
            do {
                obj = content[i$iv];
                i = 0;
                if (i$iv++ < size) {
                }
                obj.draw$ui_release(canvas, graphicsLayer);
            } while ((LayoutNode)obj.isPlaced());
        }
        if (LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds()) {
            drawBorder(canvas, InnerNodeCoordinator.innerBoundsPaint);
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    protected void placeAt-f8xVGno(long position, float zIndex, GraphicsLayer layer) {
        super.placeAt-f8xVGno(position, zIndex, layer);
        onAfterPlaceAt();
    }

    protected void placeAt-f8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        super.placeAt-f8xVGno(position, zIndex, layerBlock);
        onAfterPlaceAt();
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    protected void setLookaheadDelegate(androidx.compose.ui.node.LookaheadDelegate <set-?>) {
        this.lookaheadDelegate = <set-?>;
    }
}
