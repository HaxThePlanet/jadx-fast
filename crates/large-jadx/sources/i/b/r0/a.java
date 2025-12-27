package i.b.r0;

import i.b.a0;
import i.b.h;
import i.b.l0.f;
import i.b.r;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: subscribers.kt */
/* loaded from: classes3.dex */
public final class a {

    private static final l<Object, w> a;
    private static final l<Throwable, w> b;
    private static final kotlin.d0.c.a<w> c;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Lkotlin/w;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class a extends p implements kotlin.d0.c.a<w> {

        public static final a.a a = new a$a();

        a() {
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"", "it", "Lkotlin/w;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class b extends p implements l<Throwable, w> {

        public static final a.b a = new a$b();

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.g(th, "it");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"", "it", "Lkotlin/w;", "a", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 0})
    static final class c extends p implements l<Object, w> {

        public static final a.c a = new a$c();

        c() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(Object object) {
            n.g(object, "it");
        }
    }
    static {
        a.a = a.c.a;
        a.b = a.b.a;
        a.c = a.a.a;
    }

    private static final <T> f<T> a(l<? super T, w> lVar) {
        l lVar2;
        f fVar;
        i.b.r0.c cVar;
        if (lVar == a.a) {
            str = "Functions.emptyConsumer()";
            n.c(a.g(), str);
        } else {
            if (lVar != null) {
            }
        }
        return fVar;
    }

    private static final i.b.l0.a b(kotlin.d0.c.a<w> aVar) {
        kotlin.d0.c.a aVar2;
        i.b.l0.a aVar3;
        i.b.r0.b bVar;
        if (aVar == a.c) {
            str = "Functions.EMPTY_ACTION";
            n.c(a.c, str);
        } else {
            if (a.c != null) {
            }
        }
        return aVar3;
    }

    private static final f<Throwable> c(l<? super Throwable, w> lVar) {
        l lVar2;
        f fVar;
        i.b.r0.c cVar;
        if (lVar == a.b) {
            str = "Functions.ON_ERROR_MISSING";
            n.c(a.e, str);
        } else {
            if (a.e != null) {
            }
        }
        return fVar;
    }

    public static final i.b.j0.b d(i.b.b bVar, l<? super Throwable, w> lVar, kotlin.d0.c.a<w> aVar) {
        i.b.j0.b bVar2;
        n.g(bVar, "$this$subscribeBy");
        n.g(lVar, "onError");
        n.g(aVar, "onComplete");
        lVar = a.b;
        if (lVar != a.b || aVar != a.c) {
            if (lVar == a.b) {
                str = "subscribe(onComplete)";
                n.c(bVar.v(new b(aVar)), str);
            } else {
                str = "subscribe(onComplete.asO…ion(), Consumer(onError))";
                n.c(bVar.w(a.b(aVar), new c(lVar)), str);
            }
        } else {
            str = "subscribe()";
            n.c(bVar.u(), str);
        }
        return bVar2;
    }

    public static final <T> i.b.j0.b e(h<T> hVar, l<? super Throwable, w> lVar, kotlin.d0.c.a<w> aVar, l<? super T, w> lVar2) {
        n.g(hVar, "$this$subscribeBy");
        n.g(lVar, "onError");
        n.g(aVar, "onComplete");
        n.g(lVar2, "onNext");
        final i.b.j0.b bVar = hVar.Z(a.a(lVar2), a.c(lVar), a.b(aVar));
        n.c(bVar, "subscribe(onNext.asConsu…ete.asOnCompleteAction())");
        return bVar;
    }

    public static final <T> i.b.j0.b f(r<T> rVar, l<? super Throwable, w> lVar, kotlin.d0.c.a<w> aVar, l<? super T, w> lVar2) {
        n.g(rVar, "$this$subscribeBy");
        n.g(lVar, "onError");
        n.g(aVar, "onComplete");
        n.g(lVar2, "onNext");
        final i.b.j0.b disposable = rVar.subscribe(a.a(lVar2), a.c(lVar), a.b(aVar));
        n.c(disposable, "subscribe(onNext.asConsu…ete.asOnCompleteAction())");
        return disposable;
    }

    public static final <T> i.b.j0.b g(a0<T> a0Var, l<? super Throwable, w> lVar, l<? super T, w> lVar2) {
        n.g(a0Var, "$this$subscribeBy");
        n.g(lVar, "onError");
        n.g(lVar2, "onSuccess");
        final i.b.j0.b disposable = a0Var.subscribe(a.a(lVar2), a.c(lVar));
        n.c(disposable, "subscribe(onSuccess.asCo…rror.asOnErrorConsumer())");
        return disposable;
    }

    public static /* synthetic */ i.b.j0.b h(i.b.b bVar, l lVar, kotlin.d0.c.a aVar, int i, Object object) {
        if (i & 1 != 0) {
            lVar = a.b;
        }
        if (i & 2 != 0) {
            aVar = a.c;
        }
        return a.d(bVar, lVar, aVar);
    }

    public static /* synthetic */ i.b.j0.b i(r rVar, l lVar, kotlin.d0.c.a aVar, l lVar2, int i, Object object) {
        l lVar3;
        if (i & 1 != 0) {
            lVar = a.b;
        }
        if (i & 2 != 0) {
            aVar = a.c;
        }
        if (i & 4 != 0) {
            lVar3 = a.a;
        }
        return a.f(rVar, lVar, aVar, lVar3);
    }

    public static /* synthetic */ i.b.j0.b j(a0 a0Var, l lVar, l lVar2, int i, Object object) {
        l lVar4;
        if (i & 1 != 0) {
            lVar = a.b;
        }
        if (i & 2 != 0) {
            lVar4 = a.a;
        }
        return a.g(a0Var, lVar, lVar4);
    }
}
