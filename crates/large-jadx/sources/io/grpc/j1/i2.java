package io.grpc.j1;

import io.grpc.a;
import io.grpc.d1;
import io.grpc.e1;
import io.grpc.l;
import io.grpc.t0;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class i2 {

    private final e1[] a;
    private final AtomicBoolean b;
    static {
        i2 i2Var = new i2(new e1[0]);
    }

    i2(e1[] e1Arr) {
        super();
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        this.b = atomicBoolean;
        this.a = e1Arr;
    }

    public static io.grpc.j1.i2 h(l[] lArr, a a2, t0 t03) {
        int i;
        e1 e1Var;
        i2 i2Var = new i2(lArr);
        i = 0;
        while (i < lArr.length) {
            lArr[i].m(a2, t03);
            i++;
        }
        return i2Var;
    }

    public void a() {
        int i;
        e1 e1Var;
        final e1[] objArr = this.a;
        i = 0;
        while (i < objArr.length) {
            (l)objArr[i].j();
            i++;
        }
    }

    public void b(t0 t0) {
        int i;
        e1 e1Var;
        final e1[] objArr = this.a;
        i = 0;
        while (i < objArr.length) {
            (l)objArr[i].k(t0);
            i++;
        }
    }

    public void c() {
        int i;
        e1 e1Var;
        final e1[] objArr = this.a;
        i = 0;
        while (i < objArr.length) {
            (l)objArr[i].l();
            i++;
        }
    }

    public void d(int i) {
        int i2;
        e1 e1Var;
        final e1[] objArr = this.a;
        i2 = 0;
        while (i2 < objArr.length) {
            objArr[i2].a(i);
            i2++;
        }
    }

    public void e(int i, long l2, long l3) {
        int i3;
        e1 e1Var;
        int i2;
        long l;
        Object obj;
        final e1[] objArr = this.a;
        i3 = 0;
        while (i3 < objArr.length) {
            objArr[i3].b(i, l2, obj6);
            i3++;
        }
    }

    public void f(long l) {
        int i;
        e1 e1Var;
        final e1[] objArr = this.a;
        i = 0;
        while (i < objArr.length) {
            objArr[i].c(l);
            i++;
        }
    }

    public void g(long l) {
        int i;
        e1 e1Var;
        final e1[] objArr = this.a;
        i = 0;
        while (i < objArr.length) {
            objArr[i].d(l);
            i++;
        }
    }

    public void i(int i) {
        int i2;
        e1 e1Var;
        final e1[] objArr = this.a;
        i2 = 0;
        while (i2 < objArr.length) {
            objArr[i2].e(i);
            i2++;
        }
    }

    public void j(int i, long l2, long l3) {
        int i2;
        e1 e1Var;
        int i3;
        long l;
        Object obj;
        final e1[] objArr = this.a;
        i2 = 0;
        while (i2 < objArr.length) {
            objArr[i2].f(i, l2, obj6);
            i2++;
        }
    }

    public void k(long l) {
        int i;
        e1 e1Var;
        final e1[] objArr = this.a;
        i = 0;
        while (i < objArr.length) {
            objArr[i].g(l);
            i++;
        }
    }

    public void l(long l) {
        int i;
        e1 e1Var;
        final e1[] objArr = this.a;
        i = 0;
        while (i < objArr.length) {
            objArr[i].h(l);
            i++;
        }
    }

    public void m(d1 d1) {
        boolean compareAndSet;
        int i;
        int length;
        e1 e1Var;
        if (this.b.compareAndSet(false, true)) {
            compareAndSet = this.a;
            while (i < compareAndSet.length) {
                compareAndSet[i].i(d1);
                i++;
            }
        }
    }
}
