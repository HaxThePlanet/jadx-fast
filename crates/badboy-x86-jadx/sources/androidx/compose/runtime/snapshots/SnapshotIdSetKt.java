package androidx.compose.runtime.snapshots;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0010\u0015\n\u0002\u0008\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004", d2 = {"binarySearch", "", "", "value", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SnapshotIdSetKt {
    public static final int binarySearch(int[] $this$binarySearch, int value) {
        int low;
        int high;
        int i;
        int i2;
        low = 0;
        length--;
        while (low <= high) {
            i4 >>>= 1;
            i2 = $this$binarySearch[i];
            high = i + -1;
            low = i + 1;
        }
        return -mid;
    }
}
