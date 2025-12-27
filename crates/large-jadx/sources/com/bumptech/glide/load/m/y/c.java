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
import com.bumptech.glide.load.resource.bitmap.c0;
import com.bumptech.glide.s.d;
import java.io.InputStream;

/* compiled from: MediaStoreVideoThumbLoader.java */
/* loaded from: classes.dex */
public class c implements n<Uri, InputStream> {

    private final Context a;

    public static class a implements o<Uri, InputStream> {

        private final Context a;
        public a(Context context) {
            super();
            this.a = context;
        }

        public n<Uri, InputStream> b(r rVar) {
            return new c(this.a);
        }
    }
    public c(Context context) {
        super();
        this.a = context.getApplicationContext();
    }

    private boolean e(h hVar) {
        com.bumptech.glide.load.g gVar;
        long l = -1;
        boolean z = false;
        Object obj = hVar.c(c0.d);
        if (obj != null) {
            long value = obj.longValue();
            l = -1L;
            hVar = value == l ? 1 : 0;
        }
        return (value == l ? 1 : 0);
    }

    public n.a<InputStream> c(Uri uri, int i, int i2, h hVar) {
        if (b.d(i, i2) && this.e(hVar)) {
            return new n.a(new d(uri), c.g(this.a, uri));
        }
        return null;
    }

    public boolean d(Uri uri) {
        return b.c(uri);
    }
}
