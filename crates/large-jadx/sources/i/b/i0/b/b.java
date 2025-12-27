package i.b.i0.b;

import android.os.Handler;
import android.os.Message;
import i.b.j0.b;
import i.b.j0.c;
import i.b.p0.a;
import i.b.z;
import i.b.z.c;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: HandlerScheduler.java */
/* loaded from: classes3.dex */
final class b extends z {

    private final Handler b;
    private final boolean c;

    private static final class b implements Runnable, b {

        private final Handler a;
        private final Runnable b;
        private volatile boolean c;
        b(Handler handler, Runnable runnable) {
            super();
            this.a = handler;
            this.b = runnable;
        }

        public void dispose() {
            this.a.removeCallbacks(this);
            this.c = true;
        }

        public boolean isDisposed() {
            return this.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } catch (Throwable th) {
                a.t(th);
            }
        }
    }

    private static final class a extends z.c {

        private final Handler a;
        private final boolean b;
        private volatile boolean c;
        a(Handler handler, boolean z) {
            super();
            this.a = handler;
            this.b = z;
        }

        @Override // i.b.z$c
        public b c(Runnable runnable, long j, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.c) {
                return c.a();
            }
            i.b.i0.b.b.b bVar = new b.b(handler, a.w(runnable));
            Message obtain = Message.obtain(this.a, bVar);
            obtain.obj = this;
            if (this.b) {
                boolean z = true;
                obtain.setAsynchronous(z);
            }
            this.a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (this.c) {
                this.a.removeCallbacks(bVar);
                return c.a();
            }
            return bVar;
        }

        @Override // i.b.z$c
        public void dispose() {
            this.c = true;
            this.a.removeCallbacksAndMessages(this);
        }

        @Override // i.b.z$c
        public boolean isDisposed() {
            return this.c;
        }
    }
    b(Handler handler, boolean z) {
        super();
        this.b = handler;
        this.c = z;
    }

    @Override // i.b.z
    public z.c a() {
        return new b.a(this.b, this.c);
    }

    @Override // i.b.z
    public b d(Runnable runnable, long j, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        i.b.i0.b.b.b bVar = new b.b(handler, a.w(runnable));
        Message obtain = Message.obtain(this.b, bVar);
        if (this.c) {
            boolean z = true;
            obtain.setAsynchronous(z);
        }
        this.b.sendMessageDelayed(obtain, timeUnit.toMillis(j));
        return bVar;
    }
}
