package com.bumptech.glide.r.k;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.r.l.d;
import com.bumptech.glide.r.l.d.a;

/* loaded from: classes.dex */
public abstract class e<Z>  extends com.bumptech.glide.r.k.i<ImageView, Z> implements d.a {

    private Animatable y;
    public e(ImageView imageView) {
        super(imageView);
    }

    private void g(Z z) {
        Object obj2;
        if (z instanceof Animatable) {
            this.y = (Animatable)z;
            z.start();
        } else {
            this.y = 0;
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

    protected abstract void h(Z z);

    @Override // com.bumptech.glide.r.k.i
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.y;
        if (animatable != null) {
            animatable.stop();
        }
        i(0);
        a(drawable);
    }

    @Override // com.bumptech.glide.r.k.i
    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        i(0);
        a(drawable);
    }

    @Override // com.bumptech.glide.r.k.i
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        i(0);
        a(drawable);
    }

    public void onResourceReady(Z z, d<? super Z> d2) {
        boolean obj2;
        if (d2) {
            if (!d2.a(z, this)) {
                i(z);
            } else {
                g(z);
            }
        } else {
        }
    }

    @Override // com.bumptech.glide.r.k.i
    public void onStart() {
        final Animatable animatable = this.y;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.r.k.i
    public void onStop() {
        final Animatable animatable = this.y;
        if (animatable != null) {
            animatable.stop();
        }
    }
}
