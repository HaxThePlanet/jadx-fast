package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletionStateKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0010\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008¢\u0006\u0002\u0010\tJ\u0012\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u000e\u0010\u0015\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017R\u0019\u0010\n\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\u000e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000fR\u0016\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00088\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "isScopedCoroutine", "", "()Z", "afterCompletion", "", "state", "", "afterResume", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ScopeCoroutine<T>  extends AbstractCoroutine<T> implements CoroutineStackFrame {

    public final Continuation<T> uCont;
    public ScopeCoroutine(CoroutineContext context, Continuation<? super T> uCont) {
        final int i = 1;
        super(context, i, i);
        this.uCont = uCont;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void afterCompletion(Object state) {
        final int i = 0;
        DispatchedContinuationKt.resumeCancellableWith$default(IntrinsicsKt.intercepted(this.uCont), CompletionStateKt.recoverResult(state, this.uCont), i, 2, i);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void afterResume(Object state) {
        this.uCont.resumeWith(CompletionStateKt.recoverResult(state, this.uCont));
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final CoroutineStackFrame getCallerFrame() {
        Continuation uCont;
        if (uCont instanceof CoroutineStackFrame) {
        } else {
            uCont = 0;
        }
        return uCont;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected final boolean isScopedCoroutine() {
        return 1;
    }
}
