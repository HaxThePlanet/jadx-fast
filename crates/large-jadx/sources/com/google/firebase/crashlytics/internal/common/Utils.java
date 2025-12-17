package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public final class Utils {

    private static final ExecutorService TASK_CONTINUATION_EXECUTOR_SERVICE;
    static {
        Utils.TASK_CONTINUATION_EXECUTOR_SERVICE = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");
    }

    static Object a(CountDownLatch countDownLatch, j j2) {
        countDownLatch.countDown();
        return null;
    }

    public static <T> T awaitEvenIfOnMainThread(j<T> j) {
        Looper mainLooper;
        TimeUnit sECONDS;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        g gVar = new g(countDownLatch);
        j.continueWith(Utils.TASK_CONTINUATION_EXECUTOR_SERVICE, gVar);
        Looper myLooper = Looper.myLooper();
        if (Looper.getMainLooper() == myLooper) {
            countDownLatch.await(4, myLooper);
        } else {
            countDownLatch.await();
        }
        if (j.isSuccessful()) {
            return j.getResult();
        }
        if (j.isCanceled()) {
        } else {
            if (j.isComplete()) {
                IllegalStateException illegalStateException = new IllegalStateException(j.getException());
                throw illegalStateException;
            }
            TimeoutException obj4 = new TimeoutException();
            throw obj4;
        }
        obj4 = new CancellationException("Task is already canceled");
        throw obj4;
    }

    static Void b(k k, j j2) {
        Object obj2;
        if (j2.isSuccessful()) {
            k.e(j2.getResult());
        } else {
            obj2 = j2.getException();
            Objects.requireNonNull(obj2);
            k.d((Exception)obj2);
        }
        return null;
    }

    static Void c(k k, j j2) {
        Object obj2;
        if (j2.isSuccessful()) {
            k.e(j2.getResult());
        } else {
            obj2 = j2.getException();
            Objects.requireNonNull(obj2);
            k.d((Exception)obj2);
        }
        return null;
    }

    public static <T> j<T> callTask(Executor executor, Callable<j<T>> callable2) {
        k kVar = new k();
        Utils.1 anon = new Utils.1(callable2, kVar);
        executor.execute(anon);
        return kVar.a();
    }

    public static <T> j<T> race(j<T> j, j<T> j2) {
        k kVar = new k();
        f fVar = new f(kVar);
        j.continueWith(fVar);
        j2.continueWith(fVar);
        return kVar.a();
    }

    public static <T> j<T> race(Executor executor, j<T> j2, j<T> j3) {
        k kVar = new k();
        e eVar = new e(kVar);
        j2.continueWith(executor, eVar);
        j3.continueWith(executor, eVar);
        return kVar.a();
    }
}
