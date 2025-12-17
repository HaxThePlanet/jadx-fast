package kotlin.b0.k.a;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.e;
import kotlin.b0.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\u0008!\u0018\u00002\u00020\u0001B\u0019\u0008\u0016\u0012\u0010\u0010\u0002\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B!\u0012\u0010\u0010\u0002\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u000e\u0010\u000c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003J\u0008\u0010\r\u001a\u00020\u000eH\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0018\u0010\u000c\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "_context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;Lkotlin/coroutines/CoroutineContext;)V", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "intercepted", "releaseIntercepted", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public abstract class d extends kotlin.b0.k.a.a {

    private final g _context;
    private transient d<Object> intercepted;
    public d(d<Object> d) {
        g context;
        if (d != null) {
            context = d.getContext();
        } else {
            context = 0;
        }
        super(d, context);
    }

    public d(d<Object> d, g g2) {
        super(d);
        this._context = g2;
    }

    @Override // kotlin.b0.k.a.a
    public g getContext() {
        final g _context = this._context;
        n.d(_context);
        return _context;
    }

    public final d<Object> intercepted() {
        Object intercepted;
        kotlin.b0.e.b bVar;
        if (this.intercepted != null) {
        } else {
            intercepted = getContext().get(e.p);
            if (intercepted != null && (e)intercepted.i(this) != null) {
                if (intercepted.i(this) != null) {
                } else {
                    intercepted = this;
                }
            } else {
            }
            this.intercepted = intercepted;
        }
        return intercepted;
    }

    @Override // kotlin.b0.k.a.a
    protected void releaseIntercepted() {
        kotlin.b0.g.b bVar2;
        kotlin.b0.e.b bVar;
        d intercepted = this.intercepted;
        if (intercepted != null && intercepted != this) {
            if (intercepted != this) {
                bVar2 = getContext().get(e.p);
                n.d(bVar2);
                (e)bVar2.e(intercepted);
            }
        }
        this.intercepted = c.a;
    }
}
