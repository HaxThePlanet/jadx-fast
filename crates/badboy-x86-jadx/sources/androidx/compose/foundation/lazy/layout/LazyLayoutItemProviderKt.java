package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0001¨\u0006\u0006", d2 = {"findIndexByKey", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "key", "", "lastKnownIndex", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutItemProviderKt {
    public static final int findIndexByKey(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider $this$findIndexByKey, Object key, int lastKnownIndex) {
        int itemCount2;
        int itemCount;
        if (key != null) {
            if ($this$findIndexByKey.getItemCount() == 0) {
            } else {
                if (lastKnownIndex < $this$findIndexByKey.getItemCount() && Intrinsics.areEqual(key, $this$findIndexByKey.getKey(lastKnownIndex))) {
                    if (Intrinsics.areEqual(key, $this$findIndexByKey.getKey(lastKnownIndex))) {
                        return lastKnownIndex;
                    }
                }
                int index = $this$findIndexByKey.getIndex(key);
                if (index != -1) {
                    return index;
                }
            }
            return lastKnownIndex;
        }
        return lastKnownIndex;
    }
}
