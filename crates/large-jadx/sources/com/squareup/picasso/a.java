package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: Action.java */
/* loaded from: classes2.dex */
abstract class a<T> {

    final t a;
    final w b;
    final WeakReference<T> c = new a$a<>();
    final boolean d;
    final int e;
    final int f;
    final int g;
    final Drawable h;
    final String i;
    final Object j;
    boolean k;
    boolean l;

    static class a<M> extends WeakReference<M> {

        final a a;
        a(M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.a = aVar;
        }
    }
    a(t tVar, T t, w wVar, int i, int i2, int i3, Drawable drawable, String str, Object object, boolean z) {
        Object obj;
        super();
        this.a = tVar;
        this.b = wVar;
        i = t == null ? 0 : i;
        final com.squareup.picasso.a.a aVar = new a.a(this, t, tVar.k);
        this.e = i;
        this.f = i2;
        this.d = z;
        this.g = i3;
        this.h = drawable;
        this.i = str;
        if (object == null) {
            obj = this;
        }
        this.j = obj;
    }

    void a() {
        this.l = true;
    }

    String d() {
        return this.i;
    }

    int e() {
        return this.e;
    }

    int f() {
        return this.f;
    }

    t g() {
        return this.a;
    }

    t.f h() {
        return this.b.t;
    }

    w i() {
        return this.b;
    }

    Object j() {
        return this.j;
    }

    T k() {
        int i = 0;
        if (this.c == null) {
            i = 0;
        } else {
            Object obj = this.c.get();
        }
        return i;
    }

    boolean l() {
        return this.l;
    }

    boolean m() {
        return this.k;
    }

    abstract void b(Bitmap bitmap, t.e eVar);

    abstract void c(Exception exc);
}
