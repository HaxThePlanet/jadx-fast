package com.google.firebase.storage;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.Slashes;
import com.google.firebase.storage.internal.StorageReferenceUri;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class StorageReference implements Comparable<com.google.firebase.storage.StorageReference> {

    static final boolean $assertionsDisabled = false;
    private static final String TAG = "StorageReference";
    private final com.google.firebase.storage.FirebaseStorage mFirebaseStorage;
    private final Uri mStorageUri;
    static {
        final Class<com.google.firebase.storage.StorageReference> obj = StorageReference.class;
    }

    StorageReference(Uri uri, com.google.firebase.storage.FirebaseStorage firebaseStorage2) {
        int i;
        int i2;
        super();
        int i3 = 0;
        i2 = uri != null ? i : i3;
        r.b(i2, "storageUri cannot be null");
        if (firebaseStorage2 != null) {
        } else {
            i = i3;
        }
        r.b(i, "FirebaseApp cannot be null");
        this.mStorageUri = uri;
        this.mFirebaseStorage = firebaseStorage2;
    }

    static j access$000(com.google.firebase.storage.StorageReference storageReference, Integer integer2, String string3) {
        return storageReference.listHelper(integer2, string3);
    }

    private j<com.google.firebase.storage.ListResult> listHelper(Integer integer, String string2) {
        k kVar = new k();
        ListTask listTask = new ListTask(this, integer, string2, kVar);
        StorageTaskScheduler.getInstance().scheduleCommand(listTask);
        return kVar.a();
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.StorageReference child(String string) {
        r.b(empty ^= 1, "childName cannot be null or empty");
        StorageReference storageReference = new StorageReference(this.mStorageUri.buildUpon().appendEncodedPath(Slashes.preserveSlashEncode(Slashes.normalizeSlashes(string))).build(), this.mFirebaseStorage);
        return storageReference;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.firebase.storage.StorageReference storageReference) {
        return this.mStorageUri.compareTo(storageReference.mStorageUri);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return compareTo((StorageReference)object);
    }

    public j<Void> delete() {
        k kVar = new k();
        DeleteStorageTask deleteStorageTask = new DeleteStorageTask(this, kVar);
        StorageTaskScheduler.getInstance().scheduleCommand(deleteStorageTask);
        return kVar.a();
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        if (object instanceof StorageReference == null) {
            return 0;
        }
        return (StorageReference)object.toString().equals(toString());
    }

    public List<com.google.firebase.storage.FileDownloadTask> getActiveDownloadTasks() {
        return StorageTaskManager.getInstance().getDownloadTasksUnder(this);
    }

    public List<com.google.firebase.storage.UploadTask> getActiveUploadTasks() {
        return StorageTaskManager.getInstance().getUploadTasksUnder(this);
    }

    @Override // java.lang.Comparable
    FirebaseApp getApp() {
        return getStorage().getApp();
    }

    @Override // java.lang.Comparable
    public String getBucket() {
        return this.mStorageUri.getAuthority();
    }

    public j<byte[]> getBytes(long l) {
        k kVar = new k();
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        StorageReference.3 anon = new StorageReference.3(this, l, obj5, kVar);
        StorageReference.2 obj5 = new StorageReference.2(this, kVar);
        obj5 = new StorageReference.1(this, kVar);
        streamDownloadTask.setStreamProcessor(anon).addOnSuccessListener(obj5).addOnFailureListener(obj5);
        streamDownloadTask.queue();
        return kVar.a();
    }

    public j<Uri> getDownloadUrl() {
        k kVar = new k();
        GetDownloadUrlTask getDownloadUrlTask = new GetDownloadUrlTask(this, kVar);
        StorageTaskScheduler.getInstance().scheduleCommand(getDownloadUrlTask);
        return kVar.a();
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.FileDownloadTask getFile(Uri uri) {
        FileDownloadTask fileDownloadTask = new FileDownloadTask(this, uri);
        fileDownloadTask.queue();
        return fileDownloadTask;
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.FileDownloadTask getFile(File file) {
        return getFile(Uri.fromFile(file));
    }

    public j<com.google.firebase.storage.StorageMetadata> getMetadata() {
        k kVar = new k();
        GetMetadataTask getMetadataTask = new GetMetadataTask(this, kVar);
        StorageTaskScheduler.getInstance().scheduleCommand(getMetadataTask);
        return kVar.a();
    }

    @Override // java.lang.Comparable
    public String getName() {
        String substring;
        int lastIndexOf;
        substring = this.mStorageUri.getPath();
        lastIndexOf = substring.lastIndexOf(47);
        if (lastIndexOf != -1) {
            substring = substring.substring(lastIndexOf++);
        }
        return substring;
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.StorageReference getParent() {
        boolean substring;
        boolean equals;
        String path = this.mStorageUri.getPath();
        if (!TextUtils.isEmpty(path)) {
            if (path.equals("/")) {
            } else {
                int lastIndexOf = path.lastIndexOf(47);
                if (lastIndexOf == -1) {
                } else {
                    substring = path.substring(0, lastIndexOf);
                }
            }
            StorageReference storageReference = new StorageReference(this.mStorageUri.buildUpon().path(substring).build(), this.mFirebaseStorage);
            return storageReference;
        }
        return null;
    }

    @Override // java.lang.Comparable
    public String getPath() {
        return this.mStorageUri.getPath();
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.StorageReference getRoot() {
        StorageReference storageReference = new StorageReference(this.mStorageUri.buildUpon().path("").build(), this.mFirebaseStorage);
        return storageReference;
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.FirebaseStorage getStorage() {
        return this.mFirebaseStorage;
    }

    @Override // java.lang.Comparable
    StorageReferenceUri getStorageReferenceUri() {
        StorageReferenceUri storageReferenceUri = new StorageReferenceUri(this.mStorageUri, this.mFirebaseStorage.getEmulatorSettings());
        return storageReferenceUri;
    }

    @Override // java.lang.Comparable
    Uri getStorageUri() {
        return this.mStorageUri;
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.StreamDownloadTask getStream() {
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.queue();
        return streamDownloadTask;
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.StreamDownloadTask getStream(com.google.firebase.storage.StreamDownloadTask.StreamProcessor streamDownloadTask$StreamProcessor) {
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.setStreamProcessor(streamProcessor);
        streamDownloadTask.queue();
        return streamDownloadTask;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return toString().hashCode();
    }

    public j<com.google.firebase.storage.ListResult> list(int i) {
        int i2;
        int i3;
        int i5 = 0;
        i3 = i > 0 ? i2 : i5;
        r.b(i3, "maxResults must be greater than zero");
        if (i <= 1000) {
        } else {
            i2 = i5;
        }
        r.b(i2, "maxResults must be at most 1000");
        return listHelper(Integer.valueOf(i), 0);
    }

    public j<com.google.firebase.storage.ListResult> list(int i, String string2) {
        int i3;
        int i2;
        int i4;
        i3 = 1;
        int i5 = 0;
        i2 = i > 0 ? i3 : i5;
        r.b(i2, "maxResults must be greater than zero");
        i4 = i <= 1000 ? i3 : i5;
        r.b(i4, "maxResults must be at most 1000");
        if (string2 != null) {
        } else {
            i3 = i5;
        }
        r.b(i3, "pageToken must be non-null to resume a previous list() operation");
        return listHelper(Integer.valueOf(i), string2);
    }

    public j<com.google.firebase.storage.ListResult> listAll() {
        k kVar2 = new k();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final Executor commandPoolExecutor = StorageTaskScheduler.getInstance().getCommandPoolExecutor();
        int i = 0;
        super(this, arrayList, arrayList2, commandPoolExecutor, kVar2);
        listHelper(i, i).continueWithTask(commandPoolExecutor, anon2);
        return kVar2.a();
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.UploadTask putBytes(byte[] bArr) {
        int i;
        i = bArr != null ? 1 : 0;
        r.b(i, "bytes cannot be null");
        UploadTask uploadTask = new UploadTask(this, 0, bArr);
        uploadTask.queue();
        return uploadTask;
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.UploadTask putBytes(byte[] bArr, com.google.firebase.storage.StorageMetadata storageMetadata2) {
        int i;
        int i2;
        int i3 = 0;
        i2 = bArr != null ? i : i3;
        r.b(i2, "bytes cannot be null");
        if (storageMetadata2 != null) {
        } else {
            i = i3;
        }
        r.b(i, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata2, bArr);
        uploadTask.queue();
        return uploadTask;
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.UploadTask putFile(Uri uri) {
        int i;
        i = uri != null ? 1 : 0;
        r.b(i, "uri cannot be null");
        int i2 = 0;
        UploadTask uploadTask = new UploadTask(this, i2, uri, i2);
        uploadTask.queue();
        return uploadTask;
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.UploadTask putFile(Uri uri, com.google.firebase.storage.StorageMetadata storageMetadata2) {
        int i;
        int i2;
        int i3 = 0;
        i2 = uri != null ? i : i3;
        r.b(i2, "uri cannot be null");
        if (storageMetadata2 != null) {
        } else {
            i = i3;
        }
        r.b(i, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata2, uri, 0);
        uploadTask.queue();
        return uploadTask;
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.UploadTask putFile(Uri uri, com.google.firebase.storage.StorageMetadata storageMetadata2, Uri uri3) {
        int i;
        int i2;
        int i3 = 0;
        i2 = uri != null ? i : i3;
        r.b(i2, "uri cannot be null");
        if (storageMetadata2 != null) {
        } else {
            i = i3;
        }
        r.b(i, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata2, uri, uri3);
        uploadTask.queue();
        return uploadTask;
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.UploadTask putStream(InputStream inputStream) {
        int i;
        i = inputStream != null ? 1 : 0;
        r.b(i, "stream cannot be null");
        UploadTask uploadTask = new UploadTask(this, 0, inputStream);
        uploadTask.queue();
        return uploadTask;
    }

    @Override // java.lang.Comparable
    public com.google.firebase.storage.UploadTask putStream(InputStream inputStream, com.google.firebase.storage.StorageMetadata storageMetadata2) {
        int i2;
        int i;
        int i3 = 0;
        i = inputStream != null ? i2 : i3;
        r.b(i, "stream cannot be null");
        if (storageMetadata2 != null) {
        } else {
            i2 = i3;
        }
        r.b(i2, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata2, inputStream);
        uploadTask.queue();
        return uploadTask;
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gs://");
        stringBuilder.append(this.mStorageUri.getAuthority());
        stringBuilder.append(this.mStorageUri.getEncodedPath());
        return stringBuilder.toString();
    }

    public j<com.google.firebase.storage.StorageMetadata> updateMetadata(com.google.firebase.storage.StorageMetadata storageMetadata) {
        r.j(storageMetadata);
        k kVar = new k();
        UpdateMetadataTask updateMetadataTask = new UpdateMetadataTask(this, kVar, storageMetadata);
        StorageTaskScheduler.getInstance().scheduleCommand(updateMetadataTask);
        return kVar.a();
    }
}
