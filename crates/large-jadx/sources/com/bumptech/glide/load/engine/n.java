package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.l;
import com.bumptech.glide.t.k;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes.dex */
class n implements f {

    private final Object b;
    private final int c;
    private final int d;
    private final Class<?> e;
    private final Class<?> f;
    private final f g;
    private final Map<Class<?>, l<?>> h;
    private final h i;
    private int j;
    n(Object object, f f2, int i3, int i4, Map<Class<?>, l<?>> map5, Class<?> class6, Class<?> class7, h h8) {
        super();
        k.d(object);
        this.b = object;
        k.e(f2, "Signature must not be null");
        this.g = (f)f2;
        this.c = i3;
        this.d = i4;
        k.d(map5);
        this.h = (Map)map5;
        k.e(class6, "Resource class must not be null");
        this.e = (Class)class6;
        k.e(class7, "Transcode class must not be null");
        this.f = (Class)class7;
        k.d(h8);
        this.i = (h)h8;
    }

    @Override // com.bumptech.glide.load.f
    public void a(MessageDigest messageDigest) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object object) {
        boolean equals;
        int i;
        Object obj;
        Object obj4;
        i = 0;
        if (object instanceof n && this.b.equals(object.b) && this.g.equals(object.g) && this.d == object.d && this.c == object.c && this.h.equals(object.h) && this.e.equals(object.e) && this.f.equals(object.f) && this.i.equals(object.i)) {
            if (this.b.equals(object.b)) {
                if (this.g.equals(object.g)) {
                    if (this.d == object.d) {
                        if (this.c == object.c) {
                            if (this.h.equals(object.h)) {
                                if (this.e.equals(object.e)) {
                                    if (this.f.equals(object.f)) {
                                        if (this.i.equals(object.i)) {
                                            i = 1;
                                        }
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
        int i2;
        if (this.j == 0) {
            int i4 = this.b.hashCode();
            this.j = i4;
            i5 += i18;
            this.j = i6;
            i7 += i19;
            this.j = i8;
            i9 += i20;
            this.j = i10;
            i11 += i21;
            this.j = i12;
            i13 += i22;
            this.j = i14;
            i15 += i23;
            this.j = i16;
            this.j = i17 += i2;
        }
        return this.j;
    }

    @Override // com.bumptech.glide.load.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EngineKey{model=");
        stringBuilder.append(this.b);
        stringBuilder.append(", width=");
        stringBuilder.append(this.c);
        stringBuilder.append(", height=");
        stringBuilder.append(this.d);
        stringBuilder.append(", resourceClass=");
        stringBuilder.append(this.e);
        stringBuilder.append(", transcodeClass=");
        stringBuilder.append(this.f);
        stringBuilder.append(", signature=");
        stringBuilder.append(this.g);
        stringBuilder.append(", hashCode=");
        stringBuilder.append(this.j);
        stringBuilder.append(", transformations=");
        stringBuilder.append(this.h);
        stringBuilder.append(", options=");
        stringBuilder.append(this.i);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
