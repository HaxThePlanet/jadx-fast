package com.google.android.gms.tasks;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.r;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public final class m {
    public static <TResult> TResult a(com.google.android.gms.tasks.j<TResult> j) {
        r.h();
        r.k(j, "Task must not be null");
        if (j.isComplete()) {
            return m.j(j);
        }
        o oVar = new o(0);
        m.k(j, oVar);
        oVar.a();
        return m.j(j);
    }

    public static <TResult> TResult b(com.google.android.gms.tasks.j<TResult> j, long l2, TimeUnit timeUnit3) {
        r.h();
        r.k(j, "Task must not be null");
        r.k(obj5, "TimeUnit must not be null");
        if (j.isComplete()) {
            return m.j(j);
        }
        o oVar = new o(0);
        m.k(j, oVar);
        if (!oVar.b(l2, timeUnit3)) {
        } else {
            return m.j(j);
        }
        TimeoutException obj2 = new TimeoutException("Timed out waiting for Task");
        throw obj2;
    }

    @Deprecated
    public static <TResult> com.google.android.gms.tasks.j<TResult> c(Executor executor, Callable<TResult> callable2) {
        r.k(executor, "Executor must not be null");
        r.k(callable2, "Callback must not be null");
        m0 m0Var = new m0();
        n0 n0Var = new n0(m0Var, callable2);
        executor.execute(n0Var);
        return m0Var;
    }

    public static <TResult> com.google.android.gms.tasks.j<TResult> d(Exception exception) {
        m0 m0Var = new m0();
        m0Var.c(exception);
        return m0Var;
    }

    public static <TResult> com.google.android.gms.tasks.j<TResult> e(TResult tresult) {
        m0 m0Var = new m0();
        m0Var.a(tresult);
        return m0Var;
    }

    public static com.google.android.gms.tasks.j<Void> f(Collection<? extends com.google.android.gms.tasks.j<?>> collection) {
        boolean empty;
        Object next;
        String str;
        int size;
        if (collection != null) {
            if (collection.isEmpty()) {
            } else {
                Iterator iterator = collection.iterator();
                for (j next : iterator) {
                    Objects.requireNonNull(next, "null tasks are not accepted");
                }
                m0 m0Var = new m0();
                q qVar = new q(collection.size(), m0Var);
                Iterator obj3 = collection.iterator();
                for (j size : obj3) {
                    m.k(size, qVar);
                }
            }
            return m0Var;
        }
        return m.e(0);
    }

    public static com.google.android.gms.tasks.j<Void> g(com.google.android.gms.tasks.j<?>... jArr) {
        int length;
        if (jArr != null && jArr.length == 0) {
            if (jArr.length == 0) {
            }
            return m.f(Arrays.asList(jArr));
        }
        return m.e(0);
    }

    public static com.google.android.gms.tasks.j<List<com.google.android.gms.tasks.j<?>>> h(Collection<? extends com.google.android.gms.tasks.j<?>> collection) {
        boolean empty;
        if (collection != null && collection.isEmpty()) {
            if (collection.isEmpty()) {
            }
            o0 o0Var = new o0(collection);
            return m.f(collection).continueWithTask(l.a, o0Var);
        }
        return m.e(Collections.emptyList());
    }

    public static com.google.android.gms.tasks.j<List<com.google.android.gms.tasks.j<?>>> i(com.google.android.gms.tasks.j<?>... jArr) {
        int length;
        if (jArr != null && jArr.length == 0) {
            if (jArr.length == 0) {
            }
            return m.h(Arrays.asList(jArr));
        }
        return m.e(Collections.emptyList());
    }

    private static <TResult> TResult j(com.google.android.gms.tasks.j<TResult> j) {
        if (j.isSuccessful()) {
            return j.getResult();
        }
        if (j.isCanceled()) {
            CancellationException obj1 = new CancellationException("Task is already canceled");
            throw obj1;
        }
        ExecutionException executionException = new ExecutionException(j.getException());
        throw executionException;
    }

    private static <T> void k(com.google.android.gms.tasks.j<T> j, com.google.android.gms.tasks.p<? super T> p2) {
        final Executor executor = l.b;
        j.addOnSuccessListener(executor, p2);
        j.addOnFailureListener(executor, p2);
        j.addOnCanceledListener(executor, p2);
    }
}
