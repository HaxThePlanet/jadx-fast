package com.bumptech.glide.load.m.y;

import com.bumptech.glide.load.data.j;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.m;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.m.n.a;
import com.bumptech.glide.load.m.o;
import com.bumptech.glide.load.m.r;
import java.io.InputStream;

/* compiled from: HttpGlideUrlLoader.java */
/* loaded from: classes.dex */
public class a implements n<com.bumptech.glide.load.m.g, InputStream> {

    public static final com.bumptech.glide.load.g<Integer> b;
    private final m<com.bumptech.glide.load.m.g, com.bumptech.glide.load.m.g> a;

    public static class a implements o<com.bumptech.glide.load.m.g, InputStream> {

        private final m<com.bumptech.glide.load.m.g, com.bumptech.glide.load.m.g> a = new m<>();
        public a() {
            super();
            final m mVar = new m(500L, r2);
        }

        public n<com.bumptech.glide.load.m.g, InputStream> b(r rVar) {
            return new a(this.a);
        }
    }
    static {
        a.b = g.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    }

    public a(m<com.bumptech.glide.load.m.g, com.bumptech.glide.load.m.g> mVar) {
        super();
        this.a = mVar;
    }

    public n.a<InputStream> c(com.bumptech.glide.load.m.g gVar, int i, int i2, h hVar) {
        com.bumptech.glide.load.m.g gVar2;
        if (this.a != null) {
            i = 0;
            Object i22 = this.a.a(gVar, i, i);
            if (i22 == null) {
                this.a.b(gVar, i, i, gVar);
            } else {
            }
        }
        return new n.a(gVar2, new j(gVar2, (Integer)hVar.c(a.b).intValue()));
    }

    public boolean d(com.bumptech.glide.load.m.g gVar) {
        return true;
    }
}
