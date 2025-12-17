package com.bumptech.glide.load.n.e;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.n.g.c;
import com.bumptech.glide.t.k;

/* loaded from: classes.dex */
public abstract class c<T extends Drawable>  implements u<T>, q {

    protected final T a;
    public c(T t) {
        super();
        k.d(t);
        this.a = (Drawable)t;
    }

    public final T c() {
        Drawable.ConstantState constantState = this.a.getConstantState();
        if (constantState == null) {
            return this.a;
        }
        return constantState.newDrawable();
    }

    @Override // com.bumptech.glide.load.engine.u
    public Object get() {
        return c();
    }

    @Override // com.bumptech.glide.load.engine.u
    public void initialize() {
        Object bitmap;
        boolean z;
        bitmap = this.a;
        if (bitmap instanceof BitmapDrawable) {
            (BitmapDrawable)bitmap.getBitmap().prepareToDraw();
        } else {
            if (bitmap instanceof c) {
                (c)bitmap.e().prepareToDraw();
            }
        }
    }
}
