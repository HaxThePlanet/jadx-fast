package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
final class w4<V>  extends FutureTask<V> implements Comparable<com.google.android.gms.measurement.internal.w4<V>> {

    private final long a;
    final boolean b;
    private final String c;
    final com.google.android.gms.measurement.internal.y4 v;
    w4(com.google.android.gms.measurement.internal.y4 y4, Runnable runnable2, boolean z3, String string4) {
        Object obj3;
        int obj4;
        this.v = y4;
        super(runnable2, 0);
        r.j(string4);
        long andIncrement = y4.v().getAndIncrement();
        this.a = andIncrement;
        this.c = string4;
        this.b = z3;
        if (Long.compare(andIncrement, obj4) == 0) {
            y4.a.b().r().a("Tasks index overflow");
        }
    }

    w4(com.google.android.gms.measurement.internal.y4 y4, Callable callable2, boolean z3, String string4) {
        Object obj3;
        int obj4;
        this.v = y4;
        super(callable2);
        obj4 = "Task exception on worker thread";
        r.j(obj4);
        final long andIncrement = y4.v().getAndIncrement();
        this.a = andIncrement;
        this.c = obj4;
        this.b = z3;
        if (Long.compare(andIncrement, obj4) == 0) {
            y4.a.b().r().a("Tasks index overflow");
        }
    }

    @Override // java.util.concurrent.FutureTask
    public final int compareTo(Object object) {
        boolean z;
        int i;
        long l;
        Object obj7;
        z = this.b;
        boolean z2 = object.b;
        i = 1;
        final int i2 = -1;
        if (z != z2 && !z) {
            if (!z) {
                return i;
            }
            return i2;
        }
        obj7 = Long.compare(z, l);
        if (obj7 < 0) {
            i = i2;
        } else {
            if (obj7 > 0) {
            }
        }
        obj7.a.b().t().b("Two tasks share the same index. index", Long.valueOf(this.a));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable throwable) {
        y4Var.a.b().r().b(this.c, throwable);
        super.setException(throwable);
    }
}
