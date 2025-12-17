package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J&\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u001f\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000fH\u0016R\"\u0010\u0005\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\"\u0010\u0003\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\u0008\u000c\u0010\u0008\"\u0004\u0008\r\u0010\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006 ", d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinHeight-D9Ej5fM", "()F", "setMinHeight-0680j_4", "(F)V", "F", "getMinWidth-D9Ej5fM", "setMinWidth-0680j_4", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {

    private float minHeight;
    private float minWidth;
    private UnspecifiedConstraintsNode(float minWidth, float minHeight) {
        super();
        this.minWidth = minWidth;
        this.minHeight = minHeight;
    }

    public UnspecifiedConstraintsNode(float f, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        float obj1;
        float obj2;
        if (i3 & 1 != 0) {
            obj1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i3 &= 2 != 0) {
            obj2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        super(obj1, obj2, 0);
    }

    public UnspecifiedConstraintsNode(float f, float f2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(f, f2);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getMinHeight-D9Ej5fM() {
        return this.minHeight;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getMinWidth-D9Ej5fM() {
        return this.minWidth;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        int roundToPx-0680j_4;
        if (!Dp.equals-impl0(this.minHeight, Dp.Companion.getUnspecified-D9Ej5fM())) {
            roundToPx-0680j_4 = $this$maxIntrinsicHeight.roundToPx-0680j_4(this.minHeight);
        } else {
            roundToPx-0680j_4 = 0;
        }
        return RangesKt.coerceAtLeast(measurable.maxIntrinsicHeight(width), roundToPx-0680j_4);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        int roundToPx-0680j_4;
        if (!Dp.equals-impl0(this.minWidth, Dp.Companion.getUnspecified-D9Ej5fM())) {
            roundToPx-0680j_4 = $this$maxIntrinsicWidth.roundToPx-0680j_4(this.minWidth);
        } else {
            roundToPx-0680j_4 = 0;
        }
        return RangesKt.coerceAtLeast(measurable.maxIntrinsicWidth(height), roundToPx-0680j_4);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        boolean minWidth-impl2;
        int minWidth-impl;
        int minHeight-impl;
        int maxWidth-impl;
        boolean minHeight-impl2;
        float unspecified-D9Ej5fM;
        int i = 0;
        if (!Dp.equals-impl0(this.minWidth, Dp.Companion.getUnspecified-D9Ej5fM()) && Constraints.getMinWidth-impl(constraints) == 0) {
            if (Constraints.getMinWidth-impl(constraints) == 0) {
                minWidth-impl = RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$measure_u2d3p2s80s.roundToPx-0680j_4(this.minWidth), Constraints.getMaxWidth-impl(constraints)), i);
            } else {
                minWidth-impl = Constraints.getMinWidth-impl(constraints);
            }
        } else {
        }
        if (!Dp.equals-impl0(this.minHeight, Dp.Companion.getUnspecified-D9Ej5fM()) && Constraints.getMinHeight-impl(constraints) == 0) {
            if (Constraints.getMinHeight-impl(constraints) == 0) {
                minHeight-impl = RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$measure_u2d3p2s80s.roundToPx-0680j_4(this.minHeight), Constraints.getMaxHeight-impl(constraints)), i);
            } else {
                minHeight-impl = Constraints.getMinHeight-impl(constraints);
            }
        } else {
        }
        Placeable measure-BRTryo0 = measurable.measure-BRTryo0(ConstraintsKt.Constraints(minWidth-impl, Constraints.getMaxWidth-impl(constraints), minHeight-impl, Constraints.getMaxHeight-impl(constraints)));
        UnspecifiedConstraintsNode.measure.1 anon = new UnspecifiedConstraintsNode.measure.1(measure-BRTryo0);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, measure-BRTryo0.getWidth(), measure-BRTryo0.getHeight(), 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        int roundToPx-0680j_4;
        if (!Dp.equals-impl0(this.minHeight, Dp.Companion.getUnspecified-D9Ej5fM())) {
            roundToPx-0680j_4 = $this$minIntrinsicHeight.roundToPx-0680j_4(this.minHeight);
        } else {
            roundToPx-0680j_4 = 0;
        }
        return RangesKt.coerceAtLeast(measurable.minIntrinsicHeight(width), roundToPx-0680j_4);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        int roundToPx-0680j_4;
        if (!Dp.equals-impl0(this.minWidth, Dp.Companion.getUnspecified-D9Ej5fM())) {
            roundToPx-0680j_4 = $this$minIntrinsicWidth.roundToPx-0680j_4(this.minWidth);
        } else {
            roundToPx-0680j_4 = 0;
        }
        return RangesKt.coerceAtLeast(measurable.minIntrinsicWidth(height), roundToPx-0680j_4);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setMinHeight-0680j_4(float <set-?>) {
        this.minHeight = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setMinWidth-0680j_4(float <set-?>) {
        this.minWidth = <set-?>;
    }
}
