package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.q0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\u0008'\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u00020\u001dB\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J!\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u00002\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\u0008\u0008\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0008\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u0008\r\u0010\u000cJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\u0008\u000e\u0010\u000cR\u0018\u0010\u0011\u001a\u0006\u0012\u0002\u0008\u00030\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a¨\u0006\u001c", d2 = {"Lkotlinx/coroutines/internal/AtomicOp;", "T", "<init>", "()V", "affected", "", "failure", "", "complete", "(Ljava/lang/Object;Ljava/lang/Object;)V", "decision", "decide", "(Ljava/lang/Object;)Ljava/lang/Object;", "perform", "prepare", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "getConsensus", "()Ljava/lang/Object;", "consensus", "", "isDecided", "()Z", "", "getOpSequence", "()J", "opSequence", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/OpDescriptor;"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class d<T>  extends kotlinx.coroutines.internal.v {

    private static final AtomicReferenceFieldUpdater a;
    private volatile Object _consensus;
    static {
        d.a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_consensus");
    }

    public d() {
        super();
        this._consensus = c.a;
    }

    public kotlinx.coroutines.internal.d<?> a() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.v
    public final Object c(Object object) {
        Object _consensus;
        if (this._consensus == c.a) {
            _consensus = e(g(object));
        }
        d(object, _consensus);
        return _consensus;
    }

    public abstract void d(T t, Object object2);

    @Override // kotlinx.coroutines.internal.v
    public final Object e(Object object) {
        boolean z;
        if (q0.a()) {
            z = object != c.a ? 1 : 0;
            if (z == 0) {
            } else {
            }
            AssertionError obj3 = new AssertionError();
            throw obj3;
        }
        Object _consensus = this._consensus;
        final Object obj2 = c.a;
        if (_consensus != obj2) {
            return _consensus;
        }
        if (d.a.compareAndSet(this, obj2, object)) {
            return object;
        }
        return this._consensus;
    }

    @Override // kotlinx.coroutines.internal.v
    public long f() {
        return 0;
    }

    public abstract Object g(T t);
}
