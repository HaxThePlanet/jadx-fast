package com.google.firebase.storage;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.storage.internal.AdaptiveStreamBuffer;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.internal.Util;
import com.google.firebase.storage.network.NetworkRequest;
import com.google.firebase.storage.network.ResumableUploadByteRequest;
import com.google.firebase.storage.network.ResumableUploadCancelRequest;
import com.google.firebase.storage.network.ResumableUploadQueryRequest;
import com.google.firebase.storage.network.ResumableUploadStartRequest;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class UploadTask extends com.google.firebase.storage.StorageTask<com.google.firebase.storage.UploadTask.TaskSnapshot> {

    private static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    private static final int MAXIMUM_CHUNK_SIZE = 33554432;
    static final int PREFERRED_CHUNK_SIZE = 262144;
    private static final String RESUMABLE_FINAL_STATUS = "final";
    private static final String TAG = "UploadTask";
    private static final String X_GOOG_UPLOAD_URL = "X-Goog-Upload-URL";
    private final InternalAppCheckTokenProvider mAppCheckProvider;
    private final InternalAuthProvider mAuthProvider;
    private final AtomicLong mBytesUploaded;
    private int mCurrentChunkSize = 262144;
    private volatile Exception mException = null;
    private boolean mIsStreamOwned;
    private volatile com.google.firebase.storage.StorageMetadata mMetadata;
    private volatile int mResultCode = 0;
    private ExponentialBackoffSender mSender;
    private volatile Exception mServerException = null;
    private volatile String mServerStatus;
    private final com.google.firebase.storage.StorageReference mStorageRef;
    private final AdaptiveStreamBuffer mStreamBuffer;
    private final long mTotalByteCount;
    private volatile Uri mUploadUri = null;
    private final Uri mUri;

    public class TaskSnapshot extends com.google.firebase.storage.StorageTask.SnapshotBase<com.google.firebase.storage.UploadTask.TaskSnapshot> {

        private final long mBytesUploaded;
        private final com.google.firebase.storage.StorageMetadata mMetadata;
        private final Uri mUploadUri;
        final com.google.firebase.storage.UploadTask this$0;
        TaskSnapshot(com.google.firebase.storage.UploadTask uploadTask, Exception exception2, long l3, Uri uri4, com.google.firebase.storage.StorageMetadata storageMetadata5) {
            this.this$0 = uploadTask;
            super(uploadTask, exception2);
            this.mBytesUploaded = l3;
            this.mUploadUri = storageMetadata5;
            this.mMetadata = obj6;
        }

        @Override // com.google.firebase.storage.StorageTask$SnapshotBase
        public long getBytesTransferred() {
            return this.mBytesUploaded;
        }

        @Override // com.google.firebase.storage.StorageTask$SnapshotBase
        public com.google.firebase.storage.StorageMetadata getMetadata() {
            return this.mMetadata;
        }

        @Override // com.google.firebase.storage.StorageTask$SnapshotBase
        public long getTotalByteCount() {
            return this.this$0.getTotalByteCount();
        }

        @Override // com.google.firebase.storage.StorageTask$SnapshotBase
        public Uri getUploadSessionUri() {
            return this.mUploadUri;
        }
    }
    UploadTask(com.google.firebase.storage.StorageReference storageReference, com.google.firebase.storage.StorageMetadata storageMetadata2, Uri uri3, Uri uri4) {
        Object inputStream;
        Object obj;
        int i;
        Object obj2;
        long statSize;
        Context applicationContext;
        InternalAppCheckTokenProvider appCheckProvider;
        Object obj11;
        ParcelFileDescriptor obj12;
        Object obj13;
        final String str = "UploadTask";
        super();
        AtomicLong atomicLong = new AtomicLong(0, obj);
        this.mBytesUploaded = atomicLong;
        int i4 = 0;
        int i5 = 0;
        r.j(storageReference);
        r.j(uri3);
        com.google.firebase.storage.FirebaseStorage storage = storageReference.getStorage();
        this.mStorageRef = storageReference;
        this.mMetadata = storageMetadata2;
        final InternalAuthProvider authProvider = storage.getAuthProvider();
        this.mAuthProvider = authProvider;
        appCheckProvider = storage.getAppCheckProvider();
        this.mAppCheckProvider = appCheckProvider;
        this.mUri = uri3;
        super(storageReference.getApp().getApplicationContext(), authProvider, appCheckProvider, storage.getMaxUploadRetryTimeMillis(), obj9);
        this.mSender = obj12;
        i = -1;
        obj11 = storageReference.getStorage().getApp().getApplicationContext().getContentResolver();
        obj12 = obj11.openFileDescriptor(uri3, "r");
        if (obj12 != null) {
            statSize = obj12.getStatSize();
            obj12.close();
        } else {
            statSize = i;
        }
        inputStream = obj11.openInputStream(this.mUri);
        obj11 = inputStream.available();
        if (inputStream != null && Long.compare(statSize, i) == 0 && obj11 >= 0) {
            if (Long.compare(statSize, i) == 0) {
                obj11 = inputStream.available();
                statSize = obj11 >= 0 ? (long)obj11 : statSize;
            }
            i = statSize;
            obj11 = new BufferedInputStream(inputStream);
            inputStream = obj11;
            statSize = i;
        }
        this.mTotalByteCount = statSize;
        obj11 = new AdaptiveStreamBuffer(inputStream, 262144);
        this.mStreamBuffer = obj11;
        this.mIsStreamOwned = true;
        this.mUploadUri = uri4;
    }

    UploadTask(com.google.firebase.storage.StorageReference storageReference, com.google.firebase.storage.StorageMetadata storageMetadata2, InputStream inputStream3) {
        super();
        AtomicLong atomicLong = new AtomicLong(0, obj2);
        this.mBytesUploaded = atomicLong;
        r.j(storageReference);
        r.j(inputStream3);
        final com.google.firebase.storage.FirebaseStorage storage = storageReference.getStorage();
        this.mTotalByteCount = -1;
        this.mStorageRef = storageReference;
        this.mMetadata = storageMetadata2;
        final InternalAuthProvider authProvider = storage.getAuthProvider();
        this.mAuthProvider = authProvider;
        final InternalAppCheckTokenProvider appCheckProvider = storage.getAppCheckProvider();
        this.mAppCheckProvider = appCheckProvider;
        AdaptiveStreamBuffer obj14 = new AdaptiveStreamBuffer(inputStream3, 262144);
        this.mStreamBuffer = obj14;
        this.mIsStreamOwned = false;
        this.mUri = 0;
        super(storageReference.getApp().getApplicationContext(), authProvider, appCheckProvider, storageReference.getStorage().getMaxUploadRetryTimeMillis(), obj11);
        this.mSender = obj14;
    }

    UploadTask(com.google.firebase.storage.StorageReference storageReference, com.google.firebase.storage.StorageMetadata storageMetadata2, byte[] b3Arr3) {
        super();
        AtomicLong atomicLong = new AtomicLong(0, obj2);
        this.mBytesUploaded = atomicLong;
        int i4 = 0;
        r.j(storageReference);
        r.j(b3Arr3);
        com.google.firebase.storage.FirebaseStorage storage = storageReference.getStorage();
        this.mTotalByteCount = (long)length;
        this.mStorageRef = storageReference;
        this.mMetadata = storageMetadata2;
        final InternalAuthProvider authProvider = storage.getAuthProvider();
        this.mAuthProvider = authProvider;
        final InternalAppCheckTokenProvider appCheckProvider = storage.getAppCheckProvider();
        this.mAppCheckProvider = appCheckProvider;
        this.mUri = 0;
        ByteArrayInputStream obj13 = new ByteArrayInputStream(b3Arr3);
        AdaptiveStreamBuffer obj12 = new AdaptiveStreamBuffer(obj13, 262144);
        this.mStreamBuffer = obj12;
        this.mIsStreamOwned = true;
        super(storage.getApp().getApplicationContext(), authProvider, appCheckProvider, storage.getMaxDownloadRetryTimeMillis(), obj10);
        this.mSender = obj12;
    }

    static InternalAuthProvider access$000(com.google.firebase.storage.UploadTask uploadTask) {
        return uploadTask.mAuthProvider;
    }

    static InternalAppCheckTokenProvider access$100(com.google.firebase.storage.UploadTask uploadTask) {
        return uploadTask.mAppCheckProvider;
    }

    static com.google.firebase.storage.StorageReference access$200(com.google.firebase.storage.UploadTask uploadTask) {
        return uploadTask.mStorageRef;
    }

    private void beginResumableUpload() {
        String contentType;
        Object resultString;
        int jSONObject;
        Uri mUri;
        if (this.mMetadata != null) {
            contentType = this.mMetadata.getContentType();
        } else {
            contentType = jSONObject;
        }
        if (this.mUri != null && TextUtils.isEmpty(contentType)) {
            if (TextUtils.isEmpty(contentType)) {
                contentType = this.mStorageRef.getStorage().getApp().getApplicationContext().getContentResolver().getType(this.mUri);
            }
        }
        if (TextUtils.isEmpty(contentType)) {
            contentType = "application/octet-stream";
        }
        if (this.mMetadata != null) {
            jSONObject = this.mMetadata.createJSONObject();
        }
        ResumableUploadStartRequest resumableUploadStartRequest = new ResumableUploadStartRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), jSONObject, contentType);
        if (!sendWithRetry(resumableUploadStartRequest)) {
        }
        resultString = resumableUploadStartRequest.getResultString("X-Goog-Upload-URL");
        if (!TextUtils.isEmpty(resultString)) {
            this.mUploadUri = Uri.parse(resultString);
        }
    }

    private boolean isValidHttpResponseCode(int i) {
        int i2;
        int obj2;
        if (i != 308) {
            if (i >= 200 && i < 300) {
                if (i < 300) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    private boolean processResultValid(NetworkRequest networkRequest) {
        int resultCode;
        boolean obj3;
        if (this.mSender.isRetryableError(networkRequest.getResultCode())) {
            resultCode = -2;
        }
        this.mResultCode = resultCode;
        this.mServerException = networkRequest.getException();
        this.mServerStatus = networkRequest.getResultString("X-Goog-Upload-Status");
        if (isValidHttpResponseCode(this.mResultCode) && this.mServerException == null) {
            obj3 = this.mServerException == null ? 1 : 0;
        } else {
        }
        return obj3;
    }

    private boolean recoverStatus(boolean z) {
        int long;
        String str;
        int i;
        long l;
        boolean obj12;
        ResumableUploadQueryRequest resumableUploadQueryRequest = new ResumableUploadQueryRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), this.mUploadUri);
        str = "final";
        boolean equals = str.equals(this.mServerStatus);
        int i2 = 0;
        if (equals) {
            return i2;
        }
        if (z != null) {
            if (!sendWithRetry(resumableUploadQueryRequest)) {
                return i2;
            }
        } else {
            if (!send(resumableUploadQueryRequest)) {
                return i2;
            }
        }
        if (str.equals(resumableUploadQueryRequest.getResultString("X-Goog-Upload-Status"))) {
            obj12 = new IOException("The server has terminated the upload session");
            this.mException = obj12;
            return i2;
        }
        obj12 = resumableUploadQueryRequest.getResultString("X-Goog-Upload-Size-Received");
        if (!TextUtils.isEmpty(obj12)) {
            long = Long.parseLong(obj12);
        } else {
            long = 0;
        }
        final long l2 = this.mBytesUploaded.get();
        obj12 = Long.compare(l2, long);
        if (obj12 > 0) {
            obj12 = new IOException("Unexpected error. The server lost a chunk update.");
            this.mException = obj12;
            return i2;
        }
        i = long - l2;
        if (obj12 < 0 && Long.compare(l, i) != 0) {
            i = long - l2;
            if (Long.compare(l, i) != 0) {
                obj12 = new IOException("Unexpected end of stream encountered.");
                this.mException = obj12;
                return i2;
            }
            if (!this.mBytesUploaded.compareAndSet(l2, obj6)) {
                Log.e("UploadTask", "Somehow, the uploaded bytes changed during an uploaded.  This should nothappen");
                obj12 = new IllegalStateException("uploaded bytes changed unexpectedly.");
                this.mException = obj12;
                return i2;
            }
        }
        return 1;
    }

    private boolean send(NetworkRequest networkRequest) {
        networkRequest.performRequest(Util.getCurrentAuthToken(this.mAuthProvider), Util.getCurrentAppCheckToken(this.mAppCheckProvider), this.mStorageRef.getApp().getApplicationContext());
        return processResultValid(networkRequest);
    }

    private boolean sendWithRetry(NetworkRequest networkRequest) {
        this.mSender.sendWithExponentialBackoff(networkRequest);
        return processResultValid(networkRequest);
    }

    private boolean serverStateValid() {
        Object iOException;
        Object mServerException;
        String str;
        if ("final".equals(this.mServerStatus) && this.mException == null) {
            if (this.mException == null) {
                iOException = new IOException("The server has terminated the upload session", this.mServerException);
                this.mException = iOException;
            }
            int i3 = 0;
            tryChangeState(64, i3);
            return i3;
        }
        return 1;
    }

    private boolean shouldContinue() {
        Object illegalStateException;
        int recoverStatus;
        Exception mServerException;
        int str;
        int i;
        final int i4 = 0;
        if (getInternalState() == 128) {
            return i4;
        }
        int i6 = 64;
        if (Thread.interrupted()) {
            InterruptedException interruptedException = new InterruptedException();
            this.mException = interruptedException;
            tryChangeState(i6, i4);
            return i4;
        }
        if (getInternalState() == 32) {
            tryChangeState(256, i4);
            return i4;
        }
        if (getInternalState() == 8) {
            tryChangeState(16, i4);
            return i4;
        }
        if (!serverStateValid()) {
            return i4;
        }
        if (this.mUploadUri == null && this.mException == null) {
            if (this.mException == null) {
                illegalStateException = new IllegalStateException("Unable to obtain an upload URL.");
                this.mException = illegalStateException;
            }
            tryChangeState(i6, i4);
            return i4;
        }
        if (this.mException != null) {
            tryChangeState(i6, i4);
            return i4;
        }
        int i8 = 1;
        if (this.mServerException == null && this.mResultCode >= 200) {
            if (this.mResultCode >= 200) {
                if (this.mResultCode >= 300) {
                    recoverStatus = i8;
                } else {
                    recoverStatus = i4;
                }
            } else {
            }
        } else {
        }
        if (recoverStatus != 0 && !recoverStatus(i8) && serverStateValid()) {
            if (!recoverStatus(i8)) {
                if (serverStateValid()) {
                    tryChangeState(i6, i4);
                }
                return i4;
            }
        }
        return i8;
    }

    private void uploadChunk() {
        int mCurrentChunkSize;
        int mCurrentChunkSize2;
        org.json.JSONObject resultBody;
        com.google.firebase.storage.StorageReference mStorageRef;
        final String str = "UploadTask";
        this.mStreamBuffer.fill(this.mCurrentChunkSize);
        int i = Math.min(this.mCurrentChunkSize, this.mStreamBuffer.available());
        final FirebaseApp app = this.mStorageRef.getApp();
        super(this.mStorageRef.getStorageReferenceUri(), app, this.mUploadUri, this.mStreamBuffer.get(), this.mBytesUploaded.get(), obj9, i, this.mStreamBuffer.isFinished());
        if (!send(resumableUploadByteRequest)) {
            this.mCurrentChunkSize = 262144;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Resetting chunk size to ");
            stringBuilder.append(this.mCurrentChunkSize);
            Log.d(str, stringBuilder.toString());
        }
        try {
            this.mBytesUploaded.getAndAdd((long)i);
            if (!this.mStreamBuffer.isFinished()) {
            } else {
            }
            this.mStreamBuffer.advance(i);
            mCurrentChunkSize = this.mCurrentChunkSize;
            if (mCurrentChunkSize < 33554432) {
            }
            this.mCurrentChunkSize = mCurrentChunkSize *= 2;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Increasing chunk size to ");
            stringBuilder2.append(this.mCurrentChunkSize);
            Log.d(str, stringBuilder2.toString());
            StorageMetadata.Builder builder = new StorageMetadata.Builder(resumableUploadByteRequest.getResultBody(), this.mStorageRef);
            this.mMetadata = builder.build();
            mCurrentChunkSize2 = 0;
            tryChangeState(4, mCurrentChunkSize2);
            tryChangeState(128, mCurrentChunkSize2);
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Unable to parse resulting metadata from upload:");
            String str2 = str2.getRawResult();
            stringBuilder3.append(str2);
            str2 = stringBuilder3.toString();
            Log.e(obj0, str2, th);
            this.mException = th;
            str2 = "Unable to read bytes for uploading";
            Log.e(obj0, str2, th);
            this.mException = th;
        } catch (org.json.JSONException jSON) {
        } catch (java.io.IOException ioException1) {
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    com.google.firebase.storage.StorageReference getStorage() {
        return this.mStorageRef;
    }

    @Override // com.google.firebase.storage.StorageTask
    long getTotalByteCount() {
        return this.mTotalByteCount;
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void onCanceled() {
        ResumableUploadCancelRequest resumableUploadCancelRequest;
        com.google.firebase.storage.internal.StorageReferenceUri storageReferenceUri;
        FirebaseApp anon;
        Uri mUploadUri;
        this.mSender.cancel();
        if (this.mUploadUri != null) {
            resumableUploadCancelRequest = new ResumableUploadCancelRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), this.mUploadUri);
        } else {
            resumableUploadCancelRequest = 0;
        }
        if (resumableUploadCancelRequest != null) {
            anon = new UploadTask.1(this, resumableUploadCancelRequest);
            StorageTaskScheduler.getInstance().scheduleCommand(anon);
        }
        this.mException = StorageException.fromErrorStatus(Status.B);
        super.onCanceled();
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void resetState() {
        final int i = 0;
        this.mException = i;
        this.mServerException = i;
        this.mResultCode = 0;
        this.mServerStatus = i;
    }

    @Override // com.google.firebase.storage.StorageTask
    void run() {
        boolean mIsStreamOwned;
        int i;
        Object illegalArgumentException;
        boolean continue;
        String str;
        this.mSender.reset();
        int i2 = 4;
        i = 0;
        if (!tryChangeState(i2, i)) {
            Log.d("UploadTask", "The upload cannot continue as it is not in a valid state.");
        }
        if (this.mStorageRef.getParent() == null) {
            illegalArgumentException = new IllegalArgumentException("Cannot upload to getRoot. You should upload to a storage location such as .getReference('image.png').putFile...");
            this.mException = illegalArgumentException;
        }
        if (this.mException != null) {
        }
        if (this.mUploadUri == null) {
            beginResumableUpload();
        } else {
            recoverStatus(i);
        }
        continue = shouldContinue();
        while (continue) {
            uploadChunk();
            if (shouldContinue()) {
            }
            tryChangeState(i2, i);
        }
        if (this.mIsStreamOwned && getInternalState() != 16) {
            if (getInternalState() != 16) {
                this.mStreamBuffer.close();
            }
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void schedule() {
        StorageTaskScheduler.getInstance().scheduleUpload(getRunnable());
    }

    @Override // com.google.firebase.storage.StorageTask
    com.google.firebase.storage.StorageTask.ProvideError snapStateImpl() {
        return snapStateImpl();
    }

    @Override // com.google.firebase.storage.StorageTask
    com.google.firebase.storage.UploadTask.TaskSnapshot snapStateImpl() {
        Exception mServerException;
        mServerException = this.mException != null ? this.mException : this.mServerException;
        super(this, StorageException.fromExceptionAndHttpCode(mServerException, this.mResultCode), this.mBytesUploaded.get(), obj5, this.mUploadUri, this.mMetadata);
        return taskSnapshot;
    }
}
