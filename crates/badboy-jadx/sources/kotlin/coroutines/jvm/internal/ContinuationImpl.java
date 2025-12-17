package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\u0008!\u0018\u00002\u00020\u0001B\u0019\u0008\u0016\u0012\u0010\u0010\u0002\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B!\u0012\u0010\u0010\u0002\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u000e\u0010\u000c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003J\u0008\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0018\u0010\u000c\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ContinuationImpl extends kotlin.coroutines.jvm.internal.BaseContinuationImpl {

    private final CoroutineContext _context;
    private transient Continuation<Object> intercepted;
    public ContinuationImpl(Continuation<Object> completion) {
        CoroutineContext context;
        if (completion != null) {
            context = completion.getContext();
        } else {
            context = 0;
        }
        super(completion, context);
    }

    public ContinuationImpl(Continuation<Object> completion, CoroutineContext _context) {
        super(completion);
        this._context = _context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public CoroutineContext getContext() {
        final CoroutineContext _context = this._context;
        Intrinsics.checkNotNull(_context);
        return _context;
    }

    public final Continuation<Object> intercepted() {
        Object interceptContinuation;
        Object key;
        Object obj;
        int i;
        if (this.intercepted == null) {
            interceptContinuation = getContext().get((CoroutineContext.Key)ContinuationInterceptor.Key);
            if ((ContinuationInterceptor)interceptContinuation != null) {
                if ((ContinuationInterceptor)interceptContinuation.interceptContinuation((Continuation)this) == null) {
                    interceptContinuation = this;
                }
            } else {
            }
            i = 0;
            this.intercepted = interceptContinuation;
        }
        return interceptContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected void releaseIntercepted() {
        kotlin.coroutines.CoroutineContext.Element context;
        kotlin.coroutines.ContinuationInterceptor.Key key;
        final Continuation intercepted = this.intercepted;
        if (intercepted != null && intercepted != this) {
            if (intercepted != this) {
                context = getContext().get((CoroutineContext.Key)ContinuationInterceptor.Key);
                Intrinsics.checkNotNull(context);
                (ContinuationInterceptor)context.releaseInterceptedContinuation(intercepted);
            }
        }
        this.intercepted = (Continuation)CompletedContinuation.INSTANCE;
    }
}
