package com.bumptech.glide.r;

/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: classes.dex */
public class j implements e, d {

    private final e a;
    private final Object b;
    private volatile d c;
    private volatile d d;
    private e.a e;
    private e.a f;
    private boolean g;
    public j(Object object, e eVar) {
        super();
        final com.bumptech.glide.r.e.a cLEARED2 = e.a.CLEARED;
        this.e = cLEARED2;
        this.f = cLEARED2;
        this.b = object;
        this.a = eVar;
    }

    private boolean m() {
        boolean z2 = false;
        if (this.a == null || this.a.l(this)) {
            int i2 = 1;
        }
        return z2;
    }

    private boolean n() {
        boolean z2 = false;
        if (this.a == null || this.a.f(this)) {
            int i2 = 1;
        }
        return z2;
    }

    private boolean o() {
        boolean z2 = false;
        if (this.a == null || this.a.h(this)) {
            int i2 = 1;
        }
        return z2;
    }

    public void a(d dVar) {
        synchronized (obj2) {
            try {
                if (!dVar.equals(this.c)) {
                    this.f = e.a.FAILED;
                    return;
                }
                this.e = e.a.FAILED;
                if (this.a != null) {
                    this.a.a(this);
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
                if (!this.d.b()) {
                    if (this.c.b()) {
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
                if (this.a != null) {
                    com.bumptech.glide.r.e eVar2 = this.a.c();
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
                this.g = false;
                com.bumptech.glide.r.e.a cLEARED2 = e.a.CLEARED;
                this.e = cLEARED2;
                this.f = cLEARED2;
                this.d.clear();
                this.c.clear();
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public void d() {
        synchronized (obj2) {
            try {
                if (!this.f.isComplete()) {
                    this.f = e.a.PAUSED;
                    this.d.d();
                }
                if (!this.e.isComplete()) {
                    this.e = e.a.PAUSED;
                    this.c.d();
                }
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public boolean e(d dVar) {
        com.bumptech.glide.r.d dVar3;
        boolean z2 = false;
        com.bumptech.glide.r.d dVar4;
        com.bumptech.glide.r.d dVar5;
        z = dVar instanceof j;
        int i = 0;
        if (dVar instanceof j) {
            if (this.c == null) {
                if (dVar.c == null) {
                    if (this.d == null) {
                        if (dVar.d == null) {
                            int i2 = 1;
                        }
                    }
                }
            }
        }
        return z2;
    }

    public boolean f(d dVar) {
        boolean z;
        boolean z2 = false;
        synchronized (obj2) {
            try {
                if (n()) {
                    dVar = dVar.equals(this.c) && !this.b() ? 1 : 0;
                }
                return (dVar.equals(this.c) && !this.b() ? 1 : 0);
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public boolean g() {
        boolean z = false;
        synchronized (obj2) {
            try {
                Throwable th = this.e == e.a.CLEARED ? 1 : 0;
                return (this.e == e.a.CLEARED ? 1 : 0);
            } catch (Throwable th) {
            }
            throw (this.e == e.a.CLEARED ? 1 : 0);
        }
    }

    public boolean h(d dVar) {
        boolean z;
        com.bumptech.glide.r.d dVar2;
        boolean z2 = false;
        synchronized (obj2) {
            try {
                if (o()) {
                    if (!dVar.equals(this.c)) {
                        dVar = this.e != e.a.SUCCESS ? 1 : 0;
                    }
                }
                return (this.e != e.a.SUCCESS ? 1 : 0);
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public void i() {
        com.bumptech.glide.r.e.a sUCCESS2;
        synchronized (obj2) {
            try {
                this.g = true;
            } catch (Throwable unused) {
            }
            try {
                if (this.e != e.a.SUCCESS && this.f != e.a.RUNNING) {
                    this.f = e.a.RUNNING;
                    this.d.i();
                }
                sUCCESS2 = e.a.RUNNING;
                if (this.e != e.a.RUNNING) {
                    this.e = e.a.RUNNING;
                    this.c.i();
                }
            } catch (Throwable unused) {
            }
            try {
                this.g = false;
                return;
            } finally {
                this.g = z2;
                throw th;
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) z2;
        }
    }

    public boolean isRunning() {
        boolean z = false;
        synchronized (obj2) {
            try {
                Throwable th = this.e == e.a.RUNNING ? 1 : 0;
                return (this.e == e.a.RUNNING ? 1 : 0);
            } catch (Throwable th) {
            }
            throw (this.e == e.a.RUNNING ? 1 : 0);
        }
    }

    public void j(d dVar) {
        synchronized (obj2) {
            try {
                if (dVar.equals(this.d)) {
                    this.f = e.a.SUCCESS;
                    return;
                }
                this.e = e.a.SUCCESS;
                if (this.a != null) {
                    this.a.j(this);
                }
                if (!this.f.isComplete()) {
                    this.d.clear();
                }
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public boolean k() {
        boolean z = false;
        synchronized (obj2) {
            try {
                Throwable th = this.e == e.a.SUCCESS ? 1 : 0;
                return (this.e == e.a.SUCCESS ? 1 : 0);
            } catch (Throwable th) {
            }
            throw (this.e == e.a.SUCCESS ? 1 : 0);
        }
    }

    public boolean l(d dVar) {
        boolean z;
        boolean z2 = false;
        synchronized (obj2) {
            try {
                if (m()) {
                    if (dVar.equals(this.c)) {
                        dVar = this.e != e.a.PAUSED ? 1 : 0;
                    }
                }
                return (this.e != e.a.PAUSED ? 1 : 0);
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public void p(d dVar, d dVar2) {
        this.c = dVar;
        this.d = dVar2;
    }
}
