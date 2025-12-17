package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.t.d;
import com.bumptech.glide.t.i;
import java.io.InputStream;

/* loaded from: classes.dex */
public class z implements j<InputStream, Bitmap> {

    private final com.bumptech.glide.load.resource.bitmap.m a;
    private final b b;

    static class a implements com.bumptech.glide.load.resource.bitmap.m.b {

        private final com.bumptech.glide.load.resource.bitmap.w a;
        private final d b;
        a(com.bumptech.glide.load.resource.bitmap.w w, d d2) {
            super();
            this.a = w;
            this.b = d2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m$b
        public void a(e e, Bitmap bitmap2) {
            java.io.IOException exc = this.b.a();
            if (exc != null) {
                if (bitmap2 == null) {
                } else {
                    e.c(bitmap2);
                }
                throw exc;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m$b
        public void b() {
            this.a.c();
        }
    }
    public z(com.bumptech.glide.load.resource.bitmap.m m, b b2) {
        super();
        this.a = m;
        this.b = b2;
    }

    @Override // com.bumptech.glide.load.j
    public boolean a(Object object, h h2) {
        return d((InputStream)object, h2);
    }

    @Override // com.bumptech.glide.load.j
    public u b(Object object, int i2, int i3, h h4) {
        return c((InputStream)object, i2, i3, h4);
    }

    public u<Bitmap> c(InputStream inputStream, int i2, int i3, h h4) {
        int i;
        b bVar;
        com.bumptech.glide.load.resource.bitmap.w wVar;
        Object obj10;
        if (inputStream instanceof w) {
            i = 0;
        } else {
            w wVar2 = new w((w)inputStream, this.b);
            i = obj10;
            obj10 = wVar;
        }
        d dVar = d.c(obj10);
        i iVar = new i(dVar);
        z.a aVar = new z.a(obj10, dVar);
        dVar.e();
        if (i != 0) {
            obj10.e();
        }
        return this.a.f(iVar, i2, i3, h4, aVar);
    }

    @Override // com.bumptech.glide.load.j
    public boolean d(InputStream inputStream, h h2) {
        return this.a.p(inputStream);
    }
}
