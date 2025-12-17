package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.internal.r;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class m0<TResult>  extends com.google.android.gms.tasks.j<TResult> {

    private final Object a;
    private final com.google.android.gms.tasks.h0<TResult> b;
    private boolean c;
    private volatile boolean d;
    private TResult e;
    private Exception f;
    m0() {
        super();
        Object object = new Object();
        this.a = object;
        h0 h0Var = new h0();
        this.b = h0Var;
    }

    private final void f() {
        r.n(this.c, "Task is not yet complete");
    }

    private final void g() {
        if (this.c) {
        } else {
        }
        throw DuplicateTaskCompletionException.a(this);
    }

    private final void h() {
        if (this.d) {
        } else {
        }
        CancellationException cancellationException = new CancellationException("Task is already canceled.");
        throw cancellationException;
    }

    private final void i() {
        Object obj = this.a;
        synchronized (obj) {
        }
    }

    public final void a(TResult tresult) {
        final Object obj = this.a;
        g();
        this.c = true;
        this.e = tresult;
        this.b.b(this);
        return;
        synchronized (obj) {
            obj = this.a;
            g();
            this.c = true;
            this.e = tresult;
            this.b.b(this);
        }
    }

    public final com.google.android.gms.tasks.j<TResult> addOnCanceledListener(Activity activity, com.google.android.gms.tasks.d d2) {
        x xVar = new x(l.a, d2);
        this.b.a(xVar);
        l0.a(activity).b(xVar);
        i();
        return this;
    }

    public final com.google.android.gms.tasks.j<TResult> addOnCanceledListener(com.google.android.gms.tasks.d d) {
        addOnCanceledListener(l.a, d);
        return this;
    }

    public final com.google.android.gms.tasks.j<TResult> addOnCanceledListener(Executor executor, com.google.android.gms.tasks.d d2) {
        x xVar = new x(executor, d2);
        this.b.a(xVar);
        i();
        return this;
    }

    public final com.google.android.gms.tasks.j<TResult> addOnCompleteListener(Activity activity, com.google.android.gms.tasks.e<TResult> e2) {
        z zVar = new z(l.a, e2);
        this.b.a(zVar);
        l0.a(activity).b(zVar);
        i();
        return this;
    }

    public final com.google.android.gms.tasks.j<TResult> addOnCompleteListener(com.google.android.gms.tasks.e<TResult> e) {
        z zVar = new z(l.a, e);
        this.b.a(zVar);
        i();
        return this;
    }

    public final com.google.android.gms.tasks.j<TResult> addOnCompleteListener(Executor executor, com.google.android.gms.tasks.e<TResult> e2) {
        z zVar = new z(executor, e2);
        this.b.a(zVar);
        i();
        return this;
    }

    public final com.google.android.gms.tasks.j<TResult> addOnFailureListener(Activity activity, com.google.android.gms.tasks.f f2) {
        b0 b0Var = new b0(l.a, f2);
        this.b.a(b0Var);
        l0.a(activity).b(b0Var);
        i();
        return this;
    }

    public final com.google.android.gms.tasks.j<TResult> addOnFailureListener(com.google.android.gms.tasks.f f) {
        addOnFailureListener(l.a, f);
        return this;
    }

    public final com.google.android.gms.tasks.j<TResult> addOnFailureListener(Executor executor, com.google.android.gms.tasks.f f2) {
        b0 b0Var = new b0(executor, f2);
        this.b.a(b0Var);
        i();
        return this;
    }

    public final com.google.android.gms.tasks.j<TResult> addOnSuccessListener(Activity activity, com.google.android.gms.tasks.g<? super TResult> g2) {
        d0 d0Var = new d0(l.a, g2);
        this.b.a(d0Var);
        l0.a(activity).b(d0Var);
        i();
        return this;
    }

    public final com.google.android.gms.tasks.j<TResult> addOnSuccessListener(com.google.android.gms.tasks.g<? super TResult> g) {
        addOnSuccessListener(l.a, g);
        return this;
    }

    public final com.google.android.gms.tasks.j<TResult> addOnSuccessListener(Executor executor, com.google.android.gms.tasks.g<? super TResult> g2) {
        d0 d0Var = new d0(executor, g2);
        this.b.a(d0Var);
        i();
        return this;
    }

    public final boolean b(TResult tresult) {
        final Object obj = this.a;
        synchronized (obj) {
            return 0;
        }
    }

    @Override // com.google.android.gms.tasks.j
    public final void c(Exception exception) {
        r.k(exception, "Exception must not be null");
        Object obj = this.a;
        g();
        this.c = true;
        this.f = exception;
        this.b.b(this);
        return;
        synchronized (obj) {
            r.k(exception, "Exception must not be null");
            obj = this.a;
            g();
            this.c = true;
            this.f = exception;
            this.b.b(this);
        }
    }

    public final <TContinuationResult> com.google.android.gms.tasks.j<TContinuationResult> continueWith(com.google.android.gms.tasks.c<TResult, TContinuationResult> c) {
        return continueWith(l.a, c);
    }

    public final <TContinuationResult> com.google.android.gms.tasks.j<TContinuationResult> continueWith(Executor executor, com.google.android.gms.tasks.c<TResult, TContinuationResult> c2) {
        m0 m0Var = new m0();
        t tVar = new t(executor, c2, m0Var);
        this.b.a(tVar);
        i();
        return m0Var;
    }

    public final <TContinuationResult> com.google.android.gms.tasks.j<TContinuationResult> continueWithTask(com.google.android.gms.tasks.c<TResult, com.google.android.gms.tasks.j<TContinuationResult>> c) {
        return continueWithTask(l.a, c);
    }

    public final <TContinuationResult> com.google.android.gms.tasks.j<TContinuationResult> continueWithTask(Executor executor, com.google.android.gms.tasks.c<TResult, com.google.android.gms.tasks.j<TContinuationResult>> c2) {
        m0 m0Var = new m0();
        v vVar = new v(executor, c2, m0Var);
        this.b.a(vVar);
        i();
        return m0Var;
    }

    @Override // com.google.android.gms.tasks.j
    public final boolean d(Exception exception) {
        r.k(exception, "Exception must not be null");
        Object obj = this.a;
        synchronized (obj) {
            return 0;
        }
    }

    @Override // com.google.android.gms.tasks.j
    public final boolean e() {
        Object obj = this.a;
        synchronized (obj) {
            return 0;
        }
    }

    @Override // com.google.android.gms.tasks.j
    public final Exception getException() {
        final Object obj = this.a;
        return this.f;
        synchronized (obj) {
            obj = this.a;
            return this.f;
        }
    }

    public final TResult getResult() {
        final Object obj = this.a;
        f();
        h();
        Exception exc = this.f;
        synchronized (obj) {
            return this.e;
        }
    }

    public final <X extends Throwable> TResult getResult(Class<X> class) {
        final Object obj = this.a;
        f();
        h();
        synchronized (obj) {
            Exception obj3 = this.f;
            if (obj3 != null) {
            } else {
                return this.e;
            }
            try {
                RuntimeExecutionException runtimeExecutionException = new RuntimeExecutionException(obj3);
                throw runtimeExecutionException;
                throw (Throwable)class.cast(this.f);
                throw class;
            }
        }
    }

    @Override // com.google.android.gms.tasks.j
    public final boolean isCanceled() {
        return this.d;
    }

    @Override // com.google.android.gms.tasks.j
    public final boolean isComplete() {
        final Object obj = this.a;
        return this.c;
        synchronized (obj) {
            obj = this.a;
            return this.c;
        }
    }

    @Override // com.google.android.gms.tasks.j
    public final boolean isSuccessful() {
        boolean z;
        int i;
        final Object obj = this.a;
        i = 0;
        synchronized (obj) {
            if (!this.d) {
                if (this.f == null) {
                    try {
                        i = 1;
                        return i;
                        throw th;
                    }
                }
            }
        }
    }

    public final <TContinuationResult> com.google.android.gms.tasks.j<TContinuationResult> onSuccessTask(com.google.android.gms.tasks.i<TResult, TContinuationResult> i) {
        m0 m0Var = new m0();
        f0 f0Var = new f0(l.a, i, m0Var);
        this.b.a(f0Var);
        i();
        return m0Var;
    }

    public final <TContinuationResult> com.google.android.gms.tasks.j<TContinuationResult> onSuccessTask(Executor executor, com.google.android.gms.tasks.i<TResult, TContinuationResult> i2) {
        m0 m0Var = new m0();
        f0 f0Var = new f0(executor, i2, m0Var);
        this.b.a(f0Var);
        i();
        return m0Var;
    }
}
