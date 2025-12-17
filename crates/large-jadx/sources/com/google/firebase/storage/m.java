package com.google.firebase.storage;

/* loaded from: classes2.dex */
public final class m implements Runnable {

    public final com.google.firebase.storage.TaskListenerImpl a;
    public final Object b;
    public m(com.google.firebase.storage.TaskListenerImpl taskListenerImpl, Object object2) {
        super();
        this.a = taskListenerImpl;
        this.b = object2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b(this.b);
    }
}
