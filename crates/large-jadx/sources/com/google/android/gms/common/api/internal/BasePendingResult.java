package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.e.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.r;
import f.c.a.d.b.e.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public abstract class BasePendingResult<R extends i>  extends e<R> {

    static final java.lang.ThreadLocal<Boolean> n;
    public static final int o;
    private final Object a;
    protected final com.google.android.gms.common.api.internal.BasePendingResult.a<R> b;
    private final CountDownLatch c;
    private final ArrayList<e.a> d;
    private j<? super R> e;
    private final AtomicReference<com.google.android.gms.common.api.internal.e1> f;
    private R g;
    private Status h;
    private volatile boolean i;
    private boolean j;
    private boolean k;
    private volatile com.google.android.gms.common.api.internal.d1<R> l;
    private boolean m = false;
    private com.google.android.gms.common.api.internal.r1 mResultGuardian;

    public static class a extends e {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(j<? super R> j, R r2) {
            int i = BasePendingResult.o;
            r.j(j);
            Pair pair = new Pair((j)j, r2);
            sendMessage(obtainMessage(1, pair));
        }

        @Override // f.c.a.d.b.e.e
        public final void handleMessage(Message message) {
            int what = message.what;
            if (what != 1 && what != 2) {
                if (what != 2) {
                    StringBuilder obj3 = new StringBuilder(45);
                    obj3.append("Don't know how to handle message: ");
                    obj3.append(what);
                    Exception exception = new Exception();
                    Log.wtf("BasePendingResult", obj3.toString(), exception);
                }
                (BasePendingResult)message.obj.d(Status.A);
            }
            obj3 = message.obj;
            (j)obj3.first.a((i)obj3.second);
        }
    }
    static {
        q1 q1Var = new q1();
        BasePendingResult.n = q1Var;
    }

    @Deprecated
    BasePendingResult() {
        super();
        Object object = new Object();
        this.a = object;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.c = countDownLatch;
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        AtomicReference atomicReference = new AtomicReference();
        this.f = atomicReference;
        int i = 0;
        BasePendingResult.a aVar = new BasePendingResult.a(Looper.getMainLooper());
        this.b = aVar;
        WeakReference weakReference = new WeakReference(0);
    }

    protected BasePendingResult(d d) {
        Looper mainLooper;
        super();
        Object object = new Object();
        this.a = object;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.c = countDownLatch;
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        AtomicReference atomicReference = new AtomicReference();
        this.f = atomicReference;
        int i = 0;
        if (d != null) {
            mainLooper = d.d();
        } else {
            mainLooper = Looper.getMainLooper();
        }
        BasePendingResult.a aVar = new BasePendingResult.a(mainLooper);
        this.b = aVar;
        WeakReference weakReference = new WeakReference(d);
    }

    private final R g() {
        Object andSet;
        Object obj = this.a;
        final int i2 = 1;
        r.n(z ^= i2, "Result has already been consumed.");
        r.n(e(), "Result is not ready.");
        i iVar = this.g;
        int i3 = 0;
        this.g = i3;
        this.e = i3;
        this.i = i2;
        andSet = this.f.getAndSet(i3);
        synchronized (obj) {
            obj = this.a;
            i2 = 1;
            r.n(z ^= i2, "Result has already been consumed.");
            r.n(e(), "Result is not ready.");
            iVar = this.g;
            i3 = 0;
            this.g = i3;
            this.e = i3;
            this.i = i2;
            andSet = this.f.getAndSet(i3);
        }
        f1Var.a.remove(this);
        r.j(iVar);
        return (i)iVar;
    }

    private final void h(R r) {
        int i2;
        i iVar;
        int i;
        Object obj;
        Status status;
        boolean obj5;
        this.g = r;
        this.h = r.m();
        this.c.countDown();
        i2 = 0;
        if (this.j) {
            this.e = i2;
        } else {
            obj5 = this.e;
            if (obj5 == null) {
                if (obj5 instanceof g) {
                    obj5 = new r1(this, i2);
                    this.mResultGuardian = obj5;
                }
            } else {
                this.b.removeMessages(2);
                this.b.a(obj5, g());
            }
        }
        obj5 = this.d;
        i = 0;
        while (i < obj5.size()) {
            (e.a)obj5.get(i).a(this.h);
            i++;
        }
        this.d.clear();
    }

    public static void j(i i) {
        boolean z;
        String str;
        StringBuilder stringBuilder;
        Object obj3;
        if (i instanceof g) {
            (g)i.a();
        }
    }

    static i k(com.google.android.gms.common.api.internal.BasePendingResult basePendingResult) {
        return basePendingResult.g;
    }

    @Override // com.google.android.gms.common.api.e
    public final void a(e.a e$a) {
        int i;
        Object list;
        i = a != null ? 1 : 0;
        r.b(i, "Callback cannot be null.");
        Object obj = this.a;
        synchronized (obj) {
            a.a(this.h);
        }
    }

    public final R b(long l, TimeUnit timeUnit2) {
        int cmp;
        int i;
        boolean obj4;
        if (Long.compare(l, i2) > 0) {
            r.i("await must not be called on the UI thread when time is greater than zero.");
        }
        r.n(z ^= i, "Result has already been consumed.");
        if (this.l == null) {
        } else {
            i = 0;
        }
        r.n(i, "Cannot await if then() has been called.");
        if (!this.c.await(l, timeUnit2)) {
            d(Status.A);
        }
        r.n(e(), "Result is not ready.");
        return g();
    }

    protected abstract R c(Status status);

    @Deprecated
    public final void d(Status status) {
        Status obj3;
        final Object obj = this.a;
        synchronized (obj) {
            f(c(status));
            this.k = true;
        }
    }

    @Override // com.google.android.gms.common.api.e
    public final boolean e() {
        if (Long.compare(count, i3) == 0) {
            return 1;
        }
        return 0;
    }

    public final void f(R r) {
        boolean z;
        final Object obj = this.a;
        synchronized (obj) {
            if (!this.j) {
                e();
                r.n(z2 ^= 1, "Results have already been set");
                r.n(z3 ^= 1, "Result has already been consumed");
                h(r);
            }
            try {
                BasePendingResult.j(r);
                throw r;
            }
        }
    }

    @Override // com.google.android.gms.common.api.e
    public final void i() {
        boolean booleanValue;
        int i;
        i = 1;
        if (!this.m) {
            if ((Boolean)BasePendingResult.n.get().booleanValue()) {
            } else {
                i = 0;
            }
        }
        this.m = i;
    }
}
