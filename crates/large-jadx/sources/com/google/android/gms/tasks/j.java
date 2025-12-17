package com.google.android.gms.tasks;

import android.app.Activity;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class j<TResult>  {
    public com.google.android.gms.tasks.j<TResult> addOnCanceledListener(Activity activity, com.google.android.gms.tasks.d d2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("addOnCanceledListener is not implemented.");
        throw obj1;
    }

    public com.google.android.gms.tasks.j<TResult> addOnCanceledListener(com.google.android.gms.tasks.d d) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("addOnCanceledListener is not implemented.");
        throw obj2;
    }

    public com.google.android.gms.tasks.j<TResult> addOnCanceledListener(Executor executor, com.google.android.gms.tasks.d d2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("addOnCanceledListener is not implemented");
        throw obj1;
    }

    public com.google.android.gms.tasks.j<TResult> addOnCompleteListener(Activity activity, com.google.android.gms.tasks.e<TResult> e2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("addOnCompleteListener is not implemented");
        throw obj1;
    }

    public com.google.android.gms.tasks.j<TResult> addOnCompleteListener(com.google.android.gms.tasks.e<TResult> e) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("addOnCompleteListener is not implemented");
        throw obj2;
    }

    public com.google.android.gms.tasks.j<TResult> addOnCompleteListener(Executor executor, com.google.android.gms.tasks.e<TResult> e2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("addOnCompleteListener is not implemented");
        throw obj1;
    }

    public abstract com.google.android.gms.tasks.j<TResult> addOnFailureListener(Activity activity, com.google.android.gms.tasks.f f2);

    public abstract com.google.android.gms.tasks.j<TResult> addOnFailureListener(com.google.android.gms.tasks.f f);

    public abstract com.google.android.gms.tasks.j<TResult> addOnFailureListener(Executor executor, com.google.android.gms.tasks.f f2);

    public abstract com.google.android.gms.tasks.j<TResult> addOnSuccessListener(Activity activity, com.google.android.gms.tasks.g<? super TResult> g2);

    public abstract com.google.android.gms.tasks.j<TResult> addOnSuccessListener(com.google.android.gms.tasks.g<? super TResult> g);

    public abstract com.google.android.gms.tasks.j<TResult> addOnSuccessListener(Executor executor, com.google.android.gms.tasks.g<? super TResult> g2);

    public <TContinuationResult> com.google.android.gms.tasks.j<TContinuationResult> continueWith(com.google.android.gms.tasks.c<TResult, TContinuationResult> c) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("continueWith is not implemented");
        throw obj2;
    }

    public <TContinuationResult> com.google.android.gms.tasks.j<TContinuationResult> continueWith(Executor executor, com.google.android.gms.tasks.c<TResult, TContinuationResult> c2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("continueWith is not implemented");
        throw obj1;
    }

    public <TContinuationResult> com.google.android.gms.tasks.j<TContinuationResult> continueWithTask(com.google.android.gms.tasks.c<TResult, com.google.android.gms.tasks.j<TContinuationResult>> c) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("continueWithTask is not implemented");
        throw obj2;
    }

    public <TContinuationResult> com.google.android.gms.tasks.j<TContinuationResult> continueWithTask(Executor executor, com.google.android.gms.tasks.c<TResult, com.google.android.gms.tasks.j<TContinuationResult>> c2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("continueWithTask is not implemented");
        throw obj1;
    }

    public abstract Exception getException();

    public abstract TResult getResult();

    public abstract <X extends Throwable> TResult getResult(Class<X> class);

    public abstract boolean isCanceled();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();

    public <TContinuationResult> com.google.android.gms.tasks.j<TContinuationResult> onSuccessTask(com.google.android.gms.tasks.i<TResult, TContinuationResult> i) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("onSuccessTask is not implemented");
        throw obj2;
    }

    public <TContinuationResult> com.google.android.gms.tasks.j<TContinuationResult> onSuccessTask(Executor executor, com.google.android.gms.tasks.i<TResult, TContinuationResult> i2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("onSuccessTask is not implemented");
        throw obj1;
    }
}
