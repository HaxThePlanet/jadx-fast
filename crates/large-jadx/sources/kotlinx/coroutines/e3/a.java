package kotlinx.coroutines.e3;

import com.google.android.gms.tasks.b;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.h;
import kotlin.d0.c.l;
import kotlin.d0.d.p;
import kotlin.p;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.p;
import kotlinx.coroutines.p.a;
import kotlinx.coroutines.q;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u001c\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\u001a&\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a(\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\u001c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\u001a!\u0010\u0008\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a)\u0010\u0008\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a+\u0010\u000b\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000c", d2 = {"asDeferred", "Lkotlinx/coroutines/Deferred;", "T", "Lcom/google/android/gms/tasks/Task;", "cancellationTokenSource", "Lcom/google/android/gms/tasks/CancellationTokenSource;", "asDeferredImpl", "asTask", "await", "(Lcom/google/android/gms/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/google/android/gms/tasks/Task;Lcom/google/android/gms/tasks/CancellationTokenSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitImpl", "kotlinx-coroutines-play-services"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class a {

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0014\u0010\u0003\u001a\u0010\u0012\u000c\u0012\n \u0005*\u0004\u0018\u0001H\u0002H\u00020\u0004H\n", d2 = {"<anonymous>", "", "T", "it", "Lcom/google/android/gms/tasks/Task;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a implements e {

        final p<T> a;
        a(p<? super T> p) {
            this.a = p;
            super();
        }

        public final void onComplete(j<T> j) {
            p pVar;
            kotlin.p.a aVar;
            Object obj3;
            Exception exception = j.getException();
            if (exception == null) {
                if (j.isCanceled()) {
                    aVar = 0;
                    p.a.a(this.a, aVar, 1, aVar);
                } else {
                    obj3 = j.getResult();
                    aVar = p.a;
                    p.a(obj3);
                    this.a.resumeWith(obj3);
                }
            } else {
                aVar = p.a;
                pVar = q.a(exception);
                p.a(pVar);
                this.a.resumeWith(pVar);
            }
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n", d2 = {"<anonymous>", "", "T", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Throwable, w> {

        final b $cancellationTokenSource;
        b(b b) {
            this.$cancellationTokenSource = b;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            this.$cancellationTokenSource.a();
        }
    }
    public static final <T> Object a(j<T> j, d<? super T> d2) {
        return a.b(j, 0, d2);
    }

    private static final <T> Object b(j<T> j, b b2, d<? super T> d3) {
        Object obj3;
        if (j.isComplete()) {
            Exception obj4 = j.getException();
            if (obj4 != null) {
            } else {
                if (j.isCanceled()) {
                } else {
                    return j.getResult();
                }
                StringBuilder obj5 = new StringBuilder();
                obj5.append("Task ");
                obj5.append(j);
                obj5.append(" was cancelled normally.");
                obj4 = new CancellationException(obj5.toString());
                throw obj4;
            }
            throw obj4;
        }
        q qVar = new q(b.c(d3), 1);
        qVar.B();
        a.a aVar = new a.a(qVar);
        j.addOnCompleteListener(aVar);
        if (b2 != null) {
            obj3 = new a.b(b2);
            qVar.g(obj3);
        }
        obj3 = qVar.y();
        if (obj3 == b.d()) {
            h.c(d3);
        }
        return obj3;
    }
}
