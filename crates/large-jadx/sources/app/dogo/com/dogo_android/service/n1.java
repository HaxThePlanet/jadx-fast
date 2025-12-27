package app.dogo.com.dogo_android.service;

import android.net.Uri;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class n1 implements e {

    public final /* synthetic */ PhotoUploadNotificationService a;
    public final /* synthetic */ Uri b;
    public final /* synthetic */ String c;
    public final /* synthetic */ PhotoUploadNotificationService.b d;
    public /* synthetic */ n1(PhotoUploadNotificationService photoUploadNotificationService, Uri uri, String str, PhotoUploadNotificationService.b bVar) {
        super();
        this.a = photoUploadNotificationService;
        this.b = uri;
        this.c = str;
        this.d = bVar;
    }

    public final void onComplete(j jVar) {
        PhotoUploadNotificationService.q(this.a, this.b, this.c, this.d, jVar);
    }
}
