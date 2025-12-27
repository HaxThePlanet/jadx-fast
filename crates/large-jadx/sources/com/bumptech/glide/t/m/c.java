package com.bumptech.glide.t.m;

/* compiled from: StateVerifier.java */
/* loaded from: classes.dex */
public abstract class c {

    static class a {
    }

    private static class b extends c {

        private volatile boolean a;
        b() {
            super(null);
        }

        @Override // com.bumptech.glide.t.m.c
        public void b(boolean z) {
            this.a = z;
        }

        @Override // com.bumptech.glide.t.m.c
        public void c() {
            if (this.a) {
                throw new IllegalStateException("Already released");
            }
        }
    }
    /* synthetic */ c(c.a aVar) {
        this();
    }

    public static c a() {
        return new c.b();
    }

    private c() {
        super();
    }

    abstract void b(boolean z);

    public abstract void c();
}
