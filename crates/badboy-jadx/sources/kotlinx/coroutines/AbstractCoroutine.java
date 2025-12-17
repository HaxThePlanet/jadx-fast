package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\u0008\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0008\u0010\u0019\u001a\u00020\u001aH\u0014J\u0015\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\u0008\u001eJ\r\u0010\u001f\u001a\u00020\u001aH\u0010¢\u0006\u0002\u0008 J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\tH\u0014J\u0015\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010&J\u0012\u0010'\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0004J\u001c\u0010(\u001a\u00020\u00162\u000c\u0010)\u001a\u0008\u0012\u0004\u0012\u00028\u00000*ø\u0001\u0000¢\u0006\u0002\u0010&JM\u0010+\u001a\u00020\u0016\"\u0004\u0008\u0001\u0010,2\u0006\u0010+\u001a\u00020-2\u0006\u0010.\u001a\u0002H,2'\u0010/\u001a#\u0008\u0001\u0012\u0004\u0012\u0002H,\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001800¢\u0006\u0002\u00081ø\u0001\u0000¢\u0006\u0002\u00102R\u0017\u0010\u000c\u001a\u00020\u0007¢\u0006\u000e\n\u0000\u0012\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00063", d2 = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "initParentJob", "", "active", "(Lkotlin/coroutines/CoroutineContext;ZZ)V", "context", "getContext$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", "", "state", "", "cancellationExceptionMessage", "", "handleOnCompletionException", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractCoroutine<T>  extends kotlinx.coroutines.JobSupport implements kotlinx.coroutines.Job, Continuation<T>, kotlinx.coroutines.CoroutineScope {

    private final CoroutineContext context;
    public AbstractCoroutine(CoroutineContext parentContext, boolean initParentJob, boolean active) {
        kotlin.coroutines.CoroutineContext.Element context;
        super(active);
        if (initParentJob) {
            initParentJob((Job)parentContext.get((CoroutineContext.Key)Job.Key));
        }
        this.context = parentContext.plus((CoroutineContext)this);
    }

    public static void getContext$annotations() {
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void afterResume(Object state) {
        afterCompletion(state);
    }

    @Override // kotlinx.coroutines.JobSupport
    protected String cancellationExceptionMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(DebugStringsKt.getClassSimpleName(this)).append(" was cancelled").toString();
    }

    @Override // kotlinx.coroutines.JobSupport
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.JobSupport
    public CoroutineContext getCoroutineContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(Throwable exception) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.context, exception);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.JobSupport
    public String nameString$kotlinx_coroutines_core() {
        String coroutineName = CoroutineContextKt.getCoroutineName(this.context);
        if (coroutineName == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append('"').append(coroutineName).append("\":").append(super.nameString$kotlinx_coroutines_core()).toString();
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void onCancelled(Throwable cause, boolean handled) {
    }

    protected void onCompleted(T value) {
    }

    @Override // kotlinx.coroutines.JobSupport
    protected final void onCompletionInternal(Object state) {
        Throwable cause;
        boolean handled;
        if (state instanceof CompletedExceptionally) {
            onCancelled(obj.cause, (CompletedExceptionally)state.getHandled());
        } else {
            onCompleted(state);
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void resumeWith(Object result) {
        int i = 0;
        Object completingOnce$kotlinx_coroutines_core = makeCompletingOnce$kotlinx_coroutines_core(CompletionStateKt.toState$default(result, i, 1, i));
        if (completingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
        }
        afterResume(completingOnce$kotlinx_coroutines_core);
    }

    public final <R> void start(kotlinx.coroutines.CoroutineStart start, R receiver, Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) {
        start.invoke(block, receiver, (Continuation)this);
    }
}
