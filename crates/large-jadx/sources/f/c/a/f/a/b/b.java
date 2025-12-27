package f.c.a.f.a.b;

import com.google.android.play.core.tasks.c;
import kotlin.Metadata;
import kotlin.b0.k.a.h;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;

/* compiled from: TaskUtils.kt */
/* loaded from: classes2.dex */
public final class b {

    static final class c<ResultT> implements c<T> {

        final /* synthetic */ kotlinx.coroutines.p a;
        public final void onSuccess(T t) {
            Result.a(t);
            this.a.resumeWith(t);
        }

        c(kotlinx.coroutines.p pVar) {
            this.a = pVar;
            super();
        }
    }

    static final class d implements com.google.android.play.core.tasks.b {

        final /* synthetic */ kotlinx.coroutines.p a;
        public final void onFailure(Exception exc) {
            n.c(exc, "exception");
            final Object obj = q.a(exc);
            Result.a(obj);
            this.a.resumeWith(obj);
        }

        d(kotlinx.coroutines.p pVar) {
            this.a = pVar;
            super();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u00002\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"T", "L;", "it", "Lkotlin/w;", "invoke", "(L;)V", "kotlin/Throwable", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class a extends kotlin.d0.d.p implements l<Throwable, w> {

        final /* synthetic */ a $onCanceled$inlined;
        final /* synthetic */ com.google.android.play.core.tasks.d $task$inlined;
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            this.$onCanceled$inlined.invoke();
        }

        a(a aVar, com.google.android.play.core.tasks.d dVar) {
            this.$onCanceled$inlined = aVar;
            this.$task$inlined = dVar;
            super(1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0000H\n¢\u0006\u0004\u0008\u0002\u0010\u0003", d2 = {"T", "Lkotlin/w;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class b extends kotlin.d0.d.p implements a<w> {

        public static final b.b a = new b$b();

        b() {
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
        }
    }
    public static final <T> Object a(com.google.android.play.core.tasks.d<T> dVar, a<w> aVar, kotlin.b0.d<? super T> dVar2) {
        final kotlinx.coroutines.q cancellableContinuationImpl = new CancellableContinuationImpl(b.c(dVar2), 1);
        cancellableContinuationImpl.B();
        cancellableContinuationImpl.g(new b.a(aVar, dVar));
        if (dVar.h()) {
            if (dVar.i()) {
                Object obj = dVar.g();
                kotlin.p.a aVar4 = Result.a;
                Result.a(obj);
                cancellableContinuationImpl.resumeWith(obj);
                Object obj2 = cancellableContinuationImpl.y();
                if (obj2 == b.d()) {
                    h.c(dVar2);
                }
                return obj2;
            } else {
                Exception exc = dVar.f();
                if (exc != null) {
                    n.c(exc, "task.exception!!");
                    kotlin.p.a aVar3 = Result.a;
                    obj = q.a(exc);
                    Result.a(obj);
                    cancellableContinuationImpl.resumeWith(obj);
                }
            }
            n.q();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
        dVar.d(new b.c(cancellableContinuationImpl));
        dVar.b(new b.d(cancellableContinuationImpl));
        str = "task.addOnFailureListene…ithException(exception) }";
        n.c(dVar, str);
    }

    public static /* synthetic */ Object b(com.google.android.play.core.tasks.d dVar, a aVar, kotlin.b0.d dVar2, int i, Object object) {
        f.c.a.f.a.b.b.b bVar;
        if (i & 2 != 0) {
            bVar = b.b.a;
        }
        return b.a(dVar, bVar, dVar2);
    }
}
