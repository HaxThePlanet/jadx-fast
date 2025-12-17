package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.runtime.collection.MutableVector;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\u00020\u000c*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u001c\u0010\u000f\u001a\u00020\u000c*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u00020\u000c*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/foundation/lazy/grid/DefaultLazyGridPrefetchStrategy;", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "nestedPrefetchItemCount", "", "(I)V", "currentLinePrefetchHandles", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "lineToPrefetch", "wasScrollingForward", "", "onNestedPrefetch", "", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "firstVisibleItemIndex", "onScroll", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "delta", "", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "onVisibleItemsUpdated", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultLazyGridPrefetchStrategy implements androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy {

    private final MutableVector<LazyLayoutPrefetchState.PrefetchHandle> currentLinePrefetchHandles;
    private int lineToPrefetch;
    private final int nestedPrefetchItemCount;
    private boolean wasScrollingForward;
    public DefaultLazyGridPrefetchStrategy() {
        super(0, 1, 0);
    }

    public DefaultLazyGridPrefetchStrategy(int nestedPrefetchItemCount) {
        super();
        this.nestedPrefetchItemCount = nestedPrefetchItemCount;
        this.lineToPrefetch = -1;
        int i2 = 0;
        final int i4 = 0;
        MutableVector mutableVector = new MutableVector(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);
        this.currentLinePrefetchHandles = mutableVector;
    }

    public DefaultLazyGridPrefetchStrategy(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 2 : obj1;
        super(obj1);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onNestedPrefetch(NestedPrefetchScope $this$onNestedPrefetch, int firstVisibleItemIndex) {
        int i3;
        int i;
        int i2;
        int i4;
        i3 = 0;
        while (i3 < this.nestedPrefetchItemCount) {
            i2 = 0;
            $this$onNestedPrefetch.schedulePrefetch(firstVisibleItemIndex + i);
            i3++;
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onScroll(androidx.compose.foundation.lazy.grid.LazyGridPrefetchScope $this$onScroll, float delta, androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo layoutInfo) {
        int empty;
        int first;
        MutableVector currentLinePrefetchHandles3;
        boolean currentLinePrefetchHandles;
        int i4;
        int i2;
        int totalItemsCount;
        Object obj3;
        Object scheduleLinePrefetch;
        int i$iv3;
        int column2;
        int column;
        int i;
        Orientation vertical;
        Object currentLinePrefetchHandles2;
        int i$iv;
        Object[] content;
        Object i$iv2;
        int content2;
        Object obj;
        int i3;
        final Object obj2 = this;
        final int i5 = delta;
        if (!(Collection)layoutInfo.getVisibleItemsInfo().isEmpty()) {
            i4 = 1;
            empty = Float.compare(i5, i6) < 0 ? i4 : first;
            int i7 = 0;
            totalItemsCount = 0;
            if (empty != 0) {
                scheduleLinePrefetch = CollectionsKt.last(layoutInfo.getVisibleItemsInfo());
                i$iv3 = 0;
                if (layoutInfo.getOrientation() == Orientation.Vertical) {
                    column = (LazyGridItemInfo)scheduleLinePrefetch.getRow();
                } else {
                    column = scheduleLinePrefetch.getColumn();
                }
                column += i4;
                index2 += i4;
            } else {
                scheduleLinePrefetch = CollectionsKt.first(layoutInfo.getVisibleItemsInfo());
                i$iv3 = 0;
                if (layoutInfo.getOrientation() == Orientation.Vertical) {
                    column2 = (LazyGridItemInfo)scheduleLinePrefetch.getRow();
                } else {
                    column2 = scheduleLinePrefetch.getColumn();
                }
                column2--;
                index -= i4;
            }
            if (i2 >= 0 && i2 < layoutInfo.getTotalItemsCount()) {
                if (i2 < layoutInfo.getTotalItemsCount()) {
                    first = i4;
                }
            }
            if (first != 0) {
                if (i != obj2.lineToPrefetch) {
                    currentLinePrefetchHandles = obj2.currentLinePrefetchHandles;
                    totalItemsCount = 0;
                    scheduleLinePrefetch = currentLinePrefetchHandles.getSize();
                    if (obj2.wasScrollingForward != empty && scheduleLinePrefetch > 0) {
                        currentLinePrefetchHandles = obj2.currentLinePrefetchHandles;
                        totalItemsCount = 0;
                        scheduleLinePrefetch = currentLinePrefetchHandles.getSize();
                        if (scheduleLinePrefetch > 0) {
                            i$iv3 = 0;
                            i$iv = 0;
                            (LazyLayoutPrefetchState.PrefetchHandle)currentLinePrefetchHandles.getContent()[i$iv3].cancel();
                            while (i$iv3 += i4 >= scheduleLinePrefetch) {
                                i$iv = 0;
                                (LazyLayoutPrefetchState.PrefetchHandle)vertical[i$iv3].cancel();
                            }
                        }
                    }
                    obj2.wasScrollingForward = empty;
                    obj2.lineToPrefetch = i;
                    obj2.currentLinePrefetchHandles.clear();
                    currentLinePrefetchHandles3 = obj2.currentLinePrefetchHandles;
                    i$iv3 = 0;
                    currentLinePrefetchHandles3.addAll(currentLinePrefetchHandles3.getSize(), $this$onScroll.scheduleLinePrefetch(i));
                } else {
                    obj3 = $this$onScroll;
                }
                if (empty != 0) {
                    first = CollectionsKt.last(layoutInfo.getVisibleItemsInfo());
                    currentLinePrefetchHandles2 = obj2.currentLinePrefetchHandles;
                    i$iv = 0;
                    content = currentLinePrefetchHandles2.getSize();
                    if (Float.compare(f2, i$iv) < 0 && content > 0) {
                        currentLinePrefetchHandles2 = obj2.currentLinePrefetchHandles;
                        i$iv = 0;
                        content = currentLinePrefetchHandles2.getSize();
                        if (content > 0) {
                            i$iv2 = 0;
                            i3 = 0;
                            (LazyLayoutPrefetchState.PrefetchHandle)currentLinePrefetchHandles2.getContent()[i$iv2].markAsUrgent();
                            while (i$iv2 += i4 >= content) {
                                i3 = 0;
                                (LazyLayoutPrefetchState.PrefetchHandle)content2[i$iv2].markAsUrgent();
                            }
                        }
                    }
                } else {
                    i$iv3 = obj2.currentLinePrefetchHandles;
                    vertical = 0;
                    currentLinePrefetchHandles2 = i$iv3.getSize();
                    if (Float.compare(f, i5) < 0 && currentLinePrefetchHandles2 > 0) {
                        i$iv3 = obj2.currentLinePrefetchHandles;
                        vertical = 0;
                        currentLinePrefetchHandles2 = i$iv3.getSize();
                        if (currentLinePrefetchHandles2 > 0) {
                            i$iv = 0;
                            content2 = 0;
                            (LazyLayoutPrefetchState.PrefetchHandle)i$iv3.getContent()[i$iv].markAsUrgent();
                            while (i$iv += i4 >= currentLinePrefetchHandles2) {
                                content2 = 0;
                                (LazyLayoutPrefetchState.PrefetchHandle)content[i$iv].markAsUrgent();
                            }
                        }
                    }
                }
            } else {
                obj3 = $this$onScroll;
            }
        } else {
            obj3 = $this$onScroll;
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onVisibleItemsUpdated(androidx.compose.foundation.lazy.grid.LazyGridPrefetchScope $this$onVisibleItemsUpdated, androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo layoutInfo) {
        Object first;
        int this_$iv;
        int i2;
        int size;
        int i3;
        int column;
        int column2;
        Orientation i$iv;
        Object[] content;
        Object obj;
        int i;
        i2 = -1;
        if (this.lineToPrefetch != i2 && !(Collection)layoutInfo.getVisibleItemsInfo().isEmpty()) {
            if (!(Collection)layoutInfo.getVisibleItemsInfo().isEmpty()) {
                if (this.wasScrollingForward) {
                    first = CollectionsKt.last(layoutInfo.getVisibleItemsInfo());
                    size = 0;
                    if (layoutInfo.getOrientation() == Orientation.Vertical) {
                        column = (LazyGridItemInfo)first.getRow();
                    } else {
                        column = first.getColumn();
                    }
                    column++;
                } else {
                    first = CollectionsKt.first(layoutInfo.getVisibleItemsInfo());
                    size = 0;
                    if (layoutInfo.getOrientation() == Orientation.Vertical) {
                        column2 = (LazyGridItemInfo)first.getRow();
                    } else {
                        column2 = first.getColumn();
                    }
                    column2--;
                }
                this.lineToPrefetch = i2;
                MutableVector currentLinePrefetchHandles = this.currentLinePrefetchHandles;
                i2 = 0;
                size = currentLinePrefetchHandles.getSize();
                if (this.lineToPrefetch != i3 && size > 0) {
                    this.lineToPrefetch = i2;
                    currentLinePrefetchHandles = this.currentLinePrefetchHandles;
                    i2 = 0;
                    size = currentLinePrefetchHandles.getSize();
                    if (size > 0) {
                        i$iv = 0;
                        i = 0;
                        (LazyLayoutPrefetchState.PrefetchHandle)currentLinePrefetchHandles.getContent()[i$iv].cancel();
                        while (i$iv++ >= size) {
                            i = 0;
                            (LazyLayoutPrefetchState.PrefetchHandle)content[i$iv].cancel();
                        }
                    }
                    this.currentLinePrefetchHandles.clear();
                }
            }
        }
    }
}
