package com.bumptech.glide.load.m;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d.a;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader.java */
/* loaded from: classes.dex */
public final class e<Model, Data> implements n<Model, Data> {

    private final e.a<Data> a;

    public interface a<Data> {
        Class<Data> a();

        void b(Data data);

        Data decode(String str);
    }

    private static final class b<Data> implements com.bumptech.glide.load.data.d<Data> {

        private final String a;
        private final e.a<Data> b;
        private Data c;
        b(String str, e.a<Data> aVar) {
            super();
            this.a = str;
            this.b = aVar;
        }

        public Class<Data> a() {
            return this.b.a();
        }

        public void b() {
            try {
                this.b.b(this.c);
            } catch (java.io.IOException unused) {
                return;
            }
        }

        public a d() {
            return a.LOCAL;
        }

        public void e(com.bumptech.glide.h hVar, d.a<? super Data> aVar) {
            try {
                Object decode = this.b.decode(this.a);
                this.c = decode;
                aVar.f(decode);
            } catch (java.lang.IllegalArgumentException iae) {
                aVar.c(iae);
            }
        }

        public void cancel() {
        }
    }

    public static final class c<Model> implements o<Model, InputStream> {

        private final e.a<InputStream> a = new e$c$a<>();
        public c() {
            super();
            final com.bumptech.glide.load.m.e.c.a aVar = new e.c.a(this);
        }

        public n<Model, InputStream> b(r rVar) {
            return new e(this.a);
        }
    }
    public e(e.a<Data> aVar) {
        super();
        this.a = aVar;
    }

    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }

    public n.a<Data> b(Model model, int i, int i2, com.bumptech.glide.load.h hVar) {
        return new n.a(new d(model), new e.b(model.toString(), this.a));
    }
}
