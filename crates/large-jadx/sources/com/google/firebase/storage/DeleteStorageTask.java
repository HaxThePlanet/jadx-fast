package com.google.firebase.storage;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.DeleteNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;

/* loaded from: classes2.dex */
class DeleteStorageTask implements Runnable {

    private static final String TAG = "DeleteStorageTask";
    private k<Void> mPendingResult;
    private ExponentialBackoffSender mSender;
    private com.google.firebase.storage.StorageReference mStorageRef;
    public DeleteStorageTask(com.google.firebase.storage.StorageReference storageReference, k<Void> k2) {
        super();
        r.j(storageReference);
        r.j(k2);
        this.mStorageRef = storageReference;
        this.mPendingResult = k2;
        final com.google.firebase.storage.FirebaseStorage obj7 = storageReference.getStorage();
        super(obj7.getApp().getApplicationContext(), obj7.getAuthProvider(), obj7.getAppCheckProvider(), obj7.getMaxDownloadRetryTimeMillis(), obj5);
        this.mSender = obj8;
    }

    @Override // java.lang.Runnable
    public void run() {
        DeleteNetworkRequest deleteNetworkRequest = new DeleteNetworkRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp());
        this.mSender.sendWithExponentialBackoff(deleteNetworkRequest);
        deleteNetworkRequest.completeTask(this.mPendingResult, 0);
    }
}
