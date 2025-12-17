package com.google.firebase.storage.network;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.StorageReferenceUri;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ListNetworkRequest extends com.google.firebase.storage.network.NetworkRequest {

    private final Integer maxPageSize;
    private final String nextPageToken;
    public ListNetworkRequest(StorageReferenceUri storageReferenceUri, FirebaseApp firebaseApp2, Integer integer3, String string4) {
        super(storageReferenceUri, firebaseApp2);
        this.maxPageSize = integer3;
        this.nextPageToken = string4;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    protected String getAction() {
        return "GET";
    }

    protected Map<String, String> getQueryParameters() {
        String pathWithoutBucket;
        Object maxPageSize;
        boolean nextPageToken;
        boolean empty;
        HashMap hashMap = new HashMap();
        pathWithoutBucket = getPathWithoutBucket();
        final String str2 = "/";
        if (!pathWithoutBucket.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(pathWithoutBucket);
            stringBuilder.append(str2);
            hashMap.put("prefix", stringBuilder.toString());
        }
        hashMap.put("delimiter", str2);
        maxPageSize = this.maxPageSize;
        if (maxPageSize != null) {
            hashMap.put("maxResults", Integer.toString(maxPageSize.intValue()));
        }
        if (!TextUtils.isEmpty(this.nextPageToken)) {
            hashMap.put("pageToken", this.nextPageToken);
        }
        return hashMap;
    }

    @Override // com.google.firebase.storage.network.NetworkRequest
    public Uri getURL() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getStorageReferenceUri().getHttpBaseUri());
        stringBuilder.append("/b/");
        stringBuilder.append(getStorageReferenceUri().getGsUri().getAuthority());
        stringBuilder.append("/o");
        return Uri.parse(stringBuilder.toString());
    }
}
