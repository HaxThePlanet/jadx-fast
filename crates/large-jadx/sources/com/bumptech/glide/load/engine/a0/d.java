package com.bumptech.glide.load.engine.a0;

import java.io.File;

/* compiled from: DiskLruCacheFactory.java */
/* loaded from: classes.dex */
public class d implements a.a {

    private final long a;
    private final d.a b;

    public interface a {
        File a();
    }
    public d(d.a aVar, long j) {
        super();
        this.a = j;
        this.b = aVar;
    }

    public a build() {
        long l2;
        File file = this.b.a();
        int i = 0;
        if (file == null) {
            return null;
        }
        return e.c(file, this.a);
    }
}
