package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.b0.g;
import kotlin.b0.g.b;
import kotlin.b0.g.b.a;
import kotlin.b0.g.c;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008f\u0018\u0000 (2\u00020\u0001:\u0001(J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H'J\u0008\u0010\u0013\u001a\u00020\u0014H\u0017J\u0014\u0010\u0013\u001a\u00020\u00072\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H'J\u001a\u0010\u0013\u001a\u00020\u00142\u0010\u0008\u0002\u0010\u0015\u001a\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u0018H&J\u000c\u0010\u0019\u001a\u00060\u0017j\u0002`\u0018H'JE\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00072'\u0010\u001e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\u000c\u0008 \u0012\u0008\u0008!\u0012\u0004\u0008\u0008(\u0015\u0012\u0004\u0012\u00020\u00140\u001fj\u0002`\"H'J1\u0010\u001a\u001a\u00020\u001b2'\u0010\u001e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\u000c\u0008 \u0012\u0008\u0008!\u0012\u0004\u0008\u0008(\u0015\u0012\u0004\u0012\u00020\u00140\u001fj\u0002`\"H&J\u0011\u0010#\u001a\u00020\u0014H¦@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0011\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0097\u0002J\u0008\u0010'\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0008R\u0012\u0010\t\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0008R\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0008R\u0012\u0010\u000b\u001a\u00020\u000cX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006)", d2 = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface y1 extends g.b {

    public static final kotlinx.coroutines.y1.b s;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static void a(kotlinx.coroutines.y1 y1, CancellationException cancellationException2, int i3, Object object4) {
            int obj1;
            if (object4 != null) {
            } else {
                if (i3 &= 1 != 0) {
                    obj1 = 0;
                }
                y1.c(obj1);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            throw obj0;
        }

        public static <R> R b(kotlinx.coroutines.y1 y1, R r2, p<? super R, ? super g.b, ? extends R> p3) {
            return g.b.a.a(y1, r2, p3);
        }

        public static <E extends g.b> E c(kotlinx.coroutines.y1 y1, g.c<E> g$c2) {
            return g.b.a.b(y1, c2);
        }

        public static kotlinx.coroutines.e1 d(kotlinx.coroutines.y1 y1, boolean z2, boolean z3, l l4, int i5, Object object6) {
            int obj1;
            int obj2;
            if (object6 != null) {
            } else {
                if (i5 & 1 != 0) {
                    obj1 = 0;
                }
                if (i5 &= 2 != 0) {
                    obj2 = 1;
                }
                return y1.m(obj1, obj2, l4);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            throw obj0;
        }

        public static g e(kotlinx.coroutines.y1 y1, g.c<?> g$c2) {
            return g.b.a.c(y1, c2);
        }

        public static g f(kotlinx.coroutines.y1 y1, g g2) {
            return g.b.a.d(y1, g2);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b implements g.c<kotlinx.coroutines.y1> {

        static final kotlinx.coroutines.y1.b a;
        static {
            y1.b bVar = new y1.b();
            y1.b.a = bVar;
        }
    }
    static {
        y1.s = y1.b.a;
    }

    @Override // kotlin.b0.g$b
    public abstract kotlinx.coroutines.v J(kotlinx.coroutines.x x);

    @Override // kotlin.b0.g$b
    public abstract boolean a();

    @Override // kotlin.b0.g$b
    public abstract void c(CancellationException cancellationException);

    public abstract kotlinx.coroutines.e1 m(boolean z, boolean z2, l<? super Throwable, w> l3);

    @Override // kotlin.b0.g$b
    public abstract CancellationException n();

    @Override // kotlin.b0.g$b
    public abstract boolean start();

    public abstract kotlinx.coroutines.e1 w(l<? super Throwable, w> l);
}
