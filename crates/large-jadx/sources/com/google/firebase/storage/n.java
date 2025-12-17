package com.google.firebase.storage;

/* loaded from: classes2.dex */
public final class n implements Runnable {

    public final com.google.firebase.storage.TaskListenerImpl a;
    public final Object b;
    public final com.google.firebase.storage.StorageTask.ProvideError c;
    public n(com.google.firebase.storage.TaskListenerImpl taskListenerImpl, Object object2, com.google.firebase.storage.StorageTask.ProvideError storageTask$ProvideError3) {
        super();
        this.a = taskListenerImpl;
        this.b = object2;
        this.c = provideError3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f(this.b, this.c);
    }
}
