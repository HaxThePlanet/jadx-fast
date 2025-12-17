package app.dogo.com.dogo_android.util;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.b3.d;
import kotlinx.coroutines.b3.e;
import kotlinx.coroutines.b3.f;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.x0;
import kotlinx.coroutines.y1;
import kotlinx.coroutines.y1.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u001d\u001a\u00020\u0018H\u0002J\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0007J\u0008\u0010 \u001a\u00020\u0007H\u0002J\u0006\u0010!\u001a\u00020\u0007J1\u0010\"\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00072!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0004\u0012\u00020\u00180\u0014J\u0006\u0010#\u001a\u00020\u0018J\u0014\u0010$\u001a\u00020\u00182\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006J\u0012\u0010&\u001a\u00020\u00182\n\u0008\u0002\u0010'\u001a\u0004\u0018\u00010(J\u0016\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00180*2\u0006\u0010+\u001a\u00020\u0007H\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u000c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\nR\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R+\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/util/TrainingTimer;", "", "disableTicker", "", "(Z)V", "customTimeReference", "Lkotlin/Function0;", "", "frozenSessionTimeMs", "isFrozen", "()Z", "isPaused", "isRunning", "lastFreezeTimeMs", "lastPauseTimeMs", "lastStartTimeMs", "lastStopTimeMs", "getLastStopTimeMs", "()J", "onTickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "totalElapsedTimeMs", "", "previousSessionsTimeMs", "ticker", "Lkotlinx/coroutines/Job;", "tickerPeriodMs", "cancelTimerCallback", "freeze", "getElapsedTimeMs", "getReferenceTimeMs", "getSessionElapsedTimeMs", "initTicker", "pause", "setCustomTimeReference", "reference", "start", "tickerScope", "Lkotlinx/coroutines/CoroutineScope;", "tickerFlow", "Lkotlinx/coroutines/flow/Flow;", "periodMs", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a0 {

    private final boolean a;
    private y1 b;
    private a<Long> c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;
    private l<? super Long, w> j;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@", d2 = {"<anonymous>", "", "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.util.TrainingTimer$start$1", f = "TrainingTimer.kt", l = {}, m = "invokeSuspend")
    static final class a extends k implements p<w, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.util.a0 this$0;
        a(app.dogo.com.dogo_android.util.a0 a0, d<? super app.dogo.com.dogo_android.util.a0.a> d2) {
            this.this$0 = a0;
            super(2, d2);
        }

        public final Object c(w w, d<? super w> d2) {
            return (a0.a)create(w, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            a0.a obj2 = new a0.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((w)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Long label;
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                l obj3 = a0.a(this.this$0);
                if (obj3 == null) {
                } else {
                    obj3.invoke(b.d(this.this$0.d()));
                }
                return w.a;
            }
            obj3 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj3;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.util.TrainingTimer$tickerFlow$1", f = "TrainingTimer.kt", l = {129, 130}, m = "invokeSuspend")
    static final class b extends k implements p<e<? super w>, d<? super w>, Object> {

        final long $periodMs;
        private Object L$0;
        int label;
        b(long l, d<? super app.dogo.com.dogo_android.util.a0.b> d2) {
            this.$periodMs = l;
            super(2, obj3);
        }

        public final Object c(e<? super w> e, d<? super w> d2) {
            return (a0.b)create(e, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            a0.b bVar = new a0.b(this.$periodMs, obj2, d2);
            bVar.L$0 = object;
            return bVar;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((e)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            Object obj;
            Object obj2;
            Object obj7;
            Object obj3 = b.d();
            label = this.label;
            final int i = 2;
            final int i2 = 1;
            if (label != 0) {
                if (label != i2) {
                    if (label != i) {
                    } else {
                        q.b(object);
                        obj7 = label;
                        obj = this;
                        obj.L$0 = obj7;
                        obj.label = i2;
                        if (obj7.b(w.a, obj) != obj3) {
                            obj.L$0 = obj7;
                            obj.label = i;
                            if (x0.a(obj.$periodMs, obj5) == obj3) {
                                return obj3;
                            } else {
                            }
                        }
                    }
                    obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj7;
                }
                q.b(object);
                obj7 = l$0;
                obj = this;
            } else {
                q.b(object);
                obj7 = this.L$0;
            }
            return obj3;
        }
    }
    public a0(boolean z) {
        super();
        this.a = z;
        this.i = 1000;
    }

    public a0(boolean z, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final l a(app.dogo.com.dogo_android.util.a0 a0) {
        return a0.j;
    }

    private final void b() {
        int i;
        final y1 y1Var = this.b;
        final int i2 = 0;
        if (y1Var == null) {
        } else {
            y1.a.a(y1Var, i2, 1, i2);
        }
        this.b = i2;
    }

    private final long e() {
        long l;
        int i;
        long l2 = this.f;
        if (Long.compare(l2, l) < 0) {
        } else {
            l = i;
        }
        final long l4 = this.h;
        if (Long.compare(l2, l4) < 0) {
            i = l4;
        }
        return Math.max(l, obj3);
    }

    private final long f() {
        int invoke;
        long currentTimeMillis;
        a aVar = this.c;
        if (aVar == null) {
            invoke = 0;
        } else {
            invoke = aVar.invoke();
        }
        if (invoke == 0) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            currentTimeMillis = invoke.longValue();
        }
        return currentTimeMillis;
    }

    public static void n(app.dogo.com.dogo_android.util.a0 a0, m0 m02, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        a0.m(obj1);
    }

    private final d<w> o(long l) {
        a0.b bVar = new a0.b(l, obj4, 0);
        return f.e(bVar);
    }

    public final void c() {
        boolean z;
        if (k()) {
            this.h = f();
            b();
        }
    }

    public final long d() {
        return l += l2;
    }

    public final long g() {
        int i;
        long l;
        if (k()) {
            l2 -= l4;
            l = this.e;
        } else {
            l3 -= l5;
            l = this.e;
        }
        return i += l;
    }

    public final void h(long l, l<? super Long, w> l2) {
        n.f(obj4, "onTickListener");
        this.i = l;
        this.j = obj4;
    }

    public final boolean i() {
        int i;
        i = Long.compare(l, l2) > 0 ? 1 : 0;
        return i;
    }

    public final boolean j() {
        int i;
        i = Long.compare(l, l2) > 0 ? 1 : 0;
        return i;
    }

    public final boolean k() {
        int i;
        i = Long.compare(l, l2) < 0 ? 1 : 0;
        return i;
    }

    public final void l() {
        boolean z;
        if (k()) {
            this.g = f();
            b();
        }
    }

    public final void m(m0 m0) {
        long l;
        int aVar;
        int i2;
        int i;
        int i3;
        long l2;
        Object obj10;
        b();
        aVar = 0;
        if (j()) {
            this.d = l5 += i3;
            this.e = aVar;
        }
        if (i()) {
            this.e = l4 += i3;
        }
        this.g = aVar;
        this.h = aVar;
        this.f = f();
        if (m0 != null && !this.a) {
            if (!this.a) {
                aVar = new a0.a(this, 0);
                this.b = f.f(f.g(o(this.i), aVar), m0);
            }
        }
    }
}
