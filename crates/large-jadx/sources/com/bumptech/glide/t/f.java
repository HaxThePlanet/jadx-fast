package com.bumptech.glide.t;

/* loaded from: classes.dex */
public final class f {

    public interface b {
        public abstract T get();
    }

    class a implements com.bumptech.glide.t.f.b<T> {

        private volatile T a;
        final com.bumptech.glide.t.f.b b;
        a(com.bumptech.glide.t.f.b f$b) {
            this.b = b;
            super();
        }

        public T get() {
            Object obj;
            if (this.a == null && this.a == null) {
                synchronized (this) {
                    obj = this.b.get();
                    k.d(obj);
                    this.a = obj;
                }
            }
            try {
                return this.a;
            }
        }
    }
    public static <T> com.bumptech.glide.t.f.b<T> a(com.bumptech.glide.t.f.b<T> f$b) {
        f.a aVar = new f.a(b);
        return aVar;
    }
}
