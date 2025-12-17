package kotlinx.coroutines.d3;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.b0.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.o1;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0008\u0002\u0018\u00002\u00020+2\u00020,2\u00020\u001fB)\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\u0008\u0008\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\u0008\r\u0010\u000cJ#\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\u0008\u0013\u0010\u0014J#\u0010\u0013\u001a\u00020\n2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\u0008\u0013\u0010\u0017J#\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\u0008\u0018\u0010\u0014J\u001b\u0010\u001a\u001a\u00020\n2\n\u0010\u0019\u001a\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u001c\u0010\u001dR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0002\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010!R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0006\u0010#R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0004\u0010$R\u001e\u0010&\u001a\u000c\u0012\u0008\u0012\u00060\u0010j\u0002`\u00110%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008&\u0010'R\u001a\u0010\u0007\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\u000c\n\u0004\u0008\u0007\u0010$\u001a\u0004\u0008(\u0010)¨\u0006*", d2 = {"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "", "name", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;ILjava/lang/String;I)V", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "tailDispatch", "(Ljava/lang/Runnable;Z)V", "dispatchYield", "command", "execute", "(Ljava/lang/Runnable;)V", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "Ljava/lang/String;", "I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "getTaskMode", "()I", "kotlinx-coroutines-core", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class e extends o1 implements kotlinx.coroutines.d3.j, Executor {

    private static final AtomicIntegerFieldUpdater y;
    private final kotlinx.coroutines.d3.c b;
    private final int c;
    private volatile int inFlightTasks = 0;
    private final String v;
    private final int w;
    private final ConcurrentLinkedQueue<Runnable> x;
    static {
        e.y = AtomicIntegerFieldUpdater.newUpdater(e.class, "inFlightTasks");
    }

    public e(kotlinx.coroutines.d3.c c, int i2, String string3, int i4) {
        super();
        this.b = c;
        this.c = i2;
        this.v = string3;
        this.w = i4;
        ConcurrentLinkedQueue obj1 = new ConcurrentLinkedQueue();
        this.x = obj1;
        obj1 = 0;
    }

    private final void M(Runnable runnable, boolean z2) {
        AtomicIntegerFieldUpdater num = e.y;
        while (num.incrementAndGet(this) <= this.c) {
            this.x.add(runnable);
            num = e.y;
        }
        this.b.T(runnable, this, z2);
    }

    @Override // kotlinx.coroutines.o1
    public void K(g g, Runnable runnable2) {
        M(runnable2, false);
    }

    @Override // kotlinx.coroutines.o1
    public void close() {
        IllegalStateException illegalStateException = new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.o1
    public void execute(Runnable runnable) {
        M(runnable, false);
    }

    @Override // kotlinx.coroutines.o1
    public void k() {
        Object poll = this.x.poll();
        final int i = 1;
        if ((Runnable)poll != null) {
            this.b.T((Runnable)poll, this, i);
        }
        e.y.decrementAndGet(this);
        Object poll2 = this.x.poll();
        if ((Runnable)poll2 == null) {
        }
        M((Runnable)poll2, i);
    }

    @Override // kotlinx.coroutines.o1
    public int r() {
        return this.w;
    }

    @Override // kotlinx.coroutines.o1
    public String toString() {
        String string;
        int i;
        if (this.v == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append("[dispatcher = ");
            stringBuilder.append(this.b);
            stringBuilder.append(']');
            string = stringBuilder.toString();
        }
        return string;
    }
}
