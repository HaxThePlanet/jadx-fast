package com.google.firebase.storage.network;

import android.net.Uri;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.StorageReferenceUri;

/* loaded from: classes2.dex */
public class ResumableUploadByteRequest extends com.google.firebase.storage.network.ResumableNetworkRequest {

    private final int bytesToWrite;
    private final byte[] chunk = null;
    private final boolean isFinal;
    private final long offset;
    private final Uri uploadURL;
    public ResumableUploadByteRequest(StorageReferenceUri storageReferenceUri, FirebaseApp firebaseApp2, Uri uri3, byte[] b4Arr4, long l5, int i6, boolean z7) {
        StorageReferenceUri obj1;
        Object obj2;
        super(storageReferenceUri, firebaseApp2);
        if (b4Arr4 == null && z7 != -1) {
            if (z7 != -1) {
                obj1 = new IllegalArgumentException("contentType is null or empty");
                this.mException = obj1;
            }
        }
        if (Long.compare(l5, obj1) < 0) {
            obj1 = new IllegalArgumentException("offset cannot be negative");
            this.mException = obj1;
        }
        this.bytesToWrite = z7;
        this.uploadURL = uri3;
        final int obj4 = 0;
        this.offset = l5;
        this.isFinal = obj8;
        super.setCustomHeader("X-Goog-Upload-Protocol", "resumable");
        obj1 = "X-Goog-Upload-Command";
        if (obj8 != null && z7 > 0) {
            if (z7 > 0) {
                super.setCustomHeader(obj1, "upload, finalize");
            } else {
                if (obj8 != null) {
                    super.setCustomHeader(obj1, "finalize");
                } else {
                    super.setCustomHeader(obj1, "upload");
                }
            }
        } else {
        }
        super.setCustomHeader("X-Goog-Upload-Offset", Long.toString(l5));
    }

    @Override // com.google.firebase.storage.network.ResumableNetworkRequest
    protected String getAction() {
        return "POST";
    }

    @Override // com.google.firebase.storage.network.ResumableNetworkRequest
    protected byte[] getOutputRaw() {
        return this.chunk;
    }

    @Override // com.google.firebase.storage.network.ResumableNetworkRequest
    protected int getOutputRawSize() {
        int bytesToWrite;
        if (this.bytesToWrite > 0) {
        } else {
            bytesToWrite = 0;
        }
        return bytesToWrite;
    }

    @Override // com.google.firebase.storage.network.ResumableNetworkRequest
    public Uri getURL() {
        return this.uploadURL;
    }
}
