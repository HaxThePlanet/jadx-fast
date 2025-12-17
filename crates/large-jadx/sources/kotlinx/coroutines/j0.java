package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b;
import kotlin.b0.g;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u001a%\u0010\u0000\u001a\u00020\u00012\u001a\u0008\u0004\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0086\u0008\u001a\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\u0005H\u0000¨\u0006\r", d2 = {"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class j0 {
    public static final void a(g g, Throwable throwable2) {
        try {
            kotlin.b0.g.b bVar = g.get(CoroutineExceptionHandler.r);
            if ((CoroutineExceptionHandler)bVar == null) {
            }
            i0.a(g, throwable2);
            (CoroutineExceptionHandler)bVar.handleException(g, throwable2);
            throwable2 = j0.b(throwable2, th);
            i0.a(g, throwable2);
        }
    }

    public static final Throwable b(Throwable throwable, Throwable throwable2) {
        if (throwable == throwable2) {
            return throwable;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", throwable2);
        b.a(runtimeException, throwable);
        return runtimeException;
    }
}
