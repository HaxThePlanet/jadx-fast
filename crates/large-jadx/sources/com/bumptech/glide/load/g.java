package com.bumptech.glide.load;

import com.bumptech.glide.t.k;
import java.security.MessageDigest;

/* compiled from: Option.java */
/* loaded from: classes.dex */
public final class g<T> {

    private static final g.b<Object> e = new g$a<>();
    private final T a;
    private final g.b<T> b;
    private final String c;
    private volatile byte[] d;

    public interface b<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    class a implements g.b<Object> {
        a() {
            super();
        }

        public void a(byte[] bArr, Object object, MessageDigest messageDigest) {
        }
    }

    private g(String str, T t, g.b<T> bVar) {
        super();
        k.b(str);
        this.c = str;
        this.a = t;
        k.d(bVar);
        this.b = bVar;
    }

    public static <T> g<T> a(String str, T t, g.b<T> bVar) {
        return new g(str, t, bVar);
    }

    private static <T> g.b<T> b() {
        return g.e;
    }

    private byte[] d() throws java.io.UnsupportedEncodingException {
        if (this.d == null) {
            this.d = this.c.getBytes(f.a);
        }
        return this.d;
    }

    public static <T> g<T> e(String str) {
        return new g(str, null, g.b());
    }

    public static <T> g<T> f(String str, T t) {
        return new g(str, t, g.b());
    }

    public T c() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (object instanceof g) {
            return this.c.equals(object.c);
        }
        return false;
    }

    public void g(T t, MessageDigest messageDigest) {
        this.b.a(d(), t, messageDigest);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Option{key='";
        str = str2 + this.c + 39 + 125;
        return str;
    }
}
