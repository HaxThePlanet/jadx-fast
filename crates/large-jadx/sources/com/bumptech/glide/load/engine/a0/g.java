package com.bumptech.glide.load.engine.a0;

import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.t.h;

/* compiled from: LruResourceCache.java */
/* loaded from: classes.dex */
public class g extends h<f, u<?>> implements h {

    private h.a d;
    public g(long j) {
        super(j, r2);
    }

    @Override // com.bumptech.glide.t.h
    public void a(int i) {
        int i2 = 40;
        if (i >= 40) {
            b();
        } else {
            i2 = 20;
            if (i >= 20 || i == 15) {
                long l = 2L;
                m(h() / l);
            }
        }
    }

    @Override // com.bumptech.glide.t.h
    public void e(h.a aVar) {
        this.d = aVar;
    }

    @Override // com.bumptech.glide.t.h
    protected int n(u<?> uVar) {
        if (uVar == null) {
            return super.i(null);
        }
        return uVar.getSize();
    }

    @Override // com.bumptech.glide.t.h
    protected void o(f fVar, u<?> uVar) {
        if (this.d != null && uVar != null) {
            this.d.a(uVar);
        }
    }
}
