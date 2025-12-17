package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import d.l.a.a;
import l.q;

/* loaded from: classes2.dex */
class k extends com.squareup.picasso.g {
    k(Context context) {
        super(context);
    }

    static int k(Uri uri) {
        a aVar = new a(uri.getPath());
        return aVar.c("Orientation", 1);
    }

    @Override // com.squareup.picasso.g
    public boolean c(com.squareup.picasso.w w) {
        return "file".equals(w.d.getScheme());
    }

    @Override // com.squareup.picasso.g
    public com.squareup.picasso.y.a f(com.squareup.picasso.w w, int i2) {
        y.a aVar = new y.a(0, q.l(j(w)), t.e.DISK, k.k(w.d));
        return aVar;
    }
}
