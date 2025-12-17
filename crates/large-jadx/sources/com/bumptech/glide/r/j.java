package com.bumptech.glide.r;

/* loaded from: classes.dex */
public class j implements com.bumptech.glide.r.e, com.bumptech.glide.r.d {

    private final com.bumptech.glide.r.e a;
    private final Object b;
    private volatile com.bumptech.glide.r.d c;
    private volatile com.bumptech.glide.r.d d;
    private com.bumptech.glide.r.e.a e;
    private com.bumptech.glide.r.e.a f;
    private boolean g;
    public j(Object object, com.bumptech.glide.r.e e2) {
        super();
        final com.bumptech.glide.r.e.a cLEARED = e.a.CLEARED;
        this.e = cLEARED;
        this.f = cLEARED;
        this.b = object;
        this.a = e2;
    }

    private boolean m() {
        int i;
        com.bumptech.glide.r.e eVar;
        eVar = this.a;
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

    private boolean n() {
        int i;
        com.bumptech.glide.r.e eVar;
        eVar = this.a;
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

    private boolean o() {
        int i;
        com.bumptech.glide.r.e eVar;
        eVar = this.a;
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
        final Object obj = this.b;
        synchronized (obj) {
            this.f = e.a.FAILED;
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean b() {
        int i;
        boolean z;
        final Object obj = this.b;
        synchronized (obj) {
            if (this.c.b()) {
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
        final Object obj2 = this.b;
        com.bumptech.glide.r.e eVar = this.a;
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
        final Object obj = this.b;
        this.g = false;
        com.bumptech.glide.r.e.a cLEARED = e.a.CLEARED;
        this.e = cLEARED;
        this.f = cLEARED;
        this.d.clear();
        this.c.clear();
        return;
        synchronized (obj) {
            obj = this.b;
            this.g = false;
            cLEARED = e.a.CLEARED;
            this.e = cLEARED;
            this.f = cLEARED;
            this.d.clear();
            this.c.clear();
        }
    }

    @Override // com.bumptech.glide.r.e
    public void d() {
        boolean complete2;
        boolean complete;
        final Object obj = this.b;
        synchronized (obj) {
            this.f = e.a.PAUSED;
            this.d.d();
            if (!this.e.isComplete()) {
                try {
                    this.e = e.a.PAUSED;
                    this.c.d();
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
        if (d instanceof j) {
            if (this.c == null) {
                if (d.c == null) {
                    if (this.d == null) {
                        if (d.d == null) {
                            i = 1;
                        }
                    } else {
                        if (this.d.e(d.d)) {
                        }
                    }
                }
            } else {
                if (this.c.e(d.c)) {
                }
            }
        }
        return i;
    }

    @Override // com.bumptech.glide.r.e
    public boolean f(com.bumptech.glide.r.d d) {
        com.bumptech.glide.r.d z;
        int obj3;
        final Object obj = this.b;
        synchronized (obj) {
            if (d.equals(this.c)) {
                if (!b()) {
                    try {
                        obj3 = 1;
                        obj3 = 0;
                        return obj3;
                        throw d;
                    }
                } else {
                }
            } else {
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean g() {
        int i;
        final Object obj = this.b;
        synchronized (obj) {
            i = 1;
            try {
                return i;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean h(com.bumptech.glide.r.d d) {
        Object sUCCESS;
        boolean obj3;
        final Object obj = this.b;
        synchronized (obj) {
            if (!d.equals(this.c)) {
                if (this.e != e.a.SUCCESS) {
                    try {
                        obj3 = 1;
                        obj3 = 0;
                        return obj3;
                        throw d;
                    }
                } else {
                }
            } else {
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public void i() {
        Object aVar;
        boolean z;
        com.bumptech.glide.r.e.a sUCCESS;
        final Object obj = this.b;
        this.g = true;
        synchronized (obj) {
            sUCCESS = e.a.RUNNING;
            if (this.f != sUCCESS) {
                this.f = sUCCESS;
                this.d.i();
            }
            sUCCESS = e.a.RUNNING;
            if (this.g && this.e != sUCCESS) {
                try {
                    sUCCESS = e.a.RUNNING;
                    if (this.e != sUCCESS) {
                    }
                    this.e = sUCCESS;
                    this.c.i();
                } catch (Throwable th) {
                }
            }
            this.g = false;
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean isRunning() {
        int i;
        final Object obj = this.b;
        synchronized (obj) {
            i = 1;
            try {
                return i;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public void j(com.bumptech.glide.r.d d) {
        boolean obj3;
        final Object obj = this.b;
        synchronized (obj) {
            this.f = e.a.SUCCESS;
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean k() {
        int i;
        final Object obj = this.b;
        synchronized (obj) {
            i = 1;
            try {
                return i;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public boolean l(com.bumptech.glide.r.d d) {
        com.bumptech.glide.r.e.a pAUSED;
        int obj3;
        final Object obj = this.b;
        synchronized (obj) {
            if (d.equals(this.c)) {
                if (this.e != e.a.PAUSED) {
                    try {
                        obj3 = 1;
                        obj3 = 0;
                        return obj3;
                        throw d;
                    }
                } else {
                }
            } else {
            }
        }
    }

    @Override // com.bumptech.glide.r.e
    public void p(com.bumptech.glide.r.d d, com.bumptech.glide.r.d d2) {
        this.c = d;
        this.d = d2;
    }
}
