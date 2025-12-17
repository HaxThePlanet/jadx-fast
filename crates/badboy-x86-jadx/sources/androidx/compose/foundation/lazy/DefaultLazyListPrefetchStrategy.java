package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\n\u001a\u00020\u000b*\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u001c\u0010\u000e\u001a\u00020\u000b*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0014\u001a\u00020\u000b*\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Landroidx/compose/foundation/lazy/DefaultLazyListPrefetchStrategy;", "Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "nestedPrefetchItemCount", "", "(I)V", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "indexToPrefetch", "wasScrollingForward", "", "onNestedPrefetch", "", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "firstVisibleItemIndex", "onScroll", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "delta", "", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "onVisibleItemsUpdated", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultLazyListPrefetchStrategy implements androidx.compose.foundation.lazy.LazyListPrefetchStrategy {

    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private int indexToPrefetch;
    private final int nestedPrefetchItemCount;
    private boolean wasScrollingForward;
    public DefaultLazyListPrefetchStrategy() {
        super(0, 1, 0);
    }

    public DefaultLazyListPrefetchStrategy(int nestedPrefetchItemCount) {
        super();
        this.nestedPrefetchItemCount = nestedPrefetchItemCount;
        this.indexToPrefetch = -1;
    }

    public DefaultLazyListPrefetchStrategy(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 2 : obj1;
        super(obj1);
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public void onNestedPrefetch(NestedPrefetchScope $this$onNestedPrefetch, int firstVisibleItemIndex) {
        int i3;
        int i;
        int i4;
        int i2;
        i3 = 0;
        while (i3 < this.nestedPrefetchItemCount) {
            i4 = 0;
            $this$onNestedPrefetch.schedulePrefetch(firstVisibleItemIndex + i);
            i3++;
        }
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public void onScroll(androidx.compose.foundation.lazy.LazyListPrefetchScope $this$onScroll, float delta, androidx.compose.foundation.lazy.LazyListLayoutInfo layoutInfo) {
        int empty;
        int first;
        boolean currentPrefetchHandle;
        int schedulePrefetch;
        int mainAxisItemSpacing;
        int i2;
        int currentPrefetchHandle3;
        int currentPrefetchHandle2;
        int i;
        if (!(Collection)layoutInfo.getVisibleItemsInfo().isEmpty()) {
            mainAxisItemSpacing = 1;
            empty = Float.compare(delta, i3) < 0 ? mainAxisItemSpacing : first;
            if (empty != 0) {
                index2 += mainAxisItemSpacing;
            } else {
                index -= mainAxisItemSpacing;
            }
            if (i2 >= 0 && i2 < layoutInfo.getTotalItemsCount()) {
                if (i2 < layoutInfo.getTotalItemsCount()) {
                    first = mainAxisItemSpacing;
                }
            }
            currentPrefetchHandle = this.currentPrefetchHandle;
            if (first != 0 && i2 != this.indexToPrefetch && this.wasScrollingForward != empty && currentPrefetchHandle != null) {
                if (i2 != this.indexToPrefetch) {
                    if (this.wasScrollingForward != empty) {
                        currentPrefetchHandle = this.currentPrefetchHandle;
                        if (currentPrefetchHandle != null) {
                            currentPrefetchHandle.cancel();
                        }
                    }
                    this.wasScrollingForward = empty;
                    this.indexToPrefetch = i2;
                    this.currentPrefetchHandle = $this$onScroll.schedulePrefetch(i2);
                }
                if (empty != 0) {
                    first = CollectionsKt.last(layoutInfo.getVisibleItemsInfo());
                    currentPrefetchHandle2 = this.currentPrefetchHandle;
                    if (Float.compare(f2, i) < 0 && currentPrefetchHandle2 != null) {
                        currentPrefetchHandle2 = this.currentPrefetchHandle;
                        if (currentPrefetchHandle2 != null) {
                            currentPrefetchHandle2.markAsUrgent();
                        }
                    }
                } else {
                    currentPrefetchHandle3 = this.currentPrefetchHandle;
                    if (Float.compare(f, delta) < 0 && currentPrefetchHandle3 != null) {
                        currentPrefetchHandle3 = this.currentPrefetchHandle;
                        if (currentPrefetchHandle3 != null) {
                            currentPrefetchHandle3.markAsUrgent();
                        }
                    }
                }
            }
        }
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public void onVisibleItemsUpdated(androidx.compose.foundation.lazy.LazyListPrefetchScope $this$onVisibleItemsUpdated, androidx.compose.foundation.lazy.LazyListLayoutInfo layoutInfo) {
        int indexToPrefetch;
        int i;
        int indexToPrefetch2;
        i = -1;
        if (this.indexToPrefetch != i && !(Collection)layoutInfo.getVisibleItemsInfo().isEmpty()) {
            if (!(Collection)layoutInfo.getVisibleItemsInfo().isEmpty()) {
                if (this.wasScrollingForward) {
                    index++;
                } else {
                    index2--;
                }
                this.indexToPrefetch = i;
                LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle = this.currentPrefetchHandle;
                if (this.indexToPrefetch != indexToPrefetch && currentPrefetchHandle != null) {
                    this.indexToPrefetch = i;
                    currentPrefetchHandle = this.currentPrefetchHandle;
                    if (currentPrefetchHandle != null) {
                        currentPrefetchHandle.cancel();
                    }
                    this.currentPrefetchHandle = 0;
                }
            }
        }
    }
}
