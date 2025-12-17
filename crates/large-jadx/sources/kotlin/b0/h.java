package kotlin.b0;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0004J5\u0010\u0007\u001a\u0002H\u0008\"\u0004\u0008\u0000\u0010\u00082\u0006\u0010\t\u001a\u0002H\u00082\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u0002H\u00080\u000bH\u0016¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0008\u0008\u0000\u0010\u000f*\u00020\u000c2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0096\u0002¢\u0006\u0002\u0010\u0012J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u00020\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u0011H\u0016J\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0096\u0002J\u0008\u0010\u0018\u001a\u00020\u0019H\u0002J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lkotlin/coroutines/EmptyCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "plus", "context", "readResolve", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class h implements kotlin.b0.g, Serializable {

    public static final kotlin.b0.h a;
    private static final long serialVersionUID;
    static {
        h hVar = new h();
        h.a = hVar;
    }

    private final Object readResolve() {
        return h.a;
    }

    public <R> R fold(R r, p<? super R, ? super kotlin.b0.g.b, ? extends R> p2) {
        n.f(p2, "operation");
        return r;
    }

    public <E extends kotlin.b0.g.b> E get(kotlin.b0.g.c<E> g$c) {
        n.f(c, "key");
        return 0;
    }

    @Override // kotlin.b0.g
    public int hashCode() {
        return 0;
    }

    public kotlin.b0.g minusKey(kotlin.b0.g.c<?> g$c) {
        n.f(c, "key");
        return this;
    }

    @Override // kotlin.b0.g
    public kotlin.b0.g plus(kotlin.b0.g g) {
        n.f(g, "context");
        return g;
    }

    @Override // kotlin.b0.g
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
