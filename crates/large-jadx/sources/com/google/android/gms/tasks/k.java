package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
public class k<TResult>  {

    private final com.google.android.gms.tasks.m0<TResult> a;
    public k() {
        super();
        m0 m0Var = new m0();
        this.a = m0Var;
    }

    public k(com.google.android.gms.tasks.a a) {
        super();
        m0 m0Var = new m0();
        this.a = m0Var;
        i0 i0Var = new i0(this);
        a.a(i0Var);
    }

    static com.google.android.gms.tasks.m0 f(com.google.android.gms.tasks.k k) {
        return k.a;
    }

    public com.google.android.gms.tasks.j<TResult> a() {
        return this.a;
    }

    public void b(Exception exception) {
        this.a.c(exception);
    }

    public void c(TResult tresult) {
        this.a.a(tresult);
    }

    public boolean d(Exception exception) {
        return this.a.d(exception);
    }

    public boolean e(TResult tresult) {
        return this.a.b(tresult);
    }
}
