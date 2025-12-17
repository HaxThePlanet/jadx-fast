package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.StorageReferenceUri;

/* loaded from: classes2.dex */
public class ResumableUploadCancelRequest extends com.google.firebase.storage.network.ResumableNetworkRequest {

    public static boolean cancelCalled = false;
    private final Uri uploadURL;
    static {
    }

    public ResumableUploadCancelRequest(StorageReferenceUri storageReferenceUri, FirebaseApp firebaseApp2, Uri uri3) {
        super(storageReferenceUri, firebaseApp2);
        ResumableUploadCancelRequest.cancelCalled = true;
        this.uploadURL = uri3;
        super.setCustomHeader("X-Goog-Upload-Protocol", "resumable");
        super.setCustomHeader("X-Goog-Upload-Command", "cancel");
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
