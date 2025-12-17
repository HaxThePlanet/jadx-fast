package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.q;
import d.p.b.a;
import d.p.b.b;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class g extends a<Void> implements q {

    private final Semaphore o;
    private final Set<d> p;
    public g(Context context, Set<d> set2) {
        super(context);
        Semaphore obj2 = new Semaphore(0);
        this.o = obj2;
        this.p = set2;
    }

    @Override // d.p.b.a
    public final Object A() {
        Semaphore semaphore;
        TimeUnit sECONDS;
        int i;
        Iterator iterator = this.p.iterator();
        final int i2 = 0;
        if (iterator.hasNext()) {
        } else {
            this.o.tryAcquire(0, 5, obj4);
            return i2;
        }
        (d)iterator.next().e(this);
        throw i2;
    }

    @Override // d.p.b.a
    protected final void o() {
        this.o.drainPermits();
        h();
    }
}
