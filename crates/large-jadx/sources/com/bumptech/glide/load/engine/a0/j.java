package com.bumptech.glide.load.engine.a0;

import com.bumptech.glide.t.h;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.l;
import com.bumptech.glide.t.m.a;
import com.bumptech.glide.t.m.a.d;
import com.bumptech.glide.t.m.a.f;
import com.bumptech.glide.t.m.c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SafeKeyGenerator.java */
/* loaded from: classes.dex */
public class j {

    private final h<com.bumptech.glide.load.f, String> a = new h<>();
    private final d.h.k.f<j.b> b;

    class a implements a.d<j.b> {
        a() {
            super();
        }

        public j.b b() {
            try {
            } catch (java.security.NoSuchAlgorithmException noSuchAlgorithm) {
                throw new RuntimeException(noSuchAlgorithm);
            }
            return new j.b(MessageDigest.getInstance("SHA-256"));
        }
    }

    private static final class b implements a.f {

        final MessageDigest a;
        private final c b;
        b(MessageDigest messageDigest) {
            super();
            this.b = c.a();
            this.a = messageDigest;
        }

        public c f() {
            return this.b;
        }
    }
    public j() {
        super();
        h hVar = new h(1000L, r2);
        this.b = a.d(10, new j.a(this));
    }

    private String a(com.bumptech.glide.load.f fVar) {
        Object obj2 = this.b.b();
        k.d(obj2);
        try {
            fVar.a(obj2.a);
        } finally {
            this.b.a(obj);
            throw fVar;
        }
        this.b.a(obj2);
        return l.w(obj2.a.digest());
    }

    public String b(com.bumptech.glide.load.f fVar) {
        Object obj;
        synchronized (hVar) {
            try {
            } catch (Throwable unused) {
            }
        }
        if ((String)this.a.g(fVar) == null) {
            String str = a(fVar);
        }
        synchronized (hVar4) {
            try {
                this.a.k(fVar, obj);
                return obj;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }
}
