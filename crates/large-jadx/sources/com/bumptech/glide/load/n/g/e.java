package com.bumptech.glide.load.n.g;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.q;
import com.bumptech.glide.load.n.e.c;

/* loaded from: classes.dex */
public class e extends c<com.bumptech.glide.load.n.g.c> implements q {
    public e(com.bumptech.glide.load.n.g.c c) {
        super(c);
    }

    @Override // com.bumptech.glide.load.n.e.c
    public void a() {
        (c)this.a.stop();
        (c)this.a.k();
    }

    public Class<com.bumptech.glide.load.n.g.c> b() {
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
