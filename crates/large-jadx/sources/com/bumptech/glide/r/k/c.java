package com.bumptech.glide.r.k;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.r.d;
import com.bumptech.glide.t.l;

/* compiled from: CustomTarget.java */
/* loaded from: classes.dex */
public abstract class c<T> implements h<T> {

    private final int height;
    private d request;
    private final int width;
    public c() {
        final int i = Integer.MIN_VALUE;
        this(i, i);
    }

    public final d getRequest() {
        return this.request;
    }

    public final void getSize(g gVar) {
        gVar.f(this.width, this.height);
    }

    public final void setRequest(d dVar) {
        this.request = dVar;
    }

    public c(int i, int i2) {
        super();
        if (!l.t(i, i2)) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ";
            String str2 = " and height: ";
            i = str + i + str2 + i2;
            throw new IllegalArgumentException(i);
        } else {
            this.width = i;
            this.height = i2;
            return;
        }
    }

    public void onDestroy() {
    }

    public void onLoadFailed(Drawable drawable) {
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final void removeCallback(g gVar) {
    }
}
