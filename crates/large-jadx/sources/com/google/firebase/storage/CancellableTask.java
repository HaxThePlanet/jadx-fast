package com.google.firebase.storage;

import android.app.Activity;
import com.google.android.gms.tasks.j;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class CancellableTask<StateT>  extends j<StateT> {
    public abstract com.google.firebase.storage.CancellableTask<StateT> addOnProgressListener(Activity activity, com.google.firebase.storage.OnProgressListener<? super StateT> onProgressListener2);

    public abstract com.google.firebase.storage.CancellableTask<StateT> addOnProgressListener(com.google.firebase.storage.OnProgressListener<? super StateT> onProgressListener);

    public abstract com.google.firebase.storage.CancellableTask<StateT> addOnProgressListener(Executor executor, com.google.firebase.storage.OnProgressListener<? super StateT> onProgressListener2);

    @Override // com.google.android.gms.tasks.j
    public abstract boolean cancel();

    @Override // com.google.android.gms.tasks.j
    public abstract boolean isCanceled();

    @Override // com.google.android.gms.tasks.j
    public abstract boolean isInProgress();
}
