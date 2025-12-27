package d.p.b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import d.h.k.k;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* compiled from: AsyncTaskLoader.java */
/* loaded from: classes.dex */
public abstract class a<D> extends b<D> {

    private final Executor i;
    volatile a.a<D> j;
    volatile a.a<D> k;
    long l;
    long m;
    Handler n;

    final class a extends c<Void, Void, D> implements Runnable {

        private final CountDownLatch B = new CountDownLatch(1);
        boolean C;
        final /* synthetic */ a D;
        a() {
            this.D = aVar;
            super();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
        }

        @Override // d.p.b.c
        protected void h(D d) {
            try {
                this.D.x(this, d);
            } finally {
                this.B.countDown();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) d;
            }
            this.B.countDown();
        }

        @Override // d.p.b.c
        protected void i(D d) {
            try {
                this.D.y(this, d);
            } finally {
                this.B.countDown();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) d;
            }
            this.B.countDown();
        }

        @Override // d.p.b.c
        protected D n(Void... voidArr) {
            try {
            } catch (androidx.core.os.OperationCanceledException operationCanceled) {
            }
            return this.D.C();
        }

        @Override // d.p.b.c
        public void run() {
            this.C = false;
            this.D.z();
        }
    }
    public a(Context context) {
        this(context, c.z);
    }

    @Override // d.p.b.b
    protected D C() {
        return A();
    }

    @Deprecated
    @Override // d.p.b.b
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        final String str6 = " waiting=";
        if (this.j != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.j);
            printWriter.print(str6);
            printWriter.println(this.j.C);
        }
        if (this.k != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.k);
            printWriter.print(str6);
            printWriter.println(this.k.C);
        }
        int cmp = (uptimeMillis > 0 ? 1 : (uptimeMillis == 0 ? 0 : -1));
        if (this.l != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            k.c(this.l, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            k.b(this.m, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    @Override // d.p.b.b
    protected boolean k() {
        boolean z3 = false;
        if (this.j != null && !this.d) {
            boolean z = true;
            this.g = z;
            final d.p.b.a.a aVar10 = null;
            if (this.k != null) {
                if (this.j.C) {
                    this.j.C = z3;
                    this.n.removeCallbacks(this.j);
                }
                this.j = aVar10;
                return false;
            }
            if (this.j.C) {
                this.j.C = z3;
                this.n.removeCallbacks(this.j);
                this.j = aVar10;
                return false;
            }
            boolean z5 = this.j.a(z3);
            if (z5) {
                this.k = this.j;
                w();
            }
            this.j = aVar10;
            return this.j.a(z3);
        }
        return false;
    }

    @Override // d.p.b.b
    protected void m() {
        super.m();
        b();
        this.j = new a.a(this);
        z();
    }

    @Override // d.p.b.b
    void x(a.a<D> a.a, D d) {
        B(d);
        if (this.k == a.a) {
            s();
            this.m = SystemClock.uptimeMillis();
            d.p.b.a.a aVar = null;
            this.k = aVar;
            e();
            z();
        }
    }

    @Override // d.p.b.b
    void y(a.a<D> a.a, D d) {
        if (this.j != a.a) {
            x(a.a, d);
        } else {
            if (i()) {
                B(d);
            } else {
                c();
                this.m = SystemClock.uptimeMillis();
                this.j = null;
                f(d);
            }
        }
    }

    @Override // d.p.b.b
    void z() {
        long l2;
        if (this.k == null && this.j != null) {
            if (this.j.C) {
                this.j.C = false;
                this.n.removeCallbacks(this.j);
            }
            long l = 0L;
            if (this.l > l) {
                long uptimeMillis = SystemClock.uptimeMillis();
                l = this.m + this.l;
                if (uptimeMillis < this.m) {
                    this.j.C = true;
                    this.n.postAtTime(this.j, this.m + this.l);
                    return;
                }
            }
            Object[] objArr = null;
            this.j.c(this.i, objArr);
        }
    }

    private a(Context context, Executor executor) {
        super(context);
        this.m = -10000L;
        this.i = executor;
    }

    @Override // d.p.b.b
    public abstract D A();

    @Override // d.p.b.b
    public void B(D d) {
    }

    @Override // d.p.b.b
    public void w() {
    }
}
