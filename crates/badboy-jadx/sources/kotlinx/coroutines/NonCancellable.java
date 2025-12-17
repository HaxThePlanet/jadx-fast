package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.selects.SelectClause0;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Æ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017J\u0012\u0010 \u001a\u00020\n2\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u0018\u0010 \u001a\u00020#2\u000e\u0010!\u001a\n\u0018\u00010$j\u0004\u0018\u0001`%H\u0017J\u000c\u0010&\u001a\u00060$j\u0002`%H\u0017JA\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2'\u0010+\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\"¢\u0006\u000c\u0008-\u0012\u0008\u0008.\u0012\u0004\u0008\u0008(!\u0012\u0004\u0012\u00020#0,j\u0002`/H\u0017J1\u0010'\u001a\u00020(2'\u0010+\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\"¢\u0006\u000c\u0008-\u0012\u0008\u0008.\u0012\u0004\u0008\u0008(!\u0012\u0004\u0012\u00020#0,j\u0002`/H\u0017J\u0011\u00100\u001a\u00020#H\u0097@ø\u0001\u0000¢\u0006\u0002\u00101J\u0008\u00102\u001a\u00020\nH\u0017J\u0008\u00103\u001a\u00020\u0012H\u0016R \u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00058VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0006\u0010\u0003\u001a\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u00020\n8VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u000b\u0010\u0003\u001a\u0004\u0008\t\u0010\u000cR\u001a\u0010\r\u001a\u00020\n8VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\u0003\u001a\u0004\u0008\r\u0010\u000cR\u001a\u0010\u000f\u001a\u00020\n8VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0010\u0010\u0003\u001a\u0004\u0008\u000f\u0010\u000cR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u00148VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0015\u0010\u0003\u001a\u0004\u0008\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0019\u0010\u0003\u001a\u0004\u0008\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00064", d2 = {"Lkotlinx/coroutines/NonCancellable;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/Job;", "()V", "children", "Lkotlin/sequences/Sequence;", "getChildren$annotations", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "isActive$annotations", "()Z", "isCancelled", "isCancelled$annotations", "isCompleted", "isCompleted$annotations", "message", "", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parent", "getParent$annotations", "getParent", "()Lkotlinx/coroutines/Job;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "cause", "", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NonCancellable extends AbstractCoroutineContextElement implements kotlinx.coroutines.Job {

    public static final kotlinx.coroutines.NonCancellable INSTANCE = null;
    private static final String message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited";
    static {
        NonCancellable nonCancellable = new NonCancellable();
        NonCancellable.INSTANCE = nonCancellable;
    }

    private NonCancellable() {
        super((CoroutineContext.Key)Job.Key);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static void getChildren$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static void getOnJoin$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static void getParent$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static void isActive$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static void isCancelled$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public static void isCompleted$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public kotlinx.coroutines.ChildHandle attachChild(kotlinx.coroutines.ChildJob child) {
        return (ChildHandle)NonDisposableHandle.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public void cancel() {
        Job.DefaultImpls.cancel(this);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public void cancel(CancellationException cause) {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public boolean cancel(Throwable cause) {
        return 0;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public CancellationException getCancellationException() {
        IllegalStateException illegalStateException = new IllegalStateException("This job is always active");
        throw illegalStateException;
    }

    public Sequence<kotlinx.coroutines.Job> getChildren() {
        return SequencesKt.emptySequence();
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public SelectClause0 getOnJoin() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("This job is always active");
        throw unsupportedOperationException;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public kotlinx.coroutines.Job getParent() {
        return null;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public kotlinx.coroutines.DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> handler) {
        return (DisposableHandle)NonDisposableHandle.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public kotlinx.coroutines.DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler) {
        return (DisposableHandle)NonDisposableHandle.INSTANCE;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public boolean isActive() {
        return 1;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public boolean isCancelled() {
        return 0;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public boolean isCompleted() {
        return 0;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public Object join(Continuation<? super Unit> $completion) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("This job is always active");
        throw unsupportedOperationException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public kotlinx.coroutines.Job plus(kotlinx.coroutines.Job other) {
        return Job.DefaultImpls.plus(this, other);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited")
    public boolean start() {
        return 0;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement
    public String toString() {
        return "NonCancellable";
    }
}
