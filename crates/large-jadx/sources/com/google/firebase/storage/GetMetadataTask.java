package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetMetadataNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;

/* loaded from: classes2.dex */
class GetMetadataTask implements Runnable {

    private static final String TAG = "GetMetadataTask";
    private k<com.google.firebase.storage.StorageMetadata> mPendingResult;
    private com.google.firebase.storage.StorageMetadata mResultMetadata;
    private ExponentialBackoffSender mSender;
    private com.google.firebase.storage.StorageReference mStorageRef;
    GetMetadataTask(com.google.firebase.storage.StorageReference storageReference, k<com.google.firebase.storage.StorageMetadata> k2) {
        super();
        r.j(storageReference);
        r.j(k2);
        this.mStorageRef = storageReference;
        this.mPendingResult = k2;
        if (storageReference.getRoot().getName().equals(storageReference.getName()) != null) {
        } else {
            com.google.firebase.storage.FirebaseStorage obj7 = this.mStorageRef.getStorage();
            super(obj7.getApp().getApplicationContext(), obj7.getAuthProvider(), obj7.getAppCheckProvider(), obj7.getMaxDownloadRetryTimeMillis(), obj5);
            this.mSender = obj8;
        }
        obj7 = new IllegalArgumentException("getMetadata() is not supported at the root of the bucket.");
        throw obj7;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean resultSuccess;
        Object mResultMetadata;
        Object mStorageRef;
        GetMetadataNetworkRequest getMetadataNetworkRequest = new GetMetadataNetworkRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp());
        this.mSender.sendWithExponentialBackoff(getMetadataNetworkRequest);
        if (getMetadataNetworkRequest.isResultSuccess()) {
            StorageMetadata.Builder builder = new StorageMetadata.Builder(getMetadataNetworkRequest.getResultBody(), this.mStorageRef);
            this.mResultMetadata = builder.build();
        }
        k mPendingResult2 = this.mPendingResult;
        if (mPendingResult2 != null) {
            getMetadataNetworkRequest.completeTask(mPendingResult2, this.mResultMetadata);
        }
    }
}
