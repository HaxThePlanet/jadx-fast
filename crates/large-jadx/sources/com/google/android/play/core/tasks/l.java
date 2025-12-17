package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class l<ResultT>  implements com.google.android.play.core.tasks.m<ResultT> {

    private final Executor a;
    private final Object b;
    private final com.google.android.play.core.tasks.c<? super ResultT> c;
    public l(Executor executor, com.google.android.play.core.tasks.c<? super ResultT> c2) {
        super();
        Object object = new Object();
        this.b = object;
        this.a = executor;
        this.c = c2;
    }

    static com.google.android.play.core.tasks.c b(com.google.android.play.core.tasks.l l) {
        return l.c;
    }

    static Object c(com.google.android.play.core.tasks.l l) {
        return l.b;
    }

    public final void a(com.google.android.play.core.tasks.d<ResultT> d) {
        Object obj = this.b;
        if (d.i() && this.c == null) {
            obj = this.b;
            synchronized (obj) {
            }
        }
    }
}
