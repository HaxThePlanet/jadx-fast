package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\u001c\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J&\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 J\u001c\u0010!\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\"\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0012H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\t\"\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\t\"\u0004\u0008\u000c\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006#", d2 = {"Landroidx/compose/foundation/ScrollingLayoutNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scrollerState", "Landroidx/compose/foundation/ScrollState;", "isReversed", "", "isVertical", "(Landroidx/compose/foundation/ScrollState;ZZ)V", "()Z", "setReversed", "(Z)V", "setVertical", "getScrollerState", "()Landroidx/compose/foundation/ScrollState;", "setScrollerState", "(Landroidx/compose/foundation/ScrollState;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScrollingLayoutNode extends Modifier.Node implements LayoutModifierNode {

    public static final int $stable = 8;
    private boolean isReversed;
    private boolean isVertical;
    private androidx.compose.foundation.ScrollState scrollerState;
    static {
        final int i = 8;
    }

    public ScrollingLayoutNode(androidx.compose.foundation.ScrollState scrollerState, boolean isReversed, boolean isVertical) {
        super();
        this.scrollerState = scrollerState;
        this.isReversed = isReversed;
        this.isVertical = isVertical;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.foundation.ScrollState getScrollerState() {
        return this.scrollerState;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean isReversed() {
        return this.isReversed;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean isVertical() {
        return this.isVertical;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        int maxIntrinsicHeight;
        if (this.isVertical) {
            maxIntrinsicHeight = measurable.maxIntrinsicHeight(width);
        } else {
            maxIntrinsicHeight = measurable.maxIntrinsicHeight(Integer.MAX_VALUE);
        }
        return maxIntrinsicHeight;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        int maxIntrinsicWidth;
        if (this.isVertical) {
            maxIntrinsicWidth = measurable.maxIntrinsicWidth(Integer.MAX_VALUE);
        } else {
            maxIntrinsicWidth = measurable.maxIntrinsicWidth(height);
        }
        return maxIntrinsicWidth;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Orientation horizontal;
        boolean maxHeight-impl;
        int maxWidth-impl;
        int i;
        int i2;
        int i3;
        horizontal = this.isVertical ? Orientation.Vertical : Orientation.Horizontal;
        Object obj2 = constraints;
        CheckScrollableContainerConstraintsKt.checkScrollableContainerConstraints-K40F9xA(obj2, obj2);
        if (this.isVertical) {
            i = maxWidth-impl;
        } else {
            i = maxHeight-impl;
        }
        if (this.isVertical) {
            maxWidth-impl = Constraints.getMaxWidth-impl(obj2);
        }
        final int i6 = maxWidth-impl;
        Placeable measure-BRTryo0 = measurable.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(obj2, obj2, 0, i6, 0, i, 5));
        int coerceAtMost = RangesKt.coerceAtMost(measure-BRTryo0.getWidth(), Constraints.getMaxWidth-impl(constraints));
        int coerceAtMost2 = RangesKt.coerceAtMost(measure-BRTryo0.getHeight(), Constraints.getMaxHeight-impl(constraints));
        i2 = this.isVertical ? i4 : i8;
        final int i14 = i2;
        this.scrollerState.setMaxValue$foundation_release(i14);
        i3 = this.isVertical ? coerceAtMost2 : coerceAtMost;
        this.scrollerState.setViewportSize$foundation_release(i3);
        ScrollingLayoutNode.measure.1 anon = new ScrollingLayoutNode.measure.1(this, i14, measure-BRTryo0);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, coerceAtMost, coerceAtMost2, 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        int minIntrinsicHeight;
        if (this.isVertical) {
            minIntrinsicHeight = measurable.minIntrinsicHeight(width);
        } else {
            minIntrinsicHeight = measurable.minIntrinsicHeight(Integer.MAX_VALUE);
        }
        return minIntrinsicHeight;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        int minIntrinsicWidth;
        if (this.isVertical) {
            minIntrinsicWidth = measurable.minIntrinsicWidth(Integer.MAX_VALUE);
        } else {
            minIntrinsicWidth = measurable.minIntrinsicWidth(height);
        }
        return minIntrinsicWidth;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setReversed(boolean <set-?>) {
        this.isReversed = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setScrollerState(androidx.compose.foundation.ScrollState <set-?>) {
        this.scrollerState = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setVertical(boolean <set-?>) {
        this.isVertical = <set-?>;
    }
}
