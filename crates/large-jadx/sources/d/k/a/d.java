package d.k.a;

import android.os.Looper;
import android.util.AndroidRuntimeException;

/* loaded from: classes.dex */
public final class d extends d.k.a.b<d.k.a.d> {

    private d.k.a.e s = null;
    private float t = 340282350000000000000000000000000000000f;
    private boolean u = false;
    public d(K k, d.k.a.c<K> c2) {
        super(k, c2);
        int obj1 = 0;
        obj1 = 2139095039;
        obj1 = 0;
    }

    private void o() {
        d.k.a.e eVar = this.s;
        if (eVar == null) {
        } else {
            double d = (double)f;
            if (Double.compare(d, d2) > 0) {
            } else {
                if (Double.compare(d, d3) < 0) {
                } else {
                }
                UnsupportedOperationException unsupportedOperationException2 = new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
                throw unsupportedOperationException2;
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            throw unsupportedOperationException;
        }
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        throw unsupportedOperationException3;
    }

    @Override // d.k.a.b
    public void i() {
        o();
        this.s.g((double)f);
        super.i();
    }

    @Override // d.k.a.b
    boolean k(long l) {
        float f;
        float f2;
        int cmp;
        d.k.a.e eVar;
        float f3;
        double d;
        int i2;
        d.k.a.e eVar2;
        double d3;
        double d2;
        int i;
        final Object obj = this;
        final int i3 = 1;
        final int i4 = 0;
        final int i5 = 0;
        int i6 = 2139095039;
        float f4 = obj.t;
        if (obj.u && Float.compare(f4, i6) != 0) {
            f4 = obj.t;
            if (Float.compare(f4, i6) != 0) {
                obj.s.e(f4);
                obj.t = i6;
            }
            obj.b = obj.s.a();
            obj.a = i5;
            obj.u = i4;
            return i3;
        }
        if (Float.compare(f6, i6) != 0) {
            obj.s.a();
            i = l / i7;
            d.k.a.b.h hVar2 = obj.s.h((double)f13, obj8, (double)f14);
            obj.s.e(obj.t);
            obj.t = i6;
            d.k.a.b.h hVar3 = obj.s.h((double)f19, obj15, (double)f15);
            obj.b = hVar3.a;
            obj.a = hVar3.b;
        } else {
            d.k.a.b.h hVar = obj.s.h((double)f11, obj15, (double)f12);
            obj.b = hVar.a;
            obj.a = hVar.b;
        }
        float f8 = Math.max(obj.b, obj.h);
        obj.b = f8;
        float f9 = Math.min(f8, obj.g);
        obj.b = f9;
        if (obj.n(f9, obj.a)) {
            obj.b = obj.s.a();
            obj.a = i5;
            return i3;
        }
        return i4;
    }

    @Override // d.k.a.b
    public void l(float f) {
        boolean z;
        d.k.a.e eVar;
        if (e()) {
            this.t = f;
        } else {
            if (this.s == null) {
                eVar = new e(f);
                this.s = eVar;
            }
            this.s.e(f);
            i();
        }
    }

    @Override // d.k.a.b
    public boolean m() {
        int i;
        i = Double.compare(d, i2) > 0 ? 1 : 0;
        return i;
    }

    @Override // d.k.a.b
    boolean n(float f, float f2) {
        return this.s.c(f, f2);
    }

    @Override // d.k.a.b
    public d.k.a.d p(d.k.a.e e) {
        this.s = e;
        return this;
    }

    @Override // d.k.a.b
    public void q() {
        boolean z;
        if (!m()) {
        } else {
            if (Looper.myLooper() != Looper.getMainLooper()) {
            } else {
                if (this.f) {
                    this.u = true;
                }
            }
            AndroidRuntimeException androidRuntimeException = new AndroidRuntimeException("Animations may only be started on the main thread");
            throw androidRuntimeException;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        throw unsupportedOperationException;
    }
}
