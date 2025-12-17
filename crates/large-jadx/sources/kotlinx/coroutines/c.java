package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.d0.c.p;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008'\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\u0008\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0008\u0010\u0019\u001a\u00020\u001aH\u0014J\u0015\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\u0008\u001eJ\r\u0010\u001f\u001a\u00020\u001aH\u0010¢\u0006\u0002\u0008 J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\tH\u0014J\u0015\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010&J\u0012\u0010'\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0004J\u001c\u0010(\u001a\u00020\u00162\u000c\u0010)\u001a\u0008\u0012\u0004\u0012\u00028\u00000*ø\u0001\u0000¢\u0006\u0002\u0010&JM\u0010+\u001a\u00020\u0016\"\u0004\u0008\u0001\u0010,2\u0006\u0010+\u001a\u00020-2\u0006\u0010.\u001a\u0002H,2'\u0010/\u001a#\u0008\u0001\u0012\u0004\u0012\u0002H,\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001800¢\u0006\u0002\u00081ø\u0001\u0000¢\u0006\u0002\u00102R\u0017\u0010\u000c\u001a\u00020\u0007¢\u0006\u000e\n\u0000\u0012\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00063", d2 = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "initParentJob", "", "active", "(Lkotlin/coroutines/CoroutineContext;ZZ)V", "context", "getContext$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", "", "state", "", "cancellationExceptionMessage", "", "handleOnCompletionException", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class c<T>  extends kotlinx.coroutines.f2 implements kotlinx.coroutines.y1, d<T>, kotlinx.coroutines.m0 {

    private final g b;
    public c(g g, boolean z2, boolean z3) {
        kotlin.b0.g.b obj2;
        super(z3);
        if (z2 != null) {
            f0((y1)g.get(y1.s));
        }
        this.b = g.plus(this);
    }

    @Override // kotlinx.coroutines.f2
    protected void G0(Object object) {
        C(object);
    }

    @Override // kotlinx.coroutines.f2
    protected void H0(Throwable throwable, boolean z2) {
    }

    protected void I0(T t) {
    }

    public final <R> void J0(kotlinx.coroutines.o0 o0, R r2, p<? super R, ? super d<? super T>, ? extends Object> p3) {
        o0.invoke(p3, r2, this);
    }

    @Override // kotlinx.coroutines.f2
    protected String O() {
        return n.o(r0.a(this), " was cancelled");
    }

    @Override // kotlinx.coroutines.f2
    public boolean a() {
        return super.a();
    }

    @Override // kotlinx.coroutines.f2
    public final void e0(Throwable throwable) {
        j0.a(this.b, throwable);
    }

    @Override // kotlinx.coroutines.f2
    public final g getContext() {
        return this.b;
    }

    @Override // kotlinx.coroutines.f2
    public String l0() {
        String str = g0.b(this.b);
        if (str == null) {
            return super.l0();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('"');
        stringBuilder.append(str);
        stringBuilder.append("\":");
        stringBuilder.append(super.l0());
        return stringBuilder.toString();
    }

    @Override // kotlinx.coroutines.f2
    protected final void q0(Object object) {
        Throwable th;
        boolean obj2;
        if (object instanceof b0) {
            H0(object.a, (b0)object.a());
        } else {
            I0(object);
        }
    }

    @Override // kotlinx.coroutines.f2
    public g r() {
        return this.b;
    }

    @Override // kotlinx.coroutines.f2
    public final void resumeWith(Object object) {
        int i = 0;
        Object obj3 = j0(e0.d(object, i, 1, i));
        if (obj3 == g2.b) {
        }
        G0(obj3);
    }
}
