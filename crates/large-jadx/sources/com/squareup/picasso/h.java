package com.squareup.picasso;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* compiled from: DeferredRequestCreator.java */
/* loaded from: classes2.dex */
class h implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    private final x a;
    final WeakReference<ImageView> b = new WeakReference<>();
    e c;
    h(x xVar, ImageView imageView, e eVar) {
        super();
        this.a = xVar;
        WeakReference weakReference = new WeakReference(imageView);
        this.c = eVar;
        imageView.addOnAttachStateChangeListener(this);
        if (imageView.getWindowToken() != null) {
            onViewAttachedToWindow(imageView);
        }
    }

    void a() {
        this.a.b();
        this.c = null;
        Object obj = this.b.get();
        if (obj == null) {
            return;
        }
        this.b.clear();
        obj.removeOnAttachStateChangeListener(this);
        ViewTreeObserver viewTreeObserver = obj.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
    }

    public boolean onPreDraw() {
        Object obj = this.b.get();
        final boolean z = true;
        if (obj == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = obj.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = obj.getWidth();
        final int height = obj.getHeight();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }
}
