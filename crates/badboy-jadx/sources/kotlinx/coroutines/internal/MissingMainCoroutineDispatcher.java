package kotlinx.coroutines.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Delay.DefaultImpls;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0008\u0010\u001c\u001a\u00020\u000cH\u0002J\u001e\u0010\u001d\u001a\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\u00152\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u0008\u0010!\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006\"", d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "", "limitedParallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {

    private final Throwable cause;
    private final String errorHint;
    public MissingMainCoroutineDispatcher(Throwable cause, String errorHint) {
        super();
        this.cause = cause;
        this.errorHint = errorHint;
    }

    public MissingMainCoroutineDispatcher(Throwable throwable, String string2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(throwable, obj2);
    }

    private final Void missing() {
        String it;
        int i;
        StringBuilder append;
        String str;
        if (this.cause == null) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            it = this.errorHint;
            i = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            if (it != null && stringBuilder2.append(". ").append(it).toString() == null) {
                i = 0;
                stringBuilder2 = new StringBuilder();
                if (stringBuilder2.append(". ").append(it).toString() != null) {
                } else {
                    it = "";
                }
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Module with the Main dispatcher had failed to initialize").append(it).toString(), this.cause);
            throw illegalStateException;
        }
        MainDispatchersKt.throwMissingMainDispatcherException();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long time, Continuation<? super Unit> $completion) {
        return Delay.DefaultImpls.delay(this, time, $completion);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public Void dispatch(CoroutineContext context, Runnable block) {
        missing();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public void dispatch(CoroutineContext context, Runnable block) {
        dispatch(context, block);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public MainCoroutineDispatcher getImmediate() {
        return (MainCoroutineDispatcher)this;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public DisposableHandle invokeOnTimeout(long timeMillis, Runnable block, CoroutineContext context) {
        missing();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext context) {
        missing();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int parallelism) {
        missing();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public Void scheduleResumeAfterDelay(long timeMillis, CancellableContinuation<? super Unit> continuation) {
        missing();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public void scheduleResumeAfterDelay(long timeMillis, CancellableContinuation continuation) {
        scheduleResumeAfterDelay(timeMillis, continuation);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public String toString() {
        String string;
        Throwable cause;
        StringBuilder stringBuilder = new StringBuilder();
        if (this.cause != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            string = stringBuilder2.append(", cause=").append(this.cause).toString();
        } else {
            string = "";
        }
        return stringBuilder.append("Dispatchers.Main[missing").append(string).append(']').toString();
    }
}
