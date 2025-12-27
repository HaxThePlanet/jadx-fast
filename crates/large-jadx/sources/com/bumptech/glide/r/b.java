package com.bumptech.glide.r;

/* compiled from: ErrorRequestCoordinator.java */
/* loaded from: classes.dex */
public final class b implements e, d {

    private final Object a;
    private final e b;
    private volatile d c;
    private volatile d d;
    private e.a e;
    private e.a f;
    public b(Object object, e eVar) {
        super();
        final com.bumptech.glide.r.e.a cLEARED2 = e.a.CLEARED;
        this.e = cLEARED2;
        this.f = cLEARED2;
        this.a = object;
        this.b = eVar;
    }

    private boolean m(d dVar) {
        com.bumptech.glide.r.e.a aVar;
        boolean equals;
        com.bumptech.glide.r.e.a fAILED2;
        boolean z = false;
        if (!dVar.equals(this.c)) {
            if (this.e == e.a.FAILED) {
                if (dVar.equals(this.d)) {
                    int i2 = 1;
                } else {
                    int i = 0;
                }
            }
        }
        return z;
    }

    private boolean n() {
        boolean z2 = false;
        if (this.b == null || this.b.l(this)) {
            int i2 = 1;
        }
        return z2;
    }

    private boolean o() {
        boolean z2 = false;
        if (this.b == null || this.b.f(this)) {
            int i2 = 1;
        }
        return z2;
    }

    private boolean p() {
        boolean z2 = false;
        if (this.b == null || this.b.h(this)) {
            int i2 = 1;
        }
        return z2;
    }

    public void a(d dVar) {
        synchronized (obj2) {
            try {
                if (!dVar.equals(this.d)) {
                    this.e = e.a.FAILED;
                    com.bumptech.glide.r.e.a rUNNING2 = e.a.RUNNING;
                    if (this.f != e.a.RUNNING) {
                        this.f = e.a.RUNNING;
                        this.d.i();
                    }
                    return;
                }
                this.f = e.a.FAILED;
                if (this.b != null) {
                    this.b.a(this);
                }
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public boolean b() {
        boolean z2 = true;
        synchronized (obj2) {
            try {
                if (!this.c.b()) {
                    if (this.d.b()) {
                        int i = 1;
                    } else {
                        int i2 = 0;
                    }
                }
                return z2;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public e c() {
        Object obj;
        synchronized (obj3) {
            try {
                if (this.b != null) {
                    com.bumptech.glide.r.e eVar2 = this.b.c();
                } else {
                    obj = this;
                }
                return obj;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public void clear() {
        synchronized (obj2) {
            try {
                cLEARED2 = e.a.CLEARED;
                this.e = cLEARED2;
                this.c.clear();
                if (this.f != e.a.CLEARED) {
                    this.f = e.a.CLEARED;
                    this.d.clear();
                }
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public void d() {
        synchronized (obj2) {
            try {
                final com.bumptech.glide.r.e.a rUNNING2 = e.a.RUNNING;
                if (this.e == e.a.RUNNING) {
                    this.e = e.a.PAUSED;
                    this.c.d();
                }
                if (this.f == e.a.RUNNING) {
                    this.f = e.a.PAUSED;
                    this.d.d();
                }
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public boolean e(d dVar) {
        boolean z3 = false;
        z = dVar instanceof b;
        int i = 0;
        if (dVar instanceof b) {
            if (this.c.e(dVar.c)) {
                if (this.d.e(dVar.d)) {
                    int i2 = 1;
                }
            }
        }
        return z3;
    }

    public boolean f(d dVar) {
        boolean z3 = false;
        synchronized (obj2) {
            try {
                dVar = o() && this.m(dVar) ? 1 : 0;
                return (o() && this.m(dVar) ? 1 : 0);
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public boolean g() {
        boolean z = false;
        synchronized (obj2) {
            try {
                final com.bumptech.glide.r.e.a cLEARED2 = e.a.CLEARED;
                Throwable th = this.e == e.a.CLEARED && this.f == e.a.CLEARED ? 1 : 0;
                return (this.e == e.a.CLEARED && this.f == e.a.CLEARED ? 1 : 0);
            } catch (Throwable th) {
            }
            throw (this.e == e.a.CLEARED && this.f == e.a.CLEARED ? 1 : 0);
        }
    }

    public boolean h(d dVar) {
        boolean z3 = false;
        synchronized (obj2) {
            try {
                dVar = p() && this.m(dVar) ? 1 : 0;
                return (p() && this.m(dVar) ? 1 : 0);
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public void i() {
        synchronized (obj2) {
            try {
                final com.bumptech.glide.r.e.a rUNNING2 = e.a.RUNNING;
                if (this.e != e.a.RUNNING) {
                    this.e = e.a.RUNNING;
                    this.c.i();
                }
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public boolean isRunning() {
        boolean z = true;
        synchronized (obj2) {
            try {
                final com.bumptech.glide.r.e.a rUNNING2 = e.a.RUNNING;
                if (this.e == e.a.RUNNING || this.f == e.a.RUNNING) {
                    int i = 1;
                }
                return z;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public void j(d dVar) {
        synchronized (obj2) {
            try {
                if (dVar.equals(this.c)) {
                    this.e = e.a.SUCCESS;
                } else {
                    if (dVar.equals(this.d)) {
                        this.f = e.a.SUCCESS;
                    }
                }
                if (this.b != null) {
                    this.b.j(this);
                }
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public boolean k() {
        boolean z = true;
        synchronized (obj2) {
            try {
                final com.bumptech.glide.r.e.a sUCCESS2 = e.a.SUCCESS;
                if (this.e == e.a.SUCCESS || this.f == e.a.SUCCESS) {
                    int i = 1;
                }
                return z;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public boolean l(d dVar) {
        boolean z3 = false;
        synchronized (obj2) {
            try {
                dVar = n() && this.m(dVar) ? 1 : 0;
                return (n() && this.m(dVar) ? 1 : 0);
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public void q(d dVar, d dVar2) {
        this.c = dVar;
        this.d = dVar2;
    }
}
