package app.dogo.com.dogo_android.subscription.benefits;

import i.b.a0;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.z;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0002¢\u0006\u0002\u0010\tJ\u0018\u0010\u000c\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0008\u0000\u0012\u00020\u00020\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/TimeLeft;", "Lio/reactivex/Single;", "", "delay", "unit", "Ljava/util/concurrent/TimeUnit;", "scheduler", "Lio/reactivex/Scheduler;", "durationInSeconds", "(JLjava/util/concurrent/TimeUnit;Lio/reactivex/Scheduler;J)V", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "subscribeActual", "", "observer", "Lio/reactivex/SingleObserver;", "TimerDisposable", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TimeLeft extends a0<Long> {

    private final long delay;
    private final long durationInSeconds;
    private final z scheduler;
    private final TimeUnit unit;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0000\u0018\u0000 \u00102\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0010B\u001d\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0008\u0000\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\u0008\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0008\u0000\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/subscription/benefits/TimeLeft$TimerDisposable;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lio/reactivex/disposables/Disposable;", "Ljava/lang/Runnable;", "downstream", "Lio/reactivex/SingleObserver;", "", "durationInSeconds", "(Lio/reactivex/SingleObserver;J)V", "dispose", "", "isDisposed", "", "run", "setFuture", "d", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TimerDisposable extends AtomicReference<b> implements b, Runnable {

        public static final app.dogo.com.dogo_android.subscription.benefits.TimeLeft.TimerDisposable.Companion Companion = null;
        private static final long serialVersionUID = 8465401857522493082L;
        private final d0<? super Long> downstream;
        private final long durationInSeconds;
        static {
            TimeLeft.TimerDisposable.Companion companion = new TimeLeft.TimerDisposable.Companion(0);
            TimeLeft.TimerDisposable.Companion = companion;
        }

        public TimerDisposable(d0<? super Long> d0, long l2) {
            n.f(d0, "downstream");
            super();
            this.downstream = d0;
            this.durationInSeconds = l2;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void run() {
            this.downstream.onSuccess(Long.valueOf(this.durationInSeconds));
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public final void setFuture(b b) {
            c.replace(this, b);
        }
    }
    public TimeLeft(long l, TimeUnit timeUnit2, z z3, long l4) {
        n.f(z3, "unit");
        n.f(l4, "scheduler");
        super();
        this.delay = l;
        this.unit = z3;
        this.scheduler = l4;
        this.durationInSeconds = obj6;
    }

    @Override // i.b.a0
    public final TimeUnit getUnit() {
        return this.unit;
    }

    protected void subscribeActual(d0<? super Long> d0) {
        n.f(d0, "observer");
        TimeLeft.TimerDisposable timerDisposable = new TimeLeft.TimerDisposable(d0, this.durationInSeconds, obj2);
        d0.onSubscribe(timerDisposable);
        timerDisposable.setFuture(this.scheduler.d(timerDisposable, this.delay, obj2));
    }
}
