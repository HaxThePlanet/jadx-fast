package androidx.compose.runtime;

import androidx.compose.runtime.internal.ThreadMap;
import androidx.compose.runtime.internal.ThreadMap_jvmKt;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\r\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000cJ\u0015\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0010R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00080\u0007j\u0008\u0012\u0004\u0012\u00020\u0008`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/compose/runtime/SnapshotThreadLocal;", "T", "", "()V", "mainThreadValue", "Ljava/lang/Object;", "map", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/internal/ThreadMap;", "Landroidx/compose/runtime/AtomicReference;", "writeMutex", "get", "()Ljava/lang/Object;", "set", "", "value", "(Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotThreadLocal<T>  {

    public static final int $stable = 8;
    private T mainThreadValue;
    private final AtomicReference<ThreadMap> map;
    private final Object writeMutex;
    static {
        final int i = 8;
    }

    public SnapshotThreadLocal() {
        super();
        AtomicReference atomicReference = new AtomicReference(ThreadMap_jvmKt.getEmptyThreadMap());
        this.map = atomicReference;
        Object object = new Object();
        this.writeMutex = object;
    }

    public final T get() {
        Object mainThreadValue;
        long id = Thread.currentThread().getId();
        if (Long.compare(id, mainThreadId) == 0) {
            mainThreadValue = this.mainThreadValue;
        } else {
            mainThreadValue = (ThreadMap)this.map.get().get(id);
        }
        return mainThreadValue;
    }

    public final void set(T value) {
        int writeMutex;
        int i;
        Object iNSTANCE;
        Object obj;
        AtomicReference map;
        ThreadMap with;
        long id = Thread.currentThread().getId();
        if (Long.compare(id, mainThreadId) == 0) {
            this.mainThreadValue = value;
        } else {
            writeMutex = this.writeMutex;
            i = 0;
            int i2 = 0;
            obj = this.map.get();
            synchronized (writeMutex) {
            }
        }
    }
}
