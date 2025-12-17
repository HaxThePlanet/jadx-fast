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

/* loaded from: classes3.dex */
final class b extends z {

    private final Handler b;
    private final boolean c;

    private static final class b implements Runnable, b {

        private final Handler a;
        private final Runnable b;
        private volatile boolean c;
        b(Handler handler, Runnable runnable2) {
            super();
            this.a = handler;
            this.b = runnable2;
        }

        @Override // java.lang.Runnable
        public void dispose() {
            this.a.removeCallbacks(this);
            this.c = true;
        }

        @Override // java.lang.Runnable
        public boolean isDisposed() {
            return this.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            try {
                this.b.run();
                a.t(th);
            }
        }
    }

    private static final class a extends z.c {

        private final Handler a;
        private final boolean b;
        private volatile boolean c;
        a(Handler handler, boolean z2) {
            super();
            this.a = handler;
            this.b = z2;
        }

        @Override // i.b.z$c
        public b c(Runnable runnable, long l2, TimeUnit timeUnit3) {
            boolean z;
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(obj6, "unit == null");
            if (this.c) {
                return c.a();
            }
            Handler handler = this.a;
            b.b bVar = new b.b(handler, a.w(runnable));
            Message obj3 = Message.obtain(handler, bVar);
            obj3.obj = this;
            if (this.b) {
                obj3.setAsynchronous(true);
            }
            this.a.sendMessageDelayed(obj3, obj6.toMillis(l2));
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
    b(Handler handler, boolean z2) {
        super();
        this.b = handler;
        this.c = z2;
    }

    @Override // i.b.z
    public z.c a() {
        b.a aVar = new b.a(this.b, this.c);
        return aVar;
    }

    @Override // i.b.z
    public b d(Runnable runnable, long l2, TimeUnit timeUnit3) {
        boolean z;
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(obj6, "unit == null");
        Handler handler = this.b;
        b.b bVar = new b.b(handler, a.w(runnable));
        Message obj3 = Message.obtain(handler, bVar);
        if (this.c) {
            obj3.setAsynchronous(true);
        }
        this.b.sendMessageDelayed(obj3, obj6.toMillis(l2));
        return bVar;
    }
}
