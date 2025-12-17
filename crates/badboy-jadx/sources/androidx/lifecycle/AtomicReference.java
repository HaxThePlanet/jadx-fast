package androidx.lifecycle;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005J\u000b\u0010\u0008\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/lifecycle/AtomicReference;", "V", "", "initialValue", "<init>", "(Ljava/lang/Object;)V", "base", "Ljava/util/concurrent/atomic/AtomicReference;", "get", "()Ljava/lang/Object;", "compareAndSet", "", "expectedValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AtomicReference<V>  {

    private final AtomicReference<V> base;
    public AtomicReference(V initialValue) {
        super();
        AtomicReference atomicReference = new AtomicReference(initialValue);
        this.base = atomicReference;
    }

    public final boolean compareAndSet(V expectedValue, V newValue) {
        return MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.base, expectedValue, newValue);
    }

    public final V get() {
        return this.base.get();
    }
}
