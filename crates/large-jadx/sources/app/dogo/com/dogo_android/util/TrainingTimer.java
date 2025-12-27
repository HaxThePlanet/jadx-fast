package app.dogo.com.dogo_android.util;

import kotlin.Metadata;
import kotlin.b0.k.a.k;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.b3.e;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.x0;
import kotlinx.coroutines.y1;
import kotlinx.coroutines.y1.a;

/* compiled from: TrainingTimer.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u001d\u001a\u00020\u0018H\u0002J\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0007J\u0008\u0010 \u001a\u00020\u0007H\u0002J\u0006\u0010!\u001a\u00020\u0007J1\u0010\"\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00072!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0004\u0012\u00020\u00180\u0014J\u0006\u0010#\u001a\u00020\u0018J\u0014\u0010$\u001a\u00020\u00182\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006J\u0012\u0010&\u001a\u00020\u00182\n\u0008\u0002\u0010'\u001a\u0004\u0018\u00010(J\u0016\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00180*2\u0006\u0010+\u001a\u00020\u0007H\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u000c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\nR\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R+\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/util/TrainingTimer;", "", "disableTicker", "", "(Z)V", "customTimeReference", "Lkotlin/Function0;", "", "frozenSessionTimeMs", "isFrozen", "()Z", "isPaused", "isRunning", "lastFreezeTimeMs", "lastPauseTimeMs", "lastStartTimeMs", "lastStopTimeMs", "getLastStopTimeMs", "()J", "onTickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "totalElapsedTimeMs", "", "previousSessionsTimeMs", "ticker", "Lkotlinx/coroutines/Job;", "tickerPeriodMs", "cancelTimerCallback", "freeze", "getElapsedTimeMs", "getReferenceTimeMs", "getSessionElapsedTimeMs", "initTicker", "pause", "setCustomTimeReference", "reference", "start", "tickerScope", "Lkotlinx/coroutines/CoroutineScope;", "tickerFlow", "Lkotlinx/coroutines/flow/Flow;", "periodMs", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: a0, reason: from kotlin metadata */
public final class TrainingTimer {

    /* renamed from: a, reason: from kotlin metadata */
    private final boolean customTimeReference;
    /* renamed from: b, reason: from kotlin metadata */
    private y1 disableTicker;
    /* renamed from: c, reason: from kotlin metadata */
    private a<Long> frozenSessionTimeMs;
    private long d;
    private long e;
    private long f;
    /* renamed from: g, reason: from kotlin metadata */
    private long lastFreezeTimeMs;
    /* renamed from: h, reason: from kotlin metadata */
    private long lastPauseTimeMs;
    /* renamed from: i, reason: from kotlin metadata */
    private long lastStartTimeMs;
    private l<? super Long, w> j;

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@", d2 = {"<anonymous>", "", "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.util.TrainingTimer$start$1", f = "TrainingTimer.kt", l = {}, m = "invokeSuspend")
    static final class a extends k implements p<w, kotlin.b0.d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                l customTimeReference = a0.this.j;
                if (customTimeReference != null) {
                    customTimeReference.invoke(b.d(a0.this.d()));
                }
                return w.a;
            }
        }

        a(kotlin.b0.d<? super a0.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(w wVar, kotlin.b0.d<? super w> dVar) {
            return (a0.a)create(wVar, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new a0.a(a0.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.util.TrainingTimer$tickerFlow$1", f = "TrainingTimer.kt", l = {129, 130}, m = "invokeSuspend")
    static final class b extends k implements p<e<? super w>, kotlin.b0.d<? super w>, Object> {

        final /* synthetic */ long $periodMs;
        private /* synthetic */ Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            kotlin.b0.d dVar;
            Object obj;
            Object obj4 = b.d();
            final int i = 2;
            final int i2 = 1;
            if (this.label != 0) {
                if (this.label != i2) {
                    if (this.label != i) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(object);
                        Object object2 = this;
                        dVar.L$0 = obj;
                        dVar.label = i2;
                        if (obj.b(w.a, dVar) != obj4) {
                            dVar.L$0 = obj;
                            dVar.label = i;
                            if (kotlinx.coroutines.internal.x0.a(dVar.$periodMs, dVar) == obj4) {
                                return obj4;
                            }
                        }
                    }
                }
                q.b(object);
                object2 = this;
            } else {
                q.b(object);
            }
            return obj4;
        }

        b(long j, kotlin.b0.d<? super a0.b> dVar) {
            this.$periodMs = j;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(e<? super w> eVar, kotlin.b0.d<? super w> dVar) {
            return (a0.b)create(eVar, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            final app.dogo.com.dogo_android.util.a0.b bVar = new a0.b(this.$periodMs, r2, dVar);
            bVar.L$0 = object;
            return bVar;
        }
    }
    public a0(boolean z) {
        super();
        this.customTimeReference = z;
        this.lastStartTimeMs = 1000L;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ l setCustomTimeReference(a0 reference) {
        return reference.j;
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final void cancelTimerCallback() {
        final java.util.concurrent.CancellationException cancellationException = null;
        if (this.disableTicker != null) {
            int i = 1;
            kotlinx.coroutines.internal.y1.a.a(this.disableTicker, cancellationException, i, cancellationException);
        }
        this.disableTicker = cancellationException;
    }

    private final long e() {
        long lastFreezeTimeMs2;
        int i = 0;
        i = 0;
        if (this.f >= this.lastFreezeTimeMs) {
        }
        if (this.f < this.lastPauseTimeMs) {
        }
        return Math.max(lastFreezeTimeMs2, i);
    }

    private final long f() {
        int i = 0;
        long value;
        i = this.frozenSessionTimeMs == null ? 0 : (Long)invoke;
        if (this.frozenSessionTimeMs == 0) {
            value = System.currentTimeMillis();
        } else {
            value = i.longValue();
        }
        return value;
    }

    public static /* synthetic */ void n(a0 a0Var, m0 m0Var, int i, Object object) {
        if (i & 1 != 0) {
            i = 0;
        }
        a0Var.tickerFlow(m0Var);
    }

    /* renamed from: o, reason: from kotlin metadata */
    private final kotlinx.coroutines.b3.d<w> start(long tickerScope) {
        return kotlinx.coroutines.flow.f.e(new a0.b(tickerScope, r4, 0));
    }

    public final void c() {
        if (k()) {
            this.lastPauseTimeMs = f();
            cancelTimerCallback();
        }
    }

    public final long d() {
        return g() + this.d;
    }

    public final long g() {
        long l;
        long l2;
        if (k()) {
            l = f() - this.f;
        } else {
            l = e() - this.f;
        }
        return l + l2;
    }

    /* renamed from: h, reason: from kotlin metadata */
    public final void initTicker(long tickerPeriodMs, l<? super Long, w> onTickListener) {
        n.f(onTickListener, "onTickListener");
        this.lastStartTimeMs = tickerPeriodMs;
        this.j = onTickListener;
    }

    public final boolean i() {
        boolean z = true;
        int r0 = this.lastPauseTimeMs > this.f ? 1 : 0;
        return (this.lastPauseTimeMs > this.f ? 1 : 0);
    }

    public final boolean j() {
        boolean z = true;
        int r0 = this.lastFreezeTimeMs > this.f ? 1 : 0;
        return (this.lastFreezeTimeMs > this.f ? 1 : 0);
    }

    public final boolean k() {
        boolean z = true;
        long l = e();
        int r0 = l < this.f ? 1 : 0;
        return (l < this.f ? 1 : 0);
    }

    public final void l() {
        if (k()) {
            this.lastFreezeTimeMs = f();
            cancelTimerCallback();
        }
    }

    /* renamed from: m, reason: from kotlin metadata */
    public final void tickerFlow(m0 periodMs) {
        long l3;
        long l4;
        long l5;
        cancelTimerCallback();
        long l2 = 0L;
        if (j()) {
            l4 = (this.lastFreezeTimeMs - this.f) + this.e;
            this.d += l4;
            this.e = l2;
        }
        if (i()) {
            l4 = this.lastPauseTimeMs - this.f;
            this.e += l4;
        }
        this.lastFreezeTimeMs = l2;
        this.lastPauseTimeMs = l2;
        this.f = f();
        if (periodMs != null && this.customTimeReference == null) {
            kotlin.b0.d dVar = null;
            this.disableTicker = kotlinx.coroutines.flow.f.f(kotlinx.coroutines.flow.f.g(start(this.lastStartTimeMs), new a0.a(this, dVar)), periodMs);
        }
    }

    public /* synthetic */ a0(boolean z, int i, g gVar) {
        boolean z2 = false;
        i = i & 1 != 0 ? 0 : i;
        this(z2);
    }
}
