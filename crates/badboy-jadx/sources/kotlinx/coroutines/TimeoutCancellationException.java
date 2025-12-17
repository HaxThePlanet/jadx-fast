package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00060\u0001j\u0002`\u00022\u0008\u0012\u0004\u0012\u00020\u00000\u0003B\u000f\u0008\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\u0008\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\n\u001a\u00020\u0000H\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00088\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "(Ljava/lang/String;)V", "coroutine", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "createCopy", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimeoutCancellationException extends CancellationException implements kotlinx.coroutines.CopyableThrowable<kotlinx.coroutines.TimeoutCancellationException> {

    public final transient kotlinx.coroutines.Job coroutine;
    public TimeoutCancellationException(String message) {
        super(message, 0);
    }

    public TimeoutCancellationException(String message, kotlinx.coroutines.Job coroutine) {
        super(message);
        this.coroutine = coroutine;
    }

    @Override // java.util.concurrent.CancellationException
    public Throwable createCopy() {
        return (Throwable)createCopy();
    }

    @Override // java.util.concurrent.CancellationException
    public kotlinx.coroutines.TimeoutCancellationException createCopy() {
        String message;
        if (getMessage() == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.coroutine);
        int i = 0;
        timeoutCancellationException.initCause((Throwable)this);
        return timeoutCancellationException;
    }
}
