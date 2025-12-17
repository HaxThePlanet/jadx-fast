package com.bumptech.glide.load.m.y;

import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.g;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.m.n.a;
import com.bumptech.glide.load.m.o;
import com.bumptech.glide.load.m.r;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes.dex */
public class e implements n<URL, InputStream> {

    private final n<g, InputStream> a;

    public static class a implements o<URL, InputStream> {
        public n<URL, InputStream> b(r r) {
            e eVar = new e(r.d(g.class, InputStream.class));
            return eVar;
        }
    }
    public e(n<g, InputStream> n) {
        super();
        this.a = n;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean a(Object object) {
        return d((URL)object);
    }

    @Override // com.bumptech.glide.load.m.n
    public n.a b(Object object, int i2, int i3, h h4) {
        return c((URL)object, i2, i3, h4);
    }

    public n.a<InputStream> c(URL uRL, int i2, int i3, h h4) {
        g gVar = new g(uRL);
        return this.a.b(gVar, i2, i3, h4);
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean d(URL uRL) {
        return 1;
    }
}
