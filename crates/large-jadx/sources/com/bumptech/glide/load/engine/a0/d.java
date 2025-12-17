package com.bumptech.glide.load.engine.a0;

import java.io.File;

/* loaded from: classes.dex */
public class d implements com.bumptech.glide.load.engine.a0.a.a {

    private final long a;
    private final com.bumptech.glide.load.engine.a0.d.a b;

    public interface a {
        public abstract File a();
    }
    public d(com.bumptech.glide.load.engine.a0.d.a d$a, long l2) {
        super();
        this.a = l2;
        this.b = a;
    }

    @Override // com.bumptech.glide.load.engine.a0.a$a
    public com.bumptech.glide.load.engine.a0.a build() {
        boolean directory;
        File file = this.b.a();
        int i = 0;
        if (file == null) {
            return i;
        }
        if (file.isDirectory() == null && file.mkdirs() != null) {
            if (file.mkdirs() != null) {
            }
            return i;
        }
        return e.c(file, this.a);
    }
}
