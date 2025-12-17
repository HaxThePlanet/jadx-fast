package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.t.l;

/* loaded from: classes.dex */
class c implements com.bumptech.glide.load.engine.z.l {

    private final com.bumptech.glide.load.engine.z.c.b a;
    private final com.bumptech.glide.load.engine.z.h<com.bumptech.glide.load.engine.z.c.a, Bitmap> b;

    static class a implements com.bumptech.glide.load.engine.z.m {

        private final com.bumptech.glide.load.engine.z.c.b a;
        private int b;
        private int c;
        private Bitmap.Config d;
        public a(com.bumptech.glide.load.engine.z.c.b c$b) {
            super();
            this.a = b;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void a() {
            this.a.c(this);
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void b(int i, int i2, Bitmap.Config bitmap$Config3) {
            this.b = i;
            this.c = i2;
            this.d = config3;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public boolean equals(Object object) {
            boolean i;
            int i3;
            int i2;
            Object obj4;
            i3 = 0;
            if (object instanceof c.a && this.b == object.b && this.c == object.c && this.d == object.d) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (this.d == object.d) {
                            i3 = 1;
                        }
                    }
                }
            }
            return i3;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public int hashCode() {
            int i;
            Bitmap.Config config = this.d;
            if (config != null) {
                i = config.hashCode();
            } else {
                i = 0;
            }
            return i5 += i;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public String toString() {
            return c.f(this.b, this.c, this.d);
        }
    }

    static class b extends com.bumptech.glide.load.engine.z.d<com.bumptech.glide.load.engine.z.c.a> {
        @Override // com.bumptech.glide.load.engine.z.d
        protected com.bumptech.glide.load.engine.z.m a() {
            return d();
        }

        @Override // com.bumptech.glide.load.engine.z.d
        protected com.bumptech.glide.load.engine.z.c.a d() {
            c.a aVar = new c.a(this);
            return aVar;
        }

        @Override // com.bumptech.glide.load.engine.z.d
        com.bumptech.glide.load.engine.z.c.a e(int i, int i2, Bitmap.Config bitmap$Config3) {
            final com.bumptech.glide.load.engine.z.m mVar = b();
            (c.a)mVar.b(i, i2, config3);
            return mVar;
        }
    }
    c() {
        super();
        c.b bVar = new c.b();
        this.a = bVar;
        h hVar = new h();
        this.b = hVar;
    }

    static String f(int i, int i2, Bitmap.Config bitmap$Config3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(i);
        stringBuilder.append("x");
        stringBuilder.append(i2);
        stringBuilder.append("], ");
        stringBuilder.append(config3);
        return stringBuilder.toString();
    }

    private static String g(Bitmap bitmap) {
        return c.f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String a(int i, int i2, Bitmap.Config bitmap$Config3) {
        return c.f(i, i2, config3);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public int b(Bitmap bitmap) {
        return l.g(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public void c(Bitmap bitmap) {
        this.b.d(this.a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap d(int i, int i2, Bitmap.Config bitmap$Config3) {
        return (Bitmap)this.b.a(this.a.e(i, i2, config3));
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String e(Bitmap bitmap) {
        return c.g(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap removeLast() {
        return (Bitmap)this.b.f();
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AttributeStrategy:\n  ");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}
