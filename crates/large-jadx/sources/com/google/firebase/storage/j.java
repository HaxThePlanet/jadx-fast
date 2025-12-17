package com.google.firebase.storage;

/* loaded from: classes2.dex */
public final class j implements Runnable {

    public final com.google.firebase.storage.StorageTask a;
    public j(com.google.firebase.storage.StorageTask storageTask) {
        super();
        this.a = storageTask;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f();
    }
}
