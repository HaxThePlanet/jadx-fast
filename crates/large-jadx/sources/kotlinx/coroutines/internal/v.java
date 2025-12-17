package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.r0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0000J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0001H&J\u0008\u0010\u000c\u001a\u00020\rH\u0016R\u0018\u0010\u0003\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/internal/OpDescriptor;", "", "()V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "isEarlierThan", "", "that", "perform", "affected", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class v {
    public abstract kotlinx.coroutines.internal.d<?> a();

    public final boolean b(kotlinx.coroutines.internal.v v) {
        int i;
        final kotlinx.coroutines.internal.d dVar = a();
        i = 0;
        if (dVar == null) {
            return i;
        }
        kotlinx.coroutines.internal.d obj7 = v.a();
        if (obj7 == null) {
            return i;
        }
        if (Long.compare(l, l2) < 0) {
            i = 1;
        }
        return i;
    }

    public abstract Object c(Object object);

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(r0.a(this));
        stringBuilder.append('@');
        stringBuilder.append(r0.b(this));
        return stringBuilder.toString();
    }
}
