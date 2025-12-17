package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.g;
import kotlin.b0.g.b;
import kotlin.b0.g.c;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\u0008f\u0018\u0000 \u00082\u00020\u0001:\u0001\u0008J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t", d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface CoroutineExceptionHandler extends g.b {

    public static final kotlinx.coroutines.CoroutineExceptionHandler.a r;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements g.c<kotlinx.coroutines.CoroutineExceptionHandler> {

        static final kotlinx.coroutines.CoroutineExceptionHandler.a a;
        static {
            CoroutineExceptionHandler.a aVar = new CoroutineExceptionHandler.a();
            CoroutineExceptionHandler.a.a = aVar;
        }
    }
    static {
        CoroutineExceptionHandler.r = CoroutineExceptionHandler.a.a;
    }

    @Override // kotlin.b0.g$b
    public abstract void handleException(g g, Throwable throwable2);
}
