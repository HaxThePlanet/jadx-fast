package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0010\u0018\u0000*\u0008\u0008\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0015\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\u0008\u0008\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u0008\u000b\u0010\u000cJ\r\u0010\r\u001a\u00020\u0003¢\u0006\u0004\u0008\r\u0010\u000eJ-\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\u0008\u0001\u0010\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010¢\u0006\u0004\u0008\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u000eR\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a¨\u0006\u001c", d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", "E", "", "singleConsumer", "<init>", "(Z)V", "element", "addLast", "(Ljava/lang/Object;)Z", "", "close", "()V", "isClosed", "()Z", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "removeFirstOrNull", "()Ljava/lang/Object;", "isEmpty", "", "getSize", "()I", "size", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class p<E>  {

    private static final AtomicReferenceFieldUpdater a;
    private volatile Object _cur;
    static {
        p.a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_cur");
    }

    public p(boolean z) {
        super();
        q qVar = new q(8, z);
        this._cur = qVar;
    }

    public final boolean a(E e) {
        Object _cur;
        AtomicReferenceFieldUpdater field;
        kotlinx.coroutines.internal.q qVar;
        _cur = this._cur;
        field = (q)_cur.a(e);
        qVar = 1;
        while (field != null) {
            p.a.compareAndSet(this, _cur, _cur.i());
            _cur = this._cur;
            field = (q)_cur.a(e);
            qVar = 1;
        }
        return qVar;
    }

    public final void b() {
        final Object _cur = this._cur;
        while ((q)_cur.d()) {
            p.a.compareAndSet(this, _cur, _cur.i());
            _cur = this._cur;
        }
    }

    public final int c() {
        return (q)this._cur.f();
    }

    public final E d() {
        final Object _cur = this._cur;
        Object obj = (q)_cur.j();
        while (obj != q.h) {
            p.a.compareAndSet(this, _cur, _cur.i());
            _cur = this._cur;
            obj = (q)_cur.j();
        }
        return obj;
    }
}
