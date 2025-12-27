package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* compiled from: DataCacheKey.java */
/* loaded from: classes.dex */
final class d implements f {

    private final f b;
    private final f c;
    d(f fVar, f fVar2) {
        super();
        this.b = fVar;
        this.c = fVar2;
    }

    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
        this.c.a(messageDigest);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = false;
        equals = object instanceof d;
        int i = 0;
        if (object instanceof d) {
            if (this.b.equals(object.b)) {
                if (this.c.equals(object.c)) {
                    int i2 = 1;
                }
            }
        }
        return z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DataCacheKey{sourceKey=";
        String str3 = ", signature=";
        str = str2 + this.b + str3 + this.c + 125;
        return str;
    }
}
