package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.m.n.a;
import com.bumptech.glide.t.g;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SourceGenerator.java */
/* loaded from: classes.dex */
class y implements f, f.a {

    private final g<?> a;
    private final f.a b;
    private volatile int c;
    private volatile c v;
    private volatile Object w;
    private volatile n.a<?> x;
    private volatile d y;

    class a implements d.a<Object> {

        final /* synthetic */ n.a a;
        final /* synthetic */ y b;
        a(n.a aVar) {
            this.b = yVar;
            this.a = aVar;
            super();
        }

        public void c(Exception exc) {
            if (this.b.g(this.a)) {
                this.b.i(this.a, exc);
            }
        }

        public void f(Object object) {
            if (this.b.g(this.a)) {
                this.b.h(this.a, object);
            }
        }
    }
    y(g<?> gVar, f.a aVar) {
        super();
        this.a = gVar;
        this.b = aVar;
    }

    private boolean d(Object object) {
        Object obj;
        String str3 = "SourceGenerator";
        try {
            e eVar = this.a.o(object);
            Object obj3 = eVar.a();
            com.bumptech.glide.load.d dVar2 = this.a.q(obj3);
            com.bumptech.glide.load.engine.d dVar4 = new d(this.x.a, this.a.p());
            com.bumptech.glide.load.engine.a0.a aVar8 = this.a.d();
            aVar8.a(dVar4, new e(dVar2, obj3, this.a.k()));
        } catch (Throwable th) {
        }
        String str7 = ", data: ";
        if (Log.isLoggable(str3, 2)) {
            try {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str8 = "Finished encoding source to cache, key: ";
                str = ", encoder: ";
                String str6 = ", duration: ";
                double d = g.a(g.b());
                str4 = str8 + dVar4 + str7 + th + str + dVar2 + str6 + d;
                Log.v(str3, str4);
                this.y = dVar4;
                this.v = new c(Collections.singletonList(this.x.a), this.a, this);
            } catch (Throwable th) {
            }
            try {
                if (Log.isLoggable(str3, 3)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str5 = "Attempt to write: ";
                    String str9 = " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...";
                    str2 = str5 + this.y + str7 + th + str9;
                    Log.d(str3, str2);
                }
            } catch (Throwable th) {
            }
            try {
                object2.e(this.x.a, eVar.a(), this.x.c, this.x.c.d(), this.x.a);
            } catch (Throwable th) {
            }
            return false;
        }
    }

    private boolean f() {
        boolean z = true;
        int r0 = this.c < this.a.g().size() ? 1 : 0;
        return (this.c < this.a.g().size() ? 1 : 0);
    }

    private void j(n.a<?> aVar) {
        this.x.c.e(this.a.l(), new y.a(this, aVar));
    }

    public void a(f fVar, Exception exc, d<?> dVar, com.bumptech.glide.load.a aVar) {
        this.b.a(fVar, exc, dVar, this.x.c.d());
    }

    public boolean b() {
        boolean z = false;
        Object obj2 = null;
        int i;
        int i2;
        obj2 = null;
        z = true;
        if (this.w != null) {
            this.w = obj2;
            try {
            } catch (java.io.IOException ioException) {
                int str = 3;
                String str2 = "SourceGenerator";
                str = Log.isLoggable(str2, str);
            }
            if (!d(this.w)) {
                return true;
            }
        }
        if (this.v != null) {
            if (this.v.b()) {
                return true;
            }
        }
        this.v = obj2;
        this.x = obj2;
        int i3 = 0;
        while (!this.v) {
            if (!f()) {
                return z;
            }
        }
        return z;
    }

    public void c() {
        throw new UnsupportedOperationException();
    }

    public void cancel() {
        if (this.x != null) {
            aVar.c.cancel();
        }
    }

    public void e(f fVar, Object object, d<?> dVar, com.bumptech.glide.load.a aVar, f fVar2) {
        this.b.e(fVar, object, dVar, this.x.c.d(), fVar);
    }

    boolean g(n.a<?> aVar) {
        boolean z = false;
        aVar = this.x != null && this.x == aVar ? 1 : 0;
        return (this.x != null && this.x == aVar ? 1 : 0);
    }

    void h(n.a<?> aVar, Object object) {
        if (object != null) {
            if (this.a.e().c(aVar.c.d())) {
                this.w = object;
                this.b.c();
            } else {
                this.b.e(aVar.a, object, aVar.c, aVar.c.d(), this.y);
            }
        }
    }

    void i(n.a<?> aVar, Exception exc) {
        this.b.a(this.y, exc, aVar.c, aVar.c.d());
    }
}
