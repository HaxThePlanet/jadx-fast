package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
class l extends com.squareup.picasso.a<ImageView> {

    com.squareup.picasso.e m;
    l(com.squareup.picasso.t t, ImageView imageView2, com.squareup.picasso.w w3, int i4, int i5, int i6, Drawable drawable7, String string8, Object object9, com.squareup.picasso.e e10, boolean z11) {
        final Object obj = this;
        super(t, imageView2, w3, i4, i5, i6, drawable7, string8, object9, z11);
        obj.m = e10;
    }

    @Override // com.squareup.picasso.a
    void a() {
        com.squareup.picasso.e eVar;
        super.a();
        if (this.m != null) {
            this.m = 0;
        }
    }

    @Override // com.squareup.picasso.a
    public void b(Bitmap bitmap, com.squareup.picasso.t.e t$e2) {
        if (bitmap == null) {
        } else {
            final Object obj2 = obj;
            if ((ImageView)obj2 == null) {
            }
            com.squareup.picasso.t tVar = this.a;
            u.c((ImageView)obj2, tVar.e, bitmap, e2, this.d, tVar.m);
            com.squareup.picasso.e obj8 = this.m;
            if (obj8 != null) {
                obj8.onSuccess();
            }
        }
        Object[] obj9 = new Object[1];
        obj8 = new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        throw obj8;
    }

    @Override // com.squareup.picasso.a
    public void c(Exception exception) {
        Drawable i;
        Object obj = this.c.get();
        if ((ImageView)obj == null) {
        }
        Drawable drawable = (ImageView)obj.getDrawable();
        if (drawable instanceof Animatable) {
            (Animatable)drawable.stop();
        }
        i = this.g;
        if (i != 0) {
            obj.setImageResource(i);
        } else {
            i = this.h;
            if (i != null) {
                obj.setImageDrawable(i);
            }
        }
        com.squareup.picasso.e eVar = this.m;
        if (eVar != null) {
            eVar.onError(exception);
        }
    }
}
