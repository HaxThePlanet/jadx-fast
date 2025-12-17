package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007B\r\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0013\u0010\u0017\u001a\u00020\u00062\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0006\u0010\u0018\u001a\u00020\u0006R\t\u0010\u000b\u001a\u00020\u000cX\u0082\u0004R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lkotlinx/coroutines/ThreadState;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "job", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "_state", "Lkotlinx/atomicfu/AtomicInt;", "cancelHandle", "Lkotlinx/coroutines/DisposableHandle;", "targetThread", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "clearInterrupt", "invalidState", "", "state", "", "invoke", "setup", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ThreadState implements Function1<Throwable, Unit> {

    private static final AtomicIntegerFieldUpdater _state$FU;
    @Volatile
    private volatile int _state;
    private kotlinx.coroutines.DisposableHandle cancelHandle;
    private final kotlinx.coroutines.Job job;
    private final Thread targetThread;
    static {
        ThreadState._state$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state");
    }

    public ThreadState(kotlinx.coroutines.Job job) {
        super();
        this.job = job;
        this.targetThread = Thread.currentThread();
    }

    private final Void invalidState(int state) {
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Illegal state ").append(state).toString().toString());
        throw illegalStateException;
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function12, Object object3) {
        Integer valueOf;
        final int i = 0;
        while (true) {
            function12.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(object3)));
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final void clearInterrupt() {
        int i;
        int i3;
        boolean compareAndSet;
        int i2;
        final Object obj = this;
        final int i4 = 0;
        while (/* condition */) {
            i = ThreadState._state$FU.get(this);
            i3 = 0;
        }
        invalidState(i);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object p1) {
        invoke((Throwable)p1);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public void invoke(Throwable cause) {
        int i;
        int i3;
        boolean compareAndSet;
        int i2;
        final Object obj = this;
        final int i4 = 0;
        while (/* condition */) {
            i = ThreadState._state$FU.get(this);
            i3 = 0;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final void setup() {
        int i2;
        int i;
        boolean compareAndSet;
        int i3;
        int i4 = 1;
        this.cancelHandle = this.job.invokeOnCompletion(i4, i4, (Function1)this);
        Object obj = this;
        int i5 = 0;
        while (/* condition */) {
            i2 = ThreadState._state$FU.get(this);
            i = 0;
        }
        invalidState(i2);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }
}
