package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class h<ResultT>  implements com.google.android.play.core.tasks.m<ResultT> {

    private final Executor a;
    private final Object b;
    private final com.google.android.play.core.tasks.a<ResultT> c;
    public h(Executor executor, com.google.android.play.core.tasks.a<ResultT> a2) {
        super();
        Object object = new Object();
        this.b = object;
        this.a = executor;
        this.c = a2;
    }

    static com.google.android.play.core.tasks.a b(com.google.android.play.core.tasks.h h) {
        return h.c;
    }

    static Object c(com.google.android.play.core.tasks.h h) {
        return h.b;
    }

    public final void a(com.google.android.play.core.tasks.d<ResultT> d) {
        Object obj = this.b;
        synchronized (obj) {
        }
    }
}
