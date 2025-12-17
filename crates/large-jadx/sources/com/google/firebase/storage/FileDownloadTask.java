package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class FileDownloadTask extends com.google.firebase.storage.StorageTask<com.google.firebase.storage.FileDownloadTask.TaskSnapshot> {

    static final int PREFERRED_CHUNK_SIZE = 262144;
    private static final String TAG = "FileDownloadTask";
    private long mBytesDownloaded;
    private final Uri mDestinationFile;
    private String mETagVerification = null;
    private volatile Exception mException = null;
    private int mResultCode;
    private long mResumeOffset = 0;
    private ExponentialBackoffSender mSender;
    private com.google.firebase.storage.StorageReference mStorageRef;
    private long mTotalBytes = -1;

    public class TaskSnapshot extends com.google.firebase.storage.StorageTask.SnapshotBase<com.google.firebase.storage.FileDownloadTask.TaskSnapshot> {

        private final long mBytesDownloaded;
        final com.google.firebase.storage.FileDownloadTask this$0;
        TaskSnapshot(com.google.firebase.storage.FileDownloadTask fileDownloadTask, Exception exception2, long l3) {
            this.this$0 = fileDownloadTask;
            super(fileDownloadTask, exception2);
            this.mBytesDownloaded = l3;
        }

        @Override // com.google.firebase.storage.StorageTask$SnapshotBase
        public long getBytesTransferred() {
            return this.mBytesDownloaded;
        }

        @Override // com.google.firebase.storage.StorageTask$SnapshotBase
        public long getTotalByteCount() {
            return this.this$0.getTotalBytes();
        }
    }
    FileDownloadTask(com.google.firebase.storage.StorageReference storageReference, Uri uri2) {
        super();
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        this.mStorageRef = storageReference;
        this.mDestinationFile = uri2;
        final com.google.firebase.storage.FirebaseStorage obj7 = storageReference.getStorage();
        super(obj7.getApp().getApplicationContext(), obj7.getAuthProvider(), obj7.getAppCheckProvider(), obj7.getMaxDownloadRetryTimeMillis(), obj5);
        this.mSender = obj8;
    }

    private int fillBuffer(InputStream inputStream, byte[] b2Arr2) {
        int i3;
        int i;
        int i2;
        int length;
        Throwable obj5;
        i = i3;
        i2 = -1;
        while (i3 != b2Arr2.length) {
            length = inputStream.read(b2Arr2, i3, length2 -= i3);
            if (length != i2) {
            }
            i = 1;
            i3 += length;
            i2 = -1;
        }
        if (i != 0) {
        } else {
            i3 = i2;
        }
        return i3;
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

    private boolean processResponse(NetworkRequest networkRequest) {
        int i2;
        byte[] bArr;
        boolean newFile;
        FileOutputStream fileOutputStream;
        int i;
        String tryChangeState;
        Exception mException;
        String str;
        long mResumeOffset;
        long l;
        Object obj11;
        obj11 = networkRequest.getStream();
        i2 = 0;
        if (obj11 != null) {
            File file = new File(this.mDestinationFile.getPath());
            int i4 = 0;
            str = "FileDownloadTask";
            if (file.exists() == null) {
                if (Long.compare(mResumeOffset, i4) > 0) {
                } else {
                    if (file.createNewFile() == null) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("unable to create file:");
                        stringBuilder2.append(file.getAbsolutePath());
                        Log.w(str, stringBuilder2.toString());
                    }
                }
                obj11 = new IOException("The file to download to has been deleted.");
                throw obj11;
            }
            if (Long.compare(mResumeOffset, i4) > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Resuming download file ");
                stringBuilder.append(file.getAbsolutePath());
                stringBuilder.append(" at ");
                stringBuilder.append(this.mResumeOffset);
                Log.d(str, stringBuilder.toString());
                fileOutputStream = new FileOutputStream(file, 1);
            } else {
                fileOutputStream = new FileOutputStream(file);
            }
            bArr = new byte[262144];
            while (i != 0) {
                tryChangeState = fillBuffer(obj11, bArr);
                if (tryChangeState != -1) {
                }
                fileOutputStream.write(bArr, i2, tryChangeState);
                this.mBytesDownloaded = mBytesDownloaded += l;
                if (this.mException != null) {
                }
                if (tryChangeState(4, i2) == null) {
                }
                i = i2;
                Log.d(str, "Exception occurred during file download. Retrying.", this.mException);
                this.mException = 0;
                i = i2;
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            obj11.close();
            i2 = i;
        } else {
            obj11 = new IllegalStateException("Unable to open Firebase Storage stream.");
            this.mException = obj11;
        }
        return i2;
    }

    @Override // com.google.firebase.storage.StorageTask
    long getDownloadedSizeInBytes() {
        return this.mBytesDownloaded;
    }

    @Override // com.google.firebase.storage.StorageTask
    com.google.firebase.storage.StorageReference getStorage() {
        return this.mStorageRef;
    }

    @Override // com.google.firebase.storage.StorageTask
    long getTotalBytes() {
        return this.mTotalBytes;
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void onCanceled() {
        this.mSender.cancel();
        this.mException = StorageException.fromErrorStatus(Status.B);
    }

    @Override // com.google.firebase.storage.StorageTask
    void run() {
        boolean tryChangeState;
        int internalState;
        boolean tryChangeState2;
        Throwable mBytesDownloaded;
        int internalState2;
        File length;
        int i;
        int response;
        Exception mException;
        boolean validHttpResponseCode;
        int i2;
        String str;
        String resultString;
        boolean mETagVerification;
        long mResumeOffset;
        internalState = 64;
        final int i7 = 0;
        if (this.mException != null) {
            tryChangeState(internalState, i7);
        }
        int i3 = 4;
        if (!tryChangeState(i3, i7)) {
        }
        int i8 = 0;
        this.mBytesDownloaded = i8;
        internalState2 = 0;
        this.mException = internalState2;
        this.mSender.reset();
        GetNetworkRequest getNetworkRequest = new GetNetworkRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), this.mResumeOffset, resultString);
        this.mSender.sendWithExponentialBackoff(getNetworkRequest, i7);
        this.mResultCode = getNetworkRequest.getResultCode();
        while (getNetworkRequest.getException() != null) {
            mException = getNetworkRequest.getException();
            this.mException = mException;
            if (isValidHttpResponseCode(this.mResultCode) && this.mException == null && getInternalState() == i3) {
            } else {
            }
            response = i7;
            str = "FileDownloadTask";
            getNetworkRequest.performRequestEnd();
            if (response != null && this.mException == null && getInternalState() == i3) {
            } else {
            }
            i2 = i7;
            length = new File(this.mDestinationFile.getPath());
            if (length.exists()) {
            } else {
            }
            this.mResumeOffset = i8;
            i8 = 0;
            this.mBytesDownloaded = i8;
            internalState2 = 0;
            this.mException = internalState2;
            this.mSender.reset();
            getNetworkRequest = new GetNetworkRequest(this.mStorageRef.getStorageReferenceUri(), this.mStorageRef.getApp(), this.mResumeOffset, resultString);
            this.mSender.sendWithExponentialBackoff(getNetworkRequest, i7);
            this.mResultCode = getNetworkRequest.getResultCode();
            mException = this.mException;
            this.mResumeOffset = length.length();
            if (this.mException == null) {
            } else {
            }
            if (getInternalState() == i3) {
            } else {
            }
            this.mTotalBytes = l += mResumeOffset;
            resultString = getNetworkRequest.getResultString("ETag");
            this.mETagVerification = resultString;
            response = processResponse(getNetworkRequest);
            mETagVerification = this.mETagVerification;
            if (this.mException == null) {
            } else {
            }
            if (getInternalState() == i3) {
            } else {
            }
            response = i2;
            Log.e(obj9, "Exception occurred during file write.  Aborting.", mBytesDownloaded);
            this.mException = mBytesDownloaded;
        }
        Log.w(str, "The file at the server has changed.  Restarting from the beginning.");
        this.mResumeOffset = i8;
        this.mETagVerification = internalState2;
        getNetworkRequest.performRequestEnd();
        schedule();
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void schedule() {
        StorageTaskScheduler.getInstance().scheduleDownload(getRunnable());
    }

    @Override // com.google.firebase.storage.StorageTask
    com.google.firebase.storage.FileDownloadTask.TaskSnapshot snapStateImpl() {
        FileDownloadTask.TaskSnapshot taskSnapshot = new FileDownloadTask.TaskSnapshot(this, StorageException.fromExceptionAndHttpCode(this.mException, this.mResultCode), mBytesDownloaded += mResumeOffset, obj3);
        return taskSnapshot;
    }

    @Override // com.google.firebase.storage.StorageTask
    com.google.firebase.storage.StorageTask.ProvideError snapStateImpl() {
        return snapStateImpl();
    }
}
