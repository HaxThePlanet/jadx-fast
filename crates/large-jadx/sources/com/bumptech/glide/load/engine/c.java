package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.m.n.a;
import com.bumptech.glide.t.m.b;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
class c implements com.bumptech.glide.load.engine.f, d.a<Object> {

    private File A;
    private final List<f> a;
    private final com.bumptech.glide.load.engine.g<?> b;
    private final com.bumptech.glide.load.engine.f.a c;
    private int v;
    private f w;
    private List<n<File, ?>> x;
    private int y;
    private volatile n.a<?> z;
    c(com.bumptech.glide.load.engine.g<?> g, com.bumptech.glide.load.engine.f.a f$a2) {
        super(g.c(), g, a2);
    }

    c(List<f> list, com.bumptech.glide.load.engine.g<?> g2, com.bumptech.glide.load.engine.f.a f$a3) {
        super();
        this.v = -1;
        this.a = list;
        this.b = g2;
        this.c = a3;
    }

    private boolean a() {
        int i;
        i = this.y < this.x.size() ? 1 : 0;
        return i;
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean b() {
        String str;
        List list;
        int i3;
        int i4;
        File file;
        a aVar;
        int i;
        int i2;
        com.bumptech.glide.load.h hVar;
        b.a("DataCacheGenerator.startNext");
        i4 = 0;
        int i7 = 1;
        while (this.x != null) {
            i5 += i7;
            this.v = i6;
            str = this.a.get(this.v);
            d dVar = new d((f)str, this.b.p());
            file = this.b.d().b(dVar);
            this.A = file;
            if (file != null) {
            }
            i4 = 0;
            i7 = 1;
            this.w = str;
            this.x = this.b.j(file);
            this.y = i4;
        }
        this.z = 0;
        try {
            while (i4 == 0) {
                if (a()) {
                }
                int i9 = this.y;
                this.y = i9 + 1;
                this.z = (n)this.x.get(i9).b(this.A, this.b.t(), this.b.f(), this.b.k());
                if (this.z != 0 && this.b.u(aVar4.c.a()) != 0) {
                }
                if (this.b.u(aVar4.c.a()) != 0) {
                }
                aVar3.c.e(this.b.l(), this);
                i4 = i7;
            }
            if (a()) {
            }
            i9 = this.y;
            this.y = i9 + 1;
            this.z = (n)this.x.get(i9).b(this.A, this.b.t(), this.b.f(), this.b.k());
            if (this.z != 0 && this.b.u(aVar4.c.a()) != 0) {
            }
            if (this.b.u(aVar4.c.a()) != 0) {
            }
            aVar3.c.e(this.b.l(), this);
            i4 = i7;
            b.e();
            return i4;
            i5 += i7;
            this.v = i6;
            b.e();
            return i4;
            str = this.a.get(this.v);
            dVar = new d((f)str, this.b.p());
            file = this.b.d().b(dVar);
            this.A = file;
            if (file != null) {
            }
            this.w = str;
            this.x = this.b.j(file);
            this.y = i4;
            b.e();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.f
    public void c(Exception exception) {
        this.c.a(this.w, exception, aVar2.c, a.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        Object aVar;
        aVar = this.z;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.f
    public void f(Object object) {
        this.c.e(this.w, object, aVar2.c, a.DATA_DISK_CACHE, this.w);
    }
}
