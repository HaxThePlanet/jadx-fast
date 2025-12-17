package kotlin.b0;

import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008'\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public abstract class a implements kotlin.b0.g.b {

    private final kotlin.b0.g.c<?> key;
    public a(kotlin.b0.g.c<?> g$c) {
        n.f(c, "key");
        super();
        this.key = c;
    }

    public <R> R fold(R r, p<? super R, ? super kotlin.b0.g.b, ? extends R> p2) {
        n.f(p2, "operation");
        return g.b.a.a(this, r, p2);
    }

    public <E extends kotlin.b0.g.b> E get(kotlin.b0.g.c<E> g$c) {
        n.f(c, "key");
        return g.b.a.b(this, c);
    }

    public kotlin.b0.g.c<?> getKey() {
        return this.key;
    }

    public kotlin.b0.g minusKey(kotlin.b0.g.c<?> g$c) {
        n.f(c, "key");
        return g.b.a.c(this, c);
    }

    @Override // kotlin.b0.g$b
    public kotlin.b0.g plus(kotlin.b0.g g) {
        n.f(g, "context");
        return g.b.a.d(this, g);
    }
}
