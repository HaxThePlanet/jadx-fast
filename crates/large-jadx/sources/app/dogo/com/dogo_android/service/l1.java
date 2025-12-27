package app.dogo.com.dogo_android.service;

import com.google.firebase.storage.OnProgressListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class l1 implements OnProgressListener {

    public final /* synthetic */ PhotoUploadNotificationService a;
    public /* synthetic */ l1(PhotoUploadNotificationService photoUploadNotificationService) {
        super();
        this.a = photoUploadNotificationService;
    }

    public final void onProgress(Object object) {
        PhotoUploadNotificationService.o(this.a, object);
    }
}
