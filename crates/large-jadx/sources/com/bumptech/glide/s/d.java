package com.bumptech.glide.s;

import com.bumptech.glide.load.f;
import com.bumptech.glide.t.k;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class d implements f {

    private final Object b;
    public d(Object object) {
        super();
        k.d(object);
        this.b = object;
    }

    @Override // com.bumptech.glide.load.f
    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(f.a));
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object object) {
        if (object instanceof d) {
            return this.b.equals(object.b);
        }
        return 0;
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // com.bumptech.glide.load.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ObjectKey{object=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
