package com.google.firebase.firestore.core;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class AsyncEventListener<T>  implements EventListener<T> {

    private final EventListener<T> eventListener;
    private final Executor executor;
    private volatile boolean muted = false;
    public AsyncEventListener(Executor executor, EventListener<T> eventListener2) {
        super();
        final int i = 0;
        this.executor = executor;
        this.eventListener = eventListener2;
    }

    private void a(Object object, FirebaseFirestoreException firebaseFirestoreException2) {
        boolean eventListener;
        if (!this.muted) {
            this.eventListener.onEvent(object, firebaseFirestoreException2);
        }
    }

    @Override // com.google.firebase.firestore.EventListener
    public void b(Object object, FirebaseFirestoreException firebaseFirestoreException2) {
        a(object, firebaseFirestoreException2);
    }

    @Override // com.google.firebase.firestore.EventListener
    public void mute() {
        this.muted = true;
    }

    public void onEvent(T t, FirebaseFirestoreException firebaseFirestoreException2) {
        c cVar = new c(this, t, firebaseFirestoreException2);
        this.executor.execute(cVar);
    }
}
