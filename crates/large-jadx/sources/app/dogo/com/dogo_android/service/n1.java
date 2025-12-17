package app.dogo.com.dogo_android.service;

import android.net.Uri;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class n1 implements e {

    public final app.dogo.com.dogo_android.service.PhotoUploadNotificationService a;
    public final Uri b;
    public final String c;
    public final app.dogo.com.dogo_android.service.PhotoUploadNotificationService.b d;
    public n1(app.dogo.com.dogo_android.service.PhotoUploadNotificationService photoUploadNotificationService, Uri uri2, String string3, app.dogo.com.dogo_android.service.PhotoUploadNotificationService.b photoUploadNotificationService$b4) {
        super();
        this.a = photoUploadNotificationService;
        this.b = uri2;
        this.c = string3;
        this.d = b4;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        PhotoUploadNotificationService.m(this.a, this.b, this.c, this.d, j);
    }
}
