package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class m1 implements c {

    public final /* synthetic */ PhotoUploadNotificationService a;
    public final /* synthetic */ String b;
    public /* synthetic */ m1(PhotoUploadNotificationService photoUploadNotificationService, String str) {
        super();
        this.a = photoUploadNotificationService;
        this.b = str;
    }

    public final Object then(j jVar) {
        return PhotoUploadNotificationService.p(this.a, this.b, jVar);
    }
}
