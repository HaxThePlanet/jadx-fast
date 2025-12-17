package com.bumptech.glide.load.engine.a0;

import com.bumptech.glide.load.f;
import com.bumptech.glide.t.h;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.l;
import com.bumptech.glide.t.m.a;
import com.bumptech.glide.t.m.a.d;
import com.bumptech.glide.t.m.a.f;
import com.bumptech.glide.t.m.c;
import d.h.k.f;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class j {

    private final h<f, String> a;
    private final f<com.bumptech.glide.load.engine.a0.j.b> b;

    class a implements a.d<com.bumptech.glide.load.engine.a0.j.b> {
        a(com.bumptech.glide.load.engine.a0.j j) {
            super();
        }

        @Override // com.bumptech.glide.t.m.a$d
        public Object a() {
            return b();
        }

        @Override // com.bumptech.glide.t.m.a$d
        public com.bumptech.glide.load.engine.a0.j.b b() {
            try {
                j.b bVar = new j.b(MessageDigest.getInstance("SHA-256"));
                return bVar;
                RuntimeException runtimeException = new RuntimeException(th);
                throw runtimeException;
            }
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

        @Override // com.bumptech.glide.t.m.a$f
        public c f() {
            return this.b;
        }
    }
    public j() {
        super();
        h hVar = new h(1000, obj2);
        this.a = hVar;
        j.a aVar = new j.a(this);
        this.b = a.d(10, aVar);
    }

    private String a(f f) {
        Object obj = this.b.b();
        k.d(obj);
        f.a(obj.a);
        this.b.a((j.b)obj);
        return l.w(obj.a.digest());
    }

    public String b(f f) {
        Object obj;
        h hVar = this.a;
        synchronized (hVar) {
            hVar = this.a;
        }
        obj = a(f);
        final h hVar4 = this.a;
        this.a.k(f, obj);
        return obj;
        synchronized (hVar4) {
            hVar4 = this.a;
            this.a.k(f, obj);
            return obj;
        }
    }
}
