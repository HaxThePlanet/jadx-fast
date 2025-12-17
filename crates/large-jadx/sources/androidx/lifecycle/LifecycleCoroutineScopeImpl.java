package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000c¢\u0006\u0004\u0008\u0018\u0010\u0019J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\n\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\u000c8\u0016@\u0016X\u0096\u0004¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00128\u0010@\u0010X\u0090\u0004¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006\u001a", d2 = {"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/l;", "Landroidx/lifecycle/n;", "Lkotlin/w;", "f", "()V", "Landroidx/lifecycle/q;", "source", "Landroidx/lifecycle/j$b;", "event", "c", "(Landroidx/lifecycle/q;Landroidx/lifecycle/j$b;)V", "Lkotlin/b0/g;", "b", "Lkotlin/b0/g;", "r", "()Lkotlin/b0/g;", "coroutineContext", "Landroidx/lifecycle/j;", "a", "Landroidx/lifecycle/j;", "e", "()Landroidx/lifecycle/j;", "lifecycle", "<init>", "(Landroidx/lifecycle/j;Lkotlin/b0/g;)V", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
public final class LifecycleCoroutineScopeImpl extends androidx.lifecycle.l implements androidx.lifecycle.n {

    private final androidx.lifecycle.j a;
    private final g b;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\u0008\u0002\u0010\u0003", d2 = {"Lkotlinx/coroutines/m0;", "Lkotlin/w;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    @f(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        private Object L$0;
        int label;
        final androidx.lifecycle.LifecycleCoroutineScopeImpl this$0;
        a(androidx.lifecycle.LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, d d2) {
            this.this$0 = lifecycleCoroutineScopeImpl;
            super(2, d2);
        }

        public final d<w> create(Object object, d<?> d2) {
            n.f(d2, "completion");
            LifecycleCoroutineScopeImpl.a aVar = new LifecycleCoroutineScopeImpl.a(this.this$0, d2);
            aVar.L$0 = object;
            return aVar;
        }

        @Override // kotlin.b0.k.a.k
        public final Object invoke(Object object, Object object2) {
            return (LifecycleCoroutineScopeImpl.a)create(object, (d)object2).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int this$0;
            int iNITIALIZED;
            Object obj3;
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                if (this.this$0.e().b().compareTo(j.c.INITIALIZED) >= 0) {
                    this.this$0.e().a(this.this$0);
                } else {
                    iNITIALIZED = 0;
                    b2.d((m0)this.L$0.r(), iNITIALIZED, 1, iNITIALIZED);
                }
                return w.a;
            }
            obj3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj3;
        }
    }
    public LifecycleCoroutineScopeImpl(androidx.lifecycle.j j, g g2) {
        String str;
        Object obj2;
        androidx.lifecycle.j.c obj3;
        n.f(j, "lifecycle");
        n.f(g2, "coroutineContext");
        super();
        this.a = j;
        this.b = g2;
        if (e().b() == j.c.DESTROYED) {
            str = 0;
            b2.d(r(), str, 1, str);
        }
    }

    @Override // androidx.lifecycle.l
    public void c(androidx.lifecycle.q q, androidx.lifecycle.j.b j$b2) {
        String str;
        int obj2;
        androidx.lifecycle.j.c obj3;
        n.f(q, "source");
        n.f(b2, "event");
        if (e().b().compareTo(j.c.DESTROYED) <= 0) {
            e().c(this);
            str = 0;
            b2.d(r(), str, 1, str);
        }
    }

    @Override // androidx.lifecycle.l
    public androidx.lifecycle.j e() {
        return this.a;
    }

    @Override // androidx.lifecycle.l
    public final void f() {
        LifecycleCoroutineScopeImpl.a aVar = new LifecycleCoroutineScopeImpl.a(this, 0);
        k.d(this, c1.c().M(), 0, aVar, 2, 0);
    }

    @Override // androidx.lifecycle.l
    public g r() {
        return this.b;
    }
}
