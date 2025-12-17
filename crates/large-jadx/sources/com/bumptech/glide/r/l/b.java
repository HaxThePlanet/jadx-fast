package com.bumptech.glide.r.l;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/* loaded from: classes.dex */
public class b implements com.bumptech.glide.r.l.d<Drawable> {

    private final int a;
    private final boolean b;
    public b(int i, boolean z2) {
        super();
        this.a = i;
        this.b = z2;
    }

    @Override // com.bumptech.glide.r.l.d
    public boolean a(Object object, com.bumptech.glide.r.l.d.a d$a2) {
        return b((Drawable)object, a2);
    }

    @Override // com.bumptech.glide.r.l.d
    public boolean b(Drawable drawable, com.bumptech.glide.r.l.d.a d$a2) {
        Object colorDrawable;
        final int i2 = 0;
        if (a2.b() == null) {
            colorDrawable = new ColorDrawable(i2);
        }
        Drawable[] arr = new Drawable[2];
        arr[i2] = colorDrawable;
        int i = 1;
        arr[i] = drawable;
        TransitionDrawable transitionDrawable = new TransitionDrawable(arr);
        transitionDrawable.setCrossFadeEnabled(this.b);
        transitionDrawable.startTransition(this.a);
        a2.a(transitionDrawable);
        return i;
    }
}
