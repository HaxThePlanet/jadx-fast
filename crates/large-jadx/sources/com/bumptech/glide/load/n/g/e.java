package com.bumptech.glide.load.n.g;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.n.e.c;

/* compiled from: GifDrawableResource.java */
/* loaded from: classes.dex */
public class e extends c<c> implements q {
    public e(c cVar) {
        super(cVar);
    }

    @Override // com.bumptech.glide.load.n.e.c
    public void a() {
        (c)this.a.stop();
        (c)this.a.k();
    }

    @Override // com.bumptech.glide.load.n.e.c
    public Class<c> b() {
        return c.class;
    }

    @Override // com.bumptech.glide.load.n.e.c
    public int getSize() {
        return (c)this.a.i();
    }

    @Override // com.bumptech.glide.load.n.e.c
    public void initialize() {
        (c)this.a.e().prepareToDraw();
    }
}
