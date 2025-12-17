package com.google.firebase.storage;

import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.ListNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;

/* loaded from: classes2.dex */
class ListTask implements Runnable {

    private static final String TAG = "ListTask";
    private final Integer maxResults;
    private final String pageToken;
    private final k<com.google.firebase.storage.ListResult> pendingResult;
    private final ExponentialBackoffSender sender;
    private final com.google.firebase.storage.StorageReference storageRef;
    ListTask(com.google.firebase.storage.StorageReference storageReference, Integer integer2, String string3, k<com.google.firebase.storage.ListResult> k4) {
        super();
        r.j(storageReference);
        r.j(k4);
        this.storageRef = storageReference;
        this.maxResults = integer2;
        this.pageToken = string3;
        this.pendingResult = k4;
        final com.google.firebase.storage.FirebaseStorage obj7 = storageReference.getStorage();
        super(obj7.getApp().getApplicationContext(), obj7.getAuthProvider(), obj7.getAppCheckProvider(), obj7.getMaxDownloadRetryTimeMillis(), obj5);
        this.sender = obj8;
    }

    @Override // java.lang.Runnable
    public void run() {
        int jSON;
        Object resultBody;
        ListNetworkRequest listNetworkRequest = new ListNetworkRequest(this.storageRef.getStorageReferenceUri(), this.storageRef.getApp(), this.maxResults, this.pageToken);
        this.sender.sendWithExponentialBackoff(listNetworkRequest);
        if (listNetworkRequest.isResultSuccess()) {
            jSON = ListResult.fromJSON(this.storageRef.getStorage(), listNetworkRequest.getResultBody());
        } else {
            jSON = 0;
        }
        k pendingResult2 = this.pendingResult;
        if (pendingResult2 != null) {
            listNetworkRequest.completeTask(pendingResult2, jSON);
        }
    }
}
