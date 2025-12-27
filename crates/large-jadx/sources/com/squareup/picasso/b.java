package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.util.List;
import l.q;

/* compiled from: AssetRequestHandler.java */
/* loaded from: classes2.dex */
class b extends y {

    private static final int d = 22;
    private final Context a;
    private final Object b = new Object();
    private AssetManager c;
    b(Context context) {
        super();
        final Object object = new Object();
        this.a = context;
    }

    static String j(w wVar) {
        return wVar.d.toString().substring(b.d);
    }

    @Override // com.squareup.picasso.y
    public boolean c(w wVar) {
        boolean z = false;
        if ("file".equals(wVar.d.getScheme()) != null) {
            if (!wVar.d.getPathSegments().isEmpty()) {
                if ("android_asset".equals(wVar.d.getPathSegments().get(0))) {
                    int i2 = 1;
                }
            }
        }
        return z;
    }

    @Override // com.squareup.picasso.y
    public y.a f(w wVar, int i) {
        AssetManager assets;
        if (this.c == null) {
            synchronized (obj) {
                try {
                    if (this.c == null) {
                        this.c = this.a.getAssets();
                    }
                } catch (Throwable th) {
                }
            }
        }
        return new y.a(q.l(this.c.open(b.j(th))), t.e.DISK);
    }

}
