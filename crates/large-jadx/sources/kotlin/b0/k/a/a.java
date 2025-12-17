package kotlin.b0.k.a;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.d0.d.n;
import kotlin.p;
import kotlin.q;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0017\u0012\u0010\u0010\u0005\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J$\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u00012\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0001H\u0016J\u001a\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0001H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H$ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0008\u0010\u0015\u001a\u00020\rH\u0014J\u001e\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\u0005\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001a", d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public abstract class a implements d<Object>, kotlin.b0.k.a.e, Serializable {

    private final d<Object> completion;
    public a(d<Object> d) {
        super();
        this.completion = d;
    }

    public d<w> create(Object object, d<?> d2) {
        n.f(d2, "completion");
        UnsupportedOperationException obj1 = new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
        throw obj1;
    }

    public d<w> create(d<?> d) {
        n.f(d, "completion");
        UnsupportedOperationException obj2 = new UnsupportedOperationException("create(Continuation) has not been overridden");
        throw obj2;
    }

    @Override // kotlin.b0.d
    public kotlin.b0.k.a.e getCallerFrame() {
        d completion;
        if (!completion instanceof e) {
            completion = 0;
        }
        return (e)completion;
    }

    public final d<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.b0.d
    public java.lang.StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    @Override // kotlin.b0.d
    protected abstract Object invokeSuspend(Object object);

    @Override // kotlin.b0.d
    protected void releaseIntercepted() {
    }

    @Override // kotlin.b0.d
    public final void resumeWith(Object object) {
        d dVar;
        d completion;
        kotlin.p.a aVar;
        Object obj4;
        dVar = this;
        h.b(dVar);
        completion = dVar.completion;
        n.d(completion);
        obj4 = dVar.invokeSuspend(obj4);
        while (obj4 == b.d()) {
            aVar = p.a;
            p.a(obj4);
            dVar.releaseIntercepted();
            dVar = completion;
            h.b(dVar);
            completion = dVar.completion;
            n.d(completion);
            obj4 = dVar.invokeSuspend(obj4);
            aVar = p.a;
            object = q.a(object);
            p.a(object);
        }
    }

    @Override // kotlin.b0.d
    public String toString() {
        Object stackTraceElement;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Continuation at ");
        if (getStackTraceElement() != null) {
        } else {
            stackTraceElement = getClass().getName();
        }
        stringBuilder.append(stackTraceElement);
        return stringBuilder.toString();
    }
}
