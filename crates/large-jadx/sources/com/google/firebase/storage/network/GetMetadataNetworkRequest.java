package com.google.firebase.storage.network;

import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.StorageReferenceUri;

/* loaded from: classes2.dex */
public class GetMetadataNetworkRequest extends com.google.firebase.storage.network.NetworkRequest {
    public GetMetadataNetworkRequest(StorageReferenceUri storageReferenceUri, FirebaseApp firebaseApp2) {
        super(storageReferenceUri, firebaseApp2);
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String getAction() {
        return "GET";
    }
}
