package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.e;
import kotlinx.coroutines.c;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.v;
import kotlinx.coroutines.y1;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0010\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008¢\u0006\u0002\u0010\tJ\u0012\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0018\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u000e\u0010\u0019\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001bR\u0019\u0010\n\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\u000e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00088\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "isScopedCoroutine", "", "()Z", "parent", "Lkotlinx/coroutines/Job;", "getParent$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "afterCompletion", "", "state", "", "afterResume", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class x<T>  extends c<T> implements e {

    public final d<T> c;
    public x(g g, d<? super T> d2) {
        final int i = 1;
        super(g, i, i);
        this.c = d2;
    }

    @Override // kotlinx.coroutines.c
    protected void C(Object object) {
        int i = 0;
        h.c(b.c(this.c), e0.a(object, this.c), i, 2, i);
    }

    @Override // kotlinx.coroutines.c
    protected void G0(Object object) {
        final d dVar = this.c;
        dVar.resumeWith(e0.a(object, dVar));
    }

    @Override // kotlinx.coroutines.c
    public final y1 K0() {
        int parent;
        v vVar = b0();
        if (vVar == null) {
            parent = 0;
        } else {
            parent = vVar.getParent();
        }
        return parent;
    }

    @Override // kotlinx.coroutines.c
    public final e getCallerFrame() {
        d dVar;
        if (dVar instanceof e) {
        } else {
            dVar = 0;
        }
        return dVar;
    }

    @Override // kotlinx.coroutines.c
    public final java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.c
    protected final boolean h0() {
        return 1;
    }
}
