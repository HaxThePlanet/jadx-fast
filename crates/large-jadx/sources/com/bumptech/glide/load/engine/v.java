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
class v implements com.bumptech.glide.load.engine.f, d.a<Object> {

    private File A;
    private com.bumptech.glide.load.engine.w B;
    private final com.bumptech.glide.load.engine.f.a a;
    private final com.bumptech.glide.load.engine.g<?> b;
    private int c;
    private int v = -1;
    private f w;
    private List<n<File, ?>> x;
    private int y;
    private volatile n.a<?> z;
    v(com.bumptech.glide.load.engine.g<?> g, com.bumptech.glide.load.engine.f.a f$a2) {
        super();
        final int i = -1;
        this.b = g;
        this.a = a2;
    }

    private boolean a() {
        int i;
        i = this.y < this.x.size() ? 1 : 0;
        return i;
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean b() {
        int i3;
        List list;
        int i2;
        boolean empty;
        boolean list2;
        int i;
        File file;
        int size;
        com.bumptech.glide.load.engine.w wVar;
        boolean z;
        f fVar;
        int i4;
        int i5;
        com.bumptech.glide.load.l lVar;
        Object obj;
        com.bumptech.glide.load.h hVar;
        com.bumptech.glide.load.engine.w wVar2;
        b.a("ResourceCacheGenerator.startNext");
        List list3 = this.b.c();
        i2 = 0;
        if (list3.isEmpty()) {
            b.e();
            return i2;
        }
        list = this.b.m();
        if (list.isEmpty()) {
            if (File.class.equals(this.b.r()) == null) {
            } else {
                b.e();
                return i2;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to find any load path from ");
                stringBuilder.append(this.b.i());
                stringBuilder.append(" to ");
                stringBuilder.append(this.b.r());
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                throw illegalStateException;
                size = 1;
                this.z = 0;
                while (i2 == 0) {
                    if (a()) {
                    }
                    int i6 = this.y;
                    this.y = i6 + 1;
                    this.z = (n)this.x.get(i6).b(this.A, this.b.t(), this.b.f(), this.b.k());
                    if (this.z != 0 && this.b.u(aVar3.c.a()) != 0) {
                    }
                    if (this.b.u(aVar3.c.a()) != 0) {
                    }
                    aVar2.c.e(this.b.l(), this);
                    i2 = size;
                }
                if (a()) {
                }
                i6 = this.y;
                this.y = i6 + 1;
                this.z = (n)this.x.get(i6).b(this.A, this.b.t(), this.b.f(), this.b.k());
                if (this.z != 0 && this.b.u(aVar3.c.a()) != 0) {
                }
                if (this.b.u(aVar3.c.a()) != 0) {
                }
                aVar2.c.e(this.b.l(), this);
                i2 = size;
            }
            i8 += size;
            this.v = i;
            if (i >= list.size()) {
            } else {
            }
            b.e();
            return i2;
        }
    }

    @Override // com.bumptech.glide.load.engine.f
    public void c(Exception exception) {
        this.a.a(this.B, exception, aVar2.c, a.RESOURCE_DISK_CACHE);
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
        this.a.e(this.w, object, aVar2.c, a.RESOURCE_DISK_CACHE, this.B);
    }
}
