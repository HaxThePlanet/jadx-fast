package kotlin.coroutines.cancellation;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a!\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0087\u0008\u001a\u0017\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0087\u0008*\u001a\u0008\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t¨\u0006\n", d2 = {"CancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", "message", "", "cause", "", "Lkotlin/SinceKotlin;", "version", "1.4", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CancellationExceptionKt {
    private static final CancellationException CancellationException(String message, Throwable cause) {
        CancellationException cancellationException = new CancellationException(message);
        final int i = 0;
        cancellationException.initCause(cause);
        return cancellationException;
    }

    private static final CancellationException CancellationException(Throwable cause) {
        String string;
        if (cause != null) {
            string = cause.toString();
        } else {
            string = 0;
        }
        CancellationException cancellationException = new CancellationException(string);
        final int i = 0;
        cancellationException.initCause(cause);
        return cancellationException;
    }

    public static void CancellationException$annotations() {
    }
}
