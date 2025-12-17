package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.f;
import com.bumptech.glide.t.k;

/* loaded from: classes.dex */
class p<Z>  implements com.bumptech.glide.load.engine.u<Z> {

    private final boolean a;
    private final boolean b;
    private final com.bumptech.glide.load.engine.u<Z> c;
    private final com.bumptech.glide.load.engine.p.a v;
    private final f w;
    private int x;
    private boolean y;

    interface a {
        public abstract void d(f f, com.bumptech.glide.load.engine.p<?> p2);
    }
    p(com.bumptech.glide.load.engine.u<Z> u, boolean z2, boolean z3, f f4, com.bumptech.glide.load.engine.p.a p$a5) {
        super();
        k.d(u);
        this.c = (u)u;
        this.a = z2;
        this.b = z3;
        this.w = f4;
        k.d(a5);
        this.v = (p.a)a5;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void a() {
        boolean z;
        synchronized (this) {
            try {
                if (this.y) {
                } else {
                }
                this.y = true;
                if (this.b) {
                }
                this.c.a();
                IllegalStateException illegalStateException = new IllegalStateException("Cannot recycle a resource that has already been recycled");
                throw illegalStateException;
                IllegalStateException illegalStateException2 = new IllegalStateException("Cannot recycle a resource while it is still acquired");
                throw illegalStateException2;
                throw th;
            }
        }
    }

    public Class<Z> b() {
        return this.c.b();
    }

    @Override // com.bumptech.glide.load.engine.u
    void c() {
        synchronized (this) {
            try {
                this.x = i++;
                IllegalStateException illegalStateException = new IllegalStateException("Cannot acquire a recycled resource");
                throw illegalStateException;
                throw th;
            }
        }
    }

    com.bumptech.glide.load.engine.u<Z> d() {
        return this.c;
    }

    @Override // com.bumptech.glide.load.engine.u
    boolean e() {
        return this.a;
    }

    @Override // com.bumptech.glide.load.engine.u
    void f() {
        int i2;
        int i;
        int i3 = this.x;
        synchronized (this) {
            try {
                i3 -= i;
                this.x = i2;
                if (i2 == 0) {
                } else {
                }
                i = 0;
                if (i != 0) {
                }
                this.v.d(this.w, this);
                IllegalStateException illegalStateException = new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                throw illegalStateException;
                throw th;
            }
        }
    }

    public Z get() {
        return this.c.get();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return this.c.getSize();
    }

    @Override // com.bumptech.glide.load.engine.u
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EngineResource{isMemoryCacheable=");
        stringBuilder.append(this.a);
        stringBuilder.append(", listener=");
        stringBuilder.append(this.v);
        stringBuilder.append(", key=");
        stringBuilder.append(this.w);
        stringBuilder.append(", acquired=");
        stringBuilder.append(this.x);
        stringBuilder.append(", isRecycled=");
        stringBuilder.append(this.y);
        stringBuilder.append(", resource=");
        stringBuilder.append(this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
        synchronized (this) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("EngineResource{isMemoryCacheable=");
            stringBuilder.append(this.a);
            stringBuilder.append(", listener=");
            stringBuilder.append(this.v);
            stringBuilder.append(", key=");
            stringBuilder.append(this.w);
            stringBuilder.append(", acquired=");
            stringBuilder.append(this.x);
            stringBuilder.append(", isRecycled=");
            stringBuilder.append(this.y);
            stringBuilder.append(", resource=");
            stringBuilder.append(this.c);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
}
