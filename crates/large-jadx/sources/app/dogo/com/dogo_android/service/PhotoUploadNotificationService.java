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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\u0018\u0000 -2\u00020\u0001:\u0002-.B%\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J&\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J.\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0016J \u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J0\u0010)\u001a\u00020\u001d2\u0008\u0010*\u001a\u0004\u0018\u00010\u00182\u0008\u0010+\u001a\u0004\u0018\u00010\u001b2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0010,\u001a\u0004\u0018\u00010 H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/service/PhotoUploadNotificationService;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseTaskService;", "fireBaseStorageService", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "firestoreService", "Lapp/dogo/com/dogo_android/service/FirestoreService;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "(Lapp/dogo/com/dogo_android/service/FireBaseStorageService;Lapp/dogo/com/dogo_android/service/FirestoreService;Lapp/dogo/com/dogo_android/service/StorageService;)V", "getFireBaseStorageService", "()Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "setFireBaseStorageService", "(Lapp/dogo/com/dogo_android/service/FireBaseStorageService;)V", "getFirestoreService", "()Lapp/dogo/com/dogo_android/service/FirestoreService;", "setFirestoreService", "(Lapp/dogo/com/dogo_android/service/FirestoreService;)V", "getStorageService", "()Lapp/dogo/com/dogo_android/service/StorageService;", "setStorageService", "(Lapp/dogo/com/dogo_android/service/StorageService;)V", "broadcastUploadFinished", "", "downloadUrl", "Landroid/net/Uri;", "fileUri", "requestId", "", "doOnUploadFinish", "", "reqId", "reqType", "Lapp/dogo/com/dogo_android/service/PhotoUploadNotificationService$RequestTypes;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "uploadFromUri", "localFileUri", "remotePath", "requestType", "Companion", "RequestTypes", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PhotoUploadNotificationService extends q {

    public static final app.dogo.com.dogo_android.service.PhotoUploadNotificationService.a Companion;
    private app.dogo.com.dogo_android.service.l2 b;
    private app.dogo.com.dogo_android.service.t2 c;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/service/PhotoUploadNotificationService$Companion;", "", "()V", "ACTION_UPLOAD", "", "EXTRA_DOWNLOAD_URL", "EXTRA_FILE_URI", "EXTRA_REMOTE_PATH", "EXTRA_REQUEST_ID", "EXTRA_REQUEST_TYPE", "UPLOAD_COMPLETED", "UPLOAD_ERROR", "intentFilter", "Landroid/content/IntentFilter;", "getIntentFilter", "()Landroid/content/IntentFilter;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final IntentFilter a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("upload_completed");
            intentFilter.addAction("upload_error");
            return intentFilter;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0003\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/service/PhotoUploadNotificationService$RequestTypes;", "", "(Ljava/lang/String;I)V", "CHALLENGE", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum b {

        CHALLENGE;
        private static final app.dogo.com.dogo_android.service.PhotoUploadNotificationService.b[] $values() {
            app.dogo.com.dogo_android.service.PhotoUploadNotificationService.b[] arr = new PhotoUploadNotificationService.b[1];
            return arr;
        }
    }
    static {
        PhotoUploadNotificationService.a aVar = new PhotoUploadNotificationService.a(0);
        PhotoUploadNotificationService.Companion = aVar;
    }

    public PhotoUploadNotificationService() {
        super(0, 0, 0, 7, 0);
    }

    public PhotoUploadNotificationService(app.dogo.com.dogo_android.service.l2 l2, app.dogo.com.dogo_android.service.m2 m22, app.dogo.com.dogo_android.service.t2 t23) {
        n.f(l2, "fireBaseStorageService");
        n.f(m22, "firestoreService");
        n.f(t23, "storageService");
        super();
        this.b = l2;
        this.c = t23;
    }

    public PhotoUploadNotificationService(app.dogo.com.dogo_android.service.l2 l2, app.dogo.com.dogo_android.service.m2 m22, app.dogo.com.dogo_android.service.t2 t23, int i4, g g5) {
        app.dogo.com.dogo_android.service.l2 obj1;
        app.dogo.com.dogo_android.service.m2 obj2;
        app.dogo.com.dogo_android.service.t2 obj3;
        if (i4 & 1 != 0) {
            obj1 = App.Companion.i();
        }
        if (i4 & 2 != 0) {
            obj2 = App.Companion.j();
        }
        if (i4 &= 4 != 0) {
            obj3 = App.Companion.p();
        }
        super(obj1, obj2, obj3);
    }

    private final boolean h(Uri uri, Uri uri2, String string3) {
        Intent intent = new Intent("upload_completed");
        Intent obj3 = intent.putExtra("extra_download_url", uri).putExtra("extra_file_uri", uri2).putExtra("extra_request_id", string3);
        n.e(obj3, "Intent(UPLOAD_COMPLETED)\n            .putExtra(EXTRA_DOWNLOAD_URL, downloadUrl)\n            .putExtra(EXTRA_FILE_URI, fileUri)\n            .putExtra(EXTRA_REQUEST_ID, requestId)");
        return a.b(getApplicationContext()).d(obj3);
    }

    private final void i(Uri uri, Uri uri2, String string3, app.dogo.com.dogo_android.service.PhotoUploadNotificationService.b photoUploadNotificationService$b4) {
        app.dogo.com.dogo_android.service.t2 obj1;
        Object obj2;
        String obj3;
        Object obj4;
        c();
        if (b4 == PhotoUploadNotificationService.b.CHALLENGE) {
            obj2 = ".jpg";
            obj4 = "challenge_pending";
            if (uri != null) {
                this.c.m(obj4, "challenge_successful", n.o(string3, obj2));
            } else {
                d();
                this.c.m(obj4, "challenge_failed", n.o(string3, obj2));
            }
        }
    }

    public static void k(app.dogo.com.dogo_android.service.PhotoUploadNotificationService photoUploadNotificationService, UploadTask.TaskSnapshot uploadTask$TaskSnapshot2) {
        PhotoUploadNotificationService.o(photoUploadNotificationService, taskSnapshot2);
    }

    public static j l(app.dogo.com.dogo_android.service.PhotoUploadNotificationService photoUploadNotificationService, String string2, j j3) {
        return PhotoUploadNotificationService.p(photoUploadNotificationService, string2, j3);
    }

    public static void m(app.dogo.com.dogo_android.service.PhotoUploadNotificationService photoUploadNotificationService, Uri uri2, String string3, app.dogo.com.dogo_android.service.PhotoUploadNotificationService.b photoUploadNotificationService$b4, j j5) {
        PhotoUploadNotificationService.q(photoUploadNotificationService, uri2, string3, b4, j5);
    }

    private final void n(Uri uri, String string2, String string3, app.dogo.com.dogo_android.service.PhotoUploadNotificationService.b photoUploadNotificationService$b4) {
        g();
        this.e(getString(2131887637), 0, obj4);
        if (b4 != PhotoUploadNotificationService.b.CHALLENGE) {
        } else {
            n.d(string2);
            l1 l1Var = new l1(this);
            m1 m1Var = new m1(this, string2);
            n1 n1Var = new n1(this, uri, string3, b4);
            this.b.t(uri, string2, l2.b.CHALLENGE_BUCKET).addOnProgressListener(l1Var).continueWithTask(m1Var).addOnCompleteListener(n1Var);
        }
        UnsupportedOperationException obj8 = new UnsupportedOperationException("configure this class for more request types");
        throw obj8;
    }

    private static final void o(app.dogo.com.dogo_android.service.PhotoUploadNotificationService photoUploadNotificationService, UploadTask.TaskSnapshot uploadTask$TaskSnapshot2) {
        n.f(photoUploadNotificationService, "this$0");
        n.f(taskSnapshot2, "snapshot");
        photoUploadNotificationService.e(photoUploadNotificationService.getString(2131887637), taskSnapshot2.getBytesTransferred(), obj4);
    }

    private static final j p(app.dogo.com.dogo_android.service.PhotoUploadNotificationService photoUploadNotificationService, String string2, j j3) {
        n.f(photoUploadNotificationService, "this$0");
        n.f(j3, "task");
        if (!j3.isSuccessful()) {
        } else {
            return photoUploadNotificationService.j().f(string2, l2.b.CHALLENGE_BUCKET);
        }
        Exception obj1 = j3.getException();
        n.d(obj1);
        obj1.printStackTrace();
        obj1 = j3.getException();
        n.d(obj1);
        throw obj1;
    }

    private static final void q(app.dogo.com.dogo_android.service.PhotoUploadNotificationService photoUploadNotificationService, Uri uri2, String string3, app.dogo.com.dogo_android.service.PhotoUploadNotificationService.b photoUploadNotificationService$b4, j j5) {
        Object obj5;
        n.f(photoUploadNotificationService, "this$0");
        n.f(j5, "task");
        if (j5.isSuccessful()) {
            obj5 = j5.getResult();
        } else {
            obj5 = 0;
        }
        photoUploadNotificationService.h(obj5, uri2, string3);
        photoUploadNotificationService.i(obj5, uri2, string3, b4);
        photoUploadNotificationService.f();
    }

    @Override // app.dogo.com.dogo_android.util.e0.q
    public final app.dogo.com.dogo_android.service.l2 j() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.e0.q
    public IBinder onBind(Intent intent) {
        n.f(intent, "intent");
        return null;
    }

    @Override // app.dogo.com.dogo_android.util.e0.q
    public int onStartCommand(Intent intent, int i2, int i3) {
        String stringExtra;
        String str;
        Object obj3;
        boolean obj4;
        String obj5;
        n.f(intent, "intent");
        if (n.b("action_upload", intent.getAction())) {
            n((Uri)intent.getParcelableExtra("extra_file_uri"), intent.getStringExtra("extra_remote_path"), intent.getStringExtra("extra_request_id"), (PhotoUploadNotificationService.b)intent.getSerializableExtra("extra_request_type"));
        }
        return 3;
    }
}
