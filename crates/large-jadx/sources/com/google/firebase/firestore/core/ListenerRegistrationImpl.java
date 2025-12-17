package com.google.firebase.firestore.core;

import com.google.firebase.firestore.ListenerRegistration;

/* loaded from: classes2.dex */
public class ListenerRegistrationImpl implements ListenerRegistration {

    private final com.google.firebase.firestore.core.AsyncEventListener<com.google.firebase.firestore.core.ViewSnapshot> asyncEventListener;
    private final com.google.firebase.firestore.core.FirestoreClient client;
    private final com.google.firebase.firestore.core.QueryListener queryListener;
    public ListenerRegistrationImpl(com.google.firebase.firestore.core.FirestoreClient firestoreClient, com.google.firebase.firestore.core.QueryListener queryListener2, com.google.firebase.firestore.core.AsyncEventListener<com.google.firebase.firestore.core.ViewSnapshot> asyncEventListener3) {
        super();
        this.client = firestoreClient;
        this.queryListener = queryListener2;
        this.asyncEventListener = asyncEventListener3;
    }

    @Override // com.google.firebase.firestore.ListenerRegistration
    public void remove() {
        this.asyncEventListener.mute();
        this.client.stopListening(this.queryListener);
    }
}
