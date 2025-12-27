package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.t.l;

/* compiled from: AttributeStrategy.java */
/* loaded from: classes.dex */
class c implements l {

    private final c.b a = new c$b();
    private final h<c.a, Bitmap> b = new h<>();

    static class a implements m {

        private final c.b a;
        private int b;
        private int c;
        private Bitmap.Config d;
        public a(c.b bVar) {
            super();
            this.a = bVar;
        }

        public void a() {
            this.a.c(this);
        }

        public void b(int i, int i2, Bitmap.Config config) {
            this.b = i;
            this.c = i2;
            this.d = config;
        }

        @Override // java.lang.Object
        public boolean equals(Object object) {
            boolean z2 = false;
            z = object instanceof c.a;
            int i4 = 0;
            if (object instanceof c.a) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (this.d == object.d) {
                            int i5 = 1;
                        }
                    }
                }
            }
            return z2;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i = 0;
            if (this.d != null) {
                i = this.d.hashCode();
            } else {
                i = 0;
            }
            return (this.b * 31) + this.c * 31 + i;
        }

        @Override // java.lang.Object
        public String toString() {
            return c.f(this.b, this.c, this.d);
        }
    }

    static class b extends d<c.a> {
        b() {
            super();
        }

        @Override // com.bumptech.glide.load.engine.z.d
        protected c.a d() {
            return new c.a(this);
        }

        @Override // com.bumptech.glide.load.engine.z.d
        c.a e(int i, int i2, Bitmap.Config config) {
            final com.bumptech.glide.load.engine.z.m mVar = b();
            mVar.b(i, i2, config);
            return mVar;
        }
    }
    c() {
        super();
        com.bumptech.glide.load.engine.z.c.b bVar = new c.b();
        com.bumptech.glide.load.engine.z.h hVar = new h();
    }

    static String f(int i, int i2, Bitmap.Config config) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "[";
        String str2 = "x";
        String str3 = "], ";
        str4 = str + i + str2 + i2 + str3 + config;
        return str4;
    }

    private static String g(Bitmap bitmap) {
        return c.f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public String a(int i, int i2, Bitmap.Config config) {
        return c.f(i, i2, config);
    }

    public int b(Bitmap bitmap) {
        return l.g(bitmap);
    }

    public void c(Bitmap bitmap) {
        this.b.d(this.a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public Bitmap d(int i, int i2, Bitmap.Config config) {
        return (Bitmap)this.b.a(this.a.e(i, i2, config));
    }

    public String e(Bitmap bitmap) {
        return c.g(bitmap);
    }

    public Bitmap removeLast() {
        return (Bitmap)this.b.f();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "AttributeStrategy:\n  ";
        str = str2 + this.b;
        return str;
    }
}
