package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.resource.bitmap.w;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class k implements com.bumptech.glide.load.data.e<InputStream> {

    private final w a;

    public static final class a implements com.bumptech.glide.load.data.e.a<InputStream> {

        private final b a;
        public a(b b) {
            super();
            this.a = b;
        }

        public Class<InputStream> a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.e$a
        public com.bumptech.glide.load.data.e b(Object object) {
            return c((InputStream)object);
        }

        public com.bumptech.glide.load.data.e<InputStream> c(InputStream inputStream) {
            k kVar = new k(inputStream, this.a);
            return kVar;
        }
    }
    public k(InputStream inputStream, b b2) {
        super();
        w wVar = new w(inputStream, b2);
        this.a = wVar;
        wVar.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.e
    public Object a() {
        return d();
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
        this.a.e();
    }

    @Override // com.bumptech.glide.load.data.e
    public void c() {
        this.a.c();
    }

    @Override // com.bumptech.glide.load.data.e
    public InputStream d() {
        this.a.reset();
        return this.a;
    }
}
