package com.bumptech.glide.r.k;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.r.d;
import com.bumptech.glide.t.l;

/* loaded from: classes.dex */
public abstract class c<T>  implements com.bumptech.glide.r.k.h<T> {

    private final int height;
    private d request;
    private final int width;
    public c() {
        final int i = Integer.MIN_VALUE;
        super(i, i);
    }

    public c(int i, int i2) {
        super();
        if (!l.t(i, i2)) {
        } else {
            this.width = i;
            this.height = i2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        stringBuilder.append(i);
        stringBuilder.append(" and height: ");
        stringBuilder.append(i2);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // com.bumptech.glide.r.k.h
    public final d getRequest() {
        return this.request;
    }

    @Override // com.bumptech.glide.r.k.h
    public final void getSize(com.bumptech.glide.r.k.g g) {
        g.f(this.width, this.height);
    }

    @Override // com.bumptech.glide.r.k.h
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.r.k.h
    public void onLoadFailed(Drawable drawable) {
    }

    @Override // com.bumptech.glide.r.k.h
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.r.k.h
    public void onStart() {
    }

    @Override // com.bumptech.glide.r.k.h
    public void onStop() {
    }

    @Override // com.bumptech.glide.r.k.h
    public final void removeCallback(com.bumptech.glide.r.k.g g) {
    }

    @Override // com.bumptech.glide.r.k.h
    public final void setRequest(d d) {
        this.request = d;
    }
}
