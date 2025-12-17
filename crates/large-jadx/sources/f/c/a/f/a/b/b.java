package f.c.a.f.a.b;

import com.google.android.play.core.tasks.b;
import com.google.android.play.core.tasks.c;
import com.google.android.play.core.tasks.d;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.h;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.p;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

/* loaded from: classes2.dex */
public final class b {

    static final class c implements c<T> {

        final p a;
        c(p p) {
            this.a = p;
            super();
        }

        public final void onSuccess(T t) {
            final kotlin.p.a aVar = p.a;
            p.a(t);
            this.a.resumeWith(t);
        }
    }

    static final class d implements b {

        final p a;
        d(p p) {
            this.a = p;
            super();
        }

        @Override // com.google.android.play.core.tasks.b
        public final void onFailure(Exception exception) {
            n.c(exception, "exception");
            kotlin.p.a aVar = p.a;
            final Object obj3 = q.a(exception);
            p.a(obj3);
            this.a.resumeWith(obj3);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u00002\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"T", "L;", "it", "Lkotlin/w;", "invoke", "(L;)V", "kotlin/Throwable", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class a extends p implements l<Throwable, w> {

        final a $onCanceled$inlined;
        final d $task$inlined;
        a(a a, d d2) {
            this.$onCanceled$inlined = a;
            this.$task$inlined = d2;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            this.$onCanceled$inlined.invoke();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0000H\n¢\u0006\u0004\u0008\u0002\u0010\u0003", d2 = {"T", "Lkotlin/w;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class b extends p implements a<w> {

        public static final f.c.a.f.a.b.b.b a;
        static {
            b.b bVar = new b.b();
            b.b.a = bVar;
        }

        b() {
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
    public static final <T> Object a(d<T> d, a<w> a2, d<? super T> d3) {
        Object obj3;
        Object obj4;
        q qVar = new q(b.c(d3), 1);
        qVar.B();
        b.a aVar = new b.a(a2, d);
        qVar.g(aVar);
        if (d.h()) {
            if (d.i()) {
                obj3 = d.g();
                obj4 = p.a;
                p.a(obj3);
                qVar.resumeWith(obj3);
                obj3 = qVar.y();
                if (obj3 == b.d()) {
                    h.c(d3);
                }
                return obj3;
            } else {
                obj3 = d.f();
                if (obj3 == null) {
                } else {
                    n.c(obj3, "task.exception!!");
                    obj4 = p.a;
                    obj3 = q.a(obj3);
                    p.a(obj3);
                    qVar.resumeWith(obj3);
                }
            }
            n.q();
            throw 0;
        }
        obj4 = new b.c(qVar);
        d.d(obj4);
        obj4 = new b.d(qVar);
        d.b(obj4);
        n.c(d, "task.addOnFailureListene…ithException(exception) }");
    }

    public static Object b(d d, a a2, d d3, int i4, Object object5) {
        f.c.a.f.a.b.b.b obj1;
        if (i4 &= 2 != 0) {
            obj1 = b.b.a;
        }
        return b.a(d, obj1, d3);
    }
}
