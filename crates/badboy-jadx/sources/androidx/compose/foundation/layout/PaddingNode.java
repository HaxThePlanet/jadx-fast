package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ&\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"R\"\u0010\u0007\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\"\u0010\u0006\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\u0008\u0010\u0010\u000c\"\u0004\u0008\u0011\u0010\u000eR\u001a\u0010\u0008\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\u0008\u0016\u0010\u000c\"\u0004\u0008\u0017\u0010\u000eR\"\u0010\u0005\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\u0008\u0018\u0010\u000c\"\u0004\u0008\u0019\u0010\u000e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006#", d2 = {"Landroidx/compose/foundation/layout/PaddingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM", "()F", "setBottom-0680j_4", "(F)V", "F", "getEnd-D9Ej5fM", "setEnd-0680j_4", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "getStart-D9Ej5fM", "setStart-0680j_4", "getTop-D9Ej5fM", "setTop-0680j_4", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PaddingNode extends Modifier.Node implements LayoutModifierNode {

    private float bottom;
    private float end;
    private boolean rtlAware;
    private float start;
    private float top;
    private PaddingNode(float start, float top, float end, float bottom, boolean rtlAware) {
        super();
        this.start = start;
        this.top = top;
        this.end = end;
        this.bottom = bottom;
        this.rtlAware = rtlAware;
    }

    public PaddingNode(float f, float f2, float f3, float f4, boolean z5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        float f9;
        float f7;
        float f6;
        float f8;
        float f5;
        float obj8;
        float obj9;
        float obj10;
        float obj11;
        int obj14;
        if (i6 & 1 != 0) {
            obj14 = 0;
            f7 = obj8;
        } else {
            f7 = f;
        }
        if (i6 & 2 != 0) {
            obj9 = 0;
            f6 = obj9;
        } else {
            f6 = f2;
        }
        if (i6 & 4 != 0) {
            obj9 = 0;
            f8 = obj10;
        } else {
            f8 = f3;
        }
        if (i6 & 8 != 0) {
            obj9 = 0;
            f5 = obj11;
        } else {
            f5 = f4;
        }
        super(f7, f6, f8, f5, z5, 0);
    }

    public PaddingNode(float f, float f2, float f3, float f4, boolean z5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(f, f2, f3, f4, z5);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getBottom-D9Ej5fM() {
        return this.bottom;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getEnd-D9Ej5fM() {
        return this.end;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getStart-D9Ej5fM() {
        return this.start;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getTop-D9Ej5fM() {
        return this.top;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        roundToPx-0680j_4 += roundToPx-0680j_42;
        roundToPx-0680j_43 += roundToPx-0680j_44;
        int i4 = -i2;
        Placeable measure-BRTryo0 = measurable.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(constraints, obj15, -i));
        PaddingNode.measure.1 anon = new PaddingNode.measure.1(this, measure-BRTryo0, $this$measure_u2d3p2s80s);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, ConstraintsKt.constrainWidth-K40F9xA(constraints, obj15), ConstraintsKt.constrainHeight-K40F9xA(constraints, obj15), 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setBottom-0680j_4(float <set-?>) {
        this.bottom = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setEnd-0680j_4(float <set-?>) {
        this.end = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setRtlAware(boolean <set-?>) {
        this.rtlAware = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setStart-0680j_4(float <set-?>) {
        this.start = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setTop-0680j_4(float <set-?>) {
        this.top = <set-?>;
    }
}
