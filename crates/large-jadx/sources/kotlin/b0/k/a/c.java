package kotlin.b0.k.a;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008À\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003J \u0010\u0008\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000cJ\u0008\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000f", d2 = {"Lkotlin/coroutines/jvm/internal/CompletedContinuation;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class c implements d<Object> {

    public static final kotlin.b0.k.a.c a;
    static {
        c cVar = new c();
        c.a = cVar;
    }

    @Override // kotlin.b0.d
    public g getContext() {
        IllegalStateException illegalStateException = new IllegalStateException("This continuation is already complete".toString());
        throw illegalStateException;
    }

    @Override // kotlin.b0.d
    public void resumeWith(Object object) {
        IllegalStateException obj2 = new IllegalStateException("This continuation is already complete".toString());
        throw obj2;
    }

    @Override // kotlin.b0.d
    public String toString() {
        return "This continuation is already complete";
    }
}
