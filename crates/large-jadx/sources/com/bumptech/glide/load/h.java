package com.bumptech.glide.load;

import com.bumptech.glide.t.b;
import d.e.a;
import d.e.g;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class h implements com.bumptech.glide.load.f {

    private final a<com.bumptech.glide.load.g<?>, Object> b;
    public h() {
        super();
        b bVar = new b();
        this.b = bVar;
    }

    private static <T> void f(com.bumptech.glide.load.g<T> g, Object object2, MessageDigest messageDigest3) {
        g.g(object2, messageDigest3);
    }

    @Override // com.bumptech.glide.load.f
    public void a(MessageDigest messageDigest) {
        int i;
        Object obj2;
        Object obj;
        i = 0;
        while (i < this.b.size()) {
            h.f((g)this.b.j(i), this.b.n(i), messageDigest);
            i++;
        }
    }

    public <T> T c(com.bumptech.glide.load.g<T> g) {
        a key;
        Object obj2;
        if (this.b.containsKey(g)) {
            obj2 = this.b.get(g);
        } else {
            obj2 = g.c();
        }
        return obj2;
    }

    @Override // com.bumptech.glide.load.f
    public void d(com.bumptech.glide.load.h h) {
        this.b.k(h.b);
    }

    public <T> com.bumptech.glide.load.h e(com.bumptech.glide.load.g<T> g, T t2) {
        this.b.put(g, t2);
        return this;
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object object) {
        if (object instanceof h) {
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
        stringBuilder.append("Options{values=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
