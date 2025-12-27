package com.bumptech.glide.load.m.y;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.data.o.b;
import com.bumptech.glide.load.data.o.c;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.m.n.a;
import com.bumptech.glide.load.m.o;
import com.bumptech.glide.load.m.r;
import com.bumptech.glide.s.d;
import java.io.InputStream;

/* compiled from: MediaStoreImageThumbLoader.java */
/* loaded from: classes.dex */
public class b implements n<Uri, InputStream> {

    private final Context a;

    public static class a implements o<Uri, InputStream> {

        private final Context a;
        public a(Context context) {
            super();
            this.a = context;
        }

        public n<Uri, InputStream> b(r rVar) {
            return new b(this.a);
        }
    }
    public b(Context context) {
        super();
        this.a = context.getApplicationContext();
    }

    public n.a<InputStream> c(Uri uri, int i, int i2, h hVar) {
        if (b.d(i, i2)) {
            return new n.a(new d(uri), c.f(this.a, uri));
        }
        return null;
    }

    public boolean d(Uri uri) {
        return b.a(uri);
    }
}
