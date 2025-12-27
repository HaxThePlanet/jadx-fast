package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import d.l.a.a;
import l.q;

/* compiled from: FileRequestHandler.java */
/* loaded from: classes2.dex */
class k extends g {
    k(Context context) {
        super(context);
    }

    static int k(Uri uri) {
        return new a(uri.getPath()).c("Orientation", 1);
    }

    @Override // com.squareup.picasso.g
    public boolean c(w wVar) {
        return "file".equals(wVar.d.getScheme());
    }

    @Override // com.squareup.picasso.g
    public y.a f(w wVar, int i) {
        return new y.a(null, q.l(j(wVar)), t.e.DISK, k.k(wVar.d));
    }
}
