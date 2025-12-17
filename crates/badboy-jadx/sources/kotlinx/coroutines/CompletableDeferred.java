package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0003\n\u0000\u0008f\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\tH&¨\u0006\n", d2 = {"Lkotlinx/coroutines/CompletableDeferred;", "T", "Lkotlinx/coroutines/Deferred;", "complete", "", "value", "(Ljava/lang/Object;)Z", "completeExceptionally", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CompletableDeferred<T>  extends kotlinx.coroutines.Deferred<T> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static void cancel(kotlinx.coroutines.CompletableDeferred $this) {
            Deferred.DefaultImpls.cancel((Deferred)$this);
        }

        public static <T, R> R fold(kotlinx.coroutines.CompletableDeferred<T> $this, R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return Deferred.DefaultImpls.fold((Deferred)$this, initial, operation);
        }

        public static <T, E extends CoroutineContext.Element> E get(kotlinx.coroutines.CompletableDeferred<T> $this, CoroutineContext.Key<E> key) {
            return Deferred.DefaultImpls.get((Deferred)$this, key);
        }

        public static <T> CoroutineContext minusKey(kotlinx.coroutines.CompletableDeferred<T> $this, CoroutineContext.Key<?> key) {
            return Deferred.DefaultImpls.minusKey((Deferred)$this, key);
        }

        public static <T> CoroutineContext plus(kotlinx.coroutines.CompletableDeferred<T> $this, CoroutineContext context) {
            return Deferred.DefaultImpls.plus((Deferred)$this, context);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static <T> kotlinx.coroutines.Job plus(kotlinx.coroutines.CompletableDeferred<T> $this, kotlinx.coroutines.Job other) {
            return Deferred.DefaultImpls.plus((Deferred)$this, other);
        }
    }
    public abstract boolean complete(T t);

    @Override // kotlinx.coroutines.Deferred
    public abstract boolean completeExceptionally(Throwable throwable);
}
