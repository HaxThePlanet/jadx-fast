package kotlinx.coroutines.c3;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.p;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.internal.h;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a#\u0010\u0006\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u00032\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0008H\u0082\u0008\u001a\u001e\u0010\t\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\u00010\u00032\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u0003H\u0000\u001a>\u0010\t\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u000b*\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000c2\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001ay\u0010\t\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u000f\"\u0004\u0008\u0001\u0010\u000b*\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00102\u0006\u0010\u0011\u001a\u0002H\u000f2\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u00032%\u0008\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000cH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0017", d2 = {"dispatcherFailure", "", "completion", "Lkotlin/coroutines/Continuation;", "e", "", "runSafely", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "onCancellation", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class a {
    public static final void a(d d, Throwable throwable2) {
        a.b(d, throwable2);
        throw 0;
    }

    private static final void b(d<?> d, Throwable throwable2) {
        kotlin.p.a aVar = p.a;
        Object obj = q.a(throwable2);
        p.a(obj);
        d.resumeWith(obj);
        throw throwable2;
    }

    public static final void c(d<? super w> d, d<?> d2) {
        final int i = 0;
        kotlin.p.a aVar = p.a;
        w wVar = w.a;
        p.a(wVar);
        h.c(b.c(d), wVar, i, 2, i);
    }

    public static final <T> void d(l<? super d<? super T>, ? extends Object> l, d<? super T> d2) {
        final int i = 0;
        kotlin.p.a aVar = p.a;
        w wVar = w.a;
        p.a(wVar);
        h.c(b.c(b.a(l, d2)), wVar, i, 2, i);
    }

    public static final <R, T> void e(p<? super R, ? super d<? super T>, ? extends Object> p, R r2, d<? super T> d3, l<? super Throwable, w> l4) {
        try {
            kotlin.p.a obj1 = p.a;
            obj1 = w.a;
            p.a(obj1);
            h.b(b.c(b.b(p, r2, d3)), obj1, l4);
            a.a(d3, p);
            p = null;
            throw p;
        }
    }

    public static void f(p p, Object object2, d d3, l l4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        a.e(p, object2, d3, obj3);
    }
}
