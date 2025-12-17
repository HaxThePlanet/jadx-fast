package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.n.e.f;

/* loaded from: classes.dex */
public class x implements j<Uri, Bitmap> {

    private final f a;
    private final e b;
    public x(f f, e e2) {
        super();
        this.a = f;
        this.b = e2;
    }

    @Override // com.bumptech.glide.load.j
    public boolean a(Object object, h h2) {
        return d((Uri)object, h2);
    }

    @Override // com.bumptech.glide.load.j
    public u b(Object object, int i2, int i3, h h4) {
        return c((Uri)object, i2, i3, h4);
    }

    public u<Bitmap> c(Uri uri, int i2, int i3, h h4) {
        u obj2 = this.a.c(uri, i2, i3, h4);
        if (obj2 == null) {
            return 0;
        }
        return n.a(this.b, (Drawable)obj2.get(), i2, i3);
    }

    @Override // com.bumptech.glide.load.j
    public boolean d(Uri uri, h h2) {
        return "android.resource".equals(uri.getScheme());
    }
}
