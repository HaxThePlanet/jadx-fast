package com.google.firebase.firestore;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.inject.Deferred;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
class FirestoreMultiDbComponent implements FirebaseAppLifecycleListener, com.google.firebase.firestore.FirebaseFirestore.InstanceRegistry {

    private final FirebaseApp app;
    private final Deferred<InternalAppCheckTokenProvider> appCheckProvider;
    private final Deferred<InternalAuthProvider> authProvider;
    private final Context context;
    private final Map<String, com.google.firebase.firestore.FirebaseFirestore> instances;
    private final GrpcMetadataProvider metadataProvider;
    FirestoreMultiDbComponent(Context context, FirebaseApp firebaseApp2, Deferred<InternalAuthProvider> deferred3, Deferred<InternalAppCheckTokenProvider> deferred4, GrpcMetadataProvider grpcMetadataProvider5) {
        super();
        HashMap hashMap = new HashMap();
        this.instances = hashMap;
        this.context = context;
        this.app = firebaseApp2;
        this.authProvider = deferred3;
        this.appCheckProvider = deferred4;
        this.metadataProvider = grpcMetadataProvider5;
        firebaseApp2.addLifecycleEventListener(this);
    }

    @Override // com.google.firebase.FirebaseAppLifecycleListener
    com.google.firebase.firestore.FirebaseFirestore get(String string) {
        Object instance;
        Map instances;
        FirebaseApp app;
        Deferred authProvider;
        Deferred appCheckProvider;
        Object obj2;
        Object obj;
        GrpcMetadataProvider metadataProvider;
        synchronized (this) {
            try {
                this.instances.put(string, FirebaseFirestore.newInstance(this.context, this.app, this.authProvider, this.appCheckProvider, string, this, this.metadataProvider));
                return instance;
                throw string;
            }
        }
    }

    @Override // com.google.firebase.FirebaseAppLifecycleListener
    public void onDeleted(String string, FirebaseOptions firebaseOptions2) {
        int i;
        Object[] arr;
        int i2;
        String str;
        java.util.Set obj6;
        ArrayList obj5 = new ArrayList(this.instances.entrySet());
        obj5 = obj5.iterator();
        synchronized (this) {
            try {
                while (obj5.hasNext()) {
                    obj6 = obj5.next();
                    (FirebaseFirestore)(Map.Entry)obj6.getValue().terminate();
                    int i3 = 1;
                    i2 = 0;
                    if (!this.instances.containsKey(obj6.getKey())) {
                    } else {
                    }
                    i = i2;
                    arr = new Object[i3];
                    arr[i2] = obj6.getKey();
                    Assert.hardAssert(i, "terminate() should have removed its entry from `instances` for key: %s", arr);
                    i = i3;
                }
                obj6 = obj5.next();
                (FirebaseFirestore)(Map.Entry)obj6.getValue().terminate();
                i3 = 1;
                i2 = 0;
                if (!this.instances.containsKey(obj6.getKey())) {
                } else {
                }
                i = i3;
                i = i2;
                arr = new Object[i3];
                arr[i2] = obj6.getKey();
                Assert.hardAssert(i, "terminate() should have removed its entry from `instances` for key: %s", arr);
                throw string;
            }
        }
    }

    @Override // com.google.firebase.FirebaseAppLifecycleListener
    public void remove(String string) {
        this.instances.remove(string);
        return;
        synchronized (this) {
            this.instances.remove(string);
        }
    }
}
