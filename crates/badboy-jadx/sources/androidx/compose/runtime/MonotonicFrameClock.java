package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008f\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ7\u0010\u0006\u001a\u0002H\u0007\"\u0004\u0008\u0000\u0010\u00072!\u0010\u0008\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u0002H\u00070\tH¦@¢\u0006\u0002\u0010\u000eR\u0018\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0010À\u0006\u0003", d2 = {"Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Key", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MonotonicFrameClock extends CoroutineContext.Element {

    public static final androidx.compose.runtime.MonotonicFrameClock.Key Key;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R fold(androidx.compose.runtime.MonotonicFrameClock $this, R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)$this, initial, operation);
        }

        public static <E extends CoroutineContext.Element> E get(androidx.compose.runtime.MonotonicFrameClock $this, CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.get((CoroutineContext.Element)$this, key);
        }

        @Deprecated
        public static CoroutineContext.Key<?> getKey(androidx.compose.runtime.MonotonicFrameClock $this) {
            return MonotonicFrameClock.access$getKey$jd($this);
        }

        public static CoroutineContext minusKey(androidx.compose.runtime.MonotonicFrameClock $this, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey((CoroutineContext.Element)$this, key);
        }

        public static CoroutineContext plus(androidx.compose.runtime.MonotonicFrameClock $this, CoroutineContext context) {
            return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)$this, context);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/runtime/MonotonicFrameClock$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/runtime/MonotonicFrameClock;", "()V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<androidx.compose.runtime.MonotonicFrameClock> {

        static final androidx.compose.runtime.MonotonicFrameClock.Key $$INSTANCE;
        static {
            MonotonicFrameClock.Key key = new MonotonicFrameClock.Key();
            MonotonicFrameClock.Key.$$INSTANCE = key;
        }
    }
    static {
        MonotonicFrameClock.Key = MonotonicFrameClock.Key.$$INSTANCE;
    }

    public static CoroutineContext.Key access$getKey$jd(androidx.compose.runtime.MonotonicFrameClock $this) {
        return super.getKey();
    }

    public CoroutineContext.Key<?> getKey() {
        return (CoroutineContext.Key)MonotonicFrameClock.Key;
    }

    public abstract <R> Object withFrameNanos(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation2);
}
