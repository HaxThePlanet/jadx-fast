package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0007\u0008\u0002\u0018\u00002\u00020\u0001B$\u0012\u001d\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0008\u0007¢\u0006\u0002\u0010\u0008J\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\u0005X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0008\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0013", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlotCache;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "calculation", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "cachedConstraints", "J", "cachedDensity", "", "cachedSizes", "invoke", "density", "constraints", "invoke-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LazyStaggeredGridSlotCache implements androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider {

    private long cachedConstraints;
    private float cachedDensity;
    private androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots cachedSizes;
    private final Function2<Density, Constraints, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots> calculation;
    public LazyStaggeredGridSlotCache(Function2<? super Density, ? super Constraints, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots> calculation) {
        super();
        this.calculation = calculation;
        this.cachedConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, 0);
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider
    public androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots invoke-0kLqBqw(Density density, long constraints) {
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots cachedSizes;
        long density2;
        final Object obj = density;
        final int i = 0;
        if (this.cachedSizes != null && Constraints.equals-impl0(this.cachedConstraints, obj3)) {
            if (Constraints.equals-impl0(this.cachedConstraints, obj3)) {
                cachedSizes = Float.compare(cachedDensity, density2) == 0 ? 1 : 0;
                if (cachedSizes != 0) {
                    androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSlots cachedSizes2 = this.cachedSizes;
                    Intrinsics.checkNotNull(cachedSizes2);
                    return cachedSizes2;
                }
            }
        }
        this.cachedConstraints = constraints;
        this.cachedDensity = obj.getDensity();
        Object invoke = this.calculation.invoke(obj, Constraints.box-impl(constraints));
        final int i2 = 0;
        this.cachedSizes = (LazyStaggeredGridSlots)invoke;
        return (LazyStaggeredGridSlots)invoke;
    }
}
