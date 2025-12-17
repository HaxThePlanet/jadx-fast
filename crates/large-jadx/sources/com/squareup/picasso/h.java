package com.squareup.picasso;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
class h implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    private final com.squareup.picasso.x a;
    final WeakReference<ImageView> b;
    com.squareup.picasso.e c;
    h(com.squareup.picasso.x x, ImageView imageView2, com.squareup.picasso.e e3) {
        super();
        this.a = x;
        WeakReference obj1 = new WeakReference(imageView2);
        this.b = obj1;
        this.c = e3;
        imageView2.addOnAttachStateChangeListener(this);
        if (imageView2.getWindowToken() != null) {
            onViewAttachedToWindow(imageView2);
        }
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    void a() {
        this.a.b();
        this.c = 0;
        Object obj = this.b.get();
        if ((ImageView)obj == null) {
        }
        this.b.clear();
        (ImageView)obj.removeOnAttachStateChangeListener(this);
        ViewTreeObserver viewTreeObserver = obj.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public boolean onPreDraw() {
        Object viewTreeObserver;
        int width;
        Object obj = this.b.get();
        final int i = 1;
        if ((ImageView)obj == null) {
            return i;
        }
        viewTreeObserver = (ImageView)obj.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return i;
        }
        width = obj.getWidth();
        final int height = obj.getHeight();
        if (width > 0) {
            if (height <= 0) {
            } else {
                obj.removeOnAttachStateChangeListener(this);
                viewTreeObserver.removeOnPreDrawListener(this);
                this.b.clear();
                viewTreeObserver = this.a;
                viewTreeObserver.m();
                viewTreeObserver.k(width, height);
                viewTreeObserver.g(obj, this.c);
            }
        }
        return i;
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }
}
