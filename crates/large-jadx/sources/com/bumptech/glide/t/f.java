package com.bumptech.glide.t;

/* compiled from: GlideSuppliers.java */
/* loaded from: classes.dex */
public final class f {

    public interface b<T> {
        T get();
    }

    class a implements f.b<T> {

        private volatile T a;
        final /* synthetic */ f.b b;
        a(f.b bVar) {
            this.b = bVar;
            super();
        }

        public T get() {
            Object obj;
            if (this.a == null) {
                synchronized (this) {
                    try {
                        if (this.a == null) {
                            obj = this.b.get();
                            k.d(obj);
                            this.a = obj;
                        }
                    } catch (Throwable th) {
                    }
                }
            }
            return this.a;
        }
    }
    public static <T> f.b<T> a(f.b<T> bVar) {
        return new f.a(bVar);
    }
}
