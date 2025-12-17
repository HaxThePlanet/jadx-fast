package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016J\u0008\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006", d2 = {"Landroidx/compose/foundation/lazy/layout/DummyHandle;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "()V", "cancel", "", "markAsUrgent", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DummyHandle implements androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle {

    public static final androidx.compose.foundation.lazy.layout.DummyHandle INSTANCE;
    static {
        DummyHandle dummyHandle = new DummyHandle();
        DummyHandle.INSTANCE = dummyHandle;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle
    public void cancel() {
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle
    public void markAsUrgent() {
    }
}
