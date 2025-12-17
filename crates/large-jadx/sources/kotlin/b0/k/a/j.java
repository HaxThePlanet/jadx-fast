package kotlin.b0.k.a;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.h;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008!\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\u0010\u0002\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public abstract class j extends kotlin.b0.k.a.a {
    public j(d<Object> d) {
        h hVar;
        d obj2;
        super(d);
        if (d != null) {
            obj2 = d.getContext() == h.a ? 1 : 0;
            if (obj2 == null) {
            } else {
            }
            obj2 = new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            throw obj2;
        }
    }

    @Override // kotlin.b0.k.a.a
    public g getContext() {
        return h.a;
    }
}
