package com.google.android.play.core.tasks;

/* loaded from: classes2.dex */
public final class o<ResultT>  {

    private final com.google.android.play.core.tasks.r<ResultT> a;
    public o() {
        super();
        r rVar = new r();
        this.a = rVar;
    }

    public final com.google.android.play.core.tasks.d<ResultT> a() {
        return this.a;
    }

    public final void b(Exception exception) {
        this.a.j(exception);
    }

    public final void c(ResultT resultt) {
        this.a.k(resultt);
    }

    public final boolean d(Exception exception) {
        return this.a.l(exception);
    }

    public final boolean e(ResultT resultt) {
        return this.a.m(resultt);
    }
}
