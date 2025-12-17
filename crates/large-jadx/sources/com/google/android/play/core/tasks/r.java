package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.i1;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class r<ResultT>  extends com.google.android.play.core.tasks.d<ResultT> {

    private final Object a;
    private final com.google.android.play.core.tasks.n<ResultT> b;
    private boolean c;
    private ResultT d;
    private Exception e;
    r() {
        super();
        Object object = new Object();
        this.a = object;
        n nVar = new n();
        this.b = nVar;
    }

    private final void n() {
        i1.b(this.c, "Task is not yet complete");
    }

    private final void o() {
        i1.b(z ^= 1, "Task is already complete");
    }

    private final void p() {
        Object obj = this.a;
        synchronized (obj) {
        }
    }

    public final com.google.android.play.core.tasks.d<ResultT> a(com.google.android.play.core.tasks.a<ResultT> a) {
        h hVar = new h(e.a, a);
        this.b.a(hVar);
        p();
        return this;
    }

    public final com.google.android.play.core.tasks.d<ResultT> b(com.google.android.play.core.tasks.b b) {
        c(e.a, b);
        return this;
    }

    public final com.google.android.play.core.tasks.d<ResultT> c(Executor executor, com.google.android.play.core.tasks.b b2) {
        j jVar = new j(executor, b2);
        this.b.a(jVar);
        p();
        return this;
    }

    public final com.google.android.play.core.tasks.d<ResultT> d(com.google.android.play.core.tasks.c<? super ResultT> c) {
        e(e.a, c);
        return this;
    }

    public final com.google.android.play.core.tasks.d<ResultT> e(Executor executor, com.google.android.play.core.tasks.c<? super ResultT> c2) {
        l lVar = new l(executor, c2);
        this.b.a(lVar);
        p();
        return this;
    }

    @Override // com.google.android.play.core.tasks.d
    public final Exception f() {
        final Object obj = this.a;
        return this.e;
        synchronized (obj) {
            obj = this.a;
            return this.e;
        }
    }

    public final ResultT g() {
        final Object obj = this.a;
        n();
        Exception exc = this.e;
        synchronized (obj) {
            return this.d;
        }
    }

    @Override // com.google.android.play.core.tasks.d
    public final boolean h() {
        final Object obj = this.a;
        return this.c;
        synchronized (obj) {
            obj = this.a;
            return this.c;
        }
    }

    @Override // com.google.android.play.core.tasks.d
    public final boolean i() {
        boolean z;
        int i;
        final Object obj = this.a;
        i = 0;
        synchronized (obj) {
            if (this.e == null) {
                i = 1;
            }
            try {
                return i;
                throw th;
            }
        }
    }

    @Override // com.google.android.play.core.tasks.d
    public final void j(Exception exception) {
        final Object obj = this.a;
        o();
        this.c = true;
        this.e = exception;
        this.b.b(this);
        return;
        synchronized (obj) {
            obj = this.a;
            o();
            this.c = true;
            this.e = exception;
            this.b.b(this);
        }
    }

    public final void k(ResultT resultt) {
        final Object obj = this.a;
        o();
        this.c = true;
        this.d = resultt;
        this.b.b(this);
        return;
        synchronized (obj) {
            obj = this.a;
            o();
            this.c = true;
            this.d = resultt;
            this.b.b(this);
        }
    }

    @Override // com.google.android.play.core.tasks.d
    public final boolean l(Exception exception) {
        final Object obj = this.a;
        synchronized (obj) {
            return 0;
        }
    }

    public final boolean m(ResultT resultt) {
        final Object obj = this.a;
        synchronized (obj) {
            return 0;
        }
    }
}
