package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.m.n.a;
import com.bumptech.glide.t.g;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
class y implements com.bumptech.glide.load.engine.f, com.bumptech.glide.load.engine.f.a {

    private final com.bumptech.glide.load.engine.g<?> a;
    private final com.bumptech.glide.load.engine.f.a b;
    private volatile int c;
    private volatile com.bumptech.glide.load.engine.c v;
    private volatile Object w;
    private volatile n.a<?> x;
    private volatile com.bumptech.glide.load.engine.d y;

    class a implements d.a<Object> {

        final n.a a;
        final com.bumptech.glide.load.engine.y b;
        a(com.bumptech.glide.load.engine.y y, n.a n$a2) {
            this.b = y;
            this.a = a2;
            super();
        }

        @Override // com.bumptech.glide.load.data.d$a
        public void c(Exception exception) {
            boolean z;
            n.a aVar;
            if (this.b.g(this.a)) {
                this.b.i(this.a, exception);
            }
        }

        @Override // com.bumptech.glide.load.data.d$a
        public void f(Object object) {
            boolean z;
            n.a aVar;
            if (this.b.g(this.a)) {
                this.b.h(this.a, object);
            }
        }
    }
    y(com.bumptech.glide.load.engine.g<?> g, com.bumptech.glide.load.engine.f.a f$a2) {
        super();
        this.a = g;
        this.b = a2;
    }

    private boolean d(Object object) {
        long string;
        boolean stringBuilder2;
        long dVar;
        Object obj;
        Object str;
        boolean stringBuilder;
        String str2;
        Object obj13;
        String str3 = "SourceGenerator";
        e eVar = this.a.o(object);
        Object obj2 = eVar.a();
        str = this.a.q(obj2);
        e eVar2 = new e(str, obj2, this.a.k());
        d dVar3 = new d(aVar8.a, this.a.p());
        a aVar9 = this.a.d();
        aVar9.a(dVar3, eVar2);
        String str5 = ", data: ";
        if (Log.isLoggable(str3, 2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Finished encoding source to cache, key: ");
            stringBuilder.append(dVar3);
            stringBuilder.append(str5);
            stringBuilder.append(object);
            stringBuilder.append(", encoder: ");
            stringBuilder.append(str);
            stringBuilder.append(", duration: ");
            stringBuilder.append(g.a(g.b()));
            Log.v(str3, stringBuilder.toString());
        }
        if (aVar9.b(dVar3) != null) {
            this.y = dVar3;
            obj13 = new c(Collections.singletonList(aVar2.a), this.a, this);
            this.v = obj13;
            obj13.c.b();
            return 1;
        }
        if (Log.isLoggable(str3, 3)) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Attempt to write: ");
            stringBuilder2.append(this.y);
            stringBuilder2.append(str5);
            stringBuilder2.append(object);
            stringBuilder2.append(" to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            Log.d(str3, stringBuilder2.toString());
        }
        this.b.e(aVar3.a, eVar.a(), aVar4.c, aVar5.c.d(), aVar6.a);
        return 0;
    }

    private boolean f() {
        int i;
        i = this.c < this.a.g().size() ? 1 : 0;
        return i;
    }

    private void j(n.a<?> n$a) {
        y.a aVar2 = new y.a(this, a);
        aVar.c.e(this.a.l(), aVar2);
    }

    public void a(f f, Exception exception2, d<?> d3, a a4) {
        this.b.a(f, exception2, d3, aVar.c.d());
    }

    @Override // com.bumptech.glide.load.engine.f
    public boolean b() {
        Object obj;
        com.bumptech.glide.load.engine.c cVar;
        int i;
        int i2;
        int str2;
        String str;
        i2 = 0;
        final int i3 = 1;
        this.w = i2;
        if (this.w != null && !d(this.w)) {
            this.w = i2;
            if (!d(this.w)) {
                return i3;
            }
        }
        if (this.v != null && this.v.b()) {
            if (this.v.b()) {
                return i3;
            }
        }
        this.v = i2;
        this.x = i2;
        i = 0;
        while (i == 0) {
            if (f()) {
            }
            str2 = this.c;
            this.c = str2 + 1;
            this.x = (n.a)this.a.g().get(str2);
            if (this.x != 0) {
            }
            if (!this.a.e().c(aVar2.c.d())) {
            } else {
            }
            j(this.x);
            i = i3;
            if (this.a.u(aVar3.c.a()) != 0) {
            }
        }
        return i;
    }

    @Override // com.bumptech.glide.load.engine.f
    public void c() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    @Override // com.bumptech.glide.load.engine.f
    public void cancel() {
        Object aVar;
        aVar = this.x;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    public void e(f f, Object object2, d<?> d3, a a4, f f5) {
        this.b.e(f, object2, d3, obj10.c.d(), f);
    }

    boolean g(n.a<?> n$a) {
        int obj2;
        final n.a aVar = this.x;
        if (aVar != null && aVar == a) {
            obj2 = aVar == a ? 1 : 0;
        } else {
        }
        return obj2;
    }

    void h(n.a<?> n$a, Object object2) {
        com.bumptech.glide.load.engine.j jVar;
        a aVar2;
        Object obj;
        d dVar2;
        a aVar;
        com.bumptech.glide.load.engine.d dVar;
        Object obj7;
        if (object2 != null && this.a.e().c(a.c.d())) {
            if (jVar.c(a.c.d())) {
                this.w = object2;
                this.b.c();
            } else {
                dVar2 = a.c;
                this.b.e(a.a, object2, dVar2, dVar2.d(), this.y);
            }
        } else {
        }
    }

    void i(n.a<?> n$a, Exception exception2) {
        final d obj4 = a.c;
        this.b.a(this.y, exception2, obj4, obj4.d());
    }
}
