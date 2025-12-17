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

/* loaded from: classes.dex */
public class c implements n<Uri, InputStream> {

    private final Context a;

    public static class a implements o<Uri, InputStream> {

        private final Context a;
        public a(Context context) {
            super();
            this.a = context;
        }

        public n<Uri, InputStream> b(r r) {
            c obj2 = new c(this.a);
            return obj2;
        }
    }
    public c(Context context) {
        super();
        this.a = context.getApplicationContext();
    }

    private boolean e(h h) {
        com.bumptech.glide.load.g longValue;
        int i;
        Object obj5;
        obj5 = h.c(c0.d);
        if (obj5 != null && Long.compare(longValue, i) == 0) {
            obj5 = Long.compare(longValue, i) == 0 ? 1 : 0;
        } else {
        }
        return obj5;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean a(Object object) {
        return d((Uri)object);
    }

    @Override // com.bumptech.glide.load.m.n
    public n.a b(Object object, int i2, int i3, h h4) {
        return c((Uri)object, i2, i3, h4);
    }

    public n.a<InputStream> c(Uri uri, int i2, int i3, h h4) {
        boolean obj2;
        if (b.d(i2, i3) && e(h4)) {
            if (e(h4)) {
                d obj3 = new d(uri);
                obj2 = new n.a(obj3, c.g(this.a, uri));
                return obj2;
            }
        }
        return 0;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean d(Uri uri) {
        return b.c(uri);
    }
}
