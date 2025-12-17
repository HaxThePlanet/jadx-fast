package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
abstract class a<T>  {

    final com.squareup.picasso.t a;
    final com.squareup.picasso.w b;
    final WeakReference<T> c;
    final boolean d;
    final int e;
    final int f;
    final int g;
    final Drawable h;
    final String i;
    final Object j;
    boolean k;
    boolean l;

    static class a extends WeakReference<M> {

        final com.squareup.picasso.a a;
        a(com.squareup.picasso.a a, M m2, ReferenceQueue<? super M> referenceQueue3) {
            super(m2, referenceQueue3);
            this.a = a;
        }
    }
    a(com.squareup.picasso.t t, T t2, com.squareup.picasso.w w3, int i4, int i5, int i6, Drawable drawable7, String string8, Object object9, boolean z10) {
        int obj1;
        Object obj3;
        Object obj9;
        super();
        this.a = t;
        this.b = w3;
        if (t2 == null) {
            obj1 = 0;
        } else {
            obj3 = new a.a(this, t2, t.k);
            obj1 = obj3;
        }
        this.c = obj1;
        this.e = i4;
        this.f = i5;
        this.d = z10;
        this.g = i6;
        this.h = drawable7;
        this.i = string8;
        if (object9 != null) {
        } else {
            obj9 = this;
        }
        this.j = obj9;
    }

    void a() {
        this.l = true;
    }

    abstract void b(Bitmap bitmap, com.squareup.picasso.t.e t$e2);

    abstract void c(Exception exception);

    String d() {
        return this.i;
    }

    int e() {
        return this.e;
    }

    int f() {
        return this.f;
    }

    com.squareup.picasso.t g() {
        return this.a;
    }

    com.squareup.picasso.t.f h() {
        return wVar.t;
    }

    com.squareup.picasso.w i() {
        return this.b;
    }

    Object j() {
        return this.j;
    }

    T k() {
        int i;
        WeakReference weakReference = this.c;
        if (weakReference == null) {
            i = 0;
        } else {
            i = weakReference.get();
        }
        return i;
    }

    boolean l() {
        return this.l;
    }

    boolean m() {
        return this.k;
    }
}
