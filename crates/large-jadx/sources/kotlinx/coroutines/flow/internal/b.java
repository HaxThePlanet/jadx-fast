package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.b0.g;
import kotlin.b0.g.b;
import kotlin.b0.g.b.a;
import kotlin.b0.g.c;
import kotlin.d0.c.p;
import kotlin.d0.d.g;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\n", d2 = {"Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "e", "", "(Ljava/lang/Throwable;)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b implements g.b {

    public static final kotlinx.coroutines.flow.internal.b.a c;
    public final Throwable a;
    private final g.c<?> b;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements g.c<kotlinx.coroutines.flow.internal.b> {
        public a(g g) {
            super();
        }
    }
    static {
        b.a aVar = new b.a(0);
        b.c = aVar;
    }

    public b(Throwable throwable) {
        super();
        this.a = throwable;
        this.b = b.c;
    }

    public <R> R fold(R r, p<? super R, ? super g.b, ? extends R> p2) {
        return g.b.a.a(this, r, p2);
    }

    public <E extends g.b> E get(g.c<E> g$c) {
        return g.b.a.b(this, c);
    }

    public g.c<?> getKey() {
        return this.b;
    }

    public g minusKey(g.c<?> g$c) {
        return g.b.a.c(this, c);
    }

    @Override // kotlin.b0.g$b
    public g plus(g g) {
        return g.b.a.d(this, g);
    }
}
