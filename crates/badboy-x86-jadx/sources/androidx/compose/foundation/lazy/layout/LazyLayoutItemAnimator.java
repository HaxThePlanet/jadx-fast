package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0015\n\u0002\u0008\u0005\u0008\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003IJKB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010(\u001a\u0004\u0018\u00010\u00072\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u000bJ1\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\u000b2\u0012\u0008\u0002\u0010.\u001a\u000c0\u0010R\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0002\u0010/J\u0082\u0001\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u000c\u00104\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u000c\u001a\u00020\r2\u000c\u00105\u001a\u0008\u0012\u0004\u0012\u00028\u0000062\u0006\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@J\u0010\u0010A\u001a\u00020,2\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0006\u0010B\u001a\u00020,J\u001f\u0010C\u001a\u00020,2\u0006\u0010-\u001a\u00028\u00002\u0008\u0008\u0002\u0010D\u001a\u00020#H\u0002¢\u0006\u0002\u0010EJ\u0019\u0010F\u001a\u00020\u000b*\u00020G2\u0006\u0010-\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010HR\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\u000c0\u0010R\u0008\u0012\u0004\u0012\u00028\u00000\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\u00020\u00128Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\u00020\u000b*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010!R\u0018\u0010\"\u001a\u00020#*\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u0018\u0010&\u001a\u00020\u000b*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008'\u0010!\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006L", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "T", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "", "()V", "disappearingItems", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "displayingNode", "Landroidx/compose/ui/node/DrawModifierNode;", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "minSizeToFitDisappearingItems", "Landroidx/compose/ui/unit/IntSize;", "getMinSizeToFitDisappearingItems-YbymL2g", "()J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingAwayToEndBound", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "crossAxisOffset", "getCrossAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)Z", "mainAxisOffset", "getMainAxisOffset", "getAnimation", "key", "placeableIndex", "initializeAnimation", "", "item", "itemInfo", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;ILandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;)V", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "isVertical", "isLookingAhead", "laneCount", "hasLookaheadOccurred", "layoutMinOffset", "layoutMaxOffset", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "removeInfoForKey", "reset", "startPlacementAnimationsIfNeeded", "isMovingAway", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Z)V", "updateAndReturnOffsetFor", "", "([ILandroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "DisplayingDisappearingItemsElement", "DisplayingDisappearingItemsNode", "ItemInfo", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutItemAnimator<T extends androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem>  {

    public static final int $stable = 8;
    private final List<androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation> disappearingItems;
    private DrawModifierNode displayingNode;
    private int firstVisibleIndex;
    private androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap keyIndexMap;
    private final MutableScatterMap<Object, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo<T>> keyToItemInfoMap;
    private final Modifier modifier;
    private final MutableScatterSet<Object> movingAwayKeys;
    private final List<T> movingAwayToEndBound;
    private final List<T> movingAwayToStartBound;
    private final List<T> movingInFromEndBound;
    private final List<T> movingInFromStartBound;

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u0004HÂ\u0003J\u0017\u0010\u0007\u001a\u00020\u00002\u000c\u0008\u0002\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004HÆ\u0001J\u0008\u0010\u0008\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u000c\u0010\u0014\u001a\u00020\u0012*\u00020\u0015H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class DisplayingDisappearingItemsElement extends ModifierNodeElement<androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.DisplayingDisappearingItemsNode> {

        private final androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<?> animator;
        public DisplayingDisappearingItemsElement(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<?> animator) {
            super();
            this.animator = animator;
        }

        private final androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<?> component1() {
            return this.animator;
        }

        public static androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.DisplayingDisappearingItemsElement copy$default(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.DisplayingDisappearingItemsElement lazyLayoutItemAnimator$DisplayingDisappearingItemsElement, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator lazyLayoutItemAnimator2, int i3, Object object4) {
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator obj1;
            if (i3 &= 1 != 0) {
                obj1 = displayingDisappearingItemsElement.animator;
            }
            return displayingDisappearingItemsElement.copy(obj1);
        }

        public final androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.DisplayingDisappearingItemsElement copy(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            LazyLayoutItemAnimator.DisplayingDisappearingItemsElement displayingDisappearingItemsElement = new LazyLayoutItemAnimator.DisplayingDisappearingItemsElement(lazyLayoutItemAnimator);
            return displayingDisappearingItemsElement;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.DisplayingDisappearingItemsNode create() {
            LazyLayoutItemAnimator.DisplayingDisappearingItemsNode displayingDisappearingItemsNode = new LazyLayoutItemAnimator.DisplayingDisappearingItemsNode(this.animator);
            return displayingDisappearingItemsNode;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public Modifier.Node create() {
            return (Modifier.Node)create();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof LazyLayoutItemAnimator.DisplayingDisappearingItemsElement) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.animator, obj.animator)) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return this.animator.hashCode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
            $this$inspectableProperties.setName("DisplayingDisappearingItemsElement");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("DisplayingDisappearingItemsElement(animator=").append(this.animator).append(')').toString();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.DisplayingDisappearingItemsNode node) {
            node.setAnimator(this.animator);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(Modifier.Node node) {
            update((LazyLayoutItemAnimator.DisplayingDisappearingItemsNode)node);
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u0004HÂ\u0003J\u0017\u0010\u0007\u001a\u00020\u00002\u000c\u0008\u0002\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004HÆ\u0001J\u0013\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u000c\u0010\u0014\u001a\u00020\u000f*\u00020\u0015H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "onAttach", "", "onDetach", "setAnimator", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class DisplayingDisappearingItemsNode extends Modifier.Node implements DrawModifierNode {

        private androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<?> animator;
        public DisplayingDisappearingItemsNode(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<?> animator) {
            super();
            this.animator = animator;
        }

        private final androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<?> component1() {
            return this.animator;
        }

        public static androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.DisplayingDisappearingItemsNode copy$default(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.DisplayingDisappearingItemsNode lazyLayoutItemAnimator$DisplayingDisappearingItemsNode, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator lazyLayoutItemAnimator2, int i3, Object object4) {
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator obj1;
            if (i3 &= 1 != 0) {
                obj1 = displayingDisappearingItemsNode.animator;
            }
            return displayingDisappearingItemsNode.copy(obj1);
        }

        public final androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.DisplayingDisappearingItemsNode copy(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            LazyLayoutItemAnimator.DisplayingDisappearingItemsNode displayingDisappearingItemsNode = new LazyLayoutItemAnimator.DisplayingDisappearingItemsNode(lazyLayoutItemAnimator);
            return displayingDisappearingItemsNode;
        }

        @Override // androidx.compose.ui.Modifier$Node
        public void draw(ContentDrawScope $this$draw) {
            int transform;
            Object obj;
            List $this$fastForEach$iv;
            int index$iv;
            Object obj3;
            Object obj2;
            int i2;
            GraphicsLayer graphicsLayer;
            float f;
            long l;
            long l4;
            int i3;
            long l3;
            long l2;
            List i;
            final int i5 = 0;
            index$iv = transform;
            while (index$iv < LazyLayoutItemAnimator.access$getDisappearingItems$p(obj.animator).size()) {
                obj2 = obj3;
                i2 = 0;
                transform = (LazyLayoutItemAnimation)obj2.getLayer();
                if (transform == null) {
                } else {
                }
                graphicsLayer = transform;
                l4 = $this$draw;
                i3 = f - f2;
                l3 = l - f3;
                l2 = 0;
                (DrawScope)l4.getDrawContext().getTransform().translate(i3, l3);
                int i7 = 0;
                GraphicsLayerKt.drawLayer(l4, graphicsLayer);
                i = $this$fastForEach$iv;
                l4.getDrawContext().getTransform().translate(-i3, -l3);
                index$iv++;
                obj = this;
                $this$fastForEach$iv = i;
                i = $this$fastForEach$iv;
            }
            $this$draw.drawContent();
        }

        @Override // androidx.compose.ui.Modifier$Node
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof LazyLayoutItemAnimator.DisplayingDisappearingItemsNode) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.animator, obj.animator)) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.ui.Modifier$Node
        public int hashCode() {
            return this.animator.hashCode();
        }

        @Override // androidx.compose.ui.Modifier$Node
        public void onAttach() {
            LazyLayoutItemAnimator.access$setDisplayingNode$p(this.animator, (DrawModifierNode)this);
        }

        @Override // androidx.compose.ui.Modifier$Node
        public void onDetach() {
            this.animator.reset();
        }

        public final void setAnimator(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<?> animator) {
            boolean attached;
            if (!Intrinsics.areEqual(this.animator, animator) && getNode().isAttached()) {
                if (getNode().isAttached()) {
                    this.animator.reset();
                    LazyLayoutItemAnimator.access$setDisplayingNode$p(animator, (DrawModifierNode)this);
                    this.animator = animator;
                }
            }
        }

        @Override // androidx.compose.ui.Modifier$Node
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("DisplayingDisappearingItemsNode(animator=").append(this.animator).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J=\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010*R0\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\"\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u0013\"\u0004\u0008\u001b\u0010\u0015R\u001e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0013R\u001e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\u0013\"\u0004\u0008\"\u0010\u0015\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006+", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "<set-?>", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "animations", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "setConstraints-_Sx5XlM", "(Landroidx/compose/ui/unit/Constraints;)V", "crossAxisOffset", "", "getCrossAxisOffset", "()I", "setCrossAxisOffset", "(I)V", "isRunningPlacement", "", "()Z", "lane", "getLane", "setLane", "layoutMaxOffset", "getLayoutMaxOffset", "layoutMinOffset", "getLayoutMinOffset", "span", "getSpan", "setSpan", "updateAnimation", "", "positionedItem", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;III)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class ItemInfo {

        private androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] animations;
        private Constraints constraints;
        private int crossAxisOffset;
        private int lane;
        private int layoutMaxOffset;
        private int layoutMinOffset;
        private int span = 1;
        final androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<T> this$0;
        public ItemInfo(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator this$0) {
            this.this$0 = this$0;
            super();
            this.animations = LazyLayoutItemAnimatorKt.access$getEmptyArray$p();
            int i = 1;
        }

        private final boolean isRunningPlacement() {
            int i3;
            int i4;
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation lazyLayoutItemAnimation;
            int it;
            int i;
            int i2;
            boolean runningMovingAwayAnimation;
            final androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] animations = this.animations;
            final int i5 = 0;
            i3 = 0;
            i4 = i3;
            while (i4 < animations.length) {
                androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation lazyLayoutItemAnimation2 = lazyLayoutItemAnimation;
                i = 0;
                i2 = 1;
                if (lazyLayoutItemAnimation2 != null && lazyLayoutItemAnimation2.isRunningMovingAwayAnimation() == i2) {
                } else {
                }
                it = i3;
                i4++;
                if (lazyLayoutItemAnimation2.isRunningMovingAwayAnimation() == i2) {
                } else {
                }
                it = i2;
            }
            return i3;
        }

        public static void updateAnimation$default(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo lazyLayoutItemAnimator$ItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem lazyLayoutMeasuredItem2, CoroutineScope coroutineScope3, GraphicsContext graphicsContext4, int i5, int i6, int i7, int i8, Object object9) {
            int i;
            int obj13;
            if (i8 &= 32 != 0) {
                i = obj13;
            } else {
                i = i7;
            }
            itemInfo.updateAnimation(lazyLayoutMeasuredItem2, coroutineScope3, graphicsContext4, i5, i6, i);
        }

        public final androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] getAnimations() {
            return this.animations;
        }

        public final Constraints getConstraints-DWUhwKw() {
            return this.constraints;
        }

        public final int getCrossAxisOffset() {
            return this.crossAxisOffset;
        }

        public final int getLane() {
            return this.lane;
        }

        public final int getLayoutMaxOffset() {
            return this.layoutMaxOffset;
        }

        public final int getLayoutMinOffset() {
            return this.layoutMinOffset;
        }

        public final int getSpan() {
            return this.span;
        }

        public final void setConstraints-_Sx5XlM(Constraints <set-?>) {
            this.constraints = <set-?>;
        }

        public final void setCrossAxisOffset(int <set-?>) {
            this.crossAxisOffset = <set-?>;
        }

        public final void setLane(int <set-?>) {
            this.lane = <set-?>;
        }

        public final void setSpan(int <set-?>) {
            this.span = <set-?>;
        }

        public final void updateAnimation(T positionedItem, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int layoutMinOffset, int layoutMaxOffset, int crossAxisOffset) {
            int fadeOutSpec;
            int i;
            int i2;
            int copyOf;
            int placeablesCount;
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation lazyLayoutItemAnimation;
            int i3;
            int i6;
            int i5;
            Object obj2;
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode lazyLayoutAnimationSpecsNode;
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] lazyLayoutItemAnimation2;
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation lazyLayoutItemAnimation3;
            CoroutineScope coroutineScope2;
            GraphicsContext context;
            int i4;
            final Object obj = this;
            if (!obj.isRunningPlacement()) {
                obj.layoutMinOffset = layoutMinOffset;
                obj.layoutMaxOffset = layoutMaxOffset;
            } else {
                fadeOutSpec = layoutMinOffset;
                i = layoutMaxOffset;
            }
            i2 = positionedItem.getPlaceablesCount();
            while (i2 < animations2.length) {
                lazyLayoutItemAnimation = obj.animations[i2];
                if (lazyLayoutItemAnimation != null) {
                }
                i2++;
                lazyLayoutItemAnimation.release();
            }
            if (i7.length != positionedItem.getPlaceablesCount()) {
                copyOf = Arrays.copyOf(obj.animations, positionedItem.getPlaceablesCount());
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                obj.animations = (LazyLayoutItemAnimation[])copyOf;
            }
            obj.constraints = Constraints.box-impl(positionedItem.getConstraints-msEJaDk());
            obj.crossAxisOffset = crossAxisOffset;
            obj.lane = positionedItem.getLane();
            obj.span = positionedItem.getSpan();
            i3 = 0;
            while (i3 < positionedItem.getPlaceablesCount()) {
                i6 = i3;
                i5 = 0;
                lazyLayoutAnimationSpecsNode = LazyLayoutItemAnimatorKt.access$getSpecs(positionedItem.getParentData(i6));
                if (lazyLayoutAnimationSpecsNode == null) {
                } else {
                }
                if (obj.animations[i6] == null) {
                } else {
                }
                coroutineScope2 = coroutineScope;
                context = graphicsContext;
                lazyLayoutItemAnimation2.setFadeInSpec(lazyLayoutAnimationSpecsNode.getFadeInSpec());
                lazyLayoutItemAnimation2.setPlacementSpec(lazyLayoutAnimationSpecsNode.getPlacementSpec());
                lazyLayoutItemAnimation2.setFadeOutSpec(lazyLayoutAnimationSpecsNode.getFadeOutSpec());
                i3++;
                fadeOutSpec = layoutMinOffset;
                LazyLayoutItemAnimator.ItemInfo.updateAnimation.1.animation.1 anon = new LazyLayoutItemAnimator.ItemInfo.updateAnimation.1.animation.1(obj.this$0);
                lazyLayoutItemAnimation2 = new LazyLayoutItemAnimation(coroutineScope, graphicsContext, (Function0)anon);
                i4 = 0;
                obj.animations[i6] = lazyLayoutItemAnimation2;
                androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation lazyLayoutItemAnimation4 = obj.animations[i6];
                if (lazyLayoutItemAnimation4 != null) {
                }
                obj.animations[i6] = 0;
                coroutineScope2 = coroutineScope;
                context = graphicsContext;
                lazyLayoutItemAnimation4.release();
            }
            Object obj3 = positionedItem;
            CoroutineScope coroutineScope3 = coroutineScope;
            GraphicsContext context2 = graphicsContext;
        }
    }
    static {
        final int i = 8;
    }

    public LazyLayoutItemAnimator() {
        super();
        this.keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
        this.movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
        ArrayList arrayList = new ArrayList();
        this.movingInFromStartBound = (List)arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.movingInFromEndBound = (List)arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.movingAwayToStartBound = (List)arrayList3;
        ArrayList arrayList4 = new ArrayList();
        this.movingAwayToEndBound = (List)arrayList4;
        ArrayList arrayList5 = new ArrayList();
        this.disappearingItems = (List)arrayList5;
        LazyLayoutItemAnimator.DisplayingDisappearingItemsElement displayingDisappearingItemsElement = new LazyLayoutItemAnimator.DisplayingDisappearingItemsElement(this);
        this.modifier = (Modifier)displayingDisappearingItemsElement;
    }

    public static final int access$getCrossAxisOffset(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator $this, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem $receiver) {
        return $this.getCrossAxisOffset($receiver);
    }

    public static final List access$getDisappearingItems$p(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator $this) {
        return $this.disappearingItems;
    }

    public static final DrawModifierNode access$getDisplayingNode$p(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator $this) {
        return $this.displayingNode;
    }

    public static final void access$setDisplayingNode$p(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator $this, DrawModifierNode <set-?>) {
        $this.displayingNode = <set-?>;
    }

    private final int getCrossAxisOffset(androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem $this$crossAxisOffset) {
        int y-impl;
        long offset-Bjo55l4 = $this$crossAxisOffset.getOffset-Bjo55l4(0);
        final int i2 = 0;
        if (!$this$crossAxisOffset.isVertical()) {
            y-impl = IntOffset.getY-impl(offset-Bjo55l4);
        } else {
            y-impl = IntOffset.getX-impl(offset-Bjo55l4);
        }
        return y-impl;
    }

    private final boolean getHasAnimations(T $this$hasAnimations) {
        int i;
        int i3;
        int i2;
        androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode lazyLayoutAnimationSpecsNode;
        int i5 = 0;
        i = i5;
        while (i < $this$hasAnimations.getPlaceablesCount()) {
            i2 = 0;
            i++;
        }
        return i5;
    }

    private final int getMainAxisOffset(androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem $this$mainAxisOffset) {
        int y-impl;
        long offset-Bjo55l4 = $this$mainAxisOffset.getOffset-Bjo55l4(0);
        final int i2 = 0;
        if ($this$mainAxisOffset.isVertical()) {
            y-impl = IntOffset.getY-impl(offset-Bjo55l4);
        } else {
            y-impl = IntOffset.getX-impl(offset-Bjo55l4);
        }
        return y-impl;
    }

    private final void initializeAnimation(T item, int mainAxisOffset, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo<T> itemInfo) {
        long plus-qkQi6aY;
        int i4;
        int i6;
        int i2;
        long copy-iSbpLlY$default;
        int i7;
        int i5;
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation lazyLayoutItemAnimation;
        int i;
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation lazyLayoutItemAnimation2;
        int i8;
        long minus-qkQi6aY;
        int i3;
        plus-qkQi6aY = item;
        final long offset-Bjo55l4 = plus-qkQi6aY.getOffset-Bjo55l4(0);
        if (plus-qkQi6aY.isVertical()) {
            copy-iSbpLlY$default = IntOffset.copy-iSbpLlY$default(offset-Bjo55l4, obj3, 0, mainAxisOffset, 1);
        } else {
            copy-iSbpLlY$default = IntOffset.copy-iSbpLlY$default(offset-Bjo55l4, obj3, mainAxisOffset, 0, 2);
        }
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] animations = itemInfo.getAnimations();
        int i9 = 0;
        i5 = 0;
        while (i4 < animations.length) {
            lazyLayoutItemAnimation2 = lazyLayoutItemAnimation;
            i8 = 0;
            if (lazyLayoutItemAnimation2 != null) {
            } else {
            }
            i3 = i4;
            i4 = i3 + 1;
            plus-qkQi6aY = item;
            i5 = i;
            i3 = i4;
            lazyLayoutItemAnimation2.setRawOffset--gyyYBs(IntOffset.plus-qkQi6aY(copy-iSbpLlY$default, i7));
        }
    }

    static void initializeAnimation$default(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator lazyLayoutItemAnimator, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem lazyLayoutMeasuredItem2, int i3, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo lazyLayoutItemAnimator$ItemInfo4, int i5, Object object6) {
        Object obj3;
        int obj4;
        if (i5 &= 4 != 0) {
            Intrinsics.checkNotNull(lazyLayoutItemAnimator.keyToItemInfoMap.get(lazyLayoutMeasuredItem2.getKey()));
        }
        lazyLayoutItemAnimator.initializeAnimation(lazyLayoutMeasuredItem2, i3, obj3);
    }

    private final void removeInfoForKey(Object key) {
        Object animations;
        int i3;
        int length;
        int i;
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation lazyLayoutItemAnimation;
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation lazyLayoutItemAnimation2;
        int i2;
        animations = this.keyToItemInfoMap.remove(key);
        animations = (LazyLayoutItemAnimator.ItemInfo)animations.getAnimations();
        if (animations != null && animations != null) {
            animations = animations.getAnimations();
            if (animations != null) {
                i3 = 0;
                i = 0;
                while (i < animations.length) {
                    lazyLayoutItemAnimation2 = lazyLayoutItemAnimation;
                    i2 = 0;
                    if (lazyLayoutItemAnimation2 != null) {
                    }
                    i++;
                    lazyLayoutItemAnimation2.release();
                }
            }
        }
    }

    private final void startPlacementAnimationsIfNeeded(T item, boolean isMovingAway) {
        Object minus-qkQi6aY;
        Object obj;
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] animations;
        Object $this$forEachIndexed$iv2;
        int i;
        int i3;
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation lazyLayoutItemAnimation;
        int i2;
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation lazyLayoutItemAnimation2;
        int i4;
        Object obj3;
        long offset-Bjo55l4;
        long rawOffset-nOcc-ac;
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] $this$forEachIndexed$iv;
        Object obj2;
        obj = minus-qkQi6aY.keyToItemInfoMap.get(item.getKey());
        Intrinsics.checkNotNull(obj);
        final int i5 = 0;
        i = 0;
        i3 = 0;
        while (i3 < animations.length) {
            lazyLayoutItemAnimation2 = lazyLayoutItemAnimation;
            i4 = 0;
            if (lazyLayoutItemAnimation2 != null) {
            } else {
            }
            obj3 = item;
            obj2 = obj;
            $this$forEachIndexed$iv = animations;
            $this$forEachIndexed$iv2 = isMovingAway;
            i3++;
            minus-qkQi6aY = this;
            i = i2;
            animations = $this$forEachIndexed$iv;
            obj = obj2;
            offset-Bjo55l4 = item.getOffset-Bjo55l4(i);
            rawOffset-nOcc-ac = lazyLayoutItemAnimation2.getRawOffset-nOcc-ac();
            obj2 = obj;
            if (!IntOffset.equals-impl0(rawOffset-nOcc-ac, obj15)) {
            } else {
            }
            $this$forEachIndexed$iv = animations;
            $this$forEachIndexed$iv2 = isMovingAway;
            lazyLayoutItemAnimation2.setRawOffset--gyyYBs(offset-Bjo55l4);
            if (!IntOffset.equals-impl0(rawOffset-nOcc-ac, obj15)) {
            } else {
            }
            $this$forEachIndexed$iv = animations;
            $this$forEachIndexed$iv2 = isMovingAway;
            $this$forEachIndexed$iv = animations;
            lazyLayoutItemAnimation2.animatePlacementDelta-ar5cAso(IntOffset.minus-qkQi6aY(offset-Bjo55l4, obj13), obj);
        }
    }

    static void startPlacementAnimationsIfNeeded$default(androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator lazyLayoutItemAnimator, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem lazyLayoutMeasuredItem2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        lazyLayoutItemAnimator.startPlacementAnimationsIfNeeded(lazyLayoutMeasuredItem2, obj2);
    }

    private final int updateAndReturnOffsetFor(int[] $this$updateAndReturnOffsetFor, T item) {
        int maxOffset;
        int i2;
        int i;
        int mainAxisSizeWithSpacings;
        final int lane = item.getLane();
        maxOffset = 0;
        i2 = lane;
        while (i2 < lane + span) {
            $this$updateAndReturnOffsetFor[i2] = i4 += mainAxisSizeWithSpacings;
            maxOffset = Math.max(maxOffset, $this$updateAndReturnOffsetFor[i2]);
            i2++;
        }
        return maxOffset;
    }

    public final androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation getAnimation(Object key, int placeableIndex) {
        Object animations;
        int i;
        animations = this.keyToItemInfoMap.get(key);
        animations = (LazyLayoutItemAnimator.ItemInfo)animations.getAnimations();
        if (animations != null && animations != null) {
            animations = animations.getAnimations();
            i = animations != null ? animations[placeableIndex] : 0;
        } else {
        }
        return i;
    }

    public final long getMinSizeToFitDisappearingItems-YbymL2g() {
        long size;
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        GraphicsLayer layer;
        int i3;
        int i2;
        long l;
        long height-impl;
        int i4 = 0;
        size = IntSize.Companion.getZero-YbymL2g();
        List disappearingItems = this.disappearingItems;
        final int i5 = 0;
        index$iv = 0;
        while (index$iv < disappearingItems.size()) {
            obj2 = obj;
            i = 0;
            layer = (LazyLayoutItemAnimation)obj2.getLayer();
            if (layer != null) {
            }
            index$iv++;
            size = IntSizeKt.IntSize(Math.max(IntSize.getWidth-impl(size), x-impl += width-impl2), Math.max(IntSize.getHeight-impl(size), y-impl += height-impl));
        }
        return size;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, List<T> positionedItems, androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap keyIndexMap, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider<T> itemProvider, boolean isVertical, boolean isLookingAhead, int laneCount, boolean hasLookaheadOccurred, int layoutMinOffset, int layoutMaxOffset, CoroutineScope coroutineScope, GraphicsContext graphicsContext) {
        int $this$fastAny$iv;
        int index3;
        long scrollOffset;
        int[] iArr;
        int this_$iv;
        List $this$sortByDescending$iv;
        int layoutMinOffset2;
        List $this$sortBy$iv;
        int it;
        int empty;
        int i19;
        int size5;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        Object displayingNode;
        int item2;
        int i13;
        int crossAxisOffset;
        int i20;
        int i9;
        int i$iv$iv;
        Object[] list;
        int size3;
        Object[] index$iv;
        int size2;
        int size;
        int i3;
        MutableScatterMap map3;
        int $this$forEach$iv2;
        MutableScatterSet $i$f$isFull;
        int index;
        int newIndex;
        int index2;
        int $this$forEach$iv;
        int index$iv$iv;
        Object[] $this$maskEmptyOrDeleted$iv$iv$iv3;
        int x-impl;
        int i18;
        int j$iv$iv4;
        int i16;
        int j$iv$iv3;
        int accumulatedOffsetPerLane2;
        int i15;
        int[] iArr2;
        int length;
        int $this$any$iv;
        int value$iv$iv$iv;
        int size4;
        int[] accumulatedOffsetPerLane;
        MutableScatterMap animation;
        int i21;
        MutableScatterMap movingInFromEndBound;
        long[] isProgress;
        boolean it2;
        Object obj3;
        Object obj2;
        MutableScatterMap map2;
        MutableScatterSet $this$fastForEach$iv;
        int i6;
        int first;
        int mainAxisSizeWithSpacings;
        int i11;
        int itemInfo;
        long[] lArr;
        int andReturnOffsetFor;
        int $i$f$forEach;
        Object[] objArr;
        Object[] slot$iv$iv2;
        long slot$iv$iv;
        int shouldAnimateAppearance;
        int hasAnimations;
        MutableScatterMap map;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i10;
        int i7;
        int i;
        int j$iv$iv2;
        int item;
        MutableScatterMap scrollOffset2;
        int i17;
        GraphicsContext j$iv$iv;
        GraphicsContext context2;
        int i2;
        int index$iv2;
        int lane;
        int i12;
        int span;
        int i14;
        int unbox-impl;
        Object obj;
        Object info;
        CoroutineScope coroutineScope2;
        GraphicsContext context;
        int newIndex2;
        int i5;
        int crossAxisOffset2;
        int i4;
        int i8;
        long[] m$iv$iv;
        final Object obj4 = this;
        i16 = consumedScroll;
        final int i54 = layoutWidth;
        final int i55 = layoutHeight;
        final List list5 = positionedItems;
        final androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap map4 = keyIndexMap;
        $this$any$iv = laneCount;
        final androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap keyIndexMap2 = obj4.keyIndexMap;
        obj4.keyIndexMap = map4;
        i19 = 0;
        List list4 = list2;
        int i37 = 0;
        index$iv$iv = 0;
        i21 = 0;
        while (index$iv$iv < list4.size()) {
            i6 = 0;
            i11 = 0;
            index$iv$iv++;
            i21 = 0;
        }
        $this$fastAny$iv = i21;
        value$iv$iv$iv = $this$fastAny$iv;
        if (value$iv$iv$iv == 0 && obj4.keyToItemInfoMap.isEmpty()) {
            if (obj4.keyToItemInfoMap.isEmpty()) {
                obj4.reset();
            }
        }
        Object firstOrNull = CollectionsKt.firstOrNull(list5);
        if ((LazyLayoutMeasuredItem)firstOrNull != null) {
            index3 = (LazyLayoutMeasuredItem)firstOrNull.getIndex();
        } else {
            index3 = i21;
        }
        obj4.firstVisibleIndex = index3;
        if (isVertical) {
            scrollOffset = IntOffsetKt.IntOffset(i21, i16);
        } else {
            scrollOffset = IntOffsetKt.IntOffset(i16, i21);
        }
        if (!isLookingAhead) {
            if (!hasLookaheadOccurred) {
                i9 = 1;
            } else {
                i9 = i21;
            }
        } else {
        }
        int i66 = i9;
        MutableScatterMap keyToItemInfoMap2 = obj4.keyToItemInfoMap;
        first = 0;
        movingInFromEndBound = map2;
        long[] this_$iv2 = movingInFromEndBound.metadata;
        itemInfo = i38;
        $i$f$forEachKey -= m$iv$iv2;
        final int i68 = 128;
        final int i69 = 255;
        final int i70 = 7;
        final long l2 = -9187201950435737472L;
        if (0 <= i39) {
        } else {
            hasAnimations = value$iv$iv$iv;
            map = movingInFromEndBound;
            j$iv$iv4 = 8;
        }
        $this$forEach$iv2 = 0;
        x-impl = 0;
        size4 = positionedItems.size();
        while (x-impl < size4) {
            length = map2;
            itemInfo = 0;
            obj4.movingAwayKeys.remove((LazyLayoutMeasuredItem)length.getKey());
            if (obj4.getHasAnimations(length)) {
            } else {
            }
            item = scrollOffset;
            map = $this$forEach$iv2;
            i10 = x-impl;
            lane = size4;
            i19 = 2;
            obj4.removeInfoForKey(length.getKey());
            x-impl = i10 + 1;
            list = objArr;
            $this$forEach$iv2 = map;
            scrollOffset = item;
            size4 = lane;
            j$iv$iv4 = 8;
            if (keyIndexMap2 != null) {
            } else {
            }
            movingInFromEndBound = -1;
            slot$iv$iv = obj8;
            if (movingInFromEndBound == -1 && keyIndexMap2 != null) {
            } else {
            }
            i3 = 0;
            if (slot$iv$iv == null) {
            } else {
            }
            map = $this$forEach$iv2;
            i10 = x-impl;
            scrollOffset2 = length;
            if (i66 != 0) {
            } else {
            }
            lane = size4;
            span = movingInFromEndBound;
            j$iv$iv2 = slot$iv$iv;
            map3 = scrollOffset2;
            item = scrollOffset;
            i19 = 2;
            j$iv$iv2 = slot$iv$iv;
            LazyLayoutItemAnimator.ItemInfo.updateAnimation$default(j$iv$iv2, scrollOffset2, coroutineScope, graphicsContext, layoutMinOffset, layoutMaxOffset, 0, 32, 0);
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] animations2 = j$iv$iv2.getAnimations();
            x-impl = 0;
            $this$forEach$iv = 0;
            while ($this$forEach$iv < animations2.length) {
                scrollOffset2 = slot$iv$iv;
                i17 = null;
                if (scrollOffset2 != null) {
                } else {
                }
                i2 = $this$forEach$iv;
                context2 = x-impl;
                i12 = size4;
                i14 = movingInFromEndBound;
                animation = scrollOffset2;
                $this$forEach$iv = i2 + 1;
                x-impl = context2;
                size4 = i12;
                movingInFromEndBound = i14;
                i2 = $this$forEach$iv;
                context2 = x-impl;
                i12 = size4;
                i14 = movingInFromEndBound;
                if (!IntOffset.equals-impl0(scrollOffset2.getRawOffset-nOcc-ac(), x-impl)) {
                } else {
                }
                animation = scrollOffset2;
                scrollOffset2.setRawOffset--gyyYBs(IntOffset.plus-qkQi6aY(scrollOffset2.getRawOffset-nOcc-ac(), x-impl));
            }
            j$iv$iv = x-impl;
            lane = size4;
            span = movingInFromEndBound;
            if (i3 != 0) {
            } else {
            }
            item = scrollOffset;
            LazyLayoutItemAnimator.startPlacementAnimationsIfNeeded$default(obj4, scrollOffset2, false, 2, 0);
            $this$forEach$iv = j$iv$iv2.getAnimations();
            x-impl = 0;
            size4 = 0;
            while (size4 < $this$forEach$iv.length) {
                lArr = movingInFromEndBound;
                slot$iv$iv = null;
                if (lArr != null) {
                } else {
                }
                scrollOffset2 = scrollOffset;
                i19 = lArr;
                size4++;
                scrollOffset = scrollOffset2;
                if (lArr.isDisappearanceAnimationInProgress()) {
                } else {
                }
                scrollOffset2 = scrollOffset;
                i19 = lArr;
                i19.animateAppearance();
                scrollOffset2 = scrollOffset;
                obj4.disappearingItems.remove(lArr);
                scrollOffset = obj4.displayingNode;
                if (scrollOffset != null) {
                }
                DrawModifierNodeKt.invalidateDraw(scrollOffset);
                scrollOffset = Unit.INSTANCE;
            }
            item = scrollOffset;
            lArr = movingInFromEndBound;
            slot$iv$iv = null;
            if (lArr != null) {
            } else {
            }
            scrollOffset2 = scrollOffset;
            i19 = lArr;
            size4++;
            scrollOffset = scrollOffset2;
            if (lArr.isDisappearanceAnimationInProgress()) {
            } else {
            }
            scrollOffset2 = scrollOffset;
            i19 = lArr;
            i19.animateAppearance();
            scrollOffset2 = scrollOffset;
            obj4.disappearingItems.remove(lArr);
            scrollOffset = obj4.displayingNode;
            if (scrollOffset != null) {
            }
            DrawModifierNodeKt.invalidateDraw(scrollOffset);
            scrollOffset = Unit.INSTANCE;
            scrollOffset2 = slot$iv$iv;
            i17 = null;
            if (scrollOffset2 != null) {
            } else {
            }
            i2 = $this$forEach$iv;
            context2 = x-impl;
            i12 = size4;
            i14 = movingInFromEndBound;
            animation = scrollOffset2;
            $this$forEach$iv = i2 + 1;
            x-impl = context2;
            size4 = i12;
            movingInFromEndBound = i14;
            i2 = $this$forEach$iv;
            context2 = x-impl;
            i12 = size4;
            i14 = movingInFromEndBound;
            if (!IntOffset.equals-impl0(scrollOffset2.getRawOffset-nOcc-ac(), x-impl)) {
            } else {
            }
            animation = scrollOffset2;
            scrollOffset2.setRawOffset--gyyYBs(IntOffset.plus-qkQi6aY(scrollOffset2.getRawOffset-nOcc-ac(), x-impl));
            LazyLayoutItemAnimator.ItemInfo shouldAnimateAppearance2 = new LazyLayoutItemAnimator.ItemInfo(obj4);
            j$iv$iv2 = shouldAnimateAppearance2;
            MutableScatterMap map5 = length;
            LazyLayoutItemAnimator.ItemInfo.updateAnimation$default(j$iv$iv2, map5, coroutineScope, graphicsContext, layoutMinOffset, layoutMaxOffset, 0, 32, 0);
            length = j$iv$iv2;
            map3 = map5;
            map = $this$forEach$iv2;
            i10 = x-impl;
            obj4.keyToItemInfoMap.set(map3.getKey(), length);
            if (map3.getIndex() != movingInFromEndBound && movingInFromEndBound != -1) {
            } else {
            }
            j$iv$iv2 = map3.getOffset-Bjo55l4(0);
            $this$forEach$iv2 = 0;
            if (map3.isVertical()) {
            } else {
            }
            x-impl = IntOffset.getX-impl(j$iv$iv2);
            obj4.initializeAnimation(map3, x-impl, length);
            if (i3 != 0) {
            } else {
            }
            MutableScatterMap item4 = map3;
            lane = size4;
            item = scrollOffset;
            i19 = 2;
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] animations = length.getAnimations();
            x-impl = 0;
            $this$forEach$iv2 = 0;
            while ($this$forEach$iv2 < animations.length) {
                j$iv$iv2 = lArr;
                i17 = null;
                if (j$iv$iv2 != 0) {
                }
                $this$forEach$iv2++;
                j$iv$iv2.animateAppearance();
                j$iv$iv = Unit.INSTANCE;
            }
            lane = size4;
            map3 = map6;
            item = scrollOffset;
            i19 = 2;
            j$iv$iv2 = lArr;
            i17 = null;
            if (j$iv$iv2 != 0) {
            }
            $this$forEach$iv2++;
            j$iv$iv2.animateAppearance();
            j$iv$iv = Unit.INSTANCE;
            x-impl = IntOffset.getY-impl(j$iv$iv2);
            if (movingInFromEndBound != -1) {
            } else {
            }
            if (movingInFromEndBound < obj4.firstVisibleIndex) {
            } else {
            }
            obj4.movingInFromEndBound.add(map3);
            item = scrollOffset;
            lane = size4;
            i19 = 2;
            obj4.movingInFromStartBound.add(map3);
            item = scrollOffset;
            lane = size4;
            i19 = 2;
            if (keyIndexMap2 != null) {
            } else {
            }
            i3 = 1;
            movingInFromEndBound = keyIndexMap2.getIndex(length.getKey());
        }
        long scrollOffset4 = scrollOffset;
        slot$iv$iv2 = list;
        $this$maskEmptyOrDeleted$iv$iv$iv2 = $this$forEach$iv2;
        i7 = x-impl;
        size5 = 2;
        iArr = new int[$this$any$iv];
        size3 = 0;
        while (size3 < $this$any$iv) {
            iArr[size3] = 0;
            size3++;
        }
        iArr2 = iArr;
        if (i66 != 0 && keyIndexMap2 != null) {
            if (keyIndexMap2 != null) {
                if (!(Collection)obj4.movingInFromStartBound.isEmpty()) {
                    List movingInFromStartBound3 = obj4.movingInFromStartBound;
                    int i33 = 0;
                    if (movingInFromStartBound3.size() > 1) {
                        $this$forEach$iv2 = new LazyLayoutItemAnimator.onMeasured$$inlined.sortByDescending.1(keyIndexMap2);
                        CollectionsKt.sortWith(movingInFromStartBound3, (Comparator)$this$forEach$iv2);
                    }
                    List movingInFromStartBound4 = obj4.movingInFromStartBound;
                    movingInFromEndBound = 0;
                    empty = 0;
                    size3 = movingInFromStartBound4.size();
                    while (empty < size3) {
                        MutableScatterMap index$iv3 = map2;
                        itemInfo = 0;
                        long accumulatedOffsetPerLane3 = slot$iv$iv;
                        LazyLayoutItemAnimator.initializeAnimation$default(obj4, index$iv3, layoutMinOffset - andReturnOffsetFor, 0, 4, 0);
                        LazyLayoutItemAnimator.startPlacementAnimationsIfNeeded$default(obj4, index$iv3, false, accumulatedOffsetPerLane3, 0);
                        empty = slot$iv$iv2 + 1;
                        size5 = accumulatedOffsetPerLane3;
                        size3 = shouldAnimateAppearance;
                        iArr2 = j$iv$iv;
                    }
                    slot$iv$iv2 = empty;
                    j$iv$iv = iArr2;
                    accumulatedOffsetPerLane2 = size5;
                    ArraysKt.fill$default(j$iv$iv, 0, 0, 0, 6, 0);
                    accumulatedOffsetPerLane = j$iv$iv;
                } else {
                    accumulatedOffsetPerLane = iArr2;
                    accumulatedOffsetPerLane2 = size5;
                }
                List movingInFromEndBound4 = obj4.movingInFromEndBound;
                int i30 = 0;
                if (!(Collection)obj4.movingInFromEndBound.isEmpty() && movingInFromEndBound4.size() > 1) {
                    movingInFromEndBound4 = obj4.movingInFromEndBound;
                    i30 = 0;
                    if (movingInFromEndBound4.size() > 1) {
                        size3 = new LazyLayoutItemAnimator.onMeasured$$inlined.sortBy.1(keyIndexMap2);
                        CollectionsKt.sortWith(movingInFromEndBound4, (Comparator)size3);
                    }
                    movingInFromEndBound = obj4.movingInFromEndBound;
                    map2 = 0;
                    iArr = 0;
                    size5 = movingInFromEndBound.size();
                    while (iArr < size5) {
                        int index$iv4 = itemInfo;
                        andReturnOffsetFor = 0;
                        LazyLayoutItemAnimator.initializeAnimation$default(obj4, index$iv4, i46 -= mainAxisSizeWithSpacings2, 0, 4, 0);
                        LazyLayoutItemAnimator.startPlacementAnimationsIfNeeded$default(obj4, index$iv4, false, accumulatedOffsetPerLane2, 0);
                        iArr = shouldAnimateAppearance + 1;
                        size5 = slot$iv$iv;
                    }
                    shouldAnimateAppearance = iArr;
                    ArraysKt.fill$default(accumulatedOffsetPerLane, 0, 0, 0, 6, 0);
                }
            } else {
                accumulatedOffsetPerLane = iArr2;
                accumulatedOffsetPerLane2 = size5;
            }
        } else {
        }
        MutableScatterSet movingAwayKeys = obj4.movingAwayKeys;
        $i$f$isFull = movingAwayKeys;
        isProgress = $i$f$isFull.metadata;
        $i$f$forEach = accumulatedOffsetPerLane2;
        length2 += -2;
        $this$fastForEach$iv = movingAwayKeys;
        if (0 <= i15) {
        } else {
            $i$f$forEach = $this$maskEmptyOrDeleted$iv$iv$iv;
            shouldAnimateAppearance = index$iv;
            $this$maskEmptyOrDeleted$iv$iv$iv2 = $i$f$isFull;
            i7 = i18;
            m$iv$iv = isProgress;
        }
        List movingAwayToStartBound2 = obj4.movingAwayToStartBound;
        int i27 = 0;
        if (!(Collection)obj4.movingAwayToStartBound.isEmpty() && movingAwayToStartBound2.size() > 1) {
            movingAwayToStartBound2 = obj4.movingAwayToStartBound;
            i27 = 0;
            if (movingAwayToStartBound2.size() > 1) {
                size2 = new LazyLayoutItemAnimator.onMeasured$$inlined.sortByDescending.2(map4);
                CollectionsKt.sortWith(movingAwayToStartBound2, (Comparator)size2);
            }
            $this$maskEmptyOrDeleted$iv$iv$iv = 0;
            index$iv = 0;
            while (index$iv < obj4.movingAwayToStartBound.size()) {
                i15 = i18;
                $this$any$iv = 0;
                Object obj5 = obj4.keyToItemInfoMap.get((LazyLayoutMeasuredItem)i15.getKey());
                Intrinsics.checkNotNull(obj5);
                if (isLookingAhead) {
                } else {
                }
                layoutMinOffset2 = (LazyLayoutItemAnimator.ItemInfo)obj5.getLayoutMinOffset();
                i15.position(layoutMinOffset2 -= isProgress, itemInfo.getCrossAxisOffset(), i54, i55);
                if (i66 != 0) {
                }
                index$iv++;
                $this$sortByDescending$iv = $this$fastForEach$iv;
                $this$maskEmptyOrDeleted$iv$iv$iv = first;
                obj4.startPlacementAnimationsIfNeeded(i15, true);
                itemInfo = obj5;
                layoutMinOffset2 = obj4.getMainAxisOffset((LazyLayoutMeasuredItem)CollectionsKt.first(list5));
            }
            $this$fastForEach$iv = $this$sortByDescending$iv;
            first = $this$maskEmptyOrDeleted$iv$iv$iv;
            ArraysKt.fill$default(accumulatedOffsetPerLane, 0, 0, 0, 6, 0);
        }
        List movingAwayToEndBound2 = obj4.movingAwayToEndBound;
        int i28 = 0;
        if (!(Collection)obj4.movingAwayToEndBound.isEmpty() && movingAwayToEndBound2.size() > 1) {
            movingAwayToEndBound2 = obj4.movingAwayToEndBound;
            i28 = 0;
            if (movingAwayToEndBound2.size() > 1) {
                size = new LazyLayoutItemAnimator.onMeasured$$inlined.sortBy.2(map4);
                CollectionsKt.sortWith(movingAwayToEndBound2, (Comparator)size);
            }
            $this$maskEmptyOrDeleted$iv$iv$iv = 0;
            index$iv = 0;
            while (index$iv < obj4.movingAwayToEndBound.size()) {
                i15 = i18;
                $this$any$iv = 0;
                Object obj6 = obj4.keyToItemInfoMap.get((LazyLayoutMeasuredItem)i15.getKey());
                Intrinsics.checkNotNull(obj6);
                if (isLookingAhead) {
                } else {
                }
                layoutMaxOffset2 -= mainAxisSizeWithSpacings;
                i15.position(it += isProgress, itemInfo.getCrossAxisOffset(), i54, i55);
                if (i66 != 0) {
                } else {
                }
                i20 = 1;
                index$iv++;
                $this$sortBy$iv = $this$fastForEach$iv;
                $this$maskEmptyOrDeleted$iv$iv$iv = first;
                obj4.startPlacementAnimationsIfNeeded(i15, true);
                itemInfo = obj6;
                mainAxisSizeWithSpacings = 0;
                it = obj4.getMainAxisOffset((LazyLayoutMeasuredItem)CollectionsKt.last(list5));
            }
            $this$fastForEach$iv = $this$sortBy$iv;
            first = $this$maskEmptyOrDeleted$iv$iv$iv;
        }
        List movingAwayToStartBound3 = obj4.movingAwayToStartBound;
        int i32 = 0;
        CollectionsKt.reverse(movingAwayToStartBound3);
        Unit $this$onMeasured_u24lambda_u2419 = Unit.INSTANCE;
        list5.addAll(0, (Collection)movingAwayToStartBound3);
        list5.addAll((Collection)obj4.movingAwayToEndBound);
        obj4.movingInFromStartBound.clear();
        obj4.movingInFromEndBound.clear();
        obj4.movingAwayToStartBound.clear();
        obj4.movingAwayToEndBound.clear();
        obj4.movingAwayKeys.clear();
    }

    public final void reset() {
        boolean keyToItemInfoMap;
        MutableScatterMap this_$iv2;
        int $i$f$forEachValue;
        Object[] values;
        MutableScatterMap map;
        int i3;
        long[] metadata;
        int i6;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int animations;
        int j$iv$iv;
        int i9;
        int i;
        long l;
        Object obj;
        int i5;
        int i4;
        int i8;
        int i10;
        MutableScatterMap this_$iv;
        int i2;
        int i11;
        int i7;
        final Object obj2 = this;
        if (obj2.keyToItemInfoMap.isNotEmpty()) {
            this_$iv2 = obj2.keyToItemInfoMap;
            i3 = 0;
            metadata = map.metadata;
            length += -2;
            if (0 <= i6) {
            } else {
                this_$iv = this_$iv2;
                i2 = $i$f$forEachValue;
            }
            obj2.keyToItemInfoMap.clear();
        }
        obj2.keyIndexMap = (LazyLayoutKeyIndexMap)LazyLayoutKeyIndexMap.Empty;
        obj2.firstVisibleIndex = -1;
    }
}
