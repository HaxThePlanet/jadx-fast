package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.d0.d.n;
import kotlin.p;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.d3.i;
import kotlinx.coroutines.d3.j;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.y;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u000e\u0008 \u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\u0008\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\u0008\u0014J\u001f\u0010\u0015\u001a\u0002H\u0001\"\u0004\u0008\u0001\u0010\u00012\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\u0008\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u000c2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001b\u001a\u00020\u000cJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\u0008\u001dR\u0018\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008X \u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", "", "takenState", "", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", "state", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class z0<T>  extends i {

    public int c;
    public z0(int i) {
        super();
        this.c = i;
    }

    @Override // kotlinx.coroutines.d3.i
    public void b(Object object, Throwable throwable2) {
    }

    public abstract d<T> c();

    @Override // kotlinx.coroutines.d3.i
    public Throwable d(Object object) {
        Throwable i;
        Object obj3;
        if (object instanceof b0) {
        } else {
            obj3 = i;
        }
        if (obj3 == null) {
        } else {
            i = obj3.a;
        }
        return i;
    }

    public <T> T e(Object object) {
        return object;
    }

    @Override // kotlinx.coroutines.d3.i
    public final void f(Throwable throwable, Throwable throwable2) {
        Throwable obj3;
        if (throwable == null && throwable2 == null) {
            if (throwable2 == null) {
            }
        }
        if (throwable != null && throwable2 != null) {
            if (throwable2 != null) {
                b.a(throwable, throwable2);
            }
        }
        if (throwable == null) {
            obj3 = throwable2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fatal exception in coroutines machinery for ");
        stringBuilder.append(this);
        stringBuilder.append(". Please read KDoc to 'handleFatalException' method and report this incident to maintainers");
        n.d(obj3);
        p0 obj4 = new p0(stringBuilder.toString(), obj3);
        j0.a(c().getContext(), obj4);
    }

    @Override // kotlinx.coroutines.d3.i
    public abstract Object i();

    @Override // kotlinx.coroutines.d3.i
    public final void run() {
        int z3;
        j jVar;
        Throwable th2;
        kotlin.p.a aVar;
        kotlin.p.a aVar2;
        Object obj;
        w wVar;
        boolean z2;
        int i;
        kotlin.b0.g.b bVar;
        Object exc;
        Object obj2;
        boolean obj3;
        kotlinx.coroutines.y1.b z;
        if (q0.a()) {
            z3 = this.c != -1 ? 1 : 0;
            if (z3 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        d dVar = c();
        d dVar2 = dVar.w;
        final g context = dVar2.getContext();
        Object obj5 = d0.c(context, dVar.y);
        final int i3 = 0;
        if (obj5 != d0.a) {
            i = g0.e(dVar2, context, obj5);
        } else {
            i = i3;
        }
        obj3 = i();
        final Throwable th3 = d(obj3);
        if (th3 == null && a1.b(this.c)) {
            if (a1.b(this.c)) {
                bVar = dVar2.getContext().get(y1.s);
            } else {
                bVar = i3;
            }
        } else {
        }
        if (bVar != null && !bVar.a()) {
            if (!bVar.a()) {
                exc = bVar.n();
                b(obj3, exc);
                kotlin.p.a aVar4 = p.a;
                if (q0.d()) {
                    if (!dVar2 instanceof e) {
                    } else {
                        exc = y.a(exc, (e)dVar2);
                    }
                }
                obj2 = q.a(exc);
                p.a(obj2);
                dVar2.resumeWith(obj2);
            } else {
                if (th3 != null) {
                    kotlin.p.a aVar3 = p.a;
                    obj2 = q.a(th3);
                    p.a(obj2);
                    dVar2.resumeWith(obj2);
                } else {
                    obj2 = e(obj3);
                    obj3 = p.a;
                    p.a(obj2);
                    dVar2.resumeWith(obj2);
                }
            }
        } else {
        }
        if (i != 0) {
            try {
                if (i.L0()) {
                }
                d0.a(context, obj5);
                aVar2 = p.a;
                this.b.k();
                p.a(w.a);
                aVar = p.a;
                obj = q.a(th);
                p.a(obj);
                f(i3, p.c(wVar));
                z2 = z2.L0();
                if (z2 && z2) {
                } else {
                }
                z2 = z2.L0();
                if (!z2) {
                } else {
                }
                d0.a(obj3, aVar);
                throw obj;
                obj = p.a;
                th.k();
                Throwable th = w.a;
                p.a(th);
                obj = p.a;
                th = q.a(th);
                p.a(th);
                th = p.c(th);
                f(aVar, th);
            } catch (Throwable th) {
            }
        } else {
        }
    }
}
