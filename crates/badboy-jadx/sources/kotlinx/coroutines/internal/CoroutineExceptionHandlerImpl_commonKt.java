package kotlinx.coroutines.internal;

import java.util.Collection;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006", d2 = {"handleUncaughtCoroutineException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoroutineExceptionHandlerImpl_commonKt {
    public static final void handleUncaughtCoroutineException(CoroutineContext context, Throwable exception) {
        kotlinx.coroutines.internal.DiagnosticCoroutineContextException diagnosticCoroutineContextException;
        Object next;
        Throwable th;
        Throwable handlerException;
        Iterator iterator = CoroutineExceptionHandlerImplKt.getPlatformExceptionHandlers().iterator();
        for (CoroutineExceptionHandler next : iterator) {
            next.handleException(context, exception);
        }
        diagnosticCoroutineContextException = new DiagnosticCoroutineContextException(context);
        ExceptionsKt.addSuppressed(exception, (Throwable)diagnosticCoroutineContextException);
        CoroutineExceptionHandlerImplKt.propagateExceptionFinalResort(exception);
    }
}
