package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* compiled from: TargetAction.java */
/* loaded from: classes2.dex */
final class d0 extends a<c0> {
    d0(t tVar, c0 c0Var, w wVar, int i, int i2, Drawable drawable, String str, Object object, int i3) {
        super(tVar, c0Var, wVar, i, i2, i3, drawable, str, object, false);
    }

    @Override // com.squareup.picasso.a
    void b(Bitmap bitmap, t.e eVar) {
        if (bitmap == null) {
            Object[] arr = new Object[1];
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[] { this }));
        } else {
            Object obj = k();
            if (obj != null) {
                obj.onBitmapLoaded(bitmap, eVar);
                if (bitmap.isRecycled()) {
                    throw new IllegalStateException("Target callback must not recycle bitmap!");
                }
            }
            return;
        }
    }

    @Override // com.squareup.picasso.a
    void c(Exception exc) throws android.content.res.Resources.NotFoundException {
        final Object obj = k();
        if (obj != null && this.g != 0) {
            obj.onBitmapFailed(exc, this.a.e.getResources().getDrawable(this.g));
        }
    }
}
