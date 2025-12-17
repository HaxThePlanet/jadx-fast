package com.bumptech.glide.load;

import com.bumptech.glide.t.k;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class g<T>  {

    private static final com.bumptech.glide.load.g.b<Object> e;
    private final T a;
    private final com.bumptech.glide.load.g.b<T> b;
    private final String c;
    private volatile byte[] d;

    public interface b {
        public abstract void a(byte[] bArr, T t2, MessageDigest messageDigest3);
    }

    class a implements com.bumptech.glide.load.g.b<Object> {
        @Override // com.bumptech.glide.load.g$b
        public void a(byte[] bArr, Object object2, MessageDigest messageDigest3) {
        }
    }
    static {
        g.a aVar = new g.a();
        g.e = aVar;
    }

    private g(String string, T t2, com.bumptech.glide.load.g.b<T> g$b3) {
        super();
        k.b(string);
        this.c = string;
        this.a = t2;
        k.d(b3);
        this.b = (g.b)b3;
    }

    public static <T> com.bumptech.glide.load.g<T> a(String string, T t2, com.bumptech.glide.load.g.b<T> g$b3) {
        g gVar = new g(string, t2, b3);
        return gVar;
    }

    private static <T> com.bumptech.glide.load.g.b<T> b() {
        return g.e;
    }

    private byte[] d() {
        byte[] bytes;
        java.nio.charset.Charset charset;
        if (this.d == null) {
            this.d = this.c.getBytes(f.a);
        }
        return this.d;
    }

    public static <T> com.bumptech.glide.load.g<T> e(String string) {
        g gVar = new g(string, 0, g.b());
        return gVar;
    }

    public static <T> com.bumptech.glide.load.g<T> f(String string, T t2) {
        g gVar = new g(string, t2, g.b());
        return gVar;
    }

    public T c() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (object instanceof g) {
            return this.c.equals(object.c);
        }
        return 0;
    }

    public void g(T t, MessageDigest messageDigest2) {
        this.b.a(d(), t, messageDigest2);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Option{key='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
