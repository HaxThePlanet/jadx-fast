package androidx.compose.ui.layout;

import androidx.compose.ui.node.MeasureScopeWithLayoutNodeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\"\u0010\u0011\u001a\u00020\u000e*\u00020\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\"\u0010\u0017\u001a\u00020\u000e*\u00020\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J,\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 J\"\u0010!\u001a\u00020\u000e*\u00020\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\"\u0010\"\u001a\u00020\u000e*\u00020\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0018\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006#", d2 = {"Landroidx/compose/ui/layout/MultiContentMeasurePolicyImpl;", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "(Landroidx/compose/ui/layout/MultiContentMeasurePolicy;)V", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MultiContentMeasurePolicyImpl implements androidx.compose.ui.layout.MeasurePolicy {

    public static final int $stable;
    private final androidx.compose.ui.layout.MultiContentMeasurePolicy measurePolicy;
    static {
    }

    public MultiContentMeasurePolicyImpl(androidx.compose.ui.layout.MultiContentMeasurePolicy measurePolicy) {
        super();
        this.measurePolicy = measurePolicy;
    }

    public static androidx.compose.ui.layout.MultiContentMeasurePolicyImpl copy$default(androidx.compose.ui.layout.MultiContentMeasurePolicyImpl multiContentMeasurePolicyImpl, androidx.compose.ui.layout.MultiContentMeasurePolicy multiContentMeasurePolicy2, int i3, Object object4) {
        androidx.compose.ui.layout.MultiContentMeasurePolicy obj1;
        if (i3 &= 1 != 0) {
            obj1 = multiContentMeasurePolicyImpl.measurePolicy;
        }
        return multiContentMeasurePolicyImpl.copy(obj1);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final androidx.compose.ui.layout.MultiContentMeasurePolicy component1() {
        return this.measurePolicy;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final androidx.compose.ui.layout.MultiContentMeasurePolicyImpl copy(androidx.compose.ui.layout.MultiContentMeasurePolicy multiContentMeasurePolicy) {
        MultiContentMeasurePolicyImpl multiContentMeasurePolicyImpl = new MultiContentMeasurePolicyImpl(multiContentMeasurePolicy);
        return multiContentMeasurePolicyImpl;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof MultiContentMeasurePolicyImpl) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.measurePolicy, obj.measurePolicy)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final androidx.compose.ui.layout.MultiContentMeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int hashCode() {
        return this.measurePolicy.hashCode();
    }

    public int maxIntrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> measurables, int width) {
        final int i = 0;
        return this.measurePolicy.maxIntrinsicHeight($this$maxIntrinsicHeight, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren($this$maxIntrinsicHeight), width);
    }

    public int maxIntrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> measurables, int height) {
        final int i = 0;
        return this.measurePolicy.maxIntrinsicWidth($this$maxIntrinsicWidth, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren($this$maxIntrinsicWidth), height);
    }

    public androidx.compose.ui.layout.MeasureResult measure-3p2s80s(androidx.compose.ui.layout.MeasureScope $this$measure_u2d3p2s80s, List<? extends androidx.compose.ui.layout.Measurable> measurables, long constraints) {
        final int i = 0;
        return this.measurePolicy.measure-3p2s80s($this$measure_u2d3p2s80s, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren((IntrinsicMeasureScope)$this$measure_u2d3p2s80s), constraints);
    }

    public int minIntrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> measurables, int width) {
        final int i = 0;
        return this.measurePolicy.minIntrinsicHeight($this$minIntrinsicHeight, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren($this$minIntrinsicHeight), width);
    }

    public int minIntrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> measurables, int height) {
        final int i = 0;
        return this.measurePolicy.minIntrinsicWidth($this$minIntrinsicWidth, MeasureScopeWithLayoutNodeKt.getChildrenOfVirtualChildren($this$minIntrinsicWidth), height);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("MultiContentMeasurePolicyImpl(measurePolicy=").append(this.measurePolicy).append(')').toString();
    }
}
