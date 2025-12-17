package com.google.firebase.storage;

import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class FirebaseStorageComponent {

    private final FirebaseApp app;
    private final Provider<InternalAppCheckTokenProvider> appCheckProvider;
    private final Provider<InternalAuthProvider> authProvider;
    private final Map<String, com.google.firebase.storage.FirebaseStorage> instances;
    FirebaseStorageComponent(FirebaseApp firebaseApp, Provider<InternalAuthProvider> provider2, Provider<InternalAppCheckTokenProvider> provider3) {
        super();
        HashMap hashMap = new HashMap();
        this.instances = hashMap;
        this.app = firebaseApp;
        this.authProvider = provider2;
        this.appCheckProvider = provider3;
    }

    void clearInstancesForTesting() {
        this.instances.clear();
        return;
        synchronized (this) {
            this.instances.clear();
        }
    }

    com.google.firebase.storage.FirebaseStorage get(String string) {
        Object firebaseStorage;
        Map instances;
        Provider authProvider;
        Provider appCheckProvider;
        synchronized (this) {
            try {
                firebaseStorage = new FirebaseStorage(string, this.app, this.authProvider, this.appCheckProvider);
                this.instances.put(string, firebaseStorage);
                return firebaseStorage;
                throw string;
            }
        }
    }
}
