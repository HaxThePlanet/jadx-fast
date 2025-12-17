package com.bumptech.glide.load.n.f;

import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import java.io.File;

/* loaded from: classes.dex */
public class a implements j<File, File> {
    @Override // com.bumptech.glide.load.j
    public boolean a(Object object, h h2) {
        return d((File)object, h2);
    }

    @Override // com.bumptech.glide.load.j
    public u b(Object object, int i2, int i3, h h4) {
        return c((File)object, i2, i3, h4);
    }

    public u<File> c(File file, int i2, int i3, h h4) {
        b obj2 = new b(file);
        return obj2;
    }

    @Override // com.bumptech.glide.load.j
    public boolean d(File file, h h2) {
        return 1;
    }
}
