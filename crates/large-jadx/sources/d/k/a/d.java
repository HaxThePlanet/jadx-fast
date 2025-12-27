package d.k.a;

import android.os.Looper;
import android.util.AndroidRuntimeException;

/* compiled from: SpringAnimation.java */
/* loaded from: classes.dex */
public final class d extends b<d> {

    private e s = null;
    private float t = 340282350000000000000000000000000000000f;
    private boolean u = false;
    public d(K k, c<K> cVar) {
        super(k, cVar);
    }

    private void o() {
        if (this.s == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        } else {
            double d = (double)this.s.a();
            double d2 = (double)this.g;
            if (this.s > this.g) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else {
                double d3 = (double)this.h;
                if (this.s < this.h) {
                    throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                }
            }
        }
    }

    @Override // d.k.a.b
    public void i() {
        o();
        this.s.g((double)d());
        super.i();
    }

    @Override // d.k.a.b
    boolean k(long j) {
        final Object j3 = this;
        final boolean z3 = true;
        final boolean z4 = false;
        final float f14 = 0.0f;
        float f15 = Float.MAX_VALUE;
        if (j3.u) {
            if (j3.t != Float.MAX_VALUE) {
                j3.s.e(j3.t);
                j3.t = Float.MAX_VALUE;
            }
            j3.b = j3.s.a();
            j3.a = 0.0f;
            j3.u = z4;
            return true;
        }
        if (j3.t != Float.MAX_VALUE) {
            j3.s.a();
            d = (double)j3.a;
            j2 = j / 2L;
            d.k.a.b.h hVar2 = j3.s.h((double)j3.b, d, j2);
            j3.s.e(j3.t);
            j3.t = Float.MAX_VALUE;
            d2 = (double)hVar2.a;
            d.k.a.b.h hVar3 = j3.s.h(d2, (double)hVar2.b, j2);
            j3.b = hVar3.a;
            j3.a = hVar3.b;
        } else {
            d2 = (double)j3.b;
            d.k.a.b.h hVar = j3.s.h(d2, (double)j3.a, j);
            j3.b = hVar.a;
            j3.a = hVar.b;
        }
        float max = Math.max(j3.b, j3.h);
        j3.b = max;
        float min = Math.min(max, j3.g);
        j3.b = min;
        if (j3.n(min, j3.a)) {
            j3.b = j3.s.a();
            j3.a = 0.0f;
            return true;
        }
        return false;
    }

    @Override // d.k.a.b
    public void l(float f) {
        if (e()) {
            this.t = f;
        } else {
            if (this.s == null) {
                this.s = new e(f);
            }
            this.s.e(f);
            i();
        }
    }

    @Override // d.k.a.b
    public boolean m() {
        boolean z = true;
        int r0 = this.s.b > 0 ? 1 : 0;
        return (this.s.b > 0 ? 1 : 0);
    }

    @Override // d.k.a.b
    boolean n(float f, float f2) {
        return this.s.c(f, f2);
    }

    @Override // d.k.a.b
    public d p(e eVar) {
        this.s = eVar;
        return this;
    }

    @Override // d.k.a.b
    public void q() throws AndroidRuntimeException {
        if (!m()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        } else {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new AndroidRuntimeException("Animations may only be started on the main thread");
            } else {
                if (this.f) {
                    boolean z = true;
                    this.u = z;
                }
                return;
            }
        }
    }
}
