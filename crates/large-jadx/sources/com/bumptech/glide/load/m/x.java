package com.bumptech.glide.load.m;

import android.net.Uri;
import com.bumptech.glide.load.h;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UrlUriLoader.java */
/* loaded from: classes.dex */
public class x<Data> implements n<Uri, Data> {

    private static final Set<String> b;
    private final n<g, Data> a;

    public static class a implements o<Uri, InputStream> {
        public n<Uri, InputStream> b(r rVar) {
            return new x(rVar.d(g.class, InputStream.class));
        }
    }
    static {
        x.b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "http", "https" })));
    }

    public x(n<g, Data> nVar) {
        super();
        this.a = nVar;
    }

    public n.a<Data> c(Uri uri, int i, int i2, h hVar) {
        return this.a.b(new g(uri.toString()), i, i2, hVar);
    }

    public boolean d(Uri uri) {
        return x.b.contains(uri.getScheme());
    }
}
