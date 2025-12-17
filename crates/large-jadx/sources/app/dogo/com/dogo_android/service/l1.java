package app.dogo.com.dogo_android.service;

import com.google.firebase.storage.OnProgressListener;

/* loaded from: classes.dex */
public final class l1 implements OnProgressListener {

    public final app.dogo.com.dogo_android.service.PhotoUploadNotificationService a;
    public l1(app.dogo.com.dogo_android.service.PhotoUploadNotificationService photoUploadNotificationService) {
        super();
        this.a = photoUploadNotificationService;
    }

    @Override // com.google.firebase.storage.OnProgressListener
    public final void onProgress(Object object) {
        PhotoUploadNotificationService.k(this.a, (UploadTask.TaskSnapshot)object);
    }
}
