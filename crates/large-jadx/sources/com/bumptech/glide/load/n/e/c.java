package com.bumptech.glide.load.n.e;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.n.g.c;
import com.bumptech.glide.t.k;

/* compiled from: DrawableResource.java */
/* loaded from: classes.dex */
public abstract class c<T extends Drawable> implements u<T>, q {

    protected final T a;
    public c(T t) {
        super();
        k.d(t);
        this.a = t;
    }

    public final T c() {
        Drawable.ConstantState constantState = this.a.getConstantState();
        if (constantState == null) {
            return this.a;
        }
        return constantState.newDrawable();
    }

    public void initialize() {
        z = drawable instanceof BitmapDrawable;
        if (drawable instanceof BitmapDrawable) {
            drawable.getBitmap().prepareToDraw();
        } else {
            z = drawable instanceof c;
            if (drawable instanceof c) {
                drawable.e().prepareToDraw();
            }
        }
    }
}
