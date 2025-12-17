package com.bumptech.glide.load.engine.a0;

import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.t.h;

/* loaded from: classes.dex */
public class g extends h<f, u<?>> implements com.bumptech.glide.load.engine.a0.h {

    private com.bumptech.glide.load.engine.a0.h.a d;
    public g(long l) {
        super(l, obj2);
    }

    @Override // com.bumptech.glide.t.h
    public void a(int i) {
        int i2;
        int i3;
        if (i >= 40) {
            b();
        } else {
            if (i < 20) {
                if (i == 15) {
                    m(l /= i3);
                }
            } else {
            }
        }
    }

    @Override // com.bumptech.glide.t.h
    public u c(f f, u u2) {
        return (u)super.k(f, u2);
    }

    @Override // com.bumptech.glide.t.h
    public u d(f f) {
        return (u)super.l(f);
    }

    @Override // com.bumptech.glide.t.h
    public void e(com.bumptech.glide.load.engine.a0.h.a h$a) {
        this.d = a;
    }

    @Override // com.bumptech.glide.t.h
    protected int i(Object object) {
        return n((u)object);
    }

    @Override // com.bumptech.glide.t.h
    protected void j(Object object, Object object2) {
        o((f)object, (u)object2);
    }

    protected int n(u<?> u) {
        if (u == null) {
            return super.i(0);
        }
        return u.getSize();
    }

    protected void o(f f, u<?> u2) {
        final com.bumptech.glide.load.engine.a0.h.a obj1 = this.d;
        if (obj1 != null && u2 != null) {
            if (u2 != null) {
                obj1.a(u2);
            }
        }
    }
}
