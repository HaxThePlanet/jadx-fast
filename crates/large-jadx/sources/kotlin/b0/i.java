package kotlin.b0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.b0.j.a;
import kotlin.b0.j.b;
import kotlin.b0.k.a.e;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0001\u0018\u0000 \u001a*\u0006\u0008\u0000\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u001aB\u0015\u0008\u0011\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005B\u001f\u0008\u0000\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0001J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\u00152\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0016H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001b", d2 = {"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class i<T>  implements kotlin.b0.d<T>, e {

    @Deprecated
    private static final AtomicReferenceFieldUpdater<kotlin.b0.i<?>, Object> b;
    private final kotlin.b0.d<T> a;
    private volatile Object result;
    static {
        i.b = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "result");
    }

    public i(kotlin.b0.d<? super T> d) {
        n.f(d, "delegate");
        super(d, a.UNDECIDED);
    }

    public i(kotlin.b0.d<? super T> d, Object object2) {
        n.f(d, "delegate");
        super();
        this.a = d;
        this.result = object2;
    }

    @Override // kotlin.b0.d
    public final Object b() {
        Object result;
        boolean rESUMED;
        Object obj;
        a uNDECIDED = a.UNDECIDED;
        if (this.result == uNDECIDED && i.b.compareAndSet(this, uNDECIDED, b.d())) {
            if (i.b.compareAndSet(this, uNDECIDED, b.d())) {
                return b.d();
            }
            result = this.result;
        }
        if (result == a.RESUMED) {
            result = b.d();
            return result;
        } else {
            if (result instanceof p.b) {
            } else {
            }
        }
        throw result.exception;
    }

    @Override // kotlin.b0.d
    public e getCallerFrame() {
        kotlin.b0.d dVar;
        if (!dVar instanceof e) {
            dVar = 0;
        }
        return (e)dVar;
    }

    @Override // kotlin.b0.d
    public kotlin.b0.g getContext() {
        return this.a.getContext();
    }

    @Override // kotlin.b0.d
    public java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.b0.d
    public void resumeWith(Object object) {
        boolean compareAndSet;
        Object uNDECIDED;
        a rESUMED;
        Object result = this.result;
        uNDECIDED = a.UNDECIDED;
        while (result == uNDECIDED) {
            result = this.result;
            uNDECIDED = a.UNDECIDED;
        }
    }

    @Override // kotlin.b0.d
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SafeContinuation for ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}
