package com.google.firebase.storage;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.internal.StorageReferenceUri;
import com.google.firebase.storage.network.GetMetadataNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class GetDownloadUrlTask implements Runnable {

    private static final String DOWNLOAD_TOKENS_KEY = "downloadTokens";
    private static final String TAG = "GetMetadataTask";
    private k<Uri> pendingResult;
    private ExponentialBackoffSender sender;
    private com.google.firebase.storage.StorageReference storageRef;
    GetDownloadUrlTask(com.google.firebase.storage.StorageReference storageReference, k<Uri> k2) {
        super();
        r.j(storageReference);
        r.j(k2);
        this.storageRef = storageReference;
        this.pendingResult = k2;
        if (storageReference.getRoot().getName().equals(storageReference.getName()) != null) {
        } else {
            com.google.firebase.storage.FirebaseStorage obj7 = this.storageRef.getStorage();
            super(obj7.getApp().getApplicationContext(), obj7.getAuthProvider(), obj7.getAppCheckProvider(), obj7.getMaxOperationRetryTimeMillis(), obj5);
            this.sender = obj8;
        }
        obj7 = new IllegalArgumentException("getDownloadUrl() is not supported at the root of the bucket.");
        throw obj7;
    }

    private Uri extractDownloadUrl(JSONObject jSONObject) {
        String obj4 = jSONObject.optString("downloadTokens");
        if (!TextUtils.isEmpty(obj4)) {
            Uri.Builder upon = this.storageRef.getStorageReferenceUri().getHttpUri().buildUpon();
            upon.appendQueryParameter("alt", "media");
            upon.appendQueryParameter("token", obj4.split(",", -1)[0]);
            return upon.build();
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        Uri downloadUrl;
        GetMetadataNetworkRequest getMetadataNetworkRequest = new GetMetadataNetworkRequest(this.storageRef.getStorageReferenceUri(), this.storageRef.getApp());
        this.sender.sendWithExponentialBackoff(getMetadataNetworkRequest);
        if (getMetadataNetworkRequest.isResultSuccess()) {
            downloadUrl = extractDownloadUrl(getMetadataNetworkRequest.getResultBody());
        } else {
            downloadUrl = 0;
        }
        k pendingResult = this.pendingResult;
        if (pendingResult != null) {
            getMetadataNetworkRequest.completeTask(pendingResult, downloadUrl);
        }
    }
}
