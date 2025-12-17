package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class j<ResultT>  implements com.google.android.play.core.tasks.m<ResultT> {

    private final Executor a;
    private final Object b;
    private final com.google.android.play.core.tasks.b c;
    public j(Executor executor, com.google.android.play.core.tasks.b b2) {
        super();
        Object object = new Object();
        this.b = object;
        this.a = executor;
        this.c = b2;
    }

    static com.google.android.play.core.tasks.b b(com.google.android.play.core.tasks.j j) {
        return j.c;
    }

    static Object c(com.google.android.play.core.tasks.j j) {
        return j.b;
    }

    public final void a(com.google.android.play.core.tasks.d<ResultT> d) {
        Object obj = this.b;
        if (!d.i() && this.c == null) {
            obj = this.b;
            synchronized (obj) {
            }
        }
    }
}
