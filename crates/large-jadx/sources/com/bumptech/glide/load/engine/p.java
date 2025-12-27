package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import com.bumptech.glide.t.k;

/* compiled from: EngineResource.java */
/* loaded from: classes.dex */
class p<Z> implements u<Z> {

    private final boolean a;
    private final boolean b;
    private final u<Z> c;
    private final p.a v;
    private final f w;
    private int x;
    private boolean y;

    interface a {
        void d(f fVar, p<?> pVar);
    }
    p(u<Z> uVar, boolean z, boolean z2, f fVar, p.a aVar) {
        super();
        k.d(uVar);
        this.c = uVar;
        this.a = z;
        this.b = z2;
        this.w = fVar;
        k.d(aVar);
        this.v = aVar;
    }

    public synchronized void a() {
        this.y = true;
        if (this.b) {
            this.c.a();
        }
        throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
    }

    public Class<Z> b() {
        return this.c.b();
    }

    synchronized void c() {
        this.x++;
        throw new IllegalStateException("Cannot acquire a recycled resource");
    }

    u<Z> d() {
        return this.c;
    }

    boolean e() {
        return this.a;
    }

    void f() {
        int i2 = 1;
        synchronized (this) {
            try {
                i2 = 1;
                this.x -= i2;
                if (this.x != 0) {
                    i2 = 0;
                }
            } catch (Throwable unused) {
            }
            try {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            } catch (Throwable th) {
            }
            throw th;
        }
        if (i2 != 0) {
            this.v.d(this.w, this);
        }
    }

    public Z get() {
        return this.c.get();
    }

    public int getSize() {
        return this.c.getSize();
    }

    @Override // java.lang.Object
    public synchronized String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "EngineResource{isMemoryCacheable=";
        String str3 = ", listener=";
        String str4 = ", key=";
        String str5 = ", acquired=";
        String str6 = ", isRecycled=";
        String str7 = ", resource=";
        str = str2 + this.a + str3 + this.v + str4 + this.w + str5 + this.x + str6 + this.y + str7 + this.c + 125;
        return str;
    }
}
