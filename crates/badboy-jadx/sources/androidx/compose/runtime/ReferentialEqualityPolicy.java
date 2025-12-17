package androidx.compose.runtime;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008Â\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0008\u0010\u0008\u001a\u00020\tH\u0016¨\u0006\n", d2 = {"Landroidx/compose/runtime/ReferentialEqualityPolicy;", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "", "()V", "equivalent", "", "a", "b", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ReferentialEqualityPolicy implements androidx.compose.runtime.SnapshotMutationPolicy<Object> {

    public static final androidx.compose.runtime.ReferentialEqualityPolicy INSTANCE;
    static {
        ReferentialEqualityPolicy referentialEqualityPolicy = new ReferentialEqualityPolicy();
        ReferentialEqualityPolicy.INSTANCE = referentialEqualityPolicy;
    }

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public boolean equivalent(Object a, Object b) {
        int i;
        i = a == b ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.SnapshotMutationPolicy
    public String toString() {
        return "ReferentialEqualityPolicy";
    }
}
