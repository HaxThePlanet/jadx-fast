package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.tasks.k;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.NetworkRequest;
import com.google.firebase.storage.network.UpdateMetadataNetworkRequest;

/* loaded from: classes2.dex */
class UpdateMetadataTask implements Runnable {

    private static final String TAG = "UpdateMetadataTask";
    private final com.google.firebase.storage.StorageMetadata mNewMetadata;
    private final k<com.google.firebase.storage.StorageMetadata> mPendingResult;
    private com.google.firebase.storage.StorageMetadata mResultMetadata = null;
    private ExponentialBackoffSender mSender;
    private final com.google.firebase.storage.StorageReference mStorageRef;
    public UpdateMetadataTask(com.google.firebase.storage.StorageReference storageReference, k<com.google.firebase.storage.StorageMetadata> k2, com.google.firebase.storage.StorageMetadata storageMetadata3) {
        super();
        int i = 0;
        this.mStorageRef = storageReference;
        this.mPendingResult = k2;
        this.mNewMetadata = storageMetadata3;
        final com.google.firebase.storage.FirebaseStorage obj7 = storageReference.getStorage();
        super(obj7.getApp().getApplicationContext(), obj7.getAuthProvider(), obj7.getAppCheckProvider(), obj7.getMaxOperationRetryTimeMillis(), obj5);
        this.mSender = obj8;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean resultSuccess;
        Object mResultMetadata;
        Object mStorageRef;
        UpdateMetadataNetworkRequest updateMetadataNetworkRequest = new UpdateMetadataNetworkRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), this.mNewMetadata.createJSONObject());
        this.mSender.sendWithExponentialBackoff(updateMetadataNetworkRequest);
        if (updateMetadataNetworkRequest.isResultSuccess()) {
            StorageMetadata.Builder builder = new StorageMetadata.Builder(updateMetadataNetworkRequest.getResultBody(), this.mStorageRef);
            this.mResultMetadata = builder.build();
        }
        k mPendingResult2 = this.mPendingResult;
        if (mPendingResult2 != null) {
            updateMetadataNetworkRequest.completeTask(mPendingResult2, this.mResultMetadata);
        }
    }
}
