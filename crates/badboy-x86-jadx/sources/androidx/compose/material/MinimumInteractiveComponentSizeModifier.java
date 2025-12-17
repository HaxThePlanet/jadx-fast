package androidx.compose.material;

import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\u0008\u0010\u000c\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0017", d2 = {"Landroidx/compose/material/MinimumInteractiveComponentSizeModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "size", "Landroidx/compose/ui/unit/DpSize;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSize-MYxV2XQ", "()J", "J", "equals", "", "other", "", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MinimumInteractiveComponentSizeModifier implements LayoutModifier {

    private final long size;
    private MinimumInteractiveComponentSizeModifier(long size) {
        super();
        this.size = size;
    }

    public MinimumInteractiveComponentSizeModifier(long l, DefaultConstructorMarker defaultConstructorMarker2) {
        super(l, defaultConstructorMarker2);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public boolean equals(Object other) {
        Object obj;
        if (other instanceof MinimumInteractiveComponentSizeModifier) {
            obj = other;
        } else {
            obj = 0;
        }
        if (obj == null) {
            return 0;
        }
        return DpSize.equals-impl0(this.size, obj2);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public final long getSize-MYxV2XQ() {
        return this.size;
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int hashCode() {
        return DpSize.hashCode-impl(this.size);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        final Placeable measure-BRTryo0 = measurable.measure-BRTryo0(constraints);
        final int i = Math.max(measure-BRTryo0.getWidth(), $this$measure_u2d3p2s80s.roundToPx-0680j_4(DpSize.getWidth-D9Ej5fM(this.size)));
        final int i2 = Math.max(measure-BRTryo0.getHeight(), $this$measure_u2d3p2s80s.roundToPx-0680j_4(DpSize.getHeight-D9Ej5fM(this.size)));
        MinimumInteractiveComponentSizeModifier.measure.1 anon = new MinimumInteractiveComponentSizeModifier.measure.1(i, measure-BRTryo0, i2);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, i, i2, 0, (Function1)anon, 4, 0);
    }
}
