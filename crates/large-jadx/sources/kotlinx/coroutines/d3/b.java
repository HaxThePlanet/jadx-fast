package kotlinx.coroutines.d3;

import kotlin.Metadata;
import kotlin.h0.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.internal.a0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0008H\u0016J\u0008\u0010\t\u001a\u00020\nH\u0007J\u0008\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000c", d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b extends kotlinx.coroutines.d3.c {

    public static final kotlinx.coroutines.d3.b y;
    private static final h0 z;
    static {
        b bVar = new b();
        b.y = bVar;
        e eVar = new e(bVar, a0.f("kotlinx.coroutines.io.parallelism", g.b(64, a0.a()), 0, 0, 12, 0), "Dispatchers.IO", 1);
        b.z = eVar;
    }

    private b() {
        super(0, 0, 0, 7, 0);
    }

    @Override // kotlinx.coroutines.d3.c
    public final h0 U() {
        return b.z;
    }

    @Override // kotlinx.coroutines.d3.c
    public void close() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Dispatchers.Default cannot be closed");
        throw unsupportedOperationException;
    }

    @Override // kotlinx.coroutines.d3.c
    public String toString() {
        return "Dispatchers.Default";
    }
}
