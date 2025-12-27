package com.bumptech.glide.r.k;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.r.l.d;
import com.bumptech.glide.r.l.d.a;

/* compiled from: ImageViewTarget.java */
/* loaded from: classes.dex */
public abstract class e<Z> extends i<ImageView, Z> implements d.a {

    private Animatable y;
    public e(ImageView imageView) {
        super(imageView);
    }

    private void g(Z z) {
        if (z instanceof Animatable) {
            this.y = z;
            z.start();
        } else {
            Animatable animatable = null;
            this.y = animatable;
        }
    }

    private void i(Z z) {
        h(z);
        g(z);
    }

    @Override // com.bumptech.glide.r.k.i
    public void a(Drawable drawable) {
        (ImageView)this.a.setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.r.k.i
    public Drawable b() {
        return (ImageView)this.a.getDrawable();
    }

    @Override // com.bumptech.glide.r.k.i
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        if (this.y != null) {
            this.y.stop();
        }
        i(null);
        a(drawable);
    }

    @Override // com.bumptech.glide.r.k.i
    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        i(null);
        a(drawable);
    }

    @Override // com.bumptech.glide.r.k.i
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        i(null);
        a(drawable);
    }

    @Override // com.bumptech.glide.r.k.i
    public void onResourceReady(Z z, d<? super Z> dVar) {
        boolean z2;
        if (dVar == null || !dVar.a(z, this)) {
            i(z);
        }
    }

    @Override // com.bumptech.glide.r.k.i
    public void onStart() {
        if (this.y != null) {
            this.y.start();
        }
    }

    @Override // com.bumptech.glide.r.k.i
    public void onStop() {
        if (this.y != null) {
            this.y.stop();
        }
    }

    @Override // com.bumptech.glide.r.k.i
    protected abstract void h(Z z);
}
