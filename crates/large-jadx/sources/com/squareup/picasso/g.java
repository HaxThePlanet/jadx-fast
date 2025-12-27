package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import l.q;

/* compiled from: ContentStreamRequestHandler.java */
/* loaded from: classes2.dex */
class g extends y {

    final Context a;
    g(Context context) {
        super();
        this.a = context;
    }

    @Override // com.squareup.picasso.y
    public boolean c(w wVar) {
        return "content".equals(wVar.d.getScheme());
    }

    @Override // com.squareup.picasso.y
    public y.a f(w wVar, int i) {
        return new y.a(q.l(j(wVar)), t.e.DISK);
    }

    @Override // com.squareup.picasso.y
    InputStream j(w wVar) throws java.io.FileNotFoundException {
        return this.a.getContentResolver().openInputStream(wVar.d);
    }
}
