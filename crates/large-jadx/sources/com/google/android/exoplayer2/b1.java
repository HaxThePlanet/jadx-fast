package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.i0;
import com.google.android.exoplayer2.util.x;

/* loaded from: classes.dex */
final class b1 implements x {

    private final i0 a;
    private final com.google.android.exoplayer2.b1.a b;
    private com.google.android.exoplayer2.z1 c;
    private x v;
    private boolean w = true;
    private boolean x;

    public interface a {
        public abstract void c(com.google.android.exoplayer2.u1 u1);
    }
    public b1(com.google.android.exoplayer2.b1.a b1$a, i i2) {
        super();
        this.b = a;
        i0 obj1 = new i0(i2);
        this.a = obj1;
        obj1 = 1;
    }

    private boolean d(boolean z) {
        com.google.android.exoplayer2.z1 z1Var;
        boolean obj2;
        z1Var = this.c;
        if (z1Var != null && !z1Var.c()) {
            if (!z1Var.c()) {
                if (!this.c.a()) {
                    if (!z) {
                        if (this.c.j()) {
                            obj2 = 1;
                        } else {
                            obj2 = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    private void j(boolean z) {
        boolean equals;
        boolean z2;
        boolean obj5;
        this.w = true;
        if (d(z) && this.x) {
            this.w = true;
            if (this.x) {
                this.a.b();
            }
        }
        obj5 = this.v;
        g.e(obj5);
        long l = (x)obj5.o();
        if (this.w && Long.compare(l, l2) < 0) {
            if (Long.compare(l, l2) < 0) {
                this.a.c();
            }
            this.w = false;
            if (this.x) {
                this.a.b();
            }
        }
        this.a.a(l);
        obj5 = obj5.e();
        if (!obj5.equals(this.a.e())) {
            this.a.h(obj5);
            this.b.c(obj5);
        }
    }

    @Override // com.google.android.exoplayer2.util.x
    public void a(com.google.android.exoplayer2.z1 z1) {
        com.google.android.exoplayer2.z1 obj2;
        if (z1 == this.c) {
            obj2 = 0;
            this.v = obj2;
            this.c = obj2;
            this.w = true;
        }
    }

    @Override // com.google.android.exoplayer2.util.x
    public void b(com.google.android.exoplayer2.z1 z1) {
        x xVar;
        Object obj3;
        x xVar2 = z1.A();
        xVar = this.v;
        if (xVar2 != null && xVar2 != xVar) {
            xVar = this.v;
            if (xVar2 != xVar) {
                if (xVar != null) {
                } else {
                    this.v = xVar2;
                    this.c = z1;
                    xVar2.h(this.a.e());
                }
                obj3 = new IllegalStateException("Multiple renderer media clocks enabled.");
                throw ExoPlaybackException.d(obj3);
            }
        }
    }

    @Override // com.google.android.exoplayer2.util.x
    public void c(long l) {
        this.a.a(l);
    }

    @Override // com.google.android.exoplayer2.util.x
    public com.google.android.exoplayer2.u1 e() {
        com.google.android.exoplayer2.u1 u1Var;
        x xVar = this.v;
        if (xVar != null) {
            u1Var = xVar.e();
        } else {
            u1Var = this.a.e();
        }
        return u1Var;
    }

    @Override // com.google.android.exoplayer2.util.x
    public void f() {
        this.x = true;
        this.a.b();
    }

    @Override // com.google.android.exoplayer2.util.x
    public void g() {
        this.x = false;
        this.a.c();
    }

    @Override // com.google.android.exoplayer2.util.x
    public void h(com.google.android.exoplayer2.u1 u1) {
        com.google.android.exoplayer2.u1 obj2;
        x xVar = this.v;
        if (xVar != null) {
            xVar.h(u1);
            obj2 = this.v.e();
        }
        this.a.h(obj2);
    }

    @Override // com.google.android.exoplayer2.util.x
    public long i(boolean z) {
        j(z);
        return o();
    }

    @Override // com.google.android.exoplayer2.util.x
    public long o() {
        long l;
        if (this.w) {
            l = this.a.o();
        } else {
            x xVar = this.v;
            g.e(xVar);
            l = (x)xVar.o();
        }
        return l;
    }
}
