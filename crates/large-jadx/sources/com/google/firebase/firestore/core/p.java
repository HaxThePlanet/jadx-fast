package com.google.firebase.firestore.core;

import com.google.firebase.firestore.util.Listener;

/* loaded from: classes2.dex */
public final class p implements Listener {

    public static final com.google.firebase.firestore.core.p a;
    static {
        p pVar = new p();
        p.a = pVar;
    }

    @Override // com.google.firebase.firestore.util.Listener
    public final void onValue(Object object) {
        FirestoreClient.z((String)object);
    }
}
