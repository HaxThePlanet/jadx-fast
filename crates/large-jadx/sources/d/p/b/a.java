package d.p.b;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import d.h.k.k;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class a<D>  extends d.p.b.b<D> {

    private final Executor i;
    volatile d.p.b.a.a<D> j;
    volatile d.p.b.a.a<D> k;
    long l;
    long m;
    Handler n;

    final class a extends d.p.b.c<Void, Void, D> implements Runnable {

        private final CountDownLatch B;
        boolean C;
        final d.p.b.a D;
        a(d.p.b.a a) {
            this.D = a;
            super();
            CountDownLatch obj2 = new CountDownLatch(1);
            this.B = obj2;
        }

        @Override // d.p.b.c
        protected Object b(Object[] objectArr) {
            return n((Void[])objectArr);
        }

        protected void h(D d) {
            try {
                this.D.x(this, d);
                this.B.countDown();
                this.B.countDown();
                throw d;
            }
        }

        protected void i(D d) {
            try {
                this.D.y(this, d);
                this.B.countDown();
                this.B.countDown();
                throw d;
            }
        }

        protected D n(Void... voidArr) {
            try {
                return this.D.C();
                if (!f()) {
                } else {
                }
                voidArr = null;
                return voidArr;
                throw voidArr;
            }
        }

        @Override // d.p.b.c
        public void run() {
            this.C = false;
            this.D.z();
        }
    }
    public a(Context context) {
        super(context, c.z);
    }

    private a(Context context, Executor executor2) {
        super(context);
        this.m = -10000;
        this.i = executor2;
    }

    public abstract D A();

    public void B(D d) {
    }

    protected D C() {
        return A();
    }

    @Deprecated
    public void g(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4) {
        long uptimeMillis;
        String obj5;
        d.p.b.a.a obj6;
        super.g(string, fileDescriptor2, printWriter3, string4Arr4);
        final String obj8 = " waiting=";
        if (this.j != null) {
            printWriter3.print(string);
            printWriter3.print("mTask=");
            printWriter3.print(this.j);
            printWriter3.print(obj8);
            printWriter3.println(obj6.C);
        }
        if (this.k != null) {
            printWriter3.print(string);
            printWriter3.print("mCancellingTask=");
            printWriter3.print(this.k);
            printWriter3.print(obj8);
            printWriter3.println(obj6.C);
        }
        obj6 = Long.compare(uptimeMillis, i);
        if (obj6 != null) {
            printWriter3.print(string);
            printWriter3.print("mUpdateThrottle=");
            k.c(this.l, obj6);
            printWriter3.print(" mLastLoadCompleteTime=");
            k.b(this.m, obj6, SystemClock.uptimeMillis());
            printWriter3.println();
        }
    }

    @Override // d.p.b.b
    protected boolean k() {
        boolean z;
        boolean z2;
        int i;
        d.p.b.a.a aVar;
        i = 0;
        if (this.j != null && !this.d) {
            if (!this.d) {
                this.g = true;
            }
            final int i2 = 0;
            if (this.k != null && aVar7.C) {
                if (aVar7.C) {
                    aVar8.C = i;
                    this.n.removeCallbacks(this.j);
                }
                this.j = i2;
                return i;
            }
            if (aVar4.C) {
                aVar6.C = i;
                this.n.removeCallbacks(this.j);
                this.j = i2;
                return i;
            }
            boolean z4 = this.j.a(i);
            if (z4) {
                this.k = this.j;
                w();
            }
            this.j = i2;
            return z4;
        }
        return i;
    }

    @Override // d.p.b.b
    protected void m() {
        super.m();
        b();
        a.a aVar = new a.a(this);
        this.j = aVar;
        z();
    }

    @Override // d.p.b.b
    public void w() {
    }

    void x(d.p.b.a.a<D> a.a, D d2) {
        d.p.b.a.a obj1;
        B(d2);
        if (this.k == a.a) {
            s();
            this.m = SystemClock.uptimeMillis();
            this.k = 0;
            e();
            z();
        }
    }

    void y(d.p.b.a.a<D> a.a, D d2) {
        d.p.b.a.a uptimeMillis;
        d.p.b.a.a obj3;
        if (this.j != a.a) {
            x(a.a, d2);
        } else {
            if (i()) {
                B(d2);
            } else {
                c();
                this.m = SystemClock.uptimeMillis();
                this.j = 0;
                f(d2);
            }
        }
    }

    @Override // d.p.b.b
    void z() {
        boolean z;
        int cmp;
        d.p.b.a.a aVar2;
        d.p.b.a.a aVar;
        int i;
        int i2;
        long l;
        if (this.k == null && this.j != null && aVar3.C) {
            if (this.j != null) {
                if (aVar3.C) {
                    aVar4.C = false;
                    this.n.removeCallbacks(this.j);
                }
                if (Long.compare(l2, i) > 0 && Long.compare(uptimeMillis, i) < 0) {
                    if (Long.compare(uptimeMillis, i) < 0) {
                        aVar5.C = true;
                        this.n.postAtTime(this.j, l4 += l5);
                    }
                }
                this.j.c(this.i, 0);
            }
        }
    }
}
