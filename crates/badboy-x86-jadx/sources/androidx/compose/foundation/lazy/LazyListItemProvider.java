package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008a\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0008X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u000cX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000fÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/LazyListItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "headerIndexes", "", "", "getHeaderIndexes", "()Ljava/util/List;", "itemScope", "Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "getItemScope", "()Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LazyListItemProvider extends LazyLayoutItemProvider {
    public abstract List<Integer> getHeaderIndexes();

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public abstract androidx.compose.foundation.lazy.LazyItemScopeImpl getItemScope();

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public abstract LazyLayoutKeyIndexMap getKeyIndexMap();
}
