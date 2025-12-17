package com.google.firebase.firestore;

import com.google.firebase.firestore.bundle.BundleMetadata;

/* loaded from: classes2.dex */
public final class LoadBundleTaskProgress {

    static final com.google.firebase.firestore.LoadBundleTaskProgress INITIAL;
    private final long bytesLoaded;
    private final int documentsLoaded;
    private final Exception exception;
    private final com.google.firebase.firestore.LoadBundleTaskProgress.TaskState taskState;
    private final long totalBytes;
    private final int totalDocuments;

    public static enum TaskState {

        ERROR,
        RUNNING,
        SUCCESS;
    }
    static {
        super(0, 0, 0, obj4, 0, obj6, 0, LoadBundleTaskProgress.TaskState.SUCCESS);
        LoadBundleTaskProgress.INITIAL = loadBundleTaskProgress;
    }

    public LoadBundleTaskProgress(int i, int i2, long l3, long l4, Exception exception5, com.google.firebase.firestore.LoadBundleTaskProgress.TaskState loadBundleTaskProgress$TaskState6) {
        super();
        this.documentsLoaded = i;
        this.totalDocuments = i2;
        this.bytesLoaded = l3;
        this.totalBytes = exception5;
        this.taskState = obj8;
        this.exception = obj7;
    }

    public static com.google.firebase.firestore.LoadBundleTaskProgress forInitial(BundleMetadata bundleMetadata) {
        super(0, bundleMetadata.getTotalDocuments(), 0, obj4, bundleMetadata.getTotalBytes(), obj6, 0, LoadBundleTaskProgress.TaskState.RUNNING);
        return loadBundleTaskProgress;
    }

    public static com.google.firebase.firestore.LoadBundleTaskProgress forSuccess(BundleMetadata bundleMetadata) {
        super(bundleMetadata.getTotalDocuments(), bundleMetadata.getTotalDocuments(), bundleMetadata.getTotalBytes(), obj4, bundleMetadata.getTotalBytes(), obj6, 0, LoadBundleTaskProgress.TaskState.SUCCESS);
        return loadBundleTaskProgress;
    }

    public boolean equals(Object object) {
        int equals;
        Class<com.google.firebase.firestore.LoadBundleTaskProgress> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (LoadBundleTaskProgress.class != object.getClass()) {
            } else {
                if (this.documentsLoaded != object.documentsLoaded) {
                    return i;
                }
                if (this.totalDocuments != object.totalDocuments) {
                    return i;
                }
                if (Long.compare(bytesLoaded, bytesLoaded2) != 0) {
                    return i;
                }
                if (Long.compare(totalBytes, totalBytes2) != 0) {
                    return i;
                }
                if (this.taskState != object.taskState) {
                    return i;
                }
                Exception exception = this.exception;
                final Exception obj7 = object.exception;
                if (exception != null) {
                    equals = exception.equals(obj7);
                } else {
                    if (obj7 == null) {
                    } else {
                        equals = i;
                    }
                }
            }
            return equals;
        }
        return i;
    }

    public long getBytesLoaded() {
        return this.bytesLoaded;
    }

    public int getDocumentsLoaded() {
        return this.documentsLoaded;
    }

    public Exception getException() {
        return this.exception;
    }

    public com.google.firebase.firestore.LoadBundleTaskProgress.TaskState getTaskState() {
        return this.taskState;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public int getTotalDocuments() {
        return this.totalDocuments;
    }

    public int hashCode() {
        int i;
        long bytesLoaded = this.bytesLoaded;
        int i17 = 32;
        long totalBytes = this.totalBytes;
        Exception exception = this.exception;
        if (exception != null) {
            i = exception.hashCode();
        } else {
            i = 0;
        }
        return i10 += i;
    }
}
