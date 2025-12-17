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

/* loaded from: classes.dex */
public class p extends k {
    public p(c c, l l2, q q3, Context context4) {
        super(c, l2, q3, context4);
    }

    public app.dogo.com.dogo_android.util.o<Drawable> A(Uri uri) {
        return (o)super.j(uri);
    }

    public app.dogo.com.dogo_android.util.o<Drawable> B(Integer integer) {
        return (o)super.k(integer);
    }

    public app.dogo.com.dogo_android.util.o<Drawable> C(Object object) {
        return (o)super.l(object);
    }

    public app.dogo.com.dogo_android.util.o<Drawable> D(String string) {
        return (o)super.m(string);
    }

    @Override // com.bumptech.glide.k
    public k a(f f) {
        return v(f);
    }

    @Override // com.bumptech.glide.k
    public j b(Class class) {
        return w(class);
    }

    @Override // com.bumptech.glide.k
    public j c() {
        return x();
    }

    @Override // com.bumptech.glide.k
    public j d() {
        return y();
    }

    @Override // com.bumptech.glide.k
    public j i(Drawable drawable) {
        return z(drawable);
    }

    @Override // com.bumptech.glide.k
    public j k(Integer integer) {
        return B(integer);
    }

    @Override // com.bumptech.glide.k
    public j l(Object object) {
        return C(object);
    }

    @Override // com.bumptech.glide.k
    protected void r(g g) {
        boolean nVar;
        Object obj2;
        if (g instanceof n) {
            super.r(g);
        } else {
            nVar = new n();
            super.r(nVar.v0(g));
        }
    }

    public app.dogo.com.dogo_android.util.p v(f<Object> f) {
        super.a(f);
        return (p)this;
    }

    public <ResourceType> app.dogo.com.dogo_android.util.o<ResourceType> w(Class<ResourceType> class) {
        o oVar = new o(this.a, this, class, this.b);
        return oVar;
    }

    public app.dogo.com.dogo_android.util.o<Bitmap> x() {
        return (o)super.c();
    }

    public app.dogo.com.dogo_android.util.o<Drawable> y() {
        return (o)super.d();
    }

    public app.dogo.com.dogo_android.util.o<Drawable> z(Drawable drawable) {
        return (o)super.i(drawable);
    }
}
