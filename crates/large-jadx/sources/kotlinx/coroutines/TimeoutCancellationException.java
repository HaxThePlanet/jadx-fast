package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00060\u0001j\u0002`\u00022\u0008\u0012\u0004\u0012\u00020\u00000\u0003B\u000f\u0008\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\u0008\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\n\u0010\n\u001a\u0004\u0018\u00010\u0000H\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00088\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "message", "", "(Ljava/lang/String;)V", "coroutine", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "createCopy", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TimeoutCancellationException extends CancellationException implements kotlinx.coroutines.f0<kotlinx.coroutines.TimeoutCancellationException> {

    public final kotlinx.coroutines.y1 coroutine;
    public TimeoutCancellationException(String string) {
        super(string, 0);
    }

    public TimeoutCancellationException(String string, kotlinx.coroutines.y1 y12) {
        super(string);
        this.coroutine = y12;
    }

    @Override // java.util.concurrent.CancellationException
    public Throwable a() {
        return b();
    }

    @Override // java.util.concurrent.CancellationException
    public kotlinx.coroutines.TimeoutCancellationException b() {
        String message;
        if (getMessage() == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.coroutine);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }
}
