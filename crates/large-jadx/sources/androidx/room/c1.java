package androidx.room;

import kotlin.Metadata;
import kotlin.b0.e;
import kotlin.b0.g;
import kotlin.b0.g.b;
import kotlin.b0.g.b.a;
import kotlin.b0.g.c;
import kotlin.d0.c.p;
import kotlin.d0.d.g;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010R\u001a\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Landroidx/room/TransactionElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "transactionThreadControlJob", "Lkotlinx/coroutines/Job;", "transactionDispatcher", "Lkotlin/coroutines/ContinuationInterceptor;", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/ContinuationInterceptor;)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "referenceCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getTransactionDispatcher$room_ktx_release", "()Lkotlin/coroutines/ContinuationInterceptor;", "acquire", "", "release", "Key", "room-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c1 implements g.b {

    public static final androidx.room.c1.a b;
    private final e a;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/room/TransactionElement$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/room/TransactionElement;", "()V", "room-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements g.c<androidx.room.c1> {
        public a(g g) {
            super();
        }
    }
    static {
        c1.a aVar = new c1.a(0);
        c1.b = aVar;
    }

    @Override // kotlin.b0.g$b
    public final e b() {
        return this.a;
    }

    public <R> R fold(R r, p<? super R, ? super g.b, ? extends R> p2) {
        return g.b.a.a(this, r, p2);
    }

    public <E extends g.b> E get(g.c<E> g$c) {
        return g.b.a.b(this, c);
    }

    public g.c<androidx.room.c1> getKey() {
        return c1.b;
    }

    public g minusKey(g.c<?> g$c) {
        return g.b.a.c(this, c);
    }

    @Override // kotlin.b0.g$b
    public g plus(g g) {
        return g.b.a.d(this, g);
    }
}
