package app.dogo.com.dogo_android.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.c;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.o.l;
import com.bumptech.glide.o.q;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.g;

/* compiled from: GlideRequests.java */
/* loaded from: classes.dex */
public class p extends k {
    public p(c cVar, l lVar, q qVar, Context context) {
        super(cVar, lVar, qVar, context);
    }

    @Override // com.bumptech.glide.k
    public o<Drawable> A(Uri uri) {
        return (o)super.j(uri);
    }

    @Override // com.bumptech.glide.k
    public o<Drawable> B(Integer integer) {
        return (o)super.k(integer);
    }

    @Override // com.bumptech.glide.k
    public o<Drawable> C(Object object) {
        return (o)super.l(object);
    }

    @Override // com.bumptech.glide.k
    public o<Drawable> D(String str) {
        return (o)super.m(str);
    }

    @Override // com.bumptech.glide.k
    protected void r(g gVar) {
        z = gVar instanceof n;
        if (gVar instanceof n) {
            super.r(gVar);
        } else {
            super.r(new n().v0(gVar));
        }
    }

    @Override // com.bumptech.glide.k
    public p v(f<Object> fVar) {
        super.a(fVar);
        return (p)this;
    }

    @Override // com.bumptech.glide.k
    public <ResourceType> o<ResourceType> w(Class<ResourceType> cls) {
        return new o(this.a, this, cls, this.b);
    }

    @Override // com.bumptech.glide.k
    public o<Bitmap> x() {
        return (o)super.c();
    }

    @Override // com.bumptech.glide.k
    public o<Drawable> y() {
        return (o)super.d();
    }

    @Override // com.bumptech.glide.k
    public o<Drawable> z(Drawable drawable) {
        return (o)super.i(drawable);
    }
}
