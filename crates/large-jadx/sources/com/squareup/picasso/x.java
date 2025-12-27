package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestCreator.java */
/* loaded from: classes2.dex */
public class x {

    private static final AtomicInteger m = new AtomicInteger();
    private final t a;
    private final w.b b = new w$b();
    private boolean c;
    private boolean d;
    private boolean e = true;
    private int f;
    private int g;
    private int h;
    private int i;
    private Drawable j;
    private Drawable k;
    private Object l;

    x(t tVar, Uri uri, int i) {
        super();
        if (tVar.o) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        } else {
            this.a = tVar;
            com.squareup.picasso.w.b bVar = new w.b(uri, i, tVar.l);
            return;
        }
    }

    private w c(long j) {
        int andIncrement = x.m.getAndIncrement();
        com.squareup.picasso.w wVar2 = this.b.a();
        wVar2.a = andIncrement;
        wVar2.b = j;
        final String str7 = "Main";
        if (this.a.n) {
            str2 = "created";
            f0.t(str7, str2, wVar2.g(), wVar2.toString());
        }
        this.a.p(wVar2);
        if (wVar2 != wVar2) {
            wVar2.a = andIncrement;
            wVar2.b = j;
            if (this.a.n) {
                StringBuilder stringBuilder = new StringBuilder();
                String str5 = "into ";
                str4 = str5 + wVar2;
                f0.t(str7, "changed", wVar2.d(), str4);
            }
        }
        return wVar2;
    }

    private Drawable e() throws android.content.res.Resources.NotFoundException {
        if (this.f != 0) {
            int sDK_INT2 = Build.VERSION.SDK_INT;
            if (Build.VERSION.SDK_INT >= 21) {
                return this.a.e.getDrawable(this.f);
            }
            if (Build.VERSION.SDK_INT >= 16) {
                return this.a.e.getResources().getDrawable(this.f);
            }
            TypedValue typedValue = new TypedValue();
            this.a.e.getResources().getValue(this.f, typedValue, true);
            return this.a.e.getResources().getDrawable(typedValue.resourceId);
        }
        return this.j;
    }

    public x a() {
        this.b.b(17);
        return this;
    }

    x b() {
        this.l = null;
        return this;
    }

    public x d() {
        this.d = true;
        return this;
    }

    public void f(ImageView imageView) {
        g(imageView, null);
    }

    public void g(ImageView imageView, e eVar) {
        boolean z5;
        final com.squareup.picasso.x imageView3 = this;
        ImageView imageView2 = imageView;
        com.squareup.picasso.e eVar22 = eVar;
        f0.c();
        if (imageView2 == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else {
            if (!imageView3.b.c()) {
                imageView3.a.b(imageView2);
                if (imageView3.e) {
                    u.d(imageView2, e());
                }
                return;
            }
            if (imageView3.d) {
                if (imageView3.b.d()) {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                } else {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (!(width != 0 || height == 0)) {
                        if (imageView3.e) {
                            u.d(imageView2, e());
                        }
                    }
                    imageView3.a.e(imageView2, new h(this, imageView2, eVar22));
                    return;
                }
            }
            com.squareup.picasso.w wVar = c(System.nanoTime());
            final String str8 = f0.f(wVar);
            if (p.shouldReadFromMemoryCache(imageView3.h) && bitmap != null) {
                imageView3.a.b(imageView2);
                com.squareup.picasso.t.e mEMORY2 = t.e.MEMORY;
                u.c(imageView, tVar6.e, bitmap, mEMORY2, imageView3.c, tVar6.m);
                if (imageView3.a.n) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str5 = "from ";
                    str4 = str5 + t.e.MEMORY;
                    f0.t("Main", "completed", wVar.g(), str4);
                }
                if (eVar22 != null) {
                    eVar.onSuccess();
                }
                return;
            }
            if (imageView3.e) {
                u.d(imageView2, e());
            }
            l lVar = new l(imageView3.a, imageView, wVar, imageView3.h, imageView3.i, i, drawable, str8, obj, eVar, z6);
            imageView3.a.g(lVar);
            return;
        }
    }

    public void h(c0 c0Var) {
        Drawable drawable = null;
        Drawable drawable2 = null;
        f0.c();
        if (c0Var == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else {
            if (this.d) {
                throw new IllegalStateException("Fit cannot be used with a Target.");
            } else {
                int i2 = 0;
                if (!this.b.c()) {
                    this.a.c(c0Var);
                    if (this.e) {
                        drawable = e();
                    }
                    c0Var.onPrepareLoad(drawable);
                    return;
                }
                final com.squareup.picasso.w wVar = c(System.nanoTime());
                final String str3 = f0.f(wVar);
                if (p.shouldReadFromMemoryCache(this.h) && bitmap != null) {
                    this.a.c(c0Var);
                    c0Var.onBitmapLoaded(bitmap, t.e.MEMORY);
                    return;
                }
                if (this.e) {
                    drawable2 = e();
                }
                c0Var.onPrepareLoad(drawable2);
                d0 d0Var = new d0(this.a, c0Var, wVar, this.h, this.i, this.k, str3, this.l, this.g);
                this.a.g(d0Var);
                return;
            }
        }
    }

    public x i() {
        this.c = true;
        return this;
    }

    public x j() {
        if (this.f != 0) {
            throw new IllegalStateException("Placeholder resource already set.");
        } else {
            if (this.j != null) {
                throw new IllegalStateException("Placeholder image already set.");
            } else {
                this.e = false;
                return this;
            }
        }
    }

    public x k(int i, int i2) {
        this.b.e(i, i2);
        return this;
    }

    public x l(e0 e0Var) {
        this.b.f(e0Var);
        return this;
    }

    x m() {
        this.d = false;
        return this;
    }
}
