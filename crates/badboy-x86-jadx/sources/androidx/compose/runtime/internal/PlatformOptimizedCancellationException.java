package androidx.compose.runtime.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0000\u0008 \u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"Landroidx/compose/runtime/internal/PlatformOptimizedCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "(Ljava/lang/String;)V", "fillInStackTrace", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PlatformOptimizedCancellationException extends CancellationException {

    public static final int $stable;
    static {
    }

    public PlatformOptimizedCancellationException() {
        final int i = 0;
        super(i, 1, i);
    }

    public PlatformOptimizedCancellationException(String message) {
        super(message);
    }

    public PlatformOptimizedCancellationException(String string, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    @Override // java.util.concurrent.CancellationException
    public Throwable fillInStackTrace() {
        int i = 0;
        setStackTrace(new StackTraceElement[0]);
        return (Throwable)this;
    }
}
