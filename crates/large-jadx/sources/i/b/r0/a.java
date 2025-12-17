package i.b.r0;

import i.b.a0;
import i.b.b;
import i.b.h;
import i.b.j0.b;
import i.b.l0.a;
import i.b.l0.f;
import i.b.m0.b.a;
import i.b.r;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* loaded from: classes3.dex */
public final class a {

    private static final l<Object, w> a;
    private static final l<Throwable, w> b;
    private static final a<w> c;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0001\u0010\u0002", d2 = {"Lkotlin/w;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class a extends p implements a<w> {

        public static final i.b.r0.a.a a;
        static {
            a.a aVar = new a.a();
            a.a.a = aVar;
        }

        a() {
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"", "it", "Lkotlin/w;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class b extends p implements l<Throwable, w> {

        public static final i.b.r0.a.b a;
        static {
            a.b bVar = new a.b();
            a.b.a = bVar;
        }

        b() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.g(throwable, "it");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\u0008\u0003\u0010\u0004", d2 = {"", "it", "Lkotlin/w;", "a", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 0})
    static final class c extends p implements l<Object, w> {

        public static final i.b.r0.a.c a;
        static {
            a.c cVar = new a.c();
            a.c.a = cVar;
        }

        c() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(Object object) {
            n.g(object, "it");
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a(object);
            return w.a;
        }
    }
    static {
        a.a = a.c.a;
        a.b = a.b.a;
        a.c = a.a.a;
    }

    private static final <T> f<T> a(l<? super T, w> l) {
        Object cVar;
        Object obj1;
        if (l == a.a) {
            n.c(a.g(), "Functions.emptyConsumer()");
        } else {
            if (l != null) {
                cVar = new c(l);
                obj1 = cVar;
            }
        }
        return obj1;
    }

    private static final a b(a<w> a) {
        Object bVar;
        Object obj1;
        if (a == a.c) {
            n.c(a.c, "Functions.EMPTY_ACTION");
        } else {
            if (a != null) {
                bVar = new b(a);
                obj1 = bVar;
            }
        }
        return obj1;
    }

    private static final f<Throwable> c(l<? super Throwable, w> l) {
        Object cVar;
        Object obj1;
        if (l == a.b) {
            n.c(a.e, "Functions.ON_ERROR_MISSING");
        } else {
            if (l != null) {
                cVar = new c(l);
                obj1 = cVar;
            }
        }
        return obj1;
    }

    public static final b d(b b, l<? super Throwable, w> l2, a<w> a3) {
        Object cVar;
        a aVar;
        b obj2;
        String obj3;
        Object obj4;
        n.g(b, "$this$subscribeBy");
        n.g(l2, "onError");
        n.g(a3, "onComplete");
        cVar = a.b;
        if (l2 == cVar && a3 == a.c) {
            if (a3 == a.c) {
                n.c(b.u(), "subscribe()");
            } else {
                if (l2 == cVar) {
                    obj3 = new b(a3);
                    n.c(b.v(obj3), "subscribe(onComplete)");
                } else {
                    cVar = new c(l2);
                    n.c(b.w(a.b(a3), cVar), "subscribe(onComplete.asO…ion(), Consumer(onError))");
                }
            }
        } else {
        }
        return obj2;
    }

    public static final <T> b e(h<T> h, l<? super Throwable, w> l2, a<w> a3, l<? super T, w> l4) {
        n.g(h, "$this$subscribeBy");
        n.g(l2, "onError");
        n.g(a3, "onComplete");
        n.g(l4, "onNext");
        final b obj1 = h.Z(a.a(l4), a.c(l2), a.b(a3));
        n.c(obj1, "subscribe(onNext.asConsu…ete.asOnCompleteAction())");
        return obj1;
    }

    public static final <T> b f(r<T> r, l<? super Throwable, w> l2, a<w> a3, l<? super T, w> l4) {
        n.g(r, "$this$subscribeBy");
        n.g(l2, "onError");
        n.g(a3, "onComplete");
        n.g(l4, "onNext");
        final b obj1 = r.subscribe(a.a(l4), a.c(l2), a.b(a3));
        n.c(obj1, "subscribe(onNext.asConsu…ete.asOnCompleteAction())");
        return obj1;
    }

    public static final <T> b g(a0<T> a0, l<? super Throwable, w> l2, l<? super T, w> l3) {
        n.g(a0, "$this$subscribeBy");
        n.g(l2, "onError");
        n.g(l3, "onSuccess");
        final b obj1 = a0.subscribe(a.a(l3), a.c(l2));
        n.c(obj1, "subscribe(onSuccess.asCo…rror.asOnErrorConsumer())");
        return obj1;
    }

    public static b h(b b, l l2, a a3, int i4, Object object5) {
        l obj1;
        a obj2;
        if (i4 & 1 != 0) {
            obj1 = a.b;
        }
        if (i4 &= 2 != 0) {
            obj2 = a.c;
        }
        return a.d(b, obj1, obj2);
    }

    public static b i(r r, l l2, a a3, l l4, int i5, Object object6) {
        l obj1;
        a obj2;
        l obj3;
        if (i5 & 1 != 0) {
            obj1 = a.b;
        }
        if (i5 & 2 != 0) {
            obj2 = a.c;
        }
        if (i5 &= 4 != 0) {
            obj3 = a.a;
        }
        return a.f(r, obj1, obj2, obj3);
    }

    public static b j(a0 a0, l l2, l l3, int i4, Object object5) {
        l obj1;
        l obj2;
        if (i4 & 1 != 0) {
            obj1 = a.b;
        }
        if (i4 &= 2 != 0) {
            obj2 = a.a;
        }
        return a.g(a0, obj1, obj2);
    }
}
