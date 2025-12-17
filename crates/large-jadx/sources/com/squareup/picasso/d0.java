package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
final class d0 extends com.squareup.picasso.a<com.squareup.picasso.c0> {
    d0(com.squareup.picasso.t t, com.squareup.picasso.c0 c02, com.squareup.picasso.w w3, int i4, int i5, Drawable drawable6, String string7, Object object8, int i9) {
        super(t, c02, w3, i4, i5, i9, drawable6, string7, object8, 0);
    }

    @Override // com.squareup.picasso.a
    void b(Bitmap bitmap, com.squareup.picasso.t.e t$e2) {
        Bitmap obj2;
        if (bitmap == null) {
        } else {
            Object obj = k();
            if ((c0)obj != null) {
                (c0)obj.onBitmapLoaded(bitmap, e2);
                if (bitmap.isRecycled()) {
                } else {
                }
                obj2 = new IllegalStateException("Target callback must not recycle bitmap!");
                throw obj2;
            }
        }
        Object[] obj3 = new Object[1];
        obj2 = new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        throw obj2;
    }

    @Override // com.squareup.picasso.a
    void c(Exception exception) {
        Drawable drawable;
        int i;
        final Object obj = k();
        if ((c0)obj != null) {
            if (this.g != 0) {
                (c0)obj.onBitmapFailed(exception, tVar.e.getResources().getDrawable(this.g));
            } else {
                obj.onBitmapFailed(exception, this.h);
            }
        }
    }
}
