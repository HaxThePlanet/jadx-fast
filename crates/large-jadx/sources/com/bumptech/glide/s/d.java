package com.bumptech.glide.s;

import com.bumptech.glide.load.f;
import com.bumptech.glide.t.k;
import java.security.MessageDigest;

/* compiled from: ObjectKey.java */
/* loaded from: classes.dex */
public final class d implements f {

    private final Object b;
    public d(Object object) {
        super();
        k.d(object);
        this.b = object;
    }

    public void a(MessageDigest messageDigest) throws java.io.UnsupportedEncodingException {
        messageDigest.update(this.b.toString().getBytes(f.a));
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        if (object instanceof d) {
            return this.b.equals(object.b);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ObjectKey{object=";
        str = str2 + this.b + 125;
        return str;
    }
}
