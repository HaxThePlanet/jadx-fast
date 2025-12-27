package com.bumptech.glide.load.m.y;

import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.g;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.m.n.a;
import com.bumptech.glide.load.m.o;
import com.bumptech.glide.load.m.r;
import java.io.InputStream;
import java.net.URL;

/* compiled from: UrlLoader.java */
/* loaded from: classes.dex */
public class e implements n<URL, InputStream> {

    private final n<g, InputStream> a;

    public static class a implements o<URL, InputStream> {
        public n<URL, InputStream> b(r rVar) {
            return new e(rVar.d(g.class, InputStream.class));
        }
    }
    public e(n<g, InputStream> nVar) {
        super();
        this.a = nVar;
    }

    public n.a<InputStream> c(URL url, int i, int i2, h hVar) {
        return this.a.b(new g(url), i, i2, hVar);
    }

    public boolean d(URL url) {
        return true;
    }
}
