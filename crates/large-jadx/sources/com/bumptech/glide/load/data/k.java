package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.resource.bitmap.w;
import java.io.InputStream;

/* compiled from: InputStreamRewinder.java */
/* loaded from: classes.dex */
public final class k implements e<InputStream> {

    private final w a = new w();

    public static final class a implements e.a<InputStream> {

        private final b a;
        public a(b bVar) {
            super();
            this.a = bVar;
        }

        public Class<InputStream> a() {
            return InputStream.class;
        }

        public e<InputStream> c(InputStream inputStream) {
            return new k(inputStream, this.a);
        }
    }
    public k(InputStream inputStream, b bVar) {
        super();
        new w(inputStream, bVar).mark(5242880);
    }

    public void b() {
        this.a.e();
    }

    public void c() {
        this.a.c();
    }

    public InputStream d() {
        this.a.reset();
        return this.a;
    }
}
