package com.google.firebase.storage.network;

import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.StorageReferenceUri;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public class GetNetworkRequest extends com.google.firebase.storage.network.NetworkRequest {

    private static final String TAG = "GetNetworkRequest";
    public GetNetworkRequest(StorageReferenceUri storageReferenceUri, FirebaseApp firebaseApp2, long l3) {
        int obj1;
        Object obj2;
        super(storageReferenceUri, firebaseApp2);
        if (Long.compare(l3, obj1) != 0) {
            obj1 = new StringBuilder();
            obj1.append("bytes=");
            obj1.append(l3);
            obj1.append("-");
            super.setCustomHeader("Range", obj1.toString());
        }
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String getAction() {
        return "GET";
    }

    protected Map<String, String> getQueryParameters() {
        return Collections.singletonMap("alt", "media");
    }
}
