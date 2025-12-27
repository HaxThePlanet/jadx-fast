package com.bumptech.glide.load;

import com.bumptech.glide.t.b;
import d.e.a;
import d.e.g;
import java.security.MessageDigest;

/* compiled from: Options.java */
/* loaded from: classes.dex */
public final class h implements f {

    private final a<g<?>, Object> b = new b<>();
    public h() {
        super();
        final b bVar = new b();
    }

    private static <T> void f(g<T> gVar, Object object, MessageDigest messageDigest) {
        gVar.g(object, messageDigest);
    }

    public void a(MessageDigest messageDigest) {
        int i = 0;
        i = 0;
        while (i < this.b.size()) {
            h.f((g)this.b.j(i), this.b.n(i), messageDigest);
            i = i + 1;
        }
    }

    public <T> T c(g<T> gVar) {
        Object obj;
        if (this.b.containsKey(gVar)) {
            obj = this.b.get(gVar);
        } else {
            obj = gVar.c();
        }
        return obj;
    }

    public void d(h hVar) {
        this.b.k(hVar.b);
    }

    public <T> h e(g<T> gVar, T t) {
        this.b.put(gVar, t);
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        if (object instanceof h) {
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
        String str2 = "Options{values=";
        str = str2 + this.b + 125;
        return str;
    }
}
