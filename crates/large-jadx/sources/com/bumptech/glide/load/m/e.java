package com.bumptech.glide.load.m;

import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.h;
import com.bumptech.glide.s.d;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class e<Model, Data>  implements com.bumptech.glide.load.m.n<Model, Data> {

    private final com.bumptech.glide.load.m.e.a<Data> a;

    public interface a {
        public abstract Class<Data> a();

        public abstract void b(Data data);

        public abstract Data decode(String string);
    }

    private static final class b implements d<Data> {

        private final String a;
        private final com.bumptech.glide.load.m.e.a<Data> b;
        private Data c;
        b(String string, com.bumptech.glide.load.m.e.a<Data> e$a2) {
            super();
            this.a = string;
            this.b = a2;
        }

        public Class<Data> a() {
            return this.b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            try {
                this.b.b(this.c);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public a d() {
            return a.LOCAL;
        }

        public void e(h h, d.a<? super Data> d$a2) {
            Object obj2;
            try {
                obj2 = this.b.decode(this.a);
                this.c = obj2;
                a2.f(obj2);
                a2.c(h);
            }
        }
    }

    public static final class c implements com.bumptech.glide.load.m.o<Model, InputStream> {

        private final com.bumptech.glide.load.m.e.a<InputStream> a;
        public c() {
            super();
            e.c.a aVar = new e.c.a(this);
            this.a = aVar;
        }

        public com.bumptech.glide.load.m.n<Model, InputStream> b(com.bumptech.glide.load.m.r r) {
            e obj2 = new e(this.a);
            return obj2;
        }
    }
    public e(com.bumptech.glide.load.m.e.a<Data> e$a) {
        super();
        this.a = a;
    }

    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }

    public com.bumptech.glide.load.m.n.a<Data> b(Model model, int i2, int i3, h h4) {
        d obj4 = new d(model);
        e.b obj5 = new e.b(model.toString(), this.a);
        n.a obj3 = new n.a(obj4, obj5);
        return obj3;
    }
}
