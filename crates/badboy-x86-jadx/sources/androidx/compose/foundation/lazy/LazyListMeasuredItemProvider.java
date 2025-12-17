package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\n\u0008 \u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B'\u0008\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJB\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u0003\u001a\u00020\u0004H&ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eJ\"\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!J2\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006&", d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "(JZLandroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "childConstraints", "getChildConstraints-msEJaDk", "()J", "J", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "createItem", "index", "", "key", "", "contentType", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "createItem-X9ElhV4", "(ILjava/lang/Object;Ljava/lang/Object;Ljava/util/List;J)Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "getAndMeasure", "getAndMeasure-0kLqBqw", "(IJ)Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "lane", "span", "getAndMeasure--hBUhpc", "(IIIJ)Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LazyListMeasuredItemProvider implements LazyLayoutMeasuredItemProvider<androidx.compose.foundation.lazy.LazyListMeasuredItem> {

    public static final int $stable;
    private final long childConstraints;
    private final androidx.compose.foundation.lazy.LazyListItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;
    static {
    }

    private LazyListMeasuredItemProvider(long constraints, boolean isVertical, androidx.compose.foundation.lazy.LazyListItemProvider itemProvider, LazyLayoutMeasureScope measureScope) {
        int maxHeight-impl;
        int maxWidth-impl;
        int i;
        super();
        this.itemProvider = measureScope;
        this.measureScope = obj13;
        if (itemProvider != null) {
            i = maxWidth-impl;
        } else {
            i = maxHeight-impl;
        }
        if (itemProvider == null) {
            maxHeight-impl = Constraints.getMaxHeight-impl(constraints);
        }
        this.childConstraints = ConstraintsKt.Constraints$default(0, i, 0, maxHeight-impl, 5, 0);
    }

    public LazyListMeasuredItemProvider(long l, boolean z2, androidx.compose.foundation.lazy.LazyListItemProvider lazyListItemProvider3, LazyLayoutMeasureScope lazyLayoutMeasureScope4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(l, z2, lazyListItemProvider3, lazyLayoutMeasureScope4, defaultConstructorMarker5);
    }

    public static androidx.compose.foundation.lazy.LazyListMeasuredItem getAndMeasure-0kLqBqw$default(androidx.compose.foundation.lazy.LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, long l3, int i4, Object object5) {
        long obj2;
        if (obj5 != null) {
        } else {
            if (object5 &= 2 != 0) {
                obj2 = lazyListMeasuredItemProvider.childConstraints;
            }
            return lazyListMeasuredItemProvider.getAndMeasure-0kLqBqw(i2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAndMeasure-0kLqBqw");
        throw obj0;
    }

    public abstract androidx.compose.foundation.lazy.LazyListMeasuredItem createItem-X9ElhV4(int i, Object object2, Object object3, List<? extends Placeable> list4, long l5);

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    public androidx.compose.foundation.lazy.LazyListMeasuredItem getAndMeasure--hBUhpc(int index, int lane, int span, long constraints) {
        return getAndMeasure-0kLqBqw(index, constraints);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    public LazyLayoutMeasuredItem getAndMeasure--hBUhpc(int index, int lane, int span, long constraints) {
        return (LazyLayoutMeasuredItem)getAndMeasure--hBUhpc(index, lane, span, constraints);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    public final androidx.compose.foundation.lazy.LazyListMeasuredItem getAndMeasure-0kLqBqw(int index, long constraints) {
        return this.createItem-X9ElhV4(index, this.itemProvider.getKey(index), this.itemProvider.getContentType(index), this.measureScope.measure-0kLqBqw(index, constraints), constraints);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    public final long getChildConstraints-msEJaDk() {
        return this.childConstraints;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }
}
