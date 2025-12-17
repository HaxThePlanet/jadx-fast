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
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#J\u001c\u0010$\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010%\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J \u0010&\u001a\u00020\u0011*\u00020\u00122\u0008\u0008\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)J \u0010*\u001a\u00020\u0011*\u00020\u00122\u0008\u0008\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\u0008+\u0010)J \u0010,\u001a\u00020\u0011*\u00020\u00122\u0008\u0008\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\u0008-\u0010)J \u0010.\u001a\u00020\u0011*\u00020\u00122\u0008\u0008\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\u0008/\u0010)R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00060", d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {

    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;
    public AspectRatioNode(float aspectRatio, boolean matchHeightConstraintsFirst) {
        super();
        this.aspectRatio = aspectRatio;
        this.matchHeightConstraintsFirst = matchHeightConstraintsFirst;
    }

    private final long findSize-ToXhtMw(long $this$findSize_u2dToXhtMw) {
        int i;
        boolean equals-impl0;
        Object obj;
        androidx.compose.foundation.layout.AspectRatioNode aspectRatioNode;
        long zero-YbymL2g;
        int i2;
        int i3;
        long obj9;
        int i18 = 0;
        if (!this.matchHeightConstraintsFirst) {
            int i30 = 1;
            aspectRatioNode = $this$findSize_u2dToXhtMw;
            obj9 = AspectRatioNode.tryMaxWidth-JN-0ABg$default(this, aspectRatioNode, obj4, 0, i30);
            int i11 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            int i31 = 1;
            obj9 = AspectRatioNode.tryMaxHeight-JN-0ABg$default(this, aspectRatioNode, obj4, 0, i31);
            int i12 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            int i32 = 1;
            obj9 = AspectRatioNode.tryMinWidth-JN-0ABg$default(this, aspectRatioNode, obj4, 0, i32);
            int i13 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            i2 = 1;
            obj9 = AspectRatioNode.tryMinHeight-JN-0ABg$default(this, aspectRatioNode, obj4, 0, i2);
            int i14 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            obj9 = tryMaxWidth-JN-0ABg(aspectRatioNode, obj4);
            int i15 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            obj9 = tryMaxHeight-JN-0ABg(aspectRatioNode, obj4);
            int i16 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            obj9 = tryMinWidth-JN-0ABg(aspectRatioNode, obj4);
            int i17 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            obj9 = tryMinHeight-JN-0ABg(aspectRatioNode, obj4);
            i = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
        } else {
            aspectRatioNode = $this$findSize_u2dToXhtMw;
            int i27 = 1;
            obj9 = AspectRatioNode.tryMaxHeight-JN-0ABg$default(this, aspectRatioNode, obj4, 0, i27);
            int i4 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            int i28 = 1;
            obj9 = AspectRatioNode.tryMaxWidth-JN-0ABg$default(this, aspectRatioNode, obj4, 0, i28);
            int i5 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            int i29 = 1;
            obj9 = AspectRatioNode.tryMinHeight-JN-0ABg$default(this, aspectRatioNode, obj4, 0, i29);
            int i6 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            i2 = 1;
            obj9 = AspectRatioNode.tryMinWidth-JN-0ABg$default(this, aspectRatioNode, obj4, 0, i2);
            int i7 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            obj9 = tryMaxHeight-JN-0ABg(aspectRatioNode, obj4);
            int i8 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            obj9 = tryMaxWidth-JN-0ABg(aspectRatioNode, obj4);
            int i9 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            obj9 = tryMinHeight-JN-0ABg(aspectRatioNode, obj4);
            int i10 = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
            obj9 = tryMinWidth-JN-0ABg(aspectRatioNode, obj4);
            i = 0;
            if (!IntSize.equals-impl0(obj9, obj10)) {
                return obj9;
            }
        }
        return IntSize.Companion.getZero-YbymL2g();
    }

    private final long tryMaxHeight-JN-0ABg(long $this$tryMaxHeight_u2dJN_u2d0ABg, boolean enforceConstraints) {
        int $this$fastRoundToInt$iv;
        int i;
        boolean satisfiedBy-4WqzIAM;
        final int maxHeight-impl = Constraints.getMaxHeight-impl($this$tryMaxHeight_u2dJN_u2d0ABg);
        i = 0;
        $this$fastRoundToInt$iv = Math.round(f *= aspectRatio);
        i = IntSizeKt.IntSize($this$fastRoundToInt$iv, maxHeight-impl);
        if (maxHeight-impl != Integer.MAX_VALUE && $this$fastRoundToInt$iv > 0 && obj8 != null && ConstraintsKt.isSatisfiedBy-4WqzIAM($this$tryMaxHeight_u2dJN_u2d0ABg, enforceConstraints)) {
            i = 0;
            $this$fastRoundToInt$iv = Math.round(f *= aspectRatio);
            if ($this$fastRoundToInt$iv > 0) {
                i = IntSizeKt.IntSize($this$fastRoundToInt$iv, maxHeight-impl);
                if (obj8 != null) {
                    if (ConstraintsKt.isSatisfiedBy-4WqzIAM($this$tryMaxHeight_u2dJN_u2d0ABg, enforceConstraints)) {
                    }
                }
                return i;
            }
        }
        return IntSize.Companion.getZero-YbymL2g();
    }

    static long tryMaxHeight-JN-0ABg$default(androidx.compose.foundation.layout.AspectRatioNode aspectRatioNode, long l2, boolean z3, int i4, Object object5) {
        int obj3;
        final int obj5 = 1;
        if (object5 &= obj5 != 0) {
            obj3 = obj5;
        }
        return aspectRatioNode.tryMaxHeight-JN-0ABg(l2, z3);
    }

    private final long tryMaxWidth-JN-0ABg(long $this$tryMaxWidth_u2dJN_u2d0ABg, boolean enforceConstraints) {
        int $this$fastRoundToInt$iv;
        int i;
        boolean satisfiedBy-4WqzIAM;
        final int maxWidth-impl = Constraints.getMaxWidth-impl($this$tryMaxWidth_u2dJN_u2d0ABg);
        i = 0;
        $this$fastRoundToInt$iv = Math.round(f /= aspectRatio);
        i = IntSizeKt.IntSize(maxWidth-impl, $this$fastRoundToInt$iv);
        if (maxWidth-impl != Integer.MAX_VALUE && $this$fastRoundToInt$iv > 0 && obj8 != null && ConstraintsKt.isSatisfiedBy-4WqzIAM($this$tryMaxWidth_u2dJN_u2d0ABg, enforceConstraints)) {
            i = 0;
            $this$fastRoundToInt$iv = Math.round(f /= aspectRatio);
            if ($this$fastRoundToInt$iv > 0) {
                i = IntSizeKt.IntSize(maxWidth-impl, $this$fastRoundToInt$iv);
                if (obj8 != null) {
                    if (ConstraintsKt.isSatisfiedBy-4WqzIAM($this$tryMaxWidth_u2dJN_u2d0ABg, enforceConstraints)) {
                    }
                }
                return i;
            }
        }
        return IntSize.Companion.getZero-YbymL2g();
    }

    static long tryMaxWidth-JN-0ABg$default(androidx.compose.foundation.layout.AspectRatioNode aspectRatioNode, long l2, boolean z3, int i4, Object object5) {
        int obj3;
        final int obj5 = 1;
        if (object5 &= obj5 != 0) {
            obj3 = obj5;
        }
        return aspectRatioNode.tryMaxWidth-JN-0ABg(l2, z3);
    }

    private final long tryMinHeight-JN-0ABg(long $this$tryMinHeight_u2dJN_u2d0ABg, boolean enforceConstraints) {
        int i;
        boolean satisfiedBy-4WqzIAM;
        final int minHeight-impl = Constraints.getMinHeight-impl($this$tryMinHeight_u2dJN_u2d0ABg);
        i = 0;
        int $this$fastRoundToInt$iv = Math.round(f *= aspectRatio);
        i = IntSizeKt.IntSize($this$fastRoundToInt$iv, minHeight-impl);
        if ($this$fastRoundToInt$iv > 0 && obj8 != null && ConstraintsKt.isSatisfiedBy-4WqzIAM($this$tryMinHeight_u2dJN_u2d0ABg, enforceConstraints)) {
            i = IntSizeKt.IntSize($this$fastRoundToInt$iv, minHeight-impl);
            if (obj8 != null) {
                if (ConstraintsKt.isSatisfiedBy-4WqzIAM($this$tryMinHeight_u2dJN_u2d0ABg, enforceConstraints)) {
                }
            }
            return i;
        }
        return IntSize.Companion.getZero-YbymL2g();
    }

    static long tryMinHeight-JN-0ABg$default(androidx.compose.foundation.layout.AspectRatioNode aspectRatioNode, long l2, boolean z3, int i4, Object object5) {
        int obj3;
        final int obj5 = 1;
        if (object5 &= obj5 != 0) {
            obj3 = obj5;
        }
        return aspectRatioNode.tryMinHeight-JN-0ABg(l2, z3);
    }

    private final long tryMinWidth-JN-0ABg(long $this$tryMinWidth_u2dJN_u2d0ABg, boolean enforceConstraints) {
        int i;
        boolean satisfiedBy-4WqzIAM;
        final int minWidth-impl = Constraints.getMinWidth-impl($this$tryMinWidth_u2dJN_u2d0ABg);
        i = 0;
        int $this$fastRoundToInt$iv = Math.round(f /= aspectRatio);
        i = IntSizeKt.IntSize(minWidth-impl, $this$fastRoundToInt$iv);
        if ($this$fastRoundToInt$iv > 0 && obj8 != null && ConstraintsKt.isSatisfiedBy-4WqzIAM($this$tryMinWidth_u2dJN_u2d0ABg, enforceConstraints)) {
            i = IntSizeKt.IntSize(minWidth-impl, $this$fastRoundToInt$iv);
            if (obj8 != null) {
                if (ConstraintsKt.isSatisfiedBy-4WqzIAM($this$tryMinWidth_u2dJN_u2d0ABg, enforceConstraints)) {
                }
            }
            return i;
        }
        return IntSize.Companion.getZero-YbymL2g();
    }

    static long tryMinWidth-JN-0ABg$default(androidx.compose.foundation.layout.AspectRatioNode aspectRatioNode, long l2, boolean z3, int i4, Object object5) {
        int obj3;
        final int obj5 = 1;
        if (object5 &= obj5 != 0) {
            obj3 = obj5;
        }
        return aspectRatioNode.tryMinWidth-JN-0ABg(l2, z3);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        int $this$fastRoundToInt$iv;
        int i;
        if (width != Integer.MAX_VALUE) {
            i = 0;
            $this$fastRoundToInt$iv = Math.round(f /= aspectRatio);
        } else {
            $this$fastRoundToInt$iv = measurable.maxIntrinsicHeight(width);
        }
        return $this$fastRoundToInt$iv;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        int $this$fastRoundToInt$iv;
        int i;
        if (height != Integer.MAX_VALUE) {
            i = 0;
            $this$fastRoundToInt$iv = Math.round(f *= aspectRatio);
        } else {
            $this$fastRoundToInt$iv = measurable.maxIntrinsicWidth(height);
        }
        return $this$fastRoundToInt$iv;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        long fixed-JhjzzOo;
        int width-impl;
        int height-impl;
        final long l = constraints;
        final long size-ToXhtMw = this.findSize-ToXhtMw(l);
        if (!IntSize.equals-impl0(size-ToXhtMw, obj4)) {
            fixed-JhjzzOo = Constraints.Companion.fixed-JhjzzOo(IntSize.getWidth-impl(size-ToXhtMw), IntSize.getHeight-impl(size-ToXhtMw));
        } else {
            fixed-JhjzzOo = l;
        }
        final Placeable measure-BRTryo0 = measurable.measure-BRTryo0(fixed-JhjzzOo);
        AspectRatioNode.measure.1 anon = new AspectRatioNode.measure.1(measure-BRTryo0);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, measure-BRTryo0.getWidth(), measure-BRTryo0.getHeight(), 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        int $this$fastRoundToInt$iv;
        int i;
        if (width != Integer.MAX_VALUE) {
            i = 0;
            $this$fastRoundToInt$iv = Math.round(f /= aspectRatio);
        } else {
            $this$fastRoundToInt$iv = measurable.minIntrinsicHeight(width);
        }
        return $this$fastRoundToInt$iv;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        int $this$fastRoundToInt$iv;
        int i;
        if (height != Integer.MAX_VALUE) {
            i = 0;
            $this$fastRoundToInt$iv = Math.round(f *= aspectRatio);
        } else {
            $this$fastRoundToInt$iv = measurable.minIntrinsicWidth(height);
        }
        return $this$fastRoundToInt$iv;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setAspectRatio(float <set-?>) {
        this.aspectRatio = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setMatchHeightConstraintsFirst(boolean <set-?>) {
        this.matchHeightConstraintsFirst = <set-?>;
    }
}
