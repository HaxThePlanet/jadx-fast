package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.StorageReferenceUri;

/* loaded from: classes2.dex */
public class ResumableUploadQueryRequest extends com.google.firebase.storage.network.ResumableNetworkRequest {

    private final Uri uploadURL;
    public ResumableUploadQueryRequest(StorageReferenceUri storageReferenceUri, FirebaseApp firebaseApp2, Uri uri3) {
        super(storageReferenceUri, firebaseApp2);
        this.uploadURL = uri3;
        super.setCustomHeader("X-Goog-Upload-Protocol", "resumable");
        super.setCustomHeader("X-Goog-Upload-Command", "query");
    }

    @Override // com.google.firebase.storage.network.ResumableNetworkRequest
    protected String getAction() {
        return "POST";
    }

    @Override // com.google.firebase.storage.network.ResumableNetworkRequest
    public Uri getURL() {
        return this.uploadURL;
    }
}
