package com.google.firebase.storage;

/* loaded from: classes2.dex */
public final class l implements com.google.firebase.storage.TaskListenerImpl.OnRaise {

    public final com.google.firebase.storage.StorageTask a;
    public l(com.google.firebase.storage.StorageTask storageTask) {
        super();
        this.a = storageTask;
    }

    @Override // com.google.firebase.storage.TaskListenerImpl$OnRaise
    public final void raise(Object object, Object object2) {
        this.a.h((g)object, (StorageTask.ProvideError)object2);
    }
}
