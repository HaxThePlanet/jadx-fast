package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008 \u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0008\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJb\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00082\u0006\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00082\u0006\u0010\u0014\u001a\u00020\u00082\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00082\u0006\u0010\u001b\u001a\u00020\u0008H&ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ8\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00082\u0006\u0010\u001b\u001a\u00020\u00082\u0006\u0010\u0014\u001a\u00020\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 J2\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00082\u0006\u0010\u001a\u001a\u00020\u00082\u0006\u0010\u001b\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006#", d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "defaultMainAxisSpacing", "", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;I)V", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "createItem", "index", "key", "", "contentType", "crossAxisSize", "mainAxisSpacing", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lane", "span", "createItem-O3s9Psw", "(ILjava/lang/Object;Ljava/lang/Object;IILjava/util/List;JII)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "getAndMeasure", "getAndMeasure-m8Kt_7k", "(IJIII)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "getAndMeasure--hBUhpc", "(IIIJ)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LazyGridMeasuredItemProvider implements LazyLayoutMeasuredItemProvider<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> {

    public static final int $stable;
    private final int defaultMainAxisSpacing;
    private final androidx.compose.foundation.lazy.grid.LazyGridItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;
    static {
    }

    public LazyGridMeasuredItemProvider(androidx.compose.foundation.lazy.grid.LazyGridItemProvider itemProvider, LazyLayoutMeasureScope measureScope, int defaultMainAxisSpacing) {
        super();
        this.itemProvider = itemProvider;
        this.measureScope = measureScope;
        this.defaultMainAxisSpacing = defaultMainAxisSpacing;
    }

    public abstract androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem createItem-O3s9Psw(int i, Object object2, Object object3, int i4, int i5, List<? extends Placeable> list6, long l7, int i8, int i9);

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    public androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem getAndMeasure--hBUhpc(int index, int lane, int span, long constraints) {
        return this.getAndMeasure-m8Kt_7k(index, constraints, obj3, lane, span);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    public LazyLayoutMeasuredItem getAndMeasure--hBUhpc(int index, int lane, int span, long constraints) {
        return (LazyLayoutMeasuredItem)getAndMeasure--hBUhpc(index, lane, span, constraints);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    public final androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem getAndMeasure-m8Kt_7k(int index, long constraints, int lane, int span, int mainAxisSpacing) {
        int minHeight-impl;
        int i;
        if (Constraints.getHasFixedWidth-impl(constraints)) {
            i = minHeight-impl;
            return this.createItem-O3s9Psw(index, this.itemProvider.getKey(index), this.itemProvider.getContentType(index), i, obj18, this.measureScope.measure-0kLqBqw(index, constraints), constraints, obj9, span);
        } else {
            if (!Constraints.getHasFixedHeight-impl(constraints)) {
            } else {
                i = minHeight-impl;
            }
        }
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("does not have fixed height".toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }
}
