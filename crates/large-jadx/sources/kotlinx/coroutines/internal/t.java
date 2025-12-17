package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.b0.g;
import kotlin.d0.d.n;
import kotlin.w;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.p;
import kotlinx.coroutines.w0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0008\u0010\u001b\u001a\u00020\u000cH\u0002J\u001e\u0010\u001c\u001a\u00020\u000c2\u0006\u0010\u0018\u001a\u00020\u000e2\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0008\u0010 \u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006!", d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "isDispatchNeeded", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class t extends j2 implements w0 {

    private final Throwable b;
    private final String c;
    public t(Throwable throwable, String string2) {
        super();
        this.b = throwable;
        this.c = string2;
    }

    private final Void V() {
        String str;
        String str3;
        String str2;
        if (this.b == null) {
        } else {
            str = this.c;
            str3 = "";
            if (str == null) {
            } else {
                str = n.o(". ", str);
                if (str == null) {
                } else {
                    str3 = str;
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException(n.o("Module with the Main dispatcher had failed to initialize", str3), this.b);
            throw illegalStateException;
        }
        s.c();
        throw 0;
    }

    @Override // kotlinx.coroutines.j2
    public void K(g g, Runnable runnable2) {
        U(g, runnable2);
        throw 0;
    }

    @Override // kotlinx.coroutines.j2
    public boolean L(g g) {
        V();
        throw 0;
    }

    @Override // kotlinx.coroutines.j2
    public j2 M() {
        return this;
    }

    @Override // kotlinx.coroutines.j2
    public Void U(g g, Runnable runnable2) {
        V();
        throw 0;
    }

    public Void Y(long l, p<? super w> p2) {
        V();
        throw 0;
    }

    @Override // kotlinx.coroutines.j2
    public void j(long l, p p2) {
        Y(l, p2);
        throw 0;
    }

    @Override // kotlinx.coroutines.j2
    public String toString() {
        String str;
        String str2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dispatchers.Main[missing");
        Throwable th = this.b;
        if (th != null) {
            str = n.o(", cause=", th);
        } else {
            str = "";
        }
        stringBuilder.append(str);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override // kotlinx.coroutines.j2
    public e1 x(long l, Runnable runnable2, g g3) {
        V();
        throw 0;
    }
}
