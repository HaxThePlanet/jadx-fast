package com.google.android.play.core.tasks;

import com.google.android.play.core.internal.i1;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public final class f {
    public static <ResultT> ResultT a(com.google.android.play.core.tasks.d<ResultT> d) {
        i1.a(d, "Task must not be null");
        if (d.h()) {
            return f.d(d);
        }
        t tVar = new t(0);
        f.e(d, tVar);
        tVar.a();
        return f.d(d);
    }

    public static <ResultT> com.google.android.play.core.tasks.d<ResultT> b(Exception exception) {
        r rVar = new r();
        rVar.j(exception);
        return rVar;
    }

    public static <ResultT> com.google.android.play.core.tasks.d<ResultT> c(ResultT resultt) {
        r rVar = new r();
        rVar.k(resultt);
        return rVar;
    }

    private static <ResultT> ResultT d(com.google.android.play.core.tasks.d<ResultT> d) {
        if (!d.i()) {
        } else {
            return d.g();
        }
        ExecutionException executionException = new ExecutionException(d.f());
        throw executionException;
    }

    private static void e(com.google.android.play.core.tasks.d<?> d, com.google.android.play.core.tasks.u u2) {
        final java.util.concurrent.Executor executor = e.b;
        d.e(executor, u2);
        d.c(executor, u2);
    }
}
