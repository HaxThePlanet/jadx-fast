package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* compiled from: ImageViewAction.java */
/* loaded from: classes2.dex */
class l extends a<ImageView> {

    e m;
    l(t tVar, ImageView imageView, w wVar, int i, int i2, int i3, Drawable drawable, String str, Object object, e eVar, boolean z) {
        final Object tVar3 = this;
        super(tVar, imageView, wVar, i, i2, i3, drawable, str, object, z);
        tVar3.m = eVar;
    }

    @Override // com.squareup.picasso.a
    void a() {
        super.a();
        if (this.m != null) {
            com.squareup.picasso.e eVar = null;
            this.m = eVar;
        }
    }

    @Override // com.squareup.picasso.a
    public void b(Bitmap bitmap, t.e eVar) {
        if (bitmap == null) {
            Object[] arr = new Object[1];
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[] { this }));
        } else {
            final ImageView imageView = this.c.get();
            if (imageView == null) {
                return;
            }
            u.c(imageView, tVar.e, bitmap, eVar, this.d, tVar.m);
            if (this.m != null) {
                this.m.onSuccess();
            }
            return;
        }
    }

    @Override // com.squareup.picasso.a
    public void c(Exception exc) {
        Object obj = this.c.get();
        if (obj == null) {
            return;
        }
        Drawable drawable2 = obj.getDrawable();
        if (drawable2 instanceof Animatable) {
            drawable2.stop();
        }
        if (this.g != 0) {
            obj.setImageResource(this.g);
        } else {
            if (this.h != null) {
                obj.setImageDrawable(this.h);
            }
        }
        if (this.m != null) {
            this.m.onError(exc);
        }
    }
}
