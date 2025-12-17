package kotlinx.coroutines;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.g;
import kotlin.j0.i;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0000\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class i0 {

    private static final List<kotlinx.coroutines.CoroutineExceptionHandler> a;
    static {
        i0.a = i.A(i.a(a.a()));
    }

    public static final void a(g g, Throwable throwable2) {
        Object next;
        Thread currentThread;
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Iterator iterator = i0.a.iterator();
        for (CoroutineExceptionHandler next : iterator) {
            next.handleException(g, throwable2);
        }
        final Thread obj4 = Thread.currentThread();
        obj4.getUncaughtExceptionHandler().uncaughtException(obj4, throwable2);
    }
}
