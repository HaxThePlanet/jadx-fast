package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h0.g;
import kotlin.w;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.p;
import kotlinx.coroutines.w0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\u001c\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0013\u0010\u0017\u001a\u00020\t2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010!\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00100#H\u0016J\u0008\u0010$\u001a\u00020\u0006H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00020\u0000X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%", d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "cancelOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a extends kotlinx.coroutines.android.b implements w0 {

    private volatile kotlinx.coroutines.android.a _immediate;
    private final Handler b;
    private final String c;
    private final boolean v;
    private final kotlinx.coroutines.android.a w;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¨\u0006\u0002", d2 = {"<anonymous>", "", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b implements Runnable {

        final p a;
        final kotlinx.coroutines.android.a b;
        public b(p p, kotlinx.coroutines.android.a a2) {
            this.a = p;
            this.b = a2;
            super();
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.k(this.b, w.a);
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000", d2 = {"kotlinx/coroutines/JobKt__JobKt$DisposableHandle$1", "Lkotlinx/coroutines/DisposableHandle;", "dispose", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements e1 {

        final kotlinx.coroutines.android.a a;
        final Runnable b;
        public a(kotlinx.coroutines.android.a a, Runnable runnable2) {
            this.a = a;
            this.b = runnable2;
            super();
        }

        @Override // kotlinx.coroutines.e1
        public void dispose() {
            a.U(this.a).removeCallbacks(this.b);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<Throwable, w> {

        final Runnable $block;
        final kotlinx.coroutines.android.a this$0;
        c(kotlinx.coroutines.android.a a, Runnable runnable2) {
            this.this$0 = a;
            this.$block = runnable2;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            a.U(this.this$0).removeCallbacks(this.$block);
        }
    }
    public a(Handler handler, String string2) {
        super(handler, string2, 0);
    }

    public a(Handler handler, String string2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(handler, obj2);
    }

    private a(Handler handler, String string2, boolean z3) {
        int i;
        Object obj2;
        kotlinx.coroutines.android.a obj4;
        super(0);
        this.b = handler;
        this.c = string2;
        this.v = z3;
        i = z3 ? this : i;
        this._immediate = i;
        if (this._immediate == null) {
            obj4 = new a(handler, string2, 1);
            this._immediate = obj4;
            obj2 = w.a;
        }
        this.w = obj4;
    }

    public static final Handler U(kotlinx.coroutines.android.a a) {
        return a.b;
    }

    private final void V(g g, Runnable runnable2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The task was rejected, the handler underlying the dispatcher '");
        stringBuilder.append(this);
        stringBuilder.append("' was closed");
        CancellationException cancellationException = new CancellationException(stringBuilder.toString());
        b2.c(g, cancellationException);
        c1.b().K(g, runnable2);
    }

    @Override // kotlinx.coroutines.android.b
    public void K(g g, Runnable runnable2) {
        if (!this.b.post(runnable2)) {
            V(g, runnable2);
        }
    }

    @Override // kotlinx.coroutines.android.b
    public boolean L(g g) {
        Looper looper;
        int obj2;
        if (this.v) {
            if (!n.b(Looper.myLooper(), this.b.getLooper())) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // kotlinx.coroutines.android.b
    public j2 M() {
        return Y();
    }

    @Override // kotlinx.coroutines.android.b
    public kotlinx.coroutines.android.a Y() {
        return this.w;
    }

    @Override // kotlinx.coroutines.android.b
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof a && object.b == this.b) {
            obj2 = object.b == this.b ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // kotlinx.coroutines.android.b
    public int hashCode() {
        return System.identityHashCode(this.b);
    }

    public void j(long l, p<? super w> p2) {
        Object obj5;
        a.b bVar = new a.b(obj7, this);
        if (this.b.postDelayed(bVar, g.f(l, p2))) {
            obj5 = new a.c(this, bVar);
            obj7.g(obj5);
        } else {
            V(obj7.getContext(), bVar);
        }
    }

    @Override // kotlinx.coroutines.android.b
    public String toString() {
        String string;
        boolean str;
        if (T() == null && this.c == null) {
            if (this.c == null) {
                string = this.b.toString();
            }
            if (this.v) {
                string = n.o(string, ".immediate");
            }
        }
        return string;
    }

    @Override // kotlinx.coroutines.android.b
    public e1 x(long l, Runnable runnable2, g g3) {
        if (this.b.postDelayed(g3, g.f(l, runnable2))) {
            a.a obj4 = new a.a(this, g3);
            return obj4;
        }
        V(obj7, g3);
        return l2.a;
    }
}
