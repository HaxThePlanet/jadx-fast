package com.google.firebase.storage;

import android.app.Activity;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class ControllableTask<StateT>  extends com.google.firebase.storage.CancellableTask<StateT> {
    public abstract com.google.firebase.storage.ControllableTask<StateT> addOnPausedListener(Activity activity, com.google.firebase.storage.OnPausedListener<? super StateT> onPausedListener2);

    public abstract com.google.firebase.storage.ControllableTask<StateT> addOnPausedListener(com.google.firebase.storage.OnPausedListener<? super StateT> onPausedListener);

    public abstract com.google.firebase.storage.ControllableTask<StateT> addOnPausedListener(Executor executor, com.google.firebase.storage.OnPausedListener<? super StateT> onPausedListener2);

    @Override // com.google.firebase.storage.CancellableTask
    public abstract boolean isPaused();

    @Override // com.google.firebase.storage.CancellableTask
    public abstract boolean pause();

    @Override // com.google.firebase.storage.CancellableTask
    public abstract boolean resume();
}
