package io.grpc.j1;

import io.grpc.a;
import io.grpc.d1;
import io.grpc.e1;
import io.grpc.l;
import io.grpc.t0;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: StatsTraceContext.java */
/* loaded from: classes3.dex */
public final class i2 {

    private final e1[] a;
    private final AtomicBoolean b = new AtomicBoolean(0);
    static {
        final io.grpc.j1.i2 i2Var = new i2(new e1[0]);
    }

    i2(e1[] e1VarArr) {
        super();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.a = e1VarArr;
    }

    public static i2 h(l[] lVarArr, a aVar, t0 t0Var) {
        int i = 0;
        i = 0;
        for (e1 e1Var : lVarArr) {
            e1Var.m(aVar, t0Var);
        }
        return new i2(lVarArr);
    }

    public void a() {
        int i = 0;
        i = 0;
        for (e1 e1Var : objArr) {
            e1Var.j();
        }
    }

    public void b(t0 t0Var) {
        int i = 0;
        i = 0;
        for (e1 e1Var : objArr) {
            e1Var.k(t0Var);
        }
    }

    public void c() {
        int i = 0;
        i = 0;
        for (e1 e1Var : objArr) {
            e1Var.l();
        }
    }

    public void d(int i) {
        int i2 = 0;
        i2 = 0;
        for (e1 e1Var : objArr) {
            e1Var.a(i);
        }
    }

    public void e(int i, long j, long j2) {
        int i2 = 0;
        i2 = 0;
        for (e1 e1Var : objArr) {
            e1Var.b(i, j, j2);
        }
    }

    public void f(long j) {
        int i = 0;
        i = 0;
        for (e1 e1Var : objArr) {
            e1Var.c(j);
        }
    }

    public void g(long j) {
        int i = 0;
        i = 0;
        for (e1 e1Var : objArr) {
            e1Var.d(j);
        }
    }

    public void i(int i) {
        int i2 = 0;
        i2 = 0;
        for (e1 e1Var : objArr) {
            e1Var.e(i);
        }
    }

    public void j(int i, long j, long j2) {
        int i2 = 0;
        i2 = 0;
        for (e1 e1Var : objArr) {
            e1Var.f(i, j, j2);
        }
    }

    public void k(long j) {
        int i = 0;
        i = 0;
        for (e1 e1Var : objArr) {
            e1Var.g(j);
        }
    }

    public void l(long j) {
        int i = 0;
        i = 0;
        for (e1 e1Var : objArr) {
            e1Var.h(j);
        }
    }

    public void m(d1 d1Var) {
        boolean z = false;
        e1 e1Var;
        z = false;
        boolean z3 = true;
        if (this.b.compareAndSet(z, z3)) {
            for (e1 e1Var : objArr) {
                e1Var.i(d1Var);
            }
        }
    }
}
