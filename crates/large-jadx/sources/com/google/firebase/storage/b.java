package com.google.firebase.storage;

/* loaded from: classes2.dex */
public final class b implements com.google.firebase.storage.TaskListenerImpl.OnRaise {

    public static final com.google.firebase.storage.b a;
    static {
        b bVar = new b();
        b.a = bVar;
    }

    @Override // com.google.firebase.storage.TaskListenerImpl$OnRaise
    public final void raise(Object object, Object object2) {
        (OnPausedListener)object.onPaused((StorageTask.ProvideError)object2);
    }
}
