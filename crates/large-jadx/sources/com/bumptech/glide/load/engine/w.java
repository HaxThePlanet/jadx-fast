package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.f;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: ResourceCacheKey.java */
/* loaded from: classes.dex */
final class w implements f {

    private static final com.bumptech.glide.t.h<Class<?>, byte[]> j = new h<>();
    private final b b;
    private final f c;
    private final f d;
    private final int e;
    private final int f;
    private final Class<?> g;
    private final com.bumptech.glide.load.h h;
    private final com.bumptech.glide.load.l<?> i;

    w(b bVar, f fVar, f fVar2, int i, int i2, com.bumptech.glide.load.l<?> lVar, Class<?> cls, com.bumptech.glide.load.h hVar) {
        super();
        this.b = bVar;
        this.c = fVar;
        this.d = fVar2;
        this.e = i;
        this.f = i2;
        this.i = lVar;
        this.g = cls;
        this.h = hVar;
    }

    private byte[] c() throws java.io.UnsupportedEncodingException {
        Object obj;
        final com.bumptech.glide.t.h hVar = w.j;
        if ((byte[])hVar.g(this.g) == null) {
            w.j.k(this.g, this.g.getName().getBytes(f.a));
        }
        return obj;
    }

    public void a(MessageDigest messageDigest) {
        Object obj = this.b.c(8, byte[].class);
        ByteBuffer.wrap(obj).putInt(this.e).putInt(this.f).array();
        this.d.a(messageDigest);
        this.c.a(messageDigest);
        messageDigest.update(obj);
        if (this.i != null) {
            this.i.a(messageDigest);
        }
        this.h.a(messageDigest);
        messageDigest.update(c());
        this.b.d(obj);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = false;
        equals = object instanceof w;
        int i4 = 0;
        if (object instanceof w) {
            if (this.f == object.f) {
                if (this.e == object.e) {
                    if (l.c(this.i, object.i)) {
                        if (this.g.equals(object.g)) {
                            if (this.c.equals(object.c)) {
                                if (this.d.equals(object.d)) {
                                    if (this.h.equals(object.h)) {
                                        int i5 = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        i = (this.c.hashCode() * 31) + this.d.hashCode() * 31 + this.e * 31 + this.f;
        if (this.i != null) {
            i = (this.c.hashCode() * 31 + this.d.hashCode() * 31 + this.e * 31 + this.f) * 31 + this.i.hashCode();
        }
        return (i * 31) + this.g.hashCode() * 31 + this.h.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ResourceCacheKey{sourceKey=";
        String str3 = ", signature=";
        String str4 = ", width=";
        String str5 = ", height=";
        String str6 = ", decodedResourceClass=";
        String str7 = ", transformation='";
        String str8 = ", options=";
        str = str2 + this.c + str3 + this.d + str4 + this.e + str5 + this.f + str6 + this.g + str7 + this.i + 39 + str8 + this.h + 125;
        return str;
    }
}
