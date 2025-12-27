package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.m.n.a;
import com.bumptech.glide.t.m.b;
import java.io.File;
import java.util.List;

/* compiled from: DataCacheGenerator.java */
/* loaded from: classes.dex */
class c implements f, d.a<Object> {

    private File A;
    private final List<f> a;
    private final g<?> b;
    private final f.a c;
    private int v;
    private f w;
    private List<n<File, ?>> x;
    private int y;
    private volatile n.a<?> z;
    c(g<?> gVar, f.a aVar) {
        this(gVar.c(), gVar, aVar);
    }

    private boolean a() {
        boolean z = true;
        int r0 = this.y < this.x.size() ? 1 : 0;
        return (this.y < this.x.size() ? 1 : 0);
    }

    public boolean b() {
        n.a aVar = null;
        boolean z = false;
        com.bumptech.glide.load.engine.a0.a aVar2;
        item = "DataCacheGenerator.startNext";
        b.a(item);
        z = false;
        int i5 = 1;
        while (this.x != null) {
            try {
                this.v += i5;
            } finally {
                b.e();
                throw th;
            }
            if (this.x >= this.a.size()) {
                b.e();
                return false;
            }
        }
        aVar = null;
        this.z = aVar;
        while (!z) {
            if (!a()) {
                b.e();
                return z;
            }
        }
        b.e();
        return z;
    }

    public void c(Exception exc) {
        this.c.a(this.w, exc, this.z.c, a.DATA_DISK_CACHE);
    }

    public void cancel() {
        if (this.z != null) {
            aVar.c.cancel();
        }
    }

    public void f(Object object) {
        this.c.e(this.w, object, this.z.c, a.DATA_DISK_CACHE, this.w);
    }

    c(List<f> list, g<?> gVar, f.a aVar) {
        super();
        this.v = -1;
        this.a = list;
        this.b = gVar;
        this.c = aVar;
    }
}
