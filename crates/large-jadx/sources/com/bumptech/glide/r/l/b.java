package com.bumptech.glide.r.l;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/* compiled from: DrawableCrossFadeTransition.java */
/* loaded from: classes.dex */
public class b implements d<Drawable> {

    private final int a;
    private final boolean b;
    public b(int i, boolean z) {
        super();
        this.a = i;
        this.b = z;
    }

    public boolean b(Drawable drawable, d.a aVar) {
        Drawable drawable2;
        final int i2 = 0;
        if (aVar.b() == null) {
            ColorDrawable colorDrawable = new ColorDrawable(i2);
        }
        Drawable[] arr = new Drawable[2];
        int i = 1;
        arr[i] = drawable;
        final TransitionDrawable transitionDrawable = new TransitionDrawable(arr);
        transitionDrawable.setCrossFadeEnabled(this.b);
        transitionDrawable.startTransition(this.a);
        aVar.a(transitionDrawable);
        return true;
    }
}
