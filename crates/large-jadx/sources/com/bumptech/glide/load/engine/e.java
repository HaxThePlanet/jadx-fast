package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.d;
import com.bumptech.glide.load.engine.a0.a.b;
import com.bumptech.glide.load.h;
import java.io.File;

/* loaded from: classes.dex */
class e<DataType>  implements a.b {

    private final d<DataType> a;
    private final DataType b;
    private final h c;
    e(d<DataType> d, DataType datatype2, h h3) {
        super();
        this.a = d;
        this.b = datatype2;
        this.c = h3;
    }

    @Override // com.bumptech.glide.load.engine.a0.a$b
    public boolean a(File file) {
        return this.a.a(this.b, file, this.c);
    }
}
