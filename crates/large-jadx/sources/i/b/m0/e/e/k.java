package i.b.m0.e.e;

import i.b.l0.a;
import i.b.l0.f;
import i.b.m0.b.a;
import i.b.m0.b.b;
import i.b.m0.d.i;
import i.b.m0.d.t;
import i.b.m0.j.e;
import i.b.m0.j.f;
import i.b.m0.j.k;
import i.b.m0.j.n;
import i.b.w;
import i.b.y;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public final class k {
    public static <T> void a(w<? extends T> w) {
        f fVar = new f();
        t tVar = new t(a.g(), fVar, fVar, a.g());
        w.subscribe(tVar);
        e.a(fVar, tVar);
        Throwable obj4 = fVar.a;
        if (obj4 != null) {
        } else {
        }
        throw k.e(obj4);
    }

    public static <T> void b(w<? extends T> w, y<? super T> y2) {
        boolean disposed;
        Throwable obj3;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        i iVar = new i(linkedBlockingQueue);
        y2.onSubscribe(iVar);
        w.subscribe(iVar);
        while (iVar.isDisposed()) {
            if (linkedBlockingQueue.poll() == null) {
            }
            if (!iVar.isDisposed()) {
                break;
            }
            if (obj3 != i.a) {
                break;
            }
            if (!n.acceptFull(obj3, y2)) {
                break;
            }
            obj3 = linkedBlockingQueue.take();
        }
    }

    public static <T> void c(w<? extends T> w, f<? super T> f2, f<? super Throwable> f3, a a4) {
        b.e(f2, "onNext is null");
        b.e(f3, "onError is null");
        b.e(a4, "onComplete is null");
        t tVar = new t(f2, f3, a4, a.g());
        k.b(w, tVar);
    }
}
