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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0016J\u001c\u0010%\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020 H\u0016J&\u0010'\u001a\u00020(*\u00020)2\u0006\u0010\"\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-J\u001c\u0010.\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0016J\u001c\u0010/\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020 H\u0016R\u001a\u0010\u0008\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\"\u0010\u0007\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\"\u0010\u0006\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\u0008\u0014\u0010\u0010\"\u0004\u0008\u0015\u0010\u0012R\"\u0010\u0005\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\u0008\u0016\u0010\u0010\"\u0004\u0008\u0017\u0010\u0012R\"\u0010\u0003\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\u0008\u0018\u0010\u0010\"\u0004\u0008\u0019\u0010\u0012R\u001e\u0010\u001a\u001a\u00020\u001b*\u00020\u001c8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00060", d2 = {"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "getMaxHeight-D9Ej5fM", "()F", "setMaxHeight-0680j_4", "(F)V", "F", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMinWidth-D9Ej5fM", "setMinWidth-0680j_4", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SizeNode extends Modifier.Node implements LayoutModifierNode {

    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;
    private SizeNode(float minWidth, float minHeight, float maxWidth, float maxHeight, boolean enforceIncoming) {
        super();
        this.minWidth = minWidth;
        this.minHeight = minHeight;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.enforceIncoming = enforceIncoming;
    }

    public SizeNode(float f, float f2, float f3, float f4, boolean z5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        float f8;
        float f7;
        float f5;
        float f6;
        float obj8;
        float obj9;
        float obj10;
        float obj11;
        if (i6 & 1 != 0) {
            f8 = obj8;
        } else {
            f8 = f;
        }
        if (i6 & 2 != 0) {
            f7 = obj9;
        } else {
            f7 = f2;
        }
        if (i6 & 4 != 0) {
            f5 = obj10;
        } else {
            f5 = f3;
        }
        if (i6 & 8 != 0) {
            f6 = obj11;
        } else {
            f6 = f4;
        }
        super(f8, f7, f5, f6, z5, 0);
    }

    public SizeNode(float f, float f2, float f3, float f4, boolean z5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(f, f2, f3, f4, z5);
    }

    private final long getTargetConstraints-OenEA2s(Density $this$targetConstraints) {
        int coerceAtLeast3;
        int i;
        int coerceAtLeast2;
        int it;
        float unspecified-D9Ej5fM2;
        int coerceAtLeast;
        int unspecified-D9Ej5fM;
        int i2 = Integer.MAX_VALUE;
        i = 0;
        if (!Dp.equals-impl0(this.maxWidth, Dp.Companion.getUnspecified-D9Ej5fM())) {
            coerceAtLeast3 = RangesKt.coerceAtLeast($this$targetConstraints.roundToPx-0680j_4(this.maxWidth), i);
        } else {
            coerceAtLeast3 = i2;
        }
        if (!Dp.equals-impl0(this.maxHeight, Dp.Companion.getUnspecified-D9Ej5fM())) {
            coerceAtLeast2 = RangesKt.coerceAtLeast($this$targetConstraints.roundToPx-0680j_4(this.maxHeight), i);
        } else {
            coerceAtLeast2 = i2;
        }
        if (!Dp.equals-impl0(this.minWidth, Dp.Companion.getUnspecified-D9Ej5fM())) {
            unspecified-D9Ej5fM2 = 0;
            if (RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$targetConstraints.roundToPx-0680j_4(this.minWidth), coerceAtLeast3), i) != i2) {
            } else {
                it = i;
            }
        } else {
            it = i;
        }
        if (!Dp.equals-impl0(this.minHeight, Dp.Companion.getUnspecified-D9Ej5fM())) {
            coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$targetConstraints.roundToPx-0680j_4(this.minHeight), coerceAtLeast2), i);
            unspecified-D9Ej5fM = 0;
            if (coerceAtLeast != i2) {
                i = coerceAtLeast;
            }
        } else {
        }
        return ConstraintsKt.Constraints(it, coerceAtLeast3, i, coerceAtLeast2);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getMaxHeight-D9Ej5fM() {
        return this.maxHeight;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getMaxWidth-D9Ej5fM() {
        return this.maxWidth;
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
        int constrainHeight-K40F9xA;
        long targetConstraints-OenEA2s = getTargetConstraints-OenEA2s((Density)$this$maxIntrinsicHeight);
        if (Constraints.getHasFixedHeight-impl(targetConstraints-OenEA2s)) {
            constrainHeight-K40F9xA = Constraints.getMaxHeight-impl(targetConstraints-OenEA2s);
        } else {
            constrainHeight-K40F9xA = ConstraintsKt.constrainHeight-K40F9xA(targetConstraints-OenEA2s, obj1);
        }
        return constrainHeight-K40F9xA;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        int constrainWidth-K40F9xA;
        long targetConstraints-OenEA2s = getTargetConstraints-OenEA2s((Density)$this$maxIntrinsicWidth);
        if (Constraints.getHasFixedWidth-impl(targetConstraints-OenEA2s)) {
            constrainWidth-K40F9xA = Constraints.getMaxWidth-impl(targetConstraints-OenEA2s);
        } else {
            constrainWidth-K40F9xA = ConstraintsKt.constrainWidth-K40F9xA(targetConstraints-OenEA2s, obj1);
        }
        return constrainWidth-K40F9xA;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        Object obj2;
        long resolvedMinWidth;
        int minWidth-impl;
        int maxWidth-impl;
        float unspecified-D9Ej5fM;
        int minHeight-impl;
        float unspecified-D9Ej5fM2;
        int maxHeight-impl;
        float unspecified-D9Ej5fM3;
        long l;
        float unspecified-D9Ej5fM4;
        long targetConstraints-OenEA2s = getTargetConstraints-OenEA2s((Density)$this$measure_u2d3p2s80s);
        int i = 0;
        if (this.enforceIncoming) {
            resolvedMinWidth = ConstraintsKt.constrain-N9IONVI(constraints, obj4);
        } else {
            obj2 = constraints;
            if (!Dp.equals-impl0(this.minWidth, Dp.Companion.getUnspecified-D9Ej5fM())) {
                minWidth-impl = Constraints.getMinWidth-impl(targetConstraints-OenEA2s);
            } else {
                minWidth-impl = RangesKt.coerceAtMost(Constraints.getMinWidth-impl(obj2), Constraints.getMaxWidth-impl(targetConstraints-OenEA2s));
            }
            if (!Dp.equals-impl0(this.maxWidth, Dp.Companion.getUnspecified-D9Ej5fM())) {
                maxWidth-impl = Constraints.getMaxWidth-impl(targetConstraints-OenEA2s);
            } else {
                maxWidth-impl = RangesKt.coerceAtLeast(Constraints.getMaxWidth-impl(obj2), Constraints.getMinWidth-impl(targetConstraints-OenEA2s));
            }
            if (!Dp.equals-impl0(this.minHeight, Dp.Companion.getUnspecified-D9Ej5fM())) {
                minHeight-impl = Constraints.getMinHeight-impl(targetConstraints-OenEA2s);
            } else {
                minHeight-impl = RangesKt.coerceAtMost(Constraints.getMinHeight-impl(obj2), Constraints.getMaxHeight-impl(targetConstraints-OenEA2s));
            }
            if (!Dp.equals-impl0(this.maxHeight, Dp.Companion.getUnspecified-D9Ej5fM())) {
                maxHeight-impl = Constraints.getMaxHeight-impl(targetConstraints-OenEA2s);
            } else {
                maxHeight-impl = RangesKt.coerceAtLeast(Constraints.getMaxHeight-impl(obj2), Constraints.getMinHeight-impl(targetConstraints-OenEA2s));
            }
            resolvedMinWidth = l;
        }
        final Placeable measure-BRTryo0 = measurable.measure-BRTryo0(resolvedMinWidth);
        SizeNode.measure.1 anon = new SizeNode.measure.1(measure-BRTryo0);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, measure-BRTryo0.getWidth(), measure-BRTryo0.getHeight(), 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        int constrainHeight-K40F9xA;
        long targetConstraints-OenEA2s = getTargetConstraints-OenEA2s((Density)$this$minIntrinsicHeight);
        if (Constraints.getHasFixedHeight-impl(targetConstraints-OenEA2s)) {
            constrainHeight-K40F9xA = Constraints.getMaxHeight-impl(targetConstraints-OenEA2s);
        } else {
            constrainHeight-K40F9xA = ConstraintsKt.constrainHeight-K40F9xA(targetConstraints-OenEA2s, obj1);
        }
        return constrainHeight-K40F9xA;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        int constrainWidth-K40F9xA;
        long targetConstraints-OenEA2s = getTargetConstraints-OenEA2s((Density)$this$minIntrinsicWidth);
        if (Constraints.getHasFixedWidth-impl(targetConstraints-OenEA2s)) {
            constrainWidth-K40F9xA = Constraints.getMaxWidth-impl(targetConstraints-OenEA2s);
        } else {
            constrainWidth-K40F9xA = ConstraintsKt.constrainWidth-K40F9xA(targetConstraints-OenEA2s, obj1);
        }
        return constrainWidth-K40F9xA;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setEnforceIncoming(boolean <set-?>) {
        this.enforceIncoming = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setMaxHeight-0680j_4(float <set-?>) {
        this.maxHeight = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setMaxWidth-0680j_4(float <set-?>) {
        this.maxWidth = <set-?>;
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
