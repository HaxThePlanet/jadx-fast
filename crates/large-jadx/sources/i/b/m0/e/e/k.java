package i.b.m0.e.e;

import i.b.m0.b.b;
import i.b.m0.d.i;
import i.b.m0.d.t;
import i.b.m0.j.e;
import i.b.m0.j.k;
import i.b.m0.j.n;
import i.b.w;
import i.b.y;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ObservableBlockingSubscribe.java */
/* loaded from: classes3.dex */
public final class k {
    public static <T> void a(w<? extends T> wVar) {
        final i.b.m0.j.f fVar = new f();
        final t tVar = new t(a.g(), fVar, fVar, a.g());
        wVar.subscribe(tVar);
        e.a(fVar, tVar);
        if (fVar.a != null) {
            throw k.e(fVar.a);
        }
    }

    public static <T> void b(w<? extends T> wVar, y<? super T> yVar) {
        Object obj;
        Object poll;
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        final i iVar = new i(linkedBlockingQueue);
        yVar.onSubscribe(iVar);
        wVar.subscribe(iVar);
        while (iVar.isDisposed()) {
            if (!iVar.isDisposed() && poll != i.a && n.acceptFull(poll, yVar)) {
                return;
            }
        }
    }

    public static <T> void c(w<? extends T> wVar, i.b.l0.f<? super T> fVar, i.b.l0.f<? super Throwable> fVar2, i.b.l0.a aVar) {
        b.e(fVar, "onNext is null");
        b.e(fVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        k.b(wVar, new t(fVar, fVar2, aVar, a.g()));
    }
}
