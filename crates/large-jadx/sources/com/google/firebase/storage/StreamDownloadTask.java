package com.google.firebase.storage;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.ExponentialBackoffSender;
import com.google.firebase.storage.network.GetNetworkRequest;
import com.google.firebase.storage.network.NetworkRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class StreamDownloadTask extends com.google.firebase.storage.StorageTask<com.google.firebase.storage.StreamDownloadTask.TaskSnapshot> {

    static final long PREFERRED_CHUNK_SIZE = 262144L;
    private static final String TAG = "StreamDownloadTask";
    private long bytesDownloaded;
    private long bytesDownloadedSnapped;
    private String eTagVerification;
    private volatile Exception exception = null;
    private InputStream inputStream;
    private com.google.firebase.storage.StreamDownloadTask.StreamProcessor processor;
    private NetworkRequest request;
    private volatile int resultCode = 0;
    private ExponentialBackoffSender sender;
    private com.google.firebase.storage.StorageReference storageRef;
    private long totalBytes = -1;

    public interface StreamProcessor {
        public abstract void doInBackground(com.google.firebase.storage.StreamDownloadTask.TaskSnapshot streamDownloadTask$TaskSnapshot, InputStream inputStream2);
    }

    static class StreamProgressWrapper extends InputStream {

        private long mDownloadedBytes;
        private Callable<InputStream> mInputStreamCallable;
        private long mLastExceptionPosition;
        private com.google.firebase.storage.StreamDownloadTask mParentTask;
        private boolean mStreamClosed;
        private IOException mTemporaryException;
        private InputStream mWrappedStream;
        StreamProgressWrapper(Callable<InputStream> callable, com.google.firebase.storage.StreamDownloadTask streamDownloadTask2) {
            super();
            this.mParentTask = streamDownloadTask2;
            this.mInputStreamCallable = callable;
        }

        static boolean access$100(com.google.firebase.storage.StreamDownloadTask.StreamProgressWrapper streamDownloadTask$StreamProgressWrapper) {
            return streamProgressWrapper.ensureStream();
        }

        private void checkCancel() {
            com.google.firebase.storage.StreamDownloadTask internalState;
            int i;
            internalState = this.mParentTask;
            if (internalState != null) {
                if (internalState.getInternalState() == 32) {
                } else {
                }
                CancelException cancelException = new CancelException();
                throw cancelException;
            }
        }

        private boolean ensureStream() {
            IOException mTemporaryException2;
            Object mWrappedStream;
            long mDownloadedBytes;
            String str;
            IOException mTemporaryException;
            checkCancel();
            InputStream mWrappedStream2 = this.mWrappedStream;
            if (this.mTemporaryException != null && mWrappedStream2 != null) {
                mWrappedStream2 = this.mWrappedStream;
                if (mWrappedStream2 != null) {
                    mWrappedStream2.close();
                }
                mTemporaryException2 = 0;
                this.mWrappedStream = mTemporaryException2;
                str = "StreamDownloadTask";
                if (Long.compare(mLastExceptionPosition, mDownloadedBytes2) == 0) {
                    Log.i(str, "Encountered exception during stream operation. Aborting.", this.mTemporaryException);
                    return 0;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Encountered exception during stream operation. Retrying at ");
                stringBuilder.append(this.mDownloadedBytes);
                Log.i(str, stringBuilder.toString(), this.mTemporaryException);
                this.mLastExceptionPosition = this.mDownloadedBytes;
                this.mTemporaryException = mTemporaryException2;
            }
            if (this.mStreamClosed) {
            } else {
                try {
                    if (this.mWrappedStream == null) {
                    }
                    this.mWrappedStream = (InputStream)this.mInputStreamCallable.call();
                    mDownloadedBytes = th instanceof IOException;
                    if (mDownloadedBytes) {
                    }
                    throw (IOException)th;
                    mDownloadedBytes = new IOException("Unable to open stream", th);
                    throw mDownloadedBytes;
                    return 1;
                    IOException iOException = new IOException("Can't perform operation on closed stream");
                    throw iOException;
                } catch (Exception e) {
                }
            }
        }

        private void recordDownloadedBytes(long l) {
            com.google.firebase.storage.StreamDownloadTask mParentTask = this.mParentTask;
            if (mParentTask != null) {
                mParentTask.recordDownloadedBytes(l);
            }
            this.mDownloadedBytes = mDownloadedBytes += l;
        }

        @Override // java.io.InputStream
        public int available() {
            if (!ensureStream()) {
            } else {
                return this.mWrappedStream.available();
            }
            throw this.mTemporaryException;
        }

        @Override // java.io.InputStream
        public void close() {
            Object mParentTask;
            int i;
            InputStream mWrappedStream = this.mWrappedStream;
            if (mWrappedStream != null) {
                mWrappedStream.close();
            }
            this.mStreamClosed = true;
            mParentTask = this.mParentTask;
            if (mParentTask != null && StreamDownloadTask.access$200(mParentTask) != null) {
                if (StreamDownloadTask.access$200(mParentTask) != null) {
                    StreamDownloadTask.access$200(this.mParentTask).performRequestEnd();
                    StreamDownloadTask.access$202(this.mParentTask, 0);
                }
            }
            checkCancel();
        }

        @Override // java.io.InputStream
        public void mark(int i) {
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return 0;
        }

        @Override // java.io.InputStream
        public int read() {
            int i;
            if (!ensureStream()) {
            } else {
                int read = this.mWrappedStream.read();
                if (read != -1) {
                    recordDownloadedBytes(1);
                }
                return read;
            }
            throw this.mTemporaryException;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            int i5;
            Throwable cmp;
            boolean ensureStream;
            int i;
            int i4;
            int obj7;
            int obj8;
            i5 = 0;
            while (ensureStream()) {
                i = -1;
                while (Long.compare(l, i4) > 0) {
                    int read = this.mWrappedStream.read(bArr, obj7, 262144);
                    i5 += read;
                    obj7 += read;
                    obj8 -= read;
                    recordDownloadedBytes((long)read);
                    checkCancel();
                    i = -1;
                }
                int read2 = this.mWrappedStream.read(bArr, obj7, obj8);
                obj7 += read2;
                i5 += read2;
                obj8 -= read2;
                recordDownloadedBytes((long)read2);
                read = this.mWrappedStream.read(bArr, obj7, 262144);
                i5 += read;
                obj7 += read;
                obj8 -= read;
                recordDownloadedBytes((long)read);
                checkCancel();
            }
            throw this.mTemporaryException;
        }

        @Override // java.io.InputStream
        public long skip(long l) {
            int i;
            Throwable cmp;
            boolean ensureStream;
            int skip;
            int cmp2;
            int i2;
            int obj10;
            final int i3 = 0;
            i = i3;
            while (ensureStream()) {
                int i4 = 262144;
                i2 = -1;
                while (Long.compare(obj10, i4) > 0) {
                    ensureStream = this.mWrappedStream.skip(i4);
                    i += ensureStream;
                    obj10 -= ensureStream;
                    recordDownloadedBytes(ensureStream);
                    checkCancel();
                    i4 = 262144;
                    i2 = -1;
                }
                skip = this.mWrappedStream.skip(obj10);
                i += skip;
                obj10 -= skip;
                recordDownloadedBytes(skip);
                ensureStream = this.mWrappedStream.skip(i4);
                i += ensureStream;
                obj10 -= ensureStream;
                recordDownloadedBytes(ensureStream);
                checkCancel();
            }
            try {
                throw this.mTemporaryException;
            }
        }
    }

    public class TaskSnapshot extends com.google.firebase.storage.StorageTask.SnapshotBase<com.google.firebase.storage.StreamDownloadTask.TaskSnapshot> {

        private final long mBytesDownloaded;
        final com.google.firebase.storage.StreamDownloadTask this$0;
        TaskSnapshot(com.google.firebase.storage.StreamDownloadTask streamDownloadTask, Exception exception2, long l3) {
            this.this$0 = streamDownloadTask;
            super(streamDownloadTask, exception2);
            this.mBytesDownloaded = l3;
        }

        @Override // com.google.firebase.storage.StorageTask$SnapshotBase
        public long getBytesTransferred() {
            return this.mBytesDownloaded;
        }

        @Override // com.google.firebase.storage.StorageTask$SnapshotBase
        public InputStream getStream() {
            return StreamDownloadTask.access$300(this.this$0);
        }

        @Override // com.google.firebase.storage.StorageTask$SnapshotBase
        public long getTotalByteCount() {
            return this.this$0.getTotalBytes();
        }
    }
    StreamDownloadTask(com.google.firebase.storage.StorageReference storageReference) {
        super();
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        this.storageRef = storageReference;
        final com.google.firebase.storage.FirebaseStorage obj8 = storageReference.getStorage();
        super(obj8.getApp().getApplicationContext(), obj8.getAuthProvider(), obj8.getAppCheckProvider(), obj8.getMaxDownloadRetryTimeMillis(), obj5);
        this.sender = exponentialBackoffSender2;
    }

    static InputStream access$000(com.google.firebase.storage.StreamDownloadTask streamDownloadTask) {
        return streamDownloadTask.createDownloadStream();
    }

    static NetworkRequest access$200(com.google.firebase.storage.StreamDownloadTask streamDownloadTask) {
        return streamDownloadTask.request;
    }

    static NetworkRequest access$202(com.google.firebase.storage.StreamDownloadTask streamDownloadTask, NetworkRequest networkRequest2) {
        streamDownloadTask.request = networkRequest2;
        return networkRequest2;
    }

    static InputStream access$300(com.google.firebase.storage.StreamDownloadTask streamDownloadTask) {
        return streamDownloadTask.inputStream;
    }

    private InputStream createDownloadStream() {
        Exception exception;
        boolean validHttpResponseCode;
        ExponentialBackoffSender sender;
        boolean eTagVerification;
        int i;
        this.sender.reset();
        NetworkRequest request = this.request;
        if (request != null) {
            request.performRequestEnd();
        }
        GetNetworkRequest getNetworkRequest = new GetNetworkRequest(this.storageRef.getStorageReferenceUri(), this.storageRef.getApp(), this.bytesDownloaded, obj4);
        this.request = getNetworkRequest;
        this.sender.sendWithExponentialBackoff(getNetworkRequest, false);
        this.resultCode = this.request.getResultCode();
        if (this.request.getException() != null) {
            exception = this.request.getException();
        } else {
            exception = this.exception;
        }
        this.exception = exception;
        if (isValidHttpResponseCode(this.resultCode) && this.exception == null && getInternalState() == 4) {
            if (this.exception == null) {
                if (getInternalState() == 4) {
                    i = 1;
                }
            }
        }
        if (i == 0) {
        } else {
            String resultString = this.request.getResultString("ETag");
            eTagVerification = this.eTagVerification;
            if (!TextUtils.isEmpty(resultString) && eTagVerification != null) {
                eTagVerification = this.eTagVerification;
                if (eTagVerification != null) {
                    if (!eTagVerification.equals(resultString)) {
                    } else {
                    }
                    this.resultCode = 409;
                    IOException iOException = new IOException("The ETag on the server changed.");
                    throw iOException;
                }
            }
            this.eTagVerification = resultString;
            this.totalBytes = l += bytesDownloaded;
            return this.request.getStream();
        }
        IOException iOException2 = new IOException("Could not open resulting stream.");
        throw iOException2;
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

    @Override // com.google.firebase.storage.StorageTask
    com.google.firebase.storage.StorageReference getStorage() {
        return this.storageRef;
    }

    @Override // com.google.firebase.storage.StorageTask
    long getTotalBytes() {
        return this.totalBytes;
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void onCanceled() {
        this.sender.cancel();
        this.exception = StorageException.fromErrorStatus(Status.B);
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void onProgress() {
        this.bytesDownloadedSnapped = this.bytesDownloaded;
    }

    @Override // com.google.firebase.storage.StorageTask
    public boolean pause() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
        throw unsupportedOperationException;
    }

    @Override // com.google.firebase.storage.StorageTask
    void recordDownloadedBytes(long l) {
        int obj5;
        int obj6;
        bytesDownloaded += l;
        this.bytesDownloaded = i;
        if (Long.compare(obj5, i) <= 0) {
            obj6 = 4;
            if (getInternalState() == obj6) {
                tryChangeState(obj6, false);
            } else {
                this.bytesDownloadedSnapped = this.bytesDownloaded;
            }
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    public boolean resume() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
        throw unsupportedOperationException;
    }

    @Override // com.google.firebase.storage.StorageTask
    void run() {
        int str;
        int tryChangeState;
        int internalState;
        com.google.firebase.storage.StreamDownloadTask.StreamProcessor processor;
        InputStream inputStream;
        int i;
        Exception internalState2;
        Object bufferedInputStream;
        InputStream inputStream2;
        final int i2 = 0;
        if (this.exception != null) {
            tryChangeState(64, i2);
        }
        tryChangeState = 4;
        if (!tryChangeState(tryChangeState, i2)) {
        }
        StreamDownloadTask.1 anon = new StreamDownloadTask.1(this);
        StreamDownloadTask.StreamProgressWrapper streamProgressWrapper = new StreamDownloadTask.StreamProgressWrapper(anon, this);
        bufferedInputStream = new BufferedInputStream(streamProgressWrapper);
        this.inputStream = bufferedInputStream;
        StreamDownloadTask.StreamProgressWrapper.access$100(streamProgressWrapper);
        processor = this.processor;
        if (processor != null) {
            processor.doInBackground((StreamDownloadTask.TaskSnapshot)snapState(), this.inputStream);
        }
        if (this.inputStream == null) {
            this.request.performRequestEnd();
            this.request = 0;
        }
        if (this.exception == null && getInternalState() == tryChangeState) {
            i = getInternalState() == tryChangeState ? 1 : i2;
        } else {
        }
        if (i != 0) {
            tryChangeState(tryChangeState, i2);
            tryChangeState(128, i2);
        } else {
            if (getInternalState() == 32) {
                internalState = 256;
            }
            if (!tryChangeState(internalState, i2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to change download task to final state from ");
                stringBuilder.append(getInternalState());
                Log.w("StreamDownloadTask", stringBuilder.toString());
            }
        }
    }

    @Override // com.google.firebase.storage.StorageTask
    protected void schedule() {
        StorageTaskScheduler.getInstance().scheduleDownload(getRunnable());
    }

    @Override // com.google.firebase.storage.StorageTask
    com.google.firebase.storage.StreamDownloadTask setStreamProcessor(com.google.firebase.storage.StreamDownloadTask.StreamProcessor streamDownloadTask$StreamProcessor) {
        int i;
        r.j(streamProcessor);
        i = this.processor == null ? 1 : 0;
        r.m(i);
        this.processor = streamProcessor;
        return this;
    }

    @Override // com.google.firebase.storage.StorageTask
    com.google.firebase.storage.StorageTask.ProvideError snapStateImpl() {
        return snapStateImpl();
    }

    @Override // com.google.firebase.storage.StorageTask
    com.google.firebase.storage.StreamDownloadTask.TaskSnapshot snapStateImpl() {
        StreamDownloadTask.TaskSnapshot taskSnapshot = new StreamDownloadTask.TaskSnapshot(this, StorageException.fromExceptionAndHttpCode(this.exception, this.resultCode), this.bytesDownloadedSnapped, obj3);
        return taskSnapshot;
    }
}
