package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.l;
import com.bumptech.glide.t.k;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: EngineKey.java */
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
    n(Object object, f fVar, int i, int i2, Map<Class<?>, l<?>> map, Class<?> cls, Class<?> cls2, h hVar) {
        super();
        k.d(object);
        this.b = object;
        k.e(fVar, "Signature must not be null");
        this.g = fVar;
        this.c = i;
        this.d = i2;
        k.d(map);
        this.h = map;
        k.e(cls, "Resource class must not be null");
        this.e = cls;
        k.e(cls2, "Transcode class must not be null");
        this.f = cls2;
        k.d(hVar);
        this.i = hVar;
    }

    public void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = false;
        equals = object instanceof n;
        int i3 = 0;
        if (object instanceof n) {
            if (this.b.equals(object.b)) {
                if (this.g.equals(object.g)) {
                    if (this.d == object.d) {
                        if (this.c == object.c) {
                            if (this.h.equals(object.h)) {
                                if (this.e.equals(object.e)) {
                                    if (this.f.equals(object.f)) {
                                        if (this.i.equals(object.i)) {
                                            int i4 = 1;
                                        }
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
        if (this.j == 0) {
            int i4 = this.b.hashCode();
            this.j = i4;
            int i6 = (i4 * 31) + this.g.hashCode();
            this.j = i6;
            int i8 = (i6 * 31) + this.c;
            this.j = i8;
            int i10 = (i8 * 31) + this.d;
            this.j = i10;
            int i12 = (i10 * 31) + this.h.hashCode();
            this.j = i12;
            int i14 = (i12 * 31) + this.e.hashCode();
            this.j = i14;
            int i16 = (i14 * 31) + this.f.hashCode();
            this.j = i16;
            i = (i16 * 31) + this.i.hashCode();
            this.j = i;
        }
        return this.j;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "EngineKey{model=";
        String str3 = ", width=";
        String str4 = ", height=";
        String str5 = ", resourceClass=";
        String str6 = ", transcodeClass=";
        String str7 = ", signature=";
        String str8 = ", hashCode=";
        String str9 = ", transformations=";
        String str10 = ", options=";
        str = str2 + this.b + str3 + this.c + str4 + this.d + str5 + this.e + str6 + this.f + str7 + this.g + str8 + this.j + str9 + this.h + str10 + this.i + 125;
        return str;
    }
}
