package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.h;
import kotlin.d0.d.n;
import kotlin.p;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0006\n\u0002\u0010\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u000e:\u0002\u000b\u000cB\u001d\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u000c\u0008\u0001\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00030\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0019\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\tR\"\u0010\u0004\u001a\u0010\u0012\u000c\u0008\u0001\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0004\u0010\n\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\r", d2 = {"Lkotlinx/coroutines/AwaitAll;", "T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 5, 1}, xi = 48)
final class g<T>  {

    static final AtomicIntegerFieldUpdater b;
    private final kotlinx.coroutines.u0<T>[] a;
    volatile int notCompletedCount;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\u0008\u0082\u0004\u0018\u00002\u00020\u001cB\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00020\u0001¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\u00082\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\u0008\t\u0010\nR \u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u000bR<\u0010\u0013\u001a\u000e\u0018\u00010\u000cR\u0008\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\u000e\u001a\u000e\u0018\u00010\u000cR\u0008\u0012\u0004\u0012\u00028\u00000\r8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\u0008\u0015\u0010\u0016\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a¨\u0006\u001b", d2 = {"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "", "cause", "", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobNode;"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class a extends kotlinx.coroutines.e2 {

        private volatile Object _disposer = null;
        private final kotlinx.coroutines.p<List<? extends T>> w;
        public kotlinx.coroutines.e1 x;
        final kotlinx.coroutines.g<T> y;
        public a(kotlinx.coroutines.g g, kotlinx.coroutines.p p2) {
            this.y = g;
            super();
            this.w = p2;
            final int obj1 = 0;
        }

        public final kotlinx.coroutines.g.b<T> B() {
            return (g.b)this._disposer;
        }

        @Override // kotlinx.coroutines.e2
        public final kotlinx.coroutines.e1 C() {
            kotlinx.coroutines.e1 e1Var = this.x;
            if (e1Var == null) {
            } else {
                return e1Var;
            }
            n.w("handle");
            throw 0;
        }

        public final void D(kotlinx.coroutines.g.b<T> g.b) {
            this._disposer = g.b;
        }

        @Override // kotlinx.coroutines.e2
        public final void E(kotlinx.coroutines.e1 e1) {
            this.x = e1;
        }

        @Override // kotlinx.coroutines.e2
        public Object invoke(Object object) {
            y((Throwable)object);
            return w.a;
        }

        @Override // kotlinx.coroutines.e2
        public void y(Throwable throwable) {
            Object obj2;
            ArrayList arrayList;
            int length;
            int i;
            Object obj;
            int obj6;
            if (throwable != null) {
                obj6 = this.w.h(throwable);
                if (obj6 != null) {
                    this.w.x(obj6);
                    obj6 = B();
                    if (obj6 == null) {
                    } else {
                        obj6.b();
                    }
                }
            } else {
                if (g.b.decrementAndGet(this.y) == 0) {
                    kotlinx.coroutines.u0[] objArr = g.a(this.y);
                    arrayList = new ArrayList(objArr.length);
                    i = 0;
                    while (i < objArr.length) {
                        arrayList.add(objArr[i].f());
                        i++;
                    }
                    obj2 = p.a;
                    p.a(arrayList);
                    this.w.resumeWith(arrayList);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\u000c0\u0004R\u0008\u0012\u0004\u0012\u00028\u00000\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0008\u001a\u00020\tJ\u0013\u0010\n\u001a\u00020\t2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0096\u0002J\u0008\u0010\r\u001a\u00020\u000eH\u0016R \u0010\u0002\u001a\u0012\u0012\u000e\u0012\u000c0\u0004R\u0008\u0012\u0004\u0012\u00028\u00000\u00050\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000f", d2 = {"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "nodes", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "disposeAll", "", "invoke", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private final class b extends kotlinx.coroutines.n {

        private final kotlinx.coroutines.g.a<T>[] a;
        public b(kotlinx.coroutines.g g, kotlinx.coroutines.g.a[] g$a2Arr2) {
            super();
            this.a = a2Arr2;
        }

        @Override // kotlinx.coroutines.n
        public void a(Throwable throwable) {
            b();
        }

        @Override // kotlinx.coroutines.n
        public final void b() {
            int i;
            kotlinx.coroutines.e1 e1Var;
            final kotlinx.coroutines.g.a[] objArr = this.a;
            i = 0;
            while (i < objArr.length) {
                objArr[i].C().dispose();
                i++;
            }
        }

        @Override // kotlinx.coroutines.n
        public Object invoke(Object object) {
            a((Throwable)object);
            return w.a;
        }

        @Override // kotlinx.coroutines.n
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DisposeHandlersOnCancel[");
            stringBuilder.append(this.a);
            stringBuilder.append(']');
            return stringBuilder.toString();
        }
    }
    static {
        g.b = AtomicIntegerFieldUpdater.newUpdater(g.class, "notCompletedCount");
    }

    public g(kotlinx.coroutines.u0<? extends T>[] u0Arr) {
        super();
        this.a = u0Arr;
        this.notCompletedCount = u0Arr.length;
    }

    public static final kotlinx.coroutines.u0[] a(kotlinx.coroutines.g g) {
        return g.a;
    }

    public final Object b(d<? super List<? extends T>> d) {
        int i;
        int i2;
        w wVar;
        kotlinx.coroutines.g.a aVar;
        q qVar = new q(b.c(d), 1);
        qVar.B();
        int length = objArr.length;
        kotlinx.coroutines.g.a[] arr = new g.a[length];
        i2 = i;
        while (i2 < length) {
            kotlinx.coroutines.u0 u0Var = g.a(this)[i2];
            u0Var.start();
            aVar = new g.a(this, qVar);
            aVar.E(u0Var.w(aVar));
            wVar = w.a;
            arr[i2] = aVar;
            i2++;
        }
        g.b bVar = new g.b(this, arr);
        while (i < length) {
            arr[i].D(bVar);
            i++;
        }
        if (qVar.t()) {
            bVar.b();
        } else {
            qVar.g(bVar);
        }
        Object obj = qVar.y();
        if (obj == b.d()) {
            h.c(d);
        }
        return obj;
    }
}
