package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import java.security.MessageDigest;

/* loaded from: classes.dex */
final class d implements f {

    private final f b;
    private final f c;
    d(f f, f f2) {
        super();
        this.b = f;
        this.c = f2;
    }

    @Override // com.bumptech.glide.load.f
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
        this.c.a(messageDigest);
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object object) {
        boolean equals;
        int i;
        f fVar;
        Object obj4;
        i = 0;
        if (object instanceof d && this.b.equals(object.b) && this.c.equals(object.c)) {
            if (this.b.equals(object.b)) {
                if (this.c.equals(object.c)) {
                    i = 1;
                }
            }
        }
        return i;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return i2 += i4;
    }

    @Override // com.bumptech.glide.load.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataCacheKey{sourceKey=");
        stringBuilder.append(this.b);
        stringBuilder.append(", signature=");
        stringBuilder.append(this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
