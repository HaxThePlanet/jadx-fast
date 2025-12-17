package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\n\u0008\u0001\u0010\u0002 \u0000*\u0002H\u00012\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ\r\u0010\u000b\u001a\u00020\u000cH\u0010¢\u0006\u0002\u0008\rJ\u0008\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lkotlinx/coroutines/TimeoutCoroutine;", "U", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "time", "", "uCont", "Lkotlin/coroutines/Continuation;", "(JLkotlin/coroutines/Continuation;)V", "nameString", "", "nameString$kotlinx_coroutines_core", "run", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TimeoutCoroutine<U, T extends U>  extends ScopeCoroutine<T> implements Runnable {

    public final long time;
    public TimeoutCoroutine(long time, Continuation<? super U> uCont) {
        super(obj4.getContext(), obj4);
        this.time = time;
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine
    public String nameString$kotlinx_coroutines_core() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(super.nameString$kotlinx_coroutines_core()).append("(timeMillis=").append(this.time).append(')').toString();
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine
    public void run() {
        cancelCoroutine((Throwable)TimeoutKt.TimeoutCancellationException(this.time, obj1, DelayKt.getDelay(getContext())));
    }
}
