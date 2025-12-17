package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008g\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006", d2 = {"Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/Job;", "parentCancelled", "", "parentJob", "Lkotlinx/coroutines/ParentJob;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ChildJob extends kotlinx.coroutines.Job {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static void cancel(kotlinx.coroutines.ChildJob $this) {
            Job.DefaultImpls.cancel((Job)$this);
        }

        public static <R> R fold(kotlinx.coroutines.ChildJob $this, R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return Job.DefaultImpls.fold((Job)$this, initial, operation);
        }

        public static <E extends CoroutineContext.Element> E get(kotlinx.coroutines.ChildJob $this, CoroutineContext.Key<E> key) {
            return Job.DefaultImpls.get((Job)$this, key);
        }

        public static CoroutineContext minusKey(kotlinx.coroutines.ChildJob $this, CoroutineContext.Key<?> key) {
            return Job.DefaultImpls.minusKey((Job)$this, key);
        }

        public static CoroutineContext plus(kotlinx.coroutines.ChildJob $this, CoroutineContext context) {
            return Job.DefaultImpls.plus((Job)$this, context);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static kotlinx.coroutines.Job plus(kotlinx.coroutines.ChildJob $this, kotlinx.coroutines.Job other) {
            return Job.DefaultImpls.plus((Job)$this, other);
        }
    }
    @Override // kotlinx.coroutines.Job
    public abstract void parentCancelled(kotlinx.coroutines.ParentJob parentJob);
}
