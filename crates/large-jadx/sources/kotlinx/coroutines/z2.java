package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.g;
import kotlin.b0.g.b;
import kotlin.b0.g.b.a;
import kotlin.b0.g.c;
import kotlin.d0.c.p;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Â\u0002\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00000\u0002B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lkotlinx/coroutines/UndispatchedMarker;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext$Key;", "()V", "key", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class z2 implements g.b, g.c<kotlinx.coroutines.z2> {

    public static final kotlinx.coroutines.z2 a;
    static {
        z2 z2Var = new z2();
        z2.a = z2Var;
    }

    public <R> R fold(R r, p<? super R, ? super g.b, ? extends R> p2) {
        return g.b.a.a(this, r, p2);
    }

    public <E extends g.b> E get(g.c<E> g$c) {
        return g.b.a.b(this, c);
    }

    public g.c<?> getKey() {
        return this;
    }

    public g minusKey(g.c<?> g$c) {
        return g.b.a.c(this, c);
    }

    @Override // kotlin.b0.g$b
    public g plus(g g) {
        return g.b.a.d(this, g);
    }
}
