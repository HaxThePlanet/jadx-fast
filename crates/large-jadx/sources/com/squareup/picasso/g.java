package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import l.q;

/* loaded from: classes2.dex */
class g extends com.squareup.picasso.y {

    final Context a;
    g(Context context) {
        super();
        this.a = context;
    }

    @Override // com.squareup.picasso.y
    public boolean c(com.squareup.picasso.w w) {
        return "content".equals(w.d.getScheme());
    }

    @Override // com.squareup.picasso.y
    public com.squareup.picasso.y.a f(com.squareup.picasso.w w, int i2) {
        y.a obj3 = new y.a(q.l(j(w)), t.e.DISK);
        return obj3;
    }

    @Override // com.squareup.picasso.y
    InputStream j(com.squareup.picasso.w w) {
        return this.a.getContentResolver().openInputStream(w.d);
    }
}
