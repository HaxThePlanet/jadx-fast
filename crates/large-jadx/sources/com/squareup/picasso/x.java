package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class x {

    private static final AtomicInteger m;
    private final com.squareup.picasso.t a;
    private final com.squareup.picasso.w.b b;
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
    static {
        AtomicInteger atomicInteger = new AtomicInteger();
        x.m = atomicInteger;
    }

    x(com.squareup.picasso.t t, Uri uri2, int i3) {
        super();
        int i = 1;
        if (t.o) {
        } else {
            this.a = t;
            w.b bVar = new w.b(uri2, i3, t.l);
            this.b = bVar;
        }
        IllegalStateException obj2 = new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        throw obj2;
    }

    private com.squareup.picasso.w c(long l) {
        int andIncrement;
        String str;
        String string;
        String str2;
        long obj8;
        String obj9;
        andIncrement = x.m.getAndIncrement();
        com.squareup.picasso.w wVar = this.b.a();
        wVar.a = andIncrement;
        wVar.b = l;
        boolean z = tVar.n;
        final String str4 = "Main";
        if (z) {
            f0.t(str4, "created", wVar.g(), wVar.toString());
        }
        this.a.p(wVar);
        wVar.a = andIncrement;
        wVar.b = l;
        if (wVar != wVar && z) {
            wVar.a = andIncrement;
            wVar.b = l;
            if (z) {
                obj9 = new StringBuilder();
                obj9.append("into ");
                obj9.append(wVar);
                f0.t(str4, "changed", wVar.d(), obj9.toString());
            }
        }
        return wVar;
    }

    private Drawable e() {
        int i = this.f;
        int sDK_INT = Build.VERSION.SDK_INT;
        if (i != 0 && sDK_INT >= 21) {
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 21) {
                return tVar4.e.getDrawable(i);
            }
            if (sDK_INT >= 16) {
                return tVar.e.getResources().getDrawable(this.f);
            }
            TypedValue typedValue = new TypedValue();
            tVar2.e.getResources().getValue(this.f, typedValue, true);
            return tVar3.e.getResources().getDrawable(typedValue.resourceId);
        }
        return this.j;
    }

    public com.squareup.picasso.x a() {
        this.b.b(17);
        return this;
    }

    com.squareup.picasso.x b() {
        this.l = 0;
        return this;
    }

    public com.squareup.picasso.x d() {
        this.d = true;
        return this;
    }

    public void f(ImageView imageView) {
        g(imageView, 0);
    }

    public void g(ImageView imageView, com.squareup.picasso.e e2) {
        boolean z4;
        boolean z3;
        boolean readFromMemoryCache;
        boolean z2;
        boolean z;
        Object string;
        Object str;
        boolean width;
        Object str2;
        int height;
        com.squareup.picasso.w.b bVar;
        final Object obj = this;
        ImageView view2 = imageView;
        com.squareup.picasso.e eVar = e2;
        f0.c();
        if (view2 == null) {
        } else {
            obj.a.b(view2);
            if (!obj.b.c() && obj.e) {
                obj.a.b(view2);
                if (obj.e) {
                    u.d(view2, e());
                }
            }
            if (obj.d) {
                if (obj.b.d()) {
                } else {
                    width = imageView.getWidth();
                    height = imageView.getHeight();
                    if (width != 0) {
                        if (height == 0) {
                            if (obj.e) {
                                u.d(view2, e());
                            }
                        }
                        obj.b.e(width, height);
                    } else {
                    }
                    h hVar = new h(this, view2, eVar);
                    obj.a.e(view2, hVar);
                }
                IllegalStateException illegalStateException = new IllegalStateException("Fit cannot be used with resize.");
                throw illegalStateException;
            }
            com.squareup.picasso.w wVar2 = c(System.nanoTime());
            final String str6 = f0.f(wVar2);
            width = obj.a.m(str6);
            obj.a.b(view2);
            com.squareup.picasso.t tVar5 = obj.a;
            com.squareup.picasso.t.e mEMORY = t.e.MEMORY;
            u.c(imageView, tVar5.e, width, mEMORY, obj.c, tVar5.m);
            if (p.shouldReadFromMemoryCache(obj.h) && width != null && tVar6.n) {
                width = obj.a.m(str6);
                if (width != null) {
                    obj.a.b(view2);
                    tVar5 = obj.a;
                    mEMORY = t.e.MEMORY;
                    u.c(imageView, tVar5.e, width, mEMORY, obj.c, tVar5.m);
                    if (tVar6.n) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("from ");
                        stringBuilder.append(mEMORY);
                        f0.t("Main", "completed", wVar2.g(), stringBuilder.toString());
                    }
                    if (eVar != null) {
                        e2.onSuccess();
                    }
                }
            }
            if (obj.e) {
                u.d(view2, e());
            }
            super(obj.a, imageView, wVar2, obj.h, obj.i, obj.g, obj.k, str6, obj.l, e2, obj.c);
            obj.a.g(lVar2);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Target must not be null.");
        throw illegalArgumentException;
    }

    public void h(com.squareup.picasso.c0 c0) {
        boolean readFromMemoryCache;
        int i;
        f0.c();
        if (c0 == null) {
        } else {
            if (this.d) {
            } else {
                i = 0;
                this.a.c(c0);
                if (!this.b.c() && this.e) {
                    this.a.c(c0);
                    if (this.e) {
                        i = e();
                    }
                    c0.onPrepareLoad(i);
                }
                final com.squareup.picasso.w wVar = c(System.nanoTime());
                final String str3 = f0.f(wVar);
                readFromMemoryCache = this.a.m(str3);
                if (p.shouldReadFromMemoryCache(this.h) && readFromMemoryCache != null) {
                    readFromMemoryCache = this.a.m(str3);
                    if (readFromMemoryCache != null) {
                        this.a.c(c0);
                        c0.onBitmapLoaded(readFromMemoryCache, t.e.MEMORY);
                    }
                }
                if (this.e) {
                    i = e();
                }
                c0.onPrepareLoad(i);
                super(this.a, c0, wVar, this.h, this.i, this.k, str3, this.l, this.g);
                this.a.g(d0Var);
            }
            IllegalStateException obj15 = new IllegalStateException("Fit cannot be used with a Target.");
            throw obj15;
        }
        obj15 = new IllegalArgumentException("Target must not be null.");
        throw obj15;
    }

    public com.squareup.picasso.x i() {
        this.c = true;
        return this;
    }

    public com.squareup.picasso.x j() {
        if (this.f != 0) {
        } else {
            if (this.j != null) {
            } else {
                this.e = false;
                return this;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Placeholder image already set.");
            throw illegalStateException;
        }
        IllegalStateException illegalStateException2 = new IllegalStateException("Placeholder resource already set.");
        throw illegalStateException2;
    }

    public com.squareup.picasso.x k(int i, int i2) {
        this.b.e(i, i2);
        return this;
    }

    public com.squareup.picasso.x l(com.squareup.picasso.e0 e0) {
        this.b.f(e0);
        return this;
    }

    com.squareup.picasso.x m() {
        this.d = false;
        return this;
    }
}
