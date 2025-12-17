package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreException.Code;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.AsyncQueue.TimerId;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.firestore.util.Function;

/* loaded from: classes2.dex */
public class TransactionRunner<TResult>  {

    public static final int DEFAULT_MAX_ATTEMPTS_COUNT = 5;
    private AsyncQueue asyncQueue;
    private int attemptsRemaining = 5;
    private ExponentialBackoff backoff;
    private RemoteStore remoteStore;
    private k<TResult> taskSource;
    private Function<com.google.firebase.firestore.core.Transaction, j<TResult>> updateFunction;
    public TransactionRunner(AsyncQueue asyncQueue, RemoteStore remoteStore2, Function<com.google.firebase.firestore.core.Transaction, j<TResult>> function3) {
        super();
        k kVar = new k();
        this.taskSource = kVar;
        this.asyncQueue = asyncQueue;
        this.remoteStore = remoteStore2;
        this.updateFunction = function3;
        int obj3 = 5;
        obj3 = new ExponentialBackoff(asyncQueue, AsyncQueue.TimerId.RETRY_TRANSACTION);
        this.backoff = obj3;
    }

    private void a(j j, j j2) {
        Object obj2;
        Object obj3;
        if (j2.isSuccessful()) {
            this.taskSource.c(j.getResult());
        } else {
            handleTransactionError(j2);
        }
    }

    private void c(com.google.firebase.firestore.core.Transaction transaction, j j2) {
        boolean successful;
        com.google.firebase.firestore.core.a0 a0Var;
        j obj3;
        if (!j2.isSuccessful()) {
            handleTransactionError(j2);
        } else {
            a0Var = new a0(this, j2);
            transaction.commit().addOnCompleteListener(this.asyncQueue.getExecutor(), a0Var);
        }
    }

    private void e() {
        com.google.firebase.firestore.core.Transaction transaction = this.remoteStore.createTransaction();
        z zVar = new z(this, transaction);
        (j)this.updateFunction.apply(transaction).addOnCompleteListener(this.asyncQueue.getExecutor(), zVar);
    }

    private void handleTransactionError(j j) {
        int retryableTransactionError;
        Exception obj2;
        if (this.attemptsRemaining > 0 && TransactionRunner.isRetryableTransactionError(j.getException())) {
            if (TransactionRunner.isRetryableTransactionError(j.getException())) {
                runWithBackoff();
            } else {
                this.taskSource.b(j.getException());
            }
        } else {
        }
    }

    private static boolean isRetryableTransactionError(Exception exception) {
        boolean code;
        int i;
        FirebaseFirestoreException.Code fAILED_PRECONDITION;
        Object obj3;
        i = 0;
        if (exception instanceof FirebaseFirestoreException != null) {
            code = (FirebaseFirestoreException)exception.getCode();
            if (code != FirebaseFirestoreException.Code.ABORTED && code != FirebaseFirestoreException.Code.FAILED_PRECONDITION) {
                if (code != FirebaseFirestoreException.Code.FAILED_PRECONDITION) {
                    if (!Datastore.isPermanentError(exception.getCode())) {
                        i = 1;
                    }
                } else {
                }
            } else {
            }
        }
        return i;
    }

    private void runWithBackoff() {
        this.attemptsRemaining = attemptsRemaining--;
        b0 b0Var = new b0(this);
        this.backoff.backoffAndRun(b0Var);
    }

    public void b(j j, j j2) {
        a(j, j2);
    }

    public void d(com.google.firebase.firestore.core.Transaction transaction, j j2) {
        c(transaction, j2);
    }

    public void f() {
        e();
    }

    public j<TResult> run() {
        runWithBackoff();
        return this.taskSource.a();
    }
}
