package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0003\n\u0000\u0008f\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u00020\u0002J\u0011\u0010\u0007\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0008J\r\u0010\t\u001a\u00028\u0000H'¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\u000cH'R\u0018\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\r", d2 = {"Lkotlinx/coroutines/Deferred;", "T", "Lkotlinx/coroutines/Job;", "onAwait", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "getCompletionExceptionOrNull", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Deferred<T>  extends kotlinx.coroutines.Job {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static void cancel(kotlinx.coroutines.Deferred $this) {
            Job.DefaultImpls.cancel((Job)$this);
        }

        public static <T, R> R fold(kotlinx.coroutines.Deferred<? extends T> $this, R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return Job.DefaultImpls.fold((Job)$this, initial, operation);
        }

        public static <T, E extends CoroutineContext.Element> E get(kotlinx.coroutines.Deferred<? extends T> $this, CoroutineContext.Key<E> key) {
            return Job.DefaultImpls.get((Job)$this, key);
        }

        public static <T> CoroutineContext minusKey(kotlinx.coroutines.Deferred<? extends T> $this, CoroutineContext.Key<?> key) {
            return Job.DefaultImpls.minusKey((Job)$this, key);
        }

        public static <T> CoroutineContext plus(kotlinx.coroutines.Deferred<? extends T> $this, CoroutineContext context) {
            return Job.DefaultImpls.plus((Job)$this, context);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static <T> kotlinx.coroutines.Job plus(kotlinx.coroutines.Deferred<? extends T> $this, kotlinx.coroutines.Job other) {
            return Job.DefaultImpls.plus((Job)$this, other);
        }
    }
    public abstract Object await(Continuation<? super T> continuation);

    public abstract T getCompleted();

    @Override // kotlinx.coroutines.Job
    public abstract Throwable getCompletionExceptionOrNull();

    public abstract SelectClause1<T> getOnAwait();
}
