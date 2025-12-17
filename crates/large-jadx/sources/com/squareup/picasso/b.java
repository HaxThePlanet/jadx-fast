package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.util.List;
import l.q;

/* loaded from: classes2.dex */
class b extends com.squareup.picasso.y {

    private static final int d = 22;
    private final Context a;
    private final Object b;
    private AssetManager c;
    static {
    }

    b(Context context) {
        super();
        Object object = new Object();
        this.b = object;
        this.a = context;
    }

    static String j(com.squareup.picasso.w w) {
        return w.d.toString().substring(b.d);
    }

    @Override // com.squareup.picasso.y
    public boolean c(com.squareup.picasso.w w) {
        boolean equals;
        int i;
        Uri obj3;
        obj3 = w.d;
        if ("file".equals(obj3.getScheme()) != null && !obj3.getPathSegments().isEmpty() && "android_asset".equals(obj3.getPathSegments().get(0))) {
            if (!obj3.getPathSegments().isEmpty()) {
                if ("android_asset".equals(obj3.getPathSegments().get(i))) {
                    i = 1;
                }
            }
        }
        return i;
    }

    @Override // com.squareup.picasso.y
    public com.squareup.picasso.y.a f(com.squareup.picasso.w w, int i2) {
        AssetManager assets;
        Object obj3;
        obj3 = this.b;
        if (this.c == null && this.c == null) {
            obj3 = this.b;
            synchronized (obj3) {
                this.c = this.a.getAssets();
            }
        }
        obj3 = new y.a(q.l(this.c.open(b.j(w))), t.e.DISK);
        return obj3;
    }
}
