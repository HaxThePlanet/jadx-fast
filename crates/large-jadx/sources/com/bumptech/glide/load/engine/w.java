package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.l;
import com.bumptech.glide.t.h;
import com.bumptech.glide.t.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
final class w implements f {

    private static final h<Class<?>, byte[]> j;
    private final b b;
    private final f c;
    private final f d;
    private final int e;
    private final int f;
    private final Class<?> g;
    private final h h;
    private final l<?> i;
    static {
        h hVar = new h(50, obj2);
        w.j = hVar;
    }

    w(b b, f f2, f f3, int i4, int i5, l<?> l6, Class<?> class7, h h8) {
        super();
        this.b = b;
        this.c = f2;
        this.d = f3;
        this.e = i4;
        this.f = i5;
        this.i = l6;
        this.g = class7;
        this.h = h8;
    }

    private byte[] c() {
        Object bytes;
        Class cls;
        final h hVar = w.j;
        if ((byte[])hVar.g(this.g) == null) {
            hVar.k(this.g, this.g.getName().getBytes(f.a));
        }
        return bytes;
    }

    @Override // com.bumptech.glide.load.f
    public void a(MessageDigest messageDigest) {
        Object obj = this.b.c(8, byte[].class);
        ByteBuffer.wrap((byte[])obj).putInt(this.e).putInt(this.f).array();
        this.d.a(messageDigest);
        this.c.a(messageDigest);
        messageDigest.update(obj);
        l lVar = this.i;
        if (lVar != null) {
            lVar.a(messageDigest);
        }
        this.h.a(messageDigest);
        messageDigest.update(c());
        this.b.d(obj);
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object object) {
        boolean equals;
        int i;
        int i2;
        Object obj4;
        i = 0;
        if (object instanceof w && this.f == object.f && this.e == object.e && l.c(this.i, object.i) && this.g.equals(object.g) && this.c.equals(object.c) && this.d.equals(object.d) && this.h.equals(object.h)) {
            if (this.f == object.f) {
                if (this.e == object.e) {
                    if (l.c(this.i, object.i)) {
                        if (this.g.equals(object.g)) {
                            if (this.c.equals(object.c)) {
                                if (this.d.equals(object.d)) {
                                    if (this.h.equals(object.h)) {
                                        i = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        int i;
        l lVar;
        lVar = this.i;
        if (lVar != null) {
            i12 += lVar;
        }
        return i10 += i17;
    }

    @Override // com.bumptech.glide.load.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ResourceCacheKey{sourceKey=");
        stringBuilder.append(this.c);
        stringBuilder.append(", signature=");
        stringBuilder.append(this.d);
        stringBuilder.append(", width=");
        stringBuilder.append(this.e);
        stringBuilder.append(", height=");
        stringBuilder.append(this.f);
        stringBuilder.append(", decodedResourceClass=");
        stringBuilder.append(this.g);
        stringBuilder.append(", transformation='");
        stringBuilder.append(this.i);
        stringBuilder.append('\'');
        stringBuilder.append(", options=");
        stringBuilder.append(this.h);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
