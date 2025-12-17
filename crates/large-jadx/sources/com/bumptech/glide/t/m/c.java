package com.bumptech.glide.t.m;

/* loaded from: classes.dex */
public abstract class c {

    static class a {
    }

    private static class b extends com.bumptech.glide.t.m.c {

        private volatile boolean a;
        b() {
            super(0);
        }

        @Override // com.bumptech.glide.t.m.c
        public void b(boolean z) {
            this.a = z;
        }

        @Override // com.bumptech.glide.t.m.c
        public void c() {
            if (this.a) {
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException("Already released");
            throw illegalStateException;
        }
    }
    c(com.bumptech.glide.t.m.c.a c$a) {
        super();
    }

    public static com.bumptech.glide.t.m.c a() {
        c.b bVar = new c.b();
        return bVar;
    }

    abstract void b(boolean z);

    public abstract void c();
}
