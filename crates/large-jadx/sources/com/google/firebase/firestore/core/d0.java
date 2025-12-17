package com.google.firebase.firestore.core;

import com.google.firebase.firestore.ListenerRegistration;

/* loaded from: classes2.dex */
public final class d0 implements Runnable {

    public final ListenerRegistration a;
    public d0(ListenerRegistration listenerRegistration) {
        super();
        this.a = listenerRegistration;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.remove();
    }
}
