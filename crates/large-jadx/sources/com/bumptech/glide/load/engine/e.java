package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.d;
import com.bumptech.glide.load.engine.a0.a.b;
import com.bumptech.glide.load.h;
import java.io.File;

/* compiled from: DataCacheWriter.java */
/* loaded from: classes.dex */
class e<DataType> implements a.b {

    private final d<DataType> a;
    private final DataType b;
    private final h c;
    e(d<DataType> dVar, DataType datatype, h hVar) {
        super();
        this.a = dVar;
        this.b = datatype;
        this.c = hVar;
    }

    public boolean a(File file) {
        return this.a.a(this.b, file, this.c);
    }
}
