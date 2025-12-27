package app.dogo.com.dogo_android.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.IBinder;
import app.dogo.com.dogo_android.util.e0.q;
import com.google.android.gms.tasks.j;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask.TaskSnapshot;
import d.q.a.a;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: PhotoUploadNotificationService.kt */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\u0018\u0000 -2\u00020\u0001:\u0002-.B%\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J&\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J.\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0016J \u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J0\u0010)\u001a\u00020\u001d2\u0008\u0010*\u001a\u0004\u0018\u00010\u00182\u0008\u0010+\u001a\u0004\u0018\u00010\u001b2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0010,\u001a\u0004\u0018\u00010 H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/service/PhotoUploadNotificationService;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseTaskService;", "fireBaseStorageService", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "(Lapp/dogo/com/dogo_android/service/FireBaseStorageService;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/StorageService;)V", "getFireBaseStorageService", "()Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "setFireBaseStorageService", "(Lapp/dogo/com/dogo_android/service/FireBaseStorageService;)V", "getFirestoreService", "()Lapp/dogo/com/dogo_android/service/FirestoreService;", "setFirestoreService", "(Lapp/dogo/com/dogo_android/service/FirestoreService;)V", "getStorageService", "()Lapp/dogo/com/dogo_android/service/StorageService;", "setStorageService", "(Lapp/dogo/com/dogo_android/service/StorageService;)V", "broadcastUploadFinished", "", "downloadUrl", "Landroid/net/Uri;", "fileUri", "requestId", "", "doOnUploadFinish", "", "reqId", "reqType", "Lapp/dogo/com/dogo_android/service/PhotoUploadNotificationService$RequestTypes;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "uploadFromUri", "localFileUri", "remotePath", "requestType", "Companion", "RequestTypes", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class PhotoUploadNotificationService extends q {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final PhotoUploadNotificationService.a INSTANCE = new PhotoUploadNotificationService$a(0);
    private l2 b;
    private t2 c;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/service/PhotoUploadNotificationService$Companion;", "", "()V", "ACTION_UPLOAD", "", "EXTRA_DOWNLOAD_URL", "EXTRA_FILE_URI", "EXTRA_REMOTE_PATH", "EXTRA_REQUEST_ID", "EXTRA_REQUEST_TYPE", "UPLOAD_COMPLETED", "UPLOAD_ERROR", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public final IntentFilter a() throws android.content.IntentFilter.MalformedMimeTypeException {
            final IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("upload_completed");
            intentFilter.addAction("upload_error");
            return intentFilter;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0003\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/service/PhotoUploadNotificationService$RequestTypes;", "", "(Ljava/lang/String;I)V", "CHALLENGE", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum b {

        CHALLENGE;
        private static final /* synthetic */ PhotoUploadNotificationService.b[] $values() {
            app.dogo.com.dogo_android.service.PhotoUploadNotificationService.b[] arr = new PhotoUploadNotificationService.b[1];
            return new PhotoUploadNotificationService.b[] { PhotoUploadNotificationService_RequestTypes.CHALLENGE };
        }
    }
    public PhotoUploadNotificationService(l2 l2Var, m2 m2Var, t2 t2Var) {
        n.f(l2Var, "fireBaseStorageService");
        n.f(m2Var, "firestoreService");
        n.f(t2Var, "storageService");
        super();
        this.b = l2Var;
        this.c = t2Var;
    }

    /* renamed from: h, reason: from kotlin metadata */
    private final boolean broadcastUploadFinished(Uri downloadUrl, Uri fileUri, String requestId) {
        Intent extra3 = new Intent("upload_completed").putExtra("extra_download_url", downloadUrl).putExtra("extra_file_uri", fileUri).putExtra("extra_request_id", requestId);
        n.e(extra3, "Intent(UPLOAD_COMPLETED)\n            .putExtra(EXTRA_DOWNLOAD_URL, downloadUrl)\n            .putExtra(EXTRA_FILE_URI, fileUri)\n            .putExtra(EXTRA_REQUEST_ID, requestId)");
        return a.b(getApplicationContext()).d(extra3);
    }

    /* renamed from: i, reason: from kotlin metadata */
    private final void doOnUploadFinish(Uri downloadUrl, Uri fileUri, String reqId, PhotoUploadNotificationService.b reqType) {
        c();
        if (reqType == PhotoUploadNotificationService_RequestTypes.CHALLENGE && downloadUrl != null) {
            str = "challenge_successful";
            this.c.m(str2, str, n.o(reqId, ".jpg"));
        }
    }

    /* renamed from: n, reason: from kotlin metadata */
    private final void uploadFromUri(Uri localFileUri, String remotePath, String requestId, PhotoUploadNotificationService.b requestType) {
        g();
        this.e(getString(2131887637), 0L, 0L);
        if (requestType != PhotoUploadNotificationService_RequestTypes.CHALLENGE) {
            throw new UnsupportedOperationException("configure this class for more request types");
        } else {
            n.d(remotePath);
            this.b.t(localFileUri, remotePath, FireBaseStorageService_StorageBucket.CHALLENGE_BUCKET).addOnProgressListener(new l1(this)).continueWithTask(new m1(this, remotePath)).addOnCompleteListener(new n1(this, localFileUri, requestId, requestType));
            return;
        }
    }

    private static final void o(PhotoUploadNotificationService photoUploadNotificationService, UploadTask.TaskSnapshot taskSnapshot) {
        n.f(photoUploadNotificationService, "this$0");
        n.f(taskSnapshot, "snapshot");
        photoUploadNotificationService.e(photoUploadNotificationService.getString(2131887637), taskSnapshot.getBytesTransferred(), taskSnapshot.getTotalByteCount());
    }

    private static final j p(PhotoUploadNotificationService photoUploadNotificationService, String str, j jVar) {
        n.f(photoUploadNotificationService, "this$0");
        n.f(jVar, "task");
        if (!jVar.isSuccessful()) {
            Exception exception = jVar.getException();
            n.d(exception);
            exception.printStackTrace();
            Exception exception2 = jVar.getException();
            n.d(exception2);
            throw exception2;
        } else {
            return photoUploadNotificationService.j().f(str, FireBaseStorageService_StorageBucket.CHALLENGE_BUCKET);
        }
    }

    private static final void q(PhotoUploadNotificationService photoUploadNotificationService, Uri uri, String str, PhotoUploadNotificationService.b bVar, j jVar) {
        n.f(photoUploadNotificationService, "this$0");
        n.f(jVar, "task");
        Object result = jVar.isSuccessful() ? (Uri)result : 0;
        photoUploadNotificationService.broadcastUploadFinished(uri, uri, str);
        photoUploadNotificationService.doOnUploadFinish(uri, uri, str, bVar);
        photoUploadNotificationService.f();
    }

    @Override // app.dogo.com.dogo_android.util.e0.q
    public final l2 j() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.e0.q
    public int onStartCommand(Intent intent, int i, int i2) {
        n.f(intent, "intent");
        stringExtra2 = "action_upload";
        if (n.b(stringExtra2, intent.getAction())) {
            str = "extra_request_type";
            uploadFromUri((Uri)intent.getParcelableExtra("extra_file_uri"), intent.getStringExtra("extra_remote_path"), intent.getStringExtra("extra_request_id"), (PhotoUploadNotificationService_RequestTypes)intent.getSerializableExtra(str));
        }
        return 3;
    }

    public /* synthetic */ PhotoUploadNotificationService(l2 l2Var, m2 m2Var, t2 t2Var, int i, g gVar) {
        app.dogo.com.dogo_android.service.l2 l2Var2;
        if (i & 1 != 0) {
            l2Var2 = App.Companion.i();
        }
        if (i & 2 != 0) {
            m2Var = App.Companion.j();
        }
        if (i & 4 != 0) {
            t2Var = App.Companion.p();
        }
        this(l2Var2, m2Var, t2Var);
    }


    public PhotoUploadNotificationService() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ void k(PhotoUploadNotificationService photoUploadNotificationService, UploadTask.TaskSnapshot taskSnapshot) {
        PhotoUploadNotificationService.o(photoUploadNotificationService, taskSnapshot);
    }

    /* renamed from: l, reason: from kotlin metadata */
    public static /* synthetic */ j onStartCommand(PhotoUploadNotificationService intent, String flags, j startId) {
        return PhotoUploadNotificationService.p(intent, flags, startId);
    }

    public static /* synthetic */ void m(PhotoUploadNotificationService photoUploadNotificationService, Uri uri, String str, PhotoUploadNotificationService.b bVar, j jVar) {
        PhotoUploadNotificationService.q(photoUploadNotificationService, uri, str, bVar, jVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.q
    public IBinder onBind(Intent intent) {
        n.f(intent, "intent");
        return null;
    }
}
