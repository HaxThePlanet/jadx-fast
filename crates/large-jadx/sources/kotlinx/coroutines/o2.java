package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.p;
import kotlin.q;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0096\u0002R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class o2<T>  extends kotlinx.coroutines.e2 {

    private final kotlinx.coroutines.q<T> w;
    public o2(kotlinx.coroutines.q<? super T> q) {
        super();
        this.w = q;
    }

    @Override // kotlinx.coroutines.e2
    public Object invoke(Object object) {
        y((Throwable)object);
        return w.a;
    }

    @Override // kotlinx.coroutines.e2
    public void y(Throwable throwable) {
        boolean z;
        kotlinx.coroutines.q qVar;
        kotlin.p.a aVar;
        Object obj3;
        obj3 = z().c0();
        if (q0.a()) {
            if (z2 ^= 1 == 0) {
            } else {
            }
            obj3 = new AssertionError();
            throw obj3;
        }
        if (obj3 instanceof b0) {
            aVar = p.a;
            obj3 = q.a(obj3.a);
            p.a(obj3);
            this.w.resumeWith(obj3);
        } else {
            obj3 = g2.h((b0)obj3);
            aVar = p.a;
            p.a(obj3);
            this.w.resumeWith(obj3);
        }
    }
}
