package com.google.firebase.storage;

/* loaded from: classes2.dex */
public final class p implements com.google.firebase.storage.TaskListenerImpl.OnRaise {

    public static final com.google.firebase.storage.p a;
    static {
        p pVar = new p();
        p.a = pVar;
    }

    @Override // com.google.firebase.storage.TaskListenerImpl$OnRaise
    public final void raise(Object object, Object object2) {
        (OnProgressListener)object.onProgress((StorageTask.ProvideError)object2);
    }
}
