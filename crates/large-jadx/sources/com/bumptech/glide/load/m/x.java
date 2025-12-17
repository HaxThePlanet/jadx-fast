package com.bumptech.glide.load.m;

import android.net.Uri;
import com.bumptech.glide.load.h;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class x<Data>  implements com.bumptech.glide.load.m.n<Uri, Data> {

    private static final Set<String> b;
    private final com.bumptech.glide.load.m.n<com.bumptech.glide.load.m.g, Data> a;

    public static class a implements com.bumptech.glide.load.m.o<Uri, InputStream> {
        public com.bumptech.glide.load.m.n<Uri, InputStream> b(com.bumptech.glide.load.m.r r) {
            x xVar = new x(r.d(g.class, InputStream.class));
            return xVar;
        }
    }
    static {
        HashSet hashSet = new HashSet(Arrays.asList(/* result */));
        x.b = Collections.unmodifiableSet(hashSet);
    }

    public x(com.bumptech.glide.load.m.n<com.bumptech.glide.load.m.g, Data> n) {
        super();
        this.a = n;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean a(Object object) {
        return d((Uri)object);
    }

    @Override // com.bumptech.glide.load.m.n
    public com.bumptech.glide.load.m.n.a b(Object object, int i2, int i3, h h4) {
        return c((Uri)object, i2, i3, h4);
    }

    public com.bumptech.glide.load.m.n.a<Data> c(Uri uri, int i2, int i3, h h4) {
        g gVar = new g(uri.toString());
        return this.a.b(gVar, i2, i3, h4);
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean d(Uri uri) {
        return x.b.contains(uri.getScheme());
    }
}
