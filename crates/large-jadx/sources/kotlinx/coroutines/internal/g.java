package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.k.a.e;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.u2;
import kotlinx.coroutines.z0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\u0008\u0000\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u00028\u00000O2\u00060?j\u0002`@2\u0008\u0012\u0004\u0012\u00028\u00000\u0004B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\u0008\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\u0008¢\u0006\u0004\u0008\t\u0010\nJ!\u0010\u0011\u001a\u00020\u00082\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012¢\u0006\u0004\u0008\u0013\u0010\u0014J\u001f\u0010\u001a\u001a\u00020\u00082\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00028\u0000H\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cH\u0016¢\u0006\u0004\u0008\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\u0008 \u0010!J\u0015\u0010\"\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\u0008\"\u0010#J\r\u0010$\u001a\u00020\u0008¢\u0006\u0004\u0008$\u0010\nJH\u0010+\u001a\u00020\u00082\u000c\u0010&\u001a\u0008\u0012\u0004\u0012\u00028\u00000%2%\u0008\u0008\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\u000c\u0008(\u0012\u0008\u0008)\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u00020\u0008\u0018\u00010'H\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,J\u001a\u0010.\u001a\u00020\u001f2\u0008\u0010-\u001a\u0004\u0018\u00010\u000bH\u0086\u0008¢\u0006\u0004\u0008.\u0010/J!\u00100\u001a\u00020\u00082\u000c\u0010&\u001a\u0008\u0012\u0004\u0012\u00028\u00000%H\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u00080\u00101J \u00102\u001a\u00020\u00082\u000c\u0010&\u001a\u0008\u0012\u0004\u0012\u00028\u00000%H\u0016ø\u0001\u0000¢\u0006\u0004\u00082\u00101J\u0011\u00105\u001a\u0004\u0018\u00010\u000bH\u0010¢\u0006\u0004\u00083\u00104J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\u00087\u00108J\u001b\u0010:\u001a\u0004\u0018\u00010\r2\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u000309¢\u0006\u0004\u0008:\u0010;R\u001e\u0010<\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\u000c\n\u0004\u0008<\u0010=\u0012\u0004\u0008>\u0010\nR\u001c\u0010C\u001a\n\u0018\u00010?j\u0004\u0018\u0001`@8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008A\u0010BR\u0014\u0010\u0016\u001a\u00020\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008D\u0010ER\u001a\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0005\u0010FR\u0014\u0010G\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\u0008G\u0010=R\u001a\u0010J\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00048PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008H\u0010IR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010KR\u001a\u0010M\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008L\u0010\u0014\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006N", d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "", "awaitReusability", "()V", "", "takenState", "", "cause", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "isReusable", "()Z", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "release", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "resumeCancellableWith", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "state", "resumeCancelled", "(Ljava/lang/Object;)Z", "resumeUndispatchedWith", "(Ljava/lang/Object;)V", "resumeWith", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CancellableContinuation;", "tryReleaseClaimedContinuation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "_state", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g<T>  extends z0<T> implements e, d<T> {

    private static final AtomicReferenceFieldUpdater z;
    private volatile Object _reusableCancellableContinuation = null;
    public final h0 v;
    public final d<T> w;
    public Object x;
    public final Object y;
    static {
        g.z = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_reusableCancellableContinuation");
    }

    public g(h0 h0, d<? super T> d2) {
        super(-1);
        this.v = h0;
        this.w = d2;
        this.x = h.a();
        this.y = d0.b(getContext());
        int obj2 = 0;
    }

    private final q<?> o() {
        Object _reusableCancellableContinuation;
        if (_reusableCancellableContinuation instanceof q) {
        } else {
            _reusableCancellableContinuation = 0;
        }
        return _reusableCancellableContinuation;
    }

    @Override // kotlinx.coroutines.z0
    public void b(Object object, Throwable throwable2) {
        Object obj2;
        if (object instanceof c0) {
            object.b.invoke(throwable2);
        }
    }

    public d<T> c() {
        return this;
    }

    @Override // kotlinx.coroutines.z0
    public e getCallerFrame() {
        d dVar;
        if (dVar instanceof e) {
        } else {
            dVar = 0;
        }
        return dVar;
    }

    @Override // kotlinx.coroutines.z0
    public g getContext() {
        return this.w.getContext();
    }

    @Override // kotlinx.coroutines.z0
    public java.lang.StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.z0
    public Object i() {
        boolean z;
        Object obj = this.x;
        if (q0.a()) {
            z = obj != h.a() ? 1 : 0;
            if (z == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        this.x = h.a();
        return obj;
    }

    @Override // kotlinx.coroutines.z0
    public final void m() {
        while (this._reusableCancellableContinuation != h.b) {
        }
    }

    public final q<T> n() {
        boolean compareAndSet;
        kotlinx.coroutines.internal.z zVar;
        Object _reusableCancellableContinuation = this._reusableCancellableContinuation;
        while (_reusableCancellableContinuation == null) {
            _reusableCancellableContinuation = this._reusableCancellableContinuation;
        }
        this._reusableCancellableContinuation = h.b;
        return 0;
    }

    @Override // kotlinx.coroutines.z0
    public final boolean q() {
        int i;
        i = this._reusableCancellableContinuation != null ? 1 : 0;
        return i;
    }

    @Override // kotlinx.coroutines.z0
    public final boolean r(Throwable throwable) {
        boolean compareAndSet;
        Object obj;
        int i;
        Object _reusableCancellableContinuation = this._reusableCancellableContinuation;
        obj = h.b;
        final int i2 = 1;
        while (n.b(_reusableCancellableContinuation, obj)) {
            _reusableCancellableContinuation = this._reusableCancellableContinuation;
            obj = h.b;
            i2 = 1;
        }
        return i2;
    }

    @Override // kotlinx.coroutines.z0
    public void resumeWith(Object object) {
        g context;
        Object context2;
        boolean z;
        int i;
        Object obj7;
        context = this.w.getContext();
        final int i2 = 0;
        final int i3 = 1;
        context2 = e0.d(object, i2, i3, i2);
        i = 0;
        if (this.v.L(context)) {
            this.x = context2;
            this.c = i;
            this.v.K(context, this);
        } else {
            boolean z2 = q0.a();
            context = u2.a.a();
            if (context.g0()) {
                this.x = context2;
                this.c = i;
                context.U(this);
            } else {
                context.Y(i3);
                context2 = getContext();
                this.w.resumeWith(object);
                obj7 = w.a;
                d0.a(context2, d0.c(context2, this.y));
                while (context.l0() == null) {
                }
                context.M(i3);
            }
        }
    }

    @Override // kotlinx.coroutines.z0
    public final void s() {
        m();
        final q qVar = o();
        if (qVar == null) {
        } else {
            qVar.s();
        }
    }

    @Override // kotlinx.coroutines.z0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DispatchedContinuation[");
        stringBuilder.append(this.v);
        stringBuilder.append(", ");
        stringBuilder.append(r0.c(this.w));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final Throwable u(p<?> p) {
        Object _reusableCancellableContinuation = this._reusableCancellableContinuation;
        final kotlinx.coroutines.internal.z zVar = h.b;
        final int i = 0;
        while (_reusableCancellableContinuation == zVar) {
            _reusableCancellableContinuation = this._reusableCancellableContinuation;
            zVar = h.b;
            i = 0;
        }
        if (!_reusableCancellableContinuation instanceof Throwable) {
        } else {
            if (!g.z.compareAndSet(this, _reusableCancellableContinuation, i)) {
            } else {
                return (Throwable)_reusableCancellableContinuation;
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("Failed requirement.".toString());
            throw obj4;
        }
        IllegalStateException illegalStateException = new IllegalStateException(n.o("Inconsistent state ", _reusableCancellableContinuation).toString());
        throw illegalStateException;
    }
}
