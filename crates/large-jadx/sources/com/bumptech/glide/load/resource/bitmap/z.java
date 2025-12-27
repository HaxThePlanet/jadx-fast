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

/* compiled from: StreamBitmapDecoder.java */
/* loaded from: classes.dex */
public class z implements j<InputStream, Bitmap> {

    private final m a;
    private final b b;

    static class a implements m.b {

        private final w a;
        private final d b;
        a(w wVar, d dVar) {
            super();
            this.a = wVar;
            this.b = dVar;
        }

        public void a(e eVar, Bitmap bitmap) {
            java.io.IOException iOException = this.b.a();
            if (iOException != null && bitmap != null) {
                eVar.c(bitmap);
                throw iOException;
            }
        }

        public void b() {
            this.a.c();
        }
    }
    public z(m mVar, b bVar) {
        super();
        this.a = mVar;
        this.b = bVar;
    }

    public u<Bitmap> c(InputStream inputStream, int i, int i2, h hVar) {
        Object obj3;
        if (inputStream instanceof w) {
            i = 0;
        } else {
            i = 1;
        }
        d dVar = d.c(obj3);
        try {
        } catch (Throwable th) {
            obj2.e();
        }
        dVar.e();
        if (i != 0) {
            obj3.e();
        }
        return this.a.f(new i(dVar), i, i2, hVar, new z.a(obj3, dVar));
    }

    public boolean d(InputStream inputStream, h hVar) {
        return this.a.p(inputStream);
    }
}
