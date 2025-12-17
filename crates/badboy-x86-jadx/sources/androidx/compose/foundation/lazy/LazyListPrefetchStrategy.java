package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\nH&J\u001c\u0010\u000b\u001a\u00020\u0007*\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0014\u0010\u0011\u001a\u00020\u0007*\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u0010H&R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0012À\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/LazyListPrefetchStrategy;", "", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "getPrefetchScheduler", "()Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "onNestedPrefetch", "", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "firstVisibleItemIndex", "", "onScroll", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "delta", "", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "onVisibleItemsUpdated", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LazyListPrefetchStrategy {
    public PrefetchScheduler getPrefetchScheduler() {
        return null;
    }

    public abstract void onNestedPrefetch(NestedPrefetchScope nestedPrefetchScope, int i2);

    public abstract void onScroll(androidx.compose.foundation.lazy.LazyListPrefetchScope lazyListPrefetchScope, float f2, androidx.compose.foundation.lazy.LazyListLayoutInfo lazyListLayoutInfo3);

    public abstract void onVisibleItemsUpdated(androidx.compose.foundation.lazy.LazyListPrefetchScope lazyListPrefetchScope, androidx.compose.foundation.lazy.LazyListLayoutInfo lazyListLayoutInfo2);
}
