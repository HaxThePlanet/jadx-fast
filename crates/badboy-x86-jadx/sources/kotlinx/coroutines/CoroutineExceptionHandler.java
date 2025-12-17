package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\u0008f\u0018\u0000 \u00082\u00020\u0001:\u0001\u0008J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t", d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CoroutineExceptionHandler extends CoroutineContext.Element {

    public static final kotlinx.coroutines.CoroutineExceptionHandler.Key Key;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(kotlinx.coroutines.CoroutineExceptionHandler $this, R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)$this, initial, operation);
        }

        public static <E extends CoroutineContext.Element> E get(kotlinx.coroutines.CoroutineExceptionHandler $this, CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.get((CoroutineContext.Element)$this, key);
        }

        public static CoroutineContext minusKey(kotlinx.coroutines.CoroutineExceptionHandler $this, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey((CoroutineContext.Element)$this, key);
        }

        public static CoroutineContext plus(kotlinx.coroutines.CoroutineExceptionHandler $this, CoroutineContext context) {
            return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)$this, context);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<kotlinx.coroutines.CoroutineExceptionHandler> {

        static final kotlinx.coroutines.CoroutineExceptionHandler.Key $$INSTANCE;
        static {
            CoroutineExceptionHandler.Key key = new CoroutineExceptionHandler.Key();
            CoroutineExceptionHandler.Key.$$INSTANCE = key;
        }
    }
    static {
        CoroutineExceptionHandler.Key = CoroutineExceptionHandler.Key.$$INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext$Element
    public abstract void handleException(CoroutineContext coroutineContext, Throwable throwable2);
}
