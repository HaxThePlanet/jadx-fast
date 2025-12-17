package com.bumptech.glide.r;

/* loaded from: classes.dex */
public final class b implements com.bumptech.glide.r.e, com.bumptech.glide.r.d {

    private final Object a;
    private final com.bumptech.glide.r.e b;
    private volatile com.bumptech.glide.r.d c;
    private volatile com.bumptech.glide.r.d d;
    private com.bumptech.glide.r.e.a e;
    private com.bumptech.glide.r.e.a f;
    public b(Object object, com.bumptech.glide.r.e e2) {
        super();
        final com.bumptech.glide.r.e.a cLEARED = e.a.CLEARED;
        this.e = cLEARED;
        this.f = cLEARED;
        this.a = object;
        this.b = e2;
    }

    private boolean m(com.bumptech.glide.r.d d) {
        Object equals;
        com.bumptech.glide.r.e.a fAILED;
        boolean obj3;
        if (!d.equals(this.c)) {
            if (this.e == e.a.FAILED && d.equals(this.d)) {
                if (d.equals(this.d)) {
                    obj3 = 1;
                } else {
                    obj3 = 0;
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    private boolean n() {
        int i;
        com.bumptech.glide.r.e eVar;
        eVar = this.b;
        if (eVar != null) {
            if (eVar.l(this)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private boolean o() {
        int i;
        com.bumptech.glide.r.e eVar;
        eVar = this.b;
        if (eVar != null) {
            if (eVar.f(this)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private boolean p() {
        int i;
        com.bumptech.glide.r.e eVar;
        eVar = this.b;
        if (eVar != null) {
            if (eVar.h(this)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // com.bumptech.glide.r.e
    public void a(com.bumptech.glide.r.d d) {
        Object obj3;
        final Object obj = this.a;
        synchronized (obj) {
            this.e = e.a.FAILED;
            com.bumptech.glide.r.e.a rUNNING = e.a.RUNNING;
            if (this.f != rUNNING) {
                this.f = rUNNING;
                this.d.i();
            }
            try {
                this.f = e.a.FAILED;
                obj3 = this.b;
                if (obj3 != null) {
                }
                obj3.a(this);
                throw d;
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean b() {
        int i;
        boolean z;
        final Object obj = this.a;
        synchronized (obj) {
            if (this.d.b()) {
                i = 1;
            } else {
                try {
                    i = 0;
                    i = 1;
                    return i;
                    throw th;
                }
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public com.bumptech.glide.r.e c() {
        Object obj;
        final Object obj2 = this.a;
        com.bumptech.glide.r.e eVar = this.b;
        synchronized (obj2) {
            obj = eVar.c();
            try {
                return obj;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public void clear() {
        Object cLEARED;
        final Object obj = this.a;
        cLEARED = e.a.CLEARED;
        this.e = cLEARED;
        this.c.clear();
        synchronized (obj) {
            this.f = cLEARED;
            this.d.clear();
        }
    }

    @Override // com.bumptech.glide.r.e
    public void d() {
        Object aVar;
        Object aVar2;
        final Object obj = this.a;
        final com.bumptech.glide.r.e.a rUNNING = e.a.RUNNING;
        synchronized (obj) {
            this.e = e.a.PAUSED;
            this.c.d();
            if (this.f == rUNNING) {
                try {
                    this.f = e.a.PAUSED;
                    this.d.d();
                    throw th;
                }
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean e(com.bumptech.glide.r.d d) {
        boolean z;
        int i;
        com.bumptech.glide.r.d dVar;
        Object obj4;
        i = 0;
        if (d instanceof b && this.c.e(d.c) && this.d.e(d.d)) {
            if (this.c.e(d.c)) {
                if (this.d.e(d.d)) {
                    i = 1;
                }
            }
        }
        return i;
    }

    @Override // com.bumptech.glide.r.e
    public boolean f(com.bumptech.glide.r.d d) {
        com.bumptech.glide.r.d obj3;
        final Object obj = this.a;
        synchronized (obj) {
            if (m(d)) {
                obj3 = 1;
            } else {
                try {
                    obj3 = 0;
                    return obj3;
                    throw d;
                }
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean g() {
        com.bumptech.glide.r.e.a aVar;
        int i;
        final Object obj = this.a;
        final com.bumptech.glide.r.e.a cLEARED = e.a.CLEARED;
        synchronized (obj) {
            if (this.f == cLEARED) {
                i = 1;
            } else {
                try {
                    i = 0;
                    return i;
                    throw th;
                }
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean h(com.bumptech.glide.r.d d) {
        com.bumptech.glide.r.d obj3;
        final Object obj = this.a;
        synchronized (obj) {
            if (m(d)) {
                obj3 = 1;
            } else {
                try {
                    obj3 = 0;
                    return obj3;
                    throw d;
                }
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public void i() {
        Object aVar;
        final Object obj = this.a;
        final com.bumptech.glide.r.e.a rUNNING = e.a.RUNNING;
        synchronized (obj) {
            this.e = rUNNING;
            this.c.i();
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean isRunning() {
        int i;
        com.bumptech.glide.r.e.a aVar;
        final Object obj = this.a;
        final com.bumptech.glide.r.e.a rUNNING = e.a.RUNNING;
        synchronized (obj) {
            if (this.f == rUNNING) {
                i = 1;
            } else {
                try {
                    i = 0;
                    i = 1;
                    return i;
                    throw th;
                }
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public void j(com.bumptech.glide.r.d d) {
        boolean equals;
        com.bumptech.glide.r.e.a obj3;
        final Object obj = this.a;
        synchronized (obj) {
            this.e = e.a.SUCCESS;
            obj3 = this.b;
            if (obj3 != null) {
                obj3.j(this);
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean k() {
        int i;
        com.bumptech.glide.r.e.a aVar;
        final Object obj = this.a;
        final com.bumptech.glide.r.e.a sUCCESS = e.a.SUCCESS;
        synchronized (obj) {
            if (this.f == sUCCESS) {
                i = 1;
            } else {
                try {
                    i = 0;
                    i = 1;
                    return i;
                    throw th;
                }
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean l(com.bumptech.glide.r.d d) {
        com.bumptech.glide.r.d obj3;
        final Object obj = this.a;
        synchronized (obj) {
            if (m(d)) {
                obj3 = 1;
            } else {
                try {
                    obj3 = 0;
                    return obj3;
                    throw d;
                }
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public void q(com.bumptech.glide.r.d d, com.bumptech.glide.r.d d2) {
        this.c = d;
        this.d = d2;
    }
}
