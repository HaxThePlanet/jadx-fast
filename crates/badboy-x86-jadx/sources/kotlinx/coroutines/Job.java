package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.selects.SelectClause0;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008f\u0018\u0000 -2\u00020\u0001:\u0001-J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H'J\u0008\u0010\u0018\u001a\u00020\u0019H\u0017J\u0014\u0010\u0018\u001a\u00020\u00072\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH'J\u001a\u0010\u0018\u001a\u00020\u00192\u0010\u0008\u0002\u0010\u001a\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dH&J\u000c\u0010\u001e\u001a\u00060\u001cj\u0002`\u001dH'JE\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\u00072\u0008\u0008\u0002\u0010\"\u001a\u00020\u00072'\u0010#\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\u000c\u0008%\u0012\u0008\u0008&\u0012\u0004\u0008\u0008(\u001a\u0012\u0004\u0012\u00020\u00190$j\u0002`'H'J1\u0010\u001f\u001a\u00020 2'\u0010#\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\u000c\u0008%\u0012\u0008\u0008&\u0012\u0004\u0008\u0008(\u001a\u0012\u0004\u0012\u00020\u00190$j\u0002`'H&J\u0011\u0010(\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0011\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0000H\u0097\u0002J\u0008\u0010,\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0008R\u0012\u0010\t\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0008R\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0008R\u0012\u0010\u000b\u001a\u00020\u000cX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00008&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0010\u0010\u0011\u001a\u0004\u0008\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006.", d2 = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parent", "getParent$annotations", "()V", "getParent", "()Lkotlinx/coroutines/Job;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Job extends CoroutineContext.Element {

    public static final kotlinx.coroutines.Job.Key Key;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static void cancel(kotlinx.coroutines.Job $this) {
            $this.cancel(0);
        }

        public static void cancel$default(kotlinx.coroutines.Job job, CancellationException cancellationException2, int i3, Object object4) {
            int obj1;
            if (object4 != null) {
            } else {
                if (i3 &= 1 != 0) {
                    obj1 = 0;
                }
                job.cancel(obj1);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            throw obj0;
        }

        public static boolean cancel$default(kotlinx.coroutines.Job job, Throwable throwable2, int i3, Object object4) {
            int obj1;
            if (object4 != null) {
            } else {
                if (i3 &= 1 != 0) {
                    obj1 = 0;
                }
                return job.cancel(obj1);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            throw obj0;
        }

        public static <R> R fold(kotlinx.coroutines.Job $this, R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            return CoroutineContext.Element.DefaultImpls.fold((CoroutineContext.Element)$this, initial, operation);
        }

        public static <E extends CoroutineContext.Element> E get(kotlinx.coroutines.Job $this, CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.get((CoroutineContext.Element)$this, key);
        }

        public static void getParent$annotations() {
        }

        public static kotlinx.coroutines.DisposableHandle invokeOnCompletion$default(kotlinx.coroutines.Job job, boolean z2, boolean z3, Function1 function14, int i5, Object object6) {
            int obj1;
            int obj2;
            if (object6 != null) {
            } else {
                if (i5 & 1 != 0) {
                    obj1 = 0;
                }
                if (i5 &= 2 != 0) {
                    obj2 = 1;
                }
                return job.invokeOnCompletion(obj1, obj2, function14);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            throw obj0;
        }

        public static CoroutineContext minusKey(kotlinx.coroutines.Job $this, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey((CoroutineContext.Element)$this, key);
        }

        public static CoroutineContext plus(kotlinx.coroutines.Job $this, CoroutineContext context) {
            return CoroutineContext.Element.DefaultImpls.plus((CoroutineContext.Element)$this, context);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static kotlinx.coroutines.Job plus(kotlinx.coroutines.Job $this, kotlinx.coroutines.Job other) {
            return other;
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<kotlinx.coroutines.Job> {

        static final kotlinx.coroutines.Job.Key $$INSTANCE;
        static {
            Job.Key key = new Job.Key();
            Job.Key.$$INSTANCE = key;
        }
    }
    static {
        Job.Key = Job.Key.$$INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext$Element
    public abstract kotlinx.coroutines.ChildHandle attachChild(kotlinx.coroutines.ChildJob childJob);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public abstract void cancel();

    @Override // kotlin.coroutines.CoroutineContext$Element
    public abstract void cancel(CancellationException cancellationException);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public abstract boolean cancel(Throwable throwable);

    @Override // kotlin.coroutines.CoroutineContext$Element
    public abstract CancellationException getCancellationException();

    public abstract Sequence<kotlinx.coroutines.Job> getChildren();

    @Override // kotlin.coroutines.CoroutineContext$Element
    public abstract SelectClause0 getOnJoin();

    @Override // kotlin.coroutines.CoroutineContext$Element
    public abstract kotlinx.coroutines.Job getParent();

    public abstract kotlinx.coroutines.DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> function1);

    public abstract kotlinx.coroutines.DisposableHandle invokeOnCompletion(boolean z, boolean z2, Function1<? super Throwable, Unit> function13);

    @Override // kotlin.coroutines.CoroutineContext$Element
    public abstract boolean isActive();

    @Override // kotlin.coroutines.CoroutineContext$Element
    public abstract boolean isCancelled();

    @Override // kotlin.coroutines.CoroutineContext$Element
    public abstract boolean isCompleted();

    public abstract Object join(Continuation<? super Unit> continuation);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public abstract kotlinx.coroutines.Job plus(kotlinx.coroutines.Job job);

    @Override // kotlin.coroutines.CoroutineContext$Element
    public abstract boolean start();
}
