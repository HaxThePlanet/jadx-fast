package com.google.firebase.storage.network;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.StorageReferenceUri;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ResumableUploadStartRequest extends com.google.firebase.storage.network.ResumableNetworkRequest {

    private final String contentType;
    private final JSONObject metadata;
    public ResumableUploadStartRequest(StorageReferenceUri storageReferenceUri, FirebaseApp firebaseApp2, JSONObject jSONObject3, String string4) {
        boolean obj1;
        Object obj2;
        super(storageReferenceUri, firebaseApp2);
        this.metadata = jSONObject3;
        this.contentType = string4;
        if (TextUtils.isEmpty(string4)) {
            obj1 = new IllegalArgumentException("mContentType is null or empty");
            this.mException = obj1;
        }
        super.setCustomHeader("X-Goog-Upload-Protocol", "resumable");
        super.setCustomHeader("X-Goog-Upload-Command", "start");
        super.setCustomHeader("X-Goog-Upload-Header-Content-Type", string4);
    }

    @Override // com.google.firebase.storage.network.ResumableNetworkRequest
    protected String getAction() {
        return "POST";
    }

    @Override // com.google.firebase.storage.network.ResumableNetworkRequest
    protected JSONObject getOutputJSON() {
        return this.metadata;
    }

    protected Map<String, String> getQueryParameters() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", getPathWithoutBucket());
        hashMap.put("uploadType", "resumable");
        return hashMap;
    }

    @Override // com.google.firebase.storage.network.ResumableNetworkRequest
    public Uri getURL() {
        Uri.Builder upon = getStorageReferenceUri().getHttpBaseUri().buildUpon();
        upon.appendPath("b");
        upon.appendPath(getStorageReferenceUri().getGsUri().getAuthority());
        upon.appendPath("o");
        return upon.build();
    }
}
