package kotlinx.coroutines;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.b0.g;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.w;
import kotlinx.coroutines.internal.e0;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.q;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0008 \u0018\u00002\u0002092\u00020::\u00044567B\u0007¢\u0006\u0004\u0008\u0001\u0010\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\u0004\u0010\u0002J\u0017\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J!\u0010\u000c\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\u0008\u000c\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\u0008\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\u0017\u0010\u0002J\u000f\u0010\u0018\u001a\u00020\u0003H\u0004¢\u0006\u0004\u0008\u0018\u0010\u0002J\u001d\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\u0008\u001f\u0010 J#\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u00142\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\u0008#\u0010$J%\u0010'\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00142\u000c\u0010&\u001a\u0008\u0012\u0004\u0012\u00020\u00030%H\u0016¢\u0006\u0004\u0008'\u0010(J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u001aH\u0002¢\u0006\u0004\u0008)\u0010*J\u000f\u0010+\u001a\u00020\u0003H\u0014¢\u0006\u0004\u0008+\u0010\u0002R$\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\u000c\u001a\u0004\u0008-\u0010.\"\u0004\u0008/\u00100R\u0014\u00101\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u00081\u0010.R\u0014\u00103\u001a\u00020\u00148TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u00082\u0010\u0016¨\u00068", d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class j1 extends kotlinx.coroutines.k1 implements kotlinx.coroutines.w0 {

    private static final AtomicReferenceFieldUpdater w;
    private static final AtomicReferenceFieldUpdater x;
    private volatile Object _delayed = null;
    private volatile int _isCompleted = 0;
    private volatile Object _queue = null;

    @Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008 \u0018\u00002\u00060\u0001j\u0002`\u00022\u0008\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0011\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u0007J\u0008\u0010$\u001a\u00020%H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u000c2\u000c\u0010\u000b\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u000c8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class c implements Runnable, Comparable<kotlinx.coroutines.j1.c>, kotlinx.coroutines.e1, f0 {

        public long a;
        private Object b;
        private int c = -1;
        public c(long l) {
            super();
            this.a = l;
            final int obj1 = -1;
        }

        public void a(e0<?> e0) {
            int i;
            i = this.b != m1.b() ? 1 : 0;
            if (i == 0) {
            } else {
                this.b = e0;
            }
            IllegalArgumentException obj3 = new IllegalArgumentException("Failed requirement.".toString());
            throw obj3;
        }

        @Override // java.lang.Runnable
        public int compareTo(Object object) {
            return i((j1.c)object);
        }

        @Override // java.lang.Runnable
        public final void dispose() {
            Object obj;
            obj = this.b;
            synchronized (this) {
                try {
                    if (obj instanceof j1.d) {
                    } else {
                    }
                    obj = 0;
                }
                obj.g(this);
                this.b = m1.b();
            }
        }

        public e0<?> e() {
            Object obj;
            if (obj instanceof e0) {
            } else {
                obj = 0;
            }
            return obj;
        }

        @Override // java.lang.Runnable
        public void f(int i) {
            this.c = i;
        }

        @Override // java.lang.Runnable
        public int getIndex() {
            return this.c;
        }

        @Override // java.lang.Runnable
        public int i(kotlinx.coroutines.j1.c j1$c) {
            int obj5;
            obj5 = Long.compare(i, i2);
            obj5 = obj5 > 0 ? 1 : obj5 < 0 ? -1 : 0;
            return obj5;
        }

        @Override // java.lang.Runnable
        public final int j(long l, kotlinx.coroutines.j1.d j1$d2, kotlinx.coroutines.j1 j13) {
            int i;
            int i2;
            long obj8;
            int obj11;
            synchronized (this) {
                try {
                    return 2;
                    f0 f0Var = j13.b();
                    if (j1.z0(obj11)) {
                    }
                    return 1;
                    int i3 = 0;
                    j13.b = l;
                    long l3 = f0Var.a;
                } catch (Throwable th) {
                }
                long l2 = j13.b;
                if (Long.compare(obj8, i3) < 0) {
                    try {
                        this.a = l2;
                    } catch (Throwable th) {
                    }
                }
                try {
                    j13.a(this);
                    return 0;
                    throw l;
                    throw l;
                }
            }
        }

        @Override // java.lang.Runnable
        public final boolean k(long l) {
            int obj3;
            obj3 = Long.compare(obj3, i) >= 0 ? 1 : 0;
            return obj3;
        }

        @Override // java.lang.Runnable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Delayed[nanos=");
            stringBuilder.append(this.a);
            stringBuilder.append(']');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends e0<kotlinx.coroutines.j1.c> {

        public long b;
        public d(long l) {
            super();
            this.b = l;
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0008\u0010\u0008\u001a\u00020\u0006H\u0016J\u0008\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class a extends kotlinx.coroutines.j1.c {

        private final kotlinx.coroutines.p<w> v;
        final kotlinx.coroutines.j1 w;
        public a(kotlinx.coroutines.j1 j1, long l2, kotlinx.coroutines.p p3) {
            this.w = j1;
            super(l2, p3);
            this.v = obj4;
        }

        @Override // kotlinx.coroutines.j1$c
        public void run() {
            this.v.k(this.w, w.a);
        }

        @Override // kotlinx.coroutines.j1$c
        public String toString() {
            return n.o(super.toString(), this.v);
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u0008\u001a\u00020\tH\u0016J\u0008\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class b extends kotlinx.coroutines.j1.c {

        private final Runnable v;
        public b(long l, Runnable runnable2) {
            super(l, runnable2);
            this.v = obj3;
        }

        @Override // kotlinx.coroutines.j1$c
        public void run() {
            this.v.run();
        }

        @Override // kotlinx.coroutines.j1$c
        public String toString() {
            return n.o(super.toString(), this.v);
        }
    }
    static {
        Class<Object> obj = Object.class;
        final Class<kotlinx.coroutines.j1> obj2 = j1.class;
        j1.w = AtomicReferenceFieldUpdater.newUpdater(obj2, obj, "_queue");
        j1.x = AtomicReferenceFieldUpdater.newUpdater(obj2, obj, "_delayed");
    }

    public j1() {
        super();
        int i = 0;
        int i2 = 0;
    }

    private final void A0() {
        boolean compareAndSet;
        q qVar;
        Object obj;
        int i;
        if (q0.a()) {
            if (!J0()) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        Object _queue = this._queue;
        while (_queue == null) {
            _queue = this._queue;
            qVar = new q(8, 1);
            Objects.requireNonNull(_queue, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
            qVar.a((Runnable)_queue);
        }
    }

    private final Runnable C0() {
        q compareAndSet;
        AtomicReferenceFieldUpdater field;
        kotlinx.coroutines.internal.z zVar;
        final Object _queue = this._queue;
        int i = 0;
        while (_queue == null) {
            _queue = this._queue;
            i = 0;
            Objects.requireNonNull(_queue, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
            Object obj = _queue;
            Object obj2 = (q)obj.j();
            j1.w.compareAndSet(this, _queue, obj.i());
        }
        return i;
    }

    private final boolean I0(Runnable runnable) {
        boolean compareAndSet;
        int i;
        int qVar;
        Object obj;
        int i2;
        compareAndSet = this._queue;
        qVar = 0;
        while (J0()) {
            i = 1;
            qVar = new q(8, i);
            Objects.requireNonNull(compareAndSet, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
            qVar.a((Runnable)compareAndSet);
            qVar.a(runnable);
            compareAndSet = this._queue;
            qVar = 0;
            Objects.requireNonNull(compareAndSet, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
            obj = compareAndSet;
            i2 = (q)obj.a(runnable);
            j1.w.compareAndSet(this, compareAndSet, obj.i());
        }
        return qVar;
    }

    private final boolean J0() {
        return this._isCompleted;
    }

    private final void Q0() {
        long nanoTime;
        f0 f0Var;
        kotlinx.coroutines.d dVar = e.a();
        if (dVar == null) {
            nanoTime = System.nanoTime();
        } else {
            nanoTime = dVar.a();
        }
        Object _delayed = this._delayed;
        while ((j1.d)_delayed == null) {
            f0Var = 0;
            if (f0Var != null) {
            }
            t0(nanoTime, obj1);
            _delayed = this._delayed;
            f0Var = (j1.d)(j1.d)_delayed.i();
        }
    }

    private final int b1(long l, kotlinx.coroutines.j1.c j1$c2) {
        Object _delayed;
        int i;
        kotlinx.coroutines.j1.d dVar;
        if (J0()) {
            return 1;
        }
        if ((j1.d)this._delayed == null) {
            dVar = new j1.d(l, c2);
            j1.x.compareAndSet(this, 0, dVar);
            n.d(this._delayed);
        }
        return obj6.j(l, c2, _delayed);
    }

    private final void g1(boolean z) {
        this._isCompleted = z;
    }

    private final boolean i1(kotlinx.coroutines.j1.c j1$c) {
        int i;
        int obj2;
        Object _delayed = this._delayed;
        if ((j1.d)_delayed == null) {
            i = 0;
        } else {
            i = (j1.d)_delayed.e();
        }
        obj2 = i == c ? 1 : 0;
        return obj2;
    }

    public static final boolean z0(kotlinx.coroutines.j1 j1) {
        return j1.J0();
    }

    @Override // kotlinx.coroutines.k1
    public final void G0(Runnable runnable) {
        boolean z;
        if (I0(runnable)) {
            v0();
        } else {
            s0.y.G0(runnable);
        }
    }

    @Override // kotlinx.coroutines.k1
    public final void K(g g, Runnable runnable2) {
        G0(runnable2);
    }

    @Override // kotlinx.coroutines.k1
    protected boolean L0() {
        Object _delayed;
        int i;
        kotlinx.coroutines.internal.z zVar;
        i = 0;
        if (!j0()) {
            return i;
        }
        _delayed = this._delayed;
        if (_delayed != null && !(j1.d)_delayed.d()) {
            if (!_delayed.d()) {
                return i;
            }
        }
        Object _queue = this._queue;
        if (_queue == null) {
            i = i2;
        } else {
        }
        return i;
    }

    @Override // kotlinx.coroutines.k1
    public long N0() {
        long nanoTime;
        int i3;
        int i;
        boolean z;
        int i2;
        final int i4 = 0;
        if (l0()) {
            return i4;
        }
        Object _delayed = this._delayed;
        if (_delayed != null && !(j1.d)_delayed.d()) {
            if (!_delayed.d()) {
                kotlinx.coroutines.d dVar = e.a();
                if (dVar == null) {
                    nanoTime = System.nanoTime();
                } else {
                    nanoTime = dVar.a();
                }
                i3 = _delayed.b();
                i = 0;
                synchronized (_delayed) {
                }
                if ((j1.c)i != 0) {
                }
            }
        }
        Runnable runnable = C0();
        if (runnable != null) {
            runnable.run();
            return i4;
        }
        return V();
    }

    @Override // kotlinx.coroutines.k1
    protected long V() {
        Object _queue;
        f0 f0Var;
        boolean z;
        long nanoTime;
        final int i2 = 0;
        if (Long.compare(l, i2) == 0) {
            return i2;
        }
        _queue = this._queue;
        long l4 = Long.MAX_VALUE;
        if (_queue == null) {
            Object _delayed = this._delayed;
            if ((j1.d)_delayed == null) {
                f0Var = 0;
            } else {
                f0Var = (j1.d)_delayed.e();
            }
            if (f0Var == null) {
                return l4;
            }
            kotlinx.coroutines.d dVar = e.a();
            if (dVar == null) {
                nanoTime = System.nanoTime();
            } else {
                nanoTime = dVar.a();
            }
            return g.c(l2 -= nanoTime, z);
        } else {
            if (_queue instanceof q && !(q)_queue.g()) {
                if (!(q)_queue.g()) {
                    return i2;
                }
            }
        }
        if (_queue == m1.a()) {
            return l4;
        }
        return i2;
    }

    @Override // kotlinx.coroutines.k1
    protected final void V0() {
        final int i = 0;
        this._queue = i;
        this._delayed = i;
    }

    @Override // kotlinx.coroutines.k1
    public final void a1(long l, kotlinx.coroutines.j1.c j1$c2) {
        int i;
        boolean obj3;
        final int i2 = b1(l, c2);
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                } else {
                }
                obj3 = new IllegalStateException("unexpected result".toString());
                throw obj3;
            }
            t0(l, c2);
        } else {
            if (i1(obj5)) {
                v0();
            }
        }
    }

    @Override // kotlinx.coroutines.k1
    protected final kotlinx.coroutines.e1 e1(long l, Runnable runnable2) {
        long nanoTime;
        Object bVar;
        long obj4;
        obj4 = m1.c(l);
        if (Long.compare(obj4, l2) < 0) {
            kotlinx.coroutines.d dVar = e.a();
            if (dVar == null) {
                nanoTime = System.nanoTime();
            } else {
                nanoTime = dVar.a();
            }
            bVar = new j1.b(obj4 += nanoTime, runnable2, obj6);
            a1(nanoTime, obj1);
        } else {
            bVar = l2.a;
        }
        return bVar;
    }

    public void j(long l, kotlinx.coroutines.p<? super w> p2) {
        long nanoTime;
        kotlinx.coroutines.j1.a aVar;
        long obj4;
        obj4 = m1.c(l);
        if (Long.compare(obj4, l2) < 0) {
            kotlinx.coroutines.d dVar = e.a();
            if (dVar == null) {
                nanoTime = System.nanoTime();
            } else {
                nanoTime = dVar.a();
            }
            aVar = new j1.a(this, obj4 += nanoTime, p2, obj6);
            s.a(obj6, aVar);
            a1(nanoTime, obj1);
        }
    }

    @Override // kotlinx.coroutines.k1
    protected void shutdown() {
        int cmp;
        int i;
        u2.a.b();
        g1(true);
        A0();
        while (Long.compare(l, i) <= 0) {
        }
        Q0();
    }

    @Override // kotlinx.coroutines.k1
    public kotlinx.coroutines.e1 x(long l, Runnable runnable2, g g3) {
        return w0.a.a(this, l, runnable2, g3);
    }
}
