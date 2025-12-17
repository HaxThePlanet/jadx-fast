package androidx.compose.runtime.snapshots;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u001a\u0008\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0008\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"sync", "", "invalidIteratorSet", "", "modificationError", "validateRange", "", "index", "", "size", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SnapshotStateListKt {

    private static final Object sync;
    static {
        Object object = new Object();
        SnapshotStateListKt.sync = object;
    }

    public static final Object access$getSync$p() {
        return SnapshotStateListKt.sync;
    }

    public static final Void access$invalidIteratorSet() {
        return SnapshotStateListKt.invalidIteratorSet();
    }

    public static final Void access$modificationError() {
        return SnapshotStateListKt.modificationError();
    }

    public static final void access$validateRange(int index, int size) {
        SnapshotStateListKt.validateRange(index, size);
    }

    private static final Void invalidIteratorSet() {
        IllegalStateException illegalStateException = new IllegalStateException("Cannot call set before the first call to next() or previous() or immediately after a call to add() or remove()".toString());
        throw illegalStateException;
    }

    private static final Void modificationError() {
        IllegalStateException illegalStateException = new IllegalStateException("Cannot modify a state list through an iterator".toString());
        throw illegalStateException;
    }

    private static final void validateRange(int index, int size) {
        int i;
        i = 0;
        if (index >= 0 && index < size) {
            if (index < size) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("index (").append(index).append(") is out of bound of [0, ").append(size).append(')').toString());
        throw indexOutOfBoundsException;
    }
}
