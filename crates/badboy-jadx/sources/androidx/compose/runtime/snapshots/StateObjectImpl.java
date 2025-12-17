package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.AtomicInt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008 \u0018\u00002\u00020\u0001B\u0007\u0008\u0000¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0007\u001a\u00020\u0008H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000f", d2 = {"Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "readerKind", "Landroidx/compose/runtime/AtomicInt;", "isReadIn", "", "reader", "Landroidx/compose/runtime/snapshots/ReaderKind;", "isReadIn-h_f27i8$runtime_release", "(I)Z", "recordReadIn", "", "recordReadIn-h_f27i8$runtime_release", "(I)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class StateObjectImpl implements androidx.compose.runtime.snapshots.StateObject {

    public static final int $stable;
    private final AtomicInt readerKind;
    static {
    }

    public StateObjectImpl() {
        super();
        AtomicInt atomicInt = new AtomicInt(0);
        this.readerKind = atomicInt;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final boolean isReadIn-h_f27i8$runtime_release(int reader) {
        int i;
        final int i3 = 0;
        i = constructor-impl & reader != 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public final void recordReadIn-h_f27i8$runtime_release(int reader) {
        int constructor-impl;
        int $i$f$withReadIn3QSx2Dw;
        boolean compareAndSet;
        int i;
        constructor-impl = ReaderKind.constructor-impl(this.readerKind.get());
        int i3 = 0;
        while (constructor-impl & reader != 0) {
            i = 1;
            int i4 = 0;
            constructor-impl = ReaderKind.constructor-impl(this.readerKind.get());
            i3 = 0;
            i = 0;
        }
    }
}
