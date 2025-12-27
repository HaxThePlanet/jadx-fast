package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.m.n.a;
import com.bumptech.glide.t.m.b;
import java.io.File;
import java.util.List;

/* compiled from: ResourceCacheGenerator.java */
/* loaded from: classes.dex */
class v implements f, d.a<Object> {

    private File A;
    private w B;
    private final f.a a;
    private final g<?> b;
    private int c;
    private int v = -1;
    private f w;
    private List<n<File, ?>> x;
    private int y;
    private volatile n.a<?> z;
    v(g<?> gVar, f.a aVar) {
        super();
        this.b = gVar;
        this.a = aVar;
    }

    private boolean a() {
        boolean z = true;
        int r0 = this.y < this.x.size() ? 1 : 0;
        return (this.y < this.x.size() ? 1 : 0);
    }

    public boolean b() {
        n.a aVar = null;
        boolean z = false;
        com.bumptech.glide.load.engine.w wVar2;
        f fVar;
        b.a("ResourceCacheGenerator.startNext");
        try {
            List list3 = this.b.c();
        } finally {
            b.e();
            throw th;
        }
        int i5 = 0;
        if (list3.isEmpty()) {
            b.e();
            return false;
        }
        try {
            List list = this.b.m();
        } finally {
            b.e();
            throw th;
        }
        int size = 1;
        while (this.x != null) {
            try {
                this.v += size;
                this.c += size;
            } finally {
                b.e();
                throw th;
            }
            Object item2 = list3.get(this.c);
            cls = list.get(this.v);
            w wVar = new w(this.b.b(), item2, this.b.p(), this.b.t(), this.b.f(), this.b.s(cls), cls, this.b.k());
            this.B = wVar;
            File file = this.b.d().b(this.B);
            this.A = file;
            if (this.v >= list3.size()) {
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
        this.a.a(this.B, exc, this.z.c, a.RESOURCE_DISK_CACHE);
    }

    public void cancel() {
        if (this.z != null) {
            aVar.c.cancel();
        }
    }

    public void f(Object object) {
        this.a.e(this.w, object, this.z.c, a.RESOURCE_DISK_CACHE, this.B);
    }
}
